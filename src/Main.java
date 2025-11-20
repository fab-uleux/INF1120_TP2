import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String entree = "";

        //Appelle des méthodes et création de l'objet associe
        ROT13_Code rot13 = new ROT13_Code();
        Cesar_Code cesar = new Cesar_Code();
        CesarChoix_Code cesarChoix = new CesarChoix_Code();
        PolyAlpha_Code polyAlpha = new PolyAlpha_Code();

        //Appelle de la méthode menu_Code et création de l'objet menu
        menu_Code menu = new menu_Code();

        int nombre = 0;
        int choix2 = 0;

        //Appelle du premier menu et lecture de la réponse
        menu.menu1();
        int choix1 = sc.nextInt();
        sc.nextLine();

        switch (choix1){
            case 1:
                System.out.println("Saisie au clavier");
                entree = sc.nextLine();
                System.out.println("Le texte que vous désirez encrypter: " + entree);
                break;
            case 2:
                System.out.println("Random");
                char[] alphabetRnd = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
                Random rnd = new Random();
                int longueur = rnd.nextInt(3, 21);

                char[] lettresAleatoires = new char[longueur];
                for (int i = 0; i < longueur; i++) {
                    int rndIndex = rnd.nextInt(alphabetRnd.length);
                    lettresAleatoires[i] = alphabetRnd[rndIndex];
                }
                entree = new String(lettresAleatoires);
                System.out.println("Texte généré avec Random d'une longueur de " + longueur + " lettres) \nVoici le texte généré: " + entree);
                break;
            case 3:
                System.out.println("Quitter");
                return;
        }

        menu.menu2();
        choix2 = sc.nextInt();

        boolean continuer = true;

        while (continuer) {
            switch (choix2) {
                case 1:
                    System.out.println("ROT-13");
                    String resultatRot13 = rot13.rot13(entree);
                    System.out.println("Texte encrypté: " + resultatRot13);
                    continuer = false;
                    break;
                case 2:
                    System.out.println("Le chiffre César");
                    String resultatCesar = cesar.cesar(entree);
                    System.out.println("Texte encrypté: " + resultatCesar);
                    continuer = false;
                    break;
                case 3:
                    System.out.println("César au choix");
                    System.out.println("Entrez le nombre de lettres (1-25):");
                    int decalage = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Direction: (1) Droite ou (2) Gauche?");
                    int direction = sc.nextInt();

                    if (direction == 2) {
                        decalage = -decalage;
                    }

                    String resultatCesarChoix = cesarChoix.cesarChoix(entree, decalage);
                    System.out.println("Texte encrypté: " + resultatCesarChoix);
                    continuer = false;
                    break;
                case 4:
                    System.out.println("Le Poly-Alphavariante");
//                   String resultaPolyAlpha = polyAlpha.polyAlpha(entree);
                    continuer = false;
                    break;
                case 5:
                    System.out.println("Je sais pas - choix aléatoire");
                    Random rnd2 = new Random();
                    choix2 = rnd2.nextInt(1, 5);
                    System.out.println("Méthode choisie: " + choix2);
                    break;
            }
        }

        sc.close();
    }
}