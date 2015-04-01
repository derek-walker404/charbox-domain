package co.charbox.domain.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class SSTProperties {

	public static final String DATA_CHUNK_100 = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	public static final String DATA_CHUNK_1000 = DATA_CHUNK_100 + DATA_CHUNK_100 + DATA_CHUNK_100 + DATA_CHUNK_100 + DATA_CHUNK_100
			 + DATA_CHUNK_100 + DATA_CHUNK_100 + DATA_CHUNK_100 + DATA_CHUNK_100 + DATA_CHUNK_100;
	public static final String DATA_CHUNK_1024 = DATA_CHUNK_1000 + "000000000000000000000000";
	public static final String DATA_CHUNK_2000 = DATA_CHUNK_1000 + DATA_CHUNK_1000;
	public static final String DATA_CHUNK_10000 = DATA_CHUNK_1000 + DATA_CHUNK_1000 + DATA_CHUNK_1000 + DATA_CHUNK_1000 + DATA_CHUNK_1000
			 + DATA_CHUNK_1000 + DATA_CHUNK_1000 + DATA_CHUNK_1000 + DATA_CHUNK_1000 + DATA_CHUNK_1000;
	
	private static final Properties prop = new Properties();
	
	static {
		try {
			prop.load(new FileInputStream(new File("sst.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private SSTProperties() { }
	
	public static String getDefaultDataChunk() {
		return DATA_CHUNK_2000;
	}
	
	public static Properties getConfig() {
		return prop;
	}
	
	public static double calcSpeed(int size, int duration) {
		double speed = duration <= 0 
				? -1 
				: (size * 8.0 / 1048.576 / duration); // do I need to multiple by 8 here? math don't work now. comm bak laytur, da nomburs luk gud doh
		return speed;
	}
}
