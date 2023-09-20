#include "GeneralPublic.h"

static int code = 0;

GeneralPublic::GeneralPublic(string name, string phone, int deposit)
	: Person(name, phone, deposit) 
{
	setID(++code);
}

GeneralPublic::GeneralPublic(string id, string name, string phone, int deposit)
	: Person(name, phone, deposit)
{
	cout << "일반인 생성" << endl;
	id.erase(0, 1);
	int int_id = stoi(id);
	setID(int_id);
	if (code < int_id)
		code = int_id;
}

GeneralPublic::~GeneralPublic() {
	cout << "일반인 삭제 " << endl;
}

void GeneralPublic::print() const
{
	cout << "[ 일반 ] " << getName() << "(기탁자코드:" << depositorID << ") "
		<< getPhone() << " " << getDeposit() << endl;
}

string GeneralPublic::toString() const
{
	return "일반 " + getID() + " " + getName() + " "
		+ getPhone() + " " + to_string(getDeposit()) + "\n";
}

void GeneralPublic::setID(int id)
{
	depositorID = "V";
	if (to_string(id).length() > 5)
	{
		depositorID += to_string(id);
		return;
	}
	for (unsigned int i = 0; i < 5 - to_string(id).length(); i++) 
		depositorID += '0';
	depositorID += to_string(id);
}

string GeneralPublic::getID() const
{
	return depositorID;
}