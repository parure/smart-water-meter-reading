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
package org.recognizer;

import java.io.Serializable;

import org.encog.neural.som.SOM;

/**
 * This class contains specifications of a meter type. When the program addtype.java is launched, an instance of TypeSpec is created and stored in the folder res. When the program reader.type is launched, it gets the instance of TypeSpec corresponding to the type of the meter (for now, the type of the meter is necessarily "GWF_MTK") and uses the specifications to read the picture.
 * 
 * @author pauline ruegg-reymond
 *
 */
public class TypeSpec implements Serializable {
	
	private static final long serialVersionUID = -8839149622675225584L;
	
	private double dialWidth;
	private double dialHeight;
	private double dialX;
	private double dialY;
	private int charWidth;
	private int charHeight;
	
	private double middleX;
	private double middleY;
	private double tenthX;
	private double tenthY;
	private double hundredthX;
	private double hundredthY;
	private double thousandthX;
	private double thousandthY;
	private double tenthousandthX;
	private double tenthousandthY;
	
	private SOM net;
	
	public double getDialWidth() {
		return dialWidth;
	}
	public void setDialWidth(double dialWidth) {
		this.dialWidth = dialWidth;
	}
	public double getDialHeight() {
		return dialHeight;
	}
	public void setDialHeight(double dialHeight) {
		this.dialHeight = dialHeight;
	}
	public double getDialX() {
		return dialX;
	}
	public void setDialX(double dialX) {
		this.dialX = dialX;
	}
	public double getDialY() {
		return dialY;
	}
	public void setDialY(double dialY) {
		this.dialY = dialY;
	}
	public int getCharWidth() {
		return charWidth;
	}
	public void setCharWidth(int charWidth) {
		this.charWidth = charWidth;
	}
	public int getCharHeight() {
		return charHeight;
	}
	public void setCharHeight(int charHeight) {
		this.charHeight = charHeight;
	}
	public double getMiddleX() {
		return middleX;
	}
	public void setMiddleX(double middleX) {
		this.middleX = middleX;
	}
	public double getMiddleY() {
		return middleY;
	}
	public void setMiddleY(double middleY) {
		this.middleY = middleY;
	}
	public double getTenthX() {
		return tenthX;
	}
	public void setTenthX(double tenthX) {
		this.tenthX = tenthX;
	}
	public double getTenthY() {
		return tenthY;
	}
	public void setTenthY(double tenthY) {
		this.tenthY = tenthY;
	}
	public double getHundredthX() {
		return hundredthX;
	}
	public void setHundredthX(double hundredthX) {
		this.hundredthX = hundredthX;
	}
	public double getHundredthY() {
		return hundredthY;
	}
	public void setHundredthY(double hundredthY) {
		this.hundredthY = hundredthY;
	}
	public double getThousandthX() {
		return thousandthX;
	}
	public void setThousandthX(double thousandthX) {
		this.thousandthX = thousandthX;
	}
	public double getThousandthY() {
		return thousandthY;
	}
	public void setThousandthY(double thousandthY) {
		this.thousandthY = thousandthY;
	}
	public double getTenthousandthX() {
		return tenthousandthX;
	}
	public void setTenthousandthX(double tenthousandthX) {
		this.tenthousandthX = tenthousandthX;
	}
	public double getTenthousandthY() {
		return tenthousandthY;
	}
	public void setTenthousandthY(double tenthousandthY) {
		this.tenthousandthY = tenthousandthY;
	}
	public SOM getNet() {
		return net;
	}
	public void setNet(SOM net) {
		this.net = net;
	}
}
