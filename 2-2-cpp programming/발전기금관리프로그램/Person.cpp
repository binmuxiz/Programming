#include "Person.h"

Person::Person(string name, string phone, int deposit)
	: name(name), phone(phone), deposit(deposit) {
	cout << "Person 생성" << endl;
}

Person::~Person() {
	cout << "Person 삭제" << endl;
}

void Person::print() const {}

string Person::toString() const
{
	return "";
}

void Person::setDeposit(int deposit)
{
	this->deposit += deposit;
}

string Person::getName() const
{
	return name;
}

string Person::getPhone() const
{
	return phone;
}

int Person::getDeposit() const
{
	return deposit;
}

string Person::getID() const
{
	return "";
}

string Person::getDepartment() const
{
	return "";
}

string Person::getExtentionNum() const
{
	return "";
}

