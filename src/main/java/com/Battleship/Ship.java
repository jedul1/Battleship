package com.Battleship;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ship {

    private ArrayList<String> battleship;
    private String name;
    private int size;


    public Ship(String name, int size) {
        if (name != null && size >= 1) {
            this.battleship = new ArrayList<>(size);
            this.name = name;
            this.size = size;
        }
    }

    public String getName() {
        return new String(name);
    }

    public int getSize() {
        return size;
    }

    /**
     * Determines whether a ship is sunken
     * @return true if the battleship ArrayList is empty
     */
    public boolean isSunken() {
        return battleship.isEmpty();
    }

    /**
     * Determines if the player's guess is a hit or miss.
     * @param guess the player's guess
     * @return 1 if the player's guess is in the list
     */
    // not optimized because requires linear search for guess -- but the
    // list itself will never be more than 6 elements. Ideally use a HashMap.
    public int checkGuess(String guess) {
        if (isValid(guess)) {
            if (battleship.remove(guess)) { // removes item and checks if item is there at once.
                // If the item is not there, condition is false.
                return 1;
            } else {
                return 0;
            }
        } return -1; // invalid guess
    }

    // This method is primarily used for testing
    public boolean addElement(String e) {
        if (isValid(e)) {
            return battleship.add(e);
        }
        return false;
    }

    private boolean isValid(String guess) {
        if (guess != null) {
            String regex = "[a-jA-J]\\d";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(guess);
            return matcher.matches();
        }
        return false;
    }

    @Override
    public String toString() {
        return "com.Battleship.Ship Name: " + name + "\n Size: " + size + "\n" + battleship.toString();
    }
}
