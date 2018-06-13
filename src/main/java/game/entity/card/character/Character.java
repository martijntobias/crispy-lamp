package game.entity.card.character;

import game.entity.Type;
import game.entity.card.Card;

/**
 * Abstract superclass to Minions and Heroes.
 */
public abstract class Character extends Card {
    protected int attack;
    protected int health;
    protected Type type;

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public Type getType() {
        return type;
    }
}
