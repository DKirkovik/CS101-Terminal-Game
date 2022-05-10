package scenes;

import java.util.ArrayList;

public class DragonScene extends Scene {
    public DragonScene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        super(paths);
    }

    @Override
    String welcomeText() {
        String txt = "You enter a huge cavern with a giant Dragon snoring loudly! \n Around him are piles of gold and gems!";
        return txt;
    }

    @Override
    String sceneAction() {
        String action = "Go the the weird thumping noise!";
        return action;
    }

}
