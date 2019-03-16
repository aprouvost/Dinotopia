import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
					
public class panStats extends JPanel implements ActionListener {
	
	
	public panStats() { //CONSTRUCTEUR
		
		this.setBackground(new Color(0,0,0,0));
		this.setBounds(410, 250, 780-410, 480-250);
		this.setLayout(new GridLayout());
		
		//JLabel compteur de tours
		JLabel compteurTour = new JLabel("Tour n°: ");
		JLabel propCarni = new JLabel("Proportion de carnivores :");
		JLabel propHerbi = new JLabel("Proportion d'herbivores :");
		JLabel prctgDino = new JLabel("Pourcentage de dinosaures :");
		JLabel prctgVegetaux = new JLabel("Pourcentage de végétaux :");
		
		
		
	}

	
	
	public void actionPerformed(ActionEvent arg0) {
	}

}