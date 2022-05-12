package GameElement.Stuff;

import GameElement.Interact;
import GameElement.Char.Hero;
import GameElement.GameElement;

abstract public class Stuff extends GameElement implements Interact {
    private String name;


    public Stuff(){
        this.setStatus("Treasure");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }







}
