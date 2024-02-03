package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods to initialize and read  data  from Properties file
 * @author HP
 */

public class propertiesUtility {
	private  Properties property;
	/**
	 * This method is used to initialize  Properties file
	 * @param filepath
	 */
	public void propertiesInit(String filepath)
	{
		FileInputStream fis= null;
		try
		{
			fis=new FileInputStream(filepath);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			}
		property =new Properties();
		try
		{
			property.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
/**
 * This method fetches data from properties file based on the key passed  as an argument
 * @param key
 * @return
 */

public String readFromProperties(String key)
{
	return property.getProperty(key);
}
}
