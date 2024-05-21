package uy.edu.um.adt.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashImplTest {
    private MyHashImpl<String, Integer> hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new MyHashImpl<>();
    }

    @Test
    public void testPut() {
        hashTable.put("TestKey", 1);
        assertTrue(hashTable.contains("TestKey"));
    }

    @Test
    public void testRemove() {
        hashTable.put("TestKey", 1);
        hashTable.remove("TestKey");
        assertFalse(hashTable.contains("TestKey"));
    }

    @Test
    public void testContains() {
        assertFalse(hashTable.contains("TestKey"));
        hashTable.put("TestKey", 1);
        assertTrue(hashTable.contains("TestKey"));
    }
}

