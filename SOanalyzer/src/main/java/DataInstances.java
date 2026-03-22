import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ipeirotis.readability.engine.Readability;
import com.ipeirotis.readability.enums.MetricType;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import weka.core.*;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

//import java.io.StringReader;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.w3c.dom.Document;
//import org.xml.sax.InputSource;

public class DataInstances {

    public Instances data;
    private Gson gson;

    public DataInstances() {
        gson = new Gson();

        ArrayList<Attribute> atts;
        ArrayList<String> attVals1;
        ArrayList<String> attVals2;
        ArrayList<String> attVals3;

        double[] vals;

        // 1. set up attributes
        atts = new ArrayList<Attribute>();

        // - numeric
        atts.add(new Attribute("Score"));
        atts.add(new Attribute("ViewCount"));
        atts.add(new Attribute("AnswerCount"));
        atts.add(new Attribute("CommentCount"));
        atts.add(new Attribute("FavoriteCount"));

        // - nominal
        attVals1 = new ArrayList<String>();
        attVals1.add("1");
        attVals1.add("2");
        attVals2 = new ArrayList<String>();
        attVals2.add("0");
        attVals2.add("1");
        attVals3 = new ArrayList<String>();
        attVals3.add("0");
        attVals3.add("1");
        attVals3.add("2");

        atts.add(new Attribute("PostTypeId", attVals1));//1:question 2:answer
        atts.add(new Attribute("AcceptedAnswer", attVals2));//0:false 1:true
        atts.add(new Attribute("Edited", attVals2));//0:false 1:true

        // - string
        atts.add(new Attribute("Body", (ArrayList<String>) null));
        atts.add(new Attribute("Title", (ArrayList<String>) null));
        atts.add(new Attribute("Tags", (ArrayList<String>) null));

        // - ???
        atts.add(new Attribute("Id", (ArrayList<String>) null));
        atts.add(new Attribute("ParentId", (ArrayList<String>) null));
        atts.add(new Attribute("OwnerUserId", (ArrayList<String>) null));
        atts.add(new Attribute("OwnerDisplayName", (ArrayList<String>) null));
        atts.add(new Attribute("LastEditorUserId", (ArrayList<String>) null));
        atts.add(new Attribute("LastEditorDisplayName", (ArrayList<String>) null));

        // - date
        atts.add(new Attribute("CreationDate", "yyyy-MM-dd'T'HH:mm:ss"));
        atts.add(new Attribute("LastEditDate", "yyyy-MM-dd'T'HH:mm:ss"));
        atts.add(new Attribute("LastActivityDate", "yyyy-MM-dd'T'HH:mm:ss"));
        atts.add(new Attribute("ClosedDate", "yyyy-MM-dd'T'HH:mm:ss"));
        atts.add(new Attribute("CommunityOwnedDate", "yyyy-MM-dd'T'HH:mm:ss"));

        atts.add(new Attribute("OwnerType", attVals1));//0:user 1:guest
        atts.add(new Attribute("Closed", attVals2));//0:open 1:closed
        atts.add(new Attribute("NowMinusCreation"));
        atts.add(new Attribute("NowMinusLastActivity"));
        atts.add(new Attribute("HTMLTags", (ArrayList<String>) null));
        atts.add(new Attribute("PureText", (ArrayList<String>) null));
        atts.add(new Attribute("CHARACTERS"));
        atts.add(new Attribute("FLESCH_KINCAID"));
        atts.add(new Attribute("ARI"));
        atts.add(new Attribute("SYLLABLES"));
        atts.add(new Attribute("SENTENCES"));
        atts.add(new Attribute("COLEMAN_LIAU"));
        atts.add(new Attribute("GUNNING_FOG"));
        atts.add(new Attribute("COMPLEXWORDS"));
        atts.add(new Attribute("SMOG_INDEX"));
        atts.add(new Attribute("SMOG"));
        atts.add(new Attribute("FLESCH_READING"));
        atts.add(new Attribute("WORDS"));
        atts.add(new Attribute("normalBlock", (ArrayList<String>) null));
        atts.add(new Attribute("codeBlock", (ArrayList<String>) null));
        atts.add(new Attribute("oriText", (ArrayList<String>) null));
        atts.add(new Attribute("modifiedText", (ArrayList<String>) null));
        atts.add(new Attribute("position", attVals3));
        atts.add(new Attribute("operation", attVals3));
        atts.add(new Attribute("purifiedOriText", (ArrayList<String>) null));
        atts.add(new Attribute("purifiedModifiedText", (ArrayList<String>) null));
        atts.add(new Attribute("levenshtein"));
        atts.add(new Attribute("position2", attVals2));
        atts.add(new Attribute("similarity", attVals2));



        this.data = new Instances("Post", atts, 0);
    }

