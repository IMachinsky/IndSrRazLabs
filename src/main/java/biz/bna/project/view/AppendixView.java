package biz.bna.project.view;



public class AppendixView {


    private Integer appendixId;


    private String appendixName;


    private String appendixPath;


    private Integer relevance;

    public AppendixView() {
    }

    public AppendixView(Integer appendixId,
                        String appendixName,
                        String appendixPath,
                        Integer relevance) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
        this.relevance = relevance;
    }

    public Integer getAppendixId() {
        return appendixId;
    }

    public void setAppendixId(Integer appendixId) {
        this.appendixId = appendixId;
    }

    public String getAppendixName() {
        return appendixName;
    }

    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }

    public String getAppendixPath() {
        return appendixPath;
    }

    public void setAppendixPath(String appendixPath) {
        this.appendixPath = appendixPath;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }
}
