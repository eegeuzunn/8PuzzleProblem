package searchAlgorithms;

import puzzle.Puzzle;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Dfs {

    public static void search(Puzzle start, Puzzle goal){
        int numberOfNodesExpanded = 0;
        int numberOfFringeNodes = 0;

        Stack<Puzzle> stack = new Stack<>();
        Set<Puzzle> visited = new HashSet<>();

        stack.push(start);

        if( start.equals(goal)){
            ResultPrinter.print(start, numberOfNodesExpanded, numberOfFringeNodes);
            return;
        }

        while(!stack.isEmpty()){
            Puzzle current = stack.pop();
            visited.add(current);

            var moves = current.createMoves();
            numberOfNodesExpanded++;

            for(Puzzle move : moves) {
                if(!visited.contains(move)){
                    if( move.equals(goal)){
                        numberOfFringeNodes = stack.size();
                        ResultPrinter.print(move, numberOfNodesExpanded, numberOfFringeNodes);
                        return;
                    } else{
                        stack.push(move);
                    }
                }
            }
        }
        ResultPrinter.print(null, numberOfNodesExpanded, numberOfFringeNodes);
    }
}
