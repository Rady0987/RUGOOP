package nl.rug.oop.rpg;
/*
**Models a door with a description
*/
public class Door implements Inspectable {
	private String description;
	public Door(String description) {
		this.description = description;
	}

	public void inspect(){
		System.out.println(description);
	}
	
}