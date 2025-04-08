package petvirtual

class Pet(val nome: String) {
    var idade: Int = 0
    var fome: Int = 50
    var felicidade: Int = 50
    var cansaço: Int = 50
    var banheiro: Int = 0
    var sujeira: Int = 0
    var vivo: Boolean = true

    companion object {
        private const val MAX_FOME = 100
        private const val MAX_CANSACO = 100
        private const val MAX_BANHEIRO = 80
        private const val MAX_SUJEIRA = 80
        private const val MIN_FELICIDADE = 0
        private const val IDADE_VITORIA = 50
    }

    fun alimentar() {
        if (!vivo) return

        fome = (fome - 15).coerceAtLeast(0)
        banheiro += 20
        println("\n🍖 $nome foi alimentado!")
        println("Fome: -15 | Banheiro: +20")
        verificarStatus()
    }

    fun brincar() {
        if (!vivo) return

        felicidade += 20
        cansaço += 15
        sujeira += 10
        println("\n⚽ $nome brincou e se divertiu!")
        println("Felicidade: +20 | Cansaço: +15 | Sujeira: +10")
        verificarStatus()
    }

    fun descansar(horas: Int) {
        if (!vivo) return

        val reducaoCansaco = horas * 8
        cansaço = (cansaço - reducaoCansaco).coerceAtLeast(0)
        println("\n😴 $nome descansou por $horas horas")
        println("Cansaço: -${reducaoCansaco}")

        if (horas >= 8) {
            cansaço = 0
            println("💤 $nome está completamente descansado!")
        }

        verificarStatus()
    }

    fun usarBanheiro() {
        if (!vivo) return

        banheiro = 0
        println("\n🚽 $nome usou o banheiro!")
        verificarStatus()
    }

    fun tomarBanho() {
        if (!vivo) return

        sujeira = 0
        println("\n🚿 $nome tomou banho e está limpinho!")
        verificarStatus()
    }

    fun verificarStatus() {
        println("\n📊 Status de $nome:")
        println("🐾 Idade: $idade dias")
        println("🍗 Fome: $fome/100")
        println("😊 Felicidade: $felicidade/100")
        println("😴 Cansaço: $cansaço/100")
        println("🚽 Banheiro: $banheiro/80")
        println("🧼 Sujeira: $sujeira/80")

        // Mensagens de alerta
        if (fome >= 80) println("⚠️ CUIDADO! $nome está com muita fome!")
        if (felicidade <= 20) println("⚠️ CUIDADO! $nome está muito triste!")
        if (banheiro >= 50) println("⚠️ $nome precisa ir ao banheiro!")
        if (sujeira >= 50) println("⚠️ $nome está muito sujo!")
        if (cansaço >= 80) println("⚠️ $nome está exausto!")
    }

    fun passarTempo() {
        if (!vivo) return

        idade++
        fome += 5
        felicidade = (felicidade - 5).coerceAtLeast(0)
        cansaço += 5
        banheiro += 5
        sujeira += 3

        println("\n⏳ Um dia se passou para $nome...")
        println("Fome: +5 | Felicidade: -5 | Cansaço: +5 | Banheiro: +5 | Sujeira: +3")

        verificarCondicoes()
    }

    private fun verificarCondicoes() {
        when {
            fome >= MAX_FOME -> {
                vivo = false
                println("💀 $nome morreu de fome!")
            }
            cansaço >= MAX_CANSACO -> {
                vivo = false
                println("💀 $nome morreu de exaustão!")
            }
            banheiro >= MAX_BANHEIRO -> {
                vivo = false
                println("💀 $nome teve um acidente e não conseguiu sobreviver!")
            }
            sujeira >= MAX_SUJEIRA -> {
                vivo = false
                println("💀 $nome ficou muito sujo e adoeceu gravemente!")
            }
            felicidade <= MIN_FELICIDADE -> {
                vivo = false
                println("💀 $nome ficou tão triste que fugiu!")
            }
            idade >= IDADE_VITORIA -> {
                vivo = false
                println("🎉 PARABÉNS! Você cuidou de $nome até a velhice!")
            }
        }
    }
}