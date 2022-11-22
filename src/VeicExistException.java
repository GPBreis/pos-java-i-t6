public class VeicExistException extends Exception {
    VeicExistException() {
        System.out.println("Já existe um veículo com esta placa");
    }
}