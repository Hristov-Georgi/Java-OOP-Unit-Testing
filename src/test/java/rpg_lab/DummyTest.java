package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int WEAPON_ATTACK_POINTS = 30;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
         this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
         this.deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        this.dummy.takeAttack(WEAPON_ATTACK_POINTS);
        Assert.assertEquals(DUMMY_HEALTH - WEAPON_ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {

        deadDummy.takeAttack(WEAPON_ATTACK_POINTS);

    }

    @Test
    public void deadDummyCanGiveXP() {
        int expectedXP = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_EXPERIENCE, expectedXP);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        dummy.giveExperience();
    }
}
