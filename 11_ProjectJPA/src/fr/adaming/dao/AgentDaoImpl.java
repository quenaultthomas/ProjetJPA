package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.adaming.model.Agent;


public class AgentDaoImpl implements IAgentDao {

	
	@Override
	public int isExistDAO(String login, String mdp) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		
		Query queryAgentIsExist = em.createNamedQuery("getAgent");
		queryAgentIsExist.setParameter("mail",login);
		queryAgentIsExist.setParameter("mdp",mdp);
		
		@SuppressWarnings("unchecked")
		List<Agent> listeAgent = queryAgentIsExist.getResultList();
		
		System.out.println(listeAgent.size());
		
		return listeAgent.size();
	}
}
