package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends BaseEntity {

    private String username;
    private String password;
    private List<Card> cards;
    private double points;
    private double experience;

    private User() {
        super(UUID.randomUUID().toString());
        this.cards = new ArrayList<>();
    }

    public User(String name, String password) {
        this();
        this.setUsername(name);
        this.setPassword(password);
        this.setPoints(50);
        this.setExperience(0);
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getExperience() {
        return experience;
    }

    private void setExperience(double experience) {
        this.experience = experience;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void setPointsViaDuel() {
        this.setPoints(this.getPoints() + 10);

    }

    public void setExperienceViaDuel() {
        this.setExperience(this.getExperience() + 5);
    }
}
