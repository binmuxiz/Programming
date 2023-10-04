package project2;

public class BS_Insertion {
	
    private static int search(Comparable[] arr, int left, int right, Comparable x) 
    {

        if (right >= left) 
        {
            int mid = left + ((right - left) / 2);

            //ã�� ��(x)�� �迭�� ��Ұ� ��ġ�ϸ� �迭�� �ε����� ��ȯ�Ѵ�.
            if (arr[mid] == x)
                return mid;
            //ã�� ��(x)���� �迭�� ��Ұ� ũ�ٸ� �迭�� ������ ������ �����Ѵ�.
            if (arr[mid].compareTo(x) > 0)
                return search(arr, left, mid - 1, x);
            //ã�� ��(x)���� �迭�� ��Ұ� �۴ٸ� �迭�� ���� ������ �����Ѵ�.
            return search(arr, mid + 1, right, x);
        }
        //��ġ�ϴ� ���� ���ٸ� �迭�� �� ���� �ε��� ��ȯ
        return left;
    }


    public static void sort(Comparable[] arr) 
    {

        Comparable temp;
        int find_Index, j;//�ӽú���, Ž������� �� ���� ����

        for (int i = 1; i < arr.length; i++) {
            temp = arr[i]; // �ӽ� ������ ��� �迭 ���� �����Ѵ�.
            find_Index = search(arr, 0, i, temp);
            //�ӽú��� ���� �� �ε����� ����Ž���Ѵ�. search() �޼ҵ� ����

            for (j = i - 1; j >= find_Index; j--) {
                arr[j + 1] = arr[j];
            } //���õ� �迭���� �ӽú��� ���� �� �ڸ����� ���������� ��ĭ�� �о��.

            arr[find_Index] = temp; //�ӽú����� ������ ���� ����Ž���� ���� ã�� �ε�����  �����Ѵ�.
        }
    }

}
