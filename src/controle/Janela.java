package controle;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField inNumCilindrosField;
	private JTextField inPosInicialField;
	private JTextField inFilePathField;
	private JButton btnExecutar;
	
	private JTextArea outSSF;
	private JTextArea outScan;
	private JTextArea outFifo;
	private JTextArea outScanC;
	private JTextArea outLook;
	private JTextArea outLookC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		panelTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelTop.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTop.validate();
		
		JLabel lblNewLabel = new JLabel("Num. de Cilindros:");
		lblNewLabel.setToolTipText("");
		
		inNumCilindrosField = new JTextField();
		inNumCilindrosField.setColumns(10);
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.X_AXIS));
		panelTop.add(lblNewLabel);
		panelTop.add(inNumCilindrosField);
		
		JLabel label = new JLabel(" Posição Inicial:");
		panelTop.add(label);
		
		inPosInicialField = new JTextField();
		inPosInicialField.setColumns(10);
		panelTop.add(inPosInicialField);
		
		JLabel label_1 = new JLabel(" Nome do Arquivo:");
		panelTop.add(label_1);
		
		inFilePathField = new JTextField();
		inFilePathField.setColumns(10);
		panelTop.add(inFilePathField);
		
		btnExecutar = new JButton("Executar");
		panelTop.add(btnExecutar);
		btnExecutar.addActionListener(this);
		 
		
		//South Pane
		
		JPanel panelSul = new JPanel();
		panelSul.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelSul.setLayout(new GridLayout(1, 2, 10, 0));
		
		
		//Esquerda
		
		JPanel panelEsquerda = new JPanel();
		panelEsquerda.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelEsquerda.setSize(new Dimension(205, 105));
		panelSul.add(panelEsquerda);
		panelEsquerda.setLayout(new GridLayout(3, 1, 3, 0));
		
		JPanel panelFifo = new JPanel();
		panelEsquerda.add(panelFifo);
		panelFifo.setLayout(new BoxLayout(panelFifo, BoxLayout.Y_AXIS));
	
		JLabel lblNewLabel_1 = new JLabel("FIFO");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelFifo.add(lblNewLabel_1);
		

		outFifo = new JTextArea(0, 0);
		JScrollPane scrollFifo = new JScrollPane(outFifo);
		panelFifo.add(scrollFifo);
		
		JPanel panelSSF = new JPanel();
		panelEsquerda.add(panelSSF);
		panelSSF.setLayout(new BoxLayout(panelSSF, BoxLayout.Y_AXIS));
		
		JLabel label_2 = new JLabel("SSF");
		label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_2.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelSSF.add(label_2);
		
		outSSF = new JTextArea(0,0);
		JScrollPane scrollSSF = new JScrollPane(outSSF);
		panelSSF.add(scrollSSF);

		JPanel panelScan = new JPanel();
		panelEsquerda.add(panelScan);
		panelScan.setLayout(new BoxLayout(panelScan, BoxLayout.Y_AXIS));
		
		JLabel label_3 = new JLabel("Scan");
		label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_3.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelScan.add(label_3);
		
		outScan = new JTextArea(0,0);
		JScrollPane scrollScan = new JScrollPane(outScan);
		panelScan.add(scrollScan);
		
		
		
		//Direita
		
		JPanel panelDireita = new JPanel();
		panelDireita.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelDireita.setSize(new Dimension(205, 105));
		panelSul.add(panelDireita);
		panelDireita.setLayout(new GridLayout(3, 1, 3, 0));
		
		JPanel panelScanCircular = new JPanel();
		panelDireita.add(panelScanCircular);
		panelScanCircular.setLayout(new BoxLayout(panelScanCircular, BoxLayout.Y_AXIS));
		
		JLabel lblScanC = new JLabel("Scan Circular");
		lblScanC.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblScanC.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelScanCircular.add(lblScanC);
		
		outScanC = new JTextArea(0,0);
		JScrollPane scrollSC = new JScrollPane(outScanC);
		panelScanCircular.add(scrollSC);
		
		JPanel panelLook = new JPanel();
		panelDireita.add(panelLook);
		panelLook.setLayout(new BoxLayout(panelLook, BoxLayout.Y_AXIS));
		
		JLabel lblLook = new JLabel("Look");
		lblLook.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLook.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelLook.add(lblLook);
		
		outLook = new JTextArea(0,0);
		JScrollPane scrolL = new JScrollPane(outLook);
		panelLook.add(scrolL);
		
		JPanel panelLookCircular = new JPanel();
		panelDireita.add(panelLookCircular);
		panelLookCircular.setLayout(new BoxLayout(panelLookCircular, BoxLayout.Y_AXIS));
		
		JLabel lblLookC = new JLabel("Look Circular");
		lblLookC.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLookC.setBorder(new EmptyBorder(2, 2, 2, 2));
		panelLookCircular.add(lblLookC);
		
		outLookC = new JTextArea();
		JScrollPane scrollLC = new JScrollPane(outLookC);
		panelLookCircular.add(scrollLC);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelTop, BorderLayout.NORTH);
		contentPane.add(panelSul);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		outFifo.setText(inNumCilindrosField.getText() + " " + inPosInicialField.getText() + " " + inFilePathField.getText());
		outSSF.setText(inNumCilindrosField.getText() + " " + inPosInicialField.getText() + " " + inFilePathField.getText());
		outScan.setText(inNumCilindrosField.getText() + " " + inPosInicialField.getText() + " " + inFilePathField.getText());
		outScanC.setText(inNumCilindrosField.getText() + " " + inPosInicialField.getText() + " " + inFilePathField.getText());
		outLook.setText(inNumCilindrosField.getText() + " " + inPosInicialField.getText() + " " + inFilePathField.getText());
		outLookC.setText(inNumCilindrosField.getText() + " " + inPosInicialField.getText() + " " + inFilePathField.getText());
	}

}
