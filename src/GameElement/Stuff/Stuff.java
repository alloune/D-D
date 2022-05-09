package GameElement.Stuff;


import GameElement.GameElement;

abstract public class Stuff extends GameElement {
    private String name;
    private int strength;
    private String user;

    public Stuff(){
        this.setStatus("Treasure");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStrength() {
        return strength;
    }
}
