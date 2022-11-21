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

    public int getiP() {
        return iP;
    }

    public int getiC() {
        return iC;
    }

    public void addPasseio(Passeio pass) {
        this.listaPasseio[this.iP] = pass;
        this.iP++;
    }

    public boolean passeioVago() {
        if (this.iP < this.listaPasseio.length) {
            return true;
        } else {
            System.out.println("Não é possível cadastrar mais veículos de passeio.");
            return false;
        }
    }

    public Passeio[] getListaPasseio() {
        return listaPasseio;
    }

    /*
    public boolean existePasseio(String placa) {
        for(int i = 0; i < getiP(); i++){
            if(getListaPasseio()[i].getPlaca().equalsIgnoreCase(placa)){
                
            } 
        }
    }
*/
    public void addCarga(Carga c) {
        this.listaCarga[this.iC] = c;
        this.iC++;
    }

    public boolean cargaVago() {
        if (this.iC < this.listaCarga.length) {
            return true;
        } else {
            System.out.println("Não é possível cadastrar mais veículos de carga.");
            return false;
        }
    }

    public Carga[] getListaCarga() {
        return listaCarga;
    }
}