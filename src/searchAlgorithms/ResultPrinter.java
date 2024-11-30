package searchAlgorithms;

import puzzle.Puzzle;

public class ResultPrinter {
    public static void print(Puzzle result , int numberOfNodesExpanded, int numberOfFringeNodes){
        if(result == null){
            System.out.println("No solution found");
        } else {
            System.out.println("Solution found");
            System.out.println(result.getTable().get(0) + "\n" + result.getTable().get(1) + "\n" + result.getTable().get(2));
        }

        System.out.println("Number of nodes expanded: " + numberOfNodesExpanded);
        System.out.println("Number of fringe nodes: " + numberOfFringeNodes);
    }
}
