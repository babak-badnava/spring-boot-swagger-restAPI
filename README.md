# Spring boot - Spring Rest API - Swagger - Junit test

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Integration of Spring boot, Spring Rest API, Swagger, and Junit test

This is a base project that I am using whenever I want to implement a REST API. In this project, I have used Spring BOOT and Spring REST API to implement my REST API and Swagger for their documentation. I also used Junit test to write unit test for this project.

To add a new Rest Controller follow the below instruction:
  - Extend a class from ```V1RestController``` and add it under ```ir.badnava.restswagger.restcontroller.v1```
  - Then you can add a method in this class like:
```
@ApiOperation(value = "A test controller", response = RestResponseBody.class)
@RequestMapping(value = "/greeting", method = RequestMethod.POST)
public TestResponseBody greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    testService.doSomeLogic();
    return new TestResponseBody(name);
}
```
   - ```@ApiOperation``` is an annotation that is defined by Swagger.
   - To have a structured output for the REST API, we designed an abstract class named ```RestResponseBody``` that all of the responses will be extended from this class.
   - To implement the logic of your API, you can create a class under ```ir.badnava.restswagger.service```, and then, use it in your controller.
   - Then you can run the application and have access to the Swagger UI by going to the [127.0.0.1:5623/rest-ui](http://127.0.0.1:5623/rest-ui)
   - if you want to call your API, your API's address will be like [127.0.0.1:5623/api/v1/test/greeting](http://127.0.0.1:5623/api/v1/test/greeting)

# Junit test
  - After you created a new REST Controller you can write a Junit test for it by extending from ```ir.badnava.restswagger.MainTest``` like the way I did at the ```ir.badnava.restswagger.TestControllerTest```.
```
package ir.badnava.restswagger;
import ir.badnava.restswagger.restcontroller.v1.TestController;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.util.LinkedMultiValueMap;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest extends MainTest {
    @Test
    public void greetingTest() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Babak");
        names.add("John");
        names.add("Babak");
        for (String sample : names) {
            String content = "";
            try {
                LinkedMultiValueMap<String, String> param = new LinkedMultiValueMap<>();
                param.add("name", sample);
                mvc.perform(post("/api/v1/test/greeting")
                        .params(param)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                        .andExpect(status().isOk())
                        .andDo(new ResultHandler() {
                            @Override
                            public void handle(MvcResult mvcResult) throws Exception {
                                System.out.println(mvcResult.getResponse().getContentAsString());
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```
