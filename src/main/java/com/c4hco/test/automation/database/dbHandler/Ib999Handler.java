package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ib999Handler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private final BasicActions basicActions = new BasicActions();

    public List<Ib999Entity> getIb999Details(String query) {
        List<Ib999Entity> dbDataList = new ArrayList<>();
        ResultSet rs;
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {
                Ib999Entity ib999DetailsEntity = new Ib999Entity();

                // ---- Set all the values from db ---- //
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = Ib999Entity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(ib999DetailsEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(ib999DetailsEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(ib999DetailsEntity, columnValue);
                            }
                        } else {
                            // Handle the case where columnValue is null
                            // For example, you could set a default value or leave the field uninitialized
                            // field.set(policyTableEntity, defaultValue);
                        }
                    } catch (NoSuchFieldException e) {
                        // Handle the case where the ResultSet column does not match a field in the object
                        // You can ignore it or handle it according to your requirements
                    }
                }
                dbDataList.add(ib999DetailsEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbDataList;
    }

    public List<Ib999Entity> getIbDetailsAfterCompleted(String query) {
        List<Ib999Entity> dbDataList = new ArrayList<>();
        int iterationCount = 0;
        try {
            do {
                basicActions.wait(10000);
                dbDataList = getIb999Details(query);
                iterationCount++;
                if(iterationCount>40){
                    System.out.println("Iteration count is greater than 35. ");
                    break;
                }
                System.out.println("---- Waiting for the ib999 file ---- ");
            } while (dbDataList.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbDataList;
    }
}
