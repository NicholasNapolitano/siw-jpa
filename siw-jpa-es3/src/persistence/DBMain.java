package persistence;

import java.util.List;

import javax.persistence.*;

import model.Address;
import model.Product;
import model.esercitazione.Artista;
import model.esercitazione.Stanza;

public class DBMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("es3-unit");
		EntityManager em = emf.createEntityManager();

		Product product = new Product();
		product.setName("KRIDDIG");
		product.setPrice(3.5F);
		product.setDescription("A wonderful bla bla");
		product.setCode("9781853262715-AA");

		Address address = new Address();
		CrudRepository<Address> addressRepository = new CrudRepositoryJPA<Address>(em, Address.class);

		address.setCity("Roma");
		address.setCountry("Italia");

		Artista a = new Artista();
		a.setNome("Marco");

		Stanza s = new Stanza();
		s.setNome("N11");

		CrudRepository<Artista> artistaRepository = new CrudRepositoryJPA<Artista>(em, Artista.class);
		CrudRepository<Stanza> stanzaRepository = new CrudRepositoryJPA<Stanza>(em, Stanza.class);

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		artistaRepository.save(a);
		List<Artista> artisti = artistaRepository.findAll();
		for (Artista artista : artisti) {
			System.out.println(artista.toString());
		}

		stanzaRepository.save(s);
		addressRepository.save(address);
		tx.commit();

		em.close();
		emf.close();
	}

}
