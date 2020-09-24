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



		


	/** 	AreaDeEstudo area1 = new AreaDeEstudo();
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