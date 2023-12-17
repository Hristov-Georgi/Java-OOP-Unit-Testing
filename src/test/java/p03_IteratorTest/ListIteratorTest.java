package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static final String[] ELEMENTS = {"cat", "dog", "lizard", "snake", "mouse", "chicken"};

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS);
    }

    @Test
    public void constructorShouldCreateInstanceFromListIterator() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator(ELEMENTS);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorThrowsOperationNotSupportExceptionForNullValue() throws OperationNotSupportedException {
       new ListIterator(null);
    }

    @Test
    public void testMoveMethodHasNextAndReturnsTrue() {
        this.listIterator.move();
        Assert.assertTrue(true);
    }

    @Test
    public void testMoveMethodReturnsFalse() throws OperationNotSupportedException {
        ListIterator singleElementIterator = new ListIterator("goat");
        singleElementIterator.move();
        Assert.assertFalse(false);
    }

    @Test (expected = IllegalStateException.class)
    public void checkIfPrintMethodElementsListSizeIsZeroAndThrowsException() throws OperationNotSupportedException {
        String[] elements = new String[0];
        ListIterator printTestIterator = new ListIterator(elements);
        printTestIterator.print();
    }

    @Test
    public void checkIfPrintMethodReturnsValueFromList() {

        int index = 0;

        while (this.listIterator.hasNext()) {

            Assert.assertEquals(ELEMENTS[index], this.listIterator.print());
            index++;
            this.listIterator.move();
        }
    }

}
