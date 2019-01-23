import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void httpConnection() throws IOException {
		URL url = new URL("http://example.com");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("param1", "val");
		
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

}
