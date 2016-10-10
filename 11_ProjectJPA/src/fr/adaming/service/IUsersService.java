package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Users;

public interface IUsersService {
	
	public void AjouterService(Users us);
	
	public void MiseAJourService(Users us);
	
	public void SupprimerService(Users us);
	
	public List<Users> getAllUserService();
	
	public Users UsersGetByIdService(int id_us);

}
