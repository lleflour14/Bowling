package bowling;

import java.util.Arrays;

public class Tour {
	private int[] boule;
	private double score;
	
	
	
	public Tour(int[] boule){
		this.boule=boule;
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
		return "lancés : " + Arrays.toString(boule);
	}
}
