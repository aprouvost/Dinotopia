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
        conteneur.setSize(1200,650);
        conteneur.setLocation(150,80);
        conteneur.setBackground(new Color(0,0,0,97));

        boutonLancement = new JButton ("J'ai compris les regles, je souhaite lancer ma partie");
        boutonLancement.setSize(500,70);
        boutonLancement.setLocation(300,400);
        boutonLancement.setBackground(Color.white);
        boutonLancement.addActionListener(this);



        JLabel texteRegles = new JLabel("");
        JLabel texteRegles2 = new JLabel("");
        String ligne ="";
        String msg ="<html>";
        int i=0;
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
            if(i == 0){
              texteRegles.setText(ligne);
              i++;
            }
            else if(i != 0){
              msg += ligne + "<br>";
            }
            lecteurAvecBuffer.close();
            msg += "</html>";
          }
        catch (Exception e){
          System.out.println(e.toString());
        }
        texteRegles2.setText(msg);
        texteRegles.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,20));
        texteRegles.setForeground(Color.white);
        texteRegles.setSize(550,200);
        texteRegles.setLocation(50,-50);
        texteRegles2.setFont(new Font("TimesRoman",Font.BOLD,15));
        texteRegles2.setForeground(Color.white);
        texteRegles2.setSize(1000,200);
        texteRegles2.setLocation(100,150);

        conteneur.add(texteRegles);
        conteneur.add(texteRegles2);
        conteneur.add(boutonLancement);

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
