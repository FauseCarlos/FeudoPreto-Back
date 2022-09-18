package com.terrasdevastadas.site.searialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.terrasdevastadas.site.model.Atividade;

public class AtividadeSerializer extends StdSerializer<Atividade> {
	
	private static final long serialVersionUID = 1L;
    public AtividadeSerializer(Class<Atividade> t) {
        super(t);
    }
    public AtividadeSerializer() {
        this(null);
    }
    @Override
    public void serialize(Atividade atividade, JsonGenerator jg, SerializerProvider sp)
            throws IOException, JsonGenerationException {
        jg.writeStartObject();
        jg.writeStringField("nome", atividade.getNome());
        jg.writeStringField("descrição", atividade.getDescrição());
        jg.writeBooleanField("concluida", atividade.isConcluida());
  
        jg.writeEndObject();
    }

}
