package GameElement;

import GameElement.Char.Hero;

public abstract class GameElement implements Interact{
    private int position;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public GameElement isInteraction(Hero pHero, GameElement element) {

        if(pHero.getPosition() == element.getPosition()){
            return element;
        }
        else {
            return null;
        }
    }


}
