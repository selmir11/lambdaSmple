package com.c4hco.test.automation.edi.ediUtil;

import com.c4hco.test.automation.Dto.Edi.Edi999.Edi999Segments;
import com.c4hco.test.automation.Dto.SharedData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.xlate.edi.stream.EDIInputFactory;
import io.xlate.edi.stream.EDIStreamReader;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class Ob999Util {

    public void parseOb999(InputStream inputStream) {
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
            System.out.println("jsonSegmentString Ob999::"+jsonCommonSegmentString);
            JSONObject ob999SegJsonObj = new JSONObject(jsonCommonSegmentString);
            setOb999Segments(ob999SegJsonObj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setOb999Segments(JSONObject ob999SegJsonObj){
        Edi999Segments ob999Segments = new Edi999Segments();

        JSONArray isaSeg = ob999SegJsonObj.getJSONArray("ISA");
        JSONArray ieaSeg = ob999SegJsonObj.getJSONArray("IEA");
        JSONArray gsSegment = ob999SegJsonObj.getJSONArray("GS");
        JSONArray geSeg = ob999SegJsonObj.getJSONArray("GE");
        JSONArray stSeg = ob999SegJsonObj.getJSONArray("ST");
        JSONArray seSeg = ob999SegJsonObj.getJSONArray("SE");
        JSONArray ak1Seg = ob999SegJsonObj.getJSONArray("AK1");
        JSONArray ak2Seg = ob999SegJsonObj.getJSONArray("AK2");
        JSONArray ak9Seg = ob999SegJsonObj.getJSONArray("AK9");
        JSONArray ik5Seg = ob999SegJsonObj.getJSONArray("IK5");

        JSONArray isaSegment = (JSONArray) isaSeg.get(0);
        JSONArray ieaSegment = (JSONArray) ieaSeg.get(0);

        ob999Segments.setISA(isaSegment);
        ob999Segments.setIEA(ieaSegment);
        ob999Segments.setGS(gsSegment);
        ob999Segments.setGE(geSeg);
        ob999Segments.setST(stSeg);
        ob999Segments.setSE(seSeg);
        ob999Segments.setAK1(ak1Seg);
        ob999Segments.setAK2(ak2Seg);
        ob999Segments.setAK9(ak9Seg);
        ob999Segments.setIK5(ik5Seg);

        SharedData.setOb999Segments(ob999Segments);
    }
}
