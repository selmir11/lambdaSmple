package com.c4hco.test.automation.Dto;

import lombok.Data;
import java.util.Map;

@Data
public class GroupDetails {
    Map<String, String> groupNumAndEnrollees;
}