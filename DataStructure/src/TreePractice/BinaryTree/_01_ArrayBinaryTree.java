package TreePractice.BinaryTree;

/**
 * 배열을 이용한 이진 트리 구성, 순회 4종류
 */

public class _01_ArrayBinaryTree {
    public static void main(String[] args) {

        //Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("==Pre-Order==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("==In-Order==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("Post-Order==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("==Level-Order==");
        bt.levelOrder(0);
        System.out.println();

    }

    static class BinaryTree {
        char[] arr;

        BinaryTree(char[] arr) {
            this.arr = arr.clone();
        }

        void preOrder(int idx) {
            System.out.print(this.arr[idx] + " ");

            int left = idx * 2 + 1;
            int right = left + 1;

            if (left < this.arr.length) {
                this.preOrder(left);
            }
            if (right < this.arr.length) {
                this.preOrder(right);
            }
        }

        void inOrder(int idx) {

            int left = idx * 2 + 1;
            int right = left + 1;

            if (left < this.arr.length) {
                this.inOrder(left);
            }

            System.out.print(this.arr[idx] + " ");

            if (right < this.arr.length) {
                this.inOrder(right);
            }
        }

        void postOrder(int idx) {
            int left = idx * 2 + 1;
            int right = left + 1;

            if (left < this.arr.length) {
                this.postOrder(left);
            }

            if (right < this.arr.length) {
                this.postOrder(right);
            }

            System.out.print(this.arr[idx] + " ");
        }

        void levelOrder(int idx) {
            for (int i = idx; i < this.arr.length; i++) {
                System.out.print(this.arr[i] + " ");
            }
        }
    }
}
