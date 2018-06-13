package game.state.collections;

import game.entity.card.character.Minion;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int MAX_SIZE = 7;

    private final List<Minion> minions;

    public Board() {
        this.minions = new ArrayList<>();
    }

    public int size() {
        return minions.size();
    }

    public boolean isEmpty() {
        return minions.isEmpty();
    }

    public Minion get(int i) {
        return minions.get(i);
    }

    public Minion getFromRight(int i) {
        return minions.get(size() - (i+1));
    }

    public List<Minion> getAll() {
        return new ArrayList<>(minions);
    }

    public boolean add(Minion minion, int i) {
        if(size() >= MAX_SIZE) {
            return false;
        } else {
            minions.add(i, minion);
            return true;
        }
    }

    public boolean addLeft(Minion minion) {
        return add(minion, 0);
    }

    public boolean addRight(Minion minion) {
        return add(minion, size());
    }
}
