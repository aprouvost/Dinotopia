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

public class Joueur extends JFrame implements ActionListener  {

    private JButton boutonLancement;
    private Plateau vie;
    private PanelB cont;
    private JComboBox text;
    private String[] tab;
    private String ac;
    private JTextField textField;
    private JTextField textField2;
    private String probT;
    private String probH;

    public Joueur(Plateau plat){
        Image icone = Toolkit.getDefaultToolkit().getImage("img/skull.jpg");
        this.setIconImage(icone);
        try{
          this.cont = new PanelB("img/fond2.jpg");
        }
        catch(IOException e){
          e.printStackTrace();
        }

        this.add(cont);

        this.vie = plat;
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

        JLabel texteAff = new JLabel("Choisissez la densite de presence des dinosaures :");
        texteAff.setFont(new Font("TimesRoman",Font.BOLD,30));
        texteAff.setForeground(Color.white);
        texteAff.setLocation(20,100);
        texteAff.setSize(650,50);

        JLabel texteAff2 = new JLabel("Proportion de dinosaures");
        texteAff2.setFont(new Font("TimesRoman",Font.BOLD,20));
        texteAff2.setForeground(Color.white);
        texteAff2.setLocation(120,230);
        texteAff2.setSize(250,50);

        JLabel texteAff3 = new JLabel("Proportion d'herbivores parmis eux");
        texteAff3.setFont(new Font("TimesRoman",Font.BOLD,20));
        texteAff3.setForeground(Color.white);
        texteAff3.setLocation(430,230);
        texteAff3.setSize(250,50);

        textField = new JTextField();
        textField.setColumns(5);
        textField.setLocation(200,200);
        textField.setSize(50,35);
        textField2 = new JTextField();
        textField2.setColumns(5);
        textField2.setLocation(500,200);
        textField2.setSize(50,35);

        this.setVisible(true);
        cont.add(texteAff);
        cont.add(texteAff2);
        cont.add(texteAff3);
        cont.add(textField);
        cont.add(textField2);
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

        tab = msg.split("/");

        text = new JComboBox();
        for(int k=0;k<tab.length;k++){
          text.addItem(tab[k]);
        }
        text.setSize(300,40);
        text.setLocation(20,20);
        text.setEditable(true);
        cont.add(text);


  }

  /*public void itemStateChanged(ItemEvent x){
    try{

    }
    catch(Exception e){
      System.err.print(e.getMessage());
    }
  }*/

  public void actionPerformed (ActionEvent e){
    if (e.getSource() == boutonLancement){
      System.out.println("un passage");
      this.ac = text.getSelectedItem().toString();
      this.probT = textField.getText();
      this.probH = textField2.getText();
      boolean toWrite = true;
      for(int l=0;l<tab.length;l++){
        if (tab[l].equals(ac)){
          toWrite = false;
        }
      }
      if(toWrite){
        try{
         FileWriter fw = new FileWriter("joueur.txt",true);
         fw.write(ac+"\n");
         fw.close();
        }
        catch(IOException ioe){
         System.err.println("IOException:" + ioe.getMessage());
        }
      }
      System.out.println(Double.parseDouble(probH));
      System.out.println(Double.parseDouble(probT));

      vie.setProp(Double.parseDouble(probT));
      vie.setDensiteHerb(Double.parseDouble(probH));
      vie.nouvelleGeneration();
      AffichagePlateau p = new AffichagePlateau(vie);
      new RegleDinotopia(p);
      this.setVisible(false);
    }
  }
}
