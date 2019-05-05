package com.wangcf.tess4J;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class test {
	public static void main(String[] args) throws IOException, TesseractException {
		testEn();
	}
	
	//使用英文库-识别图片
	public static void testEn() throws IOException, TesseractException{
		File imageFile=new File("/Users/wangyifan/Downloads/validate.png");
		BufferedImage bfimage=ImageIO.read(imageFile);
		bfimage=converImage(bfimage);
		ITesseract intance=new Tesseract();
		String result=intance.doOCR(bfimage);
		System.out.println(result);
	}
	
	//对图片进行处理 - 提高识别度
	public static BufferedImage converImage(BufferedImage image){
		//图像简单灰度处理 - 黑白处理
		image=ImageHelper.convertImageToGrayscale(image);
		//图像缩放 - 放大n倍图像
		image=ImageHelper.getScaledInstance(image, image.getWidth()*3, image.getHeight()*3);
		return image;
	}
}
