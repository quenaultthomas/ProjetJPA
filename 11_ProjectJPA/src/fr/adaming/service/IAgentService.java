package fr.adaming.service;

import fr.adaming.model.Agent;

public interface IAgentService {
	
	public int isExistService(String login, String mdp);
	
	public Agent AgentGetByIdService(String login, String mdp);

}
