#include "MyString.h"

int getLength(const char* srcStr)
{
	int size = 0;
	while (srcStr[size] != '\0')
		size++;
	return size;
}

MyString::MyString() : capacity(INIT_CAPACITY), size(0)
{
	myStr = new char[capacity];
	myStr[size] = '\0';
}

MyString::MyString(const char* srcStr)
{
	size = getLength(srcStr);
	reserve_cap(size);
	myStr = new char[capacity];
	strCopy(srcStr);
}

MyString::MyString(const MyString& srcStr)
{
	size = srcStr.size;
	capacity = srcStr.capacity;
	myStr = new char[capacity];
	strCopy(srcStr.myStr);
}

MyString::~MyString()
{
	delete[] myStr;
}

/*
* 피드백 ) reserve_cap이 정의 되어있는데 100으로 기본크기를 만들고 있다.
* 일관성 없음. 128이 어땠을까
*/
istream& operator>>(istream& is, MyString& str)
{
	str.deleteString();
	str.capacity = 100;
	str.myStr = new char[str.capacity];

	while (true)
	{
		char ch = cin.get();	// is.get()으로 호출했어야함
		if (ch == '\n')
			break;
		if (str.size >= str.capacity - 1)
			str.resize();
		str.myStr[str.size++] = ch;
	}
	str.myStr[str.size] = '\0';

	return is;
}

/*
* cout << 이 아닌 os <<로 구현해야함. 감점
*/
ostream& operator<<(ostream& os, const MyString& str)
{
	for (int i = 0; i < str.size; i++)
		cout << str.myStr[i];
	cout << endl;
	return os;
}

const MyString& MyString::operator=(const char* srcStr)
{
	return substitute(srcStr, getLength(srcStr));
}

const MyString& MyString::operator=(const MyString& srcStr)
{
	return substitute(srcStr.myStr, srcStr.size);
}

const MyString& MyString::substitute(const char* srcStr, int size2nd)
{
	deleteString();
	size = size2nd;
	reserve_cap(size);
	myStr = new char[capacity];
	strCopy(srcStr);

	return *this;
}

const MyString MyString::operator+(const char* str2nd) const
{
	return plus(str2nd, getLength(str2nd));
}

const MyString MyString::operator+(const MyString& str2nd) const
{
	return plus(str2nd.myStr, str2nd.size);
}

const MyString MyString::plus(const char* str2nd, int size2nd) const
{
	MyString result;
	int tempSize = size + size2nd;
	result.reserve_cap(tempSize);
	result.myStr = new char[result.capacity];
	result.strCopy(myStr);
	result.strCopy(str2nd, size);
	result.size = tempSize;
	return result;
}

const MyString& MyString::operator +=(const char* str2nd)
{
	return append(str2nd, getLength(str2nd));
}

const MyString& MyString::append(const char* str2nd)
{
	return append(str2nd, getLength(str2nd));
}

const MyString& MyString::append(const MyString& str2nd)
{
	return append(str2nd.myStr, str2nd.size);
}

const MyString& MyString::append(const char* str2nd, int size2nd)
{
	int tempSize = size + size2nd;
	resize(tempSize);
	strCopy(str2nd, size);
	size = tempSize;

	return *this;
}

bool MyString::operator ==(const MyString& str) const
{
	if (size != str.size)
		return false;

	for (int i = 0; i < size; i++)
	{
		if (myStr[i] != str.myStr[i])
			return false;
	}
	return true;
}

bool MyString::operator !=(const MyString& str) const
{
	if (*this == str)
		return false;
	return true;
}

const int MyString::compare(const char* srcStr) const
{
	int i = 0;
	while (i < size && srcStr[i] != '\0')
	{
		if (myStr[i] < srcStr[i])
			return -1;
		if (myStr[i] > srcStr[i])
			return 1;
		i++;
	}
	if (i >= size && srcStr[i] != '\0') // this의 길이가 더 작으면
		return -1;
	else if (i < size && srcStr[i] == '\0')
		return 1;
	else
		return 0;
}

