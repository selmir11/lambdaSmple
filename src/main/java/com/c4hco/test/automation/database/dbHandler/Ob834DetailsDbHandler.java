package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ob834DetailsDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public List<Ob834DetailsEntity> getOb834DbDetails(String query, String appType)  {
        List<Ob834DetailsEntity> dbDataList = new ArrayList<>();
        ResultSet rs;
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {
                Ob834DetailsEntity ob834DetailsEntity = new Ob834DetailsEntity();
                System.out.println("--db entries--"+rs.getString("first_name"));
                System.out.println("ob834 table entries---"+ob834DetailsEntity);
                // ---- Set all the values from db ---- //
                dbDataList.add(ob834DetailsEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dbDataList;
    }


}
