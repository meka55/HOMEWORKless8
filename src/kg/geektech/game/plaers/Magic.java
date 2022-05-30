package kg.geektech.game.plaers;

import kg.geektech.game.generals.RPG_GAME;

import java.util.Random;

public class Magic extends Hero{


    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int number = RPG_GAME.random.nextInt(5) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this !=  heroes[i]) {
                heroes[i].setDamage(heroes[i].getDamage() + number );

            }
        }
    }
}





