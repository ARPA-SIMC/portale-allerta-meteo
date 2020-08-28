package it.eng.allerter.allerta;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.HashSet;
import java.util.Set;

/**
 * Un ImageObserver che impedisce il proseguimento fino a quando le immagini
 * non sono state scaricate completamente. Java crea infatti le immagini anche
 * prima di possederne tutti i dati, specie se provengono dalla rete.
 * @author Favini_G
 *
 */
public class MyImageObserver implements ImageObserver {
	
	public boolean completo = false;

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		
		if ((infoflags & ImageObserver.ALLBITS) != 0) {
			completo = true;
			return false;
		}
			
		
		return true;
	}

}
