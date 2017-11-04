package com.github.luksrn.algoritmo.rbtree;

public class Main {

	public static void main(String[] args) {
		
		RBTree<Integer> tree = new RBTree<>();

		tree.insert(100);
		tree.insert(50);
		tree.insert(25);
		tree.insert(259);
		tree.insert(89);
		tree.insert(76);
		
		System.out.println("Minimum = " + tree.treeMinimum());
		
		tree.rbPrint();
		tree.rbCheck();

		System.out.println(tree.search(100));
		System.out.println(tree.search(259));
		System.out.println(tree.search(250));
		
		System.out.println(tree);
	}
}
