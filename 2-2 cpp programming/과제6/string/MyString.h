#pragma once
#include <iostream>
using namespace std;

class MyString
{
public:
	MyString();
	MyString(const char* srcStr);
	MyString(const MyString& srcStr);
	~MyString();

	friend istream& operator >>(istream& is, MyString& str);
	friend ostream& operator <<(ostream& os, const MyString& str);

	const MyString& operator =(const char* srcStr);
	const MyString& operator =(const MyString& srcStr);


	const MyString operator +(const char* str2nd) const;
	const MyString operator +(const MyString& str2nd) const;

	const MyString& operator +=(const char* str2nd);

	const MyString& append(const char* str2nd);
	const MyString& append(const MyString& str2nd);

	bool operator ==(const MyString& str) const;
	bool operator !=(const MyString& str) const;

	bool operator <(const char* srcStr) const;
	bool operator <=(const char* srcStr) const;
	bool operator >(const char* srcStr) const;
	bool operator >=(const char* srcStr) const;

	bool operator <(const MyString& srcStr) const;
	bool operator <=(const MyString& srcStr) const;
	bool operator >(const MyString& srcStr) const;
	bool operator >=(const MyString& srcStr) const;

	int find(int pos, const char* subStr) const;
	int find(int pos, const MyString& subStr) const;
	int find(const char* subStr) const;
	int find(const MyString& subStr) const;

	const MyString substr(int pos, int cnt) const;

	const MyString& insert(int pos, const char* subStr);
	const MyString& insert(int pos, const MyString& subStr);

	const MyString& replace(int pos, int cnt, const char* subStr);
	const MyString& replace(int pos, int cnt, const MyString& subStr);

	const MyString& erase(int pos, int cnt);

	char at(int pos) const;
	char operator[](int pos) const;
	bool empty() const;
	int length() const;

private:
	static const int INIT_CAPACITY = 8;
	char* myStr;
	int size;
	int capacity;

	void resize();
	void resize(int newsize);
	void reserve_cap(int size);
	void strCopy(const char* srcStr, const int begin = 0);
	void deleteString();

	const MyString plus(const char* str2nd, int size2nd) const;
	const MyString& substitute(const char* srcStr, int size2nd);
	const MyString& append(const char* str2nd, int size2nd);
	const int compare(const char* srcStr) const;
	const MyString& insert(int pos, int subSize, const char* subStr);
	const MyString& replace(int pos, int cnt, int subSize, const char* subStr);

};

