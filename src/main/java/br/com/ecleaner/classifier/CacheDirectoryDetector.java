package br.com.ecleaner.classifier;

import java.nio.file.Path;
import java.util.Objects;

public class CacheDirectoryDetector {
    private final Path diretorioCacheOpera;

    public CacheDirectoryDetector(){

        // Obtém o diretório local de dados do usuário no Windows.
        String localAppData = System.getenv("LOCALAPPDATA");

        if (localAppData == null || localAppData.isBlank()){
            throw new IllegalStateException("Não foi possível localizar o diretório LOCALAPPDATA.");
        }

        // Monta o caminho padrão do cache do Opera GX.
        this.diretorioCacheOpera = Path.of(localAppData)
                .resolve("Opera Software")
                .resolve("Opera GX Stable")
                .resolve("Default")
                .resolve("Cache");

    }

    public CacheDirectoryDetector(Path diretorioCacheOpera) {

        // Impede que o detector seja criado com um caminho nulo.
        this.diretorioCacheOpera = Objects.requireNonNull(
                diretorioCacheOpera,
                "O diretório de cache não pode ser null."
        );
    }

    public boolean pertenceADiretorioDeCache(Path arquivo){
        // Impede que a verificação seja executada com um caminho null.
        Objects.requireNonNull(arquivo, "O caminho não pode ser null");

        //Normaliza os caminhos para facilitar a comparação.
        Path caminhoArquivo = arquivo.toAbsolutePath().normalize();
        Path caminhoCache = diretorioCacheOpera.toAbsolutePath().normalize();

        //Verifica se o arquivo pertence ao diretorio de cache do opera gx
        return caminhoArquivo.startsWith(caminhoCache);

    }
}
