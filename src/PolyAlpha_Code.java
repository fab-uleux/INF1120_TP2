public class PolyAlpha_Code {
    public String polyAlpha(String entree) {
        char[] tab = entree.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] voyelleToSymbole = "+=&*!$".toCharArray();
        char[] voyelle = "aeiou".toCharArray();
        char[] nombre = "0123456789".toCharArray();
        char[] nombreRev = "9876543210".toCharArray();

        for (int i = 0; i < tab.length; i++) {
            char charactere = tab[i];

//            for (int j = 0; j < alphabet.length; j++) {
//                if (charactere == alphabet[j]) {
//                    tab[i] = alphabet[(j + 13)%26];
//                }
//            }
        }
        return new String(tab);
    }
}
