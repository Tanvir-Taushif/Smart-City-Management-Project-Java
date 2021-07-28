package smart.city.management;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class bankManagement{
    String sql;
    int money;
    bankManagement(String datapass,int bank){
        JFrame frame=new JFrame("Brittia Bank");
        Font font=new Font("Arial",Font.BOLD,15);
        JLabel cash=new JLabel("Deposit Money: ");
        cash.setBounds(10, 80, 150, 30);
        cash.setFont(font);
        JLabel amount=new JLabel("Balance: ");
        amount.setBounds(10, 140, 150, 30);
        amount.setFont(font);
        cash.setForeground(Color.blue);
        amount.setForeground(Color.blue);
        JTextField depo=new JTextField();
        depo.setBounds(165,80,150,30);
        JTextField am=new JTextField();
        am.setBounds(165,140,150,30);
        JButton deposit=new JButton("Deposit");
        deposit.setBounds(330, 80, 80, 30);
        JButton view=new JButton("View");
        view.setBounds(330, 140, 80, 30);
        JButton back=new JButton("Back");
        back.setBounds(190, 200, 80, 30);
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        deposit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String url="jdbc:mysql://localhost:3306/smart_city";
          String password=datapass;
          String user="root";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           int mn=Integer.valueOf(depo.getText());
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           sql="update bank set Balance="+(money+mn)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Cash Deposit Successfull");
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        view.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
          am.setText(String.valueOf(money));
           }
       });
        frame.setSize(500, 300);
        frame.add(cash);
        frame.add(depo);
        frame.add(deposit);
        frame.add(amount);
        frame.add(am);
        frame.add(view);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Hospital{
    int money;
    Hospital(String datapass,int bank){
       JFrame frame=new JFrame("Brittia Hospital");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Brittia Hospital");
        JLabel label=new JLabel("Emergency Bed Book Fees(100$)");
        JLabel num=new JLabel("Contact No: 01234567891");
        JButton pay=new JButton("Pay");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        label.setFont(font);
        label.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        label.setBounds(20,110,280,30);
        pay.setBounds(330,110,80,30);
        back.setBounds(200,200,80,30);
        pay.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root",sql="";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           if(money<100){
               JOptionPane.showMessageDialog(null,"Not enough money on your account");
           }
           else{
           sql="update bank set Balance="+(money-100)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Process Complete");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(500, 300);
        frame.add(name);
        frame.add(num);
        frame.add(label);
        frame.add(pay);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Restaurant{
    int money;
    Restaurant(String datapass,int bank){
       JFrame frame=new JFrame("Brittia Restaurant");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Brittia Restaurant");
        JLabel label=new JLabel("Food Delivary Charge (80$)");
        JLabel num=new JLabel("Contact No: 01234567892");
        JButton pay=new JButton("Pay");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        label.setFont(font);
        label.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        label.setBounds(20,110,280,30);
        pay.setBounds(330,110,80,30);
        back.setBounds(200,200,80,30);
        pay.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root",sql="";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           if(money<80){
               JOptionPane.showMessageDialog(null,"Not enough money on your account");
           }
           else{
           sql="update bank set Balance="+(money-80)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Process Complete");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(500, 300);
        frame.add(name);
        frame.add(num);
        frame.add(label);
        frame.add(pay);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Transport{
    int money;
    Transport(String datapass,int bank){
       JFrame frame=new JFrame("Brittia Metro");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Brittia Metro");
        JLabel label=new JLabel("Buy Ticket (40$)");
        JLabel num=new JLabel("Contact No: 01234567893");
        JButton pay=new JButton("Pay");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        label.setFont(font);
        label.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        label.setBounds(20,110,280,30);
        pay.setBounds(330,110,80,30);
        back.setBounds(200,200,80,30);
        pay.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root",sql="";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           if(money<40){
               JOptionPane.showMessageDialog(null,"Not enough money on your account");
           }
           else{
           sql="update bank set Balance="+(money-40)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Process Complete");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(500, 300);
        frame.add(name);
        frame.add(num);
        frame.add(label);
        frame.add(pay);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Rent{
    int money;
    Rent(String datapass,int bank){
       JFrame frame=new JFrame("Brittia Housing");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Brittia Housing");
        JLabel label=new JLabel("Rent House(250$)");
        JLabel num=new JLabel("Contact No: 01234567894");
        JButton pay=new JButton("Pay");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        label.setFont(font);
        label.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        label.setBounds(20,110,280,30);
        pay.setBounds(330,110,80,30);
        back.setBounds(200,200,80,30);
        pay.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root",sql="";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           if(money<250){
               JOptionPane.showMessageDialog(null,"Not enough money on your account");
           }
           else{
           sql="update bank set Balance="+(money-250)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Process Complete");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(500, 300);
        frame.add(name);
        frame.add(num);
        frame.add(label);
        frame.add(pay);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Edu{
    int money;
    Edu(String datapass,int bank){
       JFrame frame=new JFrame("Brittia University");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Brittia University");
        JLabel label=new JLabel("Semester Fee (120$)");
        JLabel num=new JLabel("Contact No: 01234567895");
        JButton pay=new JButton("Pay");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        label.setFont(font);
        label.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        label.setBounds(20,110,280,30);
        pay.setBounds(330,110,80,30);
        back.setBounds(200,200,80,30);
        pay.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root",sql="";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           if(money<120){
               JOptionPane.showMessageDialog(null,"Not enough money on your account");
           }
           else{
           sql="update bank set Balance="+(money-120)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Process Complete");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(500, 300);
        frame.add(name);
        frame.add(num);
        frame.add(label);
        frame.add(pay);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Tour{
    int money;
    Tour(String datapass,int bank){
       JFrame frame=new JFrame("Austrasia Beach");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Austrasia Beach");
        JLabel label=new JLabel("Entry pass booking (80$)");
        JLabel num=new JLabel("Contact No: 01234567896");
        JButton pay=new JButton("Pay");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        label.setFont(font);
        label.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        label.setBounds(20,110,280,30);
        pay.setBounds(330,110,80,30);
        back.setBounds(200,200,80,30);
        pay.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root",sql="";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           sql="select  Balance from bank where Contact_No="+bank+";";
           rs=stmt.executeQuery(sql);
           while(rs.next()){
               money=rs.getInt("Balance");
           }
           if(money<80){
               JOptionPane.showMessageDialog(null,"Not enough money on your account");
           }
           else{
           sql="update bank set Balance="+(money-80)+" where Contact_No="+bank+";";
           stmt.executeUpdate(sql);
           JOptionPane.showMessageDialog(null,"Process Complete");
           }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(500, 300);
        frame.add(name);
        frame.add(num);
        frame.add(label);
        frame.add(pay);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Police{
    Police(){
        JFrame frame=new JFrame("Brittia Police");
        Font font=new Font("Arial",Font.BOLD,17);
        JLabel name=new JLabel("Brittia Police Station");
        JLabel num=new JLabel("Contact No: 01234567897");
        JButton back=new JButton("Back");
        name.setFont(font);
        name.setForeground(Color.red);
        num.setFont(font);
        num.setForeground(Color.blue);
        name.setBounds(20,30,200, 30);
        num.setBounds(20,70,250,30);
        back.setBounds(150,150,80,30);
        back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
        frame.setSize(400,250);
        frame.add(name);
        frame.add(num);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class front{
    String sql,work,place;
    int banknum;
    static JComboBox add,occ;
    JTable jt2;
    int pop_num,tourist_num;
    JScrollPane sp;
    front(String datapass,String name,String pass,int type){
        JFrame frame=new JFrame("City of Brittia");
       ImageIcon background = new ImageIcon("C:\\Users\\Asus\\Desktop\\Java Files\\Smart City Management\\images\\britiaMain.png");
       Image image=background.getImage();
       image.getScaledInstance(500,320, 0);
       frame.setContentPane(new ImagePanel(image));
       Font font=new Font("Arial",Font.BOLD,17);
       String s1[] = {"Select Your Choice","Doctor","Engineer","Police","Student","Worker","Teacher","Lawyer","Banker","Businessman","Any"};
        occ=new JComboBox(s1);
         occ.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e)
              {
                  if (e.getSource() == occ) {
                  work=occ.getSelectedItem().toString();
              }
            }
         });
         JPanel o=new JPanel();
         JPanel p=new JPanel();
         String s2[] = {"Select Your Choice","College Street","Rail Station","Utopia Junction","Airport","Austrasia Beach","Avenue 1",
                        "Avenue 2","Avenue 3","Any"};
        add=new JComboBox(s2);
         add.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e)
              {
                  if (e.getSource() == add) {
                  place=add.getSelectedItem().toString();
              }
            }
         });
        o.add(add);
        p.add(occ);
        String[][] tableData=new String[200][4];
        String column[]={"Name","Profession","Area","Contact No."};
        Font fontf=new Font("Arial",Font.BOLD,25);
        JLabel plate=new JLabel("The City of Brittia");
        plate.setFont(fontf);
        plate.setForeground(Color.red);
        plate.setBounds(400,30,400,40);
       JLabel welcome=new JLabel("Welcome "+name);
       welcome.setBounds(820, 30, 200, 30);
       welcome.setFont(font);
       welcome.setForeground(Color.black);
       JButton bank=new JButton("Bank");
       bank.setBounds(20,150,150,30);
       JButton hospital=new JButton("Hospital");
       hospital.setBounds(20,200,150,30);
       JButton restaurant=new JButton("Restaurant");
       restaurant.setBounds(20,250,150,30);
       JButton transport=new JButton("Transport");
       transport.setBounds(20,300,150,30);
       JButton rent=new JButton("Rent House");
       rent.setBounds(20,350,150,30);
       JButton edu=new JButton("Education");
       edu.setBounds(20,400,150,30);
       JButton tour=new JButton("Tourists Spots");
       tour.setBounds(20,450,150,30);
       JButton police=new JButton("Police Station");
       police.setBounds(20, 500, 150, 30);
       JButton back=new JButton("Back");
       back.setBounds(925, 500, 100, 30);
       JButton leave=new JButton("Leave City");
       leave.setBounds(925, 450, 100, 30);
       JLabel sr=new JLabel("Search Citizens ");
       JButton search=new JButton("Search");
       JButton refresh=new JButton("Refresh");
       sr.setForeground(Color.blue);
       sr.setFont(font);
       sr.setBounds(230, 160,200,30);
       o.setBounds(230,200,200,30);
       p.setBounds(440,200,200,30);
       search.setBounds(650,200,100,30);
       refresh.setBounds(760,200,100,30);
       search.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           int x=0;
           int nb;
           if(work.equals("Any") && place.equals("Any")){
               sql="select Name,Occupation,Address,Contact_No from population;";
           }
           else if(work.equals("Any")){
                sql="select Name,Occupation,Address,Contact_No from population where Address='"+place+"';";
           }
           else if(place.equals("Any")){
                sql="select Name,Occupation,Address,Contact_No from population where Occupation='"+work+"';";
           }
           else {
               sql="select Name,Occupation,Address,Contact_No from population where Occupation='"+work+"' and Address='"+place+"';";
           }
           ResultSet rs=stmt.executeQuery(sql);
           while(rs.next()){
               tableData[x][0]=rs.getString("Name");
               tableData[x][1]=rs.getString("Occupation");
               tableData[x][2]=rs.getString("Address");
               tableData[x][3]="0"+String.valueOf(rs.getInt("Contact_No"));
               x++;
           }
               jt2=new JTable(tableData,column);
               jt2.setBounds(230,250,430,300);
               sp=new JScrollPane(jt2);    
               sp.setBounds(230, 250, 430, 300);
               frame.add(sp);
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
           }
       });
       refresh.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
               new front(datapass,name,pass,type);
           }
       });
       back.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               frame.dispose();
           }
       });
       hospital.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Hospital(datapass,banknum);
           }
       });
       restaurant.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Restaurant(datapass,banknum);
           }
       });
       transport.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Transport(datapass,banknum);
           }
       });
       rent.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Rent(datapass,banknum);
           }
       });
       edu.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Edu(datapass,banknum);
           }
       });
       tour.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Tour(datapass,banknum);
           }
       });
       police.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new Police();
           }
       });
       bank.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new bankManagement(datapass,banknum);
           }
       });
       String url="jdbc:mysql://localhost:3306/smart_city";
       String password=datapass;
       String user="root";
       try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ) {
           ResultSet rs;
           pop_num=0;tourist_num=0;
           sql="select Contact_No from population where Name='"+name+"'"
                           + "and Password='"+pass+"';";
                       rs=stmt.executeQuery(sql);
                       while(rs.next()){
                         banknum=rs.getInt("Contact_No");
                       }
            sql="select Name from population;";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                pop_num++;
            }
            sql="select Name from tourists;";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                tourist_num++;
            }
           }catch (Exception x) {
                JOptionPane.showMessageDialog(null,"Error 404 not found");
                x.printStackTrace();
           }
       JLabel tot=new JLabel("Total Population: "+pop_num);
       JLabel tot_tour=new JLabel("Tourists: "+tourist_num);
       JLabel tot_city=new JLabel("Citizen: "+(pop_num-tourist_num));
       Font font2=new Font("Arial",Font.BOLD,16);
       tot.setFont(font2);
       tot_tour.setFont(font2);
       tot_city.setFont(font2);
       tot.setBounds(740, 250,150,30);
       tot_city.setBounds(740,270,150,30);
       tot_tour.setBounds(740,290,150,30);
       leave.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent x){
                   int number=0;
                   ResultSet rs;
                   try(Connection conn = DriverManager.getConnection(url,user,password);
         Statement stmt = conn.createStatement();
        ){
                       sql="select Contact_No from population where Name='"+name+"'"
                           + "and Password='"+pass+"';";
                       System.out.println(sql);
                       rs=stmt.executeQuery(sql);
                       while(rs.next()){
                         number=rs.getInt("Contact_No");
                       }
                       sql="delete from population where Contact_No="+number+";";
                       stmt.executeUpdate(sql);
                       sql="delete from bank where Contact_No="+number+";";
                       stmt.executeUpdate(sql);
                       if(type==1){
                           sql="delete from tourists where Contact_No="+number+";";
                           stmt.executeUpdate(sql);
                       }
                       else{
                           sql="delete from residents where Contact_No="+number+";";
                           stmt.executeUpdate(sql);
                       }
                       JOptionPane.showMessageDialog(null,"All Data Removed");
                       frame.dispose();
                   }catch(Exception e){System.out.println(e);}
               }
           });
       frame.add(plate);
       frame.add(tot);
       frame.add(tot_city);
       frame.add(tot_tour);
       frame.add(o);
       frame.add(p);
       frame.add(search);
       frame.add(refresh);
       frame.add(bank);
       frame.add(hospital);
       frame.add(restaurant);
       frame.add(transport);
       frame.add(rent);
       frame.add(edu);
       frame.add(tour);
       frame.add(police);
       frame.add(welcome);
       frame.add(leave);
       frame.add(back);
       frame.add(sr);
       frame.revalidate();
       frame.setSize(1060,628);
       frame.setVisible(true);
       frame.setLayout(null);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
public class controlPanel {
    controlPanel(String datapass,String nameCont,String passCont,int type){
        new front(datapass,nameCont,passCont,type);
    }
}
