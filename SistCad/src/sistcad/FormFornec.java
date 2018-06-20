package sistcad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

public class FormFornec extends JFrame implements ActionListener {
    
    JLabel          lblTitulo   =new JLabel ("Cadastro de Fornecedor"),
                    lblRSocial  =new JLabel ("R.Social:"),
                    lblCNPJ     =new JLabel ("CNPJ:"),
                    lblCEP      =new JLabel ("CEP:"),
                    lblEndereco =new JLabel ("Endereço:"),
                    lblNumero   =new JLabel ("Nº:"),
                    lblTelefone =new JLabel ("Telefone:"),
                    lblEmail    =new JLabel ("Email:");
    
    JTextField      txfRSocial  =new JTextField(),
                    txfNumero   =new JTextField(),
                    txfEmail    =new JTextField(),
                    txfEndereco =new JTextField();
    
    MaskFormatter   MaskCnpj,
                    maskCep,
                    maskTelefone;
    
    JButton         btnEnviar,
                    btnSair,
                    btnDescartar;
    
    ImageIcon       Sair,
                    Enviar,
                    Descartar;
    
    JFormattedTextField ftxfCnpj,
                        ftxfCep,
                        ftxfTelefone;
    
    //Events
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSair){
        FormFornec.this.dispose();
        }
        if(e.getSource()==btnEnviar){
            String a = txfRSocial.getText();
            String b = ftxfCnpj.getText();
            String c = ftxfTelefone.getText();
            String d = ftxfCep.getText();
            String m = txfEmail.getText();
            String f = txfEndereco.getText();
            String g = txfNumero.getText();
            
           JOptionPane.showMessageDialog(null,"Fornecedor cadastrado no SistCad! \n\n"+" R.Social: "+a+"\n CNPJ: "+b+"\n Telefone: "+c+"\n E-mail: "+m+"\n CEP: "+d+"\n Endereço: "+f+"\n Nº "+g+"\n","Fornecedor cadastrado",1);
        }
        if(e.getSource()==btnDescartar){
            txfRSocial  .setText("");
            txfNumero   .setText("");
            txfEmail    .setText("");
            txfEndereco .setText("");
            ftxfCnpj    .setText("");
            ftxfCep     .setText("");
            ftxfTelefone.setText("");
        }
        }
    
    public FormFornec(){
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
    MaskCnpj         =new MaskFormatter("##.###.###/####-##");
    maskCep         =new MaskFormatter("#####-###");
    maskTelefone    =new MaskFormatter("(##)#####-####");
    
    MaskCnpj        .setPlaceholderCharacter('_');
    maskCep         .setPlaceholderCharacter('_');
    maskTelefone    .setPlaceholderCharacter('_');
    }
    catch(ParseException excp){}
    ftxfCnpj         =new JFormattedTextField(MaskCnpj);
    ftxfCep         =new JFormattedTextField(maskCep);
    ftxfTelefone    =new JFormattedTextField(maskTelefone);
    
    //btn Positions
    lblTitulo   .setBounds(gW*7,    gH,    wWidth+(gW*15), btnH*2);
    lblRSocial  .setBounds(gW*3+3,  gH*9,  wWidth,        btnH);
    txfRSocial  .setBounds(gW*10,   gH*9,  wWidth+30,     btnH);
    lblCNPJ     .setBounds(gW*5+1,  gH*13, wWidth,        btnH);
    ftxfCnpj    .setBounds(gW*10,   gH*13, wWidth-100,    btnH);
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
    telaCliente     .add(lblCNPJ);      telaCliente     .add(ftxfCnpj);
    telaCliente     .add(lblCEP);       telaCliente     .add(ftxfCep);
    telaCliente     .add(lblTelefone);  telaCliente     .add(ftxfTelefone);
    telaCliente     .add(lblRSocial);   telaCliente     .add(txfRSocial);
    telaCliente     .add(lblEndereco);  telaCliente     .add(txfEndereco);
    telaCliente     .add(lblNumero);    telaCliente     .add(txfNumero);
    telaCliente     .add(lblEmail);     telaCliente     .add(txfEmail);
    telaCliente     .add(btnEnviar);    telaCliente     .add(btnSair);      telaCliente     .add(btnDescartar);
    
    //Buttons Events
    btnSair.addActionListener(this);
    btnEnviar.addActionListener(this);
    btnDescartar.addActionListener(this);
    
    //lbl/txf Styles
      Color	ColorsItems = new Color(46,61,78),
                ColorBg     = new Color(99,134,169),
                Colortxb    = new Color(78,108,138);
    
    lblTitulo   .setFont(new Font("SansSerif", Font.BOLD, 25));
    lblTitulo   .setForeground( ColorsItems);
    
    lblTitulo   .setForeground(ColorsItems);
    lblRSocial  .setForeground(ColorsItems);
    lblCNPJ     .setForeground(ColorsItems);
    lblCEP      .setForeground(ColorsItems);
    lblEndereco .setForeground(ColorsItems);
    lblNumero   .setForeground(ColorsItems);
    lblTelefone .setForeground(ColorsItems);
    lblEmail    .setForeground(ColorsItems);
    txfRSocial  .setForeground(ColorsItems);
    txfNumero   .setForeground(ColorsItems);
    txfEmail    .setForeground(ColorsItems);
    txfEndereco .setForeground(ColorsItems);
    ftxfCnpj    .setForeground(ColorsItems);
    ftxfCep     .setForeground(ColorsItems);
    ftxfTelefone.setForeground(ColorsItems);
    
    
    
    btnSair     .setBackground(null);
    btnEnviar   .setBackground(null);
    btnDescartar.setBackground(null);
    
    btnSair     .setBorder(null);
    btnEnviar   .setBorder(null);
    btnDescartar.setBorder(null);
    
    txfRSocial  .setBorder(null);
    txfNumero   .setBorder(null);
    txfEmail    .setBorder(null);
    txfEndereco .setBorder(null);
    ftxfCnpj    .setBorder(null);
    ftxfCep     .setBorder(null);
    ftxfTelefone.setBorder(null);
           
    
    telaCliente .setBackground(ColorBg);
    
    txfRSocial  .setBackground(Colortxb);
    txfNumero   .setBackground(Colortxb);
    txfEmail    .setBackground(Colortxb);
    txfEndereco .setBackground(Colortxb);
    ftxfCnpj    .setBackground(Colortxb);
    ftxfCep     .setBackground(Colortxb);
    ftxfTelefone.setBackground(Colortxb);
    
    
    setVisible(true);
    setSize(400,400);
    setLocationRelativeTo(null);

}    
}