import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;


public class Interface{



	ArrayList<String> array = new ArrayList<String>();
	String[] arr;
	String unsorted = "" , sorted = "";

	public Interface(){

		JFrame f = new JFrame("String Sorter");
		f.setSize(300, 450);
		f.setLocation(450,150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,2));

		JButton b1 = new JButton("Go");

		JComboBox<String> c = new JComboBox<>();
		c.addItem("Print Unsroted");
		c.addItem("Print Sorted");

		p1.add(c);
		p1.add(b1);


		JPanel p2 = new JPanel();

		JTextArea a = new JTextArea(22,21);
		a.setEditable(false);
		JScrollPane sb = new JScrollPane(a);
		sb.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		p2.add(sb);


		JPanel p3 = new JPanel();

		JButton b2 = new JButton("Open");
		JButton b3 = new JButton("Exit");

		JTextField t1 = new JTextField();
		t1.setEditable(false);

		p3.setLayout(new GridLayout(1, 3));
		p3.add(b2);
		p3.add(t1);
		p3.add(b3);


		p.add(p1,BorderLayout.NORTH);
		p.add(p2, BorderLayout.CENTER);
		p.add(p3, BorderLayout.SOUTH);
		f.add(p);


		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				if(c.getSelectedIndex() == 0)
					a.setText(unsorted);
				else
				{
					sorted = "";
					try {
						RadixSort.sort(arr);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i = 0; i < arr.length; i++) {
						
						sorted = sorted + arr[i] + "\n"; 

					}
					a.setText(sorted);
				}



			}
		});


		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sorted = "";
				unsorted = "";
				array.removeAll(array);


				Scanner scan = null;

				JFileChooser f = new JFileChooser();
				f.showOpenDialog(null);
				File file = f.getSelectedFile();
				String fileName = file.getName();
				
				

				t1.setText(fileName);
				

				if(!fileName.endsWith("txt"))
					try {
						

						throw new Exception("the file is not readable");
					} catch (Exception e2) {
						// TODO Auto-generated catch block
//						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "please choose .txt file");
					}

				try {
					scan = new Scanner(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				while(scan.hasNextLine())
					array.add(scan.nextLine());
				
				

				arr = new String[array.size()];

				for (int i = 0; i < array.size(); i++) {
					arr[i] = array.get(i);
					unsorted = unsorted + array.get(i)+"\n";
				}



			}
		});


		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});








		//		f.pack();
		f.setVisible(true);

	}





}