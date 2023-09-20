#include <iostream>
#include <string>
using namespace std;

int main()
{
	cout << " 문장입력 : ";
	string str;
	getline(cin, str);
	
	const int SIZE = 'z' - 'a' + 1;
	int counter[SIZE] = {};

	for (int i = 0; i < str.length(); i++)
		if(isalpha(str[i]))
			counter[tolower(str[i]) - 'a']++;

	for (int i = 0; i < SIZE; i++)
		if (counter[i] > 0)
			cout << "[" << (char)('a' + i) << "]" << counter[i] << " ";

	return 0;
}