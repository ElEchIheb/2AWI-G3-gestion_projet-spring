package tn.esprit.spring.gestion_projet.service.classes;


import tn.esprit.spring.gestion_projet.service.interfaces.ILogistiqueService;

public class LogistiqueServiceImpl implements ILogistiqueService {
/*	@Autowired
	EvenementRepository evenRep;
	@Autowired
	LogistiqueRepository logistiqueRepository;
	
	
	@Override
	public Logistique ajoutAffectLogEven(Logistique l, String description_evnm) {
		Evenement e = evenRep.findByDescription(description_evnm);
		List<Logistique> logis;
		if (e.getLogistiques() == null) {
		    logis = new ArrayList<>();
		} 
		else {
			logis= e.getLogistiques();}
			logistiqueRepository.save(l);
			logis.add(l);
			e.setLogistiques(logis);
			evenRep.save(e);
			return l;
	}

	@Override
	public List<Logistique> getLogistiquesDates(Date dated, Date datef) {
		List <Evenement> events = evenRep.findByDatedBetween(dated, datef);
		List <Logistique> allLogists=new ArrayList<>();
		for (Evenement e: events)
		{
			for(Logistique l: e.getLogistiques())
			{if (l.isReserve())
			allLogists.add(l);
		 }
}
		return allLogists;}
 */
		}

	
	

	