#include <iostream>
using namespace std;

int main()
{
	while (true)
	{
		double num;
		cout << "�ε��Ҽ��� ���� �Է��ϼ���(0���� ����) : ";
		cin >> num;

		if (num == 0)
		{
			cout << "����" << endl;
			break;
		}
		
		cout << "������ : " << (int)num << " �Ҽ����� : " << (num - (int)num) << endl;
	}

	return 0;
}

