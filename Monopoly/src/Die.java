//name: Thaphat Jirametharat
//ID  : 6510450453
import java.util.Random;

public class Die {
    private final int maxFaceValue = 6;
    private int faceValue;
    private Random random;

    public Die() {
        random = new Random();
        roll();
    }

    public void roll() {
        faceValue = random.nextInt(maxFaceValue) + 1;

    }

    public int getFaceValue() {
        return faceValue;
    }

}
