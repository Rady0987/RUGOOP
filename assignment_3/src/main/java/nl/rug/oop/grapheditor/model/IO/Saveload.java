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
 * This class creates saving and loading methods for the graph editor.
 */
public class Saveload {

   /**
    * This method saves the state of the graph editor.
    *
    * @param Edges The array of the edges.
    * @param Nodes The array of the nodes.
    */
   public static void saveGraph(ArrayList<Edge> Edges, ArrayList<Node> Nodes) {
      String ls = System.getProperty("line.separator");
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Save file (*.graph)", "graph");
      chooser.setFileFilter(filter);
      chooser.setDialogTitle("Save");
      chooser.setCurrentDirectory(new File("savedgraphs"));
      int returnVal = chooser.showDialog(null, "Save");
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         File file = chooser.getSelectedFile();
         chooser.setCurrentDirectory(file);
         String filename = chooser.getCurrentDirectory() + File.separator + chooser.getSelectedFile().getName() + ".graph";
         try (PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)))) {
            w.printf("%d %d %s", Nodes.size(), Edges.size(), ls);
            for (Node i : Nodes) {
               w.printf("%d %d %d %d %s %s", (int)i.getX(), (int)i.getY(), (int)i.getHeight(), (int)i.getWidth(), i.getName(), ls);
            }
            for (Edge j : Edges) {

               w.printf("%d %d %s", Nodes.indexOf(j.getNodeOne()), Nodes.indexOf(j.getNodeTwo()), ls);
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
    * This method loads a state of the graph editor.
    *
    * @param graph The GraphModel.
    * @param path The loading path.
    * @param cmdLoad True if the input file is given from terminal, false if not.
    */
   public static void loadGraph(GraphModel graph, String path, boolean cmdLoad) {
      int nodes, edges;
      File filePath = loadPath(path, cmdLoad);
      if(filePath != null) {
         try {
            Scanner scanner = new Scanner(filePath);
            nodes = scanner.nextInt();
            edges = scanner.nextInt();
            for (int i = 0; i < nodes; i++) {
               int x = scanner.nextInt();
               int y = scanner.nextInt();
               int height = scanner.nextInt();
               int width = scanner.nextInt();
               String name = scanner.next();
               Node newNode = new Node(name, x, y, width, height);
               graph.addNode(newNode);
            }
            for (int j = 0; j < edges; j++) {
               int nodeOne = scanner.nextInt();
               Node one = graph.getNode(nodeOne);
               int nodeTwo = scanner.nextInt();
               Node two = graph.getNode(nodeTwo);
               Edge edge = new Edge(one, two);
               graph.addEdge(edge);
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   /**
    * This method creates the loading path, depending on the input.
    *
    * @param path The loading path.
    * @param cmdLoad True if the input file is given from terminal, false if not.
    */
   public static File loadPath(String path, boolean cmdLoad) {
      File file = null;
      if (!cmdLoad) {
         JFileChooser chooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Save file (*.graph)", "graph");
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
      return file;
   }
}
