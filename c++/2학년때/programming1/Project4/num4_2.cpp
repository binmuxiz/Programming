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

	int startingNum = 1;
	for (int k = 0; k < ceil((double)times / format); k++)
	{
		for (int i = 1; i <= num; i++) 
		{
			for (int j = startingNum; (j < startingNum + format) && (j <= times); j++) {
				cout << setw(5) << j << " x " << i << " = " << setw(5) << i * j;
			}
			cout << endl;
		}
		startingNum += format;
		cout << endl;
	}

	return 0;
}