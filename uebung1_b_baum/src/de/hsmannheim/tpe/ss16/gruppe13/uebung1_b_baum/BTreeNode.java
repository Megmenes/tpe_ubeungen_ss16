package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum;

class BTreeNode {
	private int ordnung;
	private int countkey = 0;
	private BTreeNode[] parent = null; // Elternknoten
	private Comparable[] keys = new Comparable[2*ordnung];
	private BTreeNode[] child = new BTreeNode[2*ordnung+1];
	boolean isLeaf = false; //ist es ein Blatt oder Knoten
		
	boolean search(Comparable val) {
		System.out.println(this);
		for (int i = 0; i < child.length; i++) {
			if (keys[0] == null) {
				return false;
			}
			if (i == keys.length || keys[i] == null)
				return child[i].search(val);
			int compare = keys[i].compareTo(val);
			if (compare == 0)
				return true;
			else if (compare > 0 && child[i] != null)
				return child[i].search(val);
			else if (compare > 0 && isLeaf())
				return false;
		}
		return false;
	}

	public boolean insertIntoNode(Comparable obj, BTreeNode leftnode, BTreeNode rightnode) {
		boolean fertig = false;
		// Position für Schlüssel suchen
		for (int i = 0; i < keys.length; i++) {
			int res = keys[i].compareTo(obj); // Returns (-int / lessthan), 0/ equal, (+int/greater)
			if (res == 0) {
				// Schlüssel existiert schon -> ignorieren
				fertig = true;
				break;
			}
			else if (res > 0) {
				// Stelle gefunden -> einfügen
				//Each component in this vector with an index greater or equal to the specified 
				//index is shifted upward to have an index one greater than the value it had previously. 
				for(int j=i; j <= keys.length-1; j++){
					keys[i+1] = keys[i];
				}
				keys[i] = obj;
				fertig = true;
				break;
			}
			if (!fertig) {
//				// Schlüssel muss am Ende eingef�gt werden
//				keys[ordnung] = obj;
//				if (leftnode != null && pointers.isEmpty()) {
//					pointers.add(leftnode);
//					leftnode.parent = this;
//				}
//				if (rightnode != null) {
//					pointers.add(rightnode);
//					rightnode.parent = this;
//				}
			}
			// Knoten zu groß?
			return keys.length > ordnung * 2;
		}
	}
//	void insert(Comparable val){
//		if (!isLeaf()) {
//		boolean fertig = false;
//			for (int i = 0; i < child.length; i++) {
//				if (search(val)==false){
//					System.out.println("Die Zahl" + val + " ist schon vorhanden!");
//					fertig = true;
//					break;
//				}
//				int res = keys[i].compareTo(obj); // Returns (-int / lessthan), 0/ equal, (+int/greater)
//						
//					}
//				}
//			}
//		}
//		
//	}
	
	private boolean isLeaf() {
		return (child[0] == null);
	}

	public int getElement() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getReference() {
		// TODO Auto-generated method stub
		return 0;
	}
}
