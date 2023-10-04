#include "Controller.h"

Controller::Controller()
{
	list = new MyList<Person, string>();
}

bool Controller::handler()
{
	cout << endl 
		<< "[1] ��ü ��ȸ / "
		<< "[2] �ű� ��Ź�� ��� / "
		<< "[3] ��Ź���� ���� / "
		<< "[4] ��Ź�� ���� / "
		<< "[5] ���� : ";

	int menu;
	cin >> menu;
	cin.ignore();

	if (menu == 1)
		list->retrieveAll();

	else if (menu == 2)
	{
		string input;
		cout << "�ű� ��Ź�� ������ �Է��ϼ��� : ";
		getline(cin, input);

		Person* p = registerDepositor(input);
		if (p != nullptr)
		{
			cout << "<�ű�> ";
			p->print();
		}
		else
			cout << "!!! �߸��� �Է��Դϴ� !!!";
		cout << endl;
	}

	else if (menu == 3)
	{
		string key;
		int val;

		cout << "������ ���ϴ� ����̳� �й� �Ǵ� ��ȭ��ȣ(XXX-XXXX-XXXX)�� �Է��ϼ���. : ";
		getline(cin, key);
		cout << "�߰� ��Ź���� �Է��ϼ���. : ";
		cin >> val;

		Person* p = list->modify(key, val);
		cout << "<����> ";
		p->print();
		cout << endl;
	}

	else if (menu == 4)
	{
		string key;
		cout << "������ ���ϴ� ����̳� �й� �Ǵ� ��ȭ��ȣ(xxx-xxxx-xxxx)�� �Է��ϼ��� : ";
		getline(cin, key);

		Person* p = list->remove(key);
		cout << "<����> ";
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
	if (x[0].compare("�л�") == 0 && x.size() == 6)
		newPerson = new Student(x[1], x[2], x[3], x[4], stoi(x[5]));
	else if (x[0].compare("������") == 0 && x.size() == 7)
		newPerson = new Staff(x[1], x[2], x[3], x[4], x[5], stoi(x[6]));
	else if (x[0].compare("�Ϲ�") == 0 && x.size() == 4)
		newPerson = new GeneralPublic(x[1], x[2], stoi(x[3]));
	else if (x[0].compare("�Ϲ�") == 0 && x.size() == 5)
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
	cout << "���� ������ testcase1�� �����Ϸ��� W/w, testcase1�� ���� ���·� �����Ϸ��� C/c : ";
	char ch;
	while (true)
	{
		cin >> ch;
		if (ch == 'w' || ch == 'W')
		{
			cout << ">>> ���� ���� ���� �� ���� <<<" << endl;
			return true;
		}
		else if (ch == 'c' || ch == 'C')
		{
			cout << ">>> ���� ���� �������� �ʰ� ���� <<<" << endl;
			return false;
		}
		else
			cout << "�ٽ� �Է� : ";
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
