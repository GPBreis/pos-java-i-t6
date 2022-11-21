public final class Passeio extends Veiculo implements Calcular {
	
	private int qtdPassageiros;

	public Passeio(){
		this.qtdPassageiros = 0;
	}

	public Passeio(int qtdPassageiros){
		this.qtdPassageiros = qtdPassageiros;
	}

	public final void setQtdPassageiros(int qtdPassageiros){
		this.qtdPassageiros = qtdPassageiros;
	}

	public int getQtdPassageiros (){
		return qtdPassageiros;
	}

	public float calcVel(float velocMax){
		return velocMax * 100000.0f;
	}

	public int calcular () {
		int total = 0;

		total += getPlaca().length();
		total += getMarca().length();
		total += getModelo().length();
		total += getCor().length();

		return total;
	}

	@Override
	public String toString(){
		
		System.out.println("Placa: " + this.getPlaca());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Cor: " + this.getCor());
		System.out.println("Veloc. Max.: " + this.calcVel(this.getVelocMax()));
		System.out.println("Qtd. Rodas: " + this.getQtdRodas());
		System.out.println("Qtd. Pist. Motor: " + this.getMotor().getQtdPist());
		System.out.println("Pot. Motor: " + this.getMotor().getPotencia());
		System.out.println("Qtd. Passageiros: " + this.qtdPassageiros);
		return null;
	}

}