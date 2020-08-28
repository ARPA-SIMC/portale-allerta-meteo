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
public class G2 {
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
((GeneralPath)shape).moveTo(80.0, 160.0);
((GeneralPath)shape).lineTo(82.0, 162.0);
((GeneralPath)shape).lineTo(79.0, 167.0);
((GeneralPath)shape).lineTo(75.0, 170.0);
((GeneralPath)shape).lineTo(79.0, 177.0);
((GeneralPath)shape).lineTo(77.0, 180.0);
((GeneralPath)shape).lineTo(82.0, 182.0);
((GeneralPath)shape).lineTo(85.0, 181.0);
((GeneralPath)shape).lineTo(88.0, 185.0);
((GeneralPath)shape).lineTo(94.0, 184.0);
((GeneralPath)shape).lineTo(95.0, 182.0);
((GeneralPath)shape).lineTo(98.0, 183.0);
((GeneralPath)shape).lineTo(97.0, 190.0);
((GeneralPath)shape).lineTo(92.0, 200.0);
((GeneralPath)shape).lineTo(96.0, 207.0);
((GeneralPath)shape).lineTo(92.0, 211.0);
((GeneralPath)shape).lineTo(92.0, 214.0);
((GeneralPath)shape).lineTo(95.0, 215.0);
((GeneralPath)shape).lineTo(99.0, 222.0);
((GeneralPath)shape).lineTo(101.0, 223.0);
((GeneralPath)shape).lineTo(113.0, 221.0);
((GeneralPath)shape).lineTo(112.0, 215.0);
((GeneralPath)shape).lineTo(122.0, 206.0);
((GeneralPath)shape).lineTo(123.0, 200.0);
((GeneralPath)shape).lineTo(126.0, 201.0);
((GeneralPath)shape).lineTo(125.0, 203.0);
((GeneralPath)shape).lineTo(128.0, 203.0);
((GeneralPath)shape).lineTo(127.0, 204.0);
((GeneralPath)shape).lineTo(130.0, 207.0);
((GeneralPath)shape).lineTo(127.0, 213.0);
((GeneralPath)shape).lineTo(133.0, 216.0);
((GeneralPath)shape).lineTo(138.0, 214.0);
((GeneralPath)shape).lineTo(137.0, 212.0);
((GeneralPath)shape).lineTo(141.0, 214.0);
((GeneralPath)shape).lineTo(150.0, 214.0);
((GeneralPath)shape).lineTo(150.0, 208.0);
((GeneralPath)shape).lineTo(157.0, 209.0);
((GeneralPath)shape).lineTo(160.0, 213.0);
((GeneralPath)shape).lineTo(168.0, 215.0);
((GeneralPath)shape).lineTo(172.0, 218.0);
((GeneralPath)shape).lineTo(178.0, 213.0);
((GeneralPath)shape).lineTo(183.0, 218.0);
((GeneralPath)shape).lineTo(190.0, 206.0);
((GeneralPath)shape).lineTo(191.0, 208.0);
((GeneralPath)shape).lineTo(192.0, 207.0);
((GeneralPath)shape).lineTo(197.0, 209.0);
((GeneralPath)shape).lineTo(199.0, 207.0);
((GeneralPath)shape).lineTo(202.0, 210.0);
((GeneralPath)shape).lineTo(202.0, 212.0);
((GeneralPath)shape).lineTo(210.0, 215.0);
((GeneralPath)shape).lineTo(209.0, 222.0);
((GeneralPath)shape).lineTo(212.0, 225.0);
((GeneralPath)shape).lineTo(214.0, 223.0);
((GeneralPath)shape).lineTo(217.0, 225.0);
((GeneralPath)shape).lineTo(218.0, 232.0);
((GeneralPath)shape).lineTo(214.0, 236.0);
((GeneralPath)shape).lineTo(218.0, 239.0);
((GeneralPath)shape).lineTo(212.0, 242.0);
((GeneralPath)shape).lineTo(211.0, 246.0);
((GeneralPath)shape).lineTo(207.0, 247.0);
((GeneralPath)shape).lineTo(204.0, 250.0);
((GeneralPath)shape).lineTo(199.0, 249.0);
((GeneralPath)shape).lineTo(191.0, 253.0);
((GeneralPath)shape).lineTo(187.0, 251.0);
((GeneralPath)shape).lineTo(186.0, 248.0);
((GeneralPath)shape).lineTo(181.0, 250.0);
((GeneralPath)shape).lineTo(180.0, 252.0);
((GeneralPath)shape).lineTo(173.0, 252.0);
((GeneralPath)shape).lineTo(168.0, 256.0);
((GeneralPath)shape).lineTo(168.0, 253.0);
((GeneralPath)shape).lineTo(164.0, 247.0);
((GeneralPath)shape).lineTo(158.0, 251.0);
((GeneralPath)shape).lineTo(155.0, 248.0);
((GeneralPath)shape).lineTo(152.0, 240.0);
((GeneralPath)shape).lineTo(148.0, 243.0);
((GeneralPath)shape).lineTo(146.0, 240.0);
((GeneralPath)shape).lineTo(142.0, 244.0);
((GeneralPath)shape).lineTo(145.0, 246.0);
((GeneralPath)shape).lineTo(146.0, 249.0);
((GeneralPath)shape).lineTo(142.0, 253.0);
((GeneralPath)shape).lineTo(131.0, 259.0);
((GeneralPath)shape).lineTo(125.0, 254.0);
((GeneralPath)shape).lineTo(127.0, 252.0);
((GeneralPath)shape).lineTo(123.0, 250.0);
((GeneralPath)shape).lineTo(120.0, 250.0);
((GeneralPath)shape).lineTo(118.0, 254.0);
((GeneralPath)shape).lineTo(113.0, 255.0);
((GeneralPath)shape).lineTo(110.0, 251.0);
((GeneralPath)shape).lineTo(106.0, 255.0);
((GeneralPath)shape).lineTo(104.0, 252.0);
((GeneralPath)shape).lineTo(101.0, 253.0);
((GeneralPath)shape).lineTo(100.0, 247.0);
((GeneralPath)shape).lineTo(98.0, 245.0);
((GeneralPath)shape).lineTo(94.0, 245.0);
((GeneralPath)shape).lineTo(94.0, 238.0);
((GeneralPath)shape).lineTo(86.0, 241.0);
((GeneralPath)shape).lineTo(86.0, 246.0);
((GeneralPath)shape).lineTo(81.0, 249.0);
((GeneralPath)shape).lineTo(74.0, 244.0);
((GeneralPath)shape).lineTo(75.0, 240.0);
((GeneralPath)shape).lineTo(83.0, 234.0);
((GeneralPath)shape).lineTo(81.0, 229.0);
((GeneralPath)shape).lineTo(80.0, 231.0);
((GeneralPath)shape).lineTo(79.0, 229.0);
((GeneralPath)shape).lineTo(77.0, 217.0);
((GeneralPath)shape).lineTo(70.0, 217.0);
((GeneralPath)shape).lineTo(67.0, 218.0);
((GeneralPath)shape).lineTo(66.0, 221.0);
((GeneralPath)shape).lineTo(63.0, 221.0);
((GeneralPath)shape).lineTo(58.0, 212.0);
((GeneralPath)shape).lineTo(60.0, 209.0);
((GeneralPath)shape).lineTo(58.0, 208.0);
((GeneralPath)shape).lineTo(59.0, 204.0);
((GeneralPath)shape).lineTo(62.0, 205.0);
((GeneralPath)shape).lineTo(65.0, 203.0);
((GeneralPath)shape).lineTo(64.0, 192.0);
((GeneralPath)shape).lineTo(68.0, 192.0);
((GeneralPath)shape).lineTo(65.0, 184.0);
((GeneralPath)shape).lineTo(59.0, 185.0);
((GeneralPath)shape).lineTo(59.0, 188.0);
((GeneralPath)shape).lineTo(56.0, 188.0);
((GeneralPath)shape).lineTo(56.0, 190.0);
((GeneralPath)shape).lineTo(54.0, 187.0);
((GeneralPath)shape).lineTo(49.0, 191.0);
((GeneralPath)shape).lineTo(55.0, 196.0);
((GeneralPath)shape).lineTo(54.0, 198.0);
((GeneralPath)shape).lineTo(47.0, 199.0);
((GeneralPath)shape).lineTo(46.0, 207.0);
((GeneralPath)shape).lineTo(49.0, 208.0);
((GeneralPath)shape).lineTo(47.0, 209.0);
((GeneralPath)shape).lineTo(43.0, 206.0);
((GeneralPath)shape).lineTo(33.0, 206.0);
((GeneralPath)shape).lineTo(25.0, 199.0);
((GeneralPath)shape).lineTo(31.0, 194.0);
((GeneralPath)shape).lineTo(32.0, 190.0);
((GeneralPath)shape).lineTo(38.0, 187.0);
((GeneralPath)shape).lineTo(46.0, 178.0);
((GeneralPath)shape).lineTo(57.0, 175.0);
((GeneralPath)shape).lineTo(58.0, 170.0);
((GeneralPath)shape).lineTo(65.0, 167.0);
((GeneralPath)shape).lineTo(67.0, 169.0);
((GeneralPath)shape).lineTo(68.0, 165.0);
((GeneralPath)shape).lineTo(73.0, 161.0);
((GeneralPath)shape).lineTo(76.0, 161.0);
((GeneralPath)shape).lineTo(77.0, 159.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.0, 160.0);
((GeneralPath)shape).lineTo(82.0, 162.0);
((GeneralPath)shape).lineTo(79.0, 167.0);
((GeneralPath)shape).lineTo(75.0, 170.0);
((GeneralPath)shape).lineTo(79.0, 177.0);
((GeneralPath)shape).lineTo(77.0, 180.0);
((GeneralPath)shape).lineTo(82.0, 182.0);
((GeneralPath)shape).lineTo(85.0, 181.0);
((GeneralPath)shape).lineTo(88.0, 185.0);
((GeneralPath)shape).lineTo(94.0, 184.0);
((GeneralPath)shape).lineTo(95.0, 182.0);
((GeneralPath)shape).lineTo(98.0, 183.0);
((GeneralPath)shape).lineTo(97.0, 190.0);
((GeneralPath)shape).lineTo(92.0, 200.0);
((GeneralPath)shape).lineTo(96.0, 207.0);
((GeneralPath)shape).lineTo(92.0, 211.0);
((GeneralPath)shape).lineTo(92.0, 214.0);
((GeneralPath)shape).lineTo(95.0, 215.0);
((GeneralPath)shape).lineTo(99.0, 222.0);
((GeneralPath)shape).lineTo(101.0, 223.0);
((GeneralPath)shape).lineTo(113.0, 221.0);
((GeneralPath)shape).lineTo(112.0, 215.0);
((GeneralPath)shape).lineTo(122.0, 206.0);
((GeneralPath)shape).lineTo(123.0, 200.0);
((GeneralPath)shape).lineTo(126.0, 201.0);
((GeneralPath)shape).lineTo(125.0, 203.0);
((GeneralPath)shape).lineTo(128.0, 203.0);
((GeneralPath)shape).lineTo(127.0, 204.0);
((GeneralPath)shape).lineTo(130.0, 207.0);
((GeneralPath)shape).lineTo(127.0, 213.0);
((GeneralPath)shape).lineTo(133.0, 216.0);
((GeneralPath)shape).lineTo(138.0, 214.0);
((GeneralPath)shape).lineTo(137.0, 212.0);
((GeneralPath)shape).lineTo(141.0, 214.0);
((GeneralPath)shape).lineTo(150.0, 214.0);
((GeneralPath)shape).lineTo(150.0, 208.0);
((GeneralPath)shape).lineTo(157.0, 209.0);
((GeneralPath)shape).lineTo(160.0, 213.0);
((GeneralPath)shape).lineTo(168.0, 215.0);
((GeneralPath)shape).lineTo(172.0, 218.0);
((GeneralPath)shape).lineTo(178.0, 213.0);
((GeneralPath)shape).lineTo(183.0, 218.0);
((GeneralPath)shape).lineTo(190.0, 206.0);
((GeneralPath)shape).lineTo(191.0, 208.0);
((GeneralPath)shape).lineTo(192.0, 207.0);
((GeneralPath)shape).lineTo(197.0, 209.0);
((GeneralPath)shape).lineTo(199.0, 207.0);
((GeneralPath)shape).lineTo(202.0, 210.0);
((GeneralPath)shape).lineTo(202.0, 212.0);
((GeneralPath)shape).lineTo(210.0, 215.0);
((GeneralPath)shape).lineTo(209.0, 222.0);
((GeneralPath)shape).lineTo(212.0, 225.0);
((GeneralPath)shape).lineTo(214.0, 223.0);
((GeneralPath)shape).lineTo(217.0, 225.0);
((GeneralPath)shape).lineTo(218.0, 232.0);
((GeneralPath)shape).lineTo(214.0, 236.0);
((GeneralPath)shape).lineTo(218.0, 239.0);
((GeneralPath)shape).lineTo(212.0, 242.0);
((GeneralPath)shape).lineTo(211.0, 246.0);
((GeneralPath)shape).lineTo(207.0, 247.0);
((GeneralPath)shape).lineTo(204.0, 250.0);
((GeneralPath)shape).lineTo(199.0, 249.0);
((GeneralPath)shape).lineTo(191.0, 253.0);
((GeneralPath)shape).lineTo(187.0, 251.0);
((GeneralPath)shape).lineTo(186.0, 248.0);
((GeneralPath)shape).lineTo(181.0, 250.0);
((GeneralPath)shape).lineTo(180.0, 252.0);
((GeneralPath)shape).lineTo(173.0, 252.0);
((GeneralPath)shape).lineTo(168.0, 256.0);
((GeneralPath)shape).lineTo(168.0, 253.0);
((GeneralPath)shape).lineTo(164.0, 247.0);
((GeneralPath)shape).lineTo(158.0, 251.0);
((GeneralPath)shape).lineTo(155.0, 248.0);
((GeneralPath)shape).lineTo(152.0, 240.0);
((GeneralPath)shape).lineTo(148.0, 243.0);
((GeneralPath)shape).lineTo(146.0, 240.0);
((GeneralPath)shape).lineTo(142.0, 244.0);
((GeneralPath)shape).lineTo(145.0, 246.0);
((GeneralPath)shape).lineTo(146.0, 249.0);
((GeneralPath)shape).lineTo(142.0, 253.0);
((GeneralPath)shape).lineTo(131.0, 259.0);
((GeneralPath)shape).lineTo(125.0, 254.0);
((GeneralPath)shape).lineTo(127.0, 252.0);
((GeneralPath)shape).lineTo(123.0, 250.0);
((GeneralPath)shape).lineTo(120.0, 250.0);
((GeneralPath)shape).lineTo(118.0, 254.0);
((GeneralPath)shape).lineTo(113.0, 255.0);
((GeneralPath)shape).lineTo(110.0, 251.0);
((GeneralPath)shape).lineTo(106.0, 255.0);
((GeneralPath)shape).lineTo(104.0, 252.0);
((GeneralPath)shape).lineTo(101.0, 253.0);
((GeneralPath)shape).lineTo(100.0, 247.0);
((GeneralPath)shape).lineTo(98.0, 245.0);
((GeneralPath)shape).lineTo(94.0, 245.0);
((GeneralPath)shape).lineTo(94.0, 238.0);
((GeneralPath)shape).lineTo(86.0, 241.0);
((GeneralPath)shape).lineTo(86.0, 246.0);
((GeneralPath)shape).lineTo(81.0, 249.0);
((GeneralPath)shape).lineTo(74.0, 244.0);
((GeneralPath)shape).lineTo(75.0, 240.0);
((GeneralPath)shape).lineTo(83.0, 234.0);
((GeneralPath)shape).lineTo(81.0, 229.0);
((GeneralPath)shape).lineTo(80.0, 231.0);
((GeneralPath)shape).lineTo(79.0, 229.0);
((GeneralPath)shape).lineTo(77.0, 217.0);
((GeneralPath)shape).lineTo(70.0, 217.0);
((GeneralPath)shape).lineTo(67.0, 218.0);
((GeneralPath)shape).lineTo(66.0, 221.0);
((GeneralPath)shape).lineTo(63.0, 221.0);
((GeneralPath)shape).lineTo(58.0, 212.0);
((GeneralPath)shape).lineTo(60.0, 209.0);
((GeneralPath)shape).lineTo(58.0, 208.0);
((GeneralPath)shape).lineTo(59.0, 204.0);
((GeneralPath)shape).lineTo(62.0, 205.0);
((GeneralPath)shape).lineTo(65.0, 203.0);
((GeneralPath)shape).lineTo(64.0, 192.0);
((GeneralPath)shape).lineTo(68.0, 192.0);
((GeneralPath)shape).lineTo(65.0, 184.0);
((GeneralPath)shape).lineTo(59.0, 185.0);
((GeneralPath)shape).lineTo(59.0, 188.0);
((GeneralPath)shape).lineTo(56.0, 188.0);
((GeneralPath)shape).lineTo(56.0, 190.0);
((GeneralPath)shape).lineTo(54.0, 187.0);
((GeneralPath)shape).lineTo(49.0, 191.0);
((GeneralPath)shape).lineTo(55.0, 196.0);
((GeneralPath)shape).lineTo(54.0, 198.0);
((GeneralPath)shape).lineTo(47.0, 199.0);
((GeneralPath)shape).lineTo(46.0, 207.0);
((GeneralPath)shape).lineTo(49.0, 208.0);
((GeneralPath)shape).lineTo(47.0, 209.0);
((GeneralPath)shape).lineTo(43.0, 206.0);
((GeneralPath)shape).lineTo(33.0, 206.0);
((GeneralPath)shape).lineTo(25.0, 199.0);
((GeneralPath)shape).lineTo(31.0, 194.0);
((GeneralPath)shape).lineTo(32.0, 190.0);
((GeneralPath)shape).lineTo(38.0, 187.0);
((GeneralPath)shape).lineTo(46.0, 178.0);
((GeneralPath)shape).lineTo(57.0, 175.0);
((GeneralPath)shape).lineTo(58.0, 170.0);
((GeneralPath)shape).lineTo(65.0, 167.0);
((GeneralPath)shape).lineTo(67.0, 169.0);
((GeneralPath)shape).lineTo(68.0, 165.0);
((GeneralPath)shape).lineTo(73.0, 161.0);
((GeneralPath)shape).lineTo(76.0, 161.0);
((GeneralPath)shape).lineTo(77.0, 159.0);
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
        return 204;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 311;
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

