package game.entity;

/**
 * The Entity class is a the highest superclass for in-game entities, as follows:
 * Entity
 *  Card
 *      Spell
 *      Weapon
 *      Character
 *          Minion
 *          Hero
 *  Hero Power
 */
public abstract class Entity {
    protected String name;
    protected int cost;

    public String toString() {
        return String.format("Entity : {\"name\" : \"%s\"}", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
