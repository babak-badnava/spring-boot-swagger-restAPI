package ir.badnava.restswagger.restcontroller.v1;

import ir.badnava.restswagger.responsebodymodels.RestResponseBody;
import ir.badnava.restswagger.restcontroller.BaseRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public abstract class V1RestController<T extends RestResponseBody> extends BaseRestController {

}
