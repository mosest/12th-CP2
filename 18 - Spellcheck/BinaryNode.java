//Tara Moses
//BinaryNode Class for Assignment 18: Spellcheck
//December 18, 2013

public class BinaryNode {
	BinaryNode left;
	BinaryNode right;
	String contents;
	
	public BinaryNode(String str, BinaryNode l, BinaryNode r) {
		left=l;
		right=r;
		contents=str;
	}
	
	//getters
	public String getContents() {
		return contents;
	}
	
	public BinaryNode getLeft() {
		return left;
	}
	
	public BinaryNode getRight() {
		return right;
	}
	
	//setters	
	public void setContents(String value) {
		contents=value;
	}
	
	public void setLeft(BinaryNode newNode) {
		left=newNode;
	}
	
	public void setRight(BinaryNode newNode) {
		right=newNode;
	}
}
