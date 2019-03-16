import java.util.Scanner;

public class Main{

    public static void main(String[] args){
      int H = 20; // hauteur (en nombre de cellules)
      int L = 20; // largeur
      double P = 0.5; // probabilité de vie d'une cellule
      double pp= 0.3;
      double ppp= 1-pp;
      Plateau  vie= new Plateau ( H,L,P,pp);

      new AffichageFenetreDemarrage(vie);
      Dinosaure[][] monde=vie.mondeDino;
      int [][] caseLibre= vie.trouverCaseLibre(0,0);
      for ( int i=0; i< 8; i++){
        System.out.print( "x="+caseLibre[i][0]);
        System.out.println("y="+ caseLibre[i][1]);

      }

// Affiche le tableau de dino sur la console pour voir son état en attendant l'interface graphique

          System.out.print("+");
          for(int j=0; j<L;j++)
              System.out.print("-");
          System.out.println("+");


          for(int i=0; i<H; i++){
              System.out.print("|");
              for(int j=0; j<L;j++){
                  if(monde[i][j]!=null)
                    if(monde[i][j].type== "Herbivore")
                      System.out.print("X");
                    else
                    System.out.print("O");
                  else
                      System.out.print(".");
            }
            System.out.println("|");
          }

          System.out.print("+");
          for(int j=0; j<20;j++)
              System.out.print("-");
          System.out.println("+");

        //  vie.parcoursTab();

        }
    }
