package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class myNotepad implements ActionListener {
    private JPanel frmPanel;
    private JTextArea textArea1;
    private JMenu MyMenu;
    private JMenuBar MenuBar;
    private JMenu MyMenu2;
    private JMenuItem MyOpen;
    private JMenuItem MySave;
    private FileReader in;

    public JPanel getFrmPanel() {
        return frmPanel;
    }

    public myNotepad(){
        //Construtor da janela
        MyOpen.addActionListener(this);
        MySave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            try{
                String nome_arquivo = "";
                if (e.getSource() == MyOpen) {
                    //Abrir
                    FileDialog FOpen = new FileDialog(
                            (Dialog) null,
                            "Abrir Arquivo",
                            FileDialog.LOAD
                    );
                    FOpen.setVisible(true);
                    if (FOpen.getFile() == null) {
                        return; // encerra
                    }
                    nome_arquivo = FOpen.getDirectory() +
                            FOpen.getFile();
                    in = new FileReader(nome_arquivo);
                    StringBuilder s = new StringBuilder();
                    int i = in.read();
                    while (i != -1) {
                        //enquando nao for fim de arquivo
                        s.append((char) i);
                        i = in.read();
                    }
                    textArea1.setText(s.toString());
                    in.close();
                    return;
                }


                if(e.getSource()==MySave){

                    //Salvar
                    FileDialog FSave = new FileDialog(
                            (Dialog) null,
                            "Salvar o Arquivo",
                            FileDialog.SAVE
                    );
                    FSave.setVisible(true);
                    
                    if(FSave.getFile()==null){
                        //cai fora
                        return;
                    }
                    nome_arquivo = FSave.getDirectory() +
                            FSave.getFile();
                    FileWriter out = new FileWriter(nome_arquivo);
                    out.write(textArea1.getText());
                    out.close();

                }
            }catch (Exception ex){
                    JOptionPane.showMessageDialog(
                            null,
                            "Atenção: Erro ao efetuar operação",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
            }


        }
    }
