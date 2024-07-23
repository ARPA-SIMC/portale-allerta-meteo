package it.eng.allerter.allerta;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;

import it.eng.allerter.allerta.svg.*;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.Geografia;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.AllertaServiceUtil;
import it.eng.allerter.service.GeografiaLocalServiceUtil;
import it.eng.bollettino.service.BollettinoServiceUtil;

/**
 * Una classe di utility, composta solo da metodi statici, per la manipolazione
 * di immagini. E' possibile caricarle da disco, dalla rete, comporle a partire
 * da tile (per esempio provenienti da un server WMS) o sovrapporle come layer
 * per poi salvarle nei formati piu' comuni.
 * @author Favini_G
 *
 */
public class ImageUtility {
	
	public static int[] VERDE = {153,204,0,255};
	public static int[] GIALLO = {255,255,0,255};
	public static int[] ARANCIONE = {255,153,0,255};
	public static int[] ROSSO = {255,0,0,255};
	public static int[] BIANCO = {255,255,255,255};
	
	public static int[] GRIGIO = {25,25,25,255};
	public static int[] GRIGIO_VALANGHE = {204,204,204,255};
	public static int[] BORDO_COMUNE = {85,85,85,96};
	
	public static int[] TRASPARENTE = {0,0,0,0};
	
	public static String[] TESTI_MACROAREE = {"A","B","C","D","E","F","G","H"};
	public static float[] X_MACROAREE = {0.76f,0.85f,0.58f,0.7f,0.4f,0.45f,0.15f,0.2f};
	public static float[] Y_MACROAREE = {0.83f,0.7f,0.62f,0.4f,0.57f,0.3f,0.43f,0.21f};
	
	public static String[] TESTI_SOTTOMACROAREE = {"A1","A2","B1","B2","C1","C2","D1","D2","E1","E2","F","G1","G2","H1","H2"};
	public static float[] X_SOTTOMACROAREE = {0.75f,0.77f,0.83f,0.83f,0.51f,0.59f,0.67f,0.83f,0.36f,0.4f,0.46f,0.12f,0.16f,0.15f,0.2f};
	public static float[] Y_SOTTOMACROAREE = {0.91f,0.79f,0.73f,0.59f,0.72f,0.6f,0.39f,0.3f,0.61f,0.48f,0.3f,0.49f,0.4f,0.29f,0.17f};
	
	public static int[] COLORE_TESTO = {0,0,0,255};
	public static int[] COLORE_OUTLINE = {255,255,255,255};
	public static int DIMENSIONE_TESTO = 24;
	public static int DIMENSIONE_OUTLINE = 4;
	
	public static float[] X_AREE = {0.75f,0.77f,0.83f,0.83f,0.51f,0.61f,0.65f,0.83f,0.72f,0.36f,0.4f,0.50f,0.39f,0.36f,0.12f,0.16f,0.19f,0.2f};
	public static float[] Y_AREE = {0.91f,0.79f,0.73f,0.59f,0.72f,0.58f,0.41f,0.3f,0.28f,0.61f,0.48f,0.3f,0.31f,0.23f,0.49f,0.4f,0.27f,0.15f};
	
	
	public static double[] bbox;
	public static double sizex, sizey;
	
	
	public static int[] colorePerStato(int stato, int[] verd, int[] gial, int[] aran, int[] ross) {
		if (stato==-1) return BIANCO;
		if (stato==0) return verd;
		if (stato==1) return gial;
		if (stato==2) return aran;
		return ross;
	}
	
	public static int[] colorePerStatoValanghe(int stato, int[] verd, int[] gial, int[] aran, int[] ross) {
		if (stato==-1) return GRIGIO_VALANGHE;
		if (stato==0) return verd;
		if (stato==1) return gial;
		if (stato==2) return aran;
		return ross;
	}
	
	public static double convertX(double x, double y) {
		return sizex*(x-bbox[0])/(bbox[1]-bbox[0]);
	}
	
	public static double convertY(double x, double y) {
		return sizey*(y-bbox[2])/(bbox[3]-bbox[2]);
	}
	
	
	public static void drawArea(String name, String compl, int[] fill, int[] stroke, float pen, Graphics2D img) {
		
		List<Geografia> g = GeografiaLocalServiceUtil.findByIdComplessita(name, compl);
		
		for (Geografia gg : g) {
			drawArea(gg.getGeometria(),fill,stroke,pen,img);
		}
	}
	
