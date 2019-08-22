package com.poll.repo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.poll.brainy.Client;
import com.poll.brainy.Criterio;
import com.poll.brainy.Encuesta;
import com.poll.brainy.GroupCoherence;
import com.poll.brainy.GrupoRespuesta;
import com.poll.brainy.Pregunta;
import com.poll.brainy.PreguntaCriterio;
import com.poll.brainy.PreguntaGrupo;
import com.poll.brainy.Respuesta;
import com.poll.brainy.TipoPregunta;
import com.poll.brainy.User;


@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(GroupCoherence.class);
        config.exposeIdsFor(Criterio.class);
        config.exposeIdsFor(TipoPregunta.class);
        config.exposeIdsFor(Respuesta.class);
        config.exposeIdsFor(Pregunta.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Client.class);
        config.exposeIdsFor(Encuesta.class);
        config.exposeIdsFor(PreguntaGrupo.class);
        config.exposeIdsFor(PreguntaCriterio.class);        
        config.exposeIdsFor(GrupoRespuesta.class);
    }
}
