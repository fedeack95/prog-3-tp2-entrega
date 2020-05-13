package test;

public class main {

	public static void main(String[] args) {
		Abb abb = new Abb();
		
		//add
		abb.add(10);
		abb.add(4);
		abb.add(1);
		abb.add(6);
		abb.add(5);
		abb.add(7);
		abb.add(25);
		abb.add(15);
		abb.add(12);
		abb.add(20);
		abb.add(50);
		abb.add(30);
		abb.add(26);
		abb.add(100);
		
		abb.printPreOrder();
		abb.delete(10);
		abb.delete(26);
		abb.delete(6);
		abb.delete(50);
		System.out.println();
		abb.printPreOrder();
/*		//print In order
		abb.printInOrder();
		
		//print pre order
		abb.printPreOrder();
		
		//print post order
		abb.printPostOrder();*/
		
		//has element
	/*	System.out.println(abb.hasElement(9));
		System.out.println(abb.hasElement(89));*/
		//abb.printInOrder();
		//delete
		/*abb.delete(19);
		abb.delete(82);*/
	/*	System.out.println();
		abb.printInOrder();
		
		
		//frontera
		abb.getFrontera();
		
		//nodos en nivel
		abb.getElementsAtlevel(1);
		
		//traer mayor
		abb.getMaxElement();
		
		//altura
		System.out.println();*/
		//System.out.println(abb.getHeight());
		//System.out.println(abb.getLongestBranch().toString());
		
	/*	//autogenerate
		abb.autoGenerate(15, 1, 40);
		System.out.println();
		System.out.println(); */
	//	abb.printInOrder();
		
		
	}

}
