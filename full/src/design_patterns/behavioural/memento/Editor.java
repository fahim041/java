package design_patterns.behavioural.memento;

import java.util.ArrayList;
import java.util.List;

//originator
public class Editor {
    private String content;
    private String user;

    public void setContent(String content, String user){
        this.content = content;
        this.user = user;
    }

    public EditorState createState(){
        return new EditorState(content, user);
    }

    public void restore(EditorState state){
        content = state.getContent();
        user = state.getUser();
    }

    public String getContent(){
        return content;
    }

    public String getUser(){
        return user;
    }
}
