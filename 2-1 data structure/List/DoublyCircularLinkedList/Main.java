package DataStructure.DoublyCircularLinkedList;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList sList = new StudentList();

        try {
            File file = new File(args[0]);
            if (!file.exists())
                file.createNewFile();

            readFile(file, sList);
            displayMenu();

            while (true) {
                System.out.print("원하는 기능을 선택하세요. : ");
                int menu = sc.nextInt();
                handleMenu(file, menu, sc, sList);
                if (menu == 6)
                    return;
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();

    }

    public static void displayMenu()
    {
        System.out.println("==========================");
        System.out.println("(1) 새 학생 입력");
        System.out.println("(2) 학생 삭제");
        System.out.println("(3) 학번 순으로 전체 출력");
        System.out.println("(4) 학번 역순으로 전체 출력");
        System.out.println("(5) 특정 학번부터 전체 출력");
        System.out.println("(6) 파일에 저장하고 종료");
        System.out.println("==========================");
    }

    public static void handleMenu(File file, int menu, Scanner sc, StudentList sList)
    {
        switch (menu)
        {
            case 1:
                sc.nextLine();
                System.out.print("학번과 이름을 입력하세요. : ");
                generateStudent(sList, sc.nextLine());
                break;
            case 2:
                removeStudent(sList, sc);
                sc.nextLine();
                break;
            case 3:
                retrieveAll(sList, 3, -1);
                break;
            case 4:
                retrieveAll(sList, 4, -1);
                break;
            case 5:
                System.out.print("학번을 입력하세요 : ");
                retrieveAll(sList, 5, sc.nextInt());
                break;
            case 6:
                saveFile(file, sList);
                break;
            default:
                System.out.println("올바른 메뉴 번호를 입력해주세요.");
        }
    }

    private static void saveFile(File file, StudentList sList)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(String.valueOf(sList));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(File file, StudentList sList)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while((line = br.readLine()) != null)
                generateStudent(sList, line);

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveAll(StudentList sList, int menu, int id)
    {
        if(sList.isEmpty()) {
            System.out.println("학생 리스트가 비어있습니다.");
            return;
        }

        if(menu==3)
            System.out.println(sList);
        else if(menu==4)
            System.out.println(sList.retriveReverseAll());
        else if(menu==5)
            System.out.println(sList.retrieveAllFromCertainId(id));
    }

    private static void generateStudent(StudentList sList, String input)
    {
        try {
            String[] array;
            array = input.split(" ");

            if (array.length < 2) //학번만 입력된 경우
                throw new InputMismatchException();

            Student student = new Student(Integer.parseInt(array[0]), array[1]);

            if (!sList.add(student))
                System.out.println("중복된 학번의 학생이 존재합니다.");

        } catch (NumberFormatException e) {
                System.out.println("학번을 숫자로 입력해주세요.");
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private static void removeStudent(StudentList sList, Scanner sc)
    {
        try {
            System.out.print("학번을 입력하세요. : ");
            if(!sList.remove(sc.nextInt()))
                System.out.println("해당 학번의 학생이 존재하지 않습니다.");

        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
