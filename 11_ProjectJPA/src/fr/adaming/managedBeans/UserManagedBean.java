package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
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
		
	private Agent agent;
	HttpSession session;
	
	IUsersService userService = new UsersServiceImpl();
	
	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		agent=(Agent) session.getAttribute("agent");
	}

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
		
		users.setAgent(agent);
		
		userService.AjouterService(users);
		
		List<Users> listeUsers=new ArrayList<Users>();
		listeUsers = userService.AllUsersGetByIdAgentService(agent.getId_agent());
		
		session.setAttribute("listeUsers", listeUsers);
		return "afficher";
	}
	
	public String rechercher(){
			
		users.setAgent(agent);
		System.out.println("l'agent esgt : " + agent);
		users = userService.UsersGetByIdService(users.getId());
		System.out.println("le users est : " + users);
		List<Users> listeUsers=new ArrayList<Users>();
		listeUsers = userService.AllUsersGetByIdAgentService(agent.getId_agent());
		
		session.setAttribute("listeUsers", listeUsers);
		
	
		return "#";
		
	}
	
	public String supprimer(){
		users.setAgent(agent);
		userService.SupprimerService(users);
		
		List<Users> listeUsers=new ArrayList<Users>();
		listeUsers = userService.AllUsersGetByIdAgentService(agent.getId_agent());
		
		session.setAttribute("listeUsers", listeUsers);
		
		
		return "afficher";
	}
	
	public String modifier(){
		
		users.setAgent(agent);
		userService.MiseAJourService(users);
		List<Users> listeUsers=new ArrayList<Users>();
		listeUsers = userService.AllUsersGetByIdAgentService(agent.getId_agent());
		
		session.setAttribute("listeUsers", listeUsers);
		
		
		return "afficher";
	}
	
	
		
	}



