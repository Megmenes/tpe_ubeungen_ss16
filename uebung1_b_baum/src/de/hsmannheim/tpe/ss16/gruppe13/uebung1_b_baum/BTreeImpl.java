package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum;

public class BTreeImpl implements BTree{

	private final static int STANDARD_ORDNUNG = 3;
	private int ordnung;
	private BTreeNode root;

	/**
	 * Constructor <code>BTreeImpl(int ordnung)</code>
	 * creates a BTree with a ordnung
	 * @param int ordnung
	 */
	public BTreeImpl(int ordnung) {
		setOrdnung(ordnung);
		root = new BTreeNode();
	}
	
	
	/* Method <code>void setOrdnung(int ordnung)</code> 
	 * sets BTree's Ordnung if invalid ordnung (<= 0)
	 * is given STANDARD_ORDNUNG is set */
	private void setOrdnung(int ordnung) {
		if (ordnung <= 0) {
			this.ordnung = STANDARD_ORDNUNG;
		} else {
			this.ordnung = ordnung;
		}
	}
	
	public boolean isavail(Comparable key) {
		return root.search(key);
	}
	
	/** Method <code>int getOrdnung ()</code> returns
	 * BTree's Ordnung
	 * @return int BTree's Ordnung
	 */
	int getOrdnung() {
		return this.ordnung;
	}
	
	@Override
	public boolean insert(Integer o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Integer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		Math.log(ordnung); // H�he ist logarithmisch in	der	Anzahl	der	gespeicherten Schl�ssel	beschr�nkt.	
		return 0;
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
		//if root == null then Tree is empty
		//else the Tree has Nodes and therefore
		//is not empty
		if(root == null) {
			return true;
		} else {
			return false;
		}
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
