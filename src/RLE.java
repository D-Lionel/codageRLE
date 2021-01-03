public class RLE {
// Cet algorithme permet de compresser un message en comptant les lettres voisines similaires
    public static String compressor(String str){
        int compt = 1; // compteur pour le nombre de lettres voisines qui se répètent
        char char_courant;
        char char_precedent;
        String resultat = "";

        for(int i = 1; i < str.length(); i++){ // on parcourt la chaîne de caractères
            char_courant = str.charAt(i);
            char_precedent = str.charAt(i-1);
            if (char_courant == char_precedent){ //si la lettre qu'on parcourt est la même que la lettre précédente
                compt++; //on incrémente le compteur
            }else{ // sinon, la lettre qu'on parcourt n'est pas la même que la lettre précédente
                if (compt == 1){
                    resultat = resultat + char_precedent; // si elle est seule, on ajoute à notre résultat la lettre précédente seule
                }else{
                    resultat = resultat + compt + char_precedent; // sinon, on ajoute à notre résultat le nombre de fois que la lettre précédente est répétée
                }

                compt = 1; // on réinitialise le compteur à 1 pour compter la lettre suivante
            }
            if (i == str.length()-1){ // quand on arrive à la fin de la chaîne de caractère
                if (compt == 1){
                    resultat = resultat + char_courant; //si la lettre qu'on parcourt est seule, on ajoute à notre résultat la lettre précédente seule
                }else{
                    resultat = resultat + compt + char_courant; // sinon, on ajoute à notre résultat le nombre de fois que la lettre précédente est répétée
                }
            }
        }
        return resultat;
    }

    public static String decompressor(String str){
        String char_courant;
        String char_suivant;
        String resultat = "";
        for(int i = 0; i < str.length()-2; i++){
            char_courant = ""+str.charAt(i);
            char_suivant = ""+str.charAt(i+1);
            //Si le caractère courant est un nombre, on affiche le caractère suivant fois le nombre du caractère courant
            if(isInt(char_courant)){
                for(int j = 0; j < Integer.parseInt(char_courant)-1; j++){ // boucle sur le nombre rencontré pour répéter la lettre
                    resultat = resultat + char_suivant;
                }
            }else{
                resultat = resultat + char_courant;
            }

        }
        // quand on arrive à l'avant dernière lettre de la chaine de caractères
        char_courant = ""+str.charAt(str.length()-2);
        char_suivant = ""+str.charAt(str.length()-1);
        if(isInt(char_courant)){
            for(int j = 0; j < Integer.parseInt(char_courant); j++){
                resultat = resultat + char_suivant;
            }
        }else{
            resultat = resultat + char_courant;
        }

        //resultat = resultat + str.charAt(str.length() - 1);
        return resultat;
    }

    public static boolean isInt(String str) { // détecter qu'un caractère est un nombre entier

        try {
            int x = Integer.parseInt(str);
            return true; //String is an Integer
        } catch (NumberFormatException e) {
            return false; //String is not an Integer
        }

    }
    public static void main(String[] args) {
        System.out.println(compressor("Cooooompression de leeeeettressss multiiiiplesss"));
        System.out.println(decompressor("C5ompre2sion de l5e2tre4s mult4iple3s"));
    }
}
