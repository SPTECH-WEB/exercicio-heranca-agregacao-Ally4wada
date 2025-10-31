package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {}

    public void contratar(Desenvolvedor desenvolvedor) {
        if (vagas > 0 && desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double somaSalarios = 0.0;
        for (Desenvolvedor i:desenvolvedores) {
            somaSalarios += i.calcularSalario();
        }
        return somaSalarios;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer qtd = 0;
        for (Desenvolvedor i:desenvolvedores) {
            if (i instanceof DesenvolvedorMobile) {
                qtd++;
            }
        }
        return qtd;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> salarioMaior = new ArrayList<>();
        for (Desenvolvedor d:desenvolvedores) {
            if (d.calcularSalario() >= salario) {
                salarioMaior.add(d);
            }
        }
        return salarioMaior;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Double salarioMenor = desenvolvedores.get(0).calcularSalario();
        Desenvolvedor menorSalario = desenvolvedores.get(0);

        for (Desenvolvedor d:desenvolvedores) {
            if (d.calcularSalario() < salarioMenor) {
                salarioMenor = d.calcularSalario();
                menorSalario = d;
            }
        }
        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> DevTecnologia = new ArrayList<>();
        for (Desenvolvedor d:desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                if (Objects.equals(((DesenvolvedorMobile) d).getPlataforma(), tecnologia) ||
                        Objects.equals(((DesenvolvedorMobile) d).getLinguagem(), tecnologia)) {
                    DevTecnologia.add(d);
                }
            } else if (d instanceof DesenvolvedorWeb) {
                if (Objects.equals(((DesenvolvedorWeb) d).getBackend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getFrontend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getSgbd(), tecnologia)) {
                    DevTecnologia.add(d);
                }
            }
        }
        return DevTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double soma = 0.0;
        for (Desenvolvedor d:desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                if (Objects.equals(((DesenvolvedorMobile) d).getPlataforma(), tecnologia) ||
                        Objects.equals(((DesenvolvedorMobile) d).getLinguagem(), tecnologia)) {
                    soma += d.calcularSalario();
                }
            } else if (d instanceof DesenvolvedorWeb) {
                if (Objects.equals(((DesenvolvedorWeb) d).getBackend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getFrontend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getSgbd(), tecnologia)) {
                    soma += d.calcularSalario();
                }
            }
        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}