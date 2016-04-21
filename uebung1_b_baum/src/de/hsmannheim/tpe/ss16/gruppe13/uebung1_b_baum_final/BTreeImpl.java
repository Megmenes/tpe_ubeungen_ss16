package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class BTreeImpl implements BTree{
	private static int M = 4;
	
	private BTreeNode root; 	//root
	private int order; 			//Höhe
	private int numberkeys; 	//KEY-VALUE Pairs in BTree

	class BTreeNode {
		private int m;                             // number of children
	    private Reference[] child = new Reference[M];   // the array of children

	    // create a node with k children
	    private BTreeNode(int k) {
	        m = k;
	    }

	}
	
	private static class Reference {
	    private Comparable key;
	    private Object val;
	    private BTreeNode next;     // helper field to iterate over array entries
	    
	    public Reference(Comparable key, Object val, BTreeNode next) {
	        this.key  = key;
	        this.val  = val;
	        this.next = next;
	    }
	}
	
	
	/**
	 * Constructor <code>BTreeImpl(int ordnung)</code>
	 * creates a BTree with a ordnung
	 * @param int ordnung
	 */
	public BTreeImpl() {
		root = new BTreeNode(0);
	}
	
	@Override
	public boolean insert(Comparable key, Value val) {
        BTreeNode newNode = insertinto(root, key, val, order); 
        numberkeys++;
        if (newNode == null){
        	return false;
        }

        //split
        BTreeNode newObj = new BTreeNode(2);
        newObj.child[0] = new Reference(root.child[0].key, null, root);
        newObj.child[1] = new Reference(newNode.child[0].key, null, newNode);
        root = newObj;
        order++;
		return true;
    }
	
	public BTreeNode insertinto(BTreeNode node, Comparable key, Value val, int order) {
		int i;
		Reference t = new Reference(key, val, null);
		if(order == 0){
			for (i=0; i<node.m; i++) {
				if (key.compareTo(node.child[i].key) < 0)
					break;
			}
		}else{
			for (i=0; i<node.m; i++) {
				if((i+1 == node.m || key.compareTo(node.child[i+1].key) < 0)){
					BTreeNode newNode = insertinto(node.child[i++].next, key, val, order-1);
					if(newNode == null){
						return null;
					}
					t.key = newNode.child[0].key;
					t.next = newNode;
					break;
				}
			}
		}
		
		for (int j=0; i<node.m; i++) {
			node.child[j] = node.child[j-1];
		}
		node.child[i] = t;
		node.m += 1;
		if (node.m < M){
			return null;
		}else{
			return split(node);
		}
		
	}

	
	private BTreeNode split(BTreeNode node) {
		BTreeNode splitNode = new BTreeNode(M/2);
		node.m = M/2;
		for (int i=0; i< node.m; i++) {
			splitNode.child[i] = node.child[node.m+i];
		}
		return splitNode;
	}

	
	public Value find(BTreeNode node, Comparable key, int order){
		Reference[] child = node.child;
		if (order == 0) {
			for (int i=0; i<node.m; i++) {
				if (key.compareTo(child[i].key) == 0) {
					return (Value) child[i].val;
				}
			}
		} else {
			for (int i=0; i<node.m; i++) {
				if (i+1 == node.m || key.compareTo(child[i+1].key) < 0) {
					return find(child[i].next, key, order-1);
				}
			}
		}
		return null;
	}

	@Override
	public boolean contains(Integer o) {
//		for (int i=0; i<x.m; i++) { 
//			if(find(child[i].next, key, order-1) != o){
//				return false;
//			}
//		}
		return false;
	}
	
	
	public Value getElement(Comparable key){
		return find(root, key, order);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberkeys;
	}

	@Override
	public int height() {
		//Math.log(getOrdnung()); // Hï¿½he ist logarithmisch in	der	Anzahl	der	gespeicherten Schlï¿½ssel	beschrï¿½nkt.	
		return order;
	}

	@Override
	public Integer getMax() {
//		System.out.println("Das Maximum der Knoten ist: " + 2 * ordnung);
		return null;
	}

	@Override
	public Integer getMin() {
//		System.out.println("Das Minimum der Knoten ist:" + ordnung);
//		System.out.println("Das Minimum der Knoten ist min 1");
		return null;
	}

	/**
	 * Method <code>boolean isEmpty()</code> returns a
	 * boolean value depending on if the BTree
	 * contains NodeElements or not.
	 * @return boolean true no NodeElements contained/
	 * false if NodeElements contained
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void addAll(BTree otherTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printInorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printPostorder() {
		printPostorder(this.root);
	}

	public void printPostorder(BTreeNode node) {
		if(node != null){
			for(int i=0; i < node.getReference().length; i++){
				if(node.getReference()[i] != null){
					printPostorder(node.getReference()[i]);
				}
			}
			for(int i=0; i<node.getElement().length;i++){
				if(node.getElement()[i] != null){
					print(node.getElement()[i] + "  ");
				}
			}
		}
	}
	
	
	@Override
	public void printPreorder() {
		printPreorder(this.root);
	}
	
	public void printPreorder(BTreeNode node) {
		if(node != null){
			for(int i=0; i<node.getElement().length;i++){
				if(node.getElement()[i] != null){
					print(node.getElement()[i] + "  ");
				}
			}
			for(int i=0; i < node.getReference().length; i++){
				if(node.getReference()[i] != null){
					printPostorder(node.getReference()[i]);
				}
			}
		}
	}

	@Override
	public void printLevelorder() {
		// TODO Auto-generated method stub
		
	}

}
