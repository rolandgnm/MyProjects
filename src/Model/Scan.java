package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Scan {
	private ArrayList<Integer> arrayListSCAN = new ArrayList<Integer>(), arrayListSCANGravacao = new ArrayList<Integer>(), arrayListDeslocamentos = new ArrayList<Integer>();
	private int contador, inicioDoBraco, somatorioDeDeslocamentos, sentido, inicial;
	private double seek;
	
	@SuppressWarnings("unchecked")
	public Scan(ArrayList<Integer> arrayListSCAN, int inicioDoBraco, double seek) {
		
		this.arrayListSCAN = (ArrayList<Integer>) arrayListSCAN.clone();
		this.inicioDoBraco = inicioDoBraco;
		this.seek = seek;
		Collections.sort(this.arrayListSCAN);
		this.contador = arrayListSCAN.size();
		this.inicial = sentido;
	}
	
public void execute() {
		
		int index = 0, ultimaRequisicao = this.inicioDoBraco;
		
		if (ultimaRequisicao > this.arrayListSCAN.get(0)) {
			sentido = 1;
		}else{
			sentido = 0;
		}
		
		if (inicial == 0) {
			ControleGUI.setStatusValue(0,2);
		}else{
			ControleGUI.setStatusValue(0,3);
		}
			while (this.arrayListSCAN.get(index) <= this.inicioDoBraco) {
				index++;
			}
			if (this.sentido == 0) {
				index--;
			}
		
		while (!arrayListSCAN.isEmpty()) {
			
			if (this.sentido == 0) {
				
				while (index >= 0) {
					somatorioDeDeslocamentos += Math.abs(ultimaRequisicao - arrayListSCAN.get(index));
					this.arrayListDeslocamentos.add(Math.abs(ultimaRequisicao - arrayListSCAN.get(index)));
					
					if(inicial == 0){
						ControleGUI.setStatusValue((1-(this.arrayListSCAN.size()/this.contador))*100,2);
					}else{
						ControleGUI.setStatusValue((1-(this.arrayListSCAN.size()/this.contador))*100,3);
					}
					
					ultimaRequisicao = arrayListSCAN.get(index);
					arrayListSCANGravacao.add(arrayListSCAN.get(index));
					arrayListSCAN.remove(index);
					index--;
				}
				
				index++;
				sentido = 1;
			}
			else{
				
				while (index < arrayListSCAN.size()) {
					somatorioDeDeslocamentos += Math.abs(ultimaRequisicao - arrayListSCAN.get(index));
					this.arrayListDeslocamentos.add(Math.abs(ultimaRequisicao - arrayListSCAN.get(index)));
					if(inicial == 0){
						ControleGUI.setStatusValue((1-(this.arrayListSCAN.size()/this.contador))*100,2);
					}else{
						ControleGUI.setStatusValue((1-(this.arrayListSCAN.size()/this.contador))*100,3);
					}
					ultimaRequisicao = arrayListSCAN.get(index);
					arrayListSCANGravacao.add(arrayListSCAN.get(index));
					arrayListSCAN.remove(index);
				}
				
				index--;
				sentido = 0;
			}
		
		}
		
		ManipuladorDeArquivos.geraArquivo("arquivoSCAN" + this.sentido, arrayListSCANGravacao);
	}
	
	public double totalRequisicoes() {
	
		System.out.println("Somatorio "+ this.somatorioDeDeslocamentos + " SEEK: "+ this.seek + " Contador: " + this.contador);
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
