#include <iostream>
using namespace std;

void showDigit(int n);
void showReverseDigit(int n);

void main()

{

    int val;
    cout << "���� �Է�: ";  
    cin >> val;  

    cout << "�ٷ� ��� : "; 
    showDigit(val);

    cout << endl;

    cout << "�Ųٷ� ���: ";
    showReverseDigit(val);

}
 
void showDigit(int n)   
{
    if (n / 10 != 0)
        showDigit(n / 10);

    cout << n % 10 << " ";
}

void showReverseDigit(int n)    
{
    cout << n % 10 << " ";
    
    if (n / 10 != 0)
        showReverseDigit(n / 10);
}