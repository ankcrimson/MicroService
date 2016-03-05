package com.models;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.util.JSONPObject;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.Document;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.dto.TokenRequestDTO;

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
    public void init() {

    }
}
