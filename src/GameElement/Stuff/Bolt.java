package GameElement.Stuff;


public class Bolt extends Weapon{
    public Bolt(){
        this.setName("Éclair ♫");
        this.setStrength(2);
        this.setUser("Magicien");
    }

    @Override
    public void isInteraction() {
        System.out.println("toto");
    }
}
