#pragma once
#include <iostream>
using namespace std;

class Set
{
public:
	Set();
	Set(int* p, int s, int c);
	Set(const Set& src);
	bool duplicatedVal(const int val) const;
	void setElement(const int val);
	const Set operator | (const Set& another) const;
	const Set operator & (const Set& another) const;
	friend istream& operator >> (istream& inputStream, Set& set);
	friend ostream& operator << (ostream& outputStream, const Set& set);
	~Set();

private:
	int* pArr;
	int capacity;
	int size;
	void resize();
};

