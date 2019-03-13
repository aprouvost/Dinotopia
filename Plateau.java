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

    	int vivants = (int)prop*(h*l); //calcul de la proportion de vivants � mettre sur le plateau
    	int herbi = (int)densiteHerb*vivants; //calcul du nombre d'herbis � placer
    	int carni = (int)(1-densiteHerb)*vivants; //calcul du nombre de carnis � placer

    	int herbicree = 0;
    	int carnicree = 0;

    	//on commence par les herbivores
    	for (int i=0; i<l; i++){
    		for (int j=0; j<h; j++){
    			while(herbicree<=herbi) {

    				int x = (int) (l*Math.random());
    				int y = (int) (h*Math.random());

    				if(monde[x][y]== null)
    					monde[x][y] = new Herbivore(0.2);

    				herbicree++;
    			}
    		}
    	}

    	//on fait les carnivores
    	for(int i=0; i<l; i++) {
    		for(int j=0; j<h; j++) {
    			while(carnicree<=carni) {

    				int a = (int) (l*Math.random());
    				int b = (int) (h*Math.random());

    				if(monde[a][b]== null)
    					monde[a][b] = new Carnivore(0.7);

    				carnicree++;
    			}
    		}
    	}
    	return monde;
    }





    // Permet de dessiner sur le plateau les dinos
    public void paintComponent(Graphics g){
      // Affiche une image (background) avec gestion exception
      try {
        g.setColor(Color.black);
        int n = 40; //écart entre les lignes
        for(int i=0; i<h; i++){
            for(int j=0; j<l;j++){
                if(mondeDino[i][j]!=null){
                    g.drawImage(ImageIO.read(new File("img/herbe3.jpg")),(40+i*h),(40+j*l),this);
                }
                else
                    g.drawString("T",(40+i*h),(40+j*l));
            }
        }
      }
      catch (IOException e) {
        e.printStackTrace();
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
    public int[][] trouverCaseLibre(int h,int l){
      int[][] tab= new int[8][2]; // 8 cases libres au maximum autour de lui
      int nombre=0; // nombre de cases libres trouvées
      for(int i =h-1; i <= h+1; i++){
          for(int k = l-1; k<= l+1; k++){
              if(mondeDino[i][k].outOfBounds(mondeDino,i,k) == false && (i == h && k == l) ==false){
                  if(mondeDino[i][k] == null )
                       tab[nombre][0]=i;
                       tab[nombre][1]=k;
                       nombre++;
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
                int [][] positionLibre=trouverCaseLibre(i,j);
                if ( positionLibre[0][0]!=0 && positionLibre[0][1]!=0){
                  int parcours= (int)(8*Math.random());
                  mondeDino[positionLibre[parcours][0]][positionLibre[parcours][1]]= new Herbivore (0.3);

                }
                }
              }
          if(mondeDino[i][j].type== "Carnivore "){
              if(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)>0){
                mondeDino[i][j].retirerVieDinosaure( (mondeDino[i][j].chanceCarni)*(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)));
            }
              if(mondeDino[i][j].nbrVoisinCarni( mondeDino, i, j)>2){
                int [][] positionLibreBis=trouverCaseLibre(i,j);

              if ( positionLibreBis[0][0]!=0 && positionLibreBis[0][1]!=0){
                int parcours= (int)(8*Math.random());
                mondeDino[positionLibreBis[parcours][0]][positionLibreBis[parcours][1]]= new Carnivore (0.3);
                }
          }

        }
      }
}
}
}
