package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum;

public class BTreeNodeP {

	private BTreeNodeP[] child;
	private Comparable[] key;
	
	BTreeNodeP(BTreeImpl tree) {
		//create child and key array according to trees order
		child = new BTreeNodeP[(tree.getOrdnung()*2) + 1];
		key = new Comparable[tree.getOrdnung()*2];
	}
	
	BTreeNodeP getChildAt(int index) {
		return this.child[index];
	}
	
	Comparable getKey(int index) {
		return this.key[index];
	}
	
	int getChildrenSize() {
		return child.length;
	}
	
	int getKeySize() {
		return key.length;
	}
	
	void setChildAt(int index, BTreeNodeP child) {
		this.child[index] = child;
	}
	
	void setKeyAt(int index, Comparable val) {
		this.key[index] = val;
	}
	
	boolean isContained(Comparable val) {
		//go through keys and look if the val is contained
		for(int i = 0; i < key.length && key[i] != null; i++) {
			//if val is contained return false
			if(val.compareTo(key[i]) == 0) {
				return true;
			}
		}
		//if val isn't contained return false
		return false;
	}
	
	boolean isLeaf() {
		//if this Node has no children then it has to be a leaf
		return(child[0] == null);
	}
	
	boolean isFull() {
		//if last index of key array is full then the node is filled
		return(key[key.length - 1] != null);
	}
}
