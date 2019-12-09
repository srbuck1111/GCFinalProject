package co.grandcircus.GCFinalProject.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.GCFinalProject.model.User;

@Repository
@Transactional
public class UserDao {

	
	@PersistenceContext
	private EntityManager eManager;

	public List<User> findAll() {
		return eManager.createQuery("FROM User", User.class).getResultList();
	}
	
	public User addOrUpdate(User u) {
		return eManager.merge(u);
	}
	
	public User findById(Integer primaryKey) { 
		return eManager.find(User.class, primaryKey); 
	}
	
	public void deleteById(Integer primaryKey) {
		eManager.remove(findById(primaryKey));
	}

}
