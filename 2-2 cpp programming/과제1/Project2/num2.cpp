#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{
	while (true)
	{
		int num;
		cout << "���� ���� �Է��ϼ���(0���� ����) : ";
		cin >> num;

		if (num == 0)
		{
			cout << "����";
			break;
		}

		for (int i = 10; abs(num) >= 10; ) 
			num /= i;
		
		cout << "���� ū �ڸ���  : " << num << endl;
	}
	return 0;
}


