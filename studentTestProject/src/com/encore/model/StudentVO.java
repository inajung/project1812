package com.encore.model;

public class StudentVO {
	int studentID;
	String name;
	int major_id;
	String phone;
	String address;
	String hobby;
	String skill;
	public StudentVO() {
		
	}
	public StudentVO(int studentID, String name, int major_id, String phone, String address, String hobby,
			String skill) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.major_id = major_id;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.skill = skill;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentVO [studentID=").append(studentID).append(", name=").append(name).append(", major_id=")
				.append(major_id).append(", phone=").append(phone).append(", address=").append(address)
				.append(", hobby=").append(hobby).append(", skill=").append(skill).append("]");
		return builder.toString();
	}
 
 

}
