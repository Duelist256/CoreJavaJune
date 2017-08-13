package day170809.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dictionary<K, V> implements Iterable<Dictionary.Pair> {

    private static final int MAX = 3;

    public static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Pair>[] data = new List[MAX];

    private int hash(K key) {
        return key.hashCode() & 0x7FFFFFFF % data.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (data[index] == null) {
            data[index] = new ArrayList<>();
        }

        Pair pair = getPair(key);

        if (pair == null) {
            data[index].add(new Pair<>(key, value));
            return;
        }

        pair.value = value;

    }

    public V get(K key) {
        Pair pair = getPair(key);
        return pair == null ? null : (V) pair.value;
    }

    private Pair getPair(K key) {
        int index = hash(key);
        List<Pair> list = data[index];

        if (list == null) { // guard condition
            return null;
        }

        for (Pair pair : list) {
            if (pair.key.equals(key)) {
                return pair;
            }
        }

        return null;
    }

    @Override
    public Iterator<Pair> iterator() {
        return new Iterator<Dictionary.Pair>() {
            int currentElement = -1;
            Iterator<Pair> listIterator = null;

            @Override
            public boolean hasNext() {

                if (listIterator != null && listIterator.hasNext()) {
                    return true;
                }

                listIterator = null;

                for (++currentElement; listIterator == null
                        && currentElement < data.length; currentElement++) {
                    List<Pair> list = data[currentElement];
                    if (list == null) {
                        continue;
                    }
                    listIterator = list.iterator();
                    if (!listIterator.hasNext()) {
                        continue;
                    }
                    return listIterator.hasNext();
                }

                return false;
            }

            @Override
            public Pair next() {
                if (!hasNext()) {
                    throw new IllegalArgumentException();
                }
                return listIterator.next();
            }
        };
    }
}