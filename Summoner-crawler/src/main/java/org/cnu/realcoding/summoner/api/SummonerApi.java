package org.cnu.realcoding.lol.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LOLInfoApi {
    @Autowired
    private RestTemplate restTemplate;

    private final String requestUrl = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apiKey}";
    private String apiKey;
    private final ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<List<String>>() {};
    public List<String> getLOLInfo(String abc) {
        List<String> responseBody = restTemplate.exchange(requestUrl, HttpMethod.GET, null, responseType,abc,apiKey).getBody();
        return responseBody;
    }
}
