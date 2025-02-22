#include "Fraction.h"

using namespace std;

int main()
{
	Fraction f1(3, 5), f2(2, 5), f3;

	f1.print();
	f2.print();
	
	f3 = f1.add(f2);
	f3.print();

	f3 = f1.subtract(f2);
	f3.print();

	f3 = f1.multiply(f2);
	f3.print();

	f3 = f1.divide(f2);
	f3.print();

	return 0;
}