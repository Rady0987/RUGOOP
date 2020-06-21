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

   public void setX(int x) {
      this.x = x;
   }

   public void setY(int y) {
      this.y = y;
   }

}
