#include "Staff.h"

Staff::Staff(string staffID, string name, string department, string phone, string extentionNum, int deposit)
	: Person(name, phone, deposit), staffID(staffID), department(department), extentionNum(extentionNum) {}

Staff::~Staff() {}

void Staff::print() const
{
	cout << "[교직원] " << getName() << "(사번:" << getID() << ", 부서:"
		<< getDepartment() << "(x" << getExtentionNum() << ")) " << getPhone() << " " << getDeposit() << endl;
}

string Staff::toString() const
{
	return "교직원 " + getID() + " " + getName() + " " + getDepartment() + " "
		+ getPhone() + " " + getExtentionNum() + " " + to_string(getDeposit()) + "\n";
}

void Staff::setID(string id)
{
	staffID = id;
}

void Staff::setDepartment(string department)
{
	this->department = department;
}

void Staff::setExtentionNum(string extentionNum)
{
	this->extentionNum = extentionNum;
}

string Staff::getID() const
{
	return staffID;
}

string Staff::getDepartment() const
{
	return department;
}

string Staff::getExtentionNum() const
{
	return extentionNum;
}