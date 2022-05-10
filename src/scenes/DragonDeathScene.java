package scenes;

import java.io.*;
import java.util.ArrayList;

public class DragonDeathScene extends Scene implements Ending {
    String endText;

    public DragonDeathScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    String welcomeText() {
        endingText();
        return endText;
    }

    @Override
    String sceneAction() {
        String action = "Steal all the gold and run away!";
        setEndScene(true);
        return action;
    }

    @Override
    public void endingText() {
        try {
            Reader input = new BufferedReader(new FileReader("textFiles/dragonDeathText.txt"));
            endText = ((BufferedReader) input).readLine();
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
