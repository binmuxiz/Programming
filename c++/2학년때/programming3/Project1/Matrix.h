#pragma once

class Matrix
{
public :
	Matrix();
	Matrix(int dummy);
	void print() const;
	const Matrix add(const Matrix& mat2) const;
	const Matrix multi(const Matrix& mat2) const;
private :
	static const int MATRIX_SIZE = 3;
	int matrix[MATRIX_SIZE][MATRIX_SIZE];
};