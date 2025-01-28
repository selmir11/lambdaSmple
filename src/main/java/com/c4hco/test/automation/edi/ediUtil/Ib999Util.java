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

public class Ib999Util {

    public void parseIb999(InputStream inputStream) {
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
            JSONObject ib999SegJsonObj = new JSONObject(jsonCommonSegmentString);
            setIb999Segments(ib999SegJsonObj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setIb999Segments(JSONObject ib999SegJsonObj){
        Edi999Segments ib999Segments = new Edi999Segments();

        JSONArray isaSeg = ib999SegJsonObj.getJSONArray("ISA");
        JSONArray ieaSeg = ib999SegJsonObj.getJSONArray("IEA");
        JSONArray gsSegment = ib999SegJsonObj.getJSONArray("GS");
        JSONArray geSeg = ib999SegJsonObj.getJSONArray("GE");
        JSONArray stSeg = ib999SegJsonObj.getJSONArray("ST");
        JSONArray seSeg = ib999SegJsonObj.getJSONArray("SE");
        JSONArray ak1Seg = ib999SegJsonObj.getJSONArray("AK1");
        JSONArray ak2Seg = ib999SegJsonObj.getJSONArray("AK2");
        JSONArray ak9Seg = ib999SegJsonObj.getJSONArray("AK9");
        JSONArray ik5Seg = ib999SegJsonObj.getJSONArray("IK5");

        JSONArray isaSegment = (JSONArray) isaSeg.get(0);
        JSONArray ieaSegment = (JSONArray) ieaSeg.get(0);

        ib999Segments.setISA(isaSegment);
        ib999Segments.setIEA(ieaSegment);
        ib999Segments.setGS(gsSegment);
        ib999Segments.setGE(geSeg);
        ib999Segments.setST(stSeg);
        ib999Segments.setSE(seSeg);
        ib999Segments.setAK1(ak1Seg);
        ib999Segments.setAK2(ak2Seg);
        ib999Segments.setAK9(ak9Seg);
        ib999Segments.setIK5(ik5Seg);

        SharedData.setIb999Segments(ib999Segments);
        tstEdi999();
    }

    public void tstEdi999(){
        SharedData.getIb999Segments();
    }
}
