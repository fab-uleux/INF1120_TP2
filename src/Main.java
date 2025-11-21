import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Appelle des méthodes d'encryption
        ROT13_Code rot13 = new ROT13_Code();
        Cesar_Code cesar = new Cesar_Code();
        Cesar_Code cesarChoix = new Cesar_Code();
        PolyAlpha_Code polyAlpha = new PolyAlpha_Code();

        //Appelle des méthodes de decryption
        ROT13_Code decrypteRot13 = new ROT13_Code();

        //Appelle de la méthode menu_Code
        Menu_Code menu = new Menu_Code();

        boolean menuQuitter = true;
        int nombre = 0;
        String entree = "";
        String entreeSymbole = "";


//        String entreeOriginal = ""; PAS PERMIS. TAB DYNAMIQUE???

        while(menuQuitter){
            // Réinitialiser les variables pour chaque cycle
            boolean continuerMenu1 = true;
            boolean continuerMenu2 = true;

            //Appelle du premier menu et lecture de la réponse
            menu.menu1();
            int choix1 = sc.nextInt();
            sc.nextLine();

            while(continuerMenu1){
                switch (choix1){
                    case 1:
                        System.out.println("Saisie au clavier");
                        entree = sc.nextLine();
                        System.out.println("Le texte que vous désirez encrypter: " + entree);
                        continuerMenu1 = false;
                        break;
                    case 2:
                        System.out.println("Random");
                        char[] alphabetRnd = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
                        Random rnd = new Random();
                        int longueur = rnd.nextInt(3, 21);

                        char[] lettresAleatoires = new char[longueur];
                        for (int i = 0; i < longueur; i++) {
                            int rndIndex = rnd.nextInt(alphabetRnd.length);
                            lettresAleatoires[i] = alphabetRnd[rndIndex];
                        }
                        entree = new String(lettresAleatoires);
                        System.out.println("Texte généré d'une longueur de " + longueur + " lettres) \nVoici le texte généré: " + entree);
                        continuerMenu1 = false;
                        break;
                    case 3:
                        System.out.println("Quitter");
                        menuQuitter = false; // Arrêter la boucle principale
                        continuerMenu1 = false;
                        break;
                }
            }

            if(!menuQuitter){
                break;
            }

            // Afficher menu2
            menu.menu2();
            int choix2 = sc.nextInt();
            sc.nextLine();

            while (continuerMenu2) {
                switch (choix2) {
                    case 1:
                        System.out.println("ROT-13");
                        String resultatRot13 = rot13.rot13(entree);
                        System.out.println("Texte encrypté: " + resultatRot13);
                        continuerMenu2 = false; // Sort du menu2, retourne au menu1
                        break;
                    case 2:
                        System.out.println("Le chiffre César");
                        String resultatCesar = cesar.cesar(entree);
                        System.out.println("Texte encrypté: " + resultatCesar);
                        continuerMenu2 = false; // Sort du menu2, retourne au menu1
                        break;
                    case 3:
                        System.out.println("César au choix");
                        System.out.println("Entrez le nombre de lettres (1-25):");
                        int decalage = sc.nextInt();
                        sc.nextLine();

                        if(decalage < 1 || decalage > 25){
                            System.out.println("Veuillez entrer un nombre valide entre 1 et 25");
                            break;
                        }

                        System.out.println("Direction: (1) Droite ou (2) Gauche?");
                        int direction = sc.nextInt();
                        sc.nextLine();

                        if (direction == 2) {
                            decalage = -decalage;
                        }

                        String resultatCesarChoix = cesarChoix.cesarChoix(entree, decalage);
                        System.out.println("Texte encrypté: " + resultatCesarChoix);
                        continuerMenu2 = false; // Sort du menu2, retourne au menu1
                        break;
                    case 4:
                        System.out.println("Le Poly-Alphavariante");
                        // String resultaPolyAlpha = polyAlpha.polyAlpha(entree);
                        // System.out.println("Texte encrypté: " + resultaPolyAlpha);
                        continuerMenu2 = false; // Sort du menu2, retourne au menu1
                        break;
                    case 5:
                        System.out.println("Je sais pas");
                        Random rnd2 = new Random();
                        choix2 = rnd2.nextInt(1, 5);
                        System.out.println("Méthode choisie: " + choix2);
                        // continuerMenu2 reste true, donc le switch se ré-exécute
                        break;
                }
            }
        }

        System.out.println("Merci d'avoir encrypter avec nous, à la prochaine!");
        sc.close();

    }
}