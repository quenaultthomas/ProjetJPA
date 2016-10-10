package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "agent")

@NamedQueries({
	@NamedQuery(name="getAgent", query="SELECT u FROM Agent as u WHERE u.mail=:mail and u.mdp=:mdp"),
	})
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_agent;
	@Column(name = "mail")
	private String mail;
	@Column(name = "password")
	private String mdp;
	
	/**
	 * Empty Constructor
	 */
	public Agent() {
		super();
	}

	/**
	 * Constructors without id
	 * 
	 * @param mail
	 * @param mdp
	 */
	public Agent(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	/**
	 * Constructors with id
	 * 
	 * @param id_agent
	 * @param mail
	 * @param mdp
	 */
	public Agent(int id_agent, String mail, String mdp) {
		super();
		this.id_agent = id_agent;
		this.mail = mail;
		this.mdp = mdp;
	}

	/**
	 * Getters ans Setters declaration
	 */
	
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
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * ToString() declaration
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [id_agent=" + id_agent + ", mail=" + mail + ", mdp="
				+ mdp + "]";
	}

	
}
