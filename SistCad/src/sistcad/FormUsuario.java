package sistcad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

public class FormUsuario extends JFrame implements ActionListener {
    
    JLabel          lblTitulo   =new JLabel ("Cadastro de Usuário"),
                    lblNome     =new JLabel ("Nome:"),
                    lblCPF      =new JLabel ("CPF:"),   
                    lblRG       =new JLabel ("R.G:"),
                    lblLogin    =new JLabel ("Login:"),
                    lblSenha    =new JLabel ("Senha:"),
                    lblTelefone =new JLabel ("Telefone:"),
                    lblEmail    =new JLabel ("Email:");
    
    JTextField      txfNome     =new JTextField(),
                    txfEmail    =new JTextField(),
                    txfLogin    =new JTextField(),
                    txfSenha    =new JTextField();
    
    MaskFormatter   maskCpf,
                    maskRg,
                    maskTelefone;
    
    JButton         btnEnviar,
                    btnSair,
                    btnDescartar;
    
    ImageIcon       Sair,
                    Enviar,
                    Descartar;
    
    JFormattedTextField ftxfCpf,
                        ftxfRg,
                        ftxfTelefone;
    
    //Events
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSair){
        FormUsuario.this.dispose();
        }
        if(e.getSource()==btnEnviar){
            String a = txfNome.getText();
            String b = ftxfRg.getText();
            String c = ftxfCpf.getText();
            String d = ftxfTelefone.getText();
            String i = txfLogin.getText();
            String f = txfEmail.getText();
            String g = txfSenha.getText();
            
            JOptionPane.showMessageDialog(this,"Usuário cadastrado no SistCad! \n\n"+" Nome: "+a+"\n RG: "+b+"\n CPF: "+c+"\n E-mail: "+f+"\n Telefone: "+d+"\n Login: "+i+"\n Senha: "+g+"\n","Usuário cadastrado",1);
        }
        if(e.getSource()==btnDescartar){
            txfNome     .setText("");
            ftxfRg      .setText("");
            txfEmail    .setText("");
            ftxfCpf     .setText("");
            txfLogin    .setText("");
            txfSenha    .setText("");
            ftxfTelefone.setText("");
            
        }
    }
public FormUsuario(){
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
    maskTelefone    =new MaskFormatter("(##)#####-####");
    
    maskCpf         .setPlaceholderCharacter('_');
    maskRg          .setPlaceholderCharacter('_');
    maskTelefone    .setPlaceholderCharacter('_');
    }
    catch(ParseException excp){}
    ftxfCpf         =new JFormattedTextField(maskCpf);
    ftxfRg          =new JFormattedTextField(maskRg);
    ftxfTelefone    =new JFormattedTextField(maskTelefone);
    
    txfSenha=new JPasswordField();//PW
    
    //btn Positions
    lblTitulo   .setBounds(gW*9,    gH,    wWidth+(gW*4), btnH*2);
    lblNome     .setBounds(gW*5,    gH*9,  wWidth,        btnH);
    txfNome     .setBounds(gW*10,   gH*9,  wWidth+30,     btnH);
    lblCPF      .setBounds(gW*6+3,  gH*13, wWidth,        btnH);
    ftxfCpf     .setBounds(gW*10,   gH*13, wWidth-120,    btnH);
    lblRG       .setBounds(gW*24,   gH*13, wWidth,        btnH);
    ftxfRg      .setBounds(gW*27,   gH*13, wWidth-137,    btnH);
    lblTelefone .setBounds(gW*2+8,  gH*17, wWidth,        btnH);
    ftxfTelefone.setBounds(gW*10,   gH*17, wWidth-120,    btnH);
    lblEmail    .setBounds(gW*5+2,  gH*21, wWidth,        btnH);
    txfEmail    .setBounds(gW*10,   gH*21, wWidth-60,     btnH);
    lblLogin    .setBounds(gW*5+2,  gH*25, wWidth,        btnH);
    txfLogin    .setBounds(gW*10,   gH*25, wWidth-130,    btnH);
    lblSenha    .setBounds(gW*5-3,  gH*29, wWidth,        btnH);
    txfSenha    .setBounds(gW*10,   gH*29, wWidth-130,    btnH);
    btnEnviar   .setBounds(gW*4,   gH*35, btnW*3,         btnH*3);
    btnDescartar.setBounds(gW*19,   gH*35, btnW*3,        btnH*3);
    btnSair     .setBounds(gW*34,   gH*35, btnW*3,        btnH*3);
    
    //add buttons&labels,txf's
    telaCliente     .add(lblTitulo);
    telaCliente     .add(lblCPF);       telaCliente     .add(ftxfCpf);
    telaCliente     .add(lblRG);        telaCliente     .add(ftxfRg);
    telaCliente     .add(lblLogin);     telaCliente     .add(txfLogin);
    telaCliente     .add(lblTelefone);  telaCliente     .add(ftxfTelefone);
    telaCliente     .add(lblNome);      telaCliente     .add(txfNome);
    telaCliente     .add(lblSenha);     telaCliente     .add(txfSenha);
    telaCliente     .add(lblEmail);     telaCliente     .add(txfEmail);
    telaCliente     .add(btnEnviar);    telaCliente     .add(btnSair);telaCliente     .add(btnDescartar);
    
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
    lblLogin    .setForeground(ColorsItems);
    lblSenha    .setForeground(ColorsItems);
    lblTelefone .setForeground(ColorsItems);
    lblEmail    .setForeground(ColorsItems);
    txfNome     .setForeground(ColorsItems);
    txfEmail    .setForeground(ColorsItems);
    txfSenha    .setForeground(ColorsItems);
    ftxfCpf     .setForeground(ColorsItems);
    ftxfRg      .setForeground(ColorsItems);
    txfLogin    .setForeground(ColorsItems);
    ftxfTelefone.setForeground(ColorsItems);
    
    btnSair     .setBackground(null);
    btnEnviar   .setBackground(null);
    btnDescartar.setBackground(null);
    
    btnSair     .setBorder(null);
    btnEnviar   .setBorder(null);
    btnDescartar.setBorder(null);
    
    txfNome     .setBorder(null);
    txfEmail    .setBorder(null);
    txfSenha    .setBorder(null);
    ftxfCpf     .setBorder(null);
    ftxfRg      .setBorder(null);
    txfLogin    .setBorder(null);
    ftxfTelefone.setBorder(null);
    
    
    telaCliente .setBackground(ColorBg);
    txfNome     .setBackground(Colortxb);
    txfEmail    .setBackground(Colortxb);
    txfSenha    .setBackground(Colortxb);
    ftxfCpf     .setBackground(Colortxb);
    ftxfRg      .setBackground(Colortxb);
    txfLogin    .setBackground(Colortxb);
    ftxfTelefone.setBackground(Colortxb);
    
    
    setVisible(true);
    setSize(400,400);
    setLocationRelativeTo(null);
}    
}