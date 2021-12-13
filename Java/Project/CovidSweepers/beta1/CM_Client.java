import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.lang.Math.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Random;

public class CM_Client extends JFrame implements ActionListener
{
   JPanel CONTENT, panel_Main, panel_Chat, panel_Top, panel_Option,panel_Mine; //����ã�� �г�
   JButton btn_Ready, btn_Exit, btn_GG, btn_BGM;//bgm���� ���
   JLabel  label_logo_CENTER, label_Timer, laClient1, laClient2, laClient3, laClient4 ,  // ���ηΰ� Ÿ�̸� �ɸ��ͻ���
      label_Flag1 , label_Flag2, label_Flag3, label_Flag4,label_leftover, label_rightclicks;  //�ֻ��, �ܿ�
   Label laClient1sub, laClient2sub, laClient3sub, laClient4sub , // �ɸ��� �ؿ� �г���
      label_Flag1_syringe1 ,label_Flag1_syringe2 ,label_Flag1_syringe3 ,label_Flag1_syringe4 ,label_Announce; //�ֻ����᰹��. ~�����Դϴ�
   JTextField textField;
   JTextArea textArea;
   JScrollPane scrollPane;

   //���� ž�ΰ�
   int port = 7777;
   String playerName, playerScore, playerIdx; // Ŭ���̾�Ʈ �̸�, ����, �ε��� ����
   boolean gameStart, auth; // ���� ���� ���� üũ & ������ ���� ����
   
   //MineSweeper ms;
   public CM_Client(){
   //   ms = new MineSweeper(this);
      // �⺻ GUI ����
      setFont(new Font("�����ٸ�����", Font.PLAIN, 13)); 
      setVisible(true);
      setResizable(false);
      setTitle("JAVA Client"); //�����̸�
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1280, 720);
      setLocationRelativeTo(null);  // �̰� �����Ű�� ��������� ����
      
      // ���̽� �г�
      CONTENT = new JPanel();
      CONTENT.setBorder(null); 
      setContentPane(CONTENT);
      CONTENT.setLayout(new BoxLayout(CONTENT, BoxLayout.X_AXIS));  // axis�� ���Ĺ�� ��>>��� ��ġ
      
      panel_Main = new JPanel();
      panel_Main.setFont(new Font("�����ٸ�����", Font.PLAIN, 13));
      panel_Main.setBackground(new Color(255, 255, 255));
      CONTENT.add(panel_Main);
      panel_Main.setLayout(null);

      // ������ ��� ����
      JPanel panelCList = new JPanel();
      JLabel label_ClientList = new JLabel(new ImageIcon("image\\user.png"));
     JLabel label_ClientList1 = new JLabel(new ImageIcon("image\\user.png"));

      panelCList.setOpaque(false);
      label_ClientList.setOpaque(false);
     label_ClientList1.setOpaque(false);
      panelCList.setBorder(new LineBorder(new Color(255, 164, 38 ), 2, true)); //setborder ��������,�÷�����
      panelCList.setBounds(10, 105, 300, 500);
      label_ClientList.setBounds(-65, 105, 312, 500);
     label_ClientList1.setBounds(75, 105, 312, 500);
      panel_Main.add(panelCList);
      panel_Main.add(label_ClientList);
     panel_Main.add(label_ClientList1);
      panelCList.setLayout(null);
   
     // �ֻ��׸� ����  
     label_Flag1 = new JLabel(new ImageIcon("image\\RS.jpg"));
      label_Flag1.setBackground(Color.GRAY);
      label_Flag1.setBounds(160, 15, 120, 80);
      panelCList.add(label_Flag1);

     label_Flag2 = new JLabel(new ImageIcon("image\\PS.jpg"));
      label_Flag2.setBackground(Color.GRAY);
      label_Flag2.setBounds(160, 135, 120, 80);
      panelCList.add(label_Flag2);

     label_Flag3 = new JLabel(new ImageIcon("image\\BS.jpg"));
      label_Flag3.setBackground(Color.GRAY);
      label_Flag3.setBounds(160, 250, 120, 80);
      panelCList.add(label_Flag3);

