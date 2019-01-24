import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) throws IOException {
		//httpConnection();
		roomManager();
	}
	
	public static void httpConnection() throws IOException {
		System.out.println("Starting...");
		URL url = new URL("http://localhost:3000");
		System.out.println("Connected");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("param1", "val");
		
		con.setRequestProperty("Content-Type", "application/json");
		String contentType = con.getHeaderField("Content-Type");
		System.out.println(contentType);
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
	}
	
	public static class ParameterStringBuilder {
		public static String getParamsString(Map<String, String> params)
			throws UnsupportedEncodingException{
			StringBuilder result = new StringBuilder();
			
			for(Map.Entry<String, String> entry: params.entrySet()) {
				result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
		        result.append("=");
		        result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		        result.append("&");
			}
			
			String resultString = result.toString();
			return resultString.length() > 0
					? resultString.substring(0, resultString.length() - 1)
					: resultString;
		}
	}
	
	public static void roomManager() {
		int rooms = 20;
		int reserved = 0;
		int inUse = 0;
		int exit = 0;
		String s;
		Scanner sc = new Scanner(System.in);
		while(exit == 0) {
			System.out.printf("Available rooms: "+ rooms + "\n" + "Reserved rooms: " + reserved + "\nRooms in use: " + inUse + "\n");
			System.out.println("Would you like to add a reservation, add a room in use, or remove a room from reservation or use?");
			System.out.println("ADD RESERVE/ADD USE/REMOVE RESERVE/REMOVE USE/EXIT");
			s = sc.nextLine();
			switch(s.toUpperCase()) {
				case "ADD RESERVE":	
					if(rooms > 0) {
						reserved += 1;
						rooms -= 1;
					}
					else {
						System.out.println("There are no more available rooms!");
						sc.nextLine();
					}
					break;
				case "ADD USE":
					if(rooms > 0) {
						inUse += 1;
						rooms -= 1;
					}
					else {
						System.out.println("There are no more available rooms!");
						sc.nextLine();
					}
					break;
				case "REMOVE RESERVE":
					if(reserved > 0) {
						reserved -= 1;
						rooms += 1;
					}
					else {
						System.out.println("There are no rooms reserved!");
						sc.nextLine();
					}
					break;
				case "REMOVE USE":
					if(inUse > 0) {
						inUse -= 1;
						rooms += 1;
					}
					else {
						System.out.println("There are no rooms in use!");
						sc.nextLine();
					}
					break;
				case "EXIT":
					exit = 1;
					break;
				default: 
					System.out.println("Invalid answer");
					sc.nextLine();
					break;
			}
		}
		System.out.println("Tschuss!");

	}
}
