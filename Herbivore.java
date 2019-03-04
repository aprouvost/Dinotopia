
public class Herbivore extends Dinosaure { // Herbivore est une classe fille. Dinosaure est la classe mère.
      public double propVegeNecessaire;  // la proportion de végétation nécessaire pour etre en bonne santée. Initialisée par l'utilisateur

      public Herbivore ( double propVegeNecessaire){
        super("Herbivore"); // On indique que c'est un Dinosaure de type herbivore en utilisant le contructeur de la classe mère
        this.propVegeNecessaire= propVegeNecessaire;
      }


      /** Permet à l'herbivore d'attaquer.
      * @param chanceCarni la probabilite qu'il gagne le combat contre un carnivore
      * @param chanceHerbi la probabilité qu'il gagne le combat contre un Herbivore
      * @param adv l'adversaire qu'il attaque
      * @return la quantité de points de vie retirée à l'adversaire
      */
      public double attaque( Dinosaure adv, double chanceHerb, double chanceCarni){
        double pointsVieRetire=0;
        if (adv.type== "Herbivore"){
          pointsVieRetire= chanceHerb*adv.pointsVie;
        }else{
          pointsVieRetire= chanceCarni*adv.pointsVie;
        }
        return pointsVieRetire;
      }

      /** Retire les points de vie à l'adversaire suite à l'attaque
      * @param pointsARetirer les points à enlever à la vie de l'adversaire
      * @param adv l'adversaire à qui on retire la vie
      * @return la vie de l'adversaire après avoir subit l'attaque
      */
      public double retirerVieAdversaire( Dinosaure adv, double pointsARetirer){
        return adv.pointsVie- pointsARetirer;
      }

      /** Retire les points de vie au dinosaure visé
      * @param pointsARetirer les points à enlever
      * @return rien ( modifie directement les attributs de la classe)
      */
      public void retirerVieDinosaure( Dinosaure adv, double pointsARetirer){
         this.pointsVie= this.pointsVie- pointsARetirer;
      }


      /** ajoute au dinosaure les points de vie
      * @param pointsAAjouter les points à ajouter au dino
      * @return rien ( modifie directement les attributs de la classe)
      */
      public void ajouterVieDinosaure( double pointsAAjouter){
         this.pointsVie=this.pointsVie+ pointsAAjouter;
      }

    }
