/*
 * Hello :: 
 *  Java Program to Implement AVL Tree
 *  
 *  @author : abTAOUALA
 *  
 *  Date : 25/11/2016
 */
package AVLTree_BTree;

import AVLTree_BTree.Albume;
import AVLTree_BTree.AvlTree;
import AVLTree_BTree.BTree;

public class prog {

	public static void main(String[] args) {
		
		Albume albume1=new Albume("albume1", 1);
		Albume albume2=new Albume("albume2", 2);
		Albume albume3=new Albume("albume3", 3);
		Albume albume4=new Albume("albume4", 4);
		Albume albume5=new Albume("albume5", 5);
		Albume albume6=new Albume("albume6", 6);
		
		AvlTree tree=new AvlTree();
		tree.insert(albume1);
		tree.insert(albume2);
		tree.insert(albume3);
		tree.insert(albume4);
		tree.insert(albume5);
		tree.insert(albume6);
		System.out.println(tree.search(1) == null ? "Not found !!" : tree.search(1));
		System.out.println("--------------------------------");
		tree.parcourisprefexe();
		System.out.println("--------------------------------");
		tree.remove(albume1);
		tree.remove(albume2);
		tree.parcourisinfexe();;
		System.out.println("--------------------------------");
		tree.parcourispostfexe();
		System.out.println("--------------------------------\n"+tree.countNodes());
		tree.countNodes();
		
		
		BTree btree=new BTree(4);
		System.out.println(btree.add(albume2));
		System.out.println(btree.add(albume3));
		System.out.println(btree.add(albume4));
		System.out.println(btree.add(albume5));
		System.out.println(btree.add(albume6));
		System.out.println(btree.count);
		btree.display();
		btree.remove(albume1);
		System.out.println(btree.count);
		btree.remove(albume2);
		System.out.println(btree.count);
		btree.remove(albume3);
		System.out.println(btree.count);
	}
}
