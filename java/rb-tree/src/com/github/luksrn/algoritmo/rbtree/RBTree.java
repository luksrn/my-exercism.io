package com.github.luksrn.algoritmo.rbtree;

import com.github.luksrn.algoritmo.rbtree.RBElement.Color;

public class RBTree <T extends Comparable<T>> {

	private RBElement<T> root;
	
	private RBElement<T> nil;
	
	{
		nil = new RBElement<T>();
		nil.setColor(Color.BLACK);
		root = nil;
	}
	
	private boolean isNil(RBElement<T> node) {
		return node == null || nil == node;
	}
	public void insert(T z) {
		insert(new RBElement<T>(z));
	}
	
	public void insert(RBElement<T> z) {
		RBElement<T> y = nil;
		RBElement<T> x = root;
		
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
		z.color = RBElement.Color.RED;
		z.parent = y;
		z.left = nil;
		z.right = nil;
		rbInsertFixup(z);
	}
	private void rbInsertFixup(RBElement<T> z) {
		
		while ( z.parent.color == Color.RED ) {
			if( z.parent == z.parent.parent.left ) {
				RBElement<T> y = z.parent.parent.right;
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
				RBElement<T> y = z.parent.parent.left;
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
	
	private void leftRotate(RBElement<T> x) {
		RBElement<T> y = x.right;
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
	
	private void rightRotate(RBElement<T> x) {
		RBElement<T> y = x.left;
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
	
	public boolean delete(T key) {
		RBElement<T> node = search(key);
		if(isNil(node)) {
			return false;
		}
		delete(node);
		return true;
	}
	
	
	public void delete(RBElement<T> z) {
		RBElement<T> x = null;
		RBElement<T> y = z;
		Color originalColor = z.color;
		if(isNil(z.left)) {
			x = z.right;
			transplant(z, z.right);
		} else if(isNil(z.right)){
			x = z.left;
			transplant(z, z.left);
		} else {
			y = treeMinimum(z.right);
			originalColor = y.color;
			x = y.right;
			if( y.parent == z ) {
				x.parent = y;
			} else {
				transplant(z, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
			
		if(originalColor.equals(Color.BLACK)) {
			rbDeleteFixup(x);
		}
	}
	
	private void rbDeleteFixup(RBElement<T> x) {
		while( !isNil(root) && x.color.equals(Color.BLACK)) {
			if( x == x.parent.left ) {
				RBElement<T> w = x.parent.right;
				if(w.color.equals(Color.RED)) {
					w.color = Color.BLACK;
					x.parent.color = Color.RED;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				if(w.left.color.equals(Color.BLACK) && w.right.color.equals(Color.BLACK)) {
					w.color = Color.RED;
					x = x.parent;
				} else {
					if (w.right.color.equals(Color.BLACK)) {
						w.left.color = Color.BLACK;
						w.color = Color.RED;
						rightRotate(w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = Color.BLACK;
					w.right.color = Color.BLACK;
					leftRotate(x.parent);
					x = root;
				}
			} else if ( x == x.parent.right ) {
				RBElement<T> w = x.parent.left;
				if(w.color.equals(Color.RED)) {
					w.color = Color.BLACK;
					x.parent.color = Color.RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if(w.right.color.equals(Color.BLACK) && w.left.color.equals(Color.BLACK)) {
					w.color = Color.RED;
					x = x.parent;
				} else {
					if (w.left.color.equals(Color.BLACK)) {
						w.right.color = Color.BLACK;
						w.color = Color.RED;
						leftRotate(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = Color.BLACK;
					w.left.color = Color.BLACK;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = Color.BLACK;
	}
	
	private void transplant(RBElement<T> u, RBElement<T> v) {
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
	
	public RBElement<T> treeMinimum() {
		return treeMinimum(root);
	}
	
	
	private RBElement<T> treeMinimum(RBElement<T> r) {
		if(isNil(r) || isNil(r.left)) {
			return r;
		}
		return treeMinimum(r.left);
	}
	public void rbPrint() {
		printInOrder(root);
	}
	private void printInOrder(RBElement<T> node) {
		if(!isNil(node)) {
			printInOrder(node.left);
			System.out.println(" " + node.data.toString() + " ");
			printInOrder(node.right);
		}
	}
	
	public void rbCheck() {
		printRbCheck(root);
	}
	private void printRbCheck(RBElement<T> root) {
		if(!isNil(root)) {
			System.out.println("(" + root.parent + ", " + root.data.toString() + ", " + root.color + ", " + root.left+ ", " + root.right + ")");
			printRbCheck(root.left);
			printRbCheck(root.right);
		}
	}
	
	public RBElement<T> search(T key){
		return search(root,key);
	}
	private RBElement<T> search(RBElement<T> root, T key) {
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
