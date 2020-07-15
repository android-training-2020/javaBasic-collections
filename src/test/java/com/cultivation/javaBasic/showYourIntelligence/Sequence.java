package com.cultivation.javaBasic.showYourIntelligence;

import java.util.Iterator;

public class Sequence implements Iterable<Integer> {
    private final Integer start;
    private final Integer end;

    public Sequence(Integer start, Integer end) {
        if (start >= end) { throw new IllegalArgumentException("Start must be smaller than End."); }
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SequenceIterator(start, end);
    }
}

class SequenceIterator implements Iterator<Integer> {
    private Integer start;
    private Integer end;
    SequenceIterator(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return this.start < this.end;
    }

    @Override
    public Integer next() {
        Integer original = start;
        this.start = this.start + 1;
        return original;
    }
}
