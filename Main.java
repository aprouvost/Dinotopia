import java.util.Scanner;

public class Main{

    public static void main(String[] args){
      int H =15; // hauteur (en nombre de cellules)
      int L = 15; // largeur
      double P = 0.2; // probabilité de vie d'une cellule
      double pp= 0.5;
      double ppp= 1-pp;
      Plateau  vie= new Plateau ( H,L,P,pp);

      new AffichageFenetreDemarrage(vie);
      Dinosaure[][] monde=vie.mondeDino;


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


      boolean vivant= vie.mondeVivant(); // Je vérifie qu'il y ait au moins un dino sur le plateau pour âsser au tour suivant

        vie.parcoursTab();
        vivant= vie.mondeVivant();
        int [][] positionLibreBis=vie.trouverCaseLibre(0,0);
        if ( positionLibreBis[0][0]!=0 && positionLibreBis[0][1]!=0){
            int parcours= (int)(8*Math.random());
            monde[positionLibreBis[parcours][0]][positionLibreBis[parcours][1]]= new Carnivore (0.3);
          }


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

        System.out.println( monde[0][0].nbrVoisinCarni(monde,0,0));
        System.out.println( monde[0][0].nbrVoisinHerbi(monde,0,0));



  /*    int [][] cas= vie.trouverCaseLibre(20,20);
      for ( int i=0; i<8; i++){
          System.out.print(cas[i][0]);
          System.out.println( ","+ cas[i][1]);
        }
*/

// Affiche le tableau de dino sur la console pour voir son état en attendant l'interface graphique


        }
    }
