package kg.geektech.game.generals;

import kg.geektech.game.plaers.*;

import java.util.Random;

public class RPG_GAME {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start(){
        Boss boss = new Boss(700,50);
        Warrior warrior = new Warrior(300, 25, SuperAbility.CRITICAL_DAMAGE, "Minato");
        Medic doc = new Medic(200, 5, 15, "Tsunada");
        Magic magic = new Magic(250, 25, "Naruto");
        Berserk berserk = new Berserk(300, 25, "Kakashi");
        Medic assistant = new Medic(250,10,5, "Sacura");



        Hero[] heroes = {warrior,doc,magic,berserk,assistant};

        printStatistics(heroes, boss);

        while (!isGameFinish(heroes, boss)){
            round(heroes, boss );
        }
    }

    private static void round(Hero[] heroes, Boss boss){
        roundNumber++;
        printStatistics(heroes, boss);
        bossHits(heroes, boss);
        heroHits(heroes, boss);
        applySuperPowers(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void printStatistics(Hero[] heroes, Boss boss){
        System.out.println("-----------------------------------");
        System.out.println("ROUND " + roundNumber);
        System.out.println("Boss health: " + boss.getHealth() + "; " +
                "Boss damage: " + boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() +" health: " + heroes[i].getHealth() + "; " +
                    "Hero damage: " + heroes[i].getDamage());
        }
        System.out.println();
    }

    private static void bossHits(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroHits(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
            System.out.println(heroes[i].getName() + " HELP" + heroes[i].getName());
        }
    }

    private static boolean isGameFinish(Hero[] heroes, Boss boss){
        if (boss.getHealth() <= 0){
            System.out.println("HERO WON!!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("BOSS WON!!!");
        }

        return allHeroesDead;
    }

    private  static void applySuperPowers(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, boss);

            }
        }
    }


}

