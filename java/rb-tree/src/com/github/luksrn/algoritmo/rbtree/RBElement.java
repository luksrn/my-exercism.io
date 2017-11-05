package com.github.luksrn.algoritmo.rbtree;

public class RBElement<T extends Comparable<T>> {
	
	enum Color {
		RED, BLACK;
	}
	
	protected Color color = Color.BLACK;

	protected RBElement<T> parent;
	
	protected RBElement<T> left;
	
	protected RBElement<T> right;
	
	protected T data;
	
	public RBElement() {
	}
	
	public RBElement(T z) {
		data = z;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public RBElement<T> getParent() {
		return parent;
	}

	public void setParent(RBElement<T> parent) {
		this.parent = parent;
	}

	public RBElement<T> getLeft() {
		return left;
	}

	public void setLeft(RBElement<T> left) {
		this.left = left;
	}

	public RBElement<T> getRight() {
		return right;
	}

	public void setRight(RBElement<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data + "";
	}

}
