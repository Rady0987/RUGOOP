package nl.rug.oop.grapheditor.model;

import java.awt.*;

/**
 * This class creates a new node.
 */
public class Node extends Rectangle{
   private String name;
   private boolean isSelected;

   /**
    * The Constructor.
    *
    * @param name The name of the node.
    * @param x x coordinate.
    * @param y y coordinate.
    * @param width width value.
    * @param height height value.
    *
    */
   public Node(String name, int x, int y, int width, int height) {
      super(x, y, width, height);
      this.name = name;
      isSelected = false;
   }

   /**
    * The Constructor.
    *
    */
   public Node() {
      super( 100,100,200,100);
      this.name = "Node";
      isSelected = false;
   }

   /**
    * This method sets the node selected.
    *
    * @param b The truth value.
    *
    */
   public void setSelected(boolean b) {
      isSelected = b;
   }

   /**
    * This method gets the value of the isSelected boolean.
    *
    */
   public boolean isSelected() {
      return isSelected;
   }

   /**
    * This method sets the value of the X coordinate.
    *
    * @param x x coordinate
    */
   public void setX(int x) {
      this.x = x;
   }

   /**
    * This method sets the value of the Y coordinate.
    *
    * @param y y coordinate
    */
   public void setY(int y) {
      this.y = y;
   }

   /**
    * This method sets the name of a node.
    *
    * @param name The new name.
    */
   public void rename(String name) {
      if(name != null)
         this.name = name;
   }

   /**
    * This method gets the coordinates of the node center.
    *
    */
   public Point getCenter() {
      return new Point(x + (width / 2), y + (height / 2));
   }

   /**
    * This method gets the name of the node.
    *
    */
   public String getName() {
      return name;
   }

   /**
    * This method gets the rectangle area that is inside a node.
    *
    */
   public Rectangle getNodeArea() {
      return this;
   }

   /**
    * This method gets the coordinates of a node.
    *
    */
   public Point getCoordinates() {
      return new Point(x, y);
   }
}
