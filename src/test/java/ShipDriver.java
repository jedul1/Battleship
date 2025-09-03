/**
 * Test code for com.Battleship.Ship Class
 */
import com.Battleship.Ship;

import java.util.ArrayList;
import java.util.Random;

public class ShipDriver {
    static Ship battleship = new Ship("TestShip", 5);
    public static void main(String[] args) {
        testAdd();
        testCheckGuess();
    }

    /**
     * Tests the addElement() method in the Ship class. Elements A0 - J9 (case insensitive) are the only allowed elements.
     * The method addElement() should return false for any invalid element attempted to be added.
     */
    private static void testAdd() {
        ArrayList<String> test = new ArrayList<>();
        test.add("A0");
        test.add("a0");
        test.add("C4");
        test.add("c4");
        test.add("Y3");
        test.add(null);
        for (String testString : test) {
            try {
                assert battleship.addElement(testString) : "Didn't add element: " + testString + ". Null entry or pattern does not match";
            } catch (AssertionError e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Validates the correct functionality of the checkGuess() method in Ship class.
     * Verifies that a 1 value is returned from checkGuess() method when an element is in the battleship array.
     * Verifies that a 0 value is returned from checkGuess() method when an element is in the battleship array.
     * The -1 return value of checkGuess() is contingent on the private isValid() method in Ship class which proves to
     * function correctly from the above testAdd() method, so there is no need to verify a value of -1 in this method.
     */
    private static void testCheckGuess() {
        ArrayList<String> boardPositions = new ArrayList<>();
        String element;
        Random rand = new Random();
        int i;
        // boardPositions to be in the array
        while (boardPositions.size() <= 5) {
            i = rand.nextInt(10); // Generates random letter from A-J
            element = Character.toString(i + 65) + rand.nextInt(10); // Generates a random alphanumeric element from A-J and digit 0-9
            boardPositions.add(element); // Only board  positions ranging from A0 - J9 should be added
        }
        // Check if the expected int value is returned based on the position guess being
        // in the array and if it is a valid guess
        System.out.println("Board position array:\n" + boardPositions);
        System.out.println("Checking that the correct value (1) returns for each element in the array...");
        battleship.setBattleship(boardPositions);
        boolean successful = true;
        for (String position : boardPositions) {
            try {
                System.out.println("Checking if " + position + " is in the array");
                assert battleship.checkGuess(position) == 1 : "The checkGuess() method is returning an incorrect value. " +
                        "Objects that are in the battleship list should  return a value of 1. " + position +
                        " is said to be not found (value of 0) or invalid (value of -1).";
            } catch (AssertionError e) {
                System.out.println("Error: " + e.getMessage());
                successful = false;
            }
        }
        if (successful) {
            System.out.println("checkGuess() method successfully returned value of 1 for all of its existing values.");
        }
        System.out.println("Board position array:\n" + boardPositions);
        System.out.println("Checking that the correct value (0) returns for each element NOT in the array...");
        for (int j = 0; j < 5; j++) {
            // Creates a low threshold of K0 to upper threshold of Z9, which are invalid array entries
            String position = Character.toString(rand.nextInt(16) + 75) + rand.nextInt(10);
            try {
                System.out.println("Checking if " + position + " is in the array.");
                assert battleship.checkGuess(position) == 0 || battleship.checkGuess(position) == -1: "The board position: " + position +
                        " is said to be found in the array (value of 1), but should be a value of 0.";
            } catch (AssertionError e) {
                System.out.println("Error: " + e.getMessage());
                successful = false;
            }
        }
        if (successful) {
            System.out.println("checkGuess() method successfully returned a value of 0 for all values.");
        }
    }

}
