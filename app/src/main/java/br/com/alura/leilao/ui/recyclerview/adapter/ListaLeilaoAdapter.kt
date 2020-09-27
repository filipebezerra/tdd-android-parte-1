package br.com.alura.leilao.ui.recyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.alura.leilao.R
import br.com.alura.leilao.model.Leilao

class ListaLeilaoAdapter(
        private val context: Context,
        private val leiloes: List<Leilao>,
        private val onItemClickListener: ((Leilao) -> Unit)
) : RecyclerView.Adapter<ListaLeilaoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewCriada = LayoutInflater.from(context).inflate(
                R.layout.item_leilao,
                parent,
                false
        )
        return ViewHolder(viewCriada)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val leilao = pegaLeilaoPorPosicao(position)
        holder.vincula(leilao)
    }

    override fun getItemCount(): Int {
        return leiloes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val descricao: TextView = itemView.findViewById(R.id.item_leilao_descricao)
        private val maiorLance: TextView = itemView.findViewById(R.id.item_leilao_maior_lance)
        private lateinit var leilao: Leilao

        fun vincula(leilao: Leilao) {
            this.leilao = leilao
            descricao.text = leilao.descricao
            maiorLance.text = context.getString(R.string.valor_lance, leilao.maiorLance)
        }

        init {
            itemView.setOnClickListener { onItemClickListener.invoke(this.leilao) }
        }
    }

    fun pegaLeilaoPorPosicao(posicao: Int): Leilao {
        return leiloes[posicao]
    }
}