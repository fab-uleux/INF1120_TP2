import java.util.Random;

public class Cesar_Code {

    public String cesar(String entree) {
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

    public String cesarChoix(String entree, int decalage) {
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

    public String decrypteCesar(String entree, int decalage) {
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

}