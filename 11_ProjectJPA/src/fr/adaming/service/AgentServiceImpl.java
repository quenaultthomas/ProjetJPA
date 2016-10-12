package fr.adaming.service;

import fr.adaming.dao.AgentDaoImpl;
import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

public class AgentServiceImpl implements IAgentService{

	IAgentDao agentDao = new AgentDaoImpl();
	
	@Override
	public int isExistService(String login, String mdp) {
	
		return agentDao.isExistDAO(login, mdp);
	}

	@Override
	public Agent AgentGetByIdService(String login, String mdp) {
		return agentDao.AgentGetByIdDAO(login,mdp);
	}

}
