#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
#include "Matrix.h"
using namespace std;

Matrix::Matrix()
{
	for (int i = 0; i < MATRIX_SIZE; i++)
	{
		for (int j = 0; j < MATRIX_SIZE; j++)
		{
			matrix[i][j] = rand() % 21 - 10;
		}
	}
	srand(static_cast<unsigned int>(time(NULL)));

}

Matrix::Matrix(int dummy) {}

void Matrix::print() const
{
	for (int i = 0; i < MATRIX_SIZE; i++)
	{
		cout << "| ";
		for (int j = 0; j < MATRIX_SIZE; j++)
		{
			cout << setw(4) << matrix[i][j] << " ";
		}
		cout << "|" << endl;
	}
	cout << endl;
}

const Matrix Matrix::add(const Matrix& mat2) const
{
	Matrix newMat(0);

	for (int i = 0; i < MATRIX_SIZE; i++)
	{
		for (int j = 0; j < MATRIX_SIZE; j++)
		{
			newMat.matrix[i][j] = matrix[i][j] + mat2.matrix[i][j];
		}
	}

	return newMat;
}

const Matrix Matrix::multi(const Matrix& mat2) const
{
	Matrix newMat(0);

	for (int i = 0; i < MATRIX_SIZE; i++)
	{
		for (int j = 0, sum = 0; j < MATRIX_SIZE; j++, sum = 0)
		{
			for (int k = 0; k < MATRIX_SIZE; k++)
			{
				sum += matrix[i][k] * mat2.matrix[k][j];
			}
			newMat.matrix[i][j] = sum;
		}
	}

	return newMat;
}
