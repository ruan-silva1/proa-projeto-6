package org.example

val user = User()

fun main() {
    iniciarMenu()
}

fun iniciarMenu() {
    while (true) {
        println("Escolha uma das opções abaixo:")
        println(
            """1 - Fazer Registros
              |2 - Mostrar Registros
              |3 - Pesquisar Registros
              |4 - Sair
        """.trimMargin()
        )
        val opcao = lerEntradaNumerica()
        when (opcao) {
            1 -> user.fazerRegistro()
            2 -> user.mostrarRegistros()
            3 -> user.pesquisarUser()
            4 -> break
            else -> println("Opção inválida! Por favor, escolha uma opção válida.")
        }
    }
}

fun lerEntradaNumerica(): Int {
    while (true) {
        try {
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida! Por favor, insira um número válido.")
        }
    }
}

class User {
    val nomes = mutableListOf("João Silva", "Maria Oliveira", "Carlos Souza")
    val enderecos = mutableListOf("Rua A, 123", "Av. B, 456", "Rua C, 789")
    val telefones = mutableListOf("(11) 9999-1111", "(22) 8888-2222", "(33) 7777-3333")
    val alturas = mutableListOf(1.75, 1.68, 1.80)
    val salarios = mutableListOf(2500.0, 3200.0, 4000.0)
    val matriculas = mutableListOf("M002", "M001", "M003")

    val mediaAltura: Double
        get() {
            return if (alturas.isNotEmpty()) {
                alturas.sum() / alturas.size
            } else {
                0.0
            }
        }

    fun fazerRegistro() {
        var i = 0
        while (i < 2) {
            println("Digite o nome do usuário:")
            val nome = readln()
            nomes.add(nome)
            println("Digite o número da matrícula:")
            val matricula = readln()
            matriculas.add(matricula)
            println("Digite o salário:")
            val salario = readln().toDouble()
            salarios.add(salario)
            println("Digite o endereço do usuário:")
            val endereco = readln()
            enderecos.add(endereco)
            println("Digite o telefone do usuário:")
            val telefone = readln()
            telefones.add(telefone)
            println("Qual a sua altura?")
            val altura = readln().toDouble()
            alturas.add(altura)
            i++
        }
        println("Média das alturas é ${this.mediaAltura}")
    }

    fun pesquisarUser() {
        var usuarioEncontrado = false
        println("Qual nome ou matrícula do usuário que deseja pesquisar?")
        val search = readln()
        for (i in nomes.indices) {
            if (nomes[i] == search || matriculas[i] == search) {
                usuarioEncontrado = true
                val matriculaUser = matriculas[i]
                val enderecoUser = enderecos[i]
                val telefoneUser = telefones[i]
                val alturaUser = alturas[i]
                val salarioUser = salarios[i]
                println("O usuário ${nomes[i]} mora em $enderecoUser, possui o telefone $telefoneUser, mede $alturaUser e ganha $salarioUser")
            }
        }
        if (!usuarioEncontrado) {
            println("Usuário não encontrado!")
        }
    }

    fun mostrarRegistros() {
        println("Escolha a ordem de registros:")
        println("0 - Ordenar por ordem de entrada")
        println("1 - Ordenar por nome")
        println("2 - Ordenar por matrícula")
        println("3 - Ordenar por maior salário")
        val escolhaRegistro = lerEntradaNumerica()

        // Limpa as listas ordenadas antes de preenchê-las novamente
        val nomesSorted = mutableListOf<String>()
        val enderecosSorted = mutableListOf<String>()
        val telefonesSorted = mutableListOf<String>()
        val alturasSorted = mutableListOf<Double>()
        val salariosSorted = mutableListOf<Double>()
        val matriculasSorted = mutableListOf<String>()

        when (escolhaRegistro) {
            0 -> {
                // Ordem de entrada (não ordena)
                nomesSorted.addAll(nomes)
                enderecosSorted.addAll(enderecos)
                telefonesSorted.addAll(telefones)
                alturasSorted.addAll(alturas)
                salariosSorted.addAll(salarios)
                matriculasSorted.addAll(matriculas)
            }
            1 -> {
                // Ordenar por nome
                val indicesOrdenados = nomes.withIndex().sortedBy { it.value }.map { it.index }
                preencherListasOrdenadas(indicesOrdenados, nomesSorted, enderecosSorted, telefonesSorted, alturasSorted, salariosSorted, matriculasSorted)
            }
            2 -> {
                // Ordenar por matrícula
                val indicesOrdenados = matriculas.withIndex().sortedBy { it.value }.map { it.index }
                preencherListasOrdenadas(indicesOrdenados, nomesSorted, enderecosSorted, telefonesSorted, alturasSorted, salariosSorted, matriculasSorted)
            }
            3 -> {
                // Ordenar por maior salário
                val indicesOrdenados = salarios.withIndex().sortedByDescending { it.value }.map { it.index }
                preencherListasOrdenadas(indicesOrdenados, nomesSorted, enderecosSorted, telefonesSorted, alturasSorted, salariosSorted, matriculasSorted)
            }
            else -> {
                println("Opção inválida! Exibindo registros na ordem de entrada.")
                nomesSorted.addAll(nomes)
                enderecosSorted.addAll(enderecos)
                telefonesSorted.addAll(telefones)
                alturasSorted.addAll(alturas)
                salariosSorted.addAll(salarios)
                matriculasSorted.addAll(matriculas)
            }
        }

        // Exibe os registros
        if (nomesSorted.isEmpty()) {
            println("Nenhum registro encontrado.")
            return
        }

        val colunaNome = 15
        val colunaMatricula = 10
        val colunaTelefone = 15
        val colunaEndereco = 20
        val colunaAltura = 8
        val colunaSalario = 10

        // Cabeçalho
        println(
            "Nome".padEnd(colunaNome) + " | " +
                    "Matrícula".padEnd(colunaMatricula) + " | " +
                    "Telefone".padEnd(colunaTelefone) + " | " +
                    "Endereço".padEnd(colunaEndereco) + " | " +
                    "Altura".padEnd(colunaAltura) + " | " +
                    "Salário".padEnd(colunaSalario)
        )

        // Corpo da tabela
        for (i in nomesSorted.indices) {
            println(
                nomesSorted[i].padEnd(colunaNome) + " | " +
                        matriculasSorted[i].padEnd(colunaMatricula) + " | " +
                        telefonesSorted[i].padEnd(colunaTelefone) + " | " +
                        enderecosSorted[i].padEnd(colunaEndereco) + " | " +
                        alturasSorted[i].toString().padEnd(colunaAltura) + " | " +
                        salariosSorted[i].toString().padEnd(colunaSalario)
            )
        }
    }

    private fun preencherListasOrdenadas(
        indicesOrdenados: List<Int>,
        nomesSorted: MutableList<String>,
        enderecosSorted: MutableList<String>,
        telefonesSorted: MutableList<String>,
        alturasSorted: MutableList<Double>,
        salariosSorted: MutableList<Double>,
        matriculasSorted: MutableList<String>
    ) {
        for (i in indicesOrdenados) {
            nomesSorted.add(nomes[i])
            enderecosSorted.add(enderecos[i])
            telefonesSorted.add(telefones[i])
            alturasSorted.add(alturas[i])
            salariosSorted.add(salarios[i])
            matriculasSorted.add(matriculas[i])
        }
    }
}