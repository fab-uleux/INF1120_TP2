public class ROT13_Code {
    public String rot13(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];
            for (int j = 0; j < alphabet.length; j++) {
                if (charactere == alphabet[j]) {
                    tab[i] = alphabet[(j + 13)%26];
                }
            }
        }
        return new String(tab);
    }

    public String decrypteRot13(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];
            for (int j = 0; j < alphabet.length; j++) {
                if (charactere == alphabet[j]) {
                    tab[i] = alphabet[(j - 13)%26];
                }
            }
        }
        return new String(tab);
    }
}