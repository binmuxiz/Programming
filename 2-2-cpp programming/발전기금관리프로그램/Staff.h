#pragma once
#include "Person.h"

class Staff :
	public Person
{
public:
	Staff(string staffID, string name, string department, string phone, string extentionNum, int deposit);
	~Staff() override;
	void print() const override;
	string toString() const override;

	void setID(string id);
	void setDepartment(string department);
	void setExtentionNum(string extentionNum);
	string getID() const override;
	string getDepartment() const override;
	string getExtentionNum() const override;

private:
	string staffID;
	string department;
	string extentionNum;
};