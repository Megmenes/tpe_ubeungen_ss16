package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum;


class BTreeNode {
	private int ordnung;
	private Comparable[] keys = new Comparable[2*ordnung];
	private BTreeNode[] child = new BTreeNode[2*ordnung+1];
	boolean isLeaf = false; //ist es ein Blatt oder Knoten
		
	private boolean search(Comparable val) {
		System.out.println(this);
		for (int i = 0; i < child.length; i++) {
			if (keys[0] == null) {
				return false;
			}
			if (i == keys.length || keys[i] == null)
				return child[i].search(val);
			int cmp = keys[i].compareTo(val);
			if (cmp == 0)
				return true;
			else if (cmp > 0 && child[i] != null)
				return child[i].search(val);
			else if (cmp > 0 && isLeaf())
				return false;
		}
		return false;
	}

	private boolean isLeaf() {
		return (child[0] == null);
	}
}
