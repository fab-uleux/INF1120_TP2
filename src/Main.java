import java.util.Scanner;
import java.util.Random;

public class Main {

    //J'ai pas réussi à passer le decalage pour la décryption autrement
    static int decalageGlobal = 0;

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

    // Afficher message original
    public static void afficherMessage(String message) {
        System.out.println(
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "~ Message original: "+ message +"\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        );
    }
    // Afficher message crypté
    public static void afficherMessageCrypte(String messageCrypte) {
        System.out.println(
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "~ Message crypté: "+ messageCrypte +"\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        );
    }
    // Afficher message décrypté
    public static void afficherMessageDecrypte(String messageDecrypte) {
        System.out.println(
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "~ Message de-crypté: "+ messageDecrypte +"\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        );
    }

    public static String randomTexte() {
        char[] alphabetRnd = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
        Random rnd = new Random();
        int longueur = rnd.nextInt(3, 21);

        String texte = "";
        for (int i = 0; i < longueur; i++) {
            texte += alphabetRnd[rnd.nextInt(alphabetRnd.length)];
        }

        System.out.println("Texte généré sans symbole: " + texte);
        return texte;
    }

    public static String randomTexteSymbole() {
        char[] alphabetSymboleRnd = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789)(*&^%$#@!?".toCharArray();
        Random rnd = new Random();
        int longueur = rnd.nextInt(3, 21);

        String texte = "";
        for (int i = 0; i < longueur; i++) {
            texte += alphabetSymboleRnd[rnd.nextInt(alphabetSymboleRnd.length)];
        }

        System.out.println("Texte généré avec symbole: " + texte);
        return texte;
    }

    // Validation pour ROT-13, César et César au choix (lettres alphabétiques et espace uniquement)
    public static boolean validerCaracteresSimple(String texte) {
        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);
            // Accepte uniquement les lettres (a-z, A-Z) et l'espace
            if (!Character.isLetter(caractere) && caractere != ' ') {
                System.out.println(" Veuillez seulement utilisé les lettres alphabétiques et espace");
                return false;
            }
        }
        return true;
    }

    // Validation pour Poly-Alphavariante (lettres, chiffres, espace et caractères spécifiques)
    public static boolean validerCaracteresPolyAlpha(String texte) {
        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);
            int ascii = (int) caractere;

            boolean valide = false;

            // Accepte lettres, chiffres et espace
            if (Character.isLetterOrDigit(caractere) || caractere == ' ') {
                valide = true;
            }

            // Accepte les caractères spéciaux dans les intervalles
            if ((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 64) || (ascii >= 123 && ascii <= 126)) {
                valide = true;
            }

            // Si le caractère n'est pas valide
            if (!valide) {
                System.out.println("Caractère non valide pour Poly-Alphavariante");
                System.out.println("Veuillez entré une lettres, un chiffres, un espace ou caractères spéciaux accepter");
                return false;
            }
        }
        return true;
    }

    //ROT13
    public static String Rot13_TUF(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char caractere = tab[i];

            // l'alphabet minuscule
            for (int j = 0; j < alphabet.length; j++) {
                if (caractere == alphabet[j]) {
                    tab[i] = alphabet[(j + 13) % 26];
                }
            }
            // l'alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (caractere == alphabetMaj[j]) {
                    tab[i] = alphabetMaj[(j + 13) % 26];
                }
            }
        }
        return new String(tab);
    }

    public static String DecrypteRot13_TUF(String entreeEncrypter) {
        char[] tab = entreeEncrypter.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char caractere = tab[i];

            // l'alphabet minuscule
            for (int j = 0; j < alphabet.length; j++) {
                if (caractere == alphabet[j]) {
                    tab[i] = alphabet[(j - 13 + 26) % 26];
                }
            }
            // l'alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (caractere == alphabetMaj[j]) {
                    tab[i] = alphabetMaj[(j - 13 + 26) % 26];
                }
            }
        }
        return new String(tab);
    }

    public static String Cesar_TUF(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        Random rnd = new Random();
        decalageGlobal = rnd.nextInt(1, 26);
        int decalage = decalageGlobal;
//        System.out.println("Cesar decalage"+decalage);

        for (int i = 0; i < tab.length; i++) {
            char caractere = tab[i];

            // l'alphabet minuscule
            for (int j = 0; j < alphabet.length; j++) {
                if (caractere == alphabet[j]) {
                    tab[i] = alphabet[(j + decalage) % 26];
                }
            }
            // l'alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (caractere == alphabetMaj[j]) {
                    tab[i] = alphabetMaj[(j + decalage) % 26];
                }
            }
        }
        return new String(tab);
    }

    public static String CesarChoix_TUF(String entree, int decalage) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

