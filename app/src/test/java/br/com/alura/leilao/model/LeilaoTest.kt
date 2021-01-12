package br.com.alura.leilao.model

import org.junit.Test

import org.junit.Assert.*

class LeilaoTest {

    @Test
    fun dado_leilao_sem_lances_entao_verifica_nome_do_leilao() {
        val leilaoCarroDeLuxo = Leilao("Carro de luxo")
        val descricaoLeilaoCarroDeLuxo = leilaoCarroDeLuxo.descricao
        assertEquals("Carro de luxo", descricaoLeilaoCarroDeLuxo)
    }

    @Test
    fun dado_leilao_com_apenas_um_lance_quando_obter_maior_lance_entao_verifica_unico_lance() {
        val leilaoCarroDeLuxo = Leilao("Carro de luxo")
        leilaoCarroDeLuxo.oferta(Lance(Usuario("JuniorB"), 100_000.0))
        assertEquals(100_000.0, leilaoCarroDeLuxo.maiorLance, 0.0001)
    }

    @Test
    fun dado_leilao_com_mais_de_um_lance_em_ordem_crescente_quando_obter_maior_lance_entao_verifica_o_maior_lance() {
        val leilaoComputadorQuantico = Leilao("Computador Quântico")
        leilaoComputadorQuantico.oferta(Lance(Usuario("Cara misterioso"), 1_000_300.0))
        leilaoComputadorQuantico.oferta(Lance(Usuario("Jujuba"), 1_100_300.0))
        leilaoComputadorQuantico.oferta(Lance(Usuario("Maureen Murphy"), 2_000_000.1))
        assertEquals(2_000_000.1, leilaoComputadorQuantico.maiorLance, 0.0001)
    }

    @Test
    fun dado_leilao_com_mais_de_um_lance_em_ordem_decrescente_quando_obter_maior_lance_entao_verifica_o_maior_lance() {
        val leilaoDeApartamentoDeLuxo = Leilao("Apartamento de Luxo")
        leilaoDeApartamentoDeLuxo.oferta(Lance(Usuario("Bruna"), 3_500_000.0))
        leilaoDeApartamentoDeLuxo.oferta(Lance(Usuario("Amanda"), 2_599_000.0))
        leilaoDeApartamentoDeLuxo.oferta(Lance(Usuario("Jonas"), 1_400_000.0))
        leilaoDeApartamentoDeLuxo.oferta(Lance(Usuario("Popeye"), 1_350_000.0))
        leilaoDeApartamentoDeLuxo.oferta(Lance(Usuario("Luna"), 1_050_000.0))
        assertEquals(3_500_000.0, leilaoDeApartamentoDeLuxo.maiorLance, 0.0001)
    }

    @Test
    fun dado_leilao_com_apenas_um_lance_quando_obter_menor_lance_entao_verifica_unico_lance() {
        val leilaoCarroVoador = Leilao("Carro voador")
        leilaoCarroVoador.oferta(Lance(Usuario("Fred"), 300.0))
        assertEquals(300.0, leilaoCarroVoador.menorLance, 0.0001)
    }

    @Test
    fun dado_leilao_com_mais_de_um_lance_em_ordem_crescente_quando_obter_menor_lance_entao_verifica_o_menor_lance() {
        val leilaoDroneDeGuerra = Leilao("Drone de guerra")
        leilaoDroneDeGuerra.oferta(Lance(Usuario("Sniper"), 89_800.0))
        leilaoDroneDeGuerra.oferta(Lance(Usuario("Soldado de primeira viagem"), 90_000.0))
        leilaoDroneDeGuerra.oferta(Lance(Usuario("ThePunisher"), 100_000.0))
        assertEquals(89_800.0, leilaoDroneDeGuerra.menorLance, 0.0001)
    }

    @Test
    fun dado_leilao_com_mais_de_um_lance_em_ordem_decrescente_quando_obter_menor_lance_entao_verifica_o_menor_lance() {
        val leilaoValorDeFlor = Leilao("Vaso de flor")
        leilaoValorDeFlor.oferta(Lance(Usuario("Raposo"), 150.0))
        leilaoValorDeFlor.oferta(Lance(Usuario("Bob Esponja"), 140.0))
        leilaoValorDeFlor.oferta(Lance(Usuario("Hércules"), 130.0))
        assertEquals(130.0, leilaoValorDeFlor.menorLance, 0.0001)
    }
}