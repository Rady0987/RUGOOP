package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class FileSaving implements Serializable{
	private String name;
	private static final long serialVersionUID = 42L;
	/* This field will not be serialized */
	private transient Scanner scanner;

	public FileSaving(String name){
		this.name = name;
		File saveDirectory = new File(name);
		saveDirectory.mkdir();
	}

	public void save(){
		String location = name + "\\quicksave.ser";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(location)));
		try {
    		out.writeObject(game);
		} catch (IOException e) {
    		e.printStackTrace();
		}
		out.close(); 
	}

	public void load() throws ClassNotFoundException{
		String location = name + "\\quicksave.ser";
		ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(new File(location)));
		try{
		Game game = (Game) in.readObject(); 
		} catch (IOException e) {
    		e.printStackTrace();
		}
		in.close();
	}
}