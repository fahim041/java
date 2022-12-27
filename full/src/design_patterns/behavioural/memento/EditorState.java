package design_patterns.behavioural.memento;

//memento
public class EditorState {
    private final String content;
    private final String user;

    public EditorState(String content, String user){
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

}
