SmartWaterMeterReading 0.8

SmartWaterMeterReading is a project started by eauservice, the water service of the City of Lausanne, Switzerland. The whole project is aimed at developing a smartphone app to read water meters from water meter pictures. The part provided here does not contain the code of a smartphone app for image acquisition. It contains a program that reads images of water meter (GWF MTK) and returns the index.

Contact:

Pauline Ruegg-Reymond
<pauline.ruegg.reymond@gmail.com>

Frédéric Benninger
<frederic.benninger@lausanne.ch>

eauservice
rue de Genève 36
case postale 7416
CH-1002 Lausanne

Contents of SmartWaterMeterReading folder:

 - addtype.jar
   This is an executable jar that you can launch either by double clicking on it or by the command line:
   java -jar addtype.jar
   This program allows you to create a new water meter type. It was created on the GWF MTK model and is mainly thought to add meter types of the type GWF MTK with different diameters. In particular, the meter type added needs to have red hands on the dial. The program finds the position of these red hands and asks the user to indicate the location of the roller counter of the meter. Then the user is asked to provide pictures of the meter of the same type. Localization of the digits is performed on them and pictures of isolated digits are shown to the user. The user has to chose a template picture for every digit between 0 and 9.
 
 
 - reader.jar
   This is an executable jar that you can launch either by double clicking on it or by the command line:
   java -jar reader.jar
   This program performs index reading on pictures of meters of the type GWF MTK. Image files (jpg) have to be placed in the folder images/test/queue. The program reads the index, renames the file with this index and moves it to the folder images/test/res. If it is unable to read an image, the file remains in the folder images/test/queue and in case you ran the program in command line, an error message will be displayed.
 
 
 - src
   This folder contains the java source files
   
   - org.addtype
     This folder contains the java source files that are used specifically by the program addtype.jar (see the description of file addtype.jar).
     
     - Main.java
       This class contains the main program. It creates a object of class GUI and calls methods on it.
       
     - GUI.java
       This class contains the methods to interact with the user while creating a new meter type.
     
     - GUI_centerChooser.java
       This class is a plug-in of ImageJ that allows the user to chose 5 points on the meter picture. It is not used in the current version of the program addtype.
       
     - GUI_dialChooser.java
       This class is a plug-in of ImageJ that allows the user to select a rectangle on the meter picture.
       
   - org.reader
     This folder contains the java source files that are used specifically by the program reader.jar (see the description of file reader.jar).
     
     - Main.java
       This class contains the main program. It lists jpg files in the folder images/test/queue and launches a thread RunnableProcess for each image. Then it collects the index that was read on the picture, renames the file with this index and moves it to the folder images/test/res.
       
     - RunnableProcess.java
       This class contains a thread that creates a Recognizer from a picture and a meter type and calls methods on the Recognizer that correspond to steps of image processing to get the index of the meter on the picture.
   
   - org.recognizer
     This folder contains the java source files that are used by both programs addtype.jat and reader.jar.
     
     - Recognizer.java
       This class contains methods corresponding to different steps of the image processing to get a meter index from a meter picture.
       
     - TypeSpec.java
       This class contains specifications of a meter type. When the program addtype.java is launched, an instance of TypeSpec is created and stored in the folder res. When the program reader.type is launched, it gets the instance of TypeSpec corresponding to the type of the meter (for now, the type of the meter is necessarily "GWF_MTK") and uses the specifications to read the picture.
     
     - Tools.java
       Abstract class that is needed by the class Recognizer to perform some operations on images.
       
     - LinAlg.java
       Abstract class that is needed by the class Recognizer to perform basic matrices and vectors operations.
       
     - Searcher.java
       Abstract class that is needed by the class Recognizer to perform search operations on arrays.
   
   
 - doc
   This folder contains the javadoc of the project.
     
 
 
 - images
   This folder contains image folders
   
   - chiffres
     This folder contains image files that were used to create the type "GWF_MTK" with the program addtype.jar. More specifically, digit templates were extracted from these images.
   
   - mesures
     This folder contains an image file that was used to create the type "GWF_MTK" with the program addtype.jar. More specifically, template measures of the meter were extracted from this image.
     
   - test
     This folder is used by the program reader.jar.
     
     - queue
       You should put water meter images you want to read in this folder.
       
     - res
       By running reader.jar, the images contained in "queue" are renamed with their index and moved to this folder.
 
 
 
 - lib
   This folder contains external libraries that are used in the project.
   
   
 - res
   This folder contains serialized instances of object "TypeSpec" that are created by the program addtype.jar and used by the program reader.jar.