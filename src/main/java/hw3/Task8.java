package hw3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class Task8 {
    public static class BackwardIterator<T> implements Iterator<T> {
        private final Collection<T> collection;
        private int currentIndex;

        public BackwardIterator(Collection<T> collection) {
            this.collection = collection;
            this.currentIndex = collection.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = getElementAtIndex(currentIndex);
            currentIndex--;
            return element;
        }

        private T getElementAtIndex(int index) {
            int i = 0;
            for (T element : collection) {
                if (i == index) {
                    return element;
                }
                i++;
            }
            throw new IndexOutOfBoundsException();
        }

        // Пример использования
        public void main(String[] args) {
            Collection<Integer> numbers = List.of(1, 2, 3);
            BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(numbers);

            while (backwardIterator.hasNext()) {
                System.out.println(backwardIterator.next());
            }
        }
    }
}
