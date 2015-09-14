//Tara Moses
//Dictionary Class for Assignment 18: Spellcheck
//December 18, 2013

public class Dictionary {
	BinaryNode head;
	
	public Dictionary(BinaryNode head) {
		head=this.head;
	}
	
	public void add(BinaryNode node, String word) {
		if (node.getContents().compareToIgnoreCase(word)<0) {
			if (node.getLeft()==null) {
				node.setLeft(new BinaryNode(word,null,null));
			} else {
				add(node.getLeft(), word);
			}
		} else {
			if (node.getRight()==null) {
				node.setRight(new BinaryNode(word,null,null));
			} else {
				add(node.getRight(), word);
			}
		}
	}
	
	public boolean search(BinaryNode node, String word) {
		if (node==null) {
			return false;
		} else if (node.getContents().equalsIgnoreCase(word)) {
			return true;
		} else if (node.getContents().compareToIgnoreCase(word)<0) {
			return search(node.getLeft(), word);
		} else { 
			return search(node.getRight(), word);
		}
	}
	
	public getLeftmostNode(BinaryNode node) {
		while (node.getLeft()!=null) {
			node=node.getLeft();
		}
		return node;
	}
	
	public replace
	
	public void delete(BinaryNode node, String word) {
		
	}
	
	
}

















