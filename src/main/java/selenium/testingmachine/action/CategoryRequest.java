package selenium.testingmachine.action;


import java.util.List;

// Категори болон хэрэглэгчийн үйлдлүүдийг хүлээн авах хүсэлт загвар
public class CategoryRequest {
    private String title;
    private String url;
    private List<UserAction> actions;

    // Getter болон Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UserAction> getActions() {
        return actions;
    }

    public void setActions(List<UserAction> actions) {
        this.actions = actions;
    }
}
