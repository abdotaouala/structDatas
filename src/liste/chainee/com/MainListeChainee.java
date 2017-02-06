package liste.chainee.com;

import java.util.Scanner;

public class MainListeChainee 
{

	public static void main(String[] args) 
	{
		
//		ListeChainee listeChainee = new ListeChainee();
//		
//		ElementListeChainee element1 = new ElementListeChainee("abdellah", "beyyato", "Calme", new Date(), "House Music");
//		listeChainee.insererElement(0, element1);
//		
//		ElementListeChainee element2 = new ElementListeChainee("abdellah", "dds", "asaw", new Date(), "rret");
//		listeChainee.insererElement(1, element2);
//		
//		element2.setTitre("Beyyato");
//		listeChainee.insererElement(1, element2);
//		
//		listeChainee.rechercher("abdellah");
//		listeChainee.rechercher("2215");
//		
//		ElementListeChainee element3 = new ElementListeChainee("Hamid", "ssaw", "wqw", new Date(), "Rap");
//		listeChainee.insererElement(0, element3);
//		
//		listeChainee.afficherDiscotheque();
//		
//		listeChainee.supprimer("abdellah");
		
		Scanner sc = new Scanner(System.in);
		int nombre = -1;
		do
		{
			System.out.println("Entrez un numero (0 pour quitter)");
			System.out.println("");
			nombre = sc.nextInt();
		}
		while(nombre != 0);

	}

}
