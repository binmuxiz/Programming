#include "MyString.h"
#include <string>

int main()
{
	cout << "=============================생성자 및 대입연산자===================" << endl;

	MyString str = "ddd";
	cout << str.at(9);
	//str2 = str1;
	//cout << "str2 : " << str2;

	//MyString str3("strawberry moon");
	//MyString str4(str3);
	//cout << "str4 : " << str4;

	//MyString str5;
	//str5 = "cherry";
	//cout << "str5 : " << str5;

	//MyString str6;
	//str6 = str5;
	//cout << "str6 : " << str6;

	cout << "================================== + 연산자========================================" << endl;

	//MyString str2 = "ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp";
	//MyString str3;
	//cin >> str3;
	//cout << str3;
	//cout << str3 + str2;
	
	cout << "================================== 입출력 ======================================" << endl;

	//MyString str3 = "asdfghjkl;";
	//cin >> str3;
	//cout << str3;


	cout << "============================== append ================================" << endl;

	//str1.append(str2);
	//cout << str1;
	//str2.append("012345678901234567890123456789");
	//cout << str2;

	cout << "============================== += 연산자 ================================" << endl;

	//MyString str2 = "ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp";
	//str2 += "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
	//cout << str2;

	

	cout << "============================== 동등 비교 연산자 ================================" << endl;

	//if (str1 == str2)
	//	cout << "str1 == str2" << endl;

	//if (str1 != str2)
	//	cout << "str1 != str2" << endl;

	//if (str2 == str3)
	//	cout << "str2 == str3" << endl;

	//if (str2 != str3)
	//	cout << "str2 != str3" << endl;

	//if (str1 == str3)
	//	cout << "str1 == str3" << endl;

	//if (str1 != str3)
	//	cout << "str1 != str3" << endl;

	cout << "============================== 크기 비교 연산자 ================================" << endl;

	//if (str1 < str2)
	//	cout << "str1 < str2" << endl;

	//if (str1 <= str2)
	//	cout << "str1 <= str2" << endl;

	//if (str1 > str2)
	//	cout << "str1 > str2" << endl;

	//if (str1 >= str2)
	//	cout << "str1 >= str2" << endl;


	//if (str2 < str3)
	//	cout << "str2 < str3" << endl;

	//if (str2 <= str3)
	//	cout << "str2 <= str3" << endl;

	//if (str2 > str3)
	//	cout << "str2 > str3" << endl;

	//if (str2 >= str3)
	//	cout << "str2 >= str3" << endl;

	//if (str1 < str3)
	//	cout << "str1 < str3" << endl;

	//if (str1 <= str3)
	//	cout << "str1 <= str3" << endl;

	//if (str1 > str3)
	//	cout << "str1 > str3" << endl;

	//if (str1 >= str3)
	//	cout << "str1 >= str3" << endl;

	cout << "============================== find ================================" << endl;

	/*MyString str4 = "0123456789";
	MyString str5 = "0123";
	cout << str4.find(0, str5) << endl;*/

	cout << "============================== substr ================================" << endl;

	MyString str1 = "sfdhauisrhfiosdfhgo;ardhgtpoeirhgnvdbf;gourehpg";
	cin >> str1;
	cout << str1;
	cout << str1.substr(10, 100);


	cout << "============================== insert =============================" << endl;

	//MyString str7 = str6.insert(10, "abcqwertopasdfghkl zcnm");
	//cout << str7;

	
	
	cout << "============================== replace =============================" << endl;


	//MyString str3("0123456789");
	//MyString str4("0123456789");
	//MyString str5("0123456789");
	//MyString str6("0123456789");
	//MyString str7("0123456789");
	//MyString str8("0123456789");
	//MyString str9("0123456789");
	//MyString str10("0123456789");
	//MyString str11("0123456789");
	//MyString str12("0123456789");
	//MyString str13("0123456789");
	//MyString str14("0123456789");
	//MyString str15("0123456789");
	//MyString str16("0123456789");
	//MyString str17("0123456789");
	//MyString str18("0123456789");


	//cout << str13.replace(0, 0, " qwertyuiopasdfghjklzxcvbnm ") << endl;  // qwertyuiopasdfghjklzxcvbnm 0123456789                                 
	//cout << str14.replace(0, -1, " qwertyuiopasdfghjklzxcvbnm ") << endl; //  qwertyuiopasdfghjklzxcvbnm                                         
	//cout << str15.replace(0, 5, " qwertyuiopasdfghjklzxcvbnm ") << endl; //  qwertyuiopasdfghjklzxcvbnm 56789     
	//cout << str16.replace(0, 9, " qwertyuiopasdfghjklzxcvbnm ") << endl; //  qwertyuiopasdfghjklzxcvbnm 9 
	//cout << str17.replace(0, 10, " qwertyuiopasdfghjklzxcvbnm ") << endl; //  qwertyuiopasdfghjklzxcvbnm
	//cout << str18.replace(0, 14, " qwertyuiopasdfghjklzxcvbnm ") << endl; //  qwertyuiopasdfghjklzxcvbnm        

	//cout << str3.replace(4, -1, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123 qwertyuiopasdfghjklzxcvbnm    
	//cout << str4.replace(4, 5, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123 qwertyuiopasdfghjklzxcvbnm 9
	//cout << str5.replace(4, 9, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123 qwertyuiopasdfghjklzxcvbnm
	//cout << str6.replace(4, 10, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123 qwertyuiopasdfghjklzxcvbnm
	//cout << str7.replace(4, 14, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123 qwertyuiopasdfghjklzxcvbnm


	//cout << str8.replace(10, -1, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123456789 qwertyuiopasdfghjklzxcvbnm
	//cout << str9.replace(10, 5, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123456789 qwertyuiopasdfghjklzxcvbnm
	//cout << str10.replace(10, 9, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123456789 qwertyuiopasdfghjklzxcvbnm
	//cout << str11.replace(10, 10, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123456789 qwertyuiopasdfghjklzxcvbnm
	//cout << str12.replace(10, 14, " qwertyuiopasdfghjklzxcvbnm ") << endl; // 0123456789 qwertyuiopasdfghjklzxcvbnm
	cout << "============================== erase =============================" << endl;

	MyString str6 = "0123456789 123456789 01234567890";
	MyString str7 = str6.erase(0, 90);
	cout << str7;

	return 0;
}


