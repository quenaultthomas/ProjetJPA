package fr.adaming.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import javax.persistence.Query;

import fr.adaming.model.Users;

public class UsersDaoImpl implements IUsersDao {
	

	@Override
	public void AjouterDAO(Users us) {

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
				EntityManager em =emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				
				//Users newUser = new Users(us.getNom(), us.getPrenom(), us.getMail(), us.getPassword());
				//em.persist(newUser);
				
				em.persist(us);
				
				tx.commit();
				em.close();
				emf.close();
	}

	@Override
	public void MiseAJourDAO(Users us) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Users mergeUser = em.find(Users.class, us.getId());
		
		//Modification des parametres de la table 
		mergeUser.setNom(us.getNom());
		mergeUser.setPrenom(us.getPrenom());
		mergeUser.setMail(us.getMail());
		mergeUser.setPassword(us.getPassword());
		
	
		em.merge(mergeUser);

		tx.commit();
		em.close();
		emf.close();
	
	}

	@Override
	public void SupprimerDAO(Users us) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Récupérer un user de l'id 6
		Users delUser = em.find(Users.class, us.getId());
		
		// supprimer l'objet u
		em.remove(delUser);

		tx.commit();
		em.close();
		emf.close();
	}

	@Override
	public List<Users> getAllUserDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		
		Query queryUserList = em.createNamedQuery("getAllUsers");
				
		@SuppressWarnings("unchecked")
		List<Users> listeUser = queryUserList.getResultList();
		
		return listeUser;
		
	}

	@Override
	public Users UsersGetByIdDAO(int id_us) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Users searchUser = em.find(Users.class, id_us);
		return searchUser;
	}

	@Override
	public List<Users> AllUsersGetByIdAgentDao(int id_agent) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		
		Query queryUsersByIdAgent = em.createNamedQuery("getAllUsersByIdAgent");
		queryUsersByIdAgent.setParameter("id",id_agent);
	
		
		@SuppressWarnings("unchecked")
		List<Users> listeUsersByIdAgent = queryUsersByIdAgent.getResultList();
		System.out.println("UsersDAOImpl  111" + listeUsersByIdAgent);
		System.out.println("UsersDAOImpl  111" + listeUsersByIdAgent.size());
		return listeUsersByIdAgent;
	}
		
}
