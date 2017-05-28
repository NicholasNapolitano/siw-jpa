package it.uniroma3.db.store;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.List;



	@Entity
	@Table(name="orders")
	public class Order {
        
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;
	
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "orders_id")
    private List<OrderLine> orderLines;
	
	@ManyToOne
	private Customer customer;

    public Order() {
    }
    
    public Order(Date date){
    	this.creationTime=date;
   }

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
    
    public boolean equals(Object obj) {
        Order order = (Order)obj;
        return this.getCreationTime().equals(order.getCreationTime());
    }

    public int hashCode() {
         return this.creationTime.hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Order"); 
                sb.append("{id=").append(id); 
                sb.append(", creationTime='").append(creationTime);  
                sb.append("}\n");
        return sb.toString();
    }

	}
	