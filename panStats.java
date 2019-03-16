import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanStats extends JPanel implements ActionListener {

	private JLabel compteurTour;
	private JLabel propCarni;
	private JLabel propHerbi;
	private JLabel prctgDino;
	private JLabel prctgVegetaux;

	public PanStats() { //CONSTRUCTEUR

		this.setBackground(new Color(0,0,0,0));
		this.setBounds(410, 250, 780-410, 480-250);
		this.setLayout(new GridLayout());

		//JLabels
		this.compteurTour = new JLabel("Tour n�: ");
		this.propCarni = new JLabel("Proportion de carnivores :");
		this.propHerbi = new JLabel("Proportion d'herbivores :");
		this.prctgDino = new JLabel("Pourcentage de dinosaures :");
		this.prctgVegetaux = new JLabel("Pourcentage de v�g�taux :");

	}

	public void setCompteur(String mess) {

	}
	public void setPropCarni(String mess) {

	}
	public void setPropHerbi(String mess) {

	}
	public void setPrctgDino(String mess) {

	}
	public void setPrctgVege(String mess) {
	}



	public void actionPerformed(ActionEvent arg0) {
	}

}
