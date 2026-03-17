package se.sthlm.jfwsthlm.CernemosConsumer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import se.sthlm.jfwsthlm.CernemosConsumer.data.Rot13CipherRequest;
import se.sthlm.jfwsthlm.CernemosConsumer.data.Rot13CipherResponse;

@Service
public class ApiService
{
    private final RestTemplate restTemplate = new RestTemplate();

    public Rot13CipherResponse sendFormData(String message) {
        String url = "http://localhost:8080/rot13";
        Rot13CipherRequest rot13CipherRequest = new Rot13CipherRequest();
        rot13CipherRequest.setText(message);
        return restTemplate.postForObject(url, rot13CipherRequest, Rot13CipherResponse.class);
    }
}
