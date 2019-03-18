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
    		this.setLocation(300,200);
    		this.setResizable(false);
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel conteneur = new JPanel();
        conteneur.setLayout(null);
        conteneur.setSize(1500,640);
        conteneur.setLocation(60,60);

        boutonLancement = new JButton ("J'ai compris les regles, je souhaite lancer ma partie");
        boutonLancement.setSize(500,70);
        boutonLancement.setLocation(500,400);
        boutonLancement.setBackground(Color.white);
        boutonLancement.addActionListener(this);



        JLabel texteRegles = new JLabel("");
        String ligne ="Common";
        setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,20));
        setForeground(Color.white);/*
        try{
          InputStream flux = new FileInputStream("regles.txt");
          InputStreamReader lecture = new InputStreamReader(flux);
          BufferedReader buff=new BufferedReader(lecture);
          while ((ligne=buff.readLine())!=null){
          	ligne += ligne;
          }
          buff.close();
        }
        catch (Exception e){
          System.out.println(e.toString());
        }*/
        texteRegles.setText(ligne);
        texteRegles.setSize(100,100);
        texteRegles.setLocation(10,10);

        conteneur.add(boutonLancement);
        conteneur.add(texteRegles);

        try{
          this.pan = new PanelB("img/fond.jpg");
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
