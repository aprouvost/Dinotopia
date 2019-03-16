import java.util.Scanner;

public class Main{

    public static void main(String[] args){
      int H = 100; // hauteur (en nombre de cellules)
      int L = 100; // largeur
      double P = 0.1; // probabilité de vie d'une cellule
      double pp= 0.3;
      double ppp= 1-pp;
      Plateau  vie= new Plateau ( H,L,P,pp);

      new AffichageFenetreDemarrage(vie);
      Dinosaure[][] monde=vie.mondeDino;
      boolean vivant= vie.mondeVivant(); // Je vérifie qu'il y ait au moins un dino sur le plateau pour âsser au tour suivant
      while (vivant== true){
        vie.parcoursTab();
        vivant= vie.mondeVivant();


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

      }

  /*    int [][] cas= vie.trouverCaseLibre(20,20);
      for ( int i=0; i<8; i++){
          System.out.print(cas[i][0]);
          System.out.println( ","+ cas[i][1]);
        }
*/

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

        }
    }
