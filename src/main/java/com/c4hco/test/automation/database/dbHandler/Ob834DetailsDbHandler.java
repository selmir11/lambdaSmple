package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ob834DetailsDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

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
                // Query the database to get the current status
                dbDataList = getOb834DbDetails(query);
                System.out.println("edi status ----"+dbDataList.get(0).getEdi_status());
                System.out.println("filen name from db ---"+dbDataList.get(0).getFilename());

                // Check if any of the entities have the status "completed"
                boolean allCompleted = dbDataList.stream().allMatch(entity -> "EDI_COMPLETE".equals(entity.getEdi_status()));

                if (allCompleted) {
                    // Exit the loop if all entities have the status "completed"
                    break;
                }

                // Sleep for a short interval before polling again
                Thread.sleep(15000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("filen name from db before returning data ---"+dbDataList.get(0).getFilename());
        System.out.println("dbdata list - ob entity from db--"+dbDataList);
        return dbDataList;
    }
}
