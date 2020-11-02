import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import resolucaoeskillo.com.demo.model.Competencia;
import resolucaoeskillo.com.demo.model.Curso;
import resolucaoeskillo.com.demo.model.Experiencia;
import resolucaoeskillo.com.demo.model.Formacao;
import resolucaoeskillo.com.demo.model.Localidade;
import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.model.Telefone;
import resolucaoeskillo.com.demo.model.TipoCompetencia;
import resolucaoeskillo.com.demo.model.TipoEmprego;
import resolucaoeskillo.com.demo.model.TipoFormacao;
import resolucaoeskillo.com.demo.model.TipoTelefone;
import resolucaoeskillo.com.demo.services.LocalidadeService;
import resolucaoeskillo.com.demo.services.PerfilService;
import resolucaoeskillo.com.demo.services.TipoCompetenciaService;
import resolucaoeskillo.com.demo.services.TipoFormacaoService;
   
@SpringBootApplication
public class EskilloApplication implements CommandLineRunner {

	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private TipoCompetenciaService tipoCompetenciaService;

	@Autowired
	private TipoFormacaoService tipoFormacaoService;

	@Autowired
	private AreaEstudoService areaEstudoService;

	@Autowired
	private PerfilService perfilService;

	public static void main(String[] args) {
		SpringApplication.run(EskilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		Localidade localidade = new Localidade(null, "Teresina", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Parnaíba", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Recife", "PE");
		localidadeService.adiciona(localidade);

		TipoFormacao tipoFormacao = new TipoFormacao(null, "Bacharelado");
		tipoFormacaoService.adiciona(tipoFormacao);
		tipoFormacao = new TipoFormacao(null, "Mestrado");
		tipoFormacaoService.adiciona(tipoFormacao);
		tipoFormacao = new TipoFormacao(null, "Doutorado");
		tipoFormacaoService.adiciona(tipoFormacao);

		TipoCompetencia tipoCompetencia = new TipoCompetencia(null, "Javascript");
		tipoCompetenciaService.adiciona(tipoCompetencia);
		tipoCompetencia = new TipoCompetencia(null, "Front-end");
		tipoCompetenciaService.adiciona(tipoCompetencia);
		tipoCompetencia = new TipoCompetencia(null, "Oracle");
		tipoCompetenciaService.adiciona(tipoCompetencia);

		AreaDeEstudo areaEstudo = new AreaDeEstudo(null, "Engenharia de Software");
		areaDeEstudoService.adiciona(areaEstudo);
		areaEstudo = new AreaDeEstudo(null, "Administração");
		areaDeEstudoService.adiciona(areaEstudo);
		areaEstudo = new AreaDeEstudo(null, "Direito");
		areaDeEstudoService.adiciona(areaEstudo);

		Perfil perfil = new Perfil();
		perfil.setNome("Fulano de Tal");
		perfil.setCargoAtual("Professor");
		perfil.setSobre("De boa!");
		perfil.setEndereco("Rua Cafundó de Judas, 100");
		perfil.setComplemento("Apto 101");
		perfil.setBairro("Centro");
		perfil.setCidade("Teresina");
		perfil.setUf("PI");
		perfil.setEmail("fulano@gmail.com");
		perfil.setVisibilidadePerfil(true);
		perfil.setLocalidade(localidadeService.busca(1l));	// Teresina
		Perfil novo = perfilService.adiciona(perfil);

		Curso curso1 = new Curso();
		curso1.setDescricao("Administrador de banco de dados Oracle Exemplo");
		curso1.setOrganizacao("Organizações Tabajaras 1");
		curso1.setCargaHoraria(40);
		curso1.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"));
		curso1.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2020"));
		perfilService.adicionaCurso(novo.getId(), curso1);

		Curso curso2 = new Curso();
		curso2.setDescricao("WebDesign com HTML5 e CSS3");
		curso2.setOrganizacao("Tapioca Design");
		curso2.setCargaHoraria(32);
		curso2.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("05/11/2019"));
		curso2.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2019"));
		perfilService.adicionaCurso(novo.getId(), curso2);

		Experiencia experiencia1 = new Experiencia();
		experiencia1.setCargo("Professor");
		experiencia1.setTipoEmprego(TipoEmprego.TEMPO_INTEGRAL);
		experiencia1.setNomeEmpresa("Faculdade do Saber");
		experiencia1.setLocalidade(localidadeService.busca(1l));	// Teresina
		experiencia1.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2018"));
		experiencia1.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2019"));
		experiencia1.setOcupacaoAtual(false);
		experiencia1.setDescricao("Disciplina: Algoritmo e Lógica de Programação");
		perfilService.adicionaExperiencia(novo.getId(), experiencia1);

		Experiencia experiencia2 = new Experiencia();
		experiencia2.setCargo("Gerente de Projetos");
		experiencia2.setTipoEmprego(TipoEmprego.TEMPO_INTEGRAL);
		experiencia2.setNomeEmpresa("Organizações Tabajaras");
		experiencia2.setLocalidade(localidadeService.busca(2l));	// Parnaíba
		experiencia2.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("05/10/2019"));
		experiencia2.setDataFim(null);
		experiencia2.setOcupacaoAtual(true);
		experiencia2.setDescricao("Projetos de cooperativas agrícolas");
		perfilService.adicionaExperiencia(novo.getId(), experiencia2);

