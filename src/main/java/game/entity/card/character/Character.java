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
}
