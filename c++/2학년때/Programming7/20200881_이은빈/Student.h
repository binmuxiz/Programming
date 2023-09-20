#pragma once
#include "Person.h"

class Student :
	public Person
{
public:
	Student(string id, string name, string department, string phone, int deposit);
	~Student() override;
	void print() const override;
	string toString() const override;

	void setID(string id);
	void setDepartment(string department);

	string getID() const override;
	string getDepartment() const override;

private:
	string studentID;
	string department;
};