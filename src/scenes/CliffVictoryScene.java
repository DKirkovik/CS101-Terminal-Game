package scenes;

import java.io.*;
import java.util.ArrayList;

public class CliffVictoryScene extends Scene implements Ending {
    String endText;

    public CliffVictoryScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
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
        String txt = "Try safely crossing the river without making too much noise";
        setEndScene(true);
        return txt;
    }
}
