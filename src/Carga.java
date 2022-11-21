public final class Carga extends Veiculo {
	
	private int cargaMax;
	private int tara;

	public Carga(){
		this.cargaMax = 0;
		this.tara = 0;
	}

	public Carga(int cargaMax, int tara){
		this.cargaMax = cargaMax;
		this.tara = tara;
	}

	public final void setCargaMax(int cargaMax){
		this.cargaMax = cargaMax;
	}

	public final void setTara(int tara){
		this.tara = tara;
	}

	public int getCargaMax(){
		return cargaMax;
	}

	public int getTara(){
		return tara;
	}

	public float calcVel(float velocMax){
		return velocMax * 1000.0f;
	}
	
	public int calcular(){
		int total = 0;

		total += getVelocMax();
		total += getQtdRodas();
		total += getMotor().getQtdPist();
		total += getMotor().getPotencia();
		total += getCargaMax();
		total += getTara();

		return total;
	}

	@Override
	public String toString(){
		
		System.out.println("Placa: " + this.getPlaca());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Cor: " + this.getCor());
		System.out.println("Veloc. Max.: " + this.getVelocMax());
		System.out.println("Qtd. Rodas: " + this.getQtdRodas());
		System.out.println("Qtd. Pist. Motor: " + this.getMotor().getQtdPist());
		System.out.println("Pot. Motor: " + this.getMotor().getPotencia());
		System.out.println("Carga Max.: " + this.cargaMax);
		System.out.println("Tara : " + this.tara);
		return null;
	}

}