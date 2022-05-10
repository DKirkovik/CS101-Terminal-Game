package scenes;

import java.util.ArrayList;
import java.util.List;

public class CliffScene extends Scene {
    public CliffScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    String welcomeText() {
        String txt = "You pass through a small gap and see a river crossing \n and on the other side a big chest full of gold! Choos your action:";
        return txt;
    }

    @Override
    String sceneAction() {
        String action = "Go towards the sound of water and birds!";
        return action;
    }
}
