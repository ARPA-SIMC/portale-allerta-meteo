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
public class E {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 280.0f, -30.0f));
clip = new Area(g.getClip());
clip.intersect(new Area(new Rectangle2D.Double(-280.0,30.0,1026.0,870.0)));
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
((GeneralPath)shape).moveTo(219.0, 220.0);
((GeneralPath)shape).lineTo(220.0, 223.0);
((GeneralPath)shape).lineTo(222.0, 224.0);
((GeneralPath)shape).lineTo(225.0, 222.0);
((GeneralPath)shape).lineTo(229.0, 224.0);
((GeneralPath)shape).lineTo(231.0, 222.0);
((GeneralPath)shape).lineTo(235.0, 222.0);
((GeneralPath)shape).lineTo(234.0, 226.0);
((GeneralPath)shape).lineTo(237.0, 232.0);
((GeneralPath)shape).lineTo(240.0, 227.0);
((GeneralPath)shape).lineTo(247.0, 227.0);
((GeneralPath)shape).lineTo(249.0, 229.0);
((GeneralPath)shape).lineTo(255.0, 227.0);
((GeneralPath)shape).lineTo(258.0, 230.0);
((GeneralPath)shape).lineTo(262.0, 230.0);
((GeneralPath)shape).lineTo(262.0, 232.0);
((GeneralPath)shape).lineTo(265.0, 229.0);
((GeneralPath)shape).lineTo(268.0, 232.0);
((GeneralPath)shape).lineTo(270.0, 231.0);
((GeneralPath)shape).lineTo(275.0, 233.0);
((GeneralPath)shape).lineTo(277.0, 231.0);
((GeneralPath)shape).lineTo(277.0, 233.0);
((GeneralPath)shape).lineTo(283.0, 235.0);
((GeneralPath)shape).lineTo(282.0, 234.0);
((GeneralPath)shape).lineTo(287.0, 229.0);
((GeneralPath)shape).lineTo(288.0, 234.0);
((GeneralPath)shape).lineTo(295.0, 232.0);
((GeneralPath)shape).lineTo(297.0, 235.0);
((GeneralPath)shape).lineTo(301.0, 234.0);
((GeneralPath)shape).lineTo(301.0, 237.0);
((GeneralPath)shape).lineTo(305.0, 236.0);
((GeneralPath)shape).lineTo(305.0, 239.0);
((GeneralPath)shape).lineTo(307.0, 241.0);
((GeneralPath)shape).lineTo(314.0, 241.0);
((GeneralPath)shape).lineTo(318.0, 243.0);
((GeneralPath)shape).lineTo(325.0, 251.0);
((GeneralPath)shape).lineTo(330.0, 246.0);
((GeneralPath)shape).lineTo(333.0, 249.0);
((GeneralPath)shape).lineTo(337.0, 249.0);
((GeneralPath)shape).lineTo(342.0, 254.0);
((GeneralPath)shape).lineTo(342.0, 260.0);
((GeneralPath)shape).lineTo(347.0, 260.0);
((GeneralPath)shape).lineTo(349.0, 267.0);
((GeneralPath)shape).lineTo(345.0, 275.0);
((GeneralPath)shape).lineTo(335.0, 282.0);
((GeneralPath)shape).lineTo(336.0, 285.0);
((GeneralPath)shape).lineTo(342.0, 285.0);
((GeneralPath)shape).lineTo(346.0, 288.0);
((GeneralPath)shape).lineTo(341.0, 299.0);
((GeneralPath)shape).lineTo(344.0, 310.0);
((GeneralPath)shape).lineTo(338.0, 318.0);
((GeneralPath)shape).lineTo(337.0, 316.0);
((GeneralPath)shape).lineTo(327.0, 320.0);
((GeneralPath)shape).lineTo(329.0, 324.0);
((GeneralPath)shape).lineTo(332.0, 324.0);
((GeneralPath)shape).lineTo(330.0, 325.0);
((GeneralPath)shape).lineTo(331.0, 332.0);
((GeneralPath)shape).lineTo(329.0, 337.0);
((GeneralPath)shape).lineTo(325.0, 337.0);
((GeneralPath)shape).lineTo(320.0, 342.0);
((GeneralPath)shape).lineTo(317.0, 340.0);
((GeneralPath)shape).lineTo(317.0, 337.0);
((GeneralPath)shape).lineTo(311.0, 335.0);
((GeneralPath)shape).lineTo(309.0, 336.0);
((GeneralPath)shape).lineTo(310.0, 341.0);
((GeneralPath)shape).lineTo(304.0, 348.0);
((GeneralPath)shape).lineTo(301.0, 355.0);
((GeneralPath)shape).lineTo(303.0, 365.0);
((GeneralPath)shape).lineTo(295.0, 360.0);
((GeneralPath)shape).lineTo(292.0, 355.0);
((GeneralPath)shape).lineTo(276.0, 355.0);
((GeneralPath)shape).lineTo(272.0, 353.0);
((GeneralPath)shape).lineTo(268.0, 358.0);
((GeneralPath)shape).lineTo(268.0, 363.0);
((GeneralPath)shape).lineTo(263.0, 365.0);
((GeneralPath)shape).lineTo(260.0, 361.0);
((GeneralPath)shape).lineTo(250.0, 354.0);
((GeneralPath)shape).lineTo(249.0, 348.0);
((GeneralPath)shape).lineTo(243.0, 342.0);
((GeneralPath)shape).lineTo(243.0, 337.0);
((GeneralPath)shape).lineTo(239.0, 335.0);
((GeneralPath)shape).lineTo(233.0, 336.0);
((GeneralPath)shape).lineTo(223.0, 325.0);
((GeneralPath)shape).lineTo(217.0, 326.0);
((GeneralPath)shape).lineTo(209.0, 321.0);
((GeneralPath)shape).lineTo(201.0, 326.0);
((GeneralPath)shape).lineTo(196.0, 318.0);
((GeneralPath)shape).lineTo(189.0, 314.0);
((GeneralPath)shape).lineTo(181.0, 304.0);
((GeneralPath)shape).lineTo(173.0, 306.0);
((GeneralPath)shape).lineTo(164.0, 299.0);
((GeneralPath)shape).lineTo(168.0, 286.0);
((GeneralPath)shape).lineTo(171.0, 285.0);
((GeneralPath)shape).lineTo(173.0, 282.0);
((GeneralPath)shape).lineTo(176.0, 283.0);
((GeneralPath)shape).lineTo(182.0, 275.0);
((GeneralPath)shape).lineTo(187.0, 276.0);
((GeneralPath)shape).lineTo(196.0, 274.0);
((GeneralPath)shape).lineTo(199.0, 270.0);
((GeneralPath)shape).lineTo(204.0, 269.0);
((GeneralPath)shape).lineTo(204.0, 264.0);
((GeneralPath)shape).lineTo(197.0, 265.0);
((GeneralPath)shape).lineTo(198.0, 260.0);
((GeneralPath)shape).lineTo(200.0, 261.0);
((GeneralPath)shape).lineTo(201.0, 257.0);
((GeneralPath)shape).lineTo(196.0, 251.0);
((GeneralPath)shape).lineTo(198.0, 249.0);
((GeneralPath)shape).lineTo(203.0, 250.0);
((GeneralPath)shape).lineTo(217.0, 240.0);
((GeneralPath)shape).lineTo(217.0, 238.0);
((GeneralPath)shape).lineTo(213.0, 236.0);
((GeneralPath)shape).lineTo(217.0, 232.0);
((GeneralPath)shape).lineTo(217.0, 227.0);
((GeneralPath)shape).lineTo(213.0, 223.0);
((GeneralPath)shape).lineTo(215.0, 221.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(219.0, 220.0);
((GeneralPath)shape).lineTo(220.0, 223.0);
((GeneralPath)shape).lineTo(222.0, 224.0);
((GeneralPath)shape).lineTo(225.0, 222.0);
((GeneralPath)shape).lineTo(229.0, 224.0);
((GeneralPath)shape).lineTo(231.0, 222.0);
((GeneralPath)shape).lineTo(235.0, 222.0);
((GeneralPath)shape).lineTo(234.0, 226.0);
((GeneralPath)shape).lineTo(237.0, 232.0);
((GeneralPath)shape).lineTo(240.0, 227.0);
((GeneralPath)shape).lineTo(247.0, 227.0);
((GeneralPath)shape).lineTo(249.0, 229.0);
((GeneralPath)shape).lineTo(255.0, 227.0);
((GeneralPath)shape).lineTo(258.0, 230.0);
((GeneralPath)shape).lineTo(262.0, 230.0);
((GeneralPath)shape).lineTo(262.0, 232.0);
((GeneralPath)shape).lineTo(265.0, 229.0);
((GeneralPath)shape).lineTo(268.0, 232.0);
((GeneralPath)shape).lineTo(270.0, 231.0);
((GeneralPath)shape).lineTo(275.0, 233.0);
((GeneralPath)shape).lineTo(277.0, 231.0);
((GeneralPath)shape).lineTo(277.0, 233.0);
((GeneralPath)shape).lineTo(283.0, 235.0);
((GeneralPath)shape).lineTo(282.0, 234.0);
((GeneralPath)shape).lineTo(287.0, 229.0);
((GeneralPath)shape).lineTo(288.0, 234.0);
((GeneralPath)shape).lineTo(295.0, 232.0);
((GeneralPath)shape).lineTo(297.0, 235.0);
((GeneralPath)shape).lineTo(301.0, 234.0);
((GeneralPath)shape).lineTo(301.0, 237.0);
((GeneralPath)shape).lineTo(305.0, 236.0);
((GeneralPath)shape).lineTo(305.0, 239.0);
((GeneralPath)shape).lineTo(307.0, 241.0);
((GeneralPath)shape).lineTo(314.0, 241.0);
((GeneralPath)shape).lineTo(318.0, 243.0);
((GeneralPath)shape).lineTo(325.0, 251.0);
((GeneralPath)shape).lineTo(330.0, 246.0);
((GeneralPath)shape).lineTo(333.0, 249.0);
((GeneralPath)shape).lineTo(337.0, 249.0);
((GeneralPath)shape).lineTo(342.0, 254.0);
((GeneralPath)shape).lineTo(342.0, 260.0);
((GeneralPath)shape).lineTo(347.0, 260.0);
((GeneralPath)shape).lineTo(349.0, 267.0);
((GeneralPath)shape).lineTo(345.0, 275.0);
((GeneralPath)shape).lineTo(335.0, 282.0);
((GeneralPath)shape).lineTo(336.0, 285.0);
((GeneralPath)shape).lineTo(342.0, 285.0);
((GeneralPath)shape).lineTo(346.0, 288.0);
((GeneralPath)shape).lineTo(341.0, 299.0);
((GeneralPath)shape).lineTo(344.0, 310.0);
((GeneralPath)shape).lineTo(338.0, 318.0);
((GeneralPath)shape).lineTo(337.0, 316.0);
((GeneralPath)shape).lineTo(327.0, 320.0);
((GeneralPath)shape).lineTo(329.0, 324.0);
((GeneralPath)shape).lineTo(332.0, 324.0);
((GeneralPath)shape).lineTo(330.0, 325.0);
((GeneralPath)shape).lineTo(331.0, 332.0);
((GeneralPath)shape).lineTo(329.0, 337.0);
((GeneralPath)shape).lineTo(325.0, 337.0);
((GeneralPath)shape).lineTo(320.0, 342.0);
((GeneralPath)shape).lineTo(317.0, 340.0);
((GeneralPath)shape).lineTo(317.0, 337.0);
((GeneralPath)shape).lineTo(311.0, 335.0);
((GeneralPath)shape).lineTo(309.0, 336.0);
((GeneralPath)shape).lineTo(310.0, 341.0);
((GeneralPath)shape).lineTo(304.0, 348.0);
((GeneralPath)shape).lineTo(301.0, 355.0);
((GeneralPath)shape).lineTo(303.0, 365.0);
((GeneralPath)shape).lineTo(295.0, 360.0);
((GeneralPath)shape).lineTo(292.0, 355.0);
((GeneralPath)shape).lineTo(276.0, 355.0);
((GeneralPath)shape).lineTo(272.0, 353.0);
((GeneralPath)shape).lineTo(268.0, 358.0);
((GeneralPath)shape).lineTo(268.0, 363.0);
((GeneralPath)shape).lineTo(263.0, 365.0);
((GeneralPath)shape).lineTo(260.0, 361.0);
((GeneralPath)shape).lineTo(250.0, 354.0);
((GeneralPath)shape).lineTo(249.0, 348.0);
((GeneralPath)shape).lineTo(243.0, 342.0);
((GeneralPath)shape).lineTo(243.0, 337.0);
((GeneralPath)shape).lineTo(239.0, 335.0);
((GeneralPath)shape).lineTo(233.0, 336.0);
((GeneralPath)shape).lineTo(223.0, 325.0);
((GeneralPath)shape).lineTo(217.0, 326.0);
((GeneralPath)shape).lineTo(209.0, 321.0);
((GeneralPath)shape).lineTo(201.0, 326.0);
((GeneralPath)shape).lineTo(196.0, 318.0);
((GeneralPath)shape).lineTo(189.0, 314.0);
((GeneralPath)shape).lineTo(181.0, 304.0);
((GeneralPath)shape).lineTo(173.0, 306.0);
((GeneralPath)shape).lineTo(164.0, 299.0);
((GeneralPath)shape).lineTo(168.0, 286.0);
((GeneralPath)shape).lineTo(171.0, 285.0);
((GeneralPath)shape).lineTo(173.0, 282.0);
((GeneralPath)shape).lineTo(176.0, 283.0);
((GeneralPath)shape).lineTo(182.0, 275.0);
((GeneralPath)shape).lineTo(187.0, 276.0);
((GeneralPath)shape).lineTo(196.0, 274.0);
((GeneralPath)shape).lineTo(199.0, 270.0);
((GeneralPath)shape).lineTo(204.0, 269.0);
((GeneralPath)shape).lineTo(204.0, 264.0);
((GeneralPath)shape).lineTo(197.0, 265.0);
((GeneralPath)shape).lineTo(198.0, 260.0);
((GeneralPath)shape).lineTo(200.0, 261.0);
((GeneralPath)shape).lineTo(201.0, 257.0);
((GeneralPath)shape).lineTo(196.0, 251.0);
((GeneralPath)shape).lineTo(198.0, 249.0);
((GeneralPath)shape).lineTo(203.0, 250.0);
((GeneralPath)shape).lineTo(217.0, 240.0);
((GeneralPath)shape).lineTo(217.0, 238.0);
((GeneralPath)shape).lineTo(213.0, 236.0);
((GeneralPath)shape).lineTo(217.0, 232.0);
((GeneralPath)shape).lineTo(217.0, 227.0);
((GeneralPath)shape).lineTo(213.0, 223.0);
((GeneralPath)shape).lineTo(215.0, 221.0);
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
        return 443;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 189;
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

