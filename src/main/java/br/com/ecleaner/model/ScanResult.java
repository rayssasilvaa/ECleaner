package br.com.ecleaner.model;

import java.nio.file.Path;
import java.util.Objects;

public class ScanResult {
    private final Path diretorioAnalisado;
    private final long qntdArquivos;
    private final long tamanhoTotalBytes;

    public ScanResult(Path diretorioAnalisado, long qntdArquivos, long tamanhoTotalBytes){
        Objects.requireNonNull(diretorioAnalisado, "O diretorio não pode ser null");

        if (qntdArquivos < 0 || tamanhoTotalBytes < 0){
            throw new IllegalArgumentException("A quantidade de arquivos e o tamanho não podem ser negativos.");
        }

        this.diretorioAnalisado = diretorioAnalisado;
        this.qntdArquivos = qntdArquivos;
        this.tamanhoTotalBytes = tamanhoTotalBytes;
    }

    public Path getDiretorioAnalisado(){
        return diretorioAnalisado;
    }
    public long getQntdArquivos(){
        return qntdArquivos;
    }
    public long getTamanhoTotalBytes(){
        return tamanhoTotalBytes;
    }

}
