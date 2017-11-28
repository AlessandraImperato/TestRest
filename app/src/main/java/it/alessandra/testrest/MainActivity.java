package it.alessandra.testrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callRestUtente();
        callRest("utente.json");

       /* modo 1: direttamente nel main
       AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://fir-test-26eb8.firebaseio.com/utente.json", new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    String text = new String(responseBody);
                    Log.i("MAIN_ACTIVITY",text);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //if(statusCode == 404){
                  //  Log.i("MAIN_ACTIVITY", "ERRORE");
                //}
            }
            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }
        });
        fine modo 1*/
    }

    public void callRestUtente() {
        FirebaseRestClient.get("utente.json", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String text = new String(responseBody);
                    Log.i("MAIN_ACTIVITY", text);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public void callRest(String url) {
        FirebaseRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String text = new String(responseBody);
                    Log.i("MAIN_ACTIVITY", text);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}