	public static void drawAree(String name, String compl, int[] fill, int[] stroke, float pen, Graphics2D img) {
		
		List<Geografia> g = GeografiaLocalServiceUtil.findByAreaComplessita(name, compl);
		
		for (Geografia gg : g) {
			drawArea(gg.getGeometria(),fill,stroke,pen,img);
		}
	}
	
	public static void drawArea(String data, int[] fill, int[] stroke, float pen, Graphics2D img) {
		
		String[] s = data.split(",");
		
		GeneralPath shape = new GeneralPath();
		
		for (int k=0; k<s.length/2; k++) {
			double x = Double.parseDouble(s[k*2]);
			double y = Double.parseDouble(s[k*2+1]);
			
			double x2 = convertX(x,y);
			double y2 = convertY(x,y);
			
			if (k==0) shape.moveTo(x2, y2);
			else shape.lineTo(x2, y2);
			
		}
		
		shape.closePath();
	
		if (fill!=null) {
			Color paint = new Color(fill[0], fill[1], fill[2], fill[3]);
			img.setPaint(paint);
			img.fill(shape);
		}
		
		if (stroke!=null) {
			Color paint = new Color(stroke[0], stroke[1], stroke[2], stroke[3]);
			img.setPaint(paint);
			Stroke str = new BasicStroke(pen, 1, 1, 4.0f, null, 0.0f);
			img.setStroke(str);
			img.draw(shape);
		}
	
	}
	
	public static BufferedImage makeMappaMacroaree(int[] stati, int x, int y) {
		
		boolean usaNuovo = false;
		
		try {
			
			EntityCacheUtil.removeCache(AllertaParametro.class.getName());
			FinderCacheUtil.removeCache(AllertaParametro.class.getName());
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("MAPPA_BOUNDING_BOX");
			if (ap!=null) {
				usaNuovo = true;
				String ss[] = ap.getValore().split(",");
				bbox = new double[ss.length];
				for (int k=0; k<ss.length; k++) bbox[k] = Double.parseDouble(ss[k]);
				sizex = x;
				sizey = y;
			}
		} catch (Exception e) {
			
		}
		
		
		
		BufferedImage img = new BufferedImage(x,y,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = img.createGraphics();
		
		g.setClip(0,0,x,y);
		
		int[] VE = getParametroArrayInteri("ALLERTA_COLORE_VERDE", VERDE);
		int[] GI = getParametroArrayInteri("ALLERTA_COLORE_GIALLO", GIALLO);
		int[] AR = getParametroArrayInteri("ALLERTA_COLORE_ARANCIONE", ARANCIONE);
		int[] RO = getParametroArrayInteri("ALLERTA_COLORE_ROSSO", ROSSO);
		
		if (usaNuovo) {
			drawArea("A","simple",colorePerStato(stati[0],VE,GI,AR,RO),null,2.0f,g);
			drawArea("B","simple",colorePerStato(stati[1],VE,GI,AR,RO),null,2.0f,g);
			drawArea("C","simple",colorePerStato(stati[2],VE,GI,AR,RO),null,2.0f,g);
			drawArea("D","simple",colorePerStato(stati[3],VE,GI,AR,RO),null,2.0f,g);
			drawArea("E","simple",colorePerStato(stati[4],VE,GI,AR,RO),null,2.0f,g);
			drawArea("F","simple",colorePerStato(stati[5],VE,GI,AR,RO),null,2.0f,g);
			drawArea("G","simple",colorePerStato(stati[6],VE,GI,AR,RO),null,2.0f,g);
			drawArea("H","simple",colorePerStato(stati[7],VE,GI,AR,RO),null,2.0f,g);
			
			drawAree("comune","simple",null,BORDO_COMUNE,0.5f,g);
			
			drawArea("A","simple",null,GRIGIO,3.0f,g);
			drawArea("B","simple",null,GRIGIO,3.0f,g);
			drawArea("C","simple",null,GRIGIO,3.0f,g);
			drawArea("D","simple",null,GRIGIO,3.0f,g);
			drawArea("E","simple",null,GRIGIO,3.0f,g);
			drawArea("F","simple",null,GRIGIO,3.0f,g);
			drawArea("G","simple",null,GRIGIO,3.0f,g);
			drawArea("H","simple",null,GRIGIO,3.0f,g);
			
			String[] testi = getParametroArrayStringhe("ALLERTA_TESTI_MACROAREE", TESTI_MACROAREE);
			float[] xx = getParametroArrayFloat("ALLERTA_X_MACROAREE", X_MACROAREE);
			float[] yy = getParametroArrayFloat("ALLERTA_Y_MACROAREE", Y_MACROAREE);
			int size = getParametroIntero("ALLERTA_TESTI_DIMENSIONE", DIMENSIONE_TESTO);
			int outline = getParametroIntero("ALLERTA_OUTLINE_DIMENSIONE", DIMENSIONE_OUTLINE);
			int[] coloreTesto = getParametroArrayInteri("ALLERTA_TESTI_COLORE", COLORE_TESTO);
			int[] coloreOutline = getParametroArrayInteri("ALLERTA_OUTLINE_COLORE", COLORE_OUTLINE);
			String font = getParametroStringa("ALLERTA_TESTI_FONT", null);
			
			disegnaTesti(g, testi, xx, yy, x, y, size, outline, coloreTesto, coloreOutline, font);
			
			return img;

		}
		
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -280.0f, -60.0f));
		
		
		
