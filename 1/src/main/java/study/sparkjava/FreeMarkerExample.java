package study.sparkjava;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.post;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import study.opencsv.Select;

/**
 * <pre>
 * study.sparkjava 
 * FreeMarkerExample.java
 *
 * �꽕紐� :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : user
 * @version : v1.0
 */
public class FreeMarkerExample {

    public static void main(String args[]) throws IOException {
    	//get("/users/:name", (request, response) -> "Selected user: " + request.params(":name"));
    	 get("/:city/:diseasename/:date", (request, response) -> {
    		 Select test = new study.opencsv.Select(request.params(":city"), request.params(":date"), request.params(":diseasename"));
             Map<String, Object> attributes = new HashMap<>();
             attributes.put("message", test.output());

             // The hello.ftl file is located in directory:
             // src/test/resources/spark/examples/templateview/freemarker
             return modelAndView(attributes, "sample.ftl");
         }, new FreeMarkerTemplateEngine());
    	 post("/post", (request, response) -> {
             File file = new File("D:\\테스트\\test1.txt");
             FileWriter writer = null;
             
             try {
                 // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
                 writer = new FileWriter(file, true);
                 writer.write(request.body());
                 writer.flush();
                 
                 System.out.println("DONE");
             } catch(IOException e) {
                 e.printStackTrace();
             } finally {
                 try {
                     if(writer != null) writer.close();
                 } catch(IOException e) {
                     e.printStackTrace();
                 }
             }
             return "파일생성 되었습니다.";
         });
    }
}