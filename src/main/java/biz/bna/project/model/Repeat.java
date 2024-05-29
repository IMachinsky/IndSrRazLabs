package biz.bna.project.model;




public class Repeat {


    private Integer repeatId;


    private Integer wordId;


    private Integer appendixId;


    private Integer repeatCount;

    public Repeat() {
    }

    public Repeat(Integer repeatId, Integer wordId, Integer appendixId, Integer repeatCount) {
        this.repeatId = repeatId;
        this.wordId = wordId;
        this.appendixId = appendixId;
        this.repeatCount = repeatCount;
    }

    public Integer getRepeatId() {
        return repeatId;
    }

    public void setRepeatId(Integer repeatId) {
        this.repeatId = repeatId;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public Integer getAppendixId() {
        return appendixId;
    }

    public void setAppendixId(Integer appendixId) {
        this.appendixId = appendixId;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }
}
