#include <iostream>
using namespace std;

int main()
{
	while (true) 
	{
		int input;
		cout << "크기(3보다 큰 홀수) : ";
		cin >> input;
		if (input == 0)
		{
			cout << "종료";
			break;
		}		
		if ((input % 2) == 0 || input <= 1)
		{
			cout << "다시 입력해주세요.\n";
			continue;
		}

		for (int i = 1, line = 1; line <= input; line++)
		{
			for (int space = 1; space <= input / 2 - (i - 1); space++)
				cout << " ";
			for (int star = 1; star <= 2 * i - 1; star++)
				cout << "*";
			cout << endl;

			if (i < input / 2 + 1 && line < input / 2 + 1)
				i++;
			else
				i--;
		}
		cout << endl;
	}
	return 0;
}