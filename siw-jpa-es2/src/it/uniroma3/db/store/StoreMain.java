package it.uniroma3.db.store;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class StoreMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("store-unit");
		EntityManager em = emf.createEntityManager();

		Address address = new Address();
		address.setCity("Roma");
        address.setCountry("Lazio");
        address.setState("Italia");
        address.setStreet("Via Vasca Navale");
        address.setZipcode("12345");
        
        Customer customer = new Customer();
        customer.setFirstName("Paolo");
        customer.setLastName("Merialdo");
        customer.setEmail("Merialdo@mail.it");
        customer.setPhoneNumber("555-9876");
        customer.setDateOfBirth(new Date());
        customer.setRegistrationDate(new Date());
        
        Provider provider = new Provider();
		provider.setName("provider");
		provider.setPhoneNumber("555-0123");
		provider.setEmail("provider@mail.it");
		provider.setVatin("vatin");
		
		Order order = new Order();
		order.setCreationTime(new Date());
		
		OrderLine orderline = new OrderLine();
		orderline.setQuantity(new Integer(3));
	    orderline.setUnitPrice(3.5F);
	    
	    Product product = new Product();
	    product.setName("Prodotto");
		product.setDescription("Coca Cola");
		product.setPrice(5.0F);
		
		List<Product> prodotti = new ArrayList<Product>();
		prodotti.add(product);
		provider.setProducts(prodotti);
		
		List<Provider> fornitori = new ArrayList<Provider>();
		fornitori.add(provider);
		product.setProviders(fornitori);
		
		customer.setAddress(address);
		provider.setAddress(address);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(customer);
		em.persist(provider);
		em.persist(order);
		em.persist(product);
		tx.commit();

		em.close();
		emf.close();
	}
}
