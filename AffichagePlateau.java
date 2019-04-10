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
	private PanStats statistiques;
	private JOptionPane jop;
	private JPanel events;



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
		events = new JPanel();
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
		monde.CachePlateau();
		statistiques.Cache();
		if(e.getSource() == bout1){
			monde.parcoursTab();
			monde.compteurPlus();
		}

		//BOUTONS EVENEMENTS :
		else if(e.getSource()==monteeEau) {  //Montee des eaux
			monde.monteeDesEaux();
			monde.parcoursTab();
			monde.compteurPlus();
		}
		else if(e.getSource() == meteorite) {	//Meteorite
			monde.meteorite();
			monde.parcoursTab();
			monde.compteurPlus();
		}
		else if(e.getSource() == secheresse){	//Secheresse
			monde.secheresse();
			monde.parcoursTab();
			monde.compteurPlus();
		}
		FinPartie();
		statistiques.Visible();
		monde.AffichePlateau();
	}

	public void FinPartie(){
		System.out.println(monde.finPartie());
		if (monde.finPartie()){
			events.remove(monteeEau);
			events.remove(meteorite);
			events.remove(secheresse);
			this.remove(bout1);
			jop.showMessageDialog(null,"Le jeu est terminé, \n Bravo","Fin du Jeu",JOptionPane.INFORMATION_MESSAGE);
			new AffichageFin(monde);
		}
	}



}
