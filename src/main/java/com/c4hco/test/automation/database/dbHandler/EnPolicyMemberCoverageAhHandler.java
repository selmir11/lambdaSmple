package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EnPolicyMemberCoverageAhEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnPolicyMemberCoverageAhHandler {

    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public List<EnPolicyMemberCoverageAhEntity> getEnMemberCoverageAhTableDetails(String query) {
        List<EnPolicyMemberCoverageAhEntity> enPolMemberCoverageResult = new ArrayList<>();
        ResultSet rs;
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {
                EnPolicyMemberCoverageAhEntity enPolicyMemberCoverageAhEntity = new EnPolicyMemberCoverageAhEntity();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = EnPolicyMemberCoverageAhEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(enPolicyMemberCoverageAhEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(enPolicyMemberCoverageAhEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(enPolicyMemberCoverageAhEntity, columnValue);
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
                enPolMemberCoverageResult.add(enPolicyMemberCoverageAhEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enPolMemberCoverageResult;
    }
}
