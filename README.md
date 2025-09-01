# Battleship
Terminal game application where the user enters in guesses on a game board to sink the ships.

## Objective
The objective of the game is to sink all of the battleships on the game board. Upon the start of the game, a game board will be created and displayed. The game board is a default 5x5 game board or the user can specify a custom game board up to 10x10. Anything above 5x5 or 10x10 will not be accepted. The program will then ask the player to enter a guess of a grid location of where a battleship (or a portion of a battle ship) may be located. For example, on a 5x5 game board, the program will prompt the user to "Enter a position from A0 to E4".

### Game Set-Up
The battleships will be randomly positioned horizontally or vertically and the length of the ships will be anywhere from 1 grid unit to the integer division quotient of the game board magnitude divided by 2, plus 1. For instance, on the default game board magnitude of 5, the integer division quotient of 5 / 2 would be 2 (not 2.5). Then 2 + 1 = 3, making the range of the length of battleships being anywhere from 1 to 3 grid units. In the case of the largest game board (magnitude of 10), this would make the range of a battleship's length anywhere from 1 to 6.

The samw integer division formula is used to calculate the number of ships on a board. For a board with a magnitude of 5, the number of ships will be 3; for a magnitude of 10, the number of ships will be 6.

### During the Game
If there is a ship located at the position the user guessed, the program will specify "Hit", which should give the player a clue of where another portion of the ship may be located. If the player's guess was the last portion of the ship, that hit would result in a "A ship has been sunken". If the player's guess was in a location where there is no ship, the game will say "Miss". Finally, if the player enters an invalid guess, the program will specify it. Each guess, the game will remind the player what a valid guess is (case insensitive).

### Game Completion
The game will loop continually until all the ships have been sunken, then the program will terminate.

## Starting the game
The main method for the game is in the Game.java file. On a terminal, enter:
```
javac Game.java
java Game
```
and the game will start.

Have fun!


