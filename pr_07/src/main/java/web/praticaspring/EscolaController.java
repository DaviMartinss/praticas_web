package web.praticaspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EscolaController {

	@Autowired
	TurmaService turmaService;

	@GetMapping("/api/turma")
	public List<Turma> getTurmaList() {
		return turmaService.getTurmaList();
	}

	@GetMapping("/api/turma/{codigo}")
	public Turma getTurma(@PathVariable int codigo) {
		return turmaService.getTurmaById(codigo);
	}

	@PostMapping("/api/turma")
	public void addTurma(@RequestBody Turma turma) {


		Turma turmaExiste = turmaService.getTurmaById(turma.getCodigo());
		if(turmaExiste == null) {
			turmaService.addTurma(turma);
		}

	}

	@PutMapping("/api/turma/{codigo}")
	public Turma updateTurma(@PathVariable int codigo, @RequestBody Turma turma) {
		
		Turma turmaExiste = turmaService.getTurmaById(codigo);
		
		if(turmaExiste != null) {
			return turmaService.updateTurma(codigo, turma);
		}else {
			System.out.println("Turma não existe");
			return null;
		}
		
	}

	@DeleteMapping("/api/turma/{codigo}")
	public Boolean deleteTurma(@PathVariable int codigo) {
		//return turmaService.removeTurmaById(codigo);

		Turma turma = turmaService.getTurmaById(codigo);

		if(turma != null) {
			return turmaService.removeTurmaById(codigo);
			
		}else {
			System.out.println("Turma não existe");
			return false;
		}

}

@GetMapping("/api/turma/{codigo}/alunos")
public List<Aluno> getTurmaAlunosById(@PathVariable int codigo) {
	return turmaService.getTurmaAlunosById(codigo);
}

@PostMapping("/api/turma/{codigo}/alunos")
public void addTurmaAluno(@PathVariable int codigo, @RequestBody Aluno aluno) {

	//verifica se a turma existe

	Turma turma = turmaService.getTurmaById(codigo);

	boolean alunoExite = false;

	if(turma != null) {

		//lista de alunos da turma
		List<Aluno> alunoList = turmaService.getAlunosDaTurma(turma);

		if(alunoList == null) {

			turmaService.addTurmaAluno(codigo, aluno);
		}else {

			for (Aluno alunoAux : alunoList) {
				if(alunoAux.getMatricula() == aluno.getMatricula()) {
					alunoExite = true;
				}
			}

			if(!alunoExite) {
				turmaService.addTurmaAluno(codigo, aluno);
			}else {
				System.out.println("Aluno já está cadastrado na turma");
			}
		}

	}else {
		System.out.println("Turma não existe");
	}

}

@DeleteMapping("/api/turma/{codigo}/alunos/{matricula}")
public Boolean deleteTurmaAlunoByMatricula(@PathVariable int codigo, @PathVariable int matricula) {

	//verifica se a turma existe

	Turma turma = turmaService.getTurmaById(codigo);

	boolean alunoExite = false;

	if(turma != null) {

		//lista de alunos da turma
		List<Aluno> alunoList = turmaService.getAlunosDaTurma(turma);

		if(alunoList == null) {

			System.out.println("Não existe alunos cadastrados na turma");
			return false;

		}else {

			for (Aluno alunoAux : alunoList) {
				if(alunoAux.getMatricula() == matricula) {
					alunoExite = true;
				}
			}

			if(alunoExite) {
				turmaService.removeTurmaAlunoByMatricula(codigo, matricula);
				return true;
			}else {
				System.out.println("Aluno não existe");
				return false;
			}
		}

	}else {
		System.out.println("Turma não existe");
		return false;
	}

}

}
