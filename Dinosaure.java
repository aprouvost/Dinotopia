
public class Dinosaure {
    public String type ; // On indique si c'est un herbivore ou carnivore ( à définir dans les classes filles)
    public int age; // temps depuis lequel il est vivant ( en ms)
    public double pointsVie=100; // J'initialise à 100, à modifier plus tard

    public Dinosaure (String type){
      age=0; // initialise l'age à 0
      this.type= type;
    }

    public String toString(){
      return " Dinosaure de type"+ type+ " vivant depuis"+age;
    }

    /** Calcule le nombre de voisins d’une cellule.
    * @param monde tableau du monde ( rempli de dinosaures )
    * @param l indice de la ligne de la cellule
    * @param c indice de la colonne de la cellule
    * @return Nombre de voisins
    */

    public static int nbrVoisin(Dinosaure[][] m,int h, int l){
        int ret = 0;
        for(int i =h-1; i <= h+1; i++){
            for(int k = l-1; k<= l+1; k++){
                if(outOfBounds(m,i,k) == false && (i == h && k == l) ==false){
                    if(m[i][k] != null)
                        ret ++;
                      }
                  }
                }
          return ret; // retourne le nombre de voisins ( dans les cases voisines ) du dinosaure
        }

        /** Calcule à partir de la case indiquée si la case se situe sur le bord du plateau de jeu.
      	* @param monde tableau du monde ( rempli de dinosaures)
      	* @param h indice du nombre de lignes du tableau
      	* @param l indice du nombre de colonnes du tableau
      	* @return true si se situe au delà de l'extrémité
      	*/

    public static boolean outOfBounds(Dinosaure [][]m, int h, int l){ // Fonction prenant en parametre le plateau de jeu et ses dimensions
            boolean ret = false;
            if(h >= m.length || h < 0){
                ret = true;
                }
                else if(l >= m[h].length || l < 0){
                ret = true;
                }
                return ret;
              }

}
