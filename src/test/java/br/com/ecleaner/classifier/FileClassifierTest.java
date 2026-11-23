
package br.com.ecleaner.classifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * PATH: representa os caminhos dos arquivos utilizados nos testes.
 * TEMP DIR: fornece um diretório temporário para os cenários de teste.
 * FILE CLASSIFIER: realiza a classificação dos arquivos.
 * ASSERT EQUALS: compara a categoria obtida com a categoria esperada.
 * ASSERT THROWS: verifica se a exceção esperada foi lançada.
 */
class FileClassifierTest {

    @TempDir
    Path diretorioTemp;

    @Test
    void classificarFileTmpComoTemporario() {

        Path diretorioCache = diretorioTemp.resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        Path arquivo = Path.of("arquivo.tmp");

        FileCategory category = fileClassifier.classificar(arquivo);

        assertEquals(FileCategory.TEMPORARY, category);
    }

    @Test
    void classificarArquivoComOutraExtensaoComoOther() {

        Path diretorioCache = diretorioTemp.resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        Path arquivo = Path.of("arquivo.pdf");

        FileCategory category = fileClassifier.classificar(arquivo);

        assertEquals(FileCategory.OTHER, category);
    }

    @Test
    void deveReconhecerExtensaoComLetraMaiuscula() {

        Path diretorioCache = diretorioTemp.resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        Path arquivo = Path.of("arquivo.TMP");

        FileCategory category = fileClassifier.classificar(arquivo);

        assertEquals(FileCategory.TEMPORARY, category);
    }

    @Test
    void classificarArquivoDentroDeDiretorioCache() {

        Path diretorioCache = diretorioTemp
                .resolve("Opera Software")
                .resolve("Opera GX Stable")
                .resolve("Default")
                .resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        Path arquivo = diretorioCache.resolve("arquivo.dat");

        FileCategory category = fileClassifier.classificar(arquivo);

        assertEquals(FileCategory.CACHE, category);
    }

    @Test
    void naoDeveClassificarCacheDeOutroDiretorioComoCacheDoOpera() {

        Path diretorioCache = diretorioTemp
                .resolve("Opera Software")
                .resolve("Opera GX Stable")
                .resolve("Default")
                .resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        Path arquivo = diretorioTemp
                .resolve("Aplicativos")
                .resolve("Opera GX")
                .resolve("Cache")
                .resolve("arquivo.dat");

        FileCategory category = fileClassifier.classificar(arquivo);

        assertEquals(FileCategory.OTHER, category);
    }

    @Test
    void deveReconhecerDiretorioCacheEmSubpastas() {

        Path diretorioCache = diretorioTemp
                .resolve("Opera Software")
                .resolve("Opera GX Stable")
                .resolve("Default")
                .resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        Path arquivo = diretorioCache
                .resolve("Dados")
                .resolve("arquivo.dat");

        FileCategory category = fileClassifier.classificar(arquivo);

        assertEquals(FileCategory.CACHE, category);
    }

    @Test
    void deveRejeitarCaminhosNull() {

        Path diretorioCache = diretorioTemp.resolve("Cache");

        FileClassifier fileClassifier = new FileClassifier(diretorioCache);

        assertThrows(
                NullPointerException.class,
                () -> fileClassifier.classificar(null)
        );
    }
}
