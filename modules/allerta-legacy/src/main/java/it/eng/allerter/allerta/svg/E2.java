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
public class E2 {
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
((GeneralPath)shape).moveTo(220.0, 220.0);
((GeneralPath)shape).lineTo(221.0, 223.0);
((GeneralPath)shape).lineTo(223.0, 224.0);
((GeneralPath)shape).lineTo(226.0, 222.0);
((GeneralPath)shape).lineTo(230.0, 224.0);
((GeneralPath)shape).lineTo(232.0, 222.0);
((GeneralPath)shape).lineTo(236.0, 222.0);
((GeneralPath)shape).lineTo(235.0, 226.0);
((GeneralPath)shape).lineTo(238.0, 232.0);
((GeneralPath)shape).lineTo(241.0, 227.0);
((GeneralPath)shape).lineTo(248.0, 227.0);
((GeneralPath)shape).lineTo(250.0, 229.0);
((GeneralPath)shape).lineTo(256.0, 227.0);
((GeneralPath)shape).lineTo(259.0, 230.0);
((GeneralPath)shape).lineTo(263.0, 230.0);
((GeneralPath)shape).lineTo(263.0, 232.0);
((GeneralPath)shape).lineTo(266.0, 229.0);
((GeneralPath)shape).lineTo(269.0, 232.0);
((GeneralPath)shape).lineTo(271.0, 231.0);
((GeneralPath)shape).lineTo(276.0, 233.0);
((GeneralPath)shape).lineTo(278.0, 231.0);
((GeneralPath)shape).lineTo(278.0, 233.0);
((GeneralPath)shape).lineTo(284.0, 235.0);
((GeneralPath)shape).lineTo(283.0, 234.0);
((GeneralPath)shape).lineTo(288.0, 229.0);
((GeneralPath)shape).lineTo(289.0, 234.0);
((GeneralPath)shape).lineTo(296.0, 232.0);
((GeneralPath)shape).lineTo(298.0, 235.0);
((GeneralPath)shape).lineTo(302.0, 234.0);
((GeneralPath)shape).lineTo(302.0, 237.0);
((GeneralPath)shape).lineTo(306.0, 236.0);
((GeneralPath)shape).lineTo(306.0, 239.0);
((GeneralPath)shape).lineTo(308.0, 241.0);
((GeneralPath)shape).lineTo(315.0, 241.0);
((GeneralPath)shape).lineTo(319.0, 243.0);
((GeneralPath)shape).lineTo(326.0, 251.0);
((GeneralPath)shape).lineTo(330.0, 246.0);
((GeneralPath)shape).lineTo(334.0, 249.0);
((GeneralPath)shape).lineTo(338.0, 249.0);
((GeneralPath)shape).lineTo(344.0, 255.0);
((GeneralPath)shape).lineTo(343.0, 260.0);
((GeneralPath)shape).lineTo(348.0, 260.0);
((GeneralPath)shape).lineTo(350.0, 267.0);
((GeneralPath)shape).lineTo(346.0, 275.0);
((GeneralPath)shape).lineTo(336.0, 282.0);
((GeneralPath)shape).lineTo(337.0, 285.0);
((GeneralPath)shape).lineTo(343.0, 285.0);
((GeneralPath)shape).lineTo(347.0, 288.0);
((GeneralPath)shape).lineTo(342.0, 299.0);
((GeneralPath)shape).lineTo(345.0, 310.0);
((GeneralPath)shape).lineTo(341.0, 317.0);
((GeneralPath)shape).lineTo(339.0, 318.0);
((GeneralPath)shape).lineTo(338.0, 313.0);
((GeneralPath)shape).lineTo(336.0, 311.0);
((GeneralPath)shape).lineTo(328.0, 314.0);
((GeneralPath)shape).lineTo(324.0, 312.0);
((GeneralPath)shape).lineTo(318.0, 317.0);
((GeneralPath)shape).lineTo(313.0, 326.0);
((GeneralPath)shape).lineTo(304.0, 325.0);
((GeneralPath)shape).lineTo(299.0, 318.0);
((GeneralPath)shape).lineTo(294.0, 319.0);
((GeneralPath)shape).lineTo(294.0, 317.0);
((GeneralPath)shape).lineTo(298.0, 315.0);
((GeneralPath)shape).lineTo(295.0, 311.0);
((GeneralPath)shape).lineTo(290.0, 314.0);
((GeneralPath)shape).lineTo(287.0, 310.0);
((GeneralPath)shape).lineTo(285.0, 310.0);
((GeneralPath)shape).lineTo(284.0, 301.0);
((GeneralPath)shape).lineTo(281.0, 301.0);
((GeneralPath)shape).lineTo(277.0, 295.0);
((GeneralPath)shape).lineTo(277.0, 291.0);
((GeneralPath)shape).lineTo(269.0, 293.0);
((GeneralPath)shape).lineTo(269.0, 291.0);
((GeneralPath)shape).lineTo(260.0, 287.0);
((GeneralPath)shape).lineTo(252.0, 288.0);
((GeneralPath)shape).lineTo(250.0, 291.0);
((GeneralPath)shape).lineTo(242.0, 290.0);
((GeneralPath)shape).lineTo(233.0, 296.0);
((GeneralPath)shape).lineTo(223.0, 296.0);
((GeneralPath)shape).lineTo(222.0, 293.0);
((GeneralPath)shape).lineTo(215.0, 287.0);
((GeneralPath)shape).lineTo(214.0, 281.0);
((GeneralPath)shape).lineTo(208.0, 279.0);
((GeneralPath)shape).lineTo(208.0, 277.0);
((GeneralPath)shape).lineTo(211.0, 274.0);
((GeneralPath)shape).lineTo(209.0, 271.0);
((GeneralPath)shape).lineTo(205.0, 269.0);
((GeneralPath)shape).lineTo(205.0, 264.0);
((GeneralPath)shape).lineTo(198.0, 265.0);
((GeneralPath)shape).lineTo(199.0, 260.0);
((GeneralPath)shape).lineTo(201.0, 261.0);
((GeneralPath)shape).lineTo(202.0, 257.0);
((GeneralPath)shape).lineTo(197.0, 251.0);
((GeneralPath)shape).lineTo(199.0, 249.0);
((GeneralPath)shape).lineTo(204.0, 250.0);
((GeneralPath)shape).lineTo(218.0, 240.0);
((GeneralPath)shape).lineTo(218.0, 238.0);
((GeneralPath)shape).lineTo(214.0, 236.0);
((GeneralPath)shape).lineTo(218.0, 232.0);
((GeneralPath)shape).lineTo(218.0, 227.0);
((GeneralPath)shape).lineTo(214.0, 223.0);
((GeneralPath)shape).lineTo(216.0, 221.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(220.0, 220.0);
((GeneralPath)shape).lineTo(221.0, 223.0);
((GeneralPath)shape).lineTo(223.0, 224.0);
((GeneralPath)shape).lineTo(226.0, 222.0);
((GeneralPath)shape).lineTo(230.0, 224.0);
((GeneralPath)shape).lineTo(232.0, 222.0);
((GeneralPath)shape).lineTo(236.0, 222.0);
((GeneralPath)shape).lineTo(235.0, 226.0);
((GeneralPath)shape).lineTo(238.0, 232.0);
((GeneralPath)shape).lineTo(241.0, 227.0);
((GeneralPath)shape).lineTo(248.0, 227.0);
((GeneralPath)shape).lineTo(250.0, 229.0);
((GeneralPath)shape).lineTo(256.0, 227.0);
((GeneralPath)shape).lineTo(259.0, 230.0);
((GeneralPath)shape).lineTo(263.0, 230.0);
((GeneralPath)shape).lineTo(263.0, 232.0);
((GeneralPath)shape).lineTo(266.0, 229.0);
((GeneralPath)shape).lineTo(269.0, 232.0);
((GeneralPath)shape).lineTo(271.0, 231.0);
((GeneralPath)shape).lineTo(276.0, 233.0);
((GeneralPath)shape).lineTo(278.0, 231.0);
((GeneralPath)shape).lineTo(278.0, 233.0);
((GeneralPath)shape).lineTo(284.0, 235.0);
((GeneralPath)shape).lineTo(283.0, 234.0);
((GeneralPath)shape).lineTo(288.0, 229.0);
((GeneralPath)shape).lineTo(289.0, 234.0);
((GeneralPath)shape).lineTo(296.0, 232.0);
((GeneralPath)shape).lineTo(298.0, 235.0);
((GeneralPath)shape).lineTo(302.0, 234.0);
((GeneralPath)shape).lineTo(302.0, 237.0);
((GeneralPath)shape).lineTo(306.0, 236.0);
((GeneralPath)shape).lineTo(306.0, 239.0);
((GeneralPath)shape).lineTo(308.0, 241.0);
((GeneralPath)shape).lineTo(315.0, 241.0);
((GeneralPath)shape).lineTo(319.0, 243.0);
((GeneralPath)shape).lineTo(326.0, 251.0);
((GeneralPath)shape).lineTo(330.0, 246.0);
((GeneralPath)shape).lineTo(334.0, 249.0);
((GeneralPath)shape).lineTo(338.0, 249.0);
((GeneralPath)shape).lineTo(344.0, 255.0);
((GeneralPath)shape).lineTo(343.0, 260.0);
((GeneralPath)shape).lineTo(348.0, 260.0);
((GeneralPath)shape).lineTo(350.0, 267.0);
((GeneralPath)shape).lineTo(346.0, 275.0);
((GeneralPath)shape).lineTo(336.0, 282.0);
((GeneralPath)shape).lineTo(337.0, 285.0);
((GeneralPath)shape).lineTo(343.0, 285.0);
((GeneralPath)shape).lineTo(347.0, 288.0);
((GeneralPath)shape).lineTo(342.0, 299.0);
((GeneralPath)shape).lineTo(345.0, 310.0);
((GeneralPath)shape).lineTo(341.0, 317.0);
((GeneralPath)shape).lineTo(339.0, 318.0);
((GeneralPath)shape).lineTo(338.0, 313.0);
((GeneralPath)shape).lineTo(336.0, 311.0);
((GeneralPath)shape).lineTo(328.0, 314.0);
((GeneralPath)shape).lineTo(324.0, 312.0);
((GeneralPath)shape).lineTo(318.0, 317.0);
((GeneralPath)shape).lineTo(313.0, 326.0);
((GeneralPath)shape).lineTo(304.0, 325.0);
((GeneralPath)shape).lineTo(299.0, 318.0);
((GeneralPath)shape).lineTo(294.0, 319.0);
((GeneralPath)shape).lineTo(294.0, 317.0);
((GeneralPath)shape).lineTo(298.0, 315.0);
((GeneralPath)shape).lineTo(295.0, 311.0);
((GeneralPath)shape).lineTo(290.0, 314.0);
((GeneralPath)shape).lineTo(287.0, 310.0);
((GeneralPath)shape).lineTo(285.0, 310.0);
((GeneralPath)shape).lineTo(284.0, 301.0);
((GeneralPath)shape).lineTo(281.0, 301.0);
((GeneralPath)shape).lineTo(277.0, 295.0);
((GeneralPath)shape).lineTo(277.0, 291.0);
((GeneralPath)shape).lineTo(269.0, 293.0);
((GeneralPath)shape).lineTo(269.0, 291.0);
((GeneralPath)shape).lineTo(260.0, 287.0);
((GeneralPath)shape).lineTo(252.0, 288.0);
((GeneralPath)shape).lineTo(250.0, 291.0);
((GeneralPath)shape).lineTo(242.0, 290.0);
((GeneralPath)shape).lineTo(233.0, 296.0);
((GeneralPath)shape).lineTo(223.0, 296.0);
((GeneralPath)shape).lineTo(222.0, 293.0);
((GeneralPath)shape).lineTo(215.0, 287.0);
((GeneralPath)shape).lineTo(214.0, 281.0);
((GeneralPath)shape).lineTo(208.0, 279.0);
((GeneralPath)shape).lineTo(208.0, 277.0);
((GeneralPath)shape).lineTo(211.0, 274.0);
((GeneralPath)shape).lineTo(209.0, 271.0);
((GeneralPath)shape).lineTo(205.0, 269.0);
((GeneralPath)shape).lineTo(205.0, 264.0);
((GeneralPath)shape).lineTo(198.0, 265.0);
((GeneralPath)shape).lineTo(199.0, 260.0);
((GeneralPath)shape).lineTo(201.0, 261.0);
((GeneralPath)shape).lineTo(202.0, 257.0);
((GeneralPath)shape).lineTo(197.0, 251.0);
((GeneralPath)shape).lineTo(199.0, 249.0);
((GeneralPath)shape).lineTo(204.0, 250.0);
((GeneralPath)shape).lineTo(218.0, 240.0);
((GeneralPath)shape).lineTo(218.0, 238.0);
((GeneralPath)shape).lineTo(214.0, 236.0);
((GeneralPath)shape).lineTo(218.0, 232.0);
((GeneralPath)shape).lineTo(218.0, 227.0);
((GeneralPath)shape).lineTo(214.0, 223.0);
((GeneralPath)shape).lineTo(216.0, 221.0);
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
        return 376;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 372;
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

