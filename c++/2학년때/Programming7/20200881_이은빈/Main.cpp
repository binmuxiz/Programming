#include "Controller.h"

int main(int argc, char* argv[])
{
	cout << "***************발전기금 관리 프로그램*****************" << endl
		<< "------기탁현황-------" << endl;
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
				cout << "!!! 동일한 " << e.getStr() << "가 존재하여 신규 등록 불가 !!!" << endl;
			} 
			catch (NoSuchElement) {
				cout << "!!! 해당 ID 또는 전화번호를 가진 기탁자가 존재하지 않습니다 !!!" << endl;
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
		cout << "!!! 동일한 "<< e.getStr() << "가 존재하여 파일 읽기 불가 !!!" << endl;
	}
	return 0;
}
