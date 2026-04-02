package com.fincatto.documentofiscal.nfse.utils;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfse.NFSeConfig;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * Classe utilitária para realizar requisições HTTP (GET e POST) para serviços de NFSe.
 */
public class NFSeHttpClient implements DFLog {

    public static class NFSeHttpResponse<T> {
        private final int statusCode;
        private final T body;

        public NFSeHttpResponse(final int statusCode, final T body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        public int statusCode() {
            return statusCode;
        }

        public T body() {
            return body;
        }
    }

    private final NFSeConfig config;

    public NFSeHttpClient(final NFSeConfig config) {
        this.config = config;
    }

    /**
     * Método privado que realiza uma requisição GET para a uri especificada.
     * <code>Content-Type application/json; charset=utf-8</code>.
     *
     * @param uri URI para a qual a requisição será feita.
     * @return Objeto contendo status HTTP e corpo da resposta.
     * @throws Exception Se ocorrer um erro durante a requisição.
     */
    public NFSeHttpResponse<String> sendGetRequest(final URI uri) throws Exception {
        final NFSeHttpResponse<byte[]> response = sendGetRequestBytes(uri);
        return new NFSeHttpResponse<String>(response.statusCode(), new String(response.body(), StandardCharsets.UTF_8));
    }

    public NFSeHttpResponse<byte[]> sendGetRequestBytes(final URI uri) throws Exception {
        this.getLogger().debug("Realizando GET em: {}", uri.toString());
        final HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        if (connection instanceof javax.net.ssl.HttpsURLConnection) {
            final javax.net.ssl.HttpsURLConnection httpsConnection = (javax.net.ssl.HttpsURLConnection) connection;
            httpsConnection.setSSLSocketFactory(DFSocketFactory.getDefaultSSLContext(config).getSocketFactory());
        }

        final int statusCode = connection.getResponseCode();
        final byte[] responseBody = readResponseBody(connection, statusCode);
        connection.disconnect();
        return new NFSeHttpResponse<byte[]>(statusCode, responseBody);
    }

    public NFSeHttpResponse<String> sendPostRequest(final URI uri, final String jsonBody) throws Exception {
        this.getLogger().debug("Realizando POST em: {}", uri.toString());
        final HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        if (connection instanceof javax.net.ssl.HttpsURLConnection) {
            final javax.net.ssl.HttpsURLConnection httpsConnection = (javax.net.ssl.HttpsURLConnection) connection;
            httpsConnection.setSSLSocketFactory(DFSocketFactory.getDefaultSSLContext(config).getSocketFactory());
        }

        final byte[] requestBody = jsonBody.getBytes(StandardCharsets.UTF_8);
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(requestBody);
        }

        final int statusCode = connection.getResponseCode();
        final byte[] responseBody = readResponseBody(connection, statusCode);
        connection.disconnect();
        return new NFSeHttpResponse<String>(statusCode, new String(responseBody, StandardCharsets.UTF_8));
    }

    private byte[] readResponseBody(final HttpURLConnection connection, final int statusCode) throws Exception {
        final InputStream inputStream = statusCode >= 400 ? connection.getErrorStream() : connection.getInputStream();
        if (inputStream == null) {
            return new byte[0];
        }
        try (InputStream in = inputStream; ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            final byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }
            return baos.toByteArray();
        }
    }
}
