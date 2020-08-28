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
public class D {
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
((GeneralPath)shape).moveTo(518.0, 143.0);
((GeneralPath)shape).lineTo(530.0, 147.0);
((GeneralPath)shape).lineTo(537.0, 146.0);
((GeneralPath)shape).lineTo(542.0, 156.0);
((GeneralPath)shape).lineTo(545.0, 157.0);
((GeneralPath)shape).lineTo(550.0, 154.0);
((GeneralPath)shape).lineTo(553.0, 158.0);
((GeneralPath)shape).lineTo(560.0, 159.0);
((GeneralPath)shape).lineTo(562.0, 155.0);
((GeneralPath)shape).lineTo(565.0, 155.0);
((GeneralPath)shape).lineTo(565.0, 153.0);
((GeneralPath)shape).lineTo(566.0, 155.0);
((GeneralPath)shape).lineTo(570.0, 154.0);
((GeneralPath)shape).lineTo(572.0, 158.0);
((GeneralPath)shape).lineTo(570.0, 162.0);
((GeneralPath)shape).lineTo(572.0, 175.0);
((GeneralPath)shape).lineTo(581.0, 177.0);
((GeneralPath)shape).lineTo(583.0, 186.0);
((GeneralPath)shape).lineTo(591.0, 192.0);
((GeneralPath)shape).lineTo(589.0, 194.0);
((GeneralPath)shape).lineTo(575.0, 190.0);
((GeneralPath)shape).lineTo(578.0, 189.0);
((GeneralPath)shape).lineTo(580.0, 186.0);
((GeneralPath)shape).lineTo(576.0, 179.0);
((GeneralPath)shape).lineTo(571.0, 180.0);
((GeneralPath)shape).lineTo(567.0, 185.0);
((GeneralPath)shape).lineTo(566.0, 187.0);
((GeneralPath)shape).lineTo(570.0, 184.0);
((GeneralPath)shape).lineTo(565.0, 199.0);
((GeneralPath)shape).lineTo(563.0, 215.0);
((GeneralPath)shape).lineTo(565.0, 230.0);
((GeneralPath)shape).lineTo(568.0, 234.0);
((GeneralPath)shape).lineTo(562.0, 236.0);
((GeneralPath)shape).lineTo(547.0, 254.0);
((GeneralPath)shape).lineTo(538.0, 256.0);
((GeneralPath)shape).lineTo(531.0, 269.0);
((GeneralPath)shape).lineTo(533.0, 275.0);
((GeneralPath)shape).lineTo(526.0, 283.0);
((GeneralPath)shape).lineTo(523.0, 292.0);
((GeneralPath)shape).lineTo(519.0, 297.0);
((GeneralPath)shape).lineTo(512.0, 300.0);
((GeneralPath)shape).lineTo(508.0, 298.0);
((GeneralPath)shape).lineTo(505.0, 299.0);
((GeneralPath)shape).lineTo(501.0, 307.0);
((GeneralPath)shape).lineTo(495.0, 304.0);
((GeneralPath)shape).lineTo(493.0, 310.0);
((GeneralPath)shape).lineTo(490.0, 311.0);
((GeneralPath)shape).lineTo(486.0, 316.0);
((GeneralPath)shape).lineTo(482.0, 315.0);
((GeneralPath)shape).lineTo(482.0, 317.0);
((GeneralPath)shape).lineTo(480.0, 317.0);
((GeneralPath)shape).lineTo(481.0, 318.0);
((GeneralPath)shape).lineTo(477.0, 321.0);
((GeneralPath)shape).lineTo(472.0, 319.0);
((GeneralPath)shape).lineTo(471.0, 315.0);
((GeneralPath)shape).lineTo(466.0, 320.0);
((GeneralPath)shape).lineTo(462.0, 320.0);
((GeneralPath)shape).lineTo(464.0, 316.0);
((GeneralPath)shape).lineTo(459.0, 313.0);
((GeneralPath)shape).lineTo(458.0, 322.0);
((GeneralPath)shape).lineTo(456.0, 321.0);
((GeneralPath)shape).lineTo(455.0, 317.0);
((GeneralPath)shape).lineTo(452.0, 319.0);
((GeneralPath)shape).lineTo(449.0, 315.0);
((GeneralPath)shape).lineTo(444.0, 315.0);
((GeneralPath)shape).lineTo(443.0, 313.0);
((GeneralPath)shape).lineTo(444.0, 310.0);
((GeneralPath)shape).lineTo(447.0, 311.0);
((GeneralPath)shape).lineTo(445.0, 309.0);
((GeneralPath)shape).lineTo(446.0, 307.0);
((GeneralPath)shape).lineTo(458.0, 302.0);
((GeneralPath)shape).lineTo(455.0, 294.0);
((GeneralPath)shape).lineTo(458.0, 288.0);
((GeneralPath)shape).lineTo(460.0, 287.0);
((GeneralPath)shape).lineTo(455.0, 285.0);
((GeneralPath)shape).lineTo(453.0, 287.0);
((GeneralPath)shape).lineTo(447.0, 284.0);
((GeneralPath)shape).lineTo(450.0, 277.0);
((GeneralPath)shape).lineTo(440.0, 274.0);
((GeneralPath)shape).lineTo(433.0, 269.0);
((GeneralPath)shape).lineTo(431.0, 271.0);
((GeneralPath)shape).lineTo(426.0, 269.0);
((GeneralPath)shape).lineTo(424.0, 273.0);
((GeneralPath)shape).lineTo(417.0, 271.0);
((GeneralPath)shape).lineTo(417.0, 269.0);
((GeneralPath)shape).lineTo(410.0, 273.0);
((GeneralPath)shape).lineTo(410.0, 277.0);
((GeneralPath)shape).lineTo(405.0, 277.0);
((GeneralPath)shape).lineTo(405.0, 279.0);
((GeneralPath)shape).lineTo(403.0, 279.0);
((GeneralPath)shape).lineTo(400.0, 283.0);
((GeneralPath)shape).lineTo(398.0, 282.0);
((GeneralPath)shape).lineTo(398.0, 286.0);
((GeneralPath)shape).lineTo(395.0, 287.0);
((GeneralPath)shape).lineTo(390.0, 284.0);
((GeneralPath)shape).lineTo(389.0, 285.0);
((GeneralPath)shape).lineTo(390.0, 269.0);
((GeneralPath)shape).lineTo(385.0, 269.0);
((GeneralPath)shape).lineTo(379.0, 266.0);
((GeneralPath)shape).lineTo(381.0, 261.0);
((GeneralPath)shape).lineTo(378.0, 259.0);
((GeneralPath)shape).lineTo(373.0, 259.0);
((GeneralPath)shape).lineTo(372.0, 261.0);
((GeneralPath)shape).lineTo(369.0, 261.0);
((GeneralPath)shape).lineTo(370.0, 254.0);
((GeneralPath)shape).lineTo(360.0, 249.0);
((GeneralPath)shape).lineTo(364.0, 244.0);
((GeneralPath)shape).lineTo(358.0, 237.0);
((GeneralPath)shape).lineTo(360.0, 233.0);
((GeneralPath)shape).lineTo(351.0, 229.0);
((GeneralPath)shape).lineTo(356.0, 218.0);
((GeneralPath)shape).lineTo(363.0, 218.0);
((GeneralPath)shape).lineTo(363.0, 215.0);
((GeneralPath)shape).lineTo(371.0, 218.0);
((GeneralPath)shape).lineTo(375.0, 211.0);
((GeneralPath)shape).lineTo(376.0, 203.0);
((GeneralPath)shape).lineTo(381.0, 205.0);
((GeneralPath)shape).lineTo(381.0, 201.0);
((GeneralPath)shape).lineTo(392.0, 188.0);
((GeneralPath)shape).lineTo(393.0, 183.0);
((GeneralPath)shape).lineTo(400.0, 182.0);
((GeneralPath)shape).lineTo(403.0, 180.0);
((GeneralPath)shape).lineTo(407.0, 182.0);
((GeneralPath)shape).lineTo(413.0, 180.0);
((GeneralPath)shape).lineTo(417.0, 181.0);
((GeneralPath)shape).lineTo(420.0, 173.0);
((GeneralPath)shape).lineTo(426.0, 174.0);
((GeneralPath)shape).lineTo(426.0, 161.0);
((GeneralPath)shape).lineTo(422.0, 160.0);
((GeneralPath)shape).lineTo(421.0, 155.0);
((GeneralPath)shape).lineTo(435.0, 155.0);
((GeneralPath)shape).lineTo(443.0, 161.0);
((GeneralPath)shape).lineTo(445.0, 167.0);
((GeneralPath)shape).lineTo(449.0, 167.0);
((GeneralPath)shape).lineTo(459.0, 161.0);
((GeneralPath)shape).lineTo(470.0, 158.0);
((GeneralPath)shape).lineTo(473.0, 149.0);
((GeneralPath)shape).lineTo(479.0, 148.0);
((GeneralPath)shape).lineTo(483.0, 145.0);
((GeneralPath)shape).lineTo(504.0, 145.0);
((GeneralPath)shape).lineTo(512.0, 142.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(518.0, 143.0);
((GeneralPath)shape).lineTo(530.0, 147.0);
((GeneralPath)shape).lineTo(537.0, 146.0);
((GeneralPath)shape).lineTo(542.0, 156.0);
((GeneralPath)shape).lineTo(545.0, 157.0);
((GeneralPath)shape).lineTo(550.0, 154.0);
((GeneralPath)shape).lineTo(553.0, 158.0);
((GeneralPath)shape).lineTo(560.0, 159.0);
((GeneralPath)shape).lineTo(562.0, 155.0);
((GeneralPath)shape).lineTo(565.0, 155.0);
((GeneralPath)shape).lineTo(565.0, 153.0);
((GeneralPath)shape).lineTo(566.0, 155.0);
((GeneralPath)shape).lineTo(570.0, 154.0);
((GeneralPath)shape).lineTo(572.0, 158.0);
((GeneralPath)shape).lineTo(570.0, 162.0);
((GeneralPath)shape).lineTo(572.0, 175.0);
((GeneralPath)shape).lineTo(581.0, 177.0);
((GeneralPath)shape).lineTo(583.0, 186.0);
((GeneralPath)shape).lineTo(591.0, 192.0);
((GeneralPath)shape).lineTo(589.0, 194.0);
((GeneralPath)shape).lineTo(575.0, 190.0);
((GeneralPath)shape).lineTo(578.0, 189.0);
((GeneralPath)shape).lineTo(580.0, 186.0);
((GeneralPath)shape).lineTo(576.0, 179.0);
((GeneralPath)shape).lineTo(571.0, 180.0);
((GeneralPath)shape).lineTo(567.0, 185.0);
((GeneralPath)shape).lineTo(566.0, 187.0);
((GeneralPath)shape).lineTo(570.0, 184.0);
((GeneralPath)shape).lineTo(565.0, 199.0);
((GeneralPath)shape).lineTo(563.0, 215.0);
((GeneralPath)shape).lineTo(565.0, 230.0);
((GeneralPath)shape).lineTo(568.0, 234.0);
((GeneralPath)shape).lineTo(562.0, 236.0);
((GeneralPath)shape).lineTo(547.0, 254.0);
((GeneralPath)shape).lineTo(538.0, 256.0);
((GeneralPath)shape).lineTo(531.0, 269.0);
((GeneralPath)shape).lineTo(533.0, 275.0);
((GeneralPath)shape).lineTo(526.0, 283.0);
((GeneralPath)shape).lineTo(523.0, 292.0);
((GeneralPath)shape).lineTo(519.0, 297.0);
((GeneralPath)shape).lineTo(512.0, 300.0);
((GeneralPath)shape).lineTo(508.0, 298.0);
((GeneralPath)shape).lineTo(505.0, 299.0);
((GeneralPath)shape).lineTo(501.0, 307.0);
((GeneralPath)shape).lineTo(495.0, 304.0);
((GeneralPath)shape).lineTo(493.0, 310.0);
((GeneralPath)shape).lineTo(490.0, 311.0);
((GeneralPath)shape).lineTo(486.0, 316.0);
((GeneralPath)shape).lineTo(482.0, 315.0);
((GeneralPath)shape).lineTo(482.0, 317.0);
((GeneralPath)shape).lineTo(480.0, 317.0);
((GeneralPath)shape).lineTo(481.0, 318.0);
((GeneralPath)shape).lineTo(477.0, 321.0);
((GeneralPath)shape).lineTo(472.0, 319.0);
((GeneralPath)shape).lineTo(471.0, 315.0);
((GeneralPath)shape).lineTo(466.0, 320.0);
((GeneralPath)shape).lineTo(462.0, 320.0);
((GeneralPath)shape).lineTo(464.0, 316.0);
((GeneralPath)shape).lineTo(459.0, 313.0);
((GeneralPath)shape).lineTo(458.0, 322.0);
((GeneralPath)shape).lineTo(456.0, 321.0);
((GeneralPath)shape).lineTo(455.0, 317.0);
((GeneralPath)shape).lineTo(452.0, 319.0);
((GeneralPath)shape).lineTo(449.0, 315.0);
((GeneralPath)shape).lineTo(444.0, 315.0);
((GeneralPath)shape).lineTo(443.0, 313.0);
((GeneralPath)shape).lineTo(444.0, 310.0);
((GeneralPath)shape).lineTo(447.0, 311.0);
((GeneralPath)shape).lineTo(445.0, 309.0);
((GeneralPath)shape).lineTo(446.0, 307.0);
((GeneralPath)shape).lineTo(458.0, 302.0);
((GeneralPath)shape).lineTo(455.0, 294.0);
((GeneralPath)shape).lineTo(458.0, 288.0);
((GeneralPath)shape).lineTo(460.0, 287.0);
((GeneralPath)shape).lineTo(455.0, 285.0);
((GeneralPath)shape).lineTo(453.0, 287.0);
((GeneralPath)shape).lineTo(447.0, 284.0);
((GeneralPath)shape).lineTo(450.0, 277.0);
((GeneralPath)shape).lineTo(440.0, 274.0);
((GeneralPath)shape).lineTo(433.0, 269.0);
((GeneralPath)shape).lineTo(431.0, 271.0);
((GeneralPath)shape).lineTo(426.0, 269.0);
((GeneralPath)shape).lineTo(424.0, 273.0);
((GeneralPath)shape).lineTo(417.0, 271.0);
((GeneralPath)shape).lineTo(417.0, 269.0);
((GeneralPath)shape).lineTo(410.0, 273.0);
((GeneralPath)shape).lineTo(410.0, 277.0);
((GeneralPath)shape).lineTo(405.0, 277.0);
((GeneralPath)shape).lineTo(405.0, 279.0);
((GeneralPath)shape).lineTo(403.0, 279.0);
((GeneralPath)shape).lineTo(400.0, 283.0);
((GeneralPath)shape).lineTo(398.0, 282.0);
((GeneralPath)shape).lineTo(398.0, 286.0);
((GeneralPath)shape).lineTo(395.0, 287.0);
((GeneralPath)shape).lineTo(390.0, 284.0);
((GeneralPath)shape).lineTo(389.0, 285.0);
((GeneralPath)shape).lineTo(390.0, 269.0);
((GeneralPath)shape).lineTo(385.0, 269.0);
((GeneralPath)shape).lineTo(379.0, 266.0);
((GeneralPath)shape).lineTo(381.0, 261.0);
((GeneralPath)shape).lineTo(378.0, 259.0);
((GeneralPath)shape).lineTo(373.0, 259.0);
((GeneralPath)shape).lineTo(372.0, 261.0);
((GeneralPath)shape).lineTo(369.0, 261.0);
((GeneralPath)shape).lineTo(370.0, 254.0);
((GeneralPath)shape).lineTo(360.0, 249.0);
((GeneralPath)shape).lineTo(364.0, 244.0);
((GeneralPath)shape).lineTo(358.0, 237.0);
((GeneralPath)shape).lineTo(360.0, 233.0);
((GeneralPath)shape).lineTo(351.0, 229.0);
((GeneralPath)shape).lineTo(356.0, 218.0);
((GeneralPath)shape).lineTo(363.0, 218.0);
((GeneralPath)shape).lineTo(363.0, 215.0);
((GeneralPath)shape).lineTo(371.0, 218.0);
((GeneralPath)shape).lineTo(375.0, 211.0);
((GeneralPath)shape).lineTo(376.0, 203.0);
((GeneralPath)shape).lineTo(381.0, 205.0);
((GeneralPath)shape).lineTo(381.0, 201.0);
((GeneralPath)shape).lineTo(392.0, 188.0);
((GeneralPath)shape).lineTo(393.0, 183.0);
((GeneralPath)shape).lineTo(400.0, 182.0);
((GeneralPath)shape).lineTo(403.0, 180.0);
((GeneralPath)shape).lineTo(407.0, 182.0);
((GeneralPath)shape).lineTo(413.0, 180.0);
((GeneralPath)shape).lineTo(417.0, 181.0);
((GeneralPath)shape).lineTo(420.0, 173.0);
((GeneralPath)shape).lineTo(426.0, 174.0);
((GeneralPath)shape).lineTo(426.0, 161.0);
((GeneralPath)shape).lineTo(422.0, 160.0);
((GeneralPath)shape).lineTo(421.0, 155.0);
((GeneralPath)shape).lineTo(435.0, 155.0);
((GeneralPath)shape).lineTo(443.0, 161.0);
((GeneralPath)shape).lineTo(445.0, 167.0);
((GeneralPath)shape).lineTo(449.0, 167.0);
((GeneralPath)shape).lineTo(459.0, 161.0);
((GeneralPath)shape).lineTo(470.0, 158.0);
((GeneralPath)shape).lineTo(473.0, 149.0);
((GeneralPath)shape).lineTo(479.0, 148.0);
((GeneralPath)shape).lineTo(483.0, 145.0);
((GeneralPath)shape).lineTo(504.0, 145.0);
((GeneralPath)shape).lineTo(512.0, 142.0);
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
        return 630;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 111;
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

