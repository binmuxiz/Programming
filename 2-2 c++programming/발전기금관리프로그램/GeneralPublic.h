#pragma once
#include "Person.h"

class GeneralPublic :
	public Person
{
public:
	GeneralPublic(string name, string phone, int deposit);
	GeneralPublic(string id, string name, string phone, int deposit);
	~GeneralPublic() override;
	void print() const override;
	string toString() const override;

	void setID(int code);
	string getID() const override;

private:
	string depositorID;
};