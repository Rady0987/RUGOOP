package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.util.List;


/*
**Models a room with a description
*/
public class Room implements Inspectable {
	private String description;
	private ArrayList<Door> doors;

	public Room(String description) {
		this.description = description;
		doors = new ArrayList<>();
	}

	public void inspect(){
		System.out.println(description);
	}

	public void addDoor(Door door){
		doors.add(door);
	}

	public void inspectDoors(){
		int step = 0; 
		for(Door door : doors){
			System.out.print("(" + step + ")");
			door.inspect();
			step++;
		}
	}
	
}