import java.util.InputMismatchException;

public class Teste {

	public static Leitura scan = new Leitura();
	public static String op = "";

	public static void main(String args[]) {

		boolean sair = false;
		Passeio[] p = { new Passeio(), new Passeio(), new Passeio(), new Passeio(), new Passeio() };
		Carga[] c = { new Carga(), new Carga(), new Carga(), new Carga(), new Carga() };

		BDVeiculos bdVeiculos = new BDVeiculos();

		while (!sair) {
			System.out.println("Sistema de Gestão de Veículos - Menu Inicial\n");
			System.out.println(
					"\t1. Cadastrar Veículo de Passeio\n\t2. Cadastrar Veículo de Carga\n\t3. Imprimir Todos os Veículos de Passeio"
							+ "\n\t4. Imprimir Todos os Veículos de Carga\n\t5. Imprimir Veículo de Passeio Pela Placa\n\t6. Imprimir Veículo de Carga Pela Placa"
							+ "\n\t7. Sair do Sistema\n");
			try {
				op = scan.entDados("OP: ");
			} catch (InputMismatchException e) {
				System.out.println("Tipo de entrada incorreta, informe apenas numeros.");
			}

			switch (op) {
				case "1":
					String continua = "s";
					while (continua.equalsIgnoreCase("s")) {
						if (bdVeiculos.passeioVago()) {
							Passeio pas = new Passeio();
							System.out.println(
									"Informe os dados cadastrais do veiculo de passeio " + (bdVeiculos.getiP() + 1));
							bdVeiculos.addPasseio(cPasseio(pas));
							continua = scan.entDados("Continuar o cadastro? (s/n)");
						} else {
							continua = "n";
						}
					}
					break;
				case "2":
					continua = "s";
					while (continua.equalsIgnoreCase("s")) {
						if (bdVeiculos.cargaVago()) {
							Carga car = new Carga();
							System.out.println(
									"Informe os dados cadastrais do veiculo de carga " + (bdVeiculos.getiC() + 1));
							bdVeiculos.addCarga(cCarga(car));
							continua = scan.entDados("Continuar o cadastro? (s/n)");
						} else {
							continua = "n";
						}
					}
					break;
				case "3":
					for (int i = 0; i < bdVeiculos.getiP(); i++) {
						System.out.println();
						System.out.println("Dados cadastrais do veiculo de passeio " + (i + 1));
						vPasseio(bdVeiculos.getListaPasseio()[i]);
						System.out.println();
					}
					break;
				case "4":
					for (int i = 0; i < bdVeiculos.getiC(); i++) {
						System.out.println();
						System.out.println("Dados cadastrais do veiculo de carga " + (i + 1));
						vCarga(bdVeiculos.getListaCarga()[i]);
						System.out.println();
					}
					break;
				case "5":
					Passeio passeio = new Passeio();
					boolean temPlacaP = false;
					String passeioPlaca = scan.entDados("Informe a placa do veiculo de passeio:");
					passeio.setPlaca(passeioPlaca);
					for (int i = 0; i < p.length; i++) {
						if (p[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
							temPlacaP = true;
							System.out.println("Dados do veículo de passeio " + (i + 1));
							vPasseio(p[i]);
						}
					}
					if (!temPlacaP) {
						System.out.println("Placa nao cadastrada");
					}
					break;
				case "6":
					Carga carga = new Carga();
					boolean temPlacaC = false;
					String cargaPlaca = scan.entDados("Informe a placa do veiculo de carga:");
					carga.setPlaca(cargaPlaca);
					for (int i = 0; i < c.length; i++) {
						if (c[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
							temPlacaC = true;
							System.out.println("Dados do veículo de carga " + (i + 1));
							vCarga(c[i]);
						}
					}
					if (!temPlacaC) {
						System.out.println("Placa nao cadastrada");
					}
					break;
				case "7":
					sair = true;
					break;
				default:
					System.out.println("Informe um dos valores apresentados");
					break;
			}
		}
	}

	public static Passeio cPasseio(Passeio passeio) {
		System.out.print("Informe a placa: ");
		passeio.setPlaca(scan.entDados(""));
		System.out.print("Informe a marca: ");
		passeio.setMarca(scan.entDados(""));
		System.out.print("Informe o modelo: ");
		passeio.setModelo(scan.entDados(""));
		System.out.print("Informe a cor: ");
		passeio.setCor(scan.entDados(""));
		System.out.print("Informe a veloc. Max.: ");
		try{
			passeio.setVelocMax(Float.parseFloat(scan.entDados("")));
		} catch (VelocException e) {
			
		}
		System.out.print("Informe a qtd. de rodas: ");
		passeio.setQtdRodas(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a qtd. de pistoes do motor: ");
		passeio.getMotor().setQtdPist(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a potencia do motor: ");
		passeio.getMotor().setPotencia(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a quantidade de passageiros: ");
		passeio.setQtdPassageiros(Integer.parseInt(scan.entDados("")));
		return passeio;
	}

	public static void vPasseio(Passeio passeio) {
		System.out.println("Placa: " + passeio.getPlaca());
		System.out.println("Marca: " + passeio.getMarca());
		System.out.println("Modelo: " + passeio.getModelo());
		System.out.println("Cor: " + passeio.getCor());
		System.out.println("Qtd. de pistoes do motor: " + passeio.getMotor().getQtdPist());
		System.out.println("Potencia do motor: " + passeio.getMotor().getPotencia());
		System.out.println("Qtd. Passageiros: " + passeio.getQtdPassageiros());
		System.out.println("Veloc. Max. do veiculo de passeio: " + passeio.calcVel(passeio.getVelocMax()) + " CM/H");
		System.out.println("Soma das letras: " + passeio.calcular());
	}

	public static Carga cCarga(Carga carga) {
		System.out.print("Informe a placa: ");
		carga.setPlaca(scan.entDados(""));
		System.out.print("Informe a marca: ");
		carga.setMarca(scan.entDados(""));
		System.out.print("Informe o modelo: ");
		carga.setModelo(scan.entDados(""));
		System.out.print("Informe a cor: ");
		carga.setCor(scan.entDados(""));
		System.out.print("Informe a veloc. Max.: ");
		try {
			carga.setVelocMax(Float.parseFloat(scan.entDados("")));
		} catch (VelocException e) {
			
		}
		System.out.print("Informe a qtd. de rodas: ");
		carga.setQtdRodas(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a qtd. de pistoes do motor: ");
		carga.getMotor().setQtdPist(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a potencia do motor: ");
		carga.getMotor().setPotencia(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a quantidade de carga max.: ");
		carga.setCargaMax(Integer.parseInt(scan.entDados("")));
		System.out.print("Informe a tara: ");
		carga.setTara(Integer.parseInt(scan.entDados("")));
		return carga;
	}

	public static void vCarga(Carga carga) {
		System.out.println("Placa: " + carga.getPlaca());
		System.out.println("Marca: " + carga.getMarca());
		System.out.println("Modelo: " + carga.getModelo());
		System.out.println("Cor: " + carga.getCor());
		System.out.println("Qtd. de pistoes do motor: " + carga.getMotor().getQtdPist());
		System.out.println("Potencia do motor: " + carga.getMotor().getPotencia());
		System.out.println("Qtd. Carga Max.: " + carga.getCargaMax());
		System.out.println("Tara: " + carga.getTara());
		System.out.println("Veloc. Max. do veiculo de passeio: " + carga.calcVel(carga.getVelocMax()) + " M/H");
		System.out.println("Soma dos numeros: " + carga.calcular());
	}

}