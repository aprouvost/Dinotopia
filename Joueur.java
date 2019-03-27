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
import java.io.*;

public class Joueur extends JFrame implements ActionListener {

    private JButton boutonLancement;
    private Plateau vie;

    public Joueur(Plateau vie){
        Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
        this.setIconImage(icone);

        JPanel cont = new JPanel();
        this.add(cont);

        this.vie = vie;
        this.setTitle(" Entrez votre nom !");
        this.setSize(760,350);
    		this.setLocation(0,0);
    		this.setResizable(false);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boutonLancement = new JButton ("");
        boutonLancement.setFont(new Font("ArialBlack",Font.BOLD,15));
        boutonLancement.setText("Let's Go");
        boutonLancement.setSize(180,40);
        boutonLancement.setLocation(400,20);
        boutonLancement.addActionListener(this);
        this.setVisible(true);
        cont.add(boutonLancement);
        cont.setSize(30,30);
        cont.setLocation(100,100);
        cont.setLayout(null);


        String ligne ="";
        String msg ="";
        int i=0;
        try{
          BufferedReader lecteurAvecBuffer = null;
          try{
             lecteurAvecBuffer = new BufferedReader(new FileReader(new File("joueur.txt")));
          }
          catch(FileNotFoundException exc)
            {
               System.out.println("Erreur d'ouverture");
            }
          while ((ligne = lecteurAvecBuffer.readLine()) != null)
            msg += ligne + "/";
            lecteurAvecBuffer.close();
          }
        catch (Exception e){
          System.out.println(e.toString());
        }

        String[] tab = msg.split("/");

        JComboBox text = new JComboBox();
        for(int k=0;k<tab.length;k++){
          text.addItem(tab[k]);
        }
        text.setSize(300,40);
        text.setLocation(20,20);
        cont.add(text);

        JTextArea text2 = new JTextArea("Entrez Votre Nom ici");
        text2.setLocation(50,80);
        text2.setSize(200,30);
        cont.add(text2);

  }



  public void actionPerformed (ActionEvent e){
    if (e.getSource() == boutonLancement){
      AffichagePlateau p = new AffichagePlateau(vie);
      new RegleDinotopia(p);
      this.setVisible(false);
  }
}
}
