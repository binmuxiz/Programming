#include <iostream>
using namespace std;

int main()
{
	while (true)
	{
		double num;
		cout << "부동소수점 값을 입력하세요(0에서 종료) : ";
		cin >> num;

		if (num == 0)
		{
			cout << "종료" << endl;
			break;
		}
		
		cout << "정수부 : " << (int)num << " 소수점부 : " << (num - (int)num) << endl;
	}

	return 0;
}

