
public class Herbivore extends Dinosaure { // Herbivore est une classe fille. Dinosaure est la classe mère.
      public double propVegeNecessaire; // la proportion de végétation nécessaire pour etre en bonne santée. Initialisée par l'utilisateur

      public Herbivore ( double propVegeNecessaire){
        super("Herbivore", 0.5, 0.3); // On indique que c'est un Dinosaure de type herbivore en utilisant le contructeur de la classe mère
        this.propVegeNecessaire= propVegeNecessaire;
      }



    }
