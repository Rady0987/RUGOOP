package nl.rug.oop.rpg.io;
import nl.rug.oop.rpg.game.Game;
import java.io.*;
import java.util.Scanner;

/**
 * Class that contains some methods for saving and loading the game.
 */

public class Serializer {

    /**
     * Saves the game.
     *
     * @param game The game that needs to be saved.
     * @param typeOfSave 1 for a basic save, 2 for a quickSave.
     */
    public static void saveGame(Game game, int typeOfSave) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        /* Sets up the save directory */
        File saveDirectory = new File("savedgames");
        saveDirectory.mkdir();
        if(typeOfSave == 1) {
            System.out.println("Filename?");
            fileName = scanner.nextLine();
        } else {
            fileName = "quickSave";
        }
        /* write object to a file */
        try (FileOutputStream fileOutputStream = new FileOutputStream(saveDirectory + File.separator + fileName + ".ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(game);
            System.out.println("Save successful!");
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        } catch (IOException e) {
            System.out.println("could not write to file");
        }
    }

    /**
     * Prints the files from given directory.
     *
     * @param saveDirectory The source directory.
     */
    public static void printFiles(File saveDirectory) {
        File[] files = saveDirectory.listFiles();
        int counter = 0;
        for (File file : files) {
            System.out.print("(" + counter + ") ");
            System.out.println(file.getName());
            counter++;
        }
    }

    /**
     * @return the name of the file.
     *
     * @param saveDirectory The source directory.
     * @param number The index of the file.
     */
    public static String getFileName(File saveDirectory, int number) {
        String name = "";
        File[] files = saveDirectory.listFiles();
        int counter = 0;
        for (File file : files) {
            if (counter == number) {
                name = file.getName();
                return name;
            }
            counter++;
        }
        if (counter < number) {
            System.out.println("There is not such a file");
        }
        return name;
    }

    /**
     * Loads the game from a savefile
     *
     * @param typeOfLoad 1 for a basic load, 2 for a quickLoad.
     * @return The game that was saved in the savefile
     * @throws IOException            If the file could not be found or read from
     * @throws ClassNotFoundException If the class could not be properly loaded
     */
    public static Game loadGame(int typeOfLoad) throws IOException, ClassNotFoundException {
        File saveDirectory = new File("savedgames");
        Scanner scanner = new Scanner(System.in);
        String fileName;
        if(typeOfLoad == 1) {
            printFiles(saveDirectory);
            System.out.println("Which file? (-1 : none)");
            int number = scanner.nextInt();
            fileName = getFileName(saveDirectory, number);
        } else {
            fileName = "quickSave.ser";
        }
        try (FileInputStream fileInputStream = new FileInputStream(saveDirectory + File.separator + fileName );
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Game game = (Game) objectInputStream.readObject();
            System.out.println("Load successfully!");
            return game;
        }
    }
}


