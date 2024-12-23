package searchAlgorithms;

import puzzle.Puzzle;
import puzzle.PuzzleHeuristic;

import java.util.PriorityQueue;

public class AStar {

    public static void searchWithManhattanDistance(Puzzle puzzle, Puzzle goal) {

        PriorityQueue<PuzzleHeuristic> heap = new PriorityQueue<>();

        PuzzleHeuristic startNode = new PuzzleHeuristic(puzzle);
        startNode.calculateHeuristicManhattanDistance();

        heap.add(startNode);
        int numberOfNodesExpanded = 0;

        while (!heap.isEmpty()) {

            PuzzleHeuristic node = heap.poll();
            if (node.puzzle.equals(goal)) {
                ResultPrinter.print(node.puzzle, numberOfNodesExpanded, heap.size());
                return;
            }

            for (Puzzle move : node.puzzle.createMoves()) {
                PuzzleHeuristic newMove = new PuzzleHeuristic(move);
                newMove.calculateHeuristicManhattanDistance();
                newMove.totalcost = node.totalcost + 1;
                heap.add(newMove);
            }
            numberOfNodesExpanded++;
        }
    }

    public static void searchWithDisplacedTiles(Puzzle puzzle, Puzzle goal) {

        PriorityQueue<PuzzleHeuristic> heap = new PriorityQueue<>();

        PuzzleHeuristic startNode = new PuzzleHeuristic(puzzle);
        startNode.calculateHeuristicDisplacedTiles();

        heap.add(startNode);
        int numberOfNodesExpanded = 0;
        while (!heap.isEmpty()) {

            PuzzleHeuristic node = heap.poll();
            if (node.puzzle.equals(goal)) {
                ResultPrinter.print(node.puzzle, numberOfNodesExpanded, heap.size());
                return;
            }

            for (Puzzle move : node.puzzle.createMoves()) {
                PuzzleHeuristic newMove = new PuzzleHeuristic(move);
                newMove.calculateHeuristicDisplacedTiles();
                newMove.totalcost = node.totalcost + 1;
                heap.add(newMove);
            }
            numberOfNodesExpanded++;
        }


    }
}
