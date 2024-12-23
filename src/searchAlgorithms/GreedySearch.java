package searchAlgorithms;

import puzzle.Puzzle;
import puzzle.PuzzleHeuristic;

import java.util.HashSet;
import java.util.PriorityQueue;

public class GreedySearch {

    public static void searchWithDisplacedTiles(Puzzle puzzle, Puzzle target){
        PriorityQueue<PuzzleHeuristic> heap = new PriorityQueue<>();

        PuzzleHeuristic startNode = new PuzzleHeuristic(puzzle);
        startNode.calculateHeuristicDisplacedTiles();

        heap.add(startNode);
        int numberOfNodesExpanded = 0;
        long startTime = System.nanoTime();
        while(!heap.isEmpty()){
            long endTime = System.nanoTime();
            if(( endTime - startTime ) / 1000000 > 10000) {
                ResultPrinter.print(null, numberOfNodesExpanded, heap.size());
                return;
            }

            PuzzleHeuristic current = heap.poll();
            if(current.puzzle.equals(target)){
                ResultPrinter.print(current.puzzle, numberOfNodesExpanded, heap.size());
                return; //değerleri printlemeyi unutma
            }

            for(Puzzle move : current.puzzle.createMoves()){
                PuzzleHeuristic newMove = new PuzzleHeuristic(move);
                newMove.calculateHeuristicDisplacedTiles();
                heap.add(newMove);
            }
            numberOfNodesExpanded++;
        }
    }

    public static void searchWithManhattanDistance(Puzzle puzzle, Puzzle goal){

        PriorityQueue<PuzzleHeuristic> heap = new PriorityQueue<>();

        PuzzleHeuristic startNode = new PuzzleHeuristic(puzzle);
        startNode.calculateHeuristicManhattanDistance();

        heap.add(startNode);
        int numberOfNodesExpanded = 0;

        long startTime = System.nanoTime();
        while(!heap.isEmpty()){
            long endTime = System.nanoTime();
            if(( endTime - startTime ) / 1000000 > 10000) {
                ResultPrinter.print(null, numberOfNodesExpanded, heap.size());
                return;
            }

            PuzzleHeuristic node = heap.poll();
            if(node.puzzle.equals(goal)){
                ResultPrinter.print(node.puzzle, numberOfNodesExpanded, heap.size());
                return;
            }

            for( Puzzle move : node.puzzle.createMoves()){
                PuzzleHeuristic newMove = new PuzzleHeuristic(move);
                newMove.calculateHeuristicManhattanDistance();
                heap.add(newMove);
            }
            numberOfNodesExpanded++;
        }
    }
}
