package com.models;

import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.dto.TokenRequestDTO;
import com.google.inject.Inject;
import com.testModules.DatabaseModule;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by asriv5 on 3/3/16.
 */

@RunWith(GuiceTestRunner.class)
@GuiceModules(DatabaseModule.class)
public class CouchBaseDatasourceTest {

    @Inject
    private DataSource dataSource;

    @Test
    public void test() {
        TokenRequestDTO tokenRequestDTO = new TokenRequestDTO();
        Assert.assertTrue(dataSource.createToken(tokenRequestDTO));
    }
}
