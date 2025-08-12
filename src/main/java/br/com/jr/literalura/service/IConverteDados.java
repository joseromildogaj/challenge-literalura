package br.com.jr.literalura.service;

public interface IConverteDados {

    <T>T obterDados(String json, Class<T> classe);
}
