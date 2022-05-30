package kg.geektech.game.plaers;

public class Berserk extends Hero {

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int berserkSave;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getName() == this.getName()) {

                boss.setHealth(boss.getHealth() - boss.getDamage() /2);

            }
        }
    }
}
