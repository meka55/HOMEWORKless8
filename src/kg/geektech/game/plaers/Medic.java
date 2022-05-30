package kg.geektech.game.plaers;

public class Medic extends Hero {

    private int healPoint;

    public int getHealPoint() {
        return healPoint;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }

    public Medic(int health, int damage, int healPoint, String name) {
        super(health, damage, SuperAbility.HEAL, name);
        this.healPoint = healPoint;
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getName() != this.getName()){
                heroes[i].setHealth(heroes[i].getHealth() + this.healPoint);
            }
        }
    }
}
