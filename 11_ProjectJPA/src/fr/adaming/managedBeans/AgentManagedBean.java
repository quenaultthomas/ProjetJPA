package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;










import org.eclipse.persistence.sessions.Session;

import fr.adaming.model.Agent;
import fr.adaming.model.Users;
import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUsersService;
import fr.adaming.service.UsersServiceImpl;


@ManagedBean(name="agentMB")
@RequestScoped
public class AgentManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_agent;
	private String mail;
	private String password;
	
	private List<Users> userslist ;
	
	HttpSession session;
	
	IAgentService agentService = new AgentServiceImpl();
	IUsersService userService = new UsersServiceImpl();
	

	/**
	 * 
	 */
	public AgentManagedBean() {
		userslist=userService.AllUsersGetByIdAgentService(id_agent);
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
	

	/**
	 * @return the id_agent
	 */
	public int getId_agent() {
		return id_agent;
	}

	/**
	 * @param id_agent the id_agent to set
	 */
	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}

	//Déclaration de la méthode de connexion
	public String connexion(){
				

		
		int verif=agentService.isExistService(mail, password);
		
		if (verif!=1){
			return "erreur";
			
		} else {
			Agent agent = agentService.AgentGetByIdService(mail, password);	
			System.out.println("agent " + agent);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);
			userslist=userService.AllUsersGetByIdAgentService(agent.getId_agent());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeUsers", userslist);
			return "connexion";
		}
	}
	
	public String deconnecter(){
		
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext() 
				.getSession(true)).invalidate();
		return "deco";
		
		
		}
		
	}