		A.paint(g,colorePerStato(stati[0],VE,GI,AR,RO),TRASPARENTE);
		B.paint(g,colorePerStato(stati[1],VE,GI,AR,RO),TRASPARENTE);
		C.paint(g,colorePerStato(stati[2],VE,GI,AR,RO),TRASPARENTE);
		D.paint(g,colorePerStato(stati[3],VE,GI,AR,RO),TRASPARENTE);
		E.paint(g,colorePerStato(stati[4],VE,GI,AR,RO),TRASPARENTE);
		F.paint(g,colorePerStato(stati[5],VE,GI,AR,RO),TRASPARENTE);
		G.paint(g,colorePerStato(stati[6],VE,GI,AR,RO),TRASPARENTE);
		H.paint(g,colorePerStato(stati[7],VE,GI,AR,RO),TRASPARENTE);
		
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 100.0f, -183.0f));
		comuni.paint(g,BORDO_COMUNE,0.5f);
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -100.0f, 183.0f));
		
		A.paint(g,TRASPARENTE,GRIGIO);
		B.paint(g,TRASPARENTE,GRIGIO);
		C.paint(g,TRASPARENTE,GRIGIO);
		D.paint(g,TRASPARENTE,GRIGIO);
		E.paint(g,TRASPARENTE,GRIGIO);
		F.paint(g,TRASPARENTE,GRIGIO);
		G.paint(g,TRASPARENTE,GRIGIO);
		H.paint(g,TRASPARENTE,GRIGIO);
		
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 280.0f, 60.0f));
		
		String[] testi = getParametroArrayStringhe("ALLERTA_TESTI_MACROAREE", TESTI_MACROAREE);
		float[] xx = getParametroArrayFloat("ALLERTA_X_MACROAREE", X_MACROAREE);
		float[] yy = getParametroArrayFloat("ALLERTA_Y_MACROAREE", Y_MACROAREE);
		int size = getParametroIntero("ALLERTA_TESTI_DIMENSIONE", DIMENSIONE_TESTO);
		int outline = getParametroIntero("ALLERTA_OUTLINE_DIMENSIONE", DIMENSIONE_OUTLINE);
		int[] coloreTesto = getParametroArrayInteri("ALLERTA_TESTI_COLORE", COLORE_TESTO);
		int[] coloreOutline = getParametroArrayInteri("ALLERTA_OUTLINE_COLORE", COLORE_OUTLINE);
		String font = getParametroStringa("ALLERTA_TESTI_FONT", null);
		
		disegnaTesti(g, testi, xx, yy, x, y, size, outline, coloreTesto, coloreOutline, font);
		
		
		
		return img;
		
	}
	
