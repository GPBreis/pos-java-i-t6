public final class BDVeiculos {

    private Passeio[] listaPasseio;
    private Carga[] listaCarga;
    private int iP;
    private int iC;

    BDVeiculos() {
        listaPasseio = new Passeio[5];
        listaCarga = new Carga[5];
        iP = 0;
        iC = 0;
    }
    
    public void setiP(int iP) {
        this.iP = iP;
    }

    public void setiC(int iC) {
        this.iC = iC;
    }

    public int getiP() {
        return iP;
    }

    public int getiC() {
        return iC;
    }

    public void addPasseio(Passeio pass) {
        listaPasseio[iP] = pass;
        iP++;
    }

    public boolean passeioVago() {
        if (iP < listaPasseio.length) {
            return true;
        } else {
            System.out.println("Não é possível cadastrar mais veículos de passeio.");
            return false;
        }
    }

    public Passeio[] getListaPasseio() {
        return listaPasseio;
    }

    
    public boolean existePasseio(String placa) throws VeicExistException {
        for(int i = 0; i < getiP(); i++){
            if(getListaPasseio()[i].getPlaca().equalsIgnoreCase(placa)){
                return true;
            }
        }
        return false;
    }

    public void addCarga(Carga c) {
        listaCarga[iC] = c;
        iC++;
    }

    public boolean cargaVago() {
        if (iC < listaCarga.length) {
            return true;
        } else {
            System.out.println("Não é possível cadastrar mais veículos de carga.");
            return false;
        }
    }

    public Carga[] getListaCarga() {
        return listaCarga;
    }

    public boolean existeCarga(String placa) throws VeicExistException {
        for(int i = 0; i < getiC(); i++){
            if(getListaCarga()[i].getPlaca().equalsIgnoreCase(placa)){
                return true;
            }
        }
        return false;
    }
}