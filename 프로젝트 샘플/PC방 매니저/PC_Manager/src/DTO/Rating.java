package DTO;

public class Rating { //ȸ�����
	private int no; //RATING_SEQ ���
	private String name;

	public Rating() {
		super();
	}

	public Rating(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
