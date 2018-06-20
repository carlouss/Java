package sistcad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

public class FormCliente extends JFrame implements ActionListener {
    
    JLabel          lblTitulo   =new JLabel ("Cadastro de Cliente"),
                    lblNome     =new JLabel ("Nome:"),
                    lblCPF      =new JLabel ("CPF:"),
                    lblRG       =new JLabel ("R.G:"),
                    lblCEP      =new JLabel ("CEP:"),
                    lblEndereco =new JLabel ("Endereço:"),
                    lblNumero   =new JLabel ("Nº:"),
                    lblTelefone =new JLabel ("Telefone:"),
                    lblEmail    =new JLabel ("Email:");
    
    JTextField      txfNome     =new JTextField(),
                    txfNumero   =new JTextField(),
                    txfEmail    =new JTextField(),
                    txfEndereco =new JTextField();
    
    MaskFormatter   maskCpf,
                    maskRg,
                    maskCep,
                    maskTelefone;
    
    JButton         btnEnviar,
                    btnDescartar,
                    btnSair;
    
    ImageIcon       Sair,
                    Enviar,
                    Descartar;
    
    JFormattedTextField ftxfCpf,
                        ftxfRg,
                        ftxfCep,
                        ftxfTelefone;
    
    //Events
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSair){
        FormCliente.this.dispose();
        }
        if(e.getSource()==btnEnviar){
            String a = txfNome.getText();
            String b = ftxfRg.getText();
            String c = ftxfCpf.getText();
            String d = ftxfTelefone.getText();
            String i = ftxfCep.getText();
            String f = txfEmail.getText();
            String g = txfEndereco.getText();
            String h = txfNumero.getText();
            
            JOptionPane.showMessageDialog(null,"Cliente cadastrado no SistCad! \n\n"+" Nome: "+a+"\n RG: "+b+"\n CPF: "+c+"\n E-mail: "+f+"\n Telefone: "+d+"\n Endereço: "+g+"\n Nº "+h+"\n CEP: "+i+"\n","Cliente cadastrado",1);
        }
        if(e.getSource()==btnDescartar){
            txfNome     .setText("");
            txfNumero   .setText("");
            txfEmail    .setText("");
            txfEndereco .setText("");
            ftxfCpf     .setText("");
            ftxfRg      .setText("");
            ftxfCep     .setText("");
            ftxfTelefone.setText("");
        }
        }
    
