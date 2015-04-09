package Model;

import java.util.ArrayList;


public class Fifo {
	private ArrayList<Integer> arrayListFIFO , arrayListFIFOGravacao = new ArrayList<Integer>(), arrayListDeslocamentos = new ArrayList<Integer>();
	private int contador, inicioDoBraco, somatorioDeDeslocamentos;
	private double seek;
	
	@SuppressWarnings("unchecked")
	public Fifo(ArrayList<Integer> arrayListFIFO, int inicioDoBraco, double seek) {
		
		this.arrayListFIFO = (ArrayList<Integer>) arrayListFIFO.clone();
		this.inicioDoBraco = inicioDoBraco;
		this.seek = seek;
		this.contador = arrayListFIFO.size();
	}
	
	public void execute() {
		
		int ultimaRequisicao = this.inicioDoBraco;
		ControleGUI.setStatusValue(0, 1);
		
		while (!arrayListFIFO.isEmpty()) {
			this.somatorioDeDeslocamentos += Math.abs(this.arrayListFIFO.get(0)- ultimaRequisicao);
			ControleGUI.setStatusValue((1-(this.arrayListFIFO.size()/this.contador))*100, 1);
			this.arrayListDeslocamentos.add(Math.abs(ultimaRequisicao - arrayListFIFO.get(0)));
			ultimaRequisicao = this.arrayListFIFO.get(0);
			arrayListFIFOGravacao.add(arrayListFIFO.get(0));
			arrayListFIFO.remove(0);
		}
				
		ManipuladorDeArquivos.geraArquivo("arquivoFIFO", arrayListFIFOGravacao);
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
