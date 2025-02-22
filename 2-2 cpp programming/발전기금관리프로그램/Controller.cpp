#include "Controller.h"

Controller::Controller()
{
	list = new MyList<Person, string>();
}

bool Controller::handler()
{
	cout << endl 
		<< "[1] 전체 조회 / "
		<< "[2] 신규 기탁자 등록 / "
		<< "[3] 기탁정보 변경 / "
		<< "[4] 기탁자 삭제 / "
		<< "[5] 종료 : ";

	int menu;
	cin >> menu;
	cin.ignore();

	if (menu == 1)
		list->retrieveAll();

	else if (menu == 2)
	{
		string input;
		cout << "신규 기탁자 정보를 입력하세요 : ";
		getline(cin, input);

		Person* p = registerDepositor(input);
		if (p != nullptr)
		{
			cout << "<신규> ";
			p->print();
		}
		else
			cout << "!!! 잘못된 입력입니다 !!!";
		cout << endl;
	}

	else if (menu == 3)
	{
		string key;
		int val;

		cout << "변경을 원하는 사번이나 학번 또는 전화번호(XXX-XXXX-XXXX)를 입력하세요. : ";
		getline(cin, key);
		cout << "추가 기탁액을 입력하세요. : ";
		cin >> val;

		Person* p = list->modify(key, val);
		cout << "<변경> ";
		p->print();
		cout << endl;
	}

	else if (menu == 4)
	{
		string key;
		cout << "삭제를 원하는 사번이나 학번 또는 전화번호(xxx-xxxx-xxxx)를 입력하세요 : ";
		getline(cin, key);

		Person* p = list->remove(key);
		cout << "<삭제> ";
		p->print();
		delete p;
		cout << endl;
	}
	else if (menu == 5)
	{
		return false;
	}
	return true;
}

Person* Controller::registerDepositor(string& line)
{
	istringstream ss(line);
	string stringBuffer;
	vector<string> x;
	while (ss >> stringBuffer)
		x.push_back(stringBuffer);

	if (x.size() == 0)
		return nullptr;
	
	Person* newPerson = nullptr;
	if (x[0].compare("학생") == 0 && x.size() == 6)
		newPerson = new Student(x[1], x[2], x[3], x[4], stoi(x[5]));
	else if (x[0].compare("교직원") == 0 && x.size() == 7)
		newPerson = new Staff(x[1], x[2], x[3], x[4], x[5], stoi(x[6]));
	else if (x[0].compare("일반") == 0 && x.size() == 4)
		newPerson = new GeneralPublic(x[1], x[2], stoi(x[3]));
	else if (x[0].compare("일반") == 0 && x.size() == 5)
		newPerson = new GeneralPublic(x[1], x[2], x[3], stoi(x[4]));

	if (newPerson != nullptr)
	{
		list->add(newPerson);
		return newPerson;
	}
	return nullptr;
}

bool Controller::wantToSave() const
{
	cout << "변경 사항을 testcase1에 저장하려면 W/w, testcase1을 이전 상태로 유지하려면 C/c : ";
	char ch;
	while (true)
	{
		cin >> ch;
		if (ch == 'w' || ch == 'W')
		{
			cout << ">>> 변경 사항 저장 후 종료 <<<" << endl;
			return true;
		}
		else if (ch == 'c' || ch == 'C')
		{
			cout << ">>> 변경 사항 저장하지 않고 종료 <<<" << endl;
			return false;
		}
		else
			cout << "다시 입력 : ";
	}
	return false;
}

void Controller::saveFile(string& filename) const
{
	if (!wantToSave())
	{
		delete list;
		return;
	}

	ofstream ofs(filename);
	if (!ofs.is_open()) {
		throw CouldNotOpenFile();
	}

	string str = list->toString();
	ofs.write(str.c_str(), str.size());
	ofs.close();
	delete list;
}

void Controller::readFile(string& filename)
{
	ifstream ifs(filename);
	if (!ifs.is_open()) {
		throw CouldNotOpenFile();
	}

	string line;
	while (!ifs.eof())
	{
		getline(ifs, line);
		registerDepositor(line);
	}
	ifs.close();
	list->retrieveAll();
}
