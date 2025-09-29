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



// Você deve criar a Árvore abaixo, explicitamente no código main:
//
//     A
//   /   \
//  B     C
//   \   /
//    D E
//       \
//        F
//       / \
//      G   H
//


import EDIII.BBNode;
import EDII.BTNode;
import EDIII.BNode;
import EDII.BinaryTree;
import EDII.BST;

public class Main {

	public static void main(String[] args) {
		// 1. Instanciando uma nova BST
        // 1. Criando os nós da árvore
        System.out.println("--- Criando a Árvore ---");
        BNode a = new BNode(10);
        BNode b = new BNode(5, a);
        BNode c = new BNode(15, a);
        BNode d = new BNode(2, b);
        BNode e = new BNode(8, b);

        // Conectando os nós manualmente
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        
        System.out.println("Árvore criada com sucesso!");

        // 2. Testando os métodos isRoot e isLeaf
        System.out.println("\n--- Testando isRoot e isLeaf ---");
        System.out.println("Nó A (10) é raiz? " + a.isRoot()); // Deve ser true
        System.out.println("Nó B (5) é folha? " + b.isLeaf()); // Deve ser false
        System.out.println("Nó D (2) é folha? " + d.isLeaf()); // Deve ser true

        // 3. Testando o método getDegree
        System.out.println("\n--- Testando getDegree ---");
        System.out.println("Grau do nó A (10): " + a.getDegree()); // Deve ser 2
        System.out.println("Grau do nó B (5): " + b.getDegree()); // Deve ser 2
        System.out.println("Grau do nó C (15): " + c.getDegree()); // Deve ser 0

        // 4. Testando o método getLevel
        System.out.println("\n--- Testando getLevel ---");
        System.out.println("Nível do nó A (10): " + a.getLevel()); // Deve ser 0
        System.out.println("Nível do nó B (5): " + b.getLevel()); // Deve ser 1
        System.out.println("Nível do nó D (2): " + d.getLevel()); // Deve ser 2

        // 5. Testando o método getHeight
        // Nota: A sua implementação de getHeight no BNode está com erros de sintaxe.
        // Se você corrigiu, este teste funcionará.
        System.out.println("\n--- Testando getHeight ---");
        System.out.println("Altura do nó A (10): " + a.getHeight()); // Deve ser 2
        System.out.println("Altura do nó B (5): " + b.getHeight()); // Deve ser 1
        System.out.println("Altura do nó D (2): " + d.getHeight()); // Deve ser 0
        
    



        /* System.out.println("--- Testando Inserção ---");
        System.out.println("Inserindo os seguintes valores: 20, 10, 30, 5, 15, 25, 35, 28");
        
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);
        bst.insert(28); // Este nó tem 25 como pai, útil para testes
        
        System.out.println("Percurso em ordem (deve estar ordenado): " + bst.inOrderTraversal());
        System.out.println("Altura da árvore: " + bst.getHeight());
        System.out.println("Grau da árvore: " + bst.getDegree());
        
        // 2. Testando o método search
        System.out.println("\n--- Testando Busca ---");
        BTNode foundNode = bst.search(bst.getRoot(), 15);
        if (foundNode != null) {
            System.out.println("Nó 15 encontrado. Nível: " + foundNode.getLevel());
        } else {
            System.out.println("Nó 15 não encontrado.");
        }
        
        foundNode = bst.search(bst.getRoot(), 99);
        if (foundNode == null) {
            System.out.println("Nó 99 não encontrado, como esperado.");
        }
        
        // 3. Testando a remoção de nós
        System.out.println("\n--- Testando Remoção ---");
        
        // Caso 1: Remover um nó folha (sem filhos)
        System.out.println("Removendo nó folha (5)...");
        bst.remove(bst.getRoot(), 5);
        System.out.println("Árvore após remoção: " + bst.inOrderTraversal());
        
        // Caso 2: Remover um nó com um filho
        System.out.println("\nRemovendo nó com um filho (15)...");
        bst.remove(bst.getRoot(), 15);
        System.out.println("Árvore após remoção: " + bst.inOrderTraversal());
        
        // Caso 3: Remover um nó com dois filhos
        System.out.println("\nRemovendo nó com dois filhos (10)...");
        bst.remove(bst.getRoot(),10);
        System.out.println("Árvore após remoção: " + bst.inOrderTraversal());
        
        // 4. Testando a limpeza da árvore
        System.out.println("\n--- Testando Limpeza ---");
        bst.clear();
        System.out.println("Árvore limpa. Percurso em ordem: " + bst.inOrderTraversal());


		
		//
		/* // TODO: Continuar com a construção da árvore ****
		//
		
		System.out.println("--------------------");
		
		// Cria um objeto do tipo BinaryTree e define que a raiz da árvore binária é o nó A.
		BinaryTree tree = new BinaryTree(a); 
		
		// Saídas
		System.out.println(tree);
		System.out.println("Pré-ordem: " + tree.preOrderTraversal());
		System.out.println(" Em ordem: " + tree.inOrderTraversal());
		System.out.println("Pós-ordem: " + tree.postOrderTraversal());
		System.out.println("Por nível: " + tree.levelOrderTraversal());
		
		// Confira se a árvore foi construída como solicitado no exemplo e confira se os
		// métodos de percurso estão corretos. */ 
	}

}
