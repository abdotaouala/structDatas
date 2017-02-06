package com.ArbreRougeNoir.com;

public class Noeud 
{
	private Album album;
	private Noeud gauche;
	private Noeud droite;
	private Noeud pere;
	private String couleur;
	
	
	public Noeud(Album album) {
		super();
		this.album = album;
		this.gauche = null;
		this.droite = null;
		this.pere = null;
		this.couleur = "Rouge";
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}


	@Override
	public String toString() {
		return "Noeud [album=" + album + ", gauche=" + gauche + ", droite=" + droite + ", couleur="
				+ couleur + "]";
	}


	public Noeud getGauche() {
		return gauche;
	}


	public void setGauche(Noeud gauche) {
		this.gauche = gauche;
	}


	public Noeud getDroite() {
		return droite;
	}


	public void setDroite(Noeud droite) {
		this.droite = droite;
	}


	public Noeud getPere() {
		return pere;
	}


	public void setPere(Noeud pere) {
		this.pere = pere;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
	
}
