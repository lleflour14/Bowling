package bowling;

public class DernierTour extends Tour {

	//dernier tour donc 3 lancés
	public DernierTour(int[] boule) {
		super(boule);
	}

	//changement de valeurs du lancé 3
	public void setBoulel3(int quille) {

		boule[2] = quille;
	}

}
