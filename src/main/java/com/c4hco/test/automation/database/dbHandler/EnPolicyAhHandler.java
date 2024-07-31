package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EnPolicyAhEntity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnPolicyAhHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public List<EnPolicyAhEntity> getEnPolicyTableDetails(String query) {
        List<EnPolicyAhEntity> enPolicyResult = new ArrayList<>();
        ResultSet rs;
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {
                EnPolicyAhEntity enPolicyAhEntity = new EnPolicyAhEntity();
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            String columnName = rs.getMetaData().getColumnName(i);
            Object columnValue = rs.getObject(i);

            // Set the field value using reflection
            try {
                Field field = EnPolicyAhEntity.class.getDeclaredField(columnName);
                field.setAccessible(true);
                if (columnValue != null) {
                    // Perform type conversion based on field type
                    if (field.getType() == String.class) {
                        field.set(enPolicyAhEntity, columnValue.toString());
                    } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                        field.set(enPolicyAhEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                    } else {
                        // Handle other types as needed
                        field.set(enPolicyAhEntity, columnValue);
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
                enPolicyResult.add(enPolicyAhEntity);
        }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return enPolicyResult;
    }
}
