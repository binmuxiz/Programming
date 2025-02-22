#pragma once
#include "MyList.hpp"
#include "Student.h"
#include "Staff.h"
#include "GeneralPublic.h"
#include <vector>
#include <sstream>
#include <fstream>

class Controller
{
public:
	Controller();
	bool handler();
	Person* registerDepositor(string& line);
	bool wantToSave() const;
	void saveFile(string& filename) const;
	void readFile(string& filename);

private:
	MyList<Person, string>* list;
};

class CouldNotOpenFile {};