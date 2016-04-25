package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

public class BTreeImpl implements BTree{

//	private final static int STANDARD_ORDNUNG = 3;
	public int order;
	private BTreeNode root;

	/**
	 * Constructor <code>BTreeImpl(int ordnung)</code>
	 * creates a BTree with a ordnung
	 * @param int ordnung
	 */
	public BTreeImpl(int ordnung) {
		this.order = ordnung;
		this.root = new BTreeNode(order);
	}
	
	
	/* Method <code>void setOrdnung(int ordnung)</code> 
	 * sets BTree's Ordnung if invalid ordnung (<= 0)
	 * is given STANDARD_ORDNUNG is set */
//	private void setOrdnung(int ordnung) {
//		if (ordnung <= 0) {
//			this.ordnung = STANDARD_ORDNUNG;
//		} else {
//			this.ordnung = ordnung;
//		}
//	}
	
	@Override
	public boolean insert(Comparable newKey){
		BTreeNode returnNode = new BTreeNode(order);
		Comparable newElement = root.insert(newKey, returnNode);
		if(newElement != null){
			BTreeNode newRoot = new BTreeNode(order);
			newRoot.getKeys()[0] = newElement;
			newRoot.getChild()[0] = root;
			newRoot.getChild()[1] = returnNode;
			root = newRoot;
			return true;
		}
		return false;
	}
	
	/** Method <code>int getOrdnung ()</code> returns
	 * BTree's Ordnung
	 * @return int BTree's Ordnung
	 */
//	int getOrdnung() {
//		return this.ordnung;
//	}
	
	@Override
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Integer val) {
		return root.searchval(val);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		int o = (int) Math.log(order); // H�he ist logarithmisch in	der	Anzahl	der	gespeicherten Schl�ssel	beschr�nkt.	
		return o;
	}

	@Override
	public Integer getMax() {
//		System.out.println("Das Maximum der Knoten ist: " + 2 * ordnung);
		return 2*order;
	}

	@Override
	public Integer getMin() {
//		System.out.println("Das Minimum der Knoten ist:" + ordnung);
//		System.out.println("Das Minimum der Knoten ist min 1");
		return order;
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
		if(root.getKeys()[0] == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String print() {
		String sketch = "BTree:\n------\n";
		return (sketch + root.print(0));
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
		//printPostorder(this.root);
	}

	public void printPostorder(BTreeNode node) {
//		if(node != null){
//			for(int i=0; i < node.getRef().length; i++){
//				if(node.getRef()[i] != null){
//					printPostorder(node.getRef()[i]);
//				}
//			}
//			for(int i=0; i<node.getValue().length;i++){
//				if(node.getValue()[i] != null){
//					print(node.getValue()[i] + "  ");
//				}
//			}
//		}
	}
	
	
	@Override
	public void printPreorder() {
		// printPreorder(this.root);
	}
	
	public void printPreorder(BTreeNode node) {
//		if(node != null){
//			for(int i=0; i<node.getValue().length;i++){
//				if(node.getValue()[i] != null){
//					print(node.getValue()[i] + "  ");
//				}
//			}
//			for(int i=0; i < node.getRef().length; i++){
//				if(node.getRef()[i] != null){
//					printPostorder(node.getRef()[i]);
//				}
//			}
//		}
	}

	@Override
	public void printLevelorder() {
		// TODO Auto-generated method stub
		
	}
}
