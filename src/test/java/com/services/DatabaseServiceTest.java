package com.services;

import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.dto.TokenRequestDTO;
import com.dto.TokenResponseDTO;
import com.google.inject.Inject;
import com.modules.DatabaseModule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by asriv5 on 3/4/16.
 */
@RunWith(GuiceTestRunner.class)
@GuiceModules(DatabaseModule.class)
public class DatabaseServiceTest {

    @Inject
    private DatabaseService service;

    @Test
    public void test() {
        TokenRequestDTO tokenRequestDTO = new TokenRequestDTO();
        tokenRequestDTO.setUser("Ankur");
        tokenRequestDTO.setUuid("12345");
        TokenResponseDTO responseDTO = service.createToken(tokenRequestDTO);
        Assert.assertEquals(responseDTO.getMessage(),"Token Creation Success");
        Assert.assertEquals(responseDTO.getCreation(),"Success");
    }
}
