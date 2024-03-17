package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.sql.ResultSet;


public class DataProviderDb_qa_coco {

    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public void getDataFromob834_detail(){
        try {
            String sqlQuery = "select EDI_STATUS from qa_coco.ob834_detail";
            ResultSet rs = executor.executeQuery(sqlQuery);
            while(rs.next()) {
                System.out.println("Record for the column EDI Status:" + rs.getString("account_id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
