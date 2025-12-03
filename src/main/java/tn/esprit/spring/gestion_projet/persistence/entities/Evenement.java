package tn.esprit.spring.gestion_projet.persistence.entities;


import java.io.Serializable;

/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

 */
public class Evenement implements Serializable {
	/**
	 * 

	private static final long serialVersionUID = 1L;
	

	private int id;
	private String description;

	private Date dated;

	private Date datef;
	private float cout;
	@ManyToMany
	List <Participant> participants;
	@OneToMany
	@JsonIgnore
	List <Logistique> logistiques;

	 */
}
