package cn.edu.zucc.galiview.server.util;

import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class NoWaterRipple extends Configurable implements GimpyEngine {
    public NoWaterRipple(){}

    @Override
    public BufferedImage getDistortedImage(BufferedImage baseImage) {
        //NoiseProducer noiseProducer = this.getConfig().getNoiseImpl();
        BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(), baseImage.getHeight(), 2);
        Graphics2D graphics = (Graphics2D)distortedImage.getGraphics();
        //RippleFilter rippleFilter = new RippleFilter();
        //rippleFilter.setWaveType(0);
        //rippleFilter.setXAmplitude(2.6F);
        //rippleFilter.setYAmplitude(1.7F);
        //rippleFilter.setXWavelength(15.0F);
        //rippleFilter.setYWavelength(5.0F);
        //rippleFilter.setEdgeAction(0);
        //WaterFilter waterFilter = new WaterFilter();
        //waterFilter.setAmplitude(1.5F);
        //waterFilter.setPhase(10.0F);
        //waterFilter.setWavelength(2.0F);
        //BufferedImage effectImage = waterFilter.filter(baseImage, (BufferedImage)null);
        //effectImage = rippleFilter.filter(effectImage, (BufferedImage)null);
        graphics.drawImage(baseImage, 0, 0, (Color)null, (ImageObserver)null);
        graphics.dispose();
        //noiseProducer.makeNoise(distortedImage, 0.1F, 0.1F, 0.25F, 0.25F);
        //noiseProducer.makeNoise(distortedImage, 0.1F, 0.25F, 0.5F, 0.9F);
        return distortedImage;
    }
}
