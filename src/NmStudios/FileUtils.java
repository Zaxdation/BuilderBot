/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NmStudios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author USER
 */
public class FileUtils {
    
    public static void createUserData(String prefix){
    try {
			Properties properties = new Properties();
			properties.setProperty("botprefix", prefix);
                        
			File file = new File("C:/builderbot/config.properties");
			     FileOutputStream fileOut = new FileOutputStream(file, false);
			properties.store(fileOut, "BuilderBot Config #1.1");
                      
			fileOut.close();
                        System.out.println("Creating > Successfully closed the file.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
  
     
public static String getStringData(String filename, String dataName){
  Properties prop = new Properties();
	   InputStream input = null;

	try {

		input = new FileInputStream("C:/builderbot/" + filename);

		// load a properties file
		prop.load(input);

		// get the property value and print it out
                System.out.println(prop.getProperty(dataName));
		return prop.getProperty(dataName);

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        return null;
       

  }
    
}
