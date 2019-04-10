import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class AffichageFin extends JFrame implements ActionListener{

	public Joueur player;

	public int nbTours;
	public double propCarniFin;
	public double propHerbiFin;
	public double prctgDinoFin;
	public double prctgVegetauxFin;

	public PanelB theBigOne;
	public PanelB partieFinie;

	//CONSTRUCTEUR FENETRE
	public AffichageFin(Plateau plat){

		this.nbTours = plat.getCompteur();
		this.propCarniFin = plat.getDensiteCarn();
		this.propHerbiFin = plat.getDensiteHerb();
		this.prctgDinoFin = plat.getProp();
		this.prctgVegetauxFin = (1.0-plat.getProp());

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // mettre la fenetre � la dim de l'ordi
		this.setSize(dim);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	//police :
		Font police = new Font("Arial" , 20 , 20);

	//JLabels scores, cr�ation et positionnement /!\ RELATIF A LA RESOLUTION DE L'ECRAN
		JLabel herbivores = new JLabel("Proportion d'herbivores finale : \n"+propHerbiFin+" %",SwingConstants.CENTER);
		herbivores.setFont(police);
		herbivores.setBounds(5,((int)dim.getHeight()/3+5),(int)dim.getWidth()/2-10,(int)dim.getHeight()/2);
		herbivores.setForeground(Color.WHITE);

		JLabel carnivores = new JLabel("Proportion de carnivores finale: \n"+propCarniFin+" %",SwingConstants.CENTER);
		carnivores.setFont(police);
		carnivores.setBounds((int)dim.getWidth()/2+5,(int)dim.getHeight()/3+5,(int)dim.getWidth()/2-10,(int)dim.getHeight()/2);
		carnivores.setForeground(Color.WHITE);

		JLabel dinosaures = new JLabel("Pourcentage de dinosaures final : \n"+prctgDinoFin+" %",SwingConstants.CENTER);
		dinosaures.setFont(police);
		dinosaures.setBounds(5,((int)(2*dim.getHeight()/3+5)),(int)dim.getWidth()/2-10,(int)dim.getHeight()/2);
		dinosaures.setForeground(Color.WHITE);

		JLabel vegetaux = new JLabel("Pourcentage de vegetaux : \n"+prctgVegetauxFin+" %",SwingConstants.CENTER);
		vegetaux.setFont(police);
		vegetaux.setBounds((int)dim.getWidth()/2+5,((int)(2*dim.getHeight()/3+5)),(int)dim.getWidth()/2-10,(int)dim.getHeight()/2);
		vegetaux.setForeground(Color.WHITE);

		JLabel compteur = new JLabel("Nombre de tours de la partie : \n"+nbTours,SwingConstants.CENTER);
		compteur.setFont(police);
		compteur.setBounds((int)dim.getWidth()/4,100,(int)dim.getWidth()/2,(int)dim.getHeight()/3);
		compteur.setForeground(Color.WHITE);

	//JLabels param�tres initiaux
		JLabel herbivoresInit = new JLabel("Proportion d'herbivores initiale : \n"+plat.densiteHerbInit*100+" %",SwingConstants.CENTER);
		herbivoresInit.setFont(police);
		herbivoresInit.setBounds(herbivores.getBounds());
		herbivoresInit.setLocation(herbivoresInit.getX(), herbivoresInit.getY()-100);
		herbivoresInit.setForeground(Color.WHITE);

		JLabel carnivoresInit = new JLabel("Proportion de carnivores initiale: \n"+plat.densiteCarnInit*100+" %",SwingConstants.CENTER);
		carnivoresInit.setFont(police);
		carnivoresInit.setBounds(carnivores.getBounds());
		carnivoresInit.setLocation(carnivoresInit.getX(), carnivoresInit.getY()-100);
		carnivoresInit.setForeground(Color.WHITE);

		JLabel dinosauresInit = new JLabel("Pourcentage de dinosaures initial : \n"+plat.propInit*100+" %",SwingConstants.CENTER);
		dinosauresInit.setFont(police);
		dinosauresInit.setBounds(dinosaures.getBounds());
		dinosauresInit.setLocation(dinosauresInit.getX(), dinosauresInit.getY()-100);
		dinosauresInit.setForeground(Color.WHITE);

		JLabel vegetauxInit = new JLabel("Pourcentage de vegetaux initial: \n"+(1-plat.propInit)*100+" %",SwingConstants.CENTER);
		vegetauxInit.setFont(police);
		vegetauxInit.setBounds(vegetaux.getBounds());
		vegetauxInit.setLocation(vegetauxInit.getX(), vegetauxInit.getY()-100);
		vegetauxInit.setForeground(Color.WHITE);

	//JPanel partie finie :
		try{
			partieFinie = new PanelB("img/endgame.png");
	    }
		catch(IOException e) {
	          e.printStackTrace();
	    }
		partieFinie.setBounds((int)(dim.getWidth()/2-150), 5, 300, 100);

	//JPanel ppal
		try{
			theBigOne = new PanelB("img/FinDuGame.jpg");
	    }
		catch(IOException e) {
	          e.printStackTrace();
	    }
		theBigOne.setLayout(null);
		theBigOne.add(herbivores);theBigOne.add(carnivores);theBigOne.add(dinosaures);theBigOne.add(vegetaux);theBigOne.add(compteur);
		theBigOne.add(partieFinie);
		theBigOne.add(herbivoresInit);theBigOne.add(carnivoresInit);theBigOne.add(dinosauresInit);theBigOne.add(vegetauxInit);


		this.add(theBigOne);
		this.setVisible(true);
	}


	//METHODES
	public void actionPerformed(ActionEvent e) {

	}

}
