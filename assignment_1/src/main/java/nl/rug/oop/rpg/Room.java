package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.util.Objects;
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
		Scanner scanner = new Scanner(System.in);
		doors.get(doorNR).interact(player);
		if (!doors.get(doorNR).isDoorOpen()) {
			System.out.println("\n");
			System.out.println("\t Attack the door? (1-YES / 0-NO)");
			int selected = scanner.nextInt();
			if (selected == 1) {
				player.attack((AttackDoor) doors.get(doorNR));
				((AttackDoor) doors.get(doorNR)).attack(player);
			} else {
				System.out.println("You can't go through this door without attacking it!");
			}
		}

	}

	public void NPCInteract(int NPCNumber, Player player) {
		Scanner scanner = new Scanner(System.in);
		NPCs.get(NPCNumber).interact(player);
		if (NPCs.get(NPCNumber).getLifeState()) {
			System.out.println("\n");
			System.out.println("\t Attack " + NPCs.get(NPCNumber).name + "? (1-YES / 0-NO)");
			int selected = scanner.nextInt();
			if (NPCs.get(NPCNumber) instanceof Enemy) {
				if (selected == 1) {
					player.attack((Enemy) NPCs.get(NPCNumber));
					((Enemy) NPCs.get(NPCNumber)).attack(player);
					attackContinue(player, NPCNumber);
				} else {
					System.out.println("You can't continue your journey safe! You have to fight for your honour!");
					attackContinue(player, NPCNumber);
				}
			} else {
				if (selected == 1) {
					System.out.println(NPCs.get(NPCNumber).name + ": I'm here to help you! Why would you attack me ?!!");
				}
			}
		}
	}

	public void attackContinue (Player player, int NPCNumber) {
		Scanner scanner = new Scanner(System.in);
		while (NPCs.get(NPCNumber).getHealth() > 0) {
			System.out.println("\t Press 1 to continue attacking !");
			int inputKey = scanner.nextInt();
			player.attack((Enemy) NPCs.get(NPCNumber));
			if (NPCs.get(NPCNumber).getLifeState())
				((Enemy) NPCs.get(NPCNumber)).attack(player);
			//System.out.println("MORT NAHUI");
		}
	}
}
