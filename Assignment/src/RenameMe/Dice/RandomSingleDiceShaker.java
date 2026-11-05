package RenameMe.Dice;

import java.util.Iterator;

public class RandomSingleDiceShaker extends AbstractRandomDiceShaker {

    @Override
    public Iterator<Integer> iterator() {
        return new RandomSingleDiceIterator();
    }

    private class RandomSingleDiceIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return shakeSingleDie();
        }
    }
}