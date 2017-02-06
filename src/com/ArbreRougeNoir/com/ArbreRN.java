package com.ArbreRougeNoir.com;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ArbreRN 
{
	private Noeud racine; 
	private String rouge = "Rouge";
	private String noir = "Noir";
	private String gaucheString = "Gauche";
	private String droiteString = "Droite";
	private int compteurDeNoeuds = 0;
	private int aide = 0;
	
	public ArbreRN()
	{
		this.racine = new Noeud(null);
		this.racine.setCouleur(noir);
	}
	
	public void inserer(Noeud element, Noeud racine)
	{
		
		if(racine.getAlbum() == null)
		{
			this.racine = element;
			this.racine.setCouleur(noir);
			JOptionPane.showMessageDialog(null, "Creation de la Racine ", null, JOptionPane.INFORMATION_MESSAGE);
			compteurDeNoeuds ++;
		}
		else
		{
			if(element.getAlbum().getTitre().compareTo(racine.getAlbum().getTitre()) == 0)
			{
				JOptionPane.showMessageDialog(null, "Album Deja Existant", null, JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(element.getAlbum().getTitre().compareTo(racine.getAlbum().getTitre()) < 0)
				{
					if(racine.getGauche() == null)
					{
						racine.setGauche(element);
						element.setPere(racine);
						JOptionPane.showMessageDialog(null, "Album Inserer avec Succes", null, JOptionPane.INFORMATION_MESSAGE);
						compteurDeNoeuds ++;
					}
					else
					{
						inserer(element, racine.getGauche());
					}
				}
				else
				{
					if(racine.getDroite() == null)
					{
						racine.setDroite(element);
						element.setPere(racine);
						JOptionPane.showMessageDialog(null, "Album Inserer avec Succes", null, JOptionPane.INFORMATION_MESSAGE);
						compteurDeNoeuds ++;
						
					}
					else
					{
						inserer(element, racine.getDroite());
					}
				}
			}
		}
		
		
	}
	
	public int getCompteurDeNoeuds() {
		return compteurDeNoeuds;
	}

	public void setCompteurDeNoeuds(int compteurDeNoeuds) {
		this.compteurDeNoeuds = compteurDeNoeuds;
	}

	
	public void verifier(Noeud racine, Object[] verificationTableau)
	{
		
		if(racine.getCouleur() == rouge)
		{
			Noeud cc = racine;
			if(racine.getGauche() != null)
			{
				if(racine.getGauche().getCouleur() == rouge)
				{
					verificationTableau[0] = racine.getGauche();
					verificationTableau[1] = gaucheString;
				}
			}
			
			if(racine.getDroite() != null)
			{
				if(racine.getDroite().getCouleur() == rouge)
				{
					verificationTableau[0] = racine.getDroite();
					verificationTableau[1] = droiteString;
				}
			}
		}
		else
		{
			Noeud cc = racine;
			if(racine.getGauche() != null)
			{
				verifier(racine.getGauche(), verificationTableau);
			}
			
			if(racine.getDroite() != null)
			{
				verifier(racine.getDroite(), verificationTableau);
			}
		}
	}
		
		
		
	
	
	
	
	
	

	public String getRouge() {
		return rouge;
	}


	public void setRouge(String rouge) {
		this.rouge = rouge;
	}


	public String getNoir() {
		return noir;
	}


	public void setNoir(String noir) {
		this.noir = noir;
	}


	public String getGaucheString() {
		return gaucheString;
	}


	public void setGaucheString(String gaucheString) {
		this.gaucheString = gaucheString;
	}


	public String getDroiteString() {
		return droiteString;
	}


	public void setDroiteString(String droiteString) {
		this.droiteString = droiteString;
	}


	public void rotationGauche(Noeud fils)
	{
		Noeud pere = fils.getPere();
		Noeud grandPere = pere.getPere();
		//System.out.println(grandPere.getAlbum().getTitre());
		if(pere != this.racine)
		{
			if(grandPere.getPere() != null)
			{
				if(grandPere == grandPere.getPere().getGauche())
				{
					// Si le grandPere est le fils gauche de son pere
					if(grandPere.getGauche() == pere)
					{
						
						grandPere.getPere().setGauche(pere);
						pere.setDroite(grandPere);
						grandPere.setGauche(fils);
						pere.setPere(grandPere.getPere());
						grandPere.setPere(pere);
						fils.setPere(grandPere);
						grandPere.setCouleur(rouge);
						pere.setCouleur(noir);
						if(racine.getCouleur() != noir)
							racine.setCouleur(noir);
					}
					else
					{
						
						grandPere.getPere().setGauche(pere);
						pere.setGauche(grandPere);
						pere.setPere(grandPere.getPere());
						grandPere.setPere(pere);
						grandPere.setCouleur(rouge);
						pere.setCouleur(noir);
						if(racine.getCouleur() != noir)
							racine.setCouleur(noir);
					}
					
				}
				else
				{
					// si le grandPere est le fils droit de son Pere
					if(grandPere.getGauche() == pere)
					{
						
						grandPere.getPere().setDroite(pere);
						pere.setDroite(grandPere);
						grandPere.setGauche(fils);
						pere.setPere(grandPere.getPere());
						grandPere.setPere(pere);
						fils.setPere(grandPere);
						grandPere.setCouleur(rouge);
						pere.setCouleur(noir);
						if(racine.getCouleur() != noir)
							racine.setCouleur(noir);
					}
					else
					{
						
						grandPere.getPere().setDroite(pere);
						pere.setGauche(grandPere);
						pere.setPere(grandPere.getPere());
						grandPere.setPere(pere);
						grandPere.setCouleur(rouge);
						pere.setCouleur(noir);
						if(racine.getCouleur() != noir)
							racine.setCouleur(noir);
					}
					
				}
			}
			else
			{
				if(pere == grandPere.getGauche())
				{
					pere.setDroite(grandPere);
					grandPere.setGauche(fils);
					pere.setPere(null);
					grandPere.setPere(pere);
					fils.setPere(grandPere);
					pere.setCouleur(noir);
					grandPere.setCouleur(rouge);
				}
				else
				{
					pere.setGauche(grandPere);
					pere.setPere(null);
					grandPere.setPere(pere);
					pere.setCouleur(noir);
					grandPere.setCouleur(rouge);
					
				}
			}
			
		}
		else
		{
			pere.setCouleur(noir);
		}
		
	}
	
	public void rotationDroite(Noeud fils)
	{
		Noeud pere = fils.getPere();
		Noeud grandPere = pere.getPere();
		
		
		if(pere != this.racine)
		{
			if(pere == grandPere.getDroite())
			{
				grandPere.setDroite(fils);
				fils.setDroite(pere);
				fils.setPere(grandPere);
				pere.setPere(fils);
			}
			
			if(pere == grandPere.getGauche())
			{
				pere.setGauche(fils);
				fils.setDroite(pere);
				fils.setPere(grandPere);
				pere.setPere(fils);
			}
			
		}
		else
		{
			this.racine.setCouleur(noir);
		}
		
		
	}
	
	public void coloration(Noeud fils)
	{
		Noeud pere = fils.getPere();
		Noeud oncle = null;
		
		if(pere == pere.getPere().getGauche())
			oncle = pere.getPere().getDroite();
		else
			oncle = pere.getPere().getGauche();
		
		pere.setCouleur(noir);
		oncle.setCouleur(noir);
		pere.getPere().setCouleur(rouge);
		
		if(racine.getCouleur() != noir)
			racine.setCouleur(noir);
				
	}
	
	public String couleurOncle(Noeud fils)
	{
		Noeud oncle = null;
		Noeud pere = fils.getPere();
		String couleurOncle = null;
		
		if(pere == pere.getPere().getGauche())
		{
			oncle = pere.getPere().getDroite();
		}
		
		if(pere == pere.getPere().getDroite())
		{
			oncle = pere.getPere().getGauche();
		}
		
		if(oncle == null)
		{
			couleurOncle = noir;
		}
		else
		{
			if(oncle.getCouleur() == noir)
			{
				couleurOncle = noir;
			}
			
			if(oncle.getCouleur() == rouge)
			{
				couleurOncle = rouge;
			}
		}
		
		return couleurOncle;

	}
	

	public void afficher(Noeud racine)
	{
		Noeud aide = racine;
		
		System.out.println("------------------------------------------");
		System.out.println(aide.toString());
		
		if(racine.getGauche() != null)
			afficher(racine.getGauche());
		
		if(racine.getDroite() != null)
			afficher(racine.getDroite());
		
		
	}

	public void afficherEnLargeur(Noeud racine, JTextArea textArea)
	{
		ArrayList<Noeud> file = new ArrayList<Noeud>();
		
		file.add(racine);
		textArea.setText("");
		while(file.size() != 0)
		{
			Noeud aide = file.remove(file.size() - 1);
			textArea.setText(textArea.getText() + aide.getAlbum().getTitre() + " " + aide.getCouleur() + "\n");
			
			textArea.setText(textArea.getText() + "---------------------\n");
			
			if(aide.getGauche() != null)
			{
				file.add(0, aide.getGauche());
			}
			
			if(aide.getDroite() != null)
			{
				file.add(0, aide.getDroite());
			}
		}
	}



	public Noeud getRacine() {
		return racine;
	}

	public void setRacine(Noeud racine) {
		this.racine = racine;
	}
}
