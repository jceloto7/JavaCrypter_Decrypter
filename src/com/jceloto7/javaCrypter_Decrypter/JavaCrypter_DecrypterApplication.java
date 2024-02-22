package com.jceloto7.javaCrypter_Decrypter;

import com.IC2379.Crypter.controller.Crypter;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaCrypter_DecrypterApplication {

    private static final Crypter crypter = new Crypter(); // Instanciando o Crypter uma vez

    public static void main(String[] args) {
        Bootstrap.start();
        System.out.println("""
                Welcome to the crypt/decrypt tool.
                What do you wanna do?
                Please, type '1' to crypt or '2' to decrypt.
                """);



        // Verificar se foram fornecidos argumentos suficientes
        if (args.length < 3) {
            System.out.println("Uso: java FileEncryption [criptografar/descriptografar] [chave] [caminho da pasta]");
            return;
        }

        long startTime = System.currentTimeMillis();
        String operation = args[0];
        String key = args[1];
        String folderPath = args[2];

        // Verificar se a operação é válida
        if (!operation.equals("criptografar") && !operation.equals("descriptografar")) {
            System.out.println("Operação inválida. Use 'criptografar' ou 'descriptografar'.");
            return;
        }

        // Criar pastas de saída
        File encryptedFolder = new File(folderPath + File.separator + "Encrypted");
        encryptedFolder.mkdirs();
        File decryptedFolder = new File(folderPath + File.separator + "Decrypted");
        decryptedFolder.mkdirs();

        // Obter lista de arquivos na pasta
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo encontrado na pasta especificada.");
            return;
        }

        // Criar pool de threads para processamento paralelo
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Executar operação para cada arquivo
        for (File file : files) {
            if (file.isFile()) {
                executor.execute(() -> {
                    try {
                        if (operation.equals("criptografar")) {
                            crypter.cryptFile(key, file.getAbsolutePath(), encryptedFolder.getAbsolutePath() + File.separator + file.getName() + ".crypt");
                        } else {
                            crypter.decryptFile(key, file.getAbsolutePath(), decryptedFolder.getAbsolutePath() + File.separator + file.getName().replaceAll(".crypt", ""));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        // Encerrar pool de threads após todas as operações serem concluídas
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Aguardar até que todas as threads estejam concluídas
        }

        // Imprimir tempo total de execução
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo total de execução: " + (endTime - startTime) + " milissegundos");
    }
}
