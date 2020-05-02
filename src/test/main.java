package test;

public class main {

	public static void main(String[] args) {
		Abb abb = new Abb();
		
		//add
		abb.add(10);
		abb.add(5);
		abb.add(8);
		abb.add(15);
		abb.add(20);
		abb.add(6);
		abb.add(7);
		abb.add(9);
		abb.add(25);
		abb.add(21);
		
		//print In order
		abb.printInOrder();
		
		//print pre order
		abb.printPreOrder();
		
		//print post order
		abb.printPostOrder();
		
		//has element
		System.out.println(abb.hasElement(9));
		System.out.println(abb.hasElement(89));
		
		//delete
		abb.delete(9);
		abb.delete(82);
		
		
		//frontera
		abb.getFrontera();
		
		//nodos en nivel
		abb.getElementsAtlevel(1);
		
		//traer mayor
		abb.getMaxElement();
		
		
		//altura
		abb.getHeight();
		
		
		//rama mas larga
		abb.getLongestBranch();
		
		
		
		
		
		
		
		
		
		
		
		//autogenerate
		abb.autoGenerate(15, 1, 40);
		System.out.println();
		abb.printInOrder();
		
		
		
		
	}

}
