package br.unisanta.apptarefas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.apptarefas.R
import br.unisanta.apptarefas.adapter.TarefaAdapter
import br.unisanta.apptarefas.model.Tarefa

class MainActivity : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var edtDescricao: EditText
    private lateinit var btnAdicionar: Button
    private lateinit var recyclerView: RecyclerView

    private val listaTarefas = mutableListOf<Tarefa>()
    private lateinit var adapter: TarefaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNome = findViewById(R.id.edtNome)
        edtDescricao = findViewById(R.id.edtDescricao)
        btnAdicionar = findViewById(R.id.btnAdicionar)
        recyclerView = findViewById(R.id.recyclerView)

        adapter = TarefaAdapter(listaTarefas)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAdicionar.setOnClickListener {

            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()

            if (nome.isNotEmpty() && descricao.isNotEmpty()) {

                val tarefa = Tarefa(nome, descricao)

                listaTarefas.add(tarefa)

                adapter.notifyItemInserted(listaTarefas.size - 1)

                edtNome.text.clear()
                edtDescricao.text.clear()
            }
        }
    }
}