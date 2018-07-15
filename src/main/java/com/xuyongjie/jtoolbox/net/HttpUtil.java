/**
 * created by xuyongjie
 **/
package com.xuyongjie.jtoolbox.net;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static <T> T get(String requestUrl, Class<? extends T> responseType) throws IOException, StatusCodeNotOKException {
        T response;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(requestUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String temp;
                while ((temp = reader.readLine()) != null) {
                    builder.append(temp);
                    builder.append("\r\n");
                }
                String raw = builder.toString();
                ObjectMapper mapper = new ObjectMapper();
                response = mapper.readValue(raw, responseType);
            } else {
                throw new StatusCodeNotOKException(String.format("status code[%d] not equals 200", connection.getResponseCode()));
            }
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
        return response;
    }

    public static class StatusCodeNotOKException extends Exception {

        StatusCodeNotOKException(String message) {
            super(message);
        }
    }
}
