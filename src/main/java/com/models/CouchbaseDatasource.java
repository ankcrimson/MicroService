package com.models;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.dto.TokenRequestDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankcrimson on 3/3/16.
 */
public class CouchbaseDatasource implements DataSource {



    @Override
    public boolean createToken(TokenRequestDTO tokenRequestDTO) {
        // Connect to localhost
        Cluster cluster = CouchbaseCluster.create("localhost");

        // Open the default bucket and the "beer-sample" one
        //Bucket defaultBucket = cluster.openBucket("couchbase");
        Bucket myBucket = cluster.openBucket("tokens");

        JsonObject user = JsonObject.create();
        user.put("User",tokenRequestDTO.getUser());
        user.put("UUID",tokenRequestDTO.getUuid());

        JsonDocument jsonDocument = JsonDocument.create(tokenRequestDTO.getUuid(),user);

        myBucket.upsert(jsonDocument);

        // Disconnect and clear all allocated resources
        cluster.disconnect();

        return true;
    }


    @Override
    public List<TokenRequestDTO> listAllTokens() {
        //TODO: to implement this function
        TokenRequestDTO t1 = new TokenRequestDTO();
        TokenRequestDTO t2 = new TokenRequestDTO();
        t1.setUser("User 1");
        t1.setUuid("id1");
        t2.setUser("User 2");
        t2.setUuid("id2");
        List<TokenRequestDTO> result = new ArrayList<>();
        result.add(t1);
        result.add(t2);
        return result;
    }

    @Override
    public void init() {

    }
}
