
public class Plateau {

  // Besoin prendre en compte tous les éléments pour la mise en place du monde sur l'IHM ( tel que la température  etc là, ce dont on a parlé dans le cahier des charges)
    private int h ; // nombre de lignes du tableau ( hauteur)
    private int l; //nombre de colonnes du tableau ( largeur)
    public double probaHerb;
    public double prop;
    private Dinosaure [][] mondeDino;

    public Plateau ( int h, int l , double prop, double probaHerb){
      this.h=h;
      this.l=l;
      this.prop= prop;
      this.probaHerb= probaHerb;
      mondeDino = genererMondeAleatoire(h,l, prop, probaHerb);
    }


    /** Genere un monde aleatoire, ordonné dans un tableau.
    Chaque case du tableau contient un dinosaure
    * @param h Hauteur du monde
    * @param l Largeur du monde
    * @param p proportion vivants
    * @return monde nouvellement cree, tableau 2D de Dinosaures
    */
    public static Dinosaure [][] genererMondeAleatoire(int h, int l, double prop, double probaHerb){
      Dinosaure[][] monde= new Dinosaure[h][l];
      int variable=0;
      int vivants=0;
      int proba= 0;
      int probaHerbCrees=0;
      int herbi=0;
      int carni=0;
      for (int i=0; i<l; i++){
        for (int j=0; j<h; j++){
          while ( proba<= prop && probaHerbCrees< probaHerb){
            variable= (int)Math.random();
            if (variable< 0.5){
            //  monde[i][j]=;  // ICI besoin créer un dinosaure herbivore derrière le =
              vivants++;
              herbi++;
              proba= vivants/(h*l);
              probaHerbCrees= herbi/vivants;
            }else{
            //  monde[i][j]= ;  // ICI besoin créer un dinosaure carnivore derrière le =
              vivants++;
              carni++;
              proba= vivants/(h*l );
          }
        }
    }
  }
  return monde;
}


// Permet effacer le terminal
  public static void effaceEcran() {
      String ESC = "\033[";
      System.out.print(ESC+"2J");
      System.out.print(ESC+"0;0H");
      System.out.flush();
  }





}
