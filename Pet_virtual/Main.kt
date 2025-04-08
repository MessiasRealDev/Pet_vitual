import kotlin.concurrent.fixedRateTimer
import petvirtual.Pet


fun main() {
    print("Digite o nome do seu pet: ")
    val nome = readLine() ?: "Pet"
    val pet = Pet(nome)

    println("Bem-vindo ao jogo do Pet Virtual! Cuide bem de $nome! ")

    fixedRateTimer("timer", daemon = true, period = 15000){
        if (pet.vivo) pet.passarTempo()
    }
    var sair = false

    do {
        println("\n🎮 Escolha uma ação:")
        println("1️⃣ Alimentar")
        println("2️⃣ Brincar")
        println("3️⃣ Descansar")
        println("4️⃣ Usar o banheiro")
        println("5️⃣ Tomar banho")
        println("6️⃣ Verificar status")
        println("7️⃣ Sair")
        print("👉 Digite sua escolha: ")

        when (readLine()?.toIntOrNull()) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> {
                print("Por quantas horas o pet deve descansar? ⏳ ")
                val horas = readLine()?.toIntOrNull() ?: 1
                pet.descansar(horas)
            }
            4 -> pet.usarBanheiro()
            5 -> pet.tomarBanho()
            6 -> pet.verificarStatus()
            7 -> {
                println("👋 Obrigado por jogar! Até mais!")
                sair = true
            }
            else -> println("❌ Escolha inválida! Tente novamente.")
        }

    }while (pet.vivo && !sair)
}