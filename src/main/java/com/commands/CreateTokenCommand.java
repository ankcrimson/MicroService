package com.commands;

import com.dto.TokenRequestDTO;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.services.DatabaseService;

import javax.inject.Inject;

/**
 * Created by ankcrimson on 3/3/16.
 */
public class CreateTokenCommand extends HystrixCommand<String> {

    private TokenRequestDTO tokenRequestDTO;

    @Inject
    private DatabaseService service;

    public CreateTokenCommand(TokenRequestDTO tokenRequestDTO) {
        super(HystrixCommandGroupKey.Factory.asKey("microserviceCommands"));
        this.tokenRequestDTO = tokenRequestDTO;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("Hystrix Command Run");
        service.createToken(tokenRequestDTO);
        return "Token Command Submitted";
    }

    @Override
    protected String getFallback() {
        System.out.println("Hystrix Command Fallback - "+getExecutionException().getMessage());
        getExecutionException().printStackTrace();
        return "Create Token Failed";
    }
}
