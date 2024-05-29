package biz.bna.project.model;



public class Appendix {



    private Integer appendixId;


    private String appendixName;


    private String appendixPath;

    public Appendix() {
    }

    public Appendix(Integer appendixId, String appendixName, String appendixPath) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
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
}
