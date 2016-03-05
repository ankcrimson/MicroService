package com.commands;

import com.dto.TokenRequestDTO;

import com.dto.TokenResponseDTO;
import com.models.CouchbaseDatasource;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.services.DatabaseService;

import javax.inject.Inject;

/**
 * Created by ankcrimson on 3/3/16.
 */
public class CreateTokenCommand extends HystrixCommand<String> {

    private DatabaseService service;

    private TokenRequestDTO tokenRequestDTO;

    public CreateTokenCommand(TokenRequestDTO tokenRequestDTO, DatabaseService service) {
        super(HystrixCommandGroupKey.Factory.asKey("microserviceCommands"));
        this.tokenRequestDTO = tokenRequestDTO;
        this.service = service;
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
        //getExecutionException().printStackTrace();
        return "Create Token Failed";
    }
}
