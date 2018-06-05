package sistcad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;
import java.text.*;
import javax.swing.text.*;

public class FormUsuario extends JFrame implements ActionListener {
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
                    btnSair;
    
    ImageIcon       Sair,
                    Enviar;
    
    JFormattedTextField ftxfCpf,
                        ftxfRg,
                        ftxfCep,
                        ftxfTelefone;
    
    //Events
    @Override
    public void actionPerformed(ActionEvent e){
        
        }
public FormUsuario(){
    super ("SistCad");
    Container telaUsuario = getContentPane();
    setLayout(null);
    //set Grid
    int         gW      = 8,
                gH      = 8,
                btnW    = gW*4,
                btnH    = 26,	
                wWidth  = btnW*5+gW*7,
                wHeight = btnH*8+gH*11;
    
    //Btn Icons
    Sair            =new ImageIcon("Sair.png");
    btnSair         =new JButton (Sair);
    Enviar          =new ImageIcon("Enviar.png");
    btnEnviar       =new JButton (Enviar);
    
    //btn Positions
    lblTitulo   .setBounds(gW*9,gH, wWidth+(gW*4), btnH*2);
    
    //maks's
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
    
    //add buttons&labels,txf's
    telaUsuario     .add(lblTitulo);
    telaUsuario     .add(lblNome);
    telaUsuario     .add(lblCPF);
    telaUsuario     .add(lblRG);
    telaUsuario     .add(lblCEP);
    telaUsuario     .add(lblEndereco);
    telaUsuario     .add(lblNumero);
    telaUsuario     .add(lblTelefone);
    telaUsuario     .add(lblEmail);
    
    
    //lbl/txf Styles
    lblTitulo   .setFont(new Font("SansSerif", Font.BOLD, 25));
    lblTitulo   .setForeground( new Color(46,61,78));
    
    setVisible(true);
    setSize(400,400);
    setLocationRelativeTo(null);

}    
}