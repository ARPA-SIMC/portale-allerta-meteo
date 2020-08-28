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
public class F {
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
((GeneralPath)shape).moveTo(288.0, 142.0);
((GeneralPath)shape).lineTo(291.0, 148.0);
((GeneralPath)shape).lineTo(290.0, 152.0);
((GeneralPath)shape).lineTo(300.0, 153.0);
((GeneralPath)shape).lineTo(302.0, 156.0);
((GeneralPath)shape).lineTo(307.0, 155.0);
((GeneralPath)shape).lineTo(309.0, 158.0);
((GeneralPath)shape).lineTo(312.0, 157.0);
((GeneralPath)shape).lineTo(314.0, 160.0);
((GeneralPath)shape).lineTo(318.0, 159.0);
((GeneralPath)shape).lineTo(316.0, 161.0);
((GeneralPath)shape).lineTo(321.0, 158.0);
((GeneralPath)shape).lineTo(326.0, 159.0);
((GeneralPath)shape).lineTo(336.0, 150.0);
((GeneralPath)shape).lineTo(347.0, 152.0);
((GeneralPath)shape).lineTo(350.0, 148.0);
((GeneralPath)shape).lineTo(359.0, 151.0);
((GeneralPath)shape).lineTo(364.0, 156.0);
((GeneralPath)shape).lineTo(366.0, 154.0);
((GeneralPath)shape).lineTo(380.0, 153.0);
((GeneralPath)shape).lineTo(382.0, 151.0);
((GeneralPath)shape).lineTo(386.0, 154.0);
((GeneralPath)shape).lineTo(388.0, 150.0);
((GeneralPath)shape).lineTo(392.0, 148.0);
((GeneralPath)shape).lineTo(396.0, 148.0);
((GeneralPath)shape).lineTo(402.0, 152.0);
((GeneralPath)shape).lineTo(405.0, 149.0);
((GeneralPath)shape).lineTo(409.0, 150.0);
((GeneralPath)shape).lineTo(410.0, 152.0);
((GeneralPath)shape).lineTo(414.0, 151.0);
((GeneralPath)shape).lineTo(414.0, 157.0);
((GeneralPath)shape).lineTo(421.0, 155.0);
((GeneralPath)shape).lineTo(422.0, 160.0);
((GeneralPath)shape).lineTo(426.0, 161.0);
((GeneralPath)shape).lineTo(426.0, 174.0);
((GeneralPath)shape).lineTo(420.0, 173.0);
((GeneralPath)shape).lineTo(417.0, 181.0);
((GeneralPath)shape).lineTo(413.0, 180.0);
((GeneralPath)shape).lineTo(407.0, 182.0);
((GeneralPath)shape).lineTo(403.0, 180.0);
((GeneralPath)shape).lineTo(400.0, 182.0);
((GeneralPath)shape).lineTo(393.0, 183.0);
((GeneralPath)shape).lineTo(392.0, 188.0);
((GeneralPath)shape).lineTo(381.0, 201.0);
((GeneralPath)shape).lineTo(381.0, 205.0);
((GeneralPath)shape).lineTo(376.0, 203.0);
((GeneralPath)shape).lineTo(375.0, 211.0);
((GeneralPath)shape).lineTo(371.0, 218.0);
((GeneralPath)shape).lineTo(363.0, 215.0);
((GeneralPath)shape).lineTo(363.0, 218.0);
((GeneralPath)shape).lineTo(356.0, 218.0);
((GeneralPath)shape).lineTo(351.0, 229.0);
((GeneralPath)shape).lineTo(360.0, 233.0);
((GeneralPath)shape).lineTo(358.0, 237.0);
((GeneralPath)shape).lineTo(364.0, 244.0);
((GeneralPath)shape).lineTo(357.0, 255.0);
((GeneralPath)shape).lineTo(356.0, 261.0);
((GeneralPath)shape).lineTo(351.0, 259.0);
((GeneralPath)shape).lineTo(349.0, 261.0);
((GeneralPath)shape).lineTo(347.0, 258.0);
((GeneralPath)shape).lineTo(347.0, 260.0);
((GeneralPath)shape).lineTo(342.0, 260.0);
((GeneralPath)shape).lineTo(343.0, 255.0);
((GeneralPath)shape).lineTo(337.0, 249.0);
((GeneralPath)shape).lineTo(333.0, 249.0);
((GeneralPath)shape).lineTo(329.0, 246.0);
((GeneralPath)shape).lineTo(325.0, 251.0);
((GeneralPath)shape).lineTo(314.0, 241.0);
((GeneralPath)shape).lineTo(306.0, 241.0);
((GeneralPath)shape).lineTo(305.0, 236.0);
((GeneralPath)shape).lineTo(301.0, 237.0);
((GeneralPath)shape).lineTo(301.0, 234.0);
((GeneralPath)shape).lineTo(297.0, 235.0);
((GeneralPath)shape).lineTo(295.0, 232.0);
((GeneralPath)shape).lineTo(288.0, 234.0);
((GeneralPath)shape).lineTo(287.0, 229.0);
((GeneralPath)shape).lineTo(282.0, 233.0);
((GeneralPath)shape).lineTo(283.0, 235.0);
((GeneralPath)shape).lineTo(277.0, 233.0);
((GeneralPath)shape).lineTo(277.0, 231.0);
((GeneralPath)shape).lineTo(275.0, 233.0);
((GeneralPath)shape).lineTo(270.0, 231.0);
((GeneralPath)shape).lineTo(268.0, 232.0);
((GeneralPath)shape).lineTo(265.0, 229.0);
((GeneralPath)shape).lineTo(262.0, 232.0);
((GeneralPath)shape).lineTo(262.0, 230.0);
((GeneralPath)shape).lineTo(258.0, 230.0);
((GeneralPath)shape).lineTo(255.0, 227.0);
((GeneralPath)shape).lineTo(249.0, 229.0);
((GeneralPath)shape).lineTo(247.0, 227.0);
((GeneralPath)shape).lineTo(240.0, 227.0);
((GeneralPath)shape).lineTo(237.0, 232.0);
((GeneralPath)shape).lineTo(234.0, 226.0);
((GeneralPath)shape).lineTo(235.0, 222.0);
((GeneralPath)shape).lineTo(231.0, 222.0);
((GeneralPath)shape).lineTo(229.0, 224.0);
((GeneralPath)shape).lineTo(225.0, 222.0);
((GeneralPath)shape).lineTo(220.0, 223.0);
((GeneralPath)shape).lineTo(219.0, 220.0);
((GeneralPath)shape).lineTo(215.0, 221.0);
((GeneralPath)shape).lineTo(216.0, 211.0);
((GeneralPath)shape).lineTo(223.0, 215.0);
((GeneralPath)shape).lineTo(225.0, 205.0);
((GeneralPath)shape).lineTo(228.0, 203.0);
((GeneralPath)shape).lineTo(231.0, 205.0);
((GeneralPath)shape).lineTo(233.0, 203.0);
((GeneralPath)shape).lineTo(232.0, 191.0);
((GeneralPath)shape).lineTo(234.0, 190.0);
((GeneralPath)shape).lineTo(235.0, 185.0);
((GeneralPath)shape).lineTo(230.0, 182.0);
((GeneralPath)shape).lineTo(225.0, 184.0);
((GeneralPath)shape).lineTo(233.0, 163.0);
((GeneralPath)shape).lineTo(244.0, 163.0);
((GeneralPath)shape).lineTo(246.0, 159.0);
((GeneralPath)shape).lineTo(249.0, 161.0);
((GeneralPath)shape).lineTo(264.0, 161.0);
((GeneralPath)shape).lineTo(269.0, 158.0);
((GeneralPath)shape).lineTo(280.0, 142.0);
((GeneralPath)shape).lineTo(281.0, 148.0);
((GeneralPath)shape).lineTo(284.0, 142.0);
((GeneralPath)shape).lineTo(287.0, 141.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(288.0, 142.0);
((GeneralPath)shape).lineTo(291.0, 148.0);
((GeneralPath)shape).lineTo(290.0, 152.0);
((GeneralPath)shape).lineTo(300.0, 153.0);
((GeneralPath)shape).lineTo(302.0, 156.0);
((GeneralPath)shape).lineTo(307.0, 155.0);
((GeneralPath)shape).lineTo(309.0, 158.0);
((GeneralPath)shape).lineTo(312.0, 157.0);
((GeneralPath)shape).lineTo(314.0, 160.0);
((GeneralPath)shape).lineTo(318.0, 159.0);
((GeneralPath)shape).lineTo(316.0, 161.0);
((GeneralPath)shape).lineTo(321.0, 158.0);
((GeneralPath)shape).lineTo(326.0, 159.0);
((GeneralPath)shape).lineTo(336.0, 150.0);
((GeneralPath)shape).lineTo(347.0, 152.0);
((GeneralPath)shape).lineTo(350.0, 148.0);
((GeneralPath)shape).lineTo(359.0, 151.0);
((GeneralPath)shape).lineTo(364.0, 156.0);
((GeneralPath)shape).lineTo(366.0, 154.0);
((GeneralPath)shape).lineTo(380.0, 153.0);
((GeneralPath)shape).lineTo(382.0, 151.0);
((GeneralPath)shape).lineTo(386.0, 154.0);
((GeneralPath)shape).lineTo(388.0, 150.0);
((GeneralPath)shape).lineTo(392.0, 148.0);
((GeneralPath)shape).lineTo(396.0, 148.0);
((GeneralPath)shape).lineTo(402.0, 152.0);
((GeneralPath)shape).lineTo(405.0, 149.0);
((GeneralPath)shape).lineTo(409.0, 150.0);
((GeneralPath)shape).lineTo(410.0, 152.0);
((GeneralPath)shape).lineTo(414.0, 151.0);
((GeneralPath)shape).lineTo(414.0, 157.0);
((GeneralPath)shape).lineTo(421.0, 155.0);
((GeneralPath)shape).lineTo(422.0, 160.0);
((GeneralPath)shape).lineTo(426.0, 161.0);
((GeneralPath)shape).lineTo(426.0, 174.0);
((GeneralPath)shape).lineTo(420.0, 173.0);
((GeneralPath)shape).lineTo(417.0, 181.0);
((GeneralPath)shape).lineTo(413.0, 180.0);
((GeneralPath)shape).lineTo(407.0, 182.0);
((GeneralPath)shape).lineTo(403.0, 180.0);
((GeneralPath)shape).lineTo(400.0, 182.0);
((GeneralPath)shape).lineTo(393.0, 183.0);
((GeneralPath)shape).lineTo(392.0, 188.0);
((GeneralPath)shape).lineTo(381.0, 201.0);
((GeneralPath)shape).lineTo(381.0, 205.0);
((GeneralPath)shape).lineTo(376.0, 203.0);
((GeneralPath)shape).lineTo(375.0, 211.0);
((GeneralPath)shape).lineTo(371.0, 218.0);
((GeneralPath)shape).lineTo(363.0, 215.0);
((GeneralPath)shape).lineTo(363.0, 218.0);
((GeneralPath)shape).lineTo(356.0, 218.0);
((GeneralPath)shape).lineTo(351.0, 229.0);
((GeneralPath)shape).lineTo(360.0, 233.0);
((GeneralPath)shape).lineTo(358.0, 237.0);
((GeneralPath)shape).lineTo(364.0, 244.0);
((GeneralPath)shape).lineTo(357.0, 255.0);
((GeneralPath)shape).lineTo(356.0, 261.0);
((GeneralPath)shape).lineTo(351.0, 259.0);
((GeneralPath)shape).lineTo(349.0, 261.0);
((GeneralPath)shape).lineTo(347.0, 258.0);
((GeneralPath)shape).lineTo(347.0, 260.0);
((GeneralPath)shape).lineTo(342.0, 260.0);
((GeneralPath)shape).lineTo(343.0, 255.0);
((GeneralPath)shape).lineTo(337.0, 249.0);
((GeneralPath)shape).lineTo(333.0, 249.0);
((GeneralPath)shape).lineTo(329.0, 246.0);
((GeneralPath)shape).lineTo(325.0, 251.0);
((GeneralPath)shape).lineTo(314.0, 241.0);
((GeneralPath)shape).lineTo(306.0, 241.0);
((GeneralPath)shape).lineTo(305.0, 236.0);
((GeneralPath)shape).lineTo(301.0, 237.0);
((GeneralPath)shape).lineTo(301.0, 234.0);
((GeneralPath)shape).lineTo(297.0, 235.0);
((GeneralPath)shape).lineTo(295.0, 232.0);
((GeneralPath)shape).lineTo(288.0, 234.0);
((GeneralPath)shape).lineTo(287.0, 229.0);
((GeneralPath)shape).lineTo(282.0, 233.0);
((GeneralPath)shape).lineTo(283.0, 235.0);
((GeneralPath)shape).lineTo(277.0, 233.0);
((GeneralPath)shape).lineTo(277.0, 231.0);
((GeneralPath)shape).lineTo(275.0, 233.0);
((GeneralPath)shape).lineTo(270.0, 231.0);
((GeneralPath)shape).lineTo(268.0, 232.0);
((GeneralPath)shape).lineTo(265.0, 229.0);
((GeneralPath)shape).lineTo(262.0, 232.0);
((GeneralPath)shape).lineTo(262.0, 230.0);
((GeneralPath)shape).lineTo(258.0, 230.0);
((GeneralPath)shape).lineTo(255.0, 227.0);
((GeneralPath)shape).lineTo(249.0, 229.0);
((GeneralPath)shape).lineTo(247.0, 227.0);
((GeneralPath)shape).lineTo(240.0, 227.0);
((GeneralPath)shape).lineTo(237.0, 232.0);
((GeneralPath)shape).lineTo(234.0, 226.0);
((GeneralPath)shape).lineTo(235.0, 222.0);
((GeneralPath)shape).lineTo(231.0, 222.0);
((GeneralPath)shape).lineTo(229.0, 224.0);
((GeneralPath)shape).lineTo(225.0, 222.0);
((GeneralPath)shape).lineTo(220.0, 223.0);
((GeneralPath)shape).lineTo(219.0, 220.0);
((GeneralPath)shape).lineTo(215.0, 221.0);
((GeneralPath)shape).lineTo(216.0, 211.0);
((GeneralPath)shape).lineTo(223.0, 215.0);
((GeneralPath)shape).lineTo(225.0, 205.0);
((GeneralPath)shape).lineTo(228.0, 203.0);
((GeneralPath)shape).lineTo(231.0, 205.0);
((GeneralPath)shape).lineTo(233.0, 203.0);
((GeneralPath)shape).lineTo(232.0, 191.0);
((GeneralPath)shape).lineTo(234.0, 190.0);
((GeneralPath)shape).lineTo(235.0, 185.0);
((GeneralPath)shape).lineTo(230.0, 182.0);
((GeneralPath)shape).lineTo(225.0, 184.0);
((GeneralPath)shape).lineTo(233.0, 163.0);
((GeneralPath)shape).lineTo(244.0, 163.0);
((GeneralPath)shape).lineTo(246.0, 159.0);
((GeneralPath)shape).lineTo(249.0, 161.0);
((GeneralPath)shape).lineTo(264.0, 161.0);
((GeneralPath)shape).lineTo(269.0, 158.0);
((GeneralPath)shape).lineTo(280.0, 142.0);
((GeneralPath)shape).lineTo(281.0, 148.0);
((GeneralPath)shape).lineTo(284.0, 142.0);
((GeneralPath)shape).lineTo(287.0, 141.0);
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
        return 494;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 110;
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

