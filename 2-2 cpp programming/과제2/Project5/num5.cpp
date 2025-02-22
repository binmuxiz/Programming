#include <iostream>
using namespace std;

void merge(int arr1[], int arr2[], int mergeArr[]);

const int LENGTH = 5;

int main()
{
	int arr1[LENGTH], arr2[LENGTH], mergeArr[LENGTH * 2];

	cout << "오름차순 정수 5개 입력 : ";
	for (int i = 0; i < LENGTH; i++)
		cin >> arr1[i];

	cout << "오름차순 정수 5개 입력 : ";
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
	
	// 피드백 - 남아있는 요소들을 옮기는 코드에서 현재 제어에는 while을 사용하는 것이 바람직해 보인다.
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

	cout << "합병된 정수 10개 : ";
	for (int i = 0; i < LENGTH * 2; i++)
		cout << mergeArr[i] << " ";

	// 정적 배열의 return 불가능한 이유
	// c++의 정적 배열은 함수 stack안에 고정적인 위치로 잡히기 땜누에
	// int arr[100];  arr = funct(); 와 같은 형태로 작성 불가능
	// arr이 상수로 인식되므로 Ox200 = funct()와 같이 상수값에 무엇을 대입하려는 것처럼
	// 인식되기 때문.
}
