package it.eng.sms.search;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.sms.bean.Cittadini;

public class CittadiniHelper {

	public static boolean isFilterEmpty(CittadiniDisplayTerms displayTerms) {

		if (Validator.isNull(displayTerms.getEmail()) && Validator.isNull(displayTerms.getNome())
				&& Validator.isNull(displayTerms.getCognome()) && Validator.isNull(displayTerms.getComune())
				&& Validator.isNull(displayTerms.getTel())

		) {

			return true;
		}

		return false;

	}

	public static String getBaseQuery(boolean count, CittadiniDisplayTerms terms, int start, int end) {
		String x = "select " + (count ? "count(*)" : "name,lastname,firstname,emailaddress,coalesce(telefoni,'') as telefoni")
				+ " from appartenenza_comuni_vw where (groupid in (select groupid from usergrouprole where userid="
				+ terms.getUserId() + " and roleid in (29574,75902,75920,451351)) or exists "
				+ "(select * from users_roles where userid=" + terms.getUserId()
				+ " and roleid in (20161,168321))) ";

		if (terms.getCognome() != null && !"".equals(terms.getCognome()))
			x += " and upper(lastname) like '%" + terms.getCognome().toUpperCase() + "%' ";
		if (terms.getNome() != null && !"".equals(terms.getNome()))
			x += " and upper(firstname) like '%" + terms.getNome().toUpperCase() + "%' ";
		if (terms.getComune() != null && !"".equals(terms.getComune()))
			x += " and upper(name) like '%" + terms.getComune().toUpperCase() + "%' ";
		if (terms.getEmail() != null && !"".equals(terms.getEmail()))
			x += " and upper(emailaddress) like '%" + terms.getEmail().toUpperCase() + "%' ";
		if (terms.getTel() != null && !"".equals(terms.getTel()))
			x += " and upper(telefoni) like '%" + terms.getTel().toUpperCase() + "%' ";

		if (!count) {
			if (start != -1)
				x += " offset " + start;
			if (end != -1)
				x += " limit " + (end - start);
		}

		return x;
	}

	public static List<Cittadini> getCittadini(CittadiniDisplayTerms displayTerms, int start, int end)
			throws SystemException {

		try {
			List<Object[]> l = BollettinoLocalServiceUtil
					.eseguiQueryGenericaLista(getBaseQuery(false, displayTerms, start, end));

			List<Cittadini> out = new ArrayList<Cittadini>();
			for (Object[] o : l) {
				Cittadini ss = new Cittadini();
				out.add(ss);
				ss.setComune((String) o[0]);
				ss.setCognome((String) o[1]);
				ss.setNome((String) o[2]);
				ss.setEmail((String) o[3]);
				ss.setTelefoni((String) o[4]);
			}

			return out;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static int getTotalCittadiniCount(CittadiniDisplayTerms displayTerms) throws SystemException {

		try {

			Object l = BollettinoLocalServiceUtil.eseguiQueryGenerica(getBaseQuery(true, displayTerms, -1, -1));

			return Integer.parseInt(l.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
