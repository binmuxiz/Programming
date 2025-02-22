#include "Set.h"
#include <string>

Set::Set() : capacity(4), size(0)
{
	pArr = new int[capacity];
}

Set::Set(int* p, int s, int c)
{
	pArr = p;
	size = s;
	capacity = c;
}

Set::Set(const Set& src)
{
	capacity = src.capacity;
	size = src.size;
	
	pArr = new int[capacity];

	for (int i = 0; i < size; i++)
		pArr[i] = src.pArr[i];
}

void Set::resize()
{
	int* pTemp = new int[capacity *= 2];
	for (int i = 0; i < size; i++)
		pTemp[i] = pArr[i];

	delete[] pArr;
	pArr = pTemp;
}

bool Set::duplicatedVal(const int newVal) const
{
	for (int i = 0; i < size; i++)
	{
		if (pArr[i] == newVal)
			return true;
	}
	return false;
}

void Set::setElement(const int val)
{
	if (size == capacity)
		resize();
	pArr[size++] = val;
}

const Set Set::operator | (const Set& another) const
{
	Set newSet;

	for (int i = 0; i < size; i++)
		newSet.setElement(pArr[i]);

	for (int i = 0; i < another.size; i++)
	{
		if (!newSet.duplicatedVal(another.pArr[i]))
			newSet.setElement(another.pArr[i]);
	}
	return newSet;
}

const Set Set::operator & (const Set& another) const
{
	Set newSet;

	for (int i = 0; i < size; i++)
	{
		if (another.duplicatedVal(pArr[i]))
			newSet.setElement(pArr[i]);
	}

	return newSet;
}


istream& operator >> (istream& inputStream, Set& set)
{
	int temp;
	string str = "";

	while (true)
	{
		inputStream >> temp;
		if (temp < 0)
			break;

		if (set.duplicatedVal(temp))
		{
			str += to_string(temp) + "는 중복원소이므로 제거\n";
			continue;
		}
		set.setElement(temp);
	}
	cout << str;

	return inputStream;
}

ostream& operator << (ostream& outputStream, const Set& set)
{
	for (int i = 0; i < set.size; i++)
		outputStream << set.pArr[i] << " ";

	return outputStream;
}

Set::~Set()
{
	delete[] pArr;
}