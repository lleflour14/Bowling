package bowling;

import java.util.Arrays;

public class Tour {

	//tableau de 2 lancés
	protected int[] boule;

	public Tour(int[] boule) {
		this.boule = boule;
	}

	//changement de valeurs du lancé 1
	public void setBoulel1(int quille) {
		
		boule[0] = quille;
	}

	//changement de valeurs du lancé 2
	public void setBoulel2(int quille) {
		boule[1] = quille;
	}


	public int[] getBoule() {
		return boule;
	}

	@Override
	public String toString() {
		return "lancés : " + Arrays.toString(boule);
	}
}
