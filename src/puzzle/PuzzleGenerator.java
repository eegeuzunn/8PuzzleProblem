package puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleGenerator {

    public static Puzzle generatePuzzle(){
        List<Integer> numbers = new ArrayList<>(List.of(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8,}));
        Collections.shuffle(numbers);

        return new Puzzle(new ArrayList<>(List.of(
                new ArrayList<>(List.of(numbers.get(0), numbers.get(1), numbers.get(2))),
                new ArrayList<>(List.of(numbers.get(3), numbers.get(4), numbers.get(5))),
                new ArrayList<>(List.of(numbers.get(6), numbers.get(7), numbers.get(8)))
        )));
    }
}
