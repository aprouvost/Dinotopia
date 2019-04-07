import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Plateau extends JPanel {

  // Besoin prendre en compte tous les éléments pour la mise en place du monde sur l'IHM ( tel que la température  etc, ce dont on a parlé dans le cahier des charges)
    public int h ; // nombre de lignes du tableau ( hauteur)
    public int l; //nombre de colonnes du tableau ( largeur)
    public double densiteHerb;
    public double prop;
    public double propavant;
    public double propavantavant;
    public double densiteCarn;
    public Dinosaure [][] mondeDino;
    public int compteurTour;
    public boolean mondeStable=false;

    public Plateau ( int h, int l){
      this.h=h;
      this.l=l;
      this.prop= 0.;
      this.propavant = prop;
      this.propavantavant = prop;
      this.densiteHerb = 0.;
      this.densiteCarn=1. - densiteHerb;
      compteurTour = 0;
      //mondeDino= genererMondeAleatoire(h,l, prop, densiteHerb);
    }

    public void calcDens(){
      int comptH =0;
      int comptP =0;
      int comptC =0;
      for(int i=0;i<mondeDino.length;i++){
        for(int j=0;j<mondeDino[i].length;j++){
          if(mondeDino[i][j]!=null){
            if(mondeDino[i][j].type == "Herbivore"){
              comptH++;
            }
            else if (mondeDino[i][j].type == "Carnivore"){
              comptC++;
            }
          }
          else{
            comptP++;
          }
        }
      }
      this.prop = 1-(double)(comptP)/(double)(l*h);
      this.densiteCarn = (double)(comptC)/(double)(comptC+comptH);
      this.densiteHerb = (double)(comptH)/(double)(comptC+comptH);
    }

    public void nouvelleGeneration()
    {
      this.mondeDino = genererMondeAleatoire(h,l,prop,densiteHerb);
    }
    /** Genere un monde aleatoire, ordonné dans un tableau.
    Chaque case du tableau contient un dinosaure
    * @param h Hauteur du monde
    * @param l Largeur du monde
    * @param p proportion vivants
    * @return monde nouvellement cree, tableau 2D de Dinosaures
    */

    private Dinosaure [][] genererMondeAleatoire(int h, int l, double prop, double densiteHerb){
        	Dinosaure[][] monde= new Dinosaure[h][l];
          double nombreHerbivores=0;
          double nombreCarnivores=0;
          for (int i=0; i<l; i++){
        		for (int j=0; j<h; j++){
              double variableUn= Math.random();
              if ( variableUn< prop){
                double variableDeux= Math.random();
                if ( variableDeux< densiteHerb){
                  monde[i][j]= new Herbivore(0.2);
                  nombreHerbivores++;
                } else{
                  monde[i][j]= new Carnivore (0.7);
                  nombreCarnivores++;
                }
              }
            }
         }
           return monde;
         }


    // Permet de dessiner sur le plateau les dinos
    public void paintComponent(Graphics g){
      // Affiche une image (background) avec gestion exception
      try {
        g.drawImage(ImageIO.read(new File("img/fond.jpg")),0,0,1366,768,this);
        g.setColor(Color.black);
        int n = 40; //écart entre les lignes
        for(int i=0; i<h; i++){
            for(int j=0; j<l;j++){
              if (mondeDino[i][j]!=null){
                if (mondeDino[i][j].type=="Herbivore"){
                  g.drawImage(ImageIO.read(new File("img/dino2.png")),(80+i*(h*2-10)),(40+j*(l*2-10)),this);
                }
                else{
                  g.drawImage(ImageIO.read(new File("img/dino1.png")),(80+i*(h*2-10)),(40+j*(l*2-10)),this);
                }
              }
              else{
                g.drawImage(ImageIO.read(new File("img/herbe3.jpg")),(80+i*(h*2-10)),(40+j*(l*2-10)),this);
              }
          }
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void AffichePlateau(){
  		this.setVisible(true);
  	}
    public void CachePlateau(){
  		this.setVisible(false);
  	}

    // Permet effacer le terminal
    public static void effaceEcran() {
        String ESC = "\033[";
        System.out.print(ESC+"2J");
        System.out.print(ESC+"0;0H");
        System.out.flush();
    }

    public boolean mondeVivant(){
      boolean estVivant= false;
      for (int i=0; i<l; i++){
        for (int j=0; j<h; j++){
          if (mondeDino[i][j] != null){
              estVivant = true;
          }
        }
      }
      return estVivant;
    }


    /** Permet de trouver la premiere case libre autour de lui
    * @return tableau avec en première case la ligne, dans la deuxième la colonne
    */
    public int[][] trouverCaseLibre(int x,int y){
      int[][] tab= new int[8][2]; // 8 cases libres au maximum autour de lui
      int nombre=0; // nombre de cases libres trouvées
      for(int i =x-1; i <= x+1; i++){
          for(int k = y-1; k<= y+1; k++){
              if(i>0 && k>0 && i<l && k<h && mondeDino[i][k].outOfBounds(mondeDino,i,k) == false && (i == x) ==false &&( k == y)== false){
                  if(mondeDino[i][k] == null )
                       tab[nombre][0]=i;
                       tab[nombre][1]=k;
                       nombre++;
                  }
                }
              }
        return tab;
       }

       public static boolean outOfBounds(Dinosaure [][]m, int h, int l){ // Fonction prenant en parametre le plateau de jeu et ses dimensions
               boolean ret = false;
               if(h > m.length || h <= 0){
                   ret = true;
                }
              else if(l > m[h].length || l <= 0){
                   ret = true;
               }
           return ret;
        }




        /** Parcours du tableau et intéraction entre les différents Herbivores
        * @param i l'abscisse du dino
        * @param j l'ordonnée du dino
        * @return un boolean, si le dinosaure a survecu
        */

        public boolean interactionHerbi(int i, int j){
            mondeDino[i][j].retirerVieDinosaure( ((mondeDino[i][j].chanceCarni)*(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)))+
                                                  ((mondeDino[i][j].chanceHerb)*(mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j))));

            return !mondeDino[i][j].dinoIsDead();
        }




        /** Parcours du tableau et fait des bébés si 2 herbi à cotés
        * @param i l'abscisse du dino
        * @param j l'ordonnée du dino
        * @return rien, modifie directement le tableau
        */
        public void bebeHerbi( int i, int j){
          int voisins=mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)+mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j);
          int voiHerb=mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j);
          if(voiHerb>1 ){
             int [][] positionLibre=trouverCaseLibre(i,j);
              int parcours= (int)((8-voisins)*Math.random());
              mondeDino[positionLibre[parcours][0]][positionLibre[parcours][1]]= new Herbivore (0.3);
           }
        }


        /** Parcours du tableau et intéraction entre les différents Carnivores
        * @param i l'abscisse du dino
        * @param j l'ordonnée du dino
        * @return un boolean, si le dinosaure a survecu
        */
        public boolean interactionCarni( int i, int j){
            mondeDino[i][j].retirerVieDinosaure( (mondeDino[i][j].chanceHerb * mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j) )+
                                                  (mondeDino[i][j].chanceCarni * mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)));
            return !mondeDino[i][j].dinoIsDead();
        }



        /** Parcours du tableau et fait des bébés si 2 carni à cotés
        * @param i l'abscisse du dino
        * @param j l'ordonnée du dino
        * @return rien, modifie directement le tableau
        */

        public void bebeCarni ( int i, int j){

          int voisins=mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)+mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j);
         int voiCarni= mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j);

          if(voiCarni>1 ){
            int [][] positionLibreBis=trouverCaseLibre(i,j);
            int parcours= (int)((8-voisins)*Math.random());
            mondeDino[positionLibreBis[parcours][0]][positionLibreBis[parcours][1]]= new Carnivore (0.3);
          }
        }

        /** Parcours du tableau et intéraction entre les différents dinosaures
        * @param
        * @return rien, modifie directement le tableau
        */

  public void parcoursTab(){
    Dinosaure [][] nouveauMonde = new Dinosaure[mondeDino.length][mondeDino[0].length];
    // faire toutes les interactions qui peuvent tuer des dinos
    for(int i=0; i<h; i++){
      for(int j=0; j<l;j++){
        if(mondeDino[i][j]!=null){
          if(mondeDino[i][j].type == "Herbivore"){
            if(interactionHerbi(i,j)){ // si il a survecu
              nouveauMonde[i][j] = mondeDino[i][j];
            }
          }
          else if (mondeDino[i][j].type == "Carnivore"){
            if(interactionCarni(i,j)){ // si il a survecu
              nouveauMonde[i][j] = mondeDino[i][j];
            }
          }
        }
      }
    }
    mondeDino = nouveauMonde; // prendre le nouveau monde avec les intéractions appliquées comme référence
    // creation des nouveaux dinos
    for(int i=0; i<h; i++){
      for(int j=0; j<l;j++){
        if(mondeDino[i][j]!=null){
          if(mondeDino[i][j].type == "Herbivore"){
            bebeHerbi(i,j);
          }
          else if (mondeDino[i][j].type == "Carnivore"){
            bebeCarni(i,j);
          }
        }
      }
    }
  }

    public int getH() {
	  return h;
  }

  public int getL() {
	  return l;
  }

  public double getProp() {
	  return prop;
  }

  public double getDensiteHerb() {
	  return densiteHerb;
  }

  public double getDensiteCarn() {
	  return densiteCarn;
  }

  public Dinosaure [][] getMondeDino() {
	  return mondeDino;
  }
  public void compteurPlus(){
    compteurTour++;
  }

  public int getCompteur(){
    return this.compteurTour;
  }

  public void leMondeEstStable() {
	  if(mondeVivant()==true) {
		  double vivants = 0;
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  if(mondeDino[i][j]!=null) {
					  vivants++;
				  }

			  }
		  }
		  propavantavant = propavant;
		  propavant = prop;
		  prop = vivants/h*l;
	  }



	  if(prop==propavant && prop==propavantavant) {
		  mondeStable = true;
      System.out.println("Stable");
	  }


  }

  public void monteeDesEaux(){

    for (int i=0; i<l; i++){
      for (int j=0; j<h; j++){
        if ( mondeDino[i][j]!= null){
        if ( mondeDino[i][j].type == "Herbivore"){
          mondeDino[i][j].retirerVieDinosaure(10);
        }
        else {
          mondeDino[i][j].retirerVieDinosaure(15);
          }
        }
      }
    }
  }


  public void meteorite(){
    for (int i=0; i<l; i++){
      for (int j=0; j<h; j++){
        if ( mondeDino[i][j]!= null){
        mondeDino[i][j].retirerVieDinosaure(30);
        }
      }
    }
  }


  public void secheresse(){
    for (int i=0; i<l; i++){
      for (int j=0; j<h; j++){
        if ( mondeDino[i][j]!= null){
        if ( mondeDino[i][j].type == "Herbivore"){
          mondeDino[i][j].retirerVieDinosaure(30);
        }
        else {
          mondeDino[i][j].retirerVieDinosaure(20);
          }
        }
      }
    }
  }

  public void setProp( double prop){
    this.prop=prop;
  }

  public void setDensiteHerb( double densHerb){
    this.densiteHerb=densHerb;
    this.densiteCarn=1-densHerb;
  }





}