      label_Flag4 = new JLabel(new ImageIcon("image\\YS.jpg"));
      label_Flag4.setBackground(Color.GRAY);
      label_Flag4.setBounds(160, 375, 120, 80);
      panelCList.add(label_Flag4);
     
     //���᰹�� ���� (�ֻ�� �׸� �Ʒ� ��ġ)
     label_Flag1_syringe1 = new Label("[ ���᰹�� ]");
      label_Flag1_syringe1.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      label_Flag1_syringe1.setAlignment(Label.CENTER);
      label_Flag1_syringe1.setBackground(Color.WHITE);
      label_Flag1_syringe1.setBounds(160, 95, 120, 30);
      panelCList.add(label_Flag1_syringe1);
     
     label_Flag1_syringe2 = new Label("[ ���᰹�� ]");
      label_Flag1_syringe2.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      label_Flag1_syringe2.setAlignment(Label.CENTER);
      label_Flag1_syringe2.setBackground(Color.WHITE);
      label_Flag1_syringe2.setBounds(160, 215, 120, 30);
      panelCList.add(label_Flag1_syringe2);
      
     label_Flag1_syringe3 = new Label("[ ���᰹�� ]");
      label_Flag1_syringe3.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      label_Flag1_syringe3.setAlignment(Label.CENTER);
      label_Flag1_syringe3.setBackground(Color.WHITE);
      label_Flag1_syringe3.setBounds(160, 335, 120, 30);
      panelCList.add(label_Flag1_syringe3);
      
     label_Flag1_syringe4 = new Label("[ ���᰹�� ]");
      label_Flag1_syringe4.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      label_Flag1_syringe4.setAlignment(Label.CENTER);
      label_Flag1_syringe4.setBackground(Color.WHITE);
      label_Flag1_syringe4.setBounds(160, 455, 120, 30);
      panelCList.add(label_Flag1_syringe4);

      // ������ ����
      laClient1 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient1.setBackground(Color.GRAY);
      laClient1.setBounds(21, 15, 120, 80);
      panelCList.add(laClient1);
      
      laClient1sub = new Label("[ �г��� ]");
      laClient1sub.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      laClient1sub.setAlignment(Label.CENTER);
      laClient1sub.setBackground(Color.WHITE);
      laClient1sub.setBounds(18, 95, 120, 30);
      panelCList.add(laClient1sub);
      
      laClient2 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient2.setBackground(Color.GRAY);
      laClient2.setBounds(21, 135, 120, 80);
      panelCList.add(laClient2);
      
      laClient2sub = new Label("[ �г��� ]");
      laClient2sub.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      laClient2sub.setAlignment(Label.CENTER);
      laClient2sub.setBackground(Color.WHITE);
      laClient2sub.setBounds(18, 215, 120, 30);
      panelCList.add(laClient2sub);
      
      laClient3 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient3.setBackground(Color.GRAY);
      laClient3.setBounds(21, 255, 120, 80);
      panelCList.add(laClient3);
      
      laClient3sub = new Label("[ �г��� ]");
      laClient3sub.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      laClient3sub.setAlignment(Label.CENTER);
      laClient3sub.setBackground(Color.WHITE);
      laClient3sub.setBounds(18, 335, 120, 30);
      panelCList.add(laClient3sub);
      
      laClient4 = new JLabel(new ImageIcon("image\\waiting.png"));
      laClient4.setBackground(Color.GRAY);
      laClient4.setBounds(21, 375, 120, 80);
      panelCList.add(laClient4);
      
      laClient4sub = new Label("[ �г��� ]");
      laClient4sub.setFont(new Font("�����ٸ�����", Font.BOLD, 13));
      laClient4sub.setAlignment(Label.CENTER);
      laClient4sub.setBackground(Color.WHITE);
      laClient4sub.setBounds(18, 455, 120, 30);
      panelCList.add(laClient4sub);
      
