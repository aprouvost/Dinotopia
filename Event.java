
public class Event {

	  private Dinosaure [][] monde;
	  private int h;
	  private int l;

	  public Event(){}



	  public void monteeDesEaux(){
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  if ( monde[i][j].type == "Herbivore"){
					  monde[i][j].retirerVieDinosaure(20);
				  }
				  else {
					  monde[i][j].retirerVieDinosaure(50);
				  }
			  }
		  }
	  }


	  public void meteorite(){
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  monde[i][j].retirerVieDinosaure(50);
			  }
		  }
	  }


	  public void secheresse(){
		  for (int i=0; i<l; i++){
			  for (int j=0; j<h; j++){
				  if ( monde[i][j].type == "Herbivore"){
					  monde[i][j].retirerVieDinosaure(50);
				  }
				  else {
					  monde[i][j].retirerVieDinosaure(20);
				  }
			  }
		  }
	  }



	}
