abstract class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private float velocMax;
	private int qtdRodas;
	private Motor motor;

	public Veiculo(){
		this.placa = " ";
		this.marca = " ";
		this.modelo = " ";
		this.cor = " ";
		this.velocMax = 0.0f;
		this.qtdRodas = 0;
		motor = new Motor(0, 0);
	}

	public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia){
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.velocMax = velocMax;
		this.qtdRodas = qtdRodas;
		motor = new Motor(qtdPist, potencia);
	}


	public String getPlaca() {
		return this.placa;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getCor() {
		return this.cor;
	}

	public float getVelocMax() {
		return this.velocMax;
	}

	public int getQtdRodas() {
		return this.qtdRodas;
	}

	public Motor getMotor() {
		return this.motor;
	}
	
	public final void setPlaca(String placa) throws VeicExistException {
		this.placa = placa;
	}

	public final void setMarca(String marca){
		this.marca = marca;
	}

	public final void setModelo(String modelo){
		this.modelo = modelo;
	}

	public final void setCor(String cor){
		this.cor = cor;
	}

	public final void setVelocMax(float velocMax) throws VelocException {
		if(velocMax >= 80 && velocMax <= 110){
			this.velocMax = velocMax;
		} else if (this instanceof Passeio) {
			this.velocMax = 100.0f;
			throw new VelocException();
		} else if (this instanceof Carga) {
			this.velocMax = 90.0f;
			throw new VelocException();
		}
	}

	public final void setQtdRodas(int qtdRodas){
		this.qtdRodas = qtdRodas;
	}

	abstract float calcVel(float velocMax);
	


	@Override
	public String toString(){
		
		System.out.println("Placa: " + this.placa);
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Cor: " + this.cor);
		System.out.println("Veloc. Máx.: " + this.velocMax);
		System.out.println("Qtd. Rodas: " + this.qtdRodas);
		System.out.println("Qtd. Pist. Motor: " + this.motor.getQtdPist());
		System.out.println("Pot. Motor: " + this.motor.getPotencia());
		return null;
	}

}