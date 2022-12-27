import design_patterns.behavioural.memento.Editor;
import design_patterns.behavioural.memento.History;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("a", "user-1");
        history.push(editor.createState());

        editor.setContent("b", "user-2");
        history.push(editor.createState());

        editor.setContent("c", "user-1");
        editor.restore(history.pop());
        editor.restore(history.pop());

        System.out.println(editor.getContent() +" "+ editor.getUser());
    }
}