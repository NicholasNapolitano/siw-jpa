package model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"firstname","lastname"}))
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@Temporal (TemporalType.DATE)
	private Date dateOfBirth;
	@Temporal (TemporalType.DATE)
	private Date registrationDate;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Order> orders;

	public Customer() {
		this.orders = new ArrayList<>();
	}

	public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth,
			Date registrationDate) {
		super();
		this.orders = new ArrayList<>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return Id;
	}

	public String getFirstName() {
		return firstName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getLastName() {
		return lastName;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
