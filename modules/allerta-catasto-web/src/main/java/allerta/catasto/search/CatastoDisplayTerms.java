package allerta.catasto.search;


import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class CatastoDisplayTerms extends DisplayTerms {
	
	private String dataDa;
	private String dataA;
	
	private String comuneFilter;
	private String areaFilter;
	private int categoriaFilter;
	
	private String orderByCol;
	private String orderByType;
	
	public CatastoDisplayTerms(PortletRequest portletRequest) {
		
		super(portletRequest);
		dataDa = ParamUtil.getString( portletRequest, "dataInvioDa");
		dataA = ParamUtil.getString( portletRequest, "dataInvioA");
		
		orderByCol = ParamUtil.getString( portletRequest, "orderByCol");
		orderByType = ParamUtil.getString( portletRequest, "orderByType");
		
		areaFilter= ParamUtil.getString(portletRequest, "areaFilter");
		comuneFilter= ParamUtil.getString(portletRequest, "comuneFilter");
		categoriaFilter= ParamUtil.getInteger(portletRequest, "categoriaFilter");
	}

	public String getDataDa() {
		return dataDa;
	}

	public void setDataDa(String dataDa) {
		this.dataDa = dataDa;
	}

	public String getDataA() {
		return dataA;
	}

	public void setDataA(String dataA) {
		this.dataA = dataA;
	}

	public String getOrderByCol() {
		return orderByCol;
	}

	public void setOrderByCol(String orderByCol) {
		this.orderByCol = orderByCol;
	}

	public String getOrderByType() {
		return orderByType;
	}

	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}

	public String getComuneFilter() {
		return comuneFilter;
	}

	public void setComuneFilter(String comuneFilter) {
		this.comuneFilter = comuneFilter;
	}

	public String getAreaFilter() {
		return areaFilter;
	}

	public void setAreaFilter(String areaFilter) {
		this.areaFilter = areaFilter;
	}

	public int getCategoriaFilter() {
		return categoriaFilter;
	}

	public void setCategoriaFilter(int categoriaFilter) {
		this.categoriaFilter = categoriaFilter;
	}

	
	
}

