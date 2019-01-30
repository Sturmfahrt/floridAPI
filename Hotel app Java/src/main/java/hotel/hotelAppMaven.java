package hotel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class hotelAppMaven {

	public static void main(String[] args) throws IOException {
		//getRequest();
		//postRequest();
		postJsonBody();
		//roomManager();
	}
	@SuppressWarnings("deprecation")
	public static void postJsonBody() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			//String payload = "";
			
			//StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_FORM_URLENCODED);
			
			HttpPost post = new HttpPost("http:/localhost:3000/hotels/addhotel");
			
			System.out.println("Connected");
			
			String hotelName = "cykas";
			String roomNumber = "20";
			String roomType = "";
			String floorNumber = "";
			String description = "";
			int price = 1;
			String address = "";
			String images = "";
			int nightsUnavailable = 1;
			
			post.setHeader("Content-type", "application/json");	
			
			JSONObject json = new JSONObject();
			System.out.println("Set");
			
			json.put("hotelName", hotelName);
			json.put("roomNumber", roomNumber);
			json.put("roomType", roomType);
			json.put("floorNumber", floorNumber);
			json.put("description", description);
			json.put("price", price);
			json.put("address", address);
			json.put("images", images);
			json.put("nightsUnavailable", nightsUnavailable);
			
			System.out.println("Put");
			
			post.setEntity((HttpEntity) json);	
			
			HttpResponse response = httpClient.execute(post);
			System.out.println("Posted!");
			System.out.println(response.toString());
		} catch(Exception ex) {
			
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

	}
	
	private static HttpURLConnection con;
	
	public static void getRequest() throws IOException {
		String url = "http://localhost:3000/listhotelroom";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println(content.toString());

        } finally {
            
            con.disconnect();
        }
	}

	public static void postRequest() throws IOException, MalformedURLException, ProtocolException {
        String url = "http://localhost:3000/hotels/addhotel";
        String urlParameters = "hotelName=polska";
        urlParameters += "&roomNumber=10"; //Type room number here
        urlParameters += "&roomType=suite"; //Type room type here
        urlParameters += "&floorNumber=2"; //Type floor number here
        urlParameters += "&description=bad"; //Type the description here
        urlParameters += "&price="+100; //Type the price here
        urlParameters += "&address=123coolstreet"; //Type the address here
        urlParameters += "&images=stupid"; //Type the image URL here
        urlParameters += "&nightsUnavailable="+10; //Type the number of nights unavailable
        urlParameters += "&booker=name=Max";
        urlParameters += "&booker=notes=Likes poland";
        urlParameters += "&booker=nightsBooked="+10;
        urlParameters += "&booker=checkedIn="+true;
        
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println(content.toString());

        } finally {
            
            con.disconnect();
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
