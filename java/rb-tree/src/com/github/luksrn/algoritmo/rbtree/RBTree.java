package com.github.luksrn.algoritmo.rbtree;

import com.github.luksrn.algoritmo.rbtree.Node.Color;

public class RBTree <T extends Comparable<T>> {

	private Node<T> root;
	
	private Node<T> nil;
	
	{
		nil = new Node<T>();
		nil.setColor(Color.BLACK);
	}
	
	private boolean isNil(Node<T> node) {
		return node == null || nil == node;
	}
	public void insert(T z) {
		insert(new Node<T>(z));
	}
	
	public void insert(Node<T> z) {
		Node<T> y = nil;
		Node<T> x = root;
		
		while( !isNil(x) ) {
			y = x;
			if ( z.data.compareTo(x.data) < 0 ) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		if( isNil(root)) {
			root = z;
		} else if ( z.data.compareTo(y.data) < 0 ) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.color = Node.Color.RED;
		z.parent = y;
		z.left = nil;
		z.right = nil;
		rbInsertFixup(z);
	}
	private void rbInsertFixup(Node<T> z) {
		
		while ( z.parent.color == Color.RED ) {
			if( z.parent == z.parent.parent.left ) {
				Node<T> y = z.parent.parent.right;
				if( y.color == Color.RED ) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {
					if ( z == z.parent.right ) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					rightRotate(z.parent.parent);
				}
			}
			if( z.parent == z.parent.parent.right ) {
				Node<T> y = z.parent.parent.left;
				if( y.color == Color.RED ) {
					z.parent.color = Color.BLACK;
					y.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					z = z.parent.parent;
				} else {
					if ( z == z.parent.left ) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = Color.BLACK;
					z.parent.parent.color = Color.RED;
					rightRotate(z.parent.parent);
				}
			}
		}
		
		root.color = Color.BLACK;
	}
	
	private void leftRotate(Node<T> x) {
		Node<T> y = x.right;
		x.right = y.left;
		if( !isNil(y.left)) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if(isNil(x.parent)) {
			root = y;
		} else if ( x == x.parent.left ) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}
	
	private void rightRotate(Node<T> x) {
		Node<T> y = x.left;
		x.left = y.right;
		if( !isNil(y.right)) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if(isNil(x.parent)) {
			root = y;
		} else if ( x == x.parent.right ) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}
	
	private void transplant(Node<T> u, Node<T> v) {
		if( isNil(u.parent)) {
			root = v;
		} else if( u == u.parent.left ) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if( !isNil(v)) {
			v.parent = u.parent;
		}
	}
	
	public Node<T> treeMinimum() {
		return treeMinimum(root);
	}
	
	
	private Node<T> treeMinimum(Node<T> r) {
		if(isNil(r) || isNil(r.left)) {
			return r;
		}
		return treeMinimum(r.left);
	}
	public void rbPrint() {
		printInOrder(root);
	}
	private void printInOrder(Node<T> node) {
		if(!isNil(node)) {
			printInOrder(node.left);
			System.out.print(" " + node.data.toString() + " ");
			printInOrder(node.right);
		}
	}
	
	public void rbCheck() {
		printRbCheck(root);
	}
	private void printRbCheck(Node<T> root) {
		if(!isNil(root)) {
			System.out.println("(" + root.parent + ", " + root.data.toString() + ", " + root.color + ", " + root.left+ ", " + root.right + ")");
			printRbCheck(root.left);
			printRbCheck(root.right);
		}
	}
	
	public Node<T> search(T key){
		return search(root,key);
	}
	private Node<T> search(Node<T> root, T key) {
		if(isNil(root) || root.data.compareTo(key) == 0 ) {
			return root;
		}
		if(key.compareTo(root.data) < 0 ) {
			return search(root.left,key);
		} else {
			return search(root.right,key);
		}
	}
}
