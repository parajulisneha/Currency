package util; /**
 * Created by sachin on 7/30/17.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequester {
    public static void main(String[] args) throws Exception {
        ApiRequester http = new ApiRequester();

        System.out.println("\nTesting 2 - Send Http PuT request");
        http.sendPut();

    }

    private void sendPut() throws Exception {

//        String url = "http://192.168.0.103:5000/";
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//        //add reuqest header
//        con.setRequestMethod("POST");
//        String urlParameters = "file_path=some_file_path";
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();

        //put request
        URL url = new URL("http://127.0.0.1:5000/");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

        //add reuqest header
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        String urlParameters = "file=/output_csv/pixels.csv";

        //// Send pUt request
        OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
        out.write(urlParameters);
        out.close();
        httpCon.getInputStream();


//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + urlParameters);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());

        int responseCode = httpCon.getResponseCode();
        System.out.println("\nSending 'PUT' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpCon.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}

