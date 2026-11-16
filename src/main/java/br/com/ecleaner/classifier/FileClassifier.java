package br.com.ecleaner.classifier;

import java.nio.file.Path;
import java.util.Objects;

public class FileClassifier {

    //metodo que ira classificar arquivos
    public FileCategory classificar(Path arquivo){

        //impede que a classificacao seja executada com um caminho null
        Objects.requireNonNull(arquivo, "O caminho do arquivo não pode ser null");

        //obtem o nome do arquivo sem diferenciar letras maiúsculas e minúsculas
        String nomeArquivo = arquivo
                .getFileName()
                .toString()
                .toLowerCase();


        //verifica se o arquivo é um arquivo temporario
        if (nomeArquivo.endsWith(".tmp")){
            return FileCategory.TEMPORY;
        }

        //faz a verificacao do arquivo em cache
        if (estaEmDiretorioDeCache(arquivo)){
            return FileCategory.CACHE;
        }

        return FileCategory.OTHER;
    }

    //metodo que verifica arquivos em diretorio de cache
    private boolean estaEmDiretorioDeCache(Path arquivo){

        for (Path p : arquivo){
            if (p.toString().equalsIgnoreCase("cache")){
                return true;
            }

        }
        return false;
    }
}