bool MyString::operator <(const char* srcStr) const
{
	if (compare(srcStr) < 0)
		return true;
	return false;
}

bool MyString::operator <=(const char* srcStr) const
{
	if (compare(srcStr) > 0)
		return false;
	return true;
}

bool MyString::operator >(const char* srcStr) const
{
	if (compare(srcStr) > 0)
		return true;
	return false;
}

bool MyString::operator >=(const char* srcStr) const
{
	if (compare(srcStr) < 0)
		return false;
	return true;
}

bool MyString::operator <(const MyString& srcStr) const
{
	if (compare(srcStr.myStr) < 0)
		return true;
	return false;
}

bool MyString::operator <=(const MyString& srcStr) const
{
	if (compare(srcStr.myStr) > 0)
		return false;
	return true;
}

bool MyString::operator >(const MyString& srcStr) const
{
	if (compare(srcStr.myStr) > 0)
		return true;
	return false;
}

bool MyString::operator >=(const MyString& srcStr) const
{
	if (compare(srcStr.myStr) < 0)
		return false;
	return true;
}

/*
* "AAAX"안에 "AAX"가 있는지 확인하는 경우,
   현재 코드는 arr[2]에서 match 실패가 발생하고, 바로 arr[2]와 subStr[0]을 비교하게 되므로
   탐색 실패가 발생합니다. 
*/
int MyString::find(int pos, const char* subStr) const
{
	if (0 > pos || pos >= size)
		return -1;

	int result = pos;
	int i = pos, j = 0;
	while (i < size && subStr[j] != '\0')
	{
		if (myStr[i++] == subStr[j])
			j++;
		else
		{
			result = i;
			j = 0;
		}
	}
	if (result >= size || subStr[j] != '\0')
		return -1;
	return result;
}

int MyString::find(int pos, const MyString& subStr) const
{
	return find(pos, subStr.myStr);
}

int MyString::find(const char* subStr) const
{
	return find(0, subStr);
}

int MyString::find(const MyString& subStr) const
{
	return find(0, subStr.myStr);
}

/*
* 메모리 관리 비효율적. MyString(int) 정도의 생성자를 만들어서
* 필요없는 new와 delete의 반복을 없애야함.
*/
const MyString MyString::substr(int pos, int cnt) const
{
	if (0 > pos || pos >= size)
	{
		cout << ">> index가 string의 범위를 초과하였습니다.";
		return NULL;
	}
	if (0 > cnt || cnt > size)
		cnt = size - pos;
	
	int end = pos + cnt - 1;
	if (end >= size)
		end = size - 1;
	MyString result;
	result.deleteString();	// 얘랑
	result.size = end - pos + 1;
	result.reserve_cap(size);
	result.myStr = new char[result.capacity];	// 얘??

	int i = 0, j = pos;
	while (j <= end)
		result.myStr[i++] = myStr[j++];
	result.myStr[i] = '\0';
	result.size = i;

	return result;
}


const MyString& MyString::insert(int pos, const char* subStr)
{
	return insert(pos, getLength(subStr), subStr);
}

const MyString& MyString::insert(int pos, const MyString& subStr)
{
	return insert(pos, subStr.size, subStr.myStr);
}

/*
* resize() 비효울적
* 전체를 다 복사한 다음 pos이후의 것을 더 뒤로 미루는 작업으로 복사가
* 중복 발생
* insert()에서 공간이 부족하다고 판단될 때만 new와 복사 delete를 직접 하는
* 것이 더 효율적
*/
const MyString& MyString::insert(int pos, int subsize, const char* subStr)
{
	if (pos < 0 || pos > size)
	{
		cout << ">> index가 string의 범위를 초과하였습니다.";
		return *this;
	}

	int tempSize = size + subsize;
	resize(tempSize);

	if (size == pos)
		strCopy(subStr, pos);
	else
	{
		for (int i = size - 1; i >= pos; i--)
			myStr[i + subsize] = myStr[i];
		myStr[size + subsize] = '\0';
		char tmp = myStr[pos];
		/*
		* 굳이 strCopy()를 쓰느라 마지막 글자를 복사하는 작업보다
		* replace()처럼 직접 myStr을 관리하는것이 좋을 것 같다.
		*/
		strCopy(subStr, pos);  
		myStr[pos + subsize] = tmp;
	}
	size = tempSize;
	return *this;
}


