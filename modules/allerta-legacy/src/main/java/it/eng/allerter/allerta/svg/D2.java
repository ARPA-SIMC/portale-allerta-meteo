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
public class D2 {
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
((GeneralPath)shape).moveTo(543.0, 156.0);
((GeneralPath)shape).lineTo(548.0, 157.0);
((GeneralPath)shape).lineTo(551.0, 154.0);
((GeneralPath)shape).lineTo(554.0, 158.0);
((GeneralPath)shape).lineTo(561.0, 159.0);
((GeneralPath)shape).lineTo(563.0, 155.0);
((GeneralPath)shape).lineTo(566.0, 155.0);
((GeneralPath)shape).lineTo(566.0, 153.0);
((GeneralPath)shape).lineTo(567.0, 155.0);
((GeneralPath)shape).lineTo(571.0, 154.0);
((GeneralPath)shape).lineTo(573.0, 158.0);
((GeneralPath)shape).lineTo(571.0, 162.0);
((GeneralPath)shape).lineTo(573.0, 175.0);
((GeneralPath)shape).lineTo(582.0, 177.0);
((GeneralPath)shape).lineTo(584.0, 186.0);
((GeneralPath)shape).lineTo(592.0, 192.0);
((GeneralPath)shape).lineTo(590.0, 194.0);
((GeneralPath)shape).lineTo(576.0, 190.0);
((GeneralPath)shape).lineTo(579.0, 189.0);
((GeneralPath)shape).lineTo(581.0, 186.0);
((GeneralPath)shape).lineTo(577.0, 179.0);
((GeneralPath)shape).lineTo(572.0, 180.0);
((GeneralPath)shape).lineTo(568.0, 185.0);
((GeneralPath)shape).lineTo(567.0, 187.0);
((GeneralPath)shape).lineTo(571.0, 184.0);
((GeneralPath)shape).lineTo(566.0, 199.0);
((GeneralPath)shape).lineTo(564.0, 215.0);
((GeneralPath)shape).lineTo(566.0, 230.0);
((GeneralPath)shape).lineTo(569.0, 234.0);
((GeneralPath)shape).lineTo(563.0, 236.0);
((GeneralPath)shape).lineTo(548.0, 254.0);
((GeneralPath)shape).lineTo(544.0, 238.0);
((GeneralPath)shape).lineTo(512.0, 228.0);
((GeneralPath)shape).lineTo(515.0, 222.0);
((GeneralPath)shape).lineTo(523.0, 224.0);
((GeneralPath)shape).lineTo(541.0, 222.0);
((GeneralPath)shape).lineTo(537.0, 218.0);
((GeneralPath)shape).lineTo(539.0, 211.0);
((GeneralPath)shape).lineTo(537.0, 210.0);
((GeneralPath)shape).lineTo(539.0, 202.0);
((GeneralPath)shape).lineTo(541.0, 203.0);
((GeneralPath)shape).lineTo(540.0, 205.0);
((GeneralPath)shape).lineTo(550.0, 206.0);
((GeneralPath)shape).lineTo(553.0, 199.0);
((GeneralPath)shape).lineTo(551.0, 188.0);
((GeneralPath)shape).lineTo(547.0, 188.0);
((GeneralPath)shape).lineTo(548.0, 191.0);
((GeneralPath)shape).lineTo(546.0, 191.0);
((GeneralPath)shape).lineTo(543.0, 195.0);
((GeneralPath)shape).lineTo(540.0, 189.0);
((GeneralPath)shape).lineTo(538.0, 191.0);
((GeneralPath)shape).lineTo(537.0, 181.0);
((GeneralPath)shape).lineTo(529.0, 181.0);
((GeneralPath)shape).lineTo(527.0, 183.0);
((GeneralPath)shape).lineTo(526.0, 181.0);
((GeneralPath)shape).lineTo(524.0, 181.0);
((GeneralPath)shape).lineTo(521.0, 173.0);
((GeneralPath)shape).lineTo(528.0, 173.0);
((GeneralPath)shape).lineTo(525.0, 167.0);
((GeneralPath)shape).lineTo(526.0, 162.0);
((GeneralPath)shape).lineTo(529.0, 162.0);
((GeneralPath)shape).lineTo(529.0, 157.0);
((GeneralPath)shape).lineTo(536.0, 157.0);
((GeneralPath)shape).lineTo(536.0, 159.0);
((GeneralPath)shape).lineTo(540.0, 158.0);
((GeneralPath)shape).lineTo(540.0, 151.0);
((GeneralPath)shape).lineTo(538.0, 149.0);
((GeneralPath)shape).lineTo(541.0, 149.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(543.0, 156.0);
((GeneralPath)shape).lineTo(548.0, 157.0);
((GeneralPath)shape).lineTo(551.0, 154.0);
((GeneralPath)shape).lineTo(554.0, 158.0);
((GeneralPath)shape).lineTo(561.0, 159.0);
((GeneralPath)shape).lineTo(563.0, 155.0);
((GeneralPath)shape).lineTo(566.0, 155.0);
((GeneralPath)shape).lineTo(566.0, 153.0);
((GeneralPath)shape).lineTo(567.0, 155.0);
((GeneralPath)shape).lineTo(571.0, 154.0);
((GeneralPath)shape).lineTo(573.0, 158.0);
((GeneralPath)shape).lineTo(571.0, 162.0);
((GeneralPath)shape).lineTo(573.0, 175.0);
((GeneralPath)shape).lineTo(582.0, 177.0);
((GeneralPath)shape).lineTo(584.0, 186.0);
((GeneralPath)shape).lineTo(592.0, 192.0);
((GeneralPath)shape).lineTo(590.0, 194.0);
((GeneralPath)shape).lineTo(576.0, 190.0);
((GeneralPath)shape).lineTo(579.0, 189.0);
((GeneralPath)shape).lineTo(581.0, 186.0);
((GeneralPath)shape).lineTo(577.0, 179.0);
((GeneralPath)shape).lineTo(572.0, 180.0);
((GeneralPath)shape).lineTo(568.0, 185.0);
((GeneralPath)shape).lineTo(567.0, 187.0);
((GeneralPath)shape).lineTo(571.0, 184.0);
((GeneralPath)shape).lineTo(566.0, 199.0);
((GeneralPath)shape).lineTo(564.0, 215.0);
((GeneralPath)shape).lineTo(566.0, 230.0);
((GeneralPath)shape).lineTo(569.0, 234.0);
((GeneralPath)shape).lineTo(563.0, 236.0);
((GeneralPath)shape).lineTo(548.0, 254.0);
((GeneralPath)shape).lineTo(544.0, 238.0);
((GeneralPath)shape).lineTo(512.0, 228.0);
((GeneralPath)shape).lineTo(515.0, 222.0);
((GeneralPath)shape).lineTo(523.0, 224.0);
((GeneralPath)shape).lineTo(541.0, 222.0);
((GeneralPath)shape).lineTo(537.0, 218.0);
((GeneralPath)shape).lineTo(539.0, 211.0);
((GeneralPath)shape).lineTo(537.0, 210.0);
((GeneralPath)shape).lineTo(539.0, 202.0);
((GeneralPath)shape).lineTo(541.0, 203.0);
((GeneralPath)shape).lineTo(540.0, 205.0);
((GeneralPath)shape).lineTo(550.0, 206.0);
((GeneralPath)shape).lineTo(553.0, 199.0);
((GeneralPath)shape).lineTo(551.0, 188.0);
((GeneralPath)shape).lineTo(547.0, 188.0);
((GeneralPath)shape).lineTo(548.0, 191.0);
((GeneralPath)shape).lineTo(546.0, 191.0);
((GeneralPath)shape).lineTo(543.0, 195.0);
((GeneralPath)shape).lineTo(540.0, 189.0);
((GeneralPath)shape).lineTo(538.0, 191.0);
((GeneralPath)shape).lineTo(537.0, 181.0);
((GeneralPath)shape).lineTo(529.0, 181.0);
((GeneralPath)shape).lineTo(527.0, 183.0);
((GeneralPath)shape).lineTo(526.0, 181.0);
((GeneralPath)shape).lineTo(524.0, 181.0);
((GeneralPath)shape).lineTo(521.0, 173.0);
((GeneralPath)shape).lineTo(528.0, 173.0);
((GeneralPath)shape).lineTo(525.0, 167.0);
((GeneralPath)shape).lineTo(526.0, 162.0);
((GeneralPath)shape).lineTo(529.0, 162.0);
((GeneralPath)shape).lineTo(529.0, 157.0);
((GeneralPath)shape).lineTo(536.0, 157.0);
((GeneralPath)shape).lineTo(536.0, 159.0);
((GeneralPath)shape).lineTo(540.0, 158.0);
((GeneralPath)shape).lineTo(540.0, 151.0);
((GeneralPath)shape).lineTo(538.0, 149.0);
((GeneralPath)shape).lineTo(541.0, 149.0);
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
        return 691;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 301;
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

