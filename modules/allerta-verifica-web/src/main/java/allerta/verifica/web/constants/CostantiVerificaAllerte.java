package allerta.verifica.web.constants;

import java.util.HashMap;
import java.util.Map;

public class CostantiVerificaAllerte {
	
	public static final String[] PRECIPITAZIONI = {" ","assenti","non significative","deboli","moderate","elevate"};
	public static final String[] COLORI = {" ","VERDE","GIALLO","ARANCIONE","ROSSO"};
	public static final String[] CORRETTEZZA = {" ","C","PC","FA","MA"};
	public static final String[] MAGNITUDO = {" ","+","++","-","--"};
	public static final String[] LOCALIZZAZIONE = {" ","+","++","-","--"};
	public static final String[] CAUSE = {" ","F+","F-","P"};
	
	public static final String[] EVENTI = {"CRITICITA' IDRAULICA","CRITICITA' IDROGEOLOGICA","CRITICITA' TEMPORALI","VENTO","TEMPERATURE ESTREME","NEVE","PIOGGIA CHE GELA","STATO DEL MARE","CRITICITA' COSTIERA"};
	
	public static final String[] ZONE = {"A","B","C","D","E","F","G","H"};
	public static final String[] SOTTOZONE = {"A1","A2","B1","B2","C1","C2","D1","D2","D3","E1","E2","F1","F2","F3","G1","G2","H1","H2"};
	public static final String[] SOTTOZONE_COSTA = {"B2","D2"};

	public static Map<String, String[]> EVENTI_COLONNE;
	public static Map<String, String> NOMI_COLONNE;
	public static Map<String, String> TIPI_COLONNE;
	
	static {
		EVENTI_COLONNE = new HashMap<String, String[]>();
		EVENTI_COLONNE.put("1", new String[]{"soglie_idro"});
		EVENTI_COLONNE.put("2", new String[]{"numero_frane"});
		EVENTI_COLONNE.put("3", new String[]{"soglie_pluvio",/*"social",*/"rilevazioni","dewetra"});
		EVENTI_COLONNE.put("4", new String[]{"soglie_vento","intensita_vento","raffiche_vento"});
		EVENTI_COLONNE.put("5", new String[]{"temperature_osservate"});
		EVENTI_COLONNE.put("6", new String[]{"neve_osservata"});
		EVENTI_COLONNE.put("7", new String[]{"pioggiagela_osservata"});
		EVENTI_COLONNE.put("8", new String[]{"altezza_onda_max"});
		EVENTI_COLONNE.put("9", new String[]{"onda_cesenatico","onda_garibaldi"});
		
		NOMI_COLONNE = new HashMap<String, String>();
		TIPI_COLONNE = new HashMap<String, String>();
		NOMI_COLONNE.put("soglie_idro", "Superamenti soglie idro");
		NOMI_COLONNE.put("numero_frane", "N° frane registrate");
		NOMI_COLONNE.put("soglie_pluvio", "Superamenti soglie pluvio - cumulate max mm/h");
		NOMI_COLONNE.put("social", "Segnalazioni SIMC / Tweet");
		NOMI_COLONNE.put("rilevazioni", "Rilevazioni da Radar/ Satellite/ Fulminazioni");
		NOMI_COLONNE.put("dewetra", "Segnalazioni Dewetra/IT-Alert");
		NOMI_COLONNE.put("soglie_vento", "Superamenti raffiche");
		NOMI_COLONNE.put("intensita_vento", "Vento medio");
		NOMI_COLONNE.put("raffiche_vento", "Vento massimo");
		NOMI_COLONNE.put("soglie_temperature", "Superamenti soglie");
		NOMI_COLONNE.put("temperature_osservate", "Temperature osservate");
		NOMI_COLONNE.put("soglie_neve", "Superamenti soglie");
		NOMI_COLONNE.put("neve_osservata", "Neve osservata");
		NOMI_COLONNE.put("pioggiagela_osservata", "Pioggia che gela osservata");
		NOMI_COLONNE.put("altezza_onda_max", "Altezza onda max osservata");
		NOMI_COLONNE.put("onda_cesenatico", "Altezza onda max osservata");
		NOMI_COLONNE.put("onda_garibaldi", "Altezza livello mare max osservata"); 
	}
}
