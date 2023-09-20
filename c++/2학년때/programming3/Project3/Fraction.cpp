#include "Fraction.h"

Fraction::Fraction() : numerator(1), denominator(1) {};

Fraction::Fraction(int top, int bottom) 
{
	int i = 2;
	while (abs(top) >= i && i <= abs(bottom) && top != 0)
	{
		if (top % i == 0 && bottom % i == 0)
		{
			top /= i;
			bottom /= i;
		}
		else
			i++;
	}

	if (bottom < 0)
			numerator = -top;
	else
		numerator = top;

	denominator = abs(bottom);
}

const Fraction Fraction::operator +(const Fraction& another) const
{
	int top = (numerator * another.denominator) + (denominator * another.numerator);
	int bottom = denominator * another.denominator;

	return Fraction(top, bottom);
}

const Fraction Fraction::operator -(const Fraction& another) const
{
	int top = (numerator * another.denominator) - (denominator * another.numerator);
	int bottom = denominator * another.denominator;

	return Fraction(top, bottom);
}

const Fraction Fraction::operator *(const Fraction& another) const
{
	int top = numerator * another.numerator;
	int bottom = denominator * another.denominator;

	return Fraction(top, bottom);
}

const Fraction Fraction::operator /(const Fraction& another) const
{
	int top = numerator * another.denominator;
	int bottom = denominator * another.numerator;

	return Fraction(top, bottom);
}

bool Fraction::operator <(const Fraction& another) const
{
	if (numerator * another.denominator < denominator * another.numerator)
		return true;
	return false;
}

bool Fraction::operator >(const Fraction& another) const
{
	if (numerator * another.denominator > denominator * another.numerator)
		return true;
	return false;
}

bool Fraction::operator ==(const Fraction& another) const
{
	if (numerator * another.denominator == denominator * another.numerator)
		return true;
	return false;
}

ostream& operator << (ostream& outputStream, const Fraction& fraction)
{
	outputStream << fraction.numerator << "/" << fraction.denominator;

	return outputStream;
}

istream& operator >> (istream& inputStream, Fraction& fraction)
{
	int top, bottom;
	inputStream >> top >> bottom; 

	while (bottom == 0)
	{
		cout << "분모가 0이면 안 됩니다. 재입력하세요." << endl;
		cout << "분자와 분모를 정수로 입력하세요. :" << endl;
		inputStream >> top >> bottom;
	}

	Fraction temp(top, bottom);
	fraction.numerator = temp.numerator;
	fraction.denominator = temp.denominator;
	
	return inputStream;
}
