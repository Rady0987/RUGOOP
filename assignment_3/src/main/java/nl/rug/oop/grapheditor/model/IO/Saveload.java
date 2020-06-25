package nl.rug.oop.grapheditor.model.IO;

import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SaveLoad class
 */
public class Saveload {

   /**
    * Method that checks the extension of the file in which the program saves
    *
    * @param fileName the saving path
    */
   private static String extensionCheck(String fileName) {
      String extension;
      if (fileName.length() > 4) {
         extension = fileName.substring(fileName.length() - 4);
      } else {
         return fileName + ".txt";
      }
      if (!".txt".equals(extension)) {
         fileName += ".txt";
      }
      return fileName;
   }

   /**
    * Method that saves the state of the graph
    *
    * @param Edges the array with the edges
    * @param Nodes the array with the nodes
    * @param choise title of JFileChooser
    */
   public static void saveGraph(ArrayList<Edge> Edges, ArrayList<Node> Nodes, String choise) {
      String ls = System.getProperty("line.separator");
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
      chooser.setFileFilter(filter);
      chooser.setDialogTitle(choise);
      chooser.setCurrentDirectory(new File("savedgraphs"));
      int returnVal = chooser.showDialog(null, "Save");
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         File file = chooser.getSelectedFile();
         chooser.setCurrentDirectory(file);
         try (PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(extensionCheck(chooser.getCurrentDirectory() + File.separator + chooser.getSelectedFile().getName()), false)))) {
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

   /**
    * Method that loads a state of the graph
    * @param path the loading path
    * @param cmdLoad True if the input file is given from terminal, false if not
    *
    */
   public static void loadGraph(GraphModel graph,String path, boolean cmdLoad) {
      int nodes, edges;
      File file = null;
      if (!cmdLoad) {
         JFileChooser chooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
         chooser.setFileFilter(filter);
         chooser.setDialogTitle("Load");
         chooser.setCurrentDirectory(new File("savedgraphs"));
         int returnVal = chooser.showOpenDialog(null);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
         }
      } else {
         file = new File(path);
      }
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
                  graph.addNode(name, x, y, height, width);
               }
               for (int j = 0; j < edges; j++) {
                  int nodeOne = scanner.nextInt();
                  int nodeTwo = scanner.nextInt();
                  graph.addEdge(nodeOne, nodeTwo);
               }
            } catch (IOException e) {
               e.printStackTrace();
            }

      }

}
