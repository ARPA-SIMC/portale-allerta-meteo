
package it.eng.allerter.allerta.svg;

import java.awt.*;
import java.awt.geom.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class has been automatically generated using
 * <a href="http://englishjavadrinker.blogspot.com/search/label/SVGRoundTrip">
 * SVGRoundTrip</a>.
 */
@SuppressWarnings("unused")
public class A {
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
		Composite origComposite = ((Graphics2D) g).getComposite();
		if (origComposite instanceof AlphaComposite) {
			AlphaComposite origAlphaComposite = (AlphaComposite) origComposite;
			if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
				origAlpha = origAlphaComposite.getAlpha();
			}
		}

		Shape clip_ = g.getClip();
		AffineTransform defaultTransform_ = g.getTransform();
		// is CompositeGraphicsNode
		float alpha__0 = origAlpha;
		origAlpha = origAlpha * 1.0f;
		g.setComposite(AlphaComposite.getInstance(3, origAlpha));
		Shape clip__0 = g.getClip();
		AffineTransform defaultTransform__0 = g.getTransform();
		g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 280.0f, -30.0f));
		clip = new Area(g.getClip());
		clip.intersect(new Area(new Rectangle2D.Double(-280.0, 30.0, 1026.0, 870.0)));
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
		((GeneralPath) shape).moveTo(478.0, 323.0);
		((GeneralPath) shape).lineTo(486.0, 332.0);
		((GeneralPath) shape).lineTo(494.0, 337.0);
		((GeneralPath) shape).lineTo(496.0, 338.0);
		((GeneralPath) shape).lineTo(500.0, 334.0);
		((GeneralPath) shape).lineTo(501.0, 340.0);
		((GeneralPath) shape).lineTo(505.0, 339.0);
		((GeneralPath) shape).lineTo(507.0, 346.0);
		((GeneralPath) shape).lineTo(510.0, 341.0);
		((GeneralPath) shape).lineTo(512.0, 342.0);
		((GeneralPath) shape).lineTo(513.0, 351.0);
		((GeneralPath) shape).lineTo(520.0, 355.0);
		((GeneralPath) shape).lineTo(519.0, 362.0);
		((GeneralPath) shape).lineTo(528.0, 356.0);
		((GeneralPath) shape).lineTo(533.0, 358.0);
		((GeneralPath) shape).lineTo(536.0, 362.0);
		((GeneralPath) shape).lineTo(538.0, 361.0);
		((GeneralPath) shape).lineTo(537.0, 366.0);
		((GeneralPath) shape).lineTo(540.0, 368.0);
		((GeneralPath) shape).lineTo(543.0, 374.0);
		((GeneralPath) shape).lineTo(536.0, 388.0);
		((GeneralPath) shape).lineTo(540.0, 388.0);
		((GeneralPath) shape).lineTo(541.0, 386.0);
		((GeneralPath) shape).lineTo(545.0, 387.0);
		((GeneralPath) shape).lineTo(549.0, 382.0);
		((GeneralPath) shape).lineTo(553.0, 381.0);
		((GeneralPath) shape).lineTo(556.0, 393.0);
		((GeneralPath) shape).lineTo(559.0, 394.0);
		((GeneralPath) shape).lineTo(559.0, 402.0);
		((GeneralPath) shape).lineTo(555.0, 403.0);
		((GeneralPath) shape).lineTo(560.0, 409.0);
		((GeneralPath) shape).lineTo(564.0, 407.0);
		((GeneralPath) shape).lineTo(569.0, 413.0);
		((GeneralPath) shape).lineTo(576.0, 409.0);
		((GeneralPath) shape).lineTo(577.0, 404.0);
		((GeneralPath) shape).lineTo(580.0, 404.0);
		((GeneralPath) shape).lineTo(584.0, 407.0);
		((GeneralPath) shape).lineTo(586.0, 403.0);
		((GeneralPath) shape).lineTo(592.0, 404.0);
		((GeneralPath) shape).lineTo(594.0, 411.0);
		((GeneralPath) shape).lineTo(593.0, 418.0);
		((GeneralPath) shape).lineTo(597.0, 426.0);
		((GeneralPath) shape).lineTo(592.0, 426.0);
		((GeneralPath) shape).lineTo(590.0, 420.0);
		((GeneralPath) shape).lineTo(589.0, 424.0);
		((GeneralPath) shape).lineTo(583.0, 426.0);
		((GeneralPath) shape).lineTo(580.0, 438.0);
		((GeneralPath) shape).lineTo(576.0, 443.0);
		((GeneralPath) shape).lineTo(571.0, 446.0);
		((GeneralPath) shape).lineTo(570.0, 453.0);
		((GeneralPath) shape).lineTo(565.0, 454.0);
		((GeneralPath) shape).lineTo(563.0, 457.0);
		((GeneralPath) shape).lineTo(557.0, 455.0);
		((GeneralPath) shape).lineTo(554.0, 462.0);
		((GeneralPath) shape).lineTo(549.0, 454.0);
		((GeneralPath) shape).lineTo(545.0, 456.0);
		((GeneralPath) shape).lineTo(538.0, 456.0);
		((GeneralPath) shape).lineTo(532.0, 459.0);
		((GeneralPath) shape).lineTo(528.0, 455.0);
		((GeneralPath) shape).lineTo(526.0, 456.0);
		((GeneralPath) shape).lineTo(520.0, 453.0);
		((GeneralPath) shape).lineTo(516.0, 454.0);
		((GeneralPath) shape).lineTo(510.0, 450.0);
		((GeneralPath) shape).lineTo(509.0, 447.0);
		((GeneralPath) shape).lineTo(504.0, 446.0);
		((GeneralPath) shape).lineTo(502.0, 441.0);
		((GeneralPath) shape).lineTo(498.0, 442.0);
		((GeneralPath) shape).lineTo(495.0, 440.0);
		((GeneralPath) shape).lineTo(490.0, 442.0);
		((GeneralPath) shape).lineTo(486.0, 440.0);
		((GeneralPath) shape).lineTo(480.0, 433.0);
		((GeneralPath) shape).lineTo(470.0, 429.0);
		((GeneralPath) shape).lineTo(466.0, 425.0);
		((GeneralPath) shape).lineTo(467.0, 414.0);
		((GeneralPath) shape).lineTo(461.0, 410.0);
		((GeneralPath) shape).lineTo(462.0, 405.0);
		((GeneralPath) shape).lineTo(454.0, 397.0);
		((GeneralPath) shape).lineTo(455.0, 393.0);
		((GeneralPath) shape).lineTo(458.0, 393.0);
		((GeneralPath) shape).lineTo(456.0, 390.0);
		((GeneralPath) shape).lineTo(461.0, 389.0);
		((GeneralPath) shape).lineTo(464.0, 381.0);
		((GeneralPath) shape).lineTo(471.0, 372.0);
		((GeneralPath) shape).lineTo(474.0, 363.0);
		((GeneralPath) shape).lineTo(460.0, 363.0);
		((GeneralPath) shape).lineTo(460.0, 365.0);
		((GeneralPath) shape).lineTo(455.0, 369.0);
		((GeneralPath) shape).lineTo(450.0, 364.0);
		((GeneralPath) shape).lineTo(443.0, 364.0);
		((GeneralPath) shape).lineTo(449.0, 358.0);
		((GeneralPath) shape).lineTo(449.0, 354.0);
		((GeneralPath) shape).lineTo(463.0, 337.0);
		((GeneralPath) shape).lineTo(460.0, 335.0);
		((GeneralPath) shape).lineTo(463.0, 330.0);
		((GeneralPath) shape).lineTo(471.0, 329.0);
		((GeneralPath) shape).lineTo(473.0, 324.0);
		((GeneralPath) shape).lineTo(475.0, 325.0);
		((GeneralPath) shape).closePath();
		g.setPaint(paint);
		g.fill(shape);
		paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
		stroke = new BasicStroke(2.0f, 1, 1, 4.0f, null, 0.0f);
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(478.0, 323.0);
		((GeneralPath) shape).lineTo(486.0, 332.0);
		((GeneralPath) shape).lineTo(494.0, 337.0);
		((GeneralPath) shape).lineTo(496.0, 338.0);
		((GeneralPath) shape).lineTo(500.0, 334.0);
		((GeneralPath) shape).lineTo(501.0, 340.0);
		((GeneralPath) shape).lineTo(505.0, 339.0);
		((GeneralPath) shape).lineTo(507.0, 346.0);
		((GeneralPath) shape).lineTo(510.0, 341.0);
		((GeneralPath) shape).lineTo(512.0, 342.0);
		((GeneralPath) shape).lineTo(513.0, 351.0);
		((GeneralPath) shape).lineTo(520.0, 355.0);
		((GeneralPath) shape).lineTo(519.0, 362.0);
		((GeneralPath) shape).lineTo(528.0, 356.0);
		((GeneralPath) shape).lineTo(533.0, 358.0);
		((GeneralPath) shape).lineTo(536.0, 362.0);
		((GeneralPath) shape).lineTo(538.0, 361.0);
		((GeneralPath) shape).lineTo(537.0, 366.0);
		((GeneralPath) shape).lineTo(540.0, 368.0);
		((GeneralPath) shape).lineTo(543.0, 374.0);
		((GeneralPath) shape).lineTo(536.0, 388.0);
		((GeneralPath) shape).lineTo(540.0, 388.0);
		((GeneralPath) shape).lineTo(541.0, 386.0);
		((GeneralPath) shape).lineTo(545.0, 387.0);
		((GeneralPath) shape).lineTo(549.0, 382.0);
		((GeneralPath) shape).lineTo(553.0, 381.0);
		((GeneralPath) shape).lineTo(556.0, 393.0);
		((GeneralPath) shape).lineTo(559.0, 394.0);
		((GeneralPath) shape).lineTo(559.0, 402.0);
		((GeneralPath) shape).lineTo(555.0, 403.0);
		((GeneralPath) shape).lineTo(560.0, 409.0);
		((GeneralPath) shape).lineTo(564.0, 407.0);
		((GeneralPath) shape).lineTo(569.0, 413.0);
		((GeneralPath) shape).lineTo(576.0, 409.0);
		((GeneralPath) shape).lineTo(577.0, 404.0);
		((GeneralPath) shape).lineTo(580.0, 404.0);
		((GeneralPath) shape).lineTo(584.0, 407.0);
		((GeneralPath) shape).lineTo(586.0, 403.0);
		((GeneralPath) shape).lineTo(592.0, 404.0);
		((GeneralPath) shape).lineTo(594.0, 411.0);
		((GeneralPath) shape).lineTo(593.0, 418.0);
		((GeneralPath) shape).lineTo(597.0, 426.0);
		((GeneralPath) shape).lineTo(592.0, 426.0);
		((GeneralPath) shape).lineTo(590.0, 420.0);
		((GeneralPath) shape).lineTo(589.0, 424.0);
		((GeneralPath) shape).lineTo(583.0, 426.0);
		((GeneralPath) shape).lineTo(580.0, 438.0);
		((GeneralPath) shape).lineTo(576.0, 443.0);
		((GeneralPath) shape).lineTo(571.0, 446.0);
		((GeneralPath) shape).lineTo(570.0, 453.0);
		((GeneralPath) shape).lineTo(565.0, 454.0);
		((GeneralPath) shape).lineTo(563.0, 457.0);
		((GeneralPath) shape).lineTo(557.0, 455.0);
		((GeneralPath) shape).lineTo(554.0, 462.0);
		((GeneralPath) shape).lineTo(549.0, 454.0);
		((GeneralPath) shape).lineTo(545.0, 456.0);
		((GeneralPath) shape).lineTo(538.0, 456.0);
		((GeneralPath) shape).lineTo(532.0, 459.0);
		((GeneralPath) shape).lineTo(528.0, 455.0);
		((GeneralPath) shape).lineTo(526.0, 456.0);
		((GeneralPath) shape).lineTo(520.0, 453.0);
		((GeneralPath) shape).lineTo(516.0, 454.0);
		((GeneralPath) shape).lineTo(510.0, 450.0);
		((GeneralPath) shape).lineTo(509.0, 447.0);
		((GeneralPath) shape).lineTo(504.0, 446.0);
		((GeneralPath) shape).lineTo(502.0, 441.0);
		((GeneralPath) shape).lineTo(498.0, 442.0);
		((GeneralPath) shape).lineTo(495.0, 440.0);
		((GeneralPath) shape).lineTo(490.0, 442.0);
		((GeneralPath) shape).lineTo(486.0, 440.0);
		((GeneralPath) shape).lineTo(480.0, 433.0);
		((GeneralPath) shape).lineTo(470.0, 429.0);
		((GeneralPath) shape).lineTo(466.0, 425.0);
		((GeneralPath) shape).lineTo(467.0, 414.0);
		((GeneralPath) shape).lineTo(461.0, 410.0);
		((GeneralPath) shape).lineTo(462.0, 405.0);
		((GeneralPath) shape).lineTo(454.0, 397.0);
		((GeneralPath) shape).lineTo(455.0, 393.0);
		((GeneralPath) shape).lineTo(458.0, 393.0);
		((GeneralPath) shape).lineTo(456.0, 390.0);
		((GeneralPath) shape).lineTo(461.0, 389.0);
		((GeneralPath) shape).lineTo(464.0, 381.0);
		((GeneralPath) shape).lineTo(471.0, 372.0);
		((GeneralPath) shape).lineTo(474.0, 363.0);
		((GeneralPath) shape).lineTo(460.0, 363.0);
		((GeneralPath) shape).lineTo(460.0, 365.0);
		((GeneralPath) shape).lineTo(455.0, 369.0);
		((GeneralPath) shape).lineTo(450.0, 364.0);
		((GeneralPath) shape).lineTo(443.0, 364.0);
		((GeneralPath) shape).lineTo(449.0, 358.0);
		((GeneralPath) shape).lineTo(449.0, 354.0);
		((GeneralPath) shape).lineTo(463.0, 337.0);
		((GeneralPath) shape).lineTo(460.0, 335.0);
		((GeneralPath) shape).lineTo(463.0, 330.0);
		((GeneralPath) shape).lineTo(471.0, 329.0);
		((GeneralPath) shape).lineTo(473.0, 324.0);
		((GeneralPath) shape).lineTo(475.0, 325.0);
		((GeneralPath) shape).closePath();
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
		return 722;
	}

	/**
	 * Returns the Y of the bounding box of the original SVG image.
	 * 
	 * @return The Y of the bounding box of the original SVG image.
	 */
	public static int getOrigY() {
		return 292;
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