const MyString& MyString::replace(int pos, int cnt, const char* subStr)
{
	return replace(pos, cnt, getLength(subStr), subStr);
}

const MyString& MyString::replace(int pos, int cnt, const MyString& subStr)
{
	return replace(pos, cnt, subStr.size, subStr.myStr);
}

/*
* replace()와 erese()에서 지워지는 공간을 모두 null로 저장할 필요는 없다.
* 문자열 바로 뒤에만 null을 넣어주면 된다.
*/
const MyString& MyString::replace(int pos, int cnt, int subSize, const char* subStr)
{
	if (0 > pos || pos > size)
	{
		cout << "pos의 위치가 index를 벗어났습니다.";
		return *this;
	}

	int tempSize = 0;
	if (cnt < 0 || pos + cnt >= size)
	{
		tempSize = pos + subSize;
		resize(tempSize);
		for (int i = pos; i < size; i++)    // pos 부터 끝까지 삭제
			myStr[i] = '\0';
	}
	else
	{
		tempSize = size - cnt + subSize;
		resize(tempSize);
		for (int i = pos + cnt; i < size; i++)   //  pos + cnt위치부터 subsize만큼 밀기
			myStr[i + (subSize - cnt)] = myStr[i];
	}
	for (int i = pos, k = 0; subStr[k] != '\0'; i++, k++) // 끼워넣기
		myStr[i] = subStr[k];
	myStr[tempSize] = '\0';
	size = tempSize;
	
	return *this;
}

const MyString& MyString::erase(int pos, int cnt)
{
	if (0 > pos || pos >= size)
	{
		cout << " >> index가 string의 범위를 초과하였습니다.";
		return *this;
	}
	if (cnt < 0) // pos위치부터 싹다 지워짐
		cnt = size - pos;

	int k = pos;
	if (pos + cnt < size)
	{
		int tempSize = size - cnt;
		for (int i = pos + cnt; i < size; i++)
			myStr[i - cnt] = myStr[i];
		k = tempSize;
	}
	for (int i = k; i < size; i++)
		myStr[i] = '\0';
	size = k;

	return *this;
}


char MyString::at(int pos) const
{
	// pos가 index 범위를 벗어나는 경우 string클래스에서는 예외를 뱉지만 그 대신 출력문으로 처리.
	if (0 <= pos && pos < size)
		return myStr[pos];
	cout << ">> index가 string의 범위를 초과하였습니다.";

}

char MyString::operator[](int pos) const
{
	return at(pos);
}

bool MyString::empty() const
{
	if (size == 0)
		return true;
	return false;
}

int MyString::length() const
{
	return size;
}

void MyString::resize()
{
	capacity *= 2;
	char* temp = new char[capacity];

	for (int i = 0; i < size; i++)
		temp[i] = myStr[i];
	delete[] myStr;
	myStr = temp;
}

void MyString::resize(int newsize)
{
	if (newsize >= capacity)
	{
		reserve_cap(newsize);
		char* temp = new char[capacity];

		for (int i = 0; i < size; i++)
			temp[i] = myStr[i];
		delete[] myStr;
		myStr = temp;
	}
}

void MyString::reserve_cap(int size)
{
	int cap = INIT_CAPACITY;
	while (true)
	{
		if (size < cap)
		{
			capacity = cap;
			break;
		}
		cap *= 2;
	}
}

/*
* strCopy()자체의 완결설을 위해서 null의 위치 또는 문자열의 길이를
* 인자로 보내는 것이 안전
*/
void MyString::strCopy(const char* srcStr, const int begin)
{
	int i = begin, j = 0;
	while (srcStr[j] != '\0')
		myStr[i++] = srcStr[j++];
	myStr[i] = '\0';
}

void MyString::deleteString()
{
	if (myStr != NULL)
	{
		delete[] myStr;
		size = 0;
		capacity = 0;
	}
}
