import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.awt.*;

public class Law extends JFrame implements ActionListener {
	public static int addresstemp;
	public static int addresstemppri;
    static String a;
    public static int count;
    public static final int[] Address_list = new int[100];
    public static final String[] Name_list = new String[100];
     public static final String[] Case_list = new String[100];
    public static Law obj = new Law();

    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException, IOException {
    	

        JFrame f = new JFrame("Law Firm Management");
        JButton b = new JButton("Add Case");

        obj.create_index();
        b.setBounds(100, 100, 197, 30);
        b.addActionListener((ActionListener) obj);
        f.add(b);
        f.setSize(420, 600);
        f.setLayout(null);
        f.setVisible(true);

        JButton c = new JButton("Search Case");
        c.setBounds(100, 150, 197, 30);
        c.addActionListener((ActionListener) obj);
        f.add(c);
        f.setLayout(null);
        f.setVisible(true);

        JButton d = new JButton("Show Cases");
        d.setBounds(100, 200, 197, 30);
        d.addActionListener((ActionListener) obj);
        f.add(d);
        f.setLayout(null);
        f.setVisible(true);

//         JButton i = new JButton("Display Index");
//         i.setBounds(130, 250, 150, 30);
//         f.add(i);
//         i.addActionListener((ActionListener) obj);
//         f.setLayout(null);
//         f.setVisible(true);

        JButton e = new JButton("Case Resolved");
        e.setBounds(100, 250, 197, 30);
        e.addActionListener((ActionListener) obj);
        f.add(e);
        f.setLayout(null);
        f.setVisible(true);

        JButton g = new JButton("Out Of The Court Settlement");
        g.setBounds(100, 300, 197, 30);
        g.addActionListener((ActionListener) obj);
        f.add(g);

        f.setLayout(null);
        f.setVisible(true);
        
        JButton r = new JButton("Report");
        r.setBounds(100, 350, 197, 30);
        r.addActionListener((ActionListener) obj);
        f.add(r);

        f.setLayout(null);
        f.setVisible(true);

        JButton h = new JButton("Exit");
        h.setBounds(100, 400, 197, 30);
        f.add(h);
        h.addActionListener((ActionListener) obj);
        f.setLayout(null);
        f.setVisible(true);

    }

    String s1, searchtext;

