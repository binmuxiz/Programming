#pragma once
#include <string>
#include <iostream>
using namespace std;
class Date
{
public :
	Date();
	void setMyDday(const int &dDay);
	void setDate(const int &year, const int &month, const int &day);
	bool isCorrectDate(const int &year, const int &month, const int &day) const;
	bool isLeapYear(const int &year) const;
	void plusDday(int dDay) const;
	void minusDday(int dDay) const;
	void operator ++();
	void operator --();
	friend ostream& operator << (ostream& outputStream, const Date& date);
	

private :
	int nowYear;
	int nowMonth;
	int nowDay;
	int myDday;
	bool isExistDday;
	const static int MONTH_NUM = 12;
	const static int DAYS_PER_MONTH[MONTH_NUM];
};