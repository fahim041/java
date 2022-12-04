package design_patterns.behavioural.memento;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private String content;
    private List<String> list = new ArrayList<>();

    public void setContent(String content) {
        this.content = content;
        list.add(content);
    }

    public String getContent() {
        return content;
    }

    public void undo(){
        list.remove(list.size() - 1);
        content = list.get(list.size() - 1);
    }
}
