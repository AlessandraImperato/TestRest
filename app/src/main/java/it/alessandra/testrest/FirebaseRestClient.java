package it.alessandra.testrest;

import android.util.Log;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

/**
 * Created by utente7.academy on 28/11/2017.
 */

public class FirebaseRestClient {
    private static final String BASE_URL = "https://fir-test-26eb8.firebaseio.com/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }



}

