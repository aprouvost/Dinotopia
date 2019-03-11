import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Plateau extends JPanel {

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
          /*while ( proba<= prop && densiteHerbCrees< densiteHerb && densiteCarnCrees<densiteCarn){
            variable= (int)Math.random();
            if (variable< 0.9){
              monde[i][j]=new Herbivore(0.2);
              vivants++;
              herbi++;
              proba= vivants/(h*l);
              densiteHerbCrees= herbi/vivants;
            }else{*/
              monde[i][j]= new Carnivore(0.3);
            /*  vivants++;
              carni++;
              proba= vivants/(h*l );
              densiteCarnCrees= carni/vivants;*/
            }
          }/*
        }
      }*/
      return monde;
    }
    



    // Permet de dessiner sur le plateau les dinos
    public void paintComponent(Graphics g){
      // Affiche une image (background) avec gestion exception
      try {
        Image img = ImageIO.read(new File("img/fond.jpg"));
        g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      g.setColor(Color.black);
      int n = 40; //écart entre les lignes
      for(int i=0; i<h; i++){
          for(int j=0; j<l;j++){
              if(mondeDino[i][j]!=null)
                  g.drawString("O",(40+i*h),(40+j*l));
              else
                  g.drawString("T",(40+i*h),(40+j*l));
          }
      }
    }

// Permet effacer le terminal
    public static void effaceEcran() {
        String ESC = "\033[";
        System.out.print(ESC+"2J");
        System.out.print(ESC+"0;0H");
        System.out.flush();
    }


    /** Permet de trouver la premiere case libre autour de lui
    * @return tableau avec en première case la ligne, dans la deuxième la colonne
    */
 public int[] trouverCaseLibre(int h,int l){
   int[] tab= new int[2];
   for(int i =h-1; i <= h+1; i++){
       for(int k = l-1; k<= l+1; k++){
           if(mondeDino[i][k].outOfBounds(mondeDino,i,k) == false && (i == h && k == l) ==false){
               if(mondeDino[i][k] == null )
                    tab[0]=i;
                    tab[1]=k;
                 }
             }
           }
     return tab;
    }



  public void  parcoursTab(){
    for(int i=0; i<h; i++){
        for(int j=0; j<l;j++){
          if(mondeDino[i][j].type== "Herbivore"){
              if(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)>0){
                mondeDino[i][j].retirerVieDinosaure( (mondeDino[i][j].chanceCarni)*(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)));
              }
              if(mondeDino[i][j].nbrVoisinHerbi( mondeDino, i, j)>1 ){
                int [] positionLibre=trouverCaseLibre(i,j);
                if ( positionLibre[0]!=0 && positionLibre[0]!=0){
                  mondeDino[trouverCaseLibre(i,j)[0]][trouverCaseLibre(i,j)[1]]= new Herbivore (0.3);
                }
                }
              }
          if(mondeDino[i][j].type== "Carnivore "){
              if(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)>0){
                mondeDino[i][j].retirerVieDinosaure( (mondeDino[i][j].chanceCarni)*(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)));
            }
              if(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)>2){
                int [] positionLibre=trouverCaseLibre(i,j);
                if ( positionLibre[0]!=0 && positionLibre[0]!=0){
                  mondeDino[trouverCaseLibre(i,j)[0]][trouverCaseLibre(i,j)[1]]= new Carnivore (0.3);
                }
          }

        }
      }

}
}
}
