#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int times, num, format;

	cout << "몇단까지 출력할까요? : ";
	cin >> times;
	cout << "몇까지 곱할까요 ? : ";
	cin >> num;
	cout << "한줄에 몇단씩 출력할까요 ? : ";
	cin >> format;
	 
	for (int k = 1; k <= times; k += format) 
	{
		for (int i = 1; i <= num; i++)
		{
			for (int j = k; (j <= k + (format - 1)) && (j <= times); j++) {
				cout << setw(5) << j << " x " << setw(2) << i << " = " << setw(5) << i * j;
			}
			cout << endl;
		}
		cout << endl;
	}

	return 0;
}

for ( int j = k; )
