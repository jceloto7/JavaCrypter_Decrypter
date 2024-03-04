package com.jceloto7.javaCrypter_Decrypter.service;

import com.IC2379.Crypter.controller.Crypter;
import com.jceloto7.javaCrypter_Decrypter.Bootstrap;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Crypt_DecryptService {
    private static final Crypter crypter = Bootstrap.crypter;
    private static final Semaphore semaphore = new Semaphore(Runtime.getRuntime().availableProcessors());
    public long startTime = System.currentTimeMillis();
    public String[] process = new String[0];
    public String key = process[1];
    public ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void crypt(String key, String inputFile,String outputFile) {
        crypter.cryptFile(key, inputFile, outputFile);
        File encryptedFolder = new File(outputFile + File.separator + "Encrypted");
        encryptedFolder.mkdirs();
        File folder = new File(inputFile);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo encontrado na pasta especificada.");
        }
        for (File file : files) {
            if (file.isFile()) {
                new Thread(()-> {
                    try {
                        semaphore.acquire();
                        crypter.cryptFile(key, file.getAbsolutePath(), encryptedFolder.getAbsolutePath() +
                                File.separator + file.getName() + ".crypt");
                    } catch (Exception ex) {
                        System.out.println("An unexpected error has occured. Please try again ");
                    } finally {
                        semaphore.release();
                    }
                }).start();
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Aguardar até que todas as threads estejam concluídas
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tempo total de execução: " + (endTime - startTime) + " milissegundos");
    }

    public void decrypt(String key, String inputFile,String outputFile){
        crypter.decryptFile(key, inputFile, outputFile);
        File decryptedFolder = new File(inputFile + File.separator + "Decrypted");
        decryptedFolder.mkdirs();
        File folder = new File(inputFile);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo encontrado na pasta especificada.");
        }
        for (File file : files) {
            if (file.isFile()) {
                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        crypter.decryptFile(key, file.getAbsolutePath(), decryptedFolder.getAbsolutePath() +
                                File.separator + file.getName().replaceAll(".crypt", ""));
                    } catch (Exception ex) {
                        System.out.println("An unexpected error has occured. Please try again ");
                    }finally {
                        semaphore.release();
                    }
                }).start();
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Aguardar até que todas as threads estejam concluídas
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tempo total de execução: " + (endTime - startTime) + " milissegundos");

    }
}
