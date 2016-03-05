package com.services;

import com.dto.TokenRequestDTO;
import com.dto.TokenResponseDTO;
import com.models.DataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by asriv5 on 3/3/16.
 */
@Singleton
public class DatabaseService {

    private final DataSource dataSource;

    @Inject
    public DatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TokenResponseDTO createToken(TokenRequestDTO tokenRequestDTO) {
        System.out.println("Database service called");
        TokenResponseDTO responseDTO = new TokenResponseDTO();
        if(dataSource.createToken(tokenRequestDTO)) {
            responseDTO.setMessage("Token Creation Success");
            responseDTO.setCreation("Success");
        }
        else
        {
            responseDTO.setCreation("Fail");
            responseDTO.setMessage("Failed due to some error");
        }

        return responseDTO;
    }
}
