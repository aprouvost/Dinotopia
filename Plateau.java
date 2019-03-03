import java util Scanner;

public class Plateau {
    private int h ; // nombre de lignes du tableau ( hauteur)
    private int l; //nombre de colonnes du tableau ( largeur)

    public Plateau ( int h, int l , double prop){
      this.h=h;
      this.l=l;
      //this.prop=prop; prop à définir initialemt avec utilisateur 
      //Dinosaure[][]= new Dinosaure [h][l]
      Dinosaure[][]= new genererMondeAleatoire(h,l, prop)
    }
    /** Genere un monde aleatoire, ordonné dans un tableau.
    Chaque case du tableau contient un dinosaure
    * @param h Hauteur du monde
    * @param l Largeur du monde
    * @param p proportion herbivores
    * @return monde nouvellement cree
    */
    public static Dinosaure[][] genererMondeAleatoire(int h, int l, double p){
      Dinosaure[][] monde = new Dinosaure[h][l];
