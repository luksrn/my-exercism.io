package com.github.luksrn.algoritmo.rbtree;

public class Node<T extends Comparable<T>> {
	
	enum Color {
		RED, BLACK;
	}
	
	protected Color color = Color.BLACK;

	protected Node<T> parent;
	
	protected Node<T> left;
	
	protected Node<T> right;
	
	protected T data;
	
	public Node() {
	}
	
	public Node(T z) {
		data = z;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
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
