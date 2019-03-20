import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanEvent extends JPanel implements ActionListener{

	JButton Bout1;
	JButton Bout2;
	JButton Bout3;

	
	public PanEvent(Plateau plateau) {
		
		this.setLayout(new GridLayout(3,1,5,5));
		
		Bout1 = new JButton("yes");
		Bout2 = new JButton("yes");
		Bout3 = new JButton("yes");
		
		this.add(Bout1) ; this.add(Bout2) ; this.add(Bout3) ;
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Bout1) {  //BOUTON1
			
		}else {	
			if(e.getSource() == Bout2) {	//BOUTON2
			
			}else {	//BOUTON3
				
			}
			
		}
		
	}

}
