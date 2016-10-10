package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;






import fr.adaming.model.Users;
import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUsersService;
import fr.adaming.service.UsersServiceImpl;


@ManagedBean(name="agentMB")
@ViewScoped
public class AgentManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String password;
	
	private List<Users> userslist ;
	
	IAgentService agentService = new AgentServiceImpl();
	IUsersService userService = new UsersServiceImpl();
	

	/**
	 * 
	 */
	public AgentManagedBean() {
		userslist=userService.getAllUserService();
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the list
	 */
	public List<Users> getUserslist() {
		return userslist;
	}

	/**
	 * @param list the list to set
	 */
	public void setUserslist(List<Users> userslist) {
		this.userslist = userslist;
	}

	//Déclaration de la méthode de connexion
	public String connexion(){
				

		
		int verif=agentService.isExistService(mail, password);
		
		if (verif!=1){
			return "erreur";
			
		} else {
			
			userslist=userService.getAllUserService();
			return "connexion";
		}
	}
	
	public String deconnecter(){
		
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext() 
				.getSession(true)).invalidate();
		return "deco";
		
		
		}
		
	}


