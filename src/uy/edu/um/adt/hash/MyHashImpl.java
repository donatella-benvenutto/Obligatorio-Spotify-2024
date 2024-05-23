package uy.edu.um.adt.hash;

public class MyHashImpl <K extends Comparable<K>, V> implements
        MyHash<K, V>{
    private static final int INITIAL_CAPACITY =  23;
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
        boolean containsFalse = true;
        int initialHash = hash;
        while (table[hash] != null && table[hash].key.compareTo(key) != 0) {

            hash = (hash + c * c) % capacity;
            c++;
            if (hash == initialHash) {
                containsFalse = false;
                break;// La tabla está llena y la clave no está presente
            }
        }
        if (table[hash] == null && !containsFalse && table[hash].key.compareTo(key) == 0) {
            return hash; // Devuelve el índice si la clave no está presente y no se ha completado un ciclo completo de búsqueda
        } else {
            return -1; // Devuelve -1 si la clave no está presente y se ha completado un ciclo completo de búsqueda
        }
    }

    @Override
    public void put(K key, V value){
        if ((double)size / capacity >= LOAD_FACTOR) {
            resize();
        }
        int hash = findIndex(key);
        if (hash != -1) {
            table[hash] = new Entry<>(key, value);
            size++;
        }

    }
    @Override
    public void remove(K key){
        int hash = findIndex(key);
        if (hash != -1) {
            table[hash] = null;
            size--;
        }

    }

    @Override
    public boolean contains(K key){
        int hash = findIndex(key);
        return hash != -1;
    }

    private void resize() {
        int newSize = capacity * 2;
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
        while (table[hash] != null && !table[hash].key.equals(key)) {
            hash = (hash + c*c) % SIZE;
            c++;
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

