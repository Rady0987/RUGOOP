package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.util.Scanner;

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
			System.out.print("\t (" + step + ")");
			door.inspect();
			step++;
		}
	}

	public void inspectNPCs() {
		int step = 0;
		for(NPC npc : NPCs) {
			System.out.print("\t (" + step + ")");
			npc.inspect();
			step++;
		}
	}

	public void doorInteract(int doorNR, Player player) {
		doors.get(doorNR).interact(player);
	}

	public void NPCInteract(int NPCNumber, Player player) {
		Scanner scanner = new Scanner(System.in);
		NPCs.get(NPCNumber).interact(player);
		System.out.println("\n");
		System.out.println("\t Attack " + NPCs.get(NPCNumber).name + "? (1-YES / 0-NO)");
		int selected = scanner.nextInt();
		if (NPCs.get(NPCNumber) instanceof Enemy) {
			if (selected == 1) {
				//while (NPCs.get(NPCNumber).health != 0)
					//player.attack(NPCs.get(NPCNumber));
				 NPCs.get(NPCNumber).attack(player);
			} else {
				System.out.println("You can't continue your journey safe! You have to fight for your honour!");
				player.attack(NPCs.get(NPCNumber));
				//((Enemy) NPCs.get(NPCNumber)).attack(player);
			}
		} else {
			if (selected == 1) {
				System.out.println(NPCs.get(NPCNumber).name + ": I'm here to help you! Why would you attack me ?!!");
			}
		}
	}
}
