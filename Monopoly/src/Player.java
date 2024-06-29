//name: Thaphat Jirametharat
//ID  : 6510450453
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Board board;
    private final Piece piece;
    private final List<Die> dice;

    public Player(String name, List<Die> dice, Board board) {
        this.name = name;
        this.board = board;
        this.dice = new ArrayList<>(dice);
        this.piece = new Piece(board.getStartSquare());
    }

    public int takeTurn() {
        int total = rollDice();

        Square oldLoc = piece.getLocation();
        Square newLoc = board.getSquare(oldLoc, total);
        piece.setLocation(newLoc);

        System.out.println(name + " moves " + total + " spaces.");
        System.out.println(name + " moved from " + oldLoc.getLocation() + " to " + newLoc.getLocation() + " (" + newLoc.getName() + ").");
        System.out.println();

        return total;
    }

    private int rollDice() {
        int total = 0;
        for (Die die : dice) {
            die.roll();
            total += die.getFaceValue();
        }
        return total;
    }

    public String getName() {
        return name;
    }

}
