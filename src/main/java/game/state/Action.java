package game.state;

import game.entity.Entity;

/**
 * A single action taken by a Player. An Action contains at most three things. First the Entity that is being played or
 * cast or that is attacking. If this Entitity is null then the Action is ending the turn. Second there is the Entity
 * that is the target of the cast spell or battlecry or attack. Third there is the index position of where the played
 * Minion should end up on the Board.
 */
public class Action {

    private Entity source;
    private Entity target;
    private Integer index;

    /**
     * Creates an Action that will end the turn. For this Action to mean anything else, its source needs to be set to
     * a non-null value.
     */
    public Action() {
    }

    public Entity getSource() {
        return source;
    }

    public void setSource(Entity source) {
        this.source = source;
    }

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
