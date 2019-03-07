import java.util.Scanner;

public class Main{

    public static void main(String[] args){

      Plateau  vie= new Plateau ( 10, 20, 0.5, 0.2);
      Dinosaure[][] monde=vie.mondeDino;


// Affiche le tableau de dino sur la console pour voir son état en attendant l'interface graphique


          System.out.print("+");
          for(int j=0; j<20;j++)
              System.out.print("-");
          System.out.println("+");


          for(int i=0; i<10; i++){
              System.out.print("|");
              for(int j=0; j<20;j++){
                  if(monde[i][j]!=null)
                      System.out.print("X");
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
