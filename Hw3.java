import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import oracle.jdbc.*;
import oracle.sql.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Hw3 extends javax.swing.JFrame {

    Image img;
    ImageIcon ii;
    
     static String s1 = "",s2 = "",s3="";
    //VARIABLES FOR BUILDING
     static ArrayList<Integer> poly_cordX= new ArrayList<Integer>();
     static ArrayList<Integer> poly_cordY= new ArrayList<Integer>();
     static ArrayList<Integer> vertex= new ArrayList<Integer>();
     static Integer[] x_coordinate_array = {};
     static Integer[] y_coordinate_array = {};
     static Integer[] vertex_array = {};
     
    //VARIABLES FOR PHOTO
     static ArrayList<Integer> photo_cordX= new ArrayList<Integer>();
     static ArrayList<Integer> photo_cordY= new ArrayList<Integer>();
     static Integer[] x_PHOTO_array = {};
     static Integer[] y_PHOTO_array = {};
     
    //VARIABLES FOR PHOTOGRAPHER
     static ArrayList<Integer> photographer_cordX= new ArrayList<Integer>();
     static ArrayList<Integer> photographer_cordY= new ArrayList<Integer>();
     static Integer[] x_PHOTOGRAPHER_array = {};
     static Integer[] y_PHOTOGRAPHER_array = {};
     
     //VARIABLES FOR BUILDING RANGE
     static ArrayList<Integer> building_range_X_Arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> building_range_Y_Arraylist= new ArrayList<Integer>();
     static Integer[] building_range_X_Array = {};
     static Integer[] building_range_Y_Array = {};
     static ArrayList<Integer> vertex_range_arraylist= new ArrayList<Integer>();
     static Integer[] vertex_range_array = {};
     
     ArrayList<Integer> rangequery_xy_selected = new ArrayList<Integer>();
     
     //VARIABLES FOR PHOTO RANGE
     static ArrayList<Integer> x_PHOTO_RANGE_arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> y_PHOTO_RANGE_arraylist= new ArrayList<Integer>();
     static Integer[] x_PHOTO_RANGE_array = {};
     static Integer[] y_PHOTO_RANGE_array = {};
     
     //VARIABLES FOR PHOTOGRAPHER RANGE
     static ArrayList<Integer> x_PHOTOGRAPHER_RANGE_arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> y_PHOTOGRAPHER_RANGE_arraylist= new ArrayList<Integer>();
     static Integer[] x_PHOTOGRAPHER_RANGE_array = {};
     static Integer[] y_PHOTOGRAPHER_RANGE_array = {};
     
     //VARIABLES FOR BUILDING POINT
     int x_point;
     int y_point;
     
     static ArrayList<Integer> building_point_X_Arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> building_point_Y_Arraylist= new ArrayList<Integer>();
     static Integer[] building_point_X_Array = {};
     static Integer[] building_point_Y_Array = {};
     static ArrayList<Integer> vertex_point_arraylist= new ArrayList<Integer>();
     static Integer[] vertex_point_array = {};
     
     static ArrayList<Integer> building_point_X_Arraylist_NN= new ArrayList<Integer>();
     static ArrayList<Integer> building_point_Y_Arraylist_NN= new ArrayList<Integer>();
     static Integer[] building_point_X_Array_NN = {};
     static Integer[] building_point_Y_Array_NN = {};
     static ArrayList<Integer> vertex_point_arraylist_NN= new ArrayList<Integer>();
     static Integer[] vertex_point_array_NN = {};
     //rangequery_xy_selected<Integer> = null;
     
     //VARIABLES FOR PHOTO POINT
     static ArrayList<Integer> photo_point_X_Arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> photo_point_Y_Arraylist= new ArrayList<Integer>();
     static Integer[] photo_point_X_Array = {};
     static Integer[] photo_point_Y_Array = {};
     
     static ArrayList<Integer> photo_point_X_Arraylist_NN= new ArrayList<Integer>();
     static ArrayList<Integer> photo_point_Y_Arraylist_NN= new ArrayList<Integer>();
     static Integer[] photo_point_X_Array_NN = {};
     static Integer[] photo_point_Y_Array_NN = {};
     
     //VARIABLES FOR PHOTOGRAPHER POINT
     static ArrayList<Integer> photographer_point_X_Arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> photographer_point_Y_Arraylist= new ArrayList<Integer>();
     static Integer[] photographer_point_X_Array = {};
     static Integer[] photographer_point_Y_Array = {};
     
     static ArrayList<Integer> photographer_point_X_Arraylist_NN= new ArrayList<Integer>();
     static ArrayList<Integer> photographer_point_Y_Arraylist_NN= new ArrayList<Integer>();
     static Integer[] photographer_point_X_Array_NN = {};
     static Integer[] photographer_point_Y_Array_NN = {};
     
     //VARIABLES FOR FINDING PHOTOS
     static ArrayList<Integer> FINDPHOTO_X_Arraylist= new ArrayList<Integer>();
     static ArrayList<Integer> FINDPHOTO_Y_Arraylist= new ArrayList<Integer>();
     static Integer[] FINDPHOTO_X_Array = {};
     static Integer[] FINDPHOTO_Y_Array = {};
     
     ArrayList<Integer> rangequery_xy_selected_photo = new ArrayList<Integer>();
     int x_point_photographer,x_point_photographer_NN;
     int y_point_photographer,y_point_photographer_NN;
     
     //VARIABLES FOR FINDING PHOTOGRAPHERS
     static ArrayList<Integer> building_x_contains_arraylist = new ArrayList<Integer>();
     static ArrayList<Integer> building_y_contains_arraylist = new ArrayList<Integer>();
     static Integer[] building_x_contains_array = {};
     static Integer[] building_y_contains_array = {};
     static ArrayList<Integer> vertex_contains_arraylist = new ArrayList<Integer>();
     static Integer[] vertex_contains_array = {};
     static int X_building;
     static int Y_building;
     static ArrayList<Integer> photo_distance_X_Arraylist = new ArrayList<Integer>();
     static ArrayList<Integer> photo_distance_Y_Arraylist = new ArrayList<Integer>();
     static Integer[] photo_distance_X_Array = {};
     static Integer[] photo_distance_Y_Array = {};
     static ArrayList<Integer> photographer_distance_X_Arraylist = new ArrayList<Integer>();
     static ArrayList<Integer> photographer_distance_Y_Arraylist = new ArrayList<Integer>();
     static Integer[] photographer_distance_X_Array = {};
     static Integer[] photographer_distance_Y_Array = {};
     
     Polygon p1= new Polygon();
     Polygon p2= new Polygon();
     
     Boolean range_query_selected= false;
     Boolean  whole_selected = false;
     Boolean point_query_selected= false;
     Boolean findphoto_selected= false;
     Boolean findphotographer_selected= false;
     Boolean draw=false;
     
      int count=1; int count1=1; int x1=0,y1=0,x2=0,y2=0; int xfirst = 0,yfirst = 0;
      int count2=0; int x1_photo=0,y1_photo=0,x2_photo=0,y2_photo=0; int xfirst_photo = 0,yfirst_photo = 0;
      String sql_temp="";
      String sq1_submit=""; 
    
    public Hw3() {
        
        initComponents();
        groupButton();
        this.setTitle("Subhadra Ramakrishnan - W1102032");
        
        ImageIcon imgi = new ImageIcon("map.JPG");
        ii=imgi;
        jLabel1.setIcon(imgi);
        img=imgi.getImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setFocusCycleRoot(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setText("Active Feature Type");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Building");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Photo");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Photographer");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setText("Query");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Whole Region");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Range query");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Point query");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Find photos");
        jRadioButton4.setToolTipText("");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("Find photographers");
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton5MouseClicked(evt);
            }
        });
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit    Query");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("SQL Queries:");
        jScrollPane1.setViewportView(jTextArea1);

        jTextField3.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox3)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        

        
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        Graphics g= jLabel1.getGraphics();
        g.drawImage(img,0 , 0, this);
        range_query_selected = false;
        whole_selected = false;
        point_query_selected = true;
        findphoto_selected= false;
        findphotographer_selected= false;
        building_point_X_Arraylist = new ArrayList<Integer>();
        building_point_Y_Arraylist = new ArrayList<Integer>();
        vertex_point_arraylist = new ArrayList<Integer>();
        building_point_X_Arraylist_NN = new ArrayList<Integer>();
        building_point_Y_Arraylist_NN  = new ArrayList<Integer>();
        vertex_point_arraylist_NN  = new ArrayList<Integer>();
        photo_point_X_Arraylist = new ArrayList<Integer>();
        photo_point_Y_Arraylist = new ArrayList<Integer>();
        photo_point_X_Arraylist_NN = new ArrayList<Integer>();
        photo_point_Y_Arraylist_NN = new ArrayList<Integer>();
        photographer_point_X_Arraylist = new ArrayList<Integer>();
        photographer_point_Y_Arraylist = new ArrayList<Integer>();
        photographer_point_X_Arraylist_NN = new ArrayList<Integer>();
        photographer_point_Y_Arraylist_NN = new ArrayList<Integer>();
        g.drawImage(img,0 , 0, this);     

    }                                             

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {                                   

        int xpos = evt.getX();
        int ypos = evt.getY();
        String xy_pos= "Current mouse location: ("+xpos+","+ypos+")";
        jTextField3.setText(xy_pos);
    }                                  

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    Graphics g= jLabel1.getGraphics();
    g.drawImage(img,0 , 0, this);
    whole_selected = true;
    range_query_selected = false;
    point_query_selected = false;
    findphoto_selected= false;
    findphotographer_selected= false;
    }                                             

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        Graphics g= jLabel1.getGraphics();
        g.drawImage(img,0 , 0, this);
        
        if(jRadioButton1.isSelected())
        {
            if(whole_selected = true)
            {
            if(jCheckBox1.isSelected())
                {
                    building_draw(x_coordinate_array,y_coordinate_array,vertex_array,Color.YELLOW);
                    sq1_submit = sq1_submit + "Query"+count+": SELECT t.X,t.Y FROM building Tb, TABLE(SDO_UTIL.GETVERTICES(Tb.BUILDING_SHAPE)) t; \n";
                    count++;
                }
            if(jCheckBox2.isSelected())
                {
                    photo_draw(x_PHOTO_array,y_PHOTO_array,3,Color.BLUE);
                    sq1_submit = sq1_submit + "Query"+count+": SELECT p.X,p.Y FROM PHOTO pb, TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p; \n";
                    count++;
                }
              if(jCheckBox3.isSelected())
                {
                    photographer_draw(x_PHOTOGRAPHER_array,y_PHOTOGRAPHER_array,5,Color.GREEN);
                    sq1_submit = sq1_submit + "Query"+count+": SELECT ph.X,ph.Y FROM PHOTOGRAPHER phb, TABLE(SDO_UTIL.GETVERTICES(phb.PHOTOGRAPHER_LOCATION)) ph; \n";
                    count++;
                }
            }
        }
                
        if(jRadioButton2.isSelected())
        {
            range_query_selected = true;
            Graphics2D g6 =  (Graphics2D) jLabel1.getGraphics();
            g6.setColor(Color.RED);
            g6.setStroke(new BasicStroke(1));
            g6.drawPolygon(p1);
                if(jCheckBox1.isSelected())
                {
                    building_draw(building_range_X_Array,building_range_Y_Array,vertex_range_array,Color.YELLOW);
                    sq1_submit = sq1_submit + "Query"+count+": SELECT t.X,t.Y FROM building B, "
                        + "TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t "
                        + "WHERE sdo_relate(B.BUILDING_SHAPE, "
                        + "SDO_Geometry (2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
                        + "SDO_ORDINATE_ARRAY("+s1+")), "
                        + "'mask=ANYINTERACT') = 'TRUE'; \n";
                    count++;
                }
                
                if(jCheckBox2.isSelected())
                {
                    photo_draw(x_PHOTO_RANGE_array,y_PHOTO_RANGE_array,3,Color.BLUE);
                    sq1_submit = sq1_submit + "Query"+count+": SELECT p.X,p.Y FROM PHOTO pb, "
                    + "TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p\n" +
                    "WHERE sdo_relate(pb.PHOTO_LOCATION,SDO_Geometry (2001, null, null,\n" +
                    "SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+s1+")), 'mask=inside+touch') = 'TRUE'; \n";
                    count++;
                }
                
                if(jCheckBox3.isSelected())
                {                    
                    photographer_draw(x_PHOTOGRAPHER_RANGE_array,y_PHOTOGRAPHER_RANGE_array,5,Color.GREEN);
                    sq1_submit = sq1_submit + "Query"+count+": SELECT p.X,p.Y FROM PHOTOGRAPHER pb, "
                    + "TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p\n" +
                    "WHERE sdo_relate(pb.PHOTOGRAPHER_LOCATION,SDO_Geometry (2001, null, null,\n" +
                    "SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+s1+")), 'mask=inside+touch') = 'TRUE'; \n";
                    count++;
                }
        }
        if(jRadioButton3.isSelected())
        {
            point_query_selected = true;
            Graphics2D g7 =  (Graphics2D) jLabel1.getGraphics();
            g7.setColor(Color.RED);
            g7.setStroke(new BasicStroke(1));
            g7.drawRect(x_point, y_point, 5, 5);
            g7.drawOval(x_point-100,y_point-100,200,200); 
            if(jCheckBox1.isSelected())
              {                    
              building_draw(building_point_X_Array,building_point_Y_Array,vertex_point_array,Color.GREEN);
              building_draw(building_point_X_Array_NN,building_point_Y_Array_NN,vertex_point_array_NN,Color.YELLOW);
              
              sq1_submit = sq1_submit + "Query"+count+":SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t "
              + "WHERE SDO_WITHIN_DISTANCE(B.BUILDING_SHAPE,SDO_Geometry "
              + "(2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
              + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE';\n";
              count++;
              sq1_submit = sq1_submit + "Query"+count+":SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t "
              + "WHERE SDO_NN(B.BUILDING_SHAPE, SDO_Geometry (2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,1), "
              + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and SDO_WITHIN_DISTANCE(B.BUILDING_SHAPE,SDO_Geometry "
              + "(2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
              + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE';\n";
              count++;              
             }
            
            if(jCheckBox2.isSelected())
              {                    
              photo_draw(photo_point_X_Array,photo_point_Y_Array,3,Color.GREEN);
              photo_draw(photo_point_X_Array_NN,photo_point_Y_Array_NN,3,Color.YELLOW);
              
              sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p "
              + "WHERE SDO_WITHIN_DISTANCE(pb.PHOTO_LOCATION, SDO_Geometry (2001, null, null,"
              + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE';\n";
              count++;
              sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p "
              + "WHERE SDO_NN(pb.PHOTO_LOCATION, SDO_Geometry (2001, null, null,"
              + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and SDO_WITHIN_DISTANCE(pb.PHOTO_LOCATION, SDO_Geometry \n" +
              "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE';\n";
              count++;              
             }
            
             if(jCheckBox3.isSelected())
              {                    
              photographer_draw(photographer_point_X_Array,photographer_point_Y_Array,5,Color.GREEN);
              photographer_draw(photographer_point_X_Array_NN,photographer_point_Y_Array_NN,5,Color.YELLOW);
              
              sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p "
              + "WHERE SDO_WITHIN_DISTANCE(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,"
              + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE';\n";
              count++;
              sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p "
              + "WHERE SDO_NN(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,"
              + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and SDO_WITHIN_DISTANCE(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry \n" +
              "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE';\n";
              count++;              
             }
        }
               
             if(jRadioButton4.isSelected())
             {
            Graphics2D g6 =  (Graphics2D) jLabel1.getGraphics();
            g6.setColor(Color.RED);
            g6.setStroke(new BasicStroke(2));
            g6.drawPolygon(p2);
            
               photo_draw(FINDPHOTO_X_Array,FINDPHOTO_Y_Array,3,Color.RED);
               sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p \n" +
               "WHERE sdo_relate(pb.PHOTO_LOCATION,SDO_Geometry (2001, null, null,\n" +
               "SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+s2+")), 'mask=inside+touch') = 'TRUE'\n" +
               "and PHOTOGRAPHER_ID in (SELECT pb.PHOTOGRAPHER_ID FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p \n" +
               "WHERE SDO_NN(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
               "SDO_ORDINATE_ARRAY("+x_point_photographer_NN+","+y_point_photographer_NN+")),'sdo_num_res=1') = 'TRUE');\n";
              count++;
             }
        
             if(jRadioButton5.isSelected())
             {
            Graphics2D g6 =  (Graphics2D) jLabel1.getGraphics();
            g6.setColor(Color.RED);
            g6.setStroke(new BasicStroke(2));
            
            building_draw(building_x_contains_array,building_y_contains_array,vertex_contains_array,Color.RED);
            photo_draw(photo_distance_X_Array,photo_distance_Y_Array,3,Color.RED);
            photographer_draw(photographer_distance_X_Array,photographer_distance_Y_Array,5,Color.RED);
                sq1_submit = sq1_submit + "Query"+count+":SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t \n" +
                " WHERE SDO_CONTAINS(B.BUILDING_SHAPE, SDO_Geometry (2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,1), \n" +
                " SDO_ORDINATE_ARRAY("+X_building+","+Y_building+"))) = 'TRUE';\n";
              count++;
             sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p \n" +
                   "WHERE SDO_WITHIN_DISTANCE(pb.PHOTO_LOCATION, SDO_Geometry \n" +
                   "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
                   "SDO_ORDINATE_ARRAY("+s3+")),'distance = 80') = 'TRUE';\n"; 
              count++;
               sq1_submit = sq1_submit + "Query"+count+":SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p \n" +
                   "WHERE SDO_WITHIN_DISTANCE(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry \n" +
                   "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
                   "SDO_ORDINATE_ARRAY("+s3+")),'distance = 80') = 'TRUE';\n"; 
              count++;
             }
        jTextArea1.setText(sq1_submit);
       
        //s1="";        
    }                                     

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:

        if(range_query_selected==true)
        {
            Graphics g4 = jLabel1.getGraphics();
            g4.setColor(Color.RED);
            p1.addPoint(evt.getX(),evt.getY());
                        
            if(SwingUtilities.isLeftMouseButton(evt))
            {
                         if(count1==1)
                    {
                         x1= evt.getX();
                         y1= evt.getY();
                         //System.out.println(x1+"," +y1);
                         xfirst=x1;
                         yfirst=y1;
                        count1++;
                    }
                        
                if(count1>=2)
                {      
                         x2=evt.getX();
                         y2= evt.getY();
                         //System.out.println(x2+ ","+y2);
                         count1++;
                         g4.drawLine(x1, y1, x2, y2);
                         x1=x2;
                         y1=y2;
                }
            }

    if(SwingUtilities.isRightMouseButton(evt))
    {
                x1= evt.getX();
                y1= evt.getY();
               g4.drawLine(x2, y2, x1, y1);
               g4.drawLine(x1, y1, xfirst, yfirst);
               for(int i=0;i<p1.npoints;i++)
               {
                  rangequery_xy_selected.add(p1.xpoints[i]);
                  rangequery_xy_selected.add(p1.ypoints[i]);
               }
            range_query_selected=false;
            for(int i=0;i<rangequery_xy_selected.size();i++)
             {
                 s1+=rangequery_xy_selected.get(i)+",";
             }
             s1+=rangequery_xy_selected.get(0)+","+rangequery_xy_selected.get(1);
      try
     {
        Connection conn=null;
        System.out.println("Trying to connect to database");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@dbserver.engr.scu.edu:1521:db11g","sramakri","password");
        System.out.println("Connected");    
        
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();
        
        String vertice_range = "SELECT (SDO_UTIL.GETNUMVERTICES(BUILDING_SHAPE)) as no_of_vertices FROM building B "
                        + "WHERE sdo_relate(B.BUILDING_SHAPE, "
                        + "SDO_Geometry (2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
                        + "SDO_ORDINATE_ARRAY("+s1+")), 'mask=ANYINTERACT') = 'TRUE'";
        ResultSet rs5 = stmt.executeQuery(vertice_range);
      
      while(rs5.next())
      {
         int vert = rs5.getInt("no_of_vertices");
         vertex_range_arraylist.add(vert);
      }
	vertex_range_array = vertex_range_arraylist.toArray(vertex_range_array);  
       rs5.close();
       
       String sql_range_building= "SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t "
                        + "WHERE sdo_relate(B.BUILDING_SHAPE, "
                        + "SDO_Geometry (2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
                        + "SDO_ORDINATE_ARRAY("+s1+")), 'mask=ANYINTERACT') = 'TRUE'";
       ResultSet rs4 = stmt.executeQuery(sql_range_building);
       while(rs4.next())
      {
      int X_building_range  = rs4.getInt("X");
      building_range_X_Arraylist.add(X_building_range);
      int Y_building_range = rs4.getInt("Y");
      building_range_Y_Arraylist.add(Y_building_range);
      } 
      building_range_X_Array = building_range_X_Arraylist.toArray(building_range_X_Array);
      building_range_Y_Array = building_range_Y_Arraylist.toArray(building_range_Y_Array);
      rs4.close();
      
      //CHECKING RANGE QUERY INTERACTION WITH PHOTO TABLE
      String sql_range_photo= "SELECT p.X,p.Y FROM PHOTO pb, "
                    + "TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p " +
                    "WHERE sdo_relate(pb.PHOTO_LOCATION,SDO_Geometry (2001, null, null," +
                    "SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+s1+")), 'mask=inside+touch') = 'TRUE' \n";
      //System.out.print(sql_range_photo);
       ResultSet rs6 = stmt.executeQuery(sql_range_photo);
       while(rs6.next())
      {
      int X_photo_range  = rs6.getInt("X");
      //System.out.print("x:" +X_photo_range);
      x_PHOTO_RANGE_arraylist.add(X_photo_range);
      int Y_photo_range = rs6.getInt("Y");
       //System.out.print("y:" +Y_photo_range);
      y_PHOTO_RANGE_arraylist.add(Y_photo_range);
      } 
      x_PHOTO_RANGE_array = x_PHOTO_RANGE_arraylist.toArray(x_PHOTO_RANGE_array);
      y_PHOTO_RANGE_array = y_PHOTO_RANGE_arraylist.toArray(y_PHOTO_RANGE_array);
     
      rs6.close();
      
      //CHECKING RANGE QUERY INTERACTION WITH PHOTO TABLE
      String sql_range_photographer= "SELECT p.X,p.Y FROM PHOTOGRAPHER pb, "
                    + "TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p " +
                    "WHERE sdo_relate(pb.PHOTOGRAPHER_LOCATION,SDO_Geometry (2001, null, null," +
                    "SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+s1+")), 'mask=inside+touch') = 'TRUE' \n";
      //System.out.print(sql_range_photographer);
       ResultSet rs7 = stmt.executeQuery(sql_range_photographer);
       while(rs7.next())
      {
      int X_photographer_range  = rs7.getInt("X");
      x_PHOTOGRAPHER_RANGE_arraylist.add(X_photographer_range);
      int Y_photographer_range = rs7.getInt("Y");
      y_PHOTOGRAPHER_RANGE_arraylist.add(Y_photographer_range);
      } 
      x_PHOTOGRAPHER_RANGE_array = x_PHOTOGRAPHER_RANGE_arraylist.toArray(x_PHOTOGRAPHER_RANGE_array);
      y_PHOTOGRAPHER_RANGE_array = y_PHOTOGRAPHER_RANGE_arraylist.toArray(y_PHOTOGRAPHER_RANGE_array);
      
      rs7.close();

     }
        catch(SQLException e)
        {
        e.printStackTrace();
        System.err.println("Error while connecting!");
        }        
    }

  }
        
    if(point_query_selected==true)
    {
            Graphics2D g5 =  (Graphics2D) jLabel1.getGraphics();
            g5.setColor(Color.RED);
            g5.setStroke(new BasicStroke(1));
                                   
       if(SwingUtilities.isLeftMouseButton(evt))
      {
            x_point= evt.getX();
            y_point= evt.getY();
            g5.drawRect(x_point, y_point,5,5);
            int x = x_point-(100);
            int y = y_point-(100);
            g5.drawOval(x,y,200,200); 
            
          
     try
     {
        Connection conn=null;
        System.out.println("Trying to connect to database");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@dbserver.engr.scu.edu:1521:db11g","sramakri","password");
        System.out.println("Connected");    
        
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();    
      //CHECKING POINT QUERY INTERACTION WITH BUILDING TABLE
      String vertice_point = "SELECT (SDO_UTIL.GETNUMVERTICES(BUILDING_SHAPE)) as no_of_vertices FROM building B "
                        + "WHERE SDO_WITHIN_DISTANCE(B.BUILDING_SHAPE,SDO_Geometry "
              + "(2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
              + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
                " 'distance = 100') = 'TRUE'";
      ResultSet rs8 = stmt.executeQuery(vertice_point);
      while(rs8.next())
      {
         int vert = rs8.getInt("no_of_vertices");
         vertex_point_arraylist.add(vert);
      }
       vertex_point_array = vertex_point_arraylist.toArray(vertex_point_array);  
       rs8.close();
       
       String sql_point_building= "SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t "
              + "WHERE SDO_WITHIN_DISTANCE(B.BUILDING_SHAPE,SDO_Geometry "
              + "(2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
              + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
                " 'distance = 100') = 'TRUE'";
       ResultSet rs9 = stmt.executeQuery(sql_point_building);
       while(rs9.next())
      {
      int X_building_point  = rs9.getInt("X");
      //System.out.print("X:"+X_building_point);
      building_point_X_Arraylist.add(X_building_point);
      int Y_building_point = rs9.getInt("Y");
      //System.out.print("Y:"+Y_building_point);
      building_point_Y_Arraylist.add(Y_building_point);
      } 
      building_point_X_Array = building_point_X_Arraylist.toArray(building_point_X_Array);
      building_point_Y_Array = building_point_Y_Arraylist.toArray(building_point_Y_Array);
      rs9.close();
      
      //CHECKING POINT QUERY NEAREST NEIGHBOUR WITH BUILDING TABLE
      String vertice_point_NN = "SELECT (SDO_UTIL.GETNUMVERTICES(BUILDING_SHAPE)) as no_of_vertices  FROM building B "
    + "WHERE SDO_NN(B.BUILDING_SHAPE, SDO_Geometry (2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,1), "
    + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and "
        + "SDO_WITHIN_DISTANCE(B.BUILDING_SHAPE,SDO_Geometry "
        + "(2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
        + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
        " 'distance = 100') = 'TRUE'";
      //System.out.println(vertice_point_NN);
      ResultSet rs10 = stmt.executeQuery(vertice_point_NN);
      while(rs10.next())
      {
         int vert = rs10.getInt("no_of_vertices");
         vertex_point_arraylist_NN.add(vert);
      }
       vertex_point_array_NN = vertex_point_arraylist_NN.toArray(vertex_point_array_NN);  
       rs10.close();
       
        String sql_point_building_NN= "SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t "
        + "WHERE SDO_NN(B.BUILDING_SHAPE, SDO_Geometry (2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,1), "
        + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and "
        + "SDO_WITHIN_DISTANCE(B.BUILDING_SHAPE,SDO_Geometry "
        + "(2003, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),"
        + "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
        " 'distance = 100') = 'TRUE'";
    //System.out.println(sql_point_building_NN);
       ResultSet rs11 = stmt.executeQuery(sql_point_building_NN);
       while(rs11.next())
      {
      int X_building_point_NN  = rs11.getInt("X");
      //System.out.print(X_building_point_NN);
      building_point_X_Arraylist_NN.add(X_building_point_NN);
      int Y_building_point_NN = rs11.getInt("Y");
      //System.out.print(Y_building_point_NN);
      building_point_Y_Arraylist_NN.add(Y_building_point_NN);
      } 
      building_point_X_Array_NN = building_point_X_Arraylist_NN.toArray(building_point_X_Array_NN);
      building_point_Y_Array_NN = building_point_Y_Arraylist_NN.toArray(building_point_Y_Array_NN);
      rs11.close(); 
      
      //CHECKING POINT QUERY INTERACTION WITH PHOTO TABLE
       String sql_point_photo = "SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p "
              + "WHERE SDO_WITHIN_DISTANCE(pb.PHOTO_LOCATION, SDO_Geometry (2001, null, null,"
              + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE'";

       ResultSet rs12 = stmt.executeQuery(sql_point_photo);
       while(rs12.next())
      {
      int X_photo_point  = rs12.getInt("X");
      photo_point_X_Arraylist.add(X_photo_point);
      int Y_photo_point = rs12.getInt("Y");
      photo_point_Y_Arraylist.add(Y_photo_point);
      } 
      photo_point_X_Array = photo_point_X_Arraylist.toArray(photo_point_X_Array);
      photo_point_Y_Array = photo_point_Y_Arraylist.toArray(photo_point_Y_Array);
      rs12.close();
      
      //CHECKING POINT QUERY NEAREST NEIGHBOUR WITH PHOTO TABLE
       String sql_point_photo_NN = "SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p "
       + "WHERE SDO_NN(pb.PHOTO_LOCATION, SDO_Geometry (2001, null, null,"
       + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
       "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and SDO_WITHIN_DISTANCE(pb.PHOTO_LOCATION, SDO_Geometry \n" +
       "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
       "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
       " 'distance = 100') = 'TRUE'";
       ResultSet rs13 = stmt.executeQuery(sql_point_photo_NN);
       while(rs13.next())
      {
      int X_photo_point_NN  = rs13.getInt("X");
      photo_point_X_Arraylist_NN.add(X_photo_point_NN);
      int Y_photo_point_NN = rs13.getInt("Y");
      photo_point_Y_Arraylist_NN.add(Y_photo_point_NN);
      } 
      photo_point_X_Array_NN = photo_point_X_Arraylist_NN.toArray(photo_point_X_Array_NN);
      photo_point_Y_Array_NN = photo_point_Y_Arraylist_NN.toArray(photo_point_Y_Array_NN);
      rs13.close();
      
      //CHECKING POINT QUERY INTERACTION WITH PHOTOGRAPHER TABLE
       String sql_point_photographer = "SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p "
              + "WHERE SDO_WITHIN_DISTANCE(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,"
              + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
              "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
              " 'distance = 100') = 'TRUE'";

       ResultSet rs14 = stmt.executeQuery(sql_point_photographer);
       while(rs14.next())
      {
      int X_photographer_point  = rs14.getInt("X");
      photographer_point_X_Arraylist.add(X_photographer_point);
      int Y_photographer_point = rs14.getInt("Y");
      photographer_point_Y_Arraylist.add(Y_photographer_point);
      } 
      photographer_point_X_Array = photographer_point_X_Arraylist.toArray(photographer_point_X_Array);
      photographer_point_Y_Array = photographer_point_Y_Arraylist.toArray(photographer_point_Y_Array);
      rs14.close();
      
      //CHECKING POINT QUERY NEAREST NEIGHBOUR WITH PHOTO TABLE
       String sql_point_photographer_NN = "SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p "
       + "WHERE SDO_NN(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,"
       + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
       "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),'sdo_num_res=1') = 'TRUE' and SDO_WITHIN_DISTANCE(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry \n" +
       "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
       "SDO_ORDINATE_ARRAY("+x_point+","+y_point+")),\n" +
       " 'distance = 100') = 'TRUE'";
       ResultSet rs15 = stmt.executeQuery(sql_point_photographer_NN);
       while(rs15.next())
      {
      int X_photographer_point_NN  = rs15.getInt("X");
      photographer_point_X_Arraylist_NN.add(X_photographer_point_NN);
      int Y_photographer_point_NN = rs15.getInt("Y");
      photographer_point_Y_Arraylist_NN.add(Y_photographer_point_NN);
      } 
      photographer_point_X_Array_NN = photographer_point_X_Arraylist_NN.toArray(photographer_point_X_Array_NN);
      photographer_point_Y_Array_NN = photographer_point_Y_Arraylist_NN.toArray(photographer_point_Y_Array_NN);
      rs15.close();
      
     }
      catch(SQLException e)
        {
        e.printStackTrace();
        System.err.println("Error while connecting!");
        }
      }
    } 
     //point_query_selected = false;
     //CHECKING RANGE QUERY INTERACTION WITH BUILDING TABLE
    
      if(findphoto_selected==true)
        {
            Graphics2D g5 =  (Graphics2D) jLabel1.getGraphics();
            g5.setColor(Color.RED);
            g5.setStroke(new BasicStroke(3));
                                                           
            if(SwingUtilities.isLeftMouseButton(evt))
            {
                  if(count2==0)
                  {
                    x_point_photographer= evt.getX();
                    y_point_photographer= evt.getY();
                    //System.out.println("Point:"+x_point_photographer+ ","+y_point_photographer);
                    try
                    {
                    Connection conn=null;
                    System.out.println("Trying to connect to database");
                    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbserver.engr.scu.edu:1521:db11g","sramakri","password");
                    System.out.println("Connected");    
        
                    System.out.println("Creating statement...");
                    Statement stmt = conn.createStatement();
        
                    String sql_point_photographer_NN = "SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p "
                    + "WHERE SDO_NN(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,"
                    + "SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
                    "SDO_ORDINATE_ARRAY("+x_point_photographer+","+y_point_photographer+")),'sdo_num_res=1') = 'TRUE'";

                    ResultSet rs16 = stmt.executeQuery(sql_point_photographer_NN);
                    while(rs16.next())
                    {
                    x_point_photographer_NN  = rs16.getInt("X");
                    y_point_photographer_NN = rs16.getInt("Y");
                    } 
                    rs16.close();
                    }
                    catch(SQLException e)
                    {
                    e.printStackTrace();
                    System.err.println("Error while connecting!");
                    }
                    g5.drawRect(x_point_photographer_NN, y_point_photographer_NN,5,5);
                    //System.out.println(x_point_photographer_NN);
                    //System.out.println(y_point_photographer_NN);
                    //System.out.println("count2_0:"+count2);
                    count2++;
                  }                             
                                
              if(count2==1)
              {
                        x1_photo= evt.getX();
                        y1_photo= evt.getY();
                        count2++;
               }
                        
                if(count2>=2)
                    {  
                         x2_photo=evt.getX();
                         y2_photo= evt.getY();
                         //System.out.println(x2+ ","+y2);
                         count2++;
                         //System.out.println(x1_photo+ ","+y1_photo+","+x2_photo+","+y2_photo);
                         
                         if(count2==5)
                         {
                           xfirst_photo=x1_photo;
                           yfirst_photo=y1_photo;
                         }
                         
                         if(count2>=4)
                         {
                             p2.addPoint(evt.getX(),evt.getY());
                         }
                         if(count2>=5)
                         {
                         p2.addPoint(evt.getX(),evt.getY());
                         g5.drawLine(x1_photo, y1_photo, x2_photo, y2_photo);
                         }
                         x1_photo=x2_photo;
                         y1_photo=y2_photo;
                            
            //count2=0;
                    }
        }
             if(SwingUtilities.isRightMouseButton(evt))
            {
                p2.addPoint(evt.getX(),evt.getY());
                x1_photo= evt.getX();
                y1_photo= evt.getY();
                //System.out.println("Right mouse"+x2_photo+","+y2_photo+";"+x1_photo+","+y1_photo);
               g5.drawLine(x2_photo, y2_photo, x1_photo, y1_photo);
               //System.out.println("Right mouse finish"+x1_photo+","+y1_photo+";"+xfirst_photo+","+yfirst_photo);
               //g5.drawPolygon(p1);
               g5.drawLine(x1_photo, y1_photo, xfirst_photo, yfirst_photo);
               for(int i=0;i<p2.npoints;i++)
               {
                  rangequery_xy_selected_photo.add(p2.xpoints[i]);
                  rangequery_xy_selected_photo.add(p2.ypoints[i]);
               }
            findphoto_selected=false;
            s2="";
             for(int i=0;i<rangequery_xy_selected_photo.size();i++)
             {
                 s2+=rangequery_xy_selected_photo.get(i)+",";
             }
             s2+=rangequery_xy_selected_photo.get(0)+","+rangequery_xy_selected_photo.get(1);
            }
           //System.out.print("String:"+s1);
             
            try
            {
            Connection conn=null;
            System.out.println("Trying to connect to database");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@dbserver.engr.scu.edu:1521:db11g","sramakri","password");
            System.out.println("Connected");    
        
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
                    
            String sql_findphoto = "SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p \n" +
            "WHERE sdo_relate(pb.PHOTO_LOCATION,SDO_Geometry (2001, null, null,\n" +
            "SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+s2+")), 'mask=inside+touch') = 'TRUE'\n" +
            "and PHOTOGRAPHER_ID in (SELECT pb.PHOTOGRAPHER_ID FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p \n" +
            "WHERE SDO_NN(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry (2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
            "SDO_ORDINATE_ARRAY("+x_point_photographer_NN+","+y_point_photographer_NN+")),'sdo_num_res=1') = 'TRUE')";
       ResultSet rs17 = stmt.executeQuery(sql_findphoto);
       //System.out.println(sql_findphoto);
       while(rs17.next())
      {
      int X_findphoto  = rs17.getInt("X");
      //System.out.println("X:"+X_findphoto);
      FINDPHOTO_X_Arraylist.add(X_findphoto);
      int Y_findphoto = rs17.getInt("Y");
      //System.out.println("Y:"+Y_findphoto);
      FINDPHOTO_Y_Arraylist.add(Y_findphoto);
      } 
      FINDPHOTO_X_Array = FINDPHOTO_X_Arraylist.toArray(FINDPHOTO_X_Array);
      FINDPHOTO_Y_Array = FINDPHOTO_Y_Arraylist.toArray(FINDPHOTO_Y_Array);
      rs17.close();
                    
            }
            catch(SQLException e)
            {
            e.printStackTrace();
            System.err.println("Error while connecting!");
            }
            
        }
      
            if(findphotographer_selected==true)
        {
            Graphics2D g5 =  (Graphics2D) jLabel1.getGraphics();
            g5.setColor(Color.RED);
            g5.setStroke(new BasicStroke(3));
                                                           
            if(SwingUtilities.isLeftMouseButton(evt))
            {                  
                    int x_point_building= evt.getX();
                    int y_point_building= evt.getY();
                    //System.out.println("Point:"+x_point_photographer+ ","+y_point_photographer);
                    try
                    {
                    Connection conn=null;
                    System.out.println("Trying to connect to database");
                    conn=DriverManager.getConnection("jdbc:oracle:thin:@dbserver.engr.scu.edu:1521:db11g","sramakri","password");
                    System.out.println("Connected");    
        
                    System.out.println("Creating statement...");
                    Statement stmt = conn.createStatement();
        
                    String sql_building_contains = " SELECT t.X,t.Y FROM building B, TABLE(SDO_UTIL.GETVERTICES(B.BUILDING_SHAPE)) t \n" +
                    " WHERE SDO_CONTAINS(B.BUILDING_SHAPE, SDO_Geometry (2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,1), \n" +
                    " SDO_ORDINATE_ARRAY("+x_point_building+","+y_point_building+"))) = 'TRUE'";

                    ResultSet rs18 = stmt.executeQuery(sql_building_contains);
                    while(rs18.next())
                    {
                    X_building  = rs18.getInt("X");
                    building_x_contains_arraylist.add(X_building);
                    Y_building = rs18.getInt("Y");
                    building_y_contains_arraylist.add(Y_building);
                    } 
                    building_x_contains_array = building_x_contains_arraylist.toArray(building_x_contains_array);
                    building_y_contains_array = building_y_contains_arraylist.toArray(building_y_contains_array);
                    rs18.close();
                    
                    String sql_vertex_building_contains = " SELECT (SDO_UTIL.GETNUMVERTICES(BUILDING_SHAPE)) as no_of_vertices \n" +
                    " FROM building B  WHERE SDO_CONTAINS(B.BUILDING_SHAPE, SDO_Geometry (2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,1), \n" +
                    " SDO_ORDINATE_ARRAY("+x_point_building+","+y_point_building+"))) = 'TRUE'";
     
                    ResultSet rs19 = stmt.executeQuery(sql_vertex_building_contains);
                    while(rs19.next())
                    {
                    int vert = rs19.getInt("no_of_vertices");
                    vertex_contains_arraylist.add(vert);
                    }
                    vertex_contains_array = vertex_contains_arraylist.toArray(vertex_contains_array);  
                    rs19.close();
                    
             for(int i=0;i<building_x_contains_arraylist.size()-1;i++)
             {
               s3+=building_x_contains_arraylist.get(i)+","+building_y_contains_arraylist.get(i)+",";
             }
             s3+=building_x_contains_arraylist.get(building_x_contains_arraylist.size()-1)+","+building_y_contains_arraylist.get(building_x_contains_arraylist.size()-1);
             //System.out.println(s3);
             
                   String sql_building_photo_distance = "SELECT p.X,p.Y FROM PHOTO pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p \n" +
                   "WHERE SDO_WITHIN_DISTANCE(pb.PHOTO_LOCATION, SDO_Geometry \n" +
                   "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
                   "SDO_ORDINATE_ARRAY("+s3+")),'distance = 80') = 'TRUE'";
                   ResultSet rs20 = stmt.executeQuery(sql_building_photo_distance);
                   while(rs20.next())
                   {
                   int X_photo_distance  = rs20.getInt("X");
                   photo_distance_X_Arraylist.add(X_photo_distance);
                   int Y_photo_distance = rs20.getInt("Y");
                   photo_distance_Y_Arraylist.add(Y_photo_distance);
                   } 
                   photo_distance_X_Array = photo_distance_X_Arraylist.toArray(photo_distance_X_Array);
                   photo_distance_Y_Array = photo_distance_Y_Arraylist.toArray(photo_distance_Y_Array);
                   rs20.close(); 
                   
                   String sql_building_photographer_distance = "SELECT p.X,p.Y FROM PHOTOGRAPHER pb,TABLE(SDO_UTIL.GETVERTICES(pb.PHOTOGRAPHER_LOCATION)) p \n" +
                   "WHERE SDO_WITHIN_DISTANCE(pb.PHOTOGRAPHER_LOCATION, SDO_Geometry \n" +
                   "(2001, null, null,SDO_ELEM_INFO_ARRAY(1,1003,1),\n" +
                   "SDO_ORDINATE_ARRAY("+s3+")),'distance = 80') = 'TRUE'";
                   ResultSet rs21 = stmt.executeQuery(sql_building_photographer_distance);
                   while(rs21.next())
                   {
                   int X_photographer_distance  = rs21.getInt("X");
                   photographer_distance_X_Arraylist.add(X_photographer_distance);
                   int Y_photographer_distance = rs21.getInt("Y");
                   photographer_distance_Y_Arraylist.add(Y_photographer_distance);
                   } 
                   photographer_distance_X_Array = photographer_distance_X_Arraylist.toArray(photographer_distance_X_Array);
                   photographer_distance_Y_Array = photographer_distance_Y_Arraylist.toArray(photographer_distance_Y_Array);
                   rs21.close(); 
                    
                    }
                    catch(SQLException e)
                    {
                    e.printStackTrace();
                    System.err.println("Error while connecting!");
                    }                 
                    building_draw(building_x_contains_array,building_y_contains_array,vertex_contains_array,Color.RED);
                   }
        }
     
    }                                    

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        Graphics g= jLabel1.getGraphics();
        g.drawImage(img,0 , 0, this);
        whole_selected = false;
        range_query_selected = true;
        point_query_selected = false;
        findphoto_selected= false;
        findphotographer_selected= false;
        rangequery_xy_selected = new ArrayList<Integer>();
        building_range_X_Arraylist = new ArrayList<Integer>();
        building_range_Y_Arraylist = new ArrayList<Integer>();
        vertex_range_arraylist = new ArrayList<Integer>();
        x_PHOTO_RANGE_arraylist = new ArrayList<Integer>();
        y_PHOTO_RANGE_arraylist = new ArrayList<Integer>();
        x_PHOTOGRAPHER_RANGE_arraylist = new ArrayList<Integer>();
        y_PHOTOGRAPHER_RANGE_arraylist = new ArrayList<Integer>();
        count1=1;
        p1.reset();
        s1="";
        g.drawImage(img,0 , 0, this);
    }                                             

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
        whole_selected = false;
        range_query_selected = true;
        point_query_selected = false;
        findphoto_selected= false;
        findphotographer_selected= false;
    }                                          

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
        whole_selected = false;
        range_query_selected = false;
        point_query_selected = true;
        findphoto_selected= false;
        findphotographer_selected= false; 

    }                                          

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        Graphics g= jLabel1.getGraphics();
        g.drawImage(img,0 , 0, this);
        range_query_selected = false;
        whole_selected = false;
        point_query_selected = false;
        findphoto_selected= true;
        findphotographer_selected= false;
        FINDPHOTO_X_Arraylist = new ArrayList<Integer>();
        FINDPHOTO_Y_Arraylist = new ArrayList<Integer>();
        p2.reset();
        count2=0;
        g.drawImage(img,0 , 0, this);
    }                                             

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
    whole_selected = true;
    range_query_selected = false;
    point_query_selected = false;
    findphoto_selected= false;
    findphotographer_selected= false;
    }                                          

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
    whole_selected = false;
    range_query_selected = false;
    point_query_selected = false;
    findphoto_selected= true;
    findphotographer_selected= false;
    building_draw(x_coordinate_array,y_coordinate_array,vertex_array,Color.YELLOW);
    photo_draw(x_PHOTO_array,y_PHOTO_array,3,Color.BLUE);
    photographer_draw(x_PHOTOGRAPHER_array,y_PHOTOGRAPHER_array,5,Color.GREEN);    
    }                                          

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        Graphics g= jLabel1.getGraphics();
        g.drawImage(img,0 , 0, this);
        range_query_selected = false;
        whole_selected = false;
        point_query_selected = false;
        findphoto_selected= false;
        findphotographer_selected= true;
        building_x_contains_arraylist = new ArrayList<Integer>();
        building_y_contains_arraylist = new ArrayList<Integer>();
        vertex_contains_arraylist = new ArrayList<Integer>();
        g.drawImage(img,0 , 0, this);
        photo_distance_X_Arraylist = new ArrayList<Integer>();
        photo_distance_Y_Arraylist = new ArrayList<Integer>();
        photographer_distance_X_Arraylist = new ArrayList<Integer>();
        photographer_distance_Y_Arraylist = new ArrayList<Integer>();
        s3="";
    }                                             

    private void jRadioButton5MouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
    whole_selected = false;
    range_query_selected = false;
    point_query_selected = false;
    findphoto_selected= false;
    findphotographer_selected= true;
    building_draw(x_coordinate_array,y_coordinate_array,vertex_array,Color.YELLOW);
    photo_draw(x_PHOTO_array,y_PHOTO_array,3,Color.BLUE);
    photographer_draw(x_PHOTOGRAPHER_array,y_PHOTOGRAPHER_array,5,Color.GREEN);
    }                                          

    //Method for drawing building polygons
    public void building_draw(Integer[] x_coordinate_array,Integer[] y_coordinate_array,Integer[] vertex_array,Color s)
      {
           Graphics2D g1 =  (Graphics2D) jLabel1.getGraphics();
           g1.setColor(s);
           g1.setStroke(new BasicStroke(2));
           
           int count=0;
           System.out.println("Vertex array length"+vertex_array.length);
       for(int vertex_count=0;vertex_count<vertex_array.length;vertex_count++)
       {
       Polygon p= new Polygon();
       
       for(int i=0; i<vertex_array[vertex_count]; i++)
       {
           System.out.println("Vertex Array: "+vertex_array[vertex_count]);
       p.addPoint(x_coordinate_array[i+count],y_coordinate_array[i+count]);
       System.out.println(x_coordinate_array[i+count]+","+y_coordinate_array[i+count]);
       }
       g1.drawPolygon(p);
       count += vertex_array[vertex_count];
       //System.out.println("Polygon points:"+p.npoints);
       }       
        whole_selected = false;
      }
    
    //Method for drawing photo circles
        public void photo_draw(Integer[] x_PHOTO_array_function,Integer[] y_PHOTO_array_function,int radius, Color s)
      {
           Graphics2D g2 =  (Graphics2D) jLabel1.getGraphics();
           g2.setColor(s);
           g2.setStroke(new BasicStroke(2));
           System.out.println("x_PHOTO_array"+x_PHOTO_array_function.length);
           
           for(int i=0;i<x_PHOTO_array_function.length;i++)
           {
           g2.drawOval(x_PHOTO_array_function[i],y_PHOTO_array_function[i],radius,radius); 
           System.out.println("Photo:"+x_PHOTO_array_function[i]+","+y_PHOTO_array_function[i]);
           }

      }
        
        //Method for drawing photographer sqaures
      public void photographer_draw(Integer[] x_PHOTOGRAPHER_array,Integer[] y_PHOTOGRAPHER_array,int length,Color s)
      {
           Graphics2D g3 =  (Graphics2D) jLabel1.getGraphics();
           g3.setColor(s);
           g3.setStroke(new BasicStroke(2));
           
           for(int i=0;i<x_PHOTOGRAPHER_array.length;i++)
           {
               System.out.println("x_PHOTOGRAPHER_array"+x_PHOTOGRAPHER_array.length);
               System.out.println("photographer"+x_PHOTOGRAPHER_array[i]+","+y_PHOTOGRAPHER_array[i]);
               g3.drawRect(x_PHOTOGRAPHER_array[i],y_PHOTOGRAPHER_array[i],length,length);  
           }         
      }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Connection conn=null;
  
    try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
    }catch(ClassNotFoundException e) {
          System.err.println("The driver is not loaded properly");
    }

    try
    {
        System.out.println("Trying to connect to database");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@dbserver.engr.scu.edu:1521:db11g","sramakri","password");
        System.out.println("Connected");    
        
        System.out.println("Creating statement...");
      Statement stmt = conn.createStatement();
      
      //POPOLATE DATA FROM BUILDING TABLE
      String vertice_sql = "SELECT (SDO_UTIL.GETNUMVERTICES(BUILDING_SHAPE)) as no_of_vertices from building";
      ResultSet rs1 = stmt.executeQuery(vertice_sql);
      
      while(rs1.next())
      {
         int vert = rs1.getInt("no_of_vertices");
         vertex.add(vert);
        // System.out.print(vertex);
      }
       vertex_array = vertex.toArray(vertex_array);  
       rs1.close();
      
      String sql = "SELECT t.X,t.Y FROM building Tb, TABLE(SDO_UTIL.GETVERTICES(Tb.BUILDING_SHAPE)) t";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next())
      {
      int X_coordinate  = rs.getInt("X");
      poly_cordX.add(X_coordinate);
      int Y_coordinate = rs.getInt("Y");
      poly_cordY.add(Y_coordinate);
      } 
	x_coordinate_array = poly_cordX.toArray(x_coordinate_array);
        y_coordinate_array = poly_cordY.toArray(y_coordinate_array);  
       rs.close();
       
       //POPULATE DATA FROM PHOTO TABLE
      String photo_sql = "SELECT p.X,p.Y FROM PHOTO pb, TABLE(SDO_UTIL.GETVERTICES(pb.PHOTO_LOCATION)) p";
      ResultSet rs2 = stmt.executeQuery(photo_sql);
      
      while(rs2.next())
      {
      int X_photo  = rs2.getInt("X");
      photo_cordX.add(X_photo);
      int Y_photo = rs2.getInt("Y");
      photo_cordY.add(Y_photo);
      } 
	x_PHOTO_array = photo_cordX.toArray(x_PHOTO_array);
        y_PHOTO_array = photo_cordY.toArray(y_PHOTO_array);
       rs2.close();
       
       //POPULATE DATA FROM PHOTOGRAPHER TABLE
      String photographer_sql = "SELECT ph.X,ph.Y FROM PHOTOGRAPHER phb, TABLE(SDO_UTIL.GETVERTICES(phb.PHOTOGRAPHER_LOCATION)) ph";
      ResultSet rs3 = stmt.executeQuery(photographer_sql);
      
      while(rs3.next())
      {
      int X_photographer  = rs3.getInt("X");
      photographer_cordX.add(X_photographer);
      int Y_photographer = rs3.getInt("Y");
      photographer_cordY.add(Y_photographer);
      } 
	x_PHOTOGRAPHER_array = photographer_cordX.toArray(x_PHOTOGRAPHER_array);
        y_PHOTOGRAPHER_array = photographer_cordY.toArray(y_PHOTOGRAPHER_array);
       rs3.close();    
       
    }
    catch(SQLException e)
    {
        e.printStackTrace();
        System.err.println("Error while connecting!");
    }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hw3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration                   

private void groupButton( ) 
{

ButtonGroup bg1 = new ButtonGroup( );

bg1.add(jRadioButton1);
bg1.add(jRadioButton2);
bg1.add(jRadioButton3);
bg1.add(jRadioButton4);
bg1.add(jRadioButton5);

}
}