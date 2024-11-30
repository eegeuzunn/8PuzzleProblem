package searchAlgorithms;

import puzzle.Puzzle;
import puzzle.PuzzleDepthPair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Ids {

    //Iterative Deepening Search

    public static int numberOfNodesExpanded;
    public static int numberOfFringeNodes;

    public static void search(Puzzle start, Puzzle goal, int maxDepth){
        int nodesExpanded = 0;
        int fringeNodes = 0;
        int limit = 0;

        while(limit <= maxDepth){

            var result = dlsSearch(start, goal, limit);
            nodesExpanded += numberOfNodesExpanded;
            fringeNodes += numberOfFringeNodes;

            if(result != null){
                ResultPrinter.print(result, nodesExpanded, fringeNodes);
                return;
            }

            limit++;
        }
        ResultPrinter.print(null, nodesExpanded, fringeNodes);
    }


    public static Puzzle dlsSearch(Puzzle start, Puzzle goal, int limit){
        numberOfNodesExpanded = 0;
        numberOfFringeNodes = 0;

        if( start.equals(goal)){
            ResultPrinter.print(start, numberOfNodesExpanded, numberOfFringeNodes);
            return start;
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

                    return current.puzzle;
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
        return null;
    }
}
