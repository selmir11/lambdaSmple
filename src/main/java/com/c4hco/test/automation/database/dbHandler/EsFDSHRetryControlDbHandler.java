package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EsFDSHRetryControlEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class EsFDSHRetryControlDbHandler {

    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private final BasicActions basicActions = new BasicActions();

    public EsFDSHRetryControlEntity getDetailsFromFDSHRetry(String query)  {
        EsFDSHRetryControlEntity esFDSHEntity = new EsFDSHRetryControlEntity();
        ResultSet rs;
        basicActions.wait(5000);
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {

                /* ---- Set all the values from db ---- */
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = EsFDSHRetryControlEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esFDSHEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esFDSHEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esFDSHEntity, columnValue);
                            }
                        } else {
                        }
                    } catch (NoSuchFieldException e) {
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esFDSHEntity;
    }
}
