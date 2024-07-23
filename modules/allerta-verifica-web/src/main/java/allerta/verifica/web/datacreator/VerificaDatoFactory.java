package allerta.verifica.web.datacreator;

import java.util.ArrayList;
import java.util.List;

import allerta.verifica.model.VerificaDato;
import it.eng.allerter.model.Allerta;

public class VerificaDatoFactory {
	
	public static List<VerificaDatoCreator> creators;
	
	static {
		
		creators = new ArrayList<VerificaDatoCreator>();
		
		creators.add(new CreatorPrecipitazioni());
		creators.add(new CreatorFenomeni());
		
	}
	
	public static List<VerificaDato> initializeVerifica(Allerta a, List<VerificaDato> datiAttuali) {
		for (VerificaDatoCreator vdc: creators) {
			if (vdc.shouldExecute(a,datiAttuali))
				datiAttuali = vdc.execute(a, datiAttuali);
		}
		return datiAttuali;
	}

}
