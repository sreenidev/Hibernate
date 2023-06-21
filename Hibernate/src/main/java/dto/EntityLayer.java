package dto;

import javax.persistence.*;

@Entity (name = "Student_Details")
public class EntityLayer {
	@Id
	private int std_id;
	private String std_name;
	@Column(nullable = false)
	private Long std_phno;

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public Long getStd_phno() {
		return std_phno;
	}

	public void setStd_phno(Long std_phno) {
		this.std_phno = std_phno;
	}

	@Override
	public String toString() {
		return "EntityClass [std_id=" + std_id + ", std_name=" + std_name + ", std_phno=" + std_phno + "]";
	}

}
