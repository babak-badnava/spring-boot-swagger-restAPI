package ir.badnava.restswagger.restcontroller.v1;

import io.swagger.annotations.ApiOperation;
import ir.badnava.restswagger.responsebodymodels.RestResponseBody;
import ir.badnava.restswagger.responsebodymodels.TestResponseBody;
import ir.badnava.restswagger.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController<T extends RestResponseBody> extends V1RestController {

    @Autowired
    TestService testService;

    @ApiOperation(value = "test controller info", response = RestResponseBody.class)
    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public TestResponseBody greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        testService.doSomeLogic();

        return new TestResponseBody(name);
    }

}
