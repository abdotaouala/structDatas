/*
 * Hello :: 
 *  Java Program to Implement AVL Tree
 *  
 *  @author : abTAOUALA
 *  
 *  Date : 25/11/2016
 */
package AVLTree_BTree;

public class Albume  implements Comparable{

	
	private int index;
	private String titre;
	private String interprete;
	private String label;
	private String date;
	private String style_musicale;
	
	public Albume(String titre,int index) {

		this.titre=titre;
		this.index=index;
	}

	public Albume() {
		// TODO Auto-generated constructor stub
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Albume [titre=" + titre + ", index=" + index + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub

		if(this.index>((Albume)o).getIndex()) return 1;
		if(this.index<((Albume)o).getIndex()) return -1;
		
		else return 0;
	}
	
	
}
