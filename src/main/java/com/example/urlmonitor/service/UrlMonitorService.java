package com.example.urlmonitor.service;


import com.example.urlmonitor.exception.UrlMonitorNotSendConectionException;
import com.example.urlmonitor.record.UrlMonitorRequest;
import com.example.urlmonitor.record.UrlMonitorResponse;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UrlMonitorService {

    public UrlMonitorResponse send(UrlMonitorRequest request) {
        //Passos: instanciar HttpClient e HttpRequest
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requestHttp = HttpRequest.newBuilder()
                    .uri(URI.create(request.url()))
                    .GET()
                    .build();

            long start = System.currentTimeMillis();

            HttpResponse<String> response = client.send(requestHttp, HttpResponse.BodyHandlers.ofString());

            long end = System.currentTimeMillis();
            long resultResponseTime = end - start;

            int status = response.statusCode();

            boolean apiOnline = status >= 200 && status < 500;

            String message = (status >= 200 && status < 300)? "API funcionando corretamente."
                    : (status >= 400 && status < 500)? "API online, mas com possíveis falhas do lado do cliente."
                    : "API com falhas ou indisponível";

            return new UrlMonitorResponse(status, resultResponseTime, apiOnline, message);


        } catch (UrlMonitorNotSendConectionException e) {
            throw e;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
