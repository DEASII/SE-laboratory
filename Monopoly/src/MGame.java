//name: Thaphat Jirametharat
//ID  : 6510450453
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MGame {
    private static final int PLAYER_COUNT = 8;
    private final int gameRounds = 10;
    public final int diceCount = 2;

    private ArrayList<Player> players;
    private int currentRound;
    private Scanner scanner;

    public MGame() {
        currentRound = 0;
        players = new ArrayList<>();
        scanner = new Scanner(System.in);

        setupGame();
    }

    private void setupGame() {
        Board board = new Board();
        List<Die> dice = new ArrayList<>();

        for (int i = 0; i < diceCount; i++) {
            dice.add(new Die());
        }

        int playerCount = getNumberOfPlayers();
        getPlayerNames(playerCount, dice, board);
    }
    private int getNumberOfPlayers() {
        int playerCount = 0;
        while (playerCount < 2 || playerCount > PLAYER_COUNT) {
            System.out.print("Enter number of players (2-" + PLAYER_COUNT + "): ");
            playerCount = scanner.nextInt();
            scanner.nextLine();

            if (playerCount < 2 || playerCount > PLAYER_COUNT) {
                System.out.println("Invalid input. Please enter a number between 2 and " + PLAYER_COUNT + ".");
            }
        }
        return playerCount;
    }

    private void getPlayerNames(int playerCount, List<Die> dice, Board board) {
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name, dice, board));
        }
    }

    private void playRound() {
        System.out.println("-".repeat(12) + " Round " + (currentRound + 1) + " " + "-".repeat(12));

        Scanner press = new Scanner(System.in);
        for (Player player : players) {
            System.out.print(player.getName() + ", press 'Enter' to roll: ");
            press.nextLine();
            player.takeTurn();
        }
    }

    public void playGame() {
        while (currentRound < gameRounds) {
            playRound();
            currentRound++;
        }
    }

}
