package com.toutjuste.kata4.service;

import com.toutjuste.kata4.model.Kata4Response;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Kata4ServiceImpl implements Kata4Service {

    private static final String pwcUrl = "https://api.run.pivotal.io/v2/info";
    private static final String bluUrl = "•https://api.ng.bluemix.net/v2/info";

    @Override
    public List<Kata4Response> getProviders() {
        RestTemplate restTemplate = new RestTemplate();
        Kata4Response response = restTemplate.getForObject(pwcUrl, Kata4Response.class);
        return null;
    }
}
