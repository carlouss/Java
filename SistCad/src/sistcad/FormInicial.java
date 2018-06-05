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
        if(e.getSource()==btnCadUser){
        FormUsuario app1 = new FormUsuario();
        app1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    wWidth  = btnW*5+gW*7,
                    wHeight = btnH*8+gH*11;
    
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
    btnCadUser.addActionListener(this);
    
    //remove borders
    btnCadUser  .setBorder(null);
    btnCadProd  .setBorder(null);
    btnCliente  .setBorder(null);
    btnCadFornec.setBorder(null);
    btnSair     .setBorder(null);
    
    //Buttons Colors
    btnCadUser  .setBackground(Color.lightGray);
    btnCadProd  .setBackground(Color.lightGray);
    btnCliente  .setBackground(Color.lightGray);
    btnCadFornec.setBackground(Color.lightGray);
    btnSair     .setBackground(Color.lightGray);
    lblTitulo   .setForeground( new Color(46,61,78));
    
    lblTitulo   .setFont(new Font("SansSerif", Font.BOLD, 40));
    
    //bg color
    telaInicial .setBackground(Color.lightGray);
    
    setVisible(true);
    setSize(305,400);
    setLocationRelativeTo(null);
    }
}
