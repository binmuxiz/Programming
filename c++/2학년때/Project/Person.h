#pragma once
#include <string>
#include <iostream>
using namespace std;

class Person
{
public:
	Person(string name, string phone, int deposit);
	virtual ~Person();
	virtual void print() const;
	virtual string toString() const;

	void setDeposit(int deposit);
	string getName() const;
	string getPhone() const;
	int getDeposit() const;

	virtual string getID() const;
	virtual string getDepartment() const;
	virtual string getExtentionNum() const;


private:
	string name;
	string phone;
	int deposit;
};