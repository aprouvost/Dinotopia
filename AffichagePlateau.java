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
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

public class AffichagePlateau extends JFrame implements ActionListener {
	private Plateau monde;
	private PanelB pan;
	private JButton bout1;
	private int compt;
	private int l;

	//Attributs panEvent :
	public JButton monteeEau;
	public JButton meteorite;
	public JButton secheresse;
	public Plateau plat;
	private PanStats statistiques;



	public AffichagePlateau(Plateau vie){
		Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
		this.setIconImage(icone);
		this.monde = vie;
		this.setTitle("Dinotopia");
		this.setSize(1366,768);
		this.setLocation(0,0);		//Pour placer la fenêtre au centre de l'écran
		this.setResizable(false); 		//Pour empêcher le redimensionnement de la fenêtre  /!\ � changer
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Panneau evenements
		 */
		JPanel events = new JPanel();
		events.setBackground(new Color(0,0,0,0));
		events.setBounds(900, 100, 400, 200);

		//this.evenement = new Event(plat);

		events.setLayout(new GridLayout(3,1,5,5));
		monteeEau = new JButton("Montee Des Eaux");
		meteorite = new JButton("Meteorite");
		secheresse = new JButton("Secheresse");
		monteeEau.addActionListener(this);
		meteorite.addActionListener(this);
		secheresse.addActionListener(this);

		events.add(monteeEau) ; events.add(meteorite) ; events.add(secheresse) ;

		/**
		 * Panneau statistiques
		 */
		statistiques = new PanStats(monde);
		statistiques.setBackground(new Color(0,0,0,0));
		statistiques.setBounds(900, 500, 400, 200);

		/**
		 * Mon panneau Global
		 */
		bout1 = new JButton("Lancement / Stop");
		bout1.addActionListener(this);
		bout1.setSize(150,25);
		bout1.setLocation(300,650);
		this.add(bout1) ;
		this.add(events);
		this.add(statistiques);
		this.add(monde);
		this.setVisible(false);		// Pour rendre la fenêtre visible
		compt = 0;
		l = 3;
	}
	public void AffichePlateau(){
		this.setVisible(true);
	}


	/**
	 * Lorqu'une action est réalisé
	 */
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == bout1){
			monde.CachePlateau();
			statistiques.Cache();
			monde.parcoursTab();
			monde.compteurPlus();
			statistiques.Visible();
			monde.AffichePlateau();
		}

		//BOUTONS EVENEMENTS :
		else if(e.getSource()==monteeEau) {  //Montee des eaux
			monde.CachePlateau();
			statistiques.Cache();
			monde.monteeDesEaux();
			monde.compteurPlus();
			statistiques.Visible();
			monde.AffichePlateau();
		}
		else if(e.getSource() == meteorite) {	//Meteorite
			monde.CachePlateau();
			statistiques.Cache();
			monde.meteorite();
			monde.compteurPlus();
			statistiques.Visible();
			monde.AffichePlateau();
		}
		else if(e.getSource() == secheresse){	//Secheresse
			monde.CachePlateau();
			statistiques.Cache();
			monde.secheresse();
			monde.compteurPlus();
			statistiques.Visible();
			monde.AffichePlateau();
		}
	}
}
