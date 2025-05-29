package br.com.cotiinformatica.configurations;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cotiinformatica.dtos.TarefaRequestDto;
import br.com.cotiinformatica.dtos.TarefaResponseDto;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Tarefa;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
    	
        var mapper = new ModelMapper(); //instanciando o ModelMapper

        //Configurando a cópia dos dados de 'TarefaRequestDto' para 'Tarefa'
        mapper.addMappings(new PropertyMap<TarefaRequestDto, Tarefa>() {
            @Override
            protected void configure() {
               
                map().setTitulo(source.getTitulo());
                map().setFinalizada(source.getFinalizada());

                using(ctx -> {
                    try {
                        String data = ((TarefaRequestDto) ctx.getSource()).getData();
                        String hora = ((TarefaRequestDto) ctx.getSource()).getHora();
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data + " " + hora);
                    } catch (Exception e) {
                        return null;
                    }
                }).map(source, destination.getDataHora());

                using(ctx -> {
                    Categoria categoria = new Categoria();
                    categoria.setId(((TarefaRequestDto) ctx.getSource()).getCategoriaId());
                    return categoria;
                }).map(source, destination.getCategoria());
            }
        });
        
      //Configurando a cópia dos dados de 'Tarefa' para 'TarefaResponseDto'
        mapper.addMappings(new PropertyMap<Tarefa, TarefaResponseDto>() {
            @Override
            protected void configure() {
            	
                map().setId(source.getId());
                map().setTitulo(source.getTitulo());
                map().setFinalizado(source.getFinalizada());

                using(ctx -> {
                    Date dataHora = (Date) ctx.getSource();
                    return new java.text.SimpleDateFormat("yyyy-MM-dd").format(dataHora);
                }).map(source.getDataHora(), destination.getData());

                using(ctx -> {
                    Date dataHora = (Date) ctx.getSource();
                    return new java.text.SimpleDateFormat("HH:mm").format(dataHora);
                }).map(source.getDataHora(), destination.getHora());
            }
        });

        return mapper;
    }
}






