package persistence;

import model.Address;
import java.util.List;

public interface AddressCrudRepository {

	public Address save(Address address);
	public Address findOne(Long id);
	public List<Address> findAll();
	public void delete(Address address);
	public void deleteAll();
	
}
