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

public class BTNode {

	private int data;
	private BTNode parent;
	private BTNode left;
	private BTNode right;
	
	public BTNode() {
		this(0, null);
	}

	public BTNode(int data) {
		this(data, null);
	}

	public BTNode(int data, BTNode parent) {
		this.data = data;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BTNode getParent() {
		return parent;
	}

	public void setParent(BTNode parent) {
		this.parent = parent;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
		left.setParent(this);
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
		right.setParent(this);
	}

	public boolean hasLeftChild() {
		return left != null;
	}

	public boolean hasRightChild() {
		return right != null;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		//TODO
		return getRight() == null && getLeft() == null;
	}

	public int getDegree() {
		int count = 0;
		if(hasLeftChild()){
			count++;
		}
		if(hasRightChild()){
			count++;
		}
		return count;
	}

	public int getLevel() {
		//TODO
		if (this.getParent() == null) {
            return 0;
        }
        return 1 + this.getParent().getLevel();
	}

	public int getHeight() {
		if (right == null && left == null){
			return 0;
		}
		int leftnode;
		if (this.getLeft() == null){
			leftnode = 0;
		} else {
			leftnode = this.getLeft().getHeight();
		}
		int rightnode;
		if (this.getRight() == null){
			rightnode = 0;
		} else {
			rightnode = this.getRight().getHeight();
		}

		return 1 + Math.max(leftnode, rightnode);
	}

	@Override
	public String toString() {
		return "data: " + data
				+ ", parent: " + (parent != null ? parent.getData() : "null")
				+ ", left: " + (left != null ? left.getData() : "null")
				+ ", right: " + (right != null ? right.getData() : "null")
				+ ", isRoot(): " + isRoot()
				+ ", isLeaf(): " + isLeaf()
				+ ", getDegree(): " + getDegree()
				+ ", getLevel(): " + getLevel()
				+ ", getHeight(): " + getHeight();
	}

}
