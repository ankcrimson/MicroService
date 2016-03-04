package com.commands;

import com.models.TokenRequestDTO;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by asriv5 on 3/3/16.
 */
public class CreateTokenCommand extends HystrixCommand<String> {

    private TokenRequestDTO tokenRequestDTO;

    public CreateTokenCommand(TokenRequestDTO tokenRequestDTO) {
        super(HystrixCommandGroupKey.Factory.asKey("microserviceCommands"));
        this.tokenRequestDTO = tokenRequestDTO;
    }

    @Override
    protected String run() throws Exception {
        return null;
    }
}
