package com.toutjuste.kata4.service;

import com.toutjuste.kata4.model.Kata4Response;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kata4ServiceImpl implements Kata4Service {

    private static final String pwcUrl = "https://api.run.pivotal.io/v2/info";
    private static final String bluUrl = "https://api.ng.bluemix.net/v2/info";

    private static final String PWC = "PWC";
    private static final String BLU = "BLU";

    @Override
    public List<Kata4Response> getProviders() {
        List<Kata4Response> responses = new ArrayList<>();
        responses.addAll(getProviders(PWC));
        responses.addAll(getProviders(BLU));
        return responses;
    }


    @Override
    public List<Kata4Response> getProviders(String provider) {
        RestTemplate restTemplate = new RestTemplate();
        Kata4Response response= null;
        if (PWC.equals(provider)) {
            response = restTemplate.getForObject(pwcUrl, Kata4Response.class);
        }
        else if (BLU.equals(provider)) {
            response = restTemplate.getForObject(bluUrl, Kata4Response.class);
        }
        if (response != null){
            return Collections.singletonList(response);
        }
        return Collections.EMPTY_LIST;
    }
}