      // covid sweeper
      panel_Top = new JPanel();
      panel_Top.setBounds(10, 10, 1245, 85);
      panel_Main.add(panel_Top);
      panel_Top.setLayout(null);
      
      JLabel Top_Background = new JLabel(new ImageIcon("image\\topbg.png")); // top Background
      Top_Background.setOpaque(true);// ���� ����
      Top_Background.setBounds(0, 0, 1245, 85);
      panel_Top.add(Top_Background);
      panel_Top.setLayout(null);
      
      label_logo_CENTER = new JLabel(new ImageIcon("image\\toplogo.png")); //  logo covid sweepers
      label_logo_CENTER.setOpaque(false);
      label_logo_CENTER.setBounds(300, 10, 700, 85);
      Top_Background.add(label_logo_CENTER);

      
      // ���� ��ư ����
      btn_Ready = new JButton(new ImageIcon("image\\ready1.png"));
     btn_Ready.setPressedIcon(new ImageIcon("image\\readyd.png"));
      btn_Ready.setFocusPainted(false);
      btn_Ready.setBorderPainted(false);
      btn_Ready.setContentAreaFilled(false);
      btn_Ready.setBounds(991, 11, 115, 65);
      Top_Background.add(btn_Ready);
      btn_Ready.addActionListener(this);
      
      btn_Exit = new JButton(new ImageIcon("image\\close1.png"));
      btn_Exit.setPressedIcon(new ImageIcon("image\\closed.png"));
      btn_Exit.setFocusPainted(false);
      btn_Exit.setBorderPainted(false);
      btn_Exit.setContentAreaFilled(false);
      btn_Exit.setBounds(1118, 11, 115, 65);
      Top_Background.add(btn_Exit);
      btn_Exit.addActionListener(this); // aaddActionListener(this) �־���� ��ư ������ �����
      
      // �ΰ� ����
      JLabel label_logo_left = new JLabel(new ImageIcon("image\\leftover.png"));
      label_logo_left.setOpaque(false);
      label_logo_left.setBorder(null);
      label_logo_left.setBounds(10, 10, 120, 65);
      label_leftover = new JLabel("N"); //���̷��� ��
      label_leftover.setHorizontalTextPosition(SwingConstants.CENTER);
      label_leftover.setHorizontalAlignment(SwingConstants.CENTER);
      label_leftover.setFont(new Font("�����ٸ�����", Font.PLAIN, 30));
      label_leftover.setForeground(Color.BLACK);
      label_leftover.setBounds(10, 10, 120, 65);
      Top_Background.add(label_leftover);
      Top_Background.add(label_logo_left);

      JLabel label_logo_right = new JLabel(new ImageIcon("image\\leftover1.png"));
      label_logo_right.setOpaque(false);
      label_logo_right.setBorder(null);
      label_logo_right.setBounds(170, 10, 120, 65);
      label_rightclicks = new JLabel("N"); //�ܿ� ���̷��� ��
      label_rightclicks.setHorizontalTextPosition(SwingConstants.CENTER);
      label_rightclicks.setHorizontalAlignment(SwingConstants.CENTER);
      label_rightclicks.setFont(new Font("�����ٸ�����", Font.PLAIN, 30));
      label_rightclicks.setForeground(Color.BLACK);
      label_rightclicks.setBounds(170, 10, 120, 65);
      Top_Background.add(label_rightclicks);
      Top_Background.add(label_logo_right);

      // ä�� ����
      panel_Chat = new JPanel();
      panel_Chat.setBounds(992, 105, 263, 567);
      panel_Main.add(panel_Chat);
      panel_Chat.setLayout(null);
      
      scrollPane = new JScrollPane(textArea);
      scrollPane.setFont(new Font("�����ٸ�����", Font.PLAIN, 13));
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(0, 0, 263, 535);
      panel_Chat.add(scrollPane);
      
      textArea = new JTextArea();
      textArea.setBorder(new LineBorder(new Color(255, 164, 38), 2, true));
      textArea.setFont(new Font("�����ٸ�����", Font.PLAIN, 13));
      textArea.setEditable(false);
      textArea.setLineWrap(true);
      scrollPane.setViewportView(textArea);
      textArea.setBackground(Color.WHITE);
      
