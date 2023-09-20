#include <iostream>
using namespace std;

void merge(int arr1[], int arr2[], int mergeArr[]);

const int LENGTH = 5;

int main()
{
	int arr1[LENGTH], arr2[LENGTH], mergeArr[LENGTH * 2];

	cout << "�������� ���� 5�� �Է� : ";
	for (int i = 0; i < LENGTH; i++)
		cin >> arr1[i];

	cout << "�������� ���� 5�� �Է� : ";
	for (int i = 0; i < LENGTH; i++)
		cin >> arr2[i];

	merge(arr1, arr2, mergeArr);

	return 0;
}

void merge(int arr1[], int arr2[], int mergeArr[])
{
	int arr1Idx = 0, arr2Idx = 0, idx = 0;

	while(arr1Idx != LENGTH && arr2Idx != LENGTH)
	{
		if (arr1[arr1Idx] < arr2[arr2Idx])
			mergeArr[idx] = arr1[arr1Idx++];
			
		else if (arr1[arr1Idx] > arr2[arr2Idx])
			mergeArr[idx] = arr2[arr2Idx++];

		else
		{
			mergeArr[idx] = arr1[arr1Idx++];
			mergeArr[++idx] = arr2[arr2Idx++];
		}
		idx++;
	}
	
	// �ǵ�� - �����ִ� ��ҵ��� �ű�� �ڵ忡�� ���� ����� while�� ����ϴ� ���� �ٶ����� ���δ�.
	if (arr1Idx == LENGTH)
	{
		while(idx < LENGTH * 2)
			mergeArr[idx++] = arr2[arr2Idx++];
	}
	else if(arr2Idx == LENGTH)
	{
		while(idx < LENGTH * 2)
			mergeArr[idx++] = arr1[arr1Idx++];
	}

	cout << "�պ��� ���� 10�� : ";
	for (int i = 0; i < LENGTH * 2; i++)
		cout << mergeArr[i] << " ";

	// ���� �迭�� return �Ұ����� ����
	// c++�� ���� �迭�� �Լ� stack�ȿ� �������� ��ġ�� ������ ������
	// int arr[100];  arr = funct(); �� ���� ���·� �ۼ� �Ұ���
	// arr�� ����� �νĵǹǷ� Ox200 = funct()�� ���� ������� ������ �����Ϸ��� ��ó��
	// �νĵǱ� ����.
}
