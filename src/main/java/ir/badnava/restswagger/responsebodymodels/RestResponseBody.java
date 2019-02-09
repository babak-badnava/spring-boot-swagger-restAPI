package ir.badnava.restswagger.responsebodymodels;

import io.swagger.annotations.ApiModelProperty;
import ir.badnava.restswagger.utils.ValidationMessage;

import java.util.List;

public abstract class RestResponseBody {

    @ApiModelProperty(position = 0, notes = "More validations on the result")
    private List<ValidationMessage> validations;

    public List<ValidationMessage> getValidations() {
        return validations;
    }

    public <T extends RestResponseBody> T setValidations(List<ValidationMessage> validations) {
        this.validations = validations;
        return (T) this;
    }
}
