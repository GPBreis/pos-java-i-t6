public class Motor {

	private int qtdPist;
	private int potencia;
	
	public Motor(){
		this.qtdPist = 0;
		this.potencia = 0;
	}

	public Motor(int qtdPist, int potencia){
		this.qtdPist = qtdPist;
		this.potencia = potencia;
	}


	public int getQtdPist() {
		return this.qtdPist;
	}

	public int getPotencia() {
		return this.potencia;
	}
	
	public final void setQtdPist(int qtdPist){
		this.qtdPist = qtdPist;
	}

	public final void setPotencia(int potencia){
		this.potencia = potencia;
	}

}