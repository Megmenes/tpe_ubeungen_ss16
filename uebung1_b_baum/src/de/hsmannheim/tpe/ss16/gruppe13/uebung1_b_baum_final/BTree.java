package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

import de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final.BTreeImpl.BTreeNode;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public interface BTree {
	
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

	boolean insert(Comparable key, Value val);

	BTreeNode insertinto(BTreeNode node, Comparable key, Value val, int order);
}
