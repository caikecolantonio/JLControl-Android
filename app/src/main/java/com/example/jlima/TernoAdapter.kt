package com.example.jlima

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TernoAdapter (
    val disciplinas: List<ListaTerno>,
    val onClick: (ListaTerno) -> Unit):
    RecyclerView.Adapter<TernoAdapter.TernoViewHolder>() {
    // ViewHolder com os elementos da tela
    class TernoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView
        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_ternos)
        }
    }
    // Quantidade de disciplinas na lista
    override fun getItemCount() = this.disciplinas.size
    // inflar layout do adapter
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): TernoViewHolder {
// infla view no adapter
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_terno, parent, false)
// retornar ViewHolder
        val holder = TernoViewHolder(view)
        return holder
    }


    // bind para atualizar Views com os dados
    override fun onBindViewHolder(holder: TernoViewHolder, position: Int) {
        val context = holder.itemView.context
// recuperar objeto disciplina
        val disciplina = disciplinas[position]
// atualizar dados de disciplina
        holder.cardNome.text = disciplina.nome
        holder.cardProgress.visibility = View.VISIBLE
// download da imagem
        Picasso.with(context).load(disciplina.foto).fit().into(holder.cardImg,

            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }
                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

// adiciona evento de clique
        holder.itemView.setOnClickListener {onClick(disciplina)}
    }
}