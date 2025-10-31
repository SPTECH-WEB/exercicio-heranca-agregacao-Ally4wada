package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora) {
        super(nome, qtdHoras, valorHora);
    }

    public DesenvolvedorWeb() {
        super("Paulo", 20, 20.50);
    }


    public Double calcularSalario(){
        return (this.horasMentoria*300) + (qtdHoras*valorHora);
    }

    public Boolean isFullstack(){
        if (backend != null && frontend != null && sgbd != null){
            return true;
        }
        return false;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    @Override
    public String toString() {
        return "DesenvolvedorWeb{" +
                "backend='" + backend + '\'' +
                ", frontend='" + frontend + '\'' +
                ", sgbd='" + sgbd + '\'' +
                ", horasMentoria=" + horasMentoria +
                '}';
    }
}
