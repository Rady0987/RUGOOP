package nl.rug.oop.grapheditor.model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.*;
import java.util.Observable;
import java.util.Observer;

public class GraphModel extends Observable implements Observer {
   private ArrayList<Node> Nodes;
   private ArrayList<Edge> Edges;

   public GraphModel() {
      Nodes = new ArrayList<Node>();
      Edges = new ArrayList<Edge>();
      loadGraph();
   }

   public void removeEdge(int index) {
      Edges.remove(index);
   }

   public void addEdge(int nodeOne, int nodeTwo) {
      Edge edge = new Edge(nodeOne, nodeTwo);
      Edges.add(edge);
   }

   public void addNode(String name) {
      Node node = new Node(name);
      Nodes.add(node);
      //node.printName();
   }

   public void addNode(String name, int x, int y, int height, int width) {
      Node node = new Node(name, x, y, width, height);
      Nodes.add(node);
      //node.printName();
   }

   public void removeNode(int index) {
      Nodes.remove(index);
      for (Edge i : Edges) {
         if (i.getNodeOne() == index || i.getNodeTwo() == index)
            Edges.remove(i);
      }
   }

   public void saveGraph() {
      String ls = System.getProperty("line.separator");
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
      chooser.setFileFilter(filter);
      chooser.setDialogTitle("Save");
      chooser.setCurrentDirectory(new File("savedgraphs"));
      int returnVal = chooser.showSaveDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         File file = chooser.getSelectedFile();
         chooser.setCurrentDirectory(file);
         try (PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(chooser.getCurrentDirectory() + File.separator + chooser.getSelectedFile().getName() + ".txt", false)))) {
            w.printf("%d %d %s", Nodes.size(), Edges.size(), ls);
            for (Node i : Nodes) {
               w.printf("%d %d %d %d %s %s", i.x, i.y, i.height, i.width, i.name, ls);
            }
            for (Edge j : Edges) {
               w.printf("%d %d %s", j.getNodeOne(), j.getNodeTwo(), ls);
            }
            w.close();
            System.out.println("Save successful!");
         } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
         } catch (IOException e) {
            System.out.println("could not write to file");
         }
      }
   }

   public void loadGraph() {
      int nodes, edges;
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
      chooser.setFileFilter(filter);
      chooser.setDialogTitle("Load");
      chooser.setCurrentDirectory(new File("savedgraphs"));
      int returnVal = chooser.showOpenDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         File file = chooser.getSelectedFile();
         try {
            Scanner scanner = new Scanner(file);
            nodes = scanner.nextInt();
            edges = scanner.nextInt();
            for (int i = 0; i < nodes; i++) {
               int x = scanner.nextInt();
               int y = scanner.nextInt();
               int height = scanner.nextInt();
               int width = scanner.nextInt();
               String name = scanner.next();
               addNode(name, x, y, height, width);
            }
            for (int j = 0; j < edges; j++) {
               int nodeOne = scanner.nextInt();
               int nodeTwo = scanner.nextInt();
               addEdge(nodeOne, nodeTwo);
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   public void optionOneChosen(){
      
   }

   /**
     * Updates the view
   */
    @Override
    public void update(Observable observable, Object message) {
        setChanged();
        notifyObservers();
    }
}