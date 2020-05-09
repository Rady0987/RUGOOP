package nl.rug.oop.rpg.game;
import nl.rug.oop.rpg.Main;
import nl.rug.oop.rpg.io.Serializer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * The game class.
 */

public class Game implements Serializable {
	private Player player;
	private ArrayList<Room> rooms;
	private static final long serialVersionUID = 42L;
	/* This field will not be serialized */
	private transient Scanner scanner;

	public Game() {
		rooms = new ArrayList<Room>();
	}

	/**
	 * Method that initialize the Room 0.
	 * @param room The name of the room's variable.
	 */
	public void addRoom0(Room room) {
		Door door1 = new AttackDoor("A mysterious red door",2, 2, 1);
    	room.addDoor(door1);
    	Door door2 = new ArmorDoor("A black door",1,1);
    	room.addDoor(door2);
		Computer computer = new Computer("Computer", "An ancient, broken computer", ": Hi my dear friend, you entered a very dangerous place, this labyrinth hides a lot of" +
				" mythical creatures, some of them are not the most hospitable ones.\n" + "\t You have to be very brave, since you chose this risky path. Good luck! ", 99, 0, true, false);
		room.addNPC(computer);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 1.
	 * @param room The name of the room's variable.
	 */
	public void addRoom1(Room room) {
		Door door1 = new ArmorDoor("A broken door",2,2);
		room.addDoor(door1);
		Door door2 = new ArmorDoor("An ethereal pass",3,2);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Zulgeteb", "Troll",": Arrrr, how dare are you to step in the Zulgeteb's kingdom!?\n" +
				"\t If you want remain alive, you have to fight me!!!", 10, 5,true, false);
		room.addNPC(enemy);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 2.
	 * @param room The name of the room's variable.
	 */
	public void addRoom2(Room room) {
		Door door1 = new ArmorDoor("A moldy door",1,2);
		room.addDoor(door1);
		Door door2 = new AttackDoor("A burning pass",5, 5, 1);
		room.addDoor(door2);
		Door door3 = new AttackDoor("A bloody gate",3, 7, 3);
		room.addDoor(door3);
		Craftsman craftsman = new Craftsman("Malcolum", "Craftsman",": I'm glad to see you, weary traveller!\n" +
				"\t My goods are ready to help you in your mission!", 5, 0, true, false);
		room.addNPC(craftsman);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 3.
	 * @param room The name of the room's variable.
	 */
	public void addRoom3(Room room) {
		Door door1 = new AttackDoor("A mechanical iron door",2,4,1);
		room.addDoor(door1);
		Door door2 = new ArmorDoor("Light portal",4,3);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Warrath", "Minotaur",": Grrr! Are you really so brave or just stupid enough to think you could defeat me?? \n" +
				"\t You might have killed some trolls, but you are no match for me!!", 7, 3,true, false);
		room.addNPC(enemy);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 4.
	 * @param room The name of the room's variable.
	 */
	public void addRoom4(Room room) {
		Door door1 = new AttackDoor("A burning pass",5, 5, 1);
		room.addDoor(door1);
		Door door2 = new AttackDoor("The Ignited, Deadly Bridge",7,10,1);
		room.addDoor(door2);
		Paladin paladin = new Paladin("The Diviner of the Heaven","Paladin", ": Greetings, fearless Warrior!\n" +
				"\t As a reward for your good deeds in the name of justice, I will offer you the priceless elixir of life!", 20, 0, true, false);
		room.addNPC(paladin);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 5.
	 * @param room The name of the room's variable.
	 */
	public void addRoom5(Room room) {
		Door door1 = new AttackDoor("A blazing path",6,6,1);
		room.addDoor(door1);
		Door door2 = new ArmorDoor("Light portal",4,4);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Akath", "Demon",": Hmm, I can see your fears that you hide behind your courageous heart!\n" +
				"\t You will never get out of here, this labyrinth will be your cage for an eternity...", 13, 5,true, false);
		room.addNPC(enemy);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 6.
	 * @param room The name of the room's variable.
	 */
	public void addRoom6(Room room) {
		Door door1 = new ArmorDoor("The Ignited, Deadly Bridge ",7, 6);
		room.addDoor(door1);
		Witch witch = new Witch("Queen Drach","Witch", ": Welcome, saviour, you have overcome a lot of challenges by now, however you haven't finished yet.\n" +
				"\t The worst is yet to come, so I will grant you the power of the ancient Titans!", 20, 0, true, 5, false);
		room.addNPC(witch);
		rooms.add(room);
	}

	/**
	 * Method that initialize the Room 7.
	 * @param room The name of the room's variable.
	 */
	public void addRoom7(Room room) {
		Enemy enemy = new Enemy("Yinglong","Dragon", ": I smell blood, I might be having some fresh human meat today... \n" +
				"\t You can't run now, it was a fatal mistake to enter The Hell Incarnate Coliseum!!!\n" +
				"\t Now taste my fire!!!!!", 50, 10,true, false);
		room.addNPC(enemy);
		rooms.add(room);
	}

	/**
	 * Method that adds the player to the game.
	 * @param player the name of the attacked player.
	 */
	public void addPlayer(Player player) {
		this.player= player;
	}

	/**
	 * Method that runs the game menus.
	 */
	public void playGame(Game game) throws ClassNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		defaultMenu();
    	while( true) {
			int num = scanner.nextInt();
			if(num == 0){
				lookAround();
			}
			if(num == 1) {
				lookForWayOut();
				int doorID = scanner.nextInt();
				if(doorID == -1) {
					System.out.println("You are in room " +  player.getLocation());
				} else {
					changeRooms(doorID);
				}
			}
			if(num == 2) {
				lookForCompany();
				int interactID = scanner.nextInt();
				int arrayBounds = rooms.get(player.getLocation()).getNumberOfNPCs() - 1;
				if(interactID <= -1 || interactID > arrayBounds) {
					System.out.println("You haven't interacted with anybody.");
				} else {
					rooms.get(player.getLocation()).NPCInteract(interactID, player);
				}
			}
			if(num == 3){
				Serializer.saveGame(game,2);
			}
			if(num == 4){
				Main.startGame(Serializer.loadGame(2));
			}
			if(num == 5){
				Serializer.saveGame(game,1);
			}
			if(num == 6){
				Main.startGame(Serializer.loadGame(1));
			}
			if (!rooms.get(7).winGame()) {
				System.out.println("You have restored the balance in all the 8 lands of The Icraneron by defeating all the enemies. You are a legendary warrior!");
				System.exit(0);
			}
		defaultMenu();
		}
	}

	/**
	 * Method that prints the default set of actions.
	 */
	public void defaultMenu() {
		System.out.println("What do you want to do?");
		System.out.println("\t (0) Look around");
		System.out.println("\t (1) Look for a way out");
		System.out.println("\t (2) Look for company");
		System.out.println("\t (3) QuickSave");
		System.out.println("\t (4) QuickLoad");
		System.out.println("\t (5) Save");
		System.out.println("\t (6) Load");
	}

	/**
	 * Method that prints the description of the room.
	 */
	public void lookAround() {
		System.out.print("You are in ");
		rooms.get(player.getLocation()).inspect();
	}
	/**
	 * Method that prints the doors in a room.
	 */
	public void lookForWayOut() {
		System.out.println("You look around for doors. You see:");
		rooms.get(player.getLocation()).inspectDoors();
		System.out.println("Which door do you take? (-1 : stay here)");
	}

	/**
	 * Method that change the location of the player.
	 * @param doorID Index of the door in the ArrayList of a specific room.
	 */
	public void changeRooms(int doorID){
		if(doorID > rooms.get(player.getLocation()).getNumberOfDoors() - 1) {
			System.out.println("Invalid room");
		} else {
			rooms.get(player.getLocation()).doorInteract(doorID, player);
			System.out.println("You are in room " + player.getLocation());
		}
	}

	/**
	 * Method that prints the NPCs in a specific room.
	 */
	public void lookForCompany() {
		System.out.println("You look if there’s someone here. " + "You see: ");
		rooms.get(player.getLocation()).inspectNPCs();
		System.out.println("Interact ? (-1 : do nothing)");
	}

}