package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_DURABILITY = 20;
    private static final int AXE_ATTACK_POWER = 20;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK_POWER, AXE_DURABILITY);
        dummy = new Dummy(100, 100);

    }

    @Test
    public void axeLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void axeThrowsIllegalStateExceptionWhenDurabilityIsZero() {
        Axe brokenAxe = new Axe(AXE_ATTACK_POWER, 0);
        brokenAxe.attack(dummy);
    }

    @Test (expected = IllegalStateException.class)
    public void axeThrowsIllegalStateExceptionWhenDurabilityIsNegativeNumber() {
        Axe veryBrokenAxe = new Axe(AXE_ATTACK_POWER, -4);
        veryBrokenAxe.attack(dummy);
    }

}