      textField = new JTextField();
      textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
      textField.setBackground(Color.WHITE);
      textField.setBounds(0, 537, 263, 30);
      panel_Chat.add(textField);
      textField.setColumns(10);

 /*---2021-12-13 ������ 15*15 ����, ������ ��ġ�� ũ�� ����---*/
     panel_Mine = new JPanel(new GridLayout(15,15)); //������ 15*15
     panel_Mine.setBounds(345,105,575,575);
      panel_Main.add(panel_Mine);
     prepareField(); //����ã�� �����ʵ带 �ʱ�ȭ �ϴ� �޼ҵ� ȣ��

     //�����ϴܺκ� (Ÿ�̸�, BGM��ư)
      panel_Option = new JPanel();
      panel_Option.setOpaque(true);
      panel_Option.setBackground(Color.WHITE);
      panel_Option.setBounds(7, 615, 305, 57);
      panel_Main.add(panel_Option);
      panel_Option.setLayout(null);
   
      JLabel label_Timer_Back = new JLabel(new ImageIcon("image\\time.png"));
      label_Timer_Back.setOpaque(true);
      label_Timer = new JLabel("00 : 30");
      label_Timer.setHorizontalTextPosition(SwingConstants.CENTER);
      label_Timer.setHorizontalAlignment(SwingConstants.CENTER);
      label_Timer.setFont(new Font("�����ٸ�����", Font.PLAIN, 24));
      label_Timer.setForeground(Color.black);
      label_Timer_Back.setBounds(0, 0, 158, 57);
      label_Timer.setBounds(0, 10, 158, 57);
      panel_Option.add(label_Timer_Back);
      label_Timer_Back.add(label_Timer);

      btn_BGM = new JButton(new ImageIcon("image\\bgmOff.png"));
      btn_BGM.setPressedIcon(new ImageIcon("image\\bgmOn.png"));
      btn_BGM.setFocusPainted(false);
      btn_BGM.setBorderPainted(false);
      btn_BGM.setContentAreaFilled(false);
      btn_BGM.setBounds(155, 0, 152, 57);
      panel_Option.add(btn_BGM);
      btn_BGM.addActionListener(this);


