package test;

public class Node {
	private int value;
	private Node left;
	private Node right;
	private int level;
	private Node parent ;
	public Node(int value,int level, Node parent) {
		this.value = value;
		this.level = level;
		this.parent = parent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public boolean isLeaf() {
		return (this.getLeft() == null) && (this.getRight() == null); 
	}
	
	public void setLevel (int level) {
		this.level = level;
	}
	
	public int getlevel() {
		return this.level;
	}
	
	public int cantChilds() {
		if(this.isLeaf()) {
			return 0;
		}else if (this.getRight() != null && this.getLeft() != null) {
			return 2;
		}
		
		return 1;
	}
	public Node getMoreLeft() {
		if(this.getLeft() == null) {
			return this;
		}
		
		return this.getMoreLeftHelper(this);
	}
	
	private Node getMoreLeftHelper(Node n) {
		if(n.getLeft() == null) {
			return n;
		}
		return getMoreLeftHelper(n.getLeft());
	}
	
	public void remove () {
		
		if (parent.getLeft() == null) {
			this.parent.setRight(null);
			
		}else if(parent.getRight() == null) {
			this.parent.setLeft(null);
		}else {
			if(parent.getLeft().getValue() == this.value) {
				parent.setLeft(null);
			}else {
				parent.setRight(null);
			}
		}
	}
	
	public Node getParent() {
		return this.parent;
	}
}