package DataStructure.SinglyLinkedList;

import java.util.StringTokenizer;

class ClubList extends SinglyLinkedList<String>
{
    ClubList(String clubs)
    {
        StringTokenizer st = new StringTokenizer(clubs, "/");
        while(st.hasMoreTokens()) {
            String str = st.nextToken().trim();
            if (str.equals(""))
                continue;
            addFirst(str.trim());
        }
    }

    public String toString()
    {
        if(size == 0)
            return "";

        String str = "";
        Node<String> club = head;

        for(int i=0; i<size-1; i++, club=club.getNext())
            str += club+"/";

        str += club;
        return str;
    }
}
