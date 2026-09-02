package se.sthlm.jfwsthlm.CernemosConsumer.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import se.sthlm.jfwsthlm.CernemosConsumer.data.Rot13CipherRequest;
import se.sthlm.jfwsthlm.CernemosConsumer.data.Rot13CipherResponse;
import se.sthlm.jfwsthlm.CernemosConsumer.data.SubstitutionCipherRequest;
import se.sthlm.jfwsthlm.CernemosConsumer.data.SubstitutionCipherResponse;

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

    public SubstitutionCipherResponse sendSubstitutionFormData(String originalText, Map<Character, Character> substitutionMap) {
        String url = "http://localhost:8080/substitution";
        SubstitutionCipherRequest substitutionCipherRequest = new SubstitutionCipherRequest();
        substitutionCipherRequest.setOriginalText(originalText);
        substitutionCipherRequest.setSubstitutionMap(substitutionMap);
        return restTemplate.postForObject(url, substitutionCipherRequest, SubstitutionCipherResponse.class);
    }
}
