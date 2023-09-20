#include "Controller.h"

int main(int argc, char* argv[])
{
	cout << "***************������� ���� ���α׷�*****************" << endl
		<< "------��Ź��Ȳ-------" << endl;
	string filename = argv[1];
	Controller con;
	try
	{
		con.readFile(filename);

		bool flag = true;
		while (flag) {
			try {
				flag = con.handler();
			}
			catch (DuplicatedElement e) {
				cout << "!!! ������ " << e.getStr() << "�� �����Ͽ� �ű� ��� �Ұ� !!!" << endl;
			} 
			catch (NoSuchElement) {
				cout << "!!! �ش� ID �Ǵ� ��ȭ��ȣ�� ���� ��Ź�ڰ� �������� �ʽ��ϴ� !!!" << endl;
			}
		}
		con.saveFile(filename);
	} 
	catch (CouldNotOpenFile)
	{
		cerr << "Could not open the file - '"
			<< filename << "'" << endl;
	}
	catch (DuplicatedElement e) {
		cout << "!!! ������ "<< e.getStr() << "�� �����Ͽ� ���� �б� �Ұ� !!!" << endl;
	}
	return 0;
}
