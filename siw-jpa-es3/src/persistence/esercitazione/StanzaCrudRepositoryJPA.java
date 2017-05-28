package persistence.esercitazione;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.esercitazione.Stanza;
import persistence.CrudRepositoryJPA;

import java.util.*;

public class StanzaCrudRepositoryJPA extends CrudRepositoryJPA<Stanza> {

	public StanzaCrudRepositoryJPA(EntityManager em) {
		super(em, Stanza.class);
	}

	public List<Stanza> findStanzeByPiano(String piano) {
		TypedQuery<Stanza> query = getEm().createQuery("SELECT s FROM Stanza s WHERE s.piano = " + piano, Stanza.class);
		return query.getResultList();
	}
}