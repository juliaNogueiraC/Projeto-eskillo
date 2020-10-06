import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import resolucaoeskillo.com.demo.model.AreaDeEstudo;
import resolucaoeskillo.com.demo.model.Competencia;
import resolucaoeskillo.com.demo.model.Localidade;
import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.model.TipoCompetencia;
import resolucaoeskillo.com.demo.model.TipoFormacao;
import resolucaoeskillo.com.demo.services.AreaDeEstudoService;
import resolucaoeskillo.com.demo.services.LocalidadeService;
import resolucaoeskillo.com.demo.services.PerfilService;
import resolucaoeskillo.com.demo.services.TipoCompetenciaService;
import resolucaoeskillo.com.demo.services.TipoFormacaoService;

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
		çocalidade  = localidadeService.adiciona(localidade);

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
**/
	}

}


/**
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