package isep.project.web.jsonview;

public class AjaxRequestBody {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AjaxRequestBody{" +
                "id='" + id + '\'' +
                '}';
    }
}

