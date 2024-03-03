package tdd;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalInt;

public class CircularListImplementation implements CircularList{

    private ArrayList<Integer> circularList;
    private int actual_index;
    private static int SHIFT_INDEX_VALUE = 1;
    private static int START_INDEX_VALUE = 0;

    public CircularListImplementation() {
        this.circularList = new ArrayList<Integer>();
        this.actual_index = START_INDEX_VALUE;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> next_element = this.size() > SHIFT_INDEX_VALUE ? Optional.of(circularList.get(this.getNextIndex())) : Optional.of(circularList.get(actual_index));
        this.setActualIndex(true);
        
        return next_element;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> previous_element = this.size() != START_INDEX_VALUE ? Optional.of(circularList.get(this.getPreviousIndex())) : Optional.empty();
        this.setActualIndex(false);
        
        return previous_element;
    }

    @Override
    public void reset() {
        this.actual_index = 0;
    }

    private void setActualIndex(final boolean next) {
        int size = size();
        
        this.actual_index = next ? (this.actual_index + SHIFT_INDEX_VALUE) % size : (this.actual_index - SHIFT_INDEX_VALUE + size) % size;
    }

    private int getPreviousIndex() {
        return this.actual_index == START_INDEX_VALUE ? this.size() - SHIFT_INDEX_VALUE : this.actual_index - SHIFT_INDEX_VALUE;
    }
    
    private int getNextIndex() {
        return this.actual_index == this.size() - SHIFT_INDEX_VALUE ? START_INDEX_VALUE : this.actual_index + SHIFT_INDEX_VALUE;
    }
}
