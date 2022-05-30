package kg.geektech.game.plaers;

public abstract class Hero extends GameEntity implements HeavingSuperAbility {

    private SuperAbility ability;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }

    public Hero(int health, int damage, SuperAbility ability, String name ) {
        super(health, damage);
        this.ability = ability;
        this.name = name;
    }
}
