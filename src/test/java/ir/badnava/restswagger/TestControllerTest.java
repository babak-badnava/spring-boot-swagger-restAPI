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
