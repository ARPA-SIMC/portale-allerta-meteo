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
public class H1 {
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
((GeneralPath)shape).moveTo(47.0, 133.0);
((GeneralPath)shape).lineTo(49.0, 134.0);
((GeneralPath)shape).lineTo(49.0, 137.0);
((GeneralPath)shape).lineTo(51.0, 137.0);
((GeneralPath)shape).lineTo(51.0, 143.0);
((GeneralPath)shape).lineTo(46.0, 146.0);
((GeneralPath)shape).lineTo(50.0, 151.0);
((GeneralPath)shape).lineTo(52.0, 151.0);
((GeneralPath)shape).lineTo(67.0, 136.0);
((GeneralPath)shape).lineTo(67.0, 140.0);
((GeneralPath)shape).lineTo(70.0, 144.0);
((GeneralPath)shape).lineTo(77.0, 144.0);
((GeneralPath)shape).lineTo(81.0, 142.0);
((GeneralPath)shape).lineTo(82.0, 150.0);
((GeneralPath)shape).lineTo(85.0, 150.0);
((GeneralPath)shape).lineTo(89.0, 146.0);
((GeneralPath)shape).lineTo(88.0, 148.0);
((GeneralPath)shape).lineTo(92.0, 150.0);
((GeneralPath)shape).lineTo(93.0, 153.0);
((GeneralPath)shape).lineTo(96.0, 152.0);
((GeneralPath)shape).lineTo(99.0, 157.0);
((GeneralPath)shape).lineTo(104.0, 156.0);
((GeneralPath)shape).lineTo(100.0, 159.0);
((GeneralPath)shape).lineTo(99.0, 164.0);
((GeneralPath)shape).lineTo(101.0, 165.0);
((GeneralPath)shape).lineTo(101.0, 168.0);
((GeneralPath)shape).lineTo(104.0, 173.0);
((GeneralPath)shape).lineTo(107.0, 171.0);
((GeneralPath)shape).lineTo(108.0, 173.0);
((GeneralPath)shape).lineTo(113.0, 173.0);
((GeneralPath)shape).lineTo(114.0, 176.0);
((GeneralPath)shape).lineTo(110.0, 182.0);
((GeneralPath)shape).lineTo(113.0, 178.0);
((GeneralPath)shape).lineTo(118.0, 180.0);
((GeneralPath)shape).lineTo(122.0, 173.0);
((GeneralPath)shape).lineTo(128.0, 185.0);
((GeneralPath)shape).lineTo(137.0, 180.0);
((GeneralPath)shape).lineTo(140.0, 181.0);
((GeneralPath)shape).lineTo(141.0, 180.0);
((GeneralPath)shape).lineTo(139.0, 177.0);
((GeneralPath)shape).lineTo(141.0, 175.0);
((GeneralPath)shape).lineTo(145.0, 176.0);
((GeneralPath)shape).lineTo(146.0, 180.0);
((GeneralPath)shape).lineTo(149.0, 181.0);
((GeneralPath)shape).lineTo(158.0, 176.0);
((GeneralPath)shape).lineTo(159.0, 180.0);
((GeneralPath)shape).lineTo(160.0, 178.0);
((GeneralPath)shape).lineTo(165.0, 181.0);
((GeneralPath)shape).lineTo(163.0, 184.0);
((GeneralPath)shape).lineTo(163.0, 192.0);
((GeneralPath)shape).lineTo(160.0, 194.0);
((GeneralPath)shape).lineTo(162.0, 197.0);
((GeneralPath)shape).lineTo(168.0, 198.0);
((GeneralPath)shape).lineTo(170.0, 200.0);
((GeneralPath)shape).lineTo(169.0, 201.0);
((GeneralPath)shape).lineTo(176.0, 201.0);
((GeneralPath)shape).lineTo(180.0, 199.0);
((GeneralPath)shape).lineTo(181.0, 195.0);
((GeneralPath)shape).lineTo(184.0, 195.0);
((GeneralPath)shape).lineTo(189.0, 198.0);
((GeneralPath)shape).lineTo(186.0, 205.0);
((GeneralPath)shape).lineTo(172.0, 218.0);
((GeneralPath)shape).lineTo(168.0, 215.0);
((GeneralPath)shape).lineTo(160.0, 213.0);
((GeneralPath)shape).lineTo(157.0, 209.0);
((GeneralPath)shape).lineTo(150.0, 208.0);
((GeneralPath)shape).lineTo(150.0, 214.0);
((GeneralPath)shape).lineTo(141.0, 214.0);
((GeneralPath)shape).lineTo(137.0, 212.0);
((GeneralPath)shape).lineTo(138.0, 214.0);
((GeneralPath)shape).lineTo(133.0, 216.0);
((GeneralPath)shape).lineTo(127.0, 213.0);
((GeneralPath)shape).lineTo(130.0, 207.0);
((GeneralPath)shape).lineTo(127.0, 204.0);
((GeneralPath)shape).lineTo(128.0, 203.0);
((GeneralPath)shape).lineTo(125.0, 203.0);
((GeneralPath)shape).lineTo(126.0, 201.0);
((GeneralPath)shape).lineTo(123.0, 200.0);
((GeneralPath)shape).lineTo(122.0, 206.0);
((GeneralPath)shape).lineTo(112.0, 215.0);
((GeneralPath)shape).lineTo(113.0, 221.0);
((GeneralPath)shape).lineTo(101.0, 223.0);
((GeneralPath)shape).lineTo(99.0, 222.0);
((GeneralPath)shape).lineTo(95.0, 215.0);
((GeneralPath)shape).lineTo(92.0, 214.0);
((GeneralPath)shape).lineTo(92.0, 211.0);
((GeneralPath)shape).lineTo(96.0, 207.0);
((GeneralPath)shape).lineTo(92.0, 200.0);
((GeneralPath)shape).lineTo(97.0, 190.0);
((GeneralPath)shape).lineTo(98.0, 183.0);
((GeneralPath)shape).lineTo(95.0, 182.0);
((GeneralPath)shape).lineTo(94.0, 184.0);
((GeneralPath)shape).lineTo(88.0, 185.0);
((GeneralPath)shape).lineTo(85.0, 181.0);
((GeneralPath)shape).lineTo(82.0, 182.0);
((GeneralPath)shape).lineTo(77.0, 180.0);
((GeneralPath)shape).lineTo(79.0, 177.0);
((GeneralPath)shape).lineTo(75.0, 170.0);
((GeneralPath)shape).lineTo(79.0, 167.0);
((GeneralPath)shape).lineTo(82.0, 162.0);
((GeneralPath)shape).lineTo(80.0, 159.0);
((GeneralPath)shape).lineTo(73.0, 161.0);
((GeneralPath)shape).lineTo(68.0, 165.0);
((GeneralPath)shape).lineTo(67.0, 169.0);
((GeneralPath)shape).lineTo(65.0, 167.0);
((GeneralPath)shape).lineTo(58.0, 170.0);
((GeneralPath)shape).lineTo(57.0, 175.0);
((GeneralPath)shape).lineTo(46.0, 178.0);
((GeneralPath)shape).lineTo(43.0, 183.0);
((GeneralPath)shape).lineTo(40.0, 184.0);
((GeneralPath)shape).lineTo(37.0, 180.0);
((GeneralPath)shape).lineTo(36.0, 172.0);
((GeneralPath)shape).lineTo(28.0, 170.0);
((GeneralPath)shape).lineTo(27.0, 167.0);
((GeneralPath)shape).lineTo(24.0, 166.0);
((GeneralPath)shape).lineTo(27.0, 159.0);
((GeneralPath)shape).lineTo(26.0, 156.0);
((GeneralPath)shape).lineTo(29.0, 156.0);
((GeneralPath)shape).lineTo(32.0, 153.0);
((GeneralPath)shape).lineTo(37.0, 139.0);
((GeneralPath)shape).lineTo(40.0, 138.0);
((GeneralPath)shape).lineTo(42.0, 133.0);
((GeneralPath)shape).lineTo(47.0, 132.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.0, 133.0);
((GeneralPath)shape).lineTo(49.0, 134.0);
((GeneralPath)shape).lineTo(49.0, 137.0);
((GeneralPath)shape).lineTo(51.0, 137.0);
((GeneralPath)shape).lineTo(51.0, 143.0);
((GeneralPath)shape).lineTo(46.0, 146.0);
((GeneralPath)shape).lineTo(50.0, 151.0);
((GeneralPath)shape).lineTo(52.0, 151.0);
((GeneralPath)shape).lineTo(67.0, 136.0);
((GeneralPath)shape).lineTo(67.0, 140.0);
((GeneralPath)shape).lineTo(70.0, 144.0);
((GeneralPath)shape).lineTo(77.0, 144.0);
((GeneralPath)shape).lineTo(81.0, 142.0);
((GeneralPath)shape).lineTo(82.0, 150.0);
((GeneralPath)shape).lineTo(85.0, 150.0);
((GeneralPath)shape).lineTo(89.0, 146.0);
((GeneralPath)shape).lineTo(88.0, 148.0);
((GeneralPath)shape).lineTo(92.0, 150.0);
((GeneralPath)shape).lineTo(93.0, 153.0);
((GeneralPath)shape).lineTo(96.0, 152.0);
((GeneralPath)shape).lineTo(99.0, 157.0);
((GeneralPath)shape).lineTo(104.0, 156.0);
((GeneralPath)shape).lineTo(100.0, 159.0);
((GeneralPath)shape).lineTo(99.0, 164.0);
((GeneralPath)shape).lineTo(101.0, 165.0);
((GeneralPath)shape).lineTo(101.0, 168.0);
((GeneralPath)shape).lineTo(104.0, 173.0);
((GeneralPath)shape).lineTo(107.0, 171.0);
((GeneralPath)shape).lineTo(108.0, 173.0);
((GeneralPath)shape).lineTo(113.0, 173.0);
((GeneralPath)shape).lineTo(114.0, 176.0);
((GeneralPath)shape).lineTo(110.0, 182.0);
((GeneralPath)shape).lineTo(113.0, 178.0);
((GeneralPath)shape).lineTo(118.0, 180.0);
((GeneralPath)shape).lineTo(122.0, 173.0);
((GeneralPath)shape).lineTo(128.0, 185.0);
((GeneralPath)shape).lineTo(137.0, 180.0);
((GeneralPath)shape).lineTo(140.0, 181.0);
((GeneralPath)shape).lineTo(141.0, 180.0);
((GeneralPath)shape).lineTo(139.0, 177.0);
((GeneralPath)shape).lineTo(141.0, 175.0);
((GeneralPath)shape).lineTo(145.0, 176.0);
((GeneralPath)shape).lineTo(146.0, 180.0);
((GeneralPath)shape).lineTo(149.0, 181.0);
((GeneralPath)shape).lineTo(158.0, 176.0);
((GeneralPath)shape).lineTo(159.0, 180.0);
((GeneralPath)shape).lineTo(160.0, 178.0);
((GeneralPath)shape).lineTo(165.0, 181.0);
((GeneralPath)shape).lineTo(163.0, 184.0);
((GeneralPath)shape).lineTo(163.0, 192.0);
((GeneralPath)shape).lineTo(160.0, 194.0);
((GeneralPath)shape).lineTo(162.0, 197.0);
((GeneralPath)shape).lineTo(168.0, 198.0);
((GeneralPath)shape).lineTo(170.0, 200.0);
((GeneralPath)shape).lineTo(169.0, 201.0);
((GeneralPath)shape).lineTo(176.0, 201.0);
((GeneralPath)shape).lineTo(180.0, 199.0);
((GeneralPath)shape).lineTo(181.0, 195.0);
((GeneralPath)shape).lineTo(184.0, 195.0);
((GeneralPath)shape).lineTo(189.0, 198.0);
((GeneralPath)shape).lineTo(186.0, 205.0);
((GeneralPath)shape).lineTo(172.0, 218.0);
((GeneralPath)shape).lineTo(168.0, 215.0);
((GeneralPath)shape).lineTo(160.0, 213.0);
((GeneralPath)shape).lineTo(157.0, 209.0);
((GeneralPath)shape).lineTo(150.0, 208.0);
((GeneralPath)shape).lineTo(150.0, 214.0);
((GeneralPath)shape).lineTo(141.0, 214.0);
((GeneralPath)shape).lineTo(137.0, 212.0);
((GeneralPath)shape).lineTo(138.0, 214.0);
((GeneralPath)shape).lineTo(133.0, 216.0);
((GeneralPath)shape).lineTo(127.0, 213.0);
((GeneralPath)shape).lineTo(130.0, 207.0);
((GeneralPath)shape).lineTo(127.0, 204.0);
((GeneralPath)shape).lineTo(128.0, 203.0);
((GeneralPath)shape).lineTo(125.0, 203.0);
((GeneralPath)shape).lineTo(126.0, 201.0);
((GeneralPath)shape).lineTo(123.0, 200.0);
((GeneralPath)shape).lineTo(122.0, 206.0);
((GeneralPath)shape).lineTo(112.0, 215.0);
((GeneralPath)shape).lineTo(113.0, 221.0);
((GeneralPath)shape).lineTo(101.0, 223.0);
((GeneralPath)shape).lineTo(99.0, 222.0);
((GeneralPath)shape).lineTo(95.0, 215.0);
((GeneralPath)shape).lineTo(92.0, 214.0);
((GeneralPath)shape).lineTo(92.0, 211.0);
((GeneralPath)shape).lineTo(96.0, 207.0);
((GeneralPath)shape).lineTo(92.0, 200.0);
((GeneralPath)shape).lineTo(97.0, 190.0);
((GeneralPath)shape).lineTo(98.0, 183.0);
((GeneralPath)shape).lineTo(95.0, 182.0);
((GeneralPath)shape).lineTo(94.0, 184.0);
((GeneralPath)shape).lineTo(88.0, 185.0);
((GeneralPath)shape).lineTo(85.0, 181.0);
((GeneralPath)shape).lineTo(82.0, 182.0);
((GeneralPath)shape).lineTo(77.0, 180.0);
((GeneralPath)shape).lineTo(79.0, 177.0);
((GeneralPath)shape).lineTo(75.0, 170.0);
((GeneralPath)shape).lineTo(79.0, 167.0);
((GeneralPath)shape).lineTo(82.0, 162.0);
((GeneralPath)shape).lineTo(80.0, 159.0);
((GeneralPath)shape).lineTo(73.0, 161.0);
((GeneralPath)shape).lineTo(68.0, 165.0);
((GeneralPath)shape).lineTo(67.0, 169.0);
((GeneralPath)shape).lineTo(65.0, 167.0);
((GeneralPath)shape).lineTo(58.0, 170.0);
((GeneralPath)shape).lineTo(57.0, 175.0);
((GeneralPath)shape).lineTo(46.0, 178.0);
((GeneralPath)shape).lineTo(43.0, 183.0);
((GeneralPath)shape).lineTo(40.0, 184.0);
((GeneralPath)shape).lineTo(37.0, 180.0);
((GeneralPath)shape).lineTo(36.0, 172.0);
((GeneralPath)shape).lineTo(28.0, 170.0);
((GeneralPath)shape).lineTo(27.0, 167.0);
((GeneralPath)shape).lineTo(24.0, 166.0);
((GeneralPath)shape).lineTo(27.0, 159.0);
((GeneralPath)shape).lineTo(26.0, 156.0);
((GeneralPath)shape).lineTo(29.0, 156.0);
((GeneralPath)shape).lineTo(32.0, 153.0);
((GeneralPath)shape).lineTo(37.0, 139.0);
((GeneralPath)shape).lineTo(40.0, 138.0);
((GeneralPath)shape).lineTo(42.0, 133.0);
((GeneralPath)shape).lineTo(47.0, 132.0);
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
        return 203;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 284;
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

