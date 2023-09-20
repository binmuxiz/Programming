package DataStructure.SinglyLinkedList;

class Student
{
    private String name;
    private int id;
    private ClubList club;

    Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    Student(int id, String name, ClubList club)
    {
        this.id = id;
        this.name = name;
        this.club = club;
    }

    void setId(int id) { this.id = id; }
    void setName(String name) { this.name = name; }
    void setClub(ClubList club) { this.club = club; }
    int getId() { return id; }
    String getName() { return name; }
    ClubList getClub() { return club; }

    public String toString()
    {
        if(club==null)
            return id+" "+name;
        else
            return id+" "+name+" "+club;
    }

}
