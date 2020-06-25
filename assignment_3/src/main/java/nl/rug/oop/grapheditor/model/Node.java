package nl.rug.oop.grapheditor.model;

import java.util.Observable;

/**
 * Node class.
 */
public class Node extends Observable {
   public String name;
   private int x;
   private int y;
   private int width;
   private int height;

   /**
    * Constructor
    */
   public Node(String name, int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width= width;
      this.height = height;
      this.name = name;
   }

   /**
    * Getter for X coordinate
    */
   public int getX() {
      return x;
   }

   /**
    * Getter for Y coordinate
    */
   public int getY() {
      return y;
   }

   /**
    * Getter for height
    */
   public int getHeight() {
      return height;
   }

   /**
    * Getter for width
    */
   public int getWidth() {
      return width;
   }

   /**
    * Setter for X coordinate
    *
    * @param x x coordinate
    */
   public void setX(int x) {
      this.x = x;
   }

   /**
    * Setter for Y coordinate
    *
    * @param y Y coordinate
    */
   public void setY(int y) {
      this.y = y;
   }

   public void setName(String name) {
      this.name = name;
   }
}
