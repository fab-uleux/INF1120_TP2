public class ROT13_Code {
    public String rot13(String entree) {
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
                        break;
                    }
                }
            }
        }
        return new String(tab);
    }

    public String decrypteRot13(String entreeEncrypter) {
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
}