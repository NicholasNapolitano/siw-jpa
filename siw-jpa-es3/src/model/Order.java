package model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Long getId() {
		return id;
	}

	public Order(Date creationTime) {
		super();
		this.orderLines = new ArrayList<>();
		this.creationTime = creationTime;
	}
	
	public Order() {
		this.orderLines = new ArrayList<>();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
}
