package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertUtils {

	public static HashMap<String, Object> convertJsonToHashMap(String filePath) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			HashMap<String, Object> result = mapper.readValue(new File(filePath),
					new TypeReference<HashMap<String, Object>>() {
					});
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't read json file!");
			return null;
		}
	}

	public static String getDateTime(int plus) {
		Date dNow = new Date();
		long militime = dNow.toInstant().plus(plus, ChronoUnit.DAYS).toEpochMilli();
		SimpleDateFormat ft = new SimpleDateFormat("E, yyyy M dd hh:mm:ss zzz");
		System.out.println("Current Date: " + ft.format(militime));
		return ft.format(militime);
	}
	
	public static long getEpochMilisecond() {
		long ut1 = Instant.now().getEpochSecond();
		return ut1;
	}

//    public static void main(String args[]) {
//    	getDateTime(0);
//    	getEpochMilisecond();
//    }
}