    public void addInstance(JSONObject obj) throws Exception {
        String oriString = "";
        String modifiedString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date curDate = new Date();
        double[] vals = new double[data.numAttributes()];
        for (int i = 5; i < vals.length; i++)
            vals[i] = Utils.missingValue();
        vals[6] = 0;//accepted answer
        vals[22] = 1;//owner type
        vals[23] = 0;//closed

        Iterator<String> set = obj.keys();
        while (set.hasNext()) {
            //based on you key types
            String keyStr = set.next();
            String value = obj.get(keyStr).toString();
            switch (keyStr) {
                case "Score":
                    vals[0] = Integer.parseInt(value);
                    break;
                case "ViewCount":
                    vals[1] = Integer.parseInt(value);
                    break;
                case "AnswerCount":
                    vals[2] = Integer.parseInt(value);
                    break;
                case "CommentCount":
                    vals[3] = Integer.parseInt(value);
                    break;
                case "FavoriteCount":
                    vals[4] = Integer.parseInt(value);
                    break;
                case "PostTypeId":
                    vals[5] = data.attribute(5).indexOfValue(value);
                    break;
                case "AcceptedAnswerId":
                    if (value.equals(""))
                        value = "0";
                    else
                        value = "1";
                    vals[6] = data.attribute(6).indexOfValue(value);
                    break;
                case "Modified":
                    vals[7] = data.attribute(7).indexOfValue(value);
                    break;
                case "Body":
                    vals[8] = data.attribute(8).addStringValue(value);
//                    value = value.replace("&#xA;","");
//                    value = "<html>" + value + "</html>";
//                    Document doc = convertStringToXMLDocument( value );
//                    System.out.println(value);
                    Document doc = Jsoup.parse(value);
                    Elements all = doc.body().select("*");
                    Elements p = doc.body().select("p");
                    Elements code = doc.body().select("code");

                    StringBuilder tag = new StringBuilder();

                    for (Element e : all) {
                        if (e.tag().toString().equals("body"))
                            continue;
                        tag.append(e.tag()).append(" ");
                    }

                    vals[26] = data.attribute(26).addStringValue(tag.toString());
                    vals[27] = data.attribute(27).addStringValue(all.text());
                    vals[40] = data.attribute(40).addStringValue(p.text());
                    vals[41] = data.attribute(41).addStringValue(code.text());
                    ReadibilityVO vo = null;
                    try {
                        vo = getReadability(p.text());

                        vals[28] = vo.COLEMAN_LIAU;
                        vals[29] = vo.SMOG_INDEX;
                        vals[30] = vo.SMOG;
                        vals[31] = vo.COMPLEXWORDS;
                        vals[32] = vo.SYLLABLES;
                        vals[33] = vo.WORDS;
                        vals[34] = vo.ARI;
                        vals[35] = vo.GUNNING_FOG;
                        vals[36] = vo.FLESCH_KINCAID;
                        vals[37] = vo.FLESCH_READING;
                        vals[38] = vo.CHARACTERS;
                        vals[39] = vo.SENTENCES;
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("text = " + p.text());
                        return;
                    }
                    break;
                case "Title":
                    vals[9] = data.attribute(9).addStringValue(value);
                    break;
                case "Tags":
                    value = value.replace('<', ' ').replace('>', ' ');
                    vals[10] = data.attribute(10).addStringValue(value);
                    break;
                case "Id":
                    vals[11] = data.attribute(11).addStringValue(value);
                    break;
                case "ParentId":
                    vals[12] = data.attribute(12).addStringValue(value);
                    break;
                case "OwnerUserId":
                    vals[13] = data.attribute(13).addStringValue(value);
                    vals[22] = 0;
                    break;
                case "OwnerDisplayName":
                    vals[14] = data.attribute(14).addStringValue(value);
                    break;
                case "LastEditorUserId":
                    vals[15] = data.attribute(15).addStringValue(value);
                    break;
                case "LastEditorDisplayName":
                    vals[16] = data.attribute(16).addStringValue(value);
                    break;
                case "CreationDate":
                    vals[17] = data.attribute(17).parseDate(value);
                    vals[24] = (double)(curDate.getTime() - dateFormat.parse(value).getTime()) / 60000;
                    break;
                case "LastEditDate":
                    vals[18] = data.attribute(18).parseDate(value);
                    break;
                case "LastActivityDate":
                    vals[19] = data.attribute(19).parseDate(value);
                    vals[25] = (double)(curDate.getTime() - dateFormat.parse(value).getTime()) / 60000;
                    break;
                case "ClosedDate":
                    vals[20] = data.attribute(20).parseDate(value);
                    vals[23] = 1;
                    break;
                case "CommunityOwnedDate":
                    vals[21] = data.attribute(21).parseDate(value);
                    break;
                case "oriText":
                    vals[42] = data.attribute(42).addStringValue(value);
                    oriString = value;
                    break;
                case "modifiedText":
                    vals[43] = data.attribute(43).addStringValue(value);
                    modifiedString = value;
                    break;
            }
        }
        diff_match_patch dmp = new diff_match_patch();
        LinkedList<diff_match_patch.Diff> diff = dmp.diff_main(oriString, modifiedString);
        dmp.diff_cleanupSemantic(diff);

        boolean insertion = false;
        boolean deletion = false;

        int position = -1;

        int operation;

        for (int i = 0; i < diff.size(); i++) {
            if (diff.get(i).operation != diff_match_patch.Operation.EQUAL) {
                if (i == 0) {
                    position = 0;
                } else if (i == diff.size() - 1 && position == -1) {
                    position = 1;
                } else {
                    position = 2;
                }
            }
            if (diff.get(i).operation == diff_match_patch.Operation.INSERT)
                insertion = true;
            if (diff.get(i).operation == diff_match_patch.Operation.DELETE)
                deletion = true;
        }

        if (position == -1)
            position = 2;
        if (insertion ^ deletion)
        {
            if (insertion)
                operation = 0;
            else
                operation = 1;
        }
        else
            operation = 2;

        int position2 = 1;
        if (position != 1)
            position2 = 0;

        vals[44] = data.attribute(44).indexOfValue(new Integer(position).toString());
        vals[45] = data.attribute(45).indexOfValue(new Integer(operation).toString());

        vals[46] = data.attribute(46).addStringValue(Jsoup.parse(oriString).body().text());
        vals[47] = data.attribute(47).addStringValue(Jsoup.parse(modifiedString).body().text());

        double levenshtein = (double)EditDistanceRecursive.getLevenshteinDistance(oriString, modifiedString)/oriString.length();
        int scale = 0;
        if (levenshtein > 0.1)
            scale = 1;

        vals[48] = levenshtein;
        vals[49] = data.attribute(49).indexOfValue(new Integer(position2).toString());
        vals[50] = data.attribute(50).indexOfValue(new Integer(scale).toString());

        data.add(new DenseInstance(1.0, vals));
        return;
    }

    public ReadibilityVO getReadability(String text) throws Exception {
//        HttpResponse<JsonNode> response = Unirest.post("https://ipeirotis-readability-metrics.p.rapidapi.com/getReadabilityMetrics?text=" + URLEncoder.encode(text, "UTF-8"))
//                .header("X-RapidAPI-Host", "ipeirotis-readability-metrics.p.rapidapi.com")
//                .header("X-RapidAPI-Key", "2719e5067cmsh7e562efea3d081fp13d42ejsn60b81d28136d")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .asJson();
//        return gson.fromJson(response.getBody().toString(), ReadibilityVO.class);

        Readability r = new Readability(text);

        JsonObject json = new JsonObject();
        for (MetricType metricType : MetricType.values())
            json.addProperty(metricType.toString(),r.getMetric(metricType));

        return gson.fromJson(json.toString(), ReadibilityVO.class);
    }

//    private static Document convertStringToXMLDocument(String xmlString)
//    {
//        //Parser that produces DOM object trees from XML content
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        //API to obtain DOM Document instance
//        DocumentBuilder builder = null;
//        try
//        {
//            //Create DocumentBuilder with default configuration
//            builder = factory.newDocumentBuilder();
//
//            //Parse the content to Document object
//            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
//            return doc;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }
}