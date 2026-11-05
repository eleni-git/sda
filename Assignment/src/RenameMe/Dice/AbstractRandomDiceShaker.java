package RenameMe.Dice;

import RenameMe.DiceShaker;
import java.util.Random;

public abstract class AbstractRandomDiceShaker implements DiceShaker {
    protected final Random random = new Random();

    protected int shakeSingleDie() {
        return random.nextInt(6) + 1;
    }
}
