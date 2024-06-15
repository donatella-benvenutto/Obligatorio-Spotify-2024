package uy.edu.um.adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.junit.Test;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;

public class StackImplTest {

    @Test
    public void testFlujoCompleto() {
        MyStack<Integer> colStack = new MyStack<Integer>() {
            @Override
            public void push(Integer value) {

            }

            @Override
            public Integer pop() throws EmptyStackException {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        colStack.push(new Integer(2));
        colStack.push(new Integer(4));
        colStack.push(new Integer(7));

        assertEquals(new Integer(7), colStack.peek());

        try {

            assertEquals(new Integer(7), colStack.pop());

        } catch (EmptyStackException e) {

            fail(e.getMessage());

        }

        assertEquals(new Integer(4), colStack.peek());

        try {

            assertEquals(new Integer(4), colStack.pop());

        } catch (EmptyStackException e) {

            fail(e.getMessage());

        }

        try {

            assertEquals(new Integer(2), colStack.pop());

        } catch (EmptyStackException e) {

            fail(e.getMessage());

        }
        try {

            colStack.pop();

            fail("El stack debería estar vacío");

        } catch (EmptyStackException e) {

            assertTrue(true);

        }
    }

}
