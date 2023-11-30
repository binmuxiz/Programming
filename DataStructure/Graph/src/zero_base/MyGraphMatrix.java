package zero_base;

// 인접 행렬을 이용한 그래프 구현
public class MyGraphMatrix {
    char[] vertices;
    int[][] adjacentMatrix;
    int elementCnt;

    public MyGraphMatrix() {}

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjacentMatrix = new int[size][size];
        this.elementCnt = 0;
    }

    public boolean isFull() {
        return this.elementCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }
        vertices[elementCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjacentMatrix[x][y] = 1;
        this.adjacentMatrix[y][x] = 1;
    }

    public void addDirectedEdge(int x, int y) {
        this.adjacentMatrix[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        this.adjacentMatrix[x][y] = 0;
        this.adjacentMatrix[y][x] = 0;
    }

    public void deleteDirectedEdge(int x, int y) {
        this.adjacentMatrix[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();
        for (int i = 0; i < elementCnt; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < elementCnt; j++) {
                System.out.print(adjacentMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        MyGraphMatrix m = new MyGraphMatrix(4);
        m.addVertex('A');
        m.addVertex('B');
        m.addVertex('C');
        m.addVertex('D');

        m.addVertex('E');

        m.addEdge(0, 1);
        m.addEdge(0, 2);
        m.addEdge(1, 2);
        m.addEdge(1, 3);
        m.addEdge(2, 3);

        m.printAdjacentMatrix();

    }
}
