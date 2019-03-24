import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanEvent extends JPanel implements ActionListener{

	JButton bout1;
	JButton bout2;
	JButton bout3;
	Plateau plat;


	public PanEvent(Plateau plateau) {
		this.plat = plateau;

		this.setLayout(new GridLayout(3,1,5,5));
		bout1 = new JButton("Montee Des Eaux");
		bout2 = new JButton("Meteorite");
		bout3 = new JButton("Secheresse");
		bout1.addActionListener(this);
		bout2.addActionListener(this);
		bout3.addActionListener(this);
		this.add(bout1) ; this.add(bout2) ; this.add(bout3) ;

	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bout1) {  //BOUTON1

		}
		else if(e.getSource() == bout2) {	//BOUTON2

		}
		else {	//BOUTON3

		}
	}

}
