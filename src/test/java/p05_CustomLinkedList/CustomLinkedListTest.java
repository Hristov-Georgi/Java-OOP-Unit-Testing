package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private static final String FIRST_ELEMENT = "rock";
    private static final String SECOND_ELEMENT = "mud";
    private static final String THIRD_ELEMENT = "water";
    private static final String FOURTH_ELEMENT = "dirt";

    private static final int OUT_OF_BOUNDS_INDEX = 15;


    CustomLinkedList<String> customLinkedList;

    @Before
    public void setCustomLinkedList() {
        this.customLinkedList = new CustomLinkedList<>();
        this.customLinkedList.add(FIRST_ELEMENT);
        this.customLinkedList.add(SECOND_ELEMENT);
        this.customLinkedList.add(THIRD_ELEMENT);
        this.customLinkedList.add(FOURTH_ELEMENT);
    }

    @Test
    public void addElementsToList() {
        this.customLinkedList.add(FIRST_ELEMENT);
        this.customLinkedList.add(SECOND_ELEMENT);
        this.customLinkedList.add(THIRD_ELEMENT);
        this.customLinkedList.add(FOURTH_ELEMENT);

        Assert.assertEquals(this.customLinkedList.getCount(), 4);
    }

    @Test
    public void getMethodShouldReturnElementAtIndex() {
        String item = this.customLinkedList.get(1);
        Assert.assertEquals(item, SECOND_ELEMENT);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getMethodShouldThrowIllegalArgumentExceptionForIndexOutOfBounds(){
        this.customLinkedList.get(OUT_OF_BOUNDS_INDEX);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setMethodShouldThrowIllegalArgumentExceptionForIndexOutOfBounds() {
        this.customLinkedList.set(OUT_OF_BOUNDS_INDEX, "Lala");
    }

    @Test
    public void setMethodShouldChangeElementAtTheGivenIndex() {
        this.customLinkedList.set(1, FIRST_ELEMENT);
        Assert.assertEquals(this.customLinkedList.get(1), FIRST_ELEMENT);

    }

    @Test
    public void removeAtMethodShouldRemoveElementAtTheGivenIndexAndReturnItsValue() {
        String element = this.customLinkedList.removeAt(1);
        Assert.assertEquals(element, SECOND_ELEMENT);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowExceptionWhenIndexIsOutOfBounds() {
        this.customLinkedList.removeAt(OUT_OF_BOUNDS_INDEX);
    }

    @Test
    public void removeMethodShouldReturnMinus1WhenItemIsWithNullValueOrInvalidItem() {
        int result = this.customLinkedList.remove(null);
        Assert.assertEquals(result, -1);
        Assert.assertEquals(this.customLinkedList.remove("Koko"), -1);
    }

    @Test
    public void removeMethodShouldReturnItemsIndex() {
        Assert.assertEquals(this.customLinkedList.remove(FOURTH_ELEMENT), 3);
    }

    @Test
    public void indexOfMethodShouldReturnMinus1WhenItemIsWithNullValueOrInvalidItem() {
        Assert.assertEquals(this.customLinkedList.indexOf(null), -1);
        Assert.assertEquals(this.customLinkedList.indexOf("Koko"), -1);
    }

    @Test
    public void indexOfMethodShouldReturnItemsIndex() {
        Assert.assertEquals(this.customLinkedList.indexOf(THIRD_ELEMENT), 2);
    }

    @Test
    public void isFoundMethodShouldReturnTrue() {
        Assert.assertTrue(this.customLinkedList.contains(SECOND_ELEMENT));
    }

    @Test
    public void isFoundMethodShouldReturnFalse() {
        Assert.assertFalse(this.customLinkedList.contains("Koko"));
    }

    @Test
    public void removeListNodeMethodShouldSetHeadAndTailToNullValuesWhenAllItemsAreRemoved() {
        this.customLinkedList.remove(FIRST_ELEMENT);
        this.customLinkedList.remove(SECOND_ELEMENT);
        this.customLinkedList.remove(THIRD_ELEMENT);
        this.customLinkedList.remove(FOURTH_ELEMENT);

        Assert.assertEquals(this.customLinkedList.remove("Chicken"), -1);

    }

}
