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

	public void addRoom(Room room) {
		Door door1 = new Door("A mysterious red door",2);
    	room.addDoor(door1);
    	Door door2 = new Door("A black door",1);
    	room.addDoor(door2);
		NPC npc1 = new NPC("A suspiciously happy looking orc", 5);
		room.addNPC(npc1);
		NPC npc2 = new NPC("The kerstman",10);
		room.addNPC(npc2);
		NPC npc3 = new NPC("A dancing strawberry",8);
		room.addNPC(npc3);
		rooms.add(room);
	}

	public void addPlayer(Player player) {
		this.player= player;
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What do you want to do?");
    	System.out.println("(0) Look around");
    	System.out.println("(1) Look for a way out");
		System.out.println("(2) Look for company");
    	while(scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if(num == 0){
				lookAround();
			}
			if(num == 1) {
				lookForWayOut();
				int doorID = scanner.nextInt();
				if(doorID == -1) {
					System.out.println("You are in the same room");
				} else {
					//doors.get(DoorID);
					//Door.interact(player);
				}
			}
			if(num == 2) {
				lookForCompany();
			}
			System.out.println("What do you want to do?");
    		System.out.println("(0) Look around");
    		System.out.println("(1) Look for a way out");
			System.out.println("(2) Look for company");

		}
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

	public void lookForCompany() {
		System.out.println("You look if there’s someone here. \n" + "You see: ");
		rooms.get(player.location()).inspectNPCs();
	}
}