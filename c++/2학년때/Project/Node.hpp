#pragma once
#include <iostream>

template <typename T>
class Node
{
public:
	Node();
	Node(T* data);
	~Node();
	Node<T>* getPrev() const;
	T* getData() const;
	Node<T>* getNext() const;
	void setPrev(Node<T>* prev);
	void setData(T* data);
	void setNext(Node<T>* next);

private:
	T* data;
	Node<T>* prev;
	Node<T>* next;
};

template <typename T>
Node<T>::Node()
	: data(nullptr), prev(nullptr), next(nullptr)
{}

template <typename T>
Node<T>::Node(T* data)
	: data(data), prev(nullptr), next(nullptr)
{}

template<typename T>
Node<T>::~Node(){}

template <typename T>
T* Node<T>::getData() const
{
	return data;
}

template <typename T>
Node<T>* Node<T>::getPrev() const
{
	return prev;
}

template <typename T>
Node<T>* Node<T>::getNext() const
{
	return next;
}

template <typename T>
void Node<T>::setData(T* data)
{
	this->data = data;
}

template <typename T>
void Node<T>::setPrev(Node<T>* prev)
{
	this->prev = prev;
}

template <typename T>
void Node<T>::setNext(Node<T>* next)
{
	this->next = next;
}
