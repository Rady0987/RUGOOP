package nl.rug.oop.grapheditor.model;

import java.awt.*;

public class Node extends Rectangle {
   public String name;

   public Node(String name) {
      super(0,0,5,5);
      this.name = name;
   }

   public Node(String name, int x, int y, int width, int height) {
      super(x,y,width,height);
      this.name = name;
   }

   public void printName() {
      System.out.println(name);
   }

}
