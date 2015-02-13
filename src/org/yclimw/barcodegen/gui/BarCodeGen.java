package org.yclimw.barcodegen.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class BarCodeGen extends JFrame {

	private JPanel contentPane;
	private JComboBox<?> comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarCodeGen frame = new BarCodeGen();
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
	public BarCodeGen() {
		setTitle("条码生成器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 555);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{15, 95, 268, 42, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel configPanel = new JPanel();
		GridBagConstraints gbc_configPanel = new GridBagConstraints();
		gbc_configPanel.insets = new Insets(0, 0, 5, 5);
		gbc_configPanel.fill = GridBagConstraints.BOTH;
		gbc_configPanel.gridx = 1;
		gbc_configPanel.gridy = 1;
		panel.add(configPanel, gbc_configPanel);
		GridBagLayout gbl_configPanel = new GridBagLayout();
		gbl_configPanel.columnWidths = new int[]{0, 100, 39, 122, 0, 0};
		gbl_configPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_configPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_configPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		configPanel.setLayout(gbl_configPanel);
		
		JLabel label_1 = new JLabel("编码类型");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		configPanel.add(label_1, gbc_label_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(BarCodeTypeEnum.values()));
		comboBox.setToolTipText("111");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		configPanel.add(comboBox, gbc_comboBox);
		
		JLabel label_4 = new JLabel("文本");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 0;
		configPanel.add(label_4, gbc_label_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 0;
		configPanel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel lblDpi = new JLabel("分辨率DPI");
		GridBagConstraints gbc_lblDpi = new GridBagConstraints();
		gbc_lblDpi.anchor = GridBagConstraints.EAST;
		gbc_lblDpi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDpi.gridx = 0;
		gbc_lblDpi.gridy = 1;
		configPanel.add(lblDpi, gbc_lblDpi);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("150");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		configPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel label_5 = new JLabel("文字大小");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 1;
		configPanel.add(label_5, gbc_label_5);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 1;
		configPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel label_2 = new JLabel("高度");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		configPanel.add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		configPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("距离");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 2;
		configPanel.add(label_3, gbc_label_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 2;
		configPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		JPanel inputPanel = new JPanel();
		scrollPane.setViewportView(inputPanel);
		inputPanel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		inputPanel.add(textArea);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 3;
		panel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 27, 0, 0, 0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JLabel label = new JLabel("输出目录：");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		buttonPanel.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		buttonPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText(System.getProperty("user.dir"));
		
		JButton btnNewButton = new JButton("浏览");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		buttonPanel.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int r=fileChooser.showOpenDialog(null);
				if(r==0){
					textField.setText(fileChooser.getSelectedFile().getPath());
				}
			}
		});
		
		JButton generationButton = new JButton("创建条码");
		GridBagConstraints gbc_generationButton = new GridBagConstraints();
		gbc_generationButton.insets = new Insets(0, 0, 0, 5);
		gbc_generationButton.gridx = 3;
		gbc_generationButton.gridy = 0;
		buttonPanel.add(generationButton, gbc_generationButton);
		
		generationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] values=textArea.getText().split("\n");
				for (int i = 0; i < values.length; i++) {
					GenerationBarCode("",150, values[i]);
				}
				
			}
		});
		
		JButton exitButton = new JButton("退出");
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridx = 4;
		gbc_exitButton.gridy = 0;
		buttonPanel.add(exitButton, gbc_exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		
		
		
	}

	
	public void GenerationBarCode(String codetype,int dpi,String value){
        try {
            //Create the barcode bean
        	
        	Code128Bean bean =new Code128Bean();
//            Code39Bean bean = new Code39Bean();
            
            //Configure the barcode generator
            bean.setModuleWidth(UnitConv.in2mm(2.0f / dpi)); //makes the narrow bar 
                                                 
            //width exactly one pixel
            
//            bean.setWideFactor(3);
            bean.doQuietZone(false);
            
            //Open output file
            String exportDir=textField.getText()+File.separator+"result";
            File export=new File(exportDir);
            if(!export.exists()){
            	export.mkdir();
            }
            File outputFile = new File(exportDir+File.separator+value+".jpg");
            OutputStream out = new FileOutputStream(outputFile);
            try {
                //Set up the canvas provider for monochrome JPEG output 
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                        out, "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            
                //Generate the barcode
                bean.generateBarcode(canvas, value);
            
                //Signal end of generation
                canvas.finish();
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
