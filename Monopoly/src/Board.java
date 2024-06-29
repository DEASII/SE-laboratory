//name: Thaphat Jirametharat
//ID  : 6510450453
import java.util.ArrayList;

public class Board {
    private final ArrayList<Square> squares;
    public static final int BOARD_SIZE = 30;

    public Board() {
        squares = new ArrayList<>();
        String[] squareNames = {
                "United States", "Canada", "Mexico", "Brazil", "Argentina",
                "United Kingdom", "France", "Germany", "Italy", "Spain",
                "Russia", "China", "Japan", "India", "Australia",
                "South Africa", "Nigeria", "Egypt", "Saudi Arabia", "Turkey",
                "South Korea", "Indonesia", "Thailand", "Vietnam", "Chile",
                "Peru", "Ukraine", "Sweden", "Norway", "Switzerland"
        };

        for (int i = 0; i < BOARD_SIZE; i++) {
            squares.add(new Square(i, squareNames[i]));
        }
    }

    public Square getSquare(Square current, int move) {
        int newIndex = (current.getLocation() + move) % BOARD_SIZE;
        return squares.get(newIndex);
    }

    public Square getStartSquare() {
        return squares.get(0);
    }
}
