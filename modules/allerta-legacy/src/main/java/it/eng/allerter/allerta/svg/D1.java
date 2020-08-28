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
public class D1 {
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
((GeneralPath)shape).moveTo(519.0, 143.0);
((GeneralPath)shape).lineTo(531.0, 147.0);
((GeneralPath)shape).lineTo(538.0, 146.0);
((GeneralPath)shape).lineTo(538.0, 149.0);
((GeneralPath)shape).lineTo(540.0, 151.0);
((GeneralPath)shape).lineTo(538.0, 159.0);
((GeneralPath)shape).lineTo(536.0, 159.0);
((GeneralPath)shape).lineTo(536.0, 157.0);
((GeneralPath)shape).lineTo(529.0, 157.0);
((GeneralPath)shape).lineTo(529.0, 162.0);
((GeneralPath)shape).lineTo(526.0, 162.0);
((GeneralPath)shape).lineTo(525.0, 167.0);
((GeneralPath)shape).lineTo(528.0, 173.0);
((GeneralPath)shape).lineTo(521.0, 173.0);
((GeneralPath)shape).lineTo(524.0, 181.0);
((GeneralPath)shape).lineTo(526.0, 181.0);
((GeneralPath)shape).lineTo(527.0, 183.0);
((GeneralPath)shape).lineTo(529.0, 181.0);
((GeneralPath)shape).lineTo(537.0, 181.0);
((GeneralPath)shape).lineTo(538.0, 191.0);
((GeneralPath)shape).lineTo(540.0, 189.0);
((GeneralPath)shape).lineTo(543.0, 195.0);
((GeneralPath)shape).lineTo(546.0, 191.0);
((GeneralPath)shape).lineTo(548.0, 191.0);
((GeneralPath)shape).lineTo(547.0, 188.0);
((GeneralPath)shape).lineTo(551.0, 188.0);
((GeneralPath)shape).lineTo(553.0, 199.0);
((GeneralPath)shape).lineTo(550.0, 206.0);
((GeneralPath)shape).lineTo(544.0, 207.0);
((GeneralPath)shape).lineTo(540.0, 205.0);
((GeneralPath)shape).lineTo(541.0, 203.0);
((GeneralPath)shape).lineTo(539.0, 202.0);
((GeneralPath)shape).lineTo(537.0, 210.0);
((GeneralPath)shape).lineTo(539.0, 211.0);
((GeneralPath)shape).lineTo(537.0, 218.0);
((GeneralPath)shape).lineTo(541.0, 222.0);
((GeneralPath)shape).lineTo(523.0, 224.0);
((GeneralPath)shape).lineTo(515.0, 222.0);
((GeneralPath)shape).lineTo(512.0, 228.0);
((GeneralPath)shape).lineTo(544.0, 238.0);
((GeneralPath)shape).lineTo(548.0, 254.0);
((GeneralPath)shape).lineTo(539.0, 255.0);
((GeneralPath)shape).lineTo(533.0, 265.0);
((GeneralPath)shape).lineTo(532.0, 269.0);
((GeneralPath)shape).lineTo(534.0, 275.0);
((GeneralPath)shape).lineTo(527.0, 283.0);
((GeneralPath)shape).lineTo(524.0, 292.0);
((GeneralPath)shape).lineTo(520.0, 297.0);
((GeneralPath)shape).lineTo(513.0, 300.0);
((GeneralPath)shape).lineTo(509.0, 298.0);
((GeneralPath)shape).lineTo(506.0, 299.0);
((GeneralPath)shape).lineTo(502.0, 307.0);
((GeneralPath)shape).lineTo(496.0, 304.0);
((GeneralPath)shape).lineTo(494.0, 310.0);
((GeneralPath)shape).lineTo(491.0, 311.0);
((GeneralPath)shape).lineTo(487.0, 316.0);
((GeneralPath)shape).lineTo(483.0, 315.0);
((GeneralPath)shape).lineTo(483.0, 317.0);
((GeneralPath)shape).lineTo(481.0, 317.0);
((GeneralPath)shape).lineTo(482.0, 318.0);
((GeneralPath)shape).lineTo(478.0, 321.0);
((GeneralPath)shape).lineTo(473.0, 319.0);
((GeneralPath)shape).lineTo(472.0, 315.0);
((GeneralPath)shape).lineTo(467.0, 320.0);
((GeneralPath)shape).lineTo(463.0, 320.0);
((GeneralPath)shape).lineTo(465.0, 316.0);
((GeneralPath)shape).lineTo(460.0, 313.0);
((GeneralPath)shape).lineTo(459.0, 322.0);
((GeneralPath)shape).lineTo(457.0, 321.0);
((GeneralPath)shape).lineTo(456.0, 317.0);
((GeneralPath)shape).lineTo(453.0, 319.0);
((GeneralPath)shape).lineTo(450.0, 315.0);
((GeneralPath)shape).lineTo(445.0, 315.0);
((GeneralPath)shape).lineTo(444.0, 313.0);
((GeneralPath)shape).lineTo(445.0, 310.0);
((GeneralPath)shape).lineTo(448.0, 311.0);
((GeneralPath)shape).lineTo(446.0, 309.0);
((GeneralPath)shape).lineTo(447.0, 307.0);
((GeneralPath)shape).lineTo(459.0, 302.0);
((GeneralPath)shape).lineTo(456.0, 294.0);
((GeneralPath)shape).lineTo(459.0, 288.0);
((GeneralPath)shape).lineTo(461.0, 287.0);
((GeneralPath)shape).lineTo(456.0, 285.0);
((GeneralPath)shape).lineTo(454.0, 287.0);
((GeneralPath)shape).lineTo(448.0, 284.0);
((GeneralPath)shape).lineTo(451.0, 277.0);
((GeneralPath)shape).lineTo(441.0, 274.0);
((GeneralPath)shape).lineTo(434.0, 269.0);
((GeneralPath)shape).lineTo(432.0, 271.0);
((GeneralPath)shape).lineTo(427.0, 269.0);
((GeneralPath)shape).lineTo(425.0, 273.0);
((GeneralPath)shape).lineTo(418.0, 271.0);
((GeneralPath)shape).lineTo(418.0, 269.0);
((GeneralPath)shape).lineTo(411.0, 273.0);
((GeneralPath)shape).lineTo(411.0, 277.0);
((GeneralPath)shape).lineTo(406.0, 277.0);
((GeneralPath)shape).lineTo(406.0, 279.0);
((GeneralPath)shape).lineTo(404.0, 279.0);
((GeneralPath)shape).lineTo(401.0, 283.0);
((GeneralPath)shape).lineTo(399.0, 282.0);
((GeneralPath)shape).lineTo(399.0, 286.0);
((GeneralPath)shape).lineTo(396.0, 287.0);
((GeneralPath)shape).lineTo(391.0, 284.0);
((GeneralPath)shape).lineTo(390.0, 285.0);
((GeneralPath)shape).lineTo(391.0, 269.0);
((GeneralPath)shape).lineTo(386.0, 269.0);
((GeneralPath)shape).lineTo(380.0, 266.0);
((GeneralPath)shape).lineTo(382.0, 261.0);
((GeneralPath)shape).lineTo(379.0, 259.0);
((GeneralPath)shape).lineTo(374.0, 259.0);
((GeneralPath)shape).lineTo(373.0, 261.0);
((GeneralPath)shape).lineTo(370.0, 261.0);
((GeneralPath)shape).lineTo(371.0, 254.0);
((GeneralPath)shape).lineTo(361.0, 249.0);
((GeneralPath)shape).lineTo(365.0, 244.0);
((GeneralPath)shape).lineTo(359.0, 237.0);
((GeneralPath)shape).lineTo(361.0, 233.0);
((GeneralPath)shape).lineTo(352.0, 229.0);
((GeneralPath)shape).lineTo(357.0, 218.0);
((GeneralPath)shape).lineTo(364.0, 218.0);
((GeneralPath)shape).lineTo(364.0, 215.0);
((GeneralPath)shape).lineTo(372.0, 218.0);
((GeneralPath)shape).lineTo(376.0, 211.0);
((GeneralPath)shape).lineTo(377.0, 203.0);
((GeneralPath)shape).lineTo(382.0, 205.0);
((GeneralPath)shape).lineTo(382.0, 201.0);
((GeneralPath)shape).lineTo(393.0, 188.0);
((GeneralPath)shape).lineTo(394.0, 183.0);
((GeneralPath)shape).lineTo(401.0, 182.0);
((GeneralPath)shape).lineTo(404.0, 180.0);
((GeneralPath)shape).lineTo(408.0, 182.0);
((GeneralPath)shape).lineTo(414.0, 180.0);
((GeneralPath)shape).lineTo(418.0, 181.0);
((GeneralPath)shape).lineTo(421.0, 173.0);
((GeneralPath)shape).lineTo(427.0, 174.0);
((GeneralPath)shape).lineTo(427.0, 161.0);
((GeneralPath)shape).lineTo(423.0, 160.0);
((GeneralPath)shape).lineTo(422.0, 155.0);
((GeneralPath)shape).lineTo(436.0, 155.0);
((GeneralPath)shape).lineTo(444.0, 161.0);
((GeneralPath)shape).lineTo(446.0, 167.0);
((GeneralPath)shape).lineTo(450.0, 167.0);
((GeneralPath)shape).lineTo(460.0, 161.0);
((GeneralPath)shape).lineTo(471.0, 158.0);
((GeneralPath)shape).lineTo(474.0, 149.0);
((GeneralPath)shape).lineTo(480.0, 148.0);
((GeneralPath)shape).lineTo(484.0, 145.0);
((GeneralPath)shape).lineTo(505.0, 145.0);
((GeneralPath)shape).lineTo(513.0, 142.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(519.0, 143.0);
((GeneralPath)shape).lineTo(531.0, 147.0);
((GeneralPath)shape).lineTo(538.0, 146.0);
((GeneralPath)shape).lineTo(538.0, 149.0);
((GeneralPath)shape).lineTo(540.0, 151.0);
((GeneralPath)shape).lineTo(538.0, 159.0);
((GeneralPath)shape).lineTo(536.0, 159.0);
((GeneralPath)shape).lineTo(536.0, 157.0);
((GeneralPath)shape).lineTo(529.0, 157.0);
((GeneralPath)shape).lineTo(529.0, 162.0);
((GeneralPath)shape).lineTo(526.0, 162.0);
((GeneralPath)shape).lineTo(525.0, 167.0);
((GeneralPath)shape).lineTo(528.0, 173.0);
((GeneralPath)shape).lineTo(521.0, 173.0);
((GeneralPath)shape).lineTo(524.0, 181.0);
((GeneralPath)shape).lineTo(526.0, 181.0);
((GeneralPath)shape).lineTo(527.0, 183.0);
((GeneralPath)shape).lineTo(529.0, 181.0);
((GeneralPath)shape).lineTo(537.0, 181.0);
((GeneralPath)shape).lineTo(538.0, 191.0);
((GeneralPath)shape).lineTo(540.0, 189.0);
((GeneralPath)shape).lineTo(543.0, 195.0);
((GeneralPath)shape).lineTo(546.0, 191.0);
((GeneralPath)shape).lineTo(548.0, 191.0);
((GeneralPath)shape).lineTo(547.0, 188.0);
((GeneralPath)shape).lineTo(551.0, 188.0);
((GeneralPath)shape).lineTo(553.0, 199.0);
((GeneralPath)shape).lineTo(550.0, 206.0);
((GeneralPath)shape).lineTo(544.0, 207.0);
((GeneralPath)shape).lineTo(540.0, 205.0);
((GeneralPath)shape).lineTo(541.0, 203.0);
((GeneralPath)shape).lineTo(539.0, 202.0);
((GeneralPath)shape).lineTo(537.0, 210.0);
((GeneralPath)shape).lineTo(539.0, 211.0);
((GeneralPath)shape).lineTo(537.0, 218.0);
((GeneralPath)shape).lineTo(541.0, 222.0);
((GeneralPath)shape).lineTo(523.0, 224.0);
((GeneralPath)shape).lineTo(515.0, 222.0);
((GeneralPath)shape).lineTo(512.0, 228.0);
((GeneralPath)shape).lineTo(544.0, 238.0);
((GeneralPath)shape).lineTo(548.0, 254.0);
((GeneralPath)shape).lineTo(539.0, 255.0);
((GeneralPath)shape).lineTo(533.0, 265.0);
((GeneralPath)shape).lineTo(532.0, 269.0);
((GeneralPath)shape).lineTo(534.0, 275.0);
((GeneralPath)shape).lineTo(527.0, 283.0);
((GeneralPath)shape).lineTo(524.0, 292.0);
((GeneralPath)shape).lineTo(520.0, 297.0);
((GeneralPath)shape).lineTo(513.0, 300.0);
((GeneralPath)shape).lineTo(509.0, 298.0);
((GeneralPath)shape).lineTo(506.0, 299.0);
((GeneralPath)shape).lineTo(502.0, 307.0);
((GeneralPath)shape).lineTo(496.0, 304.0);
((GeneralPath)shape).lineTo(494.0, 310.0);
((GeneralPath)shape).lineTo(491.0, 311.0);
((GeneralPath)shape).lineTo(487.0, 316.0);
((GeneralPath)shape).lineTo(483.0, 315.0);
((GeneralPath)shape).lineTo(483.0, 317.0);
((GeneralPath)shape).lineTo(481.0, 317.0);
((GeneralPath)shape).lineTo(482.0, 318.0);
((GeneralPath)shape).lineTo(478.0, 321.0);
((GeneralPath)shape).lineTo(473.0, 319.0);
((GeneralPath)shape).lineTo(472.0, 315.0);
((GeneralPath)shape).lineTo(467.0, 320.0);
((GeneralPath)shape).lineTo(463.0, 320.0);
((GeneralPath)shape).lineTo(465.0, 316.0);
((GeneralPath)shape).lineTo(460.0, 313.0);
((GeneralPath)shape).lineTo(459.0, 322.0);
((GeneralPath)shape).lineTo(457.0, 321.0);
((GeneralPath)shape).lineTo(456.0, 317.0);
((GeneralPath)shape).lineTo(453.0, 319.0);
((GeneralPath)shape).lineTo(450.0, 315.0);
((GeneralPath)shape).lineTo(445.0, 315.0);
((GeneralPath)shape).lineTo(444.0, 313.0);
((GeneralPath)shape).lineTo(445.0, 310.0);
((GeneralPath)shape).lineTo(448.0, 311.0);
((GeneralPath)shape).lineTo(446.0, 309.0);
((GeneralPath)shape).lineTo(447.0, 307.0);
((GeneralPath)shape).lineTo(459.0, 302.0);
((GeneralPath)shape).lineTo(456.0, 294.0);
((GeneralPath)shape).lineTo(459.0, 288.0);
((GeneralPath)shape).lineTo(461.0, 287.0);
((GeneralPath)shape).lineTo(456.0, 285.0);
((GeneralPath)shape).lineTo(454.0, 287.0);
((GeneralPath)shape).lineTo(448.0, 284.0);
((GeneralPath)shape).lineTo(451.0, 277.0);
((GeneralPath)shape).lineTo(441.0, 274.0);
((GeneralPath)shape).lineTo(434.0, 269.0);
((GeneralPath)shape).lineTo(432.0, 271.0);
((GeneralPath)shape).lineTo(427.0, 269.0);
((GeneralPath)shape).lineTo(425.0, 273.0);
((GeneralPath)shape).lineTo(418.0, 271.0);
((GeneralPath)shape).lineTo(418.0, 269.0);
((GeneralPath)shape).lineTo(411.0, 273.0);
((GeneralPath)shape).lineTo(411.0, 277.0);
((GeneralPath)shape).lineTo(406.0, 277.0);
((GeneralPath)shape).lineTo(406.0, 279.0);
((GeneralPath)shape).lineTo(404.0, 279.0);
((GeneralPath)shape).lineTo(401.0, 283.0);
((GeneralPath)shape).lineTo(399.0, 282.0);
((GeneralPath)shape).lineTo(399.0, 286.0);
((GeneralPath)shape).lineTo(396.0, 287.0);
((GeneralPath)shape).lineTo(391.0, 284.0);
((GeneralPath)shape).lineTo(390.0, 285.0);
((GeneralPath)shape).lineTo(391.0, 269.0);
((GeneralPath)shape).lineTo(386.0, 269.0);
((GeneralPath)shape).lineTo(380.0, 266.0);
((GeneralPath)shape).lineTo(382.0, 261.0);
((GeneralPath)shape).lineTo(379.0, 259.0);
((GeneralPath)shape).lineTo(374.0, 259.0);
((GeneralPath)shape).lineTo(373.0, 261.0);
((GeneralPath)shape).lineTo(370.0, 261.0);
((GeneralPath)shape).lineTo(371.0, 254.0);
((GeneralPath)shape).lineTo(361.0, 249.0);
((GeneralPath)shape).lineTo(365.0, 244.0);
((GeneralPath)shape).lineTo(359.0, 237.0);
((GeneralPath)shape).lineTo(361.0, 233.0);
((GeneralPath)shape).lineTo(352.0, 229.0);
((GeneralPath)shape).lineTo(357.0, 218.0);
((GeneralPath)shape).lineTo(364.0, 218.0);
((GeneralPath)shape).lineTo(364.0, 215.0);
((GeneralPath)shape).lineTo(372.0, 218.0);
((GeneralPath)shape).lineTo(376.0, 211.0);
((GeneralPath)shape).lineTo(377.0, 203.0);
((GeneralPath)shape).lineTo(382.0, 205.0);
((GeneralPath)shape).lineTo(382.0, 201.0);
((GeneralPath)shape).lineTo(393.0, 188.0);
((GeneralPath)shape).lineTo(394.0, 183.0);
((GeneralPath)shape).lineTo(401.0, 182.0);
((GeneralPath)shape).lineTo(404.0, 180.0);
((GeneralPath)shape).lineTo(408.0, 182.0);
((GeneralPath)shape).lineTo(414.0, 180.0);
((GeneralPath)shape).lineTo(418.0, 181.0);
((GeneralPath)shape).lineTo(421.0, 173.0);
((GeneralPath)shape).lineTo(427.0, 174.0);
((GeneralPath)shape).lineTo(427.0, 161.0);
((GeneralPath)shape).lineTo(423.0, 160.0);
((GeneralPath)shape).lineTo(422.0, 155.0);
((GeneralPath)shape).lineTo(436.0, 155.0);
((GeneralPath)shape).lineTo(444.0, 161.0);
((GeneralPath)shape).lineTo(446.0, 167.0);
((GeneralPath)shape).lineTo(450.0, 167.0);
((GeneralPath)shape).lineTo(460.0, 161.0);
((GeneralPath)shape).lineTo(471.0, 158.0);
((GeneralPath)shape).lineTo(474.0, 149.0);
((GeneralPath)shape).lineTo(480.0, 148.0);
((GeneralPath)shape).lineTo(484.0, 145.0);
((GeneralPath)shape).lineTo(505.0, 145.0);
((GeneralPath)shape).lineTo(513.0, 142.0);
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
        return 531;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 294;
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

