package sistcad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FormInicial extends JFrame implements ActionListener {
    JButton     btnCliente,
                btnCadProd,
                btnCadUser,
                btnSair,
                btnCadFornec;        
    
    ImageIcon   User,
                Produto,
                Cliente,
                Fornecedor,
                Sair;
    
    JLabel      lblTitulo   =new JLabel ("SistCad");    
    
    //Events
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnSair){
        System.exit(0);
        }
        if(e.getSource()==btnCliente){
        FormCliente app1 = new FormCliente();
        }
        if(e.getSource()==btnCadUser){
        FormUsuario app2 = new FormUsuario();
        }
        if(e.getSource()==btnCadProd){
        FormProdutos app3 = new FormProdutos();
        }
        if(e.getSource()==btnCadFornec){
        FormFornec app4 = new FormFornec();
        }
    }
    
    public FormInicial(){
    super ("SistCad");
    Container telaInicial = getContentPane();
    setLayout(null);
    //set Grid
    int             gW      = 8,
                    gH      = 8,
                    btnW    = gW*4,
                    btnH    = 26,	
                    wWidth  = btnW*5+gW*7;
    
    //Btn Icons
    User            =new ImageIcon("User.png");
    btnCadUser      =new JButton (User);
    Produto         =new ImageIcon("Produto.png");
    btnCadProd      =new JButton (Produto);
    Cliente         =new ImageIcon("Cliente.png");
    btnCliente      =new JButton (Cliente);
    Fornecedor      =new ImageIcon("Fornecedor.png");
    btnCadFornec    =new JButton (Fornecedor);
    Sair            =new ImageIcon("Sair.png");
    btnSair         =new JButton (Sair);
    
   //btn Positions 
    lblTitulo   .setBounds(gW*9,gH, wWidth-(gW*3), btnH*2);
    btnCadUser  .setBounds(gW*2+btnW*1,gH*9, btnW*3, btnH*3);
    btnCadProd  .setBounds(gW*2+btnW*4,gH*9, btnW*3, btnH*3);
    btnCliente  .setBounds(gW*2+btnW*1,gH*20, btnW*3, btnH*3);
    btnCadFornec.setBounds(gW*2+btnW*4,gH*20, btnW*3, btnH*3);
    btnSair     .setBounds(gW*2+btnW*1,gH*31, btnW*3, btnH*3);
    
    //add buttons
    telaInicial .add(lblTitulo);
    telaInicial .add(btnCadUser);
    telaInicial .add(btnCliente);
    telaInicial .add(btnCadProd);
    telaInicial .add(btnCadFornec);
    telaInicial .add(btnSair);
    
    //Buttons Events
    btnSair.addActionListener(this);
    btnCliente.addActionListener(this);
    btnCadUser.addActionListener(this);
    btnCadProd.addActionListener(this);
    btnCadFornec.addActionListener(this);
    
    //colors
    Color	ColorsItems = new Color(46,61,78),
                ColorBg     = new Color(99,134,169);
    
    //remove borders
    btnCadUser  .setBorder(null);
    btnCadProd  .setBorder(null);
    btnCliente  .setBorder(null);
    btnCadFornec.setBorder(null);
    btnSair     .setBorder(null);
    
    //Buttons Colors
    btnCadUser  .setBackground(null);
    btnCadProd  .setBackground(null);
    btnCliente  .setBackground(null);
    btnCadFornec.setBackground(null);
    btnSair     .setBackground(null);
    lblTitulo   .setForeground(ColorsItems);
    
    lblTitulo   .setFont(new Font("SansSerif", Font.BOLD, 40));
    
    //bg color
    telaInicial .setBackground(ColorBg);
    
    setVisible(true);
    setSize(305,400);
    setLocationRelativeTo(null);
    
    }
}
