package puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Puzzle {

    private List<List<Integer>> table;
    private int posOfZeroRow;
    private int posOfZeroColumn;

    public Puzzle(List<List<Integer>> table) {
        this.table = table;
        setZeroPos();
    }

    public void setZeroPos(){
        for (int i = 0; i < 3 ; i++){
            for(int j = 0; j < 3; j++){
                if (table.get(i).get(j) == 0)
                {
                    posOfZeroRow = i;
                    posOfZeroColumn = j;
                    return;
                }
            }
        }
    }

    public List<Puzzle> createMoves () {
        List<Puzzle> moves = new ArrayList<>();
        if(posOfZeroRow > 0) {
            Puzzle up = new Puzzle(new ArrayList<>(deepCopyTable(table)));
            up.swapNumbers(posOfZeroRow - 1, posOfZeroColumn);
            moves.add(up);
        }

        if(posOfZeroRow < 2) {
            Puzzle down = new Puzzle(new ArrayList<>(deepCopyTable(table)));
            down.swapNumbers(posOfZeroRow + 1, posOfZeroColumn);
            moves.add(down);
        }

        if(posOfZeroColumn > 0) {
            Puzzle left = new Puzzle(new ArrayList<>(deepCopyTable(table)));
            left.swapNumbers(posOfZeroRow, posOfZeroColumn - 1);
            moves.add(left);
        }

        if(posOfZeroColumn < 2) {
            Puzzle right = new Puzzle(new ArrayList<>(deepCopyTable(table)));
            right.swapNumbers(posOfZeroRow, posOfZeroColumn + 1);
            moves.add(right);
        }

        return moves;
    }

    private List<List<Integer>> deepCopyTable(List<List<Integer>> original) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> innerList : original) {
            copy.add(new ArrayList<>(innerList));
        }
        return copy;
    }

    //i and j is new position of zero. This will swap zero with the number in i,j position
    public void swapNumbers(int i, int j){
        int temp = table.get(i).get(j);
        table.get(i).set(j, 0);
        table.get(posOfZeroRow).set(posOfZeroColumn, temp);
    }


    public List<List<Integer>> getTable() {
        return table;
    }

    public void setTable(List<List<Integer>> table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puzzle puzzle = (Puzzle) o;
        return Objects.equals(table, puzzle.table);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(table);
    }


}
