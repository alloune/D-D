package execptions;
import GameCore.StartMenu;


public class BadHeroSelection extends Exception {

   public BadHeroSelection(){super();}
   public BadHeroSelection(String msg) {
      super(msg);


   }
}


