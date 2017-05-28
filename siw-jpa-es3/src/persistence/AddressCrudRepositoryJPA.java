package persistence;

import java.util.List;
import javax.persistence.*;
import model.Address;

public class AddressCrudRepositoryJPA implements AddressCrudRepository {
	private EntityManager em;
	
	public AddressCrudRepositoryJPA(EntityManager em) {
		this.em = em;
		
	}

	@Override
	public Address save(Address address) {
		if (address.getId() == null) {
			em.persist(address);
		} else {
			return em.merge(address);	//restituisce un oggetto managed
		}
		return address;
	}

	@Override
	public Address findOne(Long id) {
		return em.find(Address.class, id);
	}

	@Override
	public List<Address> findAll() {
		TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a", Address.class);
		return query.getResultList();
	}

	@Override
	public void delete(Address address) {
		em.remove(address);
	}

	@Override
	public void deleteAll() {
		Query query = em.createQuery("DELETE FROM Address");
		query.executeUpdate();
	}

}
