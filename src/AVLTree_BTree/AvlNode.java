/*
 * Hello :: 
 *  Java Program to Implement AVL Tree
 *  
 *  @author : abTAOUALA
 *  
 *  Date : 25/11/2016
 */
package AVLTree_BTree;

public class AvlNode {

	
	 Albume albume;
	  int height;
	 AvlNode left; // gauche
	  AvlNode right; // droit
	
	//constructor
	public AvlNode() {
		this.albume = null;
		this.height = 0;
		this.left = null;
		this.right = null;
	}

	//constructor with child
	public AvlNode(Albume albume, int height, AvlNode left, AvlNode right) {
		super();
		this.albume = albume;
		this.height = height;
		this.left = left;
		this.right = right;
	}
	
	//constructor without child
	
	public AvlNode(Albume albume) {
		super();
		this.albume = albume;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
	

	public Albume getAlbume() {
		return albume;
	}

	public void setAlbume(Albume albume) {
		this.albume = albume;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AvlNode getLeft() {
		return left;
	}

	public void setLeft(AvlNode left) {
		this.left = left;
	}

	public AvlNode getRight() {
		return right;
	}

	public void setRight(AvlNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "AvlNode [albume=" + albume + ", height=" + height + "]";
	}
	
	
}
