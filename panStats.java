import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanStats extends JPanel implements ActionListener {

	private JLabel compteurTour;
	private JLabel propCarni;
	private JLabel propHerbi;
	private JLabel prctgDino;
	private JLabel prctgVegetaux;

	public PanStats(Plateau plateau) { //CONSTRUCTEUR

		this.setLayout(new GridLayout(2,2));

		//JLabels
		this.compteurTour = new JLabel("Tour numero ");
		this.propCarni = new JLabel("Proportion de carnivores :"+plateau.densiteCarn);
		this.propHerbi = new JLabel("Proportion d'herbivores :"+plateau.densiteHerb);
		this.prctgDino = new JLabel("Pourcentage de dinosaures :"+plateau.prop);
		this.prctgVegetaux = new JLabel("Pourcentage de vegetaux :"+ (1-plateau.prop));
		
		this.add(prctgDino) ; this.add(prctgVegetaux) ; this.add(propCarni) ; this.add(propHerbi) ;
	}
	
	//METHODES
	
	public void miseAJourStats(Plateau monde) {
		
	}
	
	
	//SETTERS

	public void setCompteur(String mess) {

	}
	public void setCompteur(double numb) {

	}
	
	public void setPropCarni(String mess) {

	}
	public void setPropCarni(double numb) {

	}
	
	public void setPropHerbi(String mess) {

	}
	public void setPropHerbi(double numb) {

	}
	
	public void setPrctgDino(String mess) {

	}
	public void setPrctgDino(double numb) {

	}
	
	public void setPrctgVege(String mess) {
		
	}
	public void setPrctgVege(double numb) {
		
	}



	public void actionPerformed(ActionEvent arg0) {
	}

}
