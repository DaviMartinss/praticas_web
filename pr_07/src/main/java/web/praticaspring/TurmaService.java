package web.praticaspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TurmaService {
	
	private List<Turma> turmaList = new ArrayList<Turma>();
	
	public TurmaService() {
		//produtos.addAll(Arrays.asList(new Produto(1, "Livro", 200f), new Produto(1, "Laptop", 938752.67f), new Produto(3, "Bicicleta", 12400f)));
	}
	
	public List<Turma> getTurmaList() {
		return turmaList;
	}

	public void addTurma(Turma turma) {
		
		
			turmaList.add(turma);
			
		
	}

    public Turma getTurmaById(int codigo) {
        System.out.println("código: "+codigo);
        //turma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
        for (Turma turma : turmaList) {
			if(turma.getCodigo() == codigo) {
				return turma;
			}
		}
        
        return null;
    }
    
    public List<Aluno> getTurmaAlunosById(int codigo) {
        Turma turma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
    	
        return turma.getAlunos();
    }
    
    public List<Aluno> getAlunosDaTurma(Turma turma) {
    	return turma.getAlunos();
    }

    public Turma updateTurma(int codigo, Turma turma) {
    	
        Turma oldTurma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
        
        oldTurma.setDisciplina(turma.getDisciplina());
        oldTurma.setSemestre(turma.getSemestre());

        return oldTurma;
    }

    public Boolean removeTurmaById(int codigo) {
        return turmaList.remove(turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get());
    }

	public void addTurmaAluno(int codigo, Aluno aluno) {
		
		Turma turma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
		
		turma.setAlunos(aluno);
			
	}

	public Boolean removeTurmaAlunoByMatricula(int codigo, int matricula) {
		
		
		Turma turma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
		
		return turma.getAlunos().remove(turma.getAlunos().stream().filter(a -> a.getMatricula() == matricula).findFirst().get());

	}

}

