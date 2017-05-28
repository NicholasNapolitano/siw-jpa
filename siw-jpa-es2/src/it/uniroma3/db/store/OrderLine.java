package it.uniroma3.db.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_line")

    
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private Integer quantity;
	
	@Column(nullable=true)
	private Float unitPrice;
	
	@ManyToOne
	private Product product;
	
	public OrderLine(){
		
	}
	
	public OrderLine(Long id, Integer quantity, Float price){
		this.id=id;
		this.quantity=quantity;
		this.unitPrice=price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public boolean equals(Object obj) {
        OrderLine orderLine = (OrderLine)obj;
        return this.getQuantity().equals(orderLine.getQuantity())&&this.getUnitPrice().equals(orderLine.getUnitPrice());
    }

    public int hashCode() {
         return this.getQuantity().hashCode()+this.getUnitPrice().hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OrderLine"); 
                sb.append("{id=").append(id); 
                sb.append(", quantity='").append(quantity);  
                sb.append(", unitPrice='").append(unitPrice);
                sb.append("}\n");
        return sb.toString();
    }
	
	
	

}
