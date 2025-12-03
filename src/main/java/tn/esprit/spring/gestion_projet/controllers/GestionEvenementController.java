package tn.esprit.spring.gestion_projet.controllers;





	//@RestController
	//@RequestMapping("/Evenement")
	public class GestionEvenementController {

/*	@Autowired
	IEvenemntService evenServ;
	@Autowired
	IParticipantService partServ;
	@Autowired
	ILogistiqueService logisServ;
	//Question 1
	//http://localhost:8082/GestionEvenement/Evenement/add-Participant
		@PostMapping("/add-Participant")
		public Participant addParticipant(@RequestBody Participant p)
		{
		partServ.ajouterParticipant(p);
		return(p);
		}
		//Question 2- 1ère signature
		//http://localhost:8082/GestionEvenement/Evenement/add-Affect-Event/1
		@PostMapping("/add-Affect-Event/{idParticip}")
		public Evenement addAffectEventParticipant (@RequestBody Evenement e, @PathVariable("idParticip") int idParticip) 
		{
			evenServ.ajoutAffectEvenParticip(e, idParticip);
			return e;
		}
		//Question 2- 2ère signature
		@PostMapping("/add-Affect-Event-To-Participant")
		public Evenement addAffectEventParticipant (@RequestBody Evenement e) 
		{
			evenServ.ajoutAffectEvenParticip(e);
			return e;
		}
		//Question 3
		//http://localhost:8082/GestionEvenement/Evenement/add-Affect-LogEvent/Festival Medina
		@PostMapping("/add-Affect-LogEvent/{descript}")
		public Logistique addAffectLogEvnm (@RequestBody Logistique l,  @PathVariable("descript") String description_evnm) 
		{
			logisServ.ajoutAffectLogEven(l, description_evnm);
			return l;
		}
		
		//Question 4
		//http://localhost:8082/GestionEvenement/Evenement/retrieveLogistiquesDates/2023-01-01/2023-06-01
		@GetMapping("/retrieveLogistiquesDates/{dateD}/{dateF}")
		public List <Logistique> retrieveLogistiquesDates (@PathVariable("dateD") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDb, @PathVariable("dateF") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin)
		
		{
			return logisServ.getLogistiquesDates (dateDb, dateFin);
		}
		//Question 5
		//http://localhost:8082/GestionEvenement/Evenement/retrieveLogistiquesDates/2023-01-01/2023-06-01
		@GetMapping("/getParticipantsLogis")
		public List <Participant> getParReservLogis ( )
		{
			return partServ.getParReservLogis();
			}

 */
		
		
		
	
}
