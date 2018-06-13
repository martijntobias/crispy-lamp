package game.entity;

import game.state.State;
import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

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
public abstract class Entity implements Serializable {
    protected String name = "no_name";
    protected int cost;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
