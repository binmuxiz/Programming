#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int randValue();

int main()
{
	int num = randValue();
	int input, cnt = 0;

	cout << "���� 100������ �ڿ��� �ϳ��� �����ϰ� �ֽ��ϴ�.\n";

	while (true)
	{
		cout << "\n���ڸ� �����ؼ� �Է��ϼ���. : ";
		cin >> input;
		cnt++;

		if (num < input)
		{
			cout << "���� �����ϰ� �ִ� ���ڴ� " << input << "���� ���� �����Դϴ�.\n";
		}

		else if (num > input)
		{
			cout << "���� �����ϰ� �ִ� ���ڴ� " << input << "���� ū �����Դϴ�.\n";
		}

		else
		{
			cout << "������ϴ�!!!" << cnt << "���� �����ϼ̳׿�!\n";
			break;
		}
	}
	return 0;

}

int randValue()
{
	srand(static_cast<unsigned int>(time(NULL)));
	int randVal = rand() % 100 + 1;

	return randVal;
}