package biz.bna.project.model;




public class Word {


    private Integer wordId;

    private String wordText;

    public Word() {
    }

    public Word(Integer wordId, String wordText) {
        this.wordId = wordId;
        this.wordText = wordText;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWordText() {
        return wordText;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }
}
