package br.com.alura.leilao.model

import java.io.Serializable
import java.util.*

class Leilao(val descricao: String) : Serializable {
    private val lances: MutableList<Lance> =  ArrayList()

    var maiorLance: Double = Double.NEGATIVE_INFINITY
        private set

    var menorLance: Double = Double.POSITIVE_INFINITY
        private set

    fun oferta(lance: Lance) {
        lances.add(lance)
        if (lance.valor > maiorLance) {
            maiorLance = lance.valor
        }
        if (lance.valor < menorLance) {
            menorLance = lance.valor
        }
    }
}