#include <iostream>
using namespace std;

void showDigit(int n);
void showReverseDigit(int n);

void main()

{

    int val;
    cout << "정수 입력: ";  
    cin >> val;  

    cout << "바로 출력 : "; 
    showDigit(val);

    cout << endl;

    cout << "거꾸로 출력: ";
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