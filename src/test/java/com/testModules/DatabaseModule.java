/*
 * Created by IntelliJ IDEA.
 * User: asriv5
 * Date: 3/3/16
 * Time: 7:50 PM
 */
package com.testModules;

import com.google.inject.AbstractModule;
import com.models.CouchbaseDatasource;
import com.models.DataSource;
import com.services.DatabaseService;

public class DatabaseModule extends AbstractModule {
    protected void configure() {
        //Bind DataSource to CouchBase Datasource
        bind(DataSource.class).to(CouchbaseDatasource.class);
        bind(DatabaseService.class);
    }
}
