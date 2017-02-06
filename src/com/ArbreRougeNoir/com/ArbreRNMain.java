package com.ArbreRougeNoir.com;

public class ArbreRNMain {

	public static void main(String[] args) 
	{
		ArbreRN arbreRN = new ArbreRN();
		Object[] verifier;
		
		Album d1 = new Album("Titre1", "a", "dd", "ssd", "ddse");
		Album d2 = new Album("Titre2", "a", "dd", "ssd", "ddse");
		Album d3 = new Album("C", "a", "dd", "ssd", "ddse");
		Album d4 = new Album("Titre4", "a", "dd", "ssd", "ddse");
		Album d5 = new Album("Titre5", "a", "dd", "ssd", "ddse");
		
		Noeud n1 = new Noeud(d1);
		Noeud n2 = new Noeud(d2);
		Noeud n3 = new Noeud(d3);
		Noeud n4 = new Noeud(d4);
		Noeud n5 = new Noeud(d5);
		
		arbreRN.inserer(n1, arbreRN.getRacine());
		//verifier = arbreRN.verifier(arbreRN.getRacine());
		arbreRN.inserer(n2, arbreRN.getRacine());
		arbreRN.inserer(n3, arbreRN.getRacine());
		arbreRN.inserer(n4, arbreRN.getRacine());
		arbreRN.inserer(n5, arbreRN.getRacine());
		
		
		arbreRN.afficher(arbreRN.getRacine());
	}

}
