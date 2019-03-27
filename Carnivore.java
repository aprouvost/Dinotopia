public class Carnivore extends Dinosaure { // Herbivore est une classe fille. Dinosaure est la classe mère.
      public double propViandeNecessaire;  // la proportion de viande nécessaire dans le monde pour etre en bonne santée. Initialisée par l'utilisateur

      public Carnivore ( double propViandeNecessaire){
        super("Carnivore", 6.0, 4.0); // On indique que c'est un Dinosaure de type carnivore en utilisant le contructeur de la classe mère
        this.propViandeNecessaire= propViandeNecessaire;  //propViande sera défini par la densité de population du monde
      }

}
