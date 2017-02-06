package liste.chainee.com;

public class ElementListeChainee 
{
	private String titre;
	private String interprete;
	private String Label;
	private String date;
	private String style_musicale;
	private ElementListeChainee suivant;
	
	
	public ElementListeChainee(String titre, String interprete, String label, String date, String style_musicale) {
		super();
		this.titre = titre;
		this.interprete = interprete;
		Label = label;
		this.date = date;
		this.style_musicale = style_musicale;
		this.suivant = null;
	}
	
	
	
	
	public ElementListeChainee getSuivant() {
		return suivant;
	}




	public void setSuivant(ElementListeChainee suivant) {
		this.suivant = suivant;
	}




	@Override
	public String toString() {
		return "ElementListeChainee [titre=" + titre + ", interprete=" + interprete + ", Label=" + Label + ", date="
				+ date + ", style_musicale=" + style_musicale + ", suivant=" + suivant + "]";
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
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
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
	
	
}
