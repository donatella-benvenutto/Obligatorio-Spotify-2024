package uy.edu.um.adt.hash;

import org.apache.commons.math3.primes.Primes;

public class MyHashImpl<K extends Comparable<K>, V> implements
        MyHash<K, V> {
    private static final int INITIAL_CAPACITY = 23;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;
    private int capacity;

    static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public void setTable(Entry<K, V>[] table) {
        this.table = table;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public MyHashImpl() {
        this.table = new Entry[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
    }

    public V get(K key) {
        int hash = findIndex(key);
        if (hash != -1 && table[hash] != null) {
            return table[hash].value;
        }
        return null;
    }

    private int findIndex(K key) {
        int hash = key.hashCode() % capacity;
        int c = 1;
        int initialHash = hash;
        int firstOccupiedPosition = -1;
        while (table[hash] != null) {
            if (table[hash].key.compareTo(key) == 0) {
                return hash; // Return the index if the key is present
            }
            if (firstOccupiedPosition == -1 && table[hash].key.compareTo(key) != 0) {
                firstOccupiedPosition = hash;
            }
            hash = (hash + c * c) % capacity;
            c++;
            if (hash == initialHash) {
                break; // La tabla está llena y la clave no está presente
            }
        }
        return firstOccupiedPosition != -1 ? firstOccupiedPosition : -1; //Devuelve -1 si la clave no está presente y se ha completado un ciclo completo de búsqueda o si el hash es vacío
    }

    @Override
    public void put(K key, V value) {
        if ((double) size / capacity > LOAD_FACTOR) {
            resize();
        }
        int hash = findIndex(key);
        if (hash != -1) {
            table[hash] = new Entry<>(key, value);
            size++;
        } else {
            table[key.hashCode() % capacity] = new Entry<>(key, value); // caso de hash vacío
            size++;
        }
    }

    @Override
    public void remove(K key) {
        int hash = findIndex(key);
        if (hash != -1) {
            table[hash] = null;
            size--;
        }

    }

    @Override
    public boolean contains(K key) {
        int hash = findIndex(key);
        return hash != -1;
    }

    private void resize() {
        int newSize = Primes.nextPrime(capacity * 2); // Calcula el siguiente número primo del doble del hash, así sigue siendo primo. Caso promedio es O(log(n)) peor caso es O(nlog(n)) según mí análisis de la documentación, lo cual como ya el resize de por sí es de O(n) consideramos que no afectará el rendimiento en general, ya que, solo es nlog(n) si n es par(lo q es imposible).
        Entry<K, V>[] newTable = new Entry[newSize];
        int newSizeCounter = 0; // Contador para rastrear el nuevo tamaño de la tabla

        // Rehash todos los elementos en la nueva tabla
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                K key = table[i].key;
                V value = table[i].value;
                int newHash = key.hashCode() % newSize;
                int c = 1;
                while (newTable[newHash] != null) {
                    newHash = (newHash + c * c) % newSize;
                    c++;
                }
                newTable[newHash] = new Entry<>(key, value);
                newSizeCounter++; // Incrementa el contador del nuevo tamaño
            }
        }
        // Actualiza la tabla hash y el tamaño
        table = newTable;
        size = newSizeCounter; // Actualiza el tamaño real de la tabla
        capacity = newSize;
    }
}