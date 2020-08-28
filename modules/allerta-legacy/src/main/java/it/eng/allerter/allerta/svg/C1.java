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
public class C1 {
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
((GeneralPath)shape).moveTo(343.0, 312.0);
((GeneralPath)shape).lineTo(345.0, 313.0);
((GeneralPath)shape).lineTo(344.0, 318.0);
((GeneralPath)shape).lineTo(351.0, 321.0);
((GeneralPath)shape).lineTo(353.0, 324.0);
((GeneralPath)shape).lineTo(347.0, 329.0);
((GeneralPath)shape).lineTo(343.0, 341.0);
((GeneralPath)shape).lineTo(347.0, 343.0);
((GeneralPath)shape).lineTo(349.0, 340.0);
((GeneralPath)shape).lineTo(363.0, 343.0);
((GeneralPath)shape).lineTo(367.0, 341.0);
((GeneralPath)shape).lineTo(367.0, 335.0);
((GeneralPath)shape).lineTo(371.0, 334.0);
((GeneralPath)shape).lineTo(371.0, 331.0);
((GeneralPath)shape).lineTo(374.0, 332.0);
((GeneralPath)shape).lineTo(376.0, 330.0);
((GeneralPath)shape).lineTo(378.0, 331.0);
((GeneralPath)shape).lineTo(378.0, 333.0);
((GeneralPath)shape).lineTo(384.0, 336.0);
((GeneralPath)shape).lineTo(385.0, 334.0);
((GeneralPath)shape).lineTo(387.0, 335.0);
((GeneralPath)shape).lineTo(390.0, 329.0);
((GeneralPath)shape).lineTo(398.0, 334.0);
((GeneralPath)shape).lineTo(399.0, 332.0);
((GeneralPath)shape).lineTo(404.0, 331.0);
((GeneralPath)shape).lineTo(408.0, 342.0);
((GeneralPath)shape).lineTo(400.0, 342.0);
((GeneralPath)shape).lineTo(396.0, 348.0);
((GeneralPath)shape).lineTo(391.0, 350.0);
((GeneralPath)shape).lineTo(389.0, 355.0);
((GeneralPath)shape).lineTo(381.0, 354.0);
((GeneralPath)shape).lineTo(373.0, 356.0);
((GeneralPath)shape).lineTo(373.0, 358.0);
((GeneralPath)shape).lineTo(385.0, 365.0);
((GeneralPath)shape).lineTo(386.0, 367.0);
((GeneralPath)shape).lineTo(383.0, 369.0);
((GeneralPath)shape).lineTo(375.0, 369.0);
((GeneralPath)shape).lineTo(367.0, 365.0);
((GeneralPath)shape).lineTo(361.0, 366.0);
((GeneralPath)shape).lineTo(354.0, 371.0);
((GeneralPath)shape).lineTo(347.0, 371.0);
((GeneralPath)shape).lineTo(338.0, 366.0);
((GeneralPath)shape).lineTo(340.0, 359.0);
((GeneralPath)shape).lineTo(334.0, 363.0);
((GeneralPath)shape).lineTo(328.0, 373.0);
((GeneralPath)shape).lineTo(324.0, 375.0);
((GeneralPath)shape).lineTo(323.0, 378.0);
((GeneralPath)shape).lineTo(320.0, 378.0);
((GeneralPath)shape).lineTo(320.0, 372.0);
((GeneralPath)shape).lineTo(315.0, 369.0);
((GeneralPath)shape).lineTo(310.0, 369.0);
((GeneralPath)shape).lineTo(307.0, 364.0);
((GeneralPath)shape).lineTo(304.0, 365.0);
((GeneralPath)shape).lineTo(302.0, 359.0);
((GeneralPath)shape).lineTo(305.0, 348.0);
((GeneralPath)shape).lineTo(311.0, 341.0);
((GeneralPath)shape).lineTo(310.0, 336.0);
((GeneralPath)shape).lineTo(312.0, 335.0);
((GeneralPath)shape).lineTo(318.0, 337.0);
((GeneralPath)shape).lineTo(318.0, 340.0);
((GeneralPath)shape).lineTo(321.0, 342.0);
((GeneralPath)shape).lineTo(326.0, 337.0);
((GeneralPath)shape).lineTo(330.0, 337.0);
((GeneralPath)shape).lineTo(332.0, 332.0);
((GeneralPath)shape).lineTo(331.0, 325.0);
((GeneralPath)shape).lineTo(333.0, 324.0);
((GeneralPath)shape).lineTo(330.0, 324.0);
((GeneralPath)shape).lineTo(328.0, 320.0);
((GeneralPath)shape).lineTo(338.0, 316.0);
((GeneralPath)shape).lineTo(339.0, 318.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(343.0, 312.0);
((GeneralPath)shape).lineTo(345.0, 313.0);
((GeneralPath)shape).lineTo(344.0, 318.0);
((GeneralPath)shape).lineTo(351.0, 321.0);
((GeneralPath)shape).lineTo(353.0, 324.0);
((GeneralPath)shape).lineTo(347.0, 329.0);
((GeneralPath)shape).lineTo(343.0, 341.0);
((GeneralPath)shape).lineTo(347.0, 343.0);
((GeneralPath)shape).lineTo(349.0, 340.0);
((GeneralPath)shape).lineTo(363.0, 343.0);
((GeneralPath)shape).lineTo(367.0, 341.0);
((GeneralPath)shape).lineTo(367.0, 335.0);
((GeneralPath)shape).lineTo(371.0, 334.0);
((GeneralPath)shape).lineTo(371.0, 331.0);
((GeneralPath)shape).lineTo(374.0, 332.0);
((GeneralPath)shape).lineTo(376.0, 330.0);
((GeneralPath)shape).lineTo(378.0, 331.0);
((GeneralPath)shape).lineTo(378.0, 333.0);
((GeneralPath)shape).lineTo(384.0, 336.0);
((GeneralPath)shape).lineTo(385.0, 334.0);
((GeneralPath)shape).lineTo(387.0, 335.0);
((GeneralPath)shape).lineTo(390.0, 329.0);
((GeneralPath)shape).lineTo(398.0, 334.0);
((GeneralPath)shape).lineTo(399.0, 332.0);
((GeneralPath)shape).lineTo(404.0, 331.0);
((GeneralPath)shape).lineTo(408.0, 342.0);
((GeneralPath)shape).lineTo(400.0, 342.0);
((GeneralPath)shape).lineTo(396.0, 348.0);
((GeneralPath)shape).lineTo(391.0, 350.0);
((GeneralPath)shape).lineTo(389.0, 355.0);
((GeneralPath)shape).lineTo(381.0, 354.0);
((GeneralPath)shape).lineTo(373.0, 356.0);
((GeneralPath)shape).lineTo(373.0, 358.0);
((GeneralPath)shape).lineTo(385.0, 365.0);
((GeneralPath)shape).lineTo(386.0, 367.0);
((GeneralPath)shape).lineTo(383.0, 369.0);
((GeneralPath)shape).lineTo(375.0, 369.0);
((GeneralPath)shape).lineTo(367.0, 365.0);
((GeneralPath)shape).lineTo(361.0, 366.0);
((GeneralPath)shape).lineTo(354.0, 371.0);
((GeneralPath)shape).lineTo(347.0, 371.0);
((GeneralPath)shape).lineTo(338.0, 366.0);
((GeneralPath)shape).lineTo(340.0, 359.0);
((GeneralPath)shape).lineTo(334.0, 363.0);
((GeneralPath)shape).lineTo(328.0, 373.0);
((GeneralPath)shape).lineTo(324.0, 375.0);
((GeneralPath)shape).lineTo(323.0, 378.0);
((GeneralPath)shape).lineTo(320.0, 378.0);
((GeneralPath)shape).lineTo(320.0, 372.0);
((GeneralPath)shape).lineTo(315.0, 369.0);
((GeneralPath)shape).lineTo(310.0, 369.0);
((GeneralPath)shape).lineTo(307.0, 364.0);
((GeneralPath)shape).lineTo(304.0, 365.0);
((GeneralPath)shape).lineTo(302.0, 359.0);
((GeneralPath)shape).lineTo(305.0, 348.0);
((GeneralPath)shape).lineTo(311.0, 341.0);
((GeneralPath)shape).lineTo(310.0, 336.0);
((GeneralPath)shape).lineTo(312.0, 335.0);
((GeneralPath)shape).lineTo(318.0, 337.0);
((GeneralPath)shape).lineTo(318.0, 340.0);
((GeneralPath)shape).lineTo(321.0, 342.0);
((GeneralPath)shape).lineTo(326.0, 337.0);
((GeneralPath)shape).lineTo(330.0, 337.0);
((GeneralPath)shape).lineTo(332.0, 332.0);
((GeneralPath)shape).lineTo(331.0, 325.0);
((GeneralPath)shape).lineTo(333.0, 324.0);
((GeneralPath)shape).lineTo(330.0, 324.0);
((GeneralPath)shape).lineTo(328.0, 320.0);
((GeneralPath)shape).lineTo(338.0, 316.0);
((GeneralPath)shape).lineTo(339.0, 318.0);
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
        return 481;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 464;
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

