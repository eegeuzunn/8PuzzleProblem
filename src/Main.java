import puzzle.Puzzle;
import puzzle.PuzzleGenerator;
import searchAlgorithms.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Puzzle goal = new Puzzle(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(0, 1, 2)),
                        new ArrayList<>(List.of(3, 4, 5)),
                        new ArrayList<>(List.of(6, 7, 8))
                ))
        );


        System.out.println("\nCREATED PUZZLE \n");
        Puzzle puzzle = PuzzleGenerator.generatePuzzle();
        System.out.println(puzzle.getTable().get(0) + "\n" + puzzle.getTable().get(1) + "\n" + puzzle.getTable().get(2));

        System.out.println("\n ------------------------------- \n");

        long startTime = System.nanoTime();
        System.out.println("GREEDY SEARCH (Manhattan Distance) RUNNING");
        GreedySearch.searchWithManhattanDistance(puzzle, goal);

        long endTime = System.nanoTime();
        System.out.println("Time to run greedy search: " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");

        startTime = System.nanoTime();
        System.out.println("GREEDY SEARCH (Displaced Tiles) RUNNING");
        GreedySearch.searchWithDisplacedTiles(puzzle, goal);

        endTime = System.nanoTime();
        System.out.println("Time to run greedy search: " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");

        startTime = System.nanoTime();
        System.out.println("A* (Manhattan Distance) RUNNING");
        AStar.searchWithManhattanDistance(puzzle, goal);

        endTime = System.nanoTime();
        System.out.println("Time to run A*: " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");

        startTime = System.nanoTime();
        System.out.println("A* (Displaced Tiles) RUNNING");
        AStar.searchWithDisplacedTiles(puzzle, goal);

        endTime = System.nanoTime();
        System.out.println("Time to run greedy search: " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");



        /*
        long startTime = System.nanoTime();
        System.out.println("BFS RUNNING");

        Bfs.search(puzzle, goal);

        long endTime = System.nanoTime();
        System.out.println("Time to run bfs(Breadth First Search): " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");

        startTime = System.nanoTime();
        System.out.println("DFS RUNNING");

        Dfs.search(puzzle, goal);

        endTime = System.nanoTime();
        System.out.println("Time to run dfs(Depth First Search): " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");

        startTime = System.nanoTime();
        System.out.println("DLS RUNNING");

        Dls.search(puzzle, goal,10);
        endTime = System.nanoTime();
        System.out.println("Time to run dls(Depth Limited Search): " + ( endTime - startTime ) / 1000000 + "ms");

        System.out.println("\n ------------------------------- \n");

        startTime = System.nanoTime();
        System.out.println("IDS RUNNING");

        Ids.search(puzzle, goal,10);

        endTime = System.nanoTime();
        System.out.println("Time to run ids(Iterative Depth Search): " + ( endTime - startTime ) / 1000000 + "ms");
        */
    }
}