#include <iostream>
#include <cstdlib>
#include "Fraction.h"

using namespace std;

Fraction::Fraction() : numerator(1), denominator(1) {};

Fraction::Fraction(int top, int bottom) 
{
	if (bottom == 0)
	{
		cout << "Cannot divide by zero. change the value to 1" << endl;
		bottom = 1;
	}
		
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

	// 분모/분자 중 하나가 음수면 분자를 음수로
	if (bottom < 0)
		numerator = -top;
	else
		numerator = top;

	denominator = abs(bottom);
}

const Fraction Fraction::add(const Fraction& another) const
{
	int top = (numerator * another.denominator) + (denominator * another.numerator);
	int bottom = denominator * another.denominator;

	return Fraction(top, bottom);
}

const Fraction Fraction::subtract(const Fraction& another) const
{
	int top = (numerator * another.denominator) - (denominator * another.numerator);
	int bottom = denominator * another.denominator;

	return Fraction(top, bottom);
}

const Fraction Fraction::multiply(const Fraction& another) const
{
	int top = numerator * another.numerator;
	int bottom = denominator * another.denominator;

	return Fraction(top, bottom);
}

const Fraction Fraction::divide(const Fraction& another) const
{
	int top = numerator * another.denominator;
	int bottom = denominator * another.numerator;

	return Fraction(top, bottom);
}

void Fraction::print() const
{
	cout << numerator << " / " << denominator << endl;
}