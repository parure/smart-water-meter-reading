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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ij.ImagePlus;
import ij.gui.MessageDialog;


/**
 * This class contains the main function of the program reader.
 * It lists jpg files in the folder images/test/queue and launches a thread RunnableProcess for each image. Then it collects the index that was read on the picture, renames the file with this index and moves it to the folder images/test/res.
 *
 * The program reader performs index reading on pictures of meters of the type GWF MTK. Image files (jpg) have to be placed in the folder images/test/queue. The program reads the index, renames the file with this index and moves it to the folder images/test/res. If it is unable to read an image, the file remains in the folder images/test/queue and in case you ran the program in command line, an error message will be displayed.
 * 
 * @author pauline ruegg-reymond
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* TODO
		 * Le meterType devrait être inclus dans l'exif de l'image, donc ça devrait suffire d'avoir le chemin de l'image.
		 * On peut aussi imaginer de passer le chemin de la file à scruter en paramètre de l'application.
		 */
		new MessageDialog(null, "Information", "Le programme va lire les images que vous avez placées dans le dossier images/tes/queue, les renommer par l'index trouvé et les déplacer dans le dossier images/tes/res");
		
		String meterType = "GWF_MTK";
		String[] paths = (new File("images/test/queue")).list();
		List<RunnableProcess> rplist = new ArrayList<RunnableProcess>();
		
		int i=0;
		for (String path:paths) {
			if (!path.contains("jpg")) continue;
			ImagePlus im = new ImagePlus("images/test/queue/"+path);
			RunnableProcess rp = new RunnableProcess(im, meterType);
			rp.start();
			rplist.add(i, rp);
			i++;
		}
		
		ListIterator<RunnableProcess> li = rplist.listIterator();
		
		while (li.hasNext()) {
			int j = li.nextIndex();
			RunnableProcess rp = li.next();
			String path = paths[j];
			
			while (rp.getState() != Thread.State.TERMINATED){}
			
			String dstPath = Integer.toString(rp.getIndex());
			
			File src = new File("images/test/queue/"+path);
			File dst = new File("images/test/res/"+dstPath+".jpg");
			
			src.renameTo(dst);
		}
	}
}
