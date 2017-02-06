package com.ArbreRougeEtNoirCorrect.com;


public class Data implements Comparable<Data> {
    private String titre;
    private String interprete;
    private String label;
    private String date;
    private String styleMusicale;
    
    public Data(String titre, String interprete, String label, String date, String styleMusicale)
    {
        this.titre = titre;
        this.interprete = interprete;
        this.label = label;
        this.date = date;
        this.styleMusicale = styleMusicale;
    }
    
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

	public String getStyleMusicale() {
		return styleMusicale;
	}

	public void setStyleMusicale(String styleMusicale) {
		this.styleMusicale = styleMusicale;
	}

	@Override
    public int compareTo(Data d) {
        return titre.compareTo(d.getTitre());
    }
}