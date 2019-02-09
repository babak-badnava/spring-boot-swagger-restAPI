package ir.badnava.restswagger.responsebodymodels;

public class TestResponseBody extends RestResponseBody {

    private String content;

    public TestResponseBody(String content) {
        this.content = "Hello " + content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
