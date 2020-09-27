package br.com.alura.leilao.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import br.com.alura.leilao.R
import br.com.alura.leilao.model.Leilao

class LancesLeilaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lances_leilao)
        val dadosRecebidos = intent
        if (dadosRecebidos.hasExtra("leilao")) {
            val leilao = dadosRecebidos.getSerializableExtra("leilao") as Leilao
            val descricao = findViewById<TextView>(R.id.lances_leilao_descricao)
            descricao.text = leilao.descricao
            val maiorLeilao = findViewById<TextView>(R.id.lances_leilao_maior_lance)
            maiorLeilao.text = getString(R.string.valor_lance, leilao.maiorLance)
            val menorLeilao = findViewById<TextView>(R.id.lances_leilao_menor_lance)
            menorLeilao.text = getString(R.string.valor_lance, leilao.menorLance)
        }
    }
}