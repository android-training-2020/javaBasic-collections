package com.cultivation.javaBasic;

import com.cultivation.javaBasic.showYourIntelligence.DistinctIterable;
import com.cultivation.javaBasic.showYourIntelligence.Sequence;
import com.cultivation.javaBasic.util.RandomCharacterIterable;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CollectionsTest {
    @Test
    void should_go_through_an_iterator() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add("World");
        collection.add("!");
        Iterator<String> iterator = collection.iterator();

        assertIterableEquals(Arrays.asList("Hello", "World", "!"), createList(iterator));
    }

    @SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
    private static List<String> createList(Iterator<String> iterator) {
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list;
    }

    @Test
    void should_create_a_sequence_without_putting_all_items_into_memory() {
        Sequence sequence = new Sequence(4, 10);
        assertIterableEquals(Arrays.asList(4, 5, 6, 7, 8, 9), sequence);
    }

    @Test
    void should_predict_linked_list_operation_result() {
        LinkedList<String> staff = new LinkedList<>();

        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");

        ListIterator<String> iterator = staff.listIterator();
        iterator.next();
        iterator.add("Juliet");
        iterator.previous();
        iterator.remove();

        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        iterator.previous();
        iterator.remove();
        iterator.add("I");
        iterator.add("Don't");
        iterator.add("Know");
        final List<String> expected = Arrays.asList("I", "Don't", "Know");
        assertIterableEquals(expected, staff);
    }

    @Test
    void should_generate_distinct_sequence_on_the_fly() {
        // NOTE: This test may execute for a while. But it is okay if your impl is correct.
        final int oneGagaChars = 1024 * 1024 * 1024;
        RandomCharacterIterable characters = new RandomCharacterIterable(
            oneGagaChars,
            new Character[]{'a', 'b'});

        List<Character> distinct = new DistinctIterable<>(characters).toList();
        distinct.sort(Character::compareTo);

        assertIterableEquals(Arrays.asList('a', 'b'), distinct);
    }

    @Test
    void should_reflects_back_to_original_list_for_sub_range() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 12; ++i) {
            integers.add(i);
        }

        List<Integer> subList = integers.subList(3, 10);
        subList.clear();

        integers.subList(1, 5).clear();
        integers.add(0);
        integers.add(0);
        final List<Integer> expected = Arrays.asList(0, 0, 0);
        assertIterableEquals(expected, integers);
    }
}
