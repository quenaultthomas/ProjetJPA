package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.AgentDaoImpl;
import fr.adaming.dao.IAgentDao;
import fr.adaming.dao.IUsersDao;
import fr.adaming.dao.UsersDaoImpl;
import fr.adaming.model.Users;

public class UsersServiceImpl implements IUsersService {

	private IUsersDao usersDao = new UsersDaoImpl();
	
	@Override
	public void AjouterService(Users us) {
		 usersDao.AjouterDAO(us);
	}

	@Override
	public void MiseAJourService(Users us) {
		usersDao.MiseAJourDAO(us);
	}

	@Override
	public void SupprimerService(Users us) {
		usersDao.SupprimerDAO(us);
	}

	@Override
	public List<Users> getAllUserService() {
		return usersDao.getAllUserDAO();
	}

	@Override
	public Users UsersGetByIdService(int id_us) {
		return usersDao.UsersGetByIdDAO(id_us);
	}

}
