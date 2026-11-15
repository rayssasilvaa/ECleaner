package br.com.ecleaner.scanner;

import br.com.ecleaner.model.ScanResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CleanerScannerTest {

    @TempDir
    Path temporyFile; // Diretório temporário criado automaticamente pelo JUnit.

    //conta arquivos em subdiretorios
    @Test
    void contarFilesEmSubdiretorio() throws IOException {

        // Cria o caminho de uma subpasta dentro do diretório temporário.
        Path subdiretorio = temporyFile.resolve("Projetos");

        // Cria a subpasta Projetos.
        Files.createDirectories(subdiretorio);

        // Cria um arquivo de 100 bytes no diretório principal.
        Files.writeString(temporyFile.resolve("arquivo01.txt"), "a".repeat(100));

        // Cria um arquivo de 200 bytes dentro da subpasta.
        Files.writeString(subdiretorio.resolve("arquivo02.txt"), "b".repeat(200));

        // Cria um arquivo de 300 bytes dentro da subpasta.
        Files.writeString(subdiretorio.resolve("arquivo03.txt"), "c".repeat(300));

        // Cria uma instância do scanner.
        CleanerScanner scanner = new CleanerScanner();

        // Analisa o diretório temporário e suas subpastas.
        ScanResult result = scanner.analisarDiretorio(temporyFile);

        // Verifica se o resultado da análise não é nulo.
        assertNotNull(result);

        // Confirma que os três arquivos foram encontrados.
        assertEquals(3, result.getQntdArquivos());

        // Confirma que o tamanho total dos arquivos é 600 bytes.
        assertEquals(600L, result.getTamanhoTotalBytes());
    }

    //verifica se o diretorio esta vazio
    @Test
    void zeroParaDiretorioVazio() throws IOException {

        // Cria uma instância do scanner.
        CleanerScanner scanner = new CleanerScanner();

        // Analisa o diretório temporário.
        ScanResult resultado = scanner.analisarDiretorio(temporyFile);

        // Verifica se o resultado da análise não é nulo.
        assertNotNull(resultado);

        // Confirma que nenhum arquivo foi encontrado.
        assertEquals(0, resultado.getQntdArquivos());

        // Confirma que o tamanho total é zero bytes.
        assertEquals(0L, resultado.getTamanhoTotalBytes());
    }

    //verifica se o scanner rejeita um diretorio inexistente
    @Test
    void rejeitarDiretorioInexistente(){

        //cria um arquivo que nao existe
        Path diretorioInexistente = temporyFile.resolve("file-fantasma");

        //cria uma instancia do scanner
        CleanerScanner scanner = new CleanerScanner();

        //verifica se o scanner lanca uma exception ao receber um caminho invalido.
        assertThrows(
                IllegalArgumentException.class, () -> scanner.analisarDiretorio(diretorioInexistente)
        );
    }

    //verifica se o scanner rejeita um caminho que aponta para um arquivo
    @Test
    void rejeitarCaminhoQueApontaUmArquivo()  throws IOException{

        //cria um arquivo dentro do diretorio temporario
        Path arquivo = Files.createFile(temporyFile.resolve("arquivo.txt"));

        CleanerScanner scanner = new CleanerScanner();

        //veririca se o scanner rejeita o caminho do arquivo
        assertThrows(
                IllegalArgumentException.class, () -> scanner.analisarDiretorio(arquivo)
        );
    }

}