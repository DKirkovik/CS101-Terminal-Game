import scenes.*;
import player.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player newPlayer = new Player(0, new ArrayList<>());
        Scene start = null;
        Scene activeScene;
        ArrayList<Scene> empty = new ArrayList<>();
 5
        try {
            start = new StartScene(
                    new ArrayList<Scene>(Arrays.asList(
                            new CaveScene(
                                    new ArrayList<Scene>(Arrays.asList(
                                            new DragonScene(new ArrayList<Scene>(Arrays.asList(
                                                    new DragonDeathScene(new ArrayList<Scene>(Arrays.asList())),
                                                    new DragonVictoryScene(new ArrayList<Scene>(Arrays.asList()))
                                            ))),
                                            new CliffScene(new ArrayList<Scene>(Arrays.asList(
                                                    new CliffDeathScene(new ArrayList<Scene>(Arrays.asList())),
                                                    new CliffVictoryScene(new ArrayList<Scene>(Arrays.asList()))
                                            )))
                                    ))
                            ))
                    )
            );
            activeScene = start;

            while (!activeScene.isEndScene()) {
                System.out.println(activeScene);
                Scanner scan = new Scanner(System.in);
                int input = scan.nextInt();
                try {
                    activeScene = activeScene.handleInput(input);
                    newPlayer.setPosition(input);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Not a valid input, choose again!");
                }
            }

            System.out.println(activeScene);
            System.out.println(newPlayer);
            System.out.println("Your path was: ");
            for (Integer pos : newPlayer.getPositions()) {
                System.out.print(pos + " ");
            }


        } catch (PathsCantBeEmptyException e) {
            System.out.println("Some of the scene has nulls");
        }

    }
}
