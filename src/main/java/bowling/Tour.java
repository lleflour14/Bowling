package bowling;

import java.util.ArrayList;

public class Tour {
	private ArrayList<Lancer> boule;
	private double score;
	
	private int num;
	
	public Tour(int num,ArrayList boule){
		this.num=num;
		this.boule=boule;
		this.score=0;
	}
	public Tour(int num){
		this.num=num;
	}
	
	
	public double getScore(){
		if(boule.get(0).getQuille()==10){
			score=boule.get(0).getQuille()+bonus();
		}
		else{
			score=boule.get(0).getQuille()+boule.get(1).getQuille()+bonus();
		}
		
		return score;
	}

	public double bonus(){
		double ret=0;
		Tour tourprecedent=new Tour(num-1);
		//fais un spare
		if(tourprecedent.getBoule().get(0).getQuille()+tourprecedent.getBoule().get(1).getQuille()==10) {
			ret=boule.get(0).getQuille();
		}
		//fais un strike
		if(tourprecedent.getBoule().get(0).getQuille()==10){
			ret=boule.get(0).getQuille()+boule.get(1).getQuille();
		}
		return ret;
	}


	public int getNum() {
		return num;
	}


	public ArrayList<Lancer> getBoule() {
		return boule;
	}

	@Override
	public String toString() {
		return "tour : " + num + ", lancer : " + boule + ", score=" + score;
	}
}
