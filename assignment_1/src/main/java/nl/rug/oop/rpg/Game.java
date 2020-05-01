package nl.rug.oop.rpg;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The game itself
 */
public class Game {
	private Player player;
	private ArrayList<Room> rooms;

	public Game() {
		rooms = new ArrayList<>();
	}

	public void addRoom0(Room room) {
		Door door1 = new Door("A mysterious red door",2);
    	room.addDoor(door1);
    	Door door2 = new Door("A black door",1);
    	room.addDoor(door2);
		Computer computer = new Computer("An ancient, broken computer", "Computer: Hi my dear friend, you entered a very dangerous place, this labyrinth hides a lot of" +
				" mythical creatures, some of them are not the most hospitable ones. You have to be very brave, since you chose this risky path. Good luck! ", 99);
		room.addNPC(computer);
		rooms.add(room);
	}

	public void addRoom1(Room room) {
		Door door1 = new Door("A broken door",2);
		room.addDoor(door1);
		Door door2 = new Door("An ethereal pass",3);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Troll", "Zulgeteb: Arrrr, how dare are you to step in the Zulgeteb's kingdom!?\n" +
				"If you want remain alive, you have to fight me!!!", 5, 1);
		room.addNPC(enemy);
		rooms.add(room);
	}

	public void addRoom2(Room room) {
		Door door1 = new Door("A moldy door",1);
		room.addDoor(door1);
		Door door2 = new Door("A burning pass",5);
		room.addDoor(door2);
		Door door3 = new Door("A bloody gate",3);
		room.addDoor(door3);
		Craftsman craftsman = new Craftsman("Craftsman", "Malcolum: I'm glad to see you, weary traveller!\n" +
				"My goods are ready to help you in your mission!", 5);
		room.addNPC(craftsman);
		rooms.add(room);
	}

	public void addRoom3(Room room) {
		Door door1 = new Door("A mechanical iron door",2);
		room.addDoor(door1);
		Door door2 = new Door("Light portal",4);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Minotaur", "Warrath: Grrr! Are you really so brave or just stupid enough to think you could defeat me?? \n" +
				"You might have killed some trolls, but you are no match for me!!", 7, 3);
		room.addNPC(enemy);
		rooms.add(room);
	}

	public void addRoom4(Room room) {
		Door door1 = new Door("A burning pass",5);
		room.addDoor(door1);
		Door door2 = new Door("The Ignited, Deadly Bridge",7);
		room.addDoor(door2);
		Paladin paladin = new Paladin("Paladin", "The Diviner of the Heaven: Greetings, fearless Warrior!\n" +
				"As a reward for your good deeds in the name of justice, I will offer you the priceless elixir of life!", 20);
		room.addNPC(paladin);
		rooms.add(room);
	}

	public void addRoom5(Room room) {
		Door door1 = new Door("A blazing path",6);
		room.addDoor(door1);
		Door door2 = new Door("Light portal",4);
		room.addDoor(door2);
		Enemy enemy = new Enemy("Demon", "Akath: Hmm, I can see your fears that you hide behind your courageous heart!\n" +
				"You will never get out of here, this labyrinth will be your cage for an eternity...", 13, 5);
		room.addNPC(enemy);
		rooms.add(room);
	}

	public void addRoom6(Room room) {
		Door door1 = new Door("The Ignited, Deadly Bridge ",7);
		room.addDoor(door1);
		Witch witch = new Witch("Witch", "Queen Drach: Welcome, saviour, you have overcome a lot of challenges by now, however you haven't finished yet.\n" +
				"The worst is yet to come, so I will grant you the power of the ancient Titans!", 20);
		room.addNPC(witch);
		rooms.add(room);
	}

	public void addRoom7(Room room) {
		Enemy enemy = new Enemy("Dragon", "Yinglong: I smell blood, I might be having some fresh human meat today... \n" +
				"You can't run now, it was a fatal mistake to enter The Hell Incarnate Coliseum!!!\n" +
				"Now taste my fire!!!!!", 50, 10);
		room.addNPC(enemy);
		rooms.add(room);
	}


	public void addPlayer(Player player) {
		this.player= player;
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		defaultMenu();
    	while(scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if(num == 0){
				lookAround();
			}
			if(num == 1) {
				lookForWayOut();
				int doorID = scanner.nextInt();
				if(doorID == -1) {
					System.out.println("You are in room " +  player.location());
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
					System.out.println("The creature is asleep so you can’t interact with it.");
				}
			}
		defaultMenu();

		}
	}
	public void defaultMenu() {
		System.out.println("What do you want to do?");
		System.out.println("(0) Look around");
		System.out.println("(1) Look for a way out");
		System.out.println("(2) Look for company");
	}

	public void lookAround() {
		System.out.print("You see: ");
		rooms.get(player.location()).inspect();
	}

	public void lookForWayOut() {
		System.out.println("You look around for doors. You see:");
		rooms.get(player.location()).inspectDoors();
		System.out.println("Which door do you take? (-1 : stay here)");
	}

	public void changeRooms(int doorID){
		rooms.get(player.location()).doorInteract(doorID, player);
		System.out.println("You are in room " +  player.location());
	}

	public void lookForCompany() {
		System.out.println("You look if there’s someone here. \n" + "You see: ");
		rooms.get(player.location()).inspectNPCs();
		System.out.println("Interact ? (-1 : do nothing)");
	}

	public void interact() {
		Scanner scanner = new Scanner(System.in);
		int selectedNPC = scanner.nextInt();



	}
}