package org.pc.utility;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;

public class CaptchaUtil {
	
	public static Captcha createCaptcha(int width,int height) {
		Captcha.Builder captcha = new Captcha.Builder(width, height);
		captcha.addBackground(new GradiatedBackgroundProducer());
		captcha.addText(new DefaultTextProducer(),new DefaultWordRenderer());
		captcha.addNoise(new CurvedLineNoiseProducer());
		return captcha.build();
	}
	
	public static String convertImage(Captcha captcha) {
		String image = null;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), "png", os);
			byte[] arr = Base64.getEncoder().encode(os.toByteArray());
			image = new String(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	

}
