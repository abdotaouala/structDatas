package com.TableDeHachage.com;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TableHachage 
{
	private final int Taille = 20;
	private ListeChaineeHachage[] tableauDeHachageDeListe = new ListeChaineeHachage[Taille];
	
	public TableHachage()
	{
		for(int i = 0; i < Taille; i++)
		{
			tableauDeHachageDeListe[i] = null;
		}
	}
	
	public int fonctionHachage(String titre)
	{
		int somme = 0;
		for(int i = 0; i < titre.length(); i++)
		{
			int caractereEntier = titre.charAt(i);
			somme = somme + caractereEntier;
		}
		return somme % Taille;
	}
	
	public void ajouterALaTableDeHachage(ElementListeChaineeHachage element)
	{
		int cle = fonctionHachage(element.getTitre());
		if(tableauDeHachageDeListe[cle] == null)
		{
			tableauDeHachageDeListe[cle] = new ListeChaineeHachage();
			tableauDeHachageDeListe[cle].insererElement(tableauDeHachageDeListe[cle].getLongueur(), element);
		}
		else
		{
			tableauDeHachageDeListe[cle].insererElement(tableauDeHachageDeListe[cle].getLongueur(), element);
		}
	}
	
	public void afficherDiscotheque(JTextArea textArea)
	{
		textArea.setText("");
		for(int i = 0; i < tableauDeHachageDeListe.length; i++)
		{
			if(tableauDeHachageDeListe[i] != null)
			{
				if(tableauDeHachageDeListe[i].getTete() != null)
				{
					ElementListeChaineeHachage aide = this.getTableauDeHachageDeListe()[i].getTete();
					textArea.setText(textArea.getText() + "-------------------Element " + i + " du Tableau-----------------------\n");
					while(aide != null)
					{
						
						textArea.setText(textArea.getText() + "Titre : " + aide.getTitre() + "\n");
						textArea.setText(textArea.getText() + "Interprete : " + aide.getInterprete() + "\n");
						textArea.setText(textArea.getText() + "Label : " + aide.getLabel() + "\n");
						textArea.setText(textArea.getText() + "Date : " + aide.getDate() + "\n");
						textArea.setText(textArea.getText() + "Style Musicale : " + aide.getStyle_musicale() + "\n");
						textArea.setText(textArea.getText() + "\n");
						aide = aide.getSuivant();

					}
				}
				
			}
			
			
		}
		
	}
	
	public Object[] rechercher(String titre, JTextArea textArea)
	{
		
		Object[] retour = null;
		
		for(int i = 0; i < tableauDeHachageDeListe.length; i++)
		{
			if(tableauDeHachageDeListe[i] != null)
			{
				ElementListeChaineeHachage aide = tableauDeHachageDeListe[i].getTete();
				int compteur = 0;
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
						retour = new Object[3];
						retour[0] = aide;
						retour[1] = i;
						retour[2] = compteur;
						return retour;
					}
					compteur ++;
					aide = aide.getSuivant();
				}
			}
		}
		
		
		
		
		textArea.setText("Cet Album est Absent !!!");
		return retour;
	}
	
	public void supprimer(String titre)
	{
		
		JTextArea textArea = new JTextArea();
		Object[] retour = rechercher(titre, textArea);
		
		if(retour != null)
		{
			int indiceHachage = (int)retour[1];
			ElementListeChaineeHachage aide = (ElementListeChaineeHachage)retour[0];
			int option = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer cet Album ?", null, JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.OK_OPTION)
			{
				if((int)retour[2] == 0)
				{
					tableauDeHachageDeListe[indiceHachage].setTete(tableauDeHachageDeListe[indiceHachage].getTete().getSuivant());
					
				}
				else
				{
					if((int)retour[2] == 1)
					{
						tableauDeHachageDeListe[indiceHachage].getTete().setSuivant(aide.getSuivant());
						aide = null;
					}
					else
					{
						ElementListeChaineeHachage temp = tableauDeHachageDeListe[indiceHachage].getTete();
						for(int i = 0; i < (int)retour[2] - 1; i++)
						{
							temp = temp.getSuivant();
						}
						
						temp.setSuivant(aide.getSuivant());
						aide = null;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Album Supprimer avec Success", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			tableauDeHachageDeListe[indiceHachage].setLongueur(tableauDeHachageDeListe[indiceHachage].getLongueur() - 1);
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Album avec Titre = '" + titre + "' n'existe pas dans le Discotheque !!", null,
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public ListeChaineeHachage[] getTableauDeHachageDeListe() {
		return tableauDeHachageDeListe;
	}

	public void setTableauDeHachageDeListe(ListeChaineeHachage[] tableauDeHachageDeListe) {
		this.tableauDeHachageDeListe = tableauDeHachageDeListe;
	}

	public int getTaille() {
		return Taille;
	}

	
}
