package DTO;

public class Orders {
	private String id;// member ����
	private int no; //�ŷ� ��ȣ
	private int quantity; // ���ż���
	private String s_date; // ���� ��¥ sale date
	private int p_no;// product ����
	public Orders() {
		super();
	}

	public Orders(String id, int no, int quantity, String s_date,int p_no) {
		super();
		this.id = id;
		this.no = no;
		this.p_no=p_no;
		this.quantity = quantity;
		this.s_date = s_date;
	}

	/**
	 * @return the p_no
	 */
	public int getP_no() {
		return p_no;
	}

	/**
	 * @param p_no the p_no to set
	 */
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

}