public static BufferedImage makeMappaValanghe(int[] stati, int x, int y) {
		
		String[] area1 = {"FERRIERE","OTTONE","ZERBA","ALBARETO","BARDI","BEDONIA","BERCETO","BORGO VAL DI TARO","CORNIGLIO","MONCHIO DELLE CORTI","TORNOLO"};
		String[] area2 = {"VENTASSO","VILLA MINOZZO","FANANO","FIUMALBO","FRASSINORO","MONTECRETO","PIEVEPELAGO","RIOLUNATO","SESTOLA","ALTO RENO TERME","LIZZANO IN BELVEDERE"};
		String[] area3 = {"SANTA SOFIA","VERGHERETO","MONTECOPIOLO","BAGNO DI ROMAGNA"};
		
		try {
			
			EntityCacheUtil.removeCache(AllertaParametro.class.getName());
			FinderCacheUtil.removeCache(AllertaParametro.class.getName());
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("MAPPA_BOUNDING_BOX");
			if (ap!=null) {
				String ss[] = ap.getValore().split(",");
				bbox = new double[ss.length];
				for (int k=0; k<ss.length; k++) bbox[k] = Double.parseDouble(ss[k]);
				sizex = x;
				sizey = y;
			}
		} catch (Exception e) {
			
		}
		
		
		
		BufferedImage img = new BufferedImage(x,y,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = img.createGraphics();
		
		g.setClip(0,0,x,y);
		
		int[] VE = getParametroArrayInteri("ALLERTA_COLORE_VERDE", VERDE);
		int[] GI = getParametroArrayInteri("ALLERTA_COLORE_GIALLO", GIALLO);
		int[] AR = getParametroArrayInteri("ALLERTA_COLORE_ARANCIONE", ARANCIONE);
		int[] RO = getParametroArrayInteri("ALLERTA_COLORE_ROSSO", ROSSO);
		

			List<Geografia> geo = GeografiaLocalServiceUtil.findByAreaComplessita("comune", "simple");
			
			for (Geografia gg : geo) {
				int index = -1;
				for (String ss : area1) if (ss.equals(gg.getGeografiaId())) index = 0;
				for (String ss : area2) if (ss.equals(gg.getGeografiaId())) index = 1;
				for (String ss : area3) if (ss.equals(gg.getGeografiaId())) index = 2;
				int stato = (index>=0?stati[index]:-1);
				drawArea(gg.getGeometria(),index<0?BIANCO:colorePerStatoValanghe(stato,VE,GI,AR,RO),BORDO_COMUNE,3.0f,g);
			}
						

			
			String[] testi = getParametroArrayStringhe("ALLERTA_TESTI_MACROAREE", TESTI_MACROAREE);
			float[] xx = getParametroArrayFloat("ALLERTA_X_MACROAREE", X_MACROAREE);
			float[] yy = getParametroArrayFloat("ALLERTA_Y_MACROAREE", Y_MACROAREE);
			int size = getParametroIntero("ALLERTA_TESTI_DIMENSIONE", DIMENSIONE_TESTO);
			int outline = getParametroIntero("ALLERTA_OUTLINE_DIMENSIONE", DIMENSIONE_OUTLINE);
			int[] coloreTesto = getParametroArrayInteri("ALLERTA_TESTI_COLORE", COLORE_TESTO);
			int[] coloreOutline = getParametroArrayInteri("ALLERTA_OUTLINE_COLORE", COLORE_OUTLINE);
			String font = getParametroStringa("ALLERTA_TESTI_FONT", null);
			
			
			return img;

		
		

		
	}
	
public static BufferedImage makeMappaMacroaree2(int[] stati, int x, int y) {
	
	boolean usaNuovo = false;
	
	try {
		
		EntityCacheUtil.removeCache(AllertaParametro.class.getName());
		FinderCacheUtil.removeCache(AllertaParametro.class.getName());
		
		AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("MAPPA_BOUNDING_BOX");
		if (ap!=null) {
			usaNuovo = true;
			String ss[] = ap.getValore().split(",");
			bbox = new double[ss.length];
			for (int k=0; k<ss.length; k++) bbox[k] = Double.parseDouble(ss[k]);
			sizex = x;
			sizey = y;
		}
	} catch (Exception e) {
		
	}
	
	int[] VE = getParametroArrayInteri("ALLERTA_COLORE_VERDE", VERDE);
	int[] GI = getParametroArrayInteri("ALLERTA_COLORE_GIALLO", GIALLO);
	int[] AR = getParametroArrayInteri("ALLERTA_COLORE_ARANCIONE", ARANCIONE);
	int[] RO = getParametroArrayInteri("ALLERTA_COLORE_ROSSO", ROSSO);
	
		
		BufferedImage img = new BufferedImage(x,y,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = img.createGraphics();
		
		g.setClip(0,0,x,y);
		
		if (usaNuovo) {
			drawArea("A1","simple",colorePerStato(stati[0],VE,GI,AR,RO),null,2.0f,g);
			drawArea("A2","simple",colorePerStato(stati[1],VE,GI,AR,RO),null,2.0f,g);
			drawArea("B1","simple",colorePerStato(stati[2],VE,GI,AR,RO),null,2.0f,g);
			drawArea("B2","simple",colorePerStato(stati[3],VE,GI,AR,RO),null,2.0f,g);
			drawArea("C1","simple",colorePerStato(stati[4],VE,GI,AR,RO),null,2.0f,g);
			drawArea("C2","simple",colorePerStato(stati[5],VE,GI,AR,RO),null,2.0f,g);
			drawArea("D1","simple",colorePerStato(stati[6],VE,GI,AR,RO),null,2.0f,g);
			drawArea("D2","simple",colorePerStato(stati[7],VE,GI,AR,RO),null,2.0f,g);
			drawArea("E1","simple",colorePerStato(stati[8],VE,GI,AR,RO),null,2.0f,g);
			drawArea("E2","simple",colorePerStato(stati[9],VE,GI,AR,RO),null,2.0f,g);
			drawArea("F","simple",colorePerStato(stati[10],VE,GI,AR,RO),null,2.0f,g);
			drawArea("G1","simple",colorePerStato(stati[12],VE,GI,AR,RO),null,2.0f,g);
			drawArea("G2","simple",colorePerStato(stati[13],VE,GI,AR,RO),null,2.0f,g);
			drawArea("H1","simple",colorePerStato(stati[14],VE,GI,AR,RO),null,2.0f,g);
			drawArea("H2","simple",colorePerStato(stati[15],VE,GI,AR,RO),null,2.0f,g);
			
			drawAree("comune","simple",null,BORDO_COMUNE,0.5f,g);
			
			drawArea("A1","simple",null,GRIGIO,3.0f,g);
			drawArea("A2","simple",null,GRIGIO,3.0f,g);
			drawArea("B1","simple",null,GRIGIO,3.0f,g);
			drawArea("B2","simple",null,GRIGIO,3.0f,g);
			drawArea("C1","simple",null,GRIGIO,3.0f,g);
			drawArea("C2","simple",null,GRIGIO,3.0f,g);
			drawArea("D1","simple",null,GRIGIO,3.0f,g);
			drawArea("D2","simple",null,GRIGIO,3.0f,g);
			drawArea("E1","simple",null,GRIGIO,3.0f,g);
			drawArea("E2","simple",null,GRIGIO,3.0f,g);
			drawArea("F","simple",null,GRIGIO,3.0f,g);
			drawArea("G1","simple",null,GRIGIO,3.0f,g);
			drawArea("G2","simple",null,GRIGIO,3.0f,g);
			drawArea("H1","simple",null,GRIGIO,3.0f,g);
			drawArea("H2","simple",null,GRIGIO,3.0f,g);
			
			String[] testi = getParametroArrayStringhe("ALLERTA_TESTI_SOTTOMACROAREE", TESTI_SOTTOMACROAREE);
			float[] xx = getParametroArrayFloat("ALLERTA_X_SOTTOMACROAREE", X_SOTTOMACROAREE);
			float[] yy = getParametroArrayFloat("ALLERTA_Y_SOTTOMACROAREE", Y_SOTTOMACROAREE);
			int size = getParametroIntero("ALLERTA_TESTI_DIMENSIONE", DIMENSIONE_TESTO);
			int outline = getParametroIntero("ALLERTA_OUTLINE_DIMENSIONE", DIMENSIONE_OUTLINE);
			int[] coloreTesto = getParametroArrayInteri("ALLERTA_TESTI_COLORE", COLORE_TESTO);
			int[] coloreOutline = getParametroArrayInteri("ALLERTA_OUTLINE_COLORE", COLORE_OUTLINE);
			String font = getParametroStringa("ALLERTA_TESTI_FONT", null);
			
			disegnaTesti(g, testi, xx, yy, x, y, size, outline, coloreTesto, coloreOutline,font);
			
			return img;

		}
		
		
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -180.0f, -243.0f));
		
		
		
		A1.paint(g,colorePerStato(stati[0],VE,GI,AR,RO),TRASPARENTE);
		A2.paint(g,colorePerStato(stati[1],VE,GI,AR,RO),TRASPARENTE);
		B1.paint(g,colorePerStato(stati[2],VE,GI,AR,RO),TRASPARENTE);
		B2.paint(g,colorePerStato(stati[3],VE,GI,AR,RO),TRASPARENTE);
		C1.paint(g,colorePerStato(stati[4],VE,GI,AR,RO),TRASPARENTE);
		C2.paint(g,colorePerStato(stati[5],VE,GI,AR,RO),TRASPARENTE);
		D1.paint(g,colorePerStato(stati[6],VE,GI,AR,RO),TRASPARENTE);
		D2.paint(g,colorePerStato(stati[7],VE,GI,AR,RO),TRASPARENTE);
		E1.paint(g,colorePerStato(stati[8],VE,GI,AR,RO),TRASPARENTE);
		E2.paint(g,colorePerStato(stati[9],VE,GI,AR,RO),TRASPARENTE);
		F1.paint(g,colorePerStato(stati[10],VE,GI,AR,RO),TRASPARENTE);
		G1.paint(g,colorePerStato(stati[12],VE,GI,AR,RO),TRASPARENTE);
		G2.paint(g,colorePerStato(stati[13],VE,GI,AR,RO),TRASPARENTE);
		H1.paint(g,colorePerStato(stati[14],VE,GI,AR,RO),TRASPARENTE);
		H2.paint(g,colorePerStato(stati[15],VE,GI,AR,RO),TRASPARENTE);
		
		comuni.paint(g,BORDO_COMUNE,0.5f);
		
		A1.paint(g,TRASPARENTE,GRIGIO);
		A2.paint(g,TRASPARENTE,GRIGIO);
		B1.paint(g,TRASPARENTE,GRIGIO);
		B2.paint(g,TRASPARENTE,GRIGIO);
		C1.paint(g,TRASPARENTE,GRIGIO);
		C2.paint(g,TRASPARENTE,GRIGIO);
		D1.paint(g,TRASPARENTE,GRIGIO);
		D2.paint(g,TRASPARENTE,GRIGIO);
		E1.paint(g,TRASPARENTE,GRIGIO);
		E2.paint(g,TRASPARENTE,GRIGIO);
		F1.paint(g,TRASPARENTE,GRIGIO);
		G1.paint(g,TRASPARENTE,GRIGIO);
		G2.paint(g,TRASPARENTE,GRIGIO);
		H1.paint(g,TRASPARENTE,GRIGIO);
		H2.paint(g,TRASPARENTE,GRIGIO);
		
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 180.0f, 243.0f));
		
		
		String[] testi = getParametroArrayStringhe("ALLERTA_TESTI_SOTTOMACROAREE", TESTI_SOTTOMACROAREE);
		float[] xx = getParametroArrayFloat("ALLERTA_X_SOTTOMACROAREE", X_SOTTOMACROAREE);
		float[] yy = getParametroArrayFloat("ALLERTA_Y_SOTTOMACROAREE", Y_SOTTOMACROAREE);
		int size = getParametroIntero("ALLERTA_TESTI_DIMENSIONE", DIMENSIONE_TESTO);
		int outline = getParametroIntero("ALLERTA_OUTLINE_DIMENSIONE", DIMENSIONE_OUTLINE);
		int[] coloreTesto = getParametroArrayInteri("ALLERTA_TESTI_COLORE", COLORE_TESTO);
		int[] coloreOutline = getParametroArrayInteri("ALLERTA_OUTLINE_COLORE", COLORE_OUTLINE);
		String font = getParametroStringa("ALLERTA_TESTI_FONT", null);
		
		disegnaTesti(g, testi, xx, yy, x, y, size, outline, coloreTesto, coloreOutline,font);
		
		
		return img;
		
	}
	
	/**
	 * Prende un'immagine da un file
	 * @param f
	 * @return
	 */
	public static BufferedImage getImage(File f) {
		
		BufferedImage img = null;
		try {
			
		    img = ImageIO.read(f);
		    return img;
		    
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static BufferedImage getImage(InputStream stream) {
		
		BufferedImage img = null;
		try {
			
		    img = ImageIO.read(stream);
		    return img;
		    
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
public static BufferedImage getImage(String f) {
		
		BufferedImage img = null;
		try {
			
		    img = ImageIO.read(new File(f));
		    System.out.println("TROVATA IMMAGINE "+f);
		    return img;
		    
		} catch (IOException e) {
			System.out.println("NON TROVATA IMMAGINE "+f+"; "+e.getMessage());
			return null;
		}
		
	}
	
	/**
	 * Scarica un'immagine dalla rete
	 * @param url
	 * @return
	 */
	public static BufferedImage getImage(URL url) {
		
		BufferedImage img = null;
		try {
			
		    img = ImageIO.read(url);
		    return img;
		    
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage componiImmagine(BufferedImage sfondo, List<BufferedImage> icone, String costruzione) {
		
		try {
			BufferedImage image = new BufferedImage(sfondo.getWidth(),sfondo.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = image.createGraphics();
			MyImageObserver obs = new MyImageObserver();
			
			//copia lo sfondo
			if (!g.drawImage(sfondo, 0, 0, sfondo.getWidth(), sfondo.getHeight(), obs)) {
				System.out.println("INCOMPLETO");
				while (!obs.completo) { Thread.sleep(500); /*polling causa mancanza tempo per fare un monitor*/ }
			}
			
			//disegna le icone
			String[] comandi = costruzione.split("\\|");
			for (int k=0; k<comandi.length; k+=3) {
				if (comandi[k]==null || comandi[k].equals("")) break;
				String s = comandi[k].substring(4); //togli "type" da "type1"
				int index = Integer.parseInt(s) - 1;
				BufferedImage icona = icone.get(index);
				int x = Integer.parseInt(comandi[k+1]) - 4;
				int y = Integer.parseInt(comandi[k+2]) - 4;
				
				obs = new MyImageObserver();
				if (!g.drawImage(icona, x, y, icona.getWidth(), icona.getHeight(), obs)) {
					System.out.println("INCOMPLETO");
					while (!obs.completo) { Thread.sleep(500); /*polling causa mancanza tempo per fare un monitor*/ }
				};
				
			}
			
			return image;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void saveImage(BufferedImage i, File f, String format) {
		try {
			ImageIO.write(i, format, f);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void disegnaTesti(Graphics2D g, String[] testi, float[] xx, float[] yy, int w, int h, int size, int outline, int[] coloreTesto, int[] coloreOutline, String fn) {
		
		Font f = g.getFont();
		
		Font f2 = new Font((fn!=null?fn:f.getName()),Font.PLAIN,size);

		g.setFont(f2);
		
		g.setStroke(new BasicStroke(outline));
		g.setColor(new Color(coloreOutline[0],coloreOutline[1],coloreOutline[2],coloreOutline[3]));
		
		
		for (int k=0; k<testi.length; k++) {
			
			if (outline==0) break;
			
			String t = testi[k];
			int x = (int)(w * xx[k]);
			int y = (int)(h * yy[k]);
			
			GlyphVector gv = f2.createGlyphVector(g.getFontRenderContext(), t);
			Shape s = gv.getOutline();
			
			g.translate(x, y);
			g.draw(s);
			g.translate(-x, -y);
			
		}
		
		g.setColor(new Color(coloreTesto[0],coloreTesto[1],coloreTesto[2],coloreTesto[3]));
		
		for (int k=0; k<testi.length; k++) {
			
			String t = testi[k];
			int x = (int)(w * xx[k]);
			int y = (int)(h * yy[k]);
			
			g.drawChars(t.toCharArray(), 0, t.length(), x, y);
			
		}
		
	}
	
	public static int getParametroIntero(String nome, int def) {
		
		try {
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(nome);
			if (ap==null) return def;
			
			return Integer.parseInt(ap.getValore());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return def;
		}
		
	}
	
	public static String getParametroStringa(String nome, String def) {
		
		try {
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(nome);
			if (ap==null) return def;
			
			return ap.getValore();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return def;
		}
		
	}
	
	public static float getParametroIntero(String nome, float def) {
		
		try {
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(nome);
			if (ap==null) return def;
			
			return Float.parseFloat(ap.getValore());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return def;
		}
		
	}
	
	public static int[] getParametroArrayInteri(String nome, int[] def) {
		
		try {
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(nome);
			if (ap==null) return def;
			
			String[] o = ap.getValore().split(",");
			int[] i = new int[o.length];
			
			for (int k=0; k<i.length; k++)
				i[k] = Integer.parseInt(o[k]);
			
			return i;
			
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			return def;
		}
		
	}
	
	public static float[] getParametroArrayFloat(String nome, float[] def) {
		
		try {
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(nome);
			if (ap==null) return def;
			
			String[] o = ap.getValore().split(",");
			float[] i = new float[o.length];
			
			for (int k=0; k<i.length; k++)
				i[k] = Float.parseFloat(o[k]);
			
			return i;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return def;
		}
		
	}
	
	public static String[] getParametroArrayStringhe(String nome, String[] def) {
		
		try {
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(nome);
			if (ap==null) return def;
			
			String[] o = ap.getValore().split(",");

			return o;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return def;
		}
		
	}
	
	
	public static BufferedImage makeMappaAreeNuove(int[] stati, int x, int y, String[] aree) {
				
		try {
			
			EntityCacheUtil.removeCache(AllertaParametro.class.getName());
			FinderCacheUtil.removeCache(AllertaParametro.class.getName());
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("MAPPA_BOUNDING_BOX");
			if (ap!=null) {
				String ss[] = ap.getValore().split(",");
				bbox = new double[ss.length];
				for (int k=0; k<ss.length; k++) bbox[k] = Double.parseDouble(ss[k]);
				sizex = x;
				sizey = y;
			}
		} catch (Exception e) {
			
		}

		BufferedImage img = new BufferedImage(x,y,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = img.createGraphics();
		
		g.setClip(0,0,x,y);
		
		int[] VE = getParametroArrayInteri("ALLERTA_COLORE_VERDE", VERDE);
		int[] GI = getParametroArrayInteri("ALLERTA_COLORE_GIALLO", GIALLO);
		int[] AR = getParametroArrayInteri("ALLERTA_COLORE_ARANCIONE", ARANCIONE);
		int[] RO = getParametroArrayInteri("ALLERTA_COLORE_ROSSO", ROSSO);
		
		for (int k=0; k<stati.length; k++) {
			drawArea(aree[k],"simple",colorePerStato(stati[k],VE,GI,AR,RO),null,2.0f,g);
		}
		
		drawAree("comune","simple",null,BORDO_COMUNE,0.5f,g);
		
		for (int k=0; k<stati.length; k++) {
			drawArea(aree[k],"simple",null,GRIGIO,3.0f,g);
		}

		float[] xx = getParametroArrayFloat("ALLERTA_X_TESTI", X_AREE);
		float[] yy = getParametroArrayFloat("ALLERTA_Y_TESTI", Y_AREE);
		int size = getParametroIntero("ALLERTA_TESTI_DIMENSIONE", DIMENSIONE_TESTO);
		int outline = getParametroIntero("ALLERTA_OUTLINE_DIMENSIONE", DIMENSIONE_OUTLINE);
		int[] coloreTesto = getParametroArrayInteri("ALLERTA_TESTI_COLORE", COLORE_TESTO);
		int[] coloreOutline = getParametroArrayInteri("ALLERTA_OUTLINE_COLORE", COLORE_OUTLINE);
		String font = getParametroStringa("ALLERTA_TESTI_FONT", null);
			
		disegnaTesti(g, aree, xx, yy, x, y, size, outline, coloreTesto, coloreOutline, font);
			
		return img;
		
	}
	
	public static BufferedImage makeMappaAreeNuoveNoTesto(int[] stati, int x, int y, String[] aree) {
		
		try {
			
			EntityCacheUtil.removeCache(AllertaParametro.class.getName());
			FinderCacheUtil.removeCache(AllertaParametro.class.getName());
			
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("MAPPA_BOUNDING_BOX");
			if (ap!=null) {
				String ss[] = ap.getValore().split(",");
				bbox = new double[ss.length];
				for (int k=0; k<ss.length; k++) bbox[k] = Double.parseDouble(ss[k]);
				sizex = x;
				sizey = y;
			}
		} catch (Exception e) {
			
		}

		BufferedImage img = new BufferedImage(x,y,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = img.createGraphics();
		
		g.setClip(0,0,x,y);
		
		int[] VE = getParametroArrayInteri("ALLERTA_COLORE_VERDE", VERDE);
		int[] GI = getParametroArrayInteri("ALLERTA_COLORE_GIALLO", GIALLO);
		int[] AR = getParametroArrayInteri("ALLERTA_COLORE_ARANCIONE", ARANCIONE);
		int[] RO = getParametroArrayInteri("ALLERTA_COLORE_ROSSO", ROSSO);
		
		for (int k=0; k<stati.length; k++) {
			drawArea(aree[k],"simple",colorePerStato(stati[k],VE,GI,AR,RO),null,2.0f,g);
		}
		
		drawAree("comune","simple",null,BORDO_COMUNE,0.5f,g);
		
		for (int k=0; k<stati.length; k++) {
			drawArea(aree[k],"simple",null,GRIGIO,3.0f,g);
		}

		return img;
		
	}

}
