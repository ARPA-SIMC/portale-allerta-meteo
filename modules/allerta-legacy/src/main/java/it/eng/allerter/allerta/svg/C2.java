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
public class C2 {
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
((GeneralPath)shape).moveTo(371.0, 254.0);
((GeneralPath)shape).lineTo(370.0, 261.0);
((GeneralPath)shape).lineTo(373.0, 261.0);
((GeneralPath)shape).lineTo(374.0, 259.0);
((GeneralPath)shape).lineTo(379.0, 259.0);
((GeneralPath)shape).lineTo(382.0, 261.0);
((GeneralPath)shape).lineTo(380.0, 266.0);
((GeneralPath)shape).lineTo(386.0, 269.0);
((GeneralPath)shape).lineTo(391.0, 269.0);
((GeneralPath)shape).lineTo(390.0, 285.0);
((GeneralPath)shape).lineTo(391.0, 284.0);
((GeneralPath)shape).lineTo(396.0, 287.0);
((GeneralPath)shape).lineTo(399.0, 286.0);
((GeneralPath)shape).lineTo(399.0, 282.0);
((GeneralPath)shape).lineTo(401.0, 283.0);
((GeneralPath)shape).lineTo(404.0, 279.0);
((GeneralPath)shape).lineTo(406.0, 279.0);
((GeneralPath)shape).lineTo(406.0, 277.0);
((GeneralPath)shape).lineTo(411.0, 277.0);
((GeneralPath)shape).lineTo(411.0, 273.0);
((GeneralPath)shape).lineTo(418.0, 269.0);
((GeneralPath)shape).lineTo(418.0, 271.0);
((GeneralPath)shape).lineTo(425.0, 273.0);
((GeneralPath)shape).lineTo(427.0, 269.0);
((GeneralPath)shape).lineTo(432.0, 271.0);
((GeneralPath)shape).lineTo(434.0, 269.0);
((GeneralPath)shape).lineTo(441.0, 274.0);
((GeneralPath)shape).lineTo(451.0, 277.0);
((GeneralPath)shape).lineTo(448.0, 284.0);
((GeneralPath)shape).lineTo(454.0, 287.0);
((GeneralPath)shape).lineTo(456.0, 285.0);
((GeneralPath)shape).lineTo(461.0, 287.0);
((GeneralPath)shape).lineTo(459.0, 288.0);
((GeneralPath)shape).lineTo(456.0, 294.0);
((GeneralPath)shape).lineTo(459.0, 302.0);
((GeneralPath)shape).lineTo(447.0, 307.0);
((GeneralPath)shape).lineTo(446.0, 309.0);
((GeneralPath)shape).lineTo(448.0, 311.0);
((GeneralPath)shape).lineTo(445.0, 310.0);
((GeneralPath)shape).lineTo(445.0, 315.0);
((GeneralPath)shape).lineTo(450.0, 315.0);
((GeneralPath)shape).lineTo(453.0, 319.0);
((GeneralPath)shape).lineTo(456.0, 317.0);
((GeneralPath)shape).lineTo(457.0, 321.0);
((GeneralPath)shape).lineTo(459.0, 322.0);
((GeneralPath)shape).lineTo(460.0, 314.0);
((GeneralPath)shape).lineTo(465.0, 316.0);
((GeneralPath)shape).lineTo(463.0, 320.0);
((GeneralPath)shape).lineTo(466.0, 321.0);
((GeneralPath)shape).lineTo(472.0, 315.0);
((GeneralPath)shape).lineTo(473.0, 319.0);
((GeneralPath)shape).lineTo(477.0, 321.0);
((GeneralPath)shape).lineTo(477.0, 325.0);
((GeneralPath)shape).lineTo(474.0, 324.0);
((GeneralPath)shape).lineTo(473.0, 328.0);
((GeneralPath)shape).lineTo(470.0, 330.0);
((GeneralPath)shape).lineTo(464.0, 330.0);
((GeneralPath)shape).lineTo(461.0, 335.0);
((GeneralPath)shape).lineTo(464.0, 336.0);
((GeneralPath)shape).lineTo(463.0, 339.0);
((GeneralPath)shape).lineTo(459.0, 342.0);
((GeneralPath)shape).lineTo(451.0, 353.0);
((GeneralPath)shape).lineTo(447.0, 354.0);
((GeneralPath)shape).lineTo(440.0, 351.0);
((GeneralPath)shape).lineTo(437.0, 355.0);
((GeneralPath)shape).lineTo(429.0, 353.0);
((GeneralPath)shape).lineTo(423.0, 347.0);
((GeneralPath)shape).lineTo(423.0, 345.0);
((GeneralPath)shape).lineTo(421.0, 346.0);
((GeneralPath)shape).lineTo(419.0, 343.0);
((GeneralPath)shape).lineTo(420.0, 338.0);
((GeneralPath)shape).lineTo(414.0, 333.0);
((GeneralPath)shape).lineTo(408.0, 340.0);
((GeneralPath)shape).lineTo(404.0, 331.0);
((GeneralPath)shape).lineTo(399.0, 332.0);
((GeneralPath)shape).lineTo(398.0, 334.0);
((GeneralPath)shape).lineTo(390.0, 329.0);
((GeneralPath)shape).lineTo(387.0, 335.0);
((GeneralPath)shape).lineTo(385.0, 334.0);
((GeneralPath)shape).lineTo(384.0, 336.0);
((GeneralPath)shape).lineTo(376.0, 330.0);
((GeneralPath)shape).lineTo(374.0, 332.0);
((GeneralPath)shape).lineTo(371.0, 331.0);
((GeneralPath)shape).lineTo(371.0, 334.0);
((GeneralPath)shape).lineTo(367.0, 335.0);
((GeneralPath)shape).lineTo(367.0, 341.0);
((GeneralPath)shape).lineTo(363.0, 343.0);
((GeneralPath)shape).lineTo(353.0, 340.0);
((GeneralPath)shape).lineTo(349.0, 340.0);
((GeneralPath)shape).lineTo(347.0, 343.0);
((GeneralPath)shape).lineTo(342.0, 341.0);
((GeneralPath)shape).lineTo(343.0, 337.0);
((GeneralPath)shape).lineTo(346.0, 336.0);
((GeneralPath)shape).lineTo(347.0, 329.0);
((GeneralPath)shape).lineTo(353.0, 324.0);
((GeneralPath)shape).lineTo(351.0, 321.0);
((GeneralPath)shape).lineTo(344.0, 318.0);
((GeneralPath)shape).lineTo(345.0, 313.0);
((GeneralPath)shape).lineTo(343.0, 312.0);
((GeneralPath)shape).lineTo(345.0, 307.0);
((GeneralPath)shape).lineTo(342.0, 304.0);
((GeneralPath)shape).lineTo(342.0, 299.0);
((GeneralPath)shape).lineTo(347.0, 288.0);
((GeneralPath)shape).lineTo(343.0, 285.0);
((GeneralPath)shape).lineTo(337.0, 285.0);
((GeneralPath)shape).lineTo(336.0, 282.0);
((GeneralPath)shape).lineTo(347.0, 274.0);
((GeneralPath)shape).lineTo(350.0, 267.0);
((GeneralPath)shape).lineTo(348.0, 258.0);
((GeneralPath)shape).lineTo(350.0, 261.0);
((GeneralPath)shape).lineTo(352.0, 259.0);
((GeneralPath)shape).lineTo(357.0, 261.0);
((GeneralPath)shape).lineTo(357.0, 255.0);
((GeneralPath)shape).lineTo(362.0, 250.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(371.0, 254.0);
((GeneralPath)shape).lineTo(370.0, 261.0);
((GeneralPath)shape).lineTo(373.0, 261.0);
((GeneralPath)shape).lineTo(374.0, 259.0);
((GeneralPath)shape).lineTo(379.0, 259.0);
((GeneralPath)shape).lineTo(382.0, 261.0);
((GeneralPath)shape).lineTo(380.0, 266.0);
((GeneralPath)shape).lineTo(386.0, 269.0);
((GeneralPath)shape).lineTo(391.0, 269.0);
((GeneralPath)shape).lineTo(390.0, 285.0);
((GeneralPath)shape).lineTo(391.0, 284.0);
((GeneralPath)shape).lineTo(396.0, 287.0);
((GeneralPath)shape).lineTo(399.0, 286.0);
((GeneralPath)shape).lineTo(399.0, 282.0);
((GeneralPath)shape).lineTo(401.0, 283.0);
((GeneralPath)shape).lineTo(404.0, 279.0);
((GeneralPath)shape).lineTo(406.0, 279.0);
((GeneralPath)shape).lineTo(406.0, 277.0);
((GeneralPath)shape).lineTo(411.0, 277.0);
((GeneralPath)shape).lineTo(411.0, 273.0);
((GeneralPath)shape).lineTo(418.0, 269.0);
((GeneralPath)shape).lineTo(418.0, 271.0);
((GeneralPath)shape).lineTo(425.0, 273.0);
((GeneralPath)shape).lineTo(427.0, 269.0);
((GeneralPath)shape).lineTo(432.0, 271.0);
((GeneralPath)shape).lineTo(434.0, 269.0);
((GeneralPath)shape).lineTo(441.0, 274.0);
((GeneralPath)shape).lineTo(451.0, 277.0);
((GeneralPath)shape).lineTo(448.0, 284.0);
((GeneralPath)shape).lineTo(454.0, 287.0);
((GeneralPath)shape).lineTo(456.0, 285.0);
((GeneralPath)shape).lineTo(461.0, 287.0);
((GeneralPath)shape).lineTo(459.0, 288.0);
((GeneralPath)shape).lineTo(456.0, 294.0);
((GeneralPath)shape).lineTo(459.0, 302.0);
((GeneralPath)shape).lineTo(447.0, 307.0);
((GeneralPath)shape).lineTo(446.0, 309.0);
((GeneralPath)shape).lineTo(448.0, 311.0);
((GeneralPath)shape).lineTo(445.0, 310.0);
((GeneralPath)shape).lineTo(445.0, 315.0);
((GeneralPath)shape).lineTo(450.0, 315.0);
((GeneralPath)shape).lineTo(453.0, 319.0);
((GeneralPath)shape).lineTo(456.0, 317.0);
((GeneralPath)shape).lineTo(457.0, 321.0);
((GeneralPath)shape).lineTo(459.0, 322.0);
((GeneralPath)shape).lineTo(460.0, 314.0);
((GeneralPath)shape).lineTo(465.0, 316.0);
((GeneralPath)shape).lineTo(463.0, 320.0);
((GeneralPath)shape).lineTo(466.0, 321.0);
((GeneralPath)shape).lineTo(472.0, 315.0);
((GeneralPath)shape).lineTo(473.0, 319.0);
((GeneralPath)shape).lineTo(477.0, 321.0);
((GeneralPath)shape).lineTo(477.0, 325.0);
((GeneralPath)shape).lineTo(474.0, 324.0);
((GeneralPath)shape).lineTo(473.0, 328.0);
((GeneralPath)shape).lineTo(470.0, 330.0);
((GeneralPath)shape).lineTo(464.0, 330.0);
((GeneralPath)shape).lineTo(461.0, 335.0);
((GeneralPath)shape).lineTo(464.0, 336.0);
((GeneralPath)shape).lineTo(463.0, 339.0);
((GeneralPath)shape).lineTo(459.0, 342.0);
((GeneralPath)shape).lineTo(451.0, 353.0);
((GeneralPath)shape).lineTo(447.0, 354.0);
((GeneralPath)shape).lineTo(440.0, 351.0);
((GeneralPath)shape).lineTo(437.0, 355.0);
((GeneralPath)shape).lineTo(429.0, 353.0);
((GeneralPath)shape).lineTo(423.0, 347.0);
((GeneralPath)shape).lineTo(423.0, 345.0);
((GeneralPath)shape).lineTo(421.0, 346.0);
((GeneralPath)shape).lineTo(419.0, 343.0);
((GeneralPath)shape).lineTo(420.0, 338.0);
((GeneralPath)shape).lineTo(414.0, 333.0);
((GeneralPath)shape).lineTo(408.0, 340.0);
((GeneralPath)shape).lineTo(404.0, 331.0);
((GeneralPath)shape).lineTo(399.0, 332.0);
((GeneralPath)shape).lineTo(398.0, 334.0);
((GeneralPath)shape).lineTo(390.0, 329.0);
((GeneralPath)shape).lineTo(387.0, 335.0);
((GeneralPath)shape).lineTo(385.0, 334.0);
((GeneralPath)shape).lineTo(384.0, 336.0);
((GeneralPath)shape).lineTo(376.0, 330.0);
((GeneralPath)shape).lineTo(374.0, 332.0);
((GeneralPath)shape).lineTo(371.0, 331.0);
((GeneralPath)shape).lineTo(371.0, 334.0);
((GeneralPath)shape).lineTo(367.0, 335.0);
((GeneralPath)shape).lineTo(367.0, 341.0);
((GeneralPath)shape).lineTo(363.0, 343.0);
((GeneralPath)shape).lineTo(353.0, 340.0);
((GeneralPath)shape).lineTo(349.0, 340.0);
((GeneralPath)shape).lineTo(347.0, 343.0);
((GeneralPath)shape).lineTo(342.0, 341.0);
((GeneralPath)shape).lineTo(343.0, 337.0);
((GeneralPath)shape).lineTo(346.0, 336.0);
((GeneralPath)shape).lineTo(347.0, 329.0);
((GeneralPath)shape).lineTo(353.0, 324.0);
((GeneralPath)shape).lineTo(351.0, 321.0);
((GeneralPath)shape).lineTo(344.0, 318.0);
((GeneralPath)shape).lineTo(345.0, 313.0);
((GeneralPath)shape).lineTo(343.0, 312.0);
((GeneralPath)shape).lineTo(345.0, 307.0);
((GeneralPath)shape).lineTo(342.0, 304.0);
((GeneralPath)shape).lineTo(342.0, 299.0);
((GeneralPath)shape).lineTo(347.0, 288.0);
((GeneralPath)shape).lineTo(343.0, 285.0);
((GeneralPath)shape).lineTo(337.0, 285.0);
((GeneralPath)shape).lineTo(336.0, 282.0);
((GeneralPath)shape).lineTo(347.0, 274.0);
((GeneralPath)shape).lineTo(350.0, 267.0);
((GeneralPath)shape).lineTo(348.0, 258.0);
((GeneralPath)shape).lineTo(350.0, 261.0);
((GeneralPath)shape).lineTo(352.0, 259.0);
((GeneralPath)shape).lineTo(357.0, 261.0);
((GeneralPath)shape).lineTo(357.0, 255.0);
((GeneralPath)shape).lineTo(362.0, 250.0);
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
        return 515;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 402;
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

