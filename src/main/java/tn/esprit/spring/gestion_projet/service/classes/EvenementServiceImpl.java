package tn.esprit.spring.gestion_projet.service.classes;


import tn.esprit.spring.gestion_projet.service.interfaces.IEvenemntService;

public class EvenementServiceImpl implements IEvenemntService {
/*@Autowired
ParticipantRepository partRep;
@Autowired
EvenementRepository evenRep ;
//1ère méthode d'affectation avec la signature Evenement ajoutAffectEvenParticip(Evenement e, int idParticip)
	@Override
	public Evenement ajoutAffectEvenParticip(Evenement e, int idParticip) {
		Participant p= partRep.findById(idParticip).get();
		Evenement savedEvent=evenRep.findById(e.getId()).get();
		List<Participant> pts;
		
		if(savedEvent.getParticipants() == null){
			pts=new ArrayList<>();
		}
		else 
			{pts= savedEvent.getParticipants();}

			pts.add(p);
			e.setParticipants(pts);
		evenRep.save(e);
		return e;
	}
	

//2ème méthode d'affectation avec la signature: Evenement ajoutAffectEvenParticip(Evenement e)

	@Override
	public Evenement ajoutAffectEvenParticip(Evenement e) {
			evenRep.save(e);
			return e;
		}

 */
	}
	
	

	

