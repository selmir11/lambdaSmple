package com.c4hco.test.automation.database.EntityObj;
import lombok.Data;

@Data
public class EsFDSHRetryControlEntity {
    String fdsh_retry_control_id;
    String account_id;
    String service_type;
    String member_id;
    String status;
    String created_by;
    String updated_by;
}
