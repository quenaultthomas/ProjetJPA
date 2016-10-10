package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Users;
import fr.adaming.service.IUsersService;
import fr.adaming.service.UsersServiceImpl;

@ManagedBean(name="userMB")
@SessionScoped
public class UserManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Users users;
	private List<Users> userlist;
		
	
	IUsersService userService = new UsersServiceImpl();


	/**
	 * 
	 */
	public UserManagedBean() {
		this.users = new Users();
	}


	/**
	 * @return the user
	 */
	public Users getUsers() {
		return users;
	}


	/**
	 * @param user the user to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
	/**
	 * @return the userlist
	 */
	public List<Users> getUserlist() {
		return userlist;
	}


	/**
	 * @param userlist the userlist to set
	 */
	public void setUserlist(List<Users> userlist) {
		this.userlist = userlist;
	}


	public String ajouter(){
		
		userService.AjouterService(users);
		return "afficher";
	}
	
	public String rechercher(){
			
		users = userService.UsersGetByIdService(users.getId());
	
		return "#";
		
	}
	
	public String supprimer(){
		
		userService.SupprimerService(users);
		return "afficher";
	}
	
	public String modifier(){
		userService.MiseAJourService(users);
		return "afficher";
	}
	
	
		
	}



