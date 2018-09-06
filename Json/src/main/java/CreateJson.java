import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.IOException;


/**
 * {
 "name": "aaa",
 "email": "aaa@aa.com",
 "age": 24,
 "pets": {
 "petName": "kitty",
 "petAge": 3
 },
 "skills": [ "java","linux","mysql"]
 }
 */
public class CreateJson {

    //构造节点
    JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;


    String jsonString =
            "{\"name\":\"aaa\",\"email\":\"aaa@aa.com\",\"age\":24,\"pets\":{\"petName\":\"kitty\",\"petAge\":3},\"skills\":[\"java\",\"linux\",\"mysql\"]}";
    @Test
    public void testTreeModelGenerate() throws IOException {
        ObjectNode rootNode = jsonNodeFactory.objectNode();

        //创建根结点
        rootNode.put("name","aaa");
        rootNode.put("email","aaa@aa.com");
        rootNode.put("age",24);

        ObjectNode presNode = jsonNodeFactory.objectNode();
        presNode.put("petName","kitty");
        presNode.put("petAge",3);

        rootNode.set("pets",presNode);

        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        arrayNode.add("java").add("linux").add("mysql");

        rootNode.set("skills",arrayNode);

        System.out.println(rootNode);

        //这有啥用？？？
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(System.out);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeTree(generator,rootNode);


    }


    @Test
    public void testTreeModelParse() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //使用ObjectMapper的readValue方法将json字符串解析到JsonNode实例中
        JsonNode rootNode = objectMapper.readTree(jsonString);
        System.out.println(rootNode);
        //直接从rootNode中获取某个键的值，
        //这种方式在如果我们只需要一个长json串中某个字段值时非常方便
        JsonNode nameNode = rootNode.get("name");
        System.out.println(nameNode);  // "aaa"
        String name = nameNode.asText();  // aaa
        System.out.println(name);
        //从 rootNode 中获取数组节点
        JsonNode skillsNode = rootNode.get("skills");
        for(int i = 0;i < skillsNode.size();i++) {
            System.out.println(skillsNode.get(i).asText());
        }
        //从 rootNode 中获取子对象节点
        JsonNode petsNode = rootNode.get("pets");
        String petsName = petsNode.get("petName").asText();
        System.out.println(petsName);
    }

}
