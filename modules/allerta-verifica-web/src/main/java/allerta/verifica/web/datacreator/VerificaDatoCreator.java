package allerta.verifica.web.datacreator;

import java.util.List;

import allerta.verifica.model.VerificaDato;
import it.eng.allerter.model.Allerta;

public interface VerificaDatoCreator {
	
	boolean shouldExecute(Allerta a, List<VerificaDato> datiCorrenti);
	List<VerificaDato> execute(Allerta a, List<VerificaDato> datiCorrenti);

}