public FormCliente(){
    super ("SistCad");
    Container telaCliente = getContentPane();
    setLayout(null);
    //set Grid
    int         gW      = 8,
                gH      = 8,
                btnW    = gW*4,
                btnH    = 26,	
                wWidth  = btnW*5+gW*7;
    
    //Btn Icons
    Sair            =new ImageIcon("Sair.png");
    btnSair         =new JButton (Sair);
    Enviar          =new ImageIcon("Enviar.png");
    btnEnviar       =new JButton (Enviar);
    Descartar       =new ImageIcon("Descartar.png");
    btnDescartar    =new JButton (Descartar);
    
    //masks's
    try{
    maskCpf         =new MaskFormatter("###.###.###-##");
    maskRg          =new MaskFormatter("##.###.###-#");
    maskCep         =new MaskFormatter("#####-###");
    maskTelefone    =new MaskFormatter("(##)#####-####");
    
    maskCpf         .setPlaceholderCharacter('_');
    maskRg          .setPlaceholderCharacter('_');
    maskCep         .setPlaceholderCharacter('_');
    maskTelefone    .setPlaceholderCharacter('_');
    }
    catch(ParseException excp){}
    ftxfCpf         =new JFormattedTextField(maskCpf);
    ftxfRg          =new JFormattedTextField(maskRg);
    ftxfCep         =new JFormattedTextField(maskCep);
    ftxfTelefone    =new JFormattedTextField(maskTelefone);
    
    //btn Positions
    lblTitulo   .setBounds(gW*9,    gH,    wWidth+(gW*4), btnH*2);
    lblNome     .setBounds(gW*5,    gH*9,  wWidth,        btnH);
    txfNome     .setBounds(gW*10,   gH*9,  wWidth+30,     btnH);
    lblCPF      .setBounds(gW*6+3,  gH*13, wWidth,        btnH);
    ftxfCpf     .setBounds(gW*10,   gH*13, wWidth-124,    btnH);
    lblRG       .setBounds(gW*24,   gH*13, wWidth,        btnH);
    ftxfRg      .setBounds(gW*27,   gH*13, wWidth-137,    btnH);
    lblCEP      .setBounds(gW*5+10, gH*17, wWidth,        btnH);
    ftxfCep     .setBounds(gW*10,   gH*17, wWidth-149,    btnH);
    lblNumero   .setBounds(gW*24,   gH*17, wWidth,        btnH);
    txfNumero   .setBounds(gW*27,   gH*17, wWidth-185,    btnH);
    lblEndereco .setBounds(gW*2+3,  gH*21, wWidth,        btnH);
    txfEndereco .setBounds(gW*10,   gH*21, wWidth+30,     btnH);
    lblTelefone .setBounds(gW*2+8,  gH*25, wWidth,        btnH);
    ftxfTelefone.setBounds(gW*10,   gH*25, wWidth-120,    btnH);
    lblEmail    .setBounds(gW*5+2,  gH*29, wWidth,        btnH);
    txfEmail    .setBounds(gW*10,   gH*29, wWidth-60,     btnH);
    btnEnviar   .setBounds(gW*4,   gH*35, btnW*3,         btnH*3);
    btnDescartar.setBounds(gW*19,   gH*35, btnW*3,        btnH*3);
    btnSair     .setBounds(gW*34,   gH*35, btnW*3,        btnH*3);
    
    //add buttons&labels,txf's
    telaCliente     .add(lblTitulo);
    telaCliente     .add(lblCPF);       telaCliente     .add(ftxfCpf);
    telaCliente     .add(lblRG);        telaCliente     .add(ftxfRg);
    telaCliente     .add(lblCEP);       telaCliente     .add(ftxfCep);
    telaCliente     .add(lblTelefone);  telaCliente     .add(ftxfTelefone);
    telaCliente     .add(lblNome);      telaCliente     .add(txfNome);
    telaCliente     .add(lblEndereco);  telaCliente     .add(txfEndereco);
    telaCliente     .add(lblNumero);    telaCliente     .add(txfNumero);
    telaCliente     .add(lblEmail);     telaCliente     .add(txfEmail);
    telaCliente     .add(btnEnviar);    telaCliente     .add(btnSair);     telaCliente     .add(btnDescartar);
    
    //Buttons Events
    btnSair.addActionListener(this);
    btnEnviar.addActionListener(this);
    btnDescartar.addActionListener(this);
    
    //lbl/txf Styles
    Color	ColorsItems = new Color(46,61,78),
                ColorBg     = new Color(99,134,169),
                Colortxb    = new Color(78,108,138);
    
    lblTitulo   .setFont(new Font("SansSerif", Font.BOLD, 25));
    lblTitulo   .setForeground( new Color(46,61,78));
    
    lblTitulo   .setForeground(ColorsItems);
    lblNome     .setForeground(ColorsItems);
    lblCPF      .setForeground(ColorsItems);
    lblRG       .setForeground(ColorsItems);
    lblCEP      .setForeground(ColorsItems);
    lblEndereco .setForeground(ColorsItems);
    lblNumero   .setForeground(ColorsItems);
    lblTelefone .setForeground(ColorsItems);
    lblEmail    .setForeground(ColorsItems);
    txfNome     .setForeground(ColorsItems);
    txfNumero   .setForeground(ColorsItems);
    txfEmail    .setForeground(ColorsItems);
    txfEndereco .setForeground(ColorsItems);
    ftxfCpf     .setForeground(ColorsItems);
    ftxfRg      .setForeground(ColorsItems);
    ftxfCep     .setForeground(ColorsItems);
    ftxfTelefone.setForeground(ColorsItems);
    
    
    
    btnSair     .setBackground(null);
    btnEnviar   .setBackground(null);
    btnDescartar.setBackground(null);
    
    btnSair     .setBorder(null);
    btnEnviar   .setBorder(null);
    btnDescartar.setBorder(null);
    
    txfNome     .setBorder(null);
    txfNumero   .setBorder(null);
    txfEmail    .setBorder(null);
    txfEndereco .setBorder(null);
    ftxfCpf     .setBorder(null);
    ftxfRg      .setBorder(null);
    ftxfCep     .setBorder(null);
    ftxfTelefone.setBorder(null);
    
    txfNome     .setBackground(Colortxb);
    txfNumero   .setBackground(Colortxb);
    txfEmail    .setBackground(Colortxb);
    txfEndereco .setBackground(Colortxb);
    ftxfCpf     .setBackground(Colortxb);
    ftxfRg      .setBackground(Colortxb);
    ftxfCep     .setBackground(Colortxb);
    ftxfTelefone.setBackground(Colortxb);
            
    telaCliente .setBackground(ColorBg);
    
    setVisible(true);
    setSize(400,400);
    setLocationRelativeTo(null);

}    
}