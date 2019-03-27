
public class Event {

	  private Plateau plateau;
	  private int h;
	  private int l;

	  public Event(Plateau monde){
	  	  this.plateau = monde;
	  }


	  public void monteeDesEaux(){
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  if ( this.plateau.mondeDino[i][j].type == "Herbivore"){
					  this.plateau.mondeDino[i][j].retirerVieDinosaure(20);
				  }
				  else {
					  this.plateau.mondeDino[i][j].retirerVieDinosaure(50);
				  }
			  }
		  }
	  }


	  public void meteorite(){
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  this.plateau.mondeDino[i][j].retirerVieDinosaure(50);
			  }
		  }
	  }


	  public void secheresse(){
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  if ( this.plateau.mondeDino[i][j].type == "Herbivore"){
					  this.plateau.mondeDino[i][j].retirerVieDinosaure(50);
				  }
				  else {
					  this.plateau.mondeDino[i][j].retirerVieDinosaure(20);
				  }
			  }
		  }
	  }



	}
