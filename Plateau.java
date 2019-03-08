
public class Plateau {

  // Besoin prendre en compte tous les éléments pour la mise en place du monde sur l'IHM ( tel que la température  etc là, ce dont on a parlé dans le cahier des charges)
    private int h ; // nombre de lignes du tableau ( hauteur)
    private int l; //nombre de colonnes du tableau ( largeur)
    public double densiteHerb;
    public double prop;
    public double densiteCarn;
    public Dinosaure [][] mondeDino;

    public Plateau ( int h, int l , double prop, double densiteHerb){
      this.h=h;
      this.l=l;
      this.prop= prop;
      this.densiteHerb= densiteHerb;
      this.densiteCarn=1- densiteHerb;
      mondeDino = genererMondeAleatoire(h,l, prop, densiteHerb, densiteCarn);
    }


    /** Genere un monde aleatoire, ordonné dans un tableau.
    Chaque case du tableau contient un dinosaure
    * @param h Hauteur du monde
    * @param l Largeur du monde
    * @param p proportion vivants
    * @return monde nouvellement cree, tableau 2D de Dinosaures
    */
    public static Dinosaure [][] genererMondeAleatoire(int h, int l, double prop, double densiteHerb, double densiteCarn){
      Dinosaure[][] monde= new Dinosaure[h][l];
      int variable=0;
      int vivants=0;
      double proba= 0;
      double densiteHerbCrees=0;
      double densiteCarnCrees=0;
      int herbi=0;
      int carni=0;
      for (int i=0; i<l; i++){
        for (int j=0; j<h; j++){
          while ( proba<= prop && densiteHerbCrees< densiteHerb && densiteCarnCrees<densiteCarn){
            variable= (int)Math.random();
            if (variable< 0.9){
              monde[i][j]=new Herbivore(0.2);
              vivants++;
              herbi++;
              proba= vivants/(h*l);
              densiteHerbCrees= herbi/vivants;
            }else{
              monde[i][j]= new Carnivore(0.3);
              vivants++;
              carni++;
              proba= vivants/(h*l );
              densiteCarnCrees= carni/vivants;
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

/*public void rendVivant(){
  for (int i=0; i<l; i++){
    for (int j=0; j<h; j++){
      if (mondeDino[i][j].nombreVoisins()!=0){

      }*/
}
