package fr.adaming.dao;

import fr.adaming.model.Agent;

public interface IAgentDao {
	
	public int isExistDAO(String login, String mdp);

	Agent AgentGetByIdDAO(String login, String mdp);

}
