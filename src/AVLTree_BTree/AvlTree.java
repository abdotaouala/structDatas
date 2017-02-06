/*
 * Hello :: 
 *  Java Program to Implement AVL Tree
 *  
 *  @author : abTAOUALA
 *  
 *  @Date : 25/11/2016
 */

package AVLTree_BTree;

public class AvlTree {

	private AvlNode root; // first node of tree

	public AvlTree() { // constructor
		root = null; // no nodes in tree yet
	}

	public AvlNode getRoot() {
		return root;
	}

	// Tree null
	public boolean isEmpty() {
		return root == null;
	}
	/* Make the tree logically empty */

	public void makeEmpty() {
		root = null;
	}

	/* Function to insert data */
	public void insert(Albume albume) {
		root = insert(albume, root);
	}

	/* Function to get height of node */
	private int height(AvlNode t) {
		return t == null ? 0 : t.getHeight();
	}

	/* Function to max of left/right node */
	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	/* Function to insert data recursively */
	private AvlNode insert(Albume x, AvlNode t) {
		if (t == null)
			t = new AvlNode(x);
		// insert to left
		else if (x.getIndex() < t.getAlbume().getIndex()) {
			t.setLeft(insert(x, t.getLeft()));
			if (height(t.getLeft()) - height(t.getRight()) == 2)
				if (x.getIndex() < t.getLeft().getAlbume().getIndex())
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		}
		// insert to right
		else if (x.getIndex() > t.getAlbume().getIndex()) {
			t.setRight(insert(x, t.getRight()));
			if (height(t.getRight()) - height(t.getLeft()) == 2)
				if (x.getIndex() > t.getRight().getAlbume().getIndex())
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			;
		// Duplicate; do nothing
		t.setHeight(max(height(t.getLeft()), height(t.getRight())) + 1);

		return t;
	}

	/* Rotate binary tree node with left child */
	private AvlNode rotateWithLeftChild(AvlNode k2) {
		AvlNode k1 = k2.getLeft();
		k2.setLeft(k1.getRight());
		k1.setRight(k2);
		k2.setHeight(max(height(k2.getLeft()), height(k2.getRight())) + 1);
		k1.setHeight(max(height(k1.getLeft()), k2.getHeight()) + 1);
		return k1;
	}

	/* Rotate binary tree node with right child */
	private AvlNode rotateWithRightChild(AvlNode k1) {
		AvlNode k2 = k1.getRight();
		k1.setRight(k2.getLeft());
		k2.setLeft(k1);
		k1.setHeight(max(height(k1.getLeft()), height(k1.getRight())) + 1);
		k2.setHeight(max(height(k2.getRight()), k1.getHeight()) + 1);
		return k2;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child
	 */
	private AvlNode doubleWithLeftChild(AvlNode k3) {
		k3.setLeft(rotateWithRightChild(k3.getLeft()));
		return rotateWithLeftChild(k3);
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child
	 */
	private AvlNode doubleWithRightChild(AvlNode k1) {
		k1.setRight(rotateWithLeftChild(k1.getRight()));
		return rotateWithRightChild(k1);
	}

	/* Functions to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(AvlNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	/* Functions to search for an element */
	public Albume search(int val) {
		return search(root, val);
	}

	private Albume search(AvlNode r, int index) {
		boolean found = false;
		Albume albume = null;
		while ((r != null) && !found) {
			int rindex = r.getAlbume().getIndex();

			if (index < rindex)
				r = r.getLeft();
			else if (index > rindex)
				r = r.getRight();
			else {
				found = true;
				albume = r.getAlbume();
				break;
			}
			// found = search(r, index);
		}
		return albume;
	}
	
	//REMOVE NODE 
	
//	public boolean removeNode(AvlNode node) {
//		// TODO Auto-generated method stub
//		if( (node != null) && search(node.getAlbume().getIndex())!=null)
//		removeNode(root,node);	
//		else return false;
//		
//		return true;
//	}
//	
//	private void removeNode(AvlNode node,AvlNode temp) {
//		// TODO Auto-generated method stub7
//		
//		if(temp.getLeft()==null && temp.getRight()==null)
//			temp=null;
//		
//		int compare=0;
//		if(temp!=root)
//			compare=node.getAlbume().compareTo(temp.getAlbume());
//
//		boolean direction = (compare > 0 && temp != root);
//		
//		AvlNode child = direction ? temp.getRight() : temp.getLeft();
//
//		if(child == null)
//			 return;
//
//		if(temp == root && height( child.getRight())-height( child.getLeft()) == 0  && child.getAlbume().getIndex() == node.getAlbume().getIndex()){
//
//			AvlNode newRoot = child.getLeft();
//			if(newRoot == null){
//				root.setLeft(null);
//				return;
//			}
//			else{
//
//				//enactRemoval(temp, child, false);
//				 return;
//			}
//		}
//		else if(node.getAlbume().compareTo(child.getAlbume()) == 0){
//			//enactRemoval(temp, child, direction);
//		}
//		else{
//			removeNode(node, child);
//
//		}
//		
//		
//		}
	
	 public void remove( Albume x )
	    {
	        root = remove( x, root );
	    }
	 
	 private AvlNode remove( Albume x, AvlNode t )
	    {
	        if( t == null )
	            return t;   // Item not found; do nothing
	            
	        int compareResult = x.compareTo( t.getAlbume() );
	            
	        if( compareResult < 0 )
	            t.setLeft(remove( x, t.getLeft() ));
	        else if( compareResult > 0 )
	            t.setRight (remove( x, t.getRight() ));
	        else if( t.getLeft() != null && t.getRight() != null ) // Two children
	        {
	            t.setAlbume(findMin( t.getRight() ).getAlbume());
	            t.setRight(remove( t.getAlbume(), t.getRight() ));
	        }
	        else
	            t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
	        return balance( t );
	    }
	//find Min
	 private AvlNode findMin( AvlNode t )
	    {
	        if( t == null )
	            return t;

	        while( t.getLeft() != null )
	            t = t.getLeft();
	        return t;
	    }
	 
	 //balance tree
	 private static final int ALLOWED_IMBALANCE = 1;
	 private AvlNode balance( AvlNode t )
	    {
	        if( t == null )
	            return t;
	        
	        if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE )
	            if( height( t.left.left ) >= height( t.left.right ) )
	                t = rotateWithLeftChild( t );
	            else
	                t = doubleWithLeftChild( t );
	        else
	        if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE )
	            if( height( t.right.right ) >= height( t.right.left ) )
	                t = rotateWithRightChild( t );
	            else
	                t = doubleWithRightChild( t );

	        t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
	        return t;
	    }

	// list Tree with parcours prefexe : preorder ;)

	public void parcourisprefexe() {
		parcourisprefexe(root);
	}

	private void parcourisprefexe(AvlNode node) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("list is empty !!");
			return;
		}

		AvlNode temp = node;
		System.out.println(temp.getAlbume());
		if (temp.getLeft() != null)
			parcourisprefexe(temp.getLeft());
		if (temp.getRight() != null)
			parcourisprefexe(temp.getRight());

	}

	// list Tree with parcours infexe : inorder
	public void parcourisinfexe() {
		parcourisinfexe(root);
	}

	private void parcourisinfexe(AvlNode node) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("list is empty !!");
			return;
		}

		AvlNode temp = node;

		if (temp.getLeft() != null)
			parcourisprefexe(temp.getLeft());
		System.out.println(temp.getAlbume());
		if (temp.getRight() != null)
			parcourisprefexe(temp.getRight());

	}

	// list Tree with parcours postfexe : //postorder
	public void parcourispostfexe() {
		parcourispostfexe(root);
	}

	private void parcourispostfexe(AvlNode node) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("list is empty !!");
			return;
		}

		if (node.getLeft() != null)
			parcourisprefexe(node.getLeft());

		if (node.getRight() != null)
			parcourisprefexe(node.getRight());
		System.out.println(node.getAlbume());
		
	}

	// parcours en largeur

}

// end thanks ::: ::: &copy; TAOUALA 2016