package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] ELEMENTS_ARRAY = {1, 2, 3, 4, 5 ,6};

    private Database dataBase;

    @Test
    public void testIfConstructorCreatesDatabaseElement() throws OperationNotSupportedException {
        this.dataBase = new Database(ELEMENTS_ARRAY);
        Integer[] array = this.dataBase.getElements();

        Assert.assertEquals("Arrays length is not the same", array.length, ELEMENTS_ARRAY.length);

        Assert.assertArrayEquals("Arrays elements are not equal", array, ELEMENTS_ARRAY);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorThrowsExceptionForBigElementsSize() throws OperationNotSupportedException {
        Integer[] bigArr = new Integer[18];
        this.dataBase = new Database(bigArr);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorThrowsExceptionForZeroElementsSize() throws OperationNotSupportedException {
        Integer[] nullArr = new Integer[0];
        this.dataBase = new Database(nullArr);
    }

    @Test
    public void testAddMethodAddsElementsToArray() throws OperationNotSupportedException {
        this.dataBase = new Database(1, 2, 3, 4, 5);
        dataBase.add(6);
        Integer[] checkArr = this.dataBase.getElements();

        Assert.assertEquals("Arrays length is different", checkArr.length, ELEMENTS_ARRAY.length);

        Assert.assertArrayEquals("Arrays elements are not equal", checkArr, ELEMENTS_ARRAY);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        this.dataBase = new Database(ELEMENTS_ARRAY);
        this.dataBase.add(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveMethodShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        this.dataBase = new Database(ELEMENTS_ARRAY);
        for (int i = 0; i < ELEMENTS_ARRAY.length; i++) {
            this.dataBase.remove();
        }
        this.dataBase.remove();
    }
}
