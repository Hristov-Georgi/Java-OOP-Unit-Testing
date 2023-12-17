package rpg_lab;


public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;

    public Hero(String name, Weapon axe) {
        this.name = name;
        this.experience = 0;
        this.weapon = axe;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target dummy) {
        this.weapon.attack(dummy);

        if (dummy.isDead()) {
            this.experience += dummy.giveExperience();
        }
    }
}
