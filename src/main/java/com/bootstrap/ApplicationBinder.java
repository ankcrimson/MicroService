package com.bootstrap;

import com.google.inject.Singleton;
import com.models.CouchbaseDatasource;
import com.models.DataSource;
import com.services.DatabaseService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;


/**
 * Created by asriv5 on 3/3/16.
 */

@Singleton
public class ApplicationBinder extends AbstractBinder {


    @Override
    protected void configure() {
        bind(DatabaseService.class).to(DatabaseService.class);
        bind(CouchbaseDatasource.class).to(DataSource.class);
        System.out.println("HK2 Bindings Created!!");
    }

}
