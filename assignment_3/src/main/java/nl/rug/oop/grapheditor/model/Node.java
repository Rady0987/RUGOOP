package nl.rug.oop.grapheditor.model;

import java.awt.*;

/**
 * Node class.
 */
public class Node extends Rectangle{
   private String name;
   private boolean isSelected;

   /**
    * Constructor
    */
   public Node(String name, int x, int y, int width, int height) {
      super(x, y, width, height);
      this.name = name;
      isSelected = false;
   }

   public Node() {
      super( 100,100,200,100);
      this.name = "Node";
      isSelected = false;
   }

   public void setSelected(boolean b) {
      isSelected = b;
   }

   public boolean isSelected() {
      return isSelected;
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

   public void rename(String name) {
      if(name != null)
         this.name = name;
   }

   public Point getCenter() {
      return new Point(x + (width / 2), y + (height / 2));
   }

   public String getName() {
      return name;
   }

   public Rectangle getNodeArea() {
      return this;
   }

   public Point getCoordinates() {
      return new Point(x, y);
   }

}
