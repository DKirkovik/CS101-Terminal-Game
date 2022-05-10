package scenes;

import java.util.ArrayList;

public class CaveScene extends Scene {
    public CaveScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    String welcomeText() {
        String txt = "You enter a dark cave with the sound of the water in the distance and a loud thumping noise:";
        return txt;
    }

    @Override
    String sceneAction() {
        String txt = "Start your amazing adventure!";
        return txt;
    }
}
