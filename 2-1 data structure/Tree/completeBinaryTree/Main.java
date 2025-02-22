package completeBinaryTree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("��� ������ �Է��ϼ���. : ");
		BinaryArrayTree tree = new BinaryArrayTree(sc.nextInt());
		
		tree.printTree();
		System.out.println();
		System.out.print("preorder   : ");
		tree.preorder();
		System.out.print("inorder    : ");
		tree.inorder();
		System.out.print("postorder  : ");
		tree.postorder();
		System.out.print("levelorder : ");
		tree.levelorder();
	}

}
