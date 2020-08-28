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
public class B {
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
((GeneralPath)shape).moveTo(570.0, 255.0);
((GeneralPath)shape).lineTo(570.0, 267.0);
((GeneralPath)shape).lineTo(576.0, 267.0);
((GeneralPath)shape).lineTo(570.0, 268.0);
((GeneralPath)shape).lineTo(572.0, 269.0);
((GeneralPath)shape).lineTo(570.0, 270.0);
((GeneralPath)shape).lineTo(576.0, 268.0);
((GeneralPath)shape).lineTo(571.0, 270.0);
((GeneralPath)shape).lineTo(571.0, 275.0);
((GeneralPath)shape).lineTo(577.0, 291.0);
((GeneralPath)shape).lineTo(578.0, 303.0);
((GeneralPath)shape).lineTo(583.0, 324.0);
((GeneralPath)shape).lineTo(589.0, 338.0);
((GeneralPath)shape).lineTo(615.0, 370.0);
((GeneralPath)shape).lineTo(620.0, 374.0);
((GeneralPath)shape).lineTo(624.0, 374.0);
((GeneralPath)shape).lineTo(629.0, 383.0);
((GeneralPath)shape).lineTo(643.0, 396.0);
((GeneralPath)shape).lineTo(650.0, 401.0);
((GeneralPath)shape).lineTo(656.0, 403.0);
((GeneralPath)shape).lineTo(651.0, 413.0);
((GeneralPath)shape).lineTo(652.0, 420.0);
((GeneralPath)shape).lineTo(650.0, 424.0);
((GeneralPath)shape).lineTo(652.0, 427.0);
((GeneralPath)shape).lineTo(650.0, 429.0);
((GeneralPath)shape).lineTo(643.0, 431.0);
((GeneralPath)shape).lineTo(643.0, 437.0);
((GeneralPath)shape).lineTo(641.0, 439.0);
((GeneralPath)shape).lineTo(639.0, 437.0);
((GeneralPath)shape).lineTo(632.0, 439.0);
((GeneralPath)shape).lineTo(631.0, 438.0);
((GeneralPath)shape).lineTo(631.0, 433.0);
((GeneralPath)shape).lineTo(629.0, 433.0);
((GeneralPath)shape).lineTo(628.0, 428.0);
((GeneralPath)shape).lineTo(626.0, 428.0);
((GeneralPath)shape).lineTo(626.0, 423.0);
((GeneralPath)shape).lineTo(622.0, 424.0);
((GeneralPath)shape).lineTo(619.0, 428.0);
((GeneralPath)shape).lineTo(616.0, 427.0);
((GeneralPath)shape).lineTo(616.0, 419.0);
((GeneralPath)shape).lineTo(614.0, 420.0);
((GeneralPath)shape).lineTo(608.0, 415.0);
((GeneralPath)shape).lineTo(613.0, 409.0);
((GeneralPath)shape).lineTo(611.0, 405.0);
((GeneralPath)shape).lineTo(612.0, 396.0);
((GeneralPath)shape).lineTo(594.0, 406.0);
((GeneralPath)shape).lineTo(591.0, 403.0);
((GeneralPath)shape).lineTo(586.0, 403.0);
((GeneralPath)shape).lineTo(584.0, 407.0);
((GeneralPath)shape).lineTo(580.0, 404.0);
((GeneralPath)shape).lineTo(577.0, 404.0);
((GeneralPath)shape).lineTo(576.0, 409.0);
((GeneralPath)shape).lineTo(569.0, 413.0);
((GeneralPath)shape).lineTo(564.0, 407.0);
((GeneralPath)shape).lineTo(560.0, 409.0);
((GeneralPath)shape).lineTo(555.0, 403.0);
((GeneralPath)shape).lineTo(559.0, 402.0);
((GeneralPath)shape).lineTo(559.0, 394.0);
((GeneralPath)shape).lineTo(556.0, 393.0);
((GeneralPath)shape).lineTo(553.0, 381.0);
((GeneralPath)shape).lineTo(549.0, 382.0);
((GeneralPath)shape).lineTo(545.0, 387.0);
((GeneralPath)shape).lineTo(541.0, 386.0);
((GeneralPath)shape).lineTo(540.0, 388.0);
((GeneralPath)shape).lineTo(536.0, 388.0);
((GeneralPath)shape).lineTo(543.0, 374.0);
((GeneralPath)shape).lineTo(540.0, 368.0);
((GeneralPath)shape).lineTo(537.0, 366.0);
((GeneralPath)shape).lineTo(538.0, 361.0);
((GeneralPath)shape).lineTo(536.0, 362.0);
((GeneralPath)shape).lineTo(533.0, 358.0);
((GeneralPath)shape).lineTo(528.0, 356.0);
((GeneralPath)shape).lineTo(519.0, 362.0);
((GeneralPath)shape).lineTo(520.0, 355.0);
((GeneralPath)shape).lineTo(513.0, 351.0);
((GeneralPath)shape).lineTo(512.0, 342.0);
((GeneralPath)shape).lineTo(510.0, 341.0);
((GeneralPath)shape).lineTo(507.0, 346.0);
((GeneralPath)shape).lineTo(505.0, 339.0);
((GeneralPath)shape).lineTo(501.0, 340.0);
((GeneralPath)shape).lineTo(500.0, 334.0);
((GeneralPath)shape).lineTo(496.0, 338.0);
((GeneralPath)shape).lineTo(484.0, 330.0);
((GeneralPath)shape).lineTo(483.0, 326.0);
((GeneralPath)shape).lineTo(481.0, 326.0);
((GeneralPath)shape).lineTo(480.0, 324.0);
((GeneralPath)shape).lineTo(475.0, 324.0);
((GeneralPath)shape).lineTo(482.0, 317.0);
((GeneralPath)shape).lineTo(482.0, 315.0);
((GeneralPath)shape).lineTo(486.0, 316.0);
((GeneralPath)shape).lineTo(490.0, 311.0);
((GeneralPath)shape).lineTo(493.0, 310.0);
((GeneralPath)shape).lineTo(495.0, 304.0);
((GeneralPath)shape).lineTo(501.0, 307.0);
((GeneralPath)shape).lineTo(505.0, 299.0);
((GeneralPath)shape).lineTo(508.0, 298.0);
((GeneralPath)shape).lineTo(512.0, 300.0);
((GeneralPath)shape).lineTo(519.0, 297.0);
((GeneralPath)shape).lineTo(523.0, 292.0);
((GeneralPath)shape).lineTo(526.0, 283.0);
((GeneralPath)shape).lineTo(533.0, 275.0);
((GeneralPath)shape).lineTo(531.0, 269.0);
((GeneralPath)shape).lineTo(538.0, 256.0);
((GeneralPath)shape).lineTo(547.0, 254.0);
((GeneralPath)shape).lineTo(562.0, 236.0);
((GeneralPath)shape).lineTo(568.0, 234.0);
((GeneralPath)shape).lineTo(571.0, 245.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(570.0, 255.0);
((GeneralPath)shape).lineTo(570.0, 267.0);
((GeneralPath)shape).lineTo(576.0, 267.0);
((GeneralPath)shape).lineTo(570.0, 268.0);
((GeneralPath)shape).lineTo(572.0, 269.0);
((GeneralPath)shape).lineTo(570.0, 270.0);
((GeneralPath)shape).lineTo(576.0, 268.0);
((GeneralPath)shape).lineTo(571.0, 270.0);
((GeneralPath)shape).lineTo(571.0, 275.0);
((GeneralPath)shape).lineTo(577.0, 291.0);
((GeneralPath)shape).lineTo(578.0, 303.0);
((GeneralPath)shape).lineTo(583.0, 324.0);
((GeneralPath)shape).lineTo(589.0, 338.0);
((GeneralPath)shape).lineTo(615.0, 370.0);
((GeneralPath)shape).lineTo(620.0, 374.0);
((GeneralPath)shape).lineTo(624.0, 374.0);
((GeneralPath)shape).lineTo(629.0, 383.0);
((GeneralPath)shape).lineTo(643.0, 396.0);
((GeneralPath)shape).lineTo(650.0, 401.0);
((GeneralPath)shape).lineTo(656.0, 403.0);
((GeneralPath)shape).lineTo(651.0, 413.0);
((GeneralPath)shape).lineTo(652.0, 420.0);
((GeneralPath)shape).lineTo(650.0, 424.0);
((GeneralPath)shape).lineTo(652.0, 427.0);
((GeneralPath)shape).lineTo(650.0, 429.0);
((GeneralPath)shape).lineTo(643.0, 431.0);
((GeneralPath)shape).lineTo(643.0, 437.0);
((GeneralPath)shape).lineTo(641.0, 439.0);
((GeneralPath)shape).lineTo(639.0, 437.0);
((GeneralPath)shape).lineTo(632.0, 439.0);
((GeneralPath)shape).lineTo(631.0, 438.0);
((GeneralPath)shape).lineTo(631.0, 433.0);
((GeneralPath)shape).lineTo(629.0, 433.0);
((GeneralPath)shape).lineTo(628.0, 428.0);
((GeneralPath)shape).lineTo(626.0, 428.0);
((GeneralPath)shape).lineTo(626.0, 423.0);
((GeneralPath)shape).lineTo(622.0, 424.0);
((GeneralPath)shape).lineTo(619.0, 428.0);
((GeneralPath)shape).lineTo(616.0, 427.0);
((GeneralPath)shape).lineTo(616.0, 419.0);
((GeneralPath)shape).lineTo(614.0, 420.0);
((GeneralPath)shape).lineTo(608.0, 415.0);
((GeneralPath)shape).lineTo(613.0, 409.0);
((GeneralPath)shape).lineTo(611.0, 405.0);
((GeneralPath)shape).lineTo(612.0, 396.0);
((GeneralPath)shape).lineTo(594.0, 406.0);
((GeneralPath)shape).lineTo(591.0, 403.0);
((GeneralPath)shape).lineTo(586.0, 403.0);
((GeneralPath)shape).lineTo(584.0, 407.0);
((GeneralPath)shape).lineTo(580.0, 404.0);
((GeneralPath)shape).lineTo(577.0, 404.0);
((GeneralPath)shape).lineTo(576.0, 409.0);
((GeneralPath)shape).lineTo(569.0, 413.0);
((GeneralPath)shape).lineTo(564.0, 407.0);
((GeneralPath)shape).lineTo(560.0, 409.0);
((GeneralPath)shape).lineTo(555.0, 403.0);
((GeneralPath)shape).lineTo(559.0, 402.0);
((GeneralPath)shape).lineTo(559.0, 394.0);
((GeneralPath)shape).lineTo(556.0, 393.0);
((GeneralPath)shape).lineTo(553.0, 381.0);
((GeneralPath)shape).lineTo(549.0, 382.0);
((GeneralPath)shape).lineTo(545.0, 387.0);
((GeneralPath)shape).lineTo(541.0, 386.0);
((GeneralPath)shape).lineTo(540.0, 388.0);
((GeneralPath)shape).lineTo(536.0, 388.0);
((GeneralPath)shape).lineTo(543.0, 374.0);
((GeneralPath)shape).lineTo(540.0, 368.0);
((GeneralPath)shape).lineTo(537.0, 366.0);
((GeneralPath)shape).lineTo(538.0, 361.0);
((GeneralPath)shape).lineTo(536.0, 362.0);
((GeneralPath)shape).lineTo(533.0, 358.0);
((GeneralPath)shape).lineTo(528.0, 356.0);
((GeneralPath)shape).lineTo(519.0, 362.0);
((GeneralPath)shape).lineTo(520.0, 355.0);
((GeneralPath)shape).lineTo(513.0, 351.0);
((GeneralPath)shape).lineTo(512.0, 342.0);
((GeneralPath)shape).lineTo(510.0, 341.0);
((GeneralPath)shape).lineTo(507.0, 346.0);
((GeneralPath)shape).lineTo(505.0, 339.0);
((GeneralPath)shape).lineTo(501.0, 340.0);
((GeneralPath)shape).lineTo(500.0, 334.0);
((GeneralPath)shape).lineTo(496.0, 338.0);
((GeneralPath)shape).lineTo(484.0, 330.0);
((GeneralPath)shape).lineTo(483.0, 326.0);
((GeneralPath)shape).lineTo(481.0, 326.0);
((GeneralPath)shape).lineTo(480.0, 324.0);
((GeneralPath)shape).lineTo(475.0, 324.0);
((GeneralPath)shape).lineTo(482.0, 317.0);
((GeneralPath)shape).lineTo(482.0, 315.0);
((GeneralPath)shape).lineTo(486.0, 316.0);
((GeneralPath)shape).lineTo(490.0, 311.0);
((GeneralPath)shape).lineTo(493.0, 310.0);
((GeneralPath)shape).lineTo(495.0, 304.0);
((GeneralPath)shape).lineTo(501.0, 307.0);
((GeneralPath)shape).lineTo(505.0, 299.0);
((GeneralPath)shape).lineTo(508.0, 298.0);
((GeneralPath)shape).lineTo(512.0, 300.0);
((GeneralPath)shape).lineTo(519.0, 297.0);
((GeneralPath)shape).lineTo(523.0, 292.0);
((GeneralPath)shape).lineTo(526.0, 283.0);
((GeneralPath)shape).lineTo(533.0, 275.0);
((GeneralPath)shape).lineTo(531.0, 269.0);
((GeneralPath)shape).lineTo(538.0, 256.0);
((GeneralPath)shape).lineTo(547.0, 254.0);
((GeneralPath)shape).lineTo(562.0, 236.0);
((GeneralPath)shape).lineTo(568.0, 234.0);
((GeneralPath)shape).lineTo(571.0, 245.0);
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
        return 754;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 203;
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

