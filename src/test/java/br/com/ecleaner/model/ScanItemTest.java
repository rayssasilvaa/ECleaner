package br.com.ecleaner.model;

/*
 * PATH: representa o caminho do arquivo utilizado no teste.
 * SCAN ITEM: representa o arquivo analisado.
 * ASSERT EQUALS: compara os valores armazenados com os valores esperados.
 */

import br.com.ecleaner.classifier.FileCategory;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScanItemTest {
    @Test
    void deveCriarScanItemComDadosValidos(){
        Path caminhoArquivo = Path.of("Downloads", "arquivo.tmp");

        ScanItem scanItem = new ScanItem(caminhoArquivo, 250, FileCategory.TEMPORARY);

        assertEquals(caminhoArquivo, scanItem.getCaminhoArquivo());
        assertEquals(250, scanItem.getTamanhoBytes());
        assertEquals(FileCategory.TEMPORARY, scanItem.getCategoria());
    }

    @Test
    void deveLancarExcecaoSeOCaminhoForNull(){
        assertThrows(NullPointerException.class,
                () -> new ScanItem(null, 250, FileCategory.TEMPORARY));
    }

    @Test
    void deveLancarExcecaoSeACategoriaForNull(){
        assertThrows(NullPointerException.class,
                () -> new ScanItem(Path.of("arquivo.tmp"), 250, null));
    }

    @Test
    void deveLancarExcecaoSeOTamanhoForNegativo(){
        assertThrows(IllegalArgumentException.class,
                () -> new ScanItem(Path.of("arquivo.tmp"), -1, FileCategory.TEMPORARY));
    }

    @Test
    void deveAceitarTamanhoIgualAZero(){
        ScanItem scanItem = new ScanItem(Path.of("arquivo.tmp"), 0, FileCategory.TEMPORARY);

        assertEquals(0, scanItem.getTamanhoBytes());
    }


}
