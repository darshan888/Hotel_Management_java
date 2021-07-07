package cp;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.print.PrintException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;


class Employee
{
	int id;
	String empName;
	String jobType;
	String gender;
	int salary;
	long phoneNo;
	
	Employee()
	{
		
	}
	Employee(int id,String emp_name,String job_type,String gender,int salary,long phone_no)
	{
		this.id=id;
		this.empName=emp_name;
		this.jobType=job_type;
		this.gender=gender;
		this.salary=salary;
		this.phoneNo=phone_no;
		
	}
	public String toString()
	{
		return id+":"+empName+":"+jobType+":"+gender+":"+salary+":"+phoneNo;
	}
}

class Customer{
	int custId;
	String custName;
	String contactNo;
	String address;
	//to store arrival date
	int day;
	int month;
	int year;
	int noOfDays;
	ArrayList<Integer>rid=new ArrayList<Integer>();//To store rooms booked
	ArrayList<Double>rprice=new ArrayList<Double>();
	ArrayList<String>fid=new ArrayList<String>();//To store food ordered
	ArrayList<Integer>quantity=new ArrayList<Integer>();//To store food ordered
	ArrayList<Double>fprice=new ArrayList<Double>();
	
	Customer(){
		
	}
	Customer(int custId,String custName,String contactNo,String address,int day,int month,int year,int noOfDays){
		this.custId=custId;
		this.custName=custName;
		this.contactNo=contactNo;
		this.address=address;
		this.day=day;
		this.month=month;
		this.year=year;
		this.noOfDays=noOfDays;	
	}
	void book(int r,Double rp) {
		this.rid.add(r);
		this.rprice.add(rp);
	}
	
	void order(String f,int q,Double fp) {
		this.fid.add(f);
		this.quantity.add(q);
		this.fprice.add(fp);
	}
	
	public String toString() {
		return custId+""+custName+""+contactNo+""+address+""+day+""+month+""+year+""+noOfDays;
	}
}

class Room{
	int roomId;
	int floorNo;
	String roomType;
	boolean availability;
	double price;
	
	Room(){
		
	}
	Room(int roomId,int floorNo,String roomType,boolean availability,double price){
		this.roomId=roomId;
		this.floorNo=floorNo;
		this.roomType=roomType;
		this.availability=availability;
		this.price=price;
	}
	public String toString() {
		return roomId+" "+floorNo+" "+roomType+" "+availability+" "+price;
	}
}

class Food{
	int foodId;
	String foodName;
	
	Food(){
	
	}
	Food(int foodId,String foodName){
		this.foodId=foodId;
		this.foodName=foodName;
	}
	public String toString() {
		return foodId+" "+foodName;
	}
}

class Veg extends Food{
	double price;
	float ratings;
	
	Veg(){
		super();
	}
	
	Veg(int foodId,String foodName,double price,float ratings){
		super(foodId,foodName);
		this.price=price;
		this.ratings=ratings;
	}
}

class NonVeg extends Food{
	double price;
	float ratings;
	
	NonVeg(){
		super();
	}
	
	NonVeg(int foodId,String foodName,double price,float ratings){
		super(foodId,foodName);
		this.price=price;
		this.ratings=ratings;
	}
}


class Hotel{
	String gstin;
	String hotelName;
	String address;
	String contactNo;
	ArrayList<Employee>emp=new ArrayList<Employee>();
	ArrayList<Customer>cust=new ArrayList<Customer>();
	ArrayList<Room>roo=new ArrayList<Room>();
	ArrayList<Veg>ve=new ArrayList<Veg>();
	ArrayList<NonVeg>nve=new ArrayList<NonVeg>();
	
	Hotel()
	{
		
	}
	Hotel(String gstin,String hotelName,String address,String contactNo)
	{
		this.gstin=gstin;
		this.hotelName=hotelName;
		this.address=address;
		this.contactNo=contactNo;
	}
	
}


interface Payment{
	public void pay();
}
class Card implements Payment{
	int paymentId;
	String cardNo;
	String holderName;
	double amount;
	Card(){
		
	}
	Card(int paymentId,String cardNo,String holderName,double amount){
		this.paymentId=paymentId;
		this.cardNo=cardNo;
		this.holderName=holderName;
		this.amount=amount;
	}
	public void pay() {
		//Pay the amount through card
	}
}

class Cash implements Payment{
	int paymentId;
	double amount;
	Cash(){
		
	}
	Cash(int paymentId,double amount){
		this.paymentId=paymentId;
		this.amount=amount;
	}
	public void pay() {
		//Pay the amount through cash
	}
}

class Bill{
	int billId;
	int cId;
	double totalAmount;
	Bill(){
		
	}
	Bill(int billId,int cId,double totalAmount){
		this.billId=billId;
		this.cId=cId;
		this.totalAmount=totalAmount;
	}
	public String toString() {
		return billId+" "+cId+" "+totalAmount;
	}
}

class Feedback{
	int fid;
	int cid;
	String feed;
	int response; //1 indicates +ve response 0 indicates -ve response
	
	Feedback(){
		
	}
	Feedback(int fid,int cid,String feed,int response){
		this.fid=fid;
		this.cid=cid;
		this.feed=feed;
		this.response=response;
	}
}
public class hmm extends JFrame {
	
	Hotel h=new Hotel("123AADA","EMPEROR HOTEL","HUBLI","1231");
	
	
	ArrayList<Bill>bi=new ArrayList<Bill>();
	ArrayList<Card>cr=new ArrayList<Card>();
	ArrayList<Cash>cs=new ArrayList<Cash>();
	ArrayList<Feedback>f=new ArrayList<Feedback>();
	
