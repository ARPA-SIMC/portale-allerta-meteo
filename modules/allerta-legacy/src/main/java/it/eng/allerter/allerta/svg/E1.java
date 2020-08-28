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
public class E1 {
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
((GeneralPath)shape).moveTo(205.0, 269.0);
((GeneralPath)shape).lineTo(209.0, 271.0);
((GeneralPath)shape).lineTo(211.0, 274.0);
((GeneralPath)shape).lineTo(208.0, 277.0);
((GeneralPath)shape).lineTo(208.0, 279.0);
((GeneralPath)shape).lineTo(214.0, 281.0);
((GeneralPath)shape).lineTo(215.0, 287.0);
((GeneralPath)shape).lineTo(222.0, 293.0);
((GeneralPath)shape).lineTo(223.0, 296.0);
((GeneralPath)shape).lineTo(233.0, 296.0);
((GeneralPath)shape).lineTo(242.0, 290.0);
((GeneralPath)shape).lineTo(250.0, 291.0);
((GeneralPath)shape).lineTo(256.0, 287.0);
((GeneralPath)shape).lineTo(269.0, 291.0);
((GeneralPath)shape).lineTo(269.0, 293.0);
((GeneralPath)shape).lineTo(277.0, 291.0);
((GeneralPath)shape).lineTo(277.0, 295.0);
((GeneralPath)shape).lineTo(281.0, 301.0);
((GeneralPath)shape).lineTo(284.0, 301.0);
((GeneralPath)shape).lineTo(285.0, 310.0);
((GeneralPath)shape).lineTo(287.0, 310.0);
((GeneralPath)shape).lineTo(290.0, 314.0);
((GeneralPath)shape).lineTo(295.0, 311.0);
((GeneralPath)shape).lineTo(298.0, 315.0);
((GeneralPath)shape).lineTo(294.0, 317.0);
((GeneralPath)shape).lineTo(294.0, 319.0);
((GeneralPath)shape).lineTo(299.0, 318.0);
((GeneralPath)shape).lineTo(304.0, 325.0);
((GeneralPath)shape).lineTo(313.0, 326.0);
((GeneralPath)shape).lineTo(318.0, 317.0);
((GeneralPath)shape).lineTo(324.0, 312.0);
((GeneralPath)shape).lineTo(328.0, 314.0);
((GeneralPath)shape).lineTo(335.0, 311.0);
((GeneralPath)shape).lineTo(338.0, 313.0);
((GeneralPath)shape).lineTo(338.0, 316.0);
((GeneralPath)shape).lineTo(328.0, 320.0);
((GeneralPath)shape).lineTo(330.0, 324.0);
((GeneralPath)shape).lineTo(333.0, 324.0);
((GeneralPath)shape).lineTo(331.0, 325.0);
((GeneralPath)shape).lineTo(331.0, 335.0);
((GeneralPath)shape).lineTo(321.0, 342.0);
((GeneralPath)shape).lineTo(318.0, 340.0);
((GeneralPath)shape).lineTo(318.0, 337.0);
((GeneralPath)shape).lineTo(312.0, 335.0);
((GeneralPath)shape).lineTo(310.0, 336.0);
((GeneralPath)shape).lineTo(311.0, 341.0);
((GeneralPath)shape).lineTo(305.0, 348.0);
((GeneralPath)shape).lineTo(302.0, 355.0);
((GeneralPath)shape).lineTo(304.0, 365.0);
((GeneralPath)shape).lineTo(296.0, 360.0);
((GeneralPath)shape).lineTo(293.0, 355.0);
((GeneralPath)shape).lineTo(277.0, 355.0);
((GeneralPath)shape).lineTo(273.0, 353.0);
((GeneralPath)shape).lineTo(269.0, 358.0);
((GeneralPath)shape).lineTo(269.0, 363.0);
((GeneralPath)shape).lineTo(264.0, 365.0);
((GeneralPath)shape).lineTo(261.0, 361.0);
((GeneralPath)shape).lineTo(251.0, 354.0);
((GeneralPath)shape).lineTo(250.0, 348.0);
((GeneralPath)shape).lineTo(244.0, 342.0);
((GeneralPath)shape).lineTo(244.0, 337.0);
((GeneralPath)shape).lineTo(240.0, 335.0);
((GeneralPath)shape).lineTo(234.0, 336.0);
((GeneralPath)shape).lineTo(224.0, 325.0);
((GeneralPath)shape).lineTo(218.0, 326.0);
((GeneralPath)shape).lineTo(210.0, 321.0);
((GeneralPath)shape).lineTo(202.0, 326.0);
((GeneralPath)shape).lineTo(197.0, 318.0);
((GeneralPath)shape).lineTo(190.0, 314.0);
((GeneralPath)shape).lineTo(182.0, 304.0);
((GeneralPath)shape).lineTo(174.0, 306.0);
((GeneralPath)shape).lineTo(165.0, 299.0);
((GeneralPath)shape).lineTo(169.0, 286.0);
((GeneralPath)shape).lineTo(172.0, 285.0);
((GeneralPath)shape).lineTo(174.0, 282.0);
((GeneralPath)shape).lineTo(177.0, 283.0);
((GeneralPath)shape).lineTo(183.0, 275.0);
((GeneralPath)shape).lineTo(188.0, 276.0);
((GeneralPath)shape).lineTo(197.0, 274.0);
((GeneralPath)shape).lineTo(200.0, 270.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(205.0, 269.0);
((GeneralPath)shape).lineTo(209.0, 271.0);
((GeneralPath)shape).lineTo(211.0, 274.0);
((GeneralPath)shape).lineTo(208.0, 277.0);
((GeneralPath)shape).lineTo(208.0, 279.0);
((GeneralPath)shape).lineTo(214.0, 281.0);
((GeneralPath)shape).lineTo(215.0, 287.0);
((GeneralPath)shape).lineTo(222.0, 293.0);
((GeneralPath)shape).lineTo(223.0, 296.0);
((GeneralPath)shape).lineTo(233.0, 296.0);
((GeneralPath)shape).lineTo(242.0, 290.0);
((GeneralPath)shape).lineTo(250.0, 291.0);
((GeneralPath)shape).lineTo(256.0, 287.0);
((GeneralPath)shape).lineTo(269.0, 291.0);
((GeneralPath)shape).lineTo(269.0, 293.0);
((GeneralPath)shape).lineTo(277.0, 291.0);
((GeneralPath)shape).lineTo(277.0, 295.0);
((GeneralPath)shape).lineTo(281.0, 301.0);
((GeneralPath)shape).lineTo(284.0, 301.0);
((GeneralPath)shape).lineTo(285.0, 310.0);
((GeneralPath)shape).lineTo(287.0, 310.0);
((GeneralPath)shape).lineTo(290.0, 314.0);
((GeneralPath)shape).lineTo(295.0, 311.0);
((GeneralPath)shape).lineTo(298.0, 315.0);
((GeneralPath)shape).lineTo(294.0, 317.0);
((GeneralPath)shape).lineTo(294.0, 319.0);
((GeneralPath)shape).lineTo(299.0, 318.0);
((GeneralPath)shape).lineTo(304.0, 325.0);
((GeneralPath)shape).lineTo(313.0, 326.0);
((GeneralPath)shape).lineTo(318.0, 317.0);
((GeneralPath)shape).lineTo(324.0, 312.0);
((GeneralPath)shape).lineTo(328.0, 314.0);
((GeneralPath)shape).lineTo(335.0, 311.0);
((GeneralPath)shape).lineTo(338.0, 313.0);
((GeneralPath)shape).lineTo(338.0, 316.0);
((GeneralPath)shape).lineTo(328.0, 320.0);
((GeneralPath)shape).lineTo(330.0, 324.0);
((GeneralPath)shape).lineTo(333.0, 324.0);
((GeneralPath)shape).lineTo(331.0, 325.0);
((GeneralPath)shape).lineTo(331.0, 335.0);
((GeneralPath)shape).lineTo(321.0, 342.0);
((GeneralPath)shape).lineTo(318.0, 340.0);
((GeneralPath)shape).lineTo(318.0, 337.0);
((GeneralPath)shape).lineTo(312.0, 335.0);
((GeneralPath)shape).lineTo(310.0, 336.0);
((GeneralPath)shape).lineTo(311.0, 341.0);
((GeneralPath)shape).lineTo(305.0, 348.0);
((GeneralPath)shape).lineTo(302.0, 355.0);
((GeneralPath)shape).lineTo(304.0, 365.0);
((GeneralPath)shape).lineTo(296.0, 360.0);
((GeneralPath)shape).lineTo(293.0, 355.0);
((GeneralPath)shape).lineTo(277.0, 355.0);
((GeneralPath)shape).lineTo(273.0, 353.0);
((GeneralPath)shape).lineTo(269.0, 358.0);
((GeneralPath)shape).lineTo(269.0, 363.0);
((GeneralPath)shape).lineTo(264.0, 365.0);
((GeneralPath)shape).lineTo(261.0, 361.0);
((GeneralPath)shape).lineTo(251.0, 354.0);
((GeneralPath)shape).lineTo(250.0, 348.0);
((GeneralPath)shape).lineTo(244.0, 342.0);
((GeneralPath)shape).lineTo(244.0, 337.0);
((GeneralPath)shape).lineTo(240.0, 335.0);
((GeneralPath)shape).lineTo(234.0, 336.0);
((GeneralPath)shape).lineTo(224.0, 325.0);
((GeneralPath)shape).lineTo(218.0, 326.0);
((GeneralPath)shape).lineTo(210.0, 321.0);
((GeneralPath)shape).lineTo(202.0, 326.0);
((GeneralPath)shape).lineTo(197.0, 318.0);
((GeneralPath)shape).lineTo(190.0, 314.0);
((GeneralPath)shape).lineTo(182.0, 304.0);
((GeneralPath)shape).lineTo(174.0, 306.0);
((GeneralPath)shape).lineTo(165.0, 299.0);
((GeneralPath)shape).lineTo(169.0, 286.0);
((GeneralPath)shape).lineTo(172.0, 285.0);
((GeneralPath)shape).lineTo(174.0, 282.0);
((GeneralPath)shape).lineTo(177.0, 283.0);
((GeneralPath)shape).lineTo(183.0, 275.0);
((GeneralPath)shape).lineTo(188.0, 276.0);
((GeneralPath)shape).lineTo(197.0, 274.0);
((GeneralPath)shape).lineTo(200.0, 270.0);
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
        return 344;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 421;
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

