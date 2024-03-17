package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.database.EntityObj.PolicyTableEntity;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.Dto.SharedData;

import java.util.List;

public class DbDataProvider_Exch {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();

    public List<PolicyTableEntity> getDataFromPolicyTable(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTableMixedQuery(), SharedData.getAppType());
    }
}
