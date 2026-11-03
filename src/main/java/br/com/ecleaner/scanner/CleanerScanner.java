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
        if (diretorio == null){
            throw new IllegalArgumentException("O diretorio não pode ser nulo.");
        }

        if (!Files.isDirectory(diretorio)){
            throw new IllegalArgumentException("O caminho informado não é um dirétorio válido.");
        }

        long[] qntdArquivos = {0};
        long[] tamanhoTotalBytes = {0};

        Files.walkFileTree(diretorio, new SimpleFileVisitor<>(){

            @Override
            public FileVisitResult visitFile(Path arquivo, BasicFileAttributes atributos){
              if (atributos.isRegularFile()){
                  qntdArquivos[0]++;
                  tamanhoTotalBytes[0]+= atributos.size();
              }

              return FileVisitResult.CONTINUE;
            }
        });

        return new ScanResult(diretorio, qntdArquivos[0], tamanhoTotalBytes[0]);

    }
}
