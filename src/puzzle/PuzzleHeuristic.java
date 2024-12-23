package puzzle;

public class PuzzleHeuristic implements Comparable<PuzzleHeuristic>{
    public Puzzle puzzle;
    public int heuristic;
    public int totalcost = 0;

    public PuzzleHeuristic(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public int compareTo(PuzzleHeuristic o) {
        return Integer.compare(heuristic + totalcost, o.heuristic + o.totalcost);
    }

    public void calculateHeuristicDisplacedTiles(){
        int displacedTiles = 0;
        for ( int i = 0; i < 3; i++){
            for(int j = 0; j<3; j++){
                if(puzzle.getTable().get(i).get(j) != (i * 3) + j) displacedTiles++;
            }
        }
        heuristic = displacedTiles;
    }

    public void calculateHeuristicManhattanDistance(){
        int manhattanDistance = 0;
        for ( int i = 0; i < 3; i++){
            for(int j = 0; j<3; j++){
                int value = puzzle.getTable().get(i).get(j);
                manhattanDistance += Math.abs((value % 3) -j) + Math.abs((value / 3) - i);
            }
        }
        heuristic = manhattanDistance;
    }
}
