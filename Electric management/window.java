package com.xiets.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.xu.access.DBS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
    	
    	DBS A = new DBS();
    	DBS B = new DBS();
    	B.getConnection();
    	A.getConnection();
    	//A.executeinsert2();
    	//A.Adddata("insert into test(VOL,CUR) values(50,9)");
    	//ArrayList<Integer> list = new ArrayList<Integer>();
    	/*list = A.Reacherdata("select * from test",53);
    	int a[] = new int[list.size()];
    	for(int i = 0 ;i<list.size();i++)
    	{
    		a[i] =(int)list.get(i);
    		System.out.println(a[i]);
    	}*/
    //	int jj = 9;
    	//A.Deletedata(jj);
    	//A.Changedata("update test set name='电机' where name='熊猫'");
    	
    	
    	
    	final JFrame jf = new JFrame("电机监控窗口");
        jf.setSize(600, 600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        // 创建选项卡面板（就是下面三个选择面板：总监控窗口、电机01、电机02）
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel01 = new JPanel(null);
        JPanel panel02 = new JPanel(null);
        JPanel panel03 = new JPanel(null);
        tabbedPane.addTab("总监视窗口", panel01);
        tabbedPane.addTab("电机01", panel02);
        tabbedPane.addTab("电机02", panel03);
        //创建相关组件
        JToggleButton switchbutton01 = new JToggleButton("开关01");
        JToggleButton switchbutton02 = new JToggleButton("开关02");
        JToggleButton switchbuttonall = new JToggleButton("总开关");
    	JLabel state01 = new JLabel("电机运行状态");
    	JLabel state02 = new JLabel("电机运行状态");
    	JLabel statenow = new JLabel("运行情况");
    	JLabel abstatenow = new JLabel("异常原因");
    	JLabel abstatetime= new JLabel("故障日期");
    	JLabel ele01 = new JLabel("电机01");
    	JLabel ele02 = new JLabel("电机02");
    	JLabel VOL01 = new JLabel("电压");
    	JLabel VOL02 = new JLabel("电压");
    	JLabel CUR01 = new JLabel("电流");
      	JLabel CUR02 = new JLabel("电流");
      	JLabel rotateS01 = new JLabel("转速");
      	JLabel rotateS02 = new JLabel("转速");
    	JTextField Textstate01 = new JTextField();
    	JTextField Textstate02 = new JTextField();
    	JTextField Textabstate02 = new JTextField();
    	JTextField Textabstate01 = new JTextField();
    	JTextField Textabstatetime01 = new JTextField();
    	JTextField Textabstatetime02 = new JTextField();
    	JTextField TextCUR01 = new JTextField();
    	JTextField TextCUR02 = new JTextField();
    	JTextField TextVOL01 = new JTextField();
    	JTextField TextVOL02 = new JTextField();
    	JTextField TextRotate01 = new JTextField();
    	JTextField TextRotate02 = new JTextField();  	
    	JButton detective = new JButton("电机检测");
    	JLabel showcurve01 = new JLabel("曲线显示");
    	JLabel showcurve02 = new JLabel("曲线显示");
    	JButton showcurveCUR02 = new JButton("电流—时间");
    	JButton showcurveCUR01 = new JButton("电流—时间");
    	JButton showcurveVOL02 = new JButton("电压—时间");
    	JButton showcurveVOL01 = new JButton("电压—时间");
    	JButton showcurveSPE02 = new JButton("转速—时间");
    	JButton showcurveSPE01 = new JButton("转速—时间");
    	//组件位置固定
    	detective.setBounds(120, 10, 90, 30);
    	switchbutton01.setBounds(10,10,90,30);
    	switchbutton02.setBounds(10,10,90,30);
    	switchbuttonall.setBounds(10,10,90,30);
    	state01.setBounds(10,70,100,30);
    	state02.setBounds(10,70,100,30);
    	showcurve01.setBounds(200,70,100,30);
    	showcurve02.setBounds(200,70,100,30);
    	showcurveVOL01.setBounds(200,120,100,30);
    	showcurveVOL02.setBounds(200,120,100,30);
    	showcurveCUR01.setBounds(200,170,100,30);
    	showcurveCUR02.setBounds(200,170,100,30);
    	showcurveSPE01.setBounds(200,220,100,30);
    	showcurveSPE02.setBounds(200,220,100,30);
    	statenow.setBounds(130,80,90,30);
    	abstatenow.setBounds(300,80,90,30);
    	abstatetime.setBounds(470,80,90,30);
    	Textstate01.setBounds(115,109,90,30);
    	Textabstate01.setBounds(285,109,90,30);
    	Textstate02.setBounds(115,219,90,30);
    	Textabstate02.setBounds(285,219,90,30);
    	Textabstatetime01.setBounds(455,109,90,30);
    	Textabstatetime02.setBounds(455,219,90,30);
    	ele01.setBounds(30,110,90,30);
    	ele02.setBounds(30,220,90,30);
    	VOL01.setBounds(10,120,100,30);
    	VOL02.setBounds(10,120,100,30);
    	CUR01.setBounds(10,170,100,30);
    	CUR02.setBounds(10,170,100,30);
    	rotateS01.setBounds(10,220,100,30);
    	rotateS02.setBounds(10,220,100,30);
    	TextCUR01.setBounds(50,120,100,30);
     	TextCUR02.setBounds(50,120,100,30);
     	TextVOL01.setBounds(50,170,100,30);
     	TextVOL02.setBounds(50,170,100,30);
     	TextRotate01.setBounds(50,220,100,30);
     	TextRotate02.setBounds(50,220,100,30);
    	//组件添加到面板
    	panel02.add(switchbutton01);
    	panel03.add(switchbutton02);
    	panel01.add(switchbuttonall);
        panel02.add(state01);
        panel02.add(showcurve01);
        panel03.add(showcurve02);
        panel02.add(showcurveVOL01);
        panel03.add(showcurveVOL02);
        panel02.add(showcurveCUR01);
        panel03.add(showcurveCUR02);
        panel02.add(showcurveSPE01);
        panel03.add(showcurveSPE02);
        panel03.add(state02);
        panel01.add(detective);
        panel01.add(statenow);
        panel01.add(abstatenow);
        panel01.add(abstatetime);
        panel01.add(Textstate01);
        panel01.add(Textstate02);
        panel01.add(Textabstate02);
        panel01.add(Textabstate01);
        panel01.add(Textabstatetime01);
        panel01.add(Textabstatetime02);
        panel02.add(TextCUR01);
        panel03.add(TextCUR02);
        panel02.add(TextVOL01);
        panel03.add(TextVOL02);
        panel02.add(TextRotate01);
        panel03.add(TextRotate02);
        panel01.add(ele01);
        panel01.add(ele02);
        panel02.add(VOL01);
        panel03.add(VOL02);
        panel02.add(CUR01);
        panel03.add(CUR02);
        panel02.add(rotateS01);
        panel03.add(rotateS02);

        //组件动作监听器 
        //曲线01
        showcurveVOL01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<Integer> list = new ArrayList<Integer>();
            	try {
					list = A.Reacherdata("select * from test",2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	int a[] = new int[list.size()];
            	for(int i = 0 ;i<list.size();i++)
            	{
            		a[i] =(int)list.get(i);
            	//	System.out.println(a[i]);
            	}
            	
            	JFrame jFrame = new JFrame("电压——时间");
            	jFrame.setSize(500,500);
            	//jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭就退出
                jFrame.setLocationRelativeTo(null);
                // 创建画板
                JPanel jpanel = new JPanel() {
                //序列号（可省略）
                private static final long serialVersionUID = 1L;

                    // 重写paint方法
                    @Override
                    public void paint(Graphics g) {
                    	Graphics2D g2D = (Graphics2D) g;
                    	int Origin_X = 100;
                    	int Origin_Y = 270;

                    	// X,Y轴终点坐标
                    	int XAxis_X = 620;
                    	int XAxis_Y = 270;
                    	int YAxis_X = 100;
                    	int YAxis_Y = 80;

                    	// X轴上的时间分度值（1分度=40像素）
                    	int TIME_INTERVAL = 50;
                    	// Y轴上值
                    	int PRESS_INTERVAL = 30;
                        // 必须先调用父类的paint方法
                        super.paint(g);
   
                     // 画坐标轴
                        g.setColor(Color.RED);
            			g2D.setStroke(new BasicStroke(Float.parseFloat("3.0F")));// 轴线粗度
            			// X轴以及方向箭头
            			g.drawLine(Origin_X, Origin_Y, XAxis_X, XAxis_Y);// x轴线的轴线
            			g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y - 5);// 上边箭头
            			g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y + 5);// 下边箭头

            			// Y轴以及方向箭头
            			g.drawLine(Origin_X, Origin_Y, YAxis_X, YAxis_Y);
            			g.drawLine(YAxis_X, YAxis_Y, YAxis_X - 5, YAxis_Y + 5);
            			g.drawLine(YAxis_X, YAxis_Y, YAxis_X + 5, YAxis_Y + 5);

            			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
            			g.setColor(Color.BLUE);
            			g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));

            			// X轴刻度依次变化情况
            			for (int i = Origin_X, j = 0; i < XAxis_X; i += TIME_INTERVAL, j += TIME_INTERVAL) {
            				g.drawString(" " + j, i - 10, Origin_Y + 20);
            			}
            			g.drawString("时间/min", XAxis_X + 5, XAxis_Y + 5);

            			// 画Y轴上刻度（从坐标原点起，每隔10像素画一压力值，到Y轴终点止）
            			for (int i = Origin_Y, j = 0; i > YAxis_Y; i -= PRESS_INTERVAL, j += TIME_INTERVAL) {
            				g.drawString(j + " ", Origin_X - 30, i + 3);
            			}
            			g.drawString("电压/V", YAxis_X - 5, YAxis_Y - 5);// 电压刻度小箭头值
            			// 画网格线
            			g.setColor(Color.BLACK);
            			// 坐标内部横线
            			for (int i = Origin_Y; i > YAxis_Y; i -= PRESS_INTERVAL) {
            				g.drawLine(Origin_X, i, Origin_X + 10 * TIME_INTERVAL, i);
            			}
            			// 坐标内部竖线
            			for (int i = Origin_X; i < XAxis_X; i += TIME_INTERVAL) {
            				g.drawLine(i, Origin_Y, i, Origin_Y - 6 * PRESS_INTERVAL);
            			}
            			
            			g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));
            			g.setColor(Color.red);
            			int k = 50;
            			for(int i = 0;i<10;i++) {
            				g.drawLine(i*k+100, 270-(3*a[i])/5, (i+1)*k+100, 270-(3*a[i+1])/5);
            			}
            			
            			

                        
                    }
                };
                //将绘有小人图像的画板嵌入到相框中
                jFrame.add(jpanel);
                // 设置画框大小（宽度，高度），默认都为0
                jFrame.setSize(700, 400);
                // 将画框展示出来。true设置可见，默认为false隐藏
                jFrame.setVisible(true);
            
                
                System.out.println("曲线01  被点击");
            }
        });
        //曲线02
        showcurveCUR01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
            	 System.out.println("曲线02  被点击");
            	ArrayList<Integer> list2 = new ArrayList<Integer>();
            	try {
					list2 = B.Reacherdata("select * from test",3);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
            	int b[] = new int[list2.size()];
            	for(int i = 0 ;i<list2.size();i++)
            	{
            		b[i] =(int)list2.get(i);
            		System.out.println(b[i]);
            	}
            	JFrame jFrame = new JFrame("电流——时间");
            	jFrame.setSize(500,500);
            	//jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭就退出
                jFrame.setLocationRelativeTo(null);
                // 创建画板
                JPanel jpanel = new JPanel() {
                //序列号（可省略）
                private static final long serialVersionUID = 1L;

                    // 重写paint方法
                    @Override
                    public void paint(Graphics g) {
                    	Graphics2D g2D = (Graphics2D) g;
                    	int Origin_X = 100;
                    	int Origin_Y = 270;

                    	// X,Y轴终点坐标
                    	int XAxis_X = 620;
                    	int XAxis_Y = 270;
                    	int YAxis_X = 100;
                    	int YAxis_Y = 80;

                    	// X轴上的时间分度值（1分度=40像素）
                    	int TIME_INTERVAL = 50;
                    	// Y轴上值
                    	int PRESS_INTERVAL = 30;
                        // 必须先调用父类的paint方法
                        super.paint(g);
   
                     // 画坐标轴
                        g.setColor(Color.RED);
            			g2D.setStroke(new BasicStroke(Float.parseFloat("3.0F")));// 轴线粗度
            			// X轴以及方向箭头
            			g.drawLine(Origin_X, Origin_Y, XAxis_X, XAxis_Y);// x轴线的轴线
            			g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y - 5);// 上边箭头
            			g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y + 5);// 下边箭头

            			// Y轴以及方向箭头
            			g.drawLine(Origin_X, Origin_Y, YAxis_X, YAxis_Y);
            			g.drawLine(YAxis_X, YAxis_Y, YAxis_X - 5, YAxis_Y + 5);
            			g.drawLine(YAxis_X, YAxis_Y, YAxis_X + 5, YAxis_Y + 5);

            			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
            			g.setColor(Color.BLUE);
            			g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));

            			// X轴刻度依次变化情况
            			for (int i = Origin_X, j = 0; i < XAxis_X; i += TIME_INTERVAL, j += TIME_INTERVAL) {
            				g.drawString(" " + j, i - 10, Origin_Y + 20);
            			}
            			g.drawString("时间/min", XAxis_X + 5, XAxis_Y + 5);

            			// 画Y轴上刻度（从坐标原点起，每隔10像素画一压力值，到Y轴终点止）
            			for (int i = Origin_Y, j = 0; i > YAxis_Y; i -= PRESS_INTERVAL, j += TIME_INTERVAL-45) {
            				g.drawString((j + " "), Origin_X - 30, i + 3);
            			}
            			g.drawString("电流/A", YAxis_X - 5, YAxis_Y - 5);// 电压刻度小箭头值
            			// 画网格线
            			g.setColor(Color.BLACK);
            			// 坐标内部横线
            			for (int i = Origin_Y; i > YAxis_Y; i -= PRESS_INTERVAL) {
            				g.drawLine(Origin_X, i, Origin_X + 10 * TIME_INTERVAL, i);
            			}
            			// 坐标内部竖线
            			for (int i = Origin_X; i < XAxis_X; i += TIME_INTERVAL) {
            				g.drawLine(i, Origin_Y, i, Origin_Y - 6 * PRESS_INTERVAL);
            			}
            			
            			g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));
            			g.setColor(Color.red);
            			int k = 50;
            			for(int i = 0;i<10;i++) {
            				g.drawLine(i*k+100, 270-(30*b[i])/5, (i+1)*k+100, 270-(30*b[i+1])/5);
            			}
            			
            			

                        
                    }
                };
                //将绘有小人图像的画板嵌入到相框中
                jFrame.add(jpanel);
                // 设置画框大小（宽度，高度），默认都为0
                jFrame.setSize(700, 400);
                // 将画框展示出来。true设置可见，默认为false隐藏
                jFrame.setVisible(true);
                
                System.out.println("曲线02  被点击");
            }
        });
      //曲线03
        showcurveSPE01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<Integer> list = new ArrayList<Integer>();
            	try {
					list = A.Reacherdata("select * from test",4);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	int a[] = new int[list.size()];
            	for(int i = 0 ;i<list.size();i++)
            	{
            		a[i] =(int)list.get(i);
            	//	System.out.println(a[i]);
            	}
            	
            	JFrame jFrame = new JFrame("转速——时间");
            	jFrame.setSize(500,500);
            	//jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭就退出
                jFrame.setLocationRelativeTo(null);
                // 创建画板
                JPanel jpanel = new JPanel() {
                //序列号（可省略）
                private static final long serialVersionUID = 1L;

                    // 重写paint方法
                    @Override
                    public void paint(Graphics g) {
                    	Graphics2D g2D = (Graphics2D) g;
                    	int Origin_X = 100;
                    	int Origin_Y = 270;

                    	// X,Y轴终点坐标
                    	int XAxis_X = 620;
                    	int XAxis_Y = 270;
                    	int YAxis_X = 100;
                    	int YAxis_Y = 80;

                    	// X轴上的时间分度值（1分度=40像素）
                    	int TIME_INTERVAL = 50;
                    	// Y轴上值
                    	int PRESS_INTERVAL = 30;
                        // 必须先调用父类的paint方法
                        super.paint(g);
   
                     // 画坐标轴
                        g.setColor(Color.RED);
            			g2D.setStroke(new BasicStroke(Float.parseFloat("3.0F")));// 轴线粗度
            			// X轴以及方向箭头
            			g.drawLine(Origin_X, Origin_Y, XAxis_X, XAxis_Y);// x轴线的轴线
            			g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y - 5);// 上边箭头
            			g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y + 5);// 下边箭头

            			// Y轴以及方向箭头
            			g.drawLine(Origin_X, Origin_Y, YAxis_X, YAxis_Y);
            			g.drawLine(YAxis_X, YAxis_Y, YAxis_X - 5, YAxis_Y + 5);
            			g.drawLine(YAxis_X, YAxis_Y, YAxis_X + 5, YAxis_Y + 5);

            			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
            			g.setColor(Color.BLUE);
            			g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));

            			// X轴刻度依次变化情况
            			for (int i = Origin_X, j = 0; i < XAxis_X; i += TIME_INTERVAL, j += TIME_INTERVAL) {
            				g.drawString(" " + j, i - 10, Origin_Y + 20);
            			}
            			g.drawString("时间/min", XAxis_X + 5, XAxis_Y + 5);

            			// 画Y轴上刻度（从坐标原点起，每隔10像素画一压力值，到Y轴终点止）
            			for (int i = Origin_Y, j = 0; i > YAxis_Y; i -= PRESS_INTERVAL, j += TIME_INTERVAL) {
            				g.drawString(j + " ", Origin_X - 30, i + 3);
            			}
            			g.drawString("转速/V", YAxis_X - 5, YAxis_Y - 5);// 电压刻度小箭头值
            			// 画网格线
            			g.setColor(Color.BLACK);
            			// 坐标内部横线
            			for (int i = Origin_Y; i > YAxis_Y; i -= PRESS_INTERVAL) {
            				g.drawLine(Origin_X, i, Origin_X + 10 * TIME_INTERVAL, i);
            			}
            			// 坐标内部竖线
            			for (int i = Origin_X; i < XAxis_X; i += TIME_INTERVAL) {
            				g.drawLine(i, Origin_Y, i, Origin_Y - 6 * PRESS_INTERVAL);
            			}
            			
            			g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));
            			g.setColor(Color.red);
            			int k = 50;
            			for(int i = 0;i<10;i++) {
            				g.drawLine(i*k+100, 270-(3*a[i])/5, (i+1)*k+100, 270-(3*a[i+1])/5);
            			}
            			
            			

                        
                    }
                };
                //将绘有小人图像的画板嵌入到相框中
                jFrame.add(jpanel);
                // 设置画框大小（宽度，高度），默认都为0
                jFrame.setSize(700, 400);
                // 将画框展示出来。true设置可见，默认为false隐藏
                jFrame.setVisible(true);
            
                
                System.out.println("曲线01  被点击");
            }
        });
        //总监控窗口电机检测监听
        detective.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Textstate01.setText("正常");
                ArrayList<Integer> list = new ArrayList<Integer>();
            	try {
					list = A.Reacherdata("select * from test",2);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            	int a[] = new int[list.size()];
            	
            	 ArrayList<Integer> list2 = new ArrayList<Integer>();
             	try {
 					list2 = A.Reacherdata("select * from test",7);
 				} catch (Exception e1) {
 					e1.printStackTrace();
 				}
             	String b[] = new String[list.size()];
             	
            	
            	for(int i = 0 ;i<list.size();i++)
            	{
            		b[i] = list2.get(i).toString();
            		a[i] =(int)list.get(i);
            		if (a[i]<150) {
            			Textstate01.setText("异常");
            			Textabstate01.setText("电压过低");
            			Textabstatetime01.setText(b[i]+1);
            			
            			/*try {
							A.Changedata("update test set 故障原因  = '电压过低' where ID = "+(i+1)+"");
							A.Changedata("update test set 故障日期  = list3.get(i).getCalendarType() where ID = "+(i+1)+"");
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}*/
            		}
            		else if (a[i]>300)
            		{
            			Textstate01.setText("异常");
            			Textabstate01.setText("电压过高");
            			Textabstatetime01.setText(b[i]+1);
            			/*try {
							A.Changedata("update test set 故障原因  = '电压过高' where ID = "+(i+1)+"");
							A.Changedata("update test set 故障日期  = list3.get(i).getCalendarType() where ID = "+(i+1)+"");
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}*/
            			
            			
            		}
            	}
            	/*for(int i = 0 ;i<list2.size();i++)
            	{
            		b[i] =(int)list2.get(i);
            		if ( b[i]<10) {
            			Textstate01.setText("异常");
            			Textabstate01.setText("电流过低");
            			Textabstatetime01.setText(list3.get(i).getCalendarType());
            			try {
							A.Changedata("update test set 故障原因  = '电流过低' where ID = 'i+1'");
							A.Changedata("update test set 故障日期  = list3.get(i).getCalendarType() where ID = 'i+1'");
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
            		}
            		else if (b[i]>30)
            		{
            			Textstate01.setText("异常");
            			Textabstate01.setText("电流过高");
            			Textabstatetime01.setText(list3.get(i).getCalendarType());
            			try {
							A.Changedata("update test set 故障原因  = '电流过高' where ID = 'i+1'");
							A.Changedata("update test set 故障日期  = list3.get(i).getCalendarType() where ID = 'i+1'");
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
            		}*/
            	
                
                System.out.println("电机检测  被点击");
            }
            
            	
            }
        );
        //电机01开关监听
        switchbutton01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("电机01  被点击");
            }
        });
        //电机02开关监听
        switchbutton02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("电机02  被点击");
            }
        });
       
        
        
        // 添加选项卡选中状态改变的监听器
        
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
            }
        });

        // 设置默认选中的选项卡
        tabbedPane.setSelectedIndex(0);
        
        jf.setContentPane(tabbedPane);
        jf.setVisible(true);
    

        
        
        
        
    //菜单布局//////////////////////////////////////////////
        JMenuBar menuBar = new JMenuBar();
        JMenu menuload = new JMenu("连接(L)");
        JMenuItem menuclientcreat = new JMenuItem("创建连接");
        JMenuItem menuforgetsecret = new JMenuItem("断开连接");
        JMenu menuparameter = new JMenu("状态监控(P)");
        JMenuItem menuVoltage = new  JMenuItem("电压（V）");
        JMenuItem menuCurrent = new  JMenuItem("电流（A）");
        JMenuItem menuTemperature = new  JMenuItem("温度（C）");
        JMenuItem menuspeed = new  JMenuItem("转速（r/s）");
        JMenu menuSystem = new JMenu("数据处理（D）");
		JMenuItem menutypein = new JMenuItem("数据录入");
		JMenuItem menureacher = new JMenuItem("数据查询");
		JMenuItem menudelete = new JMenuItem("数据删除");
		JMenu menucurve = new JMenu("监控曲线（Q）");
		JCheckBoxMenuItem Volcurve = new JCheckBoxMenuItem("电压—时间");
		JCheckBoxMenuItem Curcurve = new JCheckBoxMenuItem("电流—时间");
		JCheckBoxMenuItem Specurve = new JCheckBoxMenuItem("转速—时间");
		JMenu menuAbout = new JMenu("关于");
		JMenuItem SQL = new JMenuItem("数据库说明");
		
        // 一级菜单添加到菜单栏
		menuBar.add(menuload);
		menuload.add(menuclientcreat);
		menuload.add(menuforgetsecret);
		
		menuBar.add(menuparameter);
		menuparameter.add(menuVoltage);
		menuparameter.add( menuCurrent);
		menuparameter.add( menuTemperature);
		menuparameter.add( menuspeed);
		menuBar.add( menuSystem);
		menuSystem.add(menutypein);
		menuSystem.add(menureacher);
		menuSystem.add(menudelete);
		menuBar.add(menucurve);
		menucurve.add(Volcurve);
		menucurve.add(Curcurve);
		menucurve.add(Specurve);
		menuBar.add(  menuAbout);
		menuAbout.add(SQL);
	
	
       
        
        // 菜单项的点击/状态改变事件监听/////////////////////////////////////////////////////////////////////////////////
        
		//设置“连接”的子菜单的监听器
		
		// 设置 "创建连接" 子菜单被点击的监听
        menuclientcreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 JFrame load = new JFrame("用户登录");
            	 load.setSize(200,200);
            	 load.setLocationRelativeTo(null);
                 //load.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                 // 第 1 个 JPanel, 使用默认的浮动布局
                 JPanel panel01 = new JPanel();
                 panel01.add(new JLabel("用户名"));
                 panel01.add(new JTextField(10));

                 // 第 2 个 JPanel, 使用默认的浮动布局
                 JPanel panel02 = new JPanel();
                 panel02.add(new JLabel("密   码"));
                 panel02.add(new JPasswordField(10));

                 // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                 JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 panel03.add(new JButton("登录"));
                 panel03.add(new JButton("注册"));

                 // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
                 Box vBox = Box.createVerticalBox();
                 vBox.add(panel01);
                 vBox.add(panel02);
                 vBox.add(panel03);

                 load.setContentPane(vBox);

                 load.pack();
                 load.setLocationRelativeTo(null);
                 load.setVisible(true);
                  
                System.out.println("创建连接  被点击");
            	
            }
        });
        // 设置 "断开连接" 子菜单被点击的监听器
        menuforgetsecret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("断开连接  被点击");
            }
        });
        
       
        
        
        
        // 设置 "数据处理" 子菜单被点击的监听器
     
        menutypein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	 final JFrame load = new JFrame("数据录入");
            	 load.setSize(400,400);
            	 load.setLocationRelativeTo(null);
                 //load.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                 // 第 1 个 JPanel, 使用默认的浮动布局
            	 JTextField text1 =  new JTextField(10);
            	 JTextField text2 =  new JTextField(10);
            	 JTextField text3 =  new JTextField(10);
            	 JTextField text4 =  new JTextField(10);
                 JPanel panel01 = new JPanel();
                 panel01.add(new JLabel("电流"));
                 panel01.add(text1);
              

                 // 第 2 个 JPanel, 使用默认的浮动布局
                 JPanel panel02 = new JPanel();
                 panel02.add(new JLabel("电压"));
                 panel02.add(text2);

                 // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                 JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 JButton confirm = new JButton("确认");
                 panel03.add(confirm);
                 panel03.add(new JButton("取消"));
                 
                 // 第 4 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                 JPanel panel04 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 panel04.add(new JLabel("转速"));
                 panel04.add(text3);
                 
                 JPanel panel05 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 JLabel states = new JLabel(" ");
                 panel05.add(states);
                // panel05.add(text4);
            
                 // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
                 Box vBox = Box.createVerticalBox();
                 vBox.add(panel01);
                 vBox.add(panel02);
                 vBox.add(panel04);
                 vBox.add(panel05);
                 vBox.add(panel03);

                 load.setContentPane(vBox);
                 load.pack();
                 load.setLocationRelativeTo(null);
                 load.setVisible(true);
                 
                 //确认增加数据
                 confirm.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                    	 String cur = text1.getText();
                         String vol  = text2.getText();
                         String spe  = text3.getText();
                         //System.out.println(typeintextname);
                         int k = Integer.valueOf(cur);
                         int kkkk = 0;
                         int kk = Integer.valueOf(vol);
                         int kkk = Integer.valueOf(spe);
                         System.out.println(k);
                     	try {
                     	A.Adddata("insert into test(CUR,VOL,转速) values(("+k+"),("+kk+"),("+kkk+"))");
                     	kkkk++;
                     	
     				} catch (Exception e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
                   	  if(kkkk == 1)
                      {
                   		  states.setText("数据添加成功");
                   		 
                      }
                   	  else
                   	  {
                   		  states.setText("数据添加失败");
                   	  }
                         
                      
                     }
                 });
                
                System.out.println("数据录入  被点击");
            }
        });
        

        menureacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
              	 final JFrame load = new JFrame("数据查询");
            	 load.setSize(400,400);
            	 load.setLocationRelativeTo(null);
                 //load.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            	
            		ArrayList<Integer> list2 = new ArrayList<Integer>();
                	try {
    					list2 = B.Reacherdata("select * from test",6);
    				} catch (Exception e2) {
    					// TODO Auto-generated catch block
    					e2.printStackTrace();
    				}
                	int b[] = new int[list2.size()];
                	for(int i = 0 ;i<list2.size();i++)
                	{
                		b[i] =(int)list2.get(i);
                		System.out.println(b[i]);
                	}

                 // 第 1 个 JPanel, 使用默认的浮动布局
            	 JTextField text1 =  new JTextField(10);
            	 JTextField text2 =  new JTextField(10);
            	 JTextField text3 =  new JTextField(10);
                 JPanel panel01 = new JPanel();
                 panel01.add(new JLabel("时间"));
                 panel01.add(text1);
              

                 // 第 2 个 JPanel, 使用默认的浮动布局
                JPanel panel02 = new JPanel();
                JLabel states = new JLabel(" ");
                 panel02.add( states );
                 //panel02.add(text2);

                 // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                 JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 JButton confirm = new JButton("确认");
                 panel03.add(confirm);
                 panel03.add(new JButton("取消"));
                 
                 	//第 4 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                JPanel panel04 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 panel04.add(new JLabel("转速"));
                 panel04.add(text3);
            
                 // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
                 Box vBox = Box.createVerticalBox();
                 vBox.add(panel01);
                 vBox.add(panel02);
                // vBox.add(panel04);
                 vBox.add(panel03);

                 load.setContentPane(vBox);
                 load.pack();
                 load.setLocationRelativeTo(null);
                 load.setVisible(true);
                 
                 //确认增加数据
                 confirm.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                    	 String time = text1.getText();
                         //System.out.println(typeintextname);
                         int k = Integer.valueOf(time);
                       int kk = 0;
                     	for(int i = 0;i<6;i++)
                     	{
                     		if(b[i] == k)
                     		{
                     			kk++;
                     		}
                     			
                     	}
                     	if(kk>=1)
                     	{
                     		states.setText("查询成功");
                     		System.out.println("查询成功");
                     	}
                     		
                     	else
                     	{
                     		states.setText("查询失败");
                     		System.out.println("查询失败");
                            
                     	}
                     	
                         
                      
                     }

					private int strlen() {
						// TODO Auto-generated method stub
						return 0;
					}
                 });
            	 
                System.out.println("数据查询  被点击");
            }
        });
        
        menureacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 
                System.out.println("数据录入  被点击");
            }
        });
        menudelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              	 final JFrame load = new JFrame("数据删除");
            	 load.setSize(400,400);
            	 load.setLocationRelativeTo(null);
                 //load.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                 // 第 1 个 JPanel, 使用默认的浮动布局
            	 JTextField text1 =  new JTextField(10);
            	 JTextField text2 =  new JTextField(10);
            	 JTextField text3 =  new JTextField(10);
                 JPanel panel01 = new JPanel();
                 panel01.add(new JLabel("时间"));
                 panel01.add(text1);
              

                 // 第 2 个 JPanel, 使用默认的浮动布局
                /* JPanel panel02 = new JPanel();
                 panel02.add(new JLabel("电压"));
                 panel02.add(text2);*/

                 // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                 JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 JButton confirm = new JButton("确认");
                 panel03.add(confirm);
                 panel03.add(new JButton("取消"));
                 
                 // 第 4 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
                 JPanel panel04 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                 JLabel states = new JLabel(" ");
                 panel04.add(states);
                // panel04.add(text3);
            
                 // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
                 Box vBox = Box.createVerticalBox();
                 vBox.add(panel01);
               //  vBox.add(panel02);
                 vBox.add(panel04);
                 vBox.add(panel03);

                 load.setContentPane(vBox);
                 load.pack();
                 load.setLocationRelativeTo(null);
                 load.setVisible(true);
                 
                 //确认增加数据
                 confirm.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                    	 String time = text1.getText();
                         //System.out.println(typeintextname);
                         int k = Integer.valueOf(time);
                       int kk = 0;
                     	try {
                     	///String a = "delete from test where time = "+k+" ";
                     	A.Deletedata(k);/////////////////////////////////////////
                     	kk++;
                     	
     				} catch (Exception e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
                     	  if(kk == 1)
                          {
                       		  states.setText("数据删除成功");
                       		 
                          }
                       	  else
                       	  {
                       		  states.setText("数据删除失败");
                       	  }
                         
                      
                     }
                 });
            	 
                System.out.println("数据删除  被点击");
            }
        });
        
        menureacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 
                System.out.println("数据录入  被点击");
            }
        });
        

        // 设置 复选框子菜单（总的电压、电流、转速曲线） 状态改变 监听器
        Volcurve .addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("电压曲线复选框是否被选中: " + Volcurve .isSelected());
            }
        });
        Curcurve .addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("电流曲线复选框是否被选中: " + Volcurve .isSelected());
            }
        });
        Specurve .addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("转速曲线复选框是否被选中: " + Volcurve .isSelected());
            }
        });
        
        

     
      
        jf.setJMenuBar(menuBar);
        jf.setVisible(true);
    }

	private static char[] a(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}