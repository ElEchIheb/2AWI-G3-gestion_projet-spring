package tn.esprit.spring.gestion_projet.persistence.entities;


import java.io.Serializable;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

 */
public class Logistique implements Serializable {
	/**
	 * 

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlog;
	private String description;
	private boolean reserve;
	private float prix;
	int quantite;
 */
}
