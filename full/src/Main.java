import design_patterns.behavioural.memento.Editor;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setContent("a");
        editor.setContent("b");
        editor.setContent("c");
        editor.undo();
        editor.undo();
        System.out.println(editor.getContent());
    }
}