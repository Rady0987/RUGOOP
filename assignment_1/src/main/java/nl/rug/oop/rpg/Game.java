package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



/**
 * The game itself
 */
public class Game implements Serializable{
	private Player player;
	private ArrayList<Room> rooms;
	private FileSaving file;
	private static final long serialVersionUID = 42L;
	/* This field will not be serialized */
	private transient Scanner scanner;

	public Game() {
		rooms = new ArrayList<>();
	}

	public void theSaveLocation(FileSaving file){
		this.file = file;
	}

	public void addRoom0(Room room) {
		Door door1 = new AttackDoor("A mysterious red door",2, 2, 1);
    	room.addDoor(door1);
    	Door door2 = new ArmorDoor("A black door",1);
    	room.addDoor(door2);
		Computer computer = new Computer("Computer", "An ancient, broken computer", ": Hi my dear friend, you entered a very dangerous place, this labyrinth hides a lot of" +
				" mythical creatures, some of them are not the most hospitable ones.\n" + "\t You have to be very brave, since you chose this risky path. Good luck! ", 99, 0, true);
		room.addNPC(computer);
		rooms.add(room);
	}

	public void addRoom1(Room room) {
		Door door1 = new ArmorDoor("A broken door",2);
		room.addDoor(door1);
		Door door2 = new ArmorDoor("An ethereal pass",3);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Zulgeteb", "Troll",": Arrrr, how dare are you to step in the Zulgeteb's kingdom!?\n" +
				"\t If you want remain alive, you have to fight me!!!", 10, 5,true);
		room.addNPC(enemy);
		rooms.add(room);
	}

	public void addRoom2(Room room) {
		Door door1 = new ArmorDoor("A moldy door",1);
		room.addDoor(door1);
		Door door2 = new AttackDoor("A burning pass",5, 5, 1);
		room.addDoor(door2);
		Door door3 = new AttackDoor("A bloody gate",3, 7, 3);
		room.addDoor(door3);
		Craftsman craftsman = new Craftsman("Malcolum", "Craftsman",": I'm glad to see you, weary traveller!\n" +
				"\t My goods are ready to help you in your mission!", 5, 0, true);
		room.addNPC(craftsman);
		rooms.add(room);
	}

	public void addRoom3(Room room) {
		Door door1 = new AttackDoor("A mechanical iron door",2,4,1);
		room.addDoor(door1);
		Door door2 = new ArmorDoor("Light portal",4);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Warrath", "Minotaur",": Grrr! Are you really so brave or just stupid enough to think you could defeat me?? \n" +
				"\t You might have killed some trolls, but you are no match for me!!", 7, 3,true);
		room.addNPC(enemy);
		rooms.add(room);
	}

	public void addRoom4(Room room) {
		Door door1 = new AttackDoor("A burning pass",5, 5, 1);
		room.addDoor(door1);
		Door door2 = new AttackDoor("The Ignited, Deadly Bridge",7,10,1);
		room.addDoor(door2);
		Paladin paladin = new Paladin("The Diviner of the Heaven","Paladin", ": Greetings, fearless Warrior!\n" +
				"\t As a reward for your good deeds in the name of justice, I will offer you the priceless elixir of life!", 20, 0, true);
		room.addNPC(paladin);
		rooms.add(room);
	}

	public void addRoom5(Room room) {
		Door door1 = new AttackDoor("A blazing path",6,6,1);
		room.addDoor(door1);
		Door door2 = new ArmorDoor("Light portal",4);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Akath", "Demon",": Hmm, I can see your fears that you hide behind your courageous heart!\n" +
				"\t You will never get out of here, this labyrinth will be your cage for an eternity...", 13, 5,true);
		room.addNPC(enemy);
		rooms.add(room);
	}

	public void addRoom6(Room room) {
		Door door1 = new AttackDoor("The Ignited, Deadly Bridge ",7, 10, 1);
		room.addDoor(door1);
		Witch witch = new Witch("Queen Drach","Witch", ": Welcome, saviour, you have overcome a lot of challenges by now, however you haven't finished yet.\n" +
				"\t The worst is yet to come, so I will grant you the power of the ancient Titans!", 20, 0, true);
		room.addNPC(witch);
		rooms.add(room);
	}

	public void addRoom7(Room room) {
		Enemy enemy = new Enemy("Yinglong","Dragon", ": I smell blood, I might be having some fresh human meat today... \n" +
				"\t You can't run now, it was a fatal mistake to enter The Hell Incarnate Coliseum!!!\n" +
				"\t Now taste my fire!!!!!", 50, 10,true);
		room.addNPC(enemy);
		rooms.add(room);
	}


	public void addPlayer(Player player) {
		this.player= player;
	}

	public void playGame() throws ClassNotFoundException{
		Scanner scanner = new Scanner(System.in);
		defaultMenu();
    	while(scanner.hasNextInt() && (player.getHealth() > 0) ) {
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
				if(interactID == -1) {
					System.out.println("You haven't interacted with anybody.");
				} else {
					rooms.get(player.getLocation()).NPCInteract(interactID, player);
				}
			}
			if(num == 3){
				quickSave();
			}
			if(num == 4){
				quickLoad();
			}
		defaultMenu();

		}
	}

	public void quickSave(){
		file.save();
	}

	public void quickLoad() throws ClassNotFoundException{
		file.load();
	}

	public void defaultMenu() {
		System.out.println("What do you want to do?");
		System.out.println("\t (0) Look around");
		System.out.println("\t (1) Look for a way out");
		System.out.println("\t (2) Look for company");
		System.out.println("\t (3) QuickSave");
		System.out.println("\t (4) QuickLoad");
	}

	public void lookAround() {
		System.out.print("You are in ");
		rooms.get(player.getLocation()).inspect();
		//System.out.println("\n");
	}

	public void lookForWayOut() {
		System.out.println("You look around for doors. You see:");
		rooms.get(player.getLocation()).inspectDoors();
		System.out.println("Which door do you take? (-1 : stay here)");
	}

	public void changeRooms(int doorID){
		rooms.get(player.getLocation()).doorInteract(doorID, player);
		System.out.println("You are in room " +  player.getLocation());
	}

	public void lookForCompany() {
		System.out.println("You look if there’s someone here. " + "You see: ");
		rooms.get(player.getLocation()).inspectNPCs();
		System.out.println("Interact ? (-1 : do nothing)");
	}

}