public class Dinosaure {

    public String type ; // On indique si c'est un herbivore ou carnivore ( à définir dans les classes filles)
    public int age; // temps depuis lequel il est vivant ( en ms)
    public double pointsVie=50; // J'initialise à 50, à modifier plus tard
    public double chanceHerb;
    public double chanceCarni;

    public Dinosaure (String type, double chanceHerb, double chanceCarni){
      age=0; // initialise l'age à 0
      this.type= type;
      this.chanceHerb= chanceHerb;
      this.chanceCarni= chanceCarni;
    }


    public String toString(){
      return " Dinosaure de type"+ type+ " vivant depuis"+age;
    }



    /** Calcule le nombre de voisins Herbivores d’une cellule.
    * @param monde tableau du monde ( rempli de dinosaures )
    * @param l indice de la ligne de la cellule
    * @param c indice de la colonne de la cellule
    * @return Nombre de voisins
    */

    public static int nbrVoisinHerbi(Dinosaure[][] m,int h, int l){
        int ret = 0;
        for(int i =h-1; i <= h+1; i++){
            for(int k = l-1; k<= l+1; k++){
                if(outOfBounds(m,i,k) == false && (i == h && k == l) ==false){
                    if(m[i][k] != null && m[i][k].type=="Herbivore")
                        ret ++;
                      }
                  }
                }
          return ret; // retourne le nombre de voisins herbivores ( dans les cases voisines ) du dinosaure
        }

        public boolean dinoIsDead(){
          boolean isDead=false;
          if ( pointsVie<=0){
            return true;
          }else{
            return false;
          }
        }

        public static int nbrVoisinCarni(Dinosaure[][] m,int h, int l){
            int ret = 0;
            for(int i =h-1; i <= h+1; i++){
                for(int k = l-1; k<= l+1; k++){
                    if(outOfBounds(m,i,k) == false && (i == h && k == l) ==false){
                        if(m[i][k] != null && m[i][k].type=="Carnivore")
                            ret ++;
                          }
                      }
                    }
              return ret; // retourne le nombre de voisins carnivores ( dans les cases voisines ) du dinosaure
            }


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
            return ret; // retourne le nombre de voisins carnivores ( dans les cases voisines ) du dinosaure
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




      /** Permet au dinosaure d'attaquer.
      * @param chanceCarni la probabilite qu'il gagne le combat contre un carnivore
      * @param chanceHerbi la probabilité qu'il gagne le combat contre un Herbivore
      * @param adv l'adversaire qu'il attaque
      * @return la quantité de points de vie retirée à l'adversaire
      */
      public double attaque( Dinosaure adv){
          double pointsVieRetire=0;
          if (adv.type== "Herbivore"){
                      pointsVieRetire= this.chanceHerb*adv.pointsVie;
          }else{
              pointsVieRetire= this.chanceCarni*adv.pointsVie;
          }
          return pointsVieRetire;
          }



      /** Retire les points de vie à un adversaire
      * @param pointsARetirer les points à enlever à la vie de l'adversaire
      * @param adv l'adversaire à qui on retire la vie
      * @return la vie de l'adversaire après avoir subit l'attaque
      */
      public double retirerVieAdversaire( Dinosaure adv, double pointsARetirer){
        return adv.pointsVie- pointsARetirer;
      }




      /** Retire les points de vie au dinosaure
      * @param pointsARetirer les points à enlever
      * @return rien ( modifie directement les attributs de la classe)
      */
      public void retirerVieDinosaure(  double pointsARetirer){
           this.pointsVie= this.pointsVie- pointsARetirer;
       }


      /** ajoute au dinosaure les points de vie
      * @param pointsAAjouter les points à ajouter au dino
      * @return rien ( modifie directement les attributs de la classe)
      */
      public void ajouterVieDinosaure( double pointsAAjouter){
           this.pointsVie=this.pointsVie+ pointsAAjouter;
      }



}
