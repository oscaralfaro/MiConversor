import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class MiConversor {

	private JFrame frmConversorDeMonedas;
	private JComboBox<Moneda> cmb;
	private JLabel Lbl;
	private JButton btn;
	private JTextField txT;

	public enum Moneda {
		pesos_a_dolar,
		pesos_a_euro,
		pesos_a_Quetzal,
		dolar_a_pesos,
		euros_a_pesos,
		Quetzal_a_pesos,
		pesos_a_Colon,
		Colon_a_pesos,
		pesos_a_Real,
		Real_a_Pesos,
		pesos_a_soles,
		soles_a_pesos,
		pesos_a_bolivares,
		bolivares_a_pesos,
		
	}
	
	public double dolar= 16.84;
	public double euro = 18.90;
	public double Quetzal = 2157.82;
	public double Colon = 0.031;
	public double Real = 3.51;
	public double soles = 4.73;
	public double bolivares = 0.59;
	
	public double valorInput = 0.00;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiConversor window = new MiConversor();
					window.frmConversorDeMonedas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiConversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeMonedas = new JFrame();
		frmConversorDeMonedas.getContentPane().setForeground(new Color(192, 192, 192));
		frmConversorDeMonedas.getContentPane().setBackground(new Color(230, 230, 230));
		frmConversorDeMonedas.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 22));
		frmConversorDeMonedas.setForeground(new Color(0, 0, 255));
		frmConversorDeMonedas.setFont(new Font("Tahoma", Font.BOLD, 22));
		frmConversorDeMonedas.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\980030883\\Desktop\\IMAGENES LAP ASUS 2022\\convertidor de monedas.jpeg"));
		frmConversorDeMonedas.setBackground(new Color(240, 240, 240));
		frmConversorDeMonedas.setTitle("                                              G05 OSCAR ALFA           CONVERSOR DE MONEDAS");
		frmConversorDeMonedas.setBounds(100, 100, 642, 396);
		frmConversorDeMonedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMonedas.getContentPane().setLayout(null);
		
		txT = new JTextField();
		txT.setBounds(100, 79, 132, 39);
		frmConversorDeMonedas.getContentPane().add(txT);
		txT.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(100, 213, 132, 44);
		frmConversorDeMonedas.getContentPane().add(cmb);
		
		//evento del botón
		btn = new JButton("Convertir");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
				
			}
		});
		btn.setBounds(334, 213, 101, 44);
		frmConversorDeMonedas.getContentPane().add(btn);
		
		Lbl = new JLabel("$  00.00");
		Lbl.setBounds(334, 79, 101, 39);
		frmConversorDeMonedas.getContentPane().add(Lbl);
	}
	
	public void Convertir() {
		if(Validar(txT.getText())) {
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch (moneda) {
			
			case pesos_a_dolar:
			     PesosAMoneda(dolar);
			     break;
			case pesos_a_euro:
		         PesosAMoneda(euro);
		         break;
			case pesos_a_Quetzal:
		         PesosAMoneda(Quetzal);
		         break;
			case dolar_a_pesos:
		         MonedaAPesos(dolar);
		         break;
			case euros_a_pesos:
			     MonedaAPesos(euro);
		         break;
			case Quetzal_a_pesos:
		         MonedaAPesos(Quetzal);
		         break;
			case pesos_a_Colon:
	             PesosAMoneda(Colon);
	             break;
			case Colon_a_pesos:
	             MonedaAPesos(Colon);
	             break;
			case pesos_a_Real:
	             PesosAMoneda(Real);
	             break;
			case Real_a_Pesos:
	             MonedaAPesos(Real);
	             break;
			case pesos_a_soles:
	             PesosAMoneda(soles);
	             break;
			case soles_a_pesos:
	             MonedaAPesos(soles);
	             break;
			case pesos_a_bolivares:
	             PesosAMoneda(bolivares);
	             break;
			case bolivares_a_pesos:
	             MonedaAPesos(bolivares);
	             break;
		                         
		         	         
		         default:
			     throw new IllegalArgumentException("valor inesperado:" + moneda);
			
			}	
		}
		
		
	}
	
	public void PesosAMoneda(double moneda) {
	    double resultado = valorInput /moneda;
	    Lbl.setText(""+ resultado);
	}
	
    public void MonedaAPesos(double moneda) {
    	double resultado = valorInput * moneda;
	    Lbl.setText(""+ resultado);
	}
    
    public String Redondear(double valor) {
    	DecimalFormat df = new DecimalFormat("0.00");
    	df.setRoundingMode(RoundingMode.HALF_UP);
    	return df.format(valor);
    }
    
    public boolean Validar(String texto) {
    	try {
    		double x = Double.parseDouble(texto);
    		if(x > 0);
    		valorInput = x;
    		return true;
    	}catch (NumberFormatException e) {
    		Lbl.setText("Solamente números!!");
    		return false;
    		
    	}
    }
}
