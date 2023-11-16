package bowling;

public class Lancer {
	
	private int quille;
	
	public Lancer(int quille){
		this.quille=quille;
	}

	public int getQuille() {
		return quille;
	}

	@Override
	public String toString() {
		return
			"nbrquille=" + quille;
	}
}
