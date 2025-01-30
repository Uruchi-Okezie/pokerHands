# Poker Hands Challenge
This project implements a poker hand evaluator in Java, allowing users to determine the ranking of poker hands and compare them to determine winners.

## High-Level Overview:
* The solution is a Java program for determining the winner of poker hands based on the rules of poker.
* It includes classes for representing cards, ranks of hands, and methods for evaluating and comparing hands.
* The program reads hands from a file, determines the rank of each hand, and compares them to find the winner.

## Functionality:
1. The HandValue class: Contains methods for evaluating the rank of a hand, such as checking for royal flush, straight flush, etc.
2. The Main class: Reads hands from a file, determines the ranks of each hand, and compares them to determine the winner.
3. Card Class: Represents a playing card with a value and a suit. Used to construct hands and perform comparisons.
4. DeckBuilder Class: Provides functionality for parsing hands from a text representation and organising them into appropriate data structures for evaluation.
5. Enum: The project includes an enum named Rank to represent the possible ranks of poker hands. Each rank is assigned a numerical value to facilitate comparisons. The enum provides clarity and maintainability by encapsulating the different hand ranks in the poker game.
## Testing:
  * Unit tests have been written for each method in the HandValue class to verify its correctness.
  * Test cases cover various hand combinations, including edge cases and boundary conditions.
  * Additional tests have been written for the DeckBuilder class to ensure proper parsing of hands from the input file.
  * All tests pass successfully, indicating that the implementation behaves as expected.


## Likes:
* The program accurately evaluates and compares poker hands according to the rules of the game.
* It provides modularity and extensibility through well-structured classes and methods.
* The use of enums and collections enhances readability and maintainability.

## Dislikes:
* Error handling could be improved to handle unexpected inputs or edge cases more gracefully.

## New Technologies or Approaches:
* The project utilizes Java Collections, such as Lists and Sets, for handling cards and hands efficiently.
* Enums are used to represent the ranks of poker hands, providing a structured and readable way to manage hand ranks.
* The project involves reading from files using Java I/O, which allows for processing input from external sources.

## Usage:
 Compile the Java files and ensure they are in the same directory.
Place a file named "poker.txt" containing poker hands in the specified format (e.g., "5H 5C 6S 7S KD 2C 3S 8S 8D TD") in the resources directory.
 Run the Main class to evaluate the poker hands and determine the winner.

## Author:
  Uruchi Okezie

