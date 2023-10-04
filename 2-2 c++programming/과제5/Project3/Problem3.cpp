#include <iostream>
using namespace std;

void printArr(int* pArr, int size);

int main()
{
    const int MAX = 3;
    int arr[MAX][MAX] = { 1,2,3,4,10,6,7,8,9 };
    printArr(*arr, MAX);

    return 0;
}


void printArr(int* pArr, int size)
{
    //for (int row = 0; row < size * size; row += size)
    //{
    //    for (int col = 0; col < size; col++)
    //        cout << (pArr + row)[col] << " ";
    //    cout << endl;
    //}
    for (int i = 0; i < size * size; i++)
        cout << pArr[i] << " ";
}
