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
        boutonLancement = new JButton ("");
        boutonLancement.setFont(new Font("ArialBlack",Font.BOLD,15));
        boutonLancement.setText("Nouvelle Partie");
        boutonLancement.setSize(270,50);
        boutonLancement.setLocation(250,215);
        boutonLancement.addActionListener(this);
        this.setVisible(true);

        this.add(conteneur);
        conteneur.add(boutonLancement);

  }



  public void actionPerformed (ActionEvent e){
    if (e.getSource() == boutonLancement){
      AffichagePlateau p = new AffichagePlateau(vie);
      new RegleDinotopia(p);
      this.setVisible(false);
  }
}
}
