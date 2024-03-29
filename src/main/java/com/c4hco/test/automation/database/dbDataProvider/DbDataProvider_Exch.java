package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.database.EntityObj.MultipleTablesEntity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.Ob834DetailsDbHandler;
import com.c4hco.test.automation.database.dbHandler.PolicyTableDbHandler;

import java.util.List;

public class DbDataProvider_Exch {
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();
    Ob834DetailsDbHandler ob834DetailsDbHandler = new Ob834DetailsDbHandler();

    public List<MultipleTablesEntity> getDataFromMultipleTables(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.combinedQuery());
    }

    public List<Ob834DetailsEntity> getOb83Db4Details(){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(exchDbQueries.ob834Details());
    }
}
