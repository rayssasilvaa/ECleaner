package br.com.ecleaner.scanner;

import br.com.ecleaner.model.ScanResult;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CleanerScanner {

    public ScanResult analisarDiretorio(Path diretorio) throws IOException {

        // Verifica se o caminho informado não é null
        if (diretorio == null) {
            throw new IllegalArgumentException(
                    "O diretório não pode ser nulo."
            );
        }

        // Verifica se o caminho informado representa um diretório.
        if (!Files.isDirectory(diretorio)) {
            throw new IllegalArgumentException(
                    "O caminho informado não é um diretório válido."
            );
        }

        // Armazena a quantidade de arquivos encontrados.
        long[] quantidadeArquivos = {0};

        // Armazena o tamanho total dos arquivos em bytes.
        long[] tamanhoTotalBytes = {0};

        // Percorre o diretório informado e suas subpastas.
        Files.walkFileTree(diretorio, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(
                    Path arquivo,
                    BasicFileAttributes atributos
            ) {

                // Verifica se o item encontrado é um arquivo regular.
                if (atributos.isRegularFile()) {

                    // Incrementa a quantidade de arquivos encontrados.
                    quantidadeArquivos[0]++;

                    // Soma o tamanho do arquivo ao total acumulado.
                    tamanhoTotalBytes[0] += atributos.size();
                }

                // Continua a busca pelos próximos arquivos.
                return FileVisitResult.CONTINUE;
            }
        });

        // Retorna um objeto contendo os resultados da análise.
        return new ScanResult(
                diretorio,
                quantidadeArquivos[0],
                tamanhoTotalBytes[0]
        );
    }
}