package nl.rug.oop.rpg.game;
import nl.rug.oop.rpg.utility.Inspectable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/**
 * A room class.
 */

public class Room implements Inspectable, Serializable{
	private String description;
	private ArrayList<Door> doors;
	private ArrayList<NPC> NPCs;
	private static final long serialVersionUID = 42L;
	/* This field will not be serialized */
	private transient Scanner scanner;

	/**
	 * Constructor, also contains the lists with doors and NPCs.
	 *
	 * @param description Short description of the room.
	 */

	public Room(String description) {
		this.description = description;
		doors = new ArrayList<>();
		NPCs = new ArrayList<>();
	}

	/**
	 * Method that prints the description of the game.
	 */
	public void inspect() {
		System.out.println(description);
	}

	/**
	 * Method that add a door to a room and checks if is not null.
	 * @param door A door instance with all it's parameters.
	 */
	public void addDoor(Door door) {
		if (door == null) {
			return;
		}
		doors.add(door);
	}

	/**
	 * Method that add a NPC to a room.
	 * @param npc A NPC instance with all it's parameters.
	 */
	public void addNPC(NPC npc) {
		NPCs.add(npc);
	}

	/**
	 * Method that prints all the doors in a room.
	 */
	public void inspectDoors() {
		int step = 0; 
		for(Door door : doors) {
			System.out.print("\t (" + step + ")");
			door.inspect();
			step++;
		}
	}

	/**
	 * Method that prints all the NPCs in a room.
	 */
	public void inspectNPCs() {
		int step = 0;
		for(NPC npc : NPCs) {
			System.out.print("\t (" + step + ")");
			npc.inspect();
			step++;
		}
	}

	/**
	 * Method that allows the player to interact with a door.
	 * @param doorNR The index of the door in the ArrayList.
	 * @param player The name of the player.
	 */
	public void doorInteract(int doorNR, Player player) {
		Scanner scanner = new Scanner(System.in);
		doors.get(doorNR).interact(player);
		if (doors.get(doorNR) instanceof ArmorDoor)
			((ArmorDoor) doors.get(doorNR)).addArmor(player);
		if (!doors.get(doorNR).isDoorOpen()) {
			System.out.println("\n");
			System.out.println("\t Attack the door? (1-YES / 0-NO)");
			int selected = scanner.nextInt();
			if (selected == 1) {
				player.attack((AttackDoor) doors.get(doorNR));
				((AttackDoor) doors.get(doorNR)).attack(player);
				attackContinueDoor(player, doorNR);
			} else {
				System.out.println("You can't go through this door without attacking it!");
			}
		}
	}

	/**
	 * Method that allows the player to interact with a NPC.
	 * @param NPCNumber The index of the NPC in the ArrayList.
	 * @param player The name of the player.
	 */
	public void NPCInteract(int NPCNumber, Player player) {
		Scanner scanner = new Scanner(System.in);
		NPCs.get(NPCNumber).interact(player);
		NPCSpecialAbilitiesInteract(NPCNumber, player);
		if(NPCs.get(NPCNumber).getLifeState()) {
			System.out.println("\n");
			System.out.println("\t Attack " + NPCs.get(NPCNumber).name + "? (1-YES / 0-NO)");
			int selected = scanner.nextInt();
			if(NPCs.get(NPCNumber) instanceof Enemy) {
				if(selected == 1) {
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

	/**
	 * Method that allows the player to attack a NPC after interacting with it.
	 * @param NPCNumber The index of the NPC in the ArrayList.
	 * @param player The name of the player.
	 */
	public void attackContinue (Player player, int NPCNumber) {
		Scanner scanner = new Scanner(System.in);
		while (NPCs.get(NPCNumber).getHealth() > 0) {
			System.out.println("\t Press 1 to continue attacking !");
			int inputKey = scanner.nextInt();
			player.attack((Enemy) NPCs.get(NPCNumber));
			if (NPCs.get(NPCNumber).getLifeState())
				((Enemy) NPCs.get(NPCNumber)).attack(player);
		}
	}

	/**
	 * Method that allows the player to attack a door after interacting with it.
	 * @param doorNR The index of the NPC in the ArrayList.
	 * @param player The name of the player.
	 */
	public void attackContinueDoor(Player player, int doorNR) {
		Scanner scanner = new Scanner(System.in);
		while (doors.get(doorNR).getStrength() > 0) {
			System.out.println("\t Press 1 to continue attacking !");
			int inputKey = scanner.nextInt();
			player.attack((AttackDoor) doors.get(doorNR));
			if (!doors.get(doorNR).isDoorOpen())
				((AttackDoor) doors.get(doorNR)).attack(player);
		}
		doorInteract(doorNR, player);
	}

	/**
	 * Method that allows the player to interact with NPCs that have special power-ups.
	 * @param NPCNumber The index of the NPC in the ArrayList.
	 * @param player The name of the player.
	 */
	public void NPCSpecialAbilitiesInteract(int NPCNumber, Player player) {
		if (!NPCs.get(NPCNumber).interactState) {
			if (NPCs.get(NPCNumber) instanceof Paladin)
				((Paladin) NPCs.get(NPCNumber)).heal(player);
			if (NPCs.get(NPCNumber) instanceof Craftsman)
				((Craftsman) NPCs.get(NPCNumber)).inspectItems(player);
			if (NPCs.get(NPCNumber) instanceof Witch)
				((Witch) NPCs.get(NPCNumber)).damageUpgrade(player);
		} else {
			System.out.println(NPCs.get(NPCNumber).name + " (" + NPCs.get(NPCNumber).description + "):" + " Hey, how are you doing ?");
		}
	}

	/**
	 * Method that ends the game if player wins.
	 * @return true while the last NPC is alive.
	 */
	public boolean winGame() {
		boolean status = true;
		if(NPCs.get(0).getHealth() <= 0)
			status = false;
		return status;
	}

	/**
	 * @return the number of doors in a room.
	 */
	public int getNumberOfDoors() {
		return doors.size();
	}

	/**
	 * @return the number of NPCs in a room.
	 */
	public int getNumberOfNPCs() {
		return NPCs.size();
	}
}