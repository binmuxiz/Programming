#include <iostream>
using namespace std;

void printArr(int* arr, int max);

int main()
{
    const int MAX = 5;
    int arr1[MAX] = { 1,2,3,4,5 }, arr2[MAX], *p = new int[MAX];

    for (int i = 0; i < MAX; i++)
        arr2[i] = arr1[i];

    for (int i = 0; i < MAX; i++)
        p[i] = arr1[i];

    p[0] = 99;
    printArr(arr1, MAX); printArr(arr2, MAX); printArr(p, MAX);
    delete[] p;

    return 0;

}

void printArr(int * arr, int max) 
{
    for (int i = 0;i < max; i++)
        cout << arr[i] << " ";
    cout << endl;
}
