package nl.rug.oop.rpg.io;
import nl.rug.oop.rpg.game.Game;
import nl.rug.oop.rpg.game.Player;

import java.io.*;
import java.util.Properties;

/**
 * Class that contains some methods for initialising and loading Java Properties
 */

public class Initialiser {

    /**
     * Creates a number of Java Properties and stores it in a file inside of a config directory.
     *
     * @param game The name of the file the properties should be stored in
     */
    public static void createProperties(Game game) {
        Properties rpgProperties = new Properties();
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("config/props");
            rpgProperties.load(fileInput);
            String playerName = rpgProperties.getProperty("playerName");
            int location = Integer.parseInt(rpgProperties.getProperty("playerStartLocation"));
            int health = Integer.parseInt(rpgProperties.getProperty("playerHealth"));
            int attackDamage = Integer.parseInt(rpgProperties.getProperty("playerAttackDamage"));
            int armor = Integer.parseInt(rpgProperties.getProperty("playerArmor"));
            Player player = new Player(playerName,health,attackDamage,armor, location);
            game.addPlayer(player);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialises a game with properties specified in a properties file
     *
     */
    public static void initGameFromProperties() {
        File saveDirectory = new File("config");
        saveDirectory.mkdir();
        Properties rpgProperties = new Properties();
        FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream("config/props");
            rpgProperties.setProperty("playerName", "Howard the Duck");
            rpgProperties.setProperty("playerStartLocation", "0");
            rpgProperties.setProperty("playerHealth", "60");
            rpgProperties.setProperty("playerAttackDamage", "3");
            rpgProperties.setProperty("playerArmor", "0");
            rpgProperties.store(fileOutput, "These are the properties of a player in the RPG game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
