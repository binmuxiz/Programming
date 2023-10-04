#include <iostream>
#include <string> 
using namespace std;

int main()
{
	string str;
	cout << " 문장입력 : ";
	getline(cin, str);

	int i = 0;
	while (!isalpha(str[i])) 
		cout << str[i++];

	if ('a' <= str[i] && str[i] <= 'z')
		str[i] -= 'a' - 'A';
	cout << str[i++];
	
	while (i < str.length())
	{
		if ('A' <= str[i] && str[i] <= 'Z')
			str[i] += ('a' - 'A');
		cout << str[i++];
	}
	return 0;
}
