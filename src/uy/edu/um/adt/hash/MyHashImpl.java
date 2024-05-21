package uy.edu.um.adt.hash;

public class MyHashImpl <K extends Comparable<K>, V> implements
        MyHash<K, V>{
    private static final int SIZE =  23;
    private MyHash<K, V>[] table = new MyHash[SIZE];

    static class MyHash<K, V> {
        final K key;
        V value;
        MyHash<K, V> next;

        MyHash(K key, V value, MyHash<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    @Override
    public void put(K key, V value){

    }
    @Override
    public void remove(K key){

    }

    @Override
    public boolean contains(K key){
        return false;
    }
    /*
    package uy.edu.um.adt.hash;

public class MyHashImpl<K extends Comparable<K>, V> implements MyHash<K, V> {
    private static final int SIZE = 23;
    private Entry<K, V>[] table = new Entry[SIZE];

    static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode() % SIZE;
        int c=1;
        while (table[hash] != null && table[hash].key.compareTo(key) != 0) {
            hash = (hash + c**2) % SIZE;
            c=+1;
        }
        table[hash] = new Entry<>(key, value);
    }

    @Override
    public void remove(K key) {
        int hash = key.hashCode() % SIZE;
        int c=1;
        while (table[hash] != null && table[hash].key.compareTo(key) != 0) {
            hash = (hash + c**2) % SIZE;
            c=+1;
        }
        if (table[hash] != null) {
            table[hash] = null;
        }
    }

    @Override
    public boolean contains(K key) {
        int hash = key.hashCode() % SIZE;
        int c=1;
        while (table[hash] != null && table[hash].key.compareTo(key) != 0) {
            hash = (hash + c**2) % SIZE;
            c=+1;
        }
        return table[hash] != null;
    }
}
    * */
}

