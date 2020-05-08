package nl.rug.oop.rpg;
import nl.rug.oop.rpg.game.Game;

import java.io.*;
import java.util.Scanner;

public class FileSaving implements Serializable{
	private String nameFolder;
	private Game game;
	private File saveDirectory;
	private static final long serialVersionUID = 42L;
	/* This field will not be serialized */
	private transient Scanner scanner;

	public FileSaving(String nameFolder, Game game){
		this.nameFolder = nameFolder;
		this.game = game;
		saveDirectory = new File(nameFolder);
		saveDirectory.mkdir();
	}

	public void save(String name) throws FileNotFoundException{
		String location = nameFolder + "/"+ name + ".ser";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(location)));
    		out.writeObject(game);
    		out.close(); 
    		if(name == "quicksave"){
    			System.out.println("Quicksave succesful");
    		}else{
    			System.out.println("Save succesful");
    		}
		} catch (IOException e) {
    		e.printStackTrace();
		}
	}

	public void save() throws FileNotFoundException{
		save("quicksave");
	}

	public void load(String name) throws ClassNotFoundException{
		String location = nameFolder + "/"+  name;
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(location)));
			game = (Game) in.readObject(); 
			in.close();
			if(name == "quicksave.ser"){
    			System.out.println("Quickload succesful");
    		}else{
    			System.out.println("Load succesful");
    		}
		} catch (IOException e) {
    		e.printStackTrace();
		}
	}

	public void load(int number) throws ClassNotFoundException{
		File[] files = saveDirectory.listFiles();
		int counter = 0;
        for (File file : files){
        	if(counter == number)
            	load(file.getName());
            counter++;
        }
        if(counter < number){
        	System.out.println("There is not such a file");
        }
	}

	public void load()throws ClassNotFoundException{
		load("quicksave.ser");
	}

	public void printFiles(){
		File[] files = saveDirectory.listFiles();
		int counter = 0;
        for (File file : files){
        	System.out.print("("+counter+") ");
            System.out.println(file.getName());
            counter++;
        }
	}


}