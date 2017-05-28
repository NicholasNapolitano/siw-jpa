package model;

import javax.persistence.*;

import java.util.*;

@Entity
@NamedQuery(name = "allProviders", query = "Select p from Provider p")
public class Provider{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String phoneNumber;
	private String email;
	private String vatin;
	
	@ManyToMany(fetch = FetchType.LAZY/*, cascade = {CascadeType.PERSIST}*/)
	private List<Product> products;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	public Provider() {
		this.products = new ArrayList<>();
	}

	public Provider(String name, String phoneNumber, String email, String vatin) {
		this.products = new ArrayList<>();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vatin = vatin;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public void setName(String name) {
		this.name = name;
	}

}
