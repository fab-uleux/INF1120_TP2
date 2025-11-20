public class CesarChoix_Code {
    public String cesarChoix(String entree, int decalage) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

            // Alphabet minuscule
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

            // Alphabet majuscule
            for (int j = 0; j < alphabetMaj.length; j++) {
                if (charactere == alphabetMaj[j]) {
                    int nouvelIndex = (j + decalage);
                    if (nouvelIndex < 0) {
                        nouvelIndex += 26;
                    }
                    tab[i] = alphabetMaj[nouvelIndex];
                    break;
                }
            }
        }
        return new String(tab);
    }
}