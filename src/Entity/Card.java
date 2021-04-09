package Entity;

import java.util.UUID;

public class Card extends BaseEntity {

    private String name;
    private int attack;
    private int defense;

    private Card() {
        super(UUID.randomUUID().toString());
    }

    public Card(String name, int attack, int defense) {
        this();
        this.setName(name);
        this.setAttack(attack);
        this.setDefense(defense);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    private void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPower() {
        return this.getAttack() + this.getDefense();
    }

}
