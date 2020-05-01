package nl.rug.oop.rpg;
import java.util.ArrayList;
/**
 * A room class
 */
public class Room implements Inspectable {
	private String description;
	private ArrayList<Door> doors;
	private ArrayList<NPC> NPCs;

	/**
	 * Constructor, also contains the lists with doors and NPCs
	 *
	 * @param description Short description of the room
	 */

	public Room(String description) {
		this.description = description;
		doors = new ArrayList<>();
		NPCs = new ArrayList<>();
	}

	public void inspect() {
		System.out.println(description);
	}

	public void addDoor(Door door) {
		doors.add(door);
	}

	public void addNPC(NPC npc) {
		NPCs.add(npc);
	}

	public void inspectDoors() {
		int step = 0; 
		for(Door door : doors) {
			System.out.print("(" + step + ")");
			door.inspect();
			step++;
		}
	}

	public void inspectNPCs() {
		int step = 0;
		for(NPC npc : NPCs) {
			System.out.print("(" + step + ")");
			npc.inspect();
			step++;
		}
	}

	public void doorInteract(int doorNR, Player player) {
		doors.get(doorNR).interact(player);
	}

}