//        System.out.println("Cesar choix decalage"+decalage);
        for (int i = 0; i < tab.length; i++) {
            char caractere = tab[i];

            // l'alphabet minuscule
            for (int j = 0; j < alphabet.length; j++) {
                if (caractere == alphabet[j]) {
                    int k = (j + decalage) % 26;
                    if (k < 0) {
                        k += 26;
                    }
                    tab[i] = alphabet[k];
                }
            }
            // l'alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (caractere == alphabetMaj[j]) {
                    int k = (j + decalage) % 26;
                    if (k < 0) {
                        k += 26;
                    }
                    tab[i] = alphabetMaj[k];
                }
            }
        }
        return new String(tab);
    }

    public static String DecrypteCesar_TUF(String entree, int decalage) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < tab.length; i++) {
            char caractere = tab[i];

            // l'alphabet minuscule
            for (int j = 0; j < alphabet.length; j++) {
                if (caractere == alphabet[j]) {
                    int k = (j + decalage + 26) % 26;
                    tab[i] = alphabet[k];
                }
            }

            // l'alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (caractere == alphabetMaj[j]) {
                    int k = (j + decalage + 26) % 26;
                    tab[i] = alphabetMaj[k];
                }
            }
        }
        return new String(tab);
    }

    public static String PolyAlpha_TUF(String entree) {
        String resultat = "";

        for (int i = 0; i < entree.length(); i++) {
            char caractere = entree.charAt(i);

            // Garde espace telle quel
            if (caractere == ' ') {
                resultat += ' ';
            }
            // Remplacer les voyelles par des symboles
            else if (caractere == 'a' || caractere == 'A') {
                resultat += '+';
            } else if (caractere == 'e' || caractere == 'E') {
                resultat += '=';
            } else if (caractere == 'i' || caractere == 'I') {
                resultat += '&';
            } else if (caractere == 'o' || caractere == 'O') {
                resultat += '*';
            } else if (caractere == 'u' || caractere == 'U') {
                resultat += '!';
            } else if (caractere == 'y' || caractere == 'Y') {
                resultat += '$';
            } else if (caractere >= '0' && caractere <= '9') {
                resultat += (char) ('9' - (caractere - '0'));
            } else if (caractere >= 'a' && caractere <= 'z') {
                resultat += (char) (((caractere - 'a' + 4) % 26) + 'a');
            } else if (caractere >= 'A' && caractere <= 'Z') {
                resultat += (char) (((caractere - 'A' + 4) % 26) + 'A');
            } else {
                resultat += '?';
                resultat += caractere;
            }
        }
        return resultat;
    }

    public static String DecryptePolyAlpha_TUF(String entree) {
        String resultat = "";

        for (int i = 0; i < entree.length(); i++) {
            char caractere = entree.charAt(i);

            // Inverser les symboles des voyelles
            if (caractere == '+') {
                resultat += 'a';
            } else if (caractere == '=') {
                resultat += 'e';
            } else if (caractere == '&') {
                resultat += 'i';
            } else if (caractere == '*') {
                resultat += 'o';
            } else if (caractere == '!') {
                resultat += 'u';
            } else if (caractere == '$') {
                resultat += 'y';
            } else if (caractere >= '0' && caractere <= '9') {
                resultat += (char) ('9' - (caractere - '0'));
            } else if (caractere >= 'a' && caractere <= 'z') {
                resultat += (char) (((caractere - 'a' - 4 + 26) % 26) + 'a');
            } else if (caractere >= 'A' && caractere <= 'Z') {
                resultat += (char) (((caractere - 'A' - 4 + 26) % 26) + 'A');
            } else if (caractere == '?') {
                i++;
                resultat += entree.charAt(i);
            } else if (caractere == ' ') {
                resultat += ' ';
            } else {
                resultat += caractere;
            }
        }
        return resultat;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String entree = "";
        String entreeSymbole = "";

        String entreeEncrypter = "";
        String entreeSymboleEncrypter = "";
        int decalage = 0;

        boolean menuQuitter = true;

        while(menuQuitter){
            // Réinitialiser les variables pour chaque cycle
            boolean continuerMenu1 = true;
            boolean continuerMenu2 = true;

            //Appelle du premier menu et lecture de la réponse
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
                        entree = randomTexte();
                        entreeSymbole = randomTexteSymbole();
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
                        if (validerCaracteresSimple(entree)) {
                            String resultatRot13 = Rot13_TUF(entree);
                            afficherMessageCrypte(resultatRot13);
                            entreeEncrypter = resultatRot13;

                            menu3();
                            int choixDecrypt = sc.nextInt();
                            sc.nextLine();

                            if(choixDecrypt == 1) {
                                String messageDecrypte = DecrypteRot13_TUF(entreeEncrypter);
                                afficherMessageDecrypte(messageDecrypte);
                            }
                        }
                        continuerMenu2 = false;
                        break;
                    case 2:
                        System.out.println("Le chiffre César");
                        if (validerCaracteresSimple(entree)) {
//                            System.out.println("Switch choix Cesar decalage"+decalage);
                            String resultat = Cesar_TUF(entree);
                            afficherMessageCrypte(resultat);
                            entreeEncrypter = resultat;

                            menu3();
                            int choixDecrypt = sc.nextInt();
                            sc.nextLine();

                            if(choixDecrypt == 1) {
                                int decalageDecrypt = -decalageGlobal;
                                String messageDecrypte = DecrypteCesar_TUF(entreeEncrypter, decalageDecrypt);
                                afficherMessageDecrypte(messageDecrypte);
                            }
                        }
                        continuerMenu2 = false;
                        break;
                    case 3:
                        System.out.println("César au choix");
                        if (validerCaracteresSimple(entree)) {

                            System.out.println("Entrez le nombre de lettres valide netre 1 et 25:");
                            decalage = sc.nextInt();
                            sc.nextLine();

                            if(decalage < 1 || decalage > 25){
                                System.out.println("Veuillez entrer un nombre valide entre 1 et 25");
                                continuerMenu2 = false;
                                break;
                            }

                            System.out.println("Direction: (1) Droite ou (2) Gauche?");
                            int direction = sc.nextInt();
                            sc.nextLine();

                            if (direction == 2) {
                                decalage = -decalage;
                            }

                            String resultatCesarChoix = CesarChoix_TUF(entree, decalage);
                            afficherMessageCrypte(resultatCesarChoix);
                            entreeEncrypter = resultatCesarChoix;

                            menu3();
                            int choixDecrypt = sc.nextInt();
                            sc.nextLine();

                            if(choixDecrypt == 1) {
                                int decalageDecrypt = -decalage;
                                String messageDecrypte = DecrypteCesar_TUF(entreeEncrypter, decalageDecrypt);
                                afficherMessageDecrypte(messageDecrypte);
                            }

                            continuerMenu2 = false;
                        }
                        break;
                    case 4:
                        System.out.println("Le Poly-Alphavariante");
                        //Pour garder la logique entree/entreeSymbole dans Random
                        if (entreeSymbole.equals("")) {
                            entreeSymbole = entree;
                        }

                        if (validerCaracteresPolyAlpha(entreeSymbole)) {
                            String resultaPolyAlpha = PolyAlpha_TUF(entreeSymbole);
                            afficherMessageCrypte(resultaPolyAlpha);
                            entreeEncrypter = resultaPolyAlpha;

                            menu3();
                            int choixDecrypt = sc.nextInt();
                            sc.nextLine();

                            if(choixDecrypt == 1) {
                                String messageDecrypte = DecryptePolyAlpha_TUF(entreeEncrypter);
                                afficherMessageDecrypte(messageDecrypte);
                            }

                            continuerMenu2 = false;
                        }
                        break;
                    case 5:
                        System.out.println("Je sais pas");
                        Random rnd2 = new Random();
                        choix2 = rnd2.nextInt(1, 5);
                        System.out.println("Encryption choisie: " + choix2);
                        break;
                }
            }
        }
        System.out.println("Merci d'avoir encrypter avec nous, à la prochaine!");
        sc.close();
    }
}