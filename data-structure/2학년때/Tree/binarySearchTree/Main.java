package binarySearchTree;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		BinarySearchTree <String> bst = null;
		
		while(true)
		{
			System.out.print("���ڿ����� �Է��ϼ��� (�������� quit) : ");
			String str = sc.nextLine();
			
			if(str.equals("quit"))
			{
				System.out.println("�����մϴ�.");
				break;
			}
			tree(str, bst);
		}
		sc.close();
	}
	
	public static void tree(String str, BinarySearchTree<String> bst)
	{
		str.trim();
		String [] names = str.split(" ");
		
		bst = new BinarySearchTree<> (names[0]);
		
		for(int i = 1; i < names.length; i++) 
		{
			bst.put(names[i]);
		}
		
		bst.printTree();
	}
}
