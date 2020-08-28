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
public class F1 {
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
((GeneralPath)shape).moveTo(289.0, 142.0);
((GeneralPath)shape).lineTo(292.0, 148.0);
((GeneralPath)shape).lineTo(291.0, 152.0);
((GeneralPath)shape).lineTo(301.0, 153.0);
((GeneralPath)shape).lineTo(303.0, 156.0);
((GeneralPath)shape).lineTo(308.0, 155.0);
((GeneralPath)shape).lineTo(310.0, 158.0);
((GeneralPath)shape).lineTo(313.0, 157.0);
((GeneralPath)shape).lineTo(315.0, 160.0);
((GeneralPath)shape).lineTo(319.0, 159.0);
((GeneralPath)shape).lineTo(317.0, 161.0);
((GeneralPath)shape).lineTo(322.0, 158.0);
((GeneralPath)shape).lineTo(327.0, 159.0);
((GeneralPath)shape).lineTo(337.0, 150.0);
((GeneralPath)shape).lineTo(348.0, 152.0);
((GeneralPath)shape).lineTo(351.0, 148.0);
((GeneralPath)shape).lineTo(360.0, 151.0);
((GeneralPath)shape).lineTo(365.0, 156.0);
((GeneralPath)shape).lineTo(367.0, 154.0);
((GeneralPath)shape).lineTo(381.0, 153.0);
((GeneralPath)shape).lineTo(383.0, 151.0);
((GeneralPath)shape).lineTo(387.0, 154.0);
((GeneralPath)shape).lineTo(389.0, 150.0);
((GeneralPath)shape).lineTo(393.0, 148.0);
((GeneralPath)shape).lineTo(397.0, 148.0);
((GeneralPath)shape).lineTo(403.0, 152.0);
((GeneralPath)shape).lineTo(406.0, 149.0);
((GeneralPath)shape).lineTo(410.0, 150.0);
((GeneralPath)shape).lineTo(411.0, 152.0);
((GeneralPath)shape).lineTo(415.0, 151.0);
((GeneralPath)shape).lineTo(415.0, 157.0);
((GeneralPath)shape).lineTo(422.0, 155.0);
((GeneralPath)shape).lineTo(423.0, 160.0);
((GeneralPath)shape).lineTo(427.0, 161.0);
((GeneralPath)shape).lineTo(427.0, 174.0);
((GeneralPath)shape).lineTo(421.0, 173.0);
((GeneralPath)shape).lineTo(418.0, 181.0);
((GeneralPath)shape).lineTo(414.0, 180.0);
((GeneralPath)shape).lineTo(408.0, 182.0);
((GeneralPath)shape).lineTo(404.0, 180.0);
((GeneralPath)shape).lineTo(401.0, 182.0);
((GeneralPath)shape).lineTo(394.0, 183.0);
((GeneralPath)shape).lineTo(393.0, 188.0);
((GeneralPath)shape).lineTo(382.0, 201.0);
((GeneralPath)shape).lineTo(382.0, 205.0);
((GeneralPath)shape).lineTo(377.0, 203.0);
((GeneralPath)shape).lineTo(376.0, 211.0);
((GeneralPath)shape).lineTo(372.0, 218.0);
((GeneralPath)shape).lineTo(364.0, 215.0);
((GeneralPath)shape).lineTo(364.0, 218.0);
((GeneralPath)shape).lineTo(357.0, 218.0);
((GeneralPath)shape).lineTo(352.0, 229.0);
((GeneralPath)shape).lineTo(361.0, 233.0);
((GeneralPath)shape).lineTo(359.0, 237.0);
((GeneralPath)shape).lineTo(365.0, 244.0);
((GeneralPath)shape).lineTo(358.0, 255.0);
((GeneralPath)shape).lineTo(357.0, 261.0);
((GeneralPath)shape).lineTo(352.0, 259.0);
((GeneralPath)shape).lineTo(350.0, 261.0);
((GeneralPath)shape).lineTo(348.0, 258.0);
((GeneralPath)shape).lineTo(348.0, 260.0);
((GeneralPath)shape).lineTo(343.0, 260.0);
((GeneralPath)shape).lineTo(344.0, 255.0);
((GeneralPath)shape).lineTo(338.0, 249.0);
((GeneralPath)shape).lineTo(334.0, 249.0);
((GeneralPath)shape).lineTo(330.0, 246.0);
((GeneralPath)shape).lineTo(326.0, 251.0);
((GeneralPath)shape).lineTo(315.0, 241.0);
((GeneralPath)shape).lineTo(307.0, 241.0);
((GeneralPath)shape).lineTo(306.0, 236.0);
((GeneralPath)shape).lineTo(302.0, 237.0);
((GeneralPath)shape).lineTo(302.0, 234.0);
((GeneralPath)shape).lineTo(298.0, 235.0);
((GeneralPath)shape).lineTo(296.0, 232.0);
((GeneralPath)shape).lineTo(289.0, 234.0);
((GeneralPath)shape).lineTo(288.0, 229.0);
((GeneralPath)shape).lineTo(283.0, 233.0);
((GeneralPath)shape).lineTo(284.0, 235.0);
((GeneralPath)shape).lineTo(278.0, 233.0);
((GeneralPath)shape).lineTo(278.0, 231.0);
((GeneralPath)shape).lineTo(276.0, 233.0);
((GeneralPath)shape).lineTo(271.0, 231.0);
((GeneralPath)shape).lineTo(269.0, 232.0);
((GeneralPath)shape).lineTo(266.0, 229.0);
((GeneralPath)shape).lineTo(263.0, 232.0);
((GeneralPath)shape).lineTo(263.0, 230.0);
((GeneralPath)shape).lineTo(259.0, 230.0);
((GeneralPath)shape).lineTo(256.0, 227.0);
((GeneralPath)shape).lineTo(250.0, 229.0);
((GeneralPath)shape).lineTo(248.0, 227.0);
((GeneralPath)shape).lineTo(241.0, 227.0);
((GeneralPath)shape).lineTo(238.0, 232.0);
((GeneralPath)shape).lineTo(235.0, 226.0);
((GeneralPath)shape).lineTo(236.0, 222.0);
((GeneralPath)shape).lineTo(232.0, 222.0);
((GeneralPath)shape).lineTo(230.0, 224.0);
((GeneralPath)shape).lineTo(226.0, 222.0);
((GeneralPath)shape).lineTo(221.0, 223.0);
((GeneralPath)shape).lineTo(220.0, 220.0);
((GeneralPath)shape).lineTo(216.0, 221.0);
((GeneralPath)shape).lineTo(217.0, 211.0);
((GeneralPath)shape).lineTo(224.0, 215.0);
((GeneralPath)shape).lineTo(226.0, 205.0);
((GeneralPath)shape).lineTo(229.0, 203.0);
((GeneralPath)shape).lineTo(232.0, 205.0);
((GeneralPath)shape).lineTo(234.0, 203.0);
((GeneralPath)shape).lineTo(233.0, 191.0);
((GeneralPath)shape).lineTo(235.0, 190.0);
((GeneralPath)shape).lineTo(236.0, 185.0);
((GeneralPath)shape).lineTo(231.0, 182.0);
((GeneralPath)shape).lineTo(226.0, 184.0);
((GeneralPath)shape).lineTo(234.0, 163.0);
((GeneralPath)shape).lineTo(245.0, 163.0);
((GeneralPath)shape).lineTo(247.0, 159.0);
((GeneralPath)shape).lineTo(250.0, 161.0);
((GeneralPath)shape).lineTo(265.0, 161.0);
((GeneralPath)shape).lineTo(270.0, 158.0);
((GeneralPath)shape).lineTo(281.0, 142.0);
((GeneralPath)shape).lineTo(282.0, 148.0);
((GeneralPath)shape).lineTo(285.0, 142.0);
((GeneralPath)shape).lineTo(288.0, 141.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(289.0, 142.0);
((GeneralPath)shape).lineTo(292.0, 148.0);
((GeneralPath)shape).lineTo(291.0, 152.0);
((GeneralPath)shape).lineTo(301.0, 153.0);
((GeneralPath)shape).lineTo(303.0, 156.0);
((GeneralPath)shape).lineTo(308.0, 155.0);
((GeneralPath)shape).lineTo(310.0, 158.0);
((GeneralPath)shape).lineTo(313.0, 157.0);
((GeneralPath)shape).lineTo(315.0, 160.0);
((GeneralPath)shape).lineTo(319.0, 159.0);
((GeneralPath)shape).lineTo(317.0, 161.0);
((GeneralPath)shape).lineTo(322.0, 158.0);
((GeneralPath)shape).lineTo(327.0, 159.0);
((GeneralPath)shape).lineTo(337.0, 150.0);
((GeneralPath)shape).lineTo(348.0, 152.0);
((GeneralPath)shape).lineTo(351.0, 148.0);
((GeneralPath)shape).lineTo(360.0, 151.0);
((GeneralPath)shape).lineTo(365.0, 156.0);
((GeneralPath)shape).lineTo(367.0, 154.0);
((GeneralPath)shape).lineTo(381.0, 153.0);
((GeneralPath)shape).lineTo(383.0, 151.0);
((GeneralPath)shape).lineTo(387.0, 154.0);
((GeneralPath)shape).lineTo(389.0, 150.0);
((GeneralPath)shape).lineTo(393.0, 148.0);
((GeneralPath)shape).lineTo(397.0, 148.0);
((GeneralPath)shape).lineTo(403.0, 152.0);
((GeneralPath)shape).lineTo(406.0, 149.0);
((GeneralPath)shape).lineTo(410.0, 150.0);
((GeneralPath)shape).lineTo(411.0, 152.0);
((GeneralPath)shape).lineTo(415.0, 151.0);
((GeneralPath)shape).lineTo(415.0, 157.0);
((GeneralPath)shape).lineTo(422.0, 155.0);
((GeneralPath)shape).lineTo(423.0, 160.0);
((GeneralPath)shape).lineTo(427.0, 161.0);
((GeneralPath)shape).lineTo(427.0, 174.0);
((GeneralPath)shape).lineTo(421.0, 173.0);
((GeneralPath)shape).lineTo(418.0, 181.0);
((GeneralPath)shape).lineTo(414.0, 180.0);
((GeneralPath)shape).lineTo(408.0, 182.0);
((GeneralPath)shape).lineTo(404.0, 180.0);
((GeneralPath)shape).lineTo(401.0, 182.0);
((GeneralPath)shape).lineTo(394.0, 183.0);
((GeneralPath)shape).lineTo(393.0, 188.0);
((GeneralPath)shape).lineTo(382.0, 201.0);
((GeneralPath)shape).lineTo(382.0, 205.0);
((GeneralPath)shape).lineTo(377.0, 203.0);
((GeneralPath)shape).lineTo(376.0, 211.0);
((GeneralPath)shape).lineTo(372.0, 218.0);
((GeneralPath)shape).lineTo(364.0, 215.0);
((GeneralPath)shape).lineTo(364.0, 218.0);
((GeneralPath)shape).lineTo(357.0, 218.0);
((GeneralPath)shape).lineTo(352.0, 229.0);
((GeneralPath)shape).lineTo(361.0, 233.0);
((GeneralPath)shape).lineTo(359.0, 237.0);
((GeneralPath)shape).lineTo(365.0, 244.0);
((GeneralPath)shape).lineTo(358.0, 255.0);
((GeneralPath)shape).lineTo(357.0, 261.0);
((GeneralPath)shape).lineTo(352.0, 259.0);
((GeneralPath)shape).lineTo(350.0, 261.0);
((GeneralPath)shape).lineTo(348.0, 258.0);
((GeneralPath)shape).lineTo(348.0, 260.0);
((GeneralPath)shape).lineTo(343.0, 260.0);
((GeneralPath)shape).lineTo(344.0, 255.0);
((GeneralPath)shape).lineTo(338.0, 249.0);
((GeneralPath)shape).lineTo(334.0, 249.0);
((GeneralPath)shape).lineTo(330.0, 246.0);
((GeneralPath)shape).lineTo(326.0, 251.0);
((GeneralPath)shape).lineTo(315.0, 241.0);
((GeneralPath)shape).lineTo(307.0, 241.0);
((GeneralPath)shape).lineTo(306.0, 236.0);
((GeneralPath)shape).lineTo(302.0, 237.0);
((GeneralPath)shape).lineTo(302.0, 234.0);
((GeneralPath)shape).lineTo(298.0, 235.0);
((GeneralPath)shape).lineTo(296.0, 232.0);
((GeneralPath)shape).lineTo(289.0, 234.0);
((GeneralPath)shape).lineTo(288.0, 229.0);
((GeneralPath)shape).lineTo(283.0, 233.0);
((GeneralPath)shape).lineTo(284.0, 235.0);
((GeneralPath)shape).lineTo(278.0, 233.0);
((GeneralPath)shape).lineTo(278.0, 231.0);
((GeneralPath)shape).lineTo(276.0, 233.0);
((GeneralPath)shape).lineTo(271.0, 231.0);
((GeneralPath)shape).lineTo(269.0, 232.0);
((GeneralPath)shape).lineTo(266.0, 229.0);
((GeneralPath)shape).lineTo(263.0, 232.0);
((GeneralPath)shape).lineTo(263.0, 230.0);
((GeneralPath)shape).lineTo(259.0, 230.0);
((GeneralPath)shape).lineTo(256.0, 227.0);
((GeneralPath)shape).lineTo(250.0, 229.0);
((GeneralPath)shape).lineTo(248.0, 227.0);
((GeneralPath)shape).lineTo(241.0, 227.0);
((GeneralPath)shape).lineTo(238.0, 232.0);
((GeneralPath)shape).lineTo(235.0, 226.0);
((GeneralPath)shape).lineTo(236.0, 222.0);
((GeneralPath)shape).lineTo(232.0, 222.0);
((GeneralPath)shape).lineTo(230.0, 224.0);
((GeneralPath)shape).lineTo(226.0, 222.0);
((GeneralPath)shape).lineTo(221.0, 223.0);
((GeneralPath)shape).lineTo(220.0, 220.0);
((GeneralPath)shape).lineTo(216.0, 221.0);
((GeneralPath)shape).lineTo(217.0, 211.0);
((GeneralPath)shape).lineTo(224.0, 215.0);
((GeneralPath)shape).lineTo(226.0, 205.0);
((GeneralPath)shape).lineTo(229.0, 203.0);
((GeneralPath)shape).lineTo(232.0, 205.0);
((GeneralPath)shape).lineTo(234.0, 203.0);
((GeneralPath)shape).lineTo(233.0, 191.0);
((GeneralPath)shape).lineTo(235.0, 190.0);
((GeneralPath)shape).lineTo(236.0, 185.0);
((GeneralPath)shape).lineTo(231.0, 182.0);
((GeneralPath)shape).lineTo(226.0, 184.0);
((GeneralPath)shape).lineTo(234.0, 163.0);
((GeneralPath)shape).lineTo(245.0, 163.0);
((GeneralPath)shape).lineTo(247.0, 159.0);
((GeneralPath)shape).lineTo(250.0, 161.0);
((GeneralPath)shape).lineTo(265.0, 161.0);
((GeneralPath)shape).lineTo(270.0, 158.0);
((GeneralPath)shape).lineTo(281.0, 142.0);
((GeneralPath)shape).lineTo(282.0, 148.0);
((GeneralPath)shape).lineTo(285.0, 142.0);
((GeneralPath)shape).lineTo(288.0, 141.0);
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
        return 395;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 293;
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

