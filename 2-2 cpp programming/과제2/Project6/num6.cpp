#include <iostream>
using namespace std;

void matrixAdd(int arr1[][MATRIX_SIZE], int arr2[][MATRIX_SIZE], int addArr[MATRIX_SIZE][MATRIX_SIZE]);
void matrixMulti(int arr1[][MATRIX_SIZE], int arr2[][MATRIX_SIZE], int multiArr[MATRIX_SIZE][MATRIX_SIZE]);

// 적절한 const 사용하기
const int MATRIX_SIZE = 3;

int main()
{
	int arr1[][MATRIX_SIZE] = { {1,2,3}, {4,5,6}, {7,8,9} };
	int arr2[][MATRIX_SIZE] = { { 1,-1,0 }, {0,-1,1}, {-1,1,0} };
	int resultArr[MATRIX_SIZE][MATRIX_SIZE] = {};

	cout << "두 행렬의 합은\n";
	matrixAdd(arr1, arr2, resultArr);
	cout << "두 행렬의 곱은\n";
	matrixMulti(arr1, arr2, resultArr);

	return 0;
}

void matrixAdd(int arr1[][MATRIX_SIZE], int arr2[][MATRIX_SIZE], int addArr[MATRIX_SIZE][MATRIX_SIZE])
{
	for (int i = 0; i < MATRIX_SIZE; i++)
	{
		cout << "| ";
		for (int j = 0; j < MATRIX_SIZE; j++)
		{
			addArr[i][j] = arr1[i][j] + arr2[i][j];
			cout << addArr[i][j] << " ";
		}
		cout << "|" << endl;
	}
}

void matrixMulti(int arr1[][MATRIX_SIZE], int arr2[][MATRIX_SIZE], int multiArr[MATRIX_SIZE][MATRIX_SIZE])
{
	for (int i = 0; i < MATRIX_SIZE; i++)
	{
		cout << "| ";
		for (int temp = 0, j = 0; j < MATRIX_SIZE; j++, temp = 0)
		{
			for (int k = 0; k < MATRIX_SIZE; k++)
				temp += arr1[i][k] * arr2[k][j];

			multiArr[i][j] = temp;
			cout << multiArr[i][j] << " ";
		}
		cout << "|" << endl;
	}
}