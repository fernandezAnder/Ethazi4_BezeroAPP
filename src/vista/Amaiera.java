//package vista;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.MatteBorder;
//
//import controlador.Metodoak;
//
//import java.awt.Color;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.event.ActionListener;
//
//public class Amaiera extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//
//	// private static final long serialVersionUID = 1L;
//
//	private JLabel lblEskerrikAsko = new JLabel("ESKERRIK ASKO ");
//	private JLabel lblZureTxartelaOrain = new JLabel("ERABILTZEAGATIK");
//
//	private Metodoak metodos;
//	private final JButton btnAmaitu = new JButton("AMAITU");
//	private JLabel lblNewLabel_1 = new JLabel("BIDAI ON");
//
//	public Amaiera() {
//		getContentPane().setBackground(new Color(135, 206, 250));
//		setBackground(new Color(135, 206, 250));
//		
//		
//		this.setBounds(275,100,700,600);
//		getContentPane().setLayout(null);
//		
//		//LABEL ESKERRIK ASKO
//		lblEskerrikAsko.setFont(new Font("Arial Narrow", Font.BOLD, 44));
//		lblEskerrikAsko.setBounds(186, 48, 310, 78);
//		getContentPane().add(lblEskerrikAsko);
//		
//		//LABEL ZURE TXARTELA ORAIN
//		lblZureTxartelaOrain.setFont(new Font("Arial Narrow", Font.BOLD, 44));
//		lblZureTxartelaOrain.setBounds(169, 212, 347, 45);
//		getContentPane().add(lblZureTxartelaOrain);
//		btnAmaitu.setBackground(new Color(135, 206, 250));
//		btnAmaitu.setFont(new Font("Arial Narrow", Font.BOLD, 16));
//		btnAmaitu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			        try {
//			            TimeUnit.SECONDS.sleep(5);
//			        } catch (InterruptedException e1) {
//			            e1.printStackTrace();
//			        }
//			    
//			metodos.agurratop1cop();
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Amaiera frame = new Amaiera();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		}}
//		});
//
//	/**
//	 * Create the frame.
//	 */
//	public Amaiera() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 600, 500);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(135, 206, 250));
//		contentPane.setBorder(new MatteBorder(20, 10, 20, 10, (Color) new Color(70, 130, 180)));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("ESKERRIK ASKO");
//		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 40));
//		lblNewLabel.setBounds(139, 80, 320, 79);
//		contentPane.add(lblNewLabel);
//
//		JLabel lblNewLabel_1 = new JLabel("BIDAI ON");
//		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 40));
//		lblNewLabel_1.setBounds(204, 158, 159, 56);
//		contentPane.add(lblNewLabel_1);
//
//		JLabel lblNewLabel_2 = new JLabel("ERABILTZEAGATIK");
//		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 40));
//		lblNewLabel_2.setBounds(127, 219, 342, 79);
//		contentPane.add(lblNewLabel_2);
//	}
//
//}
