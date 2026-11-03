package RenameMe.Dice;

import java.util.Iterator;

public class RandomDoubleDiceShaker extends AbstractRandomDiceShaker {

    @Override
    public Iterator<Integer> iterator() {
        return new RandomDoubleDiceIterator();
    }

    private class RandomDoubleDiceIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return shakeSingleDie() + shakeSingleDie();
        }
    }
}
