package com.c4hco.test.automation.edi.ediUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.xlate.edi.stream.EDIInputFactory;
import io.xlate.edi.stream.EDIStreamReader;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.InputStream;

public class Edi999Util {

    public void parseEdi999(InputStream inputStream) {
        try {
            EDIInputFactory factory = EDIInputFactory.newFactory();
            EDIStreamReader reader = factory.createEDIStreamReader(inputStream);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode segmentsObject = objectMapper.createObjectNode();
            String currentSegmentName = null;
            ArrayNode currentSegmentArray = objectMapper.createArrayNode();
            ListValuedMap<String, ArrayNode> segmentData = new ArrayListValuedHashMap<>();


            while (reader.hasNext()) {
                switch (reader.next()) {
                    case START_INTERCHANGE:
                        String standard = reader.getStandard();
                        break;
                    case START_SEGMENT:
                        currentSegmentName = reader.getText();
                        currentSegmentArray = objectMapper.createArrayNode();
                        break;

                    case ELEMENT_DATA:
                        String data = reader.getText();
                        currentSegmentArray.add(data);
                        segmentsObject.set(currentSegmentName, currentSegmentArray);
                        break;
                    case END_SEGMENT:
                        segmentData.put(currentSegmentName, currentSegmentArray);
                        break;
                }
            }
            String jsonCommonSegmentString = objectMapper.writeValueAsString(segmentData.asMap());
            System.out.println("jsonSegmentString Edi999::"+jsonCommonSegmentString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
