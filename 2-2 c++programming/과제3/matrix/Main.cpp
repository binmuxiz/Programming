#include <iostream>
#include "Matrix.h" 

using namespace std;

int main()
{
    Matrix m1, m2;
    m1.print();
    m2.print();

    Matrix m3 = m1.add(m2);
    cout << "�� ����� ���� " << endl;
    m3.print();

    m3 = m1.multi(m2);
    cout << "�� ����� ���� " << endl;
    m3.print();

    return 0;

}
