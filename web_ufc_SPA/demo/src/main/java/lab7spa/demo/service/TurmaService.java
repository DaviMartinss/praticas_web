package lab7spa.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lab7spa.demo.controller.Turma;

@Service
public class TurmaService {
	
	private List<Turma> turmaList = new ArrayList<Turma>();
	
	public TurmaService() {
		//produtos.addAll(Arrays.asList(new Produto(1, "Livro", 200f), new Produto(1, "Laptop", 938752.67f), new Produto(3, "Bicicleta", 12400f)));
	}
	
	public List<Turma> getTurmaList() {
		return turmaList;
	}

	public void addTurma(Turma t) {
		turmaList.add(t);
	}

    public Turma getTurmaById(int codigo) {
        Turma turma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
        return turma;
    }

    public Turma updateTurma(int codigo, Turma turma) {
        Turma oldTurma = turmaList.stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
        oldTurma.getAlunos().addAll(turma.getAlunos());
        oldTurma.setDisciplina(turma.getDisciplina());
        oldTurma.setSemestre(turma.getSemestre());

        return oldTurma;
    }

    public Boolean removeTurmaById(int codigo) {
        return turmaList.remove(new Turma ( codigo, null, (Integer) null, null));
    }

}
