package com.example.MicroService.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class InformationProductClientImpl implements InformationProductClient{

    /**
     * @return
     */
    @Override
    public String getProductName() {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:51515/information"))
                .build();
        var client = HttpClient.newHttpClient();
        try {
            var httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException ioe) {
            log.error("IOException Occurred", ioe);
        } catch (InterruptedException ie) {
            log.error("InterruptedException Occurred", ie);
            Thread.currentThread().interrupt();
        }
        return null;
    }

}
