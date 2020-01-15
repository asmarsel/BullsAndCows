package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Turn {

    private SimpleIntegerProperty turnNr = new SimpleIntegerProperty(this, "turnNr");
    private SimpleStringProperty userGuess = new SimpleStringProperty(this, "userGuess");
    private SimpleIntegerProperty bulls = new SimpleIntegerProperty(this, "bulls");
    private SimpleIntegerProperty cows = new SimpleIntegerProperty(this, "cows");

    public int getTurnNr() {
        return turnNr.get();
    }

    public SimpleIntegerProperty turnNrProperty() {
        return turnNr;
    }

    public void setTurnNr(int turnNr) {
        this.turnNr.set(turnNr);
    }

    public String getUserGuess() {
        return userGuess.get();
    }

    public SimpleStringProperty userGuessProperty() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess.set(userGuess);
    }

    public int getBulls() {
        return bulls.get();
    }

    public SimpleIntegerProperty bullsProperty() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls.set(bulls);
    }

    public int getCows() {
        return cows.get();
    }

    public SimpleIntegerProperty cowsProperty() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows.set(cows);
    }
}