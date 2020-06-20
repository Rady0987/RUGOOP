package nl.rug.oop.grapheditor.model;

import java.util.Observable;

public class Node extends Observable {
   public String name;
   private int x;
   private int y;
   private int width;
   private int height;


   public Node(String name, int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width= width;
      this.height = height;
      this.name = name;
   }

   public void printName() {
      System.out.println(name);
   }

   public void move(int x, int y) {
      this.x = x;
      this.y = y;

      /* Let the Observers know that the position of the Box has changed, which will update the View */
      setChanged();
      notifyObservers();
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public int getHeight() {
      return height;
   }

   public int getWidth() {
      return width;
   }
}
