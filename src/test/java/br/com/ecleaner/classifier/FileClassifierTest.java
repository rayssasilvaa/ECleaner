package br.com.ecleaner.classifier;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * PATH: representa o caminho do arquivo utilizado no teste.
 * FILE CATEGORY: armazena a categoria identificada pelo classificador.
 * ASSERT EQUALS: compara o resultado obtido com o resultado esperado.
 * ASSERT THROWS: verifica se o metodo lança a exceção esperada.
 */

public class FileClassifierTest {

    //instancia do FileClassifier
    private final FileClassifier classifier = new FileClassifier();

    @Test
    void classificarFileTmpComoTemporario() {

        //simula o caminho de um arquivo temporario
        Path arquivo = Path.of("arquivo.tmp");

        //executa a classificacao do arquivo
        FileCategory category = classifier.classificar(arquivo);

        //verifica se o resultado é um arquivo tmp
        assertEquals(FileCategory.TEMPORY, category);

    }

    @Test
     void classificarArquivoComOutraExtensaoComoOther() {

        Path arquivo = Path.of("arquivo.pdf");

        FileCategory category = classifier.classificar(arquivo);

        assertEquals(FileCategory.OTHER, category);
    }

    @Test
    void deveReconhecerExtensaoComLetraMaiuscula() {

        Path arquivo = Path.of("arquivo.TMP");

        FileCategory category = classifier.classificar(arquivo);

        assertEquals(FileCategory.TEMPORY, category);
    }

    @Test
    void classificarArquivoDentroDeDiretorioCache(){

        Path arquivo = Path.of("Aplicativos", "Opera GX", "Cache", "arquivo.dat");

        FileCategory category = classifier.classificar(arquivo);

        assertEquals(FileCategory.CACHE, category);
    }

    @Test
    void classificarArquivoDentroDeDiretorioCacheEmMinusculo(){

        Path arquivo = Path.of("Aplicativos", "Opera GX", "cache", "arquivo.dat");

        FileCategory category = classifier.classificar(arquivo);

        assertEquals(FileCategory.CACHE, category);
    }

    @Test
    void deveReconhecerDiretorioCacheEmSubpastas() {

        Path arquivo = Path.of("Aplicativos", "Opera GX", "Cache", "Dados", "arquivo.dat");

        FileCategory category = classifier.classificar(arquivo);

        assertEquals(FileCategory.CACHE, category);
    }

    @Test
    void deveRejeitarCaminhosNull(){

        assertThrows(
                NullPointerException.class, () -> classifier.classificar(null)
        );
    }
}


