#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{
	while (true)
	{
		int num;
		cout << "정수 값을 입력하세요(0에서 종료) : ";
		cin >> num;

		if (num == 0)
		{
			cout << "종료";
			break;
		}

		for (int i = 10; abs(num) >= 10; ) 
			num /= i;
		
		cout << "제일 큰 자리수  : " << num << endl;
	}
	return 0;
}


