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
    
    public static void createUserData(String username, int unpaid){
    try {
			Properties properties = new Properties();
			properties.setProperty("unpaid", Integer.toString(unpaid));
                        
			File file = new File("C:/customers/" + username + ".properties");
			     FileOutputStream fileOut = new FileOutputStream(file, false);
			properties.store(fileOut, username);
                      
			fileOut.close();
                        System.out.println("Creating > Successfully closed the file.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
     public static void createItemData(String item, int price){
    try {
			Properties properties = new Properties();
			properties.setProperty("price", Integer.toString(price));
                        
			File file = new File("C:/items/" + item + ".properties");
			     FileOutputStream fileOut = new FileOutputStream(file, false);
			properties.store(fileOut, item);
                      
			fileOut.close();
                        System.out.println("Creating > Successfully closed the file.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
     
     public static void addItemData(String item, int price){
    try {
			Properties properties = new Properties();
			properties.setProperty("price", Integer.toString(price));
                    

			File file = new File("C:/items/" + item + ".properties");
			     FileOutputStream fileOut = new FileOutputStream(file, true);
			properties.store(fileOut, item);
                      
			fileOut.close();
                        System.out.println("Creating > Successfully closed the file.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

public static void addUserData(String username, int newC){
    try {
			Properties properties = new Properties();
			properties.setProperty("unpaid", Integer.toString(getIntData(username, "unpaid") + newC));
                    

			File file = new File("C:/customers/" + username + ".properties");
			     FileOutputStream fileOut = new FileOutputStream(file, true);
			properties.store(fileOut, username);
                      
			fileOut.close();
                        System.out.println("Creating > Successfully closed the file.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


/**public static void editUserData(String username, String dataName, int dataValue){
    try {
			Properties properties = new Properties();
			properties.setProperty(dataName, Integer.toString(dataValue));

			File file = new File(username + ".properties");
			     FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, username);
			fileOut.close();
                        System.out.println("Modding > Successfully closed the file.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}**/


public static int getIntData(String username, String dataName){
  Properties prop = new Properties();
	   InputStream input = null;

	try {

		input = new FileInputStream(username + ".properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
                System.out.println("value1: " + Integer.parseInt(prop.getProperty(dataName)));
		return Integer.parseInt(prop.getProperty(dataName));

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
        return 0;

  }

public static String getStringData(String username, String dataName, String dataValue){
  Properties prop = new Properties();
	   InputStream input = null;

	try {

		input = new FileInputStream(username + ".properties");

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
