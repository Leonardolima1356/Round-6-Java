import java.util.ArrayList;

public class Desafio {
    private String nome;
    private int minimoParticipantes;
    private int maximoAprovados;
    private ArrayList<String> regras;
    private Local local;

    public Desafio(String nome, int minimoParticipantes, int maximoAprovados, ArrayList<String> regras, Local local) {
        this.nome = nome;
        this.minimoParticipantes = minimoParticipantes;
        this.maximoAprovados = maximoAprovados;
        this.regras = regras;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public int getMinimoParticipantes() {
        return minimoParticipantes;
    }

    public int getMaximoAprovados() {
        return maximoAprovados;
    }

    public ArrayList<String> getRegras() {
        return regras;
    }

    public Local getLocal() {
        return local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMinimoParticipantes(int minimoParticipantes) {
        this.minimoParticipantes = minimoParticipantes;
    }

    public void setMaximoAprovados(int maximoAprovados) {
        this.maximoAprovados = maximoAprovados;
    }

    public void setRegras(ArrayList<String> regras) {
        this.regras = regras;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "\nDesafio: " + nome + "\nMínimo Participantes: " + minimoParticipantes +
                "\nMáximo Aprovados: " + maximoAprovados + "\nLocal: " + local.getNome() +
                "\nRegras: \n" + regras.toString();
    }
}
