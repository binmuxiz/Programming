#include "Student.h"

Student::Student(string id, string name, string department, string phone, int deposit)
	: Person(name, phone, deposit), studentID(id), department(department) {}

Student::~Student() {}

void Student::print() const
{
	cout << "[ 학생 ] " << getName() << "(학번:" << getID() << ", 학과:"
		<< getDepartment() << ") " << getPhone() << " " << getDeposit() << endl;
}

string Student::toString() const
{
	return "학생 " + getID() + " " + getName() + " " + getDepartment() + " "
		+ getPhone() + " " + to_string(getDeposit()) + "\n";
}

void Student::setID(string id)
{
	studentID = id;
}

void Student::setDepartment(string department)
{
	this->department = department;
}


string Student::getID() const
{
	return studentID;
}

string Student::getDepartment() const
{
	return department;
}