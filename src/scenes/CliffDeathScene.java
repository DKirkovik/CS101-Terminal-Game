package scenes;

import java.io.*;
import java.util.ArrayList;

public class CliffDeathScene extends Scene implements Ending {
    String endText;

    public CliffDeathScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    String welcomeText() {
        endingText();
        return endText;
    }


    @Override
    String sceneAction() {
        String txt = "Jump in the water and try swimming across!";
        setEndScene(true);
        return txt;
    }

    @Override
    public void setEndScene(boolean endScene) {
        super.setEndScene(endScene);
    }

    @Override
    public void endingText() {
        try {
            Reader input = new BufferedReader(new FileReader("textFiles/cliffDeathText.txt"));
            endText = ((BufferedReader) input).readLine();
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
