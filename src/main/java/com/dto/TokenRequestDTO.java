package com.dto;

/**
 * Created by asriv5 on 3/3/16.
 */
public class TokenRequestDTO {
    String user;
    String uuid;

    public String getUser() {
        return this.user;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