    public void actionPerformed(ActionEvent e) {
        // JFrame fa=new JFrame("Button Example");
        String s = e.getActionCommand();
        if (s.equals("Add Case")) {
            Frame frame = new JFrame("Case Registration");
            frame.setSize(350, 300);
            ((JFrame) frame).getDefaultCloseOperation();
            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);
            frame.setVisible(true);
        } else if (s.equals("Register")) {
        	int random1 = (int) (Math.random() * 1000);
//            for(int i=0;i<Case_list.length;)
//            {
//            	 if(Case_list[i].equals(null))
//            		 break;
//            	String temp=Case_list[i].substring(1,Case_list[i].length()-1);
//            	if(temp.equals(random1))
//            	{
//            		random1 = (int) (Math.random() * 1000);
//            		i=0;
//            		continue;
//            	}
//            	i++;
//            			
//            }
            
            String code = email.getText() + String.valueOf(random1);
            if(email.getText().length()!=2)
            {
            	JOptionPane.showMessageDialog(frame, "Case Code Should be of Form AA");
            	return;
            	
            }
            s1 = lName.getText() + "|" + fname.getText() + "|" + code + "|" + phNO.getText()+"\n";
            try {
                getdata(s1);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(frame, "Case Registered");

        }
        else if (s.equals("Report")) {
            try {
				report();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        else if (s.equals("Show Cases")) {
            putdata();
        } else if (s.equals("Search Case")) {
            Frame frame = new JFrame("Search");
            frame.setSize(350, 200);
            ((JFrame) frame).getDefaultCloseOperation();
            JPanel panel = new JPanel();
            frame.add(panel);
            searchcomponet(panel);
            frame.setVisible(true);

        } else if (s.equals("search")) {
            searchtext = searchName.getText();
            try {
                searchfun(searchtext);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (s.equals("Display Index")) {
            displayindex();

        } else if (s.equals("Exit")) {
            System.exit(0);

        } else if (s.equals("Case Resolved")) {
            Frame frame = new JFrame("Delete");
            frame.setSize(350, 200);
            ((JFrame) frame).getDefaultCloseOperation();
            JPanel panel = new JPanel();
            frame.add(panel);
            searchcomponet1(panel);
            frame.setVisible(true);

        } else if (s.equals("delete")) {
            searchtext = searchName.getText();
            try {
                searchfun1(searchtext);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if (s.equals("Out Of The Court Settlement")) {
            Frame frame = new JFrame("Delete");
            frame.setSize(350, 200);
            ((JFrame) frame).getDefaultCloseOperation();
            JPanel panel = new JPanel();
            frame.add(panel);
            searchcomponet2(panel);
            frame.setVisible(true);

        } else if (s.equals("Yes")) {
            if (no.isSelected())
                no.setSelected(false);
            try {
                System.out.println("yes pressed");
                deletefunrec(addresstemp);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        else if (s.equals("delete case")) {
            searchtext = searchName.getText();
            System.out.println(searchtext);
            try {
                searchfun2(searchtext);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    int indexheight = 50;
    

    public void deletefunrec(int address) throws IOException {
        RandomAccessFile file = new RandomAccessFile("law_firm.txt", "rw");
//        System.out.println("address"+ addresstemp);

        String del_ch = "*";
        file.seek(address);
        String str = file.readLine();
        System.out.println(str);
        int x = str.indexOf('|');
        x++;
        file.seek(address+x);
        file.writeBytes(del_ch);
//        System.out.println(address+x);
        JOptionPane.showMessageDialog(frame, "Case Removed");

        file.close();
        create_index();
    }

    public static String rightPadding(String input, char ch, int L) {

        String result = String

                // First right pad the string
                // with space up to length L
                .format("%" + (-L) + "s", input)

                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);

        // Return the resultant string
        return result;
    }

    JFrame indexframe = new JFrame();

    void displayindex() {
        JLabel label = new JLabel("Name          " + "Address");
        label.setBounds(0, indexheight, 1000, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        indexframe.add(label);

        for (int i = 0; i <= count; i++) {

            String b = rightPadding(Name_list[i], ' ', 20) + Address_list[i];

            label = new JLabel(b);
            indexheight = indexheight + 50;
            label.setBounds(0, indexheight, 1000, 50);
            label.setFont(new Font(null, Font.PLAIN, 25));

            indexframe.add(label);

            indexframe.getDefaultCloseOperation();
            indexframe.setSize(420, indexheight + 100);
            indexframe.setLayout(null);
            indexframe.setVisible(true);
        }
    }

    public int search_index(String key) {
        int low = 0, high = count, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (Name_list[mid].equals(key))
                return mid;
            if (Name_list[mid].compareTo(key) > 0)
                high = mid - 1;
            if (Name_list[mid].compareTo(key) < 0)
                low = mid + 1;
        }
        return -1;
    }
    public int search_case(String key) {
    	System.out.println(key+"check key");
        for(int i=0;i<Case_list.length;i++)
        {
        	if(Case_list[i]==null)
        	{
        		return -1;
        	}
        	if(Case_list[i].equals(key))
        	{
        		System.out.println(i+"check pos");
        		return i;
        	}
        }
        return -1;
    }

    void searchfun(String key) throws IOException {

        int pos;

        int t = 0;
        pos = search_index(key);
        if (pos != -1) {
            display_record(pos);
            t = pos;
            while ((t < count) && (Name_list[++t].equals(key)))
                display_record(t);
            t = pos;
            while ((t > 0) && (Name_list[--t].equals(key)))
                display_record(t);
        } else
        	JOptionPane.showMessageDialog(frame, "Searched Lawyer Name Not Found");

    }

    JFrame frame = new JFrame();
    int i = 0;
    
    void putdata()
    {
    	
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManarger.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    ex.printStackTrace();
//                }

                JFrame frame = new JFrame("All Cases");
                frame.getDefaultCloseOperation();
                JScrollPane scrollPane = new JScrollPane(new TestPane());
                frame.add(scrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(1500, 900);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements Scrollable {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            
            String name = "", usn = "", sem = "", branch = "", s;
            BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("law_firm.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            try {
            	while ((s = br.readLine()) != null) {
                    String[] result = s.split("\\|");

                    if (result[1].contains("*")) {
                        continue;
                    }
                    int p = 4, o = 0;
                    String[] heading = { "Case Title:", "Lawyer Name:", "Case Code:", "Case Descrpition:" };
                    while (p != 0) {

                        JLabel label = new JLabel(heading[o] + " " + result[o]);

                        k = k + 50;

                        label.setBounds(0, k, 1000, 50);
                        label.setFont(new Font(null, Font.PLAIN, 25));
                        add(label, gbc);
    				    gbc.gridy=gbc.gridy+50;
                        
                        p--;

                        o++;
                        if (p == 0) {
                            label = new JLabel(
                                    "---------------------------------------------------------------------------------------------------------------------------");

                            k = k + 50;

                            label.setBounds(0, k, 1000, 50);
                            label.setFont(new Font(null, Font.PLAIN, 25));

                            add(label, gbc);
        				    gbc.gridy=gbc.gridy+50;
                        }

                    }

                }
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(100, 50);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 32;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 32;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return getPreferredSize().width <= getWidth();
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

    }
         

    
    	
    

    void report() throws IOException {

        String  s;
        int totalcases=0,pending=0,resolved=0,setteled=0;
        BufferedReader br = new BufferedReader(new FileReader("law_firm.txt"));
        while ((s = br.readLine()) != null) {
        	totalcases++;
            String[] result = s.split("\\|");

            if (result[1].contains("*")&&(!result[2].contains("*"))) {
            	resolved++;
            }
            else if (result[1].contains("*")&&(result[2].contains("*"))) {
            	setteled++;
            }
            else
            {
            	pending++;
        }
        }
        br.close();
            int p = 4, o = 0;
            String[] heading = { "Total Cases:", "Pending Cases:", "Resolved Cases:", "Setteled Cases:" };
            int[] arrval = { totalcases,pending,resolved,setteled};
            JFrame frame = new JFrame("Report");
            int h=0;
            while (p != 0) {

                JLabel label = new JLabel(heading[o] + " " + arrval[o]);

                h = h + 50;

                label.setBounds(0, h, 1000, 50);
                label.setFont(new Font(null, Font.PLAIN, 25));

                frame.add(label);

                frame.getDefaultCloseOperation();
//                frame.setSize(1000, k * 5);
                frame.setSize(800, 420);
                frame.setLayout(null);
                frame.setVisible(true);
                o++;
                p--;
                
                

            }
            
        }

    

    int k = 0;
    
    

    public void display_record(int pos) throws IOException {

        RandomAccessFile file = new RandomAccessFile("law_firm.txt", "r");
        int address = Address_list[pos];
        String usn = "", sem = "", branch = "", name = "";
        file.seek(address);
        String s = file.readLine();
        while (s != null) {
            String[] result = s.split("\\|");
            usn = result[0];
            name = result[1];
            sem = result[2];
            branch = result[3];
            String b = name + " | " + usn + " | " + sem + " | " + branch + " | ";
            int p = 4, o = 0;
            String[] heading = { "Case Title:", "Lawyer Name:", "Case Code:", "Case Descrpition:" };
            while (p != 0) {

                JLabel label = new JLabel(heading[o] + " " + result[o]);

                k = k + 50;

                label.setBounds(0, k, 1000, 50);
                label.setFont(new Font(null, Font.PLAIN, 25));

                frame.add(label);

                frame.getDefaultCloseOperation();
                frame.setSize(1000, k * 5);
                frame.setLayout(null);
                frame.setVisible(true);
                p--;

                o++;
                if (p == 0) {
                    label = new JLabel(
                            "---------------------------------------------------------------------------------------------------------------------------");

                    k = k + 50;

                    label.setBounds(0, k, 1000, 50);
                    label.setFont(new Font(null, Font.PLAIN, 25));

                    frame.add(label);

                    frame.getDefaultCloseOperation();
                    frame.setSize(1000, k * 5);
                    frame.setLayout(null);
                    frame.setVisible(true);
                }

            }

            break;
        }
        file.close();
    }

    // public void myMethod() throws IOException {
    //
    // putdata();
    // JFrame frame = new JFrame();
    // JLabel label = new JLabel(a);
    // label.setBounds(0, 0, 1000, 500);
    // label.setFont(new Font(null, Font.PLAIN, 25));
    //
    // frame.add(label);
    //
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setSize(420, 420);
    // frame.setLayout(null);
    // frame.setVisible(true);
    //
    // }

    public void create_index() throws IOException, ArrayIndexOutOfBoundsException {
        count = -1;
        long pos;
        RandomAccessFile file = new RandomAccessFile("law_firm.txt", "r");
        pos = file.getFilePointer();
        String s;
        while ((s = file.readLine()) != null) {
            String[] result = s.split("\\|");
            count++;
             Case_list[count]=result[2];
             System.out.println(result[2]);
            Name_list[count] = result[1];
            Address_list[count] = (int) pos;
            pos = file.getFilePointer();
        }
        file.close();
        sort_index();
    }

    public void sort_index() throws IOException {
        for (int i = 0; i <= count; i++) {
            for (int j = i + 1; j <= count; j++) {
                if (Name_list[i].compareTo(Name_list[j]) > 0) {
                    String temp = Name_list[i];
                    Name_list[i] = Name_list[j];
                    Name_list[j] = temp;
                    int temp1 = Address_list[i];
                    Address_list[i] = Address_list[j];
                    Address_list[j] = temp1;
                    String temp2 = Case_list[i];
                    Case_list[i] = Case_list[j];
                    Case_list[j] = temp2;
                }
            }
        }

        // for(int i=0;i<=count;i++)
        // {
        // System.out.println(Name_list[i]+" "+Address_list[i]);
        // }
    }

    void getdata(String s1) throws ArrayIndexOutOfBoundsException, IOException, FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("law_firm.txt", true));
        pw.println(s1);
        pw.flush();
        pw.close();
        create_index();
    }

    static JTextField fname, lName, email, phNO, searchName;

    private static void searchcomponet(JPanel panel) {
        panel.setLayout(null);
        JLabel userLabel1 = new JLabel("Enter Name");
        userLabel1.setBounds(10, 20, 80, 25);
        panel.add(userLabel1);
        searchName = new JTextField(20);
        searchName.setBounds(100, 20, 165, 25);
        panel.add(searchName);
        JButton srcButton = new JButton("search");
        srcButton.setBounds(120, 100, 80, 25);
        Law obj = new Law();
        srcButton.addActionListener((ActionListener) obj);
        panel.add(srcButton);
    }

    static JRadioButton yes;
    static JRadioButton no;
 

    public void display_record1(int pos) throws IOException {
        RandomAccessFile file = new RandomAccessFile("law_firm.txt", "r");
        int address = Address_list[pos];
        String usn = "", sem = "", branch = "", name = "";
        file.seek(address);
        String s = file.readLine();
        while (s != null) {
            String[] result = s.split("\\|");
            usn = result[0];
            name = result[1];
            sem = result[2];
            branch = result[3];
            String b = name + " | " + usn + " | " + sem + " | " + branch + " | ";

            int p = 4, o = 0;
            String[] heading = { "Case Title:", "Lawyer Name:", "Case Code:", "Case Descrpition:" };
            while (p != 0) {

                JLabel label = new JLabel(heading[o] + " " + result[o]);

                k = k + 50;

                label.setBounds(0, k, 1000, 50);
                label.setFont(new Font(null, Font.PLAIN, 25));

                frame.add(label);

                frame.getDefaultCloseOperation();
                frame.setSize(1000, k * 5);
                frame.setLayout(null);
                frame.setVisible(true);
                p--;

                o++;
                if (p == 0) {
                    label = new JLabel(
                            "---------------------------------------------------------------------------------------------------------------------------");

                    k = k + 50;

                    label.setBounds(0, k + 120, 1000, 50);
                    label.setFont(new Font(null, Font.PLAIN, 25));
                    yes = new JRadioButton("Yes");
                    no = new JRadioButton("No");
                    yes.setBounds(25, k + 20, 80, 60);
                    no.setBounds(25, k + 80, 80, 60);
                    k = k + 100;
                    addresstemp = address;
                    System.out.println(addresstemp);
                    frame.add(yes);
                    frame.add(no);
                    yes.addActionListener((ActionListener) obj);

                    frame.add(label);

                    frame.getDefaultCloseOperation();
                    frame.setSize(1000, k * 5);
                    frame.setLayout(null);
                    frame.setVisible(true);
                }

            }

            break;
        }
        file.close();
    }

    public void display_record2(int pos) throws IOException {
        RandomAccessFile file = new RandomAccessFile("law_firm.txt", "r");
        int address = Address_list[pos];
        String usn = "", sem = "", branch = "", name = "";
        file.seek(address);
        String s = file.readLine();
        while (s != null) {
            String[] result = s.split("\\|");
            usn = result[0];
            name = result[1];
            sem = result[2];
            branch = result[3];
            String b = name + " | " + usn + " | " + sem + " | " + branch + " | ";

            int p = 4, o = 0;
            String[] heading = { "Case Title:", "Lawyer Name:", "Case Code:", "Case Descrpition:" };
            while (p != 0) {

                JLabel label = new JLabel(heading[o] + " " + result[o]);

                k = k + 50;

                label.setBounds(0, k, 1000, 50);
                label.setFont(new Font(null, Font.PLAIN, 25));

                frame.add(label);

                frame.getDefaultCloseOperation();
                frame.setSize(1000, k * 5);
                frame.setLayout(null);
                frame.setVisible(true);
                p--;

                o++;
                if (p == 0) {
                    label = new JLabel(
                            "---------------------------------------------------------------------------------------------------------------------------");

                    k = k + 50;

                    label.setBounds(0, k + 120, 1000, 50);
                    label.setFont(new Font(null, Font.PLAIN, 25));
                    yes = new JRadioButton("yes");
                    no = new JRadioButton("no");
                    yes.setBounds(25, k + 20, 80, 60);
                    no.setBounds(25, k + 80, 80, 60);
                    k = k + 100;
//                    addresstemppri = address;
//                    System.out.println(addresstemppri);
                    frame.add(yes);
                    frame.add(no);
                    yes.addActionListener((ActionListener) obj);

                    frame.add(label);

                    frame.getDefaultCloseOperation();
                    frame.setSize(1000, k * 5);
                    frame.setLayout(null);
                    frame.setVisible(true);
                }

            }

            break;
        }
        file.close();
    }

    public void deletefunrec1(int address) throws IOException {
        RandomAccessFile file = new RandomAccessFile("law_firm.txt", "rw");

        String del_ch = "*";
        file.seek(address);
        String str = file.readLine();
        System.out.println(str+"check this");
      int y = str.indexOf('|');
      y++;
      file.seek(address + y);
      file.writeBytes(del_ch); 
        int x=str.indexOf("|", str.indexOf("|") + 1);
        System.out.println(x+"check this");
//        int x = str.indexOf('|');
//        x++;
//        file.seek(address + x);
//        file.writeBytes(del_ch);
//        String str1 = file.readLine();
//        int y = str1.indexOf('|');
        file.seek(address + x+1);
        file.writeBytes(del_ch);
        JOptionPane.showMessageDialog(frame, "Case Removed");

        file.close();
        create_index();
    }

    void searchfun1(String key) throws IOException {

        int pos;

        int t = 0;
        pos = search_index(key);
        if (pos != -1) {
            display_record1(pos);
            t = pos;
            // while (!issubmit)
            // continue;
            while ((t < count) && (Name_list[++t].equals(key)))
                display_record1(t);
            t = pos;
            while ((t > 0) && (Name_list[--t].equals(key)))
                display_record1(t);
            create_index();
        } else
        	JOptionPane.showMessageDialog(frame, "Searched Lawyer Name Not Found");

    }

    void searchfun2(String key) throws IOException {
    	
        int pos;
        
        pos = search_case(key);System.out.println(pos+"in searchfun2");
    
        System.out.println("exe");
        if(pos!=-1)
        {
        	System.out.println(Address_list[pos]+"addresslist");
        addresstemppri=Address_list[pos];
        deletefunrec1(addresstemppri);
        System.out.println(addresstemppri+"pri");
        create_index();
        }
        else
        {
        	JOptionPane.showMessageDialog(frame, "Case Code Not Found");
        }
        

    }

    private static void searchcomponet1(JPanel panel) {
        panel.setLayout(null);
        JLabel userLabel1 = new JLabel("Enter Name");
        userLabel1.setBounds(10, 20, 80, 25);
        panel.add(userLabel1);
        searchName = new JTextField(20);
        searchName.setBounds(100, 20, 165, 25);
        panel.add(searchName);
        JButton srcButton = new JButton("delete");
        srcButton.setBounds(120, 100, 80, 25);
        Law obj = new Law();
        srcButton.addActionListener((ActionListener) obj);
        panel.add(srcButton);
    }

    private static void searchcomponet2(JPanel panel) {
        panel.setLayout(null);
        JLabel userLabel1 = new JLabel("Enter Case Code");
        userLabel1.setBounds(10, 20, 100, 25);
        panel.add(userLabel1);
        searchName = new JTextField(20);
        searchName.setBounds(120, 20, 165, 25);
        panel.add(searchName);
        JButton srcButton = new JButton("delete case");
        srcButton.setBounds(120, 100, 100, 25);
        Law obj = new Law();
        srcButton.addActionListener((ActionListener) obj);
        panel.add(srcButton);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel userLabel1 = new JLabel("Case Title");
        userLabel1.setBounds(10, 20, 80, 25);
        panel.add(userLabel1);
        JLabel userLabel2 = new JLabel("Lawyer Name");
        userLabel2.setBounds(10, 50, 100, 25);
        panel.add(userLabel2);
        JLabel userLabel3 = new JLabel("Case Code");
        userLabel3.setBounds(10, 80, 80, 25);
        panel.add(userLabel3);
        JLabel userLabel4 = new JLabel("Description");
        userLabel4.setBounds(10, 110, 80, 25);
        panel.add(userLabel4);

        fname = new JTextField(20);
        fname.setBounds(100, 50, 165, 25);
        panel.add(fname);
        lName = new JTextField(20);
        lName.setBounds(100, 20, 165, 25);
        panel.add(lName);
        email = new JTextField(20);
        email.setBounds(100, 80, 165, 25);
        panel.add(email);
        phNO = new JTextField(20);
        phNO.setBounds(100, 110, 165, 25);
        panel.add(phNO);

        JButton loginButton = new JButton("Register");
        loginButton.setBounds(110, 160, 100, 25);
Law obj = new Law();
        loginButton.addActionListener((ActionListener) obj);
        panel.add(loginButton);
        

    }
}