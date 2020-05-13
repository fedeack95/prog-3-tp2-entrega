package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Abb {
	private Node root;

	public Abb() {

	}

	public Node getRoot() {
		return this.root;
	}
	/**
	 * O(n) donde n es la produndidad de la rama de la izquierda + la profundidad de la rama de la derecha 
	 * En el peor de los casos 
	 */
	public int getHeight() {
		if (this.root == null) {
			return 0;
		}

		return this.getHeightHelper(this.root);
	}

	private int getHeightHelper(Node current) {
		if (current.isLeaf()) {
			return 0;
		} else {
			int leftHeight = 0;
			int rightHeight = 0;
			Node childLefth = current.getLeft();
			Node childRight = current.getRight();
			if (childLefth != null) {
				leftHeight = this.getHeightHelper(childLefth);
			}

			if (childRight != null) {
				rightHeight = this.getHeightHelper(childRight);
			}

			int currentHeight = (Math.max(leftHeight, rightHeight) + 1);
			return currentHeight;
		}

	}

	/**
	 * Complejidad o(n) n es la cantidad de nodos por los que pasa para encontrarse en el arbol
	 *  En el peor de los casos recorre la altura del arbol para encontrar el nodo 
	 * nivel del arbol.
	 */
	public boolean hasElement(int value) {
		if (this.root == null) {
			return false;
		}
		boolean valueIsEquals = (this.root.getValue() == value);

		if (valueIsEquals) {
			return valueIsEquals;
		}
		return this.hasElementHelper(this.root, value);
	}

	private boolean hasElementHelper(Node current, int value) {
		boolean valueIsEquals = (current.getValue() == value);
		boolean valueIsLess = (current.getValue() > value);
		if (valueIsEquals) {
			return valueIsEquals;
		}

		if (valueIsLess) {
			if (current.getLeft() != null) {
				valueIsEquals = this.hasElementHelper(current.getLeft(), value);
			}
			} else {
				if (current.getRight() != null) {
					valueIsEquals = this.hasElementHelper(current.getRight(), value);
				}
			}
		
		return valueIsEquals;

	}
	/**
	 * O(1) es tiempo constante no requiere ningun
	 * tipo de iteracion
	 */
	public boolean isEmpty() {
		return this.root == null;
	}

	/**
	 * Complejidad o(n) Donde n es la cantidad de nodos por lo que pasa hasta encontrar su ubicacion
	 *  En el peor de los casos tiene que recorrer todo el arbol para insertar el nodo .
	 */
	public void add(int value) {
		if (this.root == null) {
			this.root = new Node(value, 1, this.root);
		} else {
			this.addHelper(this.root, value);
		}

	}

	private void addHelper(Node current, int value) {
		if (current.getValue() > value) {
			this.addleft(current, value);
		} else {
			this.addRight(current, value);
		}

	}

	private void addleft(Node current, int value) {

		if (current.getLeft() == null) {
			Node newNode = new Node(value, current.getlevel() + 1, current);
			current.setLeft(newNode);
		} else {
			this.addHelper(current.getLeft(), value);
		}
	}

	private void addRight(Node current, int value) {
		if (current.getRight() == null) {
			Node newNode = new Node(value, current.getlevel() + 1, current);
			current.setRight(newNode);
		} else {
			this.addHelper(current.getRight(), value);
		}
	}

	/**
	 * o(n) Recorre todo los elementos del arbol
	 */
	public void printPostOrder() {
		this.printPostOrderHelper(this.root);
	}

	private void printPostOrderHelper(Node current) {
		if (current == null) {
			System.out.print("- ");
		} else {
			this.printPostOrderHelper(current.getLeft());
			this.printPostOrderHelper(current.getRight());
			System.out.print(current.getValue() + " ");

		}
	}

	/**
	 * o(n) Recorre todo los elementos del arbol
	 */
	public void printPreOrder() {
		this.prinPreOrderHelper(this.root);
	}

	private void prinPreOrderHelper(Node current) {
		if (current == null) {
			System.out.print("- ");
		} else {
			System.out.print(current.getValue() + " ");
			this.prinPreOrderHelper(current.getLeft());
			this.prinPreOrderHelper(current.getRight());
		}

	}

	/**
	 * o(n) Recorre todo los elementos del arbol
	 */
	public void printInOrder() {
		this.printInOrderHelper(this.root);
	}

	private void printInOrderHelper(Node current) {
		if (current == null) {
			System.out.print("- ");
		} else {
			this.printInOrderHelper(current.getLeft());
			System.out.print(current.getValue() + " ");
			this.printInOrderHelper(current.getRight());
		}
	}
	/**
	 * O(n) n es la cantidad de elementos del arbol
	 * 
	 * 
	 * @return
	 */
	public List<Integer> getLongestBranch() {
		if (this.root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> output = this.getLongestBranchHelper(this.root);
		Collections.reverse(output);
		return output;
	}
	
	private List<Integer> getLongestBranchHelper(Node current) {
		if (current.isLeaf()) {
			List<Integer> output = new ArrayList<Integer>();
			output.add(current.getValue());
			return output;
		} else {
			List<Integer> branchLongestLeft = new ArrayList<Integer>();
			List<Integer> branchLongestRight = new ArrayList<Integer>();
			Node childLeft = current.getLeft();
			Node childRight = current.getRight();
			if (childLeft != null) {
				branchLongestLeft.addAll(this.getLongestBranchHelper(childLeft));
			}

			if (childRight != null) {
				branchLongestRight.addAll(this.getLongestBranchHelper(childRight));
			}

			if (branchLongestLeft.size() > branchLongestRight.size()) {
				branchLongestLeft.add(current.getValue());
				return branchLongestLeft;
			} else {
				branchLongestRight.add(current.getValue());
				return branchLongestRight;
			}

		}

	}

	/**
	 * O(n) tiene que recorrer todo el arbol para agregar sus ojas al output
	 */
	public List<Integer> getFrontera() {

		return new ArrayList<Integer>(this.getFronteraHelper(this.root));
	}

	private List<Integer> getFronteraHelper(Node current) {
		List<Integer> output = new ArrayList<Integer>();
		if (current.isLeaf()) {
			output.add(current.getValue());
		} else {
			if (current.getLeft() != null) {
				output.addAll(this.getFronteraHelper(current.getLeft()));
			}
			if (current.getRight() != null) {
				output.addAll(this.getFronteraHelper(current.getRight()));
			}
		}
		return output;
	}

	/**
	 * o(n) Recorre a la de derecha hasta encontrar un null.
	 * En el peor de los cosas el arbol es una enredadera con todos sus nodos hacia la derecha
	 * 
	 * @return
	 */
	public int getMaxElement() {
		if (this.root == null) {
			return 0;
		}

		return this.getMaxElementHelper(this.root);
	}

	private int getMaxElementHelper(Node current) {
		if (current.getRight() == null) {
			return current.getValue();
		} else {
			return this.getMaxElementHelper(current.getRight());
		}
	}

	/**
	 * o(n) Recorre el arbol solo hasta el nivel ingresado.
	 * En el peor de los casos el nivel ingresado es igual a la altura del arbol
	 */

	public List<Integer> getElementsAtlevel(int level) {
		return new ArrayList<Integer>(this.getElementsAtLevelHelper(this.root, level));
	}

	private List<Integer> getElementsAtLevelHelper(Node current, int level) {
		List<Integer> output = new ArrayList<Integer>();

		if (current.getlevel() == level) {
			output.add(current.getValue());
		} else {
			if (current.getLeft() != null) {
				output.addAll(this.getElementsAtLevelHelper(current.getLeft(), level));
			}
			if (current.getRight() != null) {
				output.addAll(this.getElementsAtLevelHelper(current.getRight(), level));
			}
		}
		return output;

	}
	/**
	 * O(n) En el peor de los casos el nodo a eliminar tiene 2 hijos y hay que buscar el mas izquiero de su derecha
	 * @return
	 */
	public boolean delete(int value) {

		if (this.root.getValue() == value) {
			if (this.root.isLeaf()) {
				this.root = null;
				return true;
			} else {
				this.deleteHelper(this.root, value);
			}

		}
		return this.deleteHelper(this.root, value);
	}

	public boolean deleteHelper(Node current, int value) {
		boolean valueIsEquals = (current.getValue() == value);
		boolean valueIsLess = (current.getValue() > value);
		boolean isDelete = false;
		if (valueIsEquals) {
			if (current.isLeaf()) {
				current.remove();
				return true;
			} else {
				int cantChilds = current.cantChilds();
				if (cantChilds == 1) {
					if (current.getLeft() != null) {
						current.getParent().setRight(current.getLeft());
						return true;
					} else {
						current.getParent().setRight(current.getRight());
						return true;
					}
				} else {
					Node moreLess = current.getRight().getMoreLeft();
					if(current.getParent() == null) {
						moreLess.setLeft(current.getLeft());
						moreLess.getParent().setLeft(null);
						moreLess.setRight(current.getRight());
						this.root = moreLess;
						return true;
						
					}
					if (current.getParent().getLeft().getValue() == current.getValue()) {
						moreLess.setLeft(current.getLeft());
						current.getParent().setLeft(moreLess);

					} else {
						moreLess.setLeft(current.getLeft());
						current.getParent().setRight(moreLess);
					}
					return true;
				}
			}
		}

		if (valueIsLess) {
			if (current != null && current.getLeft() != null)
				isDelete = this.deleteHelper(current.getLeft(), value);
		} else {
			if (current != null && current.getRight() != null)
				isDelete = this.deleteHelper(current.getRight(), value);
		}

		return isDelete;
	}
	
	public void autoGenerate(int cantNodes, int to, int from) {
		if (to > from) {
			System.out.println("El segundo parametro debe ser menor que el tercero. ");
			System.out.println("Ingrese nuevamente para generar el arbol");
		} else {
			for (int i = 0; i < cantNodes; i++) {
				int randomValue = (int) Math.floor(Math.random() * (from - to + 1) + to);
				if (i == 0) {
					System.out.println(randomValue);
					this.add(randomValue);
				} else {
					while (this.hasElement(randomValue)) {
						randomValue = (int) Math.floor(Math.random() * (from - to + 1) + to);
					}
					System.out.println(randomValue);
					this.add(randomValue);
				}
			}
		}

	}
}