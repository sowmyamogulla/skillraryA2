package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains reusable methods to perform java related operations
 * @author HP
 */

public class JavaUtility {
/**
 * This method fetches current data and time in Specified format
 * @return
 */
	
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		return sdf.format(date);
	}
}
