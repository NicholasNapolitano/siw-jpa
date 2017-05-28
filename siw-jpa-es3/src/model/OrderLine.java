package model;

import javax.persistence.*;

@Entity
public class OrderLine{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Float unitPrice;
	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public OrderLine(Float unitPrice, Integer quantity) {
		super();
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public OrderLine() {}
	
}
