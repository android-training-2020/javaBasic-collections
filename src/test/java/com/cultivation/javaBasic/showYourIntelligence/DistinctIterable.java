package com.cultivation.javaBasic.showYourIntelligence;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    private Set set = new HashSet();
    private final Iterator<E> iterator;

    DistinctIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.set.size() != 2;
    }

    @Override
    public E next() {
        int size = this.set.size();
        while (this.iterator.hasNext() && size < 2) {
            E element = this.iterator.next();
            this.set.add(element);
            if(this.set.size() > size) {
                return element;
            }
        }
        throw new NoSuchElementException();
    }
}
