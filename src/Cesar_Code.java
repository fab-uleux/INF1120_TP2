import java.util.Random;

public class Cesar_Code {
    public String cesar(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // Générer un décalage aléatoire entre 1 et 25
        Random rnd = new Random();
        int decalage = rnd.nextInt(1, 26); // Entre 1 et 25

        System.out.println("Décalage aléatoire: " + decalage);

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

            // Alphabet minuscule
            for (int j = 0; j < alphabet.length; j++) {
                if (charactere == alphabet[j]) {
                    int nouvelIndex = (j + decalage) % 26;
                    tab[i] = alphabet[nouvelIndex];
                    break;
                }
            }

            // Alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (charactere == alphabetMaj[j]) {
                    int nouvelIndex = (j + decalage) % 26;
                    tab[i] = alphabetMaj[nouvelIndex];
                    break;
                }
            }
        }
        return new String(tab);
    }
}