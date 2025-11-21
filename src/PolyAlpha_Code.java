public class PolyAlpha_Code {

    public String polyAlpha(String entree) {
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
}
