package bowling;

import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {

	private int score;
	private ArrayList<Tour> partie;
	
	
	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		this.score=0;
		this.partie=new ArrayList<>();
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
		Lancer l = new Lancer(nombreDeQuillesAbattues);
		if(estTerminee()){
			throw new IllegalStateException("la partie est terminée");
		}
		if(partie.isEmpty()){
			ArrayList<Lancer> boules = new ArrayList<>();
			boules.add(l);
			Tour t = new Tour(1,boules);
			partie.add(t);
			System.out.println(partie);
		}
		
		//fin du tour si 2 lancers effectuer ou si strike
		
		else if(nombreDeQuillesAbattues==10 || partie.get(partie.size()-1).getBoule().size()==1){
			
			ArrayList<Lancer> boules = new ArrayList<>();
			boules.add(l);
			Tour t = new Tour(partie.size(),boules);
			partie.add(t);
			System.out.println(partie);
			return false;
		}
		else{
			partie.get(partie.size()-1).getBoule().add(l);
			System.out.println("test");
			System.out.println(partie);

		}
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
		if(partie.size()==20){
			ret=true;
		}
		return ret;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		int ret=0;
		if(partie.isEmpty()){
			ret=1;
		}
		else if(!estTerminee()){
			if(partie.get(partie.size()-1).getBoule().size()==1){
				ret=partie.get(partie.size()-1).getNum()+1;
			}
			else{
				ret=partie.get(partie.size()-1).getNum()+2;
			}
			
		}
		return ret;
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		int ret=0;
		if(partie.isEmpty()){
			ret=1;
		}
		else if(!estTerminee()){
			ret=partie.get(partie.size()-1).getNum();
		}
		return ret;
	}

}
