package searchAlgorithms;

import puzzle.Puzzle;
import puzzle.PuzzleDepthPair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Dls {
    //Depth Limited Search

    public static void search(Puzzle start, Puzzle goal, int limit){
        int numberOfNodesExpanded = 0;
        int numberOfFringeNodes = 0;

        if( start.equals(goal)){
            ResultPrinter.print(start, numberOfNodesExpanded, numberOfFringeNodes);
            return;
        }

        Set<Puzzle> visited = new HashSet<>();
        Queue<PuzzleDepthPair> queue = new LinkedList<>();
        queue.add( new PuzzleDepthPair(start, 0));

        while(!queue.isEmpty()) {
            var current = queue.poll();
            visited.add(current.puzzle);

            if(current.depth <= limit ) {

                if(current.puzzle.equals(goal)){
                    numberOfFringeNodes = queue.size();
                    ResultPrinter.print(current.puzzle, numberOfNodesExpanded, numberOfFringeNodes);
                    return;
                }


                var moves = current.puzzle.createMoves();
                numberOfNodesExpanded++;
                for(Puzzle move : moves){
                    if(!visited.contains(move)){
                        queue.add(new PuzzleDepthPair(move, current.depth + 1));
                    }
                }
            }
        }
        ResultPrinter.print(null, numberOfNodesExpanded, numberOfFringeNodes);
    }
}
