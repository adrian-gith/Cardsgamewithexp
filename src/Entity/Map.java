package Entity;

public class Map {

    private Card[][] map;

    public Map() {
        this.map = new Card[2][5];
    }

    public void fillMap(Card[][] map) {
        this.map = map;
    }

    public Card[][] getMap() {
        return map;
    }

    public Card[] getMyField() {
        return map[0];
    }

    public Card[] getEnemyField() {
        return map[1];
    }
}
