package sample;

import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Controller {

    public static final int NUM_COUNT = 4;
    public static final int NUM_BOUND = 10;
    private List<Integer> myNums = new ArrayList<>();
    public Spinner<Integer> userNum1;
    public Spinner<Integer> userNum2;
    public Spinner<Integer> userNum3;
    public Spinner<Integer> userNum4;
    public TableView<Turn> turnList;
    private int turnCounter;

    public void initialize() {

        var randomNumbers = new Random();
        while (myNums.size() < NUM_COUNT) {
            var random = randomNumbers.nextInt(NUM_BOUND);
            if (!myNums.contains(random)) {
                myNums.add(random);
            }
        }
        System.out.println(myNums);
    }

    public int countBulls(List<Integer> userNums) {

        int result = 0;

        for (int i = 0; i < 4; i++) {

            if (userNums.get(i).equals(myNums.get(i))) {
                result++;
            }
        }
        return result;
    }

    int countCows(List<Integer> userNums) {

        int result = 0;

        for (int i = 0; i < NUM_COUNT; i++) {
            for (int j = 0; j < NUM_COUNT; j++) {
                if (i == j){
                    continue;
                }
                if (myNums.get(i).equals(userNums.get(j))) {
                    result++;
                }
            }
        }
        return result;
    }

    public void doTurn() {
        turnCounter++;

        int n1 = userNum1.getValue();
        int n2 = userNum2.getValue();
        int n3 = userNum3.getValue();
        int n4 = userNum4.getValue();
        var guess = String.format("%d %d %d %d", n1, n2, n3, n4);

        var userNums = List.of(n1, n2, n3, n4);
        var bulls = countBulls(userNums);
        var cows = countCows(userNums);

        var turn = new Turn();
        turn.setUserGuess(guess);
        turn.setTurnNr(turnCounter);
        turn.setBulls(bulls);
        turn.setCows(cows);

        turnList.getItems().add(0, turn);
        turnList.sort();

    }
}