package by.nikita.sockets.server.entity.text;

import java.io.Serializable;
import java.util.List;

public class TextEditor implements Serializable {
    private List<String> listWithText;
    private String result;

    public List<String> getListWithText() {
        return listWithText;
    }

    public void setListWithText(List<String> listWithText) {
        this.listWithText = listWithText;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
