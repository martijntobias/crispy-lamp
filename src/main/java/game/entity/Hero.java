package game.entity;

public class Hero extends Character {
    int armor; // armor gained when becoming this hero

    public String toString() {
        return String.format("Hero : {\"name\" : \"%s\"}", name);
    }
}
