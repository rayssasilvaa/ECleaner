package br.com.ecleaner.util;

import java.util.Locale;

public class FormatarTamanho {
    public static String formatarDocumento(long bytes){
        if (bytes < 0){
            throw new IllegalArgumentException("O tamanho não pode ser negativo");
        }

        double tamanho = bytes;

        String[] unidades = {"B", "KB", "MB", "GB", "TB"};

        int i = 0;

        while (tamanho >= 1024 && i < unidades.length - 1){
            tamanho /= 1024;
            i++;
        }

        return String.format(Locale.forLanguageTag("pt-BR"), "%.2f %s", tamanho, unidades[i]);
    }
}
