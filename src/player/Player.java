package player;

import java.io.*;
import java.util.ArrayList;

public class Player {
    int curPosition;
    ArrayList<Integer> positions;

    enum Ending {
        GOOD(4),
        BAD(5),
        NEUTRAL(6);

        Ending(int i ){
        }
    }

    Ending finalEnd;
    String mainText;


    public Player(int newPos, ArrayList<Integer> pos) {
        this.curPosition = newPos;
        this.positions = pos;

    }

    public int getPosition() {
        return curPosition;
    }

    public ArrayList<Integer> getPositions() {
        return positions;
    }

    public void setPosition(int position) {
        this.curPosition = position;
        this.positions.add(position);
    }

    public void setEnding() {
        int finalPos = positions.get(positions.size() - 1);

        switch (finalPos) {
            case 2:
                finalEnd = Ending.GOOD;
                mainText = "Good ending";
                break;
            case 1:
                finalEnd = Ending.BAD;
                mainText = "Bad ending";
                break;
            default:
                finalEnd = Ending.NEUTRAL;
                mainText = "Neutral ending";
                break;

        }

    }

    void savePath() {
        try {
            PrintWriter writer = new PrintWriter("dataFiles/playerData.txt");
            for (int n : positions) {
                writer.print(n + " ");
            }
            writer.println();
            writer.println("Final end: ");
            writer.println(finalEnd);
            writer.println(mainText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        setEnding();
        savePath();

        return mainText;
    }
}
