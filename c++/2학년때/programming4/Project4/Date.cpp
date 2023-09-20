#include "Date.h"
#include <ctime>

const int Date::DAYS_PER_MONTH[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

Date::Date() 
{
	struct tm curr_tm;
	time_t now = time(NULL);
	localtime_s(&curr_tm, &now);

	nowYear = curr_tm.tm_year + 1900;
	nowMonth = curr_tm.tm_mon + 1;
	nowDay = curr_tm.tm_mday;
	isExistDday = false;
}

void Date::setDate(const int& year, const int& month, const int& day)
{
	if (isCorrectDate(year, month, day))
	{
		nowYear = year;
		nowMonth = month;
		nowDay = day;
	}
}

void Date::setMyDday(const int &dDay) 
{
	myDday = dDay;
	isExistDday = true;
}

bool Date::isCorrectDate(const int& year, const int& month, const int& day) const
{
 	if (1 <= month && month <= 12)
	{
		if (month == 2 && isLeapYear(year))
		{
			if (day <= DAYS_PER_MONTH[month - 1] + 1)
				return true;
		}
		else if (day <= DAYS_PER_MONTH[month - 1])
				return true;
	}
	
	cout << "올바른 날짜가 아니므로 날짜를 설정할 수 없습니다." << endl;
	return false;
	
}

bool Date::isLeapYear(const int &year) const
{
	if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
		return true;
	return false;
}

void Date::plusDday(int dDay) const
{
	int day, month = nowMonth, year = nowYear;

	dDay -= DAYS_PER_MONTH[month - 1] - nowDay + 1;
	if (month == 2 && isLeapYear(year))
		dDay--;

	while (dDay > 0)
	{
		if (++month > MONTH_NUM)
		{
			month = 1;
			year++;
		}

		dDay -= DAYS_PER_MONTH[month - 1];
		if (month == 2 && isLeapYear(year))
			dDay--;
	}

	day = DAYS_PER_MONTH[month - 1] + dDay;

	cout << "[D+" << myDday << "]" << year << "년 " << month << "월 " << day << "일" << endl;
}

void Date::minusDday(int dDay) const
{
	int day = 0, month = nowMonth, year = nowYear;

	dDay -= nowDay;

	while (dDay >= 0)
	{
		if (--month < 1)
		{
			month = 12;
			year--;
		}

		dDay -= DAYS_PER_MONTH[month - 1];
		if (month == 2 && isLeapYear(year))
			dDay--;
	}

	day -= dDay;

	cout << "[D" << myDday << "] " << year << "년 " << month << "월 " << day << "일" << endl;

}

void Date::operator++()
{	
	if (++nowDay > DAYS_PER_MONTH[nowMonth - 1])
	{
		if (nowMonth != 2 && !isLeapYear(nowYear))
		{
			nowDay = 1;
			if (++nowMonth > MONTH_NUM)
			{
				nowYear++;
				nowMonth = 1;
			}
		}
		else if (nowMonth == 2 && !isLeapYear(nowYear))
		{
			nowMonth++;
			nowDay = 1;
		}

		else
		{
			if (nowDay > DAYS_PER_MONTH[nowMonth - 1] + 1)
			{
				nowMonth++;
				nowDay = 1;
			}

		}
	}
}


void Date::operator--()
{
	if (--nowDay < 1)
	{
		if (--nowMonth < 1)
		{
			nowYear--;
			nowMonth = 12;
		}

		nowDay = DAYS_PER_MONTH[nowMonth - 1];
		if (nowMonth == 2 && isLeapYear(nowYear))
			nowDay++;
	}
}

ostream& operator << (ostream& outputStream, const Date& date)
{
	outputStream << "[현재 날짜] " << date.nowYear << "년 " << date.nowMonth << "월 " << date.nowDay << "일 ";
	
	if (date.isExistDday)
	{
		if (date.myDday <= 0)
			date.minusDday(-date.myDday);
		else
			date.plusDday(date.myDday);
	}
	else
		outputStream << "[D-day 없음]" << endl;

	return outputStream;
}

