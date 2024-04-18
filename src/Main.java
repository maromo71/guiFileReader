import view.myNotepad;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame notepad = new JFrame();
        notepad.setContentPane(new myNotepad().getFrmPanel());
        notepad.setSize(600, 400);
        notepad.setTitle("Bloco de Notas");
        notepad.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        notepad.setVisible(true);
    }
}