package scenes;

import java.util.ArrayList;

public abstract class Scene {

    protected ArrayList<Scene> paths;
    protected boolean isEndScene = false;
    protected boolean isStartScene = false;

    public Scene() {

    }

    public Scene(ArrayList<Scene> paths) throws PathsCantBeEmptyException {
        if (paths == null) {
            throw new PathsCantBeEmptyException();
        }
        this.paths = paths;

    }

    abstract String welcomeText();

    abstract String sceneAction();

    public void setStartScene(boolean startScene) {
        isStartScene = startScene;
    }

    public void setEndScene(boolean endScene) {
        isEndScene = endScene;
    }

    public boolean isEndScene() {
        return isEndScene;
    }

    public boolean isStartScene() {
        return isStartScene;
    }

    public Scene handleInput(int playerIndex) {
        int index = playerIndex - 1;
        if (index < 0 || index > paths.size() - 1) throw new ArrayIndexOutOfBoundsException();

        return paths.get(index);
    }

    public String toString() {
        String text = this.welcomeText() + "\n";

        for (int i = 0; i < this.paths.size(); i++) {
            Scene s = this.paths.get(i);
            if (s.sceneAction() != null) {
                text = text
                        .concat(String.format("%d: ", i + 1))
                        .concat(s.sceneAction())
                        .concat("\n");
            }
        }
        return text;
    }
}
