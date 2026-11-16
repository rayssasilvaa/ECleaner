package br.com.ecleaner;

import br.com.ecleaner.classifier.FileCategory;
import br.com.ecleaner.model.ScanResult;
import br.com.ecleaner.scanner.CleanerScanner;
import br.com.ecleaner.util.FormatarTamanho;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main(String[] args) {

        Path diretorio = Path.of("C:\\ECleaner-Teste");

        CleanerScanner scanner = new CleanerScanner();

        try{
            ScanResult resultado = scanner.analisarDiretorio(diretorio);

            System.out.println("=====ECleaner=====\n");
            System.out.println("Diretorio analisado: " + resultado.getDiretorioAnalisado());

            System.out.println("Quantidade de arquivos: " + resultado.getQntdArquivos());

            System.out.println("Tamanho total: " + FormatarTamanho.formatarDocumento(resultado.getTamanhoTotalBytes()));

        } catch (IOException | IllegalArgumentException e){
            System.out.println("Não foi possivel analisar diretório.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }
}
