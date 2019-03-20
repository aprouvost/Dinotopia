/**
 * La fenêtre principale pour afficher le tableau créer ainsi que les différentes fenêtres
 *
 */

// Chargement des bibliothèques Swing et AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AffichagePlateau extends JFrame implements ActionListener {
	Plateau monde;
	private PanelB pan;

	public AffichagePlateau(Plateau vie){
		Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
		this.setIconImage(icone);
		this.monde = vie;
		this.setTitle("Dinotopia");
		this.setSize(1366,768);
		this.setLocation(0,0);		//Pour placer la fenêtre au centre de l'écran
		this.setResizable(true); 		//Pour empêcher le redimensionnement de la fenêtre  /!\ � changer
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Panneau evenements
		 */
		PanEvent events = new PanEvent(monde);
		events.setBackground(new Color(0,0,0,0));
		events.setBounds(900, 100, 400, 200);
		
		/**
		 * Panneau statistiques
		 */
		PanStats statistiques = new PanStats(monde);
		statistiques.setBackground(new Color(0,0,0,0));
		statistiques.setBounds(900, 500, 400, 200);		
		
		/**
		 * Mon panneau Global
		 */
		this.add(events);
		this.add(statistiques);
		this.add(monde);
		this.setVisible(false);		// Pour rendre la fenêtre visible

		

	}

	public void AffichePlateau(){
		this.setVisible(true);
	}


	/**
	 * Lorqu'une action est réalisé
	 */
	public void actionPerformed (ActionEvent e){}
}
