/**
 * La fenêtre principale pour afficher la genetre de démarrage du jeu
 *
 */

// Chargement des bibliothèques Swing et AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class AffichageFenetreDemarrage extends JFrame implements ActionListener {

    private JButton boutonLancement;

    public AffichageFenetreDemarrage(){

        this.setTitle(" Bienvenue a DINOTOPIA !");
        this.setSize(1000,700);
    		this.setLocation(300,200);
    		this.setResizable(false);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel conteneur = new JPanel();
        conteneur.setLayout(null);
        conteneur.setSize(100,100);
        conteneur.setLocation(30,30);
        boutonLancement = new JButton ("Demarrer une nouvelle partie");
        boutonLancement.setSize(200,100);
        boutonLancement.setLocation(300,200);
        boutonLancement.setBackground(Color.white);
        boutonLancement.addActionListener(this);
        conteneur.add(boutonLancement);
        this.setVisible(true);
        this.add(conteneur);
  }

  public void paintComponent(Graphics g){
    // Affiche la fenetre de demarrage du jeu
    try {
      Image img = ImageIO.read(new File("img/Dinotopia.jpg"));
      g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void actionPerformed (ActionEvent e){
    if (e.getSource() == boutonLancement){
      System.out.println ( "Clic lancement d'une partie.");
  }
}
}
