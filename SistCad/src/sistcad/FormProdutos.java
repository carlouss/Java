package sistcad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

public class FormProdutos extends JFrame implements ActionListener {
    
    JLabel          lblTitulo   =new JLabel ("Cadastro de Produtos"),
                    lblDesc     =new JLabel ("Descrição:"),
                    lblFabric   =new JLabel ("Fabricação:"),
                    lblValid    =new JLabel ("Validade:"),
                    lblLote     =new JLabel ("Lote:"),
                    lblQuant    =new JLabel ("Quantidade:"),
                    lblPreco    =new JLabel ("Preço:"),
                    lblFornec   =new JLabel ("Fornecedor:");
    
    JTextField      txfDesc     =new JTextField(),
                    txfFornec   =new JTextField(),
                    txfPreco    =new JTextField(),
                    txfQuant    =new JTextField();
    
    MaskFormatter   maskFabric,
                    maskValid,
                    maskLote;
    
    JButton         btnEnviar,
                    btnSair,
                    btnDescartar;
    
    ImageIcon       Sair,
                    Enviar,
                    Descartar;
    
    JFormattedTextField ftxfFabric,
                        ftxfValid,
                        ftxfLote;
    
    //Events
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSair){
        FormProdutos.this.dispose();
        }
        if(e.getSource()==btnEnviar){
            String a = txfDesc.getText();
            String b = ftxfFabric.getText();
            String c = ftxfValid.getText();
            String d = txfPreco.getText();
            String i = ftxfLote.getText();
            String f = txfFornec.getText();
            String g = txfQuant.getText();
            double TotalProd,qtd,preco;
            
            qtd     = new Double (txfQuant.getText());
            preco   = new Double (txfPreco.getText());
            
            TotalProd=qtd*preco;
            JOptionPane.showMessageDialog(null,"Produto cadastrado no SistCad! \n\n"+" Descrição: "+a+"\n Fabricação: "+b+"\n Validade: "+c+"\n Preço: "+d+"\n Lote: "+i+"\n Fornecedor: "+f+"\n Quantidade: "+g+"\n Total: R$"+TotalProd+"\n","Produto cadastrado",1);
        }
        if(e.getSource()==btnDescartar){
            txfDesc     .setText("");
            ftxfFabric  .setText("");
            ftxfValid   .setText("");
            txfPreco    .setText("");
            ftxfLote    .setText("");
            txfFornec   .setText("");
            txfQuant    .setText("");
        }
        }
    
    public FormProdutos(){
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
    maskFabric      =new MaskFormatter("##/##/####");
    maskValid       =new MaskFormatter("##/##/####");
    maskLote        =new MaskFormatter("#######");
    
    maskFabric         .setPlaceholderCharacter('_');
    maskValid          .setPlaceholderCharacter('_');
    }
    catch(ParseException excp){}
    ftxfFabric         =new JFormattedTextField(maskFabric);
    ftxfValid          =new JFormattedTextField(maskValid);
    ftxfLote           =new JFormattedTextField(maskLote);
    
    //btn Positions
    lblTitulo   .setBounds(gW*9,    gH,    wWidth+(gW*6), btnH*2);
    lblDesc     .setBounds(gW*2,    gH*9,  wWidth,        btnH);
    txfDesc     .setBounds(gW*10,   gH*9,  wWidth+30,     btnH);
    lblFabric   .setBounds(gW*1+3,  gH*13, wWidth,        btnH);
    ftxfFabric  .setBounds(gW*10,   gH*13, wWidth-148,    btnH);
    lblValid    .setBounds(gW*20,   gH*13, wWidth,        btnH);
    ftxfValid   .setBounds(gW*27,   gH*13, wWidth-148,    btnH);
    lblLote     .setBounds(gW*5+10, gH*17, wWidth,        btnH);
    ftxfLote    .setBounds(gW*10,   gH*17, wWidth-149,    btnH);
    lblQuant    .setBounds(gW*1+2,  gH*21, wWidth,        btnH);
    txfQuant    .setBounds(gW*10,   gH*21, wWidth-160,     btnH);
    lblPreco    .setBounds(gW*5,    gH*25, wWidth,        btnH);
    txfPreco    .setBounds(gW*10,   gH*25, wWidth-160,    btnH);
    lblFornec   .setBounds(gW*1,    gH*29, wWidth,        btnH);
    txfFornec   .setBounds(gW*10,   gH*29, wWidth-60,     btnH);
    btnEnviar   .setBounds(gW*4,   gH*35, btnW*3,         btnH*3);
    btnDescartar.setBounds(gW*19,   gH*35, btnW*3,        btnH*3);
    btnSair     .setBounds(gW*34,   gH*35, btnW*3,        btnH*3);
    
    //add buttons&labels,txf's
    telaCliente     .add(lblTitulo);
    telaCliente     .add(lblFabric); telaCliente     .add(ftxfFabric);
    telaCliente     .add(lblValid);  telaCliente     .add(ftxfValid);
    telaCliente     .add(lblLote);   telaCliente     .add(ftxfLote);
    telaCliente     .add(lblPreco);  telaCliente     .add(txfPreco);
    telaCliente     .add(lblDesc);   telaCliente     .add(txfDesc);
    telaCliente     .add(lblQuant);  telaCliente     .add(txfQuant);
    telaCliente     .add(lblFornec); telaCliente     .add(txfFornec);
    telaCliente     .add(btnEnviar); telaCliente     .add(btnSair);telaCliente     .add(btnDescartar);
    
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
    lblDesc     .setForeground(ColorsItems);
    lblFabric   .setForeground(ColorsItems);
    lblValid    .setForeground(ColorsItems);
    lblLote     .setForeground(ColorsItems);
    lblQuant    .setForeground(ColorsItems);
    lblPreco    .setForeground(ColorsItems);
    lblFornec   .setForeground(ColorsItems);
    txfDesc     .setForeground(ColorsItems);
    txfFornec   .setForeground(ColorsItems);
    txfQuant    .setForeground(ColorsItems);
    ftxfFabric  .setForeground(ColorsItems);
    ftxfValid   .setForeground(ColorsItems);
    ftxfLote    .setForeground(ColorsItems);
    txfPreco    .setForeground(ColorsItems);
    
    
    
    btnSair     .setBackground(null);
    btnEnviar   .setBackground(null);
    btnDescartar.setBackground(null);
    
    btnSair     .setBorder(null);
    btnEnviar   .setBorder(null);
    btnDescartar.setBorder(null);
    
    txfDesc     .setBorder(null);
    txfFornec   .setBorder(null);
    txfQuant    .setBorder(null);
    ftxfFabric  .setBorder(null);
    ftxfValid   .setBorder(null);
    ftxfLote    .setBorder(null);
    txfPreco    .setBorder(null);
    
    
    
    telaCliente .setBackground(ColorBg);
    txfDesc     .setBackground(Colortxb);
    txfFornec   .setBackground(Colortxb);
    txfQuant    .setBackground(Colortxb);
    ftxfFabric  .setBackground(Colortxb);
    ftxfValid   .setBackground(Colortxb);
    ftxfLote    .setBackground(Colortxb);
    txfPreco    .setBackground(Colortxb);
    
    
    setVisible(true);
    setSize(400,400);
    setLocationRelativeTo(null);

}    
}