		Formacao formacao1 = new Formacao();
		formacao1.setNomeInstituicao("Faculdade Menina Bonita");
		formacao1.setTipoFormacao(tipoFormacaoService.busca(1l));	// Bacharelado
		formacao1.setAreaEstudo(areaEstudoService.busca(1l));	// Engenharia de Software
		formacao1.setAnoInicio(2016);
		formacao1.setAnoFim(2019);
		formacao1.setEmAndamento(false);
		formacao1.setDescricao("Dissertação: As tranças do Rei Careca aplicadas à Engenharia de Requisitos");
		perfilService.adicionaFormacao(novo.getId(), formacao1);

		Competencia competencia1 = new Competencia();
		competencia1.setTipoCompetencia(tipoCompetenciaService.busca(1l));	// JavaScript
		perfilService.adicionaCompetencia(novo.getId(), competencia1);

		Competencia competencia2 = new Competencia();
		competencia2.setTipoCompetencia(tipoCompetenciaService.busca(2l));	// Front-end
		perfilService.adicionaCompetencia(novo.getId(), competencia2);

		Competencia competencia3 = new Competencia();
		competencia3.setTipoCompetencia(tipoCompetenciaService.busca(3l));	// Oracle
		perfilService.adicionaCompetencia(novo.getId(), competencia3);

		Telefone telefone1 = new Telefone();
		telefone1.setNumero("(86) 91234-5678");
		telefone1.setTipo(TipoTelefone.CELULAR);
		perfilService.adicionaTelefone(novo.getId(), telefone1);

		Telefone telefone2 = new Telefone();
		telefone2.setNumero("(86) 3123-9876");
		telefone2.setTipo(TipoTelefone.FIXO_RESIDENCIAL);
		perfilService.adicionaTelefone(novo.getId(), telefone2);

	}

}

