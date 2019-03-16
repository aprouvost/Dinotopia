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
    private PanelB pan;
    private Plateau vie;

    public AffichageFenetreDemarrage(Plateau vie){
        Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
        this.setIconImage(icone);

        this.vie = vie;
        try{
          this.pan = new PanelB("img/Dinotopia.jpg");
          //System.out.print("hello");
        }
        catch(IOException e) {
          e.printStackTrace();
        }
        pan.setLayout(null);
        this.add(pan);
        this.setTitle(" Bienvenue a DINOTOPIA !");
        this.setSize(760,350);
    		this.setLocation(0,0);
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



  public void actionPerformed (ActionEvent e){
    if (e.getSource() == boutonLancement){
      AffichagePlateau p = new AffichagePlateau(vie);
      new RegleDinotopia(p);
      this.setVisible(false);
  }
}
}
