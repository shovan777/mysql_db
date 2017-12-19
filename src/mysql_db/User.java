package mysql_db;

public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    public String address;
    private Integer class_no;
    
       
	public User(int id, String first_name, String last_name, String address, Integer class_no) {
		this.getId();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.class_no = class_no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getClass_no() {
		return class_no;
	}
	public void setClass_no(Integer class_no) {
		this.class_no = class_no;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", class_no=" + class_no + "]";
	}
	
	
	
	
    
}
