import java.util.Random;

public class Cesar_Code {

    public String cesar(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Random rnd = new Random();
        int decalage = rnd.nextInt(0, 25);

        System.out.println("Décalage aléatoire: " + decalage);

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

            for (int j = 0; j < alphabet.length; j++) {
                if (charactere == alphabet[j]) {
                    int Index = (j + decalage) % 26;
                    tab[i] = alphabet[Index];
                    break;
                }
            }
        }
        return new String(tab);
    }

    public String cesarChoix(String entree, int decalage) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

            for (int j = 0; j < alphabet.length; j++) {
                if (charactere == alphabet[j]) {
                    int nouvelIndex = (j + decalage);
                    if (nouvelIndex < 0) {
                        nouvelIndex += 26;
                    }
                    tab[i] = alphabet[nouvelIndex];
                    break;
                }
            }
        }
        return new String(tab);
    }
}