      startChat();
   }
  
   public void startChat(){
      String nickName = CM_Login.nickName;
      String ip = CM_Login.ip;

      try{
         Socket s = new Socket(ip, port);
         Sender sender = new Sender(s, nickName);
         Listener listener = new Listener(s);
         new Thread(sender).start();
         new Thread(listener).start();
         
         //�̺�Ʈ �߰� 
         textField.addKeyListener(new Sender(s, nickName));
         btn_Ready.addActionListener(new Sender(s, nickName));

      }catch(UnknownHostException uh){
         JOptionPane.showMessageDialog(null, "ȣ��Ʈ�� ã�� �� �����ϴ�!", "ERROR", JOptionPane.WARNING_MESSAGE);
      }catch(IOException io){
         JOptionPane.showMessageDialog(null, "���� ���� ����!\n������ ���� �ִ� �� �����ϴ�.", "ERROR", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }
   }


   // ���� Ŭ���� �۽�
   class Sender extends Thread implements KeyListener, ActionListener
   {
      DataOutputStream dos;
      Socket s;
      String nickName;

      Sender(Socket s, String nickName){
         this.s = s;
         try{
            dos = new DataOutputStream(this.s.getOutputStream());
            this.nickName = nickName;
         }catch(IOException io){}
      }

      public void run(){
         try{
            dos.writeUTF(nickName);
         }catch(IOException io){}
      }

      public void audio() { 
         try { 
            File file = new File("bgm/bgm.mp3"); 
            Clip clip = AudioSystem.getClip(); 
            clip.open(AudioSystem.getAudioInputStream(file)); 
            clip.start();
         }catch(Exception e){
            //System.out.println("put wav file");
         }
      }
      //���� 
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn_Ready){ // '�غ�' ��ư
            try{
               dos.writeUTF("//Chat " + "[ " + nickName + " �� �غ� �Ϸ� ! ]");
               dos.flush();
               dos.writeUTF("//Ready");
               dos.flush();
               btn_Ready.setEnabled(false);
            }catch(IOException io){}
         }else if(e.getSource() == btn_BGM){
               audio();
         }
      }

     public void keyReleased(KeyEvent e){ // ä�� �Է�
         if(e.getKeyCode() == KeyEvent.VK_ENTER){
            String chat = textField.getText();
            textField.setText("");
            try{
               dos.writeUTF("//Chat " + nickName + " : " + chat);
               dos.flush();
            }catch(IOException io){}
         }
      }
      public void keyTyped(KeyEvent e){}
      public void keyPressed(KeyEvent e){}
   }
   
   // ���� Ŭ���� - ����
   class Listener extends Thread 
   {
      Socket s;
      DataInputStream dis;

      Listener(Socket s){
         this.s = s;
         try{
            dis = new DataInputStream(this.s.getInputStream());
         }catch(IOException io){}
      }
      public void run(){
         while(dis !=null ){
            try{
               String msg = dis.readUTF();

               if(msg.startsWith("//CList")){ // ���ɾ� : Ŭ���̾�Ʈ ��� ����
                  playerName = msg.substring(7, msg.indexOf(" "));
                  playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
                  playerIdx = msg.substring(msg.indexOf("#") + 1);
                  updateClientList(); // Ŭ���̾�Ʈ ��� ����
               }else if(msg.startsWith("//Start")){ // ���ɾ� : ���� ���� ( + Ÿ�̸�)
                 try {
                 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
              }
              catch (Exception e) {
                 System.out.println(e);
              }
                 prepareField();
                  start1();
                  gameStart = true;
               }else if(msg.equals("//GmGG ")){ // ���ɾ� : ������ ���� ����
                  gameStart = false;
                  auth = false;
                  textField.setEnabled(true);
                  btn_Ready.setEnabled(true);
               }else if(msg.equals("//GmEnd")){ // ���ɾ� : ���� ����
                 showFullField();
                  gameStart = false;
                  auth = false;
                  textField.setEnabled(true);
                  btn_Ready.setEnabled(true);
                  label_Timer.setText("00 : 00");
               }else if(msg.startsWith("//Mouse")){
                  if(auth == false){
                     int tempX = Integer.parseInt(msg.substring(7, msg.indexOf("."))); 
                     int tempY = Integer.parseInt(msg.substring(msg.indexOf(".") + 1));
                  }
               }else if(msg.startsWith("//Timer")){ // ���ɾ� : Ÿ�̸� �ð� ǥ��
                  label_Timer.setText(msg.substring(7));
               /*}else if(msg.equals("@@gameStart")){ 
                  //start1();  // new MineSweeper().*/
            }else{ // �Ϲ� ä�� ���
                  textArea.append(msg + "\n");
                  scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
               }
            }catch(IOException io){}
         }
      }
   }
   
   public void updateClientList(){ // Ŭ���̾�Ʈ ��� �߰�
         ImageIcon ii;
         if(Integer.parseInt(playerIdx) == 0){
            ii = new ImageIcon("image\\RC.png");
            ii.getImage().flush();
            laClient1.setIcon(ii);
            laClient1sub.setText("[" + playerName + "]");
            deleteClientList();
         }else if(Integer.parseInt(playerIdx) == 1){
            ii = new ImageIcon("image\\PC.png");
            ii.getImage().flush();
            laClient2.setIcon(ii);
            laClient2sub.setText("[" + playerName +  "]");
            deleteClientList();
         }else if(Integer.parseInt(playerIdx) == 2){
            ii = new ImageIcon("image\\BC.png");
            ii.getImage().flush();
            laClient3.setIcon(ii);
            laClient3sub.setText("[" + playerName + "]");
            deleteClientList();
         }else if(Integer.parseInt(playerIdx) == 3){
            ii = new ImageIcon("image\\YC.png");
            ii.getImage().flush();
            laClient4.setIcon(ii);
            laClient4sub.setText("[" + playerName + "]");
            deleteClientList();
         }
      }
      
      public void deleteClientList(){ // Ŭ���̾�Ʈ ��� ����
         ImageIcon ii2;
         ii2 = new ImageIcon("image\\p0.png");
         if(Integer.parseInt(playerIdx) == 0){
            laClient2.setIcon(ii2);
            laClient2sub.setText("[ �г��� ]");
            laClient3.setIcon(ii2);
            laClient3sub.setText("[ �г��� ]");
            laClient4.setIcon(ii2);
            laClient4sub.setText("[ �г��� ]");
         }else if(Integer.parseInt(playerIdx) == 1){
            laClient3.setIcon(ii2);
            laClient3sub.setText("[ �г��� ]");
            laClient4.setIcon(ii2);
            laClient4sub.setText("[ �г��� ]");
         }else if(Integer.parseInt(playerIdx) == 2){
            laClient4.setIcon(ii2);
            laClient4sub.setText("[ �г��� ]");
         }
      }
      
      int rows=15; int cols=15; int mines=44; //���� �� 
      int score =0;//����
      int tot=0; //�ֺ��� ���ڰ��� ���� ǥ��
      int leftMines=mines; //�ܿ� ���ڰ���
      
      Cell userField[][] = new Cell[15][15]; //����ڿ��� ǥ�õǴ� �ʵ�
      Cell gameField[][] = new Cell[15][15]; // ����ڰ� �� �� ���� �����ʵ�
     
      Cell selected ; //������ �� ������

      public void start1() {
        for(int i=0;i<rows;i++) {
          for(int j=0;j<cols;j++) {
            userField[i][j].setEnabled(true);
          }
        }
      }//end for start();
      
      void initFields() {
        panel_Mine.removeAll(); //����ã�� ������ �ö󰡴� �г� ���� �ʱ�ȭ
        for(int i =0;i<rows;i++) {
          for(int j=0;j<cols;j++) {
            //Cell Ÿ������ �����ʵ�, �����ʵ� ����
            gameField[i][j]=new Cell();
            userField[i][j]=new Cell();
/*---2021-12-13 ��Ʈ ũ�� ����, ��ư ���� ��Ȳ�� ����---*/
            gameField[i][j].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));
            userField[i][j].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));
            userField[i][j].setBackground(new Color(255,196,116));
            
            panel_Mine.add(userField[i][j]); //����� �ʵ常 ȭ�鿡 ���̰� �гο� �ø�
            userField[i][j].addActionListener(this);
            userField[i][j].setEnabled(false);
          } //end for j
          //���� ���� �ʱ�ȭ
          score=0;
          leftMines=mines; //�� ���ڰ��� �ʱ�ȭ
          //label_leftover = new JLabel(); //���̷��� ��
          label_leftover.setText(Integer.toString(mines));
          panel_Mine.validate();
        }//end for i
      }//end of initFields()
      
       private void showFullField(){
         for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
               if(!userField[row][col].isClicked()){   
                  userField[row][col].setType(gameField[row][col].getType());   
                  userField[row][col].setValue(gameField[row][col].getValue());
                  userField[row][col].setClicked(true);                  
                  gameField[row][col].setClicked(true);   
                  if(userField[row][col].getType() == 'm'){   
/*---2021-12-13 [���� ��ź ���� : ȸ��, ��輱: ������]--*/
                     userField[row][col].setBackground(new Color(127,127,127));//��ź ������ ȸ��
                     LineBorder bb= new LineBorder(new Color(0,0,0));//��ź�� ��輱 �������ֱ�
                     
                     ImageIcon icon = new ImageIcon("image\\virus.png");
                     Image img=icon.getImage();
                     Image changeImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                     ImageIcon changeIcon = new ImageIcon(changeImg);
                     userField[row][col].setIcon(changeIcon);
                     //userField[row][col].setText("*");                  
                  }else if(userField[row][col].getType() == 'e'){   
/*---2021-12-13 [����  ���� : ���], ��Ʈ ũ�� ����--*/
                     userField[row][col].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));
                     userField[row][col].setBackground(new Color(255,255,255));//������ ���
                     
                     userField[row][col].setText("");                  
                  }else if(userField[row][col].getType() == 'f'){   
/*---2021-12-13 [����  ���� : ���], ��Ʈ ũ�� ����--*/
                     userField[row][col].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));
                     
                     userField[row][col].setText("B");
                  }else{
/*---2021-12-13 [����  ���� : ���], ��Ʈ ũ�� ����--*/
                     userField[row][col].setBackground(new Color(255,255,255));//������ ���
                     
                     userField[row][col].setText(String.valueOf(gameField[row][col].getValue()));
                  }
                  userField[row][col].setEnabled(false);   
                  
               }
            }
         }
      }
      
      int isAMine(int row, int col) {
         if(row<rows &&col<cols &&col>=0 &&row>=0) {
            if(gameField[row][col].getType()=='m') {
              return 1;
            }
            return 0;
         }//end of if-��ȿ������
         return 0;
       }
      
       int nearMines(int row, int col) {
         int tot=0;
         if(row<rows &&col<cols &&col>=0 &&row>=0) {
          tot += isAMine(row-1,col);         
          tot += isAMine(row-1,col-1);         
          tot += isAMine(row+1,col);         
          tot += isAMine(row+1,col-1);   
          tot += isAMine(row,col-1);         
          tot += isAMine(row,col+1);
          tot += isAMine(row-1,col+1);
          tot += isAMine(row+1,col+1);
          }
          return tot;
        }//end of nearMines()

 /*---2021-12-13 ���ڰ��� minse ��ŭ ���� �����--*/
       void prepareField() {
          int makemine =mines;//makemine=44
          int row, col;
          Random ran=new Random();
          initFields();
          while(makemine-->0) { //makemine ���� 0�� �ɶ�����
             row= ran.nextInt(rows); 
             col=ran.nextInt(cols);
             
             if(gameField[row][col].getType()=='m') {//�̹� ����Ÿ���̶��
                makemine++; //makemine �� �����ؼ� --> ���ڼ� �̴� ���� �ʰ� �������
             }
             if(gameField[row][col].getType()!='m') {//���ڰ� �ƴ϶��
                gameField[row][col].setType('m'); //���� �����
             }
          };
          
          for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
               if(gameField[i][j].getType()!='m') {
                 if(nearMines(i,j)!=0) {
                   gameField[i][j].setType('n');
                   gameField[i][j].setValue(nearMines(i,j));
                 }
               }
            }//end for j
          }//end for i
        }//end for prepaerField
        
        void checkEmptyCell(int row, int col) {
          if(row<rows && col<cols && col>= 0 && row>=0){
            if(!gameField[row][col].isClicked() && !userField[row][col].isClicked() && gameField[row][col].getType() == 'e'){
/*---2021-12-13 ��Ʈ ũ�� ����--*/
               userField[row][col].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));   
               
               userField[row][col].setClicked(true);         
               userField[row][col].setType('e');                              
               userField[row][col].setValue(' ');            
               userField[row][col].setText("");            
               userField[row][col].setEnabled(false);         
               gameField[row][col].setClicked(true);
               checkEmptyCell(row - 1, col - 1);            
               checkEmptyCell(row, col - 1);
               checkEmptyCell(row + 1, col - 1);
               checkEmptyCell(row - 1, col);
               checkEmptyCell(row + 1, col);
               checkEmptyCell(row -1, col + 1);
               checkEmptyCell(row, col + 1);
               checkEmptyCell(row + 1, col + 1);

            }else if(gameField[row][col].getType() == 'n' && gameField[row][col].getValue() != 0 && !gameField[row][col].isClicked() && !userField[row][col].isClicked()){ 
/*---2021-12-13 ��Ʈ ũ�� ����--*/
               userField[row][col].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));   
               
               userField[row][col].setType(gameField[row][col].getType());         
               userField[row][col].setValue(gameField[row][col].getValue());      
               userField[row][col].setClicked(true);                        
               gameField[row][col].setClicked(true);   
               userField[row][col].setText(String.valueOf(gameField[row][col].getValue()));   
               userField[row][col].setEnabled(false);                     
            }
          }
        }//end of checkEmptyCell()


      boolean victory(){
        int checked = 0; //Ŭ���� ī��Ʈ
        for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
            if(gameField[i][j].isClicked()&&gameField[i][j].getType()=='m'){
               checked++; 
            }
          }//end for j
        }//end for i
        if(checked==mines){         
          return true;            
        }
        return false;
      } 

      @Override
      public void actionPerformed(ActionEvent e) {
          Object obj= (Object) e.getSource();
            if(e.getSource() == btn_Exit){
               int select = JOptionPane.showConfirmDialog(null, "���� ������ �����Ͻðڽ��ϱ�?", "Exit", JOptionPane.OK_CANCEL_OPTION);
               if(select == JOptionPane.YES_OPTION) System.exit(0);
            }
            if(obj == btn_Ready){   
               //start();            
            }

            /*if(obj == �����ʱ�ȭ ��ư){      
               prepareField();   

            }*/

            for(int i=0;i<rows;i++){
               for(int j=0;j<cols;j++){
                   if(obj==userField[i][j] && !userField[i][j].isClicked()){   
                   selected = gameField[i][j];                           

                   if(isAMine(i,j) == 1){ //���ڶ��--211208 ����    
/*---2021-12-13 ��Ʈ ũ�� ����--*/
                     userField[i][j].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));  
                     
                     selected.setClicked(true);                        
                     userField[i][j].setClicked(true);
                     userField[i][j].setValue(selected.getValue());         
                     userField[i][j].setType('f');    
                     userField[i][j].setText("F");  
                     
/*---2021-12-13 [�÷��� ���� : �� ���� ��Ȳ��, �÷��� ��輱: ���� ���� ��Ȳ��]--*/
                     userField[i][j].setBackground(new Color(255,165,45));//�÷��� ���� ���� �� ���ϰ�
                     LineBorder bb= new LineBorder(new Color(246,141,0));//�÷��״� ��輱 ȸ���ֱ�
                     userField[i][j].setBorder(bb);
                     
                     //userField[i][j].setText(String.valueOf(selected.getValue())); 
                     userField[i][j].setEnabled(false);                  

                     //20211208 ���� �߰��Ѱ�
                     score++;
                     leftMines--;
                     label_leftover.setText(Integer.toString(leftMines));//�ܿ� ���̷��� ��
                     //lScore.setText(Integer.toString(score));
                     //lScore.setValue(score);
                     revalidate();
                     repaint();
                     
                     //System.out.println("���� : "+score);
                   }
                   
                   else if(selected.getType() == 'n'){
 /*---2021-12-13 ��Ʈ ũ�� ����--*/
                     userField[i][j].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));
                     
                     selected.setClicked(true);                        
                     userField[i][j].setClicked(true);
                     userField[i][j].setValue(selected.getValue());         
                     userField[i][j].setType('n');                  
                     userField[i][j].setText(String.valueOf(selected.getValue()));   
                     userField[i][j].setEnabled(false);               
                   }
                   else if(selected.getType() == 'e'){ 
 /*---2021-12-13 ��Ʈ ũ�� ����--*/
                     userField[i][j].setFont(new Font("�����ٸ�����", Font.PLAIN, 10));
                     checkEmptyCell(i,j);                           
                   }
                   if(victory()){                                 
                     JOptionPane.showMessageDialog(null,"�¸�!");   
                     showFullField();                     
                   }
                 }//end of if
               }//end of for j
            }//end of for i
      }
      
   public static void main(String[]args){   
      CM_Client c = new CM_Client();
   } //end of main()
   
}