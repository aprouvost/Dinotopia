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
import java.io.*;

public class RegleDinotopia extends JFrame implements ActionListener {

    private JButton boutonLancement;
    private PanelB pan;
    private AffichagePlateau p;

    public RegleDinotopia(AffichagePlateau p){
        Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
        this.setIconImage(icone);
        this.p = p;
        this.setTitle(" Regles de Dinotopia");
        this.setSize(1500,640);
    		this.setLocation(100,50);
    		this.setResizable(false);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel conteneur = new JPanel();
        conteneur.setLayout(null);
        conteneur.setSize(1500,750);
        conteneur.setLocation(10,10);
        conteneur.setBackground(new Color(0,0,0,0));

        boutonLancement = new JButton ("J'ai compris les regles, je souhaite lancer ma partie");
        boutonLancement.setSize(500,70);
        boutonLancement.setLocation(500,400);
        boutonLancement.setBackground(Color.white);
        boutonLancement.addActionListener(this);



        JLabel texteRegles = new JLabel("");
        String ligne ="";
        String msg ="<html> ";
        try{
          BufferedReader lecteurAvecBuffer = null;
          try{
      	     lecteurAvecBuffer = new BufferedReader(new FileReader(new File("regles.txt")));
          }
          catch(FileNotFoundException exc)
            {
      	       System.out.println("Erreur d'ouverture");
            }
          while ((ligne = lecteurAvecBuffer.readLine()) != null)
            msg += ligne + "</br>";
          lecteurAvecBuffer.close();
        }
        catch (Exception e){
          System.out.println(e.toString());
        }
        texteRegles.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,10));
        texteRegles.setForeground(Color.white);
        texteRegles.setText(msg + "</html>");
        texteRegles.setSize(1000,200);
        texteRegles.setLocation(0,0);

        conteneur.add(boutonLancement);
        conteneur.add(texteRegles);

        try{
          this.pan = new PanelB("img/Regles.jpg");
        }
        catch(IOException e) {
          e.printStackTrace();
        }
        this.add(conteneur);
        this.add(pan);
        this.setVisible(true);
  }

      public void actionPerformed (ActionEvent e){
        if (e.getSource() == boutonLancement){
          p.AffichePlateau();
          this.setVisible(false);
      }
    }
}
