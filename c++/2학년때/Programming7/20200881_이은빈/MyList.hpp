#pragma once
#include "Person.h"
#include "Node.hpp"

template <typename T, typename K>
class MyList
{
public:
	MyList();
	~MyList();
	void retrieveAll() const;
	const string toString() const;
	void add(T* data);
	T* remove(K &key);
	T* modify(K &key, int value);
	const int getSize() const;

private:
	Node<T>* head;
	int size;

	void add(T* data, Node<T>* prev);
	void remove(Node<T>* target);
	bool compare(T* data1, T* data2) const;
	Node<T>* find(K& key) const;
};

class NoSuchElement {};

class DuplicatedElement {
public:
	DuplicatedElement(string str) {
		this->str = str;
	};
	string getStr() { return str; }
private:
	string str;
};


template<typename T, typename K>
MyList<T, K>::MyList()
{
	size = 0;
	head = new Node<T>();
}

template<typename T, typename K>
MyList<T, K>::~MyList()
{
	Node<T>* now = head;
	Node<T>* next = now->getNext();
	for (; next != nullptr; now = next, next = now->getNext())
	{
		delete now->getData();
		delete now;
	}
}

template<typename T, typename K>
void MyList<T, K>::retrieveAll() const
{
	for (Node<T>* node = head->getNext(); node != nullptr ; node = node->getNext())
		node->getData()->print();
}

template<typename T, typename K>
const string MyList<T, K>::toString() const
{
	string str = "";
	for (Node<T>* node = head->getNext(); node != nullptr; node = node->getNext())
		str += node->getData()->toString();
	return str;
}

template<typename T, typename K>
void MyList<T, K>::add(T* newData)
{
	if (size == 0)
	{
		add(newData, head);
		return;
	}
	
	Node<T>* now = head->getNext();
	for (; now != nullptr; now = now->getNext())
	{
		T* tempD = now->getData();
		if (newData->getID().compare(tempD->getID()) == 0) {
			delete newData;
			throw DuplicatedElement("id");
		}
		if (newData->getPhone().compare(tempD->getPhone()) == 0) {
			delete newData;
			throw DuplicatedElement("전화번호");
		}
	}
	
	Node<T>* prev = head;
	now = prev->getNext();

	for (; now != nullptr; now = now->getNext(), prev = prev->getNext())
	{
		if (compare(newData, now->getData()))
			break;
	}
	add(newData, prev);
}

template<typename T, typename K>
void MyList<T, K>::add(T* data, Node<T>* prev)
{
	Node<T>* node = new Node<T>(data);

	if (prev->getNext() == nullptr) //size==0 or list의 마지막에 추가
	{
		prev->setNext(node);
		node->setPrev(prev);
	}
	else
	{
		node->setPrev(prev);
		node->setNext(prev->getNext());
		prev->setNext(node);
		node->getNext()->setPrev(node);
	}
	size++;
}

template<typename T, typename K>
T* MyList<T, K>::remove(K &key)
{
	Node<T>* target = find(key);
	T* data = target->getData();
	remove(target);
	return data;
}

template<typename T, typename K>
void MyList<T, K>::remove(Node<T>* target)
{
	Node<T>* prev = target->getPrev();
	if (target->getNext() == nullptr)
		prev->setNext(nullptr);
	else
	{
		prev->setNext(target->getNext());
		target->getNext()->setPrev(prev);
	}
	size--;
	delete target;
}

template<typename T, typename K>
T* MyList<T, K>::modify(K& key, int value)
{
	Node<Person>* target = find(key);
	Person* data = target->getData();
	data->setDeposit(value);

	if (size == 1 || // element가 하나면
		target->getPrev()->getData() == nullptr || // 이전 node가 head면
		target->getPrev()->getData()->getDeposit() > target->getData()->getDeposit())  // prev data > target data 
		return data;

	remove(target);
	add(data);
	return data;
}

template<typename T, typename K>
const int MyList<T, K>::getSize() const
{
	return size;
}

template<typename T, typename K>
bool MyList<T, K>::compare(T* data1, T* data2) const
{
	// data1이 data2보다 이전인 경우 return true
	if (data1->getDeposit() > data2->getDeposit()) // deposit 내림차순
		return true;
	else if (data1->getDeposit() == data2->getDeposit())
	{
		if (data1->getName().compare(data2->getName()) < 0) // name 오름차순
			return true;
		else if (data1->getName().compare(data2->getName()) == 0)
		{
			if (data1->getPhone().compare(data2->getPhone()) < 0) // phone 오름차순
				return true;
		}
	}
	return false;
}

template<typename T, typename K>
Node<T>* MyList<T, K>::find(K& key) const
{
	Node<T>* now = head->getNext();

	for (; now != nullptr; now = now->getNext())
	{
		T* data = now->getData();
		if (data->getID().compare(key) == 0 || data->getPhone().compare(key) == 0)
			break;
	}
	if (now == nullptr) 
		throw NoSuchElement();
	return now;
}


