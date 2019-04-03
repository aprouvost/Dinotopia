import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanStats extends JPanel implements ActionListener {

	private JLabel compteurTour;
	private JLabel propCarni;
	private JLabel propHerbi;
	private JLabel prctgDino;
	private JLabel prctgVegetaux;
	public Font policeStats;
	private Plateau plat;

	public PanStats(Plateau plateau) { //CONSTRUCTEUR

		this.setLayout(new GridLayout(3,2,5,5));

		//police :
		policeStats = new Font("Arial", 15 , 15);

		//plateau :
		this.plat = plateau;

		//JLabels
		this.compteurTour = new JLabel("Tour numero "+plateau.getCompteur());
		this.compteurTour.setFont(policeStats);

		this.propCarni = new JLabel("<html>Proportion de carnivores :<br>"+plateau.getDensiteCarn()*100+"%</html>");
		this.propCarni.setFont(policeStats);

		this.propHerbi = new JLabel("<html>Proportion d'herbivores :<br>"+plateau.getDensiteHerb()*100+"%</html>");
		this.propHerbi.setFont(policeStats);

		this.prctgDino = new JLabel("<html>Pourcentage de dinosaures :<br>"+plateau.getProp()*100+"%</html>");
		this.prctgDino.setFont(policeStats);

		this.prctgVegetaux = new JLabel("<html>Pourcentage de vegetaux :<br>"+(1.0-plateau.getProp())*100+"%</html>");
		this.prctgVegetaux.setFont(policeStats);


		this.add(prctgDino) ; this.add(prctgVegetaux) ; this.add(propCarni) ; this.add(propHerbi) ; this.add(compteurTour);


	}

	//METHODES

	/**
	 * Mise � jour du panneau des statistiques, � appeler � chaque tour/it�ration.
	 * @param monde
	 */
	public void miseAJourStats() {
		this.compteurTour.setText("Tour numero "+plat.getCompteur());
		this.propCarni.setText("<html>Proportion de carnivores :<br>"+plat.getDensiteCarn()*100+"%</html>");
		this.propHerbi.setText("<html>Proportion d'herbivores :<br>"+plat.getDensiteHerb()*100+"%</html>");
		this.prctgDino.setText("<html>Pourcentage de dinosaures :<br>"+plat.getProp()*100+"%</html>");
		this.prctgVegetaux.setText("<html>Pourcentage de vegetaux :<br>"+(1.0-plat.getProp())*100+"%</html>");
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
	public void Visible(){
			this.setVisible(true);
	}
	public void Cache() {
			this.setVisible(false);
	}


	public void actionPerformed(ActionEvent arg0) {
	}

}
