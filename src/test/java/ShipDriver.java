/**
 * Test code for com.Battleship.Ship Class
 */
import com.Battleship.Ship;

import java.util.ArrayList;

public class ShipDriver {
    static Ship battleship = new Ship("TestShip", 5);
    public static void main(String[] args) {
        testAdd();
    }

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

}
