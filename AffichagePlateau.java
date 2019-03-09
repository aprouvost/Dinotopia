/**
 * La fenêtre principale pour afficher le tableau créer ainsi que les différentes fenêtres
 *
 */

// Chargement des bibliothèques Swing et AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class AffichagePlateau extends JFrame implements ActionListener {
	Plateau monde;

	public AffichagePlateau(Plateau vie){
		this.monde = vie;
		this.setTitle("Dinotopia");
		this.setSize(800,500);
		this.setLocation(300,200);		//Pour placer la fenêtre au centre de l'écran
		this.setResizable(false); 		//Pour empêcher le redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Mon panneau Global
		 */

		this.add(monde);
		this.setVisible(true);		// Pour rendre la fenêtre visible
	}



	/**
	 * Lorqu'une action est réalisé
	 */
	public void actionPerformed (ActionEvent e){}
}
