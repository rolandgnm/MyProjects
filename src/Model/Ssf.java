package Model;

import java.util.ArrayList;

public class Ssf {
	private ArrayList<Integer> arrayListSSF, arrayListSSFGravacao = new ArrayList<Integer>(), arrayListDeslocamentos = new ArrayList<Integer>();
	private int contador, inicioDoBraco, somatorioDeDeslocamentos;
	private double seek;
	
	@SuppressWarnings("unchecked")
	public Ssf(ArrayList<Integer> arrayListSSF, int inicioDoBraco, double seek) {
		super();
		this.arrayListSSF = (ArrayList<Integer>) arrayListSSF.clone();
		this.inicioDoBraco = inicioDoBraco;
		this.seek = seek;
		this.contador = arrayListSSF.size();
	}
	
	public void execute() {
		int index = 0, ultimaRequisicao = this.inicioDoBraco, minima = Integer.MAX_VALUE;
		ControleGUI.setStatusValue(0,4);
		
		while (!arrayListSSF.isEmpty()) {
			
			for (int i = 0; i < arrayListSSF.size(); i++) {
				if (minima > Math.abs(ultimaRequisicao - arrayListSSF.get(i))) {
					minima = Math.abs(ultimaRequisicao - arrayListSSF.get(i));
					index = i;
				}
			}
			
			this.somatorioDeDeslocamentos += Math.abs(ultimaRequisicao - arrayListSSF.get(index));
			this.arrayListDeslocamentos.add(Math.abs(ultimaRequisicao - arrayListSSF.get(index)));
			ControleGUI.setStatusValue((1-(this.arrayListSSF.size()/this.contador))*100,4);
			ultimaRequisicao = arrayListSSF.get(index);
			this.arrayListSSFGravacao.add(arrayListSSF.get(index));
			this.arrayListSSF.remove(index);
			minima = Integer.MAX_VALUE;
		}
		
		ManipuladorDeArquivos.geraArquivo("arquivoSSF", arrayListSSFGravacao);	
		
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
