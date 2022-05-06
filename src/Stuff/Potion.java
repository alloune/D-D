package Stuff;

abstract public class Potion {
    private String name;
    private int regenHealth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegenHealth() {
        return regenHealth;
    }

    public void setRegenHealth(int regenHealth) {
        this.regenHealth = regenHealth;
    }
}
