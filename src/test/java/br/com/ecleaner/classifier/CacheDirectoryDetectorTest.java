
package br.com.ecleaner.classifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * PATH: representa os caminhos utilizados nos cenários de teste.
 * TEMP DIR: fornece um diretório temporário para os testes.
 * DETECTOR: verifica se o arquivo pertence ao diretório de cache.
 * ASSERT TRUE/FALSE: confirma o resultado da classificação.
 * ASSERT THROWS: verifica se a exceção esperada foi lançada.
 */

class CacheDirectoryDetectorTest {

    @TempDir
    Path diretorioTemporario;

    @Test
    void deveReconhecerArquivoDentroDoCache() {

        Path diretorioCache = diretorioTemporario
                .resolve("Opera Software")
                .resolve("Opera GX Stable")
                .resolve("Default")
                .resolve("Cache");

        CacheDirectoryDetector detector =
                new CacheDirectoryDetector(diretorioCache);

        Path arquivo = diretorioCache.resolve("arquivo.dat");

        assertTrue(detector.pertenceADiretorioDeCache(arquivo));
    }

    @Test
    void naoDeveReconhecerArquivoForaDoCache() {

        Path diretorioCache = diretorioTemporario.resolve("Cache");

        CacheDirectoryDetector detector =
                new CacheDirectoryDetector(diretorioCache);

        Path arquivo = diretorioTemporario.resolve("arquivo.dat");

        assertFalse(detector.pertenceADiretorioDeCache(arquivo));
    }

    @Test
    void naoDeveReconhecerDiretorioComNomeSemelhante() {

        Path diretorioCache = diretorioTemporario.resolve("Cache");

        CacheDirectoryDetector detector =
                new CacheDirectoryDetector(diretorioCache);

        Path arquivo = diretorioTemporario
                .resolve("CacheBackup")
                .resolve("arquivo.dat");

        assertFalse(detector.pertenceADiretorioDeCache(arquivo));
    }

    @Test
    void deveLancarExcecaoQuandoCaminhoForNulo() {

        Path diretorioCache = diretorioTemporario.resolve("Cache");

        CacheDirectoryDetector detector =
                new CacheDirectoryDetector(diretorioCache);

        assertThrows(
                NullPointerException.class,
                () -> detector.pertenceADiretorioDeCache(null)
        );
    }
}
