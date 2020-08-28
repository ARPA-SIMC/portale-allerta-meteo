package it.eng.allerter.allerta.svg;

import java.awt.*;
import java.awt.geom.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class has been automatically generated using
 * <a href="http://englishjavadrinker.blogspot.com/search/label/SVGRoundTrip">
 * SVGRoundTrip</a>.
 */
@SuppressWarnings("unused")
public class comuni {
	
	
	static float origAlpha;
	static Shape shape = null;
	static Paint paint = null;
	static Stroke stroke = null;
	static Area clip = null;
	static Composite origComposite;
	static AlphaComposite origAlphaComposite;
	static Shape clip__0;
	static AffineTransform defaultTransform_;
	static AffineTransform defaultTransform__0;
	static float alpha__0;
	static Shape clip_;
	
	/**
	 * Paints the transcoded SVG image on the specified graphics context. You
	 * can install a custom transformation on the graphics context to scale the
	 * image.
	 * 
	 * @param g
	 *            Graphics context.
	 */
	public static void paint(Graphics2D g, int[] colori, float spessore) {
		shape = null;
		paint = null;
		stroke = null;
		clip = null;

		origAlpha = 1.0f;
		origComposite = ((Graphics2D) g).getComposite();
		if (origComposite instanceof AlphaComposite) {
			origAlphaComposite = (AlphaComposite) origComposite;
			if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
				origAlpha = origAlphaComposite.getAlpha();
			}
		}

		clip_ = g.getClip();
		defaultTransform_ = g.getTransform();
		// is CompositeGraphicsNode
		alpha__0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		clip__0 = g.getClip();
		defaultTransform__0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 181.0f, 153.0f));
		clip = new Area(g.getClip());
		clip.intersect(new Area(new Rectangle2D.Double(-181.0, -153.0, 1026.0, 870.0)));
		g.setClip(clip);
		// _0 is CompositeGraphicsNode
		float alpha__0_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_0 = g.getClip();
		AffineTransform defaultTransform__0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_0 is CompositeGraphicsNode
		float alpha__0_0_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_0_0 = g.getClip();
		AffineTransform defaultTransform__0_0_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_0_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(576.0, 415.0,
		585.0, 404.0,
		591.0, 403.0,
		594.0, 411.0,
		593.0, 418.0,
		597.0, 426.0,
		592.0, 426.0,
		590.0, 420.0,
		589.0, 424.0,
		583.0, 427.0,
		579.0, 417.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(576.0, 415.0,
		585.0, 404.0,
		591.0, 403.0,
		594.0, 411.0,
		593.0, 418.0,
		597.0, 426.0,
		592.0, 426.0,
		590.0, 420.0,
		589.0, 424.0,
		583.0, 427.0,
		579.0, 417.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_0_0;
		g.setTransform(defaultTransform__0_0_0);
		g.setClip(clip__0_0_0);
		origAlpha = alpha__0_0;
		g.setTransform(defaultTransform__0_0);
		g.setClip(clip__0_0);
		float alpha__0_1 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_1 = g.getClip();
		AffineTransform defaultTransform__0_1 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_1 is CompositeGraphicsNode
		float alpha__0_1_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_1_0 = g.getClip();
		AffineTransform defaultTransform__0_1_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_1_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(572.0, 412.0,
		575.0, 416.0,
		573.0, 418.0,
		566.0, 420.0,
		565.0, 414.0,
		569.0, 411.0,
		569.0, 413.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(572.0, 412.0,
		575.0, 416.0,
		573.0, 418.0,
		566.0, 420.0,
		565.0, 414.0,
		569.0, 411.0,
		569.0, 413.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_1_0;
		g.setTransform(defaultTransform__0_1_0);
		g.setClip(clip__0_1_0);
		origAlpha = alpha__0_1;
		g.setTransform(defaultTransform__0_1);
		g.setClip(clip__0_1);
		float alpha__0_2 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_2 = g.getClip();
		AffineTransform defaultTransform__0_2 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_2 is CompositeGraphicsNode
		float alpha__0_2_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_2_0 = g.getClip();
		AffineTransform defaultTransform__0_2_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_2_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(556.0, 416.0,
		559.0, 421.0,
		564.0, 422.0,
		562.0, 427.0,
		564.0, 431.0,
		563.0, 432.0,
		567.0, 434.0,
		558.0, 444.0,
		551.0, 442.0,
		544.0, 432.0,
		549.0, 420.0,
		548.0, 414.0,
		550.0, 413.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(556.0, 416.0,
		559.0, 421.0,
		564.0, 422.0,
		562.0, 427.0,
		564.0, 431.0,
		563.0, 432.0,
		567.0, 434.0,
		558.0, 444.0,
		551.0, 442.0,
		544.0, 432.0,
		549.0, 420.0,
		548.0, 414.0,
		550.0, 413.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_2_0;
		g.setTransform(defaultTransform__0_2_0);
		g.setClip(clip__0_2_0);
		origAlpha = alpha__0_2;
		g.setTransform(defaultTransform__0_2);
		g.setClip(clip__0_2);
		float alpha__0_3 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_3 = g.getClip();
		AffineTransform defaultTransform__0_3 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_3 is CompositeGraphicsNode
		float alpha__0_3_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_3_0 = g.getClip();
		AffineTransform defaultTransform__0_3_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_3_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(573.0, 418.0,
		576.0, 415.0,
		578.0, 416.0,
		583.0, 427.0,
		581.0, 429.0,
		578.0, 428.0,
		573.0, 433.0,
		569.0, 430.0,
		573.0, 426.0,
		571.0, 425.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(573.0, 418.0,
		576.0, 415.0,
		578.0, 416.0,
		583.0, 427.0,
		581.0, 429.0,
		578.0, 428.0,
		573.0, 433.0,
		569.0, 430.0,
		573.0, 426.0,
		571.0, 425.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_3_0;
		g.setTransform(defaultTransform__0_3_0);
		g.setClip(clip__0_3_0);
		origAlpha = alpha__0_3;
		g.setTransform(defaultTransform__0_3);
		g.setClip(clip__0_3);
		float alpha__0_4 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_4 = g.getClip();
		AffineTransform defaultTransform__0_4 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_4 is CompositeGraphicsNode
		float alpha__0_4_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_4_0 = g.getClip();
		AffineTransform defaultTransform__0_4_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_4_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(562.0, 415.0,
		566.0, 417.0,
		567.0, 420.0,
		573.0, 418.0,
		571.0, 425.0,
		573.0, 426.0,
		570.0, 428.0,
		567.0, 434.0,
		563.0, 432.0,
		564.0, 431.0,
		562.0, 427.0,
		564.0, 422.0,
		559.0, 421.0,
		556.0, 417.0,
		559.0, 417.0,
		559.0, 415.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(562.0, 415.0,
		566.0, 417.0,
		567.0, 420.0,
		573.0, 418.0,
		571.0, 425.0,
		573.0, 426.0,
		570.0, 428.0,
		567.0, 434.0,
		563.0, 432.0,
		564.0, 431.0,
		562.0, 427.0,
		564.0, 422.0,
		559.0, 421.0,
		556.0, 417.0,
		559.0, 417.0,
		559.0, 415.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_4_0;
		g.setTransform(defaultTransform__0_4_0);
		g.setClip(clip__0_4_0);
		origAlpha = alpha__0_4;
		g.setTransform(defaultTransform__0_4);
		g.setClip(clip__0_4);
		float alpha__0_5 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_5 = g.getClip();
		AffineTransform defaultTransform__0_5 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_5 is CompositeGraphicsNode
		float alpha__0_5_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_5_0 = g.getClip();
		AffineTransform defaultTransform__0_5_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_5_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(580.0, 404.0,
		584.0, 407.0,
		575.0, 416.0,
		573.0, 411.0,
		576.0, 409.0,
		577.0, 404.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(580.0, 404.0,
		584.0, 407.0,
		575.0, 416.0,
		573.0, 411.0,
		576.0, 409.0,
		577.0, 404.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_5_0;
		g.setTransform(defaultTransform__0_5_0);
		g.setClip(clip__0_5_0);
		origAlpha = alpha__0_5;
		g.setTransform(defaultTransform__0_5);
		g.setClip(clip__0_5);
		float alpha__0_6 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_6 = g.getClip();
		AffineTransform defaultTransform__0_6 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_6 is CompositeGraphicsNode
		float alpha__0_6_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_6_0 = g.getClip();
		AffineTransform defaultTransform__0_6_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_6_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(582.0, 428.0,
		580.0, 438.0,
		576.0, 443.0,
		571.0, 446.0,
		570.0, 453.0,
		565.0, 454.0,
		563.0, 457.0,
		557.0, 455.0,
		555.0, 458.0,
		555.0, 452.0,
		552.0, 451.0,
		550.0, 442.0,
		558.0, 444.0,
		565.0, 437.0,
		569.0, 430.0,
		573.0, 433.0,
		578.0, 428.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(582.0, 428.0,
		580.0, 438.0,
		576.0, 443.0,
		571.0, 446.0,
		570.0, 453.0,
		565.0, 454.0,
		563.0, 457.0,
		557.0, 455.0,
		555.0, 458.0,
		555.0, 452.0,
		552.0, 451.0,
		550.0, 442.0,
		558.0, 444.0,
		565.0, 437.0,
		569.0, 430.0,
		573.0, 433.0,
		578.0, 428.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_6_0;
		g.setTransform(defaultTransform__0_6_0);
		g.setClip(clip__0_6_0);
		origAlpha = alpha__0_6;
		g.setTransform(defaultTransform__0_6);
		g.setClip(clip__0_6);
		float alpha__0_7 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_7 = g.getClip();
		AffineTransform defaultTransform__0_7 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_7 is CompositeGraphicsNode
		float alpha__0_7_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_7_0 = g.getClip();
		AffineTransform defaultTransform__0_7_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_7_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(546.0, 436.0,
		550.0, 439.0,
		550.0, 446.0,
		552.0, 451.0,
		555.0, 452.0,
		554.0, 462.0,
		549.0, 454.0,
		541.0, 457.0,
		536.0, 453.0,
		538.0, 446.0,
		540.0, 445.0,
		543.0, 438.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(546.0, 436.0,
		550.0, 439.0,
		550.0, 446.0,
		552.0, 451.0,
		555.0, 452.0,
		554.0, 462.0,
		549.0, 454.0,
		541.0, 457.0,
		536.0, 453.0,
		538.0, 446.0,
		540.0, 445.0,
		543.0, 438.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_7_0;
		g.setTransform(defaultTransform__0_7_0);
		g.setClip(clip__0_7_0);
		origAlpha = alpha__0_7;
		g.setTransform(defaultTransform__0_7);
		g.setClip(clip__0_7);
		float alpha__0_8 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_8 = g.getClip();
		AffineTransform defaultTransform__0_8 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_8 is CompositeGraphicsNode
		float alpha__0_8_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_8_0 = g.getClip();
		AffineTransform defaultTransform__0_8_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_8_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(476.0, 324.0,
		480.0, 324.0,
		481.0, 326.0,
		483.0, 326.0,
		484.0, 330.0,
		494.0, 337.0,
		496.0, 338.0,
		500.0, 334.0,
		501.0, 340.0,
		505.0, 339.0,
		500.0, 345.0,
		498.0, 351.0,
		488.0, 344.0,
		486.0, 345.0,
		483.0, 343.0,
		478.0, 348.0,
		477.0, 344.0,
		474.0, 345.0,
		472.0, 349.0,
		469.0, 350.0,
		467.0, 363.0,
		460.0, 363.0,
		460.0, 365.0,
		455.0, 369.0,
		453.0, 366.0,
		448.0, 364.0,
		443.0, 366.0,
		444.0, 363.0,
		449.0, 358.0,
		449.0, 354.0,
		463.0, 337.0,
		460.0, 335.0,
		463.0, 330.0,
		471.0, 329.0,
		473.0, 324.0,
		475.0, 325.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(476.0, 324.0,
		480.0, 324.0,
		481.0, 326.0,
		483.0, 326.0,
		484.0, 330.0,
		494.0, 337.0,
		496.0, 338.0,
		500.0, 334.0,
		501.0, 340.0,
		505.0, 339.0,
		500.0, 345.0,
		498.0, 351.0,
		488.0, 344.0,
		486.0, 345.0,
		483.0, 343.0,
		478.0, 348.0,
		477.0, 344.0,
		474.0, 345.0,
		472.0, 349.0,
		469.0, 350.0,
		467.0, 363.0,
		460.0, 363.0,
		460.0, 365.0,
		455.0, 369.0,
		453.0, 366.0,
		448.0, 364.0,
		443.0, 366.0,
		444.0, 363.0,
		449.0, 358.0,
		449.0, 354.0,
		463.0, 337.0,
		460.0, 335.0,
		463.0, 330.0,
		471.0, 329.0,
		473.0, 324.0,
		475.0, 325.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_8_0;
		g.setTransform(defaultTransform__0_8_0);
		g.setClip(clip__0_8_0);
		origAlpha = alpha__0_8;
		g.setTransform(defaultTransform__0_8);
		g.setClip(clip__0_8);
		float alpha__0_9 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_9 = g.getClip();
		AffineTransform defaultTransform__0_9 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_9 is CompositeGraphicsNode
		float alpha__0_9_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_9_0 = g.getClip();
		AffineTransform defaultTransform__0_9_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_9_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(504.0, 340.0,
		507.0, 343.0,
		507.0, 346.0,
		510.0, 341.0,
		512.0, 342.0,
		513.0, 351.0,
		516.0, 353.0,
		509.0, 358.0,
		506.0, 357.0,
		506.0, 360.0,
		502.0, 361.0,
		502.0, 355.0,
		498.0, 351.0,
		500.0, 345.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(504.0, 340.0,
		507.0, 343.0,
		507.0, 346.0,
		510.0, 341.0,
		512.0, 342.0,
		513.0, 351.0,
		516.0, 353.0,
		509.0, 358.0,
		506.0, 357.0,
		506.0, 360.0,
		502.0, 361.0,
		502.0, 355.0,
		498.0, 351.0,
		500.0, 345.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_9_0;
		g.setTransform(defaultTransform__0_9_0);
		g.setClip(clip__0_9_0);
		origAlpha = alpha__0_9;
		g.setTransform(defaultTransform__0_9);
		g.setClip(clip__0_9);
		float alpha__0_10 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_10 = g.getClip();
		AffineTransform defaultTransform__0_10 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_10 is CompositeGraphicsNode
		float alpha__0_10_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_10_0 = g.getClip();
		AffineTransform defaultTransform__0_10_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_10_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(498.0, 351.0,
		488.0, 364.0,
		488.0, 373.0,
		488.0, 370.0,
		484.0, 369.0,
		483.0, 372.0,
		480.0, 373.0,
		478.0, 369.0,
		480.0, 365.0,
		472.0, 362.0,
		467.0, 363.0,
		468.0, 354.0,
		474.0, 345.0,
		477.0, 344.0,
		479.0, 348.0,
		483.0, 343.0,
		486.0, 345.0,
		488.0, 344.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(498.0, 351.0,
		488.0, 364.0,
		488.0, 373.0,
		488.0, 370.0,
		484.0, 369.0,
		483.0, 372.0,
		480.0, 373.0,
		478.0, 369.0,
		480.0, 365.0,
		472.0, 362.0,
		467.0, 363.0,
		468.0, 354.0,
		474.0, 345.0,
		477.0, 344.0,
		479.0, 348.0,
		483.0, 343.0,
		486.0, 345.0,
		488.0, 344.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_10_0;
		g.setTransform(defaultTransform__0_10_0);
		g.setClip(clip__0_10_0);
		origAlpha = alpha__0_10;
		g.setTransform(defaultTransform__0_10);
		g.setClip(clip__0_10);
		float alpha__0_11 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_11 = g.getClip();
		AffineTransform defaultTransform__0_11 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_11 is CompositeGraphicsNode
		float alpha__0_11_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_11_0 = g.getClip();
		AffineTransform defaultTransform__0_11_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_11_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(498.0, 351.0,
		502.0, 355.0,
		503.0, 369.0,
		499.0, 369.0,
		497.0, 374.0,
		495.0, 375.0,
		490.0, 370.0,
		493.0, 366.0,
		488.0, 366.0,
		488.0, 364.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(498.0, 351.0,
		502.0, 355.0,
		503.0, 369.0,
		499.0, 369.0,
		497.0, 374.0,
		495.0, 375.0,
		490.0, 370.0,
		493.0, 366.0,
		488.0, 366.0,
		488.0, 364.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_11_0;
		g.setTransform(defaultTransform__0_11_0);
		g.setClip(clip__0_11_0);
		origAlpha = alpha__0_11;
		g.setTransform(defaultTransform__0_11);
		g.setClip(clip__0_11);
		float alpha__0_12 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_12 = g.getClip();
		AffineTransform defaultTransform__0_12 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_12 is CompositeGraphicsNode
		float alpha__0_12_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_12_0 = g.getClip();
		AffineTransform defaultTransform__0_12_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_12_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(516.0, 353.0,
		520.0, 355.0,
		518.0, 363.0,
		521.0, 366.0,
		520.0, 371.0,
		517.0, 374.0,
		516.0, 380.0,
		512.0, 384.0,
		504.0, 386.0,
		499.0, 382.0,
		498.0, 379.0,
		500.0, 376.0,
		499.0, 375.0,
		503.0, 370.0,
		502.0, 362.0,
		506.0, 360.0,
		506.0, 357.0,
		509.0, 358.0,
		513.0, 354.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(516.0, 353.0,
		520.0, 355.0,
		518.0, 363.0,
		521.0, 366.0,
		520.0, 371.0,
		517.0, 374.0,
		516.0, 380.0,
		512.0, 384.0,
		504.0, 386.0,
		499.0, 382.0,
		498.0, 379.0,
		500.0, 376.0,
		499.0, 375.0,
		503.0, 370.0,
		502.0, 362.0,
		506.0, 360.0,
		506.0, 357.0,
		509.0, 358.0,
		513.0, 354.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_12_0;
		g.setTransform(defaultTransform__0_12_0);
		g.setClip(clip__0_12_0);
		origAlpha = alpha__0_12;
		g.setTransform(defaultTransform__0_12);
		g.setClip(clip__0_12);
		float alpha__0_13 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_13 = g.getClip();
		AffineTransform defaultTransform__0_13 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_13 is CompositeGraphicsNode
		float alpha__0_13_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_13_0 = g.getClip();
		AffineTransform defaultTransform__0_13_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_13_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(533.0, 358.0,
		534.0, 360.0,
		538.0, 361.0,
		537.0, 366.0,
		540.0, 368.0,
		543.0, 374.0,
		538.0, 385.0,
		534.0, 378.0,
		535.0, 376.0,
		529.0, 376.0,
		528.0, 379.0,
		524.0, 378.0,
		518.0, 373.0,
		521.0, 367.0,
		518.0, 364.0,
		519.0, 362.0,
		527.0, 356.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(533.0, 358.0,
		534.0, 360.0,
		538.0, 361.0,
		537.0, 366.0,
		540.0, 368.0,
		543.0, 374.0,
		538.0, 385.0,
		534.0, 378.0,
		535.0, 376.0,
		529.0, 376.0,
		528.0, 379.0,
		524.0, 378.0,
		518.0, 373.0,
		521.0, 367.0,
		518.0, 364.0,
		519.0, 362.0,
		527.0, 356.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_13_0;
		g.setTransform(defaultTransform__0_13_0);
		g.setClip(clip__0_13_0);
		origAlpha = alpha__0_13;
		g.setTransform(defaultTransform__0_13);
		g.setClip(clip__0_13);
		float alpha__0_14 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_14 = g.getClip();
		AffineTransform defaultTransform__0_14 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_14 is CompositeGraphicsNode
		float alpha__0_14_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_14_0 = g.getClip();
		AffineTransform defaultTransform__0_14_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_14_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(474.0, 363.0,
		480.0, 365.0,
		478.0, 369.0,
		480.0, 373.0,
		486.0, 375.0,
		487.0, 379.0,
		485.0, 381.0,
		481.0, 379.0,
		477.0, 385.0,
		476.0, 380.0,
		474.0, 387.0,
		469.0, 387.0,
		468.0, 391.0,
		462.0, 391.0,
		461.0, 389.0,
		464.0, 381.0,
		471.0, 372.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(474.0, 363.0,
		480.0, 365.0,
		478.0, 369.0,
		480.0, 373.0,
		486.0, 375.0,
		487.0, 379.0,
		485.0, 381.0,
		481.0, 379.0,
		477.0, 385.0,
		476.0, 380.0,
		474.0, 387.0,
		469.0, 387.0,
		468.0, 391.0,
		462.0, 391.0,
		461.0, 389.0,
		464.0, 381.0,
		471.0, 372.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_14_0;
		g.setTransform(defaultTransform__0_14_0);
		g.setClip(clip__0_14_0);
		origAlpha = alpha__0_14;
		g.setTransform(defaultTransform__0_14);
		g.setClip(clip__0_14);
		float alpha__0_15 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_15 = g.getClip();
		AffineTransform defaultTransform__0_15 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_15 is CompositeGraphicsNode
		float alpha__0_15_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_15_0 = g.getClip();
		AffineTransform defaultTransform__0_15_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_15_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(489.0, 366.0,
		493.0, 366.0,
		490.0, 370.0,
		495.0, 375.0,
		497.0, 374.0,
		499.0, 369.0,
		501.0, 368.0,
		503.0, 370.0,
		499.0, 375.0,
		500.0, 379.0,
		496.0, 384.0,
		491.0, 385.0,
		484.0, 391.0,
		482.0, 390.0,
		480.0, 381.0,
		481.0, 379.0,
		485.0, 381.0,
		487.0, 377.0,
		481.0, 373.0,
		484.0, 369.0,
		487.0, 370.0,
		488.0, 372.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(489.0, 366.0,
		493.0, 366.0,
		490.0, 370.0,
		495.0, 375.0,
		497.0, 374.0,
		499.0, 369.0,
		501.0, 368.0,
		503.0, 370.0,
		499.0, 375.0,
		500.0, 379.0,
		496.0, 384.0,
		491.0, 385.0,
		484.0, 391.0,
		482.0, 390.0,
		480.0, 381.0,
		481.0, 379.0,
		485.0, 381.0,
		487.0, 377.0,
		481.0, 373.0,
		484.0, 369.0,
		487.0, 370.0,
		488.0, 372.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_15_0;
		g.setTransform(defaultTransform__0_15_0);
		g.setClip(clip__0_15_0);
		origAlpha = alpha__0_15;
		g.setTransform(defaultTransform__0_15);
		g.setClip(clip__0_15);
		float alpha__0_16 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_16 = g.getClip();
		AffineTransform defaultTransform__0_16 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_16 is CompositeGraphicsNode
		float alpha__0_16_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_16_0 = g.getClip();
		AffineTransform defaultTransform__0_16_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_16_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(537.0, 385.0,
		535.0, 395.0,
		533.0, 395.0,
		532.0, 399.0,
		539.0, 399.0,
		543.0, 407.0,
		538.0, 406.0,
		529.0, 412.0,
		527.0, 408.0,
		522.0, 408.0,
		520.0, 405.0,
		512.0, 402.0,
		507.0, 395.0,
		504.0, 394.0,
		505.0, 391.0,
		508.0, 390.0,
		507.0, 386.0,
		510.0, 386.0,
		516.0, 380.0,
		518.0, 373.0,
		524.0, 378.0,
		528.0, 379.0,
		529.0, 376.0,
		535.0, 376.0,
		534.0, 378.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(537.0, 385.0,
		535.0, 395.0,
		533.0, 395.0,
		532.0, 399.0,
		539.0, 399.0,
		543.0, 407.0,
		538.0, 406.0,
		529.0, 412.0,
		527.0, 408.0,
		522.0, 408.0,
		520.0, 405.0,
		512.0, 402.0,
		507.0, 395.0,
		504.0, 394.0,
		505.0, 391.0,
		508.0, 390.0,
		507.0, 386.0,
		510.0, 386.0,
		516.0, 380.0,
		518.0, 373.0,
		524.0, 378.0,
		528.0, 379.0,
		529.0, 376.0,
		535.0, 376.0,
		534.0, 378.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_16_0;
		g.setTransform(defaultTransform__0_16_0);
		g.setClip(clip__0_16_0);
		origAlpha = alpha__0_16;
		g.setTransform(defaultTransform__0_16);
		g.setClip(clip__0_16);
		float alpha__0_17 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_17 = g.getClip();
		AffineTransform defaultTransform__0_17 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_17 is CompositeGraphicsNode
		float alpha__0_17_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_17_0 = g.getClip();
		AffineTransform defaultTransform__0_17_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_17_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(555.0, 387.0,
		556.0, 393.0,
		559.0, 395.0,
		559.0, 402.0,
		555.0, 403.0,
		560.0, 409.0,
		564.0, 407.0,
		568.0, 412.0,
		565.0, 417.0,
		561.0, 415.0,
		559.0, 417.0,
		550.0, 414.0,
		551.0, 411.0,
		547.0, 409.0,
		548.0, 404.0,
		545.0, 404.0,
		543.0, 410.0,
		541.0, 410.0,
		539.0, 407.0,
		543.0, 407.0,
		540.0, 402.0,
		541.0, 401.0,
		539.0, 399.0,
		532.0, 399.0,
		533.0, 395.0,
		536.0, 393.0,
		536.0, 389.0,
		540.0, 388.0,
		541.0, 386.0,
		545.0, 387.0,
		551.0, 381.0,
		553.0, 381.0,
		553.0, 385.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(555.0, 387.0,
		556.0, 393.0,
		559.0, 395.0,
		559.0, 402.0,
		555.0, 403.0,
		560.0, 409.0,
		564.0, 407.0,
		568.0, 412.0,
		565.0, 417.0,
		561.0, 415.0,
		559.0, 417.0,
		550.0, 414.0,
		551.0, 411.0,
		547.0, 409.0,
		548.0, 404.0,
		545.0, 404.0,
		543.0, 410.0,
		541.0, 410.0,
		539.0, 407.0,
		543.0, 407.0,
		540.0, 402.0,
		541.0, 401.0,
		539.0, 399.0,
		532.0, 399.0,
		533.0, 395.0,
		536.0, 393.0,
		536.0, 389.0,
		540.0, 388.0,
		541.0, 386.0,
		545.0, 387.0,
		551.0, 381.0,
		553.0, 381.0,
		553.0, 385.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_17_0;
		g.setTransform(defaultTransform__0_17_0);
		g.setClip(clip__0_17_0);
		origAlpha = alpha__0_17;
		g.setTransform(defaultTransform__0_17);
		g.setClip(clip__0_17);
		float alpha__0_18 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_18 = g.getClip();
		AffineTransform defaultTransform__0_18 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_18 is CompositeGraphicsNode
		float alpha__0_18_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_18_0 = g.getClip();
		AffineTransform defaultTransform__0_18_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_18_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(498.0, 379.0,
		501.0, 385.0,
		507.0, 386.0,
		508.0, 388.0,
		508.0, 391.0,
		505.0, 391.0,
		504.0, 394.0,
		507.0, 395.0,
		512.0, 402.0,
		517.0, 404.0,
		516.0, 408.0,
		512.0, 412.0,
		506.0, 405.0,
		495.0, 400.0,
		495.0, 396.0,
		491.0, 387.0,
		496.0, 384.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(498.0, 379.0,
		501.0, 385.0,
		507.0, 386.0,
		508.0, 388.0,
		508.0, 391.0,
		505.0, 391.0,
		504.0, 394.0,
		507.0, 395.0,
		512.0, 402.0,
		517.0, 404.0,
		516.0, 408.0,
		512.0, 412.0,
		506.0, 405.0,
		495.0, 400.0,
		495.0, 396.0,
		491.0, 387.0,
		496.0, 384.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_18_0;
		g.setTransform(defaultTransform__0_18_0);
		g.setClip(clip__0_18_0);
		origAlpha = alpha__0_18;
		g.setTransform(defaultTransform__0_18);
		g.setClip(clip__0_18);
		float alpha__0_19 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_19 = g.getClip();
		AffineTransform defaultTransform__0_19 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_19 is CompositeGraphicsNode
		float alpha__0_19_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_19_0 = g.getClip();
		AffineTransform defaultTransform__0_19_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_19_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(482.0, 390.0,
		479.0, 391.0,
		474.0, 398.0,
		463.0, 406.0,
		454.0, 397.0,
		455.0, 393.0,
		458.0, 393.0,
		457.0, 389.0,
		466.0, 391.0,
		469.0, 390.0,
		470.0, 387.0,
		474.0, 387.0,
		476.0, 380.0,
		477.0, 385.0,
		478.0, 381.0,
		480.0, 381.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(482.0, 390.0,
		479.0, 391.0,
		474.0, 398.0,
		463.0, 406.0,
		454.0, 397.0,
		455.0, 393.0,
		458.0, 393.0,
		457.0, 389.0,
		466.0, 391.0,
		469.0, 390.0,
		470.0, 387.0,
		474.0, 387.0,
		476.0, 380.0,
		477.0, 385.0,
		478.0, 381.0,
		480.0, 381.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_19_0;
		g.setTransform(defaultTransform__0_19_0);
		g.setClip(clip__0_19_0);
		origAlpha = alpha__0_19;
		g.setTransform(defaultTransform__0_19);
		g.setClip(clip__0_19);
		float alpha__0_20 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_20 = g.getClip();
		AffineTransform defaultTransform__0_20 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_20 is CompositeGraphicsNode
		float alpha__0_20_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_20_0 = g.getClip();
		AffineTransform defaultTransform__0_20_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_20_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(494.0, 385.0,
		491.0, 389.0,
		495.0, 398.0,
		492.0, 400.0,
		491.0, 404.0,
		487.0, 408.0,
		481.0, 408.0,
		477.0, 414.0,
		472.0, 415.0,
		467.0, 419.0,
		467.0, 414.0,
		461.0, 410.0,
		465.0, 403.0,
		474.0, 398.0,
		479.0, 391.0,
		484.0, 391.0,
		491.0, 385.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(494.0, 385.0,
		491.0, 389.0,
		495.0, 398.0,
		492.0, 400.0,
		491.0, 404.0,
		487.0, 408.0,
		481.0, 408.0,
		477.0, 414.0,
		472.0, 415.0,
		467.0, 419.0,
		467.0, 414.0,
		461.0, 410.0,
		465.0, 403.0,
		474.0, 398.0,
		479.0, 391.0,
		484.0, 391.0,
		491.0, 385.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_20_0;
		g.setTransform(defaultTransform__0_20_0);
		g.setClip(clip__0_20_0);
		origAlpha = alpha__0_20;
		g.setTransform(defaultTransform__0_20);
		g.setClip(clip__0_20);
		float alpha__0_21 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_21 = g.getClip();
		AffineTransform defaultTransform__0_21 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_21 is CompositeGraphicsNode
		float alpha__0_21_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_21_0 = g.getClip();
		AffineTransform defaultTransform__0_21_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_21_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(528.0, 412.0,
		528.0, 414.0,
		524.0, 414.0,
		524.0, 409.0,
		521.0, 410.0,
		519.0, 417.0,
		510.0, 418.0,
		503.0, 410.0,
		502.0, 412.0,
		495.0, 415.0,
		498.0, 422.0,
		485.0, 423.0,
		486.0, 425.0,
		490.0, 426.0,
		485.0, 430.0,
		481.0, 430.0,
		480.0, 433.0,
		466.0, 425.0,
		466.0, 421.0,
		469.0, 417.0,
		477.0, 414.0,
		481.0, 408.0,
		488.0, 408.0,
		493.0, 399.0,
		506.0, 405.0,
		512.0, 412.0,
		519.0, 405.0,
		522.0, 408.0,
		527.0, 408.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(528.0, 412.0,
		528.0, 414.0,
		524.0, 414.0,
		524.0, 409.0,
		521.0, 410.0,
		519.0, 417.0,
		510.0, 418.0,
		503.0, 410.0,
		502.0, 412.0,
		495.0, 415.0,
		498.0, 422.0,
		485.0, 423.0,
		486.0, 425.0,
		490.0, 426.0,
		485.0, 430.0,
		481.0, 430.0,
		480.0, 433.0,
		466.0, 425.0,
		466.0, 421.0,
		469.0, 417.0,
		477.0, 414.0,
		481.0, 408.0,
		488.0, 408.0,
		493.0, 399.0,
		506.0, 405.0,
		512.0, 412.0,
		519.0, 405.0,
		522.0, 408.0,
		527.0, 408.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_21_0;
		g.setTransform(defaultTransform__0_21_0);
		g.setClip(clip__0_21_0);
		origAlpha = alpha__0_21;
		g.setTransform(defaultTransform__0_21);
		g.setClip(clip__0_21);
		float alpha__0_22 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_22 = g.getClip();
		AffineTransform defaultTransform__0_22 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_22 is CompositeGraphicsNode
		float alpha__0_22_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_22_0 = g.getClip();
		AffineTransform defaultTransform__0_22_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_22_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(550.0, 413.0,
		548.0, 414.0,
		549.0, 420.0,
		544.0, 432.0,
		542.0, 430.0,
		535.0, 431.0,
		533.0, 422.0,
		531.0, 422.0,
		534.0, 413.0,
		539.0, 412.0,
		539.0, 408.0,
		543.0, 410.0,
		546.0, 404.0,
		549.0, 405.0,
		547.0, 408.0,
		551.0, 411.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(550.0, 413.0,
		548.0, 414.0,
		549.0, 420.0,
		544.0, 432.0,
		542.0, 430.0,
		535.0, 431.0,
		533.0, 422.0,
		531.0, 422.0,
		534.0, 413.0,
		539.0, 412.0,
		539.0, 408.0,
		543.0, 410.0,
		546.0, 404.0,
		549.0, 405.0,
		547.0, 408.0,
		551.0, 411.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_22_0;
		g.setTransform(defaultTransform__0_22_0);
		g.setClip(clip__0_22_0);
		origAlpha = alpha__0_22;
		g.setTransform(defaultTransform__0_22);
		g.setClip(clip__0_22);
		float alpha__0_23 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_23 = g.getClip();
		AffineTransform defaultTransform__0_23 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_23 is CompositeGraphicsNode
		float alpha__0_23_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_23_0 = g.getClip();
		AffineTransform defaultTransform__0_23_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_23_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(539.0, 408.0,
		539.0, 412.0,
		534.0, 413.0,
		534.0, 416.0,
		531.0, 418.0,
		531.0, 422.0,
		533.0, 422.0,
		534.0, 426.0,
		529.0, 428.0,
		522.0, 438.0,
		516.0, 440.0,
		512.0, 447.0,
		504.0, 446.0,
		502.0, 441.0,
		498.0, 442.0,
		495.0, 440.0,
		490.0, 442.0,
		481.0, 435.0,
		481.0, 430.0,
		485.0, 430.0,
		490.0, 426.0,
		486.0, 425.0,
		485.0, 423.0,
		489.0, 421.0,
		498.0, 422.0,
		495.0, 415.0,
		502.0, 412.0,
		503.0, 410.0,
		510.0, 418.0,
		519.0, 417.0,
		521.0, 410.0,
		524.0, 409.0,
		524.0, 414.0,
		527.0, 415.0,
		529.0, 411.0,
		533.0, 410.0,
		538.0, 406.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(539.0, 408.0,
		539.0, 412.0,
		534.0, 413.0,
		534.0, 416.0,
		531.0, 418.0,
		531.0, 422.0,
		533.0, 422.0,
		534.0, 426.0,
		529.0, 428.0,
		522.0, 438.0,
		516.0, 440.0,
		512.0, 447.0,
		504.0, 446.0,
		502.0, 441.0,
		498.0, 442.0,
		495.0, 440.0,
		490.0, 442.0,
		481.0, 435.0,
		481.0, 430.0,
		485.0, 430.0,
		490.0, 426.0,
		486.0, 425.0,
		485.0, 423.0,
		489.0, 421.0,
		498.0, 422.0,
		495.0, 415.0,
		502.0, 412.0,
		503.0, 410.0,
		510.0, 418.0,
		519.0, 417.0,
		521.0, 410.0,
		524.0, 409.0,
		524.0, 414.0,
		527.0, 415.0,
		529.0, 411.0,
		533.0, 410.0,
		538.0, 406.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_23_0;
		g.setTransform(defaultTransform__0_23_0);
		g.setClip(clip__0_23_0);
		origAlpha = alpha__0_23;
		g.setTransform(defaultTransform__0_23);
		g.setClip(clip__0_23);
		float alpha__0_24 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_24 = g.getClip();
		AffineTransform defaultTransform__0_24 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_24 is CompositeGraphicsNode
		float alpha__0_24_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_24_0 = g.getClip();
		AffineTransform defaultTransform__0_24_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_24_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(544.0, 432.0,
		546.0, 437.0,
		543.0, 438.0,
		540.0, 445.0,
		537.0, 446.0,
		536.0, 453.0,
		538.0, 456.0,
		533.0, 459.0,
		530.0, 459.0,
		528.0, 455.0,
		526.0, 456.0,
		520.0, 453.0,
		516.0, 454.0,
		510.0, 450.0,
		510.0, 448.0,
		516.0, 440.0,
		522.0, 438.0,
		529.0, 428.0,
		534.0, 426.0,
		536.0, 431.0,
		542.0, 430.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(544.0, 432.0,
		546.0, 437.0,
		543.0, 438.0,
		540.0, 445.0,
		537.0, 446.0,
		536.0, 453.0,
		538.0, 456.0,
		533.0, 459.0,
		530.0, 459.0,
		528.0, 455.0,
		526.0, 456.0,
		520.0, 453.0,
		516.0, 454.0,
		510.0, 450.0,
		510.0, 448.0,
		516.0, 440.0,
		522.0, 438.0,
		529.0, 428.0,
		534.0, 426.0,
		536.0, 431.0,
		542.0, 430.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_24_0;
		g.setTransform(defaultTransform__0_24_0);
		g.setClip(clip__0_24_0);
		origAlpha = alpha__0_24;
		g.setTransform(defaultTransform__0_24);
		g.setClip(clip__0_24);
		float alpha__0_25 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_25 = g.getClip();
		AffineTransform defaultTransform__0_25 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_25 is CompositeGraphicsNode
		float alpha__0_25_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_25_0 = g.getClip();
		AffineTransform defaultTransform__0_25_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_25_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(135.0, 105.0,
		139.0, 103.0,
		141.0, 104.0,
		140.0, 113.0,
		149.0, 106.0,
		150.0, 107.0,
		150.0, 110.0,
		148.0, 112.0,
		148.0, 119.0,
		146.0, 122.0,
		148.0, 124.0,
		153.0, 124.0,
		149.0, 128.0,
		144.0, 129.0,
		142.0, 123.0,
		137.0, 124.0,
		134.0, 122.0,
		137.0, 114.0,
		132.0, 107.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(135.0, 105.0,
		139.0, 103.0,
		141.0, 104.0,
		140.0, 113.0,
		149.0, 106.0,
		150.0, 107.0,
		150.0, 110.0,
		148.0, 112.0,
		148.0, 119.0,
		146.0, 122.0,
		148.0, 124.0,
		153.0, 124.0,
		149.0, 128.0,
		144.0, 129.0,
		142.0, 123.0,
		137.0, 124.0,
		134.0, 122.0,
		137.0, 114.0,
		132.0, 107.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_25_0;
		g.setTransform(defaultTransform__0_25_0);
		g.setClip(clip__0_25_0);
		origAlpha = alpha__0_25;
		g.setTransform(defaultTransform__0_25);
		g.setClip(clip__0_25);
		float alpha__0_26 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_26 = g.getClip();
		AffineTransform defaultTransform__0_26 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_26 is CompositeGraphicsNode
		float alpha__0_26_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_26_0 = g.getClip();
		AffineTransform defaultTransform__0_26_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_26_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(158.0, 112.0,
		160.0, 115.0,
		159.0, 120.0,
		162.0, 123.0,
		159.0, 124.0,
		156.0, 122.0,
		154.0, 125.0,
		146.0, 123.0,
		148.0, 112.0,
		150.0, 110.0,
		149.0, 105.0,
		153.0, 105.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(158.0, 112.0,
		160.0, 115.0,
		159.0, 120.0,
		162.0, 123.0,
		159.0, 124.0,
		156.0, 122.0,
		154.0, 125.0,
		146.0, 123.0,
		148.0, 112.0,
		150.0, 110.0,
		149.0, 105.0,
		153.0, 105.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_26_0;
		g.setTransform(defaultTransform__0_26_0);
		g.setClip(clip__0_26_0);
		origAlpha = alpha__0_26;
		g.setTransform(defaultTransform__0_26);
		g.setClip(clip__0_26);
		float alpha__0_27 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_27 = g.getClip();
		AffineTransform defaultTransform__0_27 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_27 is CompositeGraphicsNode
		float alpha__0_27_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_27_0 = g.getClip();
		AffineTransform defaultTransform__0_27_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_27_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(73.0, 105.0,
		76.0, 112.0,
		80.0, 113.0,
		84.0, 110.0,
		85.0, 104.0,
		87.0, 105.0,
		89.0, 109.0,
		88.0, 116.0,
		96.0, 119.0,
		88.0, 124.0,
		79.0, 122.0,
		76.0, 118.0,
		77.0, 113.0,
		70.0, 106.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(73.0, 105.0,
		76.0, 112.0,
		80.0, 113.0,
		84.0, 110.0,
		85.0, 104.0,
		87.0, 105.0,
		89.0, 109.0,
		88.0, 116.0,
		96.0, 119.0,
		88.0, 124.0,
		79.0, 122.0,
		76.0, 118.0,
		77.0, 113.0,
		70.0, 106.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_27_0;
		g.setTransform(defaultTransform__0_27_0);
		g.setClip(clip__0_27_0);
		origAlpha = alpha__0_27;
		g.setTransform(defaultTransform__0_27);
		g.setClip(clip__0_27);
		float alpha__0_28 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_28 = g.getClip();
		AffineTransform defaultTransform__0_28 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_28 is CompositeGraphicsNode
		float alpha__0_28_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_28_0 = g.getClip();
		AffineTransform defaultTransform__0_28_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_28_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(70.0, 106.0,
		77.0, 113.0,
		77.0, 121.0,
		88.0, 124.0,
		87.0, 126.0,
		78.0, 130.0,
		76.0, 128.0,
		73.0, 128.0,
		73.0, 132.0,
		69.0, 131.0,
		69.0, 120.0,
		73.0, 115.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(70.0, 106.0,
		77.0, 113.0,
		77.0, 121.0,
		88.0, 124.0,
		87.0, 126.0,
		78.0, 130.0,
		76.0, 128.0,
		73.0, 128.0,
		73.0, 132.0,
		69.0, 131.0,
		69.0, 120.0,
		73.0, 115.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_28_0;
		g.setTransform(defaultTransform__0_28_0);
		g.setClip(clip__0_28_0);
		origAlpha = alpha__0_28;
		g.setTransform(defaultTransform__0_28);
		g.setClip(clip__0_28);
		float alpha__0_29 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_29 = g.getClip();
		AffineTransform defaultTransform__0_29 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_29 is CompositeGraphicsNode
		float alpha__0_29_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_29_0 = g.getClip();
		AffineTransform defaultTransform__0_29_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_29_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(110.0, 110.0,
		114.0, 116.0,
		121.0, 119.0,
		123.0, 125.0,
		119.0, 126.0,
		117.0, 133.0,
		111.0, 141.0,
		106.0, 140.0,
		105.0, 137.0,
		100.0, 140.0,
		98.0, 137.0,
		95.0, 137.0,
		94.0, 140.0,
		84.0, 136.0,
		86.0, 131.0,
		82.0, 131.0,
		90.0, 122.0,
		96.0, 119.0,
		104.0, 123.0,
		109.0, 118.0,
		108.0, 110.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(110.0, 110.0,
		114.0, 116.0,
		121.0, 119.0,
		123.0, 125.0,
		119.0, 126.0,
		117.0, 133.0,
		111.0, 141.0,
		106.0, 140.0,
		105.0, 137.0,
		100.0, 140.0,
		98.0, 137.0,
		95.0, 137.0,
		94.0, 140.0,
		84.0, 136.0,
		86.0, 131.0,
		82.0, 131.0,
		90.0, 122.0,
		96.0, 119.0,
		104.0, 123.0,
		109.0, 118.0,
		108.0, 110.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_29_0;
		g.setTransform(defaultTransform__0_29_0);
		g.setClip(clip__0_29_0);
		origAlpha = alpha__0_29;
		g.setTransform(defaultTransform__0_29);
		g.setClip(clip__0_29);
		float alpha__0_30 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_30 = g.getClip();
		AffineTransform defaultTransform__0_30 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_30 is CompositeGraphicsNode
		float alpha__0_30_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_30_0 = g.getClip();
		AffineTransform defaultTransform__0_30_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_30_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(65.0, 112.0,
		69.0, 118.0,
		68.0, 122.0,
		70.0, 127.0,
		68.0, 128.0,
		70.0, 128.0,
		64.0, 127.0,
		62.0, 130.0,
		57.0, 130.0,
		57.0, 125.0,
		61.0, 122.0,
		60.0, 113.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(65.0, 112.0,
		69.0, 118.0,
		68.0, 122.0,
		70.0, 127.0,
		68.0, 128.0,
		70.0, 128.0,
		64.0, 127.0,
		62.0, 130.0,
		57.0, 130.0,
		57.0, 125.0,
		61.0, 122.0,
		60.0, 113.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_30_0;
		g.setTransform(defaultTransform__0_30_0);
		g.setClip(clip__0_30_0);
		origAlpha = alpha__0_30;
		g.setTransform(defaultTransform__0_30);
		g.setClip(clip__0_30);
		float alpha__0_31 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_31 = g.getClip();
		AffineTransform defaultTransform__0_31 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_31 is CompositeGraphicsNode
		float alpha__0_31_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_31_0 = g.getClip();
		AffineTransform defaultTransform__0_31_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_31_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(127.0, 114.0,
		130.0, 115.0,
		134.0, 122.0,
		138.0, 124.0,
		135.0, 132.0,
		132.0, 130.0,
		130.0, 134.0,
		129.0, 131.0,
		126.0, 134.0,
		117.0, 128.0,
		124.0, 124.0,
		124.0, 115.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(127.0, 114.0,
		130.0, 115.0,
		134.0, 122.0,
		138.0, 124.0,
		135.0, 132.0,
		132.0, 130.0,
		130.0, 134.0,
		129.0, 131.0,
		126.0, 134.0,
		117.0, 128.0,
		124.0, 124.0,
		124.0, 115.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_31_0;
		g.setTransform(defaultTransform__0_31_0);
		g.setClip(clip__0_31_0);
		origAlpha = alpha__0_31;
		g.setTransform(defaultTransform__0_31);
		g.setClip(clip__0_31);
		float alpha__0_32 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_32 = g.getClip();
		AffineTransform defaultTransform__0_32 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_32 is CompositeGraphicsNode
		float alpha__0_32_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_32_0 = g.getClip();
		AffineTransform defaultTransform__0_32_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_32_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(60.0, 113.0,
		60.0, 122.0,
		58.0, 123.0,
		56.0, 129.0,
		51.0, 129.0,
		48.0, 134.0,
		46.0, 132.0,
		41.0, 133.0,
		40.0, 126.0,
		46.0, 120.0,
		48.0, 120.0,
		47.0, 117.0,
		52.0, 118.0,
		53.0, 115.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(60.0, 113.0,
		60.0, 122.0,
		58.0, 123.0,
		56.0, 129.0,
		51.0, 129.0,
		48.0, 134.0,
		46.0, 132.0,
		41.0, 133.0,
		40.0, 126.0,
		46.0, 120.0,
		48.0, 120.0,
		47.0, 117.0,
		52.0, 118.0,
		53.0, 115.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_32_0;
		g.setTransform(defaultTransform__0_32_0);
		g.setClip(clip__0_32_0);
		origAlpha = alpha__0_32;
		g.setTransform(defaultTransform__0_32);
		g.setClip(clip__0_32);
		float alpha__0_33 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_33 = g.getClip();
		AffineTransform defaultTransform__0_33 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_33 is CompositeGraphicsNode
		float alpha__0_33_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_33_0 = g.getClip();
		AffineTransform defaultTransform__0_33_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_33_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(153.0, 124.0,
		156.0, 122.0,
		159.0, 124.0,
		162.0, 122.0,
		164.0, 128.0,
		170.0, 126.0,
		163.0, 131.0,
		160.0, 143.0,
		152.0, 137.0,
		154.0, 136.0,
		151.0, 133.0,
		151.0, 130.0,
		149.0, 129.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(153.0, 124.0,
		156.0, 122.0,
		159.0, 124.0,
		162.0, 122.0,
		164.0, 128.0,
		170.0, 126.0,
		163.0, 131.0,
		160.0, 143.0,
		152.0, 137.0,
		154.0, 136.0,
		151.0, 133.0,
		151.0, 130.0,
		149.0, 129.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_33_0;
		g.setTransform(defaultTransform__0_33_0);
		g.setClip(clip__0_33_0);
		origAlpha = alpha__0_33;
		g.setTransform(defaultTransform__0_33);
		g.setClip(clip__0_33);
		float alpha__0_34 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_34 = g.getClip();
		AffineTransform defaultTransform__0_34 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_34 is CompositeGraphicsNode
		float alpha__0_34_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_34_0 = g.getClip();
		AffineTransform defaultTransform__0_34_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_34_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(149.0, 128.0,
		152.0, 134.0,
		149.0, 137.0,
		142.0, 136.0,
		143.0, 133.0,
		140.0, 132.0,
		138.0, 136.0,
		133.0, 134.0,
		140.0, 123.0,
		142.0, 123.0,
		144.0, 129.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(149.0, 128.0,
		152.0, 134.0,
		149.0, 137.0,
		142.0, 136.0,
		143.0, 133.0,
		140.0, 132.0,
		138.0, 136.0,
		133.0, 134.0,
		140.0, 123.0,
		142.0, 123.0,
		144.0, 129.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_34_0;
		g.setTransform(defaultTransform__0_34_0);
		g.setClip(clip__0_34_0);
		origAlpha = alpha__0_34;
		g.setTransform(defaultTransform__0_34);
		g.setClip(clip__0_34);
		float alpha__0_35 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_35 = g.getClip();
		AffineTransform defaultTransform__0_35 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_35 is CompositeGraphicsNode
		float alpha__0_35_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_35_0 = g.getClip();
		AffineTransform defaultTransform__0_35_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_35_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(188.0, 131.0,
		186.0, 144.0,
		172.0, 143.0,
		173.0, 138.0,
		167.0, 137.0,
		166.0, 139.0,
		162.0, 136.0,
		163.0, 131.0,
		170.0, 127.0,
		172.0, 133.0,
		181.0, 130.0,
		183.0, 127.0,
		186.0, 128.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(188.0, 131.0,
		186.0, 144.0,
		172.0, 143.0,
		173.0, 138.0,
		167.0, 137.0,
		166.0, 139.0,
		162.0, 136.0,
		163.0, 131.0,
		170.0, 127.0,
		172.0, 133.0,
		181.0, 130.0,
		183.0, 127.0,
		186.0, 128.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_35_0;
		g.setTransform(defaultTransform__0_35_0);
		g.setClip(clip__0_35_0);
		origAlpha = alpha__0_35;
		g.setTransform(defaultTransform__0_35);
		g.setClip(clip__0_35);
		float alpha__0_36 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_36 = g.getClip();
		AffineTransform defaultTransform__0_36 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_36 is CompositeGraphicsNode
		float alpha__0_36_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_36_0 = g.getClip();
		AffineTransform defaultTransform__0_36_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_36_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(69.0, 129.0,
		70.0, 133.0,
		68.0, 133.0,
		51.0, 151.0,
		49.0, 151.0,
		45.0, 146.0,
		50.0, 143.0,
		50.0, 137.0,
		48.0, 137.0,
		49.0, 131.0,
		53.0, 128.0,
		62.0, 130.0,
		64.0, 127.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(69.0, 129.0,
		70.0, 133.0,
		68.0, 133.0,
		51.0, 151.0,
		49.0, 151.0,
		45.0, 146.0,
		50.0, 143.0,
		50.0, 137.0,
		48.0, 137.0,
		49.0, 131.0,
		53.0, 128.0,
		62.0, 130.0,
		64.0, 127.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_36_0;
		g.setTransform(defaultTransform__0_36_0);
		g.setClip(clip__0_36_0);
		origAlpha = alpha__0_36;
		g.setTransform(defaultTransform__0_36);
		g.setClip(clip__0_36);
		float alpha__0_37 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_37 = g.getClip();
		AffineTransform defaultTransform__0_37 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_37 is CompositeGraphicsNode
		float alpha__0_37_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_37_0 = g.getClip();
		AffineTransform defaultTransform__0_37_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_37_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(82.0, 131.0,
		80.0, 142.0,
		76.0, 144.0,
		69.0, 144.0,
		66.0, 140.0,
		66.0, 136.0,
		70.0, 133.0,
		70.0, 131.0,
		73.0, 132.0,
		73.0, 128.0,
		76.0, 128.0,
		78.0, 130.0,
		85.0, 128.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(82.0, 131.0,
		80.0, 142.0,
		76.0, 144.0,
		69.0, 144.0,
		66.0, 140.0,
		66.0, 136.0,
		70.0, 133.0,
		70.0, 131.0,
		73.0, 132.0,
		73.0, 128.0,
		76.0, 128.0,
		78.0, 130.0,
		85.0, 128.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_37_0;
		g.setTransform(defaultTransform__0_37_0);
		g.setClip(clip__0_37_0);
		origAlpha = alpha__0_37;
		g.setTransform(defaultTransform__0_37);
		g.setClip(clip__0_37);
		float alpha__0_38 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_38 = g.getClip();
		AffineTransform defaultTransform__0_38 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_38 is CompositeGraphicsNode
		float alpha__0_38_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_38_0 = g.getClip();
		AffineTransform defaultTransform__0_38_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_38_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(188.0, 131.0,
		193.0, 130.0,
		202.0, 135.0,
		203.0, 137.0,
		198.0, 144.0,
		199.0, 139.0,
		197.0, 140.0,
		199.0, 148.0,
		197.0, 146.0,
		196.0, 148.0,
		187.0, 148.0,
		188.0, 145.0,
		186.0, 144.0,
		187.0, 142.0,
		185.0, 141.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(188.0, 131.0,
		193.0, 130.0,
		202.0, 135.0,
		203.0, 137.0,
		198.0, 144.0,
		199.0, 139.0,
		197.0, 140.0,
		199.0, 148.0,
		197.0, 146.0,
		196.0, 148.0,
		187.0, 148.0,
		188.0, 145.0,
		186.0, 144.0,
		187.0, 142.0,
		185.0, 141.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_38_0;
		g.setTransform(defaultTransform__0_38_0);
		g.setClip(clip__0_38_0);
		origAlpha = alpha__0_38;
		g.setTransform(defaultTransform__0_38);
		g.setClip(clip__0_38);
		float alpha__0_39 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_39 = g.getClip();
		AffineTransform defaultTransform__0_39 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_39 is CompositeGraphicsNode
		float alpha__0_39_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_39_0 = g.getClip();
		AffineTransform defaultTransform__0_39_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_39_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(118.0, 130.0,
		126.0, 134.0,
		120.0, 143.0,
		118.0, 154.0,
		114.0, 150.0,
		114.0, 146.0,
		110.0, 144.0,
		111.0, 139.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(118.0, 130.0,
		126.0, 134.0,
		120.0, 143.0,
		118.0, 154.0,
		114.0, 150.0,
		114.0, 146.0,
		110.0, 144.0,
		111.0, 139.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_39_0;
		g.setTransform(defaultTransform__0_39_0);
		g.setClip(clip__0_39_0);
		origAlpha = alpha__0_39;
		g.setTransform(defaultTransform__0_39);
		g.setClip(clip__0_39);
		float alpha__0_40 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_40 = g.getClip();
		AffineTransform defaultTransform__0_40 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_40 is CompositeGraphicsNode
		float alpha__0_40_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_40_0 = g.getClip();
		AffineTransform defaultTransform__0_40_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_40_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(126.0, 134.0,
		129.0, 131.0,
		132.0, 133.0,
		132.0, 130.0,
		134.0, 131.0,
		134.0, 135.0,
		138.0, 136.0,
		140.0, 132.0,
		143.0, 133.0,
		142.0, 136.0,
		146.0, 138.0,
		147.0, 136.0,
		149.0, 137.0,
		153.0, 134.0,
		154.0, 136.0,
		152.0, 137.0,
		154.0, 138.0,
		153.0, 141.0,
		145.0, 141.0,
		141.0, 149.0,
		139.0, 145.0,
		138.0, 147.0,
		137.0, 146.0,
		139.0, 144.0,
		136.0, 143.0,
		137.0, 140.0,
		131.0, 140.0,
		127.0, 134.0,
		124.0, 136.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(126.0, 134.0,
		129.0, 131.0,
		132.0, 133.0,
		132.0, 130.0,
		134.0, 131.0,
		134.0, 135.0,
		138.0, 136.0,
		140.0, 132.0,
		143.0, 133.0,
		142.0, 136.0,
		146.0, 138.0,
		147.0, 136.0,
		149.0, 137.0,
		153.0, 134.0,
		154.0, 136.0,
		152.0, 137.0,
		154.0, 138.0,
		153.0, 141.0,
		145.0, 141.0,
		141.0, 149.0,
		139.0, 145.0,
		138.0, 147.0,
		137.0, 146.0,
		139.0, 144.0,
		136.0, 143.0,
		137.0, 140.0,
		131.0, 140.0,
		127.0, 134.0,
		124.0, 136.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_40_0;
		g.setTransform(defaultTransform__0_40_0);
		g.setClip(clip__0_40_0);
		origAlpha = alpha__0_40;
		g.setTransform(defaultTransform__0_40);
		g.setClip(clip__0_40);
		float alpha__0_41 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_41 = g.getClip();
		AffineTransform defaultTransform__0_41 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_41 is CompositeGraphicsNode
		float alpha__0_41_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_41_0 = g.getClip();
		AffineTransform defaultTransform__0_41_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_41_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(95.0, 138.0,
		93.0, 148.0,
		87.0, 148.0,
		88.0, 146.0,
		84.0, 150.0,
		81.0, 150.0,
		80.0, 138.0,
		82.0, 131.0,
		86.0, 131.0,
		84.0, 136.0,
		88.0, 137.0,
		87.0, 139.0,
		94.0, 140.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(95.0, 138.0,
		93.0, 148.0,
		87.0, 148.0,
		88.0, 146.0,
		84.0, 150.0,
		81.0, 150.0,
		80.0, 138.0,
		82.0, 131.0,
		86.0, 131.0,
		84.0, 136.0,
		88.0, 137.0,
		87.0, 139.0,
		94.0, 140.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_41_0;
		g.setTransform(defaultTransform__0_41_0);
		g.setClip(clip__0_41_0);
		origAlpha = alpha__0_41;
		g.setTransform(defaultTransform__0_41);
		g.setClip(clip__0_41);
		float alpha__0_42 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_42 = g.getClip();
		AffineTransform defaultTransform__0_42 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_42 is CompositeGraphicsNode
		float alpha__0_42_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_42_0 = g.getClip();
		AffineTransform defaultTransform__0_42_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_42_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(48.0, 134.0,
		48.0, 137.0,
		50.0, 137.0,
		49.0, 145.0,
		42.0, 146.0,
		42.0, 150.0,
		36.0, 148.0,
		36.0, 146.0,
		34.0, 148.0,
		36.0, 139.0,
		39.0, 138.0,
		41.0, 133.0,
		46.0, 132.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(48.0, 134.0,
		48.0, 137.0,
		50.0, 137.0,
		49.0, 145.0,
		42.0, 146.0,
		42.0, 150.0,
		36.0, 148.0,
		36.0, 146.0,
		34.0, 148.0,
		36.0, 139.0,
		39.0, 138.0,
		41.0, 133.0,
		46.0, 132.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_42_0;
		g.setTransform(defaultTransform__0_42_0);
		g.setClip(clip__0_42_0);
		origAlpha = alpha__0_42;
		g.setTransform(defaultTransform__0_42);
		g.setClip(clip__0_42);
		float alpha__0_43 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_43 = g.getClip();
		AffineTransform defaultTransform__0_43 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_43 is CompositeGraphicsNode
		float alpha__0_43_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_43_0 = g.getClip();
		AffineTransform defaultTransform__0_43_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_43_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(124.0, 136.0,
		127.0, 134.0,
		131.0, 140.0,
		137.0, 140.0,
		129.0, 156.0,
		125.0, 151.0,
		120.0, 153.0,
		122.0, 150.0,
		120.0, 149.0,
		120.0, 143.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(124.0, 136.0,
		127.0, 134.0,
		131.0, 140.0,
		137.0, 140.0,
		129.0, 156.0,
		125.0, 151.0,
		120.0, 153.0,
		122.0, 150.0,
		120.0, 149.0,
		120.0, 143.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_43_0;
		g.setTransform(defaultTransform__0_43_0);
		g.setClip(clip__0_43_0);
		origAlpha = alpha__0_43;
		g.setTransform(defaultTransform__0_43);
		g.setClip(clip__0_43);
		float alpha__0_44 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_44 = g.getClip();
		AffineTransform defaultTransform__0_44 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_44 is CompositeGraphicsNode
		float alpha__0_44_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_44_0 = g.getClip();
		AffineTransform defaultTransform__0_44_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_44_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(181.0, 142.0,
		180.0, 151.0,
		178.0, 150.0,
		166.0, 162.0,
		164.0, 162.0,
		167.0, 157.0,
		161.0, 154.0,
		159.0, 156.0,
		157.0, 164.0,
		158.0, 167.0,
		156.0, 167.0,
		154.0, 157.0,
		152.0, 155.0,
		155.0, 147.0,
		161.0, 141.0,
		162.0, 136.0,
		166.0, 139.0,
		167.0, 137.0,
		173.0, 138.0,
		172.0, 143.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(181.0, 142.0,
		180.0, 151.0,
		178.0, 150.0,
		166.0, 162.0,
		164.0, 162.0,
		167.0, 157.0,
		161.0, 154.0,
		159.0, 156.0,
		157.0, 164.0,
		158.0, 167.0,
		156.0, 167.0,
		154.0, 157.0,
		152.0, 155.0,
		155.0, 147.0,
		161.0, 141.0,
		162.0, 136.0,
		166.0, 139.0,
		167.0, 137.0,
		173.0, 138.0,
		172.0, 143.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_44_0;
		g.setTransform(defaultTransform__0_44_0);
		g.setClip(clip__0_44_0);
		origAlpha = alpha__0_44;
		g.setTransform(defaultTransform__0_44);
		g.setClip(clip__0_44);
		float alpha__0_45 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_45 = g.getClip();
		AffineTransform defaultTransform__0_45 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_45 is CompositeGraphicsNode
		float alpha__0_45_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_45_0 = g.getClip();
		AffineTransform defaultTransform__0_45_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_45_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(66.0, 136.0,
		66.0, 140.0,
		69.0, 144.0,
		72.0, 144.0,
		70.0, 153.0,
		64.0, 157.0,
		62.0, 153.0,
		55.0, 149.0,
		56.0, 145.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(66.0, 136.0,
		66.0, 140.0,
		69.0, 144.0,
		72.0, 144.0,
		70.0, 153.0,
		64.0, 157.0,
		62.0, 153.0,
		55.0, 149.0,
		56.0, 145.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_45_0;
		g.setTransform(defaultTransform__0_45_0);
		g.setClip(clip__0_45_0);
		origAlpha = alpha__0_45;
		g.setTransform(defaultTransform__0_45);
		g.setClip(clip__0_45);
		float alpha__0_46 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_46 = g.getClip();
		AffineTransform defaultTransform__0_46 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_46 is CompositeGraphicsNode
		float alpha__0_46_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_46_0 = g.getClip();
		AffineTransform defaultTransform__0_46_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_46_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(205.0, 139.0,
		210.0, 139.0,
		211.0, 142.0,
		220.0, 148.0,
		214.0, 150.0,
		205.0, 170.0,
		199.0, 171.0,
		199.0, 164.0,
		202.0, 156.0,
		197.0, 153.0,
		197.0, 146.0,
		199.0, 147.0,
		197.0, 144.0,
		197.0, 140.0,
		199.0, 139.0,
		198.0, 144.0,
		201.0, 138.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(205.0, 139.0,
		210.0, 139.0,
		211.0, 142.0,
		220.0, 148.0,
		214.0, 150.0,
		205.0, 170.0,
		199.0, 171.0,
		199.0, 164.0,
		202.0, 156.0,
		197.0, 153.0,
		197.0, 146.0,
		199.0, 147.0,
		197.0, 144.0,
		197.0, 140.0,
		199.0, 139.0,
		198.0, 144.0,
		201.0, 138.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_46_0;
		g.setTransform(defaultTransform__0_46_0);
		g.setClip(clip__0_46_0);
		origAlpha = alpha__0_46;
		g.setTransform(defaultTransform__0_46);
		g.setClip(clip__0_46);
		float alpha__0_47 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_47 = g.getClip();
		AffineTransform defaultTransform__0_47 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_47 is CompositeGraphicsNode
		float alpha__0_47_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_47_0 = g.getClip();
		AffineTransform defaultTransform__0_47_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_47_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(111.0, 141.0,
		109.0, 146.0,
		106.0, 148.0,
		104.0, 154.0,
		100.0, 157.0,
		95.0, 152.0,
		92.0, 153.0,
		90.0, 150.0,
		93.0, 147.0,
		95.0, 137.0,
		98.0, 137.0,
		100.0, 140.0,
		105.0, 137.0,
		106.0, 140.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(111.0, 141.0,
		109.0, 146.0,
		106.0, 148.0,
		104.0, 154.0,
		100.0, 157.0,
		95.0, 152.0,
		92.0, 153.0,
		90.0, 150.0,
		93.0, 147.0,
		95.0, 137.0,
		98.0, 137.0,
		100.0, 140.0,
		105.0, 137.0,
		106.0, 140.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_47_0;
		g.setTransform(defaultTransform__0_47_0);
		g.setClip(clip__0_47_0);
		origAlpha = alpha__0_47;
		g.setTransform(defaultTransform__0_47);
		g.setClip(clip__0_47);
		float alpha__0_48 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_48 = g.getClip();
		AffineTransform defaultTransform__0_48 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_48 is CompositeGraphicsNode
		float alpha__0_48_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_48_0 = g.getClip();
		AffineTransform defaultTransform__0_48_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_48_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(160.0, 143.0,
		155.0, 147.0,
		152.0, 155.0,
		153.0, 151.0,
		151.0, 152.0,
		150.0, 149.0,
		142.0, 148.0,
		145.0, 141.0,
		153.0, 141.0,
		154.0, 138.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(160.0, 143.0,
		155.0, 147.0,
		152.0, 155.0,
		153.0, 151.0,
		151.0, 152.0,
		150.0, 149.0,
		142.0, 148.0,
		145.0, 141.0,
		153.0, 141.0,
		154.0, 138.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_48_0;
		g.setTransform(defaultTransform__0_48_0);
		g.setClip(clip__0_48_0);
		origAlpha = alpha__0_48;
		g.setTransform(defaultTransform__0_48);
		g.setClip(clip__0_48);
		float alpha__0_49 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_49 = g.getClip();
		AffineTransform defaultTransform__0_49 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_49 is CompositeGraphicsNode
		float alpha__0_49_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_49_0 = g.getClip();
		AffineTransform defaultTransform__0_49_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_49_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(220.0, 148.0,
		227.0, 143.0,
		230.0, 144.0,
		232.0, 149.0,
		230.0, 151.0,
		232.0, 157.0,
		229.0, 161.0,
		229.0, 165.0,
		221.0, 161.0,
		219.0, 162.0,
		215.0, 160.0,
		218.0, 156.0,
		213.0, 152.0,
		217.0, 148.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(220.0, 148.0,
		227.0, 143.0,
		230.0, 144.0,
		232.0, 149.0,
		230.0, 151.0,
		232.0, 157.0,
		229.0, 161.0,
		229.0, 165.0,
		221.0, 161.0,
		219.0, 162.0,
		215.0, 160.0,
		218.0, 156.0,
		213.0, 152.0,
		217.0, 148.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_49_0;
		g.setTransform(defaultTransform__0_49_0);
		g.setClip(clip__0_49_0);
		origAlpha = alpha__0_49;
		g.setTransform(defaultTransform__0_49);
		g.setClip(clip__0_49);
		float alpha__0_50 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_50 = g.getClip();
		AffineTransform defaultTransform__0_50 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_50 is CompositeGraphicsNode
		float alpha__0_50_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_50_0 = g.getClip();
		AffineTransform defaultTransform__0_50_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_50_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(181.0, 142.0,
		188.0, 145.0,
		187.0, 148.0,
		192.0, 149.0,
		187.0, 157.0,
		182.0, 160.0,
		174.0, 169.0,
		174.0, 162.0,
		168.0, 160.0,
		174.0, 153.0,
		178.0, 150.0,
		180.0, 151.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(181.0, 142.0,
		188.0, 145.0,
		187.0, 148.0,
		192.0, 149.0,
		187.0, 157.0,
		182.0, 160.0,
		174.0, 169.0,
		174.0, 162.0,
		168.0, 160.0,
		174.0, 153.0,
		178.0, 150.0,
		180.0, 151.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_50_0;
		g.setTransform(defaultTransform__0_50_0);
		g.setClip(clip__0_50_0);
		origAlpha = alpha__0_50;
		g.setTransform(defaultTransform__0_50);
		g.setClip(clip__0_50);
		float alpha__0_51 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_51 = g.getClip();
		AffineTransform defaultTransform__0_51 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_51 is CompositeGraphicsNode
		float alpha__0_51_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_51_0 = g.getClip();
		AffineTransform defaultTransform__0_51_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_51_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(80.0, 142.0,
		81.0, 157.0,
		77.0, 160.0,
		76.0, 159.0,
		75.0, 161.0,
		72.0, 161.0,
		65.0, 169.0,
		65.0, 165.0,
		63.0, 163.0,
		70.0, 153.0,
		72.0, 144.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(80.0, 142.0,
		81.0, 157.0,
		77.0, 160.0,
		76.0, 159.0,
		75.0, 161.0,
		72.0, 161.0,
		65.0, 169.0,
		65.0, 165.0,
		63.0, 163.0,
		70.0, 153.0,
		72.0, 144.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_51_0;
		g.setTransform(defaultTransform__0_51_0);
		g.setClip(clip__0_51_0);
		origAlpha = alpha__0_51;
		g.setTransform(defaultTransform__0_51);
		g.setClip(clip__0_51);
		float alpha__0_52 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_52 = g.getClip();
		AffineTransform defaultTransform__0_52 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_52 is CompositeGraphicsNode
		float alpha__0_52_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_52_0 = g.getClip();
		AffineTransform defaultTransform__0_52_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_52_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(136.0, 143.0,
		139.0, 144.0,
		137.0, 146.0,
		138.0, 147.0,
		139.0, 145.0,
		141.0, 149.0,
		150.0, 149.0,
		150.0, 153.0,
		142.0, 166.0,
		129.0, 162.0,
		127.0, 163.0,
		127.0, 156.0,
		130.0, 155.0,
		131.0, 151.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(136.0, 143.0,
		139.0, 144.0,
		137.0, 146.0,
		138.0, 147.0,
		139.0, 145.0,
		141.0, 149.0,
		150.0, 149.0,
		150.0, 153.0,
		142.0, 166.0,
		129.0, 162.0,
		127.0, 163.0,
		127.0, 156.0,
		130.0, 155.0,
		131.0, 151.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_52_0;
		g.setTransform(defaultTransform__0_52_0);
		g.setClip(clip__0_52_0);
		origAlpha = alpha__0_52;
		g.setTransform(defaultTransform__0_52);
		g.setClip(clip__0_52);
		float alpha__0_53 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_53 = g.getClip();
		AffineTransform defaultTransform__0_53 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_53 is CompositeGraphicsNode
		float alpha__0_53_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_53_0 = g.getClip();
		AffineTransform defaultTransform__0_53_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_53_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(117.0, 153.0,
		111.0, 158.0,
		111.0, 166.0,
		103.0, 173.0,
		98.0, 162.0,
		106.0, 148.0,
		110.0, 144.0,
		114.0, 146.0,
		114.0, 150.0,
		117.0, 151.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(117.0, 153.0,
		111.0, 158.0,
		111.0, 166.0,
		103.0, 173.0,
		98.0, 162.0,
		106.0, 148.0,
		110.0, 144.0,
		114.0, 146.0,
		114.0, 150.0,
		117.0, 151.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_53_0;
		g.setTransform(defaultTransform__0_53_0);
		g.setClip(clip__0_53_0);
		origAlpha = alpha__0_53;
		g.setTransform(defaultTransform__0_53);
		g.setClip(clip__0_53);
		float alpha__0_54 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_54 = g.getClip();
		AffineTransform defaultTransform__0_54 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_54 is CompositeGraphicsNode
		float alpha__0_54_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_54_0 = g.getClip();
		AffineTransform defaultTransform__0_54_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_54_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(56.0, 149.0,
		54.0, 159.0,
		52.0, 159.0,
		50.0, 163.0,
		48.0, 162.0,
		48.0, 167.0,
		45.0, 170.0,
		38.0, 160.0,
		41.0, 158.0,
		43.0, 153.0,
		51.0, 151.0,
		56.0, 145.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(56.0, 149.0,
		54.0, 159.0,
		52.0, 159.0,
		50.0, 163.0,
		48.0, 162.0,
		48.0, 167.0,
		45.0, 170.0,
		38.0, 160.0,
		41.0, 158.0,
		43.0, 153.0,
		51.0, 151.0,
		56.0, 145.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_54_0;
		g.setTransform(defaultTransform__0_54_0);
		g.setClip(clip__0_54_0);
		origAlpha = alpha__0_54;
		g.setTransform(defaultTransform__0_54);
		g.setClip(clip__0_54);
		float alpha__0_55 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_55 = g.getClip();
		AffineTransform defaultTransform__0_55 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_55 is CompositeGraphicsNode
		float alpha__0_55_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_55_0 = g.getClip();
		AffineTransform defaultTransform__0_55_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_55_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(197.0, 146.0,
		197.0, 153.0,
		202.0, 156.0,
		200.0, 157.0,
		200.0, 167.0,
		194.0, 167.0,
		188.0, 163.0,
		189.0, 160.0,
		183.0, 159.0,
		187.0, 157.0,
		192.0, 148.0,
		196.0, 148.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(197.0, 146.0,
		197.0, 153.0,
		202.0, 156.0,
		200.0, 157.0,
		200.0, 167.0,
		194.0, 167.0,
		188.0, 163.0,
		189.0, 160.0,
		183.0, 159.0,
		187.0, 157.0,
		192.0, 148.0,
		196.0, 148.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_55_0;
		g.setTransform(defaultTransform__0_55_0);
		g.setClip(clip__0_55_0);
		origAlpha = alpha__0_55;
		g.setTransform(defaultTransform__0_55);
		g.setClip(clip__0_55);
		float alpha__0_56 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_56 = g.getClip();
		AffineTransform defaultTransform__0_56 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_56 is CompositeGraphicsNode
		float alpha__0_56_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_56_0 = g.getClip();
		AffineTransform defaultTransform__0_56_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_56_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(32.0, 150.0,
		36.0, 146.0,
		36.0, 148.0,
		42.0, 150.0,
		41.0, 146.0,
		45.0, 146.0,
		49.0, 151.0,
		51.0, 151.0,
		43.0, 153.0,
		41.0, 158.0,
		31.0, 163.0,
		29.0, 171.0,
		23.0, 166.0,
		25.0, 161.0,
		29.0, 163.0,
		30.0, 161.0,
		24.0, 156.0,
		30.0, 155.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(32.0, 150.0,
		36.0, 146.0,
		36.0, 148.0,
		42.0, 150.0,
		41.0, 146.0,
		45.0, 146.0,
		49.0, 151.0,
		51.0, 151.0,
		43.0, 153.0,
		41.0, 158.0,
		31.0, 163.0,
		29.0, 171.0,
		23.0, 166.0,
		25.0, 161.0,
		29.0, 163.0,
		30.0, 161.0,
		24.0, 156.0,
		30.0, 155.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_56_0;
		g.setTransform(defaultTransform__0_56_0);
		g.setClip(clip__0_56_0);
		origAlpha = alpha__0_56;
		g.setTransform(defaultTransform__0_56);
		g.setClip(clip__0_56);
		float alpha__0_57 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_57 = g.getClip();
		AffineTransform defaultTransform__0_57 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_57 is CompositeGraphicsNode
		float alpha__0_57_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_57_0 = g.getClip();
		AffineTransform defaultTransform__0_57_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_57_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(81.0, 150.0,
		84.0, 150.0,
		86.0, 147.0,
		88.0, 147.0,
		87.0, 148.0,
		91.0, 150.0,
		93.0, 153.0,
		92.0, 158.0,
		90.0, 158.0,
		88.0, 165.0,
		86.0, 164.0,
		83.0, 173.0,
		78.0, 176.0,
		74.0, 170.0,
		78.0, 167.0,
		81.0, 162.0,
		79.0, 160.0,
		81.0, 157.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(81.0, 150.0,
		84.0, 150.0,
		86.0, 147.0,
		88.0, 147.0,
		87.0, 148.0,
		91.0, 150.0,
		93.0, 153.0,
		92.0, 158.0,
		90.0, 158.0,
		88.0, 165.0,
		86.0, 164.0,
		83.0, 173.0,
		78.0, 176.0,
		74.0, 170.0,
		78.0, 167.0,
		81.0, 162.0,
		79.0, 160.0,
		81.0, 157.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_57_0;
		g.setTransform(defaultTransform__0_57_0);
		g.setClip(clip__0_57_0);
		origAlpha = alpha__0_57;
		g.setTransform(defaultTransform__0_57);
		g.setClip(clip__0_57);
		float alpha__0_58 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_58 = g.getClip();
		AffineTransform defaultTransform__0_58 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_58 is CompositeGraphicsNode
		float alpha__0_58_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_58_0 = g.getClip();
		AffineTransform defaultTransform__0_58_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_58_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(239.0, 155.0,
		246.0, 159.0,
		245.0, 162.0,
		240.0, 164.0,
		235.0, 162.0,
		229.0, 170.0,
		229.0, 167.0,
		225.0, 166.0,
		230.0, 163.0,
		229.0, 161.0,
		232.0, 156.0,
		230.0, 151.0,
		232.0, 149.0,
		234.0, 153.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(239.0, 155.0,
		246.0, 159.0,
		245.0, 162.0,
		240.0, 164.0,
		235.0, 162.0,
		229.0, 170.0,
		229.0, 167.0,
		225.0, 166.0,
		230.0, 163.0,
		229.0, 161.0,
		232.0, 156.0,
		230.0, 151.0,
		232.0, 149.0,
		234.0, 153.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_58_0;
		g.setTransform(defaultTransform__0_58_0);
		g.setClip(clip__0_58_0);
		origAlpha = alpha__0_58;
		g.setTransform(defaultTransform__0_58);
		g.setClip(clip__0_58);
		float alpha__0_59 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_59 = g.getClip();
		AffineTransform defaultTransform__0_59 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_59 is CompositeGraphicsNode
		float alpha__0_59_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_59_0 = g.getClip();
		AffineTransform defaultTransform__0_59_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_59_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(117.0, 153.0,
		120.0, 149.0,
		122.0, 150.0,
		120.0, 153.0,
		127.0, 152.0,
		127.0, 161.0,
		118.0, 179.0,
		116.0, 180.0,
		112.0, 178.0,
		110.0, 182.0,
		109.0, 181.0,
		113.0, 176.0,
		112.0, 173.0,
		107.0, 173.0,
		106.0, 171.0,
		111.0, 166.0,
		111.0, 158.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(117.0, 153.0,
		120.0, 149.0,
		122.0, 150.0,
		120.0, 153.0,
		127.0, 152.0,
		127.0, 161.0,
		118.0, 179.0,
		116.0, 180.0,
		112.0, 178.0,
		110.0, 182.0,
		109.0, 181.0,
		113.0, 176.0,
		112.0, 173.0,
		107.0, 173.0,
		106.0, 171.0,
		111.0, 166.0,
		111.0, 158.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_59_0;
		g.setTransform(defaultTransform__0_59_0);
		g.setClip(clip__0_59_0);
		origAlpha = alpha__0_59;
		g.setTransform(defaultTransform__0_59);
		g.setClip(clip__0_59);
		float alpha__0_60 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_60 = g.getClip();
		AffineTransform defaultTransform__0_60 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_60 is CompositeGraphicsNode
		float alpha__0_60_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_60_0 = g.getClip();
		AffineTransform defaultTransform__0_60_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_60_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(65.0, 157.0,
		63.0, 163.0,
		65.0, 166.0,
		57.0, 170.0,
		54.0, 175.0,
		54.0, 172.0,
		51.0, 173.0,
		52.0, 169.0,
		48.0, 166.0,
		48.0, 162.0,
		50.0, 163.0,
		52.0, 159.0,
		54.0, 159.0,
		56.0, 149.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(65.0, 157.0,
		63.0, 163.0,
		65.0, 166.0,
		57.0, 170.0,
		54.0, 175.0,
		54.0, 172.0,
		51.0, 173.0,
		52.0, 169.0,
		48.0, 166.0,
		48.0, 162.0,
		50.0, 163.0,
		52.0, 159.0,
		54.0, 159.0,
		56.0, 149.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_60_0;
		g.setTransform(defaultTransform__0_60_0);
		g.setClip(clip__0_60_0);
		origAlpha = alpha__0_60;
		g.setTransform(defaultTransform__0_60);
		g.setClip(clip__0_60);
		float alpha__0_61 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_61 = g.getClip();
		AffineTransform defaultTransform__0_61 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_61 is CompositeGraphicsNode
		float alpha__0_61_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_61_0 = g.getClip();
		AffineTransform defaultTransform__0_61_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_61_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(150.0, 152.0,
		153.0, 151.0,
		151.0, 155.0,
		154.0, 157.0,
		154.0, 162.0,
		157.0, 171.0,
		152.0, 175.0,
		152.0, 178.0,
		148.0, 181.0,
		145.0, 180.0,
		144.0, 176.0,
		140.0, 175.0,
		141.0, 172.0,
		134.0, 165.0,
		139.0, 164.0,
		142.0, 166.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(150.0, 152.0,
		153.0, 151.0,
		151.0, 155.0,
		154.0, 157.0,
		154.0, 162.0,
		157.0, 171.0,
		152.0, 175.0,
		152.0, 178.0,
		148.0, 181.0,
		145.0, 180.0,
		144.0, 176.0,
		140.0, 175.0,
		141.0, 172.0,
		134.0, 165.0,
		139.0, 164.0,
		142.0, 166.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_61_0;
		g.setTransform(defaultTransform__0_61_0);
		g.setClip(clip__0_61_0);
		origAlpha = alpha__0_61;
		g.setTransform(defaultTransform__0_61);
		g.setClip(clip__0_61);
		float alpha__0_62 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_62 = g.getClip();
		AffineTransform defaultTransform__0_62 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_62 is CompositeGraphicsNode
		float alpha__0_62_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_62_0 = g.getClip();
		AffineTransform defaultTransform__0_62_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_62_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(213.0, 152.0,
		218.0, 156.0,
		215.0, 160.0,
		219.0, 162.0,
		223.0, 161.0,
		223.0, 163.0,
		226.0, 164.0,
		225.0, 166.0,
		229.0, 167.0,
		229.0, 170.0,
		221.0, 172.0,
		209.0, 168.0,
		208.0, 163.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(213.0, 152.0,
		218.0, 156.0,
		215.0, 160.0,
		219.0, 162.0,
		223.0, 161.0,
		223.0, 163.0,
		226.0, 164.0,
		225.0, 166.0,
		229.0, 167.0,
		229.0, 170.0,
		221.0, 172.0,
		209.0, 168.0,
		208.0, 163.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_62_0;
		g.setTransform(defaultTransform__0_62_0);
		g.setClip(clip__0_62_0);
		origAlpha = alpha__0_62;
		g.setTransform(defaultTransform__0_62);
		g.setClip(clip__0_62);
		
		paint12(g,colori,spessore);
		
		paint2(g,colori,spessore);

	}
	
	public static void paint12(Graphics2D g, int colori[], float spessore ) {
		
		
		float alpha__0_63 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_63 = g.getClip();
		AffineTransform defaultTransform__0_63 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_63 is CompositeGraphicsNode
		float alpha__0_63_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_63_0 = g.getClip();
		AffineTransform defaultTransform__0_63_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_63_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(92.0, 153.0,
		95.0, 152.0,
		99.0, 157.0,
		103.0, 156.0,
		87.0, 174.0,
		84.0, 181.0,
		81.0, 182.0,
		76.0, 180.0,
		78.0, 176.0,
		83.0, 173.0,
		86.0, 164.0,
		88.0, 165.0,
		90.0, 158.0,
		92.0, 158.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(92.0, 153.0,
		95.0, 152.0,
		99.0, 157.0,
		103.0, 156.0,
		87.0, 174.0,
		84.0, 181.0,
		81.0, 182.0,
		76.0, 180.0,
		78.0, 176.0,
		83.0, 173.0,
		86.0, 164.0,
		88.0, 165.0,
		90.0, 158.0,
		92.0, 158.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_63_0;
		g.setTransform(defaultTransform__0_63_0);
		g.setClip(clip__0_63_0);
		origAlpha = alpha__0_63;
		g.setTransform(defaultTransform__0_63);
		g.setClip(clip__0_63);
		float alpha__0_64 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_64 = g.getClip();
		AffineTransform defaultTransform__0_64 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_64 is CompositeGraphicsNode
		float alpha__0_64_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_64_0 = g.getClip();
		AffineTransform defaultTransform__0_64_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_64_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(168.0, 160.0,
		175.0, 163.0,
		173.0, 165.0,
		174.0, 178.0,
		172.0, 180.0,
		172.0, 188.0,
		167.0, 195.0,
		161.0, 197.0,
		159.0, 194.0,
		162.0, 192.0,
		162.0, 184.0,
		164.0, 181.0,
		159.0, 178.0,
		158.0, 180.0,
		157.0, 176.0,
		152.0, 178.0,
		152.0, 175.0,
		158.0, 167.0,
		157.0, 159.0,
		161.0, 154.0,
		167.0, 157.0,
		165.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(168.0, 160.0,
		175.0, 163.0,
		173.0, 165.0,
		174.0, 178.0,
		172.0, 180.0,
		172.0, 188.0,
		167.0, 195.0,
		161.0, 197.0,
		159.0, 194.0,
		162.0, 192.0,
		162.0, 184.0,
		164.0, 181.0,
		159.0, 178.0,
		158.0, 180.0,
		157.0, 176.0,
		152.0, 178.0,
		152.0, 175.0,
		158.0, 167.0,
		157.0, 159.0,
		161.0, 154.0,
		167.0, 157.0,
		165.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_64_0;
		g.setTransform(defaultTransform__0_64_0);
		g.setClip(clip__0_64_0);
		origAlpha = alpha__0_64;
		g.setTransform(defaultTransform__0_64);
		g.setClip(clip__0_64);
		float alpha__0_65 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_65 = g.getClip();
		AffineTransform defaultTransform__0_65 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_65 is CompositeGraphicsNode
		float alpha__0_65_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_65_0 = g.getClip();
		AffineTransform defaultTransform__0_65_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_65_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(183.0, 159.0,
		189.0, 160.0,
		188.0, 163.0,
		191.0, 164.0,
		193.0, 167.0,
		199.0, 167.0,
		199.0, 172.0,
		195.0, 174.0,
		185.0, 172.0,
		184.0, 180.0,
		174.0, 176.0,
		173.0, 172.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(183.0, 159.0,
		189.0, 160.0,
		188.0, 163.0,
		191.0, 164.0,
		193.0, 167.0,
		199.0, 167.0,
		199.0, 172.0,
		195.0, 174.0,
		185.0, 172.0,
		184.0, 180.0,
		174.0, 176.0,
		173.0, 172.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_65_0;
		g.setTransform(defaultTransform__0_65_0);
		g.setClip(clip__0_65_0);
		origAlpha = alpha__0_65;
		g.setTransform(defaultTransform__0_65);
		g.setClip(clip__0_65);
		float alpha__0_66 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_66 = g.getClip();
		AffineTransform defaultTransform__0_66 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_66 is CompositeGraphicsNode
		float alpha__0_66_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_66_0 = g.getClip();
		AffineTransform defaultTransform__0_66_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_66_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(25.0, 162.0,
		26.0, 158.0,
		30.0, 161.0,
		29.0, 163.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(25.0, 162.0,
		26.0, 158.0,
		30.0, 161.0,
		29.0, 163.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_66_0;
		g.setTransform(defaultTransform__0_66_0);
		g.setClip(clip__0_66_0);
		origAlpha = alpha__0_66;
		g.setTransform(defaultTransform__0_66);
		g.setClip(clip__0_66);
		float alpha__0_67 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_67 = g.getClip();
		AffineTransform defaultTransform__0_67 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_67 is CompositeGraphicsNode
		float alpha__0_67_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_67_0 = g.getClip();
		AffineTransform defaultTransform__0_67_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_67_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(38.0, 160.0,
		45.0, 170.0,
		48.0, 166.0,
		52.0, 169.0,
		51.0, 173.0,
		54.0, 172.0,
		54.0, 175.0,
		45.0, 178.0,
		42.0, 183.0,
		39.0, 184.0,
		36.0, 180.0,
		35.0, 172.0,
		32.0, 171.0,
		30.0, 168.0,
		31.0, 164.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(38.0, 160.0,
		45.0, 170.0,
		48.0, 166.0,
		52.0, 169.0,
		51.0, 173.0,
		54.0, 172.0,
		54.0, 175.0,
		45.0, 178.0,
		42.0, 183.0,
		39.0, 184.0,
		36.0, 180.0,
		35.0, 172.0,
		32.0, 171.0,
		30.0, 168.0,
		31.0, 164.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_67_0;
		g.setTransform(defaultTransform__0_67_0);
		g.setClip(clip__0_67_0);
		origAlpha = alpha__0_67;
		g.setTransform(defaultTransform__0_67);
		g.setClip(clip__0_67);
		float alpha__0_68 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_68 = g.getClip();
		AffineTransform defaultTransform__0_68 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_68 is CompositeGraphicsNode
		float alpha__0_68_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_68_0 = g.getClip();
		AffineTransform defaultTransform__0_68_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_68_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(135.0, 164.0,
		141.0, 172.0,
		138.0, 177.0,
		140.0, 180.0,
		132.0, 181.0,
		127.0, 185.0,
		121.0, 172.0,
		125.0, 163.0,
		128.0, 164.0,
		129.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(135.0, 164.0,
		141.0, 172.0,
		138.0, 177.0,
		140.0, 180.0,
		132.0, 181.0,
		127.0, 185.0,
		121.0, 172.0,
		125.0, 163.0,
		128.0, 164.0,
		129.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_68_0;
		g.setTransform(defaultTransform__0_68_0);
		g.setClip(clip__0_68_0);
		origAlpha = alpha__0_68;
		g.setTransform(defaultTransform__0_68);
		g.setClip(clip__0_68);
		float alpha__0_69 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_69 = g.getClip();
		AffineTransform defaultTransform__0_69 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_69 is CompositeGraphicsNode
		float alpha__0_69_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_69_0 = g.getClip();
		AffineTransform defaultTransform__0_69_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_69_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(103.0, 173.0,
		97.0, 182.0,
		94.0, 182.0,
		91.0, 185.0,
		85.0, 184.0,
		84.0, 179.0,
		98.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(103.0, 173.0,
		97.0, 182.0,
		94.0, 182.0,
		91.0, 185.0,
		85.0, 184.0,
		84.0, 179.0,
		98.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_69_0;
		g.setTransform(defaultTransform__0_69_0);
		g.setClip(clip__0_69_0);
		origAlpha = alpha__0_69;
		g.setTransform(defaultTransform__0_69);
		g.setClip(clip__0_69);
		float alpha__0_70 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_70 = g.getClip();
		AffineTransform defaultTransform__0_70 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_70 is CompositeGraphicsNode
		float alpha__0_70_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_70_0 = g.getClip();
		AffineTransform defaultTransform__0_70_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_70_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(229.0, 170.0,
		230.0, 169.0,
		225.0, 184.0,
		230.0, 182.0,
		235.0, 185.0,
		234.0, 190.0,
		232.0, 191.0,
		233.0, 203.0,
		231.0, 205.0,
		228.0, 203.0,
		225.0, 205.0,
		223.0, 215.0,
		216.0, 211.0,
		215.0, 221.0,
		211.0, 225.0,
		208.0, 222.0,
		209.0, 215.0,
		199.0, 210.0,
		207.0, 199.0,
		201.0, 196.0,
		197.0, 197.0,
		199.0, 190.0,
		194.0, 189.0,
		198.0, 180.0,
		198.0, 170.0,
		205.0, 170.0,
		207.0, 164.0,
		209.0, 168.0,
		221.0, 172.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(229.0, 170.0,
		230.0, 169.0,
		225.0, 184.0,
		230.0, 182.0,
		235.0, 185.0,
		234.0, 190.0,
		232.0, 191.0,
		233.0, 203.0,
		231.0, 205.0,
		228.0, 203.0,
		225.0, 205.0,
		223.0, 215.0,
		216.0, 211.0,
		215.0, 221.0,
		211.0, 225.0,
		208.0, 222.0,
		209.0, 215.0,
		199.0, 210.0,
		207.0, 199.0,
		201.0, 196.0,
		197.0, 197.0,
		199.0, 190.0,
		194.0, 189.0,
		198.0, 180.0,
		198.0, 170.0,
		205.0, 170.0,
		207.0, 164.0,
		209.0, 168.0,
		221.0, 172.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_70_0;
		g.setTransform(defaultTransform__0_70_0);
		g.setClip(clip__0_70_0);
		origAlpha = alpha__0_70;
		g.setTransform(defaultTransform__0_70);
		g.setClip(clip__0_70);
		float alpha__0_71 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_71 = g.getClip();
		AffineTransform defaultTransform__0_71 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_71 is CompositeGraphicsNode
		float alpha__0_71_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_71_0 = g.getClip();
		AffineTransform defaultTransform__0_71_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_71_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(199.0, 172.0,
		198.0, 180.0,
		195.0, 184.0,
		184.0, 180.0,
		185.0, 172.0,
		191.0, 174.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(199.0, 172.0,
		198.0, 180.0,
		195.0, 184.0,
		184.0, 180.0,
		185.0, 172.0,
		191.0, 174.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_71_0;
		g.setTransform(defaultTransform__0_71_0);
		g.setClip(clip__0_71_0);
		origAlpha = alpha__0_71;
		g.setTransform(defaultTransform__0_71);
		g.setClip(clip__0_71);
		float alpha__0_72 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_72 = g.getClip();
		AffineTransform defaultTransform__0_72 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_72 is CompositeGraphicsNode
		float alpha__0_72_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_72_0 = g.getClip();
		AffineTransform defaultTransform__0_72_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_72_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(106.0, 171.0,
		107.0, 173.0,
		112.0, 173.0,
		113.0, 176.0,
		110.0, 180.0,
		107.0, 190.0,
		100.0, 194.0,
		94.0, 205.0,
		91.0, 201.0,
		91.0, 197.0,
		96.0, 190.0,
		98.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(106.0, 171.0,
		107.0, 173.0,
		112.0, 173.0,
		113.0, 176.0,
		110.0, 180.0,
		107.0, 190.0,
		100.0, 194.0,
		94.0, 205.0,
		91.0, 201.0,
		91.0, 197.0,
		96.0, 190.0,
		98.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_72_0;
		g.setTransform(defaultTransform__0_72_0);
		g.setClip(clip__0_72_0);
		origAlpha = alpha__0_72;
		g.setTransform(defaultTransform__0_72);
		g.setClip(clip__0_72);
		float alpha__0_73 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_73 = g.getClip();
		AffineTransform defaultTransform__0_73 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_73 is CompositeGraphicsNode
		float alpha__0_73_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_73_0 = g.getClip();
		AffineTransform defaultTransform__0_73_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_73_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(110.0, 182.0,
		112.0, 178.0,
		116.0, 180.0,
		118.0, 179.0,
		121.0, 173.0,
		127.0, 185.0,
		123.0, 187.0,
		123.0, 189.0,
		121.0, 188.0,
		115.0, 191.0,
		112.0, 198.0,
		106.0, 199.0,
		104.0, 194.0,
		102.0, 194.0,
		103.0, 198.0,
		100.0, 195.0,
		107.0, 190.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(110.0, 182.0,
		112.0, 178.0,
		116.0, 180.0,
		118.0, 179.0,
		121.0, 173.0,
		127.0, 185.0,
		123.0, 187.0,
		123.0, 189.0,
		121.0, 188.0,
		115.0, 191.0,
		112.0, 198.0,
		106.0, 199.0,
		104.0, 194.0,
		102.0, 194.0,
		103.0, 198.0,
		100.0, 195.0,
		107.0, 190.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_73_0;
		g.setTransform(defaultTransform__0_73_0);
		g.setClip(clip__0_73_0);
		origAlpha = alpha__0_73;
		g.setTransform(defaultTransform__0_73);
		g.setClip(clip__0_73);
		float alpha__0_74 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_74 = g.getClip();
		AffineTransform defaultTransform__0_74 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_74 is CompositeGraphicsNode
		float alpha__0_74_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_74_0 = g.getClip();
		AffineTransform defaultTransform__0_74_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_74_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(145.0, 180.0,
		137.0, 188.0,
		133.0, 189.0,
		131.0, 195.0,
		133.0, 198.0,
		130.0, 200.0,
		128.0, 198.0,
		125.0, 201.0,
		122.0, 200.0,
		121.0, 206.0,
		112.0, 213.0,
		111.0, 207.0,
		118.0, 197.0,
		117.0, 194.0,
		115.0, 194.0,
		115.0, 191.0,
		121.0, 188.0,
		123.0, 189.0,
		123.0, 187.0,
		125.0, 187.0,
		132.0, 181.0,
		139.0, 181.0,
		140.0, 180.0,
		138.0, 177.0,
		140.0, 175.0,
		144.0, 176.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(145.0, 180.0,
		137.0, 188.0,
		133.0, 189.0,
		131.0, 195.0,
		133.0, 198.0,
		130.0, 200.0,
		128.0, 198.0,
		125.0, 201.0,
		122.0, 200.0,
		121.0, 206.0,
		112.0, 213.0,
		111.0, 207.0,
		118.0, 197.0,
		117.0, 194.0,
		115.0, 194.0,
		115.0, 191.0,
		121.0, 188.0,
		123.0, 189.0,
		123.0, 187.0,
		125.0, 187.0,
		132.0, 181.0,
		139.0, 181.0,
		140.0, 180.0,
		138.0, 177.0,
		140.0, 175.0,
		144.0, 176.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_74_0;
		g.setTransform(defaultTransform__0_74_0);
		g.setClip(clip__0_74_0);
		origAlpha = alpha__0_74;
		g.setTransform(defaultTransform__0_74);
		g.setClip(clip__0_74);
		float alpha__0_75 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_75 = g.getClip();
		AffineTransform defaultTransform__0_75 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_75 is CompositeGraphicsNode
		float alpha__0_75_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_75_0 = g.getClip();
		AffineTransform defaultTransform__0_75_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_75_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(174.0, 176.0,
		195.0, 184.0,
		188.0, 198.0,
		181.0, 195.0,
		179.0, 199.0,
		172.0, 201.0,
		167.0, 201.0,
		169.0, 200.0,
		167.0, 198.0,
		162.0, 198.0,
		164.0, 195.0,
		167.0, 195.0,
		172.0, 188.0,
		172.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(174.0, 176.0,
		195.0, 184.0,
		188.0, 198.0,
		181.0, 195.0,
		179.0, 199.0,
		172.0, 201.0,
		167.0, 201.0,
		169.0, 200.0,
		167.0, 198.0,
		162.0, 198.0,
		164.0, 195.0,
		167.0, 195.0,
		172.0, 188.0,
		172.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_75_0;
		g.setTransform(defaultTransform__0_75_0);
		g.setClip(clip__0_75_0);
		origAlpha = alpha__0_75;
		g.setTransform(defaultTransform__0_75);
		g.setClip(clip__0_75);
		float alpha__0_76 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_76 = g.getClip();
		AffineTransform defaultTransform__0_76 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_76 is CompositeGraphicsNode
		float alpha__0_76_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_76_0 = g.getClip();
		AffineTransform defaultTransform__0_76_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_76_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(145.0, 180.0,
		148.0, 181.0,
		157.0, 176.0,
		158.0, 180.0,
		159.0, 178.0,
		164.0, 181.0,
		162.0, 184.0,
		162.0, 192.0,
		159.0, 194.0,
		161.0, 197.0,
		156.0, 199.0,
		152.0, 203.0,
		144.0, 200.0,
		141.0, 190.0,
		137.0, 189.0,
		143.0, 181.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(145.0, 180.0,
		148.0, 181.0,
		157.0, 176.0,
		158.0, 180.0,
		159.0, 178.0,
		164.0, 181.0,
		162.0, 184.0,
		162.0, 192.0,
		159.0, 194.0,
		161.0, 197.0,
		156.0, 199.0,
		152.0, 203.0,
		144.0, 200.0,
		141.0, 190.0,
		137.0, 189.0,
		143.0, 181.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_76_0;
		g.setTransform(defaultTransform__0_76_0);
		g.setClip(clip__0_76_0);
		origAlpha = alpha__0_76;
		g.setTransform(defaultTransform__0_76);
		g.setClip(clip__0_76);
		float alpha__0_77 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_77 = g.getClip();
		AffineTransform defaultTransform__0_77 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_77 is CompositeGraphicsNode
		float alpha__0_77_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_77_0 = g.getClip();
		AffineTransform defaultTransform__0_77_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_77_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(194.0, 189.0,
		199.0, 190.0,
		197.0, 197.0,
		201.0, 196.0,
		207.0, 199.0,
		202.0, 206.0,
		199.0, 208.0,
		198.0, 207.0,
		197.0, 209.0,
		191.0, 207.0,
		190.0, 208.0,
		189.0, 206.0,
		181.0, 218.0,
		177.0, 213.0,
		185.0, 205.0,
		188.0, 197.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(194.0, 189.0,
		199.0, 190.0,
		197.0, 197.0,
		201.0, 196.0,
		207.0, 199.0,
		202.0, 206.0,
		199.0, 208.0,
		198.0, 207.0,
		197.0, 209.0,
		191.0, 207.0,
		190.0, 208.0,
		189.0, 206.0,
		181.0, 218.0,
		177.0, 213.0,
		185.0, 205.0,
		188.0, 197.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_77_0;
		g.setTransform(defaultTransform__0_77_0);
		g.setClip(clip__0_77_0);
		origAlpha = alpha__0_77;
		g.setTransform(defaultTransform__0_77);
		g.setClip(clip__0_77);
		float alpha__0_78 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_78 = g.getClip();
		AffineTransform defaultTransform__0_78 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_78 is CompositeGraphicsNode
		float alpha__0_78_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_78_0 = g.getClip();
		AffineTransform defaultTransform__0_78_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_78_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(125.0, 201.0,
		128.0, 198.0,
		130.0, 200.0,
		133.0, 198.0,
		131.0, 195.0,
		136.0, 188.0,
		138.0, 190.0,
		141.0, 190.0,
		144.0, 200.0,
		152.0, 202.0,
		153.0, 206.0,
		152.0, 209.0,
		149.0, 208.0,
		149.0, 214.0,
		140.0, 214.0,
		136.0, 212.0,
		137.0, 214.0,
		132.0, 216.0,
		126.0, 213.0,
		129.0, 207.0,
		126.0, 204.0,
		127.0, 203.0,
		124.0, 203.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(125.0, 201.0,
		128.0, 198.0,
		130.0, 200.0,
		133.0, 198.0,
		131.0, 195.0,
		136.0, 188.0,
		138.0, 190.0,
		141.0, 190.0,
		144.0, 200.0,
		152.0, 202.0,
		153.0, 206.0,
		152.0, 209.0,
		149.0, 208.0,
		149.0, 214.0,
		140.0, 214.0,
		136.0, 212.0,
		137.0, 214.0,
		132.0, 216.0,
		126.0, 213.0,
		129.0, 207.0,
		126.0, 204.0,
		127.0, 203.0,
		124.0, 203.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_78_0;
		g.setTransform(defaultTransform__0_78_0);
		g.setClip(clip__0_78_0);
		origAlpha = alpha__0_78;
		g.setTransform(defaultTransform__0_78);
		g.setClip(clip__0_78);
		float alpha__0_79 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_79 = g.getClip();
		AffineTransform defaultTransform__0_79 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_79 is CompositeGraphicsNode
		float alpha__0_79_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_79_0 = g.getClip();
		AffineTransform defaultTransform__0_79_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_79_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(100.0, 196.0,
		103.0, 198.0,
		102.0, 194.0,
		106.0, 199.0,
		112.0, 198.0,
		115.0, 194.0,
		118.0, 195.0,
		118.0, 198.0,
		111.0, 207.0,
		111.0, 221.0,
		100.0, 223.0,
		94.0, 214.0,
		91.0, 214.0,
		91.0, 211.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(100.0, 196.0,
		103.0, 198.0,
		102.0, 194.0,
		106.0, 199.0,
		112.0, 198.0,
		115.0, 194.0,
		118.0, 195.0,
		118.0, 198.0,
		111.0, 207.0,
		111.0, 221.0,
		100.0, 223.0,
		94.0, 214.0,
		91.0, 214.0,
		91.0, 211.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_79_0;
		g.setTransform(defaultTransform__0_79_0);
		g.setClip(clip__0_79_0);
		origAlpha = alpha__0_79;
		g.setTransform(defaultTransform__0_79);
		g.setClip(clip__0_79);
		float alpha__0_80 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_80 = g.getClip();
		AffineTransform defaultTransform__0_80 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_80 is CompositeGraphicsNode
		float alpha__0_80_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_80_0 = g.getClip();
		AffineTransform defaultTransform__0_80_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_80_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(161.0, 197.0,
		167.0, 198.0,
		169.0, 200.0,
		167.0, 201.0,
		179.0, 199.0,
		181.0, 195.0,
		188.0, 198.0,
		185.0, 205.0,
		171.0, 218.0,
		167.0, 215.0,
		159.0, 213.0,
		156.0, 209.0,
		152.0, 209.0,
		153.0, 206.0,
		151.0, 203.0,
		156.0, 199.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(161.0, 197.0,
		167.0, 198.0,
		169.0, 200.0,
		167.0, 201.0,
		179.0, 199.0,
		181.0, 195.0,
		188.0, 198.0,
		185.0, 205.0,
		171.0, 218.0,
		167.0, 215.0,
		159.0, 213.0,
		156.0, 209.0,
		152.0, 209.0,
		153.0, 206.0,
		151.0, 203.0,
		156.0, 199.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_80_0;
		g.setTransform(defaultTransform__0_80_0);
		g.setClip(clip__0_80_0);
		origAlpha = alpha__0_80;
		g.setTransform(defaultTransform__0_80);
		g.setClip(clip__0_80);
		float alpha__0_81 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_81 = g.getClip();
		AffineTransform defaultTransform__0_81 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_81 is CompositeGraphicsNode
		float alpha__0_81_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_81_0 = g.getClip();
		AffineTransform defaultTransform__0_81_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_81_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(291.0, 148.0,
		290.0, 152.0,
		295.0, 153.0,
		291.0, 159.0,
		280.0, 156.0,
		277.0, 153.0,
		273.0, 152.0,
		280.0, 142.0,
		281.0, 148.0,
		287.0, 141.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(291.0, 148.0,
		290.0, 152.0,
		295.0, 153.0,
		291.0, 159.0,
		280.0, 156.0,
		277.0, 153.0,
		273.0, 152.0,
		280.0, 142.0,
		281.0, 148.0,
		287.0, 141.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_81_0;
		g.setTransform(defaultTransform__0_81_0);
		g.setClip(clip__0_81_0);
		origAlpha = alpha__0_81;
		g.setTransform(defaultTransform__0_81);
		g.setClip(clip__0_81);
		float alpha__0_82 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_82 = g.getClip();
		AffineTransform defaultTransform__0_82 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_82 is CompositeGraphicsNode
		float alpha__0_82_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_82_0 = g.getClip();
		AffineTransform defaultTransform__0_82_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_82_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(414.0, 152.0,
		414.0, 157.0,
		421.0, 155.0,
		422.0, 160.0,
		426.0, 161.0,
		427.0, 166.0,
		425.0, 170.0,
		426.0, 174.0,
		420.0, 173.0,
		417.0, 181.0,
		403.0, 181.0,
		400.0, 172.0,
		379.0, 163.0,
		384.0, 156.0,
		381.0, 151.0,
		386.0, 154.0,
		388.0, 150.0,
		396.0, 148.0,
		402.0, 152.0,
		405.0, 149.0,
		409.0, 150.0,
		410.0, 152.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(414.0, 152.0,
		414.0, 157.0,
		421.0, 155.0,
		422.0, 160.0,
		426.0, 161.0,
		427.0, 166.0,
		425.0, 170.0,
		426.0, 174.0,
		420.0, 173.0,
		417.0, 181.0,
		403.0, 181.0,
		400.0, 172.0,
		379.0, 163.0,
		384.0, 156.0,
		381.0, 151.0,
		386.0, 154.0,
		388.0, 150.0,
		396.0, 148.0,
		402.0, 152.0,
		405.0, 149.0,
		409.0, 150.0,
		410.0, 152.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_82_0;
		g.setTransform(defaultTransform__0_82_0);
		g.setClip(clip__0_82_0);
		origAlpha = alpha__0_82;
		g.setTransform(defaultTransform__0_82);
		g.setClip(clip__0_82);
		float alpha__0_83 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_83 = g.getClip();
		AffineTransform defaultTransform__0_83 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_83 is CompositeGraphicsNode
		float alpha__0_83_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_83_0 = g.getClip();
		AffineTransform defaultTransform__0_83_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_83_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(353.0, 149.0,
		359.0, 151.0,
		364.0, 156.0,
		366.0, 154.0,
		380.0, 153.0,
		381.0, 151.0,
		384.0, 156.0,
		377.0, 168.0,
		365.0, 171.0,
		362.0, 170.0,
		358.0, 172.0,
		352.0, 171.0,
		344.0, 179.0,
		341.0, 174.0,
		337.0, 174.0,
		336.0, 171.0,
		343.0, 164.0,
		348.0, 156.0,
		346.0, 154.0,
		350.0, 148.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(353.0, 149.0,
		359.0, 151.0,
		364.0, 156.0,
		366.0, 154.0,
		380.0, 153.0,
		381.0, 151.0,
		384.0, 156.0,
		377.0, 168.0,
		365.0, 171.0,
		362.0, 170.0,
		358.0, 172.0,
		352.0, 171.0,
		344.0, 179.0,
		341.0, 174.0,
		337.0, 174.0,
		336.0, 171.0,
		343.0, 164.0,
		348.0, 156.0,
		346.0, 154.0,
		350.0, 148.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_83_0;
		g.setTransform(defaultTransform__0_83_0);
		g.setClip(clip__0_83_0);
		origAlpha = alpha__0_83;
		g.setTransform(defaultTransform__0_83);
		g.setClip(clip__0_83);
		float alpha__0_84 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_84 = g.getClip();
		AffineTransform defaultTransform__0_84 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_84 is CompositeGraphicsNode
		float alpha__0_84_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_84_0 = g.getClip();
		AffineTransform defaultTransform__0_84_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_84_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(347.0, 152.0,
		346.0, 154.0,
		348.0, 156.0,
		343.0, 164.0,
		341.0, 162.0,
		337.0, 162.0,
		330.0, 170.0,
		327.0, 167.0,
		330.0, 162.0,
		327.0, 158.0,
		328.0, 156.0,
		331.0, 156.0,
		336.0, 150.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(347.0, 152.0,
		346.0, 154.0,
		348.0, 156.0,
		343.0, 164.0,
		341.0, 162.0,
		337.0, 162.0,
		330.0, 170.0,
		327.0, 167.0,
		330.0, 162.0,
		327.0, 158.0,
		328.0, 156.0,
		331.0, 156.0,
		336.0, 150.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_84_0;
		g.setTransform(defaultTransform__0_84_0);
		g.setClip(clip__0_84_0);
		origAlpha = alpha__0_84;
		g.setTransform(defaultTransform__0_84);
		g.setClip(clip__0_84);
		float alpha__0_85 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_85 = g.getClip();
		AffineTransform defaultTransform__0_85 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_85 is CompositeGraphicsNode
		float alpha__0_85_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_85_0 = g.getClip();
		AffineTransform defaultTransform__0_85_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_85_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(269.0, 158.0,
		273.0, 152.0,
		277.0, 153.0,
		280.0, 156.0,
		291.0, 159.0,
		291.0, 162.0,
		289.0, 162.0,
		286.0, 167.0,
		288.0, 168.0,
		279.0, 170.0,
		278.0, 173.0,
		271.0, 177.0,
		273.0, 163.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(269.0, 158.0,
		273.0, 152.0,
		277.0, 153.0,
		280.0, 156.0,
		291.0, 159.0,
		291.0, 162.0,
		289.0, 162.0,
		286.0, 167.0,
		288.0, 168.0,
		279.0, 170.0,
		278.0, 173.0,
		271.0, 177.0,
		273.0, 163.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_85_0;
		g.setTransform(defaultTransform__0_85_0);
		g.setClip(clip__0_85_0);
		origAlpha = alpha__0_85;
		g.setTransform(defaultTransform__0_85);
		g.setClip(clip__0_85);
		float alpha__0_86 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_86 = g.getClip();
		AffineTransform defaultTransform__0_86 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_86 is CompositeGraphicsNode
		float alpha__0_86_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_86_0 = g.getClip();
		AffineTransform defaultTransform__0_86_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_86_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(314.0, 159.0,
		314.0, 163.0,
		306.0, 164.0,
		303.0, 166.0,
		298.0, 164.0,
		295.0, 169.0,
		290.0, 165.0,
		288.0, 168.0,
		286.0, 167.0,
		289.0, 162.0,
		291.0, 162.0,
		291.0, 158.0,
		295.0, 153.0,
		300.0, 153.0,
		302.0, 156.0,
		307.0, 155.0,
		309.0, 158.0,
		312.0, 157.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(314.0, 159.0,
		314.0, 163.0,
		306.0, 164.0,
		303.0, 166.0,
		298.0, 164.0,
		295.0, 169.0,
		290.0, 165.0,
		288.0, 168.0,
		286.0, 167.0,
		289.0, 162.0,
		291.0, 162.0,
		291.0, 158.0,
		295.0, 153.0,
		300.0, 153.0,
		302.0, 156.0,
		307.0, 155.0,
		309.0, 158.0,
		312.0, 157.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_86_0;
		g.setTransform(defaultTransform__0_86_0);
		g.setClip(clip__0_86_0);
		origAlpha = alpha__0_86;
		g.setTransform(defaultTransform__0_86);
		g.setClip(clip__0_86);
		float alpha__0_87 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_87 = g.getClip();
		AffineTransform defaultTransform__0_87 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_87 is CompositeGraphicsNode
		float alpha__0_87_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_87_0 = g.getClip();
		AffineTransform defaultTransform__0_87_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_87_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(328.0, 157.0,
		327.0, 159.0,
		330.0, 162.0,
		327.0, 167.0,
		330.0, 170.0,
		329.0, 176.0,
		331.0, 176.0,
		329.0, 180.0,
		331.0, 183.0,
		328.0, 190.0,
		325.0, 189.0,
		325.0, 185.0,
		322.0, 181.0,
		322.0, 174.0,
		325.0, 167.0,
		315.0, 173.0,
		314.0, 164.0,
		321.0, 158.0,
		326.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(328.0, 157.0,
		327.0, 159.0,
		330.0, 162.0,
		327.0, 167.0,
		330.0, 170.0,
		329.0, 176.0,
		331.0, 176.0,
		329.0, 180.0,
		331.0, 183.0,
		328.0, 190.0,
		325.0, 189.0,
		325.0, 185.0,
		322.0, 181.0,
		322.0, 174.0,
		325.0, 167.0,
		315.0, 173.0,
		314.0, 164.0,
		321.0, 158.0,
		326.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_87_0;
		g.setTransform(defaultTransform__0_87_0);
		g.setClip(clip__0_87_0);
		origAlpha = alpha__0_87;
		g.setTransform(defaultTransform__0_87);
		g.setClip(clip__0_87);
		float alpha__0_88 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_88 = g.getClip();
		AffineTransform defaultTransform__0_88 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_88 is CompositeGraphicsNode
		float alpha__0_88_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_88_0 = g.getClip();
		AffineTransform defaultTransform__0_88_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_88_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(316.0, 161.0,
		314.0, 164.0,
		315.0, 173.0,
		308.0, 173.0,
		308.0, 164.0,
		314.0, 163.0,
		313.0, 160.0,
		318.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(316.0, 161.0,
		314.0, 164.0,
		315.0, 173.0,
		308.0, 173.0,
		308.0, 164.0,
		314.0, 163.0,
		313.0, 160.0,
		318.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_88_0;
		g.setTransform(defaultTransform__0_88_0);
		g.setClip(clip__0_88_0);
		origAlpha = alpha__0_88;
		g.setTransform(defaultTransform__0_88);
		g.setClip(clip__0_88);
		float alpha__0_89 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_89 = g.getClip();
		AffineTransform defaultTransform__0_89 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_89 is CompositeGraphicsNode
		float alpha__0_89_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_89_0 = g.getClip();
		AffineTransform defaultTransform__0_89_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_89_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(266.0, 159.0,
		268.0, 158.0,
		273.0, 163.0,
		271.0, 170.0,
		272.0, 174.0,
		269.0, 181.0,
		263.0, 178.0,
		264.0, 176.0,
		260.0, 174.0,
		261.0, 170.0,
		263.0, 170.0,
		261.0, 164.0,
		262.0, 161.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(266.0, 159.0,
		268.0, 158.0,
		273.0, 163.0,
		271.0, 170.0,
		272.0, 174.0,
		269.0, 181.0,
		263.0, 178.0,
		264.0, 176.0,
		260.0, 174.0,
		261.0, 170.0,
		263.0, 170.0,
		261.0, 164.0,
		262.0, 161.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_89_0;
		g.setTransform(defaultTransform__0_89_0);
		g.setClip(clip__0_89_0);
		origAlpha = alpha__0_89;
		g.setTransform(defaultTransform__0_89);
		g.setClip(clip__0_89);
		float alpha__0_90 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_90 = g.getClip();
		AffineTransform defaultTransform__0_90 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_90 is CompositeGraphicsNode
		float alpha__0_90_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_90_0 = g.getClip();
		AffineTransform defaultTransform__0_90_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_90_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(251.0, 161.0,
		252.0, 169.0,
		245.0, 169.0,
		243.0, 176.0,
		241.0, 176.0,
		240.0, 182.0,
		237.0, 182.0,
		237.0, 178.0,
		240.0, 175.0,
		239.0, 171.0,
		241.0, 171.0,
		240.0, 168.0,
		238.0, 168.0,
		239.0, 165.0,
		243.0, 164.0,
		246.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(251.0, 161.0,
		252.0, 169.0,
		245.0, 169.0,
		243.0, 176.0,
		241.0, 176.0,
		240.0, 182.0,
		237.0, 182.0,
		237.0, 178.0,
		240.0, 175.0,
		239.0, 171.0,
		241.0, 171.0,
		240.0, 168.0,
		238.0, 168.0,
		239.0, 165.0,
		243.0, 164.0,
		246.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_90_0;
		g.setTransform(defaultTransform__0_90_0);
		g.setClip(clip__0_90_0);
		origAlpha = alpha__0_90;
		g.setTransform(defaultTransform__0_90);
		g.setClip(clip__0_90);
		float alpha__0_91 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_91 = g.getClip();
		AffineTransform defaultTransform__0_91 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_91 is CompositeGraphicsNode
		float alpha__0_91_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_91_0 = g.getClip();
		AffineTransform defaultTransform__0_91_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_91_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(379.0, 163.0,
		400.0, 172.0,
		404.0, 180.0,
		393.0, 183.0,
		390.0, 189.0,
		375.0, 189.0,
		370.0, 192.0,
		377.0, 187.0,
		376.0, 183.0,
		372.0, 185.0,
		368.0, 180.0,
		370.0, 180.0,
		371.0, 174.0,
		378.0, 167.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(379.0, 163.0,
		400.0, 172.0,
		404.0, 180.0,
		393.0, 183.0,
		390.0, 189.0,
		375.0, 189.0,
		370.0, 192.0,
		377.0, 187.0,
		376.0, 183.0,
		372.0, 185.0,
		368.0, 180.0,
		370.0, 180.0,
		371.0, 174.0,
		378.0, 167.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_91_0;
		g.setTransform(defaultTransform__0_91_0);
		g.setClip(clip__0_91_0);
		origAlpha = alpha__0_91;
		g.setTransform(defaultTransform__0_91);
		g.setClip(clip__0_91);
		float alpha__0_92 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_92 = g.getClip();
		AffineTransform defaultTransform__0_92 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_92 is CompositeGraphicsNode
		float alpha__0_92_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_92_0 = g.getClip();
		AffineTransform defaultTransform__0_92_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_92_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(343.0, 163.0,
		339.0, 169.0,
		333.0, 174.0,
		333.0, 176.0,
		329.0, 176.0,
		330.0, 168.0,
		337.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(343.0, 163.0,
		339.0, 169.0,
		333.0, 174.0,
		333.0, 176.0,
		329.0, 176.0,
		330.0, 168.0,
		337.0, 162.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_92_0;
		g.setTransform(defaultTransform__0_92_0);
		g.setClip(clip__0_92_0);
		origAlpha = alpha__0_92;
		g.setTransform(defaultTransform__0_92);
		g.setClip(clip__0_92);
		float alpha__0_93 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_93 = g.getClip();
		AffineTransform defaultTransform__0_93 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_93 is CompositeGraphicsNode
		float alpha__0_93_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_93_0 = g.getClip();
		AffineTransform defaultTransform__0_93_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_93_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(261.0, 161.0,
		263.0, 170.0,
		252.0, 169.0,
		251.0, 161.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(261.0, 161.0,
		263.0, 170.0,
		252.0, 169.0,
		251.0, 161.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_93_0;
		g.setTransform(defaultTransform__0_93_0);
		g.setClip(clip__0_93_0);
		origAlpha = alpha__0_93;
		g.setTransform(defaultTransform__0_93);
		g.setClip(clip__0_93);
		float alpha__0_94 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_94 = g.getClip();
		AffineTransform defaultTransform__0_94 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_94 is CompositeGraphicsNode
		float alpha__0_94_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_94_0 = g.getClip();
		AffineTransform defaultTransform__0_94_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_94_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(230.0, 169.0,
		235.0, 162.0,
		244.0, 163.0,
		239.0, 165.0,
		238.0, 168.0,
		240.0, 168.0,
		241.0, 171.0,
		239.0, 171.0,
		240.0, 175.0,
		237.0, 178.0,
		237.0, 182.0,
		235.0, 185.0,
		230.0, 182.0,
		225.0, 184.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(230.0, 169.0,
		235.0, 162.0,
		244.0, 163.0,
		239.0, 165.0,
		238.0, 168.0,
		240.0, 168.0,
		241.0, 171.0,
		239.0, 171.0,
		240.0, 175.0,
		237.0, 178.0,
		237.0, 182.0,
		235.0, 185.0,
		230.0, 182.0,
		225.0, 184.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_94_0;
		g.setTransform(defaultTransform__0_94_0);
		g.setClip(clip__0_94_0);
		origAlpha = alpha__0_94;
		g.setTransform(defaultTransform__0_94);
		g.setClip(clip__0_94);
		float alpha__0_95 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_95 = g.getClip();
		AffineTransform defaultTransform__0_95 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_95 is CompositeGraphicsNode
		float alpha__0_95_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_95_0 = g.getClip();
		AffineTransform defaultTransform__0_95_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_95_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(308.0, 164.0,
		309.0, 175.0,
		300.0, 177.0,
		295.0, 170.0,
		299.0, 165.0,
		303.0, 166.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(308.0, 164.0,
		309.0, 175.0,
		300.0, 177.0,
		295.0, 170.0,
		299.0, 165.0,
		303.0, 166.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_95_0;
		g.setTransform(defaultTransform__0_95_0);
		g.setClip(clip__0_95_0);
		origAlpha = alpha__0_95;
		g.setTransform(defaultTransform__0_95);
		g.setClip(clip__0_95);
		float alpha__0_96 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_96 = g.getClip();
		AffineTransform defaultTransform__0_96 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_96 is CompositeGraphicsNode
		float alpha__0_96_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_96_0 = g.getClip();
		AffineTransform defaultTransform__0_96_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_96_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(299.0, 165.0,
		295.0, 170.0,
		300.0, 177.0,
		296.0, 182.0,
		296.0, 187.0,
		292.0, 186.0,
		292.0, 188.0,
		289.0, 188.0,
		286.0, 185.0,
		290.0, 181.0,
		290.0, 175.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(299.0, 165.0,
		295.0, 170.0,
		300.0, 177.0,
		296.0, 182.0,
		296.0, 187.0,
		292.0, 186.0,
		292.0, 188.0,
		289.0, 188.0,
		286.0, 185.0,
		290.0, 181.0,
		290.0, 175.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_96_0;
		g.setTransform(defaultTransform__0_96_0);
		g.setClip(clip__0_96_0);
		origAlpha = alpha__0_96;
		g.setTransform(defaultTransform__0_96);
		g.setClip(clip__0_96);
		float alpha__0_97 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_97 = g.getClip();
		AffineTransform defaultTransform__0_97 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_97 is CompositeGraphicsNode
		float alpha__0_97_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_97_0 = g.getClip();
		AffineTransform defaultTransform__0_97_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_97_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(296.0, 167.0,
		290.0, 176.0,
		290.0, 181.0,
		286.0, 185.0,
		289.0, 188.0,
		288.0, 191.0,
		282.0, 191.0,
		275.0, 185.0,
		275.0, 175.0,
		279.0, 170.0,
		288.0, 168.0,
		290.0, 165.0,
		295.0, 169.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(296.0, 167.0,
		290.0, 176.0,
		290.0, 181.0,
		286.0, 185.0,
		289.0, 188.0,
		288.0, 191.0,
		282.0, 191.0,
		275.0, 185.0,
		275.0, 175.0,
		279.0, 170.0,
		288.0, 168.0,
		290.0, 165.0,
		295.0, 169.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_97_0;
		g.setTransform(defaultTransform__0_97_0);
		g.setClip(clip__0_97_0);
		origAlpha = alpha__0_97;
		g.setTransform(defaultTransform__0_97);
		g.setClip(clip__0_97);
		float alpha__0_98 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_98 = g.getClip();
		AffineTransform defaultTransform__0_98 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_98 is CompositeGraphicsNode
		float alpha__0_98_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_98_0 = g.getClip();
		AffineTransform defaultTransform__0_98_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_98_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(377.0, 168.0,
		371.0, 174.0,
		370.0, 180.0,
		368.0, 180.0,
		370.0, 181.0,
		373.0, 187.0,
		361.0, 189.0,
		361.0, 185.0,
		355.0, 183.0,
		358.0, 177.0,
		353.0, 175.0,
		353.0, 171.0,
		365.0, 171.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(377.0, 168.0,
		371.0, 174.0,
		370.0, 180.0,
		368.0, 180.0,
		370.0, 181.0,
		373.0, 187.0,
		361.0, 189.0,
		361.0, 185.0,
		355.0, 183.0,
		358.0, 177.0,
		353.0, 175.0,
		353.0, 171.0,
		365.0, 171.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_98_0;
		g.setTransform(defaultTransform__0_98_0);
		g.setClip(clip__0_98_0);
		origAlpha = alpha__0_98;
		g.setTransform(defaultTransform__0_98);
		g.setClip(clip__0_98);
		float alpha__0_99 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_99 = g.getClip();
		AffineTransform defaultTransform__0_99 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_99 is CompositeGraphicsNode
		float alpha__0_99_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_99_0 = g.getClip();
		AffineTransform defaultTransform__0_99_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_99_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(309.0, 173.0,
		314.0, 173.0,
		325.0, 167.0,
		322.0, 174.0,
		322.0, 181.0,
		325.0, 185.0,
		325.0, 189.0,
		328.0, 190.0,
		331.0, 183.0,
		336.0, 184.0,
		338.0, 187.0,
		335.0, 198.0,
		332.0, 196.0,
		328.0, 197.0,
		328.0, 195.0,
		325.0, 194.0,
		324.0, 192.0,
		321.0, 194.0,
		316.0, 212.0,
		303.0, 204.0,
		308.0, 191.0,
		303.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(309.0, 173.0,
		314.0, 173.0,
		325.0, 167.0,
		322.0, 174.0,
		322.0, 181.0,
		325.0, 185.0,
		325.0, 189.0,
		328.0, 190.0,
		331.0, 183.0,
		336.0, 184.0,
		338.0, 187.0,
		335.0, 198.0,
		332.0, 196.0,
		328.0, 197.0,
		328.0, 195.0,
		325.0, 194.0,
		324.0, 192.0,
		321.0, 194.0,
		316.0, 212.0,
		303.0, 204.0,
		308.0, 191.0,
		303.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_99_0;
		g.setTransform(defaultTransform__0_99_0);
		g.setClip(clip__0_99_0);
		origAlpha = alpha__0_99;
		g.setTransform(defaultTransform__0_99);
		g.setClip(clip__0_99);
		float alpha__0_100 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_100 = g.getClip();
		AffineTransform defaultTransform__0_100 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_100 is CompositeGraphicsNode
		float alpha__0_100_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_100_0 = g.getClip();
		AffineTransform defaultTransform__0_100_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_100_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(353.0, 171.0,
		353.0, 175.0,
		358.0, 177.0,
		356.0, 184.0,
		352.0, 188.0,
		342.0, 183.0,
		346.0, 175.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(353.0, 171.0,
		353.0, 175.0,
		358.0, 177.0,
		356.0, 184.0,
		352.0, 188.0,
		342.0, 183.0,
		346.0, 175.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_100_0;
		g.setTransform(defaultTransform__0_100_0);
		g.setClip(clip__0_100_0);
		origAlpha = alpha__0_100;
		g.setTransform(defaultTransform__0_100);
		g.setClip(clip__0_100);
		float alpha__0_101 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_101 = g.getClip();
		AffineTransform defaultTransform__0_101 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_101 is CompositeGraphicsNode
		float alpha__0_101_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_101_0 = g.getClip();
		AffineTransform defaultTransform__0_101_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_101_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(261.0, 170.0,
		258.0, 178.0,
		261.0, 179.0,
		253.0, 182.0,
		251.0, 186.0,
		246.0, 182.0,
		239.0, 184.0,
		241.0, 176.0,
		243.0, 176.0,
		245.0, 169.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(261.0, 170.0,
		258.0, 178.0,
		261.0, 179.0,
		253.0, 182.0,
		251.0, 186.0,
		246.0, 182.0,
		239.0, 184.0,
		241.0, 176.0,
		243.0, 176.0,
		245.0, 169.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_101_0;
		g.setTransform(defaultTransform__0_101_0);
		g.setClip(clip__0_101_0);
		origAlpha = alpha__0_101;
		g.setTransform(defaultTransform__0_101);
		g.setClip(clip__0_101);
		float alpha__0_102 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_102 = g.getClip();
		AffineTransform defaultTransform__0_102 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_102 is CompositeGraphicsNode
		float alpha__0_102_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_102_0 = g.getClip();
		AffineTransform defaultTransform__0_102_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_102_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(336.0, 171.0,
		337.0, 174.0,
		341.0, 174.0,
		342.0, 178.0,
		345.0, 180.0,
		342.0, 183.0,
		344.0, 184.0,
		340.0, 187.0,
		329.0, 181.0,
		333.0, 174.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(336.0, 171.0,
		337.0, 174.0,
		341.0, 174.0,
		342.0, 178.0,
		345.0, 180.0,
		342.0, 183.0,
		344.0, 184.0,
		340.0, 187.0,
		329.0, 181.0,
		333.0, 174.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_102_0;
		g.setTransform(defaultTransform__0_102_0);
		g.setClip(clip__0_102_0);
		origAlpha = alpha__0_102;
		g.setTransform(defaultTransform__0_102);
		g.setClip(clip__0_102);
		float alpha__0_103 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_103 = g.getClip();
		AffineTransform defaultTransform__0_103 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_103 is CompositeGraphicsNode
		float alpha__0_103_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_103_0 = g.getClip();
		AffineTransform defaultTransform__0_103_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_103_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(261.0, 170.0,
		260.0, 174.0,
		264.0, 176.0,
		263.0, 178.0,
		269.0, 181.0,
		263.0, 191.0,
		256.0, 192.0,
		251.0, 190.0,
		253.0, 186.0,
		251.0, 186.0,
		253.0, 182.0,
		261.0, 179.0,
		258.0, 178.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(261.0, 170.0,
		260.0, 174.0,
		264.0, 176.0,
		263.0, 178.0,
		269.0, 181.0,
		263.0, 191.0,
		256.0, 192.0,
		251.0, 190.0,
		253.0, 186.0,
		251.0, 186.0,
		253.0, 182.0,
		261.0, 179.0,
		258.0, 178.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_103_0;
		g.setTransform(defaultTransform__0_103_0);
		g.setClip(clip__0_103_0);
		origAlpha = alpha__0_103;
		g.setTransform(defaultTransform__0_103);
		g.setClip(clip__0_103);
		float alpha__0_104 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_104 = g.getClip();
		AffineTransform defaultTransform__0_104 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_104 is CompositeGraphicsNode
		float alpha__0_104_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_104_0 = g.getClip();
		AffineTransform defaultTransform__0_104_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_104_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(300.0, 177.0,
		309.0, 175.0,
		302.0, 190.0,
		293.0, 191.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(300.0, 177.0,
		309.0, 175.0,
		302.0, 190.0,
		293.0, 191.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_104_0;
		g.setTransform(defaultTransform__0_104_0);
		g.setClip(clip__0_104_0);
		origAlpha = alpha__0_104;
		g.setTransform(defaultTransform__0_104);
		g.setClip(clip__0_104);
		float alpha__0_105 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_105 = g.getClip();
		AffineTransform defaultTransform__0_105 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_105 is CompositeGraphicsNode
		float alpha__0_105_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_105_0 = g.getClip();
		AffineTransform defaultTransform__0_105_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_105_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(275.0, 175.0,
		273.0, 199.0,
		271.0, 197.0,
		270.0, 199.0,
		266.0, 197.0,
		262.0, 204.0,
		256.0, 198.0,
		266.0, 187.0,
		271.0, 177.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(275.0, 175.0,
		273.0, 199.0,
		271.0, 197.0,
		270.0, 199.0,
		266.0, 197.0,
		262.0, 204.0,
		256.0, 198.0,
		266.0, 187.0,
		271.0, 177.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_105_0;
		g.setTransform(defaultTransform__0_105_0);
		g.setClip(clip__0_105_0);
		origAlpha = alpha__0_105;
		g.setTransform(defaultTransform__0_105);
		g.setClip(clip__0_105);
		float alpha__0_106 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_106 = g.getClip();
		AffineTransform defaultTransform__0_106 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_106 is CompositeGraphicsNode
		float alpha__0_106_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_106_0 = g.getClip();
		AffineTransform defaultTransform__0_106_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_106_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(356.0, 183.0,
		361.0, 185.0,
		361.0, 189.0,
		373.0, 187.0,
		372.0, 185.0,
		376.0, 183.0,
		377.0, 187.0,
		355.0, 197.0,
		358.0, 191.0,
		352.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(356.0, 183.0,
		361.0, 185.0,
		361.0, 189.0,
		373.0, 187.0,
		372.0, 185.0,
		376.0, 183.0,
		377.0, 187.0,
		355.0, 197.0,
		358.0, 191.0,
		352.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_106_0;
		g.setTransform(defaultTransform__0_106_0);
		g.setClip(clip__0_106_0);
		origAlpha = alpha__0_106;
		g.setTransform(defaultTransform__0_106);
		g.setClip(clip__0_106);
		float alpha__0_107 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_107 = g.getClip();
		AffineTransform defaultTransform__0_107 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_107 is CompositeGraphicsNode
		float alpha__0_107_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_107_0 = g.getClip();
		AffineTransform defaultTransform__0_107_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_107_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(237.0, 182.0,
		240.0, 181.0,
		240.0, 184.0,
		246.0, 182.0,
		253.0, 186.0,
		251.0, 190.0,
		246.0, 191.0,
		241.0, 198.0,
		233.0, 199.0,
		233.0, 204.0,
		232.0, 191.0,
		234.0, 190.0,
		235.0, 184.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(237.0, 182.0,
		240.0, 181.0,
		240.0, 184.0,
		246.0, 182.0,
		253.0, 186.0,
		251.0, 190.0,
		246.0, 191.0,
		241.0, 198.0,
		233.0, 199.0,
		233.0, 204.0,
		232.0, 191.0,
		234.0, 190.0,
		235.0, 184.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_107_0;
		g.setTransform(defaultTransform__0_107_0);
		g.setClip(clip__0_107_0);
		origAlpha = alpha__0_107;
		g.setTransform(defaultTransform__0_107);
		g.setClip(clip__0_107);
		float alpha__0_108 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_108 = g.getClip();
		AffineTransform defaultTransform__0_108 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_108 is CompositeGraphicsNode
		float alpha__0_108_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_108_0 = g.getClip();
		AffineTransform defaultTransform__0_108_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_108_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(344.0, 184.0,
		352.0, 188.0,
		351.0, 193.0,
		343.0, 201.0,
		340.0, 198.0,
		337.0, 203.0,
		334.0, 203.0,
		336.0, 199.0,
		337.0, 187.0,
		340.0, 187.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(344.0, 184.0,
		352.0, 188.0,
		351.0, 193.0,
		343.0, 201.0,
		340.0, 198.0,
		337.0, 203.0,
		334.0, 203.0,
		336.0, 199.0,
		337.0, 187.0,
		340.0, 187.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_108_0;
		g.setTransform(defaultTransform__0_108_0);
		g.setClip(clip__0_108_0);
		origAlpha = alpha__0_108;
		g.setTransform(defaultTransform__0_108);
		g.setClip(clip__0_108);
		float alpha__0_109 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_109 = g.getClip();
		AffineTransform defaultTransform__0_109 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_109 is CompositeGraphicsNode
		float alpha__0_109_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_109_0 = g.getClip();
		AffineTransform defaultTransform__0_109_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_109_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(288.0, 191.0,
		288.0, 193.0,
		283.0, 196.0,
		282.0, 200.0,
		281.0, 199.0,
		277.0, 203.0,
		273.0, 200.0,
		273.0, 186.0,
		277.0, 186.0,
		284.0, 192.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(288.0, 191.0,
		288.0, 193.0,
		283.0, 196.0,
		282.0, 200.0,
		281.0, 199.0,
		277.0, 203.0,
		273.0, 200.0,
		273.0, 186.0,
		277.0, 186.0,
		284.0, 192.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_109_0;
		g.setTransform(defaultTransform__0_109_0);
		g.setClip(clip__0_109_0);
		origAlpha = alpha__0_109;
		g.setTransform(defaultTransform__0_109);
		g.setClip(clip__0_109);
		float alpha__0_110 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_110 = g.getClip();
		AffineTransform defaultTransform__0_110 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_110 is CompositeGraphicsNode
		float alpha__0_110_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_110_0 = g.getClip();
		AffineTransform defaultTransform__0_110_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_110_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(295.0, 187.0,
		293.0, 191.0,
		302.0, 190.0,
		303.0, 188.0,
		308.0, 191.0,
		303.0, 201.0,
		303.0, 205.0,
		295.0, 205.0,
		295.0, 212.0,
		290.0, 217.0,
		287.0, 216.0,
		285.0, 211.0,
		287.0, 205.0,
		283.0, 202.0,
		283.0, 196.0,
		288.0, 193.0,
		289.0, 188.0,
		292.0, 188.0,
		292.0, 186.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(295.0, 187.0,
		293.0, 191.0,
		302.0, 190.0,
		303.0, 188.0,
		308.0, 191.0,
		303.0, 201.0,
		303.0, 205.0,
		295.0, 205.0,
		295.0, 212.0,
		290.0, 217.0,
		287.0, 216.0,
		285.0, 211.0,
		287.0, 205.0,
		283.0, 202.0,
		283.0, 196.0,
		288.0, 193.0,
		289.0, 188.0,
		292.0, 188.0,
		292.0, 186.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_110_0;
		g.setTransform(defaultTransform__0_110_0);
		g.setClip(clip__0_110_0);
		origAlpha = alpha__0_110;
		g.setTransform(defaultTransform__0_110);
		g.setClip(clip__0_110);
		float alpha__0_111 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_111 = g.getClip();
		AffineTransform defaultTransform__0_111 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_111 is CompositeGraphicsNode
		float alpha__0_111_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_111_0 = g.getClip();
		AffineTransform defaultTransform__0_111_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_111_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(369.0, 191.0,
		375.0, 189.0,
		390.0, 189.0,
		381.0, 201.0,
		381.0, 205.0,
		376.0, 203.0,
		375.0, 211.0,
		371.0, 218.0,
		363.0, 215.0,
		363.0, 218.0,
		356.0, 218.0,
		360.0, 194.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(369.0, 191.0,
		375.0, 189.0,
		390.0, 189.0,
		381.0, 201.0,
		381.0, 205.0,
		376.0, 203.0,
		375.0, 211.0,
		371.0, 218.0,
		363.0, 215.0,
		363.0, 218.0,
		356.0, 218.0,
		360.0, 194.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_111_0;
		g.setTransform(defaultTransform__0_111_0);
		g.setClip(clip__0_111_0);
		origAlpha = alpha__0_111;
		g.setTransform(defaultTransform__0_111);
		g.setClip(clip__0_111);
		float alpha__0_112 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_112 = g.getClip();
		AffineTransform defaultTransform__0_112 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_112 is CompositeGraphicsNode
		float alpha__0_112_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_112_0 = g.getClip();
		AffineTransform defaultTransform__0_112_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_112_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(352.0, 188.0,
		357.0, 190.0,
		357.0, 193.0,
		353.0, 199.0,
		346.0, 204.0,
		344.0, 208.0,
		346.0, 210.0,
		343.0, 212.0,
		340.0, 219.0,
		336.0, 219.0,
		341.0, 207.0,
		334.0, 206.0,
		336.0, 205.0,
		334.0, 203.0,
		337.0, 203.0,
		340.0, 198.0,
		343.0, 201.0,
		350.0, 194.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(352.0, 188.0,
		357.0, 190.0,
		357.0, 193.0,
		353.0, 199.0,
		346.0, 204.0,
		344.0, 208.0,
		346.0, 210.0,
		343.0, 212.0,
		340.0, 219.0,
		336.0, 219.0,
		341.0, 207.0,
		334.0, 206.0,
		336.0, 205.0,
		334.0, 203.0,
		337.0, 203.0,
		340.0, 198.0,
		343.0, 201.0,
		350.0, 194.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_112_0;
		g.setTransform(defaultTransform__0_112_0);
		g.setClip(clip__0_112_0);
		origAlpha = alpha__0_112;
		g.setTransform(defaultTransform__0_112);
		g.setClip(clip__0_112);
		float alpha__0_113 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_113 = g.getClip();
		AffineTransform defaultTransform__0_113 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_113 is CompositeGraphicsNode
		float alpha__0_113_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_113_0 = g.getClip();
		AffineTransform defaultTransform__0_113_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_113_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(260.0, 193.0,
		256.0, 198.0,
		250.0, 201.0,
		244.0, 200.0,
		243.0, 195.0,
		246.0, 191.0,
		251.0, 190.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(260.0, 193.0,
		256.0, 198.0,
		250.0, 201.0,
		244.0, 200.0,
		243.0, 195.0,
		246.0, 191.0,
		251.0, 190.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_113_0;
		g.setTransform(defaultTransform__0_113_0);
		g.setClip(clip__0_113_0);
		origAlpha = alpha__0_113;
		g.setTransform(defaultTransform__0_113);
		g.setClip(clip__0_113);
		float alpha__0_114 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_114 = g.getClip();
		AffineTransform defaultTransform__0_114 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_114 is CompositeGraphicsNode
		float alpha__0_114_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_114_0 = g.getClip();
		AffineTransform defaultTransform__0_114_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_114_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(335.0, 198.0,
		336.0, 199.0,
		334.0, 203.0,
		336.0, 206.0,
		327.0, 215.0,
		317.0, 209.0,
		319.0, 199.0,
		324.0, 192.0,
		325.0, 194.0,
		328.0, 195.0,
		328.0, 197.0,
		332.0, 196.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(335.0, 198.0,
		336.0, 199.0,
		334.0, 203.0,
		336.0, 206.0,
		327.0, 215.0,
		317.0, 209.0,
		319.0, 199.0,
		324.0, 192.0,
		325.0, 194.0,
		328.0, 195.0,
		328.0, 197.0,
		332.0, 196.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_114_0;
		g.setTransform(defaultTransform__0_114_0);
		g.setClip(clip__0_114_0);
		origAlpha = alpha__0_114;
		g.setTransform(defaultTransform__0_114);
		g.setClip(clip__0_114);
		float alpha__0_115 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_115 = g.getClip();
		AffineTransform defaultTransform__0_115 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_115 is CompositeGraphicsNode
		float alpha__0_115_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_115_0 = g.getClip();
		AffineTransform defaultTransform__0_115_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_115_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(355.0, 197.0,
		360.0, 194.0,
		358.0, 213.0,
		351.0, 209.0,
		347.0, 210.0,
		344.0, 208.0,
		348.0, 202.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(355.0, 197.0,
		360.0, 194.0,
		358.0, 213.0,
		351.0, 209.0,
		347.0, 210.0,
		344.0, 208.0,
		348.0, 202.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_115_0;
		g.setTransform(defaultTransform__0_115_0);
		g.setClip(clip__0_115_0);
		origAlpha = alpha__0_115;
		g.setTransform(defaultTransform__0_115);
		g.setClip(clip__0_115);
		float alpha__0_116 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_116 = g.getClip();
		AffineTransform defaultTransform__0_116 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_116 is CompositeGraphicsNode
		float alpha__0_116_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_116_0 = g.getClip();
		AffineTransform defaultTransform__0_116_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_116_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(248.0, 202.0,
		257.0, 197.0,
		256.0, 199.0,
		260.0, 201.0,
		262.0, 204.0,
		266.0, 197.0,
		270.0, 199.0,
		271.0, 197.0,
		273.0, 198.0,
		277.0, 203.0,
		281.0, 199.0,
		283.0, 200.0,
		287.0, 205.0,
		285.0, 211.0,
		287.0, 216.0,
		289.0, 216.0,
		289.0, 219.0,
		293.0, 221.0,
		295.0, 232.0,
		288.0, 234.0,
		287.0, 229.0,
		282.0, 233.0,
		283.0, 235.0,
		277.0, 233.0,
		277.0, 231.0,
		275.0, 233.0,
		270.0, 231.0,
		268.0, 232.0,
		265.0, 229.0,
		262.0, 232.0,
		262.0, 230.0,
		258.0, 230.0,
		256.0, 227.0,
		247.0, 228.0,
		249.0, 225.0,
		247.0, 223.0,
		252.0, 220.0,
		257.0, 210.0,
		254.0, 211.0,
		244.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(248.0, 202.0,
		257.0, 197.0,
		256.0, 199.0,
		260.0, 201.0,
		262.0, 204.0,
		266.0, 197.0,
		270.0, 199.0,
		271.0, 197.0,
		273.0, 198.0,
		277.0, 203.0,
		281.0, 199.0,
		283.0, 200.0,
		287.0, 205.0,
		285.0, 211.0,
		287.0, 216.0,
		289.0, 216.0,
		289.0, 219.0,
		293.0, 221.0,
		295.0, 232.0,
		288.0, 234.0,
		287.0, 229.0,
		282.0, 233.0,
		283.0, 235.0,
		277.0, 233.0,
		277.0, 231.0,
		275.0, 233.0,
		270.0, 231.0,
		268.0, 232.0,
		265.0, 229.0,
		262.0, 232.0,
		262.0, 230.0,
		258.0, 230.0,
		256.0, 227.0,
		247.0, 228.0,
		249.0, 225.0,
		247.0, 223.0,
		252.0, 220.0,
		257.0, 210.0,
		254.0, 211.0,
		244.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_116_0;
		g.setTransform(defaultTransform__0_116_0);
		g.setClip(clip__0_116_0);
		origAlpha = alpha__0_116;
		g.setTransform(defaultTransform__0_116);
		g.setClip(clip__0_116);
		float alpha__0_117 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_117 = g.getClip();
		AffineTransform defaultTransform__0_117 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_117 is CompositeGraphicsNode
		float alpha__0_117_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_117_0 = g.getClip();
		AffineTransform defaultTransform__0_117_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_117_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(243.0, 197.0,
		244.0, 200.0,
		249.0, 201.0,
		247.0, 201.0,
		248.0, 202.0,
		244.0, 208.0,
		241.0, 208.0,
		239.0, 205.0,
		235.0, 208.0,
		232.0, 206.0,
		234.0, 203.0,
		233.0, 199.0,
		240.0, 199.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(243.0, 197.0,
		244.0, 200.0,
		249.0, 201.0,
		247.0, 201.0,
		248.0, 202.0,
		244.0, 208.0,
		241.0, 208.0,
		239.0, 205.0,
		235.0, 208.0,
		232.0, 206.0,
		234.0, 203.0,
		233.0, 199.0,
		240.0, 199.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_117_0;
		g.setTransform(defaultTransform__0_117_0);
		g.setClip(clip__0_117_0);
		origAlpha = alpha__0_117;
		g.setTransform(defaultTransform__0_117);
		g.setClip(clip__0_117);
		float alpha__0_118 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_118 = g.getClip();
		AffineTransform defaultTransform__0_118 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_118 is CompositeGraphicsNode
		float alpha__0_118_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_118_0 = g.getClip();
		AffineTransform defaultTransform__0_118_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_118_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(303.0, 204.0,
		316.0, 212.0,
		312.0, 222.0,
		309.0, 222.0,
		309.0, 226.0,
		303.0, 226.0,
		304.0, 218.0,
		301.0, 216.0,
		304.0, 207.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(303.0, 204.0,
		316.0, 212.0,
		312.0, 222.0,
		309.0, 222.0,
		309.0, 226.0,
		303.0, 226.0,
		304.0, 218.0,
		301.0, 216.0,
		304.0, 207.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_118_0;
		g.setTransform(defaultTransform__0_118_0);
		g.setClip(clip__0_118_0);
		origAlpha = alpha__0_118;
		g.setTransform(defaultTransform__0_118);
		g.setClip(clip__0_118);
		float alpha__0_119 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_119 = g.getClip();
		AffineTransform defaultTransform__0_119 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_119 is CompositeGraphicsNode
		float alpha__0_119_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_119_0 = g.getClip();
		AffineTransform defaultTransform__0_119_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_119_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(303.0, 205.0,
		304.0, 207.0,
		302.0, 215.0,
		298.0, 215.0,
		293.0, 220.0,
		289.0, 219.0,
		291.0, 215.0,
		295.0, 212.0,
		295.0, 205.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(303.0, 205.0,
		304.0, 207.0,
		302.0, 215.0,
		298.0, 215.0,
		293.0, 220.0,
		289.0, 219.0,
		291.0, 215.0,
		295.0, 212.0,
		295.0, 205.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_119_0;
		g.setTransform(defaultTransform__0_119_0);
		g.setClip(clip__0_119_0);
		origAlpha = alpha__0_119;
		g.setTransform(defaultTransform__0_119);
		g.setClip(clip__0_119);
		float alpha__0_120 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_120 = g.getClip();
		AffineTransform defaultTransform__0_120 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_120 is CompositeGraphicsNode
		float alpha__0_120_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_120_0 = g.getClip();
		AffineTransform defaultTransform__0_120_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_120_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(232.0, 204.0,
		236.0, 211.0,
		230.0, 224.0,
		225.0, 222.0,
		220.0, 223.0,
		219.0, 220.0,
		215.0, 221.0,
		216.0, 211.0,
		223.0, 215.0,
		225.0, 205.0,
		228.0, 203.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(232.0, 204.0,
		236.0, 211.0,
		230.0, 224.0,
		225.0, 222.0,
		220.0, 223.0,
		219.0, 220.0,
		215.0, 221.0,
		216.0, 211.0,
		223.0, 215.0,
		225.0, 205.0,
		228.0, 203.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_120_0;
		g.setTransform(defaultTransform__0_120_0);
		g.setClip(clip__0_120_0);
		origAlpha = alpha__0_120;
		g.setTransform(defaultTransform__0_120);
		g.setClip(clip__0_120);
		float alpha__0_121 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_121 = g.getClip();
		AffineTransform defaultTransform__0_121 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_121 is CompositeGraphicsNode
		float alpha__0_121_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_121_0 = g.getClip();
		AffineTransform defaultTransform__0_121_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_121_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(334.0, 206.0,
		341.0, 207.0,
		337.0, 216.0,
		334.0, 213.0,
		333.0, 215.0,
		330.0, 211.0,
		335.0, 208.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(334.0, 206.0,
		341.0, 207.0,
		337.0, 216.0,
		334.0, 213.0,
		333.0, 215.0,
		330.0, 211.0,
		335.0, 208.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_121_0;
		g.setTransform(defaultTransform__0_121_0);
		g.setClip(clip__0_121_0);
		origAlpha = alpha__0_121;
		g.setTransform(defaultTransform__0_121);
		g.setClip(clip__0_121);
		float alpha__0_122 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_122 = g.getClip();
		AffineTransform defaultTransform__0_122 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_122 is CompositeGraphicsNode
		float alpha__0_122_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_122_0 = g.getClip();
		AffineTransform defaultTransform__0_122_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_122_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(235.0, 208.0,
		239.0, 205.0,
		241.0, 208.0,
		246.0, 210.0,
		238.0, 221.0,
		231.0, 222.0,
		236.0, 211.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(235.0, 208.0,
		239.0, 205.0,
		241.0, 208.0,
		246.0, 210.0,
		238.0, 221.0,
		231.0, 222.0,
		236.0, 211.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_122_0;
		g.setTransform(defaultTransform__0_122_0);
		g.setClip(clip__0_122_0);
		origAlpha = alpha__0_122;
		g.setTransform(defaultTransform__0_122);
		g.setClip(clip__0_122);
		float alpha__0_123 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_123 = g.getClip();
		AffineTransform defaultTransform__0_123 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_123 is CompositeGraphicsNode
		float alpha__0_123_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_123_0 = g.getClip();
		AffineTransform defaultTransform__0_123_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_123_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(358.0, 213.0,
		351.0, 229.0,
		346.0, 227.0,
		345.0, 230.0,
		335.0, 225.0,
		344.0, 211.0,
		351.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(358.0, 213.0,
		351.0, 229.0,
		346.0, 227.0,
		345.0, 230.0,
		335.0, 225.0,
		344.0, 211.0,
		351.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_123_0;
		g.setTransform(defaultTransform__0_123_0);
		g.setClip(clip__0_123_0);
		origAlpha = alpha__0_123;
		g.setTransform(defaultTransform__0_123);
		g.setClip(clip__0_123);
		float alpha__0_124 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_124 = g.getClip();
		AffineTransform defaultTransform__0_124 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_124 is CompositeGraphicsNode
		float alpha__0_124_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_124_0 = g.getClip();
		AffineTransform defaultTransform__0_124_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_124_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(317.0, 209.0,
		327.0, 215.0,
		330.0, 211.0,
		333.0, 215.0,
		334.0, 213.0,
		336.0, 216.0,
		339.0, 215.0,
		336.0, 219.0,
		338.0, 220.0,
		333.0, 228.0,
		335.0, 232.0,
		334.0, 234.0,
		336.0, 234.0,
		334.0, 235.0,
		336.0, 235.0,
		339.0, 240.0,
		335.0, 243.0,
		334.0, 250.0,
		329.0, 246.0,
		325.0, 251.0,
		314.0, 241.0,
		306.0, 241.0,
		305.0, 236.0,
		302.0, 237.0,
		300.0, 236.0,
		301.0, 234.0,
		297.0, 234.0,
		300.0, 228.0,
		309.0, 226.0,
		309.0, 222.0,
		313.0, 221.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(317.0, 209.0,
		327.0, 215.0,
		330.0, 211.0,
		333.0, 215.0,
		334.0, 213.0,
		336.0, 216.0,
		339.0, 215.0,
		336.0, 219.0,
		338.0, 220.0,
		333.0, 228.0,
		335.0, 232.0,
		334.0, 234.0,
		336.0, 234.0,
		334.0, 235.0,
		336.0, 235.0,
		339.0, 240.0,
		335.0, 243.0,
		334.0, 250.0,
		329.0, 246.0,
		325.0, 251.0,
		314.0, 241.0,
		306.0, 241.0,
		305.0, 236.0,
		302.0, 237.0,
		300.0, 236.0,
		301.0, 234.0,
		297.0, 234.0,
		300.0, 228.0,
		309.0, 226.0,
		309.0, 222.0,
		313.0, 221.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_124_0;
		g.setTransform(defaultTransform__0_124_0);
		g.setClip(clip__0_124_0);
		origAlpha = alpha__0_124;
		g.setTransform(defaultTransform__0_124);
		g.setClip(clip__0_124);
		float alpha__0_125 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_125 = g.getClip();
		AffineTransform defaultTransform__0_125 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_125 is CompositeGraphicsNode
		float alpha__0_125_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_125_0 = g.getClip();
		AffineTransform defaultTransform__0_125_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_125_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(247.0, 209.0,
		245.0, 215.0,
		248.0, 218.0,
		246.0, 221.0,
		249.0, 225.0,
		247.0, 228.0,
		240.0, 227.0,
		237.0, 232.0,
		234.0, 226.0,
		235.0, 222.0,
		242.0, 217.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(247.0, 209.0,
		245.0, 215.0,
		248.0, 218.0,
		246.0, 221.0,
		249.0, 225.0,
		247.0, 228.0,
		240.0, 227.0,
		237.0, 232.0,
		234.0, 226.0,
		235.0, 222.0,
		242.0, 217.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_125_0;
		g.setTransform(defaultTransform__0_125_0);
		g.setClip(clip__0_125_0);
		origAlpha = alpha__0_125;
		g.setTransform(defaultTransform__0_125);
		g.setClip(clip__0_125);
		float alpha__0_126 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_126 = g.getClip();
		AffineTransform defaultTransform__0_126 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_126 is CompositeGraphicsNode
		float alpha__0_126_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_126_0 = g.getClip();
		AffineTransform defaultTransform__0_126_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_126_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(248.0, 222.0,
		246.0, 221.0,
		248.0, 218.0,
		245.0, 215.0,
		247.0, 209.0,
		254.0, 211.0,
		257.0, 210.0,
		255.0, 217.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(248.0, 222.0,
		246.0, 221.0,
		248.0, 218.0,
		245.0, 215.0,
		247.0, 209.0,
		254.0, 211.0,
		257.0, 210.0,
		255.0, 217.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_126_0;
		g.setTransform(defaultTransform__0_126_0);
		g.setClip(clip__0_126_0);
		origAlpha = alpha__0_126;
		g.setTransform(defaultTransform__0_126);
		g.setClip(clip__0_126);
		float alpha__0_127 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_127 = g.getClip();
		AffineTransform defaultTransform__0_127 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_127 is CompositeGraphicsNode
		float alpha__0_127_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_127_0 = g.getClip();
		AffineTransform defaultTransform__0_127_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_127_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(356.0, 218.0,
		363.0, 218.0,
		363.0, 215.0,
		370.0, 218.0,
		364.0, 225.0,
		362.0, 234.0,
		351.0, 229.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(356.0, 218.0,
		363.0, 218.0,
		363.0, 215.0,
		370.0, 218.0,
		364.0, 225.0,
		362.0, 234.0,
		351.0, 229.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_127_0;
		g.setTransform(defaultTransform__0_127_0);
		g.setClip(clip__0_127_0);
		origAlpha = alpha__0_127;
		g.setTransform(defaultTransform__0_127);
		g.setClip(clip__0_127);
		float alpha__0_128 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_128 = g.getClip();
		AffineTransform defaultTransform__0_128 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_128 is CompositeGraphicsNode
		float alpha__0_128_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_128_0 = g.getClip();
		AffineTransform defaultTransform__0_128_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_128_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(293.0, 220.0,
		300.0, 214.0,
		304.0, 218.0,
		303.0, 227.0,
		300.0, 228.0,
		297.0, 234.0,
		293.0, 228.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(293.0, 220.0,
		300.0, 214.0,
		304.0, 218.0,
		303.0, 227.0,
		300.0, 228.0,
		297.0, 234.0,
		293.0, 228.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_128_0;
		g.setTransform(defaultTransform__0_128_0);
		g.setClip(clip__0_128_0);
		origAlpha = alpha__0_128;
		g.setTransform(defaultTransform__0_128);
		g.setClip(clip__0_128);
		float alpha__0_129 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_129 = g.getClip();
		AffineTransform defaultTransform__0_129 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_129 is CompositeGraphicsNode
		float alpha__0_129_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_129_0 = g.getClip();
		AffineTransform defaultTransform__0_129_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_129_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(351.0, 229.0,
		360.0, 233.0,
		358.0, 237.0,
		364.0, 244.0,
		357.0, 255.0,
		356.0, 261.0,
		353.0, 259.0,
		351.0, 259.0,
		350.0, 261.0,
		348.0, 260.0,
		345.0, 255.0,
		347.0, 248.0,
		344.0, 248.0,
		343.0, 241.0,
		339.0, 240.0,
		337.0, 236.0,
		338.0, 233.0,
		335.0, 236.0,
		336.0, 234.0,
		334.0, 234.0,
		335.0, 232.0,
		333.0, 228.0,
		335.0, 225.0,
		345.0, 230.0,
		346.0, 227.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(351.0, 229.0,
		360.0, 233.0,
		358.0, 237.0,
		364.0, 244.0,
		357.0, 255.0,
		356.0, 261.0,
		353.0, 259.0,
		351.0, 259.0,
		350.0, 261.0,
		348.0, 260.0,
		345.0, 255.0,
		347.0, 248.0,
		344.0, 248.0,
		343.0, 241.0,
		339.0, 240.0,
		337.0, 236.0,
		338.0, 233.0,
		335.0, 236.0,
		336.0, 234.0,
		334.0, 234.0,
		335.0, 232.0,
		333.0, 228.0,
		335.0, 225.0,
		345.0, 230.0,
		346.0, 227.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_129_0;
		g.setTransform(defaultTransform__0_129_0);
		g.setClip(clip__0_129_0);
		origAlpha = alpha__0_129;
		g.setTransform(defaultTransform__0_129);
		g.setClip(clip__0_129);
		float alpha__0_130 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_130 = g.getClip();
		AffineTransform defaultTransform__0_130 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_130 is CompositeGraphicsNode
		float alpha__0_130_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_130_0 = g.getClip();
		AffineTransform defaultTransform__0_130_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_130_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(336.0, 235.0,
		338.0, 233.0,
		337.0, 236.0,
		339.0, 240.0,
		343.0, 241.0,
		344.0, 248.0,
		347.0, 248.0,
		345.0, 255.0,
		347.0, 260.0,
		342.0, 260.0,
		343.0, 255.0,
		335.0, 249.0,
		335.0, 243.0,
		339.0, 240.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(336.0, 235.0,
		338.0, 233.0,
		337.0, 236.0,
		339.0, 240.0,
		343.0, 241.0,
		344.0, 248.0,
		347.0, 248.0,
		345.0, 255.0,
		347.0, 260.0,
		342.0, 260.0,
		343.0, 255.0,
		335.0, 249.0,
		335.0, 243.0,
		339.0, 240.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_130_0;
		g.setTransform(defaultTransform__0_130_0);
		g.setClip(clip__0_130_0);
		origAlpha = alpha__0_130;
		g.setTransform(defaultTransform__0_130);
		g.setClip(clip__0_130);
		float alpha__0_131 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_131 = g.getClip();
		AffineTransform defaultTransform__0_131 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_131 is CompositeGraphicsNode
		float alpha__0_131_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_131_0 = g.getClip();
		AffineTransform defaultTransform__0_131_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_131_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(297.0, 235.0,
		301.0, 234.0,
		302.0, 237.0,
		305.0, 236.0,
		305.0, 239.0,
		307.0, 241.0,
		314.0, 241.0,
		317.0, 243.0,
		315.0, 248.0,
		318.0, 252.0,
		322.0, 253.0,
		320.0, 257.0,
		309.0, 254.0,
		307.0, 252.0,
		307.0, 254.0,
		299.0, 246.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(297.0, 235.0,
		301.0, 234.0,
		302.0, 237.0,
		305.0, 236.0,
		305.0, 239.0,
		307.0, 241.0,
		314.0, 241.0,
		317.0, 243.0,
		315.0, 248.0,
		318.0, 252.0,
		322.0, 253.0,
		320.0, 257.0,
		309.0, 254.0,
		307.0, 252.0,
		307.0, 254.0,
		299.0, 246.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_131_0;
		g.setTransform(defaultTransform__0_131_0);
		g.setClip(clip__0_131_0);
		origAlpha = alpha__0_131;
		g.setTransform(defaultTransform__0_131);
		g.setClip(clip__0_131);
		float alpha__0_132 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_132 = g.getClip();
		AffineTransform defaultTransform__0_132 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_132 is CompositeGraphicsNode
		float alpha__0_132_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_132_0 = g.getClip();
		AffineTransform defaultTransform__0_132_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_132_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(317.0, 243.0,
		325.0, 251.0,
		329.0, 246.0,
		331.0, 247.0,
		332.0, 252.0,
		327.0, 258.0,
		322.0, 257.0,
		322.0, 253.0,
		316.0, 250.0,
		315.0, 248.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(317.0, 243.0,
		325.0, 251.0,
		329.0, 246.0,
		331.0, 247.0,
		332.0, 252.0,
		327.0, 258.0,
		322.0, 257.0,
		322.0, 253.0,
		316.0, 250.0,
		315.0, 248.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_132_0;
		g.setTransform(defaultTransform__0_132_0);
		g.setClip(clip__0_132_0);
		origAlpha = alpha__0_132;
		g.setTransform(defaultTransform__0_132);
		g.setClip(clip__0_132);
		float alpha__0_133 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_133 = g.getClip();
		AffineTransform defaultTransform__0_133 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_133 is CompositeGraphicsNode
		float alpha__0_133_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_133_0 = g.getClip();
		AffineTransform defaultTransform__0_133_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_133_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(335.0, 249.0,
		343.0, 255.0,
		344.0, 266.0,
		332.0, 265.0,
		335.0, 259.0,
		329.0, 256.0,
		332.0, 252.0,
		331.0, 246.0,
		333.0, 249.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(335.0, 249.0,
		343.0, 255.0,
		344.0, 266.0,
		332.0, 265.0,
		335.0, 259.0,
		329.0, 256.0,
		332.0, 252.0,
		331.0, 246.0,
		333.0, 249.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_133_0;
		g.setTransform(defaultTransform__0_133_0);
		g.setClip(clip__0_133_0);
		origAlpha = alpha__0_133;
		g.setTransform(defaultTransform__0_133);
		g.setClip(clip__0_133);
		float alpha__0_134 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_134 = g.getClip();
		AffineTransform defaultTransform__0_134 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_134 is CompositeGraphicsNode
		float alpha__0_134_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_134_0 = g.getClip();
		AffineTransform defaultTransform__0_134_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_134_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(64.0, 167.0,
		66.0, 169.0,
		67.0, 165.0,
		72.0, 161.0,
		79.0, 159.0,
		81.0, 161.0,
		78.0, 167.0,
		74.0, 170.0,
		78.0, 177.0,
		74.0, 183.0,
		74.0, 189.0,
		71.0, 188.0,
		66.0, 191.0,
		64.0, 184.0,
		59.0, 185.0,
		59.0, 179.0,
		54.0, 175.0,
		57.0, 170.0,
		59.0, 170.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(64.0, 167.0,
		66.0, 169.0,
		67.0, 165.0,
		72.0, 161.0,
		79.0, 159.0,
		81.0, 161.0,
		78.0, 167.0,
		74.0, 170.0,
		78.0, 177.0,
		74.0, 183.0,
		74.0, 189.0,
		71.0, 188.0,
		66.0, 191.0,
		64.0, 184.0,
		59.0, 185.0,
		59.0, 179.0,
		54.0, 175.0,
		57.0, 170.0,
		59.0, 170.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_134_0;
		g.setTransform(defaultTransform__0_134_0);
		g.setClip(clip__0_134_0);
		origAlpha = alpha__0_134;
		g.setTransform(defaultTransform__0_134);
		g.setClip(clip__0_134);
		float alpha__0_135 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_135 = g.getClip();
		AffineTransform defaultTransform__0_135 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_135 is CompositeGraphicsNode
		float alpha__0_135_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_135_0 = g.getClip();
		AffineTransform defaultTransform__0_135_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_135_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(39.0, 184.0,
		42.0, 183.0,
		45.0, 178.0,
		54.0, 175.0,
		60.0, 179.0,
		58.0, 188.0,
		54.0, 190.0,
		53.0, 187.0,
		48.0, 191.0,
		54.0, 196.0,
		53.0, 198.0,
		46.0, 199.0,
		45.0, 207.0,
		48.0, 208.0,
		46.0, 209.0,
		42.0, 206.0,
		36.0, 205.0,
		33.0, 207.0,
		25.0, 201.0,
		25.0, 197.0,
		30.0, 194.0,
		31.0, 190.0,
		37.0, 187.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(39.0, 184.0,
		42.0, 183.0,
		45.0, 178.0,
		54.0, 175.0,
		60.0, 179.0,
		58.0, 188.0,
		54.0, 190.0,
		53.0, 187.0,
		48.0, 191.0,
		54.0, 196.0,
		53.0, 198.0,
		46.0, 199.0,
		45.0, 207.0,
		48.0, 208.0,
		46.0, 209.0,
		42.0, 206.0,
		36.0, 205.0,
		33.0, 207.0,
		25.0, 201.0,
		25.0, 197.0,
		30.0, 194.0,
		31.0, 190.0,
		37.0, 187.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_135_0;
		g.setTransform(defaultTransform__0_135_0);
		g.setClip(clip__0_135_0);
		origAlpha = alpha__0_135;
		g.setTransform(defaultTransform__0_135);
		g.setClip(clip__0_135);
		float alpha__0_136 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_136 = g.getClip();
		AffineTransform defaultTransform__0_136 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_136 is CompositeGraphicsNode
		float alpha__0_136_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_136_0 = g.getClip();
		AffineTransform defaultTransform__0_136_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_136_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(76.0, 180.0,
		81.0, 182.0,
		84.0, 181.0,
		87.0, 185.0,
		97.0, 182.0,
		96.0, 190.0,
		91.0, 197.0,
		91.0, 201.0,
		95.0, 207.0,
		91.0, 211.0,
		87.0, 209.0,
		79.0, 210.0,
		76.0, 208.0,
		79.0, 204.0,
		76.0, 205.0,
		76.0, 202.0,
		71.0, 201.0,
		68.0, 205.0,
		64.0, 204.0,
		65.0, 199.0,
		63.0, 192.0,
		66.0, 193.0,
		71.0, 188.0,
		74.0, 189.0,
		74.0, 183.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(76.0, 180.0,
		81.0, 182.0,
		84.0, 181.0,
		87.0, 185.0,
		97.0, 182.0,
		96.0, 190.0,
		91.0, 197.0,
		91.0, 201.0,
		95.0, 207.0,
		91.0, 211.0,
		87.0, 209.0,
		79.0, 210.0,
		76.0, 208.0,
		79.0, 204.0,
		76.0, 205.0,
		76.0, 202.0,
		71.0, 201.0,
		68.0, 205.0,
		64.0, 204.0,
		65.0, 199.0,
		63.0, 192.0,
		66.0, 193.0,
		71.0, 188.0,
		74.0, 189.0,
		74.0, 183.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_136_0;
		g.setTransform(defaultTransform__0_136_0);
		g.setClip(clip__0_136_0);
		origAlpha = alpha__0_136;
		g.setTransform(defaultTransform__0_136);
		g.setClip(clip__0_136);
		float alpha__0_137 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_137 = g.getClip();
		AffineTransform defaultTransform__0_137 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_137 is CompositeGraphicsNode
		float alpha__0_137_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_137_0 = g.getClip();
		AffineTransform defaultTransform__0_137_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_137_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(66.0, 191.0,
		63.0, 192.0,
		64.0, 203.0,
		57.0, 206.0,
		59.0, 209.0,
		57.0, 212.0,
		59.0, 215.0,
		54.0, 218.0,
		50.0, 213.0,
		46.0, 212.0,
		48.0, 208.0,
		45.0, 207.0,
		46.0, 199.0,
		53.0, 198.0,
		54.0, 196.0,
		48.0, 191.0,
		53.0, 187.0,
		55.0, 190.0,
		55.0, 188.0,
		58.0, 188.0,
		58.0, 185.0,
		64.0, 184.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(66.0, 191.0,
		63.0, 192.0,
		64.0, 203.0,
		57.0, 206.0,
		59.0, 209.0,
		57.0, 212.0,
		59.0, 215.0,
		54.0, 218.0,
		50.0, 213.0,
		46.0, 212.0,
		48.0, 208.0,
		45.0, 207.0,
		46.0, 199.0,
		53.0, 198.0,
		54.0, 196.0,
		48.0, 191.0,
		53.0, 187.0,
		55.0, 190.0,
		55.0, 188.0,
		58.0, 188.0,
		58.0, 185.0,
		64.0, 184.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_137_0;
		g.setTransform(defaultTransform__0_137_0);
		g.setClip(clip__0_137_0);
		origAlpha = alpha__0_137;
		g.setTransform(defaultTransform__0_137);
		g.setClip(clip__0_137);
		float alpha__0_138 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_138 = g.getClip();
		AffineTransform defaultTransform__0_138 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_138 is CompositeGraphicsNode
		float alpha__0_138_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_138_0 = g.getClip();
		AffineTransform defaultTransform__0_138_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_138_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(112.0, 213.0,
		121.0, 206.0,
		122.0, 200.0,
		125.0, 201.0,
		124.0, 203.0,
		127.0, 203.0,
		126.0, 204.0,
		129.0, 207.0,
		126.0, 213.0,
		133.0, 218.0,
		126.0, 218.0,
		114.0, 222.0,
		112.0, 221.0,
		111.0, 215.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(112.0, 213.0,
		121.0, 206.0,
		122.0, 200.0,
		125.0, 201.0,
		124.0, 203.0,
		127.0, 203.0,
		126.0, 204.0,
		129.0, 207.0,
		126.0, 213.0,
		133.0, 218.0,
		126.0, 218.0,
		114.0, 222.0,
		112.0, 221.0,
		111.0, 215.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_138_0;
		g.setTransform(defaultTransform__0_138_0);
		g.setClip(clip__0_138_0);
		origAlpha = alpha__0_138;
		g.setTransform(defaultTransform__0_138);
		g.setClip(clip__0_138);
		float alpha__0_139 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_139 = g.getClip();
		AffineTransform defaultTransform__0_139 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_139 is CompositeGraphicsNode
		float alpha__0_139_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_139_0 = g.getClip();
		AffineTransform defaultTransform__0_139_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_139_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(91.0, 211.0,
		96.0, 219.0,
		86.0, 227.0,
		88.0, 231.0,
		82.0, 234.0,
		80.0, 229.0,
		79.0, 231.0,
		78.0, 229.0,
		76.0, 217.0,
		69.0, 217.0,
		66.0, 218.0,
		65.0, 221.0,
		62.0, 221.0,
		58.0, 216.0,
		57.0, 212.0,
		59.0, 209.0,
		57.0, 206.0,
		58.0, 204.0,
		61.0, 205.0,
		64.0, 203.0,
		68.0, 205.0,
		71.0, 201.0,
		76.0, 202.0,
		76.0, 205.0,
		79.0, 204.0,
		76.0, 208.0,
		79.0, 210.0,
		87.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(91.0, 211.0,
		96.0, 219.0,
		86.0, 227.0,
		88.0, 231.0,
		82.0, 234.0,
		80.0, 229.0,
		79.0, 231.0,
		78.0, 229.0,
		76.0, 217.0,
		69.0, 217.0,
		66.0, 218.0,
		65.0, 221.0,
		62.0, 221.0,
		58.0, 216.0,
		57.0, 212.0,
		59.0, 209.0,
		57.0, 206.0,
		58.0, 204.0,
		61.0, 205.0,
		64.0, 203.0,
		68.0, 205.0,
		71.0, 201.0,
		76.0, 202.0,
		76.0, 205.0,
		79.0, 204.0,
		76.0, 208.0,
		79.0, 210.0,
		87.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_139_0;
		g.setTransform(defaultTransform__0_139_0);
		g.setClip(clip__0_139_0);
		origAlpha = alpha__0_139;
		g.setTransform(defaultTransform__0_139);
		g.setClip(clip__0_139);
		float alpha__0_140 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_140 = g.getClip();
		AffineTransform defaultTransform__0_140 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_140 is CompositeGraphicsNode
		float alpha__0_140_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_140_0 = g.getClip();
		AffineTransform defaultTransform__0_140_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_140_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(33.0, 207.0,
		36.0, 205.0,
		43.0, 206.0,
		46.0, 209.0,
		46.0, 212.0,
		50.0, 213.0,
		54.0, 218.0,
		44.0, 220.0,
		43.0, 223.0,
		38.0, 217.0,
		32.0, 218.0,
		29.0, 214.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(33.0, 207.0,
		36.0, 205.0,
		43.0, 206.0,
		46.0, 209.0,
		46.0, 212.0,
		50.0, 213.0,
		54.0, 218.0,
		44.0, 220.0,
		43.0, 223.0,
		38.0, 217.0,
		32.0, 218.0,
		29.0, 214.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_140_0;
		g.setTransform(defaultTransform__0_140_0);
		g.setClip(clip__0_140_0);
		origAlpha = alpha__0_140;
		g.setTransform(defaultTransform__0_140);
		g.setClip(clip__0_140);
		float alpha__0_141 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_141 = g.getClip();
		AffineTransform defaultTransform__0_141 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_141 is CompositeGraphicsNode
		float alpha__0_141_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_141_0 = g.getClip();
		AffineTransform defaultTransform__0_141_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_141_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(199.0, 208.0,
		196.0, 218.0,
		186.0, 231.0,
		185.0, 221.0,
		186.0, 219.0,
		187.0, 220.0,
		186.0, 218.0,
		189.0, 215.0,
		186.0, 213.0,
		189.0, 206.0,
		190.0, 208.0,
		191.0, 207.0,
		196.0, 209.0,
		198.0, 207.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(199.0, 208.0,
		196.0, 218.0,
		186.0, 231.0,
		185.0, 221.0,
		186.0, 219.0,
		187.0, 220.0,
		186.0, 218.0,
		189.0, 215.0,
		186.0, 213.0,
		189.0, 206.0,
		190.0, 208.0,
		191.0, 207.0,
		196.0, 209.0,
		198.0, 207.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_141_0;
		g.setTransform(defaultTransform__0_141_0);
		g.setClip(clip__0_141_0);
		origAlpha = alpha__0_141;
		g.setTransform(defaultTransform__0_141);
		g.setClip(clip__0_141);
		float alpha__0_142 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_142 = g.getClip();
		AffineTransform defaultTransform__0_142 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_142 is CompositeGraphicsNode
		float alpha__0_142_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_142_0 = g.getClip();
		AffineTransform defaultTransform__0_142_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_142_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(152.0, 209.0,
		156.0, 209.0,
		162.0, 215.0,
		167.0, 215.0,
		171.0, 218.0,
		164.0, 220.0,
		162.0, 226.0,
		158.0, 225.0,
		157.0, 221.0,
		154.0, 223.0,
		154.0, 220.0,
		152.0, 220.0,
		153.0, 226.0,
		151.0, 227.0,
		148.0, 224.0,
		146.0, 224.0,
		145.0, 221.0,
		138.0, 221.0,
		134.0, 219.0,
		132.0, 216.0,
		137.0, 214.0,
		136.0, 212.0,
		140.0, 214.0,
		149.0, 214.0,
		149.0, 208.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(152.0, 209.0,
		156.0, 209.0,
		162.0, 215.0,
		167.0, 215.0,
		171.0, 218.0,
		164.0, 220.0,
		162.0, 226.0,
		158.0, 225.0,
		157.0, 221.0,
		154.0, 223.0,
		154.0, 220.0,
		152.0, 220.0,
		153.0, 226.0,
		151.0, 227.0,
		148.0, 224.0,
		146.0, 224.0,
		145.0, 221.0,
		138.0, 221.0,
		134.0, 219.0,
		132.0, 216.0,
		137.0, 214.0,
		136.0, 212.0,
		140.0, 214.0,
		149.0, 214.0,
		149.0, 208.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_142_0;
		g.setTransform(defaultTransform__0_142_0);
		g.setClip(clip__0_142_0);
		origAlpha = alpha__0_142;
		g.setTransform(defaultTransform__0_142);
		g.setClip(clip__0_142);
		float alpha__0_143 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_143 = g.getClip();
		AffineTransform defaultTransform__0_143 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_143 is CompositeGraphicsNode
		float alpha__0_143_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_143_0 = g.getClip();
		AffineTransform defaultTransform__0_143_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_143_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(199.0, 210.0,
		209.0, 215.0,
		208.0, 218.0,
		199.0, 227.0,
		193.0, 229.0,
		191.0, 232.0,
		187.0, 230.0,
		188.0, 227.0,
		196.0, 218.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(199.0, 210.0,
		209.0, 215.0,
		208.0, 218.0,
		199.0, 227.0,
		193.0, 229.0,
		191.0, 232.0,
		187.0, 230.0,
		188.0, 227.0,
		196.0, 218.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_143_0;
		g.setTransform(defaultTransform__0_143_0);
		g.setClip(clip__0_143_0);
		origAlpha = alpha__0_143;
		g.setTransform(defaultTransform__0_143);
		g.setClip(clip__0_143);
		float alpha__0_144 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_144 = g.getClip();
		AffineTransform defaultTransform__0_144 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_144 is CompositeGraphicsNode
		float alpha__0_144_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_144_0 = g.getClip();
		AffineTransform defaultTransform__0_144_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_144_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(177.0, 213.0,
		182.0, 218.0,
		186.0, 212.0,
		188.0, 213.0,
		187.0, 220.0,
		186.0, 219.0,
		185.0, 221.0,
		185.0, 227.0,
		177.0, 228.0,
		174.0, 233.0,
		167.0, 230.0,
		163.0, 236.0,
		158.0, 234.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(177.0, 213.0,
		182.0, 218.0,
		186.0, 212.0,
		188.0, 213.0,
		187.0, 220.0,
		186.0, 219.0,
		185.0, 221.0,
		185.0, 227.0,
		177.0, 228.0,
		174.0, 233.0,
		167.0, 230.0,
		163.0, 236.0,
		158.0, 234.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_144_0;
		g.setTransform(defaultTransform__0_144_0);
		g.setClip(clip__0_144_0);
		origAlpha = alpha__0_144;
		g.setTransform(defaultTransform__0_144);
		g.setClip(clip__0_144);
		float alpha__0_145 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_145 = g.getClip();
		AffineTransform defaultTransform__0_145 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_145 is CompositeGraphicsNode
		float alpha__0_145_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_145_0 = g.getClip();
		AffineTransform defaultTransform__0_145_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_145_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(9.0, 219.0,
		17.0, 219.0,
		15.0, 212.0,
		20.0, 221.0,
		21.0, 219.0,
		27.0, 221.0,
		29.0, 224.0,
		28.0, 230.0,
		26.0, 230.0,
		24.0, 226.0,
		17.0, 227.0,
		15.0, 223.0,
		9.0, 223.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(9.0, 219.0,
		17.0, 219.0,
		15.0, 212.0,
		20.0, 221.0,
		21.0, 219.0,
		27.0, 221.0,
		29.0, 224.0,
		28.0, 230.0,
		26.0, 230.0,
		24.0, 226.0,
		17.0, 227.0,
		15.0, 223.0,
		9.0, 223.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_145_0;
		g.setTransform(defaultTransform__0_145_0);
		g.setClip(clip__0_145_0);
		origAlpha = alpha__0_145;
		g.setTransform(defaultTransform__0_145);
		g.setClip(clip__0_145);
		float alpha__0_146 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_146 = g.getClip();
		AffineTransform defaultTransform__0_146 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_146 is CompositeGraphicsNode
		float alpha__0_146_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_146_0 = g.getClip();
		AffineTransform defaultTransform__0_146_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_146_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(54.0, 218.0,
		58.0, 216.0,
		64.0, 222.0,
		69.0, 217.0,
		75.0, 217.0,
		78.0, 229.0,
		79.0, 231.0,
		80.0, 229.0,
		82.0, 234.0,
		74.0, 240.0,
		73.0, 244.0,
		70.0, 245.0,
		66.0, 251.0,
		62.0, 253.0,
		58.0, 250.0,
		55.0, 251.0,
		55.0, 248.0,
		53.0, 250.0,
		50.0, 248.0,
		49.0, 243.0,
		44.0, 238.0,
		46.0, 237.0,
		45.0, 234.0,
		47.0, 232.0,
		45.0, 226.0,
		43.0, 226.0,
		43.0, 221.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(54.0, 218.0,
		58.0, 216.0,
		64.0, 222.0,
		69.0, 217.0,
		75.0, 217.0,
		78.0, 229.0,
		79.0, 231.0,
		80.0, 229.0,
		82.0, 234.0,
		74.0, 240.0,
		73.0, 244.0,
		70.0, 245.0,
		66.0, 251.0,
		62.0, 253.0,
		58.0, 250.0,
		55.0, 251.0,
		55.0, 248.0,
		53.0, 250.0,
		50.0, 248.0,
		49.0, 243.0,
		44.0, 238.0,
		46.0, 237.0,
		45.0, 234.0,
		47.0, 232.0,
		45.0, 226.0,
		43.0, 226.0,
		43.0, 221.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_146_0;
		g.setTransform(defaultTransform__0_146_0);
		g.setClip(clip__0_146_0);
		origAlpha = alpha__0_146;
		g.setTransform(defaultTransform__0_146);
		g.setClip(clip__0_146);
		float alpha__0_147 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_147 = g.getClip();
		AffineTransform defaultTransform__0_147 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_147 is CompositeGraphicsNode
		float alpha__0_147_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_147_0 = g.getClip();
		AffineTransform defaultTransform__0_147_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_147_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(208.0, 218.0,
		208.0, 222.0,
		211.0, 225.0,
		205.0, 229.0,
		205.0, 236.0,
		199.0, 247.0,
		192.0, 253.0,
		187.0, 252.0,
		185.0, 248.0,
		186.0, 242.0,
		193.0, 236.0,
		191.0, 232.0,
		193.0, 229.0,
		199.0, 227.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(208.0, 218.0,
		208.0, 222.0,
		211.0, 225.0,
		205.0, 229.0,
		205.0, 236.0,
		199.0, 247.0,
		192.0, 253.0,
		187.0, 252.0,
		185.0, 248.0,
		186.0, 242.0,
		193.0, 236.0,
		191.0, 232.0,
		193.0, 229.0,
		199.0, 227.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_147_0;
		g.setTransform(defaultTransform__0_147_0);
		g.setClip(clip__0_147_0);
		origAlpha = alpha__0_147;
		g.setTransform(defaultTransform__0_147);
		g.setClip(clip__0_147);
		float alpha__0_148 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_148 = g.getClip();
		AffineTransform defaultTransform__0_148 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_148 is CompositeGraphicsNode
		float alpha__0_148_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_148_0 = g.getClip();
		AffineTransform defaultTransform__0_148_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_148_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(133.0, 218.0,
		138.0, 221.0,
		135.0, 223.0,
		134.0, 227.0,
		137.0, 228.0,
		138.0, 226.0,
		141.0, 228.0,
		140.0, 233.0,
		143.0, 237.0,
		138.0, 238.0,
		137.0, 235.0,
		123.0, 242.0,
		118.0, 239.0,
		113.0, 239.0,
		107.0, 236.0,
		113.0, 232.0,
		117.0, 234.0,
		121.0, 228.0,
		124.0, 227.0,
		122.0, 220.0,
		127.0, 218.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(133.0, 218.0,
		138.0, 221.0,
		135.0, 223.0,
		134.0, 227.0,
		137.0, 228.0,
		138.0, 226.0,
		141.0, 228.0,
		140.0, 233.0,
		143.0, 237.0,
		138.0, 238.0,
		137.0, 235.0,
		123.0, 242.0,
		118.0, 239.0,
		113.0, 239.0,
		107.0, 236.0,
		113.0, 232.0,
		117.0, 234.0,
		121.0, 228.0,
		124.0, 227.0,
		122.0, 220.0,
		127.0, 218.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_148_0;
		g.setTransform(defaultTransform__0_148_0);
		g.setClip(clip__0_148_0);
		origAlpha = alpha__0_148;
		g.setTransform(defaultTransform__0_148);
		g.setClip(clip__0_148);
		float alpha__0_149 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_149 = g.getClip();
		AffineTransform defaultTransform__0_149 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_149 is CompositeGraphicsNode
		float alpha__0_149_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_149_0 = g.getClip();
		AffineTransform defaultTransform__0_149_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_149_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(171.0, 218.0,
		161.0, 231.0,
		148.0, 242.0,
		145.0, 240.0,
		141.0, 245.0,
		139.0, 244.0,
		137.0, 238.0,
		143.0, 237.0,
		140.0, 233.0,
		141.0, 228.0,
		138.0, 226.0,
		137.0, 228.0,
		134.0, 227.0,
		137.0, 221.0,
		145.0, 221.0,
		146.0, 224.0,
		148.0, 224.0,
		151.0, 227.0,
		153.0, 226.0,
		152.0, 220.0,
		154.0, 220.0,
		154.0, 223.0,
		157.0, 221.0,
		158.0, 225.0,
		162.0, 226.0,
		164.0, 220.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(171.0, 218.0,
		161.0, 231.0,
		148.0, 242.0,
		145.0, 240.0,
		141.0, 245.0,
		139.0, 244.0,
		137.0, 238.0,
		143.0, 237.0,
		140.0, 233.0,
		141.0, 228.0,
		138.0, 226.0,
		137.0, 228.0,
		134.0, 227.0,
		137.0, 221.0,
		145.0, 221.0,
		146.0, 224.0,
		148.0, 224.0,
		151.0, 227.0,
		153.0, 226.0,
		152.0, 220.0,
		154.0, 220.0,
		154.0, 223.0,
		157.0, 221.0,
		158.0, 225.0,
		162.0, 226.0,
		164.0, 220.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_149_0;
		g.setTransform(defaultTransform__0_149_0);
		g.setClip(clip__0_149_0);
		origAlpha = alpha__0_149;
		g.setTransform(defaultTransform__0_149);
		g.setClip(clip__0_149);
		float alpha__0_150 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_150 = g.getClip();
		AffineTransform defaultTransform__0_150 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_150 is CompositeGraphicsNode
		float alpha__0_150_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_150_0 = g.getClip();
		AffineTransform defaultTransform__0_150_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_150_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(27.0, 221.0,
		28.0, 219.0,
		39.0, 218.0,
		43.0, 226.0,
		45.0, 226.0,
		46.0, 237.0,
		40.0, 237.0,
		41.0, 231.0,
		33.0, 225.0,
		28.0, 225.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(27.0, 221.0,
		28.0, 219.0,
		39.0, 218.0,
		43.0, 226.0,
		45.0, 226.0,
		46.0, 237.0,
		40.0, 237.0,
		41.0, 231.0,
		33.0, 225.0,
		28.0, 225.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_150_0;
		g.setTransform(defaultTransform__0_150_0);
		g.setClip(clip__0_150_0);
		origAlpha = alpha__0_150;
		g.setTransform(defaultTransform__0_150);
		g.setClip(clip__0_150);
		
		
		
		
	}

	/**
	 * Returns the X of the bounding box of the original SVG image.
	 * 
	 * @return The X of the bounding box of the original SVG image.
	 */
	public static int getOrigX() {
		return 190;
	}

	/**
	 * Returns the Y of the bounding box of the original SVG image.
	 * 
	 * @return The Y of the bounding box of the original SVG image.
	 */
	public static int getOrigY() {
		return 256;
	}

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static int getOrigWidth() {
		return 1026;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static int getOrigHeight() {
		return 870;
	}
	
	
	public static void paint2(Graphics2D g, int colori[], float spessore) {

		
		
		float alpha__0_151 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_151 = g.getClip();
		AffineTransform defaultTransform__0_151 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_151 is CompositeGraphicsNode
		float alpha__0_151_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_151_0 = g.getClip();
		AffineTransform defaultTransform__0_151_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		
		 paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(121.0, 220.0,
			124.0, 227.0,
			121.0, 228.0,
			117.0, 234.0,
			113.0, 232.0,
			107.0, 236.0,
			113.0, 239.0,
			118.0, 239.0,
			122.0, 242.0,
			122.0, 245.0,
			118.0, 248.0,
			119.0, 252.0,
			116.0, 255.0,
			112.0, 255.0,
			109.0, 251.0,
			105.0, 255.0,
			103.0, 252.0,
			100.0, 253.0,
			99.0, 247.0,
			97.0, 245.0,
			93.0, 245.0,
			93.0, 238.0,
			85.0, 241.0,
			85.0, 246.0,
			80.0, 249.0,
			73.0, 244.0,
			74.0, 240.0,
			88.0, 231.0,
			86.0, 227.0,
			96.0, 219.0,
			100.0, 223.0,
			108.0, 221.0,
			115.0, 222.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_151_0;
			g.setTransform(defaultTransform__0_151_0);
			g.setClip(clip__0_151_0);
			origAlpha = alpha__0_151;
			g.setTransform(defaultTransform__0_151);
			g.setClip(clip__0_151);
			float alpha__0_152 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_152 = g.getClip();
			AffineTransform defaultTransform__0_152 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_152 is CompositeGraphicsNode
			float alpha__0_152_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_152_0 = g.getClip();
			AffineTransform defaultTransform__0_152_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_152_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(213.0, 223.0,
			217.0, 227.0,
			217.0, 232.0,
			213.0, 236.0,
			217.0, 239.0,
			211.0, 242.0,
			210.0, 246.0,
			200.0, 250.0,
			198.0, 249.0,
			205.0, 236.0,
			205.0, 229.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(213.0, 223.0,
			217.0, 227.0,
			217.0, 232.0,
			213.0, 236.0,
			217.0, 239.0,
			211.0, 242.0,
			210.0, 246.0,
			200.0, 250.0,
			198.0, 249.0,
			205.0, 236.0,
			205.0, 229.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_152_0;
			g.setTransform(defaultTransform__0_152_0);
			g.setClip(clip__0_152_0);
			origAlpha = alpha__0_152;
			g.setTransform(defaultTransform__0_152);
			g.setClip(clip__0_152);
			float alpha__0_153 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_153 = g.getClip();
			AffineTransform defaultTransform__0_153 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_153 is CompositeGraphicsNode
			float alpha__0_153_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_153_0 = g.getClip();
			AffineTransform defaultTransform__0_153_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_153_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(9.0, 223.0,
			15.0, 223.0,
			17.0, 227.0,
			24.0, 226.0,
			26.0, 230.0,
			29.0, 229.0,
			28.0, 225.0,
			32.0, 224.0,
			41.0, 231.0,
			40.0, 237.0,
			46.0, 237.0,
			44.0, 238.0,
			46.0, 239.0,
			46.0, 244.0,
			43.0, 244.0,
			42.0, 247.0,
			38.0, 245.0,
			35.0, 247.0,
			27.0, 239.0,
			22.0, 242.0,
			17.0, 241.0,
			19.0, 239.0,
			17.0, 236.0,
			10.0, 238.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(9.0, 223.0,
			15.0, 223.0,
			17.0, 227.0,
			24.0, 226.0,
			26.0, 230.0,
			29.0, 229.0,
			28.0, 225.0,
			32.0, 224.0,
			41.0, 231.0,
			40.0, 237.0,
			46.0, 237.0,
			44.0, 238.0,
			46.0, 239.0,
			46.0, 244.0,
			43.0, 244.0,
			42.0, 247.0,
			38.0, 245.0,
			35.0, 247.0,
			27.0, 239.0,
			22.0, 242.0,
			17.0, 241.0,
			19.0, 239.0,
			17.0, 236.0,
			10.0, 238.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_153_0;
			g.setTransform(defaultTransform__0_153_0);
			g.setClip(clip__0_153_0);
			origAlpha = alpha__0_153;
			g.setTransform(defaultTransform__0_153);
			g.setClip(clip__0_153);
			float alpha__0_154 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_154 = g.getClip();
			AffineTransform defaultTransform__0_154 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_154 is CompositeGraphicsNode
			float alpha__0_154_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_154_0 = g.getClip();
			AffineTransform defaultTransform__0_154_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_154_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(184.0, 228.0,
			186.0, 231.0,
			184.0, 236.0,
			175.0, 238.0,
			171.0, 244.0,
			159.0, 251.0,
			154.0, 248.0,
			151.0, 240.0,
			156.0, 234.0,
			160.0, 234.0,
			163.0, 236.0,
			167.0, 230.0,
			174.0, 233.0,
			177.0, 228.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(184.0, 228.0,
			186.0, 231.0,
			184.0, 236.0,
			175.0, 238.0,
			171.0, 244.0,
			159.0, 251.0,
			154.0, 248.0,
			151.0, 240.0,
			156.0, 234.0,
			160.0, 234.0,
			163.0, 236.0,
			167.0, 230.0,
			174.0, 233.0,
			177.0, 228.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_154_0;
			g.setTransform(defaultTransform__0_154_0);
			g.setClip(clip__0_154_0);
			origAlpha = alpha__0_154;
			g.setTransform(defaultTransform__0_154);
			g.setClip(clip__0_154);
			float alpha__0_155 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_155 = g.getClip();
			AffineTransform defaultTransform__0_155 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_155 is CompositeGraphicsNode
			float alpha__0_155_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_155_0 = g.getClip();
			AffineTransform defaultTransform__0_155_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_155_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(186.0, 231.0,
			187.0, 230.0,
			190.0, 232.0,
			193.0, 236.0,
			190.0, 240.0,
			186.0, 241.0,
			185.0, 248.0,
			180.0, 250.0,
			179.0, 252.0,
			172.0, 252.0,
			167.0, 256.0,
			167.0, 253.0,
			163.0, 249.0,
			163.0, 247.0,
			171.0, 244.0,
			175.0, 238.0,
			184.0, 236.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(186.0, 231.0,
			187.0, 230.0,
			190.0, 232.0,
			193.0, 236.0,
			190.0, 240.0,
			186.0, 241.0,
			185.0, 248.0,
			180.0, 250.0,
			179.0, 252.0,
			172.0, 252.0,
			167.0, 256.0,
			167.0, 253.0,
			163.0, 249.0,
			163.0, 247.0,
			171.0, 244.0,
			175.0, 238.0,
			184.0, 236.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_155_0;
			g.setTransform(defaultTransform__0_155_0);
			g.setClip(clip__0_155_0);
			origAlpha = alpha__0_155;
			g.setTransform(defaultTransform__0_155);
			g.setClip(clip__0_155);
			float alpha__0_156 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_156 = g.getClip();
			AffineTransform defaultTransform__0_156 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_156 is CompositeGraphicsNode
			float alpha__0_156_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_156_0 = g.getClip();
			AffineTransform defaultTransform__0_156_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_156_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(138.0, 238.0,
			139.0, 244.0,
			144.0, 246.0,
			145.0, 249.0,
			140.0, 254.0,
			129.0, 259.0,
			124.0, 254.0,
			126.0, 252.0,
			119.0, 250.0,
			118.0, 248.0,
			124.0, 240.0,
			137.0, 235.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(138.0, 238.0,
			139.0, 244.0,
			144.0, 246.0,
			145.0, 249.0,
			140.0, 254.0,
			129.0, 259.0,
			124.0, 254.0,
			126.0, 252.0,
			119.0, 250.0,
			118.0, 248.0,
			124.0, 240.0,
			137.0, 235.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_156_0;
			g.setTransform(defaultTransform__0_156_0);
			g.setClip(clip__0_156_0);
			origAlpha = alpha__0_156;
			g.setTransform(defaultTransform__0_156);
			g.setClip(clip__0_156);
			float alpha__0_157 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_157 = g.getClip();
			AffineTransform defaultTransform__0_157 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_157 is CompositeGraphicsNode
			float alpha__0_157_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_157_0 = g.getClip();
			AffineTransform defaultTransform__0_157_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_157_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(93.0, 245.0,
			91.0, 255.0,
			94.0, 260.0,
			92.0, 263.0,
			94.0, 264.0,
			92.0, 268.0,
			90.0, 270.0,
			85.0, 270.0,
			83.0, 279.0,
			78.0, 276.0,
			74.0, 282.0,
			69.0, 280.0,
			63.0, 271.0,
			64.0, 259.0,
			61.0, 255.0,
			62.0, 253.0,
			66.0, 251.0,
			71.0, 244.0,
			74.0, 244.0,
			80.0, 249.0,
			85.0, 246.0,
			85.0, 241.0,
			93.0, 238.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(93.0, 245.0,
			91.0, 255.0,
			94.0, 260.0,
			92.0, 263.0,
			94.0, 264.0,
			92.0, 268.0,
			90.0, 270.0,
			85.0, 270.0,
			83.0, 279.0,
			78.0, 276.0,
			74.0, 282.0,
			69.0, 280.0,
			63.0, 271.0,
			64.0, 259.0,
			61.0, 255.0,
			62.0, 253.0,
			66.0, 251.0,
			71.0, 244.0,
			74.0, 244.0,
			80.0, 249.0,
			85.0, 246.0,
			85.0, 241.0,
			93.0, 238.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_157_0;
			g.setTransform(defaultTransform__0_157_0);
			g.setClip(clip__0_157_0);
			origAlpha = alpha__0_157;
			g.setTransform(defaultTransform__0_157);
			g.setClip(clip__0_157);
			float alpha__0_158 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_158 = g.getClip();
			AffineTransform defaultTransform__0_158 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_158 is CompositeGraphicsNode
			float alpha__0_158_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_158_0 = g.getClip();
			AffineTransform defaultTransform__0_158_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_158_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(141.0, 245.0,
			145.0, 240.0,
			147.0, 243.0,
			151.0, 240.0,
			154.0, 248.0,
			157.0, 251.0,
			163.0, 247.0,
			167.0, 253.0,
			166.0, 261.0,
			155.0, 269.0,
			153.0, 274.0,
			149.0, 276.0,
			136.0, 274.0,
			138.0, 264.0,
			134.0, 257.0,
			145.0, 249.0,
			144.0, 246.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(141.0, 245.0,
			145.0, 240.0,
			147.0, 243.0,
			151.0, 240.0,
			154.0, 248.0,
			157.0, 251.0,
			163.0, 247.0,
			167.0, 253.0,
			166.0, 261.0,
			155.0, 269.0,
			153.0, 274.0,
			149.0, 276.0,
			136.0, 274.0,
			138.0, 264.0,
			134.0, 257.0,
			145.0, 249.0,
			144.0, 246.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_158_0;
			g.setTransform(defaultTransform__0_158_0);
			g.setClip(clip__0_158_0);
			origAlpha = alpha__0_158;
			g.setTransform(defaultTransform__0_158);
			g.setClip(clip__0_158);
			float alpha__0_159 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_159 = g.getClip();
			AffineTransform defaultTransform__0_159 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_159 is CompositeGraphicsNode
			float alpha__0_159_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_159_0 = g.getClip();
			AffineTransform defaultTransform__0_159_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_159_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(93.0, 245.0,
			97.0, 245.0,
			99.0, 247.0,
			101.0, 266.0,
			100.0, 271.0,
			95.0, 269.0,
			93.0, 271.0,
			94.0, 273.0,
			89.0, 272.0,
			94.0, 264.0,
			92.0, 263.0,
			94.0, 257.0,
			91.0, 255.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(93.0, 245.0,
			97.0, 245.0,
			99.0, 247.0,
			101.0, 266.0,
			100.0, 271.0,
			95.0, 269.0,
			93.0, 271.0,
			94.0, 273.0,
			89.0, 272.0,
			94.0, 264.0,
			92.0, 263.0,
			94.0, 257.0,
			91.0, 255.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_159_0;
			g.setTransform(defaultTransform__0_159_0);
			g.setClip(clip__0_159_0);
			origAlpha = alpha__0_159;
			g.setTransform(defaultTransform__0_159);
			g.setClip(clip__0_159);
			float alpha__0_160 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_160 = g.getClip();
			AffineTransform defaultTransform__0_160 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_160 is CompositeGraphicsNode
			float alpha__0_160_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_160_0 = g.getClip();
			AffineTransform defaultTransform__0_160_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_160_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(185.0, 248.0,
			186.0, 251.0,
			190.0, 253.0,
			180.0, 260.0,
			177.0, 266.0,
			181.0, 269.0,
			179.0, 271.0,
			182.0, 275.0,
			176.0, 283.0,
			173.0, 282.0,
			171.0, 285.0,
			168.0, 286.0,
			164.0, 299.0,
			162.0, 299.0,
			153.0, 291.0,
			156.0, 284.0,
			154.0, 280.0,
			151.0, 281.0,
			149.0, 276.0,
			153.0, 274.0,
			155.0, 269.0,
			163.0, 264.0,
			168.0, 255.0,
			175.0, 251.0,
			179.0, 252.0,
			180.0, 250.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(185.0, 248.0,
			186.0, 251.0,
			190.0, 253.0,
			180.0, 260.0,
			177.0, 266.0,
			181.0, 269.0,
			179.0, 271.0,
			182.0, 275.0,
			176.0, 283.0,
			173.0, 282.0,
			171.0, 285.0,
			168.0, 286.0,
			164.0, 299.0,
			162.0, 299.0,
			153.0, 291.0,
			156.0, 284.0,
			154.0, 280.0,
			151.0, 281.0,
			149.0, 276.0,
			153.0, 274.0,
			155.0, 269.0,
			163.0, 264.0,
			168.0, 255.0,
			175.0, 251.0,
			179.0, 252.0,
			180.0, 250.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_160_0;
			g.setTransform(defaultTransform__0_160_0);
			g.setClip(clip__0_160_0);
			origAlpha = alpha__0_160;
			g.setTransform(defaultTransform__0_160);
			g.setClip(clip__0_160);
			float alpha__0_161 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_161 = g.getClip();
			AffineTransform defaultTransform__0_161 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_161 is CompositeGraphicsNode
			float alpha__0_161_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_161_0 = g.getClip();
			AffineTransform defaultTransform__0_161_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_161_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(196.0, 251.0,
			201.0, 257.0,
			200.0, 261.0,
			198.0, 260.0,
			197.0, 265.0,
			204.0, 264.0,
			204.0, 269.0,
			199.0, 270.0,
			196.0, 274.0,
			187.0, 276.0,
			182.0, 275.0,
			179.0, 271.0,
			181.0, 269.0,
			177.0, 266.0,
			179.0, 262.0,
			190.0, 253.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(196.0, 251.0,
			201.0, 257.0,
			200.0, 261.0,
			198.0, 260.0,
			197.0, 265.0,
			204.0, 264.0,
			204.0, 269.0,
			199.0, 270.0,
			196.0, 274.0,
			187.0, 276.0,
			182.0, 275.0,
			179.0, 271.0,
			181.0, 269.0,
			177.0, 266.0,
			179.0, 262.0,
			190.0, 253.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_161_0;
			g.setTransform(defaultTransform__0_161_0);
			g.setClip(clip__0_161_0);
			origAlpha = alpha__0_161;
			g.setTransform(defaultTransform__0_161);
			g.setClip(clip__0_161);
			float alpha__0_162 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_162 = g.getClip();
			AffineTransform defaultTransform__0_162 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_162 is CompositeGraphicsNode
			float alpha__0_162_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_162_0 = g.getClip();
			AffineTransform defaultTransform__0_162_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_162_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(119.0, 250.0,
			126.0, 252.0,
			124.0, 254.0,
			129.0, 259.0,
			134.0, 257.0,
			137.0, 261.0,
			138.0, 272.0,
			135.0, 274.0,
			122.0, 275.0,
			121.0, 279.0,
			110.0, 291.0,
			108.0, 288.0,
			112.0, 275.0,
			109.0, 272.0,
			106.0, 274.0,
			106.0, 269.0,
			102.0, 268.0,
			105.0, 264.0,
			100.0, 265.0,
			100.0, 253.0,
			103.0, 252.0,
			105.0, 255.0,
			109.0, 251.0,
			112.0, 255.0,
			117.0, 254.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(119.0, 250.0,
			126.0, 252.0,
			124.0, 254.0,
			129.0, 259.0,
			134.0, 257.0,
			137.0, 261.0,
			138.0, 272.0,
			135.0, 274.0,
			122.0, 275.0,
			121.0, 279.0,
			110.0, 291.0,
			108.0, 288.0,
			112.0, 275.0,
			109.0, 272.0,
			106.0, 274.0,
			106.0, 269.0,
			102.0, 268.0,
			105.0, 264.0,
			100.0, 265.0,
			100.0, 253.0,
			103.0, 252.0,
			105.0, 255.0,
			109.0, 251.0,
			112.0, 255.0,
			117.0, 254.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_162_0;
			g.setTransform(defaultTransform__0_162_0);
			g.setClip(clip__0_162_0);
			origAlpha = alpha__0_162;
			g.setTransform(defaultTransform__0_162);
			g.setClip(clip__0_162);
			float alpha__0_163 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_163 = g.getClip();
			AffineTransform defaultTransform__0_163 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_163 is CompositeGraphicsNode
			float alpha__0_163_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_163_0 = g.getClip();
			AffineTransform defaultTransform__0_163_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_163_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(92.0, 273.0,
			94.0, 273.0,
			93.0, 271.0,
			95.0, 269.0,
			100.0, 271.0,
			101.0, 266.0,
			105.0, 264.0,
			102.0, 268.0,
			106.0, 269.0,
			106.0, 274.0,
			109.0, 272.0,
			112.0, 275.0,
			108.0, 288.0,
			111.0, 295.0,
			108.0, 295.0,
			108.0, 297.0,
			103.0, 297.0,
			97.0, 302.0,
			95.0, 301.0,
			92.0, 289.0,
			88.0, 289.0,
			86.0, 285.0,
			92.0, 278.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(92.0, 273.0,
			94.0, 273.0,
			93.0, 271.0,
			95.0, 269.0,
			100.0, 271.0,
			101.0, 266.0,
			105.0, 264.0,
			102.0, 268.0,
			106.0, 269.0,
			106.0, 274.0,
			109.0, 272.0,
			112.0, 275.0,
			108.0, 288.0,
			111.0, 295.0,
			108.0, 295.0,
			108.0, 297.0,
			103.0, 297.0,
			97.0, 302.0,
			95.0, 301.0,
			92.0, 289.0,
			88.0, 289.0,
			86.0, 285.0,
			92.0, 278.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_163_0;
			g.setTransform(defaultTransform__0_163_0);
			g.setClip(clip__0_163_0);
			origAlpha = alpha__0_163;
			g.setTransform(defaultTransform__0_163);
			g.setClip(clip__0_163);
			float alpha__0_164 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_164 = g.getClip();
			AffineTransform defaultTransform__0_164 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_164 is CompositeGraphicsNode
			float alpha__0_164_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_164_0 = g.getClip();
			AffineTransform defaultTransform__0_164_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_164_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(58.0, 273.0,
			59.0, 271.0,
			64.0, 272.0,
			69.0, 280.0,
			74.0, 282.0,
			78.0, 276.0,
			83.0, 279.0,
			85.0, 270.0,
			89.0, 269.0,
			89.0, 272.0,
			93.0, 274.0,
			92.0, 278.0,
			86.0, 284.0,
			86.0, 287.0,
			83.0, 283.0,
			79.0, 285.0,
			74.0, 282.0,
			73.0, 285.0,
			63.0, 286.0,
			60.0, 290.0,
			58.0, 286.0,
			52.0, 288.0,
			54.0, 283.0,
			56.0, 282.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(58.0, 273.0,
			59.0, 271.0,
			64.0, 272.0,
			69.0, 280.0,
			74.0, 282.0,
			78.0, 276.0,
			83.0, 279.0,
			85.0, 270.0,
			89.0, 269.0,
			89.0, 272.0,
			93.0, 274.0,
			92.0, 278.0,
			86.0, 284.0,
			86.0, 287.0,
			83.0, 283.0,
			79.0, 285.0,
			74.0, 282.0,
			73.0, 285.0,
			63.0, 286.0,
			60.0, 290.0,
			58.0, 286.0,
			52.0, 288.0,
			54.0, 283.0,
			56.0, 282.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_164_0;
			g.setTransform(defaultTransform__0_164_0);
			g.setClip(clip__0_164_0);
			origAlpha = alpha__0_164;
			g.setTransform(defaultTransform__0_164);
			g.setClip(clip__0_164);
			float alpha__0_165 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_165 = g.getClip();
			AffineTransform defaultTransform__0_165 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_165 is CompositeGraphicsNode
			float alpha__0_165_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_165_0 = g.getClip();
			AffineTransform defaultTransform__0_165_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_165_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(215.0, 221.0,
			219.0, 220.0,
			220.0, 223.0,
			225.0, 222.0,
			230.0, 224.0,
			231.0, 231.0,
			227.0, 239.0,
			227.0, 244.0,
			220.0, 245.0,
			217.0, 243.0,
			217.0, 238.0,
			213.0, 236.0,
			217.0, 232.0,
			217.0, 227.0,
			213.0, 223.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(215.0, 221.0,
			219.0, 220.0,
			220.0, 223.0,
			225.0, 222.0,
			230.0, 224.0,
			231.0, 231.0,
			227.0, 239.0,
			227.0, 244.0,
			220.0, 245.0,
			217.0, 243.0,
			217.0, 238.0,
			213.0, 236.0,
			217.0, 232.0,
			217.0, 227.0,
			213.0, 223.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_165_0;
			g.setTransform(defaultTransform__0_165_0);
			g.setClip(clip__0_165_0);
			origAlpha = alpha__0_165;
			g.setTransform(defaultTransform__0_165);
			g.setClip(clip__0_165);
			float alpha__0_166 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_166 = g.getClip();
			AffineTransform defaultTransform__0_166 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_166 is CompositeGraphicsNode
			float alpha__0_166_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_166_0 = g.getClip();
			AffineTransform defaultTransform__0_166_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_166_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(231.0, 222.0,
			235.0, 222.0,
			234.0, 226.0,
			237.0, 236.0,
			238.0, 238.0,
			242.0, 238.0,
			242.0, 244.0,
			240.0, 247.0,
			234.0, 245.0,
			234.0, 243.0,
			228.0, 237.0,
			230.0, 234.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(231.0, 222.0,
			235.0, 222.0,
			234.0, 226.0,
			237.0, 236.0,
			238.0, 238.0,
			242.0, 238.0,
			242.0, 244.0,
			240.0, 247.0,
			234.0, 245.0,
			234.0, 243.0,
			228.0, 237.0,
			230.0, 234.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_166_0;
			g.setTransform(defaultTransform__0_166_0);
			g.setClip(clip__0_166_0);
			origAlpha = alpha__0_166;
			g.setTransform(defaultTransform__0_166);
			g.setClip(clip__0_166);
			float alpha__0_167 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_167 = g.getClip();
			AffineTransform defaultTransform__0_167 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_167 is CompositeGraphicsNode
			float alpha__0_167_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_167_0 = g.getClip();
			AffineTransform defaultTransform__0_167_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_167_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(247.0, 227.0,
			249.0, 229.0,
			255.0, 227.0,
			258.0, 230.0,
			262.0, 230.0,
			257.0, 236.0,
			258.0, 240.0,
			256.0, 238.0,
			248.0, 239.0,
			242.0, 243.0,
			242.0, 238.0,
			238.0, 238.0,
			237.0, 231.0,
			240.0, 227.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(247.0, 227.0,
			249.0, 229.0,
			255.0, 227.0,
			258.0, 230.0,
			262.0, 230.0,
			257.0, 236.0,
			258.0, 240.0,
			256.0, 238.0,
			248.0, 239.0,
			242.0, 243.0,
			242.0, 238.0,
			238.0, 238.0,
			237.0, 231.0,
			240.0, 227.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_167_0;
			g.setTransform(defaultTransform__0_167_0);
			g.setClip(clip__0_167_0);
			origAlpha = alpha__0_167;
			g.setTransform(defaultTransform__0_167);
			g.setClip(clip__0_167);
			float alpha__0_168 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_168 = g.getClip();
			AffineTransform defaultTransform__0_168 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_168 is CompositeGraphicsNode
			float alpha__0_168_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_168_0 = g.getClip();
			AffineTransform defaultTransform__0_168_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_168_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(275.0, 233.0,
			277.0, 231.0,
			277.0, 233.0,
			283.0, 235.0,
			282.0, 234.0,
			287.0, 229.0,
			290.0, 237.0,
			293.0, 237.0,
			291.0, 240.0,
			287.0, 240.0,
			283.0, 250.0,
			277.0, 250.0,
			278.0, 253.0,
			276.0, 257.0,
			273.0, 252.0,
			274.0, 248.0,
			270.0, 247.0,
			275.0, 242.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(275.0, 233.0,
			277.0, 231.0,
			277.0, 233.0,
			283.0, 235.0,
			282.0, 234.0,
			287.0, 229.0,
			290.0, 237.0,
			293.0, 237.0,
			291.0, 240.0,
			287.0, 240.0,
			283.0, 250.0,
			277.0, 250.0,
			278.0, 253.0,
			276.0, 257.0,
			273.0, 252.0,
			274.0, 248.0,
			270.0, 247.0,
			275.0, 242.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_168_0;
			g.setTransform(defaultTransform__0_168_0);
			g.setClip(clip__0_168_0);
			origAlpha = alpha__0_168;
			g.setTransform(defaultTransform__0_168);
			g.setClip(clip__0_168);
			float alpha__0_169 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_169 = g.getClip();
			AffineTransform defaultTransform__0_169 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_169 is CompositeGraphicsNode
			float alpha__0_169_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_169_0 = g.getClip();
			AffineTransform defaultTransform__0_169_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_169_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(275.0, 233.0,
			275.0, 242.0,
			271.0, 245.0,
			271.0, 248.0,
			268.0, 249.0,
			258.0, 244.0,
			259.0, 238.0,
			257.0, 236.0,
			264.0, 230.0,
			268.0, 232.0,
			270.0, 231.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(275.0, 233.0,
			275.0, 242.0,
			271.0, 245.0,
			271.0, 248.0,
			268.0, 249.0,
			258.0, 244.0,
			259.0, 238.0,
			257.0, 236.0,
			264.0, 230.0,
			268.0, 232.0,
			270.0, 231.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_169_0;
			g.setTransform(defaultTransform__0_169_0);
			g.setClip(clip__0_169_0);
			origAlpha = alpha__0_169;
			g.setTransform(defaultTransform__0_169);
			g.setClip(clip__0_169);
			float alpha__0_170 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_170 = g.getClip();
			AffineTransform defaultTransform__0_170 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_170 is CompositeGraphicsNode
			float alpha__0_170_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_170_0 = g.getClip();
			AffineTransform defaultTransform__0_170_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_170_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(295.0, 232.0,
			298.0, 239.0,
			294.0, 257.0,
			293.0, 254.0,
			283.0, 250.0,
			287.0, 240.0,
			292.0, 239.0,
			293.0, 237.0,
			290.0, 237.0,
			289.0, 234.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(295.0, 232.0,
			298.0, 239.0,
			294.0, 257.0,
			293.0, 254.0,
			283.0, 250.0,
			287.0, 240.0,
			292.0, 239.0,
			293.0, 237.0,
			290.0, 237.0,
			289.0, 234.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_170_0;
			g.setTransform(defaultTransform__0_170_0);
			g.setClip(clip__0_170_0);
			origAlpha = alpha__0_170;
			g.setTransform(defaultTransform__0_170);
			g.setClip(clip__0_170);
			float alpha__0_171 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_171 = g.getClip();
			AffineTransform defaultTransform__0_171 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_171 is CompositeGraphicsNode
			float alpha__0_171_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_171_0 = g.getClip();
			AffineTransform defaultTransform__0_171_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_171_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(298.0, 236.0,
			299.0, 246.0,
			303.0, 249.0,
			298.0, 261.0,
			302.0, 261.0,
			303.0, 263.0,
			298.0, 269.0,
			296.0, 269.0,
			293.0, 266.0,
			290.0, 270.0,
			287.0, 270.0,
			286.0, 268.0,
			295.0, 254.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(298.0, 236.0,
			299.0, 246.0,
			303.0, 249.0,
			298.0, 261.0,
			302.0, 261.0,
			303.0, 263.0,
			298.0, 269.0,
			296.0, 269.0,
			293.0, 266.0,
			290.0, 270.0,
			287.0, 270.0,
			286.0, 268.0,
			295.0, 254.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_171_0;
			g.setTransform(defaultTransform__0_171_0);
			g.setClip(clip__0_171_0);
			origAlpha = alpha__0_171;
			g.setTransform(defaultTransform__0_171);
			g.setClip(clip__0_171);
			float alpha__0_172 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_172 = g.getClip();
			AffineTransform defaultTransform__0_172 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_172 is CompositeGraphicsNode
			float alpha__0_172_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_172_0 = g.getClip();
			AffineTransform defaultTransform__0_172_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_172_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(228.0, 237.0,
			234.0, 243.0,
			234.0, 245.0,
			238.0, 245.0,
			242.0, 249.0,
			240.0, 255.0,
			234.0, 253.0,
			231.0, 257.0,
			230.0, 261.0,
			233.0, 263.0,
			230.0, 267.0,
			222.0, 264.0,
			219.0, 260.0,
			221.0, 256.0,
			224.0, 256.0,
			227.0, 251.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(228.0, 237.0,
			234.0, 243.0,
			234.0, 245.0,
			238.0, 245.0,
			242.0, 249.0,
			240.0, 255.0,
			234.0, 253.0,
			231.0, 257.0,
			230.0, 261.0,
			233.0, 263.0,
			230.0, 267.0,
			222.0, 264.0,
			219.0, 260.0,
			221.0, 256.0,
			224.0, 256.0,
			227.0, 251.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_172_0;
			g.setTransform(defaultTransform__0_172_0);
			g.setClip(clip__0_172_0);
			origAlpha = alpha__0_172;
			g.setTransform(defaultTransform__0_172);
			g.setClip(clip__0_172);
			float alpha__0_173 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_173 = g.getClip();
			AffineTransform defaultTransform__0_173 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_173 is CompositeGraphicsNode
			float alpha__0_173_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_173_0 = g.getClip();
			AffineTransform defaultTransform__0_173_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_173_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(242.0, 243.0,
			248.0, 239.0,
			257.0, 238.0,
			258.0, 243.0,
			255.0, 249.0,
			258.0, 254.0,
			257.0, 257.0,
			252.0, 257.0,
			250.0, 250.0,
			246.0, 250.0,
			245.0, 248.0,
			240.0, 249.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(242.0, 243.0,
			248.0, 239.0,
			257.0, 238.0,
			258.0, 243.0,
			255.0, 249.0,
			258.0, 254.0,
			257.0, 257.0,
			252.0, 257.0,
			250.0, 250.0,
			246.0, 250.0,
			245.0, 248.0,
			240.0, 249.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_173_0;
			g.setTransform(defaultTransform__0_173_0);
			g.setClip(clip__0_173_0);
			origAlpha = alpha__0_173;
			g.setTransform(defaultTransform__0_173);
			g.setClip(clip__0_173);
			float alpha__0_174 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_174 = g.getClip();
			AffineTransform defaultTransform__0_174 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_174 is CompositeGraphicsNode
			float alpha__0_174_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_174_0 = g.getClip();
			AffineTransform defaultTransform__0_174_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_174_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(216.0, 240.0,
			217.0, 243.0,
			220.0, 245.0,
			227.0, 244.0,
			228.0, 250.0,
			224.0, 256.0,
			221.0, 256.0,
			217.0, 260.0,
			215.0, 271.0,
			210.0, 274.0,
			208.0, 271.0,
			204.0, 269.0,
			204.0, 264.0,
			197.0, 265.0,
			198.0, 260.0,
			200.0, 261.0,
			201.0, 257.0,
			196.0, 251.0,
			198.0, 249.0,
			203.0, 250.0,
			206.0, 247.0,
			210.0, 246.0,
			211.0, 242.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(216.0, 240.0,
			217.0, 243.0,
			220.0, 245.0,
			227.0, 244.0,
			228.0, 250.0,
			224.0, 256.0,
			221.0, 256.0,
			217.0, 260.0,
			215.0, 271.0,
			210.0, 274.0,
			208.0, 271.0,
			204.0, 269.0,
			204.0, 264.0,
			197.0, 265.0,
			198.0, 260.0,
			200.0, 261.0,
			201.0, 257.0,
			196.0, 251.0,
			198.0, 249.0,
			203.0, 250.0,
			206.0, 247.0,
			210.0, 246.0,
			211.0, 242.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_174_0;
			g.setTransform(defaultTransform__0_174_0);
			g.setClip(clip__0_174_0);
			origAlpha = alpha__0_174;
			g.setTransform(defaultTransform__0_174);
			g.setClip(clip__0_174);
			float alpha__0_175 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_175 = g.getClip();
			AffineTransform defaultTransform__0_175 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_175 is CompositeGraphicsNode
			float alpha__0_175_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_175_0 = g.getClip();
			AffineTransform defaultTransform__0_175_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_175_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(271.0, 248.0,
			274.0, 248.0,
			273.0, 252.0,
			276.0, 257.0,
			270.0, 255.0,
			267.0, 256.0,
			266.0, 259.0,
			260.0, 261.0,
			257.0, 267.0,
			253.0, 260.0,
			253.0, 257.0,
			256.0, 258.0,
			258.0, 256.0,
			256.0, 246.0,
			258.0, 243.0,
			268.0, 249.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(271.0, 248.0,
			274.0, 248.0,
			273.0, 252.0,
			276.0, 257.0,
			270.0, 255.0,
			267.0, 256.0,
			266.0, 259.0,
			260.0, 261.0,
			257.0, 267.0,
			253.0, 260.0,
			253.0, 257.0,
			256.0, 258.0,
			258.0, 256.0,
			256.0, 246.0,
			258.0, 243.0,
			268.0, 249.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_175_0;
			g.setTransform(defaultTransform__0_175_0);
			g.setClip(clip__0_175_0);
			origAlpha = alpha__0_175;
			g.setTransform(defaultTransform__0_175);
			g.setClip(clip__0_175);
			float alpha__0_176 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_176 = g.getClip();
			AffineTransform defaultTransform__0_176 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_176 is CompositeGraphicsNode
			float alpha__0_176_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_176_0 = g.getClip();
			AffineTransform defaultTransform__0_176_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_176_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(242.0, 249.0,
			245.0, 248.0,
			246.0, 250.0,
			251.0, 250.0,
			254.0, 263.0,
			258.0, 267.0,
			255.0, 267.0,
			252.0, 271.0,
			248.0, 266.0,
			239.0, 269.0,
			235.0, 265.0,
			235.0, 260.0,
			233.0, 262.0,
			230.0, 261.0,
			231.0, 257.0,
			234.0, 254.0,
			240.0, 255.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(242.0, 249.0,
			245.0, 248.0,
			246.0, 250.0,
			251.0, 250.0,
			254.0, 263.0,
			258.0, 267.0,
			255.0, 267.0,
			252.0, 271.0,
			248.0, 266.0,
			239.0, 269.0,
			235.0, 265.0,
			235.0, 260.0,
			233.0, 262.0,
			230.0, 261.0,
			231.0, 257.0,
			234.0, 254.0,
			240.0, 255.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_176_0;
			g.setTransform(defaultTransform__0_176_0);
			g.setClip(clip__0_176_0);
			origAlpha = alpha__0_176;
			g.setTransform(defaultTransform__0_176);
			g.setClip(clip__0_176);
			float alpha__0_177 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_177 = g.getClip();
			AffineTransform defaultTransform__0_177 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_177 is CompositeGraphicsNode
			float alpha__0_177_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_177_0 = g.getClip();
			AffineTransform defaultTransform__0_177_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_177_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(283.0, 250.0,
			293.0, 254.0,
			294.0, 257.0,
			287.0, 267.0,
			276.0, 275.0,
			274.0, 272.0,
			274.0, 266.0,
			277.0, 261.0,
			274.0, 260.0,
			278.0, 253.0,
			277.0, 250.0,
			279.0, 249.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(283.0, 250.0,
			293.0, 254.0,
			294.0, 257.0,
			287.0, 267.0,
			276.0, 275.0,
			274.0, 272.0,
			274.0, 266.0,
			277.0, 261.0,
			274.0, 260.0,
			278.0, 253.0,
			277.0, 250.0,
			279.0, 249.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_177_0;
			g.setTransform(defaultTransform__0_177_0);
			g.setClip(clip__0_177_0);
			origAlpha = alpha__0_177;
			g.setTransform(defaultTransform__0_177);
			g.setClip(clip__0_177);
			float alpha__0_178 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_178 = g.getClip();
			AffineTransform defaultTransform__0_178 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_178 is CompositeGraphicsNode
			float alpha__0_178_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_178_0 = g.getClip();
			AffineTransform defaultTransform__0_178_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_178_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(303.0, 249.0,
			307.0, 254.0,
			307.0, 252.0,
			309.0, 254.0,
			312.0, 254.0,
			309.0, 264.0,
			307.0, 263.0,
			305.0, 265.0,
			306.0, 268.0,
			299.0, 268.0,
			303.0, 263.0,
			302.0, 261.0,
			298.0, 261.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(303.0, 249.0,
			307.0, 254.0,
			307.0, 252.0,
			309.0, 254.0,
			312.0, 254.0,
			309.0, 264.0,
			307.0, 263.0,
			305.0, 265.0,
			306.0, 268.0,
			299.0, 268.0,
			303.0, 263.0,
			302.0, 261.0,
			298.0, 261.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_178_0;
			g.setTransform(defaultTransform__0_178_0);
			g.setClip(clip__0_178_0);
			origAlpha = alpha__0_178;
			g.setTransform(defaultTransform__0_178);
			g.setClip(clip__0_178);
			float alpha__0_179 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_179 = g.getClip();
			AffineTransform defaultTransform__0_179 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_179 is CompositeGraphicsNode
			float alpha__0_179_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_179_0 = g.getClip();
			AffineTransform defaultTransform__0_179_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_179_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(320.0, 257.0,
			319.0, 259.0,
			321.0, 263.0,
			315.0, 270.0,
			315.0, 276.0,
			313.0, 277.0,
			309.0, 269.0,
			305.0, 269.0,
			305.0, 265.0,
			309.0, 264.0,
			312.0, 255.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(320.0, 257.0,
			319.0, 259.0,
			321.0, 263.0,
			315.0, 270.0,
			315.0, 276.0,
			313.0, 277.0,
			309.0, 269.0,
			305.0, 269.0,
			305.0, 265.0,
			309.0, 264.0,
			312.0, 255.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_179_0;
			g.setTransform(defaultTransform__0_179_0);
			g.setClip(clip__0_179_0);
			origAlpha = alpha__0_179;
			g.setTransform(defaultTransform__0_179);
			g.setClip(clip__0_179);
			float alpha__0_180 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_180 = g.getClip();
			AffineTransform defaultTransform__0_180 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_180 is CompositeGraphicsNode
			float alpha__0_180_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_180_0 = g.getClip();
			AffineTransform defaultTransform__0_180_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_180_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(321.0, 256.0,
			324.0, 258.0,
			330.0, 256.0,
			334.0, 258.0,
			335.0, 260.0,
			332.0, 262.0,
			332.0, 265.0,
			334.0, 266.0,
			331.0, 271.0,
			323.0, 273.0,
			322.0, 277.0,
			317.0, 278.0,
			315.0, 277.0,
			315.0, 270.0,
			321.0, 263.0,
			319.0, 259.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(321.0, 256.0,
			324.0, 258.0,
			330.0, 256.0,
			334.0, 258.0,
			335.0, 260.0,
			332.0, 262.0,
			332.0, 265.0,
			334.0, 266.0,
			331.0, 271.0,
			323.0, 273.0,
			322.0, 277.0,
			317.0, 278.0,
			315.0, 277.0,
			315.0, 270.0,
			321.0, 263.0,
			319.0, 259.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_180_0;
			g.setTransform(defaultTransform__0_180_0);
			g.setClip(clip__0_180_0);
			origAlpha = alpha__0_180;
			g.setTransform(defaultTransform__0_180);
			g.setClip(clip__0_180);
			float alpha__0_181 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_181 = g.getClip();
			AffineTransform defaultTransform__0_181 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_181 is CompositeGraphicsNode
			float alpha__0_181_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_181_0 = g.getClip();
			AffineTransform defaultTransform__0_181_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_181_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(258.0, 267.0,
			260.0, 261.0,
			266.0, 259.0,
			267.0, 256.0,
			270.0, 255.0,
			275.0, 257.0,
			274.0, 260.0,
			277.0, 261.0,
			274.0, 266.0,
			274.0, 272.0,
			276.0, 275.0,
			274.0, 279.0,
			274.0, 284.0,
			269.0, 287.0,
			268.0, 291.0,
			262.0, 290.0,
			264.0, 287.0,
			264.0, 278.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(258.0, 267.0,
			260.0, 261.0,
			266.0, 259.0,
			267.0, 256.0,
			270.0, 255.0,
			275.0, 257.0,
			274.0, 260.0,
			277.0, 261.0,
			274.0, 266.0,
			274.0, 272.0,
			276.0, 275.0,
			274.0, 279.0,
			274.0, 284.0,
			269.0, 287.0,
			268.0, 291.0,
			262.0, 290.0,
			264.0, 287.0,
			264.0, 278.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_181_0;
			g.setTransform(defaultTransform__0_181_0);
			g.setClip(clip__0_181_0);
			origAlpha = alpha__0_181;
			g.setTransform(defaultTransform__0_181);
			g.setClip(clip__0_181);
			float alpha__0_182 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_182 = g.getClip();
			AffineTransform defaultTransform__0_182 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_182 is CompositeGraphicsNode
			float alpha__0_182_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_182_0 = g.getClip();
			AffineTransform defaultTransform__0_182_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_182_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(342.0, 260.0,
			347.0, 260.0,
			349.0, 267.0,
			345.0, 275.0,
			336.0, 282.0,
			326.0, 282.0,
			328.0, 279.0,
			333.0, 279.0,
			338.0, 273.0,
			342.0, 273.0,
			344.0, 265.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(342.0, 260.0,
			347.0, 260.0,
			349.0, 267.0,
			345.0, 275.0,
			336.0, 282.0,
			326.0, 282.0,
			328.0, 279.0,
			333.0, 279.0,
			338.0, 273.0,
			342.0, 273.0,
			344.0, 265.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_182_0;
			g.setTransform(defaultTransform__0_182_0);
			g.setClip(clip__0_182_0);
			origAlpha = alpha__0_182;
			g.setTransform(defaultTransform__0_182);
			g.setClip(clip__0_182);
			float alpha__0_183 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_183 = g.getClip();
			AffineTransform defaultTransform__0_183 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_183 is CompositeGraphicsNode
			float alpha__0_183_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_183_0 = g.getClip();
			AffineTransform defaultTransform__0_183_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_183_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(230.0, 267.0,
			231.0, 269.0,
			229.0, 275.0,
			226.0, 275.0,
			225.0, 280.0,
			215.0, 285.0,
			212.0, 280.0,
			208.0, 279.0,
			207.0, 277.0,
			215.0, 271.0,
			217.0, 261.0,
			219.0, 259.0,
			222.0, 264.0,
			226.0, 267.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(230.0, 267.0,
			231.0, 269.0,
			229.0, 275.0,
			226.0, 275.0,
			225.0, 280.0,
			215.0, 285.0,
			212.0, 280.0,
			208.0, 279.0,
			207.0, 277.0,
			215.0, 271.0,
			217.0, 261.0,
			219.0, 259.0,
			222.0, 264.0,
			226.0, 267.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_183_0;
			g.setTransform(defaultTransform__0_183_0);
			g.setClip(clip__0_183_0);
			origAlpha = alpha__0_183;
			g.setTransform(defaultTransform__0_183);
			g.setClip(clip__0_183);
			float alpha__0_184 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_184 = g.getClip();
			AffineTransform defaultTransform__0_184 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_184 is CompositeGraphicsNode
			float alpha__0_184_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_184_0 = g.getClip();
			AffineTransform defaultTransform__0_184_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_184_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(230.0, 267.0,
			235.0, 260.0,
			235.0, 265.0,
			240.0, 270.0,
			241.0, 277.0,
			243.0, 279.0,
			242.0, 282.0,
			238.0, 284.0,
			240.0, 291.0,
			232.0, 296.0,
			222.0, 296.0,
			215.0, 286.0,
			221.0, 281.0,
			225.0, 280.0,
			226.0, 275.0,
			229.0, 275.0,
			231.0, 269.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(230.0, 267.0,
			235.0, 260.0,
			235.0, 265.0,
			240.0, 270.0,
			241.0, 277.0,
			243.0, 279.0,
			242.0, 282.0,
			238.0, 284.0,
			240.0, 291.0,
			232.0, 296.0,
			222.0, 296.0,
			215.0, 286.0,
			221.0, 281.0,
			225.0, 280.0,
			226.0, 275.0,
			229.0, 275.0,
			231.0, 269.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_184_0;
			g.setTransform(defaultTransform__0_184_0);
			g.setClip(clip__0_184_0);
			origAlpha = alpha__0_184;
			g.setTransform(defaultTransform__0_184);
			g.setClip(clip__0_184);
			float alpha__0_185 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_185 = g.getClip();
			AffineTransform defaultTransform__0_185 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_185 is CompositeGraphicsNode
			float alpha__0_185_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_185_0 = g.getClip();
			AffineTransform defaultTransform__0_185_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_185_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(334.0, 266.0,
			334.0, 264.0,
			344.0, 266.0,
			342.0, 273.0,
			338.0, 273.0,
			334.0, 278.0,
			328.0, 273.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(334.0, 266.0,
			334.0, 264.0,
			344.0, 266.0,
			342.0, 273.0,
			338.0, 273.0,
			334.0, 278.0,
			328.0, 273.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_185_0;
			g.setTransform(defaultTransform__0_185_0);
			g.setClip(clip__0_185_0);
			origAlpha = alpha__0_185;
			g.setTransform(defaultTransform__0_185);
			g.setClip(clip__0_185);
			float alpha__0_186 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_186 = g.getClip();
			AffineTransform defaultTransform__0_186 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_186 is CompositeGraphicsNode
			float alpha__0_186_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_186_0 = g.getClip();
			AffineTransform defaultTransform__0_186_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_186_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(286.0, 268.0,
			290.0, 270.0,
			293.0, 266.0,
			299.0, 271.0,
			298.0, 277.0,
			294.0, 276.0,
			293.0, 278.0,
			293.0, 288.0,
			289.0, 290.0,
			287.0, 286.0,
			282.0, 287.0,
			279.0, 293.0,
			276.0, 293.0,
			275.0, 291.0,
			268.0, 293.0,
			269.0, 287.0,
			274.0, 284.0,
			275.0, 277.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(286.0, 268.0,
			290.0, 270.0,
			293.0, 266.0,
			299.0, 271.0,
			298.0, 277.0,
			294.0, 276.0,
			293.0, 278.0,
			293.0, 288.0,
			289.0, 290.0,
			287.0, 286.0,
			282.0, 287.0,
			279.0, 293.0,
			276.0, 293.0,
			275.0, 291.0,
			268.0, 293.0,
			269.0, 287.0,
			274.0, 284.0,
			275.0, 277.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_186_0;
			g.setTransform(defaultTransform__0_186_0);
			g.setClip(clip__0_186_0);
			origAlpha = alpha__0_186;
			g.setTransform(defaultTransform__0_186);
			g.setClip(clip__0_186);
			float alpha__0_187 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_187 = g.getClip();
			AffineTransform defaultTransform__0_187 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_187 is CompositeGraphicsNode
			float alpha__0_187_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_187_0 = g.getClip();
			AffineTransform defaultTransform__0_187_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_187_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(258.0, 267.0,
			264.0, 278.0,
			264.0, 287.0,
			262.0, 290.0,
			259.0, 287.0,
			255.0, 287.0,
			249.0, 291.0,
			240.0, 291.0,
			238.0, 284.0,
			242.0, 282.0,
			243.0, 279.0,
			241.0, 277.0,
			240.0, 270.0,
			248.0, 266.0,
			252.0, 271.0,
			255.0, 267.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(258.0, 267.0,
			264.0, 278.0,
			264.0, 287.0,
			262.0, 290.0,
			259.0, 287.0,
			255.0, 287.0,
			249.0, 291.0,
			240.0, 291.0,
			238.0, 284.0,
			242.0, 282.0,
			243.0, 279.0,
			241.0, 277.0,
			240.0, 270.0,
			248.0, 266.0,
			252.0, 271.0,
			255.0, 267.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_187_0;
			g.setTransform(defaultTransform__0_187_0);
			g.setClip(clip__0_187_0);
			origAlpha = alpha__0_187;
			g.setTransform(defaultTransform__0_187);
			g.setClip(clip__0_187);
			float alpha__0_188 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_188 = g.getClip();
			AffineTransform defaultTransform__0_188 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_188 is CompositeGraphicsNode
			float alpha__0_188_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_188_0 = g.getClip();
			AffineTransform defaultTransform__0_188_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_188_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(305.0, 269.0,
			309.0, 269.0,
			310.0, 274.0,
			313.0, 276.0,
			312.0, 284.0,
			314.0, 284.0,
			316.0, 288.0,
			310.0, 294.0,
			299.0, 295.0,
			294.0, 298.0,
			289.0, 290.0,
			293.0, 288.0,
			293.0, 278.0,
			294.0, 276.0,
			298.0, 277.0,
			299.0, 268.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(305.0, 269.0,
			309.0, 269.0,
			310.0, 274.0,
			313.0, 276.0,
			312.0, 284.0,
			314.0, 284.0,
			316.0, 288.0,
			310.0, 294.0,
			299.0, 295.0,
			294.0, 298.0,
			289.0, 290.0,
			293.0, 288.0,
			293.0, 278.0,
			294.0, 276.0,
			298.0, 277.0,
			299.0, 268.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_188_0;
			g.setTransform(defaultTransform__0_188_0);
			g.setClip(clip__0_188_0);
			origAlpha = alpha__0_188;
			g.setTransform(defaultTransform__0_188);
			g.setClip(clip__0_188);
			float alpha__0_189 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_189 = g.getClip();
			AffineTransform defaultTransform__0_189 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_189 is CompositeGraphicsNode
			float alpha__0_189_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_189_0 = g.getClip();
			AffineTransform defaultTransform__0_189_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_189_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(210.0, 274.0,
			201.0, 279.0,
			192.0, 294.0,
			183.0, 297.0,
			181.0, 294.0,
			187.0, 290.0,
			187.0, 288.0,
			186.0, 285.0,
			184.0, 286.0,
			181.0, 282.0,
			178.0, 282.0,
			182.0, 275.0,
			187.0, 276.0,
			196.0, 274.0,
			199.0, 270.0,
			204.0, 269.0,
			208.0, 271.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(210.0, 274.0,
			201.0, 279.0,
			192.0, 294.0,
			183.0, 297.0,
			181.0, 294.0,
			187.0, 290.0,
			187.0, 288.0,
			186.0, 285.0,
			184.0, 286.0,
			181.0, 282.0,
			178.0, 282.0,
			182.0, 275.0,
			187.0, 276.0,
			196.0, 274.0,
			199.0, 270.0,
			204.0, 269.0,
			208.0, 271.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_189_0;
			g.setTransform(defaultTransform__0_189_0);
			g.setClip(clip__0_189_0);
			origAlpha = alpha__0_189;
			g.setTransform(defaultTransform__0_189);
			g.setClip(clip__0_189);
			float alpha__0_190 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_190 = g.getClip();
			AffineTransform defaultTransform__0_190 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_190 is CompositeGraphicsNode
			float alpha__0_190_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_190_0 = g.getClip();
			AffineTransform defaultTransform__0_190_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_190_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(334.0, 278.0,
			328.0, 279.0,
			325.0, 282.0,
			321.0, 296.0,
			316.0, 296.0,
			316.0, 288.0,
			311.0, 282.0,
			313.0, 277.0,
			322.0, 277.0,
			323.0, 273.0,
			327.0, 272.0,
			328.0, 274.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(334.0, 278.0,
			328.0, 279.0,
			325.0, 282.0,
			321.0, 296.0,
			316.0, 296.0,
			316.0, 288.0,
			311.0, 282.0,
			313.0, 277.0,
			322.0, 277.0,
			323.0, 273.0,
			327.0, 272.0,
			328.0, 274.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_190_0;
			g.setTransform(defaultTransform__0_190_0);
			g.setClip(clip__0_190_0);
			origAlpha = alpha__0_190;
			g.setTransform(defaultTransform__0_190);
			g.setClip(clip__0_190);
			float alpha__0_191 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_191 = g.getClip();
			AffineTransform defaultTransform__0_191 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_191 is CompositeGraphicsNode
			float alpha__0_191_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_191_0 = g.getClip();
			AffineTransform defaultTransform__0_191_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_191_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(207.0, 277.0,
			208.0, 279.0,
			213.0, 281.0,
			214.0, 287.0,
			222.0, 295.0,
			216.0, 301.0,
			216.0, 306.0,
			220.0, 306.0,
			228.0, 313.0,
			225.0, 318.0,
			223.0, 318.0,
			225.0, 323.0,
			231.0, 326.0,
			229.0, 331.0,
			223.0, 325.0,
			217.0, 326.0,
			209.0, 321.0,
			201.0, 326.0,
			196.0, 318.0,
			193.0, 317.0,
			180.0, 304.0,
			183.0, 298.0,
			193.0, 294.0,
			201.0, 279.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(207.0, 277.0,
			208.0, 279.0,
			213.0, 281.0,
			214.0, 287.0,
			222.0, 295.0,
			216.0, 301.0,
			216.0, 306.0,
			220.0, 306.0,
			228.0, 313.0,
			225.0, 318.0,
			223.0, 318.0,
			225.0, 323.0,
			231.0, 326.0,
			229.0, 331.0,
			223.0, 325.0,
			217.0, 326.0,
			209.0, 321.0,
			201.0, 326.0,
			196.0, 318.0,
			193.0, 317.0,
			180.0, 304.0,
			183.0, 298.0,
			193.0, 294.0,
			201.0, 279.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_191_0;
			g.setTransform(defaultTransform__0_191_0);
			g.setClip(clip__0_191_0);
			origAlpha = alpha__0_191;
			g.setTransform(defaultTransform__0_191);
			g.setClip(clip__0_191);
			float alpha__0_192 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_192 = g.getClip();
			AffineTransform defaultTransform__0_192 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_192 is CompositeGraphicsNode
			float alpha__0_192_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_192_0 = g.getClip();
			AffineTransform defaultTransform__0_192_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_192_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(335.0, 282.0,
			338.0, 290.0,
			330.0, 299.0,
			332.0, 303.0,
			326.0, 303.0,
			323.0, 305.0,
			321.0, 297.0,
			324.0, 284.0,
			326.0, 281.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(335.0, 282.0,
			338.0, 290.0,
			330.0, 299.0,
			332.0, 303.0,
			326.0, 303.0,
			323.0, 305.0,
			321.0, 297.0,
			324.0, 284.0,
			326.0, 281.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_192_0;
			g.setTransform(defaultTransform__0_192_0);
			g.setClip(clip__0_192_0);
			origAlpha = alpha__0_192;
			g.setTransform(defaultTransform__0_192);
			g.setClip(clip__0_192);
			float alpha__0_193 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_193 = g.getClip();
			AffineTransform defaultTransform__0_193 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_193 is CompositeGraphicsNode
			float alpha__0_193_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_193_0 = g.getClip();
			AffineTransform defaultTransform__0_193_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_193_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(179.0, 279.0,
			178.0, 282.0,
			181.0, 282.0,
			184.0, 286.0,
			186.0, 285.0,
			187.0, 290.0,
			181.0, 294.0,
			184.0, 297.0,
			180.0, 304.0,
			173.0, 306.0,
			164.0, 299.0,
			166.0, 289.0,
			168.0, 286.0,
			171.0, 285.0,
			173.0, 282.0,
			176.0, 283.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(179.0, 279.0,
			178.0, 282.0,
			181.0, 282.0,
			184.0, 286.0,
			186.0, 285.0,
			187.0, 290.0,
			181.0, 294.0,
			184.0, 297.0,
			180.0, 304.0,
			173.0, 306.0,
			164.0, 299.0,
			166.0, 289.0,
			168.0, 286.0,
			171.0, 285.0,
			173.0, 282.0,
			176.0, 283.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_193_0;
			g.setTransform(defaultTransform__0_193_0);
			g.setClip(clip__0_193_0);
			origAlpha = alpha__0_193;
			g.setTransform(defaultTransform__0_193);
			g.setClip(clip__0_193);
			float alpha__0_194 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_194 = g.getClip();
			AffineTransform defaultTransform__0_194 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_194 is CompositeGraphicsNode
			float alpha__0_194_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_194_0 = g.getClip();
			AffineTransform defaultTransform__0_194_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_194_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(289.0, 290.0,
			294.0, 298.0,
			293.0, 304.0,
			295.0, 307.0,
			293.0, 311.0,
			289.0, 314.0,
			286.0, 310.0,
			284.0, 310.0,
			283.0, 301.0,
			281.0, 301.0,
			276.0, 294.0,
			279.0, 293.0,
			282.0, 287.0,
			286.0, 286.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(289.0, 290.0,
			294.0, 298.0,
			293.0, 304.0,
			295.0, 307.0,
			293.0, 311.0,
			289.0, 314.0,
			286.0, 310.0,
			284.0, 310.0,
			283.0, 301.0,
			281.0, 301.0,
			276.0, 294.0,
			279.0, 293.0,
			282.0, 287.0,
			286.0, 286.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_194_0;
			g.setTransform(defaultTransform__0_194_0);
			g.setClip(clip__0_194_0);
			origAlpha = alpha__0_194;
			g.setTransform(defaultTransform__0_194);
			g.setClip(clip__0_194);
			float alpha__0_195 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_195 = g.getClip();
			AffineTransform defaultTransform__0_195 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_195 is CompositeGraphicsNode
			float alpha__0_195_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_195_0 = g.getClip();
			AffineTransform defaultTransform__0_195_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_195_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(268.0, 291.0,
			266.0, 299.0,
			262.0, 302.0,
			253.0, 303.0,
			250.0, 307.0,
			246.0, 307.0,
			241.0, 297.0,
			241.0, 291.0,
			249.0, 291.0,
			255.0, 287.0,
			259.0, 287.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(268.0, 291.0,
			266.0, 299.0,
			262.0, 302.0,
			253.0, 303.0,
			250.0, 307.0,
			246.0, 307.0,
			241.0, 297.0,
			241.0, 291.0,
			249.0, 291.0,
			255.0, 287.0,
			259.0, 287.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_195_0;
			g.setTransform(defaultTransform__0_195_0);
			g.setClip(clip__0_195_0);
			origAlpha = alpha__0_195;
			g.setTransform(defaultTransform__0_195);
			g.setClip(clip__0_195);
			float alpha__0_196 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_196 = g.getClip();
			AffineTransform defaultTransform__0_196 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_196 is CompositeGraphicsNode
			float alpha__0_196_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_196_0 = g.getClip();
			AffineTransform defaultTransform__0_196_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_196_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(315.0, 290.0,
			316.0, 296.0,
			321.0, 296.0,
			324.0, 311.0,
			317.0, 317.0,
			315.0, 322.0,
			310.0, 326.0,
			303.0, 325.0,
			298.0, 318.0,
			293.0, 319.0,
			293.0, 317.0,
			297.0, 315.0,
			293.0, 311.0,
			295.0, 307.0,
			293.0, 304.0,
			294.0, 297.0,
			299.0, 297.0,
			302.0, 294.0,
			310.0, 294.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(315.0, 290.0,
			316.0, 296.0,
			321.0, 296.0,
			324.0, 311.0,
			317.0, 317.0,
			315.0, 322.0,
			310.0, 326.0,
			303.0, 325.0,
			298.0, 318.0,
			293.0, 319.0,
			293.0, 317.0,
			297.0, 315.0,
			293.0, 311.0,
			295.0, 307.0,
			293.0, 304.0,
			294.0, 297.0,
			299.0, 297.0,
			302.0, 294.0,
			310.0, 294.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_196_0;
			g.setTransform(defaultTransform__0_196_0);
			g.setClip(clip__0_196_0);
			origAlpha = alpha__0_196;
			g.setTransform(defaultTransform__0_196);
			g.setClip(clip__0_196);
			float alpha__0_197 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_197 = g.getClip();
			AffineTransform defaultTransform__0_197 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_197 is CompositeGraphicsNode
			float alpha__0_197_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_197_0 = g.getClip();
			AffineTransform defaultTransform__0_197_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_197_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(268.0, 293.0,
			276.0, 291.0,
			276.0, 295.0,
			282.0, 302.0,
			276.0, 311.0,
			278.0, 316.0,
			261.0, 332.0,
			262.0, 322.0,
			266.0, 318.0,
			273.0, 304.0,
			272.0, 300.0,
			268.0, 297.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(268.0, 293.0,
			276.0, 291.0,
			276.0, 295.0,
			282.0, 302.0,
			276.0, 311.0,
			278.0, 316.0,
			261.0, 332.0,
			262.0, 322.0,
			266.0, 318.0,
			273.0, 304.0,
			272.0, 300.0,
			268.0, 297.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_197_0;
			g.setTransform(defaultTransform__0_197_0);
			g.setClip(clip__0_197_0);
			origAlpha = alpha__0_197;
			g.setTransform(defaultTransform__0_197);
			g.setClip(clip__0_197);
			float alpha__0_198 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_198 = g.getClip();
			AffineTransform defaultTransform__0_198 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_198 is CompositeGraphicsNode
			float alpha__0_198_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_198_0 = g.getClip();
			AffineTransform defaultTransform__0_198_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_198_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(241.0, 291.0,
			241.0, 297.0,
			246.0, 307.0,
			251.0, 307.0,
			248.0, 318.0,
			249.0, 322.0,
			243.0, 327.0,
			242.0, 335.0,
			233.0, 336.0,
			229.0, 331.0,
			231.0, 326.0,
			225.0, 323.0,
			223.0, 318.0,
			225.0, 318.0,
			228.0, 313.0,
			220.0, 306.0,
			216.0, 306.0,
			216.0, 303.0,
			222.0, 296.0,
			232.0, 296.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(241.0, 291.0,
			241.0, 297.0,
			246.0, 307.0,
			251.0, 307.0,
			248.0, 318.0,
			249.0, 322.0,
			243.0, 327.0,
			242.0, 335.0,
			233.0, 336.0,
			229.0, 331.0,
			231.0, 326.0,
			225.0, 323.0,
			223.0, 318.0,
			225.0, 318.0,
			228.0, 313.0,
			220.0, 306.0,
			216.0, 306.0,
			216.0, 303.0,
			222.0, 296.0,
			232.0, 296.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_198_0;
			g.setTransform(defaultTransform__0_198_0);
			g.setClip(clip__0_198_0);
			origAlpha = alpha__0_198;
			g.setTransform(defaultTransform__0_198);
			g.setClip(clip__0_198);
			float alpha__0_199 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_199 = g.getClip();
			AffineTransform defaultTransform__0_199 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_199 is CompositeGraphicsNode
			float alpha__0_199_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_199_0 = g.getClip();
			AffineTransform defaultTransform__0_199_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_199_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(268.0, 297.0,
			272.0, 300.0,
			273.0, 304.0,
			265.0, 319.0,
			262.0, 317.0,
			264.0, 313.0,
			254.0, 311.0,
			250.0, 306.0,
			255.0, 303.0,
			263.0, 302.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(268.0, 297.0,
			272.0, 300.0,
			273.0, 304.0,
			265.0, 319.0,
			262.0, 317.0,
			264.0, 313.0,
			254.0, 311.0,
			250.0, 306.0,
			255.0, 303.0,
			263.0, 302.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_199_0;
			g.setTransform(defaultTransform__0_199_0);
			g.setClip(clip__0_199_0);
			origAlpha = alpha__0_199;
			g.setTransform(defaultTransform__0_199);
			g.setClip(clip__0_199);
			float alpha__0_200 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_200 = g.getClip();
			AffineTransform defaultTransform__0_200 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_200 is CompositeGraphicsNode
			float alpha__0_200_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_200_0 = g.getClip();
			AffineTransform defaultTransform__0_200_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_200_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(293.0, 311.0,
			297.0, 315.0,
			293.0, 317.0,
			293.0, 319.0,
			289.0, 321.0,
			286.0, 326.0,
			284.0, 325.0,
			282.0, 329.0,
			276.0, 332.0,
			270.0, 324.0,
			278.0, 316.0,
			276.0, 311.0,
			281.0, 302.0,
			283.0, 301.0,
			284.0, 310.0,
			286.0, 310.0,
			289.0, 314.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(293.0, 311.0,
			297.0, 315.0,
			293.0, 317.0,
			293.0, 319.0,
			289.0, 321.0,
			286.0, 326.0,
			284.0, 325.0,
			282.0, 329.0,
			276.0, 332.0,
			270.0, 324.0,
			278.0, 316.0,
			276.0, 311.0,
			281.0, 302.0,
			283.0, 301.0,
			284.0, 310.0,
			286.0, 310.0,
			289.0, 314.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_200_0;
			g.setTransform(defaultTransform__0_200_0);
			g.setClip(clip__0_200_0);
			origAlpha = alpha__0_200;
			g.setTransform(defaultTransform__0_200);
			g.setClip(clip__0_200);
			float alpha__0_201 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_201 = g.getClip();
			AffineTransform defaultTransform__0_201 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_201 is CompositeGraphicsNode
			float alpha__0_201_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_201_0 = g.getClip();
			AffineTransform defaultTransform__0_201_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_201_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(250.0, 306.0,
			254.0, 311.0,
			265.0, 314.0,
			262.0, 316.0,
			264.0, 318.0,
			262.0, 322.0,
			261.0, 333.0,
			247.0, 347.0,
			243.0, 342.0,
			244.0, 339.0,
			240.0, 337.0,
			243.0, 334.0,
			243.0, 327.0,
			249.0, 322.0,
			248.0, 318.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(250.0, 306.0,
			254.0, 311.0,
			265.0, 314.0,
			262.0, 316.0,
			264.0, 318.0,
			262.0, 322.0,
			261.0, 333.0,
			247.0, 347.0,
			243.0, 342.0,
			244.0, 339.0,
			240.0, 337.0,
			243.0, 334.0,
			243.0, 327.0,
			249.0, 322.0,
			248.0, 318.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_201_0;
			g.setTransform(defaultTransform__0_201_0);
			g.setClip(clip__0_201_0);
			origAlpha = alpha__0_201;
			g.setTransform(defaultTransform__0_201);
			g.setClip(clip__0_201);
			float alpha__0_202 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_202 = g.getClip();
			AffineTransform defaultTransform__0_202 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_202 is CompositeGraphicsNode
			float alpha__0_202_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_202_0 = g.getClip();
			AffineTransform defaultTransform__0_202_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_202_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(323.0, 312.0,
			327.0, 314.0,
			335.0, 311.0,
			338.0, 314.0,
			336.0, 317.0,
			327.0, 320.0,
			329.0, 324.0,
			332.0, 324.0,
			330.0, 330.0,
			331.0, 332.0,
			329.0, 337.0,
			325.0, 337.0,
			320.0, 342.0,
			317.0, 340.0,
			317.0, 337.0,
			311.0, 335.0,
			314.0, 334.0,
			310.0, 333.0,
			317.0, 317.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(323.0, 312.0,
			327.0, 314.0,
			335.0, 311.0,
			338.0, 314.0,
			336.0, 317.0,
			327.0, 320.0,
			329.0, 324.0,
			332.0, 324.0,
			330.0, 330.0,
			331.0, 332.0,
			329.0, 337.0,
			325.0, 337.0,
			320.0, 342.0,
			317.0, 340.0,
			317.0, 337.0,
			311.0, 335.0,
			314.0, 334.0,
			310.0, 333.0,
			317.0, 317.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_202_0;
			g.setTransform(defaultTransform__0_202_0);
			g.setClip(clip__0_202_0);
			origAlpha = alpha__0_202;
			g.setTransform(defaultTransform__0_202);
			g.setClip(clip__0_202);
			float alpha__0_203 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_203 = g.getClip();
			AffineTransform defaultTransform__0_203 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_203 is CompositeGraphicsNode
			float alpha__0_203_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_203_0 = g.getClip();
			AffineTransform defaultTransform__0_203_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_203_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(293.0, 319.0,
			299.0, 319.0,
			288.0, 332.0,
			283.0, 344.0,
			284.0, 339.0,
			279.0, 331.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(293.0, 319.0,
			299.0, 319.0,
			288.0, 332.0,
			283.0, 344.0,
			284.0, 339.0,
			279.0, 331.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_203_0;
			g.setTransform(defaultTransform__0_203_0);
			g.setClip(clip__0_203_0);
			origAlpha = alpha__0_203;
			g.setTransform(defaultTransform__0_203);
			g.setClip(clip__0_203);
			float alpha__0_204 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_204 = g.getClip();
			AffineTransform defaultTransform__0_204 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_204 is CompositeGraphicsNode
			float alpha__0_204_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_204_0 = g.getClip();
			AffineTransform defaultTransform__0_204_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_204_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(299.0, 319.0,
			303.0, 325.0,
			312.0, 326.0,
			310.0, 333.0,
			314.0, 334.0,
			311.0, 335.0,
			304.0, 330.0,
			300.0, 332.0,
			301.0, 335.0,
			298.0, 339.0,
			287.0, 339.0,
			287.0, 344.0,
			283.0, 345.0,
			288.0, 332.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(299.0, 319.0,
			303.0, 325.0,
			312.0, 326.0,
			310.0, 333.0,
			314.0, 334.0,
			311.0, 335.0,
			304.0, 330.0,
			300.0, 332.0,
			301.0, 335.0,
			298.0, 339.0,
			287.0, 339.0,
			287.0, 344.0,
			283.0, 345.0,
			288.0, 332.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_204_0;
			g.setTransform(defaultTransform__0_204_0);
			g.setClip(clip__0_204_0);
			origAlpha = alpha__0_204;
			g.setTransform(defaultTransform__0_204);
			g.setClip(clip__0_204);
			float alpha__0_205 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_205 = g.getClip();
			AffineTransform defaultTransform__0_205 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_205 is CompositeGraphicsNode
			float alpha__0_205_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_205_0 = g.getClip();
			AffineTransform defaultTransform__0_205_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_205_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(270.0, 324.0,
			276.0, 332.0,
			279.0, 331.0,
			284.0, 339.0,
			282.0, 345.0,
			278.0, 343.0,
			269.0, 343.0,
			269.0, 340.0,
			265.0, 334.0,
			261.0, 333.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(270.0, 324.0,
			276.0, 332.0,
			279.0, 331.0,
			284.0, 339.0,
			282.0, 345.0,
			278.0, 343.0,
			269.0, 343.0,
			269.0, 340.0,
			265.0, 334.0,
			261.0, 333.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_205_0;
			g.setTransform(defaultTransform__0_205_0);
			g.setClip(clip__0_205_0);
			origAlpha = alpha__0_205;
			g.setTransform(defaultTransform__0_205);
			g.setClip(clip__0_205);
			float alpha__0_206 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_206 = g.getClip();
			AffineTransform defaultTransform__0_206 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_206 is CompositeGraphicsNode
			float alpha__0_206_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_206_0 = g.getClip();
			AffineTransform defaultTransform__0_206_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_206_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(311.0, 335.0,
			309.0, 336.0,
			310.0, 341.0,
			304.0, 348.0,
			301.0, 355.0,
			303.0, 365.0,
			295.0, 360.0,
			292.0, 355.0,
			285.0, 354.0,
			282.0, 352.0,
			283.0, 345.0,
			287.0, 344.0,
			287.0, 339.0,
			298.0, 339.0,
			301.0, 335.0,
			299.0, 332.0,
			304.0, 330.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(311.0, 335.0,
			309.0, 336.0,
			310.0, 341.0,
			304.0, 348.0,
			301.0, 355.0,
			303.0, 365.0,
			295.0, 360.0,
			292.0, 355.0,
			285.0, 354.0,
			282.0, 352.0,
			283.0, 345.0,
			287.0, 344.0,
			287.0, 339.0,
			298.0, 339.0,
			301.0, 335.0,
			299.0, 332.0,
			304.0, 330.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_206_0;
			g.setTransform(defaultTransform__0_206_0);
			g.setClip(clip__0_206_0);
			origAlpha = alpha__0_206;
			g.setTransform(defaultTransform__0_206);
			g.setClip(clip__0_206);
			float alpha__0_207 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_207 = g.getClip();
			AffineTransform defaultTransform__0_207 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_207 is CompositeGraphicsNode
			float alpha__0_207_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_207_0 = g.getClip();
			AffineTransform defaultTransform__0_207_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_207_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(261.0, 333.0,
			265.0, 334.0,
			269.0, 340.0,
			269.0, 347.0,
			265.0, 349.0,
			264.0, 357.0,
			267.0, 359.0,
			265.0, 365.0,
			261.0, 364.0,
			260.0, 361.0,
			250.0, 354.0,
			250.0, 350.0,
			247.0, 347.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(261.0, 333.0,
			265.0, 334.0,
			269.0, 340.0,
			269.0, 347.0,
			265.0, 349.0,
			264.0, 357.0,
			267.0, 359.0,
			265.0, 365.0,
			261.0, 364.0,
			260.0, 361.0,
			250.0, 354.0,
			250.0, 350.0,
			247.0, 347.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_207_0;
			g.setTransform(defaultTransform__0_207_0);
			g.setClip(clip__0_207_0);
			origAlpha = alpha__0_207;
			g.setTransform(defaultTransform__0_207);
			g.setClip(clip__0_207);
			float alpha__0_208 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_208 = g.getClip();
			AffineTransform defaultTransform__0_208 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_208 is CompositeGraphicsNode
			float alpha__0_208_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_208_0 = g.getClip();
			AffineTransform defaultTransform__0_208_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_208_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(269.0, 343.0,
			282.0, 344.0,
			282.0, 351.0,
			284.0, 354.0,
			276.0, 355.0,
			271.0, 353.0,
			268.0, 358.0,
			268.0, 363.0,
			266.0, 364.0,
			267.0, 359.0,
			264.0, 357.0,
			265.0, 349.0,
			269.0, 347.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(269.0, 343.0,
			282.0, 344.0,
			282.0, 351.0,
			284.0, 354.0,
			276.0, 355.0,
			271.0, 353.0,
			268.0, 358.0,
			268.0, 363.0,
			266.0, 364.0,
			267.0, 359.0,
			264.0, 357.0,
			265.0, 349.0,
			269.0, 347.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_208_0;
			g.setTransform(defaultTransform__0_208_0);
			g.setClip(clip__0_208_0);
			origAlpha = alpha__0_208;
			g.setTransform(defaultTransform__0_208);
			g.setClip(clip__0_208);
			float alpha__0_209 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_209 = g.getClip();
			AffineTransform defaultTransform__0_209 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_209 is CompositeGraphicsNode
			float alpha__0_209_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_209_0 = g.getClip();
			AffineTransform defaultTransform__0_209_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_209_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(406.0, 254.0,
			412.0, 257.0,
			411.0, 259.0,
			413.0, 259.0,
			415.0, 262.0,
			412.0, 269.0,
			414.0, 271.0,
			409.0, 275.0,
			410.0, 277.0,
			405.0, 277.0,
			405.0, 279.0,
			403.0, 279.0,
			400.0, 283.0,
			398.0, 282.0,
			398.0, 286.0,
			395.0, 287.0,
			390.0, 284.0,
			389.0, 285.0,
			388.0, 280.0,
			391.0, 270.0,
			379.0, 266.0,
			381.0, 261.0,
			379.0, 259.0,
			381.0, 253.0,
			386.0, 258.0,
			388.0, 254.0,
			390.0, 258.0,
			393.0, 259.0,
			394.0, 255.0,
			398.0, 256.0,
			399.0, 253.0,
			403.0, 252.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(406.0, 254.0,
			412.0, 257.0,
			411.0, 259.0,
			413.0, 259.0,
			415.0, 262.0,
			412.0, 269.0,
			414.0, 271.0,
			409.0, 275.0,
			410.0, 277.0,
			405.0, 277.0,
			405.0, 279.0,
			403.0, 279.0,
			400.0, 283.0,
			398.0, 282.0,
			398.0, 286.0,
			395.0, 287.0,
			390.0, 284.0,
			389.0, 285.0,
			388.0, 280.0,
			391.0, 270.0,
			379.0, 266.0,
			381.0, 261.0,
			379.0, 259.0,
			381.0, 253.0,
			386.0, 258.0,
			388.0, 254.0,
			390.0, 258.0,
			393.0, 259.0,
			394.0, 255.0,
			398.0, 256.0,
			399.0, 253.0,
			403.0, 252.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_209_0;
			g.setTransform(defaultTransform__0_209_0);
			g.setClip(clip__0_209_0);
			origAlpha = alpha__0_209;
			g.setTransform(defaultTransform__0_209);
			g.setClip(clip__0_209);
			float alpha__0_210 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_210 = g.getClip();
			AffineTransform defaultTransform__0_210 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_210 is CompositeGraphicsNode
			float alpha__0_210_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_210_0 = g.getClip();
			AffineTransform defaultTransform__0_210_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_210_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(379.0, 259.0,
			381.0, 261.0,
			379.0, 266.0,
			383.0, 268.0,
			381.0, 270.0,
			381.0, 277.0,
			374.0, 278.0,
			370.0, 272.0,
			368.0, 273.0,
			367.0, 268.0,
			370.0, 260.0,
			374.0, 260.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(379.0, 259.0,
			381.0, 261.0,
			379.0, 266.0,
			383.0, 268.0,
			381.0, 270.0,
			381.0, 277.0,
			374.0, 278.0,
			370.0, 272.0,
			368.0, 273.0,
			367.0, 268.0,
			370.0, 260.0,
			374.0, 260.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_210_0;
			g.setTransform(defaultTransform__0_210_0);
			g.setClip(clip__0_210_0);
			origAlpha = alpha__0_210;
			g.setTransform(defaultTransform__0_210);
			g.setClip(clip__0_210);
			float alpha__0_211 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_211 = g.getClip();
			AffineTransform defaultTransform__0_211 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_211 is CompositeGraphicsNode
			float alpha__0_211_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_211_0 = g.getClip();
			AffineTransform defaultTransform__0_211_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_211_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(369.0, 265.0,
			367.0, 268.0,
			368.0, 273.0,
			370.0, 272.0,
			371.0, 275.0,
			373.0, 275.0,
			373.0, 278.0,
			366.0, 295.0,
			367.0, 299.0,
			365.0, 302.0,
			367.0, 306.0,
			362.0, 302.0,
			356.0, 303.0,
			355.0, 298.0,
			357.0, 294.0,
			353.0, 291.0,
			357.0, 286.0,
			360.0, 285.0,
			358.0, 275.0,
			362.0, 275.0,
			360.0, 273.0,
			366.0, 265.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(369.0, 265.0,
			367.0, 268.0,
			368.0, 273.0,
			370.0, 272.0,
			371.0, 275.0,
			373.0, 275.0,
			373.0, 278.0,
			366.0, 295.0,
			367.0, 299.0,
			365.0, 302.0,
			367.0, 306.0,
			362.0, 302.0,
			356.0, 303.0,
			355.0, 298.0,
			357.0, 294.0,
			353.0, 291.0,
			357.0, 286.0,
			360.0, 285.0,
			358.0, 275.0,
			362.0, 275.0,
			360.0, 273.0,
			366.0, 265.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_211_0;
			g.setTransform(defaultTransform__0_211_0);
			g.setClip(clip__0_211_0);
			origAlpha = alpha__0_211;
			g.setTransform(defaultTransform__0_211);
			g.setClip(clip__0_211);
			float alpha__0_212 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_212 = g.getClip();
			AffineTransform defaultTransform__0_212 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_212 is CompositeGraphicsNode
			float alpha__0_212_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_212_0 = g.getClip();
			AffineTransform defaultTransform__0_212_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_212_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(426.0, 269.0,
			428.0, 268.0,
			428.0, 271.0,
			431.0, 271.0,
			433.0, 269.0,
			437.0, 272.0,
			424.0, 294.0,
			418.0, 299.0,
			416.0, 303.0,
			410.0, 301.0,
			412.0, 293.0,
			417.0, 289.0,
			421.0, 277.0,
			425.0, 274.0,
			422.0, 273.0,
			424.0, 273.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(426.0, 269.0,
			428.0, 268.0,
			428.0, 271.0,
			431.0, 271.0,
			433.0, 269.0,
			437.0, 272.0,
			424.0, 294.0,
			418.0, 299.0,
			416.0, 303.0,
			410.0, 301.0,
			412.0, 293.0,
			417.0, 289.0,
			421.0, 277.0,
			425.0, 274.0,
			422.0, 273.0,
			424.0, 273.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_212_0;
			g.setTransform(defaultTransform__0_212_0);
			g.setClip(clip__0_212_0);
			origAlpha = alpha__0_212;
			g.setTransform(defaultTransform__0_212);
			g.setClip(clip__0_212);
			float alpha__0_213 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_213 = g.getClip();
			AffineTransform defaultTransform__0_213 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_213 is CompositeGraphicsNode
			float alpha__0_213_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_213_0 = g.getClip();
			AffineTransform defaultTransform__0_213_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_213_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(422.0, 273.0,
			425.0, 274.0,
			421.0, 277.0,
			419.0, 285.0,
			415.0, 291.0,
			411.0, 290.0,
			409.0, 283.0,
			402.0, 280.0,
			405.0, 279.0,
			405.0, 277.0,
			410.0, 277.0,
			409.0, 275.0,
			414.0, 270.0,
			417.0, 269.0,
			417.0, 271.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(422.0, 273.0,
			425.0, 274.0,
			421.0, 277.0,
			419.0, 285.0,
			415.0, 291.0,
			411.0, 290.0,
			409.0, 283.0,
			402.0, 280.0,
			405.0, 279.0,
			405.0, 277.0,
			410.0, 277.0,
			409.0, 275.0,
			414.0, 270.0,
			417.0, 269.0,
			417.0, 271.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_213_0;
			g.setTransform(defaultTransform__0_213_0);
			g.setClip(clip__0_213_0);
			origAlpha = alpha__0_213;
			g.setTransform(defaultTransform__0_213);
			g.setClip(clip__0_213);
			float alpha__0_214 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_214 = g.getClip();
			AffineTransform defaultTransform__0_214 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_214 is CompositeGraphicsNode
			float alpha__0_214_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_214_0 = g.getClip();
			AffineTransform defaultTransform__0_214_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_214_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(379.0, 277.0,
			382.0, 269.0,
			390.0, 269.0,
			388.0, 280.0,
			379.0, 279.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(379.0, 277.0,
			382.0, 269.0,
			390.0, 269.0,
			388.0, 280.0,
			379.0, 279.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_214_0;
			g.setTransform(defaultTransform__0_214_0);
			g.setClip(clip__0_214_0);
			origAlpha = alpha__0_214;
			g.setTransform(defaultTransform__0_214);
			g.setClip(clip__0_214);
			float alpha__0_215 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_215 = g.getClip();
			AffineTransform defaultTransform__0_215 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_215 is CompositeGraphicsNode
			float alpha__0_215_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_215_0 = g.getClip();
			AffineTransform defaultTransform__0_215_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_215_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(437.0, 272.0,
			450.0, 277.0,
			447.0, 284.0,
			453.0, 287.0,
			452.0, 294.0,
			447.0, 302.0,
			440.0, 304.0,
			435.0, 303.0,
			438.0, 306.0,
			433.0, 310.0,
			432.0, 315.0,
			425.0, 316.0,
			426.0, 307.0,
			419.0, 302.0,
			420.0, 298.0,
			424.0, 294.0,
			426.0, 289.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(437.0, 272.0,
			450.0, 277.0,
			447.0, 284.0,
			453.0, 287.0,
			452.0, 294.0,
			447.0, 302.0,
			440.0, 304.0,
			435.0, 303.0,
			438.0, 306.0,
			433.0, 310.0,
			432.0, 315.0,
			425.0, 316.0,
			426.0, 307.0,
			419.0, 302.0,
			420.0, 298.0,
			424.0, 294.0,
			426.0, 289.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_215_0;
			g.setTransform(defaultTransform__0_215_0);
			g.setClip(clip__0_215_0);
			origAlpha = alpha__0_215;
			g.setTransform(defaultTransform__0_215);
			g.setClip(clip__0_215);
			float alpha__0_216 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_216 = g.getClip();
			AffineTransform defaultTransform__0_216 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_216 is CompositeGraphicsNode
			float alpha__0_216_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_216_0 = g.getClip();
			AffineTransform defaultTransform__0_216_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_216_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(373.0, 277.0,
			388.0, 280.0,
			389.0, 285.0,
			390.0, 284.0,
			393.0, 287.0,
			397.0, 287.0,
			394.0, 289.0,
			395.0, 292.0,
			389.0, 294.0,
			390.0, 295.0,
			388.0, 298.0,
			392.0, 303.0,
			390.0, 309.0,
			385.0, 307.0,
			381.0, 296.0,
			377.0, 300.0,
			369.0, 296.0,
			366.0, 298.0,
			366.0, 293.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(373.0, 277.0,
			388.0, 280.0,
			389.0, 285.0,
			390.0, 284.0,
			393.0, 287.0,
			397.0, 287.0,
			394.0, 289.0,
			395.0, 292.0,
			389.0, 294.0,
			390.0, 295.0,
			388.0, 298.0,
			392.0, 303.0,
			390.0, 309.0,
			385.0, 307.0,
			381.0, 296.0,
			377.0, 300.0,
			369.0, 296.0,
			366.0, 298.0,
			366.0, 293.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_216_0;
			g.setTransform(defaultTransform__0_216_0);
			g.setClip(clip__0_216_0);
			origAlpha = alpha__0_216;
			g.setTransform(defaultTransform__0_216);
			g.setClip(clip__0_216);
			float alpha__0_217 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_217 = g.getClip();
			AffineTransform defaultTransform__0_217 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_217 is CompositeGraphicsNode
			float alpha__0_217_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_217_0 = g.getClip();
			AffineTransform defaultTransform__0_217_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_217_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(402.0, 280.0,
			409.0, 283.0,
			411.0, 290.0,
			414.0, 290.0,
			410.0, 301.0,
			412.0, 302.0,
			409.0, 307.0,
			410.0, 311.0,
			404.0, 316.0,
			401.0, 314.0,
			396.0, 315.0,
			395.0, 311.0,
			393.0, 312.0,
			392.0, 310.0,
			395.0, 307.0,
			391.0, 305.0,
			392.0, 303.0,
			388.0, 298.0,
			390.0, 295.0,
			389.0, 294.0,
			395.0, 292.0,
			394.0, 290.0,
			397.0, 288.0,
			396.0, 287.0,
			398.0, 285.0,
			398.0, 282.0,
			400.0, 283.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(402.0, 280.0,
			409.0, 283.0,
			411.0, 290.0,
			414.0, 290.0,
			410.0, 301.0,
			412.0, 302.0,
			409.0, 307.0,
			410.0, 311.0,
			404.0, 316.0,
			401.0, 314.0,
			396.0, 315.0,
			395.0, 311.0,
			393.0, 312.0,
			392.0, 310.0,
			395.0, 307.0,
			391.0, 305.0,
			392.0, 303.0,
			388.0, 298.0,
			390.0, 295.0,
			389.0, 294.0,
			395.0, 292.0,
			394.0, 290.0,
			397.0, 288.0,
			396.0, 287.0,
			398.0, 285.0,
			398.0, 282.0,
			400.0, 283.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_217_0;
			g.setTransform(defaultTransform__0_217_0);
			g.setClip(clip__0_217_0);
			origAlpha = alpha__0_217;
			g.setTransform(defaultTransform__0_217);
			g.setClip(clip__0_217);
			float alpha__0_218 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_218 = g.getClip();
			AffineTransform defaultTransform__0_218 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_218 is CompositeGraphicsNode
			float alpha__0_218_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_218_0 = g.getClip();
			AffineTransform defaultTransform__0_218_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_218_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(453.0, 287.0,
			455.0, 285.0,
			460.0, 287.0,
			458.0, 288.0,
			455.0, 294.0,
			458.0, 302.0,
			447.0, 307.0,
			444.0, 303.0,
			451.0, 298.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(453.0, 287.0,
			455.0, 285.0,
			460.0, 287.0,
			458.0, 288.0,
			455.0, 294.0,
			458.0, 302.0,
			447.0, 307.0,
			444.0, 303.0,
			451.0, 298.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_218_0;
			g.setTransform(defaultTransform__0_218_0);
			g.setClip(clip__0_218_0);
			origAlpha = alpha__0_218;
			g.setTransform(defaultTransform__0_218);
			g.setClip(clip__0_218);
			float alpha__0_219 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_219 = g.getClip();
			AffineTransform defaultTransform__0_219 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_219 is CompositeGraphicsNode
			float alpha__0_219_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_219_0 = g.getClip();
			AffineTransform defaultTransform__0_219_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_219_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(336.0, 285.0,
			344.0, 285.0,
			346.0, 289.0,
			341.0, 299.0,
			344.0, 310.0,
			338.0, 318.0,
			337.0, 313.0,
			335.0, 311.0,
			325.0, 314.0,
			323.0, 305.0,
			326.0, 303.0,
			332.0, 303.0,
			330.0, 299.0,
			338.0, 290.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(336.0, 285.0,
			344.0, 285.0,
			346.0, 289.0,
			341.0, 299.0,
			344.0, 310.0,
			338.0, 318.0,
			337.0, 313.0,
			335.0, 311.0,
			325.0, 314.0,
			323.0, 305.0,
			326.0, 303.0,
			332.0, 303.0,
			330.0, 299.0,
			338.0, 290.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_219_0;
			g.setTransform(defaultTransform__0_219_0);
			g.setClip(clip__0_219_0);
			origAlpha = alpha__0_219;
			g.setTransform(defaultTransform__0_219);
			g.setClip(clip__0_219);
			float alpha__0_220 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_220 = g.getClip();
			AffineTransform defaultTransform__0_220 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_220 is CompositeGraphicsNode
			float alpha__0_220_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_220_0 = g.getClip();
			AffineTransform defaultTransform__0_220_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_220_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(366.0, 298.0,
			369.0, 296.0,
			377.0, 300.0,
			381.0, 296.0,
			385.0, 307.0,
			388.0, 309.0,
			386.0, 312.0,
			379.0, 310.0,
			377.0, 314.0,
			381.0, 317.0,
			373.0, 322.0,
			369.0, 320.0,
			369.0, 314.0,
			367.0, 315.0,
			365.0, 311.0,
			359.0, 309.0,
			360.0, 305.0,
			367.0, 306.0,
			365.0, 302.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(366.0, 298.0,
			369.0, 296.0,
			377.0, 300.0,
			381.0, 296.0,
			385.0, 307.0,
			388.0, 309.0,
			386.0, 312.0,
			379.0, 310.0,
			377.0, 314.0,
			381.0, 317.0,
			373.0, 322.0,
			369.0, 320.0,
			369.0, 314.0,
			367.0, 315.0,
			365.0, 311.0,
			359.0, 309.0,
			360.0, 305.0,
			367.0, 306.0,
			365.0, 302.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_220_0;
			g.setTransform(defaultTransform__0_220_0);
			g.setClip(clip__0_220_0);
			origAlpha = alpha__0_220;
			g.setTransform(defaultTransform__0_220);
			g.setClip(clip__0_220);
			float alpha__0_221 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_221 = g.getClip();
			AffineTransform defaultTransform__0_221 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_221 is CompositeGraphicsNode
			float alpha__0_221_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_221_0 = g.getClip();
			AffineTransform defaultTransform__0_221_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_221_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(420.0, 298.0,
			419.0, 302.0,
			426.0, 307.0,
			424.0, 320.0,
			407.0, 340.0,
			403.0, 333.0,
			405.0, 328.0,
			403.0, 318.0,
			410.0, 311.0,
			409.0, 307.0,
			412.0, 302.0,
			416.0, 303.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(420.0, 298.0,
			419.0, 302.0,
			426.0, 307.0,
			424.0, 320.0,
			407.0, 340.0,
			403.0, 333.0,
			405.0, 328.0,
			403.0, 318.0,
			410.0, 311.0,
			409.0, 307.0,
			412.0, 302.0,
			416.0, 303.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_221_0;
			g.setTransform(defaultTransform__0_221_0);
			g.setClip(clip__0_221_0);
			origAlpha = alpha__0_221;
			g.setTransform(defaultTransform__0_221);
			g.setClip(clip__0_221);
			float alpha__0_222 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_222 = g.getClip();
			AffineTransform defaultTransform__0_222 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_222 is CompositeGraphicsNode
			float alpha__0_222_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_222_0 = g.getClip();
			AffineTransform defaultTransform__0_222_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_222_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(491.0, 311.0,
			486.0, 316.0,
			482.0, 315.0,
			482.0, 317.0,
			480.0, 317.0,
			481.0, 318.0,
			477.0, 321.0,
			472.0, 319.0,
			471.0, 316.0,
			478.0, 308.0,
			481.0, 301.0,
			482.0, 305.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(491.0, 311.0,
			486.0, 316.0,
			482.0, 315.0,
			482.0, 317.0,
			480.0, 317.0,
			481.0, 318.0,
			477.0, 321.0,
			472.0, 319.0,
			471.0, 316.0,
			478.0, 308.0,
			481.0, 301.0,
			482.0, 305.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_222_0;
			g.setTransform(defaultTransform__0_222_0);
			g.setClip(clip__0_222_0);
			origAlpha = alpha__0_222;
			g.setTransform(defaultTransform__0_222);
			g.setClip(clip__0_222);
			float alpha__0_223 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_223 = g.getClip();
			AffineTransform defaultTransform__0_223 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_223 is CompositeGraphicsNode
			float alpha__0_223_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_223_0 = g.getClip();
			AffineTransform defaultTransform__0_223_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_223_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(447.0, 307.0,
			445.0, 309.0,
			447.0, 311.0,
			444.0, 310.0,
			443.0, 313.0,
			444.0, 315.0,
			449.0, 315.0,
			453.0, 319.0,
			451.0, 321.0,
			444.0, 320.0,
			437.0, 323.0,
			435.0, 319.0,
			432.0, 319.0,
			431.0, 327.0,
			429.0, 325.0,
			427.0, 326.0,
			427.0, 334.0,
			429.0, 334.0,
			429.0, 332.0,
			432.0, 330.0,
			435.0, 330.0,
			432.0, 330.0,
			431.0, 334.0,
			435.0, 338.0,
			426.0, 336.0,
			423.0, 332.0,
			415.0, 331.0,
			423.0, 323.0,
			424.0, 316.0,
			432.0, 315.0,
			433.0, 310.0,
			438.0, 306.0,
			435.0, 304.0,
			444.0, 303.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(447.0, 307.0,
			445.0, 309.0,
			447.0, 311.0,
			444.0, 310.0,
			443.0, 313.0,
			444.0, 315.0,
			449.0, 315.0,
			453.0, 319.0,
			451.0, 321.0,
			444.0, 320.0,
			437.0, 323.0,
			435.0, 319.0,
			432.0, 319.0,
			431.0, 327.0,
			429.0, 325.0,
			427.0, 326.0,
			427.0, 334.0,
			429.0, 334.0,
			429.0, 332.0,
			432.0, 330.0,
			435.0, 330.0,
			432.0, 330.0,
			431.0, 334.0,
			435.0, 338.0,
			426.0, 336.0,
			423.0, 332.0,
			415.0, 331.0,
			423.0, 323.0,
			424.0, 316.0,
			432.0, 315.0,
			433.0, 310.0,
			438.0, 306.0,
			435.0, 304.0,
			444.0, 303.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_223_0;
			g.setTransform(defaultTransform__0_223_0);
			g.setClip(clip__0_223_0);
			origAlpha = alpha__0_223;
			g.setTransform(defaultTransform__0_223);
			g.setClip(clip__0_223);
			float alpha__0_224 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_224 = g.getClip();
			AffineTransform defaultTransform__0_224 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_224 is CompositeGraphicsNode
			float alpha__0_224_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_224_0 = g.getClip();
			AffineTransform defaultTransform__0_224_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_224_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(391.0, 305.0,
			395.0, 307.0,
			390.0, 315.0,
			387.0, 314.0,
			390.0, 325.0,
			386.0, 335.0,
			380.0, 335.0,
			375.0, 330.0,
			372.0, 331.0,
			370.0, 329.0,
			372.0, 322.0,
			381.0, 317.0,
			378.0, 316.0,
			378.0, 311.0,
			379.0, 310.0,
			386.0, 312.0,
			387.0, 309.0,
			390.0, 309.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(391.0, 305.0,
			395.0, 307.0,
			390.0, 315.0,
			387.0, 314.0,
			390.0, 325.0,
			386.0, 335.0,
			380.0, 335.0,
			375.0, 330.0,
			372.0, 331.0,
			370.0, 329.0,
			372.0, 322.0,
			381.0, 317.0,
			378.0, 316.0,
			378.0, 311.0,
			379.0, 310.0,
			386.0, 312.0,
			387.0, 309.0,
			390.0, 309.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_224_0;
			g.setTransform(defaultTransform__0_224_0);
			g.setClip(clip__0_224_0);
			origAlpha = alpha__0_224;
			g.setTransform(defaultTransform__0_224);
			g.setClip(clip__0_224);
			float alpha__0_225 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_225 = g.getClip();
			AffineTransform defaultTransform__0_225 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_225 is CompositeGraphicsNode
			float alpha__0_225_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_225_0 = g.getClip();
			AffineTransform defaultTransform__0_225_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_225_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(344.0, 307.0,
			348.0, 308.0,
			355.0, 315.0,
			359.0, 313.0,
			359.0, 309.0,
			365.0, 311.0,
			365.0, 317.0,
			358.0, 319.0,
			354.0, 334.0,
			345.0, 336.0,
			345.0, 332.0,
			352.0, 324.0,
			350.0, 321.0,
			343.0, 318.0,
			344.0, 313.0,
			342.0, 312.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(344.0, 307.0,
			348.0, 308.0,
			355.0, 315.0,
			359.0, 313.0,
			359.0, 309.0,
			365.0, 311.0,
			365.0, 317.0,
			358.0, 319.0,
			354.0, 334.0,
			345.0, 336.0,
			345.0, 332.0,
			352.0, 324.0,
			350.0, 321.0,
			343.0, 318.0,
			344.0, 313.0,
			342.0, 312.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_225_0;
			g.setTransform(defaultTransform__0_225_0);
			g.setClip(clip__0_225_0);
			origAlpha = alpha__0_225;
			g.setTransform(defaultTransform__0_225);
			g.setClip(clip__0_225);
			float alpha__0_226 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_226 = g.getClip();
			AffineTransform defaultTransform__0_226 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_226 is CompositeGraphicsNode
			float alpha__0_226_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_226_0 = g.getClip();
			AffineTransform defaultTransform__0_226_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_226_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(392.0, 310.0,
			396.0, 315.0,
			401.0, 314.0,
			404.0, 316.0,
			404.0, 330.0,
			398.0, 332.0,
			397.0, 334.0,
			389.0, 329.0,
			390.0, 320.0,
			387.0, 314.0,
			390.0, 315.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(392.0, 310.0,
			396.0, 315.0,
			401.0, 314.0,
			404.0, 316.0,
			404.0, 330.0,
			398.0, 332.0,
			397.0, 334.0,
			389.0, 329.0,
			390.0, 320.0,
			387.0, 314.0,
			390.0, 315.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_226_0;
			g.setTransform(defaultTransform__0_226_0);
			g.setClip(clip__0_226_0);
			origAlpha = alpha__0_226;
			g.setTransform(defaultTransform__0_226);
			g.setClip(clip__0_226);
			float alpha__0_227 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_227 = g.getClip();
			AffineTransform defaultTransform__0_227 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_227 is CompositeGraphicsNode
			float alpha__0_227_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_227_0 = g.getClip();
			AffineTransform defaultTransform__0_227_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_227_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(471.0, 315.0,
			472.0, 319.0,
			476.0, 321.0,
			476.0, 324.0,
			473.0, 324.0,
			471.0, 329.0,
			463.0, 330.0,
			462.0, 332.0,
			458.0, 329.0,
			452.0, 328.0,
			453.0, 324.0,
			458.0, 323.0,
			459.0, 314.0,
			464.0, 316.0,
			462.0, 320.0,
			465.0, 321.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(471.0, 315.0,
			472.0, 319.0,
			476.0, 321.0,
			476.0, 324.0,
			473.0, 324.0,
			471.0, 329.0,
			463.0, 330.0,
			462.0, 332.0,
			458.0, 329.0,
			452.0, 328.0,
			453.0, 324.0,
			458.0, 323.0,
			459.0, 314.0,
			464.0, 316.0,
			462.0, 320.0,
			465.0, 321.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_227_0;
			g.setTransform(defaultTransform__0_227_0);
			g.setClip(clip__0_227_0);
			origAlpha = alpha__0_227;
			g.setTransform(defaultTransform__0_227);
			g.setClip(clip__0_227);
			float alpha__0_228 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_228 = g.getClip();
			AffineTransform defaultTransform__0_228 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_228 is CompositeGraphicsNode
			float alpha__0_228_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_228_0 = g.getClip();
			AffineTransform defaultTransform__0_228_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_228_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(342.0, 312.0,
			344.0, 313.0,
			343.0, 318.0,
			350.0, 321.0,
			352.0, 324.0,
			346.0, 331.0,
			338.0, 331.0,
			338.0, 329.0,
			336.0, 329.0,
			334.0, 325.0,
			330.0, 330.0,
			330.0, 325.0,
			332.0, 324.0,
			329.0, 324.0,
			327.0, 320.0,
			337.0, 316.0,
			338.0, 318.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(342.0, 312.0,
			344.0, 313.0,
			343.0, 318.0,
			350.0, 321.0,
			352.0, 324.0,
			346.0, 331.0,
			338.0, 331.0,
			338.0, 329.0,
			336.0, 329.0,
			334.0, 325.0,
			330.0, 330.0,
			330.0, 325.0,
			332.0, 324.0,
			329.0, 324.0,
			327.0, 320.0,
			337.0, 316.0,
			338.0, 318.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_228_0;
			g.setTransform(defaultTransform__0_228_0);
			g.setClip(clip__0_228_0);
			origAlpha = alpha__0_228;
			g.setTransform(defaultTransform__0_228);
			g.setClip(clip__0_228);
			float alpha__0_229 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_229 = g.getClip();
			AffineTransform defaultTransform__0_229 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_229 is CompositeGraphicsNode
			float alpha__0_229_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_229_0 = g.getClip();
			AffineTransform defaultTransform__0_229_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_229_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(372.0, 322.0,
			370.0, 329.0,
			372.0, 331.0,
			370.0, 331.0,
			370.0, 334.0,
			366.0, 335.0,
			366.0, 341.0,
			362.0, 343.0,
			352.0, 340.0,
			348.0, 340.0,
			346.0, 343.0,
			341.0, 341.0,
			344.0, 336.0,
			354.0, 334.0,
			357.0, 321.0,
			359.0, 318.0,
			369.0, 314.0,
			369.0, 320.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(372.0, 322.0,
			370.0, 329.0,
			372.0, 331.0,
			370.0, 331.0,
			370.0, 334.0,
			366.0, 335.0,
			366.0, 341.0,
			362.0, 343.0,
			352.0, 340.0,
			348.0, 340.0,
			346.0, 343.0,
			341.0, 341.0,
			344.0, 336.0,
			354.0, 334.0,
			357.0, 321.0,
			359.0, 318.0,
			369.0, 314.0,
			369.0, 320.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_229_0;
			g.setTransform(defaultTransform__0_229_0);
			g.setClip(clip__0_229_0);
			origAlpha = alpha__0_229;
			g.setTransform(defaultTransform__0_229);
			g.setClip(clip__0_229);
			float alpha__0_230 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_230 = g.getClip();
			AffineTransform defaultTransform__0_230 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_230 is CompositeGraphicsNode
			float alpha__0_230_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_230_0 = g.getClip();
			AffineTransform defaultTransform__0_230_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_230_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(453.0, 319.0,
			455.0, 317.0,
			458.0, 323.0,
			453.0, 324.0,
			451.0, 330.0,
			446.0, 333.0,
			438.0, 323.0,
			444.0, 320.0,
			451.0, 321.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(453.0, 319.0,
			455.0, 317.0,
			458.0, 323.0,
			453.0, 324.0,
			451.0, 330.0,
			446.0, 333.0,
			438.0, 323.0,
			444.0, 320.0,
			451.0, 321.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_230_0;
			g.setTransform(defaultTransform__0_230_0);
			g.setClip(clip__0_230_0);
			origAlpha = alpha__0_230;
			g.setTransform(defaultTransform__0_230);
			g.setClip(clip__0_230);
			float alpha__0_231 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_231 = g.getClip();
			AffineTransform defaultTransform__0_231 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_231 is CompositeGraphicsNode
			float alpha__0_231_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_231_0 = g.getClip();
			AffineTransform defaultTransform__0_231_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_231_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(438.0, 323.0,
			446.0, 332.0,
			440.0, 339.0,
			435.0, 339.0,
			431.0, 334.0,
			432.0, 330.0,
			435.0, 330.0,
			430.0, 331.0,
			429.0, 334.0,
			427.0, 334.0,
			427.0, 326.0,
			429.0, 325.0,
			431.0, 327.0,
			432.0, 319.0,
			435.0, 319.0,
			434.0, 321.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(438.0, 323.0,
			446.0, 332.0,
			440.0, 339.0,
			435.0, 339.0,
			431.0, 334.0,
			432.0, 330.0,
			435.0, 330.0,
			430.0, 331.0,
			429.0, 334.0,
			427.0, 334.0,
			427.0, 326.0,
			429.0, 325.0,
			431.0, 327.0,
			432.0, 319.0,
			435.0, 319.0,
			434.0, 321.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_231_0;
			g.setTransform(defaultTransform__0_231_0);
			g.setClip(clip__0_231_0);
			origAlpha = alpha__0_231;
			g.setTransform(defaultTransform__0_231);
			g.setClip(clip__0_231);
			float alpha__0_232 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_232 = g.getClip();
			AffineTransform defaultTransform__0_232 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_232 is CompositeGraphicsNode
			float alpha__0_232_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_232_0 = g.getClip();
			AffineTransform defaultTransform__0_232_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_232_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(452.0, 328.0,
			458.0, 329.0,
			462.0, 332.0,
			460.0, 335.0,
			463.0, 337.0,
			462.0, 339.0,
			458.0, 342.0,
			449.0, 354.0,
			441.0, 353.0,
			439.0, 351.0,
			436.0, 355.0,
			432.0, 354.0,
			434.0, 346.0,
			439.0, 347.0,
			437.0, 338.0,
			440.0, 339.0,
			443.0, 334.0,
			450.0, 332.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(452.0, 328.0,
			458.0, 329.0,
			462.0, 332.0,
			460.0, 335.0,
			463.0, 337.0,
			462.0, 339.0,
			458.0, 342.0,
			449.0, 354.0,
			441.0, 353.0,
			439.0, 351.0,
			436.0, 355.0,
			432.0, 354.0,
			434.0, 346.0,
			439.0, 347.0,
			437.0, 338.0,
			440.0, 339.0,
			443.0, 334.0,
			450.0, 332.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_232_0;
			g.setTransform(defaultTransform__0_232_0);
			g.setClip(clip__0_232_0);
			origAlpha = alpha__0_232;
			g.setTransform(defaultTransform__0_232);
			g.setClip(clip__0_232);
			float alpha__0_233 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_233 = g.getClip();
			AffineTransform defaultTransform__0_233 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_233 is CompositeGraphicsNode
			float alpha__0_233_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_233_0 = g.getClip();
			AffineTransform defaultTransform__0_233_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_233_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(346.0, 331.0,
			341.0, 342.0,
			333.0, 349.0,
			329.0, 347.0,
			325.0, 349.0,
			320.0, 342.0,
			325.0, 337.0,
			329.0, 337.0,
			334.0, 325.0,
			336.0, 329.0,
			338.0, 329.0,
			338.0, 331.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(346.0, 331.0,
			341.0, 342.0,
			333.0, 349.0,
			329.0, 347.0,
			325.0, 349.0,
			320.0, 342.0,
			325.0, 337.0,
			329.0, 337.0,
			334.0, 325.0,
			336.0, 329.0,
			338.0, 329.0,
			338.0, 331.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_233_0;
			g.setTransform(defaultTransform__0_233_0);
			g.setClip(clip__0_233_0);
			origAlpha = alpha__0_233;
			g.setTransform(defaultTransform__0_233);
			g.setClip(clip__0_233);
			float alpha__0_234 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_234 = g.getClip();
			AffineTransform defaultTransform__0_234 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_234 is CompositeGraphicsNode
			float alpha__0_234_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_234_0 = g.getClip();
			AffineTransform defaultTransform__0_234_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_234_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(403.0, 331.0,
			407.0, 342.0,
			399.0, 342.0,
			395.0, 348.0,
			390.0, 350.0,
			392.0, 348.0,
			388.0, 346.0,
			386.0, 333.0,
			389.0, 329.0,
			397.0, 334.0,
			398.0, 332.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(403.0, 331.0,
			407.0, 342.0,
			399.0, 342.0,
			395.0, 348.0,
			390.0, 350.0,
			392.0, 348.0,
			388.0, 346.0,
			386.0, 333.0,
			389.0, 329.0,
			397.0, 334.0,
			398.0, 332.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_234_0;
			g.setTransform(defaultTransform__0_234_0);
			g.setClip(clip__0_234_0);
			origAlpha = alpha__0_234;
			g.setTransform(defaultTransform__0_234);
			g.setClip(clip__0_234);
			float alpha__0_235 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_235 = g.getClip();
			AffineTransform defaultTransform__0_235 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_235 is CompositeGraphicsNode
			float alpha__0_235_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_235_0 = g.getClip();
			AffineTransform defaultTransform__0_235_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_235_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(413.0, 333.0,
			415.0, 331.0,
			423.0, 332.0,
			426.0, 336.0,
			437.0, 339.0,
			439.0, 347.0,
			434.0, 346.0,
			432.0, 354.0,
			428.0, 353.0,
			425.0, 347.0,
			422.0, 347.0,
			422.0, 345.0,
			420.0, 346.0,
			418.0, 343.0,
			419.0, 338.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(413.0, 333.0,
			415.0, 331.0,
			423.0, 332.0,
			426.0, 336.0,
			437.0, 339.0,
			439.0, 347.0,
			434.0, 346.0,
			432.0, 354.0,
			428.0, 353.0,
			425.0, 347.0,
			422.0, 347.0,
			422.0, 345.0,
			420.0, 346.0,
			418.0, 343.0,
			419.0, 338.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_235_0;
			g.setTransform(defaultTransform__0_235_0);
			g.setClip(clip__0_235_0);
			origAlpha = alpha__0_235;
			g.setTransform(defaultTransform__0_235);
			g.setClip(clip__0_235);
			float alpha__0_236 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_236 = g.getClip();
			AffineTransform defaultTransform__0_236 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_236 is CompositeGraphicsNode
			float alpha__0_236_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_236_0 = g.getClip();
			AffineTransform defaultTransform__0_236_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_236_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(372.0, 331.0,
			375.0, 330.0,
			380.0, 335.0,
			383.0, 336.0,
			384.0, 334.0,
			387.0, 336.0,
			388.0, 346.0,
			392.0, 348.0,
			391.0, 352.0,
			388.0, 355.0,
			380.0, 354.0,
			372.0, 356.0,
			374.0, 349.0,
			370.0, 337.0,
			370.0, 331.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(372.0, 331.0,
			375.0, 330.0,
			380.0, 335.0,
			383.0, 336.0,
			384.0, 334.0,
			387.0, 336.0,
			388.0, 346.0,
			392.0, 348.0,
			391.0, 352.0,
			388.0, 355.0,
			380.0, 354.0,
			372.0, 356.0,
			374.0, 349.0,
			370.0, 337.0,
			370.0, 331.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_236_0;
			g.setTransform(defaultTransform__0_236_0);
			g.setClip(clip__0_236_0);
			origAlpha = alpha__0_236;
			g.setTransform(defaultTransform__0_236);
			g.setClip(clip__0_236);
			float alpha__0_237 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_237 = g.getClip();
			AffineTransform defaultTransform__0_237 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_237 is CompositeGraphicsNode
			float alpha__0_237_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_237_0 = g.getClip();
			AffineTransform defaultTransform__0_237_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_237_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(370.0, 334.0,
			374.0, 349.0,
			372.0, 357.0,
			384.0, 365.0,
			385.0, 367.0,
			382.0, 369.0,
			374.0, 369.0,
			366.0, 365.0,
			360.0, 366.0,
			362.0, 356.0,
			368.0, 353.0,
			369.0, 351.0,
			362.0, 343.0,
			366.0, 341.0,
			366.0, 335.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(370.0, 334.0,
			374.0, 349.0,
			372.0, 357.0,
			384.0, 365.0,
			385.0, 367.0,
			382.0, 369.0,
			374.0, 369.0,
			366.0, 365.0,
			360.0, 366.0,
			362.0, 356.0,
			368.0, 353.0,
			369.0, 351.0,
			362.0, 343.0,
			366.0, 341.0,
			366.0, 335.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_237_0;
			g.setTransform(defaultTransform__0_237_0);
			g.setClip(clip__0_237_0);
			origAlpha = alpha__0_237;
			g.setTransform(defaultTransform__0_237);
			g.setClip(clip__0_237);
			float alpha__0_238 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_238 = g.getClip();
			AffineTransform defaultTransform__0_238 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_238 is CompositeGraphicsNode
			float alpha__0_238_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_238_0 = g.getClip();
			AffineTransform defaultTransform__0_238_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_238_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(320.0, 342.0,
			325.0, 349.0,
			319.0, 352.0,
			318.0, 362.0,
			315.0, 367.0,
			309.0, 369.0,
			306.0, 364.0,
			303.0, 365.0,
			301.0, 359.0,
			304.0, 348.0,
			310.0, 341.0,
			309.0, 336.0,
			311.0, 335.0,
			317.0, 337.0,
			317.0, 340.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(320.0, 342.0,
			325.0, 349.0,
			319.0, 352.0,
			318.0, 362.0,
			315.0, 367.0,
			309.0, 369.0,
			306.0, 364.0,
			303.0, 365.0,
			301.0, 359.0,
			304.0, 348.0,
			310.0, 341.0,
			309.0, 336.0,
			311.0, 335.0,
			317.0, 337.0,
			317.0, 340.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_238_0;
			g.setTransform(defaultTransform__0_238_0);
			g.setClip(clip__0_238_0);
			origAlpha = alpha__0_238;
			g.setTransform(defaultTransform__0_238);
			g.setClip(clip__0_238);
			float alpha__0_239 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_239 = g.getClip();
			AffineTransform defaultTransform__0_239 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_239 is CompositeGraphicsNode
			float alpha__0_239_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_239_0 = g.getClip();
			AffineTransform defaultTransform__0_239_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_239_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(362.0, 343.0,
			369.0, 351.0,
			368.0, 353.0,
			362.0, 356.0,
			360.0, 367.0,
			353.0, 371.0,
			343.0, 370.0,
			344.0, 356.0,
			348.0, 356.0,
			349.0, 354.0,
			346.0, 344.0,
			348.0, 340.0,
			360.0, 341.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(362.0, 343.0,
			369.0, 351.0,
			368.0, 353.0,
			362.0, 356.0,
			360.0, 367.0,
			353.0, 371.0,
			343.0, 370.0,
			344.0, 356.0,
			348.0, 356.0,
			349.0, 354.0,
			346.0, 344.0,
			348.0, 340.0,
			360.0, 341.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_239_0;
			g.setTransform(defaultTransform__0_239_0);
			g.setClip(clip__0_239_0);
			origAlpha = alpha__0_239;
			g.setTransform(defaultTransform__0_239);
			g.setClip(clip__0_239);
			float alpha__0_240 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_240 = g.getClip();
			AffineTransform defaultTransform__0_240 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_240 is CompositeGraphicsNode
			float alpha__0_240_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_240_0 = g.getClip();
			AffineTransform defaultTransform__0_240_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_240_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(341.0, 341.0,
			346.0, 343.0,
			349.0, 354.0,
			348.0, 356.0,
			344.0, 356.0,
			343.0, 370.0,
			337.0, 366.0,
			339.0, 359.0,
			334.0, 356.0,
			332.0, 352.0,
			333.0, 349.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(341.0, 341.0,
			346.0, 343.0,
			349.0, 354.0,
			348.0, 356.0,
			344.0, 356.0,
			343.0, 370.0,
			337.0, 366.0,
			339.0, 359.0,
			334.0, 356.0,
			332.0, 352.0,
			333.0, 349.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_240_0;
			g.setTransform(defaultTransform__0_240_0);
			g.setClip(clip__0_240_0);
			origAlpha = alpha__0_240;
			g.setTransform(defaultTransform__0_240);
			g.setClip(clip__0_240);
			float alpha__0_241 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_241 = g.getClip();
			AffineTransform defaultTransform__0_241 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_241 is CompositeGraphicsNode
			float alpha__0_241_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_241_0 = g.getClip();
			AffineTransform defaultTransform__0_241_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_241_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(329.0, 347.0,
			333.0, 349.0,
			333.0, 355.0,
			338.0, 358.0,
			333.0, 363.0,
			329.0, 371.0,
			322.0, 378.0,
			319.0, 378.0,
			319.0, 372.0,
			313.0, 369.0,
			318.0, 362.0,
			319.0, 352.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(329.0, 347.0,
			333.0, 349.0,
			333.0, 355.0,
			338.0, 358.0,
			333.0, 363.0,
			329.0, 371.0,
			322.0, 378.0,
			319.0, 378.0,
			319.0, 372.0,
			313.0, 369.0,
			318.0, 362.0,
			319.0, 352.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_241_0;
			g.setTransform(defaultTransform__0_241_0);
			g.setClip(clip__0_241_0);
			origAlpha = alpha__0_241;
			g.setTransform(defaultTransform__0_241);
			g.setClip(clip__0_241);
			float alpha__0_242 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_242 = g.getClip();
			AffineTransform defaultTransform__0_242 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_242 is CompositeGraphicsNode
			float alpha__0_242_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_242_0 = g.getClip();
			AffineTransform defaultTransform__0_242_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_242_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(370.0, 254.0,
			369.0, 265.0,
			366.0, 265.0,
			362.0, 270.0,
			360.0, 273.0,
			362.0, 275.0,
			358.0, 275.0,
			360.0, 285.0,
			357.0, 286.0,
			353.0, 291.0,
			357.0, 294.0,
			355.0, 298.0,
			356.0, 303.0,
			362.0, 302.0,
			364.0, 304.0,
			361.0, 306.0,
			359.0, 313.0,
			355.0, 315.0,
			348.0, 308.0,
			342.0, 305.0,
			341.0, 299.0,
			346.0, 288.0,
			342.0, 285.0,
			336.0, 285.0,
			335.0, 282.0,
			346.0, 274.0,
			349.0, 267.0,
			347.0, 258.0,
			349.0, 261.0,
			351.0, 259.0,
			356.0, 261.0,
			356.0, 255.0,
			361.0, 250.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(370.0, 254.0,
			369.0, 265.0,
			366.0, 265.0,
			362.0, 270.0,
			360.0, 273.0,
			362.0, 275.0,
			358.0, 275.0,
			360.0, 285.0,
			357.0, 286.0,
			353.0, 291.0,
			357.0, 294.0,
			355.0, 298.0,
			356.0, 303.0,
			362.0, 302.0,
			364.0, 304.0,
			361.0, 306.0,
			359.0, 313.0,
			355.0, 315.0,
			348.0, 308.0,
			342.0, 305.0,
			341.0, 299.0,
			346.0, 288.0,
			342.0, 285.0,
			336.0, 285.0,
			335.0, 282.0,
			346.0, 274.0,
			349.0, 267.0,
			347.0, 258.0,
			349.0, 261.0,
			351.0, 259.0,
			356.0, 261.0,
			356.0, 255.0,
			361.0, 250.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_242_0;
			g.setTransform(defaultTransform__0_242_0);
			g.setClip(clip__0_242_0);
			origAlpha = alpha__0_242;
			g.setTransform(defaultTransform__0_242);
			g.setClip(clip__0_242);
			float alpha__0_243 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_243 = g.getClip();
			AffineTransform defaultTransform__0_243 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_243 is CompositeGraphicsNode
			float alpha__0_243_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_243_0 = g.getClip();
			AffineTransform defaultTransform__0_243_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_243_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(568.0, 234.0,
			571.0, 245.0,
			570.0, 267.0,
			576.0, 267.0,
			570.0, 268.0,
			572.0, 269.0,
			570.0, 270.0,
			576.0, 268.0,
			571.0, 270.0,
			571.0, 274.0,
			577.0, 291.0,
			578.0, 303.0,
			582.0, 317.0,
			575.0, 319.0,
			574.0, 316.0,
			569.0, 318.0,
			566.0, 329.0,
			562.0, 332.0,
			562.0, 335.0,
			560.0, 336.0,
			561.0, 339.0,
			558.0, 340.0,
			555.0, 336.0,
			557.0, 329.0,
			553.0, 329.0,
			550.0, 332.0,
			538.0, 325.0,
			538.0, 321.0,
			536.0, 319.0,
			529.0, 316.0,
			528.0, 311.0,
			525.0, 310.0,
			538.0, 302.0,
			532.0, 300.0,
			536.0, 300.0,
			538.0, 295.0,
			524.0, 289.0,
			526.0, 283.0,
			533.0, 275.0,
			531.0, 269.0,
			538.0, 256.0,
			547.0, 254.0,
			562.0, 236.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(568.0, 234.0,
			571.0, 245.0,
			570.0, 267.0,
			576.0, 267.0,
			570.0, 268.0,
			572.0, 269.0,
			570.0, 270.0,
			576.0, 268.0,
			571.0, 270.0,
			571.0, 274.0,
			577.0, 291.0,
			578.0, 303.0,
			582.0, 317.0,
			575.0, 319.0,
			574.0, 316.0,
			569.0, 318.0,
			566.0, 329.0,
			562.0, 332.0,
			562.0, 335.0,
			560.0, 336.0,
			561.0, 339.0,
			558.0, 340.0,
			555.0, 336.0,
			557.0, 329.0,
			553.0, 329.0,
			550.0, 332.0,
			538.0, 325.0,
			538.0, 321.0,
			536.0, 319.0,
			529.0, 316.0,
			528.0, 311.0,
			525.0, 310.0,
			538.0, 302.0,
			532.0, 300.0,
			536.0, 300.0,
			538.0, 295.0,
			524.0, 289.0,
			526.0, 283.0,
			533.0, 275.0,
			531.0, 269.0,
			538.0, 256.0,
			547.0, 254.0,
			562.0, 236.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_243_0;
			g.setTransform(defaultTransform__0_243_0);
			g.setClip(clip__0_243_0);
			origAlpha = alpha__0_243;
			g.setTransform(defaultTransform__0_243);
			g.setClip(clip__0_243);
			float alpha__0_244 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_244 = g.getClip();
			AffineTransform defaultTransform__0_244 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_244 is CompositeGraphicsNode
			float alpha__0_244_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_244_0 = g.getClip();
			AffineTransform defaultTransform__0_244_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_244_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(531.0, 269.0,
			533.0, 275.0,
			532.0, 277.0,
			526.0, 283.0,
			523.0, 292.0,
			519.0, 297.0,
			515.0, 298.0,
			514.0, 294.0,
			509.0, 292.0,
			508.0, 288.0,
			511.0, 280.0,
			509.0, 280.0,
			520.0, 272.0,
			529.0, 268.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(531.0, 269.0,
			533.0, 275.0,
			532.0, 277.0,
			526.0, 283.0,
			523.0, 292.0,
			519.0, 297.0,
			515.0, 298.0,
			514.0, 294.0,
			509.0, 292.0,
			508.0, 288.0,
			511.0, 280.0,
			509.0, 280.0,
			520.0, 272.0,
			529.0, 268.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_244_0;
			g.setTransform(defaultTransform__0_244_0);
			g.setClip(clip__0_244_0);
			origAlpha = alpha__0_244;
			g.setTransform(defaultTransform__0_244);
			g.setClip(clip__0_244);
			float alpha__0_245 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_245 = g.getClip();
			AffineTransform defaultTransform__0_245 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_245 is CompositeGraphicsNode
			float alpha__0_245_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_245_0 = g.getClip();
			AffineTransform defaultTransform__0_245_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_245_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(516.0, 298.0,
			519.0, 297.0,
			524.0, 289.0,
			538.0, 295.0,
			536.0, 300.0,
			532.0, 300.0,
			538.0, 302.0,
			524.0, 311.0,
			522.0, 307.0,
			524.0, 304.0,
			521.0, 304.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(516.0, 298.0,
			519.0, 297.0,
			524.0, 289.0,
			538.0, 295.0,
			536.0, 300.0,
			532.0, 300.0,
			538.0, 302.0,
			524.0, 311.0,
			522.0, 307.0,
			524.0, 304.0,
			521.0, 304.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_245_0;
			g.setTransform(defaultTransform__0_245_0);
			g.setClip(clip__0_245_0);
			origAlpha = alpha__0_245;
			g.setTransform(defaultTransform__0_245);
			g.setClip(clip__0_245);
			float alpha__0_246 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_246 = g.getClip();
			AffineTransform defaultTransform__0_246 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_246 is CompositeGraphicsNode
			float alpha__0_246_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_246_0 = g.getClip();
			AffineTransform defaultTransform__0_246_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_246_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(516.0, 298.0,
			521.0, 304.0,
			524.0, 304.0,
			522.0, 307.0,
			524.0, 312.0,
			514.0, 329.0,
			509.0, 334.0,
			505.0, 333.0,
			506.0, 339.0,
			501.0, 340.0,
			500.0, 334.0,
			496.0, 338.0,
			484.0, 330.0,
			483.0, 326.0,
			481.0, 326.0,
			480.0, 324.0,
			475.0, 324.0,
			482.0, 317.0,
			482.0, 315.0,
			486.0, 316.0,
			490.0, 311.0,
			493.0, 310.0,
			495.0, 304.0,
			501.0, 307.0,
			505.0, 299.0,
			508.0, 298.0,
			512.0, 300.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(516.0, 298.0,
			521.0, 304.0,
			524.0, 304.0,
			522.0, 307.0,
			524.0, 312.0,
			514.0, 329.0,
			509.0, 334.0,
			505.0, 333.0,
			506.0, 339.0,
			501.0, 340.0,
			500.0, 334.0,
			496.0, 338.0,
			484.0, 330.0,
			483.0, 326.0,
			481.0, 326.0,
			480.0, 324.0,
			475.0, 324.0,
			482.0, 317.0,
			482.0, 315.0,
			486.0, 316.0,
			490.0, 311.0,
			493.0, 310.0,
			495.0, 304.0,
			501.0, 307.0,
			505.0, 299.0,
			508.0, 298.0,
			512.0, 300.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_246_0;
			g.setTransform(defaultTransform__0_246_0);
			g.setClip(clip__0_246_0);
			origAlpha = alpha__0_246;
			g.setTransform(defaultTransform__0_246);
			g.setClip(clip__0_246);
			float alpha__0_247 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_247 = g.getClip();
			AffineTransform defaultTransform__0_247 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_247 is CompositeGraphicsNode
			float alpha__0_247_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_247_0 = g.getClip();
			AffineTransform defaultTransform__0_247_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_247_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(525.0, 310.0,
			528.0, 311.0,
			529.0, 316.0,
			535.0, 318.0,
			538.0, 321.0,
			538.0, 325.0,
			551.0, 332.0,
			553.0, 329.0,
			557.0, 329.0,
			557.0, 334.0,
			550.0, 339.0,
			543.0, 339.0,
			541.0, 342.0,
			539.0, 341.0,
			535.0, 349.0,
			535.0, 357.0,
			533.0, 358.0,
			527.0, 356.0,
			519.0, 362.0,
			520.0, 355.0,
			513.0, 351.0,
			512.0, 342.0,
			510.0, 341.0,
			507.0, 346.0,
			507.0, 343.0,
			505.0, 342.0,
			505.0, 333.0,
			509.0, 334.0,
			514.0, 329.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(525.0, 310.0,
			528.0, 311.0,
			529.0, 316.0,
			535.0, 318.0,
			538.0, 321.0,
			538.0, 325.0,
			551.0, 332.0,
			553.0, 329.0,
			557.0, 329.0,
			557.0, 334.0,
			550.0, 339.0,
			543.0, 339.0,
			541.0, 342.0,
			539.0, 341.0,
			535.0, 349.0,
			535.0, 357.0,
			533.0, 358.0,
			527.0, 356.0,
			519.0, 362.0,
			520.0, 355.0,
			513.0, 351.0,
			512.0, 342.0,
			510.0, 341.0,
			507.0, 346.0,
			507.0, 343.0,
			505.0, 342.0,
			505.0, 333.0,
			509.0, 334.0,
			514.0, 329.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_247_0;
			g.setTransform(defaultTransform__0_247_0);
			g.setClip(clip__0_247_0);
			origAlpha = alpha__0_247;
			g.setTransform(defaultTransform__0_247);
			g.setClip(clip__0_247);
			float alpha__0_248 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_248 = g.getClip();
			AffineTransform defaultTransform__0_248 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_248 is CompositeGraphicsNode
			float alpha__0_248_0 = origAlpha;
			origAlpha = origAlpha * 1.0f;
			g.setComposite(AlphaComposite.getInstance(3, origAlpha));
			Shape clip__0_248_0 = g.getClip();
			AffineTransform defaultTransform__0_248_0 = g.getTransform();
			g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
			// _0_248_0 is ShapeNode
			/*paint = new Color(85, 85, 85, 0);
			shape = new GeneralPath();
			shortcut(582.0, 317.0,
			589.0, 337.0,
			582.0, 346.0,
			570.0, 335.0,
			564.0, 335.0,
			562.0, 339.0,
			562.0, 332.0,
			566.0, 329.0,
			569.0, 318.0,
			574.0, 316.0,
			575.0, 319.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.fill(shape);
			*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
			stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
			shape = new GeneralPath();
			shortcut(582.0, 317.0,
			589.0, 337.0,
			582.0, 346.0,
			570.0, 335.0,
			564.0, 335.0,
			562.0, 339.0,
			562.0, 332.0,
			566.0, 329.0,
			569.0, 318.0,
			574.0, 316.0,
			575.0, 319.0);
			((GeneralPath) shape).closePath();
			g.setPaint(paint);
			g.setStroke(stroke);
			g.draw(shape);
			origAlpha = alpha__0_248_0;
			g.setTransform(defaultTransform__0_248_0);
			g.setClip(clip__0_248_0);
			origAlpha = alpha__0_248;
			g.setTransform(defaultTransform__0_248);
			g.setClip(clip__0_248);
			
			paint22(g,colori,spessore);
			
		
		
	}
	
	public static void paint22(Graphics2D g, int colori[], float spessore) {
		
		float alpha__0_249 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_249 = g.getClip();
		AffineTransform defaultTransform__0_249 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_249 is CompositeGraphicsNode
		float alpha__0_249_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_249_0 = g.getClip();
		AffineTransform defaultTransform__0_249_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_249_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(557.0, 338.0,
		558.0, 340.0,
		560.0, 340.0,
		564.0, 335.0,
		570.0, 335.0,
		582.0, 346.0,
		579.0, 349.0,
		580.0, 354.0,
		582.0, 355.0,
		580.0, 357.0,
		585.0, 356.0,
		585.0, 360.0,
		578.0, 363.0,
		579.0, 367.0,
		577.0, 366.0,
		574.0, 371.0,
		574.0, 369.0,
		570.0, 377.0,
		564.0, 375.0,
		562.0, 372.0,
		560.0, 378.0,
		556.0, 379.0,
		556.0, 385.0,
		559.0, 382.0,
		561.0, 382.0,
		557.0, 387.0,
		553.0, 385.0,
		553.0, 381.0,
		551.0, 381.0,
		545.0, 387.0,
		541.0, 386.0,
		540.0, 388.0,
		536.0, 389.0,
		536.0, 386.0,
		541.0, 380.0,
		540.0, 379.0,
		543.0, 374.0,
		540.0, 367.0,
		544.0, 365.0,
		548.0, 367.0,
		547.0, 363.0,
		549.0, 362.0,
		549.0, 359.0,
		553.0, 354.0,
		551.0, 348.0,
		555.0, 344.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(557.0, 338.0,
		558.0, 340.0,
		560.0, 340.0,
		564.0, 335.0,
		570.0, 335.0,
		582.0, 346.0,
		579.0, 349.0,
		580.0, 354.0,
		582.0, 355.0,
		580.0, 357.0,
		585.0, 356.0,
		585.0, 360.0,
		578.0, 363.0,
		579.0, 367.0,
		577.0, 366.0,
		574.0, 371.0,
		574.0, 369.0,
		570.0, 377.0,
		564.0, 375.0,
		562.0, 372.0,
		560.0, 378.0,
		556.0, 379.0,
		556.0, 385.0,
		559.0, 382.0,
		561.0, 382.0,
		557.0, 387.0,
		553.0, 385.0,
		553.0, 381.0,
		551.0, 381.0,
		545.0, 387.0,
		541.0, 386.0,
		540.0, 388.0,
		536.0, 389.0,
		536.0, 386.0,
		541.0, 380.0,
		540.0, 379.0,
		543.0, 374.0,
		540.0, 367.0,
		544.0, 365.0,
		548.0, 367.0,
		547.0, 363.0,
		549.0, 362.0,
		549.0, 359.0,
		553.0, 354.0,
		551.0, 348.0,
		555.0, 344.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_249_0;
		g.setTransform(defaultTransform__0_249_0);
		g.setClip(clip__0_249_0);
		origAlpha = alpha__0_249;
		g.setTransform(defaultTransform__0_249);
		g.setClip(clip__0_249);
		float alpha__0_250 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_250 = g.getClip();
		AffineTransform defaultTransform__0_250 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_250 is CompositeGraphicsNode
		float alpha__0_250_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_250_0 = g.getClip();
		AffineTransform defaultTransform__0_250_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_250_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(555.0, 336.0,
		557.0, 339.0,
		551.0, 348.0,
		553.0, 354.0,
		549.0, 359.0,
		549.0, 362.0,
		547.0, 363.0,
		548.0, 367.0,
		544.0, 365.0,
		540.0, 368.0,
		537.0, 367.0,
		538.0, 361.0,
		534.0, 360.0,
		533.0, 358.0,
		535.0, 357.0,
		535.0, 353.0,
		541.0, 353.0,
		540.0, 350.0,
		543.0, 349.0,
		547.0, 350.0,
		550.0, 339.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(555.0, 336.0,
		557.0, 339.0,
		551.0, 348.0,
		553.0, 354.0,
		549.0, 359.0,
		549.0, 362.0,
		547.0, 363.0,
		548.0, 367.0,
		544.0, 365.0,
		540.0, 368.0,
		537.0, 367.0,
		538.0, 361.0,
		534.0, 360.0,
		533.0, 358.0,
		535.0, 357.0,
		535.0, 353.0,
		541.0, 353.0,
		540.0, 350.0,
		543.0, 349.0,
		547.0, 350.0,
		550.0, 339.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_250_0;
		g.setTransform(defaultTransform__0_250_0);
		g.setClip(clip__0_250_0);
		origAlpha = alpha__0_250;
		g.setTransform(defaultTransform__0_250);
		g.setClip(clip__0_250);
		float alpha__0_251 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_251 = g.getClip();
		AffineTransform defaultTransform__0_251 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_251 is CompositeGraphicsNode
		float alpha__0_251_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_251_0 = g.getClip();
		AffineTransform defaultTransform__0_251_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_251_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(589.0, 337.0,
		598.0, 350.0,
		585.0, 361.0,
		585.0, 356.0,
		580.0, 357.0,
		582.0, 355.0,
		580.0, 354.0,
		579.0, 349.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(589.0, 337.0,
		598.0, 350.0,
		585.0, 361.0,
		585.0, 356.0,
		580.0, 357.0,
		582.0, 355.0,
		580.0, 354.0,
		579.0, 349.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_251_0;
		g.setTransform(defaultTransform__0_251_0);
		g.setClip(clip__0_251_0);
		origAlpha = alpha__0_251;
		g.setTransform(defaultTransform__0_251);
		g.setClip(clip__0_251);
		float alpha__0_252 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_252 = g.getClip();
		AffineTransform defaultTransform__0_252 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_252 is CompositeGraphicsNode
		float alpha__0_252_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_252_0 = g.getClip();
		AffineTransform defaultTransform__0_252_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_252_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(550.0, 339.0,
		547.0, 350.0,
		540.0, 350.0,
		541.0, 353.0,
		538.0, 352.0,
		536.0, 354.0,
		535.0, 349.0,
		539.0, 341.0,
		541.0, 342.0,
		543.0, 339.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(550.0, 339.0,
		547.0, 350.0,
		540.0, 350.0,
		541.0, 353.0,
		538.0, 352.0,
		536.0, 354.0,
		535.0, 349.0,
		539.0, 341.0,
		541.0, 342.0,
		543.0, 339.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_252_0;
		g.setTransform(defaultTransform__0_252_0);
		g.setClip(clip__0_252_0);
		origAlpha = alpha__0_252;
		g.setTransform(defaultTransform__0_252);
		g.setClip(clip__0_252);
		float alpha__0_253 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_253 = g.getClip();
		AffineTransform defaultTransform__0_253 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_253 is CompositeGraphicsNode
		float alpha__0_253_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_253_0 = g.getClip();
		AffineTransform defaultTransform__0_253_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_253_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(598.0, 350.0,
		599.0, 351.0,
		593.0, 357.0,
		590.0, 367.0,
		587.0, 369.0,
		585.0, 361.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(598.0, 350.0,
		599.0, 351.0,
		593.0, 357.0,
		590.0, 367.0,
		587.0, 369.0,
		585.0, 361.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_253_0;
		g.setTransform(defaultTransform__0_253_0);
		g.setClip(clip__0_253_0);
		origAlpha = alpha__0_253;
		g.setTransform(defaultTransform__0_253);
		g.setClip(clip__0_253);
		float alpha__0_254 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_254 = g.getClip();
		AffineTransform defaultTransform__0_254 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_254 is CompositeGraphicsNode
		float alpha__0_254_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_254_0 = g.getClip();
		AffineTransform defaultTransform__0_254_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_254_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(599.0, 351.0,
		593.0, 366.0,
		593.0, 369.0,
		596.0, 370.0,
		596.0, 373.0,
		592.0, 377.0,
		586.0, 377.0,
		585.0, 375.0,
		587.0, 369.0,
		590.0, 367.0,
		593.0, 357.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(599.0, 351.0,
		593.0, 366.0,
		593.0, 369.0,
		596.0, 370.0,
		596.0, 373.0,
		592.0, 377.0,
		586.0, 377.0,
		585.0, 375.0,
		587.0, 369.0,
		590.0, 367.0,
		593.0, 357.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_254_0;
		g.setTransform(defaultTransform__0_254_0);
		g.setClip(clip__0_254_0);
		origAlpha = alpha__0_254;
		g.setTransform(defaultTransform__0_254);
		g.setClip(clip__0_254);
		float alpha__0_255 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_255 = g.getClip();
		AffineTransform defaultTransform__0_255 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_255 is CompositeGraphicsNode
		float alpha__0_255_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_255_0 = g.getClip();
		AffineTransform defaultTransform__0_255_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_255_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(601.0, 366.0,
		602.0, 371.0,
		600.0, 372.0,
		596.0, 372.0,
		593.0, 367.0,
		596.0, 356.0,
		600.0, 352.0,
		601.0, 353.0,
		597.0, 357.0,
		599.0, 358.0,
		600.0, 362.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(601.0, 366.0,
		602.0, 371.0,
		600.0, 372.0,
		596.0, 372.0,
		593.0, 367.0,
		596.0, 356.0,
		600.0, 352.0,
		601.0, 353.0,
		597.0, 357.0,
		599.0, 358.0,
		600.0, 362.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_255_0;
		g.setTransform(defaultTransform__0_255_0);
		g.setClip(clip__0_255_0);
		origAlpha = alpha__0_255;
		g.setTransform(defaultTransform__0_255);
		g.setClip(clip__0_255);
		float alpha__0_256 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_256 = g.getClip();
		AffineTransform defaultTransform__0_256 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_256 is CompositeGraphicsNode
		float alpha__0_256_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_256_0 = g.getClip();
		AffineTransform defaultTransform__0_256_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_256_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(601.0, 366.0,
		599.0, 358.0,
		597.0, 357.0,
		601.0, 353.0,
		610.0, 365.0,
		607.0, 367.0,
		606.0, 365.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(601.0, 366.0,
		599.0, 358.0,
		597.0, 357.0,
		601.0, 353.0,
		610.0, 365.0,
		607.0, 367.0,
		606.0, 365.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_256_0;
		g.setTransform(defaultTransform__0_256_0);
		g.setClip(clip__0_256_0);
		origAlpha = alpha__0_256;
		g.setTransform(defaultTransform__0_256);
		g.setClip(clip__0_256);
		float alpha__0_257 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_257 = g.getClip();
		AffineTransform defaultTransform__0_257 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_257 is CompositeGraphicsNode
		float alpha__0_257_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_257_0 = g.getClip();
		AffineTransform defaultTransform__0_257_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_257_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(585.0, 361.0,
		586.0, 368.0,
		582.0, 366.0,
		579.0, 367.0,
		578.0, 363.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(585.0, 361.0,
		586.0, 368.0,
		582.0, 366.0,
		579.0, 367.0,
		578.0, 363.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_257_0;
		g.setTransform(defaultTransform__0_257_0);
		g.setClip(clip__0_257_0);
		origAlpha = alpha__0_257;
		g.setTransform(defaultTransform__0_257);
		g.setClip(clip__0_257);
		float alpha__0_258 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_258 = g.getClip();
		AffineTransform defaultTransform__0_258 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_258 is CompositeGraphicsNode
		float alpha__0_258_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_258_0 = g.getClip();
		AffineTransform defaultTransform__0_258_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_258_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(610.0, 365.0,
		620.0, 374.0,
		624.0, 374.0,
		634.0, 388.0,
		631.0, 391.0,
		632.0, 394.0,
		628.0, 395.0,
		628.0, 398.0,
		624.0, 398.0,
		623.0, 395.0,
		619.0, 397.0,
		617.0, 395.0,
		601.0, 402.0,
		600.0, 399.0,
		603.0, 394.0,
		599.0, 389.0,
		602.0, 386.0,
		606.0, 391.0,
		610.0, 387.0,
		607.0, 383.0,
		603.0, 382.0,
		606.0, 377.0,
		601.0, 372.0,
		601.0, 366.0,
		606.0, 365.0,
		607.0, 367.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(610.0, 365.0,
		620.0, 374.0,
		624.0, 374.0,
		634.0, 388.0,
		631.0, 391.0,
		632.0, 394.0,
		628.0, 395.0,
		628.0, 398.0,
		624.0, 398.0,
		623.0, 395.0,
		619.0, 397.0,
		617.0, 395.0,
		601.0, 402.0,
		600.0, 399.0,
		603.0, 394.0,
		599.0, 389.0,
		602.0, 386.0,
		606.0, 391.0,
		610.0, 387.0,
		607.0, 383.0,
		603.0, 382.0,
		606.0, 377.0,
		601.0, 372.0,
		601.0, 366.0,
		606.0, 365.0,
		607.0, 367.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_258_0;
		g.setTransform(defaultTransform__0_258_0);
		g.setClip(clip__0_258_0);
		origAlpha = alpha__0_258;
		g.setTransform(defaultTransform__0_258);
		g.setClip(clip__0_258);
		float alpha__0_259 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_259 = g.getClip();
		AffineTransform defaultTransform__0_259 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_259 is CompositeGraphicsNode
		float alpha__0_259_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_259_0 = g.getClip();
		AffineTransform defaultTransform__0_259_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_259_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(586.0, 368.0,
		586.0, 377.0,
		584.0, 380.0,
		580.0, 380.0,
		575.0, 377.0,
		577.0, 366.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(586.0, 368.0,
		586.0, 377.0,
		584.0, 380.0,
		580.0, 380.0,
		575.0, 377.0,
		577.0, 366.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_259_0;
		g.setTransform(defaultTransform__0_259_0);
		g.setClip(clip__0_259_0);
		origAlpha = alpha__0_259;
		g.setTransform(defaultTransform__0_259);
		g.setClip(clip__0_259);
		float alpha__0_260 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_260 = g.getClip();
		AffineTransform defaultTransform__0_260 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_260 is CompositeGraphicsNode
		float alpha__0_260_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_260_0 = g.getClip();
		AffineTransform defaultTransform__0_260_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_260_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(575.0, 370.0,
		575.0, 380.0,
		569.0, 379.0,
		572.0, 371.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(575.0, 370.0,
		575.0, 380.0,
		569.0, 379.0,
		572.0, 371.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_260_0;
		g.setTransform(defaultTransform__0_260_0);
		g.setClip(clip__0_260_0);
		origAlpha = alpha__0_260;
		g.setTransform(defaultTransform__0_260);
		g.setClip(clip__0_260);
		float alpha__0_261 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_261 = g.getClip();
		AffineTransform defaultTransform__0_261 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_261 is CompositeGraphicsNode
		float alpha__0_261_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_261_0 = g.getClip();
		AffineTransform defaultTransform__0_261_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_261_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(601.0, 372.0,
		606.0, 377.0,
		603.0, 382.0,
		607.0, 383.0,
		610.0, 387.0,
		606.0, 391.0,
		602.0, 386.0,
		599.0, 388.0,
		598.0, 386.0,
		596.0, 387.0,
		595.0, 386.0,
		597.0, 382.0,
		595.0, 380.0,
		591.0, 381.0,
		591.0, 386.0,
		584.0, 381.0,
		585.0, 378.0,
		592.0, 377.0,
		596.0, 372.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(601.0, 372.0,
		606.0, 377.0,
		603.0, 382.0,
		607.0, 383.0,
		610.0, 387.0,
		606.0, 391.0,
		602.0, 386.0,
		599.0, 388.0,
		598.0, 386.0,
		596.0, 387.0,
		595.0, 386.0,
		597.0, 382.0,
		595.0, 380.0,
		591.0, 381.0,
		591.0, 386.0,
		584.0, 381.0,
		585.0, 378.0,
		592.0, 377.0,
		596.0, 372.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_261_0;
		g.setTransform(defaultTransform__0_261_0);
		g.setClip(clip__0_261_0);
		origAlpha = alpha__0_261;
		g.setTransform(defaultTransform__0_261);
		g.setClip(clip__0_261);
		float alpha__0_262 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_262 = g.getClip();
		AffineTransform defaultTransform__0_262 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_262 is CompositeGraphicsNode
		float alpha__0_262_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_262_0 = g.getClip();
		AffineTransform defaultTransform__0_262_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_262_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(584.0, 380.0,
		574.0, 389.0,
		570.0, 386.0,
		565.0, 392.0,
		554.0, 388.0,
		561.0, 382.0,
		560.0, 381.0,
		559.0, 384.0,
		556.0, 384.0,
		556.0, 379.0,
		560.0, 378.0,
		562.0, 372.0,
		564.0, 375.0,
		569.0, 377.0,
		570.0, 380.0,
		573.0, 380.0,
		576.0, 377.0,
		578.0, 379.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(584.0, 380.0,
		574.0, 389.0,
		570.0, 386.0,
		565.0, 392.0,
		554.0, 388.0,
		561.0, 382.0,
		560.0, 381.0,
		559.0, 384.0,
		556.0, 384.0,
		556.0, 379.0,
		560.0, 378.0,
		562.0, 372.0,
		564.0, 375.0,
		569.0, 377.0,
		570.0, 380.0,
		573.0, 380.0,
		576.0, 377.0,
		578.0, 379.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_262_0;
		g.setTransform(defaultTransform__0_262_0);
		g.setClip(clip__0_262_0);
		origAlpha = alpha__0_262;
		g.setTransform(defaultTransform__0_262);
		g.setClip(clip__0_262);
		float alpha__0_263 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_263 = g.getClip();
		AffineTransform defaultTransform__0_263 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_263 is CompositeGraphicsNode
		float alpha__0_263_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_263_0 = g.getClip();
		AffineTransform defaultTransform__0_263_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_263_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(584.0, 380.0,
		591.0, 386.0,
		586.0, 397.0,
		578.0, 397.0,
		576.0, 387.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(584.0, 380.0,
		591.0, 386.0,
		586.0, 397.0,
		578.0, 397.0,
		576.0, 387.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_263_0;
		g.setTransform(defaultTransform__0_263_0);
		g.setClip(clip__0_263_0);
		origAlpha = alpha__0_263;
		g.setTransform(defaultTransform__0_263);
		g.setClip(clip__0_263);
		float alpha__0_264 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_264 = g.getClip();
		AffineTransform defaultTransform__0_264 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_264 is CompositeGraphicsNode
		float alpha__0_264_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_264_0 = g.getClip();
		AffineTransform defaultTransform__0_264_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_264_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(599.0, 388.0,
		599.0, 390.0,
		603.0, 394.0,
		600.0, 399.0,
		601.0, 402.0,
		598.0, 405.0,
		594.0, 406.0,
		591.0, 403.0,
		592.0, 397.0,
		596.0, 387.0,
		598.0, 386.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(599.0, 388.0,
		599.0, 390.0,
		603.0, 394.0,
		600.0, 399.0,
		601.0, 402.0,
		598.0, 405.0,
		594.0, 406.0,
		591.0, 403.0,
		592.0, 397.0,
		596.0, 387.0,
		598.0, 386.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_264_0;
		g.setTransform(defaultTransform__0_264_0);
		g.setClip(clip__0_264_0);
		origAlpha = alpha__0_264;
		g.setTransform(defaultTransform__0_264);
		g.setClip(clip__0_264);
		float alpha__0_265 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_265 = g.getClip();
		AffineTransform defaultTransform__0_265 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_265 is CompositeGraphicsNode
		float alpha__0_265_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_265_0 = g.getClip();
		AffineTransform defaultTransform__0_265_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_265_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(634.0, 388.0,
		644.0, 397.0,
		642.0, 400.0,
		640.0, 400.0,
		639.0, 398.0,
		636.0, 399.0,
		634.0, 396.0,
		629.0, 397.0,
		628.0, 396.0,
		632.0, 394.0,
		631.0, 391.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(634.0, 388.0,
		644.0, 397.0,
		642.0, 400.0,
		640.0, 400.0,
		639.0, 398.0,
		636.0, 399.0,
		634.0, 396.0,
		629.0, 397.0,
		628.0, 396.0,
		632.0, 394.0,
		631.0, 391.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_265_0;
		g.setTransform(defaultTransform__0_265_0);
		g.setClip(clip__0_265_0);
		origAlpha = alpha__0_265;
		g.setTransform(defaultTransform__0_265);
		g.setClip(clip__0_265);
		float alpha__0_266 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_266 = g.getClip();
		AffineTransform defaultTransform__0_266 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_266 is CompositeGraphicsNode
		float alpha__0_266_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_266_0 = g.getClip();
		AffineTransform defaultTransform__0_266_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_266_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(576.0, 387.0,
		578.0, 397.0,
		583.0, 397.0,
		582.0, 401.0,
		576.0, 406.0,
		576.0, 409.0,
		569.0, 413.0,
		564.0, 407.0,
		560.0, 409.0,
		558.0, 408.0,
		556.0, 403.0,
		559.0, 402.0,
		559.0, 394.0,
		556.0, 393.0,
		555.0, 389.0,
		565.0, 392.0,
		570.0, 386.0,
		574.0, 389.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(576.0, 387.0,
		578.0, 397.0,
		583.0, 397.0,
		582.0, 401.0,
		576.0, 406.0,
		576.0, 409.0,
		569.0, 413.0,
		564.0, 407.0,
		560.0, 409.0,
		558.0, 408.0,
		556.0, 403.0,
		559.0, 402.0,
		559.0, 394.0,
		556.0, 393.0,
		555.0, 389.0,
		565.0, 392.0,
		570.0, 386.0,
		574.0, 389.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_266_0;
		g.setTransform(defaultTransform__0_266_0);
		g.setClip(clip__0_266_0);
		origAlpha = alpha__0_266;
		g.setTransform(defaultTransform__0_266);
		g.setClip(clip__0_266);
		float alpha__0_267 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_267 = g.getClip();
		AffineTransform defaultTransform__0_267 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_267 is CompositeGraphicsNode
		float alpha__0_267_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_267_0 = g.getClip();
		AffineTransform defaultTransform__0_267_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_267_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(629.0, 397.0,
		634.0, 397.0,
		635.0, 405.0,
		630.0, 405.0,
		628.0, 408.0,
		624.0, 407.0,
		623.0, 409.0,
		621.0, 409.0,
		620.0, 406.0,
		616.0, 409.0,
		613.0, 409.0,
		611.0, 405.0,
		612.0, 396.0,
		617.0, 395.0,
		619.0, 397.0,
		623.0, 395.0,
		625.0, 399.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(629.0, 397.0,
		634.0, 397.0,
		635.0, 405.0,
		630.0, 405.0,
		628.0, 408.0,
		624.0, 407.0,
		623.0, 409.0,
		621.0, 409.0,
		620.0, 406.0,
		616.0, 409.0,
		613.0, 409.0,
		611.0, 405.0,
		612.0, 396.0,
		617.0, 395.0,
		619.0, 397.0,
		623.0, 395.0,
		625.0, 399.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_267_0;
		g.setTransform(defaultTransform__0_267_0);
		g.setClip(clip__0_267_0);
		origAlpha = alpha__0_267;
		g.setTransform(defaultTransform__0_267);
		g.setClip(clip__0_267);
		float alpha__0_268 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_268 = g.getClip();
		AffineTransform defaultTransform__0_268 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_268 is CompositeGraphicsNode
		float alpha__0_268_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_268_0 = g.getClip();
		AffineTransform defaultTransform__0_268_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_268_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(636.0, 399.0,
		639.0, 398.0,
		640.0, 400.0,
		642.0, 400.0,
		644.0, 397.0,
		650.0, 401.0,
		643.0, 407.0,
		642.0, 411.0,
		634.0, 407.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(636.0, 399.0,
		639.0, 398.0,
		640.0, 400.0,
		642.0, 400.0,
		644.0, 397.0,
		650.0, 401.0,
		643.0, 407.0,
		642.0, 411.0,
		634.0, 407.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_268_0;
		g.setTransform(defaultTransform__0_268_0);
		g.setClip(clip__0_268_0);
		origAlpha = alpha__0_268;
		g.setTransform(defaultTransform__0_268);
		g.setClip(clip__0_268);
		float alpha__0_269 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_269 = g.getClip();
		AffineTransform defaultTransform__0_269 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_269 is CompositeGraphicsNode
		float alpha__0_269_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_269_0 = g.getClip();
		AffineTransform defaultTransform__0_269_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_269_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(642.0, 411.0,
		643.0, 407.0,
		647.0, 403.0,
		648.0, 405.0,
		652.0, 403.0,
		650.0, 406.0,
		654.0, 409.0,
		651.0, 413.0,
		652.0, 416.0,
		642.0, 416.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(642.0, 411.0,
		643.0, 407.0,
		647.0, 403.0,
		648.0, 405.0,
		652.0, 403.0,
		650.0, 406.0,
		654.0, 409.0,
		651.0, 413.0,
		652.0, 416.0,
		642.0, 416.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_269_0;
		g.setTransform(defaultTransform__0_269_0);
		g.setClip(clip__0_269_0);
		origAlpha = alpha__0_269;
		g.setTransform(defaultTransform__0_269);
		g.setClip(clip__0_269);
		float alpha__0_270 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_270 = g.getClip();
		AffineTransform defaultTransform__0_270 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_270 is CompositeGraphicsNode
		float alpha__0_270_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_270_0 = g.getClip();
		AffineTransform defaultTransform__0_270_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_270_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(629.0, 407.0,
		630.0, 405.0,
		634.0, 404.0,
		635.0, 408.0,
		638.0, 408.0,
		642.0, 411.0,
		632.0, 418.0,
		628.0, 416.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(629.0, 407.0,
		630.0, 405.0,
		634.0, 404.0,
		635.0, 408.0,
		638.0, 408.0,
		642.0, 411.0,
		632.0, 418.0,
		628.0, 416.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_270_0;
		g.setTransform(defaultTransform__0_270_0);
		g.setClip(clip__0_270_0);
		origAlpha = alpha__0_270;
		g.setTransform(defaultTransform__0_270);
		g.setClip(clip__0_270);
		float alpha__0_271 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_271 = g.getClip();
		AffineTransform defaultTransform__0_271 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_271 is CompositeGraphicsNode
		float alpha__0_271_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_271_0 = g.getClip();
		AffineTransform defaultTransform__0_271_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_271_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(621.0, 409.0,
		623.0, 409.0,
		624.0, 407.0,
		629.0, 407.0,
		628.0, 416.0,
		624.0, 414.0,
		616.0, 420.0,
		614.0, 420.0,
		608.0, 415.0,
		613.0, 409.0,
		616.0, 409.0,
		620.0, 406.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(621.0, 409.0,
		623.0, 409.0,
		624.0, 407.0,
		629.0, 407.0,
		628.0, 416.0,
		624.0, 414.0,
		616.0, 420.0,
		614.0, 420.0,
		608.0, 415.0,
		613.0, 409.0,
		616.0, 409.0,
		620.0, 406.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_271_0;
		g.setTransform(defaultTransform__0_271_0);
		g.setClip(clip__0_271_0);
		origAlpha = alpha__0_271;
		g.setTransform(defaultTransform__0_271);
		g.setClip(clip__0_271);
		float alpha__0_272 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_272 = g.getClip();
		AffineTransform defaultTransform__0_272 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_272 is CompositeGraphicsNode
		float alpha__0_272_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_272_0 = g.getClip();
		AffineTransform defaultTransform__0_272_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_272_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(642.0, 412.0,
		642.0, 416.0,
		638.0, 417.0,
		638.0, 420.0,
		636.0, 418.0,
		631.0, 419.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(642.0, 412.0,
		642.0, 416.0,
		638.0, 417.0,
		638.0, 420.0,
		636.0, 418.0,
		631.0, 419.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_272_0;
		g.setTransform(defaultTransform__0_272_0);
		g.setClip(clip__0_272_0);
		origAlpha = alpha__0_272;
		g.setTransform(defaultTransform__0_272);
		g.setClip(clip__0_272);
		float alpha__0_273 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_273 = g.getClip();
		AffineTransform defaultTransform__0_273 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_273 is CompositeGraphicsNode
		float alpha__0_273_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_273_0 = g.getClip();
		AffineTransform defaultTransform__0_273_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_273_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(642.0, 416.0,
		647.0, 417.0,
		650.0, 415.0,
		652.0, 420.0,
		650.0, 424.0,
		645.0, 426.0,
		644.0, 429.0,
		640.0, 428.0,
		638.0, 430.0,
		636.0, 423.0,
		638.0, 417.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(642.0, 416.0,
		647.0, 417.0,
		650.0, 415.0,
		652.0, 420.0,
		650.0, 424.0,
		645.0, 426.0,
		644.0, 429.0,
		640.0, 428.0,
		638.0, 430.0,
		636.0, 423.0,
		638.0, 417.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_273_0;
		g.setTransform(defaultTransform__0_273_0);
		g.setClip(clip__0_273_0);
		origAlpha = alpha__0_273;
		g.setTransform(defaultTransform__0_273);
		g.setClip(clip__0_273);
		float alpha__0_274 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_274 = g.getClip();
		AffineTransform defaultTransform__0_274 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_274 is CompositeGraphicsNode
		float alpha__0_274_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_274_0 = g.getClip();
		AffineTransform defaultTransform__0_274_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_274_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(628.0, 416.0,
		626.0, 423.0,
		622.0, 424.0,
		619.0, 428.0,
		616.0, 427.0,
		615.0, 424.0,
		617.0, 422.0,
		617.0, 419.0,
		624.0, 414.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(628.0, 416.0,
		626.0, 423.0,
		622.0, 424.0,
		619.0, 428.0,
		616.0, 427.0,
		615.0, 424.0,
		617.0, 422.0,
		617.0, 419.0,
		624.0, 414.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_274_0;
		g.setTransform(defaultTransform__0_274_0);
		g.setClip(clip__0_274_0);
		origAlpha = alpha__0_274;
		g.setTransform(defaultTransform__0_274);
		g.setClip(clip__0_274);
		float alpha__0_275 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_275 = g.getClip();
		AffineTransform defaultTransform__0_275 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_275 is CompositeGraphicsNode
		float alpha__0_275_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_275_0 = g.getClip();
		AffineTransform defaultTransform__0_275_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_275_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(631.0, 418.0,
		636.0, 418.0,
		638.0, 420.0,
		633.0, 427.0,
		633.0, 431.0,
		629.0, 433.0,
		628.0, 428.0,
		626.0, 428.0,
		628.0, 416.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(631.0, 418.0,
		636.0, 418.0,
		638.0, 420.0,
		633.0, 427.0,
		633.0, 431.0,
		629.0, 433.0,
		628.0, 428.0,
		626.0, 428.0,
		628.0, 416.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_275_0;
		g.setTransform(defaultTransform__0_275_0);
		g.setClip(clip__0_275_0);
		origAlpha = alpha__0_275;
		g.setTransform(defaultTransform__0_275);
		g.setClip(clip__0_275);
		float alpha__0_276 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_276 = g.getClip();
		AffineTransform defaultTransform__0_276 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_276 is CompositeGraphicsNode
		float alpha__0_276_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_276_0 = g.getClip();
		AffineTransform defaultTransform__0_276_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_276_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(643.0, 429.0,
		649.0, 424.0,
		652.0, 427.0,
		646.0, 431.0,
		643.0, 431.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(643.0, 429.0,
		649.0, 424.0,
		652.0, 427.0,
		646.0, 431.0,
		643.0, 431.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_276_0;
		g.setTransform(defaultTransform__0_276_0);
		g.setClip(clip__0_276_0);
		origAlpha = alpha__0_276;
		g.setTransform(defaultTransform__0_276);
		g.setClip(clip__0_276);
		float alpha__0_277 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_277 = g.getClip();
		AffineTransform defaultTransform__0_277 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_277 is CompositeGraphicsNode
		float alpha__0_277_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_277_0 = g.getClip();
		AffineTransform defaultTransform__0_277_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_277_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(636.0, 425.0,
		638.0, 430.0,
		640.0, 428.0,
		643.0, 428.0,
		643.0, 437.0,
		632.0, 439.0,
		630.0, 435.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(636.0, 425.0,
		638.0, 430.0,
		640.0, 428.0,
		643.0, 428.0,
		643.0, 437.0,
		632.0, 439.0,
		630.0, 435.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_277_0;
		g.setTransform(defaultTransform__0_277_0);
		g.setClip(clip__0_277_0);
		origAlpha = alpha__0_277;
		g.setTransform(defaultTransform__0_277);
		g.setClip(clip__0_277);
		float alpha__0_278 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_278 = g.getClip();
		AffineTransform defaultTransform__0_278 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_278 is CompositeGraphicsNode
		float alpha__0_278_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_278_0 = g.getClip();
		AffineTransform defaultTransform__0_278_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_278_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(648.0, 403.0,
		650.0, 401.0,
		655.0, 401.0,
		656.0, 404.0,
		653.0, 409.0,
		650.0, 406.0,
		652.0, 404.0,
		648.0, 405.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(648.0, 403.0,
		650.0, 401.0,
		655.0, 401.0,
		656.0, 404.0,
		653.0, 409.0,
		650.0, 406.0,
		652.0, 404.0,
		648.0, 405.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_278_0;
		g.setTransform(defaultTransform__0_278_0);
		g.setClip(clip__0_278_0);
		origAlpha = alpha__0_278;
		g.setTransform(defaultTransform__0_278);
		g.setClip(clip__0_278);
		float alpha__0_279 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_279 = g.getClip();
		AffineTransform defaultTransform__0_279 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_279 is CompositeGraphicsNode
		float alpha__0_279_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_279_0 = g.getClip();
		AffineTransform defaultTransform__0_279_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_279_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(527.0, 145.0,
		530.0, 147.0,
		537.0, 146.0,
		539.0, 154.0,
		537.0, 159.0,
		532.0, 157.0,
		532.0, 155.0,
		515.0, 150.0,
		498.0, 153.0,
		498.0, 150.0,
		497.0, 152.0,
		496.0, 150.0,
		493.0, 149.0,
		495.0, 146.0,
		491.0, 146.0,
		506.0, 145.0,
		512.0, 142.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(527.0, 145.0,
		530.0, 147.0,
		537.0, 146.0,
		539.0, 154.0,
		537.0, 159.0,
		532.0, 157.0,
		532.0, 155.0,
		515.0, 150.0,
		498.0, 153.0,
		498.0, 150.0,
		497.0, 152.0,
		496.0, 150.0,
		493.0, 149.0,
		495.0, 146.0,
		491.0, 146.0,
		506.0, 145.0,
		512.0, 142.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_279_0;
		g.setTransform(defaultTransform__0_279_0);
		g.setClip(clip__0_279_0);
		origAlpha = alpha__0_279;
		g.setTransform(defaultTransform__0_279);
		g.setClip(clip__0_279);
		float alpha__0_280 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_280 = g.getClip();
		AffineTransform defaultTransform__0_280 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_280 is CompositeGraphicsNode
		float alpha__0_280_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_280_0 = g.getClip();
		AffineTransform defaultTransform__0_280_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_280_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(489.0, 146.0,
		495.0, 146.0,
		491.0, 155.0,
		487.0, 156.0,
		488.0, 155.0,
		477.0, 154.0,
		478.0, 158.0,
		475.0, 160.0,
		475.0, 166.0,
		472.0, 165.0,
		471.0, 163.0,
		469.0, 163.0,
		468.0, 158.0,
		472.0, 156.0,
		473.0, 149.0,
		479.0, 148.0,
		483.0, 145.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(489.0, 146.0,
		495.0, 146.0,
		491.0, 155.0,
		487.0, 156.0,
		488.0, 155.0,
		477.0, 154.0,
		478.0, 158.0,
		475.0, 160.0,
		475.0, 166.0,
		472.0, 165.0,
		471.0, 163.0,
		469.0, 163.0,
		468.0, 158.0,
		472.0, 156.0,
		473.0, 149.0,
		479.0, 148.0,
		483.0, 145.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_280_0;
		g.setTransform(defaultTransform__0_280_0);
		g.setClip(clip__0_280_0);
		origAlpha = alpha__0_280;
		g.setTransform(defaultTransform__0_280);
		g.setClip(clip__0_280);
		float alpha__0_281 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_281 = g.getClip();
		AffineTransform defaultTransform__0_281 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_281 is CompositeGraphicsNode
		float alpha__0_281_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_281_0 = g.getClip();
		AffineTransform defaultTransform__0_281_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_281_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(537.0, 149.0,
		540.0, 149.0,
		542.0, 156.0,
		545.0, 157.0,
		547.0, 157.0,
		550.0, 154.0,
		553.0, 158.0,
		560.0, 159.0,
		562.0, 155.0,
		565.0, 155.0,
		565.0, 153.0,
		566.0, 155.0,
		569.0, 153.0,
		570.0, 154.0,
		572.0, 158.0,
		567.0, 174.0,
		568.0, 182.0,
		564.0, 184.0,
		563.0, 178.0,
		560.0, 178.0,
		557.0, 168.0,
		552.0, 174.0,
		550.0, 169.0,
		547.0, 169.0,
		549.0, 163.0,
		544.0, 161.0,
		544.0, 159.0,
		540.0, 158.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(537.0, 149.0,
		540.0, 149.0,
		542.0, 156.0,
		545.0, 157.0,
		547.0, 157.0,
		550.0, 154.0,
		553.0, 158.0,
		560.0, 159.0,
		562.0, 155.0,
		565.0, 155.0,
		565.0, 153.0,
		566.0, 155.0,
		569.0, 153.0,
		570.0, 154.0,
		572.0, 158.0,
		567.0, 174.0,
		568.0, 182.0,
		564.0, 184.0,
		563.0, 178.0,
		560.0, 178.0,
		557.0, 168.0,
		552.0, 174.0,
		550.0, 169.0,
		547.0, 169.0,
		549.0, 163.0,
		544.0, 161.0,
		544.0, 159.0,
		540.0, 158.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_281_0;
		g.setTransform(defaultTransform__0_281_0);
		g.setClip(clip__0_281_0);
		origAlpha = alpha__0_281;
		g.setTransform(defaultTransform__0_281);
		g.setClip(clip__0_281);
		float alpha__0_282 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_282 = g.getClip();
		AffineTransform defaultTransform__0_282 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_282 is CompositeGraphicsNode
		float alpha__0_282_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_282_0 = g.getClip();
		AffineTransform defaultTransform__0_282_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_282_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(519.0, 151.0,
		517.0, 154.0,
		519.0, 158.0,
		515.0, 159.0,
		513.0, 163.0,
		507.0, 164.0,
		511.0, 168.0,
		502.0, 167.0,
		502.0, 175.0,
		493.0, 172.0,
		490.0, 177.0,
		489.0, 176.0,
		488.0, 180.0,
		491.0, 180.0,
		490.0, 184.0,
		488.0, 180.0,
		484.0, 181.0,
		477.0, 179.0,
		475.0, 175.0,
		473.0, 178.0,
		472.0, 177.0,
		471.0, 173.0,
		475.0, 172.0,
		476.0, 169.0,
		475.0, 160.0,
		478.0, 158.0,
		477.0, 154.0,
		490.0, 156.0,
		493.0, 149.0,
		496.0, 150.0,
		497.0, 152.0,
		498.0, 150.0,
		498.0, 153.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(519.0, 151.0,
		517.0, 154.0,
		519.0, 158.0,
		515.0, 159.0,
		513.0, 163.0,
		507.0, 164.0,
		511.0, 168.0,
		502.0, 167.0,
		502.0, 175.0,
		493.0, 172.0,
		490.0, 177.0,
		489.0, 176.0,
		488.0, 180.0,
		491.0, 180.0,
		490.0, 184.0,
		488.0, 180.0,
		484.0, 181.0,
		477.0, 179.0,
		475.0, 175.0,
		473.0, 178.0,
		472.0, 177.0,
		471.0, 173.0,
		475.0, 172.0,
		476.0, 169.0,
		475.0, 160.0,
		478.0, 158.0,
		477.0, 154.0,
		490.0, 156.0,
		493.0, 149.0,
		496.0, 150.0,
		497.0, 152.0,
		498.0, 150.0,
		498.0, 153.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_282_0;
		g.setTransform(defaultTransform__0_282_0);
		g.setClip(clip__0_282_0);
		origAlpha = alpha__0_282;
		g.setTransform(defaultTransform__0_282);
		g.setClip(clip__0_282);
		float alpha__0_283 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_283 = g.getClip();
		AffineTransform defaultTransform__0_283 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_283 is CompositeGraphicsNode
		float alpha__0_283_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_283_0 = g.getClip();
		AffineTransform defaultTransform__0_283_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_283_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(519.0, 151.0,
		532.0, 155.0,
		532.0, 157.0,
		528.0, 157.0,
		528.0, 162.0,
		525.0, 162.0,
		524.0, 167.0,
		527.0, 173.0,
		520.0, 173.0,
		523.0, 181.0,
		517.0, 185.0,
		513.0, 184.0,
		510.0, 188.0,
		506.0, 188.0,
		504.0, 186.0,
		505.0, 184.0,
		502.0, 182.0,
		503.0, 181.0,
		499.0, 180.0,
		502.0, 175.0,
		502.0, 167.0,
		511.0, 168.0,
		507.0, 164.0,
		513.0, 163.0,
		515.0, 159.0,
		519.0, 158.0,
		517.0, 154.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(519.0, 151.0,
		532.0, 155.0,
		532.0, 157.0,
		528.0, 157.0,
		528.0, 162.0,
		525.0, 162.0,
		524.0, 167.0,
		527.0, 173.0,
		520.0, 173.0,
		523.0, 181.0,
		517.0, 185.0,
		513.0, 184.0,
		510.0, 188.0,
		506.0, 188.0,
		504.0, 186.0,
		505.0, 184.0,
		502.0, 182.0,
		503.0, 181.0,
		499.0, 180.0,
		502.0, 175.0,
		502.0, 167.0,
		511.0, 168.0,
		507.0, 164.0,
		513.0, 163.0,
		515.0, 159.0,
		519.0, 158.0,
		517.0, 154.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_283_0;
		g.setTransform(defaultTransform__0_283_0);
		g.setClip(clip__0_283_0);
		origAlpha = alpha__0_283;
		g.setTransform(defaultTransform__0_283);
		g.setClip(clip__0_283);
		float alpha__0_284 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_284 = g.getClip();
		AffineTransform defaultTransform__0_284 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_284 is CompositeGraphicsNode
		float alpha__0_284_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_284_0 = g.getClip();
		AffineTransform defaultTransform__0_284_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_284_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(539.0, 156.0,
		540.0, 158.0,
		544.0, 159.0,
		544.0, 161.0,
		549.0, 163.0,
		547.0, 169.0,
		550.0, 169.0,
		552.0, 174.0,
		557.0, 168.0,
		558.0, 169.0,
		560.0, 178.0,
		563.0, 178.0,
		566.0, 186.0,
		570.0, 184.0,
		567.0, 189.0,
		560.0, 190.0,
		557.0, 185.0,
		555.0, 188.0,
		551.0, 185.0,
		546.0, 188.0,
		547.0, 191.0,
		545.0, 191.0,
		542.0, 195.0,
		539.0, 189.0,
		537.0, 191.0,
		536.0, 181.0,
		528.0, 181.0,
		526.0, 183.0,
		525.0, 181.0,
		523.0, 181.0,
		520.0, 173.0,
		527.0, 173.0,
		524.0, 167.0,
		525.0, 162.0,
		528.0, 162.0,
		528.0, 157.0,
		535.0, 157.0,
		535.0, 159.0,
		537.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(539.0, 156.0,
		540.0, 158.0,
		544.0, 159.0,
		544.0, 161.0,
		549.0, 163.0,
		547.0, 169.0,
		550.0, 169.0,
		552.0, 174.0,
		557.0, 168.0,
		558.0, 169.0,
		560.0, 178.0,
		563.0, 178.0,
		566.0, 186.0,
		570.0, 184.0,
		567.0, 189.0,
		560.0, 190.0,
		557.0, 185.0,
		555.0, 188.0,
		551.0, 185.0,
		546.0, 188.0,
		547.0, 191.0,
		545.0, 191.0,
		542.0, 195.0,
		539.0, 189.0,
		537.0, 191.0,
		536.0, 181.0,
		528.0, 181.0,
		526.0, 183.0,
		525.0, 181.0,
		523.0, 181.0,
		520.0, 173.0,
		527.0, 173.0,
		524.0, 167.0,
		525.0, 162.0,
		528.0, 162.0,
		528.0, 157.0,
		535.0, 157.0,
		535.0, 159.0,
		537.0, 159.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_284_0;
		g.setTransform(defaultTransform__0_284_0);
		g.setClip(clip__0_284_0);
		origAlpha = alpha__0_284;
		g.setTransform(defaultTransform__0_284);
		g.setClip(clip__0_284);
		float alpha__0_285 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_285 = g.getClip();
		AffineTransform defaultTransform__0_285 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_285 is CompositeGraphicsNode
		float alpha__0_285_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_285_0 = g.getClip();
		AffineTransform defaultTransform__0_285_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_285_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(432.0, 155.0,
		443.0, 161.0,
		445.0, 167.0,
		449.0, 167.0,
		459.0, 161.0,
		469.0, 158.0,
		469.0, 163.0,
		477.0, 166.0,
		475.0, 172.0,
		471.0, 173.0,
		473.0, 178.0,
		475.0, 175.0,
		477.0, 179.0,
		484.0, 181.0,
		488.0, 180.0,
		496.0, 189.0,
		495.0, 196.0,
		486.0, 192.0,
		481.0, 187.0,
		477.0, 188.0,
		479.0, 190.0,
		478.0, 192.0,
		471.0, 191.0,
		471.0, 189.0,
		463.0, 195.0,
		467.0, 206.0,
		464.0, 211.0,
		466.0, 212.0,
		462.0, 217.0,
		463.0, 222.0,
		458.0, 214.0,
		456.0, 217.0,
		452.0, 215.0,
		449.0, 218.0,
		436.0, 201.0,
		439.0, 193.0,
		434.0, 190.0,
		436.0, 185.0,
		433.0, 184.0,
		433.0, 186.0,
		428.0, 180.0,
		432.0, 179.0,
		433.0, 171.0,
		435.0, 169.0,
		425.0, 160.0,
		422.0, 160.0,
		421.0, 155.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(432.0, 155.0,
		443.0, 161.0,
		445.0, 167.0,
		449.0, 167.0,
		459.0, 161.0,
		469.0, 158.0,
		469.0, 163.0,
		477.0, 166.0,
		475.0, 172.0,
		471.0, 173.0,
		473.0, 178.0,
		475.0, 175.0,
		477.0, 179.0,
		484.0, 181.0,
		488.0, 180.0,
		496.0, 189.0,
		495.0, 196.0,
		486.0, 192.0,
		481.0, 187.0,
		477.0, 188.0,
		479.0, 190.0,
		478.0, 192.0,
		471.0, 191.0,
		471.0, 189.0,
		463.0, 195.0,
		467.0, 206.0,
		464.0, 211.0,
		466.0, 212.0,
		462.0, 217.0,
		463.0, 222.0,
		458.0, 214.0,
		456.0, 217.0,
		452.0, 215.0,
		449.0, 218.0,
		436.0, 201.0,
		439.0, 193.0,
		434.0, 190.0,
		436.0, 185.0,
		433.0, 184.0,
		433.0, 186.0,
		428.0, 180.0,
		432.0, 179.0,
		433.0, 171.0,
		435.0, 169.0,
		425.0, 160.0,
		422.0, 160.0,
		421.0, 155.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_285_0;
		g.setTransform(defaultTransform__0_285_0);
		g.setClip(clip__0_285_0);
		origAlpha = alpha__0_285;
		g.setTransform(defaultTransform__0_285);
		g.setClip(clip__0_285);
		float alpha__0_286 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_286 = g.getClip();
		AffineTransform defaultTransform__0_286 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_286 is CompositeGraphicsNode
		float alpha__0_286_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_286_0 = g.getClip();
		AffineTransform defaultTransform__0_286_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_286_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(571.0, 166.0,
		572.0, 175.0,
		581.0, 177.0,
		583.0, 186.0,
		591.0, 192.0,
		590.0, 193.0,
		575.0, 190.0,
		578.0, 189.0,
		580.0, 186.0,
		576.0, 179.0,
		571.0, 180.0,
		566.0, 186.0,
		564.0, 184.0,
		568.0, 181.0,
		567.0, 174.0,
		569.0, 166.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(571.0, 166.0,
		572.0, 175.0,
		581.0, 177.0,
		583.0, 186.0,
		591.0, 192.0,
		590.0, 193.0,
		575.0, 190.0,
		578.0, 189.0,
		580.0, 186.0,
		576.0, 179.0,
		571.0, 180.0,
		566.0, 186.0,
		564.0, 184.0,
		568.0, 181.0,
		567.0, 174.0,
		569.0, 166.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_286_0;
		g.setTransform(defaultTransform__0_286_0);
		g.setClip(clip__0_286_0);
		origAlpha = alpha__0_286;
		g.setTransform(defaultTransform__0_286);
		g.setClip(clip__0_286);
		float alpha__0_287 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_287 = g.getClip();
		AffineTransform defaultTransform__0_287 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_287 is CompositeGraphicsNode
		float alpha__0_287_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_287_0 = g.getClip();
		AffineTransform defaultTransform__0_287_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_287_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(418.0, 180.0,
		417.0, 177.0,
		420.0, 173.0,
		426.0, 174.0,
		426.0, 162.0,
		435.0, 169.0,
		433.0, 171.0,
		432.0, 179.0,
		428.0, 180.0,
		433.0, 186.0,
		433.0, 184.0,
		436.0, 185.0,
		434.0, 190.0,
		427.0, 185.0,
		424.0, 185.0,
		423.0, 182.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(418.0, 180.0,
		417.0, 177.0,
		420.0, 173.0,
		426.0, 174.0,
		426.0, 162.0,
		435.0, 169.0,
		433.0, 171.0,
		432.0, 179.0,
		428.0, 180.0,
		433.0, 186.0,
		433.0, 184.0,
		436.0, 185.0,
		434.0, 190.0,
		427.0, 185.0,
		424.0, 185.0,
		423.0, 182.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_287_0;
		g.setTransform(defaultTransform__0_287_0);
		g.setClip(clip__0_287_0);
		origAlpha = alpha__0_287;
		g.setTransform(defaultTransform__0_287);
		g.setClip(clip__0_287);
		float alpha__0_288 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_288 = g.getClip();
		AffineTransform defaultTransform__0_288 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_288 is CompositeGraphicsNode
		float alpha__0_288_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_288_0 = g.getClip();
		AffineTransform defaultTransform__0_288_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_288_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(501.0, 175.0,
		499.0, 179.0,
		500.0, 181.0,
		496.0, 187.0,
		493.0, 188.0,
		492.0, 185.0,
		490.0, 184.0,
		491.0, 180.0,
		488.0, 180.0,
		488.0, 177.0,
		490.0, 177.0,
		493.0, 172.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(501.0, 175.0,
		499.0, 179.0,
		500.0, 181.0,
		496.0, 187.0,
		493.0, 188.0,
		492.0, 185.0,
		490.0, 184.0,
		491.0, 180.0,
		488.0, 180.0,
		488.0, 177.0,
		490.0, 177.0,
		493.0, 172.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_288_0;
		g.setTransform(defaultTransform__0_288_0);
		g.setClip(clip__0_288_0);
		origAlpha = alpha__0_288;
		g.setTransform(defaultTransform__0_288);
		g.setClip(clip__0_288);
		float alpha__0_289 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_289 = g.getClip();
		AffineTransform defaultTransform__0_289 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_289 is CompositeGraphicsNode
		float alpha__0_289_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_289_0 = g.getClip();
		AffineTransform defaultTransform__0_289_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_289_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(526.0, 182.0,
		536.0, 181.0,
		539.0, 201.0,
		536.0, 203.0,
		518.0, 201.0,
		515.0, 198.0,
		509.0, 203.0,
		501.0, 203.0,
		503.0, 201.0,
		501.0, 197.0,
		502.0, 195.0,
		499.0, 195.0,
		499.0, 193.0,
		502.0, 193.0,
		510.0, 189.0,
		513.0, 184.0,
		517.0, 185.0,
		525.0, 181.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(526.0, 182.0,
		536.0, 181.0,
		539.0, 201.0,
		536.0, 203.0,
		518.0, 201.0,
		515.0, 198.0,
		509.0, 203.0,
		501.0, 203.0,
		503.0, 201.0,
		501.0, 197.0,
		502.0, 195.0,
		499.0, 195.0,
		499.0, 193.0,
		502.0, 193.0,
		510.0, 189.0,
		513.0, 184.0,
		517.0, 185.0,
		525.0, 181.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_289_0;
		g.setTransform(defaultTransform__0_289_0);
		g.setClip(clip__0_289_0);
		origAlpha = alpha__0_289;
		g.setTransform(defaultTransform__0_289);
		g.setClip(clip__0_289);
		float alpha__0_290 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_290 = g.getClip();
		AffineTransform defaultTransform__0_290 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_290 is CompositeGraphicsNode
		float alpha__0_290_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_290_0 = g.getClip();
		AffineTransform defaultTransform__0_290_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_290_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(510.0, 188.0,
		502.0, 193.0,
		499.0, 193.0,
		499.0, 195.0,
		495.0, 196.0,
		496.0, 189.0,
		494.0, 188.0,
		500.0, 181.0,
		503.0, 181.0,
		502.0, 182.0,
		505.0, 184.0,
		504.0, 186.0,
		506.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(510.0, 188.0,
		502.0, 193.0,
		499.0, 193.0,
		499.0, 195.0,
		495.0, 196.0,
		496.0, 189.0,
		494.0, 188.0,
		500.0, 181.0,
		503.0, 181.0,
		502.0, 182.0,
		505.0, 184.0,
		504.0, 186.0,
		506.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_290_0;
		g.setTransform(defaultTransform__0_290_0);
		g.setClip(clip__0_290_0);
		origAlpha = alpha__0_290;
		g.setTransform(defaultTransform__0_290);
		g.setClip(clip__0_290);
		float alpha__0_291 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_291 = g.getClip();
		AffineTransform defaultTransform__0_291 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_291 is CompositeGraphicsNode
		float alpha__0_291_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_291_0 = g.getClip();
		AffineTransform defaultTransform__0_291_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_291_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(418.0, 180.0,
		423.0, 182.0,
		426.0, 186.0,
		416.0, 190.0,
		414.0, 188.0,
		417.0, 186.0,
		411.0, 182.0,
		413.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(418.0, 180.0,
		423.0, 182.0,
		426.0, 186.0,
		416.0, 190.0,
		414.0, 188.0,
		417.0, 186.0,
		411.0, 182.0,
		413.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_291_0;
		g.setTransform(defaultTransform__0_291_0);
		g.setClip(clip__0_291_0);
		origAlpha = alpha__0_291;
		g.setTransform(defaultTransform__0_291);
		g.setClip(clip__0_291);
		float alpha__0_292 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_292 = g.getClip();
		AffineTransform defaultTransform__0_292 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_292 is CompositeGraphicsNode
		float alpha__0_292_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_292_0 = g.getClip();
		AffineTransform defaultTransform__0_292_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_292_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(570.0, 185.0,
		565.0, 199.0,
		563.0, 215.0,
		565.0, 230.0,
		568.0, 234.0,
		562.0, 236.0,
		547.0, 254.0,
		543.0, 238.0,
		511.0, 228.0,
		514.0, 222.0,
		522.0, 224.0,
		540.0, 222.0,
		536.0, 218.0,
		538.0, 211.0,
		536.0, 210.0,
		538.0, 202.0,
		540.0, 203.0,
		539.0, 205.0,
		549.0, 206.0,
		552.0, 199.0,
		551.0, 189.0,
		547.0, 188.0,
		552.0, 185.0,
		555.0, 188.0,
		556.0, 185.0,
		560.0, 190.0,
		566.0, 189.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(570.0, 185.0,
		565.0, 199.0,
		563.0, 215.0,
		565.0, 230.0,
		568.0, 234.0,
		562.0, 236.0,
		547.0, 254.0,
		543.0, 238.0,
		511.0, 228.0,
		514.0, 222.0,
		522.0, 224.0,
		540.0, 222.0,
		536.0, 218.0,
		538.0, 211.0,
		536.0, 210.0,
		538.0, 202.0,
		540.0, 203.0,
		539.0, 205.0,
		549.0, 206.0,
		552.0, 199.0,
		551.0, 189.0,
		547.0, 188.0,
		552.0, 185.0,
		555.0, 188.0,
		556.0, 185.0,
		560.0, 190.0,
		566.0, 189.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_292_0;
		g.setTransform(defaultTransform__0_292_0);
		g.setClip(clip__0_292_0);
		origAlpha = alpha__0_292;
		g.setTransform(defaultTransform__0_292);
		g.setClip(clip__0_292);
		float alpha__0_293 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_293 = g.getClip();
		AffineTransform defaultTransform__0_293 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_293 is CompositeGraphicsNode
		float alpha__0_293_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_293_0 = g.getClip();
		AffineTransform defaultTransform__0_293_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_293_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(411.0, 180.0,
		413.0, 185.0,
		417.0, 186.0,
		414.0, 188.0,
		416.0, 190.0,
		410.0, 195.0,
		409.0, 198.0,
		405.0, 195.0,
		399.0, 201.0,
		397.0, 200.0,
		398.0, 194.0,
		401.0, 193.0,
		401.0, 186.0,
		403.0, 186.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(411.0, 180.0,
		413.0, 185.0,
		417.0, 186.0,
		414.0, 188.0,
		416.0, 190.0,
		410.0, 195.0,
		409.0, 198.0,
		405.0, 195.0,
		399.0, 201.0,
		397.0, 200.0,
		398.0, 194.0,
		401.0, 193.0,
		401.0, 186.0,
		403.0, 186.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_293_0;
		g.setTransform(defaultTransform__0_293_0);
		g.setClip(clip__0_293_0);
		origAlpha = alpha__0_293;
		g.setTransform(defaultTransform__0_293);
		g.setClip(clip__0_293);
		float alpha__0_294 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_294 = g.getClip();
		AffineTransform defaultTransform__0_294 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_294 is CompositeGraphicsNode
		float alpha__0_294_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_294_0 = g.getClip();
		AffineTransform defaultTransform__0_294_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_294_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(407.0, 182.0,
		403.0, 186.0,
		401.0, 186.0,
		401.0, 193.0,
		398.0, 194.0,
		397.0, 200.0,
		399.0, 201.0,
		387.0, 214.0,
		383.0, 212.0,
		386.0, 203.0,
		381.0, 201.0,
		392.0, 188.0,
		393.0, 183.0,
		400.0, 182.0,
		403.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(407.0, 182.0,
		403.0, 186.0,
		401.0, 186.0,
		401.0, 193.0,
		398.0, 194.0,
		397.0, 200.0,
		399.0, 201.0,
		387.0, 214.0,
		383.0, 212.0,
		386.0, 203.0,
		381.0, 201.0,
		392.0, 188.0,
		393.0, 183.0,
		400.0, 182.0,
		403.0, 180.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_294_0;
		g.setTransform(defaultTransform__0_294_0);
		g.setClip(clip__0_294_0);
		origAlpha = alpha__0_294;
		g.setTransform(defaultTransform__0_294);
		g.setClip(clip__0_294);
		float alpha__0_295 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_295 = g.getClip();
		AffineTransform defaultTransform__0_295 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_295 is CompositeGraphicsNode
		float alpha__0_295_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_295_0 = g.getClip();
		AffineTransform defaultTransform__0_295_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_295_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(547.0, 188.0,
		551.0, 189.0,
		552.0, 199.0,
		549.0, 206.0,
		543.0, 207.0,
		539.0, 205.0,
		540.0, 203.0,
		537.0, 202.0,
		539.0, 201.0,
		537.0, 191.0,
		539.0, 189.0,
		541.0, 194.0,
		543.0, 195.0,
		545.0, 191.0,
		547.0, 191.0,
		546.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(547.0, 188.0,
		551.0, 189.0,
		552.0, 199.0,
		549.0, 206.0,
		543.0, 207.0,
		539.0, 205.0,
		540.0, 203.0,
		537.0, 202.0,
		539.0, 201.0,
		537.0, 191.0,
		539.0, 189.0,
		541.0, 194.0,
		543.0, 195.0,
		545.0, 191.0,
		547.0, 191.0,
		546.0, 188.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_295_0;
		g.setTransform(defaultTransform__0_295_0);
		g.setClip(clip__0_295_0);
		origAlpha = alpha__0_295;
		g.setTransform(defaultTransform__0_295);
		g.setClip(clip__0_295);
		float alpha__0_296 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_296 = g.getClip();
		AffineTransform defaultTransform__0_296 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_296 is CompositeGraphicsNode
		float alpha__0_296_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_296_0 = g.getClip();
		AffineTransform defaultTransform__0_296_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_296_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(488.0, 193.0,
		489.0, 196.0,
		486.0, 199.0,
		487.0, 201.0,
		480.0, 202.0,
		477.0, 193.0,
		474.0, 192.0,
		478.0, 192.0,
		477.0, 188.0,
		481.0, 187.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(488.0, 193.0,
		489.0, 196.0,
		486.0, 199.0,
		487.0, 201.0,
		480.0, 202.0,
		477.0, 193.0,
		474.0, 192.0,
		478.0, 192.0,
		477.0, 188.0,
		481.0, 187.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_296_0;
		g.setTransform(defaultTransform__0_296_0);
		g.setClip(clip__0_296_0);
		origAlpha = alpha__0_296;
		g.setTransform(defaultTransform__0_296);
		g.setClip(clip__0_296);
		float alpha__0_297 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_297 = g.getClip();
		AffineTransform defaultTransform__0_297 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_297 is CompositeGraphicsNode
		float alpha__0_297_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_297_0 = g.getClip();
		AffineTransform defaultTransform__0_297_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_297_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(426.0, 186.0,
		427.0, 185.0,
		439.0, 193.0,
		436.0, 201.0,
		445.0, 213.0,
		443.0, 214.0,
		419.0, 200.0,
		409.0, 198.0,
		413.0, 192.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(426.0, 186.0,
		427.0, 185.0,
		439.0, 193.0,
		436.0, 201.0,
		445.0, 213.0,
		443.0, 214.0,
		419.0, 200.0,
		409.0, 198.0,
		413.0, 192.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_297_0;
		g.setTransform(defaultTransform__0_297_0);
		g.setClip(clip__0_297_0);
		origAlpha = alpha__0_297;
		g.setTransform(defaultTransform__0_297);
		g.setClip(clip__0_297);
		float alpha__0_298 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_298 = g.getClip();
		AffineTransform defaultTransform__0_298 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_298 is CompositeGraphicsNode
		float alpha__0_298_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_298_0 = g.getClip();
		AffineTransform defaultTransform__0_298_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_298_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(479.0, 202.0,
		469.0, 212.0,
		465.0, 209.0,
		467.0, 206.0,
		463.0, 195.0,
		471.0, 189.0,
		471.0, 191.0,
		477.0, 193.0,
		478.0, 199.0,
		480.0, 200.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(479.0, 202.0,
		469.0, 212.0,
		465.0, 209.0,
		467.0, 206.0,
		463.0, 195.0,
		471.0, 189.0,
		471.0, 191.0,
		477.0, 193.0,
		478.0, 199.0,
		480.0, 200.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_298_0;
		g.setTransform(defaultTransform__0_298_0);
		g.setClip(clip__0_298_0);
		origAlpha = alpha__0_298;
		g.setTransform(defaultTransform__0_298);
		g.setClip(clip__0_298);
		float alpha__0_299 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_299 = g.getClip();
		AffineTransform defaultTransform__0_299 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_299 is CompositeGraphicsNode
		float alpha__0_299_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_299_0 = g.getClip();
		AffineTransform defaultTransform__0_299_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_299_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(488.0, 193.0,
		495.0, 196.0,
		502.0, 195.0,
		501.0, 197.0,
		503.0, 201.0,
		501.0, 202.0,
		501.0, 204.0,
		509.0, 203.0,
		515.0, 198.0,
		518.0, 201.0,
		538.0, 202.0,
		536.0, 210.0,
		538.0, 211.0,
		536.0, 218.0,
		540.0, 222.0,
		522.0, 224.0,
		511.0, 221.0,
		495.0, 211.0,
		494.0, 208.0,
		492.0, 208.0,
		486.0, 200.0,
		489.0, 196.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(488.0, 193.0,
		495.0, 196.0,
		502.0, 195.0,
		501.0, 197.0,
		503.0, 201.0,
		501.0, 202.0,
		501.0, 204.0,
		509.0, 203.0,
		515.0, 198.0,
		518.0, 201.0,
		538.0, 202.0,
		536.0, 210.0,
		538.0, 211.0,
		536.0, 218.0,
		540.0, 222.0,
		522.0, 224.0,
		511.0, 221.0,
		495.0, 211.0,
		494.0, 208.0,
		492.0, 208.0,
		486.0, 200.0,
		489.0, 196.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_299_0;
		g.setTransform(defaultTransform__0_299_0);
		g.setClip(clip__0_299_0);
		origAlpha = alpha__0_299;
		g.setTransform(defaultTransform__0_299);
		g.setClip(clip__0_299);
		float alpha__0_300 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_300 = g.getClip();
		AffineTransform defaultTransform__0_300 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_300 is CompositeGraphicsNode
		float alpha__0_300_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_300_0 = g.getClip();
		AffineTransform defaultTransform__0_300_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_300_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(399.0, 201.0,
		403.0, 196.0,
		407.0, 196.0,
		399.0, 202.0,
		393.0, 216.0,
		387.0, 213.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(399.0, 201.0,
		403.0, 196.0,
		407.0, 196.0,
		399.0, 202.0,
		393.0, 216.0,
		387.0, 213.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_300_0;
		g.setTransform(defaultTransform__0_300_0);
		g.setClip(clip__0_300_0);
		origAlpha = alpha__0_300;
		g.setTransform(defaultTransform__0_300);
		g.setClip(clip__0_300);
		float alpha__0_301 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_301 = g.getClip();
		AffineTransform defaultTransform__0_301 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_301 is CompositeGraphicsNode
		float alpha__0_301_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_301_0 = g.getClip();
		AffineTransform defaultTransform__0_301_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_301_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(407.0, 196.0,
		410.0, 199.0,
		419.0, 200.0,
		429.0, 206.0,
		431.0, 210.0,
		424.0, 210.0,
		415.0, 207.0,
		413.0, 208.0,
		411.0, 205.0,
		409.0, 205.0,
		408.0, 207.0,
		401.0, 203.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(407.0, 196.0,
		410.0, 199.0,
		419.0, 200.0,
		429.0, 206.0,
		431.0, 210.0,
		424.0, 210.0,
		415.0, 207.0,
		413.0, 208.0,
		411.0, 205.0,
		409.0, 205.0,
		408.0, 207.0,
		401.0, 203.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_301_0;
		g.setTransform(defaultTransform__0_301_0);
		g.setClip(clip__0_301_0);
		origAlpha = alpha__0_301;
		g.setTransform(defaultTransform__0_301);
		g.setClip(clip__0_301);
		float alpha__0_302 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_302 = g.getClip();
		AffineTransform defaultTransform__0_302 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_302 is CompositeGraphicsNode
		float alpha__0_302_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_302_0 = g.getClip();
		AffineTransform defaultTransform__0_302_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_302_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(487.0, 201.0,
		492.0, 208.0,
		494.0, 208.0,
		495.0, 211.0,
		514.0, 222.0,
		512.0, 226.0,
		492.0, 229.0,
		487.0, 225.0,
		486.0, 227.0,
		476.0, 222.0,
		472.0, 218.0,
		470.0, 212.0,
		471.0, 209.0,
		479.0, 202.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(487.0, 201.0,
		492.0, 208.0,
		494.0, 208.0,
		495.0, 211.0,
		514.0, 222.0,
		512.0, 226.0,
		492.0, 229.0,
		487.0, 225.0,
		486.0, 227.0,
		476.0, 222.0,
		472.0, 218.0,
		470.0, 212.0,
		471.0, 209.0,
		479.0, 202.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_302_0;
		g.setTransform(defaultTransform__0_302_0);
		g.setClip(clip__0_302_0);
		origAlpha = alpha__0_302;
		g.setTransform(defaultTransform__0_302);
		g.setClip(clip__0_302);
		float alpha__0_303 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_303 = g.getClip();
		AffineTransform defaultTransform__0_303 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_303 is CompositeGraphicsNode
		float alpha__0_303_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_303_0 = g.getClip();
		AffineTransform defaultTransform__0_303_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_303_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(387.0, 214.0,
		385.0, 219.0,
		382.0, 219.0,
		381.0, 221.0,
		383.0, 229.0,
		379.0, 238.0,
		375.0, 240.0,
		370.0, 247.0,
		364.0, 249.0,
		367.0, 244.0,
		363.0, 243.0,
		363.0, 240.0,
		358.0, 237.0,
		360.0, 233.0,
		362.0, 234.0,
		364.0, 231.0,
		364.0, 225.0,
		372.0, 216.0,
		376.0, 203.0,
		381.0, 205.0,
		381.0, 201.0,
		386.0, 203.0,
		383.0, 212.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(387.0, 214.0,
		385.0, 219.0,
		382.0, 219.0,
		381.0, 221.0,
		383.0, 229.0,
		379.0, 238.0,
		375.0, 240.0,
		370.0, 247.0,
		364.0, 249.0,
		367.0, 244.0,
		363.0, 243.0,
		363.0, 240.0,
		358.0, 237.0,
		360.0, 233.0,
		362.0, 234.0,
		364.0, 231.0,
		364.0, 225.0,
		372.0, 216.0,
		376.0, 203.0,
		381.0, 205.0,
		381.0, 201.0,
		386.0, 203.0,
		383.0, 212.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_303_0;
		g.setTransform(defaultTransform__0_303_0);
		g.setClip(clip__0_303_0);
		origAlpha = alpha__0_303;
		g.setTransform(defaultTransform__0_303);
		g.setClip(clip__0_303);
		float alpha__0_304 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_304 = g.getClip();
		AffineTransform defaultTransform__0_304 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_304 is CompositeGraphicsNode
		float alpha__0_304_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_304_0 = g.getClip();
		AffineTransform defaultTransform__0_304_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_304_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(400.0, 203.0,
		408.0, 207.0,
		409.0, 205.0,
		411.0, 205.0,
		413.0, 208.0,
		415.0, 207.0,
		424.0, 210.0,
		422.0, 219.0,
		418.0, 224.0,
		409.0, 223.0,
		408.0, 218.0,
		404.0, 218.0,
		402.0, 217.0,
		403.0, 216.0,
		396.0, 213.0,
		397.0, 206.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(400.0, 203.0,
		408.0, 207.0,
		409.0, 205.0,
		411.0, 205.0,
		413.0, 208.0,
		415.0, 207.0,
		424.0, 210.0,
		422.0, 219.0,
		418.0, 224.0,
		409.0, 223.0,
		408.0, 218.0,
		404.0, 218.0,
		402.0, 217.0,
		403.0, 216.0,
		396.0, 213.0,
		397.0, 206.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_304_0;
		g.setTransform(defaultTransform__0_304_0);
		g.setClip(clip__0_304_0);
		origAlpha = alpha__0_304;
		g.setTransform(defaultTransform__0_304);
		g.setClip(clip__0_304);
		float alpha__0_305 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_305 = g.getClip();
		AffineTransform defaultTransform__0_305 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_305 is CompositeGraphicsNode
		float alpha__0_305_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_305_0 = g.getClip();
		AffineTransform defaultTransform__0_305_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_305_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(431.0, 207.0,
		442.0, 213.0,
		442.0, 217.0,
		439.0, 218.0,
		436.0, 216.0,
		432.0, 226.0,
		422.0, 236.0,
		419.0, 235.0,
		425.0, 220.0,
		422.0, 219.0,
		424.0, 210.0,
		431.0, 210.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(431.0, 207.0,
		442.0, 213.0,
		442.0, 217.0,
		439.0, 218.0,
		436.0, 216.0,
		432.0, 226.0,
		422.0, 236.0,
		419.0, 235.0,
		425.0, 220.0,
		422.0, 219.0,
		424.0, 210.0,
		431.0, 210.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_305_0;
		g.setTransform(defaultTransform__0_305_0);
		g.setClip(clip__0_305_0);
		origAlpha = alpha__0_305;
		g.setTransform(defaultTransform__0_305);
		g.setClip(clip__0_305);
		float alpha__0_306 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_306 = g.getClip();
		AffineTransform defaultTransform__0_306 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_306 is CompositeGraphicsNode
		float alpha__0_306_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_306_0 = g.getClip();
		AffineTransform defaultTransform__0_306_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_306_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(470.0, 212.0,
		473.0, 215.0,
		472.0, 218.0,
		476.0, 222.0,
		486.0, 227.0,
		487.0, 225.0,
		492.0, 229.0,
		512.0, 226.0,
		511.0, 228.0,
		543.0, 238.0,
		547.0, 254.0,
		539.0, 255.0,
		533.0, 251.0,
		530.0, 254.0,
		524.0, 252.0,
		525.0, 249.0,
		520.0, 246.0,
		519.0, 241.0,
		496.0, 247.0,
		491.0, 253.0,
		488.0, 251.0,
		480.0, 253.0,
		481.0, 250.0,
		477.0, 250.0,
		475.0, 249.0,
		476.0, 247.0,
		472.0, 247.0,
		480.0, 245.0,
		481.0, 237.0,
		483.0, 235.0,
		482.0, 233.0,
		469.0, 228.0,
		469.0, 232.0,
		463.0, 232.0,
		463.0, 234.0,
		459.0, 233.0,
		449.0, 218.0,
		452.0, 215.0,
		456.0, 217.0,
		458.0, 214.0,
		463.0, 222.0,
		462.0, 218.0,
		465.0, 213.0,
		464.0, 209.0,
		467.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(470.0, 212.0,
		473.0, 215.0,
		472.0, 218.0,
		476.0, 222.0,
		486.0, 227.0,
		487.0, 225.0,
		492.0, 229.0,
		512.0, 226.0,
		511.0, 228.0,
		543.0, 238.0,
		547.0, 254.0,
		539.0, 255.0,
		533.0, 251.0,
		530.0, 254.0,
		524.0, 252.0,
		525.0, 249.0,
		520.0, 246.0,
		519.0, 241.0,
		496.0, 247.0,
		491.0, 253.0,
		488.0, 251.0,
		480.0, 253.0,
		481.0, 250.0,
		477.0, 250.0,
		475.0, 249.0,
		476.0, 247.0,
		472.0, 247.0,
		480.0, 245.0,
		481.0, 237.0,
		483.0, 235.0,
		482.0, 233.0,
		469.0, 228.0,
		469.0, 232.0,
		463.0, 232.0,
		463.0, 234.0,
		459.0, 233.0,
		449.0, 218.0,
		452.0, 215.0,
		456.0, 217.0,
		458.0, 214.0,
		463.0, 222.0,
		462.0, 218.0,
		465.0, 213.0,
		464.0, 209.0,
		467.0, 209.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_306_0;
		g.setTransform(defaultTransform__0_306_0);
		g.setClip(clip__0_306_0);
		origAlpha = alpha__0_306;
		g.setTransform(defaultTransform__0_306);
		g.setClip(clip__0_306);
		float alpha__0_307 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_307 = g.getClip();
		AffineTransform defaultTransform__0_307 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_307 is CompositeGraphicsNode
		float alpha__0_307_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_307_0 = g.getClip();
		AffineTransform defaultTransform__0_307_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_307_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(442.0, 213.0,
		445.0, 213.0,
		452.0, 223.0,
		447.0, 226.0,
		446.0, 230.0,
		434.0, 232.0,
		433.0, 230.0,
		432.0, 231.0,
		428.0, 229.0,
		432.0, 226.0,
		436.0, 216.0,
		441.0, 218.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(442.0, 213.0,
		445.0, 213.0,
		452.0, 223.0,
		447.0, 226.0,
		446.0, 230.0,
		434.0, 232.0,
		433.0, 230.0,
		432.0, 231.0,
		428.0, 229.0,
		432.0, 226.0,
		436.0, 216.0,
		441.0, 218.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_307_0;
		g.setTransform(defaultTransform__0_307_0);
		g.setClip(clip__0_307_0);
		origAlpha = alpha__0_307;
		g.setTransform(defaultTransform__0_307);
		g.setClip(clip__0_307);
		float alpha__0_308 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_308 = g.getClip();
		AffineTransform defaultTransform__0_308 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_308 is CompositeGraphicsNode
		float alpha__0_308_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_308_0 = g.getClip();
		AffineTransform defaultTransform__0_308_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_308_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(387.0, 214.0,
		393.0, 216.0,
		396.0, 213.0,
		399.0, 214.0,
		402.0, 217.0,
		400.0, 221.0,
		401.0, 224.0,
		398.0, 225.0,
		393.0, 222.0,
		391.0, 224.0,
		391.0, 222.0,
		386.0, 224.0,
		385.0, 220.0,
		382.0, 220.0,
		385.0, 219.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(387.0, 214.0,
		393.0, 216.0,
		396.0, 213.0,
		399.0, 214.0,
		402.0, 217.0,
		400.0, 221.0,
		401.0, 224.0,
		398.0, 225.0,
		393.0, 222.0,
		391.0, 224.0,
		391.0, 222.0,
		386.0, 224.0,
		385.0, 220.0,
		382.0, 220.0,
		385.0, 219.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_308_0;
		g.setTransform(defaultTransform__0_308_0);
		g.setClip(clip__0_308_0);
		origAlpha = alpha__0_308;
		g.setTransform(defaultTransform__0_308);
		g.setClip(clip__0_308);
		float alpha__0_309 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_309 = g.getClip();
		AffineTransform defaultTransform__0_309 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_309 is CompositeGraphicsNode
		float alpha__0_309_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_309_0 = g.getClip();
		AffineTransform defaultTransform__0_309_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_309_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(413.0, 223.0,
		411.0, 228.0,
		407.0, 231.0,
		404.0, 239.0,
		401.0, 238.0,
		400.0, 235.0,
		402.0, 234.0,
		399.0, 229.0,
		401.0, 226.0,
		400.0, 224.0,
		402.0, 223.0,
		400.0, 221.0,
		402.0, 217.0,
		400.0, 215.0,
		406.0, 219.0,
		407.0, 218.0,
		409.0, 223.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(413.0, 223.0,
		411.0, 228.0,
		407.0, 231.0,
		404.0, 239.0,
		401.0, 238.0,
		400.0, 235.0,
		402.0, 234.0,
		399.0, 229.0,
		401.0, 226.0,
		400.0, 224.0,
		402.0, 223.0,
		400.0, 221.0,
		402.0, 217.0,
		400.0, 215.0,
		406.0, 219.0,
		407.0, 218.0,
		409.0, 223.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_309_0;
		g.setTransform(defaultTransform__0_309_0);
		g.setClip(clip__0_309_0);
		origAlpha = alpha__0_309;
		g.setTransform(defaultTransform__0_309);
		g.setClip(clip__0_309);
		float alpha__0_310 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_310 = g.getClip();
		AffineTransform defaultTransform__0_310 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_310 is CompositeGraphicsNode
		float alpha__0_310_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_310_0 = g.getClip();
		AffineTransform defaultTransform__0_310_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_310_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(422.0, 219.0,
		425.0, 220.0,
		423.0, 223.0,
		422.0, 230.0,
		414.0, 243.0,
		412.0, 245.0,
		407.0, 245.0,
		404.0, 242.0,
		404.0, 238.0,
		407.0, 231.0,
		411.0, 228.0,
		413.0, 223.0,
		418.0, 224.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(422.0, 219.0,
		425.0, 220.0,
		423.0, 223.0,
		422.0, 230.0,
		414.0, 243.0,
		412.0, 245.0,
		407.0, 245.0,
		404.0, 242.0,
		404.0, 238.0,
		407.0, 231.0,
		411.0, 228.0,
		413.0, 223.0,
		418.0, 224.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_310_0;
		g.setTransform(defaultTransform__0_310_0);
		g.setClip(clip__0_310_0);
		origAlpha = alpha__0_310;
		g.setTransform(defaultTransform__0_310);
		g.setClip(clip__0_310);
		float alpha__0_311 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_311 = g.getClip();
		AffineTransform defaultTransform__0_311 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_311 is CompositeGraphicsNode
		float alpha__0_311_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_311_0 = g.getClip();
		AffineTransform defaultTransform__0_311_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_311_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(382.0, 220.0,
		385.0, 220.0,
		386.0, 224.0,
		388.0, 223.0,
		391.0, 225.0,
		391.0, 236.0,
		394.0, 237.0,
		395.0, 244.0,
		385.0, 239.0,
		384.0, 247.0,
		380.0, 247.0,
		379.0, 243.0,
		378.0, 245.0,
		377.0, 243.0,
		383.0, 229.0,
		381.0, 224.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(382.0, 220.0,
		385.0, 220.0,
		386.0, 224.0,
		388.0, 223.0,
		391.0, 225.0,
		391.0, 236.0,
		394.0, 237.0,
		395.0, 244.0,
		385.0, 239.0,
		384.0, 247.0,
		380.0, 247.0,
		379.0, 243.0,
		378.0, 245.0,
		377.0, 243.0,
		383.0, 229.0,
		381.0, 224.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_311_0;
		g.setTransform(defaultTransform__0_311_0);
		g.setClip(clip__0_311_0);
		origAlpha = alpha__0_311;
		g.setTransform(defaultTransform__0_311);
		g.setClip(clip__0_311);
		float alpha__0_312 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_312 = g.getClip();
		AffineTransform defaultTransform__0_312 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_312 is CompositeGraphicsNode
		float alpha__0_312_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_312_0 = g.getClip();
		AffineTransform defaultTransform__0_312_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_312_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(452.0, 223.0,
		459.0, 233.0,
		463.0, 234.0,
		463.0, 232.0,
		469.0, 232.0,
		469.0, 228.0,
		482.0, 233.0,
		483.0, 235.0,
		481.0, 237.0,
		480.0, 245.0,
		464.0, 246.0,
		461.0, 251.0,
		447.0, 256.0,
		450.0, 254.0,
		448.0, 252.0,
		451.0, 249.0,
		451.0, 247.0,
		443.0, 246.0,
		445.0, 241.0,
		450.0, 238.0,
		446.0, 234.0,
		446.0, 229.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(452.0, 223.0,
		459.0, 233.0,
		463.0, 234.0,
		463.0, 232.0,
		469.0, 232.0,
		469.0, 228.0,
		482.0, 233.0,
		483.0, 235.0,
		481.0, 237.0,
		480.0, 245.0,
		464.0, 246.0,
		461.0, 251.0,
		447.0, 256.0,
		450.0, 254.0,
		448.0, 252.0,
		451.0, 249.0,
		451.0, 247.0,
		443.0, 246.0,
		445.0, 241.0,
		450.0, 238.0,
		446.0, 234.0,
		446.0, 229.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_312_0;
		g.setTransform(defaultTransform__0_312_0);
		g.setClip(clip__0_312_0);
		origAlpha = alpha__0_312;
		g.setTransform(defaultTransform__0_312);
		g.setClip(clip__0_312);
		float alpha__0_313 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_313 = g.getClip();
		AffineTransform defaultTransform__0_313 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_313 is CompositeGraphicsNode
		float alpha__0_313_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_313_0 = g.getClip();
		AffineTransform defaultTransform__0_313_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_313_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(400.0, 224.0,
		401.0, 226.0,
		399.0, 229.0,
		402.0, 234.0,
		400.0, 235.0,
		401.0, 238.0,
		404.0, 239.0,
		404.0, 242.0,
		407.0, 244.0,
		406.0, 247.0,
		397.0, 240.0,
		394.0, 240.0,
		394.0, 237.0,
		391.0, 236.0,
		392.0, 232.0,
		391.0, 233.0,
		390.0, 230.0,
		390.0, 223.0,
		392.0, 224.0,
		393.0, 222.0,
		398.0, 225.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(400.0, 224.0,
		401.0, 226.0,
		399.0, 229.0,
		402.0, 234.0,
		400.0, 235.0,
		401.0, 238.0,
		404.0, 239.0,
		404.0, 242.0,
		407.0, 244.0,
		406.0, 247.0,
		397.0, 240.0,
		394.0, 240.0,
		394.0, 237.0,
		391.0, 236.0,
		392.0, 232.0,
		391.0, 233.0,
		390.0, 230.0,
		390.0, 223.0,
		392.0, 224.0,
		393.0, 222.0,
		398.0, 225.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_313_0;
		g.setTransform(defaultTransform__0_313_0);
		g.setClip(clip__0_313_0);
		origAlpha = alpha__0_313;
		g.setTransform(defaultTransform__0_313);
		g.setClip(clip__0_313);
		float alpha__0_314 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_314 = g.getClip();
		AffineTransform defaultTransform__0_314 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_314 is CompositeGraphicsNode
		float alpha__0_314_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_314_0 = g.getClip();
		AffineTransform defaultTransform__0_314_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_314_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(428.0, 229.0,
		432.0, 231.0,
		433.0, 230.0,
		434.0, 232.0,
		441.0, 232.0,
		438.0, 239.0,
		436.0, 241.0,
		434.0, 240.0,
		432.0, 244.0,
		429.0, 245.0,
		423.0, 241.0,
		420.0, 245.0,
		415.0, 240.0,
		419.0, 235.0,
		422.0, 236.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(428.0, 229.0,
		432.0, 231.0,
		433.0, 230.0,
		434.0, 232.0,
		441.0, 232.0,
		438.0, 239.0,
		436.0, 241.0,
		434.0, 240.0,
		432.0, 244.0,
		429.0, 245.0,
		423.0, 241.0,
		420.0, 245.0,
		415.0, 240.0,
		419.0, 235.0,
		422.0, 236.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_314_0;
		g.setTransform(defaultTransform__0_314_0);
		g.setClip(clip__0_314_0);
		origAlpha = alpha__0_314;
		g.setTransform(defaultTransform__0_314);
		g.setClip(clip__0_314);
		float alpha__0_315 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_315 = g.getClip();
		AffineTransform defaultTransform__0_315 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_315 is CompositeGraphicsNode
		float alpha__0_315_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_315_0 = g.getClip();
		AffineTransform defaultTransform__0_315_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_315_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(446.0, 230.0,
		446.0, 234.0,
		450.0, 238.0,
		445.0, 241.0,
		443.0, 246.0,
		451.0, 247.0,
		451.0, 249.0,
		448.0, 252.0,
		450.0, 254.0,
		431.0, 271.0,
		428.0, 271.0,
		428.0, 268.0,
		426.0, 269.0,
		431.0, 264.0,
		425.0, 259.0,
		426.0, 257.0,
		422.0, 256.0,
		423.0, 254.0,
		421.0, 251.0,
		423.0, 246.0,
		420.0, 245.0,
		423.0, 241.0,
		429.0, 245.0,
		432.0, 244.0,
		434.0, 240.0,
		436.0, 241.0,
		438.0, 239.0,
		440.0, 233.0,
		445.0, 229.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(446.0, 230.0,
		446.0, 234.0,
		450.0, 238.0,
		445.0, 241.0,
		443.0, 246.0,
		451.0, 247.0,
		451.0, 249.0,
		448.0, 252.0,
		450.0, 254.0,
		431.0, 271.0,
		428.0, 271.0,
		428.0, 268.0,
		426.0, 269.0,
		431.0, 264.0,
		425.0, 259.0,
		426.0, 257.0,
		422.0, 256.0,
		423.0, 254.0,
		421.0, 251.0,
		423.0, 246.0,
		420.0, 245.0,
		423.0, 241.0,
		429.0, 245.0,
		432.0, 244.0,
		434.0, 240.0,
		436.0, 241.0,
		438.0, 239.0,
		440.0, 233.0,
		445.0, 229.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_315_0;
		g.setTransform(defaultTransform__0_315_0);
		g.setClip(clip__0_315_0);
		origAlpha = alpha__0_315;
		g.setTransform(defaultTransform__0_315);
		g.setClip(clip__0_315);
		float alpha__0_316 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_316 = g.getClip();
		AffineTransform defaultTransform__0_316 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_316 is CompositeGraphicsNode
		float alpha__0_316_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_316_0 = g.getClip();
		AffineTransform defaultTransform__0_316_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_316_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(498.0, 247.0,
		519.0, 241.0,
		520.0, 246.0,
		523.0, 247.0,
		524.0, 252.0,
		530.0, 255.0,
		531.0, 252.0,
		536.0, 252.0,
		539.0, 255.0,
		531.0, 269.0,
		513.0, 268.0,
		510.0, 264.0,
		512.0, 259.0,
		514.0, 259.0,
		516.0, 256.0,
		500.0, 251.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(498.0, 247.0,
		519.0, 241.0,
		520.0, 246.0,
		523.0, 247.0,
		524.0, 252.0,
		530.0, 255.0,
		531.0, 252.0,
		536.0, 252.0,
		539.0, 255.0,
		531.0, 269.0,
		513.0, 268.0,
		510.0, 264.0,
		512.0, 259.0,
		514.0, 259.0,
		516.0, 256.0,
		500.0, 251.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_316_0;
		g.setTransform(defaultTransform__0_316_0);
		g.setClip(clip__0_316_0);
		origAlpha = alpha__0_316;
		g.setTransform(defaultTransform__0_316);
		g.setClip(clip__0_316);
		float alpha__0_317 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_317 = g.getClip();
		AffineTransform defaultTransform__0_317 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_317 is CompositeGraphicsNode
		float alpha__0_317_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_317_0 = g.getClip();
		AffineTransform defaultTransform__0_317_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_317_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(379.0, 238.0,
		376.0, 249.0,
		380.0, 256.0,
		379.0, 259.0,
		373.0, 259.0,
		372.0, 261.0,
		369.0, 261.0,
		370.0, 254.0,
		360.0, 249.0,
		364.0, 244.0,
		367.0, 245.0,
		364.0, 249.0,
		370.0, 247.0,
		375.0, 240.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(379.0, 238.0,
		376.0, 249.0,
		380.0, 256.0,
		379.0, 259.0,
		373.0, 259.0,
		372.0, 261.0,
		369.0, 261.0,
		370.0, 254.0,
		360.0, 249.0,
		364.0, 244.0,
		367.0, 245.0,
		364.0, 249.0,
		370.0, 247.0,
		375.0, 240.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_317_0;
		g.setTransform(defaultTransform__0_317_0);
		g.setClip(clip__0_317_0);
		origAlpha = alpha__0_317;
		g.setTransform(defaultTransform__0_317);
		g.setClip(clip__0_317);
		float alpha__0_318 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_318 = g.getClip();
		AffineTransform defaultTransform__0_318 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_318 is CompositeGraphicsNode
		float alpha__0_318_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_318_0 = g.getClip();
		AffineTransform defaultTransform__0_318_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_318_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(378.0, 245.0,
		379.0, 243.0,
		379.0, 247.0,
		384.0, 247.0,
		385.0, 239.0,
		394.0, 243.0,
		394.0, 249.0,
		396.0, 250.0,
		395.0, 252.0,
		393.0, 250.0,
		393.0, 259.0,
		390.0, 258.0,
		388.0, 254.0,
		386.0, 258.0,
		383.0, 253.0,
		380.0, 256.0,
		378.0, 255.0,
		376.0, 249.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(378.0, 245.0,
		379.0, 243.0,
		379.0, 247.0,
		384.0, 247.0,
		385.0, 239.0,
		394.0, 243.0,
		394.0, 249.0,
		396.0, 250.0,
		395.0, 252.0,
		393.0, 250.0,
		393.0, 259.0,
		390.0, 258.0,
		388.0, 254.0,
		386.0, 258.0,
		383.0, 253.0,
		380.0, 256.0,
		378.0, 255.0,
		376.0, 249.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_318_0;
		g.setTransform(defaultTransform__0_318_0);
		g.setClip(clip__0_318_0);
		origAlpha = alpha__0_318;
		g.setTransform(defaultTransform__0_318);
		g.setClip(clip__0_318);
		float alpha__0_319 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_319 = g.getClip();
		AffineTransform defaultTransform__0_319 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_319 is CompositeGraphicsNode
		float alpha__0_319_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_319_0 = g.getClip();
		AffineTransform defaultTransform__0_319_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_319_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(394.0, 240.0,
		397.0, 240.0,
		406.0, 247.0,
		407.0, 245.0,
		411.0, 245.0,
		410.0, 251.0,
		406.0, 254.0,
		403.0, 252.0,
		399.0, 253.0,
		398.0, 256.0,
		394.0, 255.0,
		393.0, 250.0,
		395.0, 252.0,
		396.0, 250.0,
		394.0, 249.0,
		395.0, 242.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(394.0, 240.0,
		397.0, 240.0,
		406.0, 247.0,
		407.0, 245.0,
		411.0, 245.0,
		410.0, 251.0,
		406.0, 254.0,
		403.0, 252.0,
		399.0, 253.0,
		398.0, 256.0,
		394.0, 255.0,
		393.0, 250.0,
		395.0, 252.0,
		396.0, 250.0,
		394.0, 249.0,
		395.0, 242.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_319_0;
		g.setTransform(defaultTransform__0_319_0);
		g.setClip(clip__0_319_0);
		origAlpha = alpha__0_319;
		g.setTransform(defaultTransform__0_319);
		g.setClip(clip__0_319);
		float alpha__0_320 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_320 = g.getClip();
		AffineTransform defaultTransform__0_320 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_320 is CompositeGraphicsNode
		float alpha__0_320_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_320_0 = g.getClip();
		AffineTransform defaultTransform__0_320_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_320_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(420.0, 245.0,
		423.0, 246.0,
		421.0, 251.0,
		423.0, 256.0,
		417.0, 255.0,
		415.0, 261.0,
		413.0, 259.0,
		412.0, 260.0,
		412.0, 257.0,
		406.0, 254.0,
		410.0, 251.0,
		412.0, 247.0,
		411.0, 245.0,
		415.0, 241.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(420.0, 245.0,
		423.0, 246.0,
		421.0, 251.0,
		423.0, 256.0,
		417.0, 255.0,
		415.0, 261.0,
		413.0, 259.0,
		412.0, 260.0,
		412.0, 257.0,
		406.0, 254.0,
		410.0, 251.0,
		412.0, 247.0,
		411.0, 245.0,
		415.0, 241.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_320_0;
		g.setTransform(defaultTransform__0_320_0);
		g.setClip(clip__0_320_0);
		origAlpha = alpha__0_320;
		g.setTransform(defaultTransform__0_320);
		g.setClip(clip__0_320);
		float alpha__0_321 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_321 = g.getClip();
		AffineTransform defaultTransform__0_321 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_321 is CompositeGraphicsNode
		float alpha__0_321_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_321_0 = g.getClip();
		AffineTransform defaultTransform__0_321_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_321_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(477.0, 250.0,
		475.0, 264.0,
		467.0, 275.0,
		458.0, 281.0,
		456.0, 277.0,
		440.0, 274.0,
		433.0, 269.0,
		440.0, 264.0,
		445.0, 258.0,
		461.0, 251.0,
		464.0, 248.0,
		463.0, 247.0,
		470.0, 245.0,
		474.0, 248.0,
		476.0, 247.0,
		475.0, 249.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(477.0, 250.0,
		475.0, 264.0,
		467.0, 275.0,
		458.0, 281.0,
		456.0, 277.0,
		440.0, 274.0,
		433.0, 269.0,
		440.0, 264.0,
		445.0, 258.0,
		461.0, 251.0,
		464.0, 248.0,
		463.0, 247.0,
		470.0, 245.0,
		474.0, 248.0,
		476.0, 247.0,
		475.0, 249.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_321_0;
		g.setTransform(defaultTransform__0_321_0);
		g.setClip(clip__0_321_0);
		origAlpha = alpha__0_321;
		g.setTransform(defaultTransform__0_321);
		g.setClip(clip__0_321);
		float alpha__0_322 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_322 = g.getClip();
		AffineTransform defaultTransform__0_322 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_322 is CompositeGraphicsNode
		float alpha__0_322_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_322_0 = g.getClip();
		AffineTransform defaultTransform__0_322_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_322_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(498.0, 247.0,
		500.0, 251.0,
		503.0, 252.0,
		502.0, 254.0,
		496.0, 255.0,
		494.0, 265.0,
		490.0, 270.0,
		491.0, 275.0,
		488.0, 274.0,
		479.0, 266.0,
		480.0, 253.0,
		488.0, 251.0,
		491.0, 253.0,
		496.0, 247.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(498.0, 247.0,
		500.0, 251.0,
		503.0, 252.0,
		502.0, 254.0,
		496.0, 255.0,
		494.0, 265.0,
		490.0, 270.0,
		491.0, 275.0,
		488.0, 274.0,
		479.0, 266.0,
		480.0, 253.0,
		488.0, 251.0,
		491.0, 253.0,
		496.0, 247.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_322_0;
		g.setTransform(defaultTransform__0_322_0);
		g.setClip(clip__0_322_0);
		origAlpha = alpha__0_322;
		g.setTransform(defaultTransform__0_322);
		g.setClip(clip__0_322);
		float alpha__0_323 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_323 = g.getClip();
		AffineTransform defaultTransform__0_323 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_323 is CompositeGraphicsNode
		float alpha__0_323_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_323_0 = g.getClip();
		AffineTransform defaultTransform__0_323_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_323_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(503.0, 252.0,
		516.0, 256.0,
		514.0, 259.0,
		512.0, 259.0,
		511.0, 265.0,
		505.0, 271.0,
		508.0, 274.0,
		507.0, 276.0,
		511.0, 280.0,
		508.0, 290.0,
		504.0, 294.0,
		498.0, 292.0,
		495.0, 294.0,
		489.0, 289.0,
		490.0, 285.0,
		493.0, 286.0,
		493.0, 284.0,
		496.0, 285.0,
		498.0, 283.0,
		495.0, 281.0,
		497.0, 277.0,
		492.0, 274.0,
		492.0, 271.0,
		494.0, 269.0,
		492.0, 268.0,
		494.0, 265.0,
		496.0, 255.0,
		502.0, 254.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(503.0, 252.0,
		516.0, 256.0,
		514.0, 259.0,
		512.0, 259.0,
		511.0, 265.0,
		505.0, 271.0,
		508.0, 274.0,
		507.0, 276.0,
		511.0, 280.0,
		508.0, 290.0,
		504.0, 294.0,
		498.0, 292.0,
		495.0, 294.0,
		489.0, 289.0,
		490.0, 285.0,
		493.0, 286.0,
		493.0, 284.0,
		496.0, 285.0,
		498.0, 283.0,
		495.0, 281.0,
		497.0, 277.0,
		492.0, 274.0,
		492.0, 271.0,
		494.0, 269.0,
		492.0, 268.0,
		494.0, 265.0,
		496.0, 255.0,
		502.0, 254.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_323_0;
		g.setTransform(defaultTransform__0_323_0);
		g.setClip(clip__0_323_0);
		origAlpha = alpha__0_323;
		g.setTransform(defaultTransform__0_323);
		g.setClip(clip__0_323);
		float alpha__0_324 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_324 = g.getClip();
		AffineTransform defaultTransform__0_324 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_324 is CompositeGraphicsNode
		float alpha__0_324_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_324_0 = g.getClip();
		AffineTransform defaultTransform__0_324_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_324_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(423.0, 256.0,
		426.0, 257.0,
		425.0, 259.0,
		431.0, 264.0,
		424.0, 273.0,
		417.0, 271.0,
		417.0, 269.0,
		412.0, 269.0,
		416.0, 263.0,
		414.0, 261.0,
		417.0, 259.0,
		417.0, 255.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(423.0, 256.0,
		426.0, 257.0,
		425.0, 259.0,
		431.0, 264.0,
		424.0, 273.0,
		417.0, 271.0,
		417.0, 269.0,
		412.0, 269.0,
		416.0, 263.0,
		414.0, 261.0,
		417.0, 259.0,
		417.0, 255.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_324_0;
		g.setTransform(defaultTransform__0_324_0);
		g.setClip(clip__0_324_0);
		origAlpha = alpha__0_324;
		g.setTransform(defaultTransform__0_324);
		g.setClip(clip__0_324);
		float alpha__0_325 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_325 = g.getClip();
		AffineTransform defaultTransform__0_325 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_325 is CompositeGraphicsNode
		float alpha__0_325_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_325_0 = g.getClip();
		AffineTransform defaultTransform__0_325_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_325_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(527.0, 268.0,
		514.0, 275.0,
		510.0, 279.0,
		507.0, 276.0,
		508.0, 274.0,
		505.0, 272.0,
		511.0, 265.0,
		513.0, 268.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(527.0, 268.0,
		514.0, 275.0,
		510.0, 279.0,
		507.0, 276.0,
		508.0, 274.0,
		505.0, 272.0,
		511.0, 265.0,
		513.0, 268.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_325_0;
		g.setTransform(defaultTransform__0_325_0);
		g.setClip(clip__0_325_0);
		origAlpha = alpha__0_325;
		g.setTransform(defaultTransform__0_325);
		g.setClip(clip__0_325);
		float alpha__0_326 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_326 = g.getClip();
		AffineTransform defaultTransform__0_326 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_326 is CompositeGraphicsNode
		float alpha__0_326_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_326_0 = g.getClip();
		AffineTransform defaultTransform__0_326_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_326_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(492.0, 268.0,
		494.0, 269.0,
		492.0, 271.0,
		491.0, 277.0,
		493.0, 277.0,
		489.0, 283.0,
		493.0, 286.0,
		490.0, 285.0,
		487.0, 288.0,
		479.0, 283.0,
		482.0, 277.0,
		479.0, 275.0,
		482.0, 270.0,
		473.0, 267.0,
		476.0, 264.0,
		491.0, 275.0,
		490.0, 270.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(492.0, 268.0,
		494.0, 269.0,
		492.0, 271.0,
		491.0, 277.0,
		493.0, 277.0,
		489.0, 283.0,
		493.0, 286.0,
		490.0, 285.0,
		487.0, 288.0,
		479.0, 283.0,
		482.0, 277.0,
		479.0, 275.0,
		482.0, 270.0,
		473.0, 267.0,
		476.0, 264.0,
		491.0, 275.0,
		490.0, 270.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_326_0;
		g.setTransform(defaultTransform__0_326_0);
		g.setClip(clip__0_326_0);
		origAlpha = alpha__0_326;
		g.setTransform(defaultTransform__0_326);
		g.setClip(clip__0_326);
		float alpha__0_327 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_327 = g.getClip();
		AffineTransform defaultTransform__0_327 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_327 is CompositeGraphicsNode
		float alpha__0_327_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_327_0 = g.getClip();
		AffineTransform defaultTransform__0_327_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_327_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(470.0, 270.0,
		465.0, 282.0,
		460.0, 287.0,
		455.0, 285.0,
		453.0, 287.0,
		447.0, 284.0,
		450.0, 277.0,
		456.0, 277.0,
		458.0, 281.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(470.0, 270.0,
		465.0, 282.0,
		460.0, 287.0,
		455.0, 285.0,
		453.0, 287.0,
		447.0, 284.0,
		450.0, 277.0,
		456.0, 277.0,
		458.0, 281.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_327_0;
		g.setTransform(defaultTransform__0_327_0);
		g.setClip(clip__0_327_0);
		origAlpha = alpha__0_327;
		g.setTransform(defaultTransform__0_327);
		g.setClip(clip__0_327);
		float alpha__0_328 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_328 = g.getClip();
		AffineTransform defaultTransform__0_328 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_328 is CompositeGraphicsNode
		float alpha__0_328_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_328_0 = g.getClip();
		AffineTransform defaultTransform__0_328_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_328_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(492.0, 274.0,
		497.0, 277.0,
		495.0, 281.0,
		498.0, 283.0,
		496.0, 285.0,
		493.0, 284.0,
		493.0, 286.0,
		489.0, 283.0,
		493.0, 278.0,
		491.0, 277.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(492.0, 274.0,
		497.0, 277.0,
		495.0, 281.0,
		498.0, 283.0,
		496.0, 285.0,
		493.0, 284.0,
		493.0, 286.0,
		489.0, 283.0,
		493.0, 278.0,
		491.0, 277.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_328_0;
		g.setTransform(defaultTransform__0_328_0);
		g.setClip(clip__0_328_0);
		origAlpha = alpha__0_328;
		g.setTransform(defaultTransform__0_328);
		g.setClip(clip__0_328);
		float alpha__0_329 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_329 = g.getClip();
		AffineTransform defaultTransform__0_329 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_329 is CompositeGraphicsNode
		float alpha__0_329_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_329_0 = g.getClip();
		AffineTransform defaultTransform__0_329_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_329_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(479.0, 283.0,
		487.0, 288.0,
		490.0, 287.0,
		484.0, 297.0,
		474.0, 292.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(479.0, 283.0,
		487.0, 288.0,
		490.0, 287.0,
		484.0, 297.0,
		474.0, 292.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_329_0;
		g.setTransform(defaultTransform__0_329_0);
		g.setClip(clip__0_329_0);
		origAlpha = alpha__0_329;
		g.setTransform(defaultTransform__0_329);
		g.setClip(clip__0_329);
		float alpha__0_330 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_330 = g.getClip();
		AffineTransform defaultTransform__0_330 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_330 is CompositeGraphicsNode
		float alpha__0_330_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_330_0 = g.getClip();
		AffineTransform defaultTransform__0_330_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_330_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(493.0, 293.0,
		490.0, 298.0,
		484.0, 297.0,
		489.0, 289.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(493.0, 293.0,
		490.0, 298.0,
		484.0, 297.0,
		489.0, 289.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_330_0;
		g.setTransform(defaultTransform__0_330_0);
		g.setClip(clip__0_330_0);
		origAlpha = alpha__0_330;
		g.setTransform(defaultTransform__0_330);
		g.setClip(clip__0_330);
		float alpha__0_331 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_331 = g.getClip();
		AffineTransform defaultTransform__0_331 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_331 is CompositeGraphicsNode
		float alpha__0_331_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_331_0 = g.getClip();
		AffineTransform defaultTransform__0_331_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_331_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(508.0, 290.0,
		509.0, 292.0,
		514.0, 294.0,
		516.0, 298.0,
		515.0, 300.0,
		508.0, 298.0,
		505.0, 299.0,
		501.0, 307.0,
		493.0, 300.0,
		495.0, 298.0,
		492.0, 296.0,
		493.0, 293.0,
		495.0, 294.0,
		498.0, 292.0,
		502.0, 292.0,
		504.0, 294.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(508.0, 290.0,
		509.0, 292.0,
		514.0, 294.0,
		516.0, 298.0,
		515.0, 300.0,
		508.0, 298.0,
		505.0, 299.0,
		501.0, 307.0,
		493.0, 300.0,
		495.0, 298.0,
		492.0, 296.0,
		493.0, 293.0,
		495.0, 294.0,
		498.0, 292.0,
		502.0, 292.0,
		504.0, 294.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_331_0;
		g.setTransform(defaultTransform__0_331_0);
		g.setClip(clip__0_331_0);
		origAlpha = alpha__0_331;
		g.setTransform(defaultTransform__0_331);
		g.setClip(clip__0_331);
		float alpha__0_332 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_332 = g.getClip();
		AffineTransform defaultTransform__0_332 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_332 is CompositeGraphicsNode
		float alpha__0_332_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_332_0 = g.getClip();
		AffineTransform defaultTransform__0_332_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_332_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(492.0, 296.0,
		495.0, 298.0,
		493.0, 300.0,
		496.0, 303.0,
		493.0, 310.0,
		490.0, 311.0,
		482.0, 305.0,
		481.0, 301.0,
		483.0, 301.0,
		482.0, 298.0,
		490.0, 298.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(492.0, 296.0,
		495.0, 298.0,
		493.0, 300.0,
		496.0, 303.0,
		493.0, 310.0,
		490.0, 311.0,
		482.0, 305.0,
		481.0, 301.0,
		483.0, 301.0,
		482.0, 298.0,
		490.0, 298.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_332_0;
		g.setTransform(defaultTransform__0_332_0);
		g.setClip(clip__0_332_0);
		origAlpha = alpha__0_332;
		g.setTransform(defaultTransform__0_332);
		g.setClip(clip__0_332);
		float alpha__0_333 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_333 = g.getClip();
		AffineTransform defaultTransform__0_333 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_333 is CompositeGraphicsNode
		float alpha__0_333_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_333_0 = g.getClip();
		AffineTransform defaultTransform__0_333_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_333_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(480.0, 253.0,
		479.0, 266.0,
		476.0, 264.0,
		473.0, 267.0,
		482.0, 270.0,
		479.0, 275.0,
		482.0, 277.0,
		474.0, 292.0,
		484.0, 297.0,
		482.0, 298.0,
		483.0, 301.0,
		481.0, 301.0,
		478.0, 308.0,
		466.0, 320.0,
		462.0, 320.0,
		464.0, 316.0,
		459.0, 314.0,
		458.0, 322.0,
		456.0, 321.0,
		455.0, 317.0,
		453.0, 319.0,
		449.0, 315.0,
		444.0, 315.0,
		443.0, 311.0,
		447.0, 311.0,
		445.0, 308.0,
		457.0, 302.0,
		455.0, 294.0,
		457.0, 288.0,
		465.0, 282.0,
		470.0, 269.0,
		475.0, 264.0,
		478.0, 250.0,
		481.0, 250.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(480.0, 253.0,
		479.0, 266.0,
		476.0, 264.0,
		473.0, 267.0,
		482.0, 270.0,
		479.0, 275.0,
		482.0, 277.0,
		474.0, 292.0,
		484.0, 297.0,
		482.0, 298.0,
		483.0, 301.0,
		481.0, 301.0,
		478.0, 308.0,
		466.0, 320.0,
		462.0, 320.0,
		464.0, 316.0,
		459.0, 314.0,
		458.0, 322.0,
		456.0, 321.0,
		455.0, 317.0,
		453.0, 319.0,
		449.0, 315.0,
		444.0, 315.0,
		443.0, 311.0,
		447.0, 311.0,
		445.0, 308.0,
		457.0, 302.0,
		455.0, 294.0,
		457.0, 288.0,
		465.0, 282.0,
		470.0, 269.0,
		475.0, 264.0,
		478.0, 250.0,
		481.0, 250.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_333_0;
		g.setTransform(defaultTransform__0_333_0);
		g.setClip(clip__0_333_0);
		origAlpha = alpha__0_333;
		g.setTransform(defaultTransform__0_333);
		g.setClip(clip__0_333);
		float alpha__0_334 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_334 = g.getClip();
		AffineTransform defaultTransform__0_334 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_334 is CompositeGraphicsNode
		float alpha__0_334_0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0_334_0 = g.getClip();
		AffineTransform defaultTransform__0_334_0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
		// _0_334_0 is ShapeNode
		/*paint = new Color(85, 85, 85, 0);
		shape = new GeneralPath();
		shortcut(595.0, 380.0,
		597.0, 382.0,
		592.0, 402.0,
		590.0, 404.0,
		586.0, 403.0,
		584.0, 407.0,
		580.0, 404.0,
		577.0, 404.0,
		583.0, 397.0,
		586.0, 397.0,
		592.0, 385.0,
		591.0, 381.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		*/ paint = new Color(colori[0], colori[1], colori[2], colori[3]);
		stroke = new BasicStroke(spessore, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		shortcut(595.0, 380.0,
		597.0, 382.0,
		592.0, 402.0,
		590.0, 404.0,
		586.0, 403.0,
		584.0, 407.0,
		580.0, 404.0,
		577.0, 404.0,
		583.0, 397.0,
		586.0, 397.0,
		592.0, 385.0,
		591.0, 381.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.setStroke(stroke);
		g.draw(shape);
		origAlpha = alpha__0_334_0;
		g.setTransform(defaultTransform__0_334_0);
		g.setClip(clip__0_334_0);
		origAlpha = alpha__0_334;
		g.setTransform(defaultTransform__0_334);
		g.setClip(clip__0_334);
		origAlpha = alpha__0;
		g.setTransform(defaultTransform__0);
		g.setClip(clip__0);
		g.setTransform(defaultTransform_);
		g.setClip(clip_);
		
	}
	
	public static void shortcut(double... punti) {
		
		((GeneralPath)   shape).moveTo(punti[0], punti[1]);
		for (int k=2; k<punti.length; k+=2) {
			((GeneralPath)   shape).lineTo(punti[k], punti[k+1]);
		}
		
	}
}
