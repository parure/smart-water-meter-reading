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
package org.addtype;

import java.awt.event.MouseEvent;

import ij.ImagePlus;
import ij.gui.MessageDialog;
import ij.gui.Overlay;
import ij.gui.Roi;
import ij.gui.YesNoCancelDialog;
import ij.plugin.tool.PlugInTool;

/**
 * This class is a plug-in of ImageJ that allows the user to select a rectangle on the meter picture.
 * 
 * @author pauline ruegg-reymond
 *
 */
public class GUI_dialChooser extends PlugInTool {
	private boolean next = false;
	private boolean canceled = false;
	private double sx, sy, ox, oy;
	private Roi roi;
	
	@Override
	public void mousePressed(ImagePlus imp, MouseEvent e) {
		Overlay overlay = imp.getOverlay();
		if (overlay == null) {
			overlay = new Overlay();
			imp.setOverlay(overlay);
		}
		overlay.clear();
		overlay.drawBackgrounds(true);
		
		sx = e.getX();
		sy = e.getY();
		roi = new Roi(sx, sy, 0, 0);
		overlay.add(roi);
		imp.updateAndDraw();
	}

	@Override
	public void mouseDragged(ImagePlus imp, MouseEvent e) {
		ox = e.getX();
		oy = e.getY();
		Overlay overlay = imp.getOverlay();
		overlay.clear();
		roi = new Roi(Math.min(sx, ox), Math.min(sy, oy), Math.abs(ox-sx), Math.abs(oy-sy));
		overlay.add(roi);
		imp.updateAndDraw();
	}

	@Override
	public void mouseReleased(ImagePlus imp, MouseEvent e) {
		ox = e.getX();
		oy = e.getY();
		Overlay overlay = imp.getOverlay();
		overlay.clear();
		roi = new Roi(Math.min(sx, ox), Math.min(sy, oy), Math.abs(ox-sx), Math.abs(oy-sy));
		overlay.add(roi);
		imp.updateAndDraw();
		
		if (ox < sx || oy < sy) {
			new MessageDialog(null, "Warning", "Veuillez commencer en haut à gauche.");
		} else {
			YesNoCancelDialog d = new YesNoCancelDialog(null, "", "Souhaitez-vous passer à l'étape suivante?");
			if (d.yesPressed()) next = true;
			if (d.cancelPressed()) canceled = true;
		}
	}

	public boolean next() {
		return next;
	}
	
	public boolean canceled() {
		return canceled;
	}
	
	public double[][] getCoordinates() {
		double[][] res = {{sx, sy}, {ox, oy}};
		return res;
	}
}
