package uy.edu.um.adt.hash;

import uy.edu.um.adt.linkedlist.MyList;

public interface MyHash<K extends Comparable<K>, V> {

    void put(K key, V value);

    void remove(K key);

    boolean contains(K key);

    V get(K key);

    int getSize();

    int getCapacity();
    public MyHashImpl.Entry<K, V>[] getTable();

    public K getKey();
    public V getValue();
}
