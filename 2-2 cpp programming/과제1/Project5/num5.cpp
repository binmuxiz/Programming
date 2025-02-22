#include <iostream>
using namespace std;

bool isPerfectNum(int num);

int main()
{
	int input;
	cout << "ют╥б : ";
	cin >> input;

	for (int num = 1; num <= input; num++)
	{
		if (isPerfectNum(num))
		{
			cout << num << "(";

			for (int i = 1; i <= num / 2; i++)
			{
				if ((num % i) == 0)
				{
					cout << i;
					if (i < (num / 2))
						cout << "+";
				}
			}

			cout << ")" << endl;
		}
	}
	return 0;
}

bool isPerfectNum(int num)
{
	int temp = 0;
	for (int i = 1; i <= num / 2; i++)  
	{
		if ((num % i) == 0)
			temp += i;
	}
	if (temp == num)
		return true;

	return false;
}