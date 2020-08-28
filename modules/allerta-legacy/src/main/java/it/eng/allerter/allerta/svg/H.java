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
public class H {
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
((GeneralPath)shape).moveTo(139.0, 113.0);
((GeneralPath)shape).lineTo(152.0, 104.0);
((GeneralPath)shape).lineTo(160.0, 114.0);
((GeneralPath)shape).lineTo(159.0, 120.0);
((GeneralPath)shape).lineTo(163.0, 123.0);
((GeneralPath)shape).lineTo(164.0, 128.0);
((GeneralPath)shape).lineTo(170.0, 126.0);
((GeneralPath)shape).lineTo(172.0, 133.0);
((GeneralPath)shape).lineTo(181.0, 130.0);
((GeneralPath)shape).lineTo(183.0, 127.0);
((GeneralPath)shape).lineTo(189.0, 131.0);
((GeneralPath)shape).lineTo(193.0, 130.0);
((GeneralPath)shape).lineTo(201.0, 134.0);
((GeneralPath)shape).lineTo(205.0, 139.0);
((GeneralPath)shape).lineTo(210.0, 139.0);
((GeneralPath)shape).lineTo(211.0, 142.0);
((GeneralPath)shape).lineTo(219.0, 147.0);
((GeneralPath)shape).lineTo(226.0, 143.0);
((GeneralPath)shape).lineTo(229.0, 143.0);
((GeneralPath)shape).lineTo(234.0, 153.0);
((GeneralPath)shape).lineTo(246.0, 159.0);
((GeneralPath)shape).lineTo(244.0, 163.0);
((GeneralPath)shape).lineTo(235.0, 162.0);
((GeneralPath)shape).lineTo(231.0, 166.0);
((GeneralPath)shape).lineTo(225.0, 184.0);
((GeneralPath)shape).lineTo(230.0, 182.0);
((GeneralPath)shape).lineTo(235.0, 185.0);
((GeneralPath)shape).lineTo(234.0, 190.0);
((GeneralPath)shape).lineTo(232.0, 191.0);
((GeneralPath)shape).lineTo(232.0, 204.0);
((GeneralPath)shape).lineTo(228.0, 203.0);
((GeneralPath)shape).lineTo(225.0, 205.0);
((GeneralPath)shape).lineTo(223.0, 215.0);
((GeneralPath)shape).lineTo(216.0, 211.0);
((GeneralPath)shape).lineTo(215.0, 221.0);
((GeneralPath)shape).lineTo(211.0, 225.0);
((GeneralPath)shape).lineTo(208.0, 222.0);
((GeneralPath)shape).lineTo(209.0, 215.0);
((GeneralPath)shape).lineTo(201.0, 212.0);
((GeneralPath)shape).lineTo(201.0, 210.0);
((GeneralPath)shape).lineTo(198.0, 207.0);
((GeneralPath)shape).lineTo(196.0, 209.0);
((GeneralPath)shape).lineTo(191.0, 207.0);
((GeneralPath)shape).lineTo(190.0, 208.0);
((GeneralPath)shape).lineTo(189.0, 206.0);
((GeneralPath)shape).lineTo(182.0, 218.0);
((GeneralPath)shape).lineTo(177.0, 213.0);
((GeneralPath)shape).lineTo(171.0, 218.0);
((GeneralPath)shape).lineTo(167.0, 215.0);
((GeneralPath)shape).lineTo(159.0, 213.0);
((GeneralPath)shape).lineTo(156.0, 209.0);
((GeneralPath)shape).lineTo(149.0, 208.0);
((GeneralPath)shape).lineTo(149.0, 214.0);
((GeneralPath)shape).lineTo(140.0, 214.0);
((GeneralPath)shape).lineTo(136.0, 212.0);
((GeneralPath)shape).lineTo(137.0, 214.0);
((GeneralPath)shape).lineTo(132.0, 216.0);
((GeneralPath)shape).lineTo(126.0, 213.0);
((GeneralPath)shape).lineTo(129.0, 207.0);
((GeneralPath)shape).lineTo(126.0, 204.0);
((GeneralPath)shape).lineTo(127.0, 203.0);
((GeneralPath)shape).lineTo(124.0, 203.0);
((GeneralPath)shape).lineTo(125.0, 201.0);
((GeneralPath)shape).lineTo(122.0, 200.0);
((GeneralPath)shape).lineTo(121.0, 206.0);
((GeneralPath)shape).lineTo(111.0, 215.0);
((GeneralPath)shape).lineTo(112.0, 221.0);
((GeneralPath)shape).lineTo(100.0, 223.0);
((GeneralPath)shape).lineTo(91.0, 211.0);
((GeneralPath)shape).lineTo(95.0, 207.0);
((GeneralPath)shape).lineTo(91.0, 201.0);
((GeneralPath)shape).lineTo(91.0, 197.0);
((GeneralPath)shape).lineTo(96.0, 190.0);
((GeneralPath)shape).lineTo(97.0, 183.0);
((GeneralPath)shape).lineTo(94.0, 182.0);
((GeneralPath)shape).lineTo(93.0, 184.0);
((GeneralPath)shape).lineTo(87.0, 185.0);
((GeneralPath)shape).lineTo(84.0, 181.0);
((GeneralPath)shape).lineTo(81.0, 182.0);
((GeneralPath)shape).lineTo(76.0, 180.0);
((GeneralPath)shape).lineTo(78.0, 177.0);
((GeneralPath)shape).lineTo(74.0, 170.0);
((GeneralPath)shape).lineTo(78.0, 167.0);
((GeneralPath)shape).lineTo(81.0, 162.0);
((GeneralPath)shape).lineTo(79.0, 159.0);
((GeneralPath)shape).lineTo(72.0, 161.0);
((GeneralPath)shape).lineTo(67.0, 165.0);
((GeneralPath)shape).lineTo(66.0, 169.0);
((GeneralPath)shape).lineTo(64.0, 167.0);
((GeneralPath)shape).lineTo(57.0, 170.0);
((GeneralPath)shape).lineTo(56.0, 175.0);
((GeneralPath)shape).lineTo(45.0, 178.0);
((GeneralPath)shape).lineTo(42.0, 183.0);
((GeneralPath)shape).lineTo(39.0, 184.0);
((GeneralPath)shape).lineTo(36.0, 180.0);
((GeneralPath)shape).lineTo(35.0, 172.0);
((GeneralPath)shape).lineTo(27.0, 170.0);
((GeneralPath)shape).lineTo(26.0, 167.0);
((GeneralPath)shape).lineTo(23.0, 166.0);
((GeneralPath)shape).lineTo(26.0, 159.0);
((GeneralPath)shape).lineTo(25.0, 156.0);
((GeneralPath)shape).lineTo(30.0, 155.0);
((GeneralPath)shape).lineTo(34.0, 148.0);
((GeneralPath)shape).lineTo(36.0, 139.0);
((GeneralPath)shape).lineTo(39.0, 138.0);
((GeneralPath)shape).lineTo(41.0, 124.0);
((GeneralPath)shape).lineTo(48.0, 120.0);
((GeneralPath)shape).lineTo(48.0, 117.0);
((GeneralPath)shape).lineTo(52.0, 118.0);
((GeneralPath)shape).lineTo(53.0, 115.0);
((GeneralPath)shape).lineTo(63.0, 112.0);
((GeneralPath)shape).lineTo(69.0, 118.0);
((GeneralPath)shape).lineTo(71.0, 118.0);
((GeneralPath)shape).lineTo(73.0, 115.0);
((GeneralPath)shape).lineTo(70.0, 107.0);
((GeneralPath)shape).lineTo(72.0, 105.0);
((GeneralPath)shape).lineTo(76.0, 112.0);
((GeneralPath)shape).lineTo(80.0, 113.0);
((GeneralPath)shape).lineTo(84.0, 110.0);
((GeneralPath)shape).lineTo(85.0, 104.0);
((GeneralPath)shape).lineTo(89.0, 109.0);
((GeneralPath)shape).lineTo(88.0, 117.0);
((GeneralPath)shape).lineTo(96.0, 119.0);
((GeneralPath)shape).lineTo(103.0, 124.0);
((GeneralPath)shape).lineTo(109.0, 118.0);
((GeneralPath)shape).lineTo(109.0, 110.0);
((GeneralPath)shape).lineTo(111.0, 110.0);
((GeneralPath)shape).lineTo(116.0, 117.0);
((GeneralPath)shape).lineTo(121.0, 118.0);
((GeneralPath)shape).lineTo(123.0, 125.0);
((GeneralPath)shape).lineTo(125.0, 114.0);
((GeneralPath)shape).lineTo(130.0, 115.0);
((GeneralPath)shape).lineTo(133.0, 119.0);
((GeneralPath)shape).lineTo(136.0, 118.0);
((GeneralPath)shape).lineTo(137.0, 114.0);
((GeneralPath)shape).lineTo(132.0, 107.0);
((GeneralPath)shape).lineTo(139.0, 103.0);
((GeneralPath)shape).lineTo(141.0, 106.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
paint = new Color(colori2[0], colori2[1], colori2[2], colori2[3]);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(139.0, 113.0);
((GeneralPath)shape).lineTo(152.0, 104.0);
((GeneralPath)shape).lineTo(160.0, 114.0);
((GeneralPath)shape).lineTo(159.0, 120.0);
((GeneralPath)shape).lineTo(163.0, 123.0);
((GeneralPath)shape).lineTo(164.0, 128.0);
((GeneralPath)shape).lineTo(170.0, 126.0);
((GeneralPath)shape).lineTo(172.0, 133.0);
((GeneralPath)shape).lineTo(181.0, 130.0);
((GeneralPath)shape).lineTo(183.0, 127.0);
((GeneralPath)shape).lineTo(189.0, 131.0);
((GeneralPath)shape).lineTo(193.0, 130.0);
((GeneralPath)shape).lineTo(201.0, 134.0);
((GeneralPath)shape).lineTo(205.0, 139.0);
((GeneralPath)shape).lineTo(210.0, 139.0);
((GeneralPath)shape).lineTo(211.0, 142.0);
((GeneralPath)shape).lineTo(219.0, 147.0);
((GeneralPath)shape).lineTo(226.0, 143.0);
((GeneralPath)shape).lineTo(229.0, 143.0);
((GeneralPath)shape).lineTo(234.0, 153.0);
((GeneralPath)shape).lineTo(246.0, 159.0);
((GeneralPath)shape).lineTo(244.0, 163.0);
((GeneralPath)shape).lineTo(235.0, 162.0);
((GeneralPath)shape).lineTo(231.0, 166.0);
((GeneralPath)shape).lineTo(225.0, 184.0);
((GeneralPath)shape).lineTo(230.0, 182.0);
((GeneralPath)shape).lineTo(235.0, 185.0);
((GeneralPath)shape).lineTo(234.0, 190.0);
((GeneralPath)shape).lineTo(232.0, 191.0);
((GeneralPath)shape).lineTo(232.0, 204.0);
((GeneralPath)shape).lineTo(228.0, 203.0);
((GeneralPath)shape).lineTo(225.0, 205.0);
((GeneralPath)shape).lineTo(223.0, 215.0);
((GeneralPath)shape).lineTo(216.0, 211.0);
((GeneralPath)shape).lineTo(215.0, 221.0);
((GeneralPath)shape).lineTo(211.0, 225.0);
((GeneralPath)shape).lineTo(208.0, 222.0);
((GeneralPath)shape).lineTo(209.0, 215.0);
((GeneralPath)shape).lineTo(201.0, 212.0);
((GeneralPath)shape).lineTo(201.0, 210.0);
((GeneralPath)shape).lineTo(198.0, 207.0);
((GeneralPath)shape).lineTo(196.0, 209.0);
((GeneralPath)shape).lineTo(191.0, 207.0);
((GeneralPath)shape).lineTo(190.0, 208.0);
((GeneralPath)shape).lineTo(189.0, 206.0);
((GeneralPath)shape).lineTo(182.0, 218.0);
((GeneralPath)shape).lineTo(177.0, 213.0);
((GeneralPath)shape).lineTo(171.0, 218.0);
((GeneralPath)shape).lineTo(167.0, 215.0);
((GeneralPath)shape).lineTo(159.0, 213.0);
((GeneralPath)shape).lineTo(156.0, 209.0);
((GeneralPath)shape).lineTo(149.0, 208.0);
((GeneralPath)shape).lineTo(149.0, 214.0);
((GeneralPath)shape).lineTo(140.0, 214.0);
((GeneralPath)shape).lineTo(136.0, 212.0);
((GeneralPath)shape).lineTo(137.0, 214.0);
((GeneralPath)shape).lineTo(132.0, 216.0);
((GeneralPath)shape).lineTo(126.0, 213.0);
((GeneralPath)shape).lineTo(129.0, 207.0);
((GeneralPath)shape).lineTo(126.0, 204.0);
((GeneralPath)shape).lineTo(127.0, 203.0);
((GeneralPath)shape).lineTo(124.0, 203.0);
((GeneralPath)shape).lineTo(125.0, 201.0);
((GeneralPath)shape).lineTo(122.0, 200.0);
((GeneralPath)shape).lineTo(121.0, 206.0);
((GeneralPath)shape).lineTo(111.0, 215.0);
((GeneralPath)shape).lineTo(112.0, 221.0);
((GeneralPath)shape).lineTo(100.0, 223.0);
((GeneralPath)shape).lineTo(91.0, 211.0);
((GeneralPath)shape).lineTo(95.0, 207.0);
((GeneralPath)shape).lineTo(91.0, 201.0);
((GeneralPath)shape).lineTo(91.0, 197.0);
((GeneralPath)shape).lineTo(96.0, 190.0);
((GeneralPath)shape).lineTo(97.0, 183.0);
((GeneralPath)shape).lineTo(94.0, 182.0);
((GeneralPath)shape).lineTo(93.0, 184.0);
((GeneralPath)shape).lineTo(87.0, 185.0);
((GeneralPath)shape).lineTo(84.0, 181.0);
((GeneralPath)shape).lineTo(81.0, 182.0);
((GeneralPath)shape).lineTo(76.0, 180.0);
((GeneralPath)shape).lineTo(78.0, 177.0);
((GeneralPath)shape).lineTo(74.0, 170.0);
((GeneralPath)shape).lineTo(78.0, 167.0);
((GeneralPath)shape).lineTo(81.0, 162.0);
((GeneralPath)shape).lineTo(79.0, 159.0);
((GeneralPath)shape).lineTo(72.0, 161.0);
((GeneralPath)shape).lineTo(67.0, 165.0);
((GeneralPath)shape).lineTo(66.0, 169.0);
((GeneralPath)shape).lineTo(64.0, 167.0);
((GeneralPath)shape).lineTo(57.0, 170.0);
((GeneralPath)shape).lineTo(56.0, 175.0);
((GeneralPath)shape).lineTo(45.0, 178.0);
((GeneralPath)shape).lineTo(42.0, 183.0);
((GeneralPath)shape).lineTo(39.0, 184.0);
((GeneralPath)shape).lineTo(36.0, 180.0);
((GeneralPath)shape).lineTo(35.0, 172.0);
((GeneralPath)shape).lineTo(27.0, 170.0);
((GeneralPath)shape).lineTo(26.0, 167.0);
((GeneralPath)shape).lineTo(23.0, 166.0);
((GeneralPath)shape).lineTo(26.0, 159.0);
((GeneralPath)shape).lineTo(25.0, 156.0);
((GeneralPath)shape).lineTo(30.0, 155.0);
((GeneralPath)shape).lineTo(34.0, 148.0);
((GeneralPath)shape).lineTo(36.0, 139.0);
((GeneralPath)shape).lineTo(39.0, 138.0);
((GeneralPath)shape).lineTo(41.0, 124.0);
((GeneralPath)shape).lineTo(48.0, 120.0);
((GeneralPath)shape).lineTo(48.0, 117.0);
((GeneralPath)shape).lineTo(52.0, 118.0);
((GeneralPath)shape).lineTo(53.0, 115.0);
((GeneralPath)shape).lineTo(63.0, 112.0);
((GeneralPath)shape).lineTo(69.0, 118.0);
((GeneralPath)shape).lineTo(71.0, 118.0);
((GeneralPath)shape).lineTo(73.0, 115.0);
((GeneralPath)shape).lineTo(70.0, 107.0);
((GeneralPath)shape).lineTo(72.0, 105.0);
((GeneralPath)shape).lineTo(76.0, 112.0);
((GeneralPath)shape).lineTo(80.0, 113.0);
((GeneralPath)shape).lineTo(84.0, 110.0);
((GeneralPath)shape).lineTo(85.0, 104.0);
((GeneralPath)shape).lineTo(89.0, 109.0);
((GeneralPath)shape).lineTo(88.0, 117.0);
((GeneralPath)shape).lineTo(96.0, 119.0);
((GeneralPath)shape).lineTo(103.0, 124.0);
((GeneralPath)shape).lineTo(109.0, 118.0);
((GeneralPath)shape).lineTo(109.0, 110.0);
((GeneralPath)shape).lineTo(111.0, 110.0);
((GeneralPath)shape).lineTo(116.0, 117.0);
((GeneralPath)shape).lineTo(121.0, 118.0);
((GeneralPath)shape).lineTo(123.0, 125.0);
((GeneralPath)shape).lineTo(125.0, 114.0);
((GeneralPath)shape).lineTo(130.0, 115.0);
((GeneralPath)shape).lineTo(133.0, 119.0);
((GeneralPath)shape).lineTo(136.0, 118.0);
((GeneralPath)shape).lineTo(137.0, 114.0);
((GeneralPath)shape).lineTo(132.0, 107.0);
((GeneralPath)shape).lineTo(139.0, 103.0);
((GeneralPath)shape).lineTo(141.0, 106.0);
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
        return 302;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 72;
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

