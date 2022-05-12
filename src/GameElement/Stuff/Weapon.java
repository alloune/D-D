package GameElement.Stuff;

import GameElement.GameElement;

public abstract class Weapon extends Stuff {
    private String name;
    private int strength;
    private String user;

    public int getStrength() {
        return strength;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
