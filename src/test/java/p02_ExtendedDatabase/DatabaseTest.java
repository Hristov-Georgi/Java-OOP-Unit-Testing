package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person[] PEOPLE_ARRAY = {
            new Person (123456789, "Pesho"),
            new Person (1234567776, "Pesho"),
            new Person (123456789, "Todor"),
            new Person (938388388, "Fiona" )};

    private static final int ID_NOT_IN_ARRAY = 9939399;
    private static final String NAME_NOT_IN_ARRAY = "Presiana";
    private static final String EQUAL_NAMES = "Pesho";
    private static final int EQUAL_ID = 123456789;

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE_ARRAY);
    }

    @Test
    public void constructorCreatesInstanceFromDatabaseClass() {
        int expectedLength = this.database.getElements().length;

        Assert.assertEquals("Arrays length is not equal", expectedLength, PEOPLE_ARRAY.length);
        Assert.assertArrayEquals("Arrays have different elements",
                this.database.getElements(), PEOPLE_ARRAY);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfTestElementsMethodThrowsExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Person[] testPerson = new Person[17];
        new Database(testPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfTestElementsMethodThrowsExceptionForZeroElements() throws OperationNotSupportedException {
        Person[] testPerson = new Person[0];
        new Database(testPerson);
    }



    @Test (expected = OperationNotSupportedException.class)
    public void addCommandShouldThrowOperationNotSupportedExceptionIfPersonIsNull()
            throws OperationNotSupportedException {

        this.database.add(null);
    }

    @Test
    public void addCommandShouldAddPersonInDatabase() throws OperationNotSupportedException {
        this.database.add(new Person(ID_NOT_IN_ARRAY, NAME_NOT_IN_ARRAY));

        Assert.assertEquals("Arrays length is not equal", this.database.getElements().length,
                PEOPLE_ARRAY.length + 1);

        Assert.assertEquals("Person ID is different",
                this.database.getElements()[this.database.getElements().length - 1].getId(),
                ID_NOT_IN_ARRAY);

        Assert.assertEquals("Person name is not equal",
                this.database.getElements()[this.database.getElements().length - 1].getUsername(),
                NAME_NOT_IN_ARRAY);

    }

    @Test
    public void testRemovingElements() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertEquals(this.database.getElements()[this.database.getElements().length - 1],
                PEOPLE_ARRAY[this.database.getElements().length - 1]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfRemoveMethodThrowsOperationNotSupportedException() throws OperationNotSupportedException {

        for (int i = 0; i < PEOPLE_ARRAY.length + 1 ; i++) {
            this.database.remove();
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfFindByUsernameMethodThrowsOperationNotSupportedException() throws OperationNotSupportedException {

        this.database.findByUsername(null);
    }

    @Test
    public void testIfFindByUsernameMethodMatchesAndAddNameToList() throws OperationNotSupportedException {
        this.database.findByUsername("Todor");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfFindByUsernameMethodDoNotMatchesAndThrowsException() throws OperationNotSupportedException {
        this.database.findByUsername("Kotarak");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfFindByUsernameMethodHaveMoreThan1EqualNameInList() throws OperationNotSupportedException {
        this.database.findByUsername(EQUAL_NAMES);
    }

    @Test
    public void testIfFindByIdMethodMatchesAndAddsIDToList() throws OperationNotSupportedException {

        this.database.findById(938388388);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfFindByIdMethodMatchesMoreThan2IDAnd() throws OperationNotSupportedException {

        this.database.findById(EQUAL_ID);
    }


    @Test (expected = OperationNotSupportedException.class)
    public void testIfFindByIdMethodDoNotMatchesIDAnd() throws OperationNotSupportedException {

        this.database.findById(900828282);
    }

}
