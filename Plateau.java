import java util Scanner;
import java Math;

public class Plateau {

  // Besoin prendre en compte tous les éléments pour la mise en place du monde sur l'IHM ( tel que la température  etc là, ce dont on a parlé dans le cahier des charges)
    private int h ; // nombre de lignes du tableau ( hauteur)
    private int l; //nombre de colonnes du tableau ( largeur)

    public Plateau ( int h, int l , double prop){
      this.h=h;
      this.l=l;
      this.prop= prop;
      Dinosaure[][]= genererMondeAleatoire(h,l, prop)  // Loic on prend prop avec l'utilisateur qui le rentre dans les para initiaux?
    }


    /** Genere un monde aleatoire, ordonné dans un tableau.
    Chaque case du tableau contient un dinosaure
    * @param h Hauteur du monde
    * @param l Largeur du monde
    * @param p proportion vivants
    * @return monde nouvellement cree, tableau 2D de Dinosaures
    */
    public static boolean [][] genererMondeAleatoire(int hauteur, int largeur, double p, double probaHerb){
      boolean[][] monde= new boolean [hateur][largeur];
      int variable=0;
      int vivants=0;
      int proba= 0;
      int probaHerbCréés=0;
      int herbi=0;
      int carni=0;
      for (int i=0; i++; i< L){
        for (int j=0; j++; j< H){
          while ( proba<= p && probaHerbCréés< probaHerb){
            variable= Math.random();
            if (variable< 0.5){
              monde[i][j]=;  // ICI besoin créer un dinosaure herbivore derrière le =
              vivants++;
              herbi++;
              proba= vivants/(hauteur*largeur);
              probaHerbCréés= herbi/vivants;
            }else{
              monde[i][j]= ;  // ICI besoin créer un dinosaure carnivore derrière le =
              vivants++;
              carni++;
              proba= vivants/(hauteur*largeur);
          }
        }
    }
  }
}

  public static void effaceEcran() {
      String ESC = "\033[";
      System.out.print(ESC+"2J");
      System.out.print(ESC+"0;0H");
      System.out.flush();
  }





}
