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
public class G {
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
((GeneralPath)shape).moveTo(79.0, 160.0);
((GeneralPath)shape).lineTo(81.0, 162.0);
((GeneralPath)shape).lineTo(78.0, 167.0);
((GeneralPath)shape).lineTo(74.0, 170.0);
((GeneralPath)shape).lineTo(78.0, 177.0);
((GeneralPath)shape).lineTo(76.0, 180.0);
((GeneralPath)shape).lineTo(81.0, 182.0);
((GeneralPath)shape).lineTo(84.0, 181.0);
((GeneralPath)shape).lineTo(87.0, 185.0);
((GeneralPath)shape).lineTo(93.0, 184.0);
((GeneralPath)shape).lineTo(94.0, 182.0);
((GeneralPath)shape).lineTo(97.0, 183.0);
((GeneralPath)shape).lineTo(96.0, 190.0);
((GeneralPath)shape).lineTo(91.0, 197.0);
((GeneralPath)shape).lineTo(91.0, 201.0);
((GeneralPath)shape).lineTo(95.0, 207.0);
((GeneralPath)shape).lineTo(91.0, 211.0);
((GeneralPath)shape).lineTo(100.0, 223.0);
((GeneralPath)shape).lineTo(112.0, 221.0);
((GeneralPath)shape).lineTo(111.0, 215.0);
((GeneralPath)shape).lineTo(121.0, 206.0);
((GeneralPath)shape).lineTo(122.0, 200.0);
((GeneralPath)shape).lineTo(125.0, 201.0);
((GeneralPath)shape).lineTo(124.0, 203.0);
((GeneralPath)shape).lineTo(127.0, 203.0);
((GeneralPath)shape).lineTo(126.0, 204.0);
((GeneralPath)shape).lineTo(129.0, 207.0);
((GeneralPath)shape).lineTo(126.0, 213.0);
((GeneralPath)shape).lineTo(132.0, 216.0);
((GeneralPath)shape).lineTo(137.0, 214.0);
((GeneralPath)shape).lineTo(136.0, 212.0);
((GeneralPath)shape).lineTo(140.0, 214.0);
((GeneralPath)shape).lineTo(149.0, 214.0);
((GeneralPath)shape).lineTo(149.0, 208.0);
((GeneralPath)shape).lineTo(156.0, 209.0);
((GeneralPath)shape).lineTo(159.0, 213.0);
((GeneralPath)shape).lineTo(167.0, 215.0);
((GeneralPath)shape).lineTo(171.0, 218.0);
((GeneralPath)shape).lineTo(177.0, 213.0);
((GeneralPath)shape).lineTo(182.0, 218.0);
((GeneralPath)shape).lineTo(189.0, 206.0);
((GeneralPath)shape).lineTo(190.0, 208.0);
((GeneralPath)shape).lineTo(191.0, 207.0);
((GeneralPath)shape).lineTo(196.0, 209.0);
((GeneralPath)shape).lineTo(198.0, 207.0);
((GeneralPath)shape).lineTo(201.0, 210.0);
((GeneralPath)shape).lineTo(201.0, 212.0);
((GeneralPath)shape).lineTo(209.0, 215.0);
((GeneralPath)shape).lineTo(208.0, 223.0);
((GeneralPath)shape).lineTo(211.0, 225.0);
((GeneralPath)shape).lineTo(213.0, 223.0);
((GeneralPath)shape).lineTo(217.0, 227.0);
((GeneralPath)shape).lineTo(217.0, 232.0);
((GeneralPath)shape).lineTo(213.0, 236.0);
((GeneralPath)shape).lineTo(217.0, 239.0);
((GeneralPath)shape).lineTo(211.0, 242.0);
((GeneralPath)shape).lineTo(210.0, 246.0);
((GeneralPath)shape).lineTo(206.0, 247.0);
((GeneralPath)shape).lineTo(203.0, 250.0);
((GeneralPath)shape).lineTo(198.0, 249.0);
((GeneralPath)shape).lineTo(196.0, 251.0);
((GeneralPath)shape).lineTo(201.0, 257.0);
((GeneralPath)shape).lineTo(200.0, 261.0);
((GeneralPath)shape).lineTo(198.0, 260.0);
((GeneralPath)shape).lineTo(197.0, 265.0);
((GeneralPath)shape).lineTo(204.0, 264.0);
((GeneralPath)shape).lineTo(204.0, 269.0);
((GeneralPath)shape).lineTo(199.0, 270.0);
((GeneralPath)shape).lineTo(196.0, 274.0);
((GeneralPath)shape).lineTo(187.0, 276.0);
((GeneralPath)shape).lineTo(182.0, 275.0);
((GeneralPath)shape).lineTo(176.0, 283.0);
((GeneralPath)shape).lineTo(173.0, 282.0);
((GeneralPath)shape).lineTo(171.0, 285.0);
((GeneralPath)shape).lineTo(168.0, 286.0);
((GeneralPath)shape).lineTo(164.0, 299.0);
((GeneralPath)shape).lineTo(159.0, 297.0);
((GeneralPath)shape).lineTo(153.0, 291.0);
((GeneralPath)shape).lineTo(156.0, 284.0);
((GeneralPath)shape).lineTo(154.0, 280.0);
((GeneralPath)shape).lineTo(150.0, 280.0);
((GeneralPath)shape).lineTo(149.0, 276.0);
((GeneralPath)shape).lineTo(141.0, 274.0);
((GeneralPath)shape).lineTo(122.0, 275.0);
((GeneralPath)shape).lineTo(121.0, 279.0);
((GeneralPath)shape).lineTo(110.0, 291.0);
((GeneralPath)shape).lineTo(111.0, 295.0);
((GeneralPath)shape).lineTo(108.0, 295.0);
((GeneralPath)shape).lineTo(108.0, 297.0);
((GeneralPath)shape).lineTo(103.0, 297.0);
((GeneralPath)shape).lineTo(97.0, 302.0);
((GeneralPath)shape).lineTo(95.0, 301.0);
((GeneralPath)shape).lineTo(92.0, 289.0);
((GeneralPath)shape).lineTo(88.0, 289.0);
((GeneralPath)shape).lineTo(82.0, 283.0);
((GeneralPath)shape).lineTo(79.0, 285.0);
((GeneralPath)shape).lineTo(74.0, 282.0);
((GeneralPath)shape).lineTo(73.0, 285.0);
((GeneralPath)shape).lineTo(63.0, 286.0);
((GeneralPath)shape).lineTo(60.0, 290.0);
((GeneralPath)shape).lineTo(58.0, 286.0);
((GeneralPath)shape).lineTo(53.0, 288.0);
((GeneralPath)shape).lineTo(53.0, 285.0);
((GeneralPath)shape).lineTo(56.0, 282.0);
((GeneralPath)shape).lineTo(58.0, 271.0);
((GeneralPath)shape).lineTo(63.0, 271.0);
((GeneralPath)shape).lineTo(64.0, 259.0);
((GeneralPath)shape).lineTo(61.0, 255.0);
((GeneralPath)shape).lineTo(62.0, 252.0);
((GeneralPath)shape).lineTo(58.0, 250.0);
((GeneralPath)shape).lineTo(55.0, 251.0);
((GeneralPath)shape).lineTo(55.0, 248.0);
((GeneralPath)shape).lineTo(53.0, 250.0);
((GeneralPath)shape).lineTo(50.0, 248.0);
((GeneralPath)shape).lineTo(49.0, 243.0);
((GeneralPath)shape).lineTo(46.0, 241.0);
((GeneralPath)shape).lineTo(42.0, 247.0);
((GeneralPath)shape).lineTo(38.0, 245.0);
((GeneralPath)shape).lineTo(35.0, 247.0);
((GeneralPath)shape).lineTo(27.0, 239.0);
((GeneralPath)shape).lineTo(22.0, 242.0);
((GeneralPath)shape).lineTo(17.0, 241.0);
((GeneralPath)shape).lineTo(19.0, 239.0);
((GeneralPath)shape).lineTo(17.0, 236.0);
((GeneralPath)shape).lineTo(10.0, 238.0);
((GeneralPath)shape).lineTo(9.0, 220.0);
((GeneralPath)shape).lineTo(17.0, 219.0);
((GeneralPath)shape).lineTo(15.0, 212.0);
((GeneralPath)shape).lineTo(20.0, 221.0);
((GeneralPath)shape).lineTo(21.0, 219.0);
((GeneralPath)shape).lineTo(27.0, 221.0);
((GeneralPath)shape).lineTo(28.0, 219.0);
((GeneralPath)shape).lineTo(32.0, 218.0);
((GeneralPath)shape).lineTo(29.0, 214.0);
((GeneralPath)shape).lineTo(33.0, 207.0);
((GeneralPath)shape).lineTo(25.0, 201.0);
((GeneralPath)shape).lineTo(25.0, 197.0);
((GeneralPath)shape).lineTo(30.0, 194.0);
((GeneralPath)shape).lineTo(31.0, 190.0);
((GeneralPath)shape).lineTo(37.0, 187.0);
((GeneralPath)shape).lineTo(45.0, 178.0);
((GeneralPath)shape).lineTo(56.0, 175.0);
((GeneralPath)shape).lineTo(57.0, 170.0);
((GeneralPath)shape).lineTo(64.0, 167.0);
((GeneralPath)shape).lineTo(66.0, 169.0);
((GeneralPath)shape).lineTo(67.0, 165.0);
((GeneralPath)shape).lineTo(72.0, 161.0);
((GeneralPath)shape).lineTo(75.0, 161.0);
((GeneralPath)shape).lineTo(76.0, 159.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(79.0, 160.0);
((GeneralPath)shape).lineTo(81.0, 162.0);
((GeneralPath)shape).lineTo(78.0, 167.0);
((GeneralPath)shape).lineTo(74.0, 170.0);
((GeneralPath)shape).lineTo(78.0, 177.0);
((GeneralPath)shape).lineTo(76.0, 180.0);
((GeneralPath)shape).lineTo(81.0, 182.0);
((GeneralPath)shape).lineTo(84.0, 181.0);
((GeneralPath)shape).lineTo(87.0, 185.0);
((GeneralPath)shape).lineTo(93.0, 184.0);
((GeneralPath)shape).lineTo(94.0, 182.0);
((GeneralPath)shape).lineTo(97.0, 183.0);
((GeneralPath)shape).lineTo(96.0, 190.0);
((GeneralPath)shape).lineTo(91.0, 197.0);
((GeneralPath)shape).lineTo(91.0, 201.0);
((GeneralPath)shape).lineTo(95.0, 207.0);
((GeneralPath)shape).lineTo(91.0, 211.0);
((GeneralPath)shape).lineTo(100.0, 223.0);
((GeneralPath)shape).lineTo(112.0, 221.0);
((GeneralPath)shape).lineTo(111.0, 215.0);
((GeneralPath)shape).lineTo(121.0, 206.0);
((GeneralPath)shape).lineTo(122.0, 200.0);
((GeneralPath)shape).lineTo(125.0, 201.0);
((GeneralPath)shape).lineTo(124.0, 203.0);
((GeneralPath)shape).lineTo(127.0, 203.0);
((GeneralPath)shape).lineTo(126.0, 204.0);
((GeneralPath)shape).lineTo(129.0, 207.0);
((GeneralPath)shape).lineTo(126.0, 213.0);
((GeneralPath)shape).lineTo(132.0, 216.0);
((GeneralPath)shape).lineTo(137.0, 214.0);
((GeneralPath)shape).lineTo(136.0, 212.0);
((GeneralPath)shape).lineTo(140.0, 214.0);
((GeneralPath)shape).lineTo(149.0, 214.0);
((GeneralPath)shape).lineTo(149.0, 208.0);
((GeneralPath)shape).lineTo(156.0, 209.0);
((GeneralPath)shape).lineTo(159.0, 213.0);
((GeneralPath)shape).lineTo(167.0, 215.0);
((GeneralPath)shape).lineTo(171.0, 218.0);
((GeneralPath)shape).lineTo(177.0, 213.0);
((GeneralPath)shape).lineTo(182.0, 218.0);
((GeneralPath)shape).lineTo(189.0, 206.0);
((GeneralPath)shape).lineTo(190.0, 208.0);
((GeneralPath)shape).lineTo(191.0, 207.0);
((GeneralPath)shape).lineTo(196.0, 209.0);
((GeneralPath)shape).lineTo(198.0, 207.0);
((GeneralPath)shape).lineTo(201.0, 210.0);
((GeneralPath)shape).lineTo(201.0, 212.0);
((GeneralPath)shape).lineTo(209.0, 215.0);
((GeneralPath)shape).lineTo(208.0, 223.0);
((GeneralPath)shape).lineTo(211.0, 225.0);
((GeneralPath)shape).lineTo(213.0, 223.0);
((GeneralPath)shape).lineTo(217.0, 227.0);
((GeneralPath)shape).lineTo(217.0, 232.0);
((GeneralPath)shape).lineTo(213.0, 236.0);
((GeneralPath)shape).lineTo(217.0, 239.0);
((GeneralPath)shape).lineTo(211.0, 242.0);
((GeneralPath)shape).lineTo(210.0, 246.0);
((GeneralPath)shape).lineTo(206.0, 247.0);
((GeneralPath)shape).lineTo(203.0, 250.0);
((GeneralPath)shape).lineTo(198.0, 249.0);
((GeneralPath)shape).lineTo(196.0, 251.0);
((GeneralPath)shape).lineTo(201.0, 257.0);
((GeneralPath)shape).lineTo(200.0, 261.0);
((GeneralPath)shape).lineTo(198.0, 260.0);
((GeneralPath)shape).lineTo(197.0, 265.0);
((GeneralPath)shape).lineTo(204.0, 264.0);
((GeneralPath)shape).lineTo(204.0, 269.0);
((GeneralPath)shape).lineTo(199.0, 270.0);
((GeneralPath)shape).lineTo(196.0, 274.0);
((GeneralPath)shape).lineTo(187.0, 276.0);
((GeneralPath)shape).lineTo(182.0, 275.0);
((GeneralPath)shape).lineTo(176.0, 283.0);
((GeneralPath)shape).lineTo(173.0, 282.0);
((GeneralPath)shape).lineTo(171.0, 285.0);
((GeneralPath)shape).lineTo(168.0, 286.0);
((GeneralPath)shape).lineTo(164.0, 299.0);
((GeneralPath)shape).lineTo(159.0, 297.0);
((GeneralPath)shape).lineTo(153.0, 291.0);
((GeneralPath)shape).lineTo(156.0, 284.0);
((GeneralPath)shape).lineTo(154.0, 280.0);
((GeneralPath)shape).lineTo(150.0, 280.0);
((GeneralPath)shape).lineTo(149.0, 276.0);
((GeneralPath)shape).lineTo(141.0, 274.0);
((GeneralPath)shape).lineTo(122.0, 275.0);
((GeneralPath)shape).lineTo(121.0, 279.0);
((GeneralPath)shape).lineTo(110.0, 291.0);
((GeneralPath)shape).lineTo(111.0, 295.0);
((GeneralPath)shape).lineTo(108.0, 295.0);
((GeneralPath)shape).lineTo(108.0, 297.0);
((GeneralPath)shape).lineTo(103.0, 297.0);
((GeneralPath)shape).lineTo(97.0, 302.0);
((GeneralPath)shape).lineTo(95.0, 301.0);
((GeneralPath)shape).lineTo(92.0, 289.0);
((GeneralPath)shape).lineTo(88.0, 289.0);
((GeneralPath)shape).lineTo(82.0, 283.0);
((GeneralPath)shape).lineTo(79.0, 285.0);
((GeneralPath)shape).lineTo(74.0, 282.0);
((GeneralPath)shape).lineTo(73.0, 285.0);
((GeneralPath)shape).lineTo(63.0, 286.0);
((GeneralPath)shape).lineTo(60.0, 290.0);
((GeneralPath)shape).lineTo(58.0, 286.0);
((GeneralPath)shape).lineTo(53.0, 288.0);
((GeneralPath)shape).lineTo(53.0, 285.0);
((GeneralPath)shape).lineTo(56.0, 282.0);
((GeneralPath)shape).lineTo(58.0, 271.0);
((GeneralPath)shape).lineTo(63.0, 271.0);
((GeneralPath)shape).lineTo(64.0, 259.0);
((GeneralPath)shape).lineTo(61.0, 255.0);
((GeneralPath)shape).lineTo(62.0, 252.0);
((GeneralPath)shape).lineTo(58.0, 250.0);
((GeneralPath)shape).lineTo(55.0, 251.0);
((GeneralPath)shape).lineTo(55.0, 248.0);
((GeneralPath)shape).lineTo(53.0, 250.0);
((GeneralPath)shape).lineTo(50.0, 248.0);
((GeneralPath)shape).lineTo(49.0, 243.0);
((GeneralPath)shape).lineTo(46.0, 241.0);
((GeneralPath)shape).lineTo(42.0, 247.0);
((GeneralPath)shape).lineTo(38.0, 245.0);
((GeneralPath)shape).lineTo(35.0, 247.0);
((GeneralPath)shape).lineTo(27.0, 239.0);
((GeneralPath)shape).lineTo(22.0, 242.0);
((GeneralPath)shape).lineTo(17.0, 241.0);
((GeneralPath)shape).lineTo(19.0, 239.0);
((GeneralPath)shape).lineTo(17.0, 236.0);
((GeneralPath)shape).lineTo(10.0, 238.0);
((GeneralPath)shape).lineTo(9.0, 220.0);
((GeneralPath)shape).lineTo(17.0, 219.0);
((GeneralPath)shape).lineTo(15.0, 212.0);
((GeneralPath)shape).lineTo(20.0, 221.0);
((GeneralPath)shape).lineTo(21.0, 219.0);
((GeneralPath)shape).lineTo(27.0, 221.0);
((GeneralPath)shape).lineTo(28.0, 219.0);
((GeneralPath)shape).lineTo(32.0, 218.0);
((GeneralPath)shape).lineTo(29.0, 214.0);
((GeneralPath)shape).lineTo(33.0, 207.0);
((GeneralPath)shape).lineTo(25.0, 201.0);
((GeneralPath)shape).lineTo(25.0, 197.0);
((GeneralPath)shape).lineTo(30.0, 194.0);
((GeneralPath)shape).lineTo(31.0, 190.0);
((GeneralPath)shape).lineTo(37.0, 187.0);
((GeneralPath)shape).lineTo(45.0, 178.0);
((GeneralPath)shape).lineTo(56.0, 175.0);
((GeneralPath)shape).lineTo(57.0, 170.0);
((GeneralPath)shape).lineTo(64.0, 167.0);
((GeneralPath)shape).lineTo(66.0, 169.0);
((GeneralPath)shape).lineTo(67.0, 165.0);
((GeneralPath)shape).lineTo(72.0, 161.0);
((GeneralPath)shape).lineTo(75.0, 161.0);
((GeneralPath)shape).lineTo(76.0, 159.0);
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
        return 288;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 128;
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

