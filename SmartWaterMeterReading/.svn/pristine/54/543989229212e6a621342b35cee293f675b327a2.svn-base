/**
 * Copyright (C) 2013 pauline ruegg-reymond
 * <pauline.ruegg.reymond@gmail.com>
 * eauservice
 * rue de Genève 36
 * case postale 7416
 * CH-1002 Lausanne
 * 
 * This file is part of SmartWaterMeterReading
 * 
 * SmartWaterMeterReading is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SmartWaterMeterReading is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import org.encog.ml.data.MLDataSet;
import org.recognizer.Recognizer;
import org.recognizer.TypeSpec;

import ij.ImagePlus;
import ij.ImageStack;
import ij.measure.ResultsTable;
import ij.process.ImageProcessor;

/**
 * This class contains a thread that creates a Recognizer from a picture and a meter type and calls methods on the Recognizer that correspond to steps of image processing to get the index of the meter on the picture.
 * 
 * @author pauline ruegg-reymond
 *
 */
public class RunnableProcess extends Thread {

	private ImagePlus im;
	private String meterType;
	private int index;
	


	public RunnableProcess(ImagePlus im, String meterType) {
		super();
		this.im = im;
		this.meterType = meterType;
	}
	
	
	
	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	@Override
	public void run() {
		try {
			Recognizer r = new Recognizer();
			FileInputStream fis = new FileInputStream("res/" + meterType);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			TypeSpec type = (TypeSpec) ois.readObject();
			ois.close();

			ImageProcessor ip = im.getProcessor();
			ImageProcessor ip_red = r.findRed(ip);
			ResultsTable blobs =  r.findBlob(ip_red, 60);
			blobs =  r.treatBlobs(ip_red,  blobs);
			ImageProcessor ip_dial =  r.getDial(ip, blobs, type);
			ip_dial =  r.binarize(ip_dial);
			blobs =  r.findBlob(ip_dial,  40);
			List<int[]> order = r.preferredOrder(blobs);
			ImageStack chars = r.getCharacters(ip_dial, blobs, type, order);
			
			MLDataSet charsDataSet =  r.imageStack2MLDataSet(chars);
			
			
			int[] numbers = r.getNumbers(charsDataSet, type, order);
			int index = r.digits2int(numbers, order, blobs);
			this.setIndex(index);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
