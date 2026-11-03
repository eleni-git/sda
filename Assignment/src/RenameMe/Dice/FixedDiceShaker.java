package RenameMe.Dice;

import RenameMe.DiceShaker;
import java.util.Iterator;

public class FixedDiceShaker  implements DiceShaker {
        private final int[] shakes;

        public FixedDiceShaker(int[] shakes) {
            this.shakes = shakes;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new FixedDiceIterator();
        }

        private class FixedDiceIterator implements Iterator<Integer> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < shakes.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more dice shakes left in the fixed sequence.");
                }
                return shakes[index++];
            }
        }
}
