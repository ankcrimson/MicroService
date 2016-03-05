package com.models;

import com.dto.TokenRequestDTO;

/**
 * Created by asriv5 on 3/3/16.
 */
public interface DataSource {
    public boolean createToken(TokenRequestDTO tokenRequestDTO);
    public void init();
}