	static int c=100;
	static int i=100;
	static int r=100;
	static int f1=100;
	static int f2=200;
	static int bill=500;
	static int p=500;
	static int fid=100;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_14;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_28;
	private JTextField textField_27;
	private JTextField textField_29;
	private JTextField textField_30;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hmm frame = new hmm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hmm() {
		h.cust.add(new Customer(10,"Arun","98744","Ylp",1,2,3,4));
		h.cust.add(new Customer(20,"Darshan","98744","Ylp",1,2,3,4));
		
		h.roo.add(new Room(50,2,"AC",true,100));
		h.roo.add(new Room(60,2,"AC",true,100));
		h.roo.add(new Room(70,2,"AC",true,100));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 10, 894, 520);
		contentPane.add(tabbedPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("EMPLOYEE", null, tabbedPane, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("ADD EMPLOYEE", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 29, 106, 38);
		panel_3.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(38, 90, 106, 38);
		panel_3.add(lblName);
		
		JLabel lblJobType = new JLabel("JOB TYPE");
		lblJobType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJobType.setBounds(38, 153, 106, 38);
		panel_3.add(lblJobType);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(38, 215, 106, 38);
		panel_3.add(lblGender);
		
		JLabel lblSalary = new JLabel("SALARY");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSalary.setBounds(38, 283, 106, 38);
		panel_3.add(lblSalary);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNo.setBounds(38, 339, 106, 38);
		panel_3.add(lblPhoneNo);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Integer in=new Integer(i);
					
				textField_2.setText(in.toString());
			}
		});
		textField_2.setBounds(206, 29, 126, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(206, 90, 126, 19);
		panel_3.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(206, 283, 126, 19);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(206, 352, 126, 19);
		panel_3.add(textField_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MANAGER", "DRIVER", "CHEF", "STAFF"}));
		comboBox.setBounds(207, 153, 125, 21);
		panel_3.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("MALE");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(201, 227, 103, 21);
		panel_3.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(324, 225, 103, 21);
		panel_3.add(rdbtnFemale);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea.setBounds(441, 100, 427, 327);
		panel_3.add(textArea);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String g="";
				if(rdbtnNewRadioButton.isSelected())
				{
					g="MALE";
					
				}
				else if(rdbtnFemale.isSelected())
				{
					g="FEMALE";
				}

				
				String emp_name=textField_3.getText();
				int id=i;
				String job_type=comboBox.getSelectedItem().toString();
				int salary=Integer.parseInt(textField_6.getText());
				int phone_no=Integer.parseInt(textField_7.getText());
				
				h.emp.add(new Employee(id,emp_name,job_type,g,salary,phone_no));
				
				JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
				textField_2.setText("");
				textField_3.setText("");
				textField_6.setText("");
				textField_7.setText("");
				rdbtnNewRadioButton.setSelected(false);
				rdbtnFemale.setSelected(false);
				for(int i=0;i<h.emp.size();i++)
				{
						String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).jobType+":"+h.emp.get(i).gender+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
						textArea.append(data+"\n");
				}
				i++;
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(112, 387, 96, 47);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ADDED EMPLOYEES");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(441, 52, 283, 38);
		panel_3.add(lblNewLabel_1);
		
		
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("SEARCH EMPLOYEES", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(157, 56, 46, 14);
		panel_4.add(lblNewLabel_1_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(254, 53, 86, 20);
		panel_4.add(textField_4);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1_1.setBounds(171, 113, 329, 119);
		panel_4.add(textArea_1_1);
		
		JButton btnNewButton_1_1 = new JButton("SEARCH");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1_1.setText("");
				int id1=Integer.parseInt(textField_4.getText());
				for(int i=0;i<h.emp.size();i++)
				{
					if(h.emp.get(i).id==id1)
					{
						String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).jobType+":"+h.emp.get(i).gender+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
						textArea_1_1.append(data+"\n");
					}
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(411, 52, 89, 23);
		panel_4.add(btnNewButton_1_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("DELETE EMPLOYEE", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(167, 138, 58, 14);
		panel_5.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setToolTipText("Enter id");
		textField_5.setColumns(10);
		textField_5.setBounds(262, 135, 86, 20);
		panel_5.add(textField_5);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_2.setBounds(422, 49, 274, 133);
		panel_5.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_3.setBounds(422, 249, 274, 133);
		panel_5.add(textArea_3);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				textArea_2.setText("");
				textArea_3.setText("");
				for(int i=0;i<h.emp.size();i++)
				{
						String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).jobType+":"+h.emp.get(i).gender+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
						textArea_2.append(data+"\n");
				}
				int id2=Integer.parseInt(textField_5.getText());
				for(int i=0;i<h.emp.size();i++)
				{
					if(h.emp.get(i).id==id2)
					{
						flag=1;
						h.emp.remove(h.emp.get(i));
						JOptionPane.showMessageDialog(null, "Deleted successfully");
					}
				}
				if(flag==0) {
					JOptionPane.showMessageDialog(null, "NO RECORD FOUND TO DELETE !!");
				}
				for(int i=0;i<h.emp.size();i++)
				{
						String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).jobType+":"+h.emp.get(i).gender+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
						textArea_3.append(data+"\n");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(214, 202, 89, 23);
		panel_5.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("BEFORE DELETING");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(422, 26, 151, 13);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("AFTER DELETING");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(422, 226, 151, 13);
		panel_5.add(lblNewLabel_3_1);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("DISPLAY EMPLOYEES", null, panel_6, null);
		panel_6.setLayout(null);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_4.setBounds(151, 156, 401, 200);
		panel_6.add(textArea_4);
		
		JButton btnNewButton_2_1 = new JButton("SHOW");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_4.setText("");
				for(int i=0;i<h.emp.size();i++)
				{
					
						String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).gender+":"+h.emp.get(i).jobType+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
						textArea_4.append(data+"\n");
					
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(305, 93, 89, 23);
		panel_6.add(btnNewButton_2_1);
		
		JPanel panel_7 = new JPanel();
		
				JTextArea textArea_2_1 = new JTextArea();
				textArea_2_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						for(int i=0;i<h.emp.size();i++)
						{
								String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).jobType+":"+h.emp.get(i).gender+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
								textArea_2_1.append(data+"\n");
						}
					}
				});
				textArea_2_1.setFont(new Font("Monospaced", Font.BOLD, 15));
				textArea_2_1.setBounds(478, 64, 274, 133);
				panel_7.add(textArea_2_1);
				
				JTextArea textArea_3_1 = new JTextArea();
				textArea_3_1.setFont(new Font("Monospaced", Font.BOLD, 15));
				textArea_3_1.setBounds(478, 264, 274, 133);
				panel_7.add(textArea_3_1);
				
				tabbedPane.addTab("UPDATE EMPLOYEE", null, panel_7, null);
				panel_7.setLayout(null);
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"NAME", "SALARY"}));
				comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				comboBox_1.setBounds(84, 136, 114, 22);
				panel_7.add(comboBox_1);
				
				textField_8 = new JTextField();
				textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_8.setColumns(10);
				textField_8.setBounds(259, 137, 114, 20);
				panel_7.add(textField_8);
				
				JButton btnNewButton_3 = new JButton("UPDATE");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int ide=Integer.parseInt(textField_9.getText());
						int instance=-1;
						for(int i=0;i<h.emp.size();i++)
						{
							
							if(h.emp.get(i).id==ide)
							{
								instance=i;
							}
						}
						if(instance==-1)
						{
							JOptionPane.showMessageDialog(null, "no record found");
						}
						else {
						if (comboBox_1.getSelectedItem()=="NAME")
						{
							String s=textField_8.getText();
							h.emp.get(instance).empName=s;
							JOptionPane.showMessageDialog(null, "updated succesful");
						}
						else if(comboBox_1.getSelectedItem()=="SALARY")
						{
							int a=Integer.parseInt(textField_8.getText());
							h.emp.get(instance).salary=a;
							JOptionPane.showMessageDialog(null, "updated succesful");
						}
						}
						for(int i=0;i<h.emp.size();i++)
						{
								String data=h.emp.get(i).id+":"+h.emp.get(i).empName+":"+h.emp.get(i).jobType+":"+h.emp.get(i).gender+":"+h.emp.get(i).salary+":"+h.emp.get(i).phoneNo;
								textArea_3_1.append(data+"\n");
						}
						
					}
				});
				btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3.setBounds(173, 211, 108, 23);
				panel_7.add(btnNewButton_3);
				
				textField_9 = new JTextField();
				textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_9.setColumns(10);
				textField_9.setBounds(259, 63, 96, 19);
				panel_7.add(textField_9);
				
				JLabel lblNewLabel_4 = new JLabel("ID");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(102, 59, 96, 22);
				panel_7.add(lblNewLabel_4);
				
				JLabel lblNewLabel_3_2 = new JLabel("BEFORE UPDATING");
				lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_3_2.setBounds(478, 41, 151, 13);
				panel_7.add(lblNewLabel_3_2);
				
				JLabel lblNewLabel_3_1_1 = new JLabel("AFTER UPDATING");
				lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_3_1_1.setBounds(478, 241, 151, 13);
				panel_7.add(lblNewLabel_3_1_1);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("CUSTOMER", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBounds(0, 0, 901, 493);
		panel.add(tabbedPane_4);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_4.addTab("ADD CUSTOMER", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(38, 29, 69, 38);
		panel_8.add(lblNewLabel_5);
		
		textField_10 = new JTextField();
		textField_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer in=new Integer(c);
				
				textField_10.setText(in.toString());
			}
		});
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(220, 29, 126, 19);
		panel_8.add(textField_10);
		
		JLabel lblNewLabel_5_1 = new JLabel("NAME");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(38, 77, 106, 38);
		panel_8.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("CONTACT NO");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_2.setBounds(38, 125, 126, 38);
		panel_8.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("ADDRESS");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_3.setBounds(38, 173, 116, 38);
		panel_8.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("ARRIVAL DATE");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_4.setBounds(38, 226, 126, 38);
		panel_8.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("NO. of DAYS");
		lblNewLabel_5_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_5.setBounds(48, 352, 106, 38);
		panel_8.add(lblNewLabel_5_5);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(220, 77, 126, 19);
		panel_8.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(220, 136, 126, 19);
		panel_8.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(220, 184, 126, 19);
		panel_8.add(textField_13);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_15.setColumns(10);
		textField_15.setBounds(221, 363, 126, 19);
		panel_8.add(textField_15);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "32"}));
		comboBox_2.setBounds(300, 238, 58, 21);
		panel_8.add(comboBox_2);
		
		JLabel lblNewLabel_5_6 = new JLabel("DATE");
		lblNewLabel_5_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_6.setBounds(192, 226, 69, 38);
		panel_8.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("MONTH");
		lblNewLabel_5_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_7.setBounds(192, 267, 69, 38);
		panel_8.add(lblNewLabel_5_7);
		
		JLabel lblNewLabel_5_8 = new JLabel("YEAR");
		lblNewLabel_5_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_8.setBounds(192, 307, 69, 38);
		panel_8.add(lblNewLabel_5_8);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2_1.setBounds(300, 279, 58, 21);
		panel_8.add(comboBox_2_1);
		
		JComboBox comboBox_2_1_1 = new JComboBox();
		comboBox_2_1_1.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		comboBox_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2_1_1.setBounds(300, 319, 58, 21);
		panel_8.add(comboBox_2_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1.setBounds(400, 63, 465, 329);
		panel_8.add(textArea_1);
		
		JComboBox comboBox_4_3_1 = new JComboBox();
		JComboBox comboBox_4_3_2 = new JComboBox();
		comboBox_4_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_4_3_1.removeAllItems();
			}
		});
		JComboBox comboBox_5_1 = new JComboBox();
		JComboBox comboBox_4_2 = new JComboBox();
		JComboBox comboBox_5_1_1 = new JComboBox();
		comboBox_5_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s="";
				textField_30.setText("");
				int cid=Integer.parseInt(comboBox_5_1_1.getSelectedItem().toString());
				for(int i=0;i<bi.size();i++) {
					if(bi.get(i).cId==cid) {
						Double d=new Double(bi.get(i).totalAmount);
						s=d.toString();
						textField_30.setText(s);
					}
				}
			}
		});
		comboBox_5_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s="";
				textField_30.setText("");
				int cid=Integer.parseInt(comboBox_5_1_1.getSelectedItem().toString());
				for(int i=0;i<bi.size();i++) {
					if(bi.get(i).cId==cid) {
						Double d=new Double(bi.get(i).totalAmount);
						s=d.toString();
						textField_30.setText(s);
					}
				}
			}
		});
		
		comboBox_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_4_2.removeAllItems();
				comboBox_4_3_2.removeAllItems();
				comboBox_5_1.removeAllItems();
				comboBox_5_1_1.removeAllItems();
				textArea_1.setText("");
				int cId=c;
				String n=textField_11.getText();
				String co=textField_12.getText();
				String ad=textField_13.getText();
				int day=Integer.parseInt(comboBox_2.getSelectedItem().toString());
				int month=Integer.parseInt(comboBox_2_1.getSelectedItem().toString());
				int year=Integer.parseInt(comboBox_2_1_1.getSelectedItem().toString());
				int days=Integer.parseInt(textField_15.getText());
				
				h.cust.add(new Customer(cId,n,co,ad,day,month,year,days));
				
				JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
				
				for(int i=0;i<h.cust.size();i++)
				{
						String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
						textArea_1.append(data+"\n");
				}
					
				ArrayList<Integer>in=new ArrayList<Integer>();
				for(int i=0;i<h.cust.size();i++) {
					in.add(h.cust.get(i).custId);
				}
				for(int j=0;j<h.cust.size();j++) {
					comboBox_4_2.addItem(in.get(j).toString());
					comboBox_4_3_2.addItem(in.get(j).toString());
					comboBox_5_1_1.addItem(in.get(j).toString());
				}
				
				for(int j=0;j<h.cust.size();j++) {
					comboBox_5_1.addItem(in.get(j).toString());
				}
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_15.setText("");
				textField_10.setText("");
				c++;
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(153, 400, 85, 21);
		panel_8.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("ADDED CUSTOMERS");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(400, 30, 283, 38);
		panel_8.add(lblNewLabel_1_2);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_4.addTab("SEARCH CUSTOMER", null, panel_9, null);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(151, 78, 46, 14);
		panel_9.add(lblNewLabel_1_1_1);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(248, 75, 86, 20);
		panel_9.add(textField_14);
		
		JTextArea textArea_1_1_1 = new JTextArea();
		textArea_1_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1_1_1.setBounds(165, 135, 329, 119);
		panel_9.add(textArea_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("SEARCH");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1_1_1.setText("");
				int id1=Integer.parseInt(textField_14.getText());
				for(int i=0;i<h.cust.size();i++)
				{
					if(h.cust.get(i).custId==id1)
					{
						String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
						textArea_1_1_1.append(data+"\n");
					}
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(405, 74, 89, 23);
		panel_9.add(btnNewButton_1_1_1);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_4.addTab("DELETE CUSTOMER", null, panel_10, null);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID2");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(134, 144, 58, 14);
		panel_10.add(lblNewLabel_2_1);
		
		JTextArea textArea_2_2 = new JTextArea();
		
		textField_16 = new JTextField();
		textField_16.setToolTipText("Enter id");
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_16.setColumns(10);
		textField_16.setBounds(229, 141, 86, 20);
		panel_10.add(textField_16);
		
		textArea_2_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_2_2.setBounds(389, 55, 377, 133);
		panel_10.add(textArea_2_2);
		
		JTextArea textArea_3_2 = new JTextArea();
		textArea_3_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_3_2.setBounds(389, 255, 377, 133);
		panel_10.add(textArea_3_2);
		
		JComboBox comboBox_4_1_1 = new JComboBox();
		
		JButton btnNewButton_1_2 = new JButton("DELETE");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				textArea_2_2.setText("");
				textArea_3_2.setText("");
				for(int i=0;i<h.cust.size();i++)
				{
						String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
						textArea_2_2.append(data+"\n");
				}
				int id2=Integer.parseInt(textField_16.getText());
				for(int i=0;i<h.cust.size();i++)
				{
					if(h.cust.get(i).custId==id2)
					{
						flag=1;
						for(int k=0;k<h.roo.size();k++) {
						for(int j=0;j<h.cust.get(i).rid.size();j++) {
							if(h.cust.get(i).rid.get(j)==h.roo.get(k).roomId) {
								h.roo.get(k).availability=true;
							}
						}
						}
						h.cust.remove(h.cust.get(i));
						JOptionPane.showMessageDialog(null, "Deleted successfully");
					}
				}
				if(flag==0) {
					JOptionPane.showMessageDialog(null, "NO RECORD FOUND TO DELETE !!");
				}
				
				for(int i=0;i<h.cust.size();i++)
				{
					String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
					textArea_3_2.append(data+"\n");
				}
				comboBox_4_2.removeAllItems();
				comboBox_5_1_1.removeAllItems();
				for(int i=0;i<h.cust.size();i++) {
					comboBox_4_2.addItem(h.cust.get(i).custId);
					comboBox_5_1_1.addItem(h.cust.get(i).custId);
					
				}
				
				comboBox_4_1_1.removeAllItems();
				for(int j=0;j<h.roo.size();j++) {
					if(h.roo.get(j).availability==true) {
					comboBox_4_1_1.addItem(h.roo.get(j).roomId);
					}
				}
				
				comboBox_4_3_2.removeAllItems();
				for(int i=0;i<h.cust.size();i++) {
					comboBox_4_3_2.addItem(h.cust.get(i).custId);
				}
				
				comboBox_5_1.removeAllItems();
				for(int i=0;i<h.cust.size();i++) {
					comboBox_5_1.addItem(h.cust.get(i).custId);
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(181, 208, 89, 23);
		panel_10.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("BEFORE DELETING");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(389, 32, 151, 13);
		panel_10.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("AFTER DELETING");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(389, 232, 151, 13);
		panel_10.add(lblNewLabel_3_1_2);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_4.addTab("DISPLAY CUSTOMER", null, panel_11, null);
		panel_11.setLayout(null);
		
		JTextArea textArea_4_1 = new JTextArea();
		textArea_4_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_4_1.setBounds(193, 130, 401, 200);
		panel_11.add(textArea_4_1);
		
		JButton btnNewButton_2_1_1 = new JButton("SHOW");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_4_1.setText("");
				for(int i=0;i<h.cust.size();i++)
				{
					
					String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
					textArea_4_1.append(data+"\n");
					
				}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1_1.setBounds(347, 67, 89, 23);
		panel_11.add(btnNewButton_2_1_1);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_4.addTab("UPDATE CUSTOMER", null, panel_12, null);
		panel_12.setLayout(null);
		
		JTextArea textArea_2_1_1 = new JTextArea();
		textArea_2_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_2_1_1.setBounds(459, 69, 386, 133);
		panel_12.add(textArea_2_1_1);
		
		JTextArea textArea_3_1_1 = new JTextArea();
		textArea_3_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_3_1_1.setBounds(459, 269, 386, 133);
		panel_12.add(textArea_3_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"NAME", "No.Of Days"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1_1.setBounds(104, 132, 114, 22);
		panel_12.add(comboBox_1_1);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_17.setColumns(10);
		textField_17.setBounds(279, 133, 114, 20);
		panel_12.add(textField_17);
		
		JButton btnNewButton_3_1 = new JButton("UPDATE");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ide=Integer.parseInt(textField_18.getText());
				int instance=-1;
				for(int i=0;i<h.cust.size();i++)
				{
					
					if(h.cust.get(i).custId==ide)
					{
						instance=i;
					}
				}
				if(instance==-1)
				{
					JOptionPane.showMessageDialog(null, "no record found");
				}
				else {
				if (comboBox_1_1.getSelectedItem()=="NAME")
				{
					String s=textField_17.getText();
					h.cust.get(instance).custName=s;
					JOptionPane.showMessageDialog(null, "updated succesful");
				}
				else if(comboBox_1_1.getSelectedItem()=="No.Of Days")
				{
					int a=Integer.parseInt(textField_17.getText());
					h.cust.get(instance).noOfDays=a;
					JOptionPane.showMessageDialog(null, "updated succesful");
				}
				}
				for(int i=0;i<h.cust.size();i++)
				{
					String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
					textArea_3_1_1.append(data+"\n");
				}
				
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_1.setBounds(193, 207, 108, 23);
		panel_12.add(btnNewButton_3_1);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_18.setColumns(10);
		textField_18.setBounds(279, 59, 96, 19);
		panel_12.add(textField_18);
		
		JLabel lblNewLabel_4_1 = new JLabel("ID");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(122, 55, 96, 22);
		panel_12.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("BEFORE UPDATING");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(459, 46, 151, 13);
		panel_12.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("AFTER UPDATING");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(459, 246, 151, 13);
		panel_12.add(lblNewLabel_3_1_1_1);
		
		JButton btnNewButton_4 = new JButton("CLICK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<h.cust.size();i++)
				{
					String data=h.cust.get(i).custId+":"+h.cust.get(i).custName+":"+h.cust.get(i).contactNo+":"+h.cust.get(i).address+" : "+h.cust.get(i).day+"/"+h.cust.get(i).month+"/"+h.cust.get(i).year+" : "+h.cust.get(i).noOfDays;
					textArea_2_1_1.append(data+"\n");
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(620, 44, 85, 21);
		panel_12.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("ROOM", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_5.setBounds(0, 0, 899, 483);
		panel_1.add(tabbedPane_5);
		
		JPanel panel_13 = new JPanel();
		tabbedPane_5.addTab("ADD ROOM", null, panel_13, null);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_5_9 = new JLabel("ID");
		lblNewLabel_5_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_9.setBounds(59, 57, 69, 38);
		panel_13.add(lblNewLabel_5_9);
		
		textField_19 = new JTextField();
		textField_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Integer in=new Integer(r);
					
					textField_19.setText(in.toString());
			}
		});
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_19.setColumns(10);
		textField_19.setBounds(241, 57, 126, 19);
		panel_13.add(textField_19);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("FLOOR NO.");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1_1.setBounds(59, 105, 106, 38);
		panel_13.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("ROOM TYPE");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_2_1.setBounds(59, 153, 126, 38);
		panel_13.add(lblNewLabel_5_2_1);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_20.setColumns(10);
		textField_20.setBounds(241, 105, 126, 19);
		panel_13.add(textField_20);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"AC", "NON-AC"}));
		comboBox_3.setBounds(241, 165, 126, 21);
		panel_13.add(comboBox_3);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_5.setBounds(409, 67, 446, 335);
		panel_13.add(textArea_5);
		
		JButton btnNewButton_5 = new JButton("ADD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_4_1_1.removeAllItems();
				textArea_5.setText("");
				int rid=r;
				int fid=Integer.parseInt(textField_20.getText());
				String rType=comboBox_3.getSelectedItem().toString();
				Double price=Double.parseDouble(textField_26.getText());
				h.roo.add(new Room(rid,fid,rType,true,price));
				
				for(int i=0;i<h.roo.size();i++) {
					String data1;
					String data=h.roo.get(i).roomId+" "+h.roo.get(i).floorNo+" "+h.roo.get(i).roomType+" "+h.roo.get(i).price;
					if(h.roo.get(i).availability==true) {
						data1=data+" "+"Available";
					}
					else {
						data1=data+" "+"Not Available";
					}
					textArea_5.append(data1+"\n");
				}
				
				ArrayList<Integer>in=new ArrayList<Integer>();
				for(int i=0;i<h.roo.size();i++) {
					in.add(h.roo.get(i).roomId);
				}
				for(int j=0;j<h.roo.size();j++) {
					if(h.roo.get(j).availability==true) {
					comboBox_4_1_1.addItem(in.get(j).toString());
					}
				}
				textField_20.setText("");	
				textField_19.setText("");
				r++;
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(149, 289, 85, 21);
		panel_13.add(btnNewButton_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("ROOMS");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(409, 24, 283, 38);
		panel_13.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("ROOM PRICE");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1_1_1.setBounds(59, 201, 126, 38);
		panel_13.add(lblNewLabel_5_1_1_1);
		
		textField_26 = new JTextField();
		textField_26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_26.setColumns(10);
		textField_26.setBounds(241, 212, 126, 19);
		panel_13.add(textField_26);
		
		JPanel panel_14 = new JPanel();
		tabbedPane_5.addTab("SEARCH ROOM", null, panel_14, null);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(212, 93, 46, 14);
		panel_14.add(lblNewLabel_1_1_1_1);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_21.setColumns(10);
		textField_21.setBounds(309, 90, 86, 20);
		panel_14.add(textField_21);
		
		JTextArea textArea_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1_1_1_1.setBounds(226, 150, 329, 119);
		panel_14.add(textArea_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("SEARCH");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1_1_1_1.setText("");
				String data1="";
				int flag=0;
				int id1=Integer.parseInt(textField_21.getText());
				for(int i=0;i<h.roo.size();i++)
				{
					if(id1==h.roo.get(i).roomId) {
					flag=1;
					String data=h.roo.get(i).roomId+" "+h.roo.get(i).floorNo+" "+h.roo.get(i).roomType+" "+h.roo.get(i).price;
					for(int j=0;j<h.roo.size();j++) {
					if(h.roo.get(j).availability==true) {
						data1=data+" "+"Available";
					}
					else {
						data1=data+" "+"Not Available";
					}
				}
					textArea_1_1_1_1.append(data1+"\n");
				}
				}
				if(flag==0) {
					textArea_1_1_1_1.setText("NO RECORDS FOUND !!");
				}
				textField_21.setText("");
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1_1.setBounds(466, 89, 89, 23);
		panel_14.add(btnNewButton_1_1_1_1);
		
		JPanel panel_15 = new JPanel();
		tabbedPane_5.addTab("DELETE ROOM", null, panel_15, null);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ID2");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(128, 149, 58, 14);
		panel_15.add(lblNewLabel_2_1_1);
		
		textField_22 = new JTextField();
		textField_22.setToolTipText("Enter id");
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_22.setColumns(10);
		textField_22.setBounds(223, 146, 86, 20);
		panel_15.add(textField_22);
		
		JTextArea textArea_2_2_1 = new JTextArea();
		textArea_2_2_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_2_2_1.setBounds(383, 60, 377, 133);
		panel_15.add(textArea_2_2_1);
		
		JTextArea textArea_3_2_1 = new JTextArea();
		textArea_3_2_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_3_2_1.setBounds(383, 260, 377, 133);
		panel_15.add(textArea_3_2_1);
		
		JButton btnNewButton_1_2_1 = new JButton("DELETE");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_2_2_1.setText("");
				textArea_3_2_1.setText("");
				int flag=0;
				for(int i=0;i<h.roo.size();i++) {
					String data1;
					String data=h.roo.get(i).roomId+" "+h.roo.get(i).floorNo+" "+h.roo.get(i).roomType+" "+h.roo.get(i).price;
					if(h.roo.get(i).availability==true) {
						data1=data+" "+"Available";
					}
					else {
						data1=data+" "+"Not Available";
					}
					textArea_2_2_1.append(data1+"\n");
				}
				int id2=Integer.parseInt(textField_22.getText());
				for(int i=0;i<h.roo.size();i++)
				{
					if(h.roo.get(i).roomId==id2)
					{
						flag=1;
						h.roo.remove(h.roo.get(i));
						JOptionPane.showMessageDialog(null, "Deleted successfully");
					}
				}
				if(flag==0) {
					JOptionPane.showMessageDialog(null, "NO RECORD FOUND TO DELETE !!");
				}
				
				for(int i=0;i<h.roo.size();i++) {
					String data1;
					String data=h.roo.get(i).roomId+" "+h.roo.get(i).floorNo+" "+h.roo.get(i).roomType+" "+h.roo.get(i).price;
					if(h.roo.get(i).availability==true) {
						data1=data+" "+"Available";
					}
					else {
						data1=data+" "+"Not Available";
					}
					textArea_3_2_1.append(data1+"\n");
				}
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_1.setBounds(175, 213, 89, 23);
		panel_15.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("BEFORE DELETING");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3_1.setBounds(383, 37, 151, 13);
		panel_15.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("AFTER DELETING");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2_1.setBounds(383, 237, 151, 13);
		panel_15.add(lblNewLabel_3_1_2_1);
		
		JPanel panel_18 = new JPanel();
		tabbedPane_5.addTab("SHOW ROOMS", null, panel_18, null);
		panel_18.setLayout(null);
		
		JTextArea textArea_4_1_1 = new JTextArea();
		textArea_4_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_4_1_1.setBounds(191, 128, 401, 200);
		panel_18.add(textArea_4_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("SHOW");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_4_1_1.setText("");
				for(int i=0;i<h.roo.size();i++) {
					String data1;
					String data=h.roo.get(i).roomId+" "+h.roo.get(i).floorNo+" "+h.roo.get(i).roomType+" "+h.roo.get(i).price;
					if(h.roo.get(i).availability==true) {
						data1=data+" "+"Available";
					}
					else {
						data1=data+" "+"Not Available";
					}
					textArea_4_1_1.append(data1+"\n");
				}
			}
		});
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1_1_1.setBounds(345, 65, 89, 23);
		panel_18.add(btnNewButton_2_1_1_1);
		
		JPanel panel_24 = new JPanel();
		tabbedPane_5.addTab("BOOK ROOM", null, panel_24, null);
		panel_24.setLayout(null);
		
		JLabel lblNewLabel_6_2 = new JLabel("ROOM BOOKING");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_2.setBounds(152, 60, 213, 34);
		panel_24.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("CUSTOMER ID");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_2.setBounds(54, 124, 118, 34);
		panel_24.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("ROOM ID");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1_1.setBounds(54, 207, 118, 34);
		panel_24.add(lblNewLabel_7_1_1);
		
		comboBox_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4_2.setBounds(223, 133, 128, 21);
		panel_24.add(comboBox_4_2);
		
		comboBox_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4_1_1.setBounds(223, 207, 128, 21);
		panel_24.add(comboBox_4_1_1);
		
		JTextArea textArea_6_1 = new JTextArea();
		textArea_6_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_6_1.setBounds(375, 72, 458, 338);
		panel_24.add(textArea_6_1);
		
		JButton btnNewButton_6_1 = new JButton("BOOK");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int instance=-1;
				int imp=-1;
				int cid=Integer.parseInt(comboBox_4_2.getSelectedItem().toString());
				int rid=Integer.parseInt(comboBox_4_1_1.getSelectedItem().toString());
				Integer k=new Integer(rid);
				String ci=k.toString();
				textArea_6_1.append("The room "+rid+" is booked by Customer id "+cid+"\n");
				
				for(int i=0;i<h.roo.size();i++) {
					if(h.roo.get(i).roomId==rid) {
						h.roo.get(i).availability=false;
						comboBox_4_1_1.removeItem(ci);
						instance=i;
					}
				}
				for(int j=0;j<h.cust.size();j++) {
					if(h.cust.get(j).custId==cid) {
						imp=j;
					}
				}
				if(imp!=-1 && instance!=-1) {
				h.cust.get(imp).rid.add(h.roo.get(instance).roomId);
				h.cust.get(imp).rprice.add(h.roo.get(instance).price);}
			}
		});
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6_1.setBounds(154, 300, 85, 21);
		panel_24.add(btnNewButton_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("BOOKED ROOMS SUMMARY");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1_1.setBounds(375, 37, 232, 34);
		panel_24.add(lblNewLabel_6_1_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("FOOD", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(447, 5, 5, 5);
		panel_2.add(tabbedPane_3);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(457, 5, 5, 5);
		panel_2.add(tabbedPane_2);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_6.setBounds(0, 0, 899, 483);
		panel_2.add(tabbedPane_6);
		
		JPanel panel_19 = new JPanel();
		tabbedPane_6.addTab("ADD FOOD", null, panel_19, null);
		panel_19.setLayout(null);
		
		JLabel lblFoodType = new JLabel("FOOD TYPE");
		lblFoodType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodType.setBounds(10, 59, 106, 38);
		panel_19.add(lblFoodType);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"VEG", "NON-VEG"}));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4.setBounds(168, 69, 150, 21);
		panel_19.add(comboBox_4);
		
		JLabel lblFoodId = new JLabel("FOOD ID");
		lblFoodId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodId.setBounds(10, 126, 106, 38);
		panel_19.add(lblFoodId);
		
		JLabel lblFoodName = new JLabel("FOOD NAME");
		lblFoodName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodName.setBounds(10, 190, 106, 38);
		panel_19.add(lblFoodName);
		
		JLabel lblFoodType_2_1 = new JLabel("PRICE");
		lblFoodType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodType_2_1.setBounds(10, 251, 106, 38);
		panel_19.add(lblFoodType_2_1);
		
		textField_23 = new JTextField();
		textField_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboBox_4.getSelectedItem().toString()=="VEG") {
				 Integer in=new Integer(f1);
				textField_23.setText(in.toString());
				}
				else if(comboBox_4.getSelectedItem().toString()=="NON-VEG") {
					 Integer in=new Integer(f2);
						textField_23.setText(in.toString());
				}
			}
		});
		textField_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_23.setColumns(10);
		textField_23.setBounds(168, 126, 150, 19);
		panel_19.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_24.setColumns(10);
		textField_24.setBounds(168, 192, 150, 19);
		panel_19.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_25.setColumns(10);
		textField_25.setBounds(168, 262, 150, 19);
		panel_19.add(textField_25);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_6.setBounds(607, 40, 263, 368);
		panel_19.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_7.setBounds(328, 40, 269, 368);
		panel_19.add(textArea_7);
		
		JButton btnNewButton_6 = new JButton("ADD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_7.setText("");
				textArea_6.setText("");
				comboBox_4_3_1.removeAllItems();
				String type=comboBox_4.getSelectedItem().toString();
				if(type=="VEG") {
							String name=textField_24.getText();
							double price=Double.parseDouble(textField_25.getText());
							h.ve.add(new Veg(f1,name,price,0));
							JOptionPane.showMessageDialog(null,"Veg Food Added Successfully !!");
	
							for(int i=0;i<h.ve.size();i++) {
								String data=h.ve.get(i).foodId+" "+h.ve.get(i).foodName+" "+h.ve.get(i).price;
								textArea_7.append(data+"\n");
							}
							for(int i=0;i<h.nve.size();i++) {
								String data=h.nve.get(i).foodId+" "+h.nve.get(i).foodName+" "+h.nve.get(i).price;
								textArea_6.append(data+"\n");
							}
							f1++;
							textField_23.setText("");
							textField_24.setText("");
							textField_25.setText("");
						
				}
				else if(type=="NON-VEG") {
					String name=textField_24.getText();
					double price=Double.parseDouble(textField_25.getText());
					h.nve.add(new NonVeg(f2,name,price,0));
					JOptionPane.showMessageDialog(null,"Non-Veg Food Added Successfully !!");
					
					for(int i=0;i<h.ve.size();i++) {
						String data=h.ve.get(i).foodId+" "+h.ve.get(i).foodName+" "+h.ve.get(i).price;
						textArea_7.append(data+"\n");
					}
					
					for(int i=0;i<h.nve.size();i++) {
						String data=h.nve.get(i).foodId+" "+h.nve.get(i).foodName+" "+h.nve.get(i).price;
						textArea_6.append(data+"\n");
					}
					for(int i=0;i<h.nve.size();i++) {
						comboBox_4_3_1.addItem(h.nve.get(i).foodName.toString());
					}
					f2++;
					textField_23.setText("");
					textField_24.setText("");
					textField_25.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Choose Food Type");
				}
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setBounds(101, 321, 135, 45);
		panel_19.add(btnNewButton_6);
		
		JLabel lblVeg = new JLabel("VEG");
		lblVeg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVeg.setBounds(328, 10, 106, 38);
		panel_19.add(lblVeg);
		
		JLabel lblFoodType_1_1 = new JLabel("NON-VEG");
		lblFoodType_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodType_1_1.setBounds(607, 10, 106, 38);
		panel_19.add(lblFoodType_1_1);
		
		JPanel panel_20 = new JPanel();
		tabbedPane_6.addTab("DISPLAY FOOD", null, panel_20, null);
		panel_20.setLayout(null);
		
		JComboBox comboBox_4_1 = new JComboBox();
		comboBox_4_1.setModel(new DefaultComboBoxModel(new String[] {"--SELECT TYPE--", "VEG", "NON-VEG"}));
		comboBox_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4_1.setBounds(152, 69, 144, 21);
		panel_20.add(comboBox_4_1);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_8.setBounds(53, 133, 574, 267);
		panel_20.add(textArea_8);
		
		JButton btnNewButton_6_2 = new JButton("SHOW");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=comboBox_4_1.getSelectedItem().toString();
				if(type=="VEG") {
							textArea_8.setText("");
							for(int i=0;i<h.ve.size();i++) {
								String data=h.ve.get(i).foodId+" "+h.ve.get(i).foodName+" "+h.ve.get(i).price;
								textArea_8.append(data+"\n");
							}
							
							comboBox_4_1.setSelectedItem("--SELECT TYPE--");
						
				}
				else if(type=="NON-VEG") {
					textArea_8.setText("");				
					for(int i=0;i<h.nve.size();i++) {
						String data=h.nve.get(i).foodId+" "+h.nve.get(i).foodName+" "+h.nve.get(i).price;
						textArea_8.append(data+"\n");
					}
					comboBox_4_1.setSelectedItem("--SELECT TYPE--");
					
				}
				else {
					textArea_8.setText("");	
					JOptionPane.showMessageDialog(null,"Please Choose Food Type");
				}
				
			}
		});
		btnNewButton_6_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6_2.setBounds(366, 57, 135, 45);
		panel_20.add(btnNewButton_6_2);
		
		JPanel panel_21 = new JPanel();
		tabbedPane_6.addTab("Ha", null, panel_21, null);
		
		JPanel panel_22 = new JPanel();
		tabbedPane_6.addTab("ORDER FOOD", null, panel_22, null);
		panel_22.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerId.setBounds(10, 35, 152, 38);
		panel_22.add(lblCustomerId);
		
		JLabel lblFoodType_1 = new JLabel("FOOD TYPE");
		lblFoodType_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodType_1.setBounds(10, 109, 152, 38);
		panel_22.add(lblFoodType_1);
		
		JComboBox comboBox_4_3 = new JComboBox();
		comboBox_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_4_3_1.removeAllItems();
				if(comboBox_4_3.getSelectedItem().toString()=="VEG") {
					comboBox_4_3_1.removeAllItems();
				for(int i=0;i<h.ve.size();i++) {
					comboBox_4_3_1.addItem(h.ve.get(i).foodName.toString());
				}
				}
				else if(comboBox_4_3.getSelectedItem().toString()=="NON-VEG") {
					comboBox_4_3_1.removeAllItems();
					for(int i=0;i<h.nve.size();i++) {
						comboBox_4_3_1.addItem(h.nve.get(i).foodName.toString());
					}
					}
				else {
					comboBox_4_3_1.removeAllItems();
				}
			}
			
		});
		comboBox_4_3.setModel(new DefaultComboBoxModel(new String[] {"--SELECT TYPE--", "VEG", "NON-VEG"}));
		comboBox_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4_3.setBounds(188, 121, 152, 21);
		panel_22.add(comboBox_4_3);
		
		JLabel lblFoodType_1_2 = new JLabel("FOOD NAME");
		lblFoodType_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodType_1_2.setBounds(10, 181, 152, 38);
		panel_22.add(lblFoodType_1_2);
		
		comboBox_4_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4_3_1.setBounds(188, 191, 152, 21);
		panel_22.add(comboBox_4_3_1);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity.setBounds(10, 250, 152, 38);
		panel_22.add(lblQuantity);
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_28.setColumns(10);
		textField_28.setBounds(188, 252, 152, 38);
		panel_22.add(textField_28);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_10.setBounds(372, 45, 491, 371);
		panel_22.add(textArea_10);
		
		JButton btnNewButton_8 = new JButton("ORDER FOOD");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int customerInstance=-1;
				int cid=Integer.parseInt(comboBox_4_3_2.getSelectedItem().toString());
				String type=comboBox_4_3.getSelectedItem().toString();
				String name=comboBox_4_3_1.getSelectedItem().toString();
				int q=Integer.parseInt(textField_28.getText());
				
				for(int j=0;j<h.cust.size();j++) {
					if(cid==h.cust.get(j).custId) {
						customerInstance=j;
					}
				}
				if(type=="VEG") {
					for(int i=0;i<h.ve.size();i++) {
						if(name==h.ve.get(i).foodName) {
							h.cust.get(customerInstance).fid.add(name);
							h.cust.get(customerInstance).quantity.add(q);
							h.cust.get(customerInstance).fprice.add(h.ve.get(i).price);
							JOptionPane.showMessageDialog(null,"VEG food Orderd Successfully !!");
							textArea_10.append(h.cust.get(customerInstance).custId+" "+name+" "+q+" "+h.cust.get(customerInstance).fprice.get(i)+"\n");
						}
					}
				}
				else if(type=="NON-VEG") {
					for(int i=0;i<h.nve.size();i++) {
						if(name==h.nve.get(i).foodName) {
							h.cust.get(customerInstance).fid.add(name);
							h.cust.get(customerInstance).quantity.add(q);
							h.cust.get(customerInstance).fprice.add(h.nve.get(i).price);
							JOptionPane.showMessageDialog(null,"NON-VEG food Orderd Successfully !!");
							textArea_10.append(h.cust.get(customerInstance)+" "+name+" "+q+" "+h.cust.get(customerInstance).fprice.get(i)+"\n");
						}
					}
				}
				comboBox_4_3.setSelectedItem("--SELECT TYPE--");
				textField_28.setText("");
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_8.setBounds(84, 338, 152, 38);
		panel_22.add(btnNewButton_8);
		
		JLabel lblOrderSummary = new JLabel("ORDER SUMMARY");
		lblOrderSummary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrderSummary.setBounds(370, 10, 152, 38);
		panel_22.add(lblOrderSummary);
		
		comboBox_4_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4_3_2.setBounds(188, 47, 152, 21);
		panel_22.add(comboBox_4_3_2);
		
		JPanel panel_23 = new JPanel();
		tabbedPane_1.addTab("BILL", null, panel_23, null);
		panel_23.setLayout(null);
		
		JTabbedPane tabbedPane_7 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_7.setBounds(0, 0, 879, 483);
		panel_23.add(tabbedPane_7);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(72, 209, 204));
		tabbedPane_7.addTab("GENERATE BILL", null, panel_25, null);
		panel_25.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("CUSTOMER ID");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(194, 31, 111, 27);
		panel_25.add(lblNewLabel_6_1);
		
		comboBox_5_1.setBounds(364, 36, 104, 21);
		panel_25.add(comboBox_5_1);
		
		JTextArea textArea_9_1 = new JTextArea();
		textArea_9_1.setBackground(new Color(245, 255, 250));
		textArea_9_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_9_1.setBounds(48, 68, 776, 378);
		panel_25.add(textArea_9_1);
		JButton btnNewButton_7_1 = new JButton("OK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_9_1.setText("");
				int customerInstance=-1;
				String data="";
				String data1="";
				String data2="";
				int id=Integer.parseInt(comboBox_5_1.getSelectedItem().toString());
				for(int i=0;i<h.cust.size();i++) {
					if(h.cust.get(i).custId==id) {
						customerInstance=i;
						for(int j=0;j<h.cust.get(i).rid.size();j++) {
							data=h.cust.get(i).rid.get(j).toString();
							data1=h.cust.get(i).rprice.get(j).toString();
							//textArea_9_1.append("The Customer "+id+" has booked room Id "+data+" with price "+data1+"\n\n");
						}
						for(int j=0;j<h.cust.get(i).fid.size();j++) {
							data=h.cust.get(i).fid.get(j);
							data2=data1=h.cust.get(i).quantity.get(j).toString();
							data1=h.cust.get(i).fprice.get(j).toString();
							//textArea_9_1.append("The Customer "+id+" has ordered food "+data+" with Qunatity "+data2+" of price "+data1+" \n\n");
						}
					}
				}
				textArea_9_1.setText("");
				textArea_9_1.append("                           BILL ID       : "+bill+"\n");
				textArea_9_1.append("                           CUSTOMER ID   : "+id+"\n\n");
				textArea_9_1.append("        ROOM DETAILS                                       FOOD DETAILS\n");
				textArea_9_1.append("      -------------------                               --------------------\n");
				textArea_9_1.append("ROOM ID   No.Of Days   Price                   FOOD                QUANTITY    PRICE \n");
				textArea_9_1.append("-------   ----------   ------                  ----                --------    -----\n");
				int i=0;
				int j=0;
				int k=0;
				int max=0;
				int custlen=h.cust.get(customerInstance).rid.size();
				int custlen1=h.cust.get(customerInstance).fid.size();
				if(custlen>custlen1) {
					max=custlen;
				}
				else if(custlen1>custlen) {
					max=custlen1;
				}
				while(k!=max) {
				if(i!=h.cust.get(customerInstance).rid.size()) {
					textArea_9_1.append(h.cust.get(customerInstance).rid.get(i)+"            "+h.cust.get(customerInstance).noOfDays+"          "+h.cust.get(customerInstance).rprice.get(i));
					i++;
				}
				else {
					textArea_9_1.append("                              ");
				}
				if(j!=h.cust.get(customerInstance).fid.size()) {
					int l=22-h.cust.get(customerInstance).fid.get(j).length();
					textArea_9_1.append("                  "+h.cust.get(customerInstance).fid.get(j));
					for(int m=0;m<l;m++) {
						textArea_9_1.append(" ");
					}
					textArea_9_1.append(h.cust.get(customerInstance).quantity.get(j)+"        "+h.cust.get(customerInstance).fprice.get(j)+"\n");
					j++;
				}
				else {
				textArea_9_1.append("                              \n");
				}
				k++;
				}
				textArea_9_1.append("--------------------------------------          -------------------------------------------\n");
				double Total=0;
				for(int q=0;q<h.cust.get(customerInstance).rprice.size();q++) {
					Total+=h.cust.get(customerInstance).rprice.get(q)*h.cust.get(customerInstance).noOfDays;
				}
				textArea_9_1.append("TOTAL         : Rs. "+Total+"                       ");
				
				double Total1=0;
				for(int q=0;q<h.cust.get(customerInstance).fprice.size();q++) {
					Total1+=h.cust.get(customerInstance).fprice.get(q)*h.cust.get(customerInstance).quantity.get(q);
				}
				textArea_9_1.append("TOTAL         : Rs. "+Total1+"\n\n\n");
				Total+=Total1;
				textArea_9_1.append("                       ----------------------------------------\n");
				textArea_9_1.append("                          GRAND TOTAL         : Rs. "+Total+"      \n");
				textArea_9_1.append("                       ----------------------------------------");
				bi.add(new Bill(bill,h.cust.get(customerInstance).custId,Total));
				System.out.println(bi);
				bill++;
			}
		});
		btnNewButton_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_7_1.setBounds(559, 36, 85, 21);
		panel_25.add(btnNewButton_7_1);
		
		JButton btnNewButton_7 = new JButton("PRINT");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean complete = textArea_9_1.print();
					if(complete) {
						JOptionPane.showMessageDialog(null, "done printing","info",JOptionPane.INFORMATION_MESSAGE);;
						
					}
					else {
						JOptionPane.showMessageDialog(null, "not done","PRINTER", JOptionPane.ERROR_MESSAGE);
						
					}
					
				}catch(Exception textArea) {
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_7.setBounds(701, 36, 85, 21);
		panel_25.add(btnNewButton_7);
		
		JPanel panel_26 = new JPanel();
		tabbedPane_7.addTab("PAY BILL", null, panel_26, null);
		panel_26.setLayout(null);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("CUSTOMER ID");
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_2.setBounds(195, 37, 111, 27);
		panel_26.add(lblNewLabel_6_1_2);
		
		comboBox_5_1_1.setBounds(358, 37, 151, 21);
		panel_26.add(comboBox_5_1_1);
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("PAYMENT MODE");
		lblNewLabel_6_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_2_1.setBounds(195, 95, 127, 27);
		panel_26.add(lblNewLabel_6_1_2_1);
		
		JComboBox comboBox_5_1_1_1 = new JComboBox();
		comboBox_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_5_1_1_1.getSelectedItem()=="CASH") {
				textField_27.setEnabled(false);
				textField_29.setEnabled(false);
				}
				else {
					textField_27.setEnabled(true);
					textField_29.setEnabled(true);
				}
			}
		});
		comboBox_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_5_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"--SELECT TYPE--", "CARD", "CASH"}));
		comboBox_5_1_1_1.setBounds(358, 95, 151, 21);
		panel_26.add(comboBox_5_1_1_1);
		
		JLabel lblNewLabel_6_1_2_1_1 = new JLabel("CARD NO.");
		lblNewLabel_6_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_2_1_1.setBounds(195, 156, 127, 27);
		panel_26.add(lblNewLabel_6_1_2_1_1);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_27.setBounds(358, 162, 151, 21);
		panel_26.add(textField_27);
		textField_27.setColumns(10);
		
		JLabel lblNewLabel_6_1_2_1_1_1 = new JLabel("HOLDER NAME");
		lblNewLabel_6_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_2_1_1_1.setBounds(195, 214, 121, 27);
		panel_26.add(lblNewLabel_6_1_2_1_1_1);
		
		textField_29 = new JTextField();
		textField_29.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_29.setColumns(10);
		textField_29.setBounds(358, 220, 151, 21);
		panel_26.add(textField_29);
		
		JLabel lblNewLabel_6_1_2_1_1_1_1 = new JLabel("AMOUNT");
		lblNewLabel_6_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_2_1_1_1_1.setBounds(195, 276, 121, 27);
		panel_26.add(lblNewLabel_6_1_2_1_1_1_1);
		
		textField_30 = new JTextField();
		textField_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_30.setColumns(10);
		textField_30.setBounds(358, 282, 151, 21);
		panel_26.add(textField_30);
		
		JButton btnNewButton_9 = new JButton("PAY");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String s="";
				int index=-1;
				int cid=Integer.parseInt(comboBox_5_1_1.getSelectedItem().toString());
				for(int i=0;i<bi.size();i++) {
					if(bi.get(i).cId==cid) {
						index=i;
						
					}
				}
					if(comboBox_5_1_1_1.getSelectedItem()=="CARD") {
						String num=textField_27.getText();
						String name=textField_29.getText();
						cr.add(new Card(p,num,name,bi.get(index).totalAmount));
						JOptionPane.showMessageDialog(null,"Payment Done through Card !!");
						flag=1;
						Integer inte=new Integer(cid);
						String st=inte.toString();
						comboBox_5_1_1.removeItem(st);
						
						p++;
						
						
					}
					
				
				
				
				else if(comboBox_5_1_1_1.getSelectedItem()=="CASH") {
					cs.add(new Cash(p,bi.get(index).totalAmount));
					JOptionPane.showMessageDialog(null,"Payment Done through Cash !!");
					flag=1;
					Integer inte=new Integer(cid);
					String st=inte.toString();
					comboBox_5_1_1.removeItem(st);
					p++;
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Choose Payment Mode !!");
				}
				comboBox_5_1_1_1.setSelectedItem("--SELECT TYPE--");
				comboBox_5_1_1.setSelectedItem("--SELECT--");
				textField_27.setText("");
				textField_29.setText("");
				textField_30.setText("");
				if(flag==1) {
					feed fe=new feed(f,h.cust.get(index).custId,fid);
					fe.setVisible(true);
				}
			}
			
		});
		btnNewButton_9.setBounds(284, 349, 85, 27);
		panel_26.add(btnNewButton_9);
		
		JPanel panel_16 = new JPanel();
		tabbedPane_1.addTab("FEEDBACK", null, panel_16, null);
		panel_16.setLayout(null);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		JButton btnNewButton_10 = new JButton("SHOW FEEDBACK");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_9.setText(" ");
				for(int i=0;i<f.size();i++) {
					textArea_9.append("The Customer id "+f.get(i).cid+" gives  ");
					if(f.get(i).response==1) {
						textArea_9.append("+ve response Feedback : \n");
					}
					else {
						textArea_9.append("-ve response : \n");
					}
					textArea_9.append("----------------------------------------------------------\n");
					textArea_9.append(f.get(i).feed+" \n");
				}
				
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_10.setForeground(new Color(0, 0, 0));
		btnNewButton_10.setBounds(308, 29, 218, 41);
		panel_16.add(btnNewButton_10);
		
		textArea_9.setBounds(10, 92, 869, 391);
		panel_16.add(textArea_9);
	}
	}


