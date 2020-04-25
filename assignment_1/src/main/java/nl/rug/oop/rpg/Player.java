package nl.rug.oop.rpg;
/***Models a player with a name*/
public class Player {
	private String name;
	private int location;
	private static int DEFAULT_LOCATION = 0;

	public Player(String name) {
		this.name = name;
		this.location = DEFAULT_LOCATION;
	}

	public int location(){
		return location;
	}

	public void changeLocation(int location){
		this.location = location;
	}
	
}