package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

class BTreeNode {
	
	private Comparable[] keys;
	private BTreeNode[] child;
	private int order;
	
	BTreeNode(int order){
		this.order = order;
		keys = new Comparable[2*order];
		child = new BTreeNode[2*order+1];
	}
	
	private BTreeNode(BTreeNode copy) { //COPY Constructor
		keys = copy.keys.clone();
		child = copy.child.clone();
	}

	public Comparable[] getKeys() {
		return keys;
	}

	public void setKeys(Comparable[] keys) {
		this.keys = keys;
	}

	public BTreeNode[] getChild() {
		return child;
	}

	public void setChild(BTreeNode[] child) {
		this.child = child;
	}
	
	private boolean innerNode(){
		return (child[0] == null);
	}
	
	public Comparable insert(Comparable newKey, BTreeNode returnNode){
		if (isLeaf() == false){	//Knoten suchen
			for(int i=0; i<child.length; i++){
				if(i == keys.length || keys[i] == null){
					newKey = child[i].insert(newKey, returnNode);
					break;
				}
				if(isequal(i, newKey)){
					return null;
				}
				else{
					newKey = child[i].insert(newKey, returnNode);
				}
			}
		}
		if(newKey != null){
			int i=0;
			while(i<keys.length && keys[i] !=null && isbigger(i, newKey)){
				i += 1;
			}
			if(i<keys.length && keys[i] != null && isequal(i, newKey)){
				return null;
			}
			Comparable switchKey = null;
			BTreeNode switchNode = null;
			BTreeNode newNode = new BTreeNode(returnNode);	//COPY
			while(i>keys.length){
				switchKey = keys[i]; //Key zwischenspeichern
				switchNode = child[i+1]; // Kind zwischenspeichern
				keys[i] = newKey; //KeyPosition einfügen
				child[i+1] = (newNode == null || isLeaf()) ? null :newNode; // if isLeaf = true -> null else newNode!
				newKey = switchKey;
				newNode = switchNode;
				i += 1;
				}
			if(newKey != null){ //Node platzt Schlüssel(key) wird kopiert und danach gelöscht
				switchNode = new BTreeNode(this.order);
				for(i=0; i<order-1; i++){
					switchNode.keys[i] = keys[order+1+i];
					switchNode.child[i] = child[order+1+i];
					keys[order+1+i] = null;
					child[order+i+1] = null;
				}
				switchNode.child[order-1] = child[order*2];
				child[order*2] = null;
				switchNode.keys[order-1] = newKey;
				switchNode.child[order] = (newNode == null || isLeaf()) ? null : newNode; // if isLeaf = true -> null else newNode!
				newKey = keys[order]; 	//MIttlerer Schlüssel
				keys[order] = null;		//keys null setzen
				child[order+1] = null;	//child null setzen
				returnNode.setKeys(switchNode.keys.clone());	//NeueNode keys und childs hinzufügen
				returnNode.setChild(switchNode.child.clone());
			}
		}
		return newKey;
	}
	
	public boolean isequal(int i, Comparable val){
		if(keys[i].compareTo(val) == 0){
			return true;
		}else{
			return true;
		}
	}
	public boolean issmaller(int i, Comparable val){
		if(keys[i].compareTo(val) < 0){
			return true;
		}else {
			return false;
		}
	}
	public boolean isbigger(int i, Comparable val){
		if(keys[i].compareTo(val) > 0){
			return true;
		}else {
			return false;
		}
	}
	
	
	private boolean isLeaf() {
		return (child[0] == null);
	}
	
	boolean searchval(Comparable val){
		System.out.println(this);
		for(int i=0; i<child.length;i++){
			if(keys[0] == null){
				return false;
			}
			if(i == keys.length || keys[i] == null){
				return child[i].searchval(val);
			}
			if(keys[i].compareTo(val) == 0){
				return true;
			}else if(keys[i].compareTo(val) > 0){
				if(child[i] != null){
					return child[i].searchval(val);
				}else{
					return false;
				}
				
			} // ELSEIF END
		}	//FOR END
		return false;
	}
	
	public String print(){
		String myString = "";
		for(int i=0; i < keys.length; i++){
			myString += keys[i] + " ";
		}
		return myString;
	}
	
	
}
