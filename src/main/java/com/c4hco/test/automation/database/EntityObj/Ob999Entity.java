package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class Ob999Entity {
    String id;
    String created_ts;
    String updated_ts;
    String created_by;
    String updated_by;
    String filename;
    String ob999_status_id;
    String edi_status;
    String interchange_sender_id;
    String interchange_receiver_id;
    String interchange_ctrl_number;
    String interchange_date;
    String interchange_time;
    String ack_requested;
    String usage_indicator;
    String group_ctrl_number;
    String ts_id_code;
    String ts_control_number;
    String imple_conv_reference;
    String ak1_functional_id_code;
    String ak1_group_ctrl_number;
    String ak1_ver_id_code;
    String ak2_ts_id_code;
    String ak2_ts_control_number;
    String ak2_imple_conv_reference;
    String ik3_segment_id_code;
    String ik3_segment_pos_in_ts;
    String ik3_loop_id_code;
    String ik3_imple_seg_syn_er_code;
    String ik4_elemnt_position_in_segment;
    String ik4_compont_position_in_composite;
    String ik4_data_elemnt_ref_number;
    String ik4_imple_data_syn_er_code;
    String ik4_copy_of_bad_data_elemnt;
    String ik5_ts_ack_code;
    String ik5_imple_ts_syn_er_code1;
    String ik5_imple_ts_syn_er_code2;
    String ik5_imple_ts_syn_er_code3;
    String ik5_imple_ts_syn_er_code4;
    String ik5_imple_ts_syn_er_code5;
    String ak9_funct_group_ack_code;
    String ak9_number_of_ts_included;
    String ak9_number_of_received_ts;
    String ak9_number_of_accepted_ts;
    String ak9_funct_group_error_code1;
    String ak9_funct_group_error_code2;
    String ak9_funct_group_error_code3;
    String ak9_funct_group_error_code4;
    String ak9_funct_group_error_code5;
}
