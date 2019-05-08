package DTO;

public class Product {
	private int no; // PRODUCT_SEQ ���
	private String name;
	private String purchase_date;// ���Գ�¥
	private int price; // ����
	private int type; // ��ǰ�� ���� ���� product_type ���̺� ����
	private int stock; // ��� ����
	private String imgaddress;

	public Product() {
		super();
	}

	public Product(int no, String name, String purchase_date, int price, int type, int stock, String imgaddress) {
		super();
		this.no = no;
		this.name = name;
		this.purchase_date = purchase_date;
		this.price = price;
		this.type = type;
		this.stock = stock;
		this.imgaddress = imgaddress;
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

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgaddress() {
		return imgaddress;
	}

	public void setImgaddress(String imgaddress) {
		this.imgaddress = imgaddress;
	}

}
