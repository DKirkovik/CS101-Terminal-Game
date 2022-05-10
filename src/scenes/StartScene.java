package scenes;

import java.io.*;
import java.util.ArrayList;

public class StartScene extends Scene implements Starting {
    String startText;

    public StartScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    String welcomeText() {
        startingText();
        return startText;
    }

    @Override
    public void setStartScene(boolean startScene) {
        super.setStartScene(startScene);
    }

    @Override
    String sceneAction() {
        setStartScene(true);
        return null;
    }

    @Override
    public void startingText() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("textFiles/startText.txt"));
            startText = input.readLine();
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
