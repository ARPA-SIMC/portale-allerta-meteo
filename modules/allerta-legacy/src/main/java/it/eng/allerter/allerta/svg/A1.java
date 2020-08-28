package it.eng.allerter.allerta.svg;


import java.awt.*;
import java.awt.geom.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class has been automatically generated using <a
 * href="http://englishjavadrinker.blogspot.com/search/label/SVGRoundTrip">SVGRoundTrip</a>.
 */
@SuppressWarnings("unused")
public class A1 {
	/**
	 * Paints the transcoded SVG image on the specified graphics context. You
	 * can install a custom transformation on the graphics context to scale the
	 * image.
	 * 
	 * @param g 
	 *            Graphics context.
	 */
	public static void paint(Graphics2D g, int[] colori, int[] colori2) {
        Shape shape = null;
        Paint paint = null;
        Stroke stroke = null;
        Area clip = null;
        
        float origAlpha = 1.0f;
        Composite origComposite = ((Graphics2D)g).getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
        Shape clip_ = g.getClip();
AffineTransform defaultTransform_ = g.getTransform();
//  is CompositeGraphicsNode
float alpha__0 = origAlpha;
origAlpha = origAlpha * 1.0f;
g.setComposite(AlphaComposite.getInstance(3, origAlpha));
Shape clip__0 = g.getClip();
AffineTransform defaultTransform__0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 180.0f, 153.0f));
clip = new Area(g.getClip());
clip.intersect(new Area(new Rectangle2D.Double(-180.0,-153.0,1026.0,870.0)));
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
paint = new Color(colori[0], colori[1], colori[2], colori[3]);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(477.0, 383.0);
((GeneralPath)shape).lineTo(479.0, 385.0);
((GeneralPath)shape).lineTo(479.0, 381.0);
((GeneralPath)shape).lineTo(481.0, 381.0);
((GeneralPath)shape).lineTo(483.0, 390.0);
((GeneralPath)shape).lineTo(485.0, 391.0);
((GeneralPath)shape).lineTo(495.0, 385.0);
((GeneralPath)shape).lineTo(492.0, 389.0);
((GeneralPath)shape).lineTo(496.0, 396.0);
((GeneralPath)shape).lineTo(496.0, 400.0);
((GeneralPath)shape).lineTo(507.0, 405.0);
((GeneralPath)shape).lineTo(513.0, 412.0);
((GeneralPath)shape).lineTo(520.0, 405.0);
((GeneralPath)shape).lineTo(523.0, 408.0);
((GeneralPath)shape).lineTo(528.0, 408.0);
((GeneralPath)shape).lineTo(530.0, 412.0);
((GeneralPath)shape).lineTo(540.0, 407.0);
((GeneralPath)shape).lineTo(540.0, 412.0);
((GeneralPath)shape).lineTo(535.0, 413.0);
((GeneralPath)shape).lineTo(532.0, 422.0);
((GeneralPath)shape).lineTo(534.0, 422.0);
((GeneralPath)shape).lineTo(536.0, 431.0);
((GeneralPath)shape).lineTo(543.0, 430.0);
((GeneralPath)shape).lineTo(554.0, 443.0);
((GeneralPath)shape).lineTo(560.0, 443.0);
((GeneralPath)shape).lineTo(567.0, 436.0);
((GeneralPath)shape).lineTo(570.0, 430.0);
((GeneralPath)shape).lineTo(574.0, 433.0);
((GeneralPath)shape).lineTo(579.0, 428.0);
((GeneralPath)shape).lineTo(583.0, 428.0);
((GeneralPath)shape).lineTo(581.0, 438.0);
((GeneralPath)shape).lineTo(577.0, 443.0);
((GeneralPath)shape).lineTo(572.0, 446.0);
((GeneralPath)shape).lineTo(571.0, 453.0);
((GeneralPath)shape).lineTo(566.0, 454.0);
((GeneralPath)shape).lineTo(564.0, 457.0);
((GeneralPath)shape).lineTo(558.0, 455.0);
((GeneralPath)shape).lineTo(555.0, 462.0);
((GeneralPath)shape).lineTo(550.0, 454.0);
((GeneralPath)shape).lineTo(546.0, 456.0);
((GeneralPath)shape).lineTo(539.0, 456.0);
((GeneralPath)shape).lineTo(533.0, 459.0);
((GeneralPath)shape).lineTo(529.0, 455.0);
((GeneralPath)shape).lineTo(527.0, 456.0);
((GeneralPath)shape).lineTo(521.0, 453.0);
((GeneralPath)shape).lineTo(517.0, 454.0);
((GeneralPath)shape).lineTo(511.0, 450.0);
((GeneralPath)shape).lineTo(510.0, 447.0);
((GeneralPath)shape).lineTo(505.0, 446.0);
((GeneralPath)shape).lineTo(503.0, 441.0);
((GeneralPath)shape).lineTo(499.0, 442.0);
((GeneralPath)shape).lineTo(496.0, 440.0);
((GeneralPath)shape).lineTo(491.0, 442.0);
((GeneralPath)shape).lineTo(487.0, 440.0);
((GeneralPath)shape).lineTo(481.0, 433.0);
((GeneralPath)shape).lineTo(471.0, 429.0);
((GeneralPath)shape).lineTo(467.0, 425.0);
((GeneralPath)shape).lineTo(468.0, 414.0);
((GeneralPath)shape).lineTo(462.0, 410.0);
((GeneralPath)shape).lineTo(463.0, 405.0);
((GeneralPath)shape).lineTo(455.0, 397.0);
((GeneralPath)shape).lineTo(456.0, 393.0);
((GeneralPath)shape).lineTo(459.0, 393.0);
((GeneralPath)shape).lineTo(458.0, 389.0);
((GeneralPath)shape).lineTo(470.0, 390.0);
((GeneralPath)shape).lineTo(470.0, 387.0);
((GeneralPath)shape).lineTo(475.0, 387.0);
((GeneralPath)shape).lineTo(477.0, 380.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(477.0, 383.0);
((GeneralPath)shape).lineTo(479.0, 385.0);
((GeneralPath)shape).lineTo(479.0, 381.0);
((GeneralPath)shape).lineTo(481.0, 381.0);
((GeneralPath)shape).lineTo(483.0, 390.0);
((GeneralPath)shape).lineTo(485.0, 391.0);
((GeneralPath)shape).lineTo(495.0, 385.0);
((GeneralPath)shape).lineTo(492.0, 389.0);
((GeneralPath)shape).lineTo(496.0, 396.0);
((GeneralPath)shape).lineTo(496.0, 400.0);
((GeneralPath)shape).lineTo(507.0, 405.0);
((GeneralPath)shape).lineTo(513.0, 412.0);
((GeneralPath)shape).lineTo(520.0, 405.0);
((GeneralPath)shape).lineTo(523.0, 408.0);
((GeneralPath)shape).lineTo(528.0, 408.0);
((GeneralPath)shape).lineTo(530.0, 412.0);
((GeneralPath)shape).lineTo(540.0, 407.0);
((GeneralPath)shape).lineTo(540.0, 412.0);
((GeneralPath)shape).lineTo(535.0, 413.0);
((GeneralPath)shape).lineTo(532.0, 422.0);
((GeneralPath)shape).lineTo(534.0, 422.0);
((GeneralPath)shape).lineTo(536.0, 431.0);
((GeneralPath)shape).lineTo(543.0, 430.0);
((GeneralPath)shape).lineTo(554.0, 443.0);
((GeneralPath)shape).lineTo(560.0, 443.0);
((GeneralPath)shape).lineTo(567.0, 436.0);
((GeneralPath)shape).lineTo(570.0, 430.0);
((GeneralPath)shape).lineTo(574.0, 433.0);
((GeneralPath)shape).lineTo(579.0, 428.0);
((GeneralPath)shape).lineTo(583.0, 428.0);
((GeneralPath)shape).lineTo(581.0, 438.0);
((GeneralPath)shape).lineTo(577.0, 443.0);
((GeneralPath)shape).lineTo(572.0, 446.0);
((GeneralPath)shape).lineTo(571.0, 453.0);
((GeneralPath)shape).lineTo(566.0, 454.0);
((GeneralPath)shape).lineTo(564.0, 457.0);
((GeneralPath)shape).lineTo(558.0, 455.0);
((GeneralPath)shape).lineTo(555.0, 462.0);
((GeneralPath)shape).lineTo(550.0, 454.0);
((GeneralPath)shape).lineTo(546.0, 456.0);
((GeneralPath)shape).lineTo(539.0, 456.0);
((GeneralPath)shape).lineTo(533.0, 459.0);
((GeneralPath)shape).lineTo(529.0, 455.0);
((GeneralPath)shape).lineTo(527.0, 456.0);
((GeneralPath)shape).lineTo(521.0, 453.0);
((GeneralPath)shape).lineTo(517.0, 454.0);
((GeneralPath)shape).lineTo(511.0, 450.0);
((GeneralPath)shape).lineTo(510.0, 447.0);
((GeneralPath)shape).lineTo(505.0, 446.0);
((GeneralPath)shape).lineTo(503.0, 441.0);
((GeneralPath)shape).lineTo(499.0, 442.0);
((GeneralPath)shape).lineTo(496.0, 440.0);
((GeneralPath)shape).lineTo(491.0, 442.0);
((GeneralPath)shape).lineTo(487.0, 440.0);
((GeneralPath)shape).lineTo(481.0, 433.0);
((GeneralPath)shape).lineTo(471.0, 429.0);
((GeneralPath)shape).lineTo(467.0, 425.0);
((GeneralPath)shape).lineTo(468.0, 414.0);
((GeneralPath)shape).lineTo(462.0, 410.0);
((GeneralPath)shape).lineTo(463.0, 405.0);
((GeneralPath)shape).lineTo(455.0, 397.0);
((GeneralPath)shape).lineTo(456.0, 393.0);
((GeneralPath)shape).lineTo(459.0, 393.0);
((GeneralPath)shape).lineTo(458.0, 389.0);
((GeneralPath)shape).lineTo(470.0, 390.0);
((GeneralPath)shape).lineTo(470.0, 387.0);
((GeneralPath)shape).lineTo(475.0, 387.0);
((GeneralPath)shape).lineTo(477.0, 380.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
origAlpha = alpha__0_0_0;
g.setTransform(defaultTransform__0_0_0);
g.setClip(clip__0_0_0);
origAlpha = alpha__0_0;
g.setTransform(defaultTransform__0_0);
g.setClip(clip__0_0);
origAlpha = alpha__0;
g.setTransform(defaultTransform__0);
g.setClip(clip__0);
g.setTransform(defaultTransform_);
g.setClip(clip_);

	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 634;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 532;
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
}

