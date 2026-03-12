package br.unisanta.apptarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.apptarefas.R
import br.unisanta.apptarefas.model.Tarefa

class TarefaAdapter(private val lista: MutableList<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.txtNome)
        val descricao: TextView = itemView.findViewById(R.id.txtDescricao)
        val status: TextView = itemView.findViewById(R.id.txtStatus)
        val btnConcluir: Button = itemView.findViewById(R.id.btnConcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {

        val tarefa = lista[position]

        holder.nome.text = tarefa.nome
        holder.descricao.text = tarefa.descricao

        if (tarefa.concluida) {
            holder.status.text = "Concluída"
            holder.btnConcluir.isEnabled = false
        } else {
            holder.status.text = "Pendente"
        }

        holder.btnConcluir.setOnClickListener {
            tarefa.concluida = true
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}