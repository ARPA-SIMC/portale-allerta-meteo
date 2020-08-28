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
public class B1 {
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
((GeneralPath)shape).moveTo(618.0, 396.0);
((GeneralPath)shape).lineTo(620.0, 397.0);
((GeneralPath)shape).lineTo(624.0, 395.0);
((GeneralPath)shape).lineTo(626.0, 399.0);
((GeneralPath)shape).lineTo(630.0, 396.0);
((GeneralPath)shape).lineTo(635.0, 396.0);
((GeneralPath)shape).lineTo(637.0, 403.0);
((GeneralPath)shape).lineTo(635.0, 407.0);
((GeneralPath)shape).lineTo(643.0, 411.0);
((GeneralPath)shape).lineTo(644.0, 407.0);
((GeneralPath)shape).lineTo(648.0, 403.0);
((GeneralPath)shape).lineTo(649.0, 405.0);
((GeneralPath)shape).lineTo(653.0, 403.0);
((GeneralPath)shape).lineTo(651.0, 406.0);
((GeneralPath)shape).lineTo(655.0, 409.0);
((GeneralPath)shape).lineTo(652.0, 413.0);
((GeneralPath)shape).lineTo(653.0, 420.0);
((GeneralPath)shape).lineTo(651.0, 424.0);
((GeneralPath)shape).lineTo(653.0, 427.0);
((GeneralPath)shape).lineTo(651.0, 429.0);
((GeneralPath)shape).lineTo(644.0, 431.0);
((GeneralPath)shape).lineTo(644.0, 437.0);
((GeneralPath)shape).lineTo(642.0, 439.0);
((GeneralPath)shape).lineTo(640.0, 437.0);
((GeneralPath)shape).lineTo(633.0, 439.0);
((GeneralPath)shape).lineTo(631.0, 436.0);
((GeneralPath)shape).lineTo(632.0, 433.0);
((GeneralPath)shape).lineTo(630.0, 433.0);
((GeneralPath)shape).lineTo(629.0, 428.0);
((GeneralPath)shape).lineTo(627.0, 428.0);
((GeneralPath)shape).lineTo(627.0, 423.0);
((GeneralPath)shape).lineTo(623.0, 424.0);
((GeneralPath)shape).lineTo(622.0, 427.0);
((GeneralPath)shape).lineTo(618.0, 428.0);
((GeneralPath)shape).lineTo(616.0, 425.0);
((GeneralPath)shape).lineTo(618.0, 422.0);
((GeneralPath)shape).lineTo(617.0, 419.0);
((GeneralPath)shape).lineTo(615.0, 420.0);
((GeneralPath)shape).lineTo(609.0, 415.0);
((GeneralPath)shape).lineTo(614.0, 409.0);
((GeneralPath)shape).lineTo(612.0, 405.0);
((GeneralPath)shape).lineTo(613.0, 396.0);
((GeneralPath)shape).lineTo(618.0, 395.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(618.0, 396.0);
((GeneralPath)shape).lineTo(620.0, 397.0);
((GeneralPath)shape).lineTo(624.0, 395.0);
((GeneralPath)shape).lineTo(626.0, 399.0);
((GeneralPath)shape).lineTo(630.0, 396.0);
((GeneralPath)shape).lineTo(635.0, 396.0);
((GeneralPath)shape).lineTo(637.0, 403.0);
((GeneralPath)shape).lineTo(635.0, 407.0);
((GeneralPath)shape).lineTo(643.0, 411.0);
((GeneralPath)shape).lineTo(644.0, 407.0);
((GeneralPath)shape).lineTo(648.0, 403.0);
((GeneralPath)shape).lineTo(649.0, 405.0);
((GeneralPath)shape).lineTo(653.0, 403.0);
((GeneralPath)shape).lineTo(651.0, 406.0);
((GeneralPath)shape).lineTo(655.0, 409.0);
((GeneralPath)shape).lineTo(652.0, 413.0);
((GeneralPath)shape).lineTo(653.0, 420.0);
((GeneralPath)shape).lineTo(651.0, 424.0);
((GeneralPath)shape).lineTo(653.0, 427.0);
((GeneralPath)shape).lineTo(651.0, 429.0);
((GeneralPath)shape).lineTo(644.0, 431.0);
((GeneralPath)shape).lineTo(644.0, 437.0);
((GeneralPath)shape).lineTo(642.0, 439.0);
((GeneralPath)shape).lineTo(640.0, 437.0);
((GeneralPath)shape).lineTo(633.0, 439.0);
((GeneralPath)shape).lineTo(631.0, 436.0);
((GeneralPath)shape).lineTo(632.0, 433.0);
((GeneralPath)shape).lineTo(630.0, 433.0);
((GeneralPath)shape).lineTo(629.0, 428.0);
((GeneralPath)shape).lineTo(627.0, 428.0);
((GeneralPath)shape).lineTo(627.0, 423.0);
((GeneralPath)shape).lineTo(623.0, 424.0);
((GeneralPath)shape).lineTo(622.0, 427.0);
((GeneralPath)shape).lineTo(618.0, 428.0);
((GeneralPath)shape).lineTo(616.0, 425.0);
((GeneralPath)shape).lineTo(618.0, 422.0);
((GeneralPath)shape).lineTo(617.0, 419.0);
((GeneralPath)shape).lineTo(615.0, 420.0);
((GeneralPath)shape).lineTo(609.0, 415.0);
((GeneralPath)shape).lineTo(614.0, 409.0);
((GeneralPath)shape).lineTo(612.0, 405.0);
((GeneralPath)shape).lineTo(613.0, 396.0);
((GeneralPath)shape).lineTo(618.0, 395.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
origAlpha = alpha__0_0_0;
g.setTransform(defaultTransform__0_0_0);
g.setClip(clip__0_0_0);
float alpha__0_0_1 = origAlpha;
origAlpha = origAlpha * 1.0f;
g.setComposite(AlphaComposite.getInstance(3, origAlpha));
Shape clip__0_0_1 = g.getClip();
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1 is ShapeNode
paint = new Color(colori[0], colori[1], colori[2], colori[3]);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(525.0, 289.0);
((GeneralPath)shape).lineTo(539.0, 295.0);
((GeneralPath)shape).lineTo(537.0, 300.0);
((GeneralPath)shape).lineTo(533.0, 300.0);
((GeneralPath)shape).lineTo(539.0, 302.0);
((GeneralPath)shape).lineTo(526.0, 310.0);
((GeneralPath)shape).lineTo(529.0, 311.0);
((GeneralPath)shape).lineTo(530.0, 316.0);
((GeneralPath)shape).lineTo(536.0, 318.0);
((GeneralPath)shape).lineTo(539.0, 321.0);
((GeneralPath)shape).lineTo(539.0, 325.0);
((GeneralPath)shape).lineTo(552.0, 332.0);
((GeneralPath)shape).lineTo(554.0, 329.0);
((GeneralPath)shape).lineTo(558.0, 329.0);
((GeneralPath)shape).lineTo(556.0, 336.0);
((GeneralPath)shape).lineTo(559.0, 340.0);
((GeneralPath)shape).lineTo(563.0, 339.0);
((GeneralPath)shape).lineTo(565.0, 335.0);
((GeneralPath)shape).lineTo(571.0, 335.0);
((GeneralPath)shape).lineTo(583.0, 346.0);
((GeneralPath)shape).lineTo(580.0, 349.0);
((GeneralPath)shape).lineTo(581.0, 354.0);
((GeneralPath)shape).lineTo(583.0, 355.0);
((GeneralPath)shape).lineTo(581.0, 357.0);
((GeneralPath)shape).lineTo(586.0, 356.0);
((GeneralPath)shape).lineTo(588.0, 369.0);
((GeneralPath)shape).lineTo(586.0, 376.0);
((GeneralPath)shape).lineTo(591.0, 378.0);
((GeneralPath)shape).lineTo(599.0, 371.0);
((GeneralPath)shape).lineTo(606.0, 376.0);
((GeneralPath)shape).lineTo(606.0, 381.0);
((GeneralPath)shape).lineTo(604.0, 382.0);
((GeneralPath)shape).lineTo(608.0, 383.0);
((GeneralPath)shape).lineTo(611.0, 387.0);
((GeneralPath)shape).lineTo(607.0, 391.0);
((GeneralPath)shape).lineTo(603.0, 386.0);
((GeneralPath)shape).lineTo(600.0, 389.0);
((GeneralPath)shape).lineTo(604.0, 394.0);
((GeneralPath)shape).lineTo(601.0, 399.0);
((GeneralPath)shape).lineTo(602.0, 402.0);
((GeneralPath)shape).lineTo(599.0, 405.0);
((GeneralPath)shape).lineTo(595.0, 406.0);
((GeneralPath)shape).lineTo(592.0, 403.0);
((GeneralPath)shape).lineTo(587.0, 403.0);
((GeneralPath)shape).lineTo(585.0, 407.0);
((GeneralPath)shape).lineTo(579.0, 404.0);
((GeneralPath)shape).lineTo(577.0, 409.0);
((GeneralPath)shape).lineTo(570.0, 413.0);
((GeneralPath)shape).lineTo(565.0, 407.0);
((GeneralPath)shape).lineTo(561.0, 409.0);
((GeneralPath)shape).lineTo(556.0, 403.0);
((GeneralPath)shape).lineTo(560.0, 402.0);
((GeneralPath)shape).lineTo(560.0, 394.0);
((GeneralPath)shape).lineTo(557.0, 393.0);
((GeneralPath)shape).lineTo(554.0, 381.0);
((GeneralPath)shape).lineTo(550.0, 382.0);
((GeneralPath)shape).lineTo(546.0, 387.0);
((GeneralPath)shape).lineTo(542.0, 386.0);
((GeneralPath)shape).lineTo(541.0, 388.0);
((GeneralPath)shape).lineTo(537.0, 388.0);
((GeneralPath)shape).lineTo(544.0, 374.0);
((GeneralPath)shape).lineTo(541.0, 368.0);
((GeneralPath)shape).lineTo(538.0, 366.0);
((GeneralPath)shape).lineTo(539.0, 361.0);
((GeneralPath)shape).lineTo(537.0, 362.0);
((GeneralPath)shape).lineTo(534.0, 358.0);
((GeneralPath)shape).lineTo(529.0, 356.0);
((GeneralPath)shape).lineTo(520.0, 362.0);
((GeneralPath)shape).lineTo(521.0, 355.0);
((GeneralPath)shape).lineTo(514.0, 351.0);
((GeneralPath)shape).lineTo(513.0, 342.0);
((GeneralPath)shape).lineTo(511.0, 341.0);
((GeneralPath)shape).lineTo(508.0, 346.0);
((GeneralPath)shape).lineTo(506.0, 339.0);
((GeneralPath)shape).lineTo(502.0, 340.0);
((GeneralPath)shape).lineTo(501.0, 334.0);
((GeneralPath)shape).lineTo(497.0, 338.0);
((GeneralPath)shape).lineTo(485.0, 330.0);
((GeneralPath)shape).lineTo(484.0, 326.0);
((GeneralPath)shape).lineTo(482.0, 326.0);
((GeneralPath)shape).lineTo(481.0, 324.0);
((GeneralPath)shape).lineTo(476.0, 324.0);
((GeneralPath)shape).lineTo(483.0, 317.0);
((GeneralPath)shape).lineTo(483.0, 315.0);
((GeneralPath)shape).lineTo(487.0, 316.0);
((GeneralPath)shape).lineTo(491.0, 311.0);
((GeneralPath)shape).lineTo(494.0, 310.0);
((GeneralPath)shape).lineTo(496.0, 304.0);
((GeneralPath)shape).lineTo(502.0, 307.0);
((GeneralPath)shape).lineTo(506.0, 299.0);
((GeneralPath)shape).lineTo(509.0, 298.0);
((GeneralPath)shape).lineTo(516.0, 300.0);
((GeneralPath)shape).lineTo(517.0, 297.0);
((GeneralPath)shape).lineTo(520.0, 297.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(525.0, 289.0);
((GeneralPath)shape).lineTo(539.0, 295.0);
((GeneralPath)shape).lineTo(537.0, 300.0);
((GeneralPath)shape).lineTo(533.0, 300.0);
((GeneralPath)shape).lineTo(539.0, 302.0);
((GeneralPath)shape).lineTo(526.0, 310.0);
((GeneralPath)shape).lineTo(529.0, 311.0);
((GeneralPath)shape).lineTo(530.0, 316.0);
((GeneralPath)shape).lineTo(536.0, 318.0);
((GeneralPath)shape).lineTo(539.0, 321.0);
((GeneralPath)shape).lineTo(539.0, 325.0);
((GeneralPath)shape).lineTo(552.0, 332.0);
((GeneralPath)shape).lineTo(554.0, 329.0);
((GeneralPath)shape).lineTo(558.0, 329.0);
((GeneralPath)shape).lineTo(556.0, 336.0);
((GeneralPath)shape).lineTo(559.0, 340.0);
((GeneralPath)shape).lineTo(563.0, 339.0);
((GeneralPath)shape).lineTo(565.0, 335.0);
((GeneralPath)shape).lineTo(571.0, 335.0);
((GeneralPath)shape).lineTo(583.0, 346.0);
((GeneralPath)shape).lineTo(580.0, 349.0);
((GeneralPath)shape).lineTo(581.0, 354.0);
((GeneralPath)shape).lineTo(583.0, 355.0);
((GeneralPath)shape).lineTo(581.0, 357.0);
((GeneralPath)shape).lineTo(586.0, 356.0);
((GeneralPath)shape).lineTo(588.0, 369.0);
((GeneralPath)shape).lineTo(586.0, 376.0);
((GeneralPath)shape).lineTo(591.0, 378.0);
((GeneralPath)shape).lineTo(599.0, 371.0);
((GeneralPath)shape).lineTo(606.0, 376.0);
((GeneralPath)shape).lineTo(606.0, 381.0);
((GeneralPath)shape).lineTo(604.0, 382.0);
((GeneralPath)shape).lineTo(608.0, 383.0);
((GeneralPath)shape).lineTo(611.0, 387.0);
((GeneralPath)shape).lineTo(607.0, 391.0);
((GeneralPath)shape).lineTo(603.0, 386.0);
((GeneralPath)shape).lineTo(600.0, 389.0);
((GeneralPath)shape).lineTo(604.0, 394.0);
((GeneralPath)shape).lineTo(601.0, 399.0);
((GeneralPath)shape).lineTo(602.0, 402.0);
((GeneralPath)shape).lineTo(599.0, 405.0);
((GeneralPath)shape).lineTo(595.0, 406.0);
((GeneralPath)shape).lineTo(592.0, 403.0);
((GeneralPath)shape).lineTo(587.0, 403.0);
((GeneralPath)shape).lineTo(585.0, 407.0);
((GeneralPath)shape).lineTo(579.0, 404.0);
((GeneralPath)shape).lineTo(577.0, 409.0);
((GeneralPath)shape).lineTo(570.0, 413.0);
((GeneralPath)shape).lineTo(565.0, 407.0);
((GeneralPath)shape).lineTo(561.0, 409.0);
((GeneralPath)shape).lineTo(556.0, 403.0);
((GeneralPath)shape).lineTo(560.0, 402.0);
((GeneralPath)shape).lineTo(560.0, 394.0);
((GeneralPath)shape).lineTo(557.0, 393.0);
((GeneralPath)shape).lineTo(554.0, 381.0);
((GeneralPath)shape).lineTo(550.0, 382.0);
((GeneralPath)shape).lineTo(546.0, 387.0);
((GeneralPath)shape).lineTo(542.0, 386.0);
((GeneralPath)shape).lineTo(541.0, 388.0);
((GeneralPath)shape).lineTo(537.0, 388.0);
((GeneralPath)shape).lineTo(544.0, 374.0);
((GeneralPath)shape).lineTo(541.0, 368.0);
((GeneralPath)shape).lineTo(538.0, 366.0);
((GeneralPath)shape).lineTo(539.0, 361.0);
((GeneralPath)shape).lineTo(537.0, 362.0);
((GeneralPath)shape).lineTo(534.0, 358.0);
((GeneralPath)shape).lineTo(529.0, 356.0);
((GeneralPath)shape).lineTo(520.0, 362.0);
((GeneralPath)shape).lineTo(521.0, 355.0);
((GeneralPath)shape).lineTo(514.0, 351.0);
((GeneralPath)shape).lineTo(513.0, 342.0);
((GeneralPath)shape).lineTo(511.0, 341.0);
((GeneralPath)shape).lineTo(508.0, 346.0);
((GeneralPath)shape).lineTo(506.0, 339.0);
((GeneralPath)shape).lineTo(502.0, 340.0);
((GeneralPath)shape).lineTo(501.0, 334.0);
((GeneralPath)shape).lineTo(497.0, 338.0);
((GeneralPath)shape).lineTo(485.0, 330.0);
((GeneralPath)shape).lineTo(484.0, 326.0);
((GeneralPath)shape).lineTo(482.0, 326.0);
((GeneralPath)shape).lineTo(481.0, 324.0);
((GeneralPath)shape).lineTo(476.0, 324.0);
((GeneralPath)shape).lineTo(483.0, 317.0);
((GeneralPath)shape).lineTo(483.0, 315.0);
((GeneralPath)shape).lineTo(487.0, 316.0);
((GeneralPath)shape).lineTo(491.0, 311.0);
((GeneralPath)shape).lineTo(494.0, 310.0);
((GeneralPath)shape).lineTo(496.0, 304.0);
((GeneralPath)shape).lineTo(502.0, 307.0);
((GeneralPath)shape).lineTo(506.0, 299.0);
((GeneralPath)shape).lineTo(509.0, 298.0);
((GeneralPath)shape).lineTo(516.0, 300.0);
((GeneralPath)shape).lineTo(517.0, 297.0);
((GeneralPath)shape).lineTo(520.0, 297.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
origAlpha = alpha__0_0_1;
g.setTransform(defaultTransform__0_0_1);
g.setClip(clip__0_0_1);
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
        return 655;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 441;
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

