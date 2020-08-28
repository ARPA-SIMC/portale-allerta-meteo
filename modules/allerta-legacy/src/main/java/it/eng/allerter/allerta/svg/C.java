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
public class C {
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
((GeneralPath)shape).moveTo(370.0, 254.0);
((GeneralPath)shape).lineTo(369.0, 261.0);
((GeneralPath)shape).lineTo(372.0, 261.0);
((GeneralPath)shape).lineTo(373.0, 259.0);
((GeneralPath)shape).lineTo(378.0, 259.0);
((GeneralPath)shape).lineTo(381.0, 261.0);
((GeneralPath)shape).lineTo(379.0, 266.0);
((GeneralPath)shape).lineTo(385.0, 269.0);
((GeneralPath)shape).lineTo(390.0, 269.0);
((GeneralPath)shape).lineTo(389.0, 285.0);
((GeneralPath)shape).lineTo(390.0, 284.0);
((GeneralPath)shape).lineTo(395.0, 287.0);
((GeneralPath)shape).lineTo(398.0, 286.0);
((GeneralPath)shape).lineTo(398.0, 282.0);
((GeneralPath)shape).lineTo(400.0, 283.0);
((GeneralPath)shape).lineTo(403.0, 279.0);
((GeneralPath)shape).lineTo(405.0, 279.0);
((GeneralPath)shape).lineTo(405.0, 277.0);
((GeneralPath)shape).lineTo(410.0, 277.0);
((GeneralPath)shape).lineTo(410.0, 273.0);
((GeneralPath)shape).lineTo(417.0, 269.0);
((GeneralPath)shape).lineTo(417.0, 271.0);
((GeneralPath)shape).lineTo(424.0, 273.0);
((GeneralPath)shape).lineTo(426.0, 269.0);
((GeneralPath)shape).lineTo(431.0, 271.0);
((GeneralPath)shape).lineTo(433.0, 269.0);
((GeneralPath)shape).lineTo(440.0, 274.0);
((GeneralPath)shape).lineTo(450.0, 277.0);
((GeneralPath)shape).lineTo(447.0, 284.0);
((GeneralPath)shape).lineTo(453.0, 287.0);
((GeneralPath)shape).lineTo(455.0, 285.0);
((GeneralPath)shape).lineTo(460.0, 287.0);
((GeneralPath)shape).lineTo(458.0, 288.0);
((GeneralPath)shape).lineTo(455.0, 294.0);
((GeneralPath)shape).lineTo(458.0, 302.0);
((GeneralPath)shape).lineTo(446.0, 307.0);
((GeneralPath)shape).lineTo(445.0, 309.0);
((GeneralPath)shape).lineTo(447.0, 311.0);
((GeneralPath)shape).lineTo(444.0, 310.0);
((GeneralPath)shape).lineTo(444.0, 315.0);
((GeneralPath)shape).lineTo(449.0, 315.0);
((GeneralPath)shape).lineTo(452.0, 319.0);
((GeneralPath)shape).lineTo(455.0, 317.0);
((GeneralPath)shape).lineTo(456.0, 321.0);
((GeneralPath)shape).lineTo(458.0, 322.0);
((GeneralPath)shape).lineTo(459.0, 314.0);
((GeneralPath)shape).lineTo(464.0, 316.0);
((GeneralPath)shape).lineTo(462.0, 320.0);
((GeneralPath)shape).lineTo(465.0, 321.0);
((GeneralPath)shape).lineTo(471.0, 315.0);
((GeneralPath)shape).lineTo(472.0, 319.0);
((GeneralPath)shape).lineTo(476.0, 321.0);
((GeneralPath)shape).lineTo(476.0, 324.0);
((GeneralPath)shape).lineTo(473.0, 324.0);
((GeneralPath)shape).lineTo(471.0, 329.0);
((GeneralPath)shape).lineTo(463.0, 330.0);
((GeneralPath)shape).lineTo(460.0, 335.0);
((GeneralPath)shape).lineTo(463.0, 337.0);
((GeneralPath)shape).lineTo(449.0, 354.0);
((GeneralPath)shape).lineTo(441.0, 353.0);
((GeneralPath)shape).lineTo(439.0, 351.0);
((GeneralPath)shape).lineTo(436.0, 355.0);
((GeneralPath)shape).lineTo(428.0, 353.0);
((GeneralPath)shape).lineTo(425.0, 347.0);
((GeneralPath)shape).lineTo(422.0, 347.0);
((GeneralPath)shape).lineTo(422.0, 345.0);
((GeneralPath)shape).lineTo(420.0, 346.0);
((GeneralPath)shape).lineTo(418.0, 343.0);
((GeneralPath)shape).lineTo(419.0, 338.0);
((GeneralPath)shape).lineTo(413.0, 333.0);
((GeneralPath)shape).lineTo(406.0, 343.0);
((GeneralPath)shape).lineTo(397.0, 343.0);
((GeneralPath)shape).lineTo(395.0, 348.0);
((GeneralPath)shape).lineTo(390.0, 350.0);
((GeneralPath)shape).lineTo(388.0, 355.0);
((GeneralPath)shape).lineTo(380.0, 354.0);
((GeneralPath)shape).lineTo(372.0, 356.0);
((GeneralPath)shape).lineTo(372.0, 358.0);
((GeneralPath)shape).lineTo(384.0, 365.0);
((GeneralPath)shape).lineTo(385.0, 367.0);
((GeneralPath)shape).lineTo(382.0, 369.0);
((GeneralPath)shape).lineTo(374.0, 369.0);
((GeneralPath)shape).lineTo(366.0, 365.0);
((GeneralPath)shape).lineTo(360.0, 366.0);
((GeneralPath)shape).lineTo(353.0, 371.0);
((GeneralPath)shape).lineTo(346.0, 371.0);
((GeneralPath)shape).lineTo(337.0, 366.0);
((GeneralPath)shape).lineTo(339.0, 359.0);
((GeneralPath)shape).lineTo(333.0, 363.0);
((GeneralPath)shape).lineTo(327.0, 373.0);
((GeneralPath)shape).lineTo(323.0, 375.0);
((GeneralPath)shape).lineTo(322.0, 378.0);
((GeneralPath)shape).lineTo(319.0, 378.0);
((GeneralPath)shape).lineTo(319.0, 372.0);
((GeneralPath)shape).lineTo(314.0, 369.0);
((GeneralPath)shape).lineTo(309.0, 369.0);
((GeneralPath)shape).lineTo(306.0, 364.0);
((GeneralPath)shape).lineTo(303.0, 365.0);
((GeneralPath)shape).lineTo(301.0, 359.0);
((GeneralPath)shape).lineTo(304.0, 348.0);
((GeneralPath)shape).lineTo(310.0, 341.0);
((GeneralPath)shape).lineTo(309.0, 336.0);
((GeneralPath)shape).lineTo(311.0, 335.0);
((GeneralPath)shape).lineTo(317.0, 337.0);
((GeneralPath)shape).lineTo(317.0, 340.0);
((GeneralPath)shape).lineTo(320.0, 342.0);
((GeneralPath)shape).lineTo(325.0, 337.0);
((GeneralPath)shape).lineTo(329.0, 337.0);
((GeneralPath)shape).lineTo(331.0, 332.0);
((GeneralPath)shape).lineTo(330.0, 325.0);
((GeneralPath)shape).lineTo(332.0, 324.0);
((GeneralPath)shape).lineTo(329.0, 324.0);
((GeneralPath)shape).lineTo(327.0, 320.0);
((GeneralPath)shape).lineTo(337.0, 316.0);
((GeneralPath)shape).lineTo(338.0, 318.0);
((GeneralPath)shape).lineTo(344.0, 310.0);
((GeneralPath)shape).lineTo(341.0, 299.0);
((GeneralPath)shape).lineTo(346.0, 288.0);
((GeneralPath)shape).lineTo(342.0, 285.0);
((GeneralPath)shape).lineTo(336.0, 285.0);
((GeneralPath)shape).lineTo(335.0, 282.0);
((GeneralPath)shape).lineTo(346.0, 274.0);
((GeneralPath)shape).lineTo(349.0, 267.0);
((GeneralPath)shape).lineTo(346.0, 259.0);
((GeneralPath)shape).lineTo(349.0, 261.0);
((GeneralPath)shape).lineTo(351.0, 259.0);
((GeneralPath)shape).lineTo(356.0, 261.0);
((GeneralPath)shape).lineTo(356.0, 255.0);
((GeneralPath)shape).lineTo(361.0, 250.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(370.0, 254.0);
((GeneralPath)shape).lineTo(369.0, 261.0);
((GeneralPath)shape).lineTo(372.0, 261.0);
((GeneralPath)shape).lineTo(373.0, 259.0);
((GeneralPath)shape).lineTo(378.0, 259.0);
((GeneralPath)shape).lineTo(381.0, 261.0);
((GeneralPath)shape).lineTo(379.0, 266.0);
((GeneralPath)shape).lineTo(385.0, 269.0);
((GeneralPath)shape).lineTo(390.0, 269.0);
((GeneralPath)shape).lineTo(389.0, 285.0);
((GeneralPath)shape).lineTo(390.0, 284.0);
((GeneralPath)shape).lineTo(395.0, 287.0);
((GeneralPath)shape).lineTo(398.0, 286.0);
((GeneralPath)shape).lineTo(398.0, 282.0);
((GeneralPath)shape).lineTo(400.0, 283.0);
((GeneralPath)shape).lineTo(403.0, 279.0);
((GeneralPath)shape).lineTo(405.0, 279.0);
((GeneralPath)shape).lineTo(405.0, 277.0);
((GeneralPath)shape).lineTo(410.0, 277.0);
((GeneralPath)shape).lineTo(410.0, 273.0);
((GeneralPath)shape).lineTo(417.0, 269.0);
((GeneralPath)shape).lineTo(417.0, 271.0);
((GeneralPath)shape).lineTo(424.0, 273.0);
((GeneralPath)shape).lineTo(426.0, 269.0);
((GeneralPath)shape).lineTo(431.0, 271.0);
((GeneralPath)shape).lineTo(433.0, 269.0);
((GeneralPath)shape).lineTo(440.0, 274.0);
((GeneralPath)shape).lineTo(450.0, 277.0);
((GeneralPath)shape).lineTo(447.0, 284.0);
((GeneralPath)shape).lineTo(453.0, 287.0);
((GeneralPath)shape).lineTo(455.0, 285.0);
((GeneralPath)shape).lineTo(460.0, 287.0);
((GeneralPath)shape).lineTo(458.0, 288.0);
((GeneralPath)shape).lineTo(455.0, 294.0);
((GeneralPath)shape).lineTo(458.0, 302.0);
((GeneralPath)shape).lineTo(446.0, 307.0);
((GeneralPath)shape).lineTo(445.0, 309.0);
((GeneralPath)shape).lineTo(447.0, 311.0);
((GeneralPath)shape).lineTo(444.0, 310.0);
((GeneralPath)shape).lineTo(444.0, 315.0);
((GeneralPath)shape).lineTo(449.0, 315.0);
((GeneralPath)shape).lineTo(452.0, 319.0);
((GeneralPath)shape).lineTo(455.0, 317.0);
((GeneralPath)shape).lineTo(456.0, 321.0);
((GeneralPath)shape).lineTo(458.0, 322.0);
((GeneralPath)shape).lineTo(459.0, 314.0);
((GeneralPath)shape).lineTo(464.0, 316.0);
((GeneralPath)shape).lineTo(462.0, 320.0);
((GeneralPath)shape).lineTo(465.0, 321.0);
((GeneralPath)shape).lineTo(471.0, 315.0);
((GeneralPath)shape).lineTo(472.0, 319.0);
((GeneralPath)shape).lineTo(476.0, 321.0);
((GeneralPath)shape).lineTo(476.0, 324.0);
((GeneralPath)shape).lineTo(473.0, 324.0);
((GeneralPath)shape).lineTo(471.0, 329.0);
((GeneralPath)shape).lineTo(463.0, 330.0);
((GeneralPath)shape).lineTo(460.0, 335.0);
((GeneralPath)shape).lineTo(463.0, 337.0);
((GeneralPath)shape).lineTo(449.0, 354.0);
((GeneralPath)shape).lineTo(441.0, 353.0);
((GeneralPath)shape).lineTo(439.0, 351.0);
((GeneralPath)shape).lineTo(436.0, 355.0);
((GeneralPath)shape).lineTo(428.0, 353.0);
((GeneralPath)shape).lineTo(425.0, 347.0);
((GeneralPath)shape).lineTo(422.0, 347.0);
((GeneralPath)shape).lineTo(422.0, 345.0);
((GeneralPath)shape).lineTo(420.0, 346.0);
((GeneralPath)shape).lineTo(418.0, 343.0);
((GeneralPath)shape).lineTo(419.0, 338.0);
((GeneralPath)shape).lineTo(413.0, 333.0);
((GeneralPath)shape).lineTo(406.0, 343.0);
((GeneralPath)shape).lineTo(397.0, 343.0);
((GeneralPath)shape).lineTo(395.0, 348.0);
((GeneralPath)shape).lineTo(390.0, 350.0);
((GeneralPath)shape).lineTo(388.0, 355.0);
((GeneralPath)shape).lineTo(380.0, 354.0);
((GeneralPath)shape).lineTo(372.0, 356.0);
((GeneralPath)shape).lineTo(372.0, 358.0);
((GeneralPath)shape).lineTo(384.0, 365.0);
((GeneralPath)shape).lineTo(385.0, 367.0);
((GeneralPath)shape).lineTo(382.0, 369.0);
((GeneralPath)shape).lineTo(374.0, 369.0);
((GeneralPath)shape).lineTo(366.0, 365.0);
((GeneralPath)shape).lineTo(360.0, 366.0);
((GeneralPath)shape).lineTo(353.0, 371.0);
((GeneralPath)shape).lineTo(346.0, 371.0);
((GeneralPath)shape).lineTo(337.0, 366.0);
((GeneralPath)shape).lineTo(339.0, 359.0);
((GeneralPath)shape).lineTo(333.0, 363.0);
((GeneralPath)shape).lineTo(327.0, 373.0);
((GeneralPath)shape).lineTo(323.0, 375.0);
((GeneralPath)shape).lineTo(322.0, 378.0);
((GeneralPath)shape).lineTo(319.0, 378.0);
((GeneralPath)shape).lineTo(319.0, 372.0);
((GeneralPath)shape).lineTo(314.0, 369.0);
((GeneralPath)shape).lineTo(309.0, 369.0);
((GeneralPath)shape).lineTo(306.0, 364.0);
((GeneralPath)shape).lineTo(303.0, 365.0);
((GeneralPath)shape).lineTo(301.0, 359.0);
((GeneralPath)shape).lineTo(304.0, 348.0);
((GeneralPath)shape).lineTo(310.0, 341.0);
((GeneralPath)shape).lineTo(309.0, 336.0);
((GeneralPath)shape).lineTo(311.0, 335.0);
((GeneralPath)shape).lineTo(317.0, 337.0);
((GeneralPath)shape).lineTo(317.0, 340.0);
((GeneralPath)shape).lineTo(320.0, 342.0);
((GeneralPath)shape).lineTo(325.0, 337.0);
((GeneralPath)shape).lineTo(329.0, 337.0);
((GeneralPath)shape).lineTo(331.0, 332.0);
((GeneralPath)shape).lineTo(330.0, 325.0);
((GeneralPath)shape).lineTo(332.0, 324.0);
((GeneralPath)shape).lineTo(329.0, 324.0);
((GeneralPath)shape).lineTo(327.0, 320.0);
((GeneralPath)shape).lineTo(337.0, 316.0);
((GeneralPath)shape).lineTo(338.0, 318.0);
((GeneralPath)shape).lineTo(344.0, 310.0);
((GeneralPath)shape).lineTo(341.0, 299.0);
((GeneralPath)shape).lineTo(346.0, 288.0);
((GeneralPath)shape).lineTo(342.0, 285.0);
((GeneralPath)shape).lineTo(336.0, 285.0);
((GeneralPath)shape).lineTo(335.0, 282.0);
((GeneralPath)shape).lineTo(346.0, 274.0);
((GeneralPath)shape).lineTo(349.0, 267.0);
((GeneralPath)shape).lineTo(346.0, 259.0);
((GeneralPath)shape).lineTo(349.0, 261.0);
((GeneralPath)shape).lineTo(351.0, 259.0);
((GeneralPath)shape).lineTo(356.0, 261.0);
((GeneralPath)shape).lineTo(356.0, 255.0);
((GeneralPath)shape).lineTo(361.0, 250.0);
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
        return 580;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 219;
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

