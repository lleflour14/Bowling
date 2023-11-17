package bowling;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {

	private int score;
	private Tour[] partie;
	
	
	
	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		this.score=0;
		this.partie=new Tour[10];
		for(int i=0;i< partie.length;i++){
			int[] lancers= new int[]{-1, -1};
			partie[i]=new Tour(lancers);
		}
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) throws IllegalStateException{
		boolean ret= true;
		
		//fin de partie
		if(estTerminee()){
			throw new IllegalStateException("la partie est terminée");
		}
		
		//strike
		if(nombreDeQuillesAbattues==10){
			partie[numeroTourCourant()-1].setBoulel1(10);
			ret=false;
		} 
		
		else if (numeroProchainLancer()==1) {
			partie[numeroTourCourant()-1].setBoulel1(nombreDeQuillesAbattues);
			ret= true;
			
			
		}
		else{
			partie[numeroTourCourant()-1].setBoulel2(nombreDeQuillesAbattues);
			ret=false;
			
		}
		System.out.println(partie[0].getBoule()[0]);
		System.out.println(partie[0].getBoule()[1]);

		return ret;
	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public double score() {
		double ret=0;
		for(Tour t : partie){
			ret+=t.getScore();
		}
		return ret;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		boolean ret = false;
		if(partie[9].getBoule()[1]!=-1){
			ret=true;
		}
		return ret;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		if(!estTerminee()){
			for(int i=0;i<10;i++){
				if(partie[i].getBoule()[0]==-1 ) {
					return i + 1;
				}
				else if(partie[i].getBoule()[0]==10){
					return i+2;
				} else if (partie[i].getBoule()[1]==-1) {
					return i+1;
				}
			}
		}
		return 0;
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		int ret=0;
		if(!estTerminee()){
			if(partie[numeroTourCourant()-1].getBoule()[0]==-1){
				ret=1;
				System.out.println("test");
				System.out.println(numeroTourCourant());
			}
			else if(partie[numeroTourCourant()-1].getBoule()[1]==-1 || partie[numeroTourCourant()-1].getBoule()[0]==10){
				ret=2;
				
			}
			else {
				ret=1;
			}
		}
		return ret;
	}

}
