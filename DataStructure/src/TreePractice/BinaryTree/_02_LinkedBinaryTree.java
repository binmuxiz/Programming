package TreePractice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 연결 리스트를 이용한 이진 트리 구성, 순회 4종류
 */
public class _02_LinkedBinaryTree {

    public static void main(String[] args) {
        //Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("==Pre-Order==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("==In-Order==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("Post-Order==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("==Level-Order==");
        bt.levelOrder(bt.head);
        System.out.println();
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class BinaryTree {
        Node head;

        BinaryTree() {
        }

        BinaryTree(char[] arr) {
            Node[] nodes = new Node[arr.length];
            for (int i = 0; i < arr.length; i++) {
                nodes[i] = new Node(arr[i], null, null);
            }

            for (int i = 0; i < arr.length; i++) {
                int left = i * 2 + 1;
                int right = left + 1;

                if (left < arr.length) {
                    nodes[i].left = nodes[left];
                }
                if (right < arr.length) {
                    nodes[i].right = nodes[right];
                }
            }
            this.head = nodes[0];
        }

        void preOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }

        void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }

        /**
         * 레벨 순회의 특성 상 재귀구조와 맞지 않음
         * Queue를 이용하여 구현한다.
         */
        void levelOrder(Node node) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }
}
