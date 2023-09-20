#include "Date.h"
#include <cctype>

void IOhandler(Date & date);
void manageMenu(const string& input, Date& date);
void moveDate(const string& input, Date& date);
bool isNumber(const string& str);

int main()
{
	Date date;
	IOhandler(date);

	return 0;
}

void IOhandler(Date & date) 
{
	string input;
	do
	{
		cout << date;
		cout << "��¥ �̵��� ����� �Ǵ� +(������) �Ǵ� -(����), D-day ����� +/-��¥, ����� Q : ";
		getline(cin, input);
		input.erase(remove(input.begin(), input.end(), ' '), input.end());

		if (input == "Q") return;
		manageMenu(input, date);

	} while (true);
	


}

void manageMenu(const string &input, Date& date)
{
	string subStr;

	if (input == "-")
		--date;

	else if (input == "+")
		++date;

	else if (isNumber(subStr = input.substr(1, input.length())) && input[0] == '-')
		date.setMyDday(-stoi(subStr));

	else if (isNumber(subStr) && input[0] == '+')
	{
		if (stoi(subStr) == 0)
			cout << "+0���� ����� �� �����ϴ�.";
		date.setMyDday(stoi(subStr));
	}

	else if (isNumber(input))
		moveDate(input, date);

	else
		cout << "������ �Է� ���¸� Ȯ���� �ּ���." << endl;
}

void moveDate(const string &input, Date& date)
{
	int date_length = 8;
	if (input.length() != date_length)
	{
		cout << "�߸��� ��¥ �Է��Դϴ�." << endl;
		return;
	}

	int inputDate = stoi(input);
	int year = inputDate / 10000;
	int month = (inputDate % 10000) / 100;
	int day = inputDate % 100;
	date.setDate(year, month, day);
}

bool isNumber(const string &str)
{
	for (char ch : str)
		if (!isdigit(ch))
			return false;
	return true;
}
