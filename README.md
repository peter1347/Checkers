# Checkers
CONTROLS: type move in this format

piece you want to move file(in letter)
piece you want to move file(in number)
where you want to move it rank and fil (number/letter)

EXAMPLE
a3b4(moves peice on a3 to b4)

Simple Console based checkers

MISSING: double capture and forced capture

no win condition/scoring system

 also need to throw exceptions for when users input invalid control because right now the program just ends if you misinput

 Also would like to add a save/load feature to save games in progress (COMPLETED)



known bugs: can jump out of bounds 

## purpose for each file
* printboard converts the board[][] array (which consistes of 0's 1's 2' 10's and 20's: 0 is empty, 1 is player1's piece, 2 is player2's peice, 10 is player1's king and 20 is player2's king) into the graphics displayed in the console

* setup is a simple algorithim to generate the defal starting positions

* spotcolor determins if a square is white or black, this is used by the printboard class to determine what color an empty square is

* Main is the main, and contains all the game logic and controls.


##### By: Peter Edde
https://github.com/peter1347/Checkers#readme



