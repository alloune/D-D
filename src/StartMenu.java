import java.util.Scanner;

public class StartMenu {
    Scanner clavier = new Scanner(System.in);
    public void start() {

        Boolean startValue = false;
        String answer = null;
        System.out.println("Continuer le jeu (Y)");
        System.out.println("Fermer le jeu (X)");
        while (!startValue) {
            System.out.println("votre réponse ");
            answer = clavier.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Vous lancez le jeu");
                startValue = true;
            }
            if (answer.equalsIgnoreCase("X")) {
                System.out.println("Vous fermez le jeu");
                System.exit(0);
            }
            if (startValue.equals(false))
                System.out.println("Merci d'entrer un caractère valide");
        }
    }


    public Hero charSelection(){
        System.out.println("Quel héro voulez vous prendre ? 1 = Guerrier, 2 = Magicien");
        String choosenHero = clavier.nextLine();
        Hero hero = chooseTheChar(choosenHero);
        return hero;
    }

    public Hero chooseTheChar(String heroSelected) {
        Scanner clavier = new Scanner(System.in);
        String name;
        Hero hero=null;

        if (heroSelected.equalsIgnoreCase("1")) {
           hero = new Warrior();
        }
        if (heroSelected.equalsIgnoreCase("2")) {
           hero = new Wizard();
        }
        System.out.println("tu as choisis le : " + hero.getHeroClass());
        System.out.println("Maintenant, merci d'entrer le nom de ton Héro ! " +
                "Quelque chose qui pète, tu ne pourras plus le changer par la suite.");
        name = clavier.nextLine();
        hero.setName(name);

        System.out.println(hero.getName()+ ", un jeune gland de " + hero.getHeroClass()+" qui deviendra bientôt " +
                "un chêne fort et puissant.");
        System.out.println("Ta vie s'élève actuellement à "+hero.getHealth()+ " et ta force à "+hero.getStrength());
        return hero;
    }
    public void coreGame(Hero theHero){

        while( theHero.getPosition() < 64) {

            System.out.println("Vous êtes sur la case "+ theHero.getPosition() +". Cliquez sur n'importe quelle touche pour lancer le dé.(ou e pour quitter.");
            String check = clavier.nextLine();
            if(check.equalsIgnoreCase("e")){

                System.exit(0);

            }
            RollTheDice lunch = new RollTheDice();
            theHero.setPosition(theHero.getPosition()+ lunch.lunchDice());

        }
        if(theHero.getPosition() >=64){
            System.out.println("Bravo !! Tu as finis le jeu :), entrée pour quitter, r pour rejouer");

        }
    }


}

