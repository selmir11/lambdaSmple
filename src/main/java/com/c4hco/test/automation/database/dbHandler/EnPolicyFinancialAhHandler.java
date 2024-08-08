package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EnPolicyFinancialAhEntity;
import com.c4hco.test.automation.database.EntityObj.EnPolicyMemberCoverageAhEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnPolicyFinancialAhHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public List<EnPolicyFinancialAhEntity> getEnPolicyFinancialAhTableDetails(String query) {
        List<EnPolicyFinancialAhEntity> enPolFinAhResult = new ArrayList<>();
        ResultSet rs;
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {
                EnPolicyFinancialAhEntity enPolicyFinancialAhEntity = new EnPolicyFinancialAhEntity();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = EnPolicyFinancialAhEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(enPolicyFinancialAhEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(enPolicyFinancialAhEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(enPolicyFinancialAhEntity, columnValue);
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
                enPolFinAhResult.add(enPolicyFinancialAhEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enPolFinAhResult;
    }
}
