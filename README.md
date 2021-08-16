# Polish draughts

## Story

Your best friend Tom is board games lover, and he plays checkers all the time like a pro.
Recently, he is really into digital versions of his favorite games,
but unfortunately he cannot find any implementation of the Polish Draughts.
Give Tom your console version of this game.

In this project, your job is to implement a variation of [Polish draughts](https://en.wikipedia.org/wiki/International_draughts) for two players.
You also can try writing some AI to play the game.

Main rules:
- There are two players with white and black pawns. White moves first.
- The size of the board can be picked before the game starts, but it must be an integer between 10 and 20.
- All moves and captures are made diagonally.
- Pawns can also capture backward.

Optional rules:
- Multiple successive jumps forward or backward in a single turn can and must be made if there is an unoccupied square
immediately beyond the enemy pawn after each jump.
- A piece is crowned if it stops on the far edge of the board at the end of its turn (that is, if it reaches the edge, and is not required to
jump backward).

Winning and draws:
- A player with no valid moves remaining loses.
- Optional: The game is considered a draw when the same position repeats itself for the third time
(not necessarily consecutive), with the same player having the move each time.
- A king-versus-king endgame is automatically declared a draw.

## What are you going to learn?

- variables
- methods
- loops and conditionals
- classes and instances
- print formatting
- user input validation
- edge case handling
- access modifiers
- OOP

## Tasks

1. There is a `Board` class that represents the square board of Polish draughts.
    - There is an `n` parameter in the constructor that specifies the side length of the square. The size must be an integer between 10 and 20. It is provided as user input.
    - There is a `Pawn[][] fields` 2D array that represents fields on a board. Each field can be `null` (empty) or a `Pawn` instance.
    - Pawns are created and placed on every other field when the board is initialized. Their number is determined by board size, as a `2 * n`.
    - There is a `toString()` method that overrides the built-in method. This method marks rows as numbers and columns as letters.
    - There is a `removePawn()` method that removes pawns from the specified position.
    - There is a `movePawn()` method that moves pawns from a specified position to another field.

2. There is a `Pawn` class.
    - There is a `Color getColor()` method that returns the color of the the pawn(white or black).
    - There is a field of the `Coordinates position` class that represents pawn coordinates on a board. The `Coordinates` class has two fields, `int x` and `int y`.
    - [Extra] There is `boolean isCrowned` field that returns `true` if a pawn is crowned.
    - The `Pawn` class contains a method that validates the move (whether it is within the game rules) before it is performed.
    - [Extra] The `Pawn` class can check if the pawn can make multiple jumps according to the rules.

3. There is a `Game` class that contains all game logic and actions.
    - There is a `start()` method that starts game between players.
    - There is a method `playRound()` that determines one-round actions that is, checks which player is next and whether there is a winner.
    - There is a method that checks if the starting position from user input is a valid pawn and if the ending position is within board boundaries. If so, it calls `tryToMakeMove()` on pawn instance.
    - There is a `checkForWinner()` method that checks whether there is a winner after each round.
    - The `checkForWinner()` method also checks for draws.

4. [OPTIONAL] Try to implement the singleton pattern. Try to implement additional features such as crowning, multi-jumping, and checking for draw.
    - The `Board` is a singleton, so it can have only one instance.
    - The Crowned feature is implemented. There is a property on `Pawn` called `boolean isCrowned` that returns `true` if a pawn is crowned and it implements crowning rules.
    - The `Pawn` class can check if it can make multiple jumps according to the rules.

## General requirements

- The board is completely redrawn in the console after each move.
- If the input is invalid, the program asks for input repeatedly, until it receives a valid value.

## Hints

- Try implementing regular draughts rules and moves at first, then expand once your first code works.
- You can use the [Singleton Design Pattern](https://refactoring.guru/design-patterns/singleton/java/example) to create only one board instance.
- You can try converting user input letters from chars to integers.
[ASCII TABLE](https://upload.wikimedia.org/wikipedia/commons/1/1b/ASCII-Table-wide.svg) may help you with this.


## Background materials

- <i class="far fa-exclamation"></i> [Fields](http://tutorials.jenkov.com/java/fields.html)
- <i class="far fa-exclamation"></i> [Methods](https://www.w3schools.com/java/java_methods.asp)
- <i class="far fa-exclamation"></i> [Types in Java](https://www.w3schools.com/java/java_data_types.asp)
- <i class="far fa-exclamation"></i> [Clean Code in Java](https://www.baeldung.com/java-clean-code)
- <i class="far fa-exclamation"></i> [Singleton Design Pattern](https://www.geeksforgeeks.org/singleton-class-java/)
- <i class="far fa-exclamation"></i> [Access Modifiers](https://www.javatpoint.com/access-modifiers)

