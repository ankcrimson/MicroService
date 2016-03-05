package com.commands;

import com.dto.TokenRequestDTO;

import com.dto.TokenResponseDTO;
import com.models.CouchbaseDatasource;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.services.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by ankcrimson on 3/3/16.
 */
public class CreateTokenCommand extends HystrixCommand<String> {

    private DatabaseService service;
    private TokenRequestDTO tokenRequestDTO;

    private static Logger LOGGER = LoggerFactory.getLogger(CreateTokenCommand.class);

    public CreateTokenCommand(TokenRequestDTO tokenRequestDTO, DatabaseService service) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("microserviceCommands"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(3000)));
        this.tokenRequestDTO = tokenRequestDTO;
        this.service = service;
    }

    @Override
    protected String run() throws Exception {
        service.createToken(tokenRequestDTO);
        return "Token Command Completed";
    }

    @Override
    protected String getFallback() {
        System.out.println("Hystrix Command Fallback - "+getExecutionException().getMessage());
        getExecutionException().printStackTrace();
        LOGGER.error("Fallback - "+getExecutionException());
        return "Create Token Failed";
    }
}
