package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private static final int EXPERIENCE = 150;

    private Hero hero;

    @Before
    public void setUp() {
        Weapon mockedAxe = Mockito.mock(Weapon.class);
        this.hero = new Hero("Conan", mockedAxe);

    }

    @Test
    public void heroTakesXPWhenTargetDies() {

        Target mockedDummy = Mockito.mock(Target.class);
        Mockito.when(mockedDummy.isDead()).thenReturn(true);
        Mockito.when(mockedDummy.giveExperience()).thenReturn(EXPERIENCE);
        this.hero.attack(mockedDummy);
        Assert.assertEquals(EXPERIENCE, this.hero.getExperience());
    }

    @Test
    public void heroDoNotTakesXPIfTargetIsAlive() {

        Target mockedDummy = Mockito.mock(Target.class);
        Mockito.when(mockedDummy.isDead()).thenReturn(false);
        Mockito.when(mockedDummy.giveExperience()).thenReturn(EXPERIENCE);
        this.hero.attack(mockedDummy);
        Assert.assertEquals(0, this.hero.getExperience());
    }
}
