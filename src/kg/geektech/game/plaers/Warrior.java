package kg.geektech.game.plaers;


import kg.geektech.game.generals.RPG_GAME;

public class Warrior extends Hero {

    public Warrior(int health, int damage, SuperAbility criticalDamage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {

        int number = RPG_GAME.random.nextInt(4) + 2;
        for (int i = 0; i < heroes.length; i++) {

            if (this.getHealth() > 0 && heroes[i].getName() == this.getName()) {
                this.setDamage(getDamage()* number);
                
            }
        }

    }
}