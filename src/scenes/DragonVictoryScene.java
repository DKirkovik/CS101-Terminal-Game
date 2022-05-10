package scenes;

import java.io.*;
import java.util.ArrayList;

public class DragonVictoryScene extends Scene implements Ending {
    String endText;

    public DragonVictoryScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    public void endingText() {
        try {
            Reader input = new BufferedReader(new FileReader("textFiles/cliffVictoryText.txt"));
            endText = ((BufferedReader) input).readLine();
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    String welcomeText() {
        endingText();
        return endText;
    }

    @Override
    String sceneAction() {
        String action = "Fight the dragon with your sword!";
        setEndScene(true);
        return action;
    }
}
