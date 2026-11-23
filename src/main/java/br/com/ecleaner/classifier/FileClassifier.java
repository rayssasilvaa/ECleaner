
package br.com.ecleaner.classifier;

import java.nio.file.Path;
import java.util.Objects;

public class FileClassifier {

    // Detector responsável por identificar arquivos no cache do Opera GX.
    private final CacheDirectoryDetector cacheDirectoryDetector;

    public FileClassifier() {
        this.cacheDirectoryDetector = new CacheDirectoryDetector();
    }

    public FileClassifier(Path diretorioCacheOpera){
        this.cacheDirectoryDetector = new CacheDirectoryDetector(diretorioCacheOpera);
    }

    // Classifica o arquivo de acordo com as regras definidas.
    public FileCategory classificar(Path arquivo) {

        // Impede que a classificação seja executada com um caminho nulo.
        Objects.requireNonNull(arquivo, "O caminho do arquivo não pode ser null.");

        // Obtém o nome do arquivo sem diferenciar letras maiúsculas e minúsculas.
        String nomeArquivo = arquivo.getFileName()
                .toString()
                .toLowerCase();

        // Identifica arquivos com extensão temporária.
        if (nomeArquivo.endsWith(".tmp")) {
            return FileCategory.TEMPORARY;
        }

        // Verifica se o arquivo pertence ao cache do Opera GX.
        if (cacheDirectoryDetector.pertenceADiretorioDeCache(arquivo)) {
            return FileCategory.CACHE;
        }

        // Classifica como OTHER quando nenhuma regra anterior é atendida.
        return FileCategory.OTHER;
    }
}