/** 
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private TipoCompetenciaService tipoCompetenciaService;

	@Autowired
	private TipoFormacaoService tipoFormacaoService;

	@Autowired
	private AreaDeEstudoService areaDeEstudoService;


	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Popula o banco de dados com dados de exemplo

		Localidade localidade = new Localidade(null, "Teresina", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Parnaíba", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Recife", "PE");
		localidade  = localidadeService.adiciona(localidade);

		TipoFormacao tipoFormacao = new TipoFormacao(null, "Bacharelado");
		tipoFormacaoService.adiciona(tipoFormacao);
		tipoFormacao = new TipoFormacao(null, "Mestrado");
		tipoFormacaoService.adiciona(tipoFormacao);
		tipoFormacao = new TipoFormacao(null, "Doutorado");
		tipoFormacaoService.adiciona(tipoFormacao);

		TipoCompetencia tipoCompetencia = new TipoCompetencia(null, "Javascript");
		tipoCompetenciaService.adiciona(tipoCompetencia);
		tipoCompetencia = new TipoCompetencia(null, "Front-end");
		tipoCompetenciaService.adiciona(tipoCompetencia);
		tipoCompetencia = new TipoCompetencia(null, "Oracle");
		tipoCompetenciaService.adiciona(tipoCompetencia);

		AreaDeEstudo areaDeEstudo = new AreaDeEstudo(null, "Engenharia de Software");
		areaDeEstudoService.adiciona(areaDeEstudo);
		areaDeEstudo = new AreaDeEstudo(null, "Administração");
		areaDeEstudoService.adiciona(areaDeEstudo);
		areaDeEstudo = new AreaDeEstudo(null, "Direito");
		areaDeEstudoService.adiciona(areaDeEstudo);

	
	  Perfil perfil = new Perfil();
	  perfil.setBairro("exemplo");
	  perfil.setCargoAtual("desempregado");// ele vai "setar" essas inf 
      perfil.setNome("peter");// e por ai vai .....
      perfil.setVisibilidadePerfil(true);
	  perfilService.add(perfil);// adicionar o perfil ai nesse repository por meio do service 
	  



	/**  Competencia Javascript = new Competencia();
	  tipoCompetencia = tipoCompetenciaService.busca(1l);
	Javascript.setId(null);
	Javascript.getTipoCompetencia(tipoCompetencia);
	perfil.getCompetencias().add(Javascript);

	perfilService.add(perfil);


	  tipoCompetencia = tipoCompetenciaService.busca(3l);

	}

}



 package resolucaoeskillo.com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import resolucaoeskillo.com.demo.services.TipoFormacaoService;

@SpringBootApplication
public class DemoApplication {

@Autowired
private TipoFormacaoService service;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Override
	 public void run(String... args)throws Exception {
	 
		System.out.println("qut de registrod:" + service.lista()).size());// listagem do service 

// size é o tamanho dac lista . aqui ele mostra a quantidade e faz a listagem 



		


		AreaDeEstudo area1 = new AreaDeEstudo();
		area1.setId(1l);
		area1.setDescricao("Engenharia de Software");
		System.out.println(area1.toString());

		AreaDeEstudo area2 = new AreaDeEstudo(2l, "Gastronomia");
		System.out.println(area2.toString());

		TipoFormacao tipo1 = new TipoFormacao();
		tipo1.setId(1l);
		tipo1.setDescricao("Bacharelado");
		System.out.println(tipo1.toString());

		Perfil perfilAnderson = new Perfil();
		perfilAnderson.setId(10l);
		perfilAnderson.setNome("Anderson");
		perfilAnderson.setCargoAtual("Professor");
		perfilAnderson.setEmail("anderson.lima@grupocev.com");

		Experiencia experienciaICev = new Experiencia();
		experienciaICev.setId(1l);
		experienciaICev.setCargo("Professor");
		experienciaICev.setNomeEmpresa("iCEV");
		experienciaICev.setDataInicio(Calendar.getInstance().getTime());
		experienciaICev.setDataFim(null);
		experienciaICev.setOcupacaoAtual(true);
		perfilAnderson.getExperiencias().add(experienciaICev);

		Telefone telefone1 = new Telefone();
		telefone1.setTipo(TipoTelefone.CELULAR);
		telefone1.setNumero("(86) 99912-3456");
		perfilAnderson.getTelefones().add(telefone1);

		System.out.println(perfilAnderson.toString());

	} **/
}
}