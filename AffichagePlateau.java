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
		try{
		 this.pan = new PanelB("img/fond.jpg");
		}
		catch(IOException e) {
		 e.printStackTrace();
		}

		Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
		this.setIconImage(icone);
		this.monde = vie;
		this.setTitle("Dinotopia");
		this.setSize(800,500);
		this.setLocation(300,200);		//Pour placer la fenêtre au centre de l'écran
		this.setResizable(false); 		//Pour empêcher le redimensionnement de la fenêtre  /!\ � changer
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Mon panneau Global
		 */
		this.setVisible(false);		// Pour rendre la fenêtre visible
		pan.setLayout(null); /////
		pan.add(monde);
		this.add(pan);

		/**
		 * Panneau statistiques
		 */
		//new PanStats();

	}

	public void AffichePlateau(){
		this.setVisible(true);
	}


	/**
	 * Lorqu'une action est réalisé
	 */
	public void actionPerformed (ActionEvent e){}
}
