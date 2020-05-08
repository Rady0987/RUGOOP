package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class FileSaving implements Serializable{
	private String name;
	private Game game;
	private static final long serialVersionUID = 42L;
	/* This field will not be serialized */
	private transient Scanner scanner;

	public FileSaving(String name, Game game){
		this.name = name;
		this.game = game;
		File saveDirectory = new File(name);
		saveDirectory.mkdir();
	}

	public void save() throws FileNotFoundException{
		String location = name + "\\quicksave.ser";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(location)));
    		out.writeObject(game);
    		out.close(); 
		} catch (IOException e) {
    		e.printStackTrace();
		}
	}

	public void load() throws ClassNotFoundException{
		String location = name + "\\quicksave.ser";
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(location)));
			game = (Game) in.readObject(); 
			in.close();
		} catch (IOException e) {
    		e.printStackTrace();
		}
	}
}