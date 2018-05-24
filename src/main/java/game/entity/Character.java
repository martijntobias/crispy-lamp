package game.entity;

/**
 * Abstract superclass to Minions and Heroes.
 */
public abstract class Character extends Entity {
    protected int attack;
    protected int health;

    public String toString() {
        return String.format("Character : {\"name\" : \"%s\"}", name);
    }
}
