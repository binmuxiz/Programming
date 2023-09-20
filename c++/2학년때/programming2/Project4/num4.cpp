#include <iostream>

using namespace std;

void intToBinary(int num, int count);

int main()
{
	int num;

	while (true)
	{
		cout << "10진수 입력(종료는 0) : ";
		cin >> num;

		if (num == 0)
			break;
		
		intToBinary(num, 0);
		cout << endl;
	}
	cout << "종료";

	return 0;
}

void intToBinary(int num, int count)
{
	count++;   

	if (num / 2 != 0)
		intToBinary(num / 2, count);

	if (count % 4 == 0)
		cout << " ";
	cout << num % 2;
}

