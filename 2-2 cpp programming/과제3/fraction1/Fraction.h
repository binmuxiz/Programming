#pragma once

class Fraction
{
public :
	Fraction();
	Fraction(int top, int bottom);
	const Fraction add(const Fraction& another) const;
	const Fraction subtract(const Fraction& another) const;
	const Fraction multiply(const Fraction& another) const;
	const Fraction divide(const Fraction& another) const;
	void print() const;

private :
	int numerator;
	int denominator;
};