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
public class A2 {
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
((GeneralPath)shape).moveTo(479.0, 323.0);
((GeneralPath)shape).lineTo(487.0, 332.0);
((GeneralPath)shape).lineTo(495.0, 337.0);
((GeneralPath)shape).lineTo(497.0, 338.0);
((GeneralPath)shape).lineTo(501.0, 334.0);
((GeneralPath)shape).lineTo(502.0, 340.0);
((GeneralPath)shape).lineTo(506.0, 339.0);
((GeneralPath)shape).lineTo(508.0, 346.0);
((GeneralPath)shape).lineTo(511.0, 341.0);
((GeneralPath)shape).lineTo(513.0, 342.0);
((GeneralPath)shape).lineTo(514.0, 351.0);
((GeneralPath)shape).lineTo(521.0, 355.0);
((GeneralPath)shape).lineTo(520.0, 362.0);
((GeneralPath)shape).lineTo(529.0, 356.0);
((GeneralPath)shape).lineTo(534.0, 358.0);
((GeneralPath)shape).lineTo(537.0, 362.0);
((GeneralPath)shape).lineTo(539.0, 361.0);
((GeneralPath)shape).lineTo(538.0, 366.0);
((GeneralPath)shape).lineTo(541.0, 368.0);
((GeneralPath)shape).lineTo(544.0, 374.0);
((GeneralPath)shape).lineTo(537.0, 388.0);
((GeneralPath)shape).lineTo(541.0, 388.0);
((GeneralPath)shape).lineTo(542.0, 386.0);
((GeneralPath)shape).lineTo(546.0, 387.0);
((GeneralPath)shape).lineTo(550.0, 382.0);
((GeneralPath)shape).lineTo(554.0, 381.0);
((GeneralPath)shape).lineTo(557.0, 393.0);
((GeneralPath)shape).lineTo(560.0, 394.0);
((GeneralPath)shape).lineTo(560.0, 402.0);
((GeneralPath)shape).lineTo(556.0, 403.0);
((GeneralPath)shape).lineTo(561.0, 409.0);
((GeneralPath)shape).lineTo(565.0, 407.0);
((GeneralPath)shape).lineTo(570.0, 413.0);
((GeneralPath)shape).lineTo(577.0, 409.0);
((GeneralPath)shape).lineTo(578.0, 404.0);
((GeneralPath)shape).lineTo(581.0, 404.0);
((GeneralPath)shape).lineTo(585.0, 407.0);
((GeneralPath)shape).lineTo(587.0, 403.0);
((GeneralPath)shape).lineTo(592.0, 403.0);
((GeneralPath)shape).lineTo(595.0, 411.0);
((GeneralPath)shape).lineTo(594.0, 418.0);
((GeneralPath)shape).lineTo(598.0, 426.0);
((GeneralPath)shape).lineTo(593.0, 426.0);
((GeneralPath)shape).lineTo(591.0, 420.0);
((GeneralPath)shape).lineTo(590.0, 424.0);
((GeneralPath)shape).lineTo(582.0, 429.0);
((GeneralPath)shape).lineTo(579.0, 428.0);
((GeneralPath)shape).lineTo(574.0, 433.0);
((GeneralPath)shape).lineTo(570.0, 430.0);
((GeneralPath)shape).lineTo(566.0, 437.0);
((GeneralPath)shape).lineTo(559.0, 444.0);
((GeneralPath)shape).lineTo(554.0, 443.0);
((GeneralPath)shape).lineTo(543.0, 430.0);
((GeneralPath)shape).lineTo(536.0, 431.0);
((GeneralPath)shape).lineTo(534.0, 422.0);
((GeneralPath)shape).lineTo(532.0, 422.0);
((GeneralPath)shape).lineTo(535.0, 413.0);
((GeneralPath)shape).lineTo(540.0, 412.0);
((GeneralPath)shape).lineTo(540.0, 407.0);
((GeneralPath)shape).lineTo(530.0, 412.0);
((GeneralPath)shape).lineTo(528.0, 408.0);
((GeneralPath)shape).lineTo(523.0, 408.0);
((GeneralPath)shape).lineTo(520.0, 405.0);
((GeneralPath)shape).lineTo(513.0, 412.0);
((GeneralPath)shape).lineTo(507.0, 405.0);
((GeneralPath)shape).lineTo(496.0, 400.0);
((GeneralPath)shape).lineTo(496.0, 396.0);
((GeneralPath)shape).lineTo(492.0, 389.0);
((GeneralPath)shape).lineTo(495.0, 385.0);
((GeneralPath)shape).lineTo(485.0, 391.0);
((GeneralPath)shape).lineTo(483.0, 390.0);
((GeneralPath)shape).lineTo(481.0, 381.0);
((GeneralPath)shape).lineTo(479.0, 381.0);
((GeneralPath)shape).lineTo(478.0, 385.0);
((GeneralPath)shape).lineTo(476.0, 381.0);
((GeneralPath)shape).lineTo(475.0, 387.0);
((GeneralPath)shape).lineTo(470.0, 387.0);
((GeneralPath)shape).lineTo(470.0, 390.0);
((GeneralPath)shape).lineTo(463.0, 391.0);
((GeneralPath)shape).lineTo(462.0, 389.0);
((GeneralPath)shape).lineTo(465.0, 381.0);
((GeneralPath)shape).lineTo(472.0, 372.0);
((GeneralPath)shape).lineTo(475.0, 363.0);
((GeneralPath)shape).lineTo(461.0, 363.0);
((GeneralPath)shape).lineTo(461.0, 365.0);
((GeneralPath)shape).lineTo(456.0, 369.0);
((GeneralPath)shape).lineTo(451.0, 364.0);
((GeneralPath)shape).lineTo(444.0, 364.0);
((GeneralPath)shape).lineTo(450.0, 358.0);
((GeneralPath)shape).lineTo(450.0, 354.0);
((GeneralPath)shape).lineTo(464.0, 337.0);
((GeneralPath)shape).lineTo(461.0, 335.0);
((GeneralPath)shape).lineTo(464.0, 330.0);
((GeneralPath)shape).lineTo(472.0, 329.0);
((GeneralPath)shape).lineTo(474.0, 324.0);
((GeneralPath)shape).lineTo(476.0, 325.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(479.0, 323.0);
((GeneralPath)shape).lineTo(487.0, 332.0);
((GeneralPath)shape).lineTo(495.0, 337.0);
((GeneralPath)shape).lineTo(497.0, 338.0);
((GeneralPath)shape).lineTo(501.0, 334.0);
((GeneralPath)shape).lineTo(502.0, 340.0);
((GeneralPath)shape).lineTo(506.0, 339.0);
((GeneralPath)shape).lineTo(508.0, 346.0);
((GeneralPath)shape).lineTo(511.0, 341.0);
((GeneralPath)shape).lineTo(513.0, 342.0);
((GeneralPath)shape).lineTo(514.0, 351.0);
((GeneralPath)shape).lineTo(521.0, 355.0);
((GeneralPath)shape).lineTo(520.0, 362.0);
((GeneralPath)shape).lineTo(529.0, 356.0);
((GeneralPath)shape).lineTo(534.0, 358.0);
((GeneralPath)shape).lineTo(537.0, 362.0);
((GeneralPath)shape).lineTo(539.0, 361.0);
((GeneralPath)shape).lineTo(538.0, 366.0);
((GeneralPath)shape).lineTo(541.0, 368.0);
((GeneralPath)shape).lineTo(544.0, 374.0);
((GeneralPath)shape).lineTo(537.0, 388.0);
((GeneralPath)shape).lineTo(541.0, 388.0);
((GeneralPath)shape).lineTo(542.0, 386.0);
((GeneralPath)shape).lineTo(546.0, 387.0);
((GeneralPath)shape).lineTo(550.0, 382.0);
((GeneralPath)shape).lineTo(554.0, 381.0);
((GeneralPath)shape).lineTo(557.0, 393.0);
((GeneralPath)shape).lineTo(560.0, 394.0);
((GeneralPath)shape).lineTo(560.0, 402.0);
((GeneralPath)shape).lineTo(556.0, 403.0);
((GeneralPath)shape).lineTo(561.0, 409.0);
((GeneralPath)shape).lineTo(565.0, 407.0);
((GeneralPath)shape).lineTo(570.0, 413.0);
((GeneralPath)shape).lineTo(577.0, 409.0);
((GeneralPath)shape).lineTo(578.0, 404.0);
((GeneralPath)shape).lineTo(581.0, 404.0);
((GeneralPath)shape).lineTo(585.0, 407.0);
((GeneralPath)shape).lineTo(587.0, 403.0);
((GeneralPath)shape).lineTo(592.0, 403.0);
((GeneralPath)shape).lineTo(595.0, 411.0);
((GeneralPath)shape).lineTo(594.0, 418.0);
((GeneralPath)shape).lineTo(598.0, 426.0);
((GeneralPath)shape).lineTo(593.0, 426.0);
((GeneralPath)shape).lineTo(591.0, 420.0);
((GeneralPath)shape).lineTo(590.0, 424.0);
((GeneralPath)shape).lineTo(582.0, 429.0);
((GeneralPath)shape).lineTo(579.0, 428.0);
((GeneralPath)shape).lineTo(574.0, 433.0);
((GeneralPath)shape).lineTo(570.0, 430.0);
((GeneralPath)shape).lineTo(566.0, 437.0);
((GeneralPath)shape).lineTo(559.0, 444.0);
((GeneralPath)shape).lineTo(554.0, 443.0);
((GeneralPath)shape).lineTo(543.0, 430.0);
((GeneralPath)shape).lineTo(536.0, 431.0);
((GeneralPath)shape).lineTo(534.0, 422.0);
((GeneralPath)shape).lineTo(532.0, 422.0);
((GeneralPath)shape).lineTo(535.0, 413.0);
((GeneralPath)shape).lineTo(540.0, 412.0);
((GeneralPath)shape).lineTo(540.0, 407.0);
((GeneralPath)shape).lineTo(530.0, 412.0);
((GeneralPath)shape).lineTo(528.0, 408.0);
((GeneralPath)shape).lineTo(523.0, 408.0);
((GeneralPath)shape).lineTo(520.0, 405.0);
((GeneralPath)shape).lineTo(513.0, 412.0);
((GeneralPath)shape).lineTo(507.0, 405.0);
((GeneralPath)shape).lineTo(496.0, 400.0);
((GeneralPath)shape).lineTo(496.0, 396.0);
((GeneralPath)shape).lineTo(492.0, 389.0);
((GeneralPath)shape).lineTo(495.0, 385.0);
((GeneralPath)shape).lineTo(485.0, 391.0);
((GeneralPath)shape).lineTo(483.0, 390.0);
((GeneralPath)shape).lineTo(481.0, 381.0);
((GeneralPath)shape).lineTo(479.0, 381.0);
((GeneralPath)shape).lineTo(478.0, 385.0);
((GeneralPath)shape).lineTo(476.0, 381.0);
((GeneralPath)shape).lineTo(475.0, 387.0);
((GeneralPath)shape).lineTo(470.0, 387.0);
((GeneralPath)shape).lineTo(470.0, 390.0);
((GeneralPath)shape).lineTo(463.0, 391.0);
((GeneralPath)shape).lineTo(462.0, 389.0);
((GeneralPath)shape).lineTo(465.0, 381.0);
((GeneralPath)shape).lineTo(472.0, 372.0);
((GeneralPath)shape).lineTo(475.0, 363.0);
((GeneralPath)shape).lineTo(461.0, 363.0);
((GeneralPath)shape).lineTo(461.0, 365.0);
((GeneralPath)shape).lineTo(456.0, 369.0);
((GeneralPath)shape).lineTo(451.0, 364.0);
((GeneralPath)shape).lineTo(444.0, 364.0);
((GeneralPath)shape).lineTo(450.0, 358.0);
((GeneralPath)shape).lineTo(450.0, 354.0);
((GeneralPath)shape).lineTo(464.0, 337.0);
((GeneralPath)shape).lineTo(461.0, 335.0);
((GeneralPath)shape).lineTo(464.0, 330.0);
((GeneralPath)shape).lineTo(472.0, 329.0);
((GeneralPath)shape).lineTo(474.0, 324.0);
((GeneralPath)shape).lineTo(476.0, 325.0);
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
        return 623;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 475;
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

