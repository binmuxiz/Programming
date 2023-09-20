#include <iostream>
#include <string>
using namespace std;

int main()
{
	const int ALPHA_NUM = 26;
	const int KEY = 25;
	string str;

	cout << "���� �Է� : ";
	getline(cin, str);
	cout << "���� ��� : ";

	int key = KEY % ALPHA_NUM;
	char val = 'z' - (key - 1); // a�� ��ü�Ǵ� ��

	for (int i = 0; i < str.length(); i++)
	{
		if (!isalpha(str[i]))
		{
			cout << str[i];
			continue;
		}
		if (tolower(str[i]) < val)
			cout << (char)(str[i] + key);
		else
			cout << (char)(str[i] - (ALPHA_NUM - key));

	}
	return 0;
}