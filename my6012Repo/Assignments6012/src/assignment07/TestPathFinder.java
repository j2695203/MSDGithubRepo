package assignment07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class TestPathFinder {

  public static void main(String[] args) throws IOException {

    /*
     * The below code assumes you have a file "tinyMaze.txt" in your project folder.
     * If PathFinder.solveMaze is implemented, it will create a file "tinyMazeOutput.txt" in your project folder.
     * 
     * REMEMBER - You have to refresh your project to see the output file in your package explorer. 
     * You are still required to make JUnit tests...just lookin' at text files ain't gonna fly. 
     */

    PathFinder.solveMaze("mazes/tinyMaze.txt", "mazes/tinyMazeOutput.txt");

  }

  @BeforeEach
  void setUp() throws IOException {
    PathFinder.solveMaze("mazes/bigMaze.txt", "mazes/bigMazeOutput.txt");
    PathFinder.solveMaze("mazes/classic.txt", "mazes/classicOutput.txt");
    PathFinder.solveMaze("mazes/demoMaze.txt", "mazes/demoMazeOutput.txt");
    PathFinder.solveMaze("mazes/mediumMaze.txt", "mazes/mediumMazeOutput.txt");
    PathFinder.solveMaze("mazes/randomMaze.txt", "mazes/randomMazeOutput.txt");
    PathFinder.solveMaze("mazes/straight.txt", "mazes/straightOutput.txt");
    PathFinder.solveMaze("mazes/tinyMaze.txt", "mazes/tinyMazeOutput.txt");
    PathFinder.solveMaze("mazes/tinyOpen.txt", "mazes/tinyOpenOutput.txt");
    PathFinder.solveMaze("mazes/turn.txt", "mazes/turnOutput.txt");
    PathFinder.solveMaze("mazes/unsolvable.txt", "mazes/unsolvableOutput.txt");
  }

  @Test
  void testDot() throws FileNotFoundException {
    assertEquals(getDot("mazes/bigMazeOutput.txt"), getDot("mazes/bigMazeSol.txt"));
    assertEquals(getDot("mazes/classicOutput.txt"), getDot("mazes/classicSol.txt"));
    assertEquals(getDot("mazes/demoMazeOutput.txt"), getDot("mazes/demoMazeSol.txt"));
    assertEquals(getDot("mazes/mediumMazeOutput.txt"), getDot("mazes/mediumMazeSol.txt"));
    assertEquals(getDot("mazes/randomMazeOutput.txt"), getDot("mazes/randomMazeSol.txt"));
    assertEquals(getDot("mazes/straightOutput.txt"), getDot("mazes/straightSol.txt"));
    assertEquals(getDot("mazes/tinyMazeOutput.txt"), getDot("mazes/tinyMazeSol.txt"));
    assertEquals(getDot("mazes/tinyOpenOutput.txt"), getDot("mazes/tinyOpenSol.txt"));
    assertEquals(getDot("mazes/turnOutput.txt"), getDot("mazes/turnSol.txt"));
    assertEquals(getDot("mazes/unsolvableOutput.txt"), getDot("mazes/unsolvableSol.txt"));

  }

  /**
   * Get the number of dots in a file.
   * @param inputFile filename
   * @return number of dots
   * @throws FileNotFoundException fails on reading file
   */
  int getDot(String inputFile) throws FileNotFoundException {

    int numDot = 0;

    FileReader mazeFile = new FileReader(inputFile);
    Scanner sc = new Scanner(mazeFile);

    while(sc.hasNext()){
      String str = sc.nextLine();
      for( int i = 0; i < str.length(); i++ ){
        if( str.charAt(i) == '.'){
          numDot++;
        }
      }
    }
    return numDot;
  }


}

