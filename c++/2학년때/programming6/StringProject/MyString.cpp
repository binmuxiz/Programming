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
* �ǵ�� ) reserve_cap�� ���� �Ǿ��ִµ� 100���� �⺻ũ�⸦ ����� �ִ�.
* �ϰ��� ����. 128�� �����
*/
istream& operator>>(istream& is, MyString& str)
{
	str.deleteString();
	str.capacity = 100;
	str.myStr = new char[str.capacity];

	while (true)
	{
		char ch = cin.get();	// is.get()���� ȣ���߾����
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
* cout << �� �ƴ� os <<�� �����ؾ���. ����
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
	if (i >= size && srcStr[i] != '\0') // this�� ���̰� �� ������
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
* "AAAX"�ȿ� "AAX"�� �ִ��� Ȯ���ϴ� ���,
   ���� �ڵ�� arr[2]���� match ���а� �߻��ϰ�, �ٷ� arr[2]�� subStr[0]�� ���ϰ� �ǹǷ�
   Ž�� ���а� �߻��մϴ�. 
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
* �޸� ���� ��ȿ����. MyString(int) ������ �����ڸ� ����
* �ʿ���� new�� delete�� �ݺ��� ���־���.
*/
const MyString MyString::substr(int pos, int cnt) const
{
	if (0 > pos || pos >= size)
	{
		cout << ">> index�� string�� ������ �ʰ��Ͽ����ϴ�.";
		return NULL;
	}
	if (0 > cnt || cnt > size)
		cnt = size - pos;
	
	int end = pos + cnt - 1;
	if (end >= size)
		end = size - 1;
	MyString result;
	result.deleteString();	// ���
	result.size = end - pos + 1;
	result.reserve_cap(size);
	result.myStr = new char[result.capacity];	// ��??

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
* resize() ��ȿ����
* ��ü�� �� ������ ���� pos������ ���� �� �ڷ� �̷�� �۾����� ���簡
* �ߺ� �߻�
* insert()���� ������ �����ϴٰ� �Ǵܵ� ���� new�� ���� delete�� ���� �ϴ�
* ���� �� ȿ����
*/
const MyString& MyString::insert(int pos, int subsize, const char* subStr)
{
	if (pos < 0 || pos > size)
	{
		cout << ">> index�� string�� ������ �ʰ��Ͽ����ϴ�.";
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
		* ���� strCopy()�� ������ ������ ���ڸ� �����ϴ� �۾�����
		* replace()ó�� ���� myStr�� �����ϴ°��� ���� �� ����.
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
* replace()�� erese()���� �������� ������ ��� null�� ������ �ʿ�� ����.
* ���ڿ� �ٷ� �ڿ��� null�� �־��ָ� �ȴ�.
*/
const MyString& MyString::replace(int pos, int cnt, int subSize, const char* subStr)
{
	if (0 > pos || pos > size)
	{
		cout << "pos�� ��ġ�� index�� ������ϴ�.";
		return *this;
	}

	int tempSize = 0;
	if (cnt < 0 || pos + cnt >= size)
	{
		tempSize = pos + subSize;
		resize(tempSize);
		for (int i = pos; i < size; i++)    // pos ���� ������ ����
			myStr[i] = '\0';
	}
	else
	{
		tempSize = size - cnt + subSize;
		resize(tempSize);
		for (int i = pos + cnt; i < size; i++)   //  pos + cnt��ġ���� subsize��ŭ �б�
			myStr[i + (subSize - cnt)] = myStr[i];
	}
	for (int i = pos, k = 0; subStr[k] != '\0'; i++, k++) // �����ֱ�
		myStr[i] = subStr[k];
	myStr[tempSize] = '\0';
	size = tempSize;
	
	return *this;
}

const MyString& MyString::erase(int pos, int cnt)
{
	if (0 > pos || pos >= size)
	{
		cout << " >> index�� string�� ������ �ʰ��Ͽ����ϴ�.";
		return *this;
	}
	if (cnt < 0) // pos��ġ���� �ϴ� ������
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
	// pos�� index ������ ����� ��� stringŬ���������� ���ܸ� ������ �� ��� ��¹����� ó��.
	if (0 <= pos && pos < size)
		return myStr[pos];
	cout << ">> index�� string�� ������ �ʰ��Ͽ����ϴ�.";

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
* strCopy()��ü�� �ϰἳ�� ���ؼ� null�� ��ġ �Ǵ� ���ڿ��� ���̸�
* ���ڷ� ������ ���� ����
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
