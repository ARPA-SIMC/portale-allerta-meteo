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
public class B2 {
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
((GeneralPath)shape).moveTo(571.0, 255.0);
((GeneralPath)shape).lineTo(571.0, 267.0);
((GeneralPath)shape).lineTo(577.0, 267.0);
((GeneralPath)shape).lineTo(571.0, 268.0);
((GeneralPath)shape).lineTo(573.0, 269.0);
((GeneralPath)shape).lineTo(571.0, 270.0);
((GeneralPath)shape).lineTo(577.0, 268.0);
((GeneralPath)shape).lineTo(572.0, 270.0);
((GeneralPath)shape).lineTo(572.0, 275.0);
((GeneralPath)shape).lineTo(578.0, 291.0);
((GeneralPath)shape).lineTo(579.0, 303.0);
((GeneralPath)shape).lineTo(584.0, 324.0);
((GeneralPath)shape).lineTo(590.0, 338.0);
((GeneralPath)shape).lineTo(613.0, 366.0);
((GeneralPath)shape).lineTo(621.0, 374.0);
((GeneralPath)shape).lineTo(625.0, 374.0);
((GeneralPath)shape).lineTo(638.0, 391.0);
((GeneralPath)shape).lineTo(651.0, 401.0);
((GeneralPath)shape).lineTo(656.0, 401.0);
((GeneralPath)shape).lineTo(657.0, 404.0);
((GeneralPath)shape).lineTo(655.0, 409.0);
((GeneralPath)shape).lineTo(651.0, 406.0);
((GeneralPath)shape).lineTo(653.0, 404.0);
((GeneralPath)shape).lineTo(649.0, 405.0);
((GeneralPath)shape).lineTo(648.0, 403.0);
((GeneralPath)shape).lineTo(644.0, 407.0);
((GeneralPath)shape).lineTo(643.0, 411.0);
((GeneralPath)shape).lineTo(639.0, 408.0);
((GeneralPath)shape).lineTo(636.0, 408.0);
((GeneralPath)shape).lineTo(635.0, 405.0);
((GeneralPath)shape).lineTo(637.0, 403.0);
((GeneralPath)shape).lineTo(635.0, 401.0);
((GeneralPath)shape).lineTo(637.0, 399.0);
((GeneralPath)shape).lineTo(635.0, 396.0);
((GeneralPath)shape).lineTo(630.0, 396.0);
((GeneralPath)shape).lineTo(626.0, 399.0);
((GeneralPath)shape).lineTo(624.0, 395.0);
((GeneralPath)shape).lineTo(620.0, 397.0);
((GeneralPath)shape).lineTo(618.0, 395.0);
((GeneralPath)shape).lineTo(602.0, 402.0);
((GeneralPath)shape).lineTo(601.0, 399.0);
((GeneralPath)shape).lineTo(604.0, 394.0);
((GeneralPath)shape).lineTo(600.0, 389.0);
((GeneralPath)shape).lineTo(603.0, 386.0);
((GeneralPath)shape).lineTo(607.0, 391.0);
((GeneralPath)shape).lineTo(611.0, 387.0);
((GeneralPath)shape).lineTo(608.0, 383.0);
((GeneralPath)shape).lineTo(604.0, 382.0);
((GeneralPath)shape).lineTo(607.0, 377.0);
((GeneralPath)shape).lineTo(602.0, 372.0);
((GeneralPath)shape).lineTo(597.0, 372.0);
((GeneralPath)shape).lineTo(591.0, 378.0);
((GeneralPath)shape).lineTo(586.0, 376.0);
((GeneralPath)shape).lineTo(588.0, 369.0);
((GeneralPath)shape).lineTo(586.0, 356.0);
((GeneralPath)shape).lineTo(581.0, 357.0);
((GeneralPath)shape).lineTo(583.0, 355.0);
((GeneralPath)shape).lineTo(581.0, 354.0);
((GeneralPath)shape).lineTo(580.0, 349.0);
((GeneralPath)shape).lineTo(583.0, 346.0);
((GeneralPath)shape).lineTo(571.0, 335.0);
((GeneralPath)shape).lineTo(565.0, 335.0);
((GeneralPath)shape).lineTo(563.0, 339.0);
((GeneralPath)shape).lineTo(559.0, 340.0);
((GeneralPath)shape).lineTo(556.0, 336.0);
((GeneralPath)shape).lineTo(558.0, 329.0);
((GeneralPath)shape).lineTo(554.0, 329.0);
((GeneralPath)shape).lineTo(551.0, 332.0);
((GeneralPath)shape).lineTo(539.0, 325.0);
((GeneralPath)shape).lineTo(539.0, 321.0);
((GeneralPath)shape).lineTo(537.0, 319.0);
((GeneralPath)shape).lineTo(532.0, 318.0);
((GeneralPath)shape).lineTo(529.0, 315.0);
((GeneralPath)shape).lineTo(529.0, 311.0);
((GeneralPath)shape).lineTo(526.0, 310.0);
((GeneralPath)shape).lineTo(539.0, 302.0);
((GeneralPath)shape).lineTo(533.0, 300.0);
((GeneralPath)shape).lineTo(537.0, 300.0);
((GeneralPath)shape).lineTo(539.0, 295.0);
((GeneralPath)shape).lineTo(525.0, 289.0);
((GeneralPath)shape).lineTo(527.0, 283.0);
((GeneralPath)shape).lineTo(534.0, 275.0);
((GeneralPath)shape).lineTo(532.0, 269.0);
((GeneralPath)shape).lineTo(539.0, 256.0);
((GeneralPath)shape).lineTo(548.0, 254.0);
((GeneralPath)shape).lineTo(563.0, 236.0);
((GeneralPath)shape).lineTo(569.0, 234.0);
((GeneralPath)shape).lineTo(572.0, 245.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(571.0, 255.0);
((GeneralPath)shape).lineTo(571.0, 267.0);
((GeneralPath)shape).lineTo(577.0, 267.0);
((GeneralPath)shape).lineTo(571.0, 268.0);
((GeneralPath)shape).lineTo(573.0, 269.0);
((GeneralPath)shape).lineTo(571.0, 270.0);
((GeneralPath)shape).lineTo(577.0, 268.0);
((GeneralPath)shape).lineTo(572.0, 270.0);
((GeneralPath)shape).lineTo(572.0, 275.0);
((GeneralPath)shape).lineTo(578.0, 291.0);
((GeneralPath)shape).lineTo(579.0, 303.0);
((GeneralPath)shape).lineTo(584.0, 324.0);
((GeneralPath)shape).lineTo(590.0, 338.0);
((GeneralPath)shape).lineTo(613.0, 366.0);
((GeneralPath)shape).lineTo(621.0, 374.0);
((GeneralPath)shape).lineTo(625.0, 374.0);
((GeneralPath)shape).lineTo(638.0, 391.0);
((GeneralPath)shape).lineTo(651.0, 401.0);
((GeneralPath)shape).lineTo(656.0, 401.0);
((GeneralPath)shape).lineTo(657.0, 404.0);
((GeneralPath)shape).lineTo(655.0, 409.0);
((GeneralPath)shape).lineTo(651.0, 406.0);
((GeneralPath)shape).lineTo(653.0, 404.0);
((GeneralPath)shape).lineTo(649.0, 405.0);
((GeneralPath)shape).lineTo(648.0, 403.0);
((GeneralPath)shape).lineTo(644.0, 407.0);
((GeneralPath)shape).lineTo(643.0, 411.0);
((GeneralPath)shape).lineTo(639.0, 408.0);
((GeneralPath)shape).lineTo(636.0, 408.0);
((GeneralPath)shape).lineTo(635.0, 405.0);
((GeneralPath)shape).lineTo(637.0, 403.0);
((GeneralPath)shape).lineTo(635.0, 401.0);
((GeneralPath)shape).lineTo(637.0, 399.0);
((GeneralPath)shape).lineTo(635.0, 396.0);
((GeneralPath)shape).lineTo(630.0, 396.0);
((GeneralPath)shape).lineTo(626.0, 399.0);
((GeneralPath)shape).lineTo(624.0, 395.0);
((GeneralPath)shape).lineTo(620.0, 397.0);
((GeneralPath)shape).lineTo(618.0, 395.0);
((GeneralPath)shape).lineTo(602.0, 402.0);
((GeneralPath)shape).lineTo(601.0, 399.0);
((GeneralPath)shape).lineTo(604.0, 394.0);
((GeneralPath)shape).lineTo(600.0, 389.0);
((GeneralPath)shape).lineTo(603.0, 386.0);
((GeneralPath)shape).lineTo(607.0, 391.0);
((GeneralPath)shape).lineTo(611.0, 387.0);
((GeneralPath)shape).lineTo(608.0, 383.0);
((GeneralPath)shape).lineTo(604.0, 382.0);
((GeneralPath)shape).lineTo(607.0, 377.0);
((GeneralPath)shape).lineTo(602.0, 372.0);
((GeneralPath)shape).lineTo(597.0, 372.0);
((GeneralPath)shape).lineTo(591.0, 378.0);
((GeneralPath)shape).lineTo(586.0, 376.0);
((GeneralPath)shape).lineTo(588.0, 369.0);
((GeneralPath)shape).lineTo(586.0, 356.0);
((GeneralPath)shape).lineTo(581.0, 357.0);
((GeneralPath)shape).lineTo(583.0, 355.0);
((GeneralPath)shape).lineTo(581.0, 354.0);
((GeneralPath)shape).lineTo(580.0, 349.0);
((GeneralPath)shape).lineTo(583.0, 346.0);
((GeneralPath)shape).lineTo(571.0, 335.0);
((GeneralPath)shape).lineTo(565.0, 335.0);
((GeneralPath)shape).lineTo(563.0, 339.0);
((GeneralPath)shape).lineTo(559.0, 340.0);
((GeneralPath)shape).lineTo(556.0, 336.0);
((GeneralPath)shape).lineTo(558.0, 329.0);
((GeneralPath)shape).lineTo(554.0, 329.0);
((GeneralPath)shape).lineTo(551.0, 332.0);
((GeneralPath)shape).lineTo(539.0, 325.0);
((GeneralPath)shape).lineTo(539.0, 321.0);
((GeneralPath)shape).lineTo(537.0, 319.0);
((GeneralPath)shape).lineTo(532.0, 318.0);
((GeneralPath)shape).lineTo(529.0, 315.0);
((GeneralPath)shape).lineTo(529.0, 311.0);
((GeneralPath)shape).lineTo(526.0, 310.0);
((GeneralPath)shape).lineTo(539.0, 302.0);
((GeneralPath)shape).lineTo(533.0, 300.0);
((GeneralPath)shape).lineTo(537.0, 300.0);
((GeneralPath)shape).lineTo(539.0, 295.0);
((GeneralPath)shape).lineTo(525.0, 289.0);
((GeneralPath)shape).lineTo(527.0, 283.0);
((GeneralPath)shape).lineTo(534.0, 275.0);
((GeneralPath)shape).lineTo(532.0, 269.0);
((GeneralPath)shape).lineTo(539.0, 256.0);
((GeneralPath)shape).lineTo(548.0, 254.0);
((GeneralPath)shape).lineTo(563.0, 236.0);
((GeneralPath)shape).lineTo(569.0, 234.0);
((GeneralPath)shape).lineTo(572.0, 245.0);
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
        return 704;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 386;
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

