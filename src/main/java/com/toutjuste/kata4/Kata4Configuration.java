package com.toutjuste.kata4;

import com.toutjuste.kata4.service.Kata4Service;
import com.toutjuste.kata4.service.Kata4ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Kata4Configuration {

    @Bean
    public Kata4Service kata4Service(){
        return new Kata4ServiceImpl();
    }

}
