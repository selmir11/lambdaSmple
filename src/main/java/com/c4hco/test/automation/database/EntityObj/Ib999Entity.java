package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class Ib999Entity {
    String interchange_sender_id;
    String interchange_receiver_id;
    String ak1_group_ctrl_number;
    String ak9_funct_group_ack_code;
    String ak9_number_of_ts_included;
    String ak9_number_of_received_ts;
    String ak9_number_of_accepted_ts;
    String filename;
}
