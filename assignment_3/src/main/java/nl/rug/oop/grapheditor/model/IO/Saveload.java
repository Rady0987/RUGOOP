package nl.rug.oop.grapheditor.model.IO;

import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Saveload {

   public static void saveGraph(ArrayList<Edge> Edges, ArrayList<Node> Nodes) {
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
               w.printf("%d %d %d %d %s %s", i.getX(), i.getY(), i.getHeight(), i.getWidth(), i.name, ls);
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

   public static void loadGraph() {
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
               GraphModel.addNode(name, x, y, height, width);
            }
            for (int j = 0; j < edges; j++) {
               int nodeOne = scanner.nextInt();
               int nodeTwo = scanner.nextInt();
               GraphModel.addEdge(nodeOne, nodeTwo);
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}
