/**
 * La fenêtreexpliquant les règles du jeu
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

public class RegleDinotopia extends JFrame implements ActionListener {

    private JButton boutonLancement;

    public RegleDinotopia(){

        this.setTitle(" Regles de Dinotopia");
        this.setSize(1000,700);
    		this.setLocation(300,200);
    		this.setResizable(false);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel conteneur = new JPanel();
        conteneur.setLayout(null);
        conteneur.setSize(600,600);
        conteneur.setLocation(60,60);

        boutonLancement = new JButton ("J'ai compris les regles, je souhaite lancer ma partie");
        boutonLancement.setSize(500,70);
        boutonLancement.setLocation(300,200);
        boutonLancement.setBackground(Color.white);
        boutonLancement.addActionListener(this);

        JLabel texteRegles = new JLabel ("BIENVENUE A DINOTOPIA \nDinotopia est un jeu de dynamique de populations. Votre but est de maintenant de configurer votre monde et de le maintenir en vie le plus longtemps possible");
        texteRegles.setSize(1000,250);
        texteRegles.setLocation(25,25);

        conteneur.add(boutonLancement);
        conteneur.add(texteRegles);
        this.setVisible(true);
        this.add(conteneur);

  }
      public void paintComponent(Graphics g){
        // Affiche la fenetre de demarrage du jeu
        try {
          Image img = ImageIO.read(new File("img/Regles.jpg"));
          g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      public void actionPerformed (ActionEvent e){
        if (e.getSource() == boutonLancement){
          System.out.println ( "Clic regles comprises.");
      }
    }
}
