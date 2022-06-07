package web.praticaspring;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private int codigo;
	private String disciplina;
    private int semestre;
    private List<Aluno> alunos;
    
    public Turma(int codigo, String disciplina, int semestre) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.alunos = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
    	
    	if(this.alunos == null)
    		this.alunos = new ArrayList<Aluno>();
    	
        this.alunos.add(aluno);
    }

}
