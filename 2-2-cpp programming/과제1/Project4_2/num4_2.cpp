#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int times, num, format;

	cout << "��ܱ��� ����ұ��? : ";
	cin >> times;
	cout << "����� ���ұ�� ? : ";
	cin >> num;
	cout << "���ٿ� ��ܾ� ����ұ�� ? : ";
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
