package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilesUtil {
	
	public static List<HashMap<String, String>> getJsonDataFromFile(String filePath) throws IOException {
		//read json to string
		String jsonString = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//convert Json String to Hash map
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonString, new TypeReference<List<HashMap<String, String>>>(){	
		});
		return data;
	}

}
