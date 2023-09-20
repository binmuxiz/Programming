#pragma once
#include <iostream>	
using namespace std;

class Fraction
{
public :
	Fraction();
	Fraction(int top, int bottom);
	const Fraction operator +(const Fraction& another) const;
	const Fraction operator -(const Fraction& another) const;
	const Fraction operator *(const Fraction& another) const;
	const Fraction operator /(const Fraction& another) const;
	bool operator <(const Fraction& another) const;
	bool operator >(const Fraction& another) const;
	bool operator ==(const Fraction& another) const;
	friend ostream& operator << (ostream& outputStream, const Fraction& another);
	friend istream& operator >> (istream& inputStream, Fraction& another);

private :
	int numerator;
	int denominator;
};