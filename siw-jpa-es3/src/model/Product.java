package model;

import javax.persistence.*;

import java.util.*;

@Entity
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private Float price;
	@Column(length = 2000)
	private String description;
	@Column(unique = true, nullable = false)
	private String code;

	@ManyToMany(mappedBy="products", fetch = FetchType.LAZY)
	private List<Provider> providers;
	
	public Product() {
		this.providers = new ArrayList<>();
	}

	public Product(String name, Float price, String description, String code) {
		this.providers = new ArrayList<>();
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
	}

	//          Getters & Setters        

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public Float getPrice() {
		return this.price;
	}

	public String getDescription() {
		return this.description;
	}

	public String getCode() {
		return this.code;
	}
	
	//NO setID perché viene generato automaticamente ed è un campo univoco

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.getCode().equals(product.getCode());
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Product"); 
		sb.append("{id=").append(id); 
		sb.append(", name='").append(name);
		sb.append(", price=").append(price);
		sb.append(", description='").append(description); 
		sb.append(", code='").append(code); 
		sb.append("}\n");
		return sb.toString();
	}
	
}


