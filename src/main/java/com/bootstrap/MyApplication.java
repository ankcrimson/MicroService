package com.bootstrap;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by asriv5 on 3/3/16.
 */
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(new ApplicationBinder());
        packages(true, "com.resource");
        System.out.println("Registered Application Binder");
    }
}