#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int times = 9;
	int num = 9;
	int format = 3;

	for (int k = 1; k < times; k += format)
	{
		for (int i = 1; i <= num; i++)
		{
			for (int j = k; j <= k + (format - 1); j++)
			{
				cout << setw(5) << j << " x " << i << " = " << setw(5) << i * j;
			}
			cout << endl;
		}
		cout << endl;
	}
		
	return 0;
}
