package br.com.ecleaner.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatarTamanhoTest {
    @Test
    void formatarBytes(){
        String resultado = FormatarTamanho.formatarDocumento(72);

        assertEquals("72,00 B", resultado);
    }
}
