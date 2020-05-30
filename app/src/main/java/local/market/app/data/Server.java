package local.market.app.data;

import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server extends AsyncTask<String, String, String> {
    private String server = "http://127.0.0.1:8081";
    public Response delegate = null;

    public Server() {}

    @Override
    protected String doInBackground(String... params) {
        String data = params[0];
        OutputStream outStream;
        String output = "";

        try {
            URL url = new URL(server);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();

            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            int inputStreamData = inputStreamReader.read();
            while (inputStreamData != -1) {
                char current = (char) inputStreamData;
                inputStreamData = inputStreamReader.read();
                output += current;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
}
