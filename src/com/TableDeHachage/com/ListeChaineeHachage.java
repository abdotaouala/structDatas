package com.TableDeHachage.com;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ListeChaineeHachage 
{
	private ElementListeChaineeHachage tete;
	private int longueur;
	public ListeChaineeHachage()
	{
		tete = null;
		longueur = 0;
	}
	
	private boolean verifierExistence(String titre)
	{
		// false == n'existe pas
		// true == Existe
		
		ElementListeChaineeHachage aide  = tete;
		
				while(aide != null)
				{
					if(aide.getTitre().equals(titre))
					{
						return true;
					}
					aide = aide.getSuivant();
				}
			
		return false;

	}
	
	public boolean insererElement(int position, ElementListeChaineeHachage element)
	{
		
		if(verifierExistence(element.getTitre()))
		{
			JOptionPane.showMessageDialog(null, "Album avec Titre = '" + element.getTitre() + "' est Deja Existant dans le Discothèque !!",
					null, JOptionPane.YES_OPTION);
			return false;
		}
		else
		{
			if(position >= 0 && position <= longueur)
			{
				
				ElementListeChaineeHachage aide = tete;
				if(position == 0)
				{
					element.setSuivant(tete);
					tete = element;
					
				}
				else
				{
					if(position == 1)
					{
						element.setSuivant(tete.getSuivant());
						tete.setSuivant(element);
						
					}
					else
					{
						ElementListeChaineeHachage temp = null;
						for(int i = 0; i < position; i++)
						{
							if(i == position - 1)
							{
								temp = aide;
							}
							aide = aide.getSuivant();
						}
						
						element.setSuivant(temp.getSuivant());
						temp.setSuivant(element);
					}
				}
				longueur ++;
				
			}
		}
		JOptionPane.showMessageDialog(null, "Insersion avec Success ", null, JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	public Object[] rechercher(String titre, JTextArea textArea)
	{
		ElementListeChaineeHachage aide = tete;
		int compteur = 0;
		Object[] retour = new Object[2];
		
		while(aide != null)
		{
			if(aide.getTitre().equals(titre))
			{
				textArea.setText("Cet Album est Présent dans le Discothèque\n");
				textArea.setText(textArea.getText() + "--------------------------------------------------------------\n");
				textArea.setText(textArea.getText() + "Titre : " + aide.getTitre() + "\n");
				textArea.setText(textArea.getText() + "Interprete : " + aide.getInterprete() + "\n");
				textArea.setText(textArea.getText() + "Label : " + aide.getLabel() + "\n");
				textArea.setText(textArea.getText() + "Date : " + aide.getDate() + "\n");
				textArea.setText(textArea.getText() + "Style Musicale : " + aide.getStyle_musicale() + "\n");
				
				retour[0] = aide;
				retour[1] = compteur;
				return retour;
			}
			compteur ++;
			aide = aide.getSuivant();
		}
		textArea.setText("Cet Album est Absent !!!");
		return null;
	}
	
	public void supprimer(String titre, JComboBox<Integer> combo)
	{
		
		JTextArea textArea = new JTextArea();
		Object[] retour = rechercher(titre, textArea);
		
		if(retour != null)
		{
			ElementListeChaineeHachage aide = (ElementListeChaineeHachage)retour[0];
			int option = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer cet Album ?", null, JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.OK_OPTION)
			{
				if((int)retour[1] == 0)
				{
					tete = tete.getSuivant();
				}
				else
				{
					if((int)retour[1] == 1)
					{
						tete.setSuivant(aide.getSuivant());
						aide = null;
					}
					else
					{
						ElementListeChaineeHachage temp = tete;
						for(int i = 0; i < (int)retour[1] - 1; i++)
						{
							temp = temp.getSuivant();
						}
						
						temp.setSuivant(aide.getSuivant());
						aide = null;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Album Supprimer avec Success", null, JOptionPane.INFORMATION_MESSAGE);
				combo.removeItemAt(longueur);
			}
			longueur --;
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Album avec Titre = '" + titre + "' n'existe pas dans le Discotheque !!", null,
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	

	public ElementListeChaineeHachage getTete() {
		return tete;
	}

	public void setTete(ElementListeChaineeHachage tete) {
		this.tete = tete;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
		
	
	
	
}
