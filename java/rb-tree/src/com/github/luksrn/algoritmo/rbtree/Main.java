package com.github.luksrn.algoritmo.rbtree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		if( args.length != 1) {
			System.err.println("USO: RBTree dicionario.txt");
			return;
		}
		RBTree<String> rbtree = new RBTree<>();
		carregarArvoreRBTree(rbtree, args[0]);
		checkRBTree(rbtree);
	}


	private static void carregarArvoreRBTree(RBTree<String> rbtree, String arquivo) {
		try {
			List<String> lines = Files.readAllLines(new File(arquivo).toPath());
			for (String line : lines ) {
				String[] tokens = line.split(" ");
				String palavra = tokens[0];
				String comando = tokens[1];
				if( comando.equals("1") ) {
					if( rbtree.search(palavra).data != null) {
						System.out.println("Palavra " + palavra + " já foi adicionado na árvore.");
						continue;
					}
					rbtree.insert(palavra);
				} else if(comando.equals("0")) {
					rbtree.delete(palavra);
					//checkRBTree(rbtree);
				}
				checkRBTree(rbtree);
			}
		} catch (IOException  e) {
			throw new RuntimeException("Falha ao carregar árvore RBTree. " + e.getMessage() , e);
		}
	}
	

	private static void checkRBTree(RBTree<String> rbtree) {
		System.out.println("=== Checking ===");
		rbtree.rbPrint();
		rbtree.rbCheck();
	}
}
