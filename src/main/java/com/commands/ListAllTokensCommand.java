package com.commands;

import com.dto.TokenRequestDTO;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.services.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by asriv5 on 3/5/16.
 */
public class ListAllTokensCommand extends HystrixCommand<List<TokenRequestDTO>> {

    private DatabaseService service;
    private static Logger LOGGER = LoggerFactory.getLogger(ListAllTokensCommand.class);

    public ListAllTokensCommand(DatabaseService service) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("microserviceCommands"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)));
        this.service=service;
    }

    @Override
    protected List<TokenRequestDTO> run() throws Exception {
        return service.listAllTokens();
    }

    @Override
    protected List<TokenRequestDTO> getFallback() {
        LOGGER.error("Error Retreving All Tokens ",getExecutionException());
        return super.getFallback();
    }
}
