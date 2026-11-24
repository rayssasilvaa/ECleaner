package br.com.ecleaner.model;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;


public class ScanResult {
    private final Path diretorioAnalisado;
    private final long qntdArquivos;
    private final long tamanhoTotalBytes;
    private final List<ScanItem> itensAnalisados;

    public ScanResult(Path diretorioAnalisado, long qntdArquivos, long tamanhoTotalBytes, List<ScanItem> itensAnalisados){
        Objects.requireNonNull(diretorioAnalisado, "O diretorio não pode ser null");

        if (qntdArquivos < 0 || tamanhoTotalBytes < 0){
            throw new IllegalArgumentException("A quantidade de arquivos e o tamanho não podem ser negativos.");
        }

        this.diretorioAnalisado = diretorioAnalisado;
        this.qntdArquivos = qntdArquivos;
        this.tamanhoTotalBytes = tamanhoTotalBytes;
        this.itensAnalisados = List.copyOf(itensAnalisados);
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
    public List<ScanItem> getItensAnalisados(){
        return itensAnalisados;
    }

}
