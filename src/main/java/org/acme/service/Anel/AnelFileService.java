package org.acme.service.Anel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.acme.service.File.FileService;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnelFileService implements FileService{
    private final String PATH_USER = System.getProperty("user.home") +
            File.separator + "quarkus" +
            File.separator + "images" +
            File.separator + "usuario" +  File.separator;

    private static final List<String> SUPPORTED_MIME_TYPES =
            Arrays.asList("image/jpeg", "image/jpg", "image/png", "image/gif");

    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10mb

    @Override
    public String salvar(String nomeArquivo, byte[] arquivo) throws IOException {
        verificarTamanhoImagem(arquivo);

        verificarTipoImagem(nomeArquivo);

        // criar diretorio caso nao exista
        Path diretorio = Paths.get(PATH_USER);
        Files.createDirectories(diretorio);

        // criando o nome do arquivo randomico
        String mimeType = Files.probeContentType(Paths.get(nomeArquivo));
        String extensao = mimeType.substring(mimeType.lastIndexOf('/') + 1);
        String novoNomeArquivo = UUID.randomUUID() + "." + extensao;

        // defindo o caminho completo do arquivo
        Path filePath = diretorio.resolve(novoNomeArquivo);

        if (filePath.toFile().exists())
            throw new IOException("Nome de arquivo ja existe. Os alunos vão buscar uma melhor solucao.");

        // salvar arquivo
        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            fos.write(arquivo);
        }

        return filePath.toFile().getName();
    }

    @Override
    public File obter(String nomeArquivo) {
        File file = new File(PATH_USER+nomeArquivo);
        return file;
    }

    private void verificarTamanhoImagem(byte[] arquivo) throws IOException {
        if (arquivo.length > MAX_FILE_SIZE)
            throw new IOException("Arquivo maior que 10mb.");
    }

    private void verificarTipoImagem(String nomeArquivo) throws IOException {
        String mimeType = Files.probeContentType(Paths.get(nomeArquivo));
        if (!SUPPORTED_MIME_TYPES.contains(mimeType))
            throw new IOException("Tipo de imagem não suportada.");

    }

    public void deletar(String nomeImagem) {
        // Obtém o caminho do arquivo da imagem
        String caminhoImagem = "/path/para/imagens/" + nomeImagem;

        // Tenta excluir o arquivo
        File arquivoImagem = new File(caminhoImagem);
        if (!arquivoImagem.delete()) {
            // Lança uma exceção se o arquivo não puder ser excluído
            throw new Error("Não foi possível excluir a imagem");
        }
    }
    
}