package DataStructure.SinglyLinkedList;

class StudentList extends SinglyLinkedList<Student>
{
    private Node<Student> searchPrevForAdd(int id)
    {
        Node<Student> prev = null;
        for(Node<Student> now = head;
            now != null;
            prev = now, now = now.getNext())
        {
            int nowId = now.getData().getId();

            if(id==nowId) // 같은 학번이 존재하는 경우
                throw new DuplicatedStudentIdException();
            if(id<nowId)
                return prev;
        }
        return prev; // 제일 마지막 노드
    }

    private Node<Student> searchPrevForRemove(int id)
    {
        for(Node<Student> now = head, prev = null;
            now != null;
            prev = now, now = now.getNext())
        {
            if(now.getData().getId()==id)
                return prev;
        }
        throw new NoSuchStudentIdException();
    }

    void add(Student st)
    {
        Node<Student> prevNode = searchPrevForAdd(st.getId());
        if(prevNode==null)
            addFirst(st);
        else
            addNext(st, prevNode);
    }

    void remove(int id)
    {
        if(isEmpty())
            return;

        Node<Student> prevNode = searchPrevForRemove(id);
        if(prevNode==null)
            removeFirst();
        else
            removeNext(prevNode);
    }

    public String toString()
    {
        String str = "";
        Node<Student> stNode = head;

        for(int i=0; i<size; i++, stNode=stNode.getNext())
            str += stNode + "\n";

        return str;
    }
}

class DuplicatedStudentIdException extends RuntimeException {
}

class NoSuchStudentIdException extends  RuntimeException {
}