package com.ArbreRougeNoir.com;

public class Album 
{
	private String titre;
	private String interprete;
	private String label;
	private String date;
	private String style_musicale;
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getInterprete() {
		return interprete;
	}
	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStyle_musicale() {
		return style_musicale;
	}
	public void setStyle_musicale(String style_musicale) {
		this.style_musicale = style_musicale;
	}
	
	@Override
	public String toString() {
		return "Donnee [titre=" + titre + ", interprete=" + interprete + ", label=" + label + ", date=" + date
				+ ", style_musicale=" + style_musicale + "]";
	}
	public Album(String titre, String interprete, String label, String date, String style_musicale) {
		super();
		this.titre = titre;
		this.interprete = interprete;
		this.label = label;
		this.date = date;
		this.style_musicale = style_musicale;
	}
	
	
}
