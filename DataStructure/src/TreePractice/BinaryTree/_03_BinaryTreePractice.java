package TreePractice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 트리 구조 복습, 구현
 */
public class _03_BinaryTreePractice {
    public static void main(String[] args) {
        //Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("==Root Node==");
        System.out.println(bt.head.data);


        System.out.println("==B's Child Node==");
        Node B = bt.searchNode('B');
        if (B.left != null) {
            System.out.println("B's left child : " + B.left.data);
        }
        if (B.right != null) {
            System.out.println("B's right child : " + B.right.data);
        }


        System.out.println("==F's Parent Node==");
        Node F = bt.searchNode('F');
        if (F.parent != null) {
            System.out.println("F's parent : " + F.parent.data);
        }


        System.out.println("==Leaf Node==");
        postOrder(bt.head);
        System.out.println();


        System.out.println("==E's Depth==");
        Node E = bt.searchNode('E');
        Node cur = E;
        int cnt = 0; // 간선의 개수
        while (cur.parent != null) {
            cur = cur.parent;
            cnt++;
        }
        System.out.println("E depth : " + cnt);


        System.out.println("==Level2 Node==");
        for (int i = 0; i < arr.length; i++) {
            Node target = bt.searchNode((char) ('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }
            if (cnt == 2) {
                System.out.print(target.data + " ");
            }
        }
        System.out.println();


        System.out.println("==Height==");
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node target = bt.searchNode((char) ('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println("Height : " + maxCnt);

        System.out.println("==B's Size==");
        int size = bt.checkSize('B');
        System.out.println("B size = " + size);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
    }

    static class BinaryTree {
        Node head;

        public BinaryTree(char[] arr) {
            Node[] nodes = new Node[arr.length];

            for (int i = 0; i < arr.length; i++) {
                nodes[i] = new Node(arr[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                int left = i * 2 + 1;
                int right = left + 1;

                if (left < arr.length) {
                    nodes[i].left = nodes[left];
                    nodes[left].parent = nodes[i];
                }
                if (right < arr.length) {
                    nodes[i].right = nodes[right];
                    nodes[right].parent = nodes[i];
                }
            }
            this.head = nodes[0];
        }

        Node searchNode(char data) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                if (cur.data == data) {
                    return cur;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            return null;
        }

        Integer checkSize(char data) {
            Node node = this.searchNode(data);

            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            int size = 0;

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    size++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    size++;
                }
            }
            return ++size;
        }
    }

    static class Node {
        char data;
        Node left;
        Node right;
        Node parent;

        public Node(char data, Node left, Node right, Node parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(char data) {
            this.data = data;
        }
    }
}
