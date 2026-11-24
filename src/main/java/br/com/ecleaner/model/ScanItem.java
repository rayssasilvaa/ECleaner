package br.com.ecleaner.model;

import br.com.ecleaner.classifier.FileCategory;

import java.nio.file.Path;
import java.util.Objects;

public class ScanItem {
    private final Path caminhoArquivo;
    private final long tamanhoBytes;
    private final FileCategory categoria;

    public ScanItem(Path caminhoArquivo, long tamanhoBytes, FileCategory categoria){

        Objects.requireNonNull(caminhoArquivo, "O caminho não pode ser null.");
        Objects.requireNonNull(categoria, "A categoria não pode ser null");

        if (tamanhoBytes < 0){
            throw new IllegalArgumentException("O tamanho não pode ser negativo.");
        }

        this.caminhoArquivo = caminhoArquivo;
        this.tamanhoBytes = tamanhoBytes;
        this.categoria = categoria;
    }

    public Path getCaminhoArquivo(){
        return caminhoArquivo;
    }
    public long getTamanhoBytes(){
        return tamanhoBytes;
    }
    public FileCategory getCategoria(){
        return categoria;
    }

}
