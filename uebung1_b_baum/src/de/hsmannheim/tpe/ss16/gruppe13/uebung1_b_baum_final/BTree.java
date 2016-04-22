package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

public interface BTree {
	
	public boolean insert(String filename);
	
	public boolean contains(Integer o);
	
	public int size();
	
	public int height();
	
	public Integer getMax();
	
	public Integer getMin();
	
	public boolean isEmpty();
	
	public void addAll(BTree otherTree);
	
	public void printInorder();
	
	public void printPostorder();
	
	public void printPreorder();
	
	public void printLevelorder();

	boolean insert(Comparable newKey);
}
