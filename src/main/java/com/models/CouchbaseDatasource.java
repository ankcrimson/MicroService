package com.models;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
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
        Bucket beerSampleBucket = cluster.openBucket("checkouts");

        // Disconnect and clear all allocated resources
        cluster.disconnect();

        return true;
    }

    @Override
    public void init() {

    }
}
