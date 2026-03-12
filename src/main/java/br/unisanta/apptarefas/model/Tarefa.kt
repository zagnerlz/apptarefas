package br.unisanta.apptarefas.model

data class Tarefa(
    var nome: String,
    var descricao: String,
    var concluida: Boolean = false
)