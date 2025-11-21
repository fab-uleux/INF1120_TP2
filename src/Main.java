import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void menu1(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "+ Faites votre choix : +\n" +
                "+ 1- Je veux saisir le message au clavier +\n" +
                "+ 2- Je veux le générer avec Random +\n" +
                "+ 3- Je veux aller dormir. (Quitter) +\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    public static void menu2(){
        System.out.println("========================================\n" +
                "= Je choisis : =\n" +
                "= 1- Le ROT-13 (décalage) =\n" +
                "= 2- Le chiffre de César =\n" +
                "= 3- César au choix =\n" +
                "= 4- Le poly-Alphavariante =\n" +
                "= 5- Je ne sais pas, choisissez pour moi \uF04C =\n" +
                "=========================================");
    }

    public static void menu3(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "~ Voulez-vous décrypter le message? ~\n" +
                "~ 1- Oui, décrypter ~\n" +
                "~ 2- Non, retour au menu principal ~\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Méthodes d'affichage
    public static void afficher_Message(String message) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("MESSAGE ORIGINAL: "+message);
        System.out.println("═══════════════════════════════════════");
    }

    public static void afficher_Message_Crypte(String messageCrypte) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("MESSAGE CRYPTÉ: "+messageCrypte);
        System.out.println("═══════════════════════════════════════");
    }

    public static void afficher_Message_Decrypte(String messageDecrypte) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("MESSAGE DÉCRYPTÉ: "+messageDecrypte);
        System.out.println("═══════════════════════════════════════");
    }

    // Validation des caractères
    public static void validerCaracteres(String texte) throws CaractereException {
        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);
            if (caractere < 32 || caractere > 126) {
                throw new CaractereException("Caractère non autorisé: '" + caractere + "' (ASCII " + (int) caractere + ")");
            }
        }
    }

    public static void validerCaracteresPolyAlpha(String texte) throws CaractereException {
        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);
            if (!Character.isLetterOrDigit(caractere) && caractere != ' ') {
                throw new CaractereException("Caractère non autorisé pour Poly-Alphavariante: '" + caractere + "'");
            }
        }
    }

    //ROT13
    public static String Rot13_TUF(String entree) {
        char[] tab = entree.toCharArray();

        char[] ascii = new char[95];
        for (int i = 32; i <= 126; i++) {
            ascii[i - 32] = (char) i;
        }

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

            int index = charactere - 32;

            if ((index >= 33 && index <= 58) | (index >= 65 && index <= 90) || index == 0) {
                for (int j = 0; j < ascii.length; j++) {
                    if (charactere == ascii[j]) {
                        tab[i] = ascii[(j + 13) % 95];
//                        break;
                    }
                }
            }
        }
        return new String(tab);
    }
    public static String decrypteRot13_TUF(String entreeEncrypter) {
        char[] tab = entreeEncrypter.toCharArray();

        char[] ascii = new char[95];
        for (int i = 32; i <= 126; i++) {
            ascii[i - 32] = (char) i;
        }

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

            int index = charactere - 32;

            if ((index >= 33 && index <= 58) ||
                    (index >= 65 && index <= 90) ||
                    index == 0) {

                for (int j = 0; j < ascii.length; j++) {
                    if (charactere == ascii[j]) {
                        tab[i] = ascii[(j - 13 + 95) % 95];
                        break;
                    }
                }
            }
        }
        return new String(tab);
    }

    public static String Cesar_TUF(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();

        Random rnd = new Random();
        int decalage = rnd.nextInt(0, 25);

        System.out.println("Décalage aléatoire: " + decalage);

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];
            int index = charactere - 32;

            if ((index >= 33 && index <= 58) || (index >= 65 && index <= 90) || index == 0) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (charactere == alphabet[j]) {
                        int newIndex = (j + decalage) % alphabet.length;
                        tab[i] = alphabet[newIndex];
//                        break;
                    }
                }
            }
        }
        return new String(tab);
    }

    public static String CesarChoix_TUF(String entree, int decalage) {
        char[] tab = entree.toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];
            int index = charactere - 32;

            if ((index >= 33 && index <= 58) || (index >= 65 && index <= 90) || index == 0) {

                int newIndex = (index + decalage) % 95;

                if (newIndex < 0) {
                    newIndex += 95;
                }
                tab[i] = (char) (newIndex + 32);
            }
        }
        return new String(tab);
    }

    public static String DecrypteCesar_TUF(String entree, int decalage) {
        char[] tab = entree.toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];
            int index = charactere - 32;

            if ((index >= 33 && index <= 58) || (index >= 65 && index <= 90) || index == 0) {

                int newIndex = (index - decalage) % 95;

                if (newIndex < 0) {
                    newIndex += 95;
                }

                tab[i] = (char) (newIndex + 32);
            }
        }

        return new String(tab);
    }

    public static String PolyAlpha_TUF(String entree) {
        char[] tab = entree.toCharArray();

        char[] ascii = new char[95];
        for (int i = 32; i <= 126; i++) {
            ascii[i - 32] = (char) i;
        }

        char[] voyelles = "aeiouyAEIOUY".toCharArray();
        char[] symboles = "+=&*!$+=&*!$".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];
            int index = charactere - 32;

            if ((index >= 33 && index <= 58) || (index >= 65 && index <= 90) || index == 0) {

                boolean replaced = false;

                for (int v = 0; v < voyelles.length; v++) {
                    if (charactere == voyelles[v]) {
                        tab[i] = symboles[v];
                        replaced = true;
                        break;
                    }
                }

                if (!replaced) {
                    if (charactere >= '0' && charactere <= '9') {
                        tab[i] = (char) ('9' - (charactere - '0'));
                        replaced = true;
                    }
                }

                if (!replaced) {
                    if ((charactere >= 'a' && charactere <= 'z')) {
                        tab[i] = (char) (((charactere - 'a' + 4) % 26) + 'a');
                    } else if ((charactere >= 'A' && charactere <= 'Z')) {
                        tab[i] = (char) (((charactere - 'A' + 4) % 26) + 'A');
                    }
                }
            } else if ((index >= 1 && index <= 15) || (index >= 26 && index <= 32) || (index >= 91 && index <= 94)) {
                for (int k = tab.length - 1; k > i; k--) {
                    tab[k] = tab[k - 1];
                }
                tab[i] = '?';
                tab[i + 1] = charactere;
                i++;
            }
        }
        return new String(tab);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String entree = "";
        String entreeSymbole = "";

        String entreeEncrypter = "";
        String entreeSymboleEncrypter = "";
        int decalageUtilise = 0;

        boolean menuQuitter = true;

        while(menuQuitter){
            // Réinitialiser les variables pour chaque cycle
            boolean continuerMenu1 = true;
            boolean continuerMenu2 = true;

            //Appelle du premier menu et lecture de la réponse
//            System.out.println(entree);
            menu1();
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
                        char[] alphabetRnd = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
                        char[] alphabetSymboleRnd = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789)(*&^%$#@!?".toCharArray();

                        Random rnd = new Random();
                        int longueur = rnd.nextInt(3, 21);

                        char[] lettresAleatoires = new char[longueur];
                        for (int i = 0; i < longueur; i++) {
                            int rndIndex = rnd.nextInt(alphabetRnd.length);
                            lettresAleatoires[i] = alphabetRnd[rndIndex];
                        }

                        char[] lettresSymboleAleatoires = new char[longueur];
                        for (int i = 0; i < longueur; i++) {
                            int rndIndex = rnd.nextInt(alphabetSymboleRnd.length);
                            lettresSymboleAleatoires[i] = alphabetSymboleRnd[rndIndex];
                        }

                        entree = new String(lettresAleatoires);
                        System.out.println("Texte généré sans symbole d'une longueur de " + longueur + " lettres) \nVoici le texte généré: " + entree);

                        entreeSymbole = new String(lettresSymboleAleatoires);
                        System.out.println("Texte généré avec symbole d'une longueur de " + longueur + " lettres) \nVoici le texte généré: " + entreeSymbole);

                        continuerMenu1 = false;
                        break;
                    case 3:
                        System.out.println("Quitter");
                        menuQuitter = false;
                        continuerMenu1 = false;
                        break;
                }
            }

            if(!menuQuitter){
                break;
            }

            // Afficher menu2
            menu2();
            int choix2 = sc.nextInt();
            sc.nextLine();

            while (continuerMenu2) {
                switch (choix2) {
                    case 1:
                        System.out.println("ROT-13");
//                        String resultatRot13 = Rot13_TUF.Rot13_TUF(entree);
                        String resultatRot13 = Rot13_TUF(entree);
                        System.out.println("Texte encrypté: " + resultatRot13);
//                        entreeEncrypter = resultatRot13;
                        continuerMenu2 = false;
                        break;
                    case 2:
                        System.out.println("Le chiffre César");
                        String resultatCesar = Cesar_TUF(entree);
                        System.out.println("Texte encrypté: " + resultatCesar);
                        continuerMenu2 = false;
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

                        String resultatCesarChoix = CesarChoix_TUF(entree, decalage);
                        System.out.println("Texte encrypté: " + resultatCesarChoix);
                        continuerMenu2 = false;
                        break;
                    case 4:
                        System.out.println("Le Poly-Alphavariante");
                         String resultaPolyAlpha = PolyAlpha_TUF(entreeSymbole);
                         System.out.println("Texte encrypté: " + resultaPolyAlpha);
                        continuerMenu2 = false;
                        break;
                    case 5:
                        System.out.println("Je sais pas");
                        Random rnd2 = new Random();
                        choix2 = rnd2.nextInt(1, 5);
                        System.out.println("Méthode choisie: " + choix2);
                        break;
                }
            }
        }
        System.out.println("Merci d'avoir encrypter avec nous, à la prochaine!");
        sc.close();
    }
}