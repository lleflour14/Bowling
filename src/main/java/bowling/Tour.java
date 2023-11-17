package bowling;

import java.util.Arrays;

public class Tour {
	private int[] boule;
	private double score;
	
	
	
	public Tour(int[] boule){
		this.boule=boule;
		this.score=0;
	}
	
	
	public double getScore(){
		if(boule[0]==10){
			this.score=boule[0]+bonus();
		}
		else{
			this.score=boule[0]+ boule[0] + bonus();
		}
		
		return score;
	}

	public double bonus(){
		double ret=0;
		int[] lancers= new int[]{-1, -1};
		Tour tourprecedent = new Tour(lancers);

		//fais un spare
		if(tourprecedent.getBoule()[0]+tourprecedent.getBoule()[1]==10) {
			ret=boule[0];
		}
		//fais un strike
		if(tourprecedent.getBoule()[0]==10){
			ret=boule[0]+boule[1];
		}
		System.out.println(ret);
		return ret;
	}


	

	public void setBoulel1(int quille){
		
		boule[0]=quille;
	}

	public void setBoulel2(int quille){
		
		boule[1]=quille;
	}

	
	public int[] getBoule() {
		return boule;
	}

	@Override
	public String toString() {
		return ", lancer : " + Arrays.toString(boule) + ", score=" + score;
	}
}
