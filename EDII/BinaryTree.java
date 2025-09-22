//
// Árvore Binária - Exemplo de implementação em Java
// Copyright (C) 2023 André Kishimoto e Jean Marcos Laine (code changed in 2025)
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.
//

package EDII;

// imports para a fila que pode ser usada na levelOrderTraversalHelper(). 

public class BinaryTree {

	private BTNode root;

	public BinaryTree() {
		this(null);
	}

	
	public BTNode getRoot() {
		return root;
	}

	public void isComplete(){
		
	}

	public boolean isFull(){
		return true;		
	}

	public boolean isFullHelper(BTNode node){
		if(node.getDegree()==0){
			return true;
		} else if (node.getDegree()==2){
			return true;
		} else {
			return false;
		}
	}

	public void setRoot(BTNode root) {
		this.root = root;
	}

	public BinaryTree(BTNode root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int getDegree() {
		return getDegreeHelper(root);
	}

	private int getDegreeHelper(BTNode node) {
		//TODO
		if (node == null){
			return 0;
		}
		int currentDegree = 0;
		if(node.getLeft()!=null){
			currentDegree++;
		}
		if(node.getRight()!=null){
			currentDegree++;
		}
		int leftDegree = getDegreeHelper(node.getLeft());
    	int rightDegree = getDegreeHelper(node.getRight());

		return Math.max(currentDegree, Math.max(leftDegree, rightDegree));
	}

	public int getHeight() {
		if (isEmpty()) {
			return -1;
		}

		return root.getHeight();
	}

	public String inOrderTraversal() {
		return inOrderTraversalHelper(root);
	}

	private String inOrderTraversalHelper(BTNode node) {
		if (node == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		
		sb.append(postOrderTraversalHelper(node.getLeft()));
		sb.append(node.getData() + " ");
		sb.append(postOrderTraversalHelper(node.getRight()));
		return sb.toString();
	}

	public String preOrderTraversal() {
		return preOrderTraversalHelper(root);
	}

	private String preOrderTraversalHelper(BTNode node) {
		//TODO
		if (node == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		
		sb.append(node.getData() + " ");
		sb.append(postOrderTraversalHelper(node.getLeft()));
		sb.append(postOrderTraversalHelper(node.getRight()));
		return sb.toString();
	}

	public String postOrderTraversal() {
		return postOrderTraversalHelper(root);
	}

	private String postOrderTraversalHelper(BTNode node) {
		if (node == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		
		sb.append(postOrderTraversalHelper(node.getLeft()));
		sb.append(postOrderTraversalHelper(node.getRight()));
		sb.append(node.getData() + " ");
		
		return sb.toString();
	}

	/* public String levelOrderTraversal() {
		return levelOrderTraversalHelper(root);
	} */
	
	/* private String levelOrderTraversalHelper(BTNode node) {
		//TODO
	} */

	@Override
	public String toString() {
		return "BinaryTree - isEmpty(): " + isEmpty()
				+ ", getDegree(): " + getDegree()
				+ ", getHeight(): " + getHeight()
				+ ", root => { " + root + " }";				
	}



}
