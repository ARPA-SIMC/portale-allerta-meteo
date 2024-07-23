package allerta.catasto.bean;

import com.liferay.portal.kernel.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class GeoLocator {

	static boolean created = false;

	public static String GEOCODER_URL = "https://servizigis.regione.emilia-romagna.it/normalizzatore/eGeoCoding?";

	// ---------------------------------------------------------------------------------------------
	HashMap<String, Object>  options;

	// ---------------------------------------------------------------------------------------------
	GeoLocator() {
		options = new HashMap<String, Object>();
	}

	// ---------------------------------------------------------------------------------------------
	// Options:
	// connector: RER, Google
	//
	// ---------------------------------------------------------------------------------------------
	public GeoLocator(HashMap<String, Object> options) {
		this.options = options;
	}

	// ---------------------------------------------------------------------------------------------
	public GeoLocator(String type) {
		this.options = new HashMap<String, Object>();
		try {
			this.options.put("connector", type);
		} catch (Exception e) {
			/* :) */ }
	}

	private String connect(String u, String payload) {

		try {
			System.out.println("connect " + u + " " + payload);
			URL url = new URL(u);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) con;
			http.setRequestMethod("POST"); // PUT is another valid option
			http.setDoOutput(true);
			http.setReadTimeout(20000);

			byte[] out = payload != null ? payload.getBytes(StandardCharsets.UTF_8)
					: "".getBytes(StandardCharsets.UTF_8);
			int length = out.length;

			http.setFixedLengthStreamingMode(length);
			http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			http.setRequestProperty("Accept", "application/json; charset=UTF-8");
			http.setRequestProperty("soapAction", u);
			System.out.println("Connecting");
			http.connect();
			OutputStream os = http.getOutputStream();
			System.out.println("Writing");
			os.write(out);
			System.out.println("Finished writing");
			String result = "";

			BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String decodedString;
			while ((decodedString = in.readLine()) != null) {
				System.out.println(decodedString);
				result += decodedString;

			}
			System.out.println("Result " + result);

			in.close();

			http.disconnect();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String login(String user, String pwd) {
		String payload = "{\"GetHandleInput\":{\"GetHandleInputParams\":{\"p_Username\":\"" + user
				+ "\",\"p_Userpassword\":\"" + pwd + "\"}}}";
		String data = connect(GEOCODER_URL + "serviceType=DBServices&serviceName=Normalizzatore&message=GetHandle",
				payload);
		if (data != null) {
			String[] spl = data.split("\"");
			for (int k = 0; k < spl.length; k++) {
				if (spl[k].equals("p_Handle")) {
					return spl[k + 2];
				}
			}
		}
		return null;
	}

	private HashMap<String, Object> query(String handle, HashMap<String, Object> params) {

		HashMap<String, Object> obj = new HashMap<String, Object>();

		try {
			String provincia = (String)params.get("provincia");
			String comune = (String)params.get("comune");
			String indirizzo = (String)params.get("indirizzo");
			String civico = (String)params.get("civico");
			if (civico == null || "".equals(civico))
				civico = "";

			String payload = "{\"norm_Indirizzo2Input\":{\"Norm_Indirizzo2InputParams\":{\"p_Toponimo\":\"__TOPONIMO__\""
					+ ",\"p_Civico\":\"__CIVICO__\",\"p_Comune\":\"__COMUNE__\",\"p_Provincia\":\"__PROVINCIA__\""
					+ ",\"p_Handle\":\"__HANDLE__\"}}}";
			payload = payload.replaceAll("__TOPONIMO__", indirizzo);
			payload = payload.replaceAll("__CIVICO__", civico);
			payload = payload.replaceAll("__COMUNE__", comune);
			payload = payload.replaceAll("__PROVINCIA__", provincia);
			payload = payload.replaceAll("__HANDLE__", handle);

			String data = connect(
					GEOCODER_URL + "serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Indirizzo2",
					payload);
			if (data == null)
				return null;
			String[] spl = data.split("\"");
			String lat = null;
			String lon = null;
			int numRighe = 0;

			for (int k = 0; k < spl.length; k++) {
				if (spl[k].toUpperCase().equals("TOTALRECORDS")) {
					numRighe = Integer.parseInt(spl[k + 2]);
				}
			}
			if (numRighe<0) numRighe = 0;
			obj.put("records", numRighe);
			if (numRighe > 0) {
				int index = 0;
				for (int k = 0; k < spl.length; k++) {

					if (spl[k].toUpperCase().equals("PROVINCIA")) {
						obj.put("provincia" + (index++), spl[k + 2]);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("COMUNE")) {
						obj.put("comune" + (index++), spl[k + 2]);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("DUG")) {
						obj.put("dug" + (index++), spl[k + 2]);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("DENOMINAZIONE")) {
						obj.put("denominazione" + (index++), spl[k + 2]);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("NUM_CIVICO")) {
						obj.put("civico" + (index++), spl[k + 2]);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("GR_AFFIDABILITA")) {
						obj.put("affidabilita" + (index++), spl[k + 2]);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("CIVICO_LAT_WGS84")) {
						obj.put("lat" + (index++),
								spl[k + 2] != null && !"".equals(spl[k + 2]) ? Double.parseDouble(spl[k + 2]) : null);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("CIVICO_LNG_WGS84")) {
						obj.put("lon" + (index++),
								spl[k + 2] != null && !"".equals(spl[k + 2]) ? Double.parseDouble(spl[k + 2]) : null);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("MIN_LAT_WGS84")) {
						obj.put("minlat" + (index++),
								spl[k + 2] != null && !"".equals(spl[k + 2]) ? Double.parseDouble(spl[k + 2]) : null);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("MIN_LNG_WGS84")) {
						obj.put("minlon" + (index++),
								spl[k + 2] != null && !"".equals(spl[k + 2]) ? Double.parseDouble(spl[k + 2]) : null);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("MAX_LAT_WGS84")) {
						obj.put("maxlat" + (index++),
								spl[k + 2] != null && !"".equals(spl[k + 2]) ? Double.parseDouble(spl[k + 2]) : null);
					}
				}
				index = 0;
				for (int k = 0; k < spl.length; k++) {
					if (spl[k].toUpperCase().equals("MAX_LNG_WGS84")) {
						obj.put("maxlon" + (index++),
								spl[k + 2] != null && !"".equals(spl[k + 2]) ? Double.parseDouble(spl[k + 2]) : null);
					}
				}

			}

			System.out.println(obj.toString());

			for (int k = 0; k < numRighe; k++) {
				if (obj.containsKey("lat" + k) && obj.containsKey("lon" + k) && obj.get("lat" + k) != null
						&& obj.get("lon" + k) != null) {
					Double d = Double.parseDouble(obj.get("lat" + k).toString());
					Double d2 = Double.parseDouble(obj.get("lon" + k).toString());
					if (d2 > d) {
						obj.put("lat" + k, d2);
						obj.put("lon" + k, d);
					}
				}
				if (obj.containsKey("minlat" + k) && obj.containsKey("minlon" + k) && obj.get("minlat" + k) != null
						&& obj.get("minlon" + k) != null) {
					Double d = Double.parseDouble(obj.get("minlat" + k).toString());
					Double d2 = Double.parseDouble(obj.get("minlon" + k).toString());
					if (d2 > d) {
						obj.put("minlat" + k, d2);
						obj.put("minlon" + k, d);
					}
				}
				if (obj.containsKey("maxlat" + k) && obj.containsKey("maxlon" + k) && obj.get("maxlat" + k) != null
						&& obj.get("maxlon" + k) != null) {
					Double d = Double.parseDouble(obj.get("maxlat" + k).toString());
					Double d2 = Double.parseDouble(obj.get("maxlon" + k).toString());
					if (d2 > d) {
						obj.put("maxlat" + k, d2);
						obj.put("maxlon" + k, d);
					}
				}
			}

			for (int k = 0; k < numRighe; k++) {
				try {

					if (obj.containsKey("lon" + k) && obj.get("lon" + k) != null && obj.containsKey("lat" + k)
							&& obj.get("lat" + k) != null) {
						obj.put("lon", Double.parseDouble(obj.get("lon" + k).toString()));
						obj.put("lat", Double.parseDouble(obj.get("lat" + k).toString()));
						return obj;
					}
					if (obj.containsKey("minlon" + k) && obj.get("minlon" + k) != null && obj.containsKey("minlat" + k)
							&& obj.get("minlat" + k) != null) {
						obj.put("lon", 0.5 * (Double.parseDouble(obj.get("minlon" + k).toString()) + Double.parseDouble(obj.get("maxlon" + k).toString())));
						obj.put("lat", 0.5 * (Double.parseDouble(obj.get("minlat" + k).toString()) + Double.parseDouble(obj.get("maxlat" + k).toString())));
						return obj;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (!obj.containsKey("lon")) obj.put("lon", 10.5);
			if (!obj.containsKey("lat")) obj.put("lat", 44.0);
			if (!obj.containsKey("records")) obj.put("records", 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	// ---------------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public HashMap<String, Object> locate(HashMap<String, Object> params) throws Exception {

		HashMap<String, Object> o=null;
		
		try {
			String handle = login("Pro_Civ", "xqxGXKdGdVVkK3GhRSrl");
			if (handle!=null) o = query(handle, params);
		} catch (Exception e) {

		}

		if (o==null) {
			o = new HashMap<String, Object>();
			
			try {
				o.put("lon", 10.5);
				o.put("lat", 44.0);
				o.put("records", 0);
			} catch (Exception e2) {}
			
		}
		
		return o;
	}
}
