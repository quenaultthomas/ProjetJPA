package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Users;

public interface IUsersDao {
	
	public void AjouterDAO(Users us);
	
	public void MiseAJourDAO(Users us);
	
	public void SupprimerDAO(Users us);
	
	public List<Users> getAllUserDAO();
	
	public Users UsersGetByIdDAO(int id_us);
	
	

}
