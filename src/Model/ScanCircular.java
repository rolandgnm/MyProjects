package Model;

import java.util.ArrayList;
import java.util.Collections;


public class ScanCircular {
	private ArrayList<Integer> arrayListCSCAN, arrayListCSCANGravacao = new ArrayList<Integer>(), arrayListDeslocamentos = new ArrayList<Integer>();
	private int contador, inicioDoBraco, somatorioDeDeslocamentos = 0;
	private double seek;
	
	@SuppressWarnings("unchecked")
	public ScanCircular(ArrayList<Integer> arrayListCSCAN, int inicioDoBraco, double seek) {
		
		this.arrayListCSCAN = (ArrayList<Integer>) arrayListCSCAN.clone();
		this.inicioDoBraco = inicioDoBraco;
		this.seek = seek;
		this.contador = arrayListCSCAN.size();
		Collections.sort(this.arrayListCSCAN);
	}
	
	public void execute() {
		
		int index = 0, ultimaRequisicao = this.inicioDoBraco;
		ControleGUI.setStatusValue(0,5);
		
			while (this.arrayListCSCAN.get(index) <= this.inicioDoBraco) {
				index++;
			}
		
		
		while (!arrayListCSCAN.isEmpty()) {
			
				while (index < arrayListCSCAN.size()) {
					this.somatorioDeDeslocamentos += Math.abs(ultimaRequisicao - this.arrayListCSCAN.get(index));
					this.arrayListDeslocamentos.add(Math.abs(ultimaRequisicao - arrayListCSCAN.get(index)));
					ControleGUI.setStatusValue((1-(this.arrayListCSCAN.size()/this.contador))*100,5);
					ultimaRequisicao = this.arrayListCSCAN.get(index);
					this.arrayListCSCANGravacao.add(this.arrayListCSCAN.get(index));
					this.arrayListCSCAN.remove(index);
				}
				
				index = 0;
		
		}
		this.somatorioDeDeslocamentos--;
		ManipuladorDeArquivos.geraArquivo("arquivoCSCAN", this.arrayListCSCANGravacao);
	}
	
	public double totalRequisicoes() {
		
		System.out.println("Somatorio "+ this.somatorioDeDeslocamentos + " SEEK: "+ this.seek + " Contador: "+this.contador);
		return (this.somatorioDeDeslocamentos*this.seek);
	}
	
	public double somatorioQuadrado(){
		double soma = 0;
		for (int i = 0; i < arrayListDeslocamentos.size(); i++){
			soma += Math.pow(arrayListDeslocamentos.get(i), 2);
		}
		return soma;
	}
	
	public double variancia() {
        double p1 = 1 / Double.valueOf(arrayListDeslocamentos.size() - 1);
        double p2 = somatorioQuadrado() - (Math.pow(this.somatorioDeDeslocamentos, 2) / Double.valueOf(arrayListDeslocamentos.size()));
        return p1 * p2;
    }
    
	public double desvioPadrao(){
		return Math.sqrt(variancia());
	}
}

