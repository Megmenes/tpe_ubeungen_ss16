package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

public class BTreeDemo {

	public static void main(String[] args) {
		System.out.println("Test");
		BTreeImpl btree = new BTreeImpl(2); //BTree Objekt erzeugen!
		Integer[] insert = {1,5,10,15,2,20,15}; //Vorgegebene Integer zum einf�gen definieren
		for (int i=0;i<insert.length;i++) {	//Solange array nicht zu Ende loope durch
			System.out.println("\nInsert: " + insert[i]);	//Ausgabe von aktuellem insert Wert
			btree.insert(insert[i]);
			System.out.println(btree);
		}
		Integer[] search = {5,3,15,16};
		for (int i=0;i<search.length;i++) {
			System.out.println("Searching for : " + search[i] + " -> " );
			System.out.println(btree.contains(i));
		}
		
	}
}