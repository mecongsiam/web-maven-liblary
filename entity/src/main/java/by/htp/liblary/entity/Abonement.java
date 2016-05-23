package by.htp.liblary.entity;

public class Abonement {

	private int idAbonement;
	private String login;
	private String name;
	private String surname;
	private String email;
	private String address;
	private String phone;

	public int getIdAbonement() {
		return idAbonement;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setIdAbonement(int idAbonement) {
		this.idAbonement = idAbonement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
