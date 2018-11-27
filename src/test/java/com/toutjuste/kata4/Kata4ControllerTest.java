package com.toutjuste.kata4;

import com.toutjuste.kata4.service.Kata4ServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(Kata4Configuration.class)
public class Kata4ControllerTest {
    private static Validator validator;

    private static MockMvc mockMvc;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        mockMvc = MockMvcBuilders.standaloneSetup(new Kata4Controller(new Kata4ServiceImpl())).build();
    }

    //Happy Flows

    @Test
    public void whenRequestWithoutParams_ReturnsCorrectValues()  throws Exception  {
        mockMvc.perform(get("/cf"))
                .andExpect(status().isOk());


        //assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void whenRequestWithParamBLU_ReturnsCorrectValues()  throws Exception  {
        mockMvc.perform(get("/cf/BLU"))
                .andExpect(status().isOk());


        //assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void whenRequestWithParamPWC_ReturnsCorrectValues()  throws Exception  {
        mockMvc.perform(get("/cf/PWC"))
                .andExpect(status().isOk());
    }


    // Non-happy flows
    @Test
    public void whenRequestWithWrongParam_ReturnsErrorValues()  throws Exception  {
        mockMvc.perform(get("/cf/WRO"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenInternalError_ReturnsErrorValues()  throws Exception  {
        mockMvc.perform(get("/cf/IER"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void whenOneRequestFailing_ReturnsErrorValues()  throws Exception  {
        mockMvc.perform(get("/cf/FAIL"))
                .andExpect(status().isServiceUnavailable());
    }

    @Test
    public void whenTimeOut_ReturnsErrorValues()  throws Exception  {
        mockMvc.perform(get("/cf/TIME"))
                .andExpect(status().isGatewayTimeout());
    }


}