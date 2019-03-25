import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Plateau extends JPanel {

  // Besoin prendre en compte tous les éléments pour la mise en place du monde sur l'IHM ( tel que la température  etc, ce dont on a parlé dans le cahier des charges)
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
      mondeDino= genererMondeAleatoire(h,l, prop, densiteHerb);
    }


    /** Genere un monde aleatoire, ordonné dans un tableau.
    Chaque case du tableau contient un dinosaure
    * @param h Hauteur du monde
    * @param l Largeur du monde
    * @param p proportion vivants
    * @return monde nouvellement cree, tableau 2D de Dinosaures
    */

    public static Dinosaure [][] genererMondeAleatoire(int h, int l, double prop, double densiteHerb){
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
      //    System.out.println("densité herbivores" +nombreHerbivores/(prop*h*l) +" voulu à"+ densiteHerb);
      //    System.out.println(" densité carnivores"+ nombreCarnivores/(h*l)+" voulu à"+ 1-densiteHerb);
      //    System.out.println(" prop de"+ (nombreCarnivores+nombreHerbivores)/(h*l)+ "voulu à"+ prop);
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
        * @return rien, modifie directement le tableau
        */

        public void interactionHerbi(int i, int j){
        //  if(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)>0){
            mondeDino[i][j].retirerVieDinosaure(1+ (int)(Math.random()*32)+ (mondeDino[i][j].chanceCarni)*(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)));
            if (mondeDino[i][j].dinoIsDead()==true){
              mondeDino[i][j]=null;
            }
        //  }
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
             //if ( positionLibre[0][0]!=0 && positionLibre[0][1]!=0){

               int parcours= (int)((8-voisins)*Math.random());
               mondeDino[positionLibre[parcours][0]][positionLibre[parcours][1]]= new Herbivore (0.3);
               /*System.out.print( "parent en ");
               System.out.print(i+",");
               System.out.println(j);
               System.out.print( "bebe Herb en "+positionLibre[parcours][0]+"," );
               System.out.println(positionLibre[parcours][1]);
               System.out.println();*/

           }
        }


        /** Parcours du tableau et intéraction entre les différents Carnivores
        * @param i l'abscisse du dino
        * @param j l'ordonnée du dino
        * @return rien, modifie directement le tableau
        */
        public void interactionCarni( int i, int j){
        //  if(mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j)>0){
             mondeDino[i][j].retirerVieDinosaure( (int)(Math.random()*32)+(mondeDino[i][j].chanceCarni)*(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)));
             if (mondeDino[i][j].dinoIsDead()==true){
             mondeDino[i][j]=null;
             }
        //   }
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
         // if ( positionLibreBis[0][0]>0 && positionLibreBis[0][1]>0){
            int parcours= (int)((8-voisins)*Math.random());
            mondeDino[positionLibreBis[parcours][0]][positionLibreBis[parcours][1]]= new Carnivore (0.3);
            /*System.out.print( "parent en ");
            System.out.print(i+",");
            System.out.println(j);
            System.out.print( "bebe Carn en "+positionLibreBis[parcours][0]+"," );
            System.out.println(positionLibreBis[parcours][1]);
            System.out.println();*/


          }
        }






        /** Parcours du tableau et intéraction entre les différents dinosaures
        * @param
        * @return rien, modifie directement le tableau
        */

  public void parcoursTab(){

    for(int i=0; i<h; i++){
        for(int j=0; j<l;j++){
          if(mondeDino[i][j]!= null && mondeDino[i][j].type== "Herbivore"){
            interactionHerbi(i,j);
            bebeHerbi(i,j);
            }

          if(mondeDino[i][j]!= null && mondeDino[i][j].type== "Carnivore"){
             interactionCarni(i,j);
             bebeCarni(i,j);
          }
        }
      }
    }




}
