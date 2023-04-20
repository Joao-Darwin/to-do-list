package projetopoo.demo.configs;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import projetopoo.demo.entities.Categoria;
import projetopoo.demo.entities.Lembrete;
import projetopoo.demo.entities.TagTarefa;
import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.entities.enums.ImportanciaTarefas;
import projetopoo.demo.repositories.CategoriaRepository;
import projetopoo.demo.repositories.LembreteRepository;
import projetopoo.demo.repositories.TagRepository;
import projetopoo.demo.repositories.TarefaRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LembreteRepository lembreteRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria categoria01 = new Categoria("IFPB");
		Categoria categoria02 = new Categoria("Trabalho");
		
		Tarefa tarefa01 = new Tarefa("Fazer atividade de POO", "Tenho que concluir a atividade colaborativa 07 de POO", categoria01, Instant.parse("2023-04-25T15:25:04Z"), ImportanciaTarefas.MEDIA);
		Tarefa tarefa02 = new Tarefa("Projeto Banco de Dados I", "terminar o diagrama entidade relacionamento", categoria01, Instant.parse("2023-04-25T15:25:04Z"), ImportanciaTarefas.MEDIA);
		
		categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02));
		tarefaRepository.saveAll(Arrays.asList(tarefa01, tarefa02));
		
		TagTarefa tag01 = new TagTarefa("Banco de dados I");
		TagTarefa tag02 = new TagTarefa("Programação Orientada a Objetos");
		TagTarefa tag03 = new TagTarefa("PDS");
		
		tagRepository.saveAll(Arrays.asList(tag01, tag02, tag03));
		
		tarefa01.getTagsTarefa().add(tag02);
		tarefa01.getTagsTarefa().add(tag03);
		tarefa02.getTagsTarefa().add(tag01);
		tarefa02.getTagsTarefa().add(tag03);
		
		tarefaRepository.saveAll(Arrays.asList(tarefa01, tarefa02));
		
		Lembrete lembrete01 = new Lembrete(Date.from(tarefa02.getDataConclusao()), "Revisar o código", tarefa02);
		
		lembreteRepository.save(lembrete01);		
	}	
}