package org.cnu.realcoding.lol.api;

import org.cnu.realcoding.summoner.domain.CurrentSummoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class LOLNameApi {
    @Autowired
    private RestTemplate restTemplate;

    private String apiKey;
    private final String requestUrl = "https://kr.api.riotgames.com/lol/league/v4/summoners/by-name/{summonerName}?api_key={apiKey}";
    public CurrentSummoner getCurrentSummoner(String name){
        return restTemplate.exchange(requestUrl, HttpMethod.GET, null, CurrentSummoner.class, name, apiKey).getBody();
    }
}
