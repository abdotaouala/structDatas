/*
 * Hello :: 
 *  Java Program to Implement AVL Tree
 *  
 *  @author : abTAOUALA
 *  
 *  Date : 25/11/2016
 */
package AVLTree_BTree;

public class BNode {

	public int count;
	String[] values;
	BNode[] links;
    final int order=0;
    BNode root;
	//constructor
	public BNode() {
		values = new String[order-1];
		links = new BNode[order];
	}
	//return true if values array is full
	boolean isFull() {
		return values[order-2] != null;
	}
			//return true if values array is empty
	boolean isEmpty() {
		return this == null;
	}
	
	//returns true if values array contains value
	boolean contains(String s) {
		for (int i = 0; i < order-1; i++) 
			if (values[i] != null && values[i].compareTo(s) == 0) return true;
		return false;
	}
	
	//returns values and links of first half of node
	BNode lvalues() {
		BNode lvalues = new BNode();
		for (int i = 0; i < order/2-1; i++) {
			lvalues.values[i] = values[i];
			lvalues.links[i] = links[i];
		}
		lvalues.links[order/2-1] = links[order/2-1];
		return lvalues;
	}
	

	//inserts value into values array
	boolean insert(String s) {
		if (contains(s)) return false;
		for (int i = 0; i < order-1; i++) {
			if (values[i] == null || s.compareTo(values[i]) < 0) {
				for (int j = order-2; j > i; j--)
					values[j] = values[j - 1];
				values[i] = s;
				count++;
				return true;
			}
		}
		return false;
	}

	//inserts array of values into values array
			void insert(String[] s) {
				for (int i = 0; i < order - 1; i++)
					if (s[i] != null) insert(s[i]);
			}

			boolean rid(String s) {
				if (!contains(s)) return false;
	    	for (int i = 0; i < order-1; i++)
	      	if (s.equals(values[i])) { //find index of s
	     			for (int j = i; j < order-2; j++)
	       			values[j] = values[j+1]; //remove s from values
						values[order-2] = null;
						break;
					}
				count--;
	      return true;
	    }

			String[] rid(String[] s) {
				for (int i = 0; i < order-1; i++)
					rid(s[i]);
				return s;
			}
		
			void merge(BNode n, BNode parent) {
				for (int i = 0; i < order; i++)
					if (parent.links[i] == this) {
						send(parent.values[i]); //send separator to node
						for (int j = i; j < order-1; j++) { //remove separator and right node from parent
							if (j > i) parent.links[j] = parent.links[j+1];
							if (j < order-2) parent.values[j] = parent.values[j+1];
						}
						break;
					}
				parent.values[order-2] = null;
				parent.links[order-1] = null;
				send(n.values); //send siblings values to node
				link(n.links); //send siblings children to node
			}
			
			//version of insert for sending values between nodes
			void send(String s) {
				if (contains(s)) return;
				for (int i = 0; i < order-1; i++) {
					if (values[i] == null || s.compareTo(values[i]) < 0) {
						for (int j = order-2; j > i; j--)
							values[j] = values[j - 1];
						values[i] = s;
						return;
					}
				}
			}

			void send(String[] s) {
				for (int i = 0; i < order - 1; i++)
					if (s[i] != null) send(s[i]);
			}
			
			//inserts node into parent's links array
			void link(BNode n) {
				for (int i = 0; i < order-1; i++)
					if (values[i] == null || n.values[0].compareTo(values[i]) < 0) {
						if (links[i] == null || links[i].contains(n.values[0])) {
								links[i] = n;
								return;
						}
						for (int j = order - 1; j > i; j--)
							links[j] = links[j-1];
						links[i] = n;
						return;
					} else if (values[order-2] != null && n.values[0].compareTo(values[order-2]) > 0) {
						links[order-1] = n;
						return;
					}
			}

			void link (BNode[] n) {
				for (int i = 0; i < order; i++)
					if (n[i] != null) link(n[i]);
			}
	

			//splits root into three nodes, root retains middle value, lower values go to links[0], higher values go to links[1]
			void splitRoot() {
				BNode temp = new BNode();
				temp.values[0] = root.values[order/2-1];
				temp.links[0] = root.lvalues();
				root = temp;
			}
			
			
}
