package uy.edu.um.adt.hash;

import static org.junit.Assert.*;

import org.junit.*;

public class HashImplTest {
    private static final int INITIAL_CAPACITY = 23;
    private static final double LOAD_FACTOR = 0.75;

    @Test
    public void testPutAndContains() {
        MyHashImpl<String, Integer> hash = new MyHashImpl<>();
        hash.put("A", 1);
        hash.put("B", 2);
        hash.put("C", 3);
        assertTrue(hash.contains("A"));
        assertTrue(hash.contains("B"));
        assertTrue(hash.contains("C"));
        assertFalse(hash.contains("D"));

    }


    @Test
    public void testRemove() {
        MyHashImpl<String, Integer> hash = new MyHashImpl<>();
        hash.put("A", 1);
        hash.put("B", 2);
        hash.put("C", 3);

        assertTrue(hash.contains("B"));
        hash.remove("B");
        assertFalse(hash.contains("B"));
        assertTrue(hash.contains("A"));
        assertTrue(hash.contains("C"));
    }

    @Test
    public void testResize() {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        for (int i = 0; i < 100; i++) {
            hash.put(i, "Value" + i);
        }

        for (int i = 0; i < 100; i++) {
            assertTrue(hash.contains(i));
        }

        assertEquals(100, hash.getSize());
    }

    @Test
    public void testCollisionHandling() {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        hash.put(1, "One");
        hash.put(24, "Twenty-Four"); // 1 y 24 colisionan if INITIAL_CAPACITY == 23
        assertTrue(hash.contains(1));
        assertTrue(hash.contains(24));
    }

    @Test
    public void testLoadFactorResize() {
        MyHashImpl<Integer, String> hash = new MyHashImpl<>();
        int numElements = (int) (INITIAL_CAPACITY * LOAD_FACTOR) + 1;
        for (int i = 0; i <= numElements; i++) {
            hash.put(i, "Value" + i);
        }
        assertTrue(hash.getCapacity() > INITIAL_CAPACITY); // Verifica que se redimensionó
        for (int i = 0; i < numElements; i++) {
            assertTrue(hash.contains(i));
        }
    }
}
