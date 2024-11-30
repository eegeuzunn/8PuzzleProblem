package searchAlgorithms;
import puzzle.Puzzle;
import java.util.*;

public class Bfs {
    //Breadth First Search

    public static void search(Puzzle start, Puzzle goal){

        int numberOfNodesExpanded = 0;
        int numberOfFringeNodes = 0;

        Queue<Puzzle> queue = new LinkedList<>();
        Set<Puzzle> visited = new HashSet<>();
        queue.add(start);

        if( start.equals(goal)){
            ResultPrinter.print(start, numberOfNodesExpanded, numberOfFringeNodes);
            return;
        }

        while(!queue.isEmpty()){
            Puzzle current = queue.poll();
            visited.add(current);

            var moves = current.createMoves();
            numberOfNodesExpanded++;

            for(Puzzle move : moves) {
                if(!visited.contains(move)){
                    if( move.equals(goal)){
                        numberOfFringeNodes = queue.size();
                        ResultPrinter.print(move, numberOfNodesExpanded, numberOfFringeNodes);
                        return;
                    } else{
                        queue.add(move);
                    }
                }
            }
        }
        ResultPrinter.print(null, numberOfNodesExpanded, numberOfFringeNodes);
    }


}
