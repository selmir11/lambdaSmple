package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ob834DetailsDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private BasicActions basicActions;

    public List<Ob834DetailsEntity> getOb834DbDetails(String query) {
        List<Ob834DetailsEntity> dbDataList = new ArrayList<>();
        ResultSet rs;
            try {
                rs = executor.executeQuery(query);
                while (rs.next()) {
                    Ob834DetailsEntity ob834DetailsEntity = new Ob834DetailsEntity();

                    // ---- Set all the values from db ---- //
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        String columnName = rs.getMetaData().getColumnName(i);
                        Object columnValue = rs.getObject(i);

                        // Set the field value using reflection
                        try {
                            Field field = Ob834DetailsEntity.class.getDeclaredField(columnName);
                            field.setAccessible(true);
                            if (columnValue != null) {
                                // Perform type conversion based on field type
                                if (field.getType() == String.class) {
                                    field.set(ob834DetailsEntity, columnValue.toString());
                                } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                    field.set(ob834DetailsEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                                } else {
                                    // Handle other types as needed
                                    field.set(ob834DetailsEntity, columnValue);
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
                    dbDataList.add(ob834DetailsEntity);
                }

            } catch (Exception e) {
                e.printStackTrace();

            }


        return dbDataList;
        }


    public List<Ob834DetailsEntity> getOb834DetalsAfterCompleted(String query) {
        List<Ob834DetailsEntity> dbDataList = new ArrayList<>();

        try {
            while (true) {
                dbDataList = getOb834DbDetails(query);
                boolean allCompleted = dbDataList.stream().allMatch(entity -> "EDI_COMPLETE".equals(entity.getEdi_status()));
                if (allCompleted) {
                    break;
                }

                basicActions.wait(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbDataList;
    }
}
