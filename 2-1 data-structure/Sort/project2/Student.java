package project2;

public class Student implements Comparable
{
	private int kor;
	private int math;
	private int eng;
	private int history;
	private int science;
	
	public Student(int kor, int math, int eng, int history, int science)
	{
		this.math = math;
		this.eng = eng;
		this.history = history;
		this.science = science;
	}
	
	public double getAvg()
	{
		return (kor + math + eng + history + science) / 5;
	}

	@Override
	public int compareTo(Object a) {
		// TODO Auto-generated method stub
		if(this.getAvg() < ((Student) a).getAvg())
			return -1;
		else if (this.getAvg() > ((Student) a).getAvg())
			return 1;
		else 
			return 0;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getAvg());
        
        return sb.toString();
    